package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.BdzdQa;
import cn.changemax.mas.po.BdzdQaExample;

public interface BdzdQaMapper {
    int countByExample(BdzdQaExample example);

    int deleteByExample(BdzdQaExample example);

    int deleteByPrimaryKey(String url);

    int insert(BdzdQa record);

    int insertSelective(BdzdQa record);

    List<BdzdQa> selectByExampleWithBLOBs(BdzdQaExample example);

    List<BdzdQa> selectByExample(BdzdQaExample example);

    BdzdQa selectByPrimaryKey(String url);

    int updateByExampleSelective(@Param("record") BdzdQa record, @Param("example") BdzdQaExample example);

    int updateByExampleWithBLOBs(@Param("record") BdzdQa record, @Param("example") BdzdQaExample example);

    int updateByExample(@Param("record") BdzdQa record, @Param("example") BdzdQaExample example);

    int updateByPrimaryKeySelective(BdzdQa record);

    int updateByPrimaryKeyWithBLOBs(BdzdQa record);

    int updateByPrimaryKey(BdzdQa record);
}