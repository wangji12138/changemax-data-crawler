package cn.changemax.mas.service.impl;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.nlp.AipNlp;

import cn.changemax.mas.service.BDAlOpenTechnologyService;

/**
 * Created by WangJi.
 */
public class BDAlOpenTechnologyServiceImpl implements BDAlOpenTechnologyService {

	/**
	 * 短文本相似度
	 *
	 * @param text1
	 * @param text2
	 * @return
	 */
	@Override
	public double shortTextSimilarity(String text1, String text2) {
		BaiDuAlAnalysisAPI alApi = new BaiDuAlAnalysisAPI();
		JSONObject jsonShortText = alApi.shortTextSimilarity(text1, text2);
		String jsonObejctString = jsonShortText.toString();

		if (jsonObejctString.contains(",")) {
			String[] jStrings = jsonObejctString.split(",");

			for (String string : jStrings) {

				if (string.contains("score") && string.contains(":")) {
					String[] sstrings = string.split(":");
					String scoreS = sstrings[1].replace("}", "");
					return Double.parseDouble(scoreS);

				}

			}
		}

		return 0;
	}

	/**
	 * 将JSONObject转换成Javabean
	 *
	 * @param javabean javaBean对象
	 * @param data     JSONObject数据
	 */
	private Object toJavaBean(Object javabean, JSONObject data) {
		Method[] methods = javabean.getClass().getDeclaredMethods();
		for (Method method : methods) {
			try {
				if (method.getName().startsWith("set")) {
					String field = method.getName(); // set()
					field = field.substring(field.indexOf("set") + 3);//
					field = field.toLowerCase().charAt(0) + field.substring(1);//
					method.invoke(javabean, new Object[] { data.get(field) });
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return javabean;
	}

	class BaiDuAlAnalysisAPI {
		// 设置APPID/AK/SK
		private static final String APP_ID = "14620633";
		private static final String API_KEY = "9YGsrL1do8G7vzjHdDn67FXj";
		private static final String SECRET_KEY = "oqQ6o95Ttq6clQz7CCiy1zYDm2h0Ndlx";

		private AipNlp client;

		public BaiDuAlAnalysisAPI() {
			// 初始化一个AipNlp
			client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

			// 可选：设置网络连接参数
			client.setConnectionTimeoutInMillis(2000);
			client.setSocketTimeoutInMillis(60000);

		}

		/**
		 * 词法分析
		 *
		 * @param text
		 * @return
		 */
		public JSONObject lexicalAnalysis(String text) {
			JSONObject jsonObject = client.depParser(text, null);

			return jsonObject;
		}

		/**
		 * 短文本相似度
		 *
		 * @param text1
		 * @param text2
		 * @return
		 */
		public JSONObject shortTextSimilarity(String text1, String text2) {

			// 传入可选参数调用接口
			HashMap<String, Object> options = new HashMap<String, Object>();
			options.put("model", "CNN");

			// 短文本相似度
			JSONObject jsonObject = client.simnet(text1, text2, options);

			return jsonObject;
		}

		/**
		 * 词义相似度
		 *
		 * @param word1
		 * @param word2
		 * @return
		 */
		public JSONObject wordSimilarity(String word1, String word2) {

			// 传入可选参数调用接口
			HashMap<String, Object> options = new HashMap<String, Object>();
			options.put("mode", 0);

			// 词义相似度
			JSONObject jsonObject = client.wordSimEmbedding(word1, word2, options);

			return jsonObject;
		}

	}

}
