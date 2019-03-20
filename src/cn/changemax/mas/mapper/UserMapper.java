package cn.changemax.mas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.User;
import cn.changemax.mas.po.UserExample;

public interface UserMapper {
	int countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(String userId);

	int insert(User record);

	int insertSelective(User record);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	int updateUserAnswerNumberByUserId(String userId, Integer answerNumber);

	int updateUserQuestionNumberByUserId(String userId, Integer questionNumber);

	List<User> selectBasicByExample(UserExample example);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(String userId);

	User selectBasicByPrimaryKey(String userId);

	User selectIntroductionByPrimaryKey(String userId);

}