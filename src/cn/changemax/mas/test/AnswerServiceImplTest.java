package cn.changemax.mas.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.changemax.mas.mapper.AnswerMapper;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.service.AnswerService;
import cn.changemax.mas.service.EncyclopediaService;
import cn.changemax.mas.utils.WordUtils;

/**
 * <p>
 * Title: AnswerServiceImplTest.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2019年1月31日
 * @version 1.0
 */
public class AnswerServiceImplTest {

	@Autowired
	private EncyclopediaService encyclopediaService;

	@Autowired
	private AnswerMapper answerMapper;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		encyclopediaService = (EncyclopediaService) ac.getBean("encyclopediaService");
		answerMapper = (AnswerMapper) ac.getBean("answerMapper");

	}

	@Test
	public void testAdd() {

		String questionId = "82e9332f-c53e-4b99-9b5d-673f811701ba";
		String analysisType = "AS";
		String textContent = "阿里巴巴";
		try {
			List<Answer> answerList = encyclopediaService.getBestEncyclopediaList(questionId, analysisType, textContent,
					WordUtils.getSplitWords(textContent), WordUtils.getKeywordWords(textContent));
			for (Answer answer : answerList) {
				System.out.println(answer.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated cat

		}

	}

}
