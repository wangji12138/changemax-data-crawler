package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.Disease;
import cn.changemax.mas.po.DiseaseExample;
import cn.changemax.mas.po.DiseaseWithBLOBs;

public interface DiseaseMapper {
    int countByExample(DiseaseExample example);

    int deleteByExample(DiseaseExample example);

    int deleteByPrimaryKey(String diseaseId);

    int insert(DiseaseWithBLOBs record);

    int insertSelective(DiseaseWithBLOBs record);

    List<DiseaseWithBLOBs> selectByExampleWithBLOBs(DiseaseExample example);

    List<Disease> selectByExample(DiseaseExample example);

    DiseaseWithBLOBs selectByPrimaryKey(String diseaseId);

    int updateByExampleSelective(@Param("record") DiseaseWithBLOBs record, @Param("example") DiseaseExample example);

    int updateByExampleWithBLOBs(@Param("record") DiseaseWithBLOBs record, @Param("example") DiseaseExample example);

    int updateByExample(@Param("record") Disease record, @Param("example") DiseaseExample example);

    int updateByPrimaryKeySelective(DiseaseWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DiseaseWithBLOBs record);

    int updateByPrimaryKey(Disease record);
}