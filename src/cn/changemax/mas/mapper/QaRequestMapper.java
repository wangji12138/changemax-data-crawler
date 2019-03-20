package cn.changemax.mas.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.changemax.mas.po.QaRequest;
import cn.changemax.mas.po.QaRequestExample;

public interface QaRequestMapper {
    int countByExample(QaRequestExample example);

    int deleteByExample(QaRequestExample example);

    int deleteByPrimaryKey(String qaRequestId);

    int insert(QaRequest record);

    int insertSelective(QaRequest record);

    List<QaRequest> selectByExample(QaRequestExample example);

    QaRequest selectByPrimaryKey(String qaRequestId);

    int updateByExampleSelective(@Param("record") QaRequest record, @Param("example") QaRequestExample example);

    int updateByExample(@Param("record") QaRequest record, @Param("example") QaRequestExample example);

    int updateByPrimaryKeySelective(QaRequest record);

    int updateByPrimaryKey(QaRequest record);
}