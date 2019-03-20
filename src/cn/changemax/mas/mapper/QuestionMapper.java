package cn.changemax.mas.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.Question;
import cn.changemax.mas.po.QuestionExample;

public interface QuestionMapper {
	int countByExample(QuestionExample example);

	int deleteByExample(QuestionExample example);

	int deleteByPrimaryKey(String questionId);

	int insert(Question record);

	int insertSelective(Question record);

	List<Map<Object, Long>> selectCategoryNumberByExample(QuestionExample example);

	List<Question> selectAnswerNumberByExample(QuestionExample example);

	List<Question> selectByExample(QuestionExample example);

	Question selectByPrimaryKey(String questionId);

	int updateViewsByQuestionId(String questionId);

	int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

	int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

	int updateByPrimaryKeySelective(Question record);

	int updateByPrimaryKey(Question record);
}