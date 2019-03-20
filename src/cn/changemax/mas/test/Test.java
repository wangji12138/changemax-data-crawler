package cn.changemax.mas.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * <p>
 * Title: Test.java
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
public class Test {
	public static String httpRequestUtils(String url, String params) {
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();
		try {
			URL reqUrl = new URL(url);
			// 建立连接
			URLConnection conn = reqUrl.openConnection();

			// 设置请求头
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
//          conn.setRequestProperty("Connection", "Keep-Alive");//保持长连接
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
		} finally {// 使用finally块来关闭输出流、输入流
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result.toString();
	}

	// 测试是否有效
	public static void main(String[] args) {
		String url = "http://api.avatardata.cn/ChengYu/Search?key=90e5fc88a32f4e68ae88f56e8e4694dc&keyWord=龙马精神";
		String params = "";

		System.out.println(httpRequestUtils(url, params));
	}

}
