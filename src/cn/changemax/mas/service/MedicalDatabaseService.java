package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.po.Answer;

/**
 * <p>
 * Title: MedicalDatabaseService.java
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
public interface MedicalDatabaseService {

	List<Answer> getBestMedicalDataList(String QuestionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception;

}
