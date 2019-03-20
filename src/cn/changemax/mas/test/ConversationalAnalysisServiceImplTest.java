package cn.changemax.mas.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.changemax.mas.po.Qa;
import cn.changemax.mas.po.QaSearch;
import cn.changemax.mas.service.ConversationalAnalysisService;
import cn.changemax.mas.service.QaSearchService;

/**
 * <p>
 * Title: ConversationalAnalysisServiceImplTest.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月12日
 * @version 1.0
 */
public class ConversationalAnalysisServiceImplTest {

	private ConversationalAnalysisService conversationalAnalysisService;
	private QaSearchService qaSearchService;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		conversationalAnalysisService = (ConversationalAnalysisService) ac.getBean("conversationalAnalysisService");
		qaSearchService = (QaSearchService) ac.getBean("qaSearchService");

	}

	@Test
	public void testAnalysisQaByQaSearch() throws Exception {
		String searchQuestion = "王者荣耀新手兰陵王怎么玩？";
		QaSearch qaSearch = qaSearchService.pretreatmentQaSearch(searchQuestion);

		System.out.println(qaSearch.toString());

		conversationalAnalysisService.analysisQaByQaSearch(qaSearch);

		System.out.println(qaSearch.getQaList().get(0).toString());
	}

	@Test
	public void testAnalysisAllQaByQaSearch() throws Exception {
		String searchQuestion = "王者荣耀新手兰陵王怎么玩？";
		QaSearch qaSearch = qaSearchService.pretreatmentQaSearch(searchQuestion);

		System.out.println(qaSearch.toString());

		conversationalAnalysisService.analysisAllQaByQaSearch(qaSearch);
		List<Qa> qaList = qaSearch.getQaList();

		for (Qa qa : qaList) {
			System.out.println(qa.toString());
		}
	}

	@Test
	public void testanalysisAllMethod() throws Exception {
		String searchQuestion = "王者荣耀新手兰陵王怎么玩？";
		QaSearch qaSearch = qaSearchService.pretreatmentQaSearch(searchQuestion);

		System.out.println(qaSearch.toString());

		conversationalAnalysisService.analysisAllMethod(qaSearch.getId(), qaSearch.getSearchQuestion(),
				qaSearch.getSplitWordList(), qaSearch.getKeywordList());

	}

}
