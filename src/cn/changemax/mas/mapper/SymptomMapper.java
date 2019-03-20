package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.Symptom;
import cn.changemax.mas.po.SymptomExample;
import cn.changemax.mas.po.SymptomWithBLOBs;

public interface SymptomMapper {
    int countByExample(SymptomExample example);

    int deleteByExample(SymptomExample example);

    int deleteByPrimaryKey(String symptomId);

    int insert(SymptomWithBLOBs record);

    int insertSelective(SymptomWithBLOBs record);

    List<SymptomWithBLOBs> selectByExampleWithBLOBs(SymptomExample example);

    List<Symptom> selectByExample(SymptomExample example);

    SymptomWithBLOBs selectByPrimaryKey(String symptomId);

    int updateByExampleSelective(@Param("record") SymptomWithBLOBs record, @Param("example") SymptomExample example);

    int updateByExampleWithBLOBs(@Param("record") SymptomWithBLOBs record, @Param("example") SymptomExample example);

    int updateByExample(@Param("record") Symptom record, @Param("example") SymptomExample example);

    int updateByPrimaryKeySelective(SymptomWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SymptomWithBLOBs record);

    int updateByPrimaryKey(Symptom record);
}