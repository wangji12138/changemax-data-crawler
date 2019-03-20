package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.OrganDisease;
import cn.changemax.mas.po.OrganDiseaseExample;

public interface OrganDiseaseMapper {
    int countByExample(OrganDiseaseExample example);

    int deleteByExample(OrganDiseaseExample example);

    int deleteByPrimaryKey(Integer organDiseaseId);

    int insert(OrganDisease record);

    int insertSelective(OrganDisease record);

    List<OrganDisease> selectByExample(OrganDiseaseExample example);

    OrganDisease selectByPrimaryKey(Integer organDiseaseId);

    int updateByExampleSelective(@Param("record") OrganDisease record, @Param("example") OrganDiseaseExample example);

    int updateByExample(@Param("record") OrganDisease record, @Param("example") OrganDiseaseExample example);

    int updateByPrimaryKeySelective(OrganDisease record);

    int updateByPrimaryKey(OrganDisease record);
}