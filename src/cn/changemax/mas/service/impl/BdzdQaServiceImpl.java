package cn.changemax.mas.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.exception.AnalysisException;
import cn.changemax.mas.mapper.BdzdQaMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.BdzdQa;
import cn.changemax.mas.po.BdzdQaExample;
import cn.changemax.mas.service.AnswerService;
import cn.changemax.mas.service.BdzdQaService;
import cn.changemax.mas.utils.ListUtils;
import cn.changemax.mas.utils.MapUtils;
import cn.changemax.mas.utils.SimilarityUtil;
import cn.changemax.mas.utils.SortUtils;
import cn.changemax.mas.utils.StringUtils;
import cn.changemax.mas.utils.TextSimilarityUtils;

/**
 * <p>
 * Title: BDZDQaImpl.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月2日
 * @version 1.0
 */
public class BdzdQaServiceImpl implements BdzdQaService {

	@Autowired
	private BdzdQaMapper bdzdQaMapper;

	@Autowired
	private AnswerService answerService;

	@Override
	public List<Answer> getBestInternetAnswerList(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception {
		if (StringUtils.isEmpty(questionId) || StringUtils.isEmpty(analysisType) || StringUtils.isEmpty(textContent)
				|| ListUtils.isEmpty(splitWordList) || ListUtils.isEmpty(keywordList)) {
			throw new AnalysisException(BdzdQaServiceImpl.class + "：参数不正确");
		}
		System.err.println("进入getBestInternetAnswerList");

		List<Answer> answerList = getAnswerByDatabase(questionId, analysisType, textContent, splitWordList,
				keywordList);
		if (ListUtils.isEmpty(answerList)) {
			answerList = getAnswerByInternet(questionId, analysisType, textContent, splitWordList, keywordList);
		}

		return answerList;
	}

	@Override
	public List<Answer> getAnswerByDatabase(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception {
		boolean isDatabase = true;

		List<BdzdQa> bdzdQaList = selectBDZDQaLikeQuestion(keywordList);

		return getOptimalBdzdQaByList(isDatabase, questionId, analysisType, textContent, splitWordList, keywordList,
				bdzdQaList);
	}

	@Override
	public List<Answer> getAnswerByInternet(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception {
		boolean isDatabase = false;
		int pageLast = getInternetBDZDAnswerLastPageByKeyword(textContent);
		List<BdzdQa> bdzdQaList = getBDZDQaList(pageLast, textContent);

		return getOptimalBdzdQaByList(isDatabase, questionId, analysisType, textContent, splitWordList, keywordList,
				bdzdQaList);
	}

	@Override
	public List<Answer> getOptimalBdzdQaByList(boolean isDatabase, String questionId, String analysisType,
			String textContent, List<String> splitWordList, List<String> keywordList, List<BdzdQa> bdzdQaList)
			throws Exception {
		final double minSimilarity1 = 0.7, minSimilarity2 = 0.9;
		final String sortField = "question";
		final boolean isName = false;
		Map<BdzdQa, Double> bdzdQaMap = TextSimilarityUtils.getSimilarityMapByObtainObjectList(textContent,
				splitWordList, keywordList, bdzdQaList, minSimilarity1, minSimilarity2, sortField, isName);

		List<Answer> answerList = null;
		if (MapUtils.isNotEmpty(bdzdQaMap)) {
			final String targetKField = "clickHeat";
			final boolean sortMode = false;
			// 进行热度排序
			List<Map.Entry<BdzdQa, Double>> sortBdzdQaList = SortUtils.sortMapByKField(bdzdQaMap, targetKField,
					sortMode);
			if (ListUtils.isNotEmpty(sortBdzdQaList)) {
				// 进行answer赋值
				// 开启线程池
				// 根据map1的大小来确定核心线程池的大小
				// 设置核心池大小
				ExecutorService getContentAndTimeExecutorService = Executors.newFixedThreadPool(sortBdzdQaList.size());

				// 存储每个线程的任务
				Map<Integer, Future<BdzdQa>> threadTaskMap = new HashMap<Integer, Future<BdzdQa>>(
						sortBdzdQaList.size());

				// 给每个线程分配任务
				for (int i = 0; i < sortBdzdQaList.size(); i++) {
					BdzdQa bdzdQa = sortBdzdQaList.get(i).getKey();

					String question = bdzdQa.getQuestion();
					String clickHeat = bdzdQa.getClickHeat();
					String url = bdzdQa.getUrl();

					Future<BdzdQa> booleanFuture = getContentAndTimeExecutorService
							.submit(new ContentAndTimeCallable(question, clickHeat, url));
					threadTaskMap.put(i, booleanFuture);

				}
				// 3、结束线程池
				getContentAndTimeExecutorService.shutdown();// 不允许再想线程池中增加线程

				// 初始化bdzdQaList2
				Map<BdzdQa, Double> sortBdzdQaMap2 = new HashMap<BdzdQa, Double>(sortBdzdQaList.size());
				while (true) {
					if (getContentAndTimeExecutorService.isTerminated()) {
						// 拼接线程的返回值
						for (int i = 0; i < sortBdzdQaList.size(); i++) {
							BdzdQa bdzdQa = threadTaskMap.get(i).get();
							if (bdzdQa != null) {
								sortBdzdQaMap2.put(bdzdQa, sortBdzdQaList.get(i).getValue());
							}
						}
						break;
					}
				}

				if (!isDatabase) {
					// 保存合法互联网qa数据
					insertBdzdQaMap(sortBdzdQaMap2);
				}

				final String toOriginalQuestionField = "question";
				final String toAnswerField = "answer";
				final String toRelatedUrlField = "url";
				// 进行QaList转换
				answerList = answerService.listMapToListAnswer(
						new ArrayList<Map.Entry<BdzdQa, Double>>(
								(Collection<? extends Entry<BdzdQa, Double>>) sortBdzdQaMap2.entrySet()),
						toOriginalQuestionField, toAnswerField, toRelatedUrlField, analysisType, questionId);
			}
		}

		return answerList;

	}

	@Override
	public int getInternetBDZDAnswerLastPageByKeyword(String textContent) throws Exception {

		int pageLast = 0;

		String homeUrl = "https://zhidao.baidu.com/search?lm=0&rn=10&pn=0&fr=search&ie=utf-8&word=" + textContent;

		Document homeDocument = Jsoup.connect(homeUrl).get();

		Document lineDocument = Jsoup.parse(homeDocument.getElementsByClass("line").toString());

		Document listInnerDocument = Jsoup.parse(lineDocument.getElementsByClass("list-inner").toString());

		Document widgetPagerDocument = Jsoup.parse(listInnerDocument.getElementsByClass("widget-pager").toString());

		Document pagerElementDocument = Jsoup.parse(widgetPagerDocument.getElementsByClass("pager").toString());

		Element pageLstElement = pagerElementDocument.getElementsByClass("pager-last").get(0);
		String hrefUrl = pageLstElement.attr("href");

		String[] hrefUrls = hrefUrl.split("&");
		for (String string : hrefUrls) {
			if (string.contains("pn")) {
				pageLast = Integer.parseInt(string.split("=")[1]);
			}
		}
		return pageLast;

	}

	/**
	 * 
	 * <p>
	 * Title: getBDZDQa
	 * </p>
	 * <p>
	 * Description: 对获取共有多少页之后再进行分析
	 * </p>
	 * 
	 * @param pageLast
	 * @param textContent
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BdzdQa> getBDZDQaList(int pageLast, String textContent) throws Exception {

		List<BdzdQa> bdzdQaList = new ArrayList<BdzdQa>();

		ExecutorService executorService = Executors.newFixedThreadPool(50);

		int maxPage = pageLast >= 30 ? 30 : pageLast;
		for (int page = 0; page <= maxPage; page += 10) {
			String searchUrl = "https://zhidao.baidu.com/search?word=" + textContent
					+ "&ie=utf-8&site=-1&sites=0&date=0&pn=" + page;

			Document homeDocument2 = Jsoup.connect(searchUrl).get();

			Document lineDocument2 = Jsoup.parse(homeDocument2.getElementsByClass("line").toString());

			Document listInnerDocument2 = Jsoup.parse(lineDocument2.getElementsByClass("list-inner").toString());

			Document listDoucment2 = Jsoup.parse(listInnerDocument2.getElementsByClass("list").toString());

			Elements dlElements = listDoucment2.getElementsByTag("dl");

			for (Element dlElement : dlElements) {
				executorService.execute(new Thread(new Runnable() {

					@Override
					public void run() {
						BdzdQa newBdzdQa = new BdzdQa();

						Element dtElement = Jsoup.parse(dlElement.getElementsByClass("dt").toString());

						Element aElement = dtElement.select("a").get(0);
						String url = aElement.attr("abs:href");

						newBdzdQa.setUrl(url);

						Element explainElement = Jsoup.parse(dlElement.getElementsByClass("explain").toString());
						String clickHeat = "";
						if (explainElement.toString().contains("ml-10")) {
							Element ml10Element = Jsoup.parse(explainElement.getElementsByClass("ml-10").toString());
							clickHeat = ml10Element.text();
						}
						newBdzdQa.setClickHeat(clickHeat);

						String question = aElement.text();
						newBdzdQa.setQuestion(question);

						bdzdQaList.add(newBdzdQa);

					}
				}));

			} // end for (Element dlElement : dlElements)
		} // end for (int page = 0; page <= maxPage; page += 10)

		executorService.shutdown();
		while (true) {

			/*
			 * 因为在上面代码块是通过线程池添加生成bdzdQa，所以只有在线程池结束之后进行遍历去重
			 */
			if (executorService.isTerminated()) {
				for (int i = 0; i < bdzdQaList.size(); i++) {
					for (int j = i + 1; j < bdzdQaList.size(); j++) {
						if (bdzdQaList.get(i).getUrl().equals(bdzdQaList.get(j).getUrl())) {
							bdzdQaList.remove(j);
							j--;
						}
					}
				}

				return bdzdQaList;
			}
		}
	}// end List<BdzdQa> getBDZDQaList(int pageLast, String
		// textContent) throws Exception

	public class ContentAndTimeCallable implements Callable<BdzdQa> {
		private String question;
		private String clickHeat;
		private String url;

		public ContentAndTimeCallable(String question, String clickHeat, String url) {
			this.question = question;
			this.clickHeat = clickHeat;
			this.url = url;
		}

		@Override
		public BdzdQa call() throws Exception {
			if (StringUtils.isEmpty(question) || StringUtils.isEmpty(url)) {
				throw new RuntimeException("网站网址为空！");
			}

			String answer = "";
			String answerTime = "";

			Document homeDocument = Jsoup.connect(url).get();
			String title = homeDocument.title();
			if (title.contains("百度宝宝知道")) {
				Document mybabyWrapDocument = Jsoup.parse(homeDocument.getElementsByClass("mybaby-wrap").toString());
				Document gridDocument = Jsoup.parse(mybabyWrapDocument.getElementsByClass("grid").toString());
				Document answerBoxDocument = Jsoup.parse(gridDocument.getElementsByClass("answer-box").toString());
				Document answerDetailContentDocument = Jsoup
						.parse(answerBoxDocument.getElementsByClass("answer-detail-content").toString());
				answer = answerDetailContentDocument.text();

			} else if (title.contains("百度知道")) {
				Document containerDocument = Jsoup.parse(homeDocument.getElementsByClass("container").toString());
				Document lineDocument = Jsoup.parse(containerDocument.getElementsByClass("line").toString());
				Document gridDocument = Jsoup.parse(lineDocument.getElementsByClass("grid").toString());
				if (gridDocument.toString().contains("wgt-best")) {// 如果包含最佳回答
					Document wgtBestDocument = Jsoup.parse(gridDocument.getElementsByClass("wgt-best").toString());
					Document wgtReplyerAllDocument = Jsoup
							.parse(wgtBestDocument.getElementsByClass("wgt-replyer-all").toString());
					Document wgtReplyerAllBoxDocument = Jsoup
							.parse(wgtReplyerAllDocument.getElementsByClass("wgt-replyer-all-box").toString());
					answerTime = wgtReplyerAllBoxDocument.text();
					Element bestTextDocument = Jsoup.parse(wgtBestDocument.getElementsByClass("best-text").toString());

					answer = bestTextDocument.text();
					if (StringUtils.isEmpty(answer)) {
						if (bestTextDocument.toString().contains("p")) {
							Elements pElements = bestTextDocument.getElementsByTag("p");
							StringBuilder answerSb = new StringBuilder();
							for (Element pElement : pElements) {
								answerSb.append(pElement.text() + "\r\n");
							}
							answer = answerSb.toString();
						}
					}
					answer = answer.replaceAll("展开全部", "");
				}
			} else {
				System.err.println("未知网站网址");
			}

			BdzdQa newBdzdQa = null;
			if (StringUtils.isNotEmpty(answer)) {
				newBdzdQa = new BdzdQa(question, answer, answerTime, clickHeat, url);
			}
			return newBdzdQa;
		}

	}

	@Override
	public List<BdzdQa> selectBDZDQaLikeQuestion(List<String> keywordList) throws Exception {
		BdzdQaExample example = new BdzdQaExample();
		example.createCriteria();
		for (String keyword : keywordList) {
			example.getOredCriteria().get(0).andQuestionLike("%" + keyword + "%");
		}
		return bdzdQaMapper.selectByExample(example);
	}

	@Override
	public void insertBDZDQa(BdzdQa bdzdQa) throws Exception {
		new Thread(new Runnable() {
			@Override
			public void run() {
				bdzdQaMapper.insertSelective(bdzdQa);
			}
		}).start();

	}

	@Override
	public void insertBdzdQaList(List<BdzdQa> bdzdQaList) throws Exception {
		for (BdzdQa bdzdQa : bdzdQaList) {
			insertBDZDQa(bdzdQa);
		}
	}

	@Override
	public void insertBdzdQaMap(Map<BdzdQa, Double> bdzdQaMap) throws Exception {
		for (BdzdQa bdzdQa : bdzdQaMap.keySet()) {
			insertBDZDQa(bdzdQa);
		}
	}

	public static void main(String[] args) throws IOException {
		BdzdQa bdzdQa = new BdzdQa();
		String url = "http://zhidao.baidu.com/question/2015582618466664148.html?fr=iks&word=%B8%D0%C3%B0%B7%A2%C9%D5%C1%CB%D4%F5%C3%B4%B0%EC%3F&ie=gbk";

		bdzdQa.setUrl(url);
		if (StringUtils.isEmpty(url)) {
			throw new RuntimeException("网站网址为空！");
		}
		Document homeDocument = Jsoup.connect(url).get();
		String title = homeDocument.title();
		boolean isAnswerNotNull = false;
		if (title.contains("百度宝宝知道")) {
			Document mybabyWrapDocument = Jsoup.parse(homeDocument.getElementsByClass("mybaby-wrap").toString());
			Document gridDocument = Jsoup.parse(mybabyWrapDocument.getElementsByClass("grid").toString());
			Document answerBoxDocument = Jsoup.parse(gridDocument.getElementsByClass("answer-box").toString());
			Document answerDetailContentDocument = Jsoup
					.parse(answerBoxDocument.getElementsByClass("answer-detail-content").toString());
			String answer = answerDetailContentDocument.text();
			if (StringUtils.isNotEmpty(answer)) {
				isAnswerNotNull = true;
			}
			bdzdQa.setAnswer(answer);
		} else if (title.contains("百度知道")) {
			Document containerDocument = Jsoup.parse(homeDocument.getElementsByClass("container").toString());
			Document lineDocument = Jsoup.parse(containerDocument.getElementsByClass("line").toString());
			Document gridDocument = Jsoup.parse(lineDocument.getElementsByClass("grid").toString());
			if (gridDocument.toString().contains("wgt-best")) {// 如果包含最佳回答
				Document wgtBestDocument = Jsoup.parse(gridDocument.getElementsByClass("wgt-best").toString());
				Document wgtReplyerAllDocument = Jsoup
						.parse(wgtBestDocument.getElementsByClass("wgt-replyer-all").toString());
				Document wgtReplyerAllBoxDocument = Jsoup
						.parse(wgtReplyerAllDocument.getElementsByClass("wgt-replyer-all-box").toString());
				String answerTime = wgtReplyerAllBoxDocument.text();
				bdzdQa.setAnswerTime(answerTime);
				Element bestTextDocument = Jsoup.parse(wgtBestDocument.getElementsByClass("best-text").toString());

				String answer = "";
				answer = bestTextDocument.text();
				if (StringUtils.isEmpty(answer)) {
					if (bestTextDocument.toString().contains("p")) {
						Elements pElements = bestTextDocument.getElementsByTag("p");
						StringBuilder answerSb = new StringBuilder();
						for (Element pElement : pElements) {
							answerSb.append(pElement.text() + "\r\n");
						}
						answer = answerSb.toString();
					}
				}
				answer = answer.replaceAll("展开全部", "");
				if (StringUtils.isNotEmpty(answer)) {
					isAnswerNotNull = true;
				}
				bdzdQa.setAnswer(answer);
			}
		} else {
			System.out.println("未知网站");
		}
	}

	@Override
	public List<BdzdQa> selectBdzdQaSearchInfo(BdzdQa bdzdQa, PageModel pageModel) throws Exception {
		/** 当前需要分页的总数据条数  */
		BdzdQaExample example = new BdzdQaExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return bdzdQaMapper.selectByExample(example);
		} else {
			return new ArrayList<BdzdQa>();
		}
	}

	@Override
	public int getCount(BdzdQaExample example) throws Exception {
		return bdzdQaMapper.countByExample(example);
	}

	@Override
	public BdzdQa selectBdzdQaByKey(String url) throws Exception {
		return bdzdQaMapper.selectByPrimaryKey(url);
	}

}
