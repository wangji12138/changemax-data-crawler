package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.exception.UserException;
import cn.changemax.mas.mapper.UserMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.Question;
import cn.changemax.mas.po.User;
import cn.changemax.mas.po.UserExample;
import cn.changemax.mas.service.AnswerService;
import cn.changemax.mas.service.QuestionService;
import cn.changemax.mas.service.UserService;
import cn.changemax.mas.utils.ListUtils;

/**
 * <p>
 * Title: UserServiceImpl.java
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
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@Override
	public User insertUser(User user) throws Exception {
		if (user == null) {
			throw new UserException("注册对象为空！");
		}
		user.setUserRegistrationTime(new Date());

		int result = userMapper.insert(user);

		if (result != 0) {
			user = null;
		}

		return user;
	}

	@Override
	public Integer updateUserAnswerNumberByUserId(String userId, Integer answerNumber) throws Exception {
		return userMapper.updateUserAnswerNumberByUserId(userId, answerNumber);
	}

	@Override
	public Integer updateUserQuestionNumberByUserId(String userId, Integer questionNumber) throws Exception {
		return userMapper.updateUserQuestionNumberByUserId(userId, questionNumber);
	}

	@Override
	public User selectByUsernameAndPassword(String username, String password) throws Exception {

		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<User> userList = userMapper.selectByExample(example);
		if (ListUtils.isNotEmpty(userList)) {
			if (userList.size() >= 2) {
				throw new UserException("用户ID重复出现！");
			}
			return userList.get(0);
		}
		return null;
	}

	@Override
	public List<User> selectUserSearchInfo(User user, PageModel pageModel) throws Exception {
		/** 当前需要分页的总数据条数  */
		UserExample example = new UserExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return userMapper.selectByExample(example);
		} else {
			return new ArrayList<User>();
		}
	}

	@Override
	public int getCount(UserExample example) throws Exception {
		return userMapper.countByExample(example);
	}

	/**
	 * 简要信息
	 */
	@Override
	public User selectDetailByUserId(String userId) throws Exception {
		User user = userMapper.selectIntroductionByPrimaryKey(userId);
		if (user != null) {
			// 获取用户下加精问题
			List<Question> fineQuestionList = questionService.selectByGenerationDateDesc(userId, null, null, 1, -1, -1);

			// 获取用户下置顶问题
			List<Question> topQuestionList = questionService.selectByGenerationDateDesc(userId, null, null, -1, 1, -1);

			// 获取用户下普通问题
			List<Question> ordinaryQuestionList = questionService.selectByGenerationDateDesc(userId, null, null, 0, 0,
					-1);

			// 获取用户下被采纳答案
			List<Answer> adoptionAnswerList = answerService.selectByGenerationDateDesc(userId, null, null, 1);

			// 获取用户下普通答案
			List<Answer> ordinaryAnswerList = answerService.selectByGenerationDateDesc(userId, null, null, 0);

		}

		return user;
	}

	/**
	 * 基本信息：id，用户名称，头像路径
	 */
	@Override
	public User selectBasicByPrimaryKey(String userId) throws Exception {
		return userMapper.selectBasicByPrimaryKey(userId);
	}

	@Override
	public User selectByPrimaryKey(String userId) throws Exception {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<User> selectMaxUserAnswerNumber(Integer number) throws Exception {
		number = (number != null && number > 0) ? number : 10;

		List<User> userList = null;
		UserExample example = new UserExample();
		example.setOrderByClause("`user_answer_number` DESC, user_id DESC");
		example.setStartRow(0);
		example.setStartRow(number);

		userList = userMapper.selectBasicByExample(example);

		return userList;
	}

	@Override
	public List<User> selectMaxUserQuestionNumber(Integer number) throws Exception {
		number = (number != null && number > 0) ? number : 10;

		List<User> userList = null;
		UserExample example = new UserExample();
		example.setOrderByClause("`user_question_number` DESC, user_id DESC");
		example.setStartRow(0);
		example.setStartRow(number);

		userList = userMapper.selectBasicByExample(example);

		return userList;
	}

}
