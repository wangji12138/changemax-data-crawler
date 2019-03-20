package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.MedicalVideo;
import cn.changemax.mas.po.MedicalVideoExample;

public interface MedicalVideoMapper {
    int countByExample(MedicalVideoExample example);

    int deleteByExample(MedicalVideoExample example);

    int deleteByPrimaryKey(Integer videoId);

    int insert(MedicalVideo record);

    int insertSelective(MedicalVideo record);

    List<MedicalVideo> selectByExample(MedicalVideoExample example);

    MedicalVideo selectByPrimaryKey(Integer videoId);

    int updateByExampleSelective(@Param("record") MedicalVideo record, @Param("example") MedicalVideoExample example);

    int updateByExample(@Param("record") MedicalVideo record, @Param("example") MedicalVideoExample example);

    int updateByPrimaryKeySelective(MedicalVideo record);

    int updateByPrimaryKey(MedicalVideo record);
}