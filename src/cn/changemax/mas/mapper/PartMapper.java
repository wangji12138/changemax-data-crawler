package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.Part;
import cn.changemax.mas.po.PartExample;

public interface PartMapper {
    int countByExample(PartExample example);

    int deleteByExample(PartExample example);

    int deleteByPrimaryKey(Integer partId);

    int insert(Part record);

    int insertSelective(Part record);

    List<Part> selectByExample(PartExample example);

    Part selectByPrimaryKey(Integer partId);

    int updateByExampleSelective(@Param("record") Part record, @Param("example") PartExample example);

    int updateByExample(@Param("record") Part record, @Param("example") PartExample example);

    int updateByPrimaryKeySelective(Part record);

    int updateByPrimaryKey(Part record);
}