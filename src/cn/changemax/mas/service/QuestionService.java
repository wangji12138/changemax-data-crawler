package cn.changemax.mas.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.Question;
import cn.changemax.mas.po.QuestionExample;

/**
 * <p>
 * Title: QuestionService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月9日
 * @version 1.0
 */
public interface QuestionService {
	Question insertQuestion(String userId, Integer questionCategoryId, String questionTitle, String questionDetail,
			Integer questionReward, Integer isAnonymous) throws Exception;

//	Qa analysisQuestionQuestion(String searchQuestion) throws Exception;

	void insertQuestion(Question question) throws Exception;

	void updateAnswerNumberByQuestionId(String questionId, Integer answerNumber) throws Exception;

	List<Question> selectByViewsDesc(String userId, String adoptionAnswerId, Integer questionCategoryId, Integer isFine,
			Integer isTop, Integer number) throws Exception;

	List<Question> selectByAnswerNumberDesc(String userId, String adoptionAnswerId, Integer questionCategoryId,
			Integer isFine, Integer isTop, Integer number) throws Exception;

	List<Question> selectByGenerationDateDesc(String userId, String adoptionAnswerId, Integer questionCategoryId,
			Integer isFine, Integer isTop, Integer number) throws Exception;

	Question selectByQuestionId(String questionId) throws Exception;

	List<Question> selectByLikeSearchQuestion(String questionTitle) throws Exception;

	List<Question> selectQuestionSearchInfo(Question question, PageModel pageModel, String startTime, String endTime)
			throws Exception;

	Map<Object, Long> selectMaxQuestionNumberQaCategory(Integer qaCategoryId, Integer number)
			throws Exception;

}
