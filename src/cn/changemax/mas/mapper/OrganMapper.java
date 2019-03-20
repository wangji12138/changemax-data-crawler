package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.Organ;
import cn.changemax.mas.po.OrganExample;

public interface OrganMapper {
    int countByExample(OrganExample example);

    int deleteByExample(OrganExample example);

    int deleteByPrimaryKey(Integer organId);

    int insert(Organ record);

    int insertSelective(Organ record);

    List<Organ> selectByExample(OrganExample example);

    Organ selectByPrimaryKey(Integer organId);

    int updateByExampleSelective(@Param("record") Organ record, @Param("example") OrganExample example);

    int updateByExample(@Param("record") Organ record, @Param("example") OrganExample example);

    int updateByPrimaryKeySelective(Organ record);

    int updateByPrimaryKey(Organ record);
}