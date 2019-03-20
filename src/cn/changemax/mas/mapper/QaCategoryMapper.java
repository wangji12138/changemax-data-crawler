package cn.changemax.mas.mapper;

import cn.changemax.mas.po.QaCategory;
import cn.changemax.mas.po.QaCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QaCategoryMapper {
	int countByExample(QaCategoryExample example);

	int deleteByExample(QaCategoryExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(QaCategory record);

	int insertSelective(QaCategory record);

	List<QaCategory> selectByExample(QaCategoryExample example);

	QaCategory selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") QaCategory record, @Param("example") QaCategoryExample example);

	int updateByExample(@Param("record") QaCategory record, @Param("example") QaCategoryExample example);

	int updateByPrimaryKeySelective(QaCategory record);

	int updateByPrimaryKey(QaCategory record);
}