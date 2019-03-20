package cn.changemax.mas.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.exception.QuestionException;
import cn.changemax.mas.mapper.QuestionMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.QaCategory;
import cn.changemax.mas.po.Question;
import cn.changemax.mas.po.QuestionExample;
import cn.changemax.mas.po.User;
import cn.changemax.mas.service.AnswerService;
import cn.changemax.mas.service.ConversationalAnalysisService;
import cn.changemax.mas.service.QaCategoryService;
import cn.changemax.mas.service.QuestionService;
import cn.changemax.mas.service.UserService;
import cn.changemax.mas.utils.ListUtils;
import cn.changemax.mas.utils.StringUtils;
import cn.changemax.mas.utils.WordUtils;

/**
 * <p>
 * Title: QuestionServiceImpl.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月9日
 * @version 1.0
 */
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionMapper questionMapper;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private ConversationalAnalysisService conversationalAnalysisService;

	@Autowired
	private QaCategoryService qaCategoryService;

	@Autowired
	private UserService userService;

	@Override
	public Question insertQuestion(String userId, Integer questionCategoryId, String questionTitle,
			String questionDetail, Integer questionReward, Integer isAnonymous) throws Exception {
		if (StringUtils.isEmpty(questionTitle)) {
			throw new QuestionException("问题标题为空！");
		}
		Question nweQuestion = pretreatmentQuestion(userId, questionCategoryId, questionTitle, questionDetail,
				questionReward, isAnonymous);

		conversationalAnalysisService.analysisAllQaByQuestion(nweQuestion);

		if (nweQuestion != null) {
			List<Answer> answerList = nweQuestion.getAnswerList();
			if (ListUtils.isNotEmpty(answerList)) {
				answerService.insertAnswerList(answerList);
				nweQuestion.setAnswerNumber(answerList.size());
			}
			insertQuestion(nweQuestion);
		}

		return nweQuestion;
	}

	@Override
	public void insertQuestion(Question question) throws Exception {
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
		questionMapper.insert(question);
//			}
//		}).start();
	}

	private Question pretreatmentQuestion(String userId, Integer questionCategoryId, String questionTitle,
			String questionDetail, Integer questionReward, Integer isAnonymous) throws Exception {
		if (StringUtils.isEmpty(userId)) {
			throw new QuestionException("用户对象为空！");
		}

		if (StringUtils.isEmpty(questionTitle)) {
			throw new QuestionException("问题标题为空！");
		}

		Question newQuestion = new Question();
		// 问题搜索对象预处理
		newQuestion.setQuestionId(UUID.randomUUID().toString().replaceAll("-", ""));// 生成id
		newQuestion.setUserId(userId);// 生成发起用户ID
		newQuestion.setUser(userService.selectBasicByPrimaryKey(userId)); // 获取用户信息
		newQuestion.setQuestionCategoryId(questionCategoryId);// 生成分类ID
		newQuestion.setQaCategory(qaCategoryService.selectById(questionCategoryId));// 获取分类信息
		newQuestion.setAdoptionAnswerId("null");
		newQuestion.setQuestionTitle(questionTitle); // 生成问题标题对象
		newQuestion.setQuestionDetail(questionDetail);// 生成问题详细内容对象
		newQuestion.setQuestionReward(questionReward);// 生成问题赏金
		newQuestion.setGenerationDate(new Date());// 生成时间
		newQuestion.setViews(1);// 默认生成访问数量
		newQuestion.setIsFine(0);// 默认生成非加精
		newQuestion.setIsTop(0);// 默认生成非置顶

		isAnonymous = (isAnonymous != null && isAnonymous > 0) ? 1 : 0;
		newQuestion.setIsAnonymous(isAnonymous);// 生成是否匿名

		// 生成分词集，关键词集
		newQuestion.setSplitWordList(WordUtils.getSplitWords(questionTitle));
		newQuestion.setKeywordList(WordUtils.getKeywordWords(questionTitle));

		return newQuestion;

	}

	private Integer getCount(QuestionExample questionExample, String userId, Integer questionCategoryId,
			String adoptionAnswerId, Integer isFine, Integer isTop) throws Exception {

		// 默认设定
		questionExample = questionExample != null ? questionExample : new QuestionExample();
		userId = (StringUtils.isNotEmpty(userId)) ? userId : null;
		questionCategoryId = (questionCategoryId != null && questionCategoryId > 0) ? questionCategoryId : -1;
		adoptionAnswerId = (StringUtils.isNotEmpty(adoptionAnswerId)) ? adoptionAnswerId : null;
		isFine = (isFine != null && isFine >= 0) ? ((isFine > 0) ? 1 : 0) : -1;
		isTop = (isTop != null && isTop >= 0) ? ((isTop > 0) ? 1 : 0) : -1;

		if (userId != null || questionCategoryId != null || adoptionAnswerId != null || isFine != -1 || isTop != -1) {

			if (!(questionExample.getOredCriteria() != null && questionExample.getOredCriteria().size() > 0)) {
				questionExample.createCriteria();
			}

			if (userId != null) {
				questionExample.getOredCriteria().get(0).andUserIdEqualTo(userId);
			}

			if (questionCategoryId != -1) {
				questionExample.getOredCriteria().get(0).andQuestionCategoryIdEqualTo(questionCategoryId);
			}

			if (adoptionAnswerId != null) {
				questionExample.getOredCriteria().get(0).andAdoptionAnswerIdEqualTo(adoptionAnswerId);
			}

			if (isFine != -1) {
				questionExample.getOredCriteria().get(0).andIsFineEqualTo(isFine);
			}

			if (isTop != -1) {
				questionExample.getOredCriteria().get(0).andIsTopEqualTo(isTop);
			}

		}

		return questionMapper.countByExample(questionExample);
	}

	/**
	 * 根据question的ID查询question及根据question的ID查询基本User
	 * 
	 * @throws Exception
	 */
	@Override
	public Question selectByQuestionId(String questionId) throws Exception {
		Question question = questionMapper.selectByPrimaryKey(questionId);

		if (question != null) {

			// 获取采纳答案信息
			if (StringUtils.isNotEmpty(question.getAdoptionAnswerId())) {
				Answer adoptionAnswer = answerService.selectAnswerById(question.getAdoptionAnswerId());
				question.setAdoptionAnswer(adoptionAnswer);
			}

			// 获取回帖信息
			List<Answer> answerList = answerService.selectBasicByQuestionId(questionId);
			question.setAnswerList(answerList);
			// 获取回帖数量
			question.setAnswerNumber(answerList.size());

			// 获取用户信息
			User user = userService.selectBasicByPrimaryKey(question.getUserId());
			question.setUser(user);

			// 获取分类信息
			QaCategory qaCategory = qaCategoryService.selectById(question.getQuestionCategoryId());
			question.setQaCategory(qaCategory);

			/*
			 * 更新访问量
			 */
			updateViewsByQuestionId(questionId);
		}
		return question;
	}

	private void updateViewsByQuestionId(String questionId) {

	}

	@Override
	public void updateAnswerNumberByQuestionId(String questionId, Integer answerNumber) throws Exception {

	}

	@Override
	public List<Question> selectByViewsDesc(String userId, String adoptionAnswerId, Integer questionCategoryId,
			Integer isFine, Integer isTop, Integer number) throws Exception {
		// 按访问量降序
		QuestionExample questionExample = new QuestionExample();
		String fieldName = "views";

		// 添加额外降序条件
		List<Question> questionList = selectByFieldDesc(questionExample, fieldName, userId, questionCategoryId,
				adoptionAnswerId, isFine, isTop, number);

		// 为Question添加其他相关对象
		boolean isUser = true, isCategory = true;
		getOtherRelatedObject(questionList, isUser, isCategory);

		return questionList;
	}

	@Override
	public List<Question> selectByAnswerNumberDesc(String userId, String adoptionAnswerId, Integer questionCategoryId,
			Integer isFine, Integer isTop, Integer number) throws Exception { // 按回答数量降序

		userId = (StringUtils.isNotEmpty(userId)) ? userId : null;
		questionCategoryId = (questionCategoryId != null && questionCategoryId >= 0) ? questionCategoryId : null;
		adoptionAnswerId = (StringUtils.isNotEmpty(adoptionAnswerId)) ? adoptionAnswerId : null;
		isFine = (isFine != null && isFine >= 0) ? ((isFine > 0) ? 1 : 0) : -1;
		isTop = (isTop != null && isTop >= 0) ? ((isTop > 0) ? 1 : 0) : -1;
		number = (number != null && number >= 0) ? number : -1;

		QuestionExample questionExample = null;

		if (userId != null || questionCategoryId != null || adoptionAnswerId != null || isFine != -1 || isTop != -1) {
			questionExample = new QuestionExample();
			questionExample.createCriteria();

			if (userId != null) {
				questionExample.getOredCriteria().get(0).andUserIdEqualTo(userId);
			}
			if (questionCategoryId != null) {
				questionExample.getOredCriteria().get(0).andQuestionCategoryIdEqualTo(questionCategoryId);
			}
			if (adoptionAnswerId != null) {
				questionExample.getOredCriteria().get(0).andAdoptionAnswerIdEqualTo(adoptionAnswerId);
			}
			if (isFine != -1) {
				questionExample.getOredCriteria().get(0).andIsFineEqualTo(isFine);
			}
			if (isTop != -1) {
				questionExample.getOredCriteria().get(0).andIsTopEqualTo(isTop);
			}
		}

		if (number != -1) {
			questionExample.setStartRow(0);
			questionExample.setPageSize(number);
		}

		// 添加额外降序条件
		List<Question> questionList = questionMapper.selectAnswerNumberByExample(questionExample);

		// 为Question添加其他相关对象
		boolean isUser = true, isCategory = true;
		getOtherRelatedObject(questionList, isUser, isCategory);

		return questionList;
	}

	@Override
	public List<Question> selectByGenerationDateDesc(String userId, String adoptionAnswerId, Integer questionCategoryId,
			Integer isFine, Integer isTop, Integer number) throws Exception {
		// 按生成时间降序
		QuestionExample questionExample = new QuestionExample();
		String fieldName = "generation_date";

		// 添加额外降序条件
		List<Question> questionList = selectByFieldDesc(questionExample, fieldName, userId, questionCategoryId,
				adoptionAnswerId, isFine, isTop, number);

		// 为Question添加其他相关对象
		boolean isUser = true, isCategory = true;
		getOtherRelatedObject(questionList, isUser, isCategory);

		return questionList;
	}

	/**
	 * 
	 * <p>
	 * Title: getOtherRelatedObject
	 * </p>
	 * <p>
	 * Description: 为QuestionList添加其他相关对象
	 * </p>
	 * 
	 * @param questionList
	 * @param isUser
	 * @param isCategory
	 * @throws Exception
	 */
	private void getOtherRelatedObject(List<Question> questionList, boolean isUser, boolean isCategory)
			throws Exception {
		if (ListUtils.isNotEmpty(questionList)) {
			for (Question question : questionList) {
				if (isUser) {
					// 获取用户信息
					question.setUser(userService.selectBasicByPrimaryKey(question.getUserId()));
				}
				
				if (isCategory) {
					// 获取分类信息
					question.setQaCategory(qaCategoryService.selectById(question.getQuestionCategoryId()));
				}
			}
		}
	}

	/**
	 * 
	 * <p>
	 * Title: selectByFieldDesc
	 * </p>
	 * <p>
	 * Description: 添加额外降序条件
	 * </p>
	 * 
	 * @param questionExample
	 * @param fieldName
	 * @param userId
	 * @param questionCategoryId
	 * @param adoptionAnswerId
	 * @param isFine
	 * @param isTop
	 * @param number
	 * @return
	 * @throws Exception
	 */
	private List<Question> selectByFieldDesc(QuestionExample questionExample, String fieldName, String userId,
			Integer questionCategoryId, String adoptionAnswerId, Integer isFine, Integer isTop, Integer number)
			throws Exception {
		// 默认设定
		questionExample = questionExample != null ? questionExample : new QuestionExample();
		fieldName = (StringUtils.isNotEmpty(fieldName)) ? fieldName : "search_date";
		userId = (StringUtils.isNotEmpty(userId)) ? userId : null;
		questionCategoryId = (questionCategoryId != null && questionCategoryId >= 0) ? questionCategoryId : null;
		adoptionAnswerId = (StringUtils.isNotEmpty(adoptionAnswerId)) ? adoptionAnswerId : null;
		isFine = (isFine != null && isFine >= 0) ? ((isFine > 0) ? 1 : 0) : -1;
		isTop = (isTop != null && isTop >= 0) ? ((isTop > 0) ? 1 : 0) : -1;
		number = (number != null && number >= 0) ? number : -1;

		questionExample.setOrderByClause("`" + fieldName + "` DESC, question_id DESC");

		if (userId != null || questionCategoryId != null || adoptionAnswerId != null || isFine != -1 || isTop != -1) {
			if (questionExample.getOredCriteria() == null || questionExample.getOredCriteria().size() == 0
					|| questionExample.getOredCriteria().get(0) == null) {
				questionExample.createCriteria();
			}

			if (userId != null) {
				questionExample.getOredCriteria().get(0).andUserIdEqualTo(userId);
			}
			if (questionCategoryId != null) {
				questionExample.getOredCriteria().get(0).andQuestionCategoryIdEqualTo(questionCategoryId);
			}
			if (adoptionAnswerId != null) {
				questionExample.getOredCriteria().get(0).andAdoptionAnswerIdEqualTo(adoptionAnswerId);
			}
			if (isFine != -1) {
				questionExample.getOredCriteria().get(0).andIsFineEqualTo(isFine);
			}
			if (isTop != -1) {
				questionExample.getOredCriteria().get(0).andIsTopEqualTo(isTop);
			}
		}

		if (number != -1) {
			questionExample.setStartRow(0);
			questionExample.setPageSize(number);
		}

		return questionMapper.selectByExample(questionExample);

	}

	@Override
	public List<Question> selectByLikeSearchQuestion(String searchQuestion) throws Exception {
		QuestionExample questionExample = new QuestionExample();
		questionExample.createCriteria();

		if (StringUtils.isNotEmpty(searchQuestion)) {
			List<String> keywordList = WordUtils.getKeywordWords(searchQuestion);

			for (String keyword : keywordList) {
				questionExample.getOredCriteria().get(0).andQuestionTitleLike("%" + keyword + "%");
			}
		}

		/*
		 * 后期按类型排序
		 */
		String userId = null, adoptionAnswerId = null;
		Integer questionCategoryId = null;
		int isFine = -1, isTop = -1, number = -1;
		String fieldName = "generation_date";
		// 添加额外降序条件
		List<Question> questionList = selectByFieldDesc(questionExample, fieldName, userId, questionCategoryId,
				adoptionAnswerId, isFine, isTop, number);

		// 为Question添加其他相关对象
		boolean isUser = true, isCategory = true;
		getOtherRelatedObject(questionList, isUser, isCategory);
		return questionList;
	}

	@Override
	public List<Question> selectQuestionSearchInfo(Question question, PageModel pageModel, String startTime,
			String endTime) throws Exception {
		/** 当前需要分页的总数据条数  */
		QuestionExample example = new QuestionExample();
		// 时间约束
		if (StringUtils.isNotEmpty(startTime) || StringUtils.isNotEmpty(endTime)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			example.createCriteria();
			if (StringUtils.isNotEmpty(startTime)) {
				System.out.println();
				example.getOredCriteria().get(0).andGenerationDateGreaterThanOrEqualTo(sdf.parse(startTime));
			}
			if (StringUtils.isNotEmpty(endTime)) {
				example.getOredCriteria().get(0).andGenerationDateLessThan(sdf.parse(endTime));
			}
		}

		int recordCount = getCount(null, null, null, null, -1, -1);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return questionMapper.selectByExample(example);
		} else {
			return new ArrayList<Question>();
		}
	}

	@Override
	public Map<Object, Long> selectMaxQuestionNumberQaCategory(Integer qaCategoryId, Integer number) throws Exception {
		number = (number != null) ? number : 5;

		Map<Object, Long> questionNumberMap = null;

		QuestionExample questionExample = new QuestionExample();
		if (number > 0) {
			questionExample.setStartRow(0);
			questionExample.setPageSize(number);
		}
		if (qaCategoryId != null && qaCategoryId > 0) {
			questionExample.createCriteria().andQuestionCategoryIdEqualTo(qaCategoryId);
		}

		List<Map<Object, Long>> questionNumberMapList = questionMapper.selectCategoryNumberByExample(questionExample);

		if (ListUtils.isNotEmpty(questionNumberMapList)) {
			questionNumberMap = new HashMap<Object, Long>();
			for (Map<Object, Long> map : questionNumberMapList) {
				Object mapEntryQaCategoryId = map.get("questionCategoryId");
				if (mapEntryQaCategoryId != null) {
					Long mapEntryNumber = map.get("qaCategoryNumber");
					questionNumberMap.put(mapEntryQaCategoryId, mapEntryNumber);
				}

			}
		}
		return questionNumberMap;
	}

}
