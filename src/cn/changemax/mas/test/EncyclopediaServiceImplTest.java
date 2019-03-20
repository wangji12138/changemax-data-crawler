package cn.changemax.mas.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.changemax.mas.po.Encyclopedia;
import cn.changemax.mas.po.Qa;
import cn.changemax.mas.service.EncyclopediaService;
import cn.changemax.mas.utils.ListUtils;
import cn.changemax.mas.utils.WordUtils;

/**
 * <p>
 * Title: EncyclopediaServiceImplTest.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月11日
 * @version 1.0
 */
public class EncyclopediaServiceImplTest {
	private EncyclopediaService encyclopediaService;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		encyclopediaService = (EncyclopediaService) ac.getBean("encyclopediaService");
	}

	@Test
	public void test() throws Exception {
		String searchQuestion = "王者荣耀";
		List<Qa> bestEncyclopediaQaList = encyclopediaService.getBestEncyclopediaList("wangjiwangji", "test",
				searchQuestion, WordUtils.getSplitWords(searchQuestion), WordUtils.getKeywordWords(searchQuestion));
		if (ListUtils.isNotEmpty(bestEncyclopediaQaList)) {
			for (Qa qa : bestEncyclopediaQaList) {
				System.out.println(qa.toString());
			}
		}
	}

	@Test
	public void test2() throws Exception {

		String ss = "行尸走肉、\r\n" + "\r\n" + "金蝉脱壳、\r\n" + "\r\n" + "百里挑一、\r\n" + "\r\n" + "金玉满堂、\r\n" + "\r\n"
				+ "背水一战、\r\n" + "\r\n" + "霸王别姬\r\n" + "\r\n";
		ss.replace("\r\n", "");
		String[] sss = ss.split("、");

		StringBuilder sb = new StringBuilder();
		for (String string : sss) {
			Encyclopedia encyclopedia = encyclopediaService.selectIdiomEncyclopedia(string);
			if (encyclopedia != null) {
				String name = encyclopedia.getName().replaceAll("\"", "”");
				String introduction = encyclopedia.getIntroduction().replaceAll("\"", "”");

				sb.append("{\"" + name + "\", \"" + introduction + "\"}, ");

			}
		}
		System.out.println(sb.toString());

	}

	@Test
	public void test3() throws Exception {

		String ss = "行尸走肉、\r\n" + "\r\n" + "金蝉脱壳、\r\n" + "\r\n" + "百里挑一、\r\n" + "\r\n" + "金玉满堂、\r\n" + "\r\n"
				+ "背水一战、\r\n" + "\r\n" + "霸王别姬\r\n" + "\r\n";
		ss.replace("\r\n", "");
		String[] sss = ss.split("、");

		StringBuilder sb = new StringBuilder();
		for (String string : sss) {
			Encyclopedia encyclopedia = encyclopediaService.selectIdiomEncyclopedia(string);
			if (encyclopedia != null) {
				String name = encyclopedia.getName().replaceAll("\"", "”");
				String introduction = encyclopedia.getIntroduction().replaceAll("\"", "”");

				sb.append("{\"" + name + "\", \"" + introduction + "\"}, ");

			}
		}
		System.out.println(sb.toString());

	}

}
