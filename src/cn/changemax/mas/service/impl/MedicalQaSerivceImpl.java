package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.exception.AnalysisException;
import cn.changemax.mas.mapper.MedicalQaMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.MedicalQa;
import cn.changemax.mas.po.MedicalQaExample;
import cn.changemax.mas.service.AnswerService;
import cn.changemax.mas.service.MedicalQaService;
import cn.changemax.mas.utils.ListUtils;
import cn.changemax.mas.utils.MapUtils;
import cn.changemax.mas.utils.SortUtils;
import cn.changemax.mas.utils.StringUtils;
import cn.changemax.mas.utils.TextSimilarityUtils;

/**
 * <p>
 * Title: MedicalQaSerivceImpl.java
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
public class MedicalQaSerivceImpl implements MedicalQaService {

	@Autowired
	private MedicalQaMapper medicalQaMapper;

	@Autowired
	private AnswerService answerService;

	@Override
	public List<MedicalQa> selectMedicalQaByLikeQuestion(List<String> keywordList) throws Exception {
		MedicalQaExample example = new MedicalQaExample();
		example.createCriteria();
		for (String keyword : keywordList) {
			example.getOredCriteria().get(0).andQuestionLike("%" + keyword + "%");
		}
		return medicalQaMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<Answer> getBestMedicalQaList(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception {
		if (StringUtils.isEmpty(questionId) || StringUtils.isEmpty(analysisType) || StringUtils.isEmpty(textContent)
				|| ListUtils.isEmpty(splitWordList) || ListUtils.isEmpty(keywordList)) {
			throw new AnalysisException(MedicalQaSerivceImpl.class + "：参数不正确");
		}
		System.err.println("进入getBestMedicalQaList");

		List<MedicalQa> medicalQaList = selectMedicalQaByLikeQuestion(keywordList);

		List<Answer> bestMedicalQaList = null;
		if (ListUtils.isNotEmpty(medicalQaList)) {
			final double minSimilarity1 = 0.8, minSimilarity2 = 0.8;
			final String sortField = "question";
			final boolean isName = false;

			// 获取相识度集高集
			Map<MedicalQa, Double> obtainMedicalQaMap = TextSimilarityUtils.getSimilarityMapByObtainObjectList(
					textContent, splitWordList, keywordList, medicalQaList, minSimilarity1, minSimilarity2, sortField,
					isName);

			if (MapUtils.isNotEmpty(obtainMedicalQaMap)) {
				final boolean sortMode = false;
				// 将map集中按相似度值V排序
				List<Map.Entry<MedicalQa, Double>> qaEntryList = SortUtils.sortMapByDouble(obtainMedicalQaMap,
						sortMode);

				if (ListUtils.isNotEmpty(qaEntryList)) {
					final String toOriginalQuestionField = "question";
					final String toAnswerField = "answer";
					final String toRelatedUrlField = "qaId";

					// 将List<Map.Entry<K, Double>>转换为answerList
					bestMedicalQaList = answerService.listMapToListAnswer(qaEntryList, toOriginalQuestionField,
							toAnswerField, toRelatedUrlField, analysisType, questionId);

				}
			}
		}

		return bestMedicalQaList;
	}

	@Override
	public List<MedicalQa> selectMedicalQaSearchInfo(MedicalQa medicalQa, PageModel pageModel) throws Exception {
		/** 当前需要分页的总数据条数  */
		MedicalQaExample example = new MedicalQaExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return medicalQaMapper.selectByExample(example);
		} else {
			return new ArrayList<MedicalQa>();
		}
	}

	@Override
	public int getCount(MedicalQaExample example) throws Exception {
		return medicalQaMapper.countByExample(example);
	}

	@Override
	public MedicalQa selectByPrimaryKey(Integer qaId) throws Exception {
		return medicalQaMapper.selectByPrimaryKey(qaId);
	}

}
