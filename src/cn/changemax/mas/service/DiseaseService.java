package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.Disease;
import cn.changemax.mas.po.DiseaseExample;
import cn.changemax.mas.po.DiseaseWithBLOBs;

/**
 * <p>
 * Title: TDiseaseService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年11月28日
 * @version 1.0
 */
public interface DiseaseService {
	DiseaseWithBLOBs selectByPrimaryKey(String diseaseId) throws Exception;

	List<Disease> selectByExample(DiseaseExample example) throws Exception;

	List<DiseaseWithBLOBs> selectByExampleWithBLOBs(DiseaseExample example) throws Exception;

	List<Disease> getTDiseaseByName(String diseaseName) throws Exception;

	List<Answer> getBastDiseaseIntroByLikeDiseaseName(String analysisType, String questionId, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception;

	List<DiseaseWithBLOBs> selectDiseaseIntroByLikeDiseaseName(List<String> keywordList) throws Exception;

	int getCount(DiseaseExample example) throws Exception;

	List<DiseaseWithBLOBs> selectDiseaseWithBLOBsSearchInfo(Disease disease, PageModel pageModel) throws Exception;

}
