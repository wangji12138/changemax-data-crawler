package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.QaRequest;
import cn.changemax.mas.po.QaResponse;
import cn.changemax.mas.po.QaResponseExample;

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
public interface QaResponseService {

	QaResponse getQaResponseByQaRequest(QaRequest request) throws Exception;

	void insertQaResponse(QaResponse qaResponse) throws Exception;

	List<QaResponse> selectQaResponseSearchInfo(QaResponse qaResponse, PageModel pageModel) throws Exception;

	int getCount(QaResponseExample example) throws Exception;

	QaResponse selectByPrimaryKey(String qaResponseId) throws Exception;

}
