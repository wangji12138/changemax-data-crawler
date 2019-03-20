package cn.changemax.mas.service.impl;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.exception.AnswerException;
import cn.changemax.mas.mapper.AnswerMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.AnswerExample;
import cn.changemax.mas.po.Question;
import cn.changemax.mas.service.AnswerService;
import cn.changemax.mas.service.QuestionService;
import cn.changemax.mas.service.UserService;
import cn.changemax.mas.utils.ListUtils;
import cn.changemax.mas.utils.SimilarityUtil;
import cn.changemax.mas.utils.StringUtils;

/**
 * <p>
 * Title: AnswerServiceImpl.java
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
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	private AnswerMapper answerMapper;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserService userService;

	@Override
	public Question insertAnswer(String userId, String questionId, String originalQuestion, String answerDetail)
			throws Exception {
		/*
		 * 更新Question的回答数量
		 */
		questionService.updateAnswerNumberByQuestionId(questionId, 1);

		/*
		 * 新增Answer
		 */
		Double questionSimilarity = 1.0;
		String answerType = "USER", relatedUrl = "";
		Answer newAnswer = pretreatmentAnswer(userId, questionId, originalQuestion, questionSimilarity, answerType,
				relatedUrl, answerDetail);
		insertAnswer(newAnswer);// 持久化

		/*
		 * 根据question的ID查询question及根据question的ID查询基本User
		 */
		return questionService.selectByQuestionId(questionId);

	}

	private Answer pretreatmentAnswer(String userId, String questionId, String originalQuestion,
			double questionSimilarity, String answerType, String relatedUrl, String answerDetail) throws Exception {
		// 问答对象预处理
		Answer newAnswer = new Answer();

		newAnswer.setAnswerId(UUID.randomUUID().toString().replace("-", ""));// 生成答案id
		newAnswer.setUserId(userId);// 生成用户ID
		newAnswer.setQuestionId(questionId);// 生成主贴id
		newAnswer.setOriginalQuestion(originalQuestion);// 生成原始问题内容

		DecimalFormat dfQuestionSimilarity = new DecimalFormat("0.000000"); // 设置double类型小数点后位数格式
		questionSimilarity = Double.parseDouble(dfQuestionSimilarity.format(questionSimilarity));
		newAnswer.setQuestionSimilarity(questionSimilarity);// 生成问题与原始问题相似度

		newAnswer.setAnswerType(answerType);// 生成答案类型
		newAnswer.setRelatedUrl(relatedUrl);// 生成相关地址
		newAnswer.setGenerationDate(new Date());// 生成回帖时间
		newAnswer.setGoodNumber(0);// 生成好赞数量
		newAnswer.setBadNumber(0);// 生成坏赞数量
		newAnswer.setIsAdoption(0);// 生成是否采纳
		newAnswer.setAnswerDetail(answerDetail); // 生成回答内容

		return newAnswer;

	}

	@Override
	public void insertAnswer(Answer answer) throws Exception {
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
		System.out.println(answer.toString());
		//answerMapper.insert(answer);
//			}
//		}).start();

	}

	@Override
	public void insertAnswerList(List<Answer> answerList) throws Exception {
		for (Answer answer : answerList) {
			insertAnswer(answer);
		}
	}

	@Override
	public Integer updateGoodNumberByAnswerId(String answerId, Integer goodNumber) throws Exception {
		return answerMapper.updateGoodNumberByAnswerId(answerId, goodNumber);
	}

	@Override
	public Integer updateBadNumberByAnswerId(String answerId, Integer badNumber) throws Exception {
		return answerMapper.updateBadNumberByAnswerId(answerId, badNumber);
	}

	@Override
	public Integer updateIsAdoptionByAnswerId(String answerId, String questionId) throws Exception {
		AnswerExample example = new AnswerExample();
		example.createCriteria().andQuestionIdEqualTo(questionId).andIsAdoptionEqualTo(1);//

		Integer desirableAnswerCount = answerMapper.countByExample(example);
		if (desirableAnswerCount != null && desirableAnswerCount > 0) {
			throw new AnswerException("已经确立的合适的答案，无法改变");
//			updateIsOptimalById(0);
		}

		Answer record = new Answer();
		Integer isAdoption = 1;
		record.setIsAdoption(isAdoption);
		example.createCriteria().andAnswerIdEqualTo(answerId).andQuestionIdEqualTo(questionId);//
		return answerMapper.updateByExample(record, example);
	}

	@Override
	public List<Answer> selectBasicByQuestionId(String questionId) throws Exception {
		AnswerExample answerExample = new AnswerExample();
		String fieldName = "generation_date", userId = null, answerType = null;
		Integer isAdoption = 0, number = -1;
		List<Answer> answerList = selectByFieldDesc(answerExample, fieldName, userId, questionId, answerType,
				isAdoption, number);

		boolean isUser = true;
		getOtherRelatedObject(answerList, isUser);
		return answerList;
	}

	@Override
	public List<Answer> selectByGenerationDateDesc(String userId, String questionId, String answerType,
			Integer isAdoption) throws Exception {
		AnswerExample answerExample = new AnswerExample();
		String fieldName = "generation_date";
		Integer number = -1;
		List<Answer> answerList = selectByFieldDesc(answerExample, fieldName, userId, questionId, answerType,
				isAdoption, number);

		boolean isUser = true;
		getOtherRelatedObject(answerList, isUser);
		return answerList;
	}

	private List<Answer> selectByFieldDesc(AnswerExample answerExample, String fieldName, String userId,
			String questionId, String answerType, Integer isAdoption, Integer number) throws Exception {
		// 默认设定
		answerExample = answerExample != null ? answerExample : new AnswerExample();
		fieldName = (StringUtils.isNotEmpty(fieldName)) ? fieldName : "search_date";
		userId = (StringUtils.isNotEmpty(userId)) ? userId : null;
		questionId = (StringUtils.isNotEmpty(questionId)) ? questionId : null;
		answerType = (StringUtils.isNotEmpty(answerType)) ? answerType : null;
		isAdoption = (isAdoption != null && isAdoption >= 0) ? ((isAdoption > 0) ? 1 : 0) : -1;
		number = (number != null && number >= 0) ? number : -1;

		answerExample.setOrderByClause("`" + fieldName + "` DESC, answer_id DESC");

		if (userId != null || questionId != null || answerType != null || isAdoption != -1) {
			if (!(answerExample.getOredCriteria() != null && answerExample.getOredCriteria().size() > 0)) {
				answerExample.createCriteria();
				System.err.println("answerExample.createCriteria()");
			} else {
				System.err.println(answerExample.getOredCriteria().size());
			}

			if (userId != null) {
				answerExample.getOredCriteria().get(0).andUserIdEqualTo(userId);
			}
			if (questionId != null) {
				answerExample.getOredCriteria().get(0).andQuestionIdEqualTo(questionId);
			}
			if (answerType != null) {
				answerExample.getOredCriteria().get(0).andAnswerTypeEqualTo(answerType);
			}
			if (isAdoption != -1) {
				answerExample.getOredCriteria().get(0).andIsAdoptionEqualTo(isAdoption);
			}
		}

		if (number != -1) {
			answerExample.setStartRow(0);
			answerExample.setPageSize(number);
		}

		return answerMapper.selectByExample(answerExample);

	}

	private void getOtherRelatedObject(List<Answer> answerList, boolean isUser) throws Exception {
		if (ListUtils.isNotEmpty(answerList)) {
			for (Answer answer : answerList) {
				if (isUser) {
					// 获取用户信息
					answer.setUser(userService.selectBasicByPrimaryKey(answer.getUserId()));
				}
			}
		}
	}

	@Override
	public Answer selectAdoptionByQuestionId(String questionId) throws Exception {
		Answer adoptionAnswer = null;
		AnswerExample example = new AnswerExample();
		example.createCriteria().andQuestionIdEqualTo(questionId).andIsAdoptionEqualTo(1);
		List<Answer> answerList = answerMapper.selectByExample(example);

		if (ListUtils.isNotEmpty(answerList) && answerList.size() == 1) {
			adoptionAnswer = answerList.get(0);
		}

		return adoptionAnswer;
	}

	@Override
	public List<Answer> selectQuestionInfo(Answer answer, PageModel pageModel, String startTime, String endTime)
			throws Exception {
		/** 当前需要分页的总数据条数  */
		AnswerExample answerExample = new AnswerExample();
		// 时间约束
		if (StringUtils.isNotEmpty(startTime) || StringUtils.isNotEmpty(endTime)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			answerExample.createCriteria();
			if (StringUtils.isNotEmpty(startTime)) {
				System.out.println();
				answerExample.getOredCriteria().get(0).andGenerationDateGreaterThanOrEqualTo(sdf.parse(startTime));
			}
			if (StringUtils.isNotEmpty(endTime)) {
				answerExample.getOredCriteria().get(0).andGenerationDateLessThan(sdf.parse(endTime));
			}
		}

		int recordCount = getCount(answerExample, null, null, null, null);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			answerExample.setStartRow(pageModel.getFirstLimitParam());
			answerExample.setPageSize(pageModel.getPageSize());

			return answerMapper.selectByExample(answerExample);
		} else {
			return new ArrayList<Answer>();
		}
	}

	private Integer getCount(AnswerExample answerExample, String userId, String questionId, String answerType,
			Integer isAdoption) throws Exception {

		// 默认设定
		answerExample = answerExample != null ? answerExample : new AnswerExample();
		userId = (StringUtils.isNotEmpty(userId)) ? userId : null;
		questionId = (StringUtils.isNotEmpty(questionId)) ? questionId : null;
		answerType = (StringUtils.isNotEmpty(answerType)) ? answerType : null;
		isAdoption = (isAdoption != null && isAdoption >= 0) ? ((isAdoption > 0) ? 1 : 0) : -1;

		if (answerExample.getOredCriteria() == null && answerExample.getOredCriteria().get(0) == null) {
			answerExample.createCriteria();
		}

		if (userId != null) {
			answerExample.getOredCriteria().get(0).andUserIdEqualTo(userId);
		}

		if (questionId != null) {
			answerExample.getOredCriteria().get(0).andQuestionIdEqualTo(questionId);
		}

		if (answerType != null) {
			answerExample.getOredCriteria().get(0).andAnswerTypeEqualTo(answerType);
		}

		if (isAdoption != -1) {
			answerExample.getOredCriteria().get(0).andIsAdoptionEqualTo(isAdoption);
		}

		return answerMapper.countByExample(answerExample);
	}

	@Override
	public Answer selectAnswerById(String answerId) throws Exception {
		return answerMapper.selectByPrimaryKey(answerId);
	}

	/**
	 * 将List<Map.Entry<K, Double>>转换为List，且不破坏原有顺序
	 */
	@Override
	public <K, V extends Comparable<? super V>> List<Answer> listMapToListAnswer(List<Map.Entry<K, Double>> toMapList,
			final String toOriginalQuestionField, final String toAnswerField, final String toRelatedUrlField,
			final String analysisType, final String questionId) throws Exception {
		if (ListUtils.isEmpty(toMapList)) {
			return null;
		}

		if (StringUtils.isEmpty(toOriginalQuestionField) || StringUtils.isEmpty(toAnswerField)
				|| StringUtils.isEmpty(analysisType) || StringUtils.isEmpty(questionId)) {
			throw new AnswerException("Map转换List<Answer>异常！！");
		}
		Object toKObject = toMapList.get(0).getKey();

		// 获取getXxx()方法名称
		String toOriginalQuestionFieldMethodStr = "get" + toOriginalQuestionField.substring(0, 1).toUpperCase()
				+ toOriginalQuestionField.substring(1);
		Method toOriginalQuestionFieldMethod = toKObject.getClass().getMethod(toOriginalQuestionFieldMethodStr, null);

		// 获取getXxx()方法名称
		String toAnswerFieldMethodStr = "get" + toAnswerField.substring(0, 1).toUpperCase()
				+ toAnswerField.substring(1);
		Method toAnswerFieldMethod = toKObject.getClass().getMethod(toAnswerFieldMethodStr, null);

		// 获取getXxx()方法名称
		Method toRelatedUrlFieldMethod = null;
		if (StringUtils.isNotEmpty(toRelatedUrlField)) {
			String toRelatedUrlFieldMethodStr = "get" + toRelatedUrlField.substring(0, 1).toUpperCase()
					+ toRelatedUrlField.substring(1);
			toRelatedUrlFieldMethod = toKObject.getClass().getMethod(toRelatedUrlFieldMethodStr, null);
		}

		List<Answer> answerList = new ArrayList<Answer>();
		for (Entry<K, Double> entry : toMapList) {
			Object object = entry.getKey();
			Double questionSimilarity = entry.getValue();
			Object toOriginalQuestionFieldValue = toOriginalQuestionFieldMethod.invoke(object, null);
			String originalQuestion = toOriginalQuestionFieldValue == null ? ""
					: toOriginalQuestionFieldValue.toString();
			Object toAnswerFieldValue = toAnswerFieldMethod.invoke(object, null);

			/*
			 * 此处需对相似度答案细节进行筛选 判断是否重复答案细节，来进行是否添加答案集
			 */
			boolean isRepeatAnswerDetail = false;

			String answerDetail = toAnswerFieldValue == null ? "" : toAnswerFieldValue.toString();
			for (Answer answer : answerList) {
				double answerDetailSimilarity = SimilarityUtil.getSimilarity(answerDetail, answer.getAnswerDetail());
				if (answerDetailSimilarity > 0.9) {
					System.err.println("出现重复答案细节，相似度为：" + answerDetailSimilarity);
					isRepeatAnswerDetail = true;
					break;
				}
			}

			if (!isRepeatAnswerDetail) {
				Object toRelatedUrlFieldValue = toRelatedUrlFieldMethod == null ? ""
						: (toRelatedUrlFieldMethod.invoke(object, null));
				String relatedUrl = toRelatedUrlFieldValue == null ? "" : toRelatedUrlFieldValue.toString();
				String userId = "changemax";

				Answer newAnswer = pretreatmentAnswer(userId, questionId, originalQuestion, questionSimilarity,
						analysisType, relatedUrl, answerDetail);

				answerList.add(newAnswer);
			}

		}

		return answerList;

	}

	/**
	 * 将无序结果集转换为无序Answer集
	 */
	@Override
	public <K, V extends Comparable<? super V>> List<Answer> mapToList(Map<K, Double> toMap,
			final String toOriginalQuestionField, final String toAnswerField, final String toRelatedUrlField,
			final String analysisType, final String questionId) throws Exception {

		List<Map.Entry<K, Double>> toMapList = new ArrayList<Map.Entry<K, Double>>(toMap.entrySet());

		return listMapToListAnswer(toMapList, toOriginalQuestionField, toAnswerField, toRelatedUrlField, analysisType,
				questionId);
	}

}
