package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.QaAi;
import cn.changemax.mas.po.QaAiExample;
import cn.changemax.mas.po.QaAiKey;

public interface QaAiMapper {
    int countByExample(QaAiExample example);

    int deleteByExample(QaAiExample example);

    int deleteByPrimaryKey(QaAiKey key);

    int insert(QaAi record);

    int insertSelective(QaAi record);

    List<QaAi> selectByExample(QaAiExample example);

    QaAi selectByPrimaryKey(QaAiKey key);

    int updateByExampleSelective(@Param("record") QaAi record, @Param("example") QaAiExample example);

    int updateByExample(@Param("record") QaAi record, @Param("example") QaAiExample example);

    int updateByPrimaryKeySelective(QaAi record);

    int updateByPrimaryKey(QaAi record);
}