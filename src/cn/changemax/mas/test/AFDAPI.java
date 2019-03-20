package cn.changemax.mas.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

/**
 * <p>
 * Title: AFDAPI.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月21日
 * @version 1.0
 */
public class AFDAPI {
	public static String AFDIDURL = "http://api.avatardata.cn/ChengYu/Search";
	public static String AFDSEARCHURL = "http://api.avatardata.cn/ChengYu/LookUp?key=90e5fc88a32f4e68ae88f56e8e4694dc&id=";// 026a379d-6827-432a-9caa-0f875a9fffd9

	public static String search(String name) {
		String jsonResult = getServiceInfo(AFDIDURL + name);

		JSONObject jsonObjectResult = new JSONObject(jsonResult);// 得到 {"1":"颜色","2":"尺码"}对象
		Object result = jsonObjectResult.get("result");
		JSONObject jsonObjectId = new JSONObject(result.toString());// 得到 {"1":"颜色","2":"尺码"}对象

		Object id = jsonObjectId.get("id");

		String jsonResult2 = getServiceInfo(AFDSEARCHURL + id.toString());

		JSONObject jsonObjectResult2 = new JSONObject(jsonResult2);// 得到 {"1":"颜色","2":"尺码"}对象
		Object result2 = jsonObjectResult2.get("result");
		JSONObject jsonObject2 = new JSONObject(result2.toString());// 得到 {"1":"颜色","2":"尺码"}对象
		Object content = jsonObject2.get("content");
		Object derivation = jsonObject2.get("derivation");

		return content.toString() + "\r\n" + derivation.toString();
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("idiomName", "目中无人");

		String url = "http://106.13.38.154:8080/MedicalAnalysisSystem/encyclopedia/idiomSearch?idiomName=目中无人";

		System.out.println(GetPostUrl(url, params));
	}

	public static String GetPostUrl(String sendUrl, Map<String, String> params) {
		HttpURLConnection httpurlconnection = null;
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();

		try {
			// 构建请求参数
			StringBuffer paramSb = new StringBuffer();
			if (params != null) {
				int i = 0;
				for (java.util.Map.Entry<String, String> e : params.entrySet()) {
					paramSb.append(e.getKey());
					paramSb.append("=");
					// 将参数值urlEncode编码,防止传递中乱码
					paramSb.append(URLEncoder.encode(e.getValue(), "UTF-8"));
					if (i != params.size() - 1) {
						i++;
						paramSb.append("&");
					}
				}
				paramSb.substring(0, paramSb.length() - 1);
			}
			String urlString = sendUrl + "?" + paramSb.toString();
			System.out.println(urlString);

			URL reqUrl = new URL(urlString);
			// 建立连接
			URLConnection conn = reqUrl.openConnection();

			// 设置请求头

			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			// conn.setRequestProperty("Connection", "Keep-Alive");//保持长连接
			conn.setDoOutput(true); // 设置为true才可以使用conn.getOutputStream().write()
			conn.setDoInput(true); // 才可以使用conn.getInputStream().read();

			// 写入参数
			out = new PrintWriter(conn.getOutputStream());
			// 设置参数，可以直接写&参数，也可以直接传入拼接好的
			out.print(params);
			// flush输出流的缓冲
			out.flush();

			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (httpurlconnection != null) {
				httpurlconnection.disconnect();
			}
		}
		return result.toString();
	}

	/**
	 * 发送Get请求到服务器
	 *
	 * @param strUrlPath:接口地址（带参数）
	 * @return
	 */
	public static String getServiceInfo(String strUrlPath) {
		String strResult = "";
		try {
			URL url = new URL(strUrlPath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setUseCaches(false);
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
			strResult = buffer.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strResult;
	}
}
