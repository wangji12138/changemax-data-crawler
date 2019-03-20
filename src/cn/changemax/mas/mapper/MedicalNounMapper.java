package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.MedicalNounExample;
import cn.changemax.mas.po.MedicalNounKey;

public interface MedicalNounMapper {
    int countByExample(MedicalNounExample example);

    int deleteByExample(MedicalNounExample example);

    int deleteByPrimaryKey(MedicalNounKey key);

    int insert(MedicalNounKey record);

    int insertSelective(MedicalNounKey record);

    List<MedicalNounKey> selectByExample(MedicalNounExample example);

    int updateByExampleSelective(@Param("record") MedicalNounKey record, @Param("example") MedicalNounExample example);

    int updateByExample(@Param("record") MedicalNounKey record, @Param("example") MedicalNounExample example);
}