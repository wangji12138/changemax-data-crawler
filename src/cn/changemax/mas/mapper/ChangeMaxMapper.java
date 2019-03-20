package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.ChangeMax;
import cn.changemax.mas.po.ChangeMaxExample;

public interface ChangeMaxMapper {
    int countByExample(ChangeMaxExample example);

    int deleteByExample(ChangeMaxExample example);

    int deleteByPrimaryKey(Integer changeMaxId);

    int insert(ChangeMax record);

    int insertSelective(ChangeMax record);

    List<ChangeMax> selectByExample(ChangeMaxExample example);

    ChangeMax selectByPrimaryKey(Integer changeMaxId);

    int updateByExampleSelective(@Param("record") ChangeMax record, @Param("example") ChangeMaxExample example);

    int updateByExample(@Param("record") ChangeMax record, @Param("example") ChangeMaxExample example);

    int updateByPrimaryKeySelective(ChangeMax record);

    int updateByPrimaryKey(ChangeMax record);
}