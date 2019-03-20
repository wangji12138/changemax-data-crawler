package cn.changemax.mas.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import cn.changemax.mas.exception.AnalysisException;
import cn.changemax.mas.mapper.QaAiMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.QaAi;
import cn.changemax.mas.po.QaAiExample;
import cn.changemax.mas.po.QaAiKey;
import cn.changemax.mas.service.QaAiService;
import cn.changemax.mas.utils.StringUtils;
import cn.changemax.mas.utils.TuLingHttpUtils;

/**
 * <p>
 * Title: QaAiServiceImpl.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月15日
 * @version 1.0
 */
public class QaAiServiceImpl implements QaAiService {

	@Autowired
	private QaAiMapper qaAiMapper;

	/**
	 * 发送一个消息，并得到返回的消息
	 *
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	@Override
	public Answer sendMsg(final String questionId, final String analysisType, final String textContent)
			throws Exception {
		if (StringUtils.isEmpty(questionId) || StringUtils.isEmpty(analysisType) || StringUtils.isEmpty(textContent)) {
			throw new AnalysisException(BdzdQaServiceImpl.class + "：参数不正确");
		}
		System.err.println("进入sendMsg");

		String url = setParams(textContent);
		String res = doGet(url);
		Gson gson = new Gson();
		QaAi qaAi = gson.fromJson(res, QaAi.class);

		String answerMessage = "";
		if (qaAi.getCode() > 400000 || StringUtils.isEmpty(qaAi.getText())) {
			// 该功能等待开发...
			answerMessage = ("");
		} else {
			answerMessage = qaAi.getText();

			qaAi.setUserText(textContent);
			qaAi.setQaId(questionId);

			// insertQaAi(qaAi);
		}

		if (StringUtils.isNotEmpty(answerMessage)) {
			Answer answer = new Answer();
			answer.setQuestionId(questionId);
			answer.setOriginalQuestion(textContent);
			answer.setAnswerDetail(answerMessage);
			answer.setQuestionSimilarity(0.0);
			answer.setAnswerType(analysisType);
			String relatedUrl = null;
			try {
				relatedUrl = new String("http://www.tuling123.com/".getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			answer.setRelatedUrl(relatedUrl != null ? relatedUrl.toString() : "");

			return answer;
		} else {
			return null;
		}

	}

	/**
	 * 拼接Url
	 *
	 * @param msg
	 * @return
	 */
	private String setParams(String msg) {
		/** 利用Java中URLEncoder对其进行编码，如果不能实现，抛出异常 */
		try {
			msg = URLEncoder.encode(msg, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return TuLingHttpUtils.URL + "?key=" + TuLingHttpUtils.API_KEY + "&info=" + msg;
	}

	/**
	 * Get请求，获得返回数据
	 *
	 * @param urlStr
	 * @return
	 */
	private String doGet(String urlStr) {
		java.net.URL url = null;
		HttpURLConnection conn = null;
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(5 * 1000);
			conn.setConnectTimeout(5 * 1000);
			conn.setRequestMethod("GET");
			conn.connect();
			if (conn.getResponseCode() == 200) { // 判断服务器是否成功处理了请求
				is = conn.getInputStream();
				baos = new ByteArrayOutputStream();
				int len = -1;
				byte[] buf = new byte[128];

				while ((len = is.read(buf)) != -1) { // 从输入流中读取一定数量的字节，如果流位于文件末尾而没有可用的字节将会返回-1；
					baos.write(buf, 0, len);
				}
				baos.flush(); // 刷新，将缓冲区内容全部输出
				return baos.toString();
			} else {
				throw new RuntimeException("服务器连接错误！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("服务器连接错误！");
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (baos != null)
					baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			conn.disconnect();
		}

	}

	@Override
	public void insertQaAi(QaAi qaAi) throws Exception {
		new Thread(new Runnable() {

			@Override
			public void run() {
				qaAiMapper.insertSelective(qaAi);
			}
		}).start();
	}

	class DepParser {
		private Long log_id;
		private String text;

		private JSONArray items;

		public Long getLog_id() {
			return log_id;
		}

		public void setLog_id(Long log_id) {
			this.log_id = log_id;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public JSONArray getItems() {
			return items;
		}

		public void setItems(JSONArray items) {
			this.items = items;
		}

		@Override
		public String toString() {
			return "DepParser [log_id=" + log_id + ", text=" + text + ", items=" + items + "]";
		}

	}

	class MyItem {

		private Integer head;
		private String deprel;
		private String postag;
		private Integer id;
		private String word;

		public Integer getHead() {
			return head;
		}

		public void setHead(Integer head) {
			this.head = head;
		}

		public String getDeprel() {
			return deprel;
		}

		public void setDeprel(String deprel) {
			this.deprel = deprel;
		}

		public String getPostag() {
			return postag;
		}

		public void setPostag(String postag) {
			this.postag = postag;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getWord() {
			return word;
		}

		public void setWord(String word) {
			this.word = word;
		}

		@Override
		public String toString() {
			return "MyItem [head=" + head + ", deprel=" + deprel + ", postag=" + postag + ", id=" + id + ", word="
					+ word + "]";
		}

	}

	class ShortText {
		private long log_id;
		private double score = 0.0;
		private JSONArray texts;

		public long getLog_id() {
			return log_id;
		}

		public void setLog_id(long log_id) {
			this.log_id = log_id;
		}

		public double getScore() {
			return score;
		}

		public void setScore(double score) {
			this.score = score;
		}

		public JSONArray getTexts() {
			return texts;
		}

		public void setTexts(JSONArray texts) {
			this.texts = texts;
		}
	}

	@Override
	public List<QaAi> selectQaAiSearchInfo(QaAi qaAi, PageModel pageModel) throws Exception {
		/** 当前需要分页的总数据条数  */
		QaAiExample example = new QaAiExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return qaAiMapper.selectByExample(example);
		} else {
			return new ArrayList<QaAi>();
		}
	}

	@Override
	public int getCount(QaAiExample example) throws Exception {
		return qaAiMapper.countByExample(example);
	}

	@Override
	public QaAi selectByPrimaryKey(QaAiKey key) throws Exception {
		return qaAiMapper.selectByPrimaryKey(key);
	}

}