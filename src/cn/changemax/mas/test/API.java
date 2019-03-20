package cn.changemax.mas.test;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.changemax.mas.po.Encyclopedia;
import cn.changemax.mas.utils.StringUtils;

/**
 * <p>
 * Title: API.java
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
public class API {

	public String lemmaWgtLemmaTitle = "lemmaWgt-lemmaTitle";// 词条标题
	public String lemmaSummary = "lemma-summary";// 词条简介

	public static String paraTitle = "para-title";// 成语解释标题
	public static String titleText = "title-text";// 成语解释标题文本

	public static String para = "para";// 成语解释

	public static String getEncyclopediaInfor(String baiduEncyclopediaUrl) throws Exception {
		Document homeDocument = Jsoup.connect(baiduEncyclopediaUrl).get();

		Document bodyWrapperDocument = Jsoup.parse(homeDocument.getElementsByClass("body-wrapper").toString());
		Document contentWrapperDocument = Jsoup
				.parse(bodyWrapperDocument.getElementsByClass("content-wrapper").toString());

		Document contentDocument = Jsoup.parse(contentWrapperDocument.getElementsByClass("content").toString());
		Document mainContentDocument = Jsoup.parse(contentDocument.getElementsByClass("main-content").toString());

		return getSubtagText(mainContentDocument);
	}

	private static String getSubtagText(Document document) {
		StringBuilder contentSB = new StringBuilder();

		Elements allDivElements = document.getElementsByTag("div");
		for (Element element : allDivElements) {
			String className = element.className();

			if (className.contains(paraTitle)) {
				contentSB.append("\r\n");

				Element paraTitleElement = element.getElementsByClass(paraTitle).get(0);
				Element titleTextElement = paraTitleElement.getElementsByClass(titleText).get(0);

				contentSB.append(titleTextElement.text() + "\r\n");
			} else if (className.contains(para)) {
				Elements allParaElements = element.getElementsByClass(para);
				for (Element paraElement : allParaElements) {
					contentSB.append(paraElement.text() + "\r\n");
				}

			}
		}
		return contentSB.toString();

	}

	public static List<Encyclopedia> searchEncyclopediaEntries(String keywordString) throws Exception {
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
			if (!StringUtils.isEmpty(hrefUrl) && !StringUtils.isEmpty(title)) {
				if (title.contains("_")) {
					title = title.substring(0, title.indexOf("_"));
					encyclopediaList.add(new Encyclopedia(title, hrefUrl));
				}
			}

		}
		return encyclopediaList;
	}

	public static Encyclopedia selectIdiomEncyclopedia(String idiomName) throws Exception {
		if (StringUtils.isEmpty(idiomName)) {
			return null;
		}

		List<Encyclopedia> encyclopediaList = searchEncyclopediaEntries(idiomName);// 搜索百科词条

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

	public static void main(String[] args) throws Exception {
		String new_idiom_name = "无法无天";
		Encyclopedia newEncyclopedia = selectIdiomEncyclopedia(new_idiom_name);
		System.out.println(newEncyclopedia.getIntroduction());
	}

}
