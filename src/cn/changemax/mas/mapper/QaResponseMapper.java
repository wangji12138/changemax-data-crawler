package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.QaResponse;
import cn.changemax.mas.po.QaResponseExample;

public interface QaResponseMapper {
    int countByExample(QaResponseExample example);

    int deleteByExample(QaResponseExample example);

    int deleteByPrimaryKey(String qaResponseId);

    int insert(QaResponse record);

    int insertSelective(QaResponse record);

    List<QaResponse> selectByExample(QaResponseExample example);

    QaResponse selectByPrimaryKey(String qaResponseId);

    int updateByExampleSelective(@Param("record") QaResponse record, @Param("example") QaResponseExample example);

    int updateByExample(@Param("record") QaResponse record, @Param("example") QaResponseExample example);

    int updateByPrimaryKeySelective(QaResponse record);

    int updateByPrimaryKey(QaResponse record);
}