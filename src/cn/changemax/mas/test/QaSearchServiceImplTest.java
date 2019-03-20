package cn.changemax.mas.test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.changemax.mas.po.Question;
import cn.changemax.mas.service.QuestionService;
import cn.changemax.mas.utils.StringUtils;

/**
 * <p>
 * Title: QuestionServiceImplTest.java
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
public class QaSearchServiceImplTest {

	private QuestionService questionService;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		questionService = (QuestionService) ac.getBean("questionService");

	}

	@Test
	public void selectNewQuestionTest2() throws Exception {
		Map<Integer, Integer> map = questionService.selectMaxQuestionNumberQaCategory(-1, -1);
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+"--"+entry.getValue());
		}
	}

	@Test
	public void selectNewQuestionTest() throws Exception {
		List<Question> newQuestionList = null;
		try {
			Integer isAddFine = 0;
			Integer isTop = 0;
			Integer desirableQaId = 0;
			Integer number = 10;
			newQuestionList = questionService.selectMaxSearchDateQuestion(isAddFine, isTop, desirableQaId, number);

		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println(errorMessage);
			e.printStackTrace();
		}
		for (Question qaSearch : newQuestionList) {
			System.out.println(qaSearch.getSearchQuestion());
		}
	}

	@Test
	public void initiateTest() throws Exception {
		String userId = "82e9332f-c53e-4b99-9b5d-673f811701ba";

		String searchQuestion = "感冒发烧了怎么办？";

		try {
			Question qaSearch = qaSearchService.insertQuestion(1, userId, searchQuestion);

			System.out.println(qaSearch.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void listFineTest() throws Exception {
		List<Question> fineQuestionList = null;
		try {
			Integer isAddFine = 1;
			Integer isTop = 0;
			Integer desirableQaId = -1;
			Integer number = 5;
			fineQuestionList = qaSearchService.selectMaxSearchDateQuestion(isAddFine, isTop, desirableQaId, number);

		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println(errorMessage);
			e.printStackTrace();
		}

		for (Question qaSearch : fineQuestionList) {
			System.out.println(qaSearch.toString());
			System.out.println(qaSearch.getUser().toString());
		}
	}

	@Test
	public void listHotTest() throws Exception {
		List<Question> hotViewsQuestionList = null;

		try {

			String userId = null;
			String adoptionAnswerId = null;
			Integer questionCategoryId = -1;
			Integer isFine = 0;
			Integer isTop = 0;
			Integer number = 10;
			hotViewsQuestionList = questionService.selectByViewsDesc(userId, adoptionAnswerId, questionCategoryId,
					isFine, isTop, number);

			for (Question qaSearch : hotViewsQuestionList) {
				System.out.println(qaSearch.toString());
				System.out.println(qaSearch.getUser().toString());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void dateilTest() throws Exception {
		String id = "f5eecfddbdde44af9a26f4c7d84eafa7";

		try {
			Question qaSearch = qaSearchService.selectById(id);
			List<Question> hotViewsQuestionList = qaSearchService.selectMaxViewsQuestion(8);
			List<Question> hotAnswerQuestionList = qaSearchService.selectMaxAnswerQuestion(8);

			System.out.println(qaSearch.getQaList().toString());
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
	}

}
