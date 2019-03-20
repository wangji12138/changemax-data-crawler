package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.Encyclopedia;
import cn.changemax.mas.po.EncyclopediaExample;
import cn.changemax.mas.po.EncyclopediaKey;

public interface EncyclopediaMapper {
    int countByExample(EncyclopediaExample example);

    int deleteByExample(EncyclopediaExample example);

    int deleteByPrimaryKey(EncyclopediaKey key);

    int insert(Encyclopedia record);

    int insertSelective(Encyclopedia record);

    List<Encyclopedia> selectByExample(EncyclopediaExample example);

    Encyclopedia selectByPrimaryKey(EncyclopediaKey key);

    int updateByExampleSelective(@Param("record") Encyclopedia record, @Param("example") EncyclopediaExample example);

    int updateByExample(@Param("record") Encyclopedia record, @Param("example") EncyclopediaExample example);

    int updateByPrimaryKeySelective(Encyclopedia record);

    int updateByPrimaryKey(Encyclopedia record);
}