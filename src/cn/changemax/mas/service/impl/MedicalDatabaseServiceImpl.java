package cn.changemax.mas.service.impl;

import java.util.List;

import cn.changemax.mas.exception.AnalysisException;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.service.MedicalDatabaseService;
import cn.changemax.mas.utils.ListUtils;
import cn.changemax.mas.utils.StringUtils;

/**
 * <p>
 * Title: MedicalDatabaseServiceImpl.java
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
public class MedicalDatabaseServiceImpl implements MedicalDatabaseService {

	@Override
	public List<Answer> getBestMedicalDataList(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception {
		if (StringUtils.isEmpty(questionId) || StringUtils.isEmpty(analysisType) || StringUtils.isEmpty(textContent)
				|| ListUtils.isEmpty(splitWordList) || ListUtils.isEmpty(keywordList)) {
			throw new AnalysisException(MedicalDatabaseServiceImpl.class + "：参数不正确");
		}
		System.err.println("进入getBestMedicalDataList");
		return null;
	}

}
