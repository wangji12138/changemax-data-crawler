package cn.changemax.mas.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.changemax.mas.po.Qa;
import cn.changemax.mas.service.BdzdQaService;
import cn.changemax.mas.utils.WordUtils;

/**
 * <p>
 * Title: BdzdQuestionAnswerServiceImplTest.java
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
public class BdzdQuestionAnswerServiceImplTest {
	private BdzdQaService bdzdQuestionAnswerService;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		bdzdQuestionAnswerService = (BdzdQaService) ac.getBean("bdzdQuestionAnswerService");

	}

	@Test
	public void testGetInternetAnswer() throws Exception {
		String searchQuestion = "王者荣耀亚瑟怎么玩？";
		List<Qa> qas = bdzdQuestionAnswerService.getBestInternetAnswerList("123456", "test", searchQuestion,
				WordUtils.getSplitWords(searchQuestion), WordUtils.getKeywordWords(searchQuestion));
		for (Qa qa : qas) {
			System.out.println(qa.toString());

		}
	}

}
