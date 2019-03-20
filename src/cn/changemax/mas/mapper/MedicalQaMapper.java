package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.MedicalQa;
import cn.changemax.mas.po.MedicalQaExample;

public interface MedicalQaMapper {
    int countByExample(MedicalQaExample example);

    int deleteByExample(MedicalQaExample example);

    int deleteByPrimaryKey(Integer qaId);

    int insert(MedicalQa record);

    int insertSelective(MedicalQa record);

    List<MedicalQa> selectByExampleWithBLOBs(MedicalQaExample example);

    List<MedicalQa> selectByExample(MedicalQaExample example);

    MedicalQa selectByPrimaryKey(Integer qaId);

    int updateByExampleSelective(@Param("record") MedicalQa record, @Param("example") MedicalQaExample example);

    int updateByExampleWithBLOBs(@Param("record") MedicalQa record, @Param("example") MedicalQaExample example);

    int updateByExample(@Param("record") MedicalQa record, @Param("example") MedicalQaExample example);

    int updateByPrimaryKeySelective(MedicalQa record);

    int updateByPrimaryKeyWithBLOBs(MedicalQa record);

    int updateByPrimaryKey(MedicalQa record);
}