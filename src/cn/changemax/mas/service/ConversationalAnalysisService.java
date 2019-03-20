package cn.changemax.mas.service;

import java.util.List;
import java.util.Map;

import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.QaRequest;
import cn.changemax.mas.po.QaResponse;
import cn.changemax.mas.po.Question;
import cn.changemax.mas.po.Text;

/**
 * <p>
 * Title: AnalysisService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月3日
 * @version 1.0
 */
public interface ConversationalAnalysisService {

	/**
	 * 
	 * <p>
	 * Title: analysisQaByQuestion
	 * </p>
	 * <p>
	 * Description: 获取最优Qa
	 * </p>
	 * 
	 * @param newQuestion
	 * @return
	 * @throws Exception
	 */
	public void analysisQaByQuestion(Question question) throws Exception;

	/**
	 * 
	 * <p>
	 * Title: analysisAllQaByQuestion
	 * </p>
	 * <p>
	 * Description: 获取最优Qa集
	 * </p>
	 * 
	 * @param newQuestion
	 * @throws Exception
	 */
	public void analysisAllQaByQuestion(Question question) throws Exception;

	/**
	 * 
	 * <p>
	 * Title: conversationalAnalysisPortal
	 * </p>
	 * <p>
	 * Description: 对话式分析入口
	 * </p>
	 * 
	 * @param newQaResponse
	 * @param qaRequest
	 * @return
	 * @throws Exception
	 */
	public boolean conversationalAnalysisPortal(QaResponse qaResponse, QaRequest qaRequest) throws Exception;

	/**
	 * 
	 * <p>
	 * Title: simpleSentenceAnalysis
	 * </p>
	 * <p>
	 * Description: 简单性分析入口
	 * </p>
	 * 
	 * @param newQaResponse
	 * @param userText
	 * @return
	 * @throws Exception
	 */
	public boolean simpleSentenceAnalysis(QaResponse qaResponse, Text userText) throws Exception;

	/**
	 * 
	 * <p>
	 * Title: complexityAnalysis
	 * </p>
	 * <p>
	 * Description: 复杂性分析入口
	 * </p>
	 * 
	 * @param newQaResponse
	 * @param qaRequest
	 * @return
	 * @throws Exception
	 */
	public boolean complexityAnalysis(QaResponse qaResponse, QaRequest qaRequest) throws Exception;

	/**
	 * 
	 * <p>
	 * Title: analysisAllMethod
	 * </p>
	 * <p>
	 * Description: 开启线程池分析所有方法
	 * </p>
	 * 
	 * @param questionId
	 * @param question
	 * @param splitWordList
	 * @param keywordList
	 * @return
	 * @throws Exception
	 */
	public Map<String, List<Answer>> analysisAllMethod(String questionId, String question, List<String> splitWordList,
			List<String> keywordList) throws Exception;

	public Map<String, List<Answer>> analysisAllMethod2(String questionId, String question, List<String> splitWordList,
			List<String> keywordList) throws Exception;

	List<Answer> analysisMethod(String methodType, String questionId, String textContent, List<String> splitWordList,
			List<String> keywordList);

}
