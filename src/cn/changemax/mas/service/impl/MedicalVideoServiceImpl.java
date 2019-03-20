package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.exception.AnalysisException;
import cn.changemax.mas.mapper.MedicalVideoMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.MedicalVideo;
import cn.changemax.mas.po.MedicalVideoExample;
import cn.changemax.mas.service.AnswerService;
import cn.changemax.mas.service.MedicalVideoService;
import cn.changemax.mas.utils.ListUtils;
import cn.changemax.mas.utils.MapUtils;
import cn.changemax.mas.utils.SortUtils;
import cn.changemax.mas.utils.StringUtils;
import cn.changemax.mas.utils.TextSimilarityUtils;

/**
 * <p>
 * Title: MedicalVideoServiceImpl.java
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
public class MedicalVideoServiceImpl implements MedicalVideoService {

	@Autowired
	private MedicalVideoMapper medicalVideoMapper;

	@Autowired
	private AnswerService answerService;

	@Override
	public List<MedicalVideo> selectMedicalVideoByLikeQuestion(List<String> keywordList) throws Exception {
		MedicalVideoExample example = new MedicalVideoExample();
		example.createCriteria();
		for (String keyword : keywordList) {
			example.getOredCriteria().get(0).andVideoTitleLike("%" + keyword + "%");
		}
		return medicalVideoMapper.selectByExample(example);
	}

	@Override
	public List<Answer> getBestMedicalVideo(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception {
		if (StringUtils.isEmpty(questionId) || StringUtils.isEmpty(analysisType) || StringUtils.isEmpty(textContent)
				|| ListUtils.isEmpty(splitWordList) || ListUtils.isEmpty(keywordList)) {
			throw new AnalysisException(MedicalVideoServiceImpl.class + "：参数不正确");
		}
		System.err.println("进入getBestMedicalVideo");

		List<MedicalVideo> medicalVideoList = selectMedicalVideoByLikeQuestion(keywordList);

		List<Answer> bestMedicalVideoQaList = null;
		if (ListUtils.isNotEmpty(medicalVideoList)) {
			final double minSimilarity1 = 0.8, minSimilarity2 = 0.8;
			final String sortField = "videoTitle";
			final boolean isName = false;

			// 获取相识度集高集
			Map<MedicalVideo, Double> obtainMedicalVideoMap = TextSimilarityUtils.getSimilarityMapByObtainObjectList(
					textContent, splitWordList, keywordList, medicalVideoList, minSimilarity1, minSimilarity2,
					sortField, isName);

			if (MapUtils.isNotEmpty(obtainMedicalVideoMap)) {
				final boolean sortMode = false;
				// 将map集中按相似度值V排序
				List<Map.Entry<MedicalVideo, Double>> qaEntryList = SortUtils.sortMapByDouble(obtainMedicalVideoMap,
						sortMode);

				if (ListUtils.isNotEmpty(qaEntryList)) {
					final String toOriginalQuestionField = "videoTitle";
					final String toAnswerField = "videoUrl";
					final String toRelatedUrlField = "videoUrl";

					// 将List<Map.Entry<K, Double>>转换为answerList
					bestMedicalVideoQaList = answerService.listMapToListAnswer(qaEntryList, toOriginalQuestionField,
							toAnswerField, toRelatedUrlField, analysisType, questionId);

				}
			}
		}

		return bestMedicalVideoQaList;
	}

	@Override
	public List<MedicalVideo> selectMedicalVideoSearchInfo(MedicalVideo medicalVideo, PageModel pageModel)
			throws Exception {
		/** 当前需要分页的总数据条数  */
		MedicalVideoExample example = new MedicalVideoExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return medicalVideoMapper.selectByExample(example);
		} else {
			return new ArrayList<MedicalVideo>();
		}
	}

	@Override
	public int getCount(MedicalVideoExample example) throws Exception {
		return medicalVideoMapper.countByExample(example);
	}

	@Override
	public MedicalVideo selectByPrimaryKey(Integer videoId) throws Exception {
		return medicalVideoMapper.selectByPrimaryKey(videoId);
	}

}
