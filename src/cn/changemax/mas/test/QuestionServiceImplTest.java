package cn.changemax.mas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.changemax.mas.mapper.QuestionMapper;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.Question;
import cn.changemax.mas.service.QuestionService;

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
 * @date 2019年1月31日
 * @version 1.0
 */
public class QuestionServiceImplTest {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionMapper questionMapper;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		questionService = (QuestionService) ac.getBean("questionService");
		questionMapper = (QuestionMapper) ac.getBean("questionMapper");

	}

	@Test
	public void testAdd() {

		String userId = "82e9332f-c53e-4b99-9b5d-673f811701ba";
		Integer questionCategoryId = 1;
		String questionTitle = "毛泽东";
		String questionDetail = "123210";
		Integer questionReward = 1;
		Integer isAnonymous = 0;
		Question question;
		try {
			question = questionService.insertQuestion(userId, questionCategoryId, questionTitle, questionDetail,
					questionReward, isAnonymous);
			for (Answer answer : question.getAnswerList()) {
				System.out.println(answer.getAnswerDetail());
				System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	

	@Test
	public void testGetAllHot() {
		/*
		 * 初始化hotQuestionList
		 */
		try {
			String userId = null;
			String adoptionAnswerId = null;
			Integer questionCategoryId = -1;
			Integer isFine = 0;
			Integer isTop = 0;
			Integer number = 10;
			List<Question> hotViewsQuestionList = questionService.selectByViewsDesc(userId, adoptionAnswerId,
					questionCategoryId, isFine, isTop, number);

			for (Question question : hotViewsQuestionList) {
				System.out.println(question.toString());
			}
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
	}

	@Test
	public void testDetail() {
		try {
			String questionId = "f81713ac65d3403dafb4944ed28dfb6f";

			Question question = questionService.selectByQuestionId(questionId);

			String userId1 = null;
			String adoptionAnswerId1 = null;
			Integer questionCategoryId1 = -1;
			Integer isFine1 = 0;
			Integer isTop1 = 0;
			Integer number1 = 10;
			List<Question> hotViewsQuestionList = questionService.selectByViewsDesc(userId1, adoptionAnswerId1,
					questionCategoryId1, isFine1, isTop1, number1);

			String userId2 = null;
			String adoptionAnswerId2 = null;
			Integer questionCategoryId2 = -1;
			Integer isFine2 = 0;
			Integer isTop2 = 0;
			Integer number2 = 10;
			List<Question> hotAnswerQuestionList = questionService.selectByAnswerNumberDesc(userId2, adoptionAnswerId2,
					questionCategoryId2, isFine2, isTop2, number2);
			System.out.println(question.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectMaxQuestionNumberQaCategory() throws Exception {
		Map<Object, Long> map = questionService.selectMaxQuestionNumberQaCategory(-1, -1);
		for (Entry<Object, Long> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}

//		Integer number = -1, qaCategoryId = -1;
//		QuestionExample questionExample = new QuestionExample();
//		if (number > 0) {
//			questionExample.setStartRow(0);
//			questionExample.setPageSize(number);
//		}
//		if (qaCategoryId != null && qaCategoryId > 0) {
//			questionExample.createCriteria().andQuestionCategoryIdEqualTo(qaCategoryId);
//		}
//
//		List<Map<Integer, Integer>> questionNumberMapList = questionMapper
//				.selectCategoryNumberByExample(questionExample);
//
//		if (ListUtils.isNotEmpty(questionNumberMapList)) {
//			Map<Integer, Integer> map = questionNumberMapList.get(0);
////			for (Map<Integer, Integer> map : questionNumberMapList) {
//				for (Entry<Integer, Integer> entry : map.entrySet()) {
//					System.out.println("-------4444444--------");
//
//					Object mapEntryQaCategoryId = entry.getKey();
//					System.out.println(mapEntryQaCategoryId);
//					Object mapEntryNumber = entry.getValue();
//					System.out.println(mapEntryNumber);
//					System.out.println("-------444444444--------");
//
//				}
//				System.out.println("---------------");
////			}
//		}
	}

	public static void main(String[] args) {
		List<Integer> integerList = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			integerList.add(new Integer(random.nextInt(100)));
		}

		for (int i = 0; i < integerList.size(); i++) {
			System.out.println(integerList.get(i));
			integerList.remove(i);
			i--;
		}
	}

}
