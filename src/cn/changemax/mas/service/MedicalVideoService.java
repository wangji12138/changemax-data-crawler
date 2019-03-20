package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.MedicalVideo;
import cn.changemax.mas.po.MedicalVideoExample;

/**
 * <p>
 * Title: MedicalVideoService.java
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
public interface MedicalVideoService {
	List<Answer> getBestMedicalVideo(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception;

	List<MedicalVideo> selectMedicalVideoByLikeQuestion(List<String> keywordList) throws Exception;

	MedicalVideo selectByPrimaryKey(Integer videoId) throws Exception;

	int getCount(MedicalVideoExample example) throws Exception;

	List<MedicalVideo> selectMedicalVideoSearchInfo(MedicalVideo medicalVideo, PageModel pageModel) throws Exception;

}
