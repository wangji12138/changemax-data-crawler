package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.OrganSymptom;
import cn.changemax.mas.po.OrganSymptomExample;

public interface OrganSymptomMapper {
    int countByExample(OrganSymptomExample example);

    int deleteByExample(OrganSymptomExample example);

    int deleteByPrimaryKey(Integer organSymptomId);

    int insert(OrganSymptom record);

    int insertSelective(OrganSymptom record);

    List<OrganSymptom> selectByExample(OrganSymptomExample example);

    OrganSymptom selectByPrimaryKey(Integer organSymptomId);

    int updateByExampleSelective(@Param("record") OrganSymptom record, @Param("example") OrganSymptomExample example);

    int updateByExample(@Param("record") OrganSymptom record, @Param("example") OrganSymptomExample example);

    int updateByPrimaryKeySelective(OrganSymptom record);

    int updateByPrimaryKey(OrganSymptom record);
}