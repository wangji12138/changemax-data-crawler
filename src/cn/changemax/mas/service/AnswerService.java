package cn.changemax.mas.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.AnswerExample;
import cn.changemax.mas.po.Question;

/**
 * <p>
 * Title: AnswerService.java
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
public interface AnswerService {
	Question insertAnswer(String userId, String questionId, String originalQuestion, String answerDetail)
			throws Exception;

	void insertAnswer(Answer answer) throws Exception;

	void insertAnswerList(List<Answer> answerList) throws Exception;

	Answer selectAdoptionByQuestionId(String questionId) throws Exception;

	List<Answer> selectBasicByQuestionId(String questionId) throws Exception;

	List<Answer> selectQuestionInfo(Answer answer, PageModel pageModel, String startTime, String endTime)
			throws Exception;

	Answer selectAnswerById(String answerId) throws Exception;

	Integer updateGoodNumberByAnswerId(String answerId, Integer goodNumber) throws Exception;

	Integer updateBadNumberByAnswerId(String answerId, Integer badNumber) throws Exception;

	Integer updateIsAdoptionByAnswerId(String answerId, String questionId) throws Exception;

	<K, V extends Comparable<? super V>> List<Answer> listMapToListAnswer(List<Entry<K, Double>> toMapList,
			String toOriginalQuestionField, String toAnswerField, String toRelatedUrlField, String analysisType,
			String questionId) throws Exception;

	<K, V extends Comparable<? super V>> List<Answer> mapToList(Map<K, Double> toMap, String toOriginalQuestionField,
			String toAnswerField, String toRelatedUrlField, String analysisType, String questionId) throws Exception;

	List<Answer> selectByGenerationDateDesc(String userId, String questionId, String answerType, Integer isAdoption)
			throws Exception;

}
