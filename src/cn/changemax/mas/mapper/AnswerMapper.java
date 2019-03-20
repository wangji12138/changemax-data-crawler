package cn.changemax.mas.mapper;

import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.AnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnswerMapper {
	int countByExample(AnswerExample example);

	int deleteByExample(AnswerExample example);

	int deleteByPrimaryKey(String answerId);

	int insert(Answer record);

	int insertSelective(Answer record);

	List<Answer> selectByExampleWithBLOBs(AnswerExample example);

	List<Answer> selectByExample(AnswerExample example);

	Answer selectByPrimaryKey(String answerId);

	int updateByExampleSelective(@Param("record") Answer record, @Param("example") AnswerExample example);

	int updateByExampleWithBLOBs(@Param("record") Answer record, @Param("example") AnswerExample example);

	int updateByExample(@Param("record") Answer record, @Param("example") AnswerExample example);

	int updateByPrimaryKeySelective(Answer record);

	int updateByPrimaryKeyWithBLOBs(Answer record);

	int updateByPrimaryKey(Answer record);

	int updateGoodNumberByAnswerId(String answerId, Integer goodNumber);

	int updateBadNumberByAnswerId(String answerId, Integer badNumber);

}