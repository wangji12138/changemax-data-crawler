package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.QaRequest;
import cn.changemax.mas.po.QaRequestExample;
import cn.changemax.mas.po.QaResponse;

/**
 * <p>
 * Title: QaRequestService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月1日
 * @version 1.0
 */
public interface QaRequestService {

	void insertQaRequest(QaRequest qaRequest) throws Exception;

	QaResponse getQaResponseByQaRequest(QaRequest qaRequest) throws Exception;

	List<QaRequest> selectQaRequestSearchInfo(QaRequest qaRequest, PageModel pageModel) throws Exception;

	int getCount(QaRequestExample example) throws Exception;

	QaRequest selectByPrimaryKey(String qaRequestId) throws Exception;

}
