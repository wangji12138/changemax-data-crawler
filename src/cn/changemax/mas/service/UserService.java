package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.User;
import cn.changemax.mas.po.UserExample;

/**
 * <p>
 * Title: UserService.java
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
public interface UserService {

	User insertUser(User user) throws Exception;

	User selectByUsernameAndPassword(String username, String password) throws Exception;

	Integer updateUserAnswerNumberByUserId(String userId, Integer answerNumbers) throws Exception;

	Integer updateUserQuestionNumberByUserId(String userId, Integer questionsNumber) throws Exception;

	List<User> selectMaxUserAnswerNumber(Integer number) throws Exception;

	List<User> selectMaxUserQuestionNumber(Integer number) throws Exception;

	List<User> selectUserSearchInfo(User user, PageModel pageModel) throws Exception;

	int getCount(UserExample example) throws Exception;

	User selectBasicByPrimaryKey(String userId) throws Exception;

	User selectByPrimaryKey(String userId) throws Exception;

	User selectDetailByUserId(String userId) throws Exception;

}
