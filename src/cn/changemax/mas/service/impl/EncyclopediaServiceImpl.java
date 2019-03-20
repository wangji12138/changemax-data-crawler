package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.exception.AnalysisException;
import cn.changemax.mas.mapper.EncyclopediaMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.Encyclopedia;
import cn.changemax.mas.po.EncyclopediaExample;
import cn.changemax.mas.po.EncyclopediaKey;
import cn.changemax.mas.service.AnswerService;
import cn.changemax.mas.service.EncyclopediaService;
import cn.changemax.mas.utils.EncyclopediaConstant;
import cn.changemax.mas.utils.ListUtils;
import cn.changemax.mas.utils.MapUtils;
import cn.changemax.mas.utils.SortUtils;
import cn.changemax.mas.utils.StringUtils;
import cn.changemax.mas.utils.TextSimilarityUtils;
import cn.changemax.mas.utils.WordUtils;

/**
 * <p>
 * Title: EncyclopediaServiceImpl.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月10日
 * @version 1.0
 */
public class EncyclopediaServiceImpl implements EncyclopediaService {

	@Autowired
	private EncyclopediaMapper encyclopediaMapper;

	@Autowired
	private AnswerService answerService;

	@Override
	public List<Answer> getBestEncyclopediaList(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception {
		if (StringUtils.isEmpty(questionId) || StringUtils.isEmpty(analysisType) || StringUtils.isEmpty(textContent)
				|| ListUtils.isEmpty(splitWordList) || ListUtils.isEmpty(keywordList)) {
			throw new AnalysisException(EncyclopediaServiceImpl.class + "：参数不正确");
		}
		System.err.println("进入getBestEncyclopediaList");

		List<Answer> bestBaiDuEncyclopediaQaList = getBestDatabaseEncyclopedia(questionId, analysisType, textContent,
				splitWordList, keywordList);
		System.err.println("getBestDatabaseEncyclopedia");

		if (ListUtils.isEmpty(bestBaiDuEncyclopediaQaList)) {
			bestBaiDuEncyclopediaQaList = getBestBaiDuEncyclopedia(questionId, analysisType, textContent, splitWordList,
					keywordList);
			System.err.println("getBestBaiDuEncyclopedia");
		}

		return bestBaiDuEncyclopediaQaList;
	}

	@Override
	public List<Answer> getBestDatabaseEncyclopedia(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception {
		boolean isDatabase = true;

		List<Encyclopedia> encyclopediaList = selectEncyclopediaByLikeName(keywordList);// 搜索百科词条

		return getOptimalEncyclopediaByList(isDatabase, questionId, analysisType, textContent, splitWordList,
				keywordList, encyclopediaList);
	}

	@Override
	public List<Encyclopedia> selectEncyclopediaByLikeName(List<String> keywordList) {
		EncyclopediaExample example = new EncyclopediaExample();
		example.createCriteria();
		for (String keyword : keywordList) {
			example.getOredCriteria().get(0).andNameLike("%" + keyword + "%");
		}
		return encyclopediaMapper.selectByExample(example);
	}

	@Override
	public List<Answer> getBestBaiDuEncyclopedia(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception {
		boolean isDatabase = false;
		// 预处理searchEncyclopediaEntries
		StringBuilder keywordSB = new StringBuilder();
		for (String keyword : keywordList) {
			keywordSB.append(keyword);
		}
		String keywordString = keywordSB.toString();
		List<Encyclopedia> encyclopediaList = searchEncyclopediaEntries(keywordString);// 搜索百科词条

		return getOptimalEncyclopediaByList(isDatabase, questionId, analysisType, textContent, splitWordList,
				keywordList, encyclopediaList);

	}

	private List<Answer> getOptimalEncyclopediaByList(boolean isDatabase, String questionId, String analysisType,
			String textContent, List<String> splitWordList, List<String> keywordList,
			List<Encyclopedia> encyclopediaList) throws Exception {
		List<Answer> bestBaiDuEncyclopediaQaList = null;
		if (ListUtils.isNotEmpty(encyclopediaList)) {
			final double minSimilarity1 = 0.8, minSimilarity2 = 0.8;
			final String sortField = "name";
			final boolean isName = false;

			// 获取相识度集高集
			Map<Encyclopedia, Double> obtainEncyclopediaMap = TextSimilarityUtils.getSimilarityMapByObtainObjectList(
					textContent, splitWordList, keywordList, encyclopediaList, minSimilarity1, minSimilarity2,
					sortField, isName);

			if (MapUtils.isNotEmpty(obtainEncyclopediaMap)) {
				final boolean sortMode = false;
				// 将map集中按相似度值V排序
				List<Map.Entry<Encyclopedia, Double>> qaEntryList = SortUtils.sortMapByDouble(obtainEncyclopediaMap,
						sortMode);

				if (ListUtils.isNotEmpty(qaEntryList)) {
					// 进行简介获取,因数据偏少，不进行线程池
					for (Entry<Encyclopedia, Double> entry : qaEntryList) {
						entry.getKey().setIntroduction(getEncyclopediaInfor(entry.getKey().getUrl()));

						// 存储本地数据库
						if (!isDatabase) {
							insertEncyclopedia(entry.getKey());
						}
					}

					final String toOriginalQuestionField = "name";
					final String toAnswerField = "introduction";
					final String toRelatedUrlField = "url";

					// 将List<Map.Entry<K, Double>>转换为answerList
					bestBaiDuEncyclopediaQaList = answerService.listMapToListAnswer(qaEntryList,
							toOriginalQuestionField, toAnswerField, toRelatedUrlField, analysisType, questionId);

				}
			}
		}

		return bestBaiDuEncyclopediaQaList;
	}

	@Override
	public void insertEncyclopedia(Encyclopedia encyclopedia) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				encyclopediaMapper.insertSelective(encyclopedia);
			}
		}).start();
	}

	@Override
	public String getEncyclopediaIntro(String baiduEncyclopediaUrl) throws Exception {
		Document homeDocument = Jsoup.connect(baiduEncyclopediaUrl).get();

		Document bodyWrapperDocument = Jsoup.parse(homeDocument.getElementsByClass("body-wrapper").toString());
		Document contentWrapperDocument = Jsoup
				.parse(bodyWrapperDocument.getElementsByClass("content-wrapper").toString());
		Document mainContentDocument = Jsoup
				.parse(contentWrapperDocument.getElementsByClass("main-content").toString());
		Document lemmaSummaryDocument = Jsoup.parse(mainContentDocument.getElementsByClass("lemma-summary").toString());

		String baiduEncyclopediaIntro = lemmaSummaryDocument.text();
		if (StringUtils.isNotEmpty(baiduEncyclopediaIntro)) {
			return baiduEncyclopediaIntro;
		}

		return null;
	}

	public String getEncyclopediaInfor(String baiduEncyclopediaUrl) throws Exception {
		Document homeDocument = Jsoup.connect(baiduEncyclopediaUrl).get();

		Document bodyWrapperDocument = Jsoup.parse(homeDocument.getElementsByClass("body-wrapper").toString());
		Document contentWrapperDocument = Jsoup
				.parse(bodyWrapperDocument.getElementsByClass("content-wrapper").toString());

		Document contentDocument = Jsoup.parse(contentWrapperDocument.getElementsByClass("content").toString());
		Document mainContentDocument = Jsoup.parse(contentDocument.getElementsByClass("main-content").toString());

		StringBuilder contentSB = new StringBuilder();

		Elements allDivElements = mainContentDocument.getElementsByTag("div");
		for (Element element : allDivElements) {
			String className = element.className();
			/*
			 * if (className.contains(EncyclopediaConstant.lemmaSummary)) { Element
			 * lemmaSummaryElement =
			 * element.getElementsByClass(EncyclopediaConstant.lemmaSummary).get(0);
			 * Elements allParaElements =
			 * lemmaSummaryElement.getElementsByClass(EncyclopediaConstant.para); for
			 * (Element paraElement : allParaElements) { contentSB.append(paraElement.text()
			 * + "\r\n"); }
			 * 
			 * contentSB.append("\r\n");
			 * 
			 * } else
			 */ if (className.contains(EncyclopediaConstant.paraTitle)) {
				contentSB.append("\r\n");

				Element paraTitleElement = element.getElementsByClass(EncyclopediaConstant.paraTitle).get(0);
				Element titleTextElement = paraTitleElement.getElementsByClass(EncyclopediaConstant.titleText).get(0);

				contentSB.append(titleTextElement.text() + "\r\n");
			} else if (className.contains(EncyclopediaConstant.para)) {
				Elements allParaElements = element.getElementsByClass(EncyclopediaConstant.para);
				for (Element paraElement : allParaElements) {
					contentSB.append(paraElement.text() + "\r\n");
				}

			}
		}
		return contentSB.toString();
	}

	@Override
	public List<Encyclopedia> searchEncyclopediaEntries(String keywordString) throws Exception {
		String baiduEncyclopediaSearchUrl = "https://baike.baidu.com/search/none?word=" + keywordString;

		Document homeDocument = Jsoup.connect(baiduEncyclopediaSearchUrl).get();

		Document bodyWrapperDocument = Jsoup.parse(homeDocument.getElementsByClass("body-wrapper").toString());

		Document searchListDocument = Jsoup.parse(bodyWrapperDocument.getElementsByClass("search-list").toString());

		Elements ddElements = searchListDocument.getElementsByTag("dd");

		List<Encyclopedia> encyclopediaList = new ArrayList<Encyclopedia>();
		for (Element ddelement : ddElements) {
			Element resultTitleDocument = ddelement.getElementsByClass("result-title").get(0);
			String hrefUrl = resultTitleDocument.attr("abs:href");
			String title = resultTitleDocument.text();
			if (StringUtils.isEmpty(hrefUrl)) {
				hrefUrl = "https://baike.baidu.com" + resultTitleDocument.attr("href");
			}
			if (StringUtils.isNotEmpty(hrefUrl) && StringUtils.isNotEmpty(title)) {
				if (title.contains("_")) {
					title = title.substring(0, title.indexOf("_"));
					encyclopediaList.add(new Encyclopedia(title, hrefUrl));
				}
			}

		}
		return encyclopediaList;
	}

	@Override
	public Encyclopedia selectIdiomEncyclopedia(String key, String idiomName) throws Exception {
		if (StringUtils.isEmpty(key) || StringUtils.isEmpty(idiomName)) {
			return null;
		}

		if (!key.equals("wangji")) {
			return null;
		}

		if (idiomName.length() < 2 && idiomName.length() > 12) {
			return null;
		}

		List<String> splitWords = WordUtils.getSplitWords(idiomName);
		List<String> keywordWords = WordUtils.getKeywordWords(idiomName);

		// 预处理searchEncyclopediaEntries
		StringBuilder keywordSB = new StringBuilder();
		for (String keyword : keywordWords) {
			keywordSB.append(keyword);
		}
		String keywordString = keywordSB.toString();
		List<Encyclopedia> encyclopediaList = searchEncyclopediaEntries(keywordString);// 搜索百科词条

		Encyclopedia suspectEncyclopedia = null;

		for (Encyclopedia encyclopedia : encyclopediaList) {
			String name = encyclopedia.getName();

			if (name.contains("成语") || name.contains("词语")/* || name.contains("词汇") */) {
				if (name.contains("汉语成语") || name.contains("汉语词语")/* || name.contains("汉语词汇") */) {
					suspectEncyclopedia = encyclopedia;
					break;
				}
				suspectEncyclopedia = encyclopedia;
				break;
			}
		}

		if (suspectEncyclopedia == null && encyclopediaList != null && encyclopediaList.size() > 0) {
			suspectEncyclopedia = encyclopediaList.get(0);
		}

		if (suspectEncyclopedia != null) {
			String introduction = getEncyclopediaInfor(suspectEncyclopedia.getUrl());
			suspectEncyclopedia.setIntroduction(introduction);
		}

		return suspectEncyclopedia;

	}

	@Override
	public List<Encyclopedia> selectEncyclopediaSearchInfo(Encyclopedia encyclopedia, PageModel pageModel)
			throws Exception {
		/** 当前需要分页的总数据条数  */
		EncyclopediaExample example = new EncyclopediaExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return encyclopediaMapper.selectByExample(example);
		} else {
			return new ArrayList<Encyclopedia>();
		}
	}

	@Override
	public int getCount(EncyclopediaExample example) throws Exception {
		return encyclopediaMapper.countByExample(example);
	}

	@Override
	public Encyclopedia selectEncyclopediaByKey(EncyclopediaKey key) throws Exception {
		return encyclopediaMapper.selectByPrimaryKey(key);
	}

}
