package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.exception.DiseaseException;
import cn.changemax.mas.exception.TextSimilarityException;
import cn.changemax.mas.mapper.DiseaseMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.Disease;
import cn.changemax.mas.po.DiseaseExample;
import cn.changemax.mas.po.DiseaseWithBLOBs;
import cn.changemax.mas.service.AnswerService;
import cn.changemax.mas.service.DiseaseService;
import cn.changemax.mas.utils.ListUtils;
import cn.changemax.mas.utils.MapUtils;
import cn.changemax.mas.utils.StringUtils;
import cn.changemax.mas.utils.TextSimilarityUtils;

/**
 * <p>
 * Title: TDiseaseServiceImpl.java
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
public class DiseaseServiceImpl implements DiseaseService {

	@Autowired
	private DiseaseMapper diseaseMapper;

	@Autowired
	private AnswerService answerService;

	@Override
	public DiseaseWithBLOBs selectByPrimaryKey(String diseaseId) throws Exception {
		// TODO Auto-generated method stub
		return diseaseMapper.selectByPrimaryKey(diseaseId);
	}

	@Override
	public List<Disease> selectByExample(DiseaseExample example) throws Exception {

		return null;
	}

	@Override
	public List<DiseaseWithBLOBs> selectByExampleWithBLOBs(DiseaseExample example) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiseaseWithBLOBs> selectDiseaseWithBLOBsSearchInfo(Disease disease, PageModel pageModel)
			throws Exception {
		/** 当前需要分页的总数据条数  */
		DiseaseExample example = new DiseaseExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return diseaseMapper.selectByExampleWithBLOBs(example);
		} else {
			return new ArrayList<DiseaseWithBLOBs>();
		}
	}

	@Override
	public int getCount(DiseaseExample example) throws Exception {
		return diseaseMapper.countByExample(example);
	}

	@Override
	public List<Disease> getTDiseaseByName(String diseaseName) throws Exception {
		DiseaseExample example = new DiseaseExample();
		example.createCriteria().andDiseaseNameLike("%" + diseaseName + "%");
		List<Disease> tDiseaseList = diseaseMapper.selectByExample(example);
		return tDiseaseList;
	}

	@Override
	public List<Answer> getBastDiseaseIntroByLikeDiseaseName(String analysisType, String questionId, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception {
		if (StringUtils.isEmpty(textContent) || ListUtils.isEmpty(splitWordList) || ListUtils.isEmpty(keywordList)) {
			throw new TextSimilarityException("文本分析对象或文本分词对象集或文本关键词集为空！");
		}

		List<DiseaseWithBLOBs> diseaseWithBLOBsList = selectDiseaseIntroByLikeDiseaseName(keywordList);

		final double minSimilarity1 = 0.0, minSimilarity2 = 0.9;
		final String sortField = "diseaseName";
		final boolean isName = true;
		Map<DiseaseWithBLOBs, Double> diseaseWithBLOBListMap = TextSimilarityUtils.getSimilarityMapByObtainObjectList(
				textContent, splitWordList, keywordList, diseaseWithBLOBsList, minSimilarity1, minSimilarity2,
				sortField, isName);

		List<Answer> answerList = null;
		if (MapUtils.isNotEmpty(diseaseWithBLOBListMap)) {
			final String toOriginalQuestionField = "diseaseNames";
			final String toAnswerField = "diseaseIntro";
			final String toRelatedUrlField = "diseaseId";
			try {
				answerList = answerService.mapToList(diseaseWithBLOBListMap, toOriginalQuestionField, toAnswerField,
						toRelatedUrlField, analysisType, questionId);
			} catch (Exception e) {
				throw new DiseaseException(e.getMessage());
			}

		}

		return answerList;

	}

	@Override
	public List<DiseaseWithBLOBs> selectDiseaseIntroByLikeDiseaseName(List<String> keywordList) {
		DiseaseExample example = new DiseaseExample();
		example.createCriteria();
		for (String keyword : keywordList) {
			example.getOredCriteria().get(0).andDiseaseNameLike("%" + keyword + "%");
		}
		return diseaseMapper.selectByExampleWithBLOBs(example);

	}

}
