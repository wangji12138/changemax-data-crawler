package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.exception.AnalysisException;
import cn.changemax.mas.mapper.QaRequestMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.QaRequest;
import cn.changemax.mas.po.QaRequestExample;
import cn.changemax.mas.po.QaResponse;
import cn.changemax.mas.service.QaRequestService;
import cn.changemax.mas.service.QaResponseService;

/**
 * <p>
 * Title: QaRequestServiceImpl.java
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
public class QaRequestServiceImpl implements QaRequestService {

	@Autowired
	private QaRequestMapper qaRequestMapper;

	@Autowired
	private QaResponseService qaResponseService;

	@Override
	public QaResponse getQaResponseByQaRequest(QaRequest qaRequest) throws Exception {

		if (qaRequest == null) {
			throw new AnalysisException("请求对象为空");
		}
		insertQaRequest(qaRequest);// 保存请求内容
		return qaResponseService.getQaResponseByQaRequest(qaRequest);

	}

	@Override
	public void insertQaRequest(QaRequest qaRequest) throws Exception {
		new Thread(new Runnable() {

			@Override
			public void run() {
				qaRequestMapper.insert(qaRequest);
			}
		}).start();
	}

	@Override
	public List<QaRequest> selectQaRequestSearchInfo(QaRequest qaRequest, PageModel pageModel) throws Exception {
		/** 当前需要分页的总数据条数  */
		QaRequestExample example = new QaRequestExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return qaRequestMapper.selectByExample(example);
		} else {
			return new ArrayList<QaRequest>();
		}
	}

	@Override
	public int getCount(QaRequestExample example) throws Exception {
		return qaRequestMapper.countByExample(example);
	}

	@Override
	public QaRequest selectByPrimaryKey(String qaRequestId) throws Exception {
		return qaRequestMapper.selectByPrimaryKey(qaRequestId);
	}

}
