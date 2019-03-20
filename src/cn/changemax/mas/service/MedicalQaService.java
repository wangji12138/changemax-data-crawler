package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.MedicalQa;
import cn.changemax.mas.po.MedicalQaExample;

/**
 * <p>
 * Title: MedicalQaSerivce.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月2日
 * @version 1.0
 */
public interface MedicalQaService {

	List<MedicalQa> selectMedicalQaByLikeQuestion(List<String> keywordList) throws Exception;

	List<Answer> getBestMedicalQaList(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception;

	List<MedicalQa> selectMedicalQaSearchInfo(MedicalQa medicalQa, PageModel pageModel) throws Exception;

	int getCount(MedicalQaExample example) throws Exception;

	MedicalQa selectByPrimaryKey(Integer qaId) throws Exception;

}
