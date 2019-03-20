package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.Text;
import cn.changemax.mas.po.TextExample;

public interface TextMapper {
    int countByExample(TextExample example);

    int deleteByExample(TextExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Text record);

    int insertSelective(Text record);

    List<Text> selectByExample(TextExample example);

    Text selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Text record, @Param("example") TextExample example);

    int updateByExample(@Param("record") Text record, @Param("example") TextExample example);

    int updateByPrimaryKeySelective(Text record);

    int updateByPrimaryKey(Text record);
}