package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.mapper.QaResponseMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.ChangeMax;
import cn.changemax.mas.po.QaRequest;
import cn.changemax.mas.po.QaResponse;
import cn.changemax.mas.po.QaResponseExample;
import cn.changemax.mas.service.ChangeMaxService;
import cn.changemax.mas.service.ConversationalAnalysisService;
import cn.changemax.mas.service.QaResponseService;

/**
 * <p>
 * Title: QaRequestServiceImpl.java
 * </p>
 * <p>
 * Description:医疗数据响应分析
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月1日
 * @version 1.0
 */
public class QaResponseServiceImpl implements QaResponseService {
	@Autowired
	private ChangeMaxService changeMaxService;

	@Autowired
	private ConversationalAnalysisService conversationalAnalysisService;

	@Autowired
	private QaResponseMapper qaResponseMapper;

	@Override
	public QaResponse getQaResponseByQaRequest(QaRequest qaRequest) throws Exception {
		System.err.println(qaRequest.getQaRequestId());

		// 获取changemax对象
		ChangeMax qaResponseChangeMax = changeMaxService.selectChangeMaxByUserId(qaRequest.getQaRequestUserId());// 通过用户请求对象中的用户id获取对应的changemax对象
		QaResponse newQaResponse = new QaResponse(qaResponseChangeMax.getChangeMaxId() + "");// 生成响应对象

		boolean isSuccessfulAnalysis = conversationalAnalysisService.conversationalAnalysisPortal(newQaResponse,
				qaRequest);

		if (isSuccessfulAnalysis) {
			insertQaResponse(newQaResponse);
			return newQaResponse;
		} else {
			return null;
		}

	}

	/**
	 * 插入qa响应对象
	 */
	@Override
	public void insertQaResponse(QaResponse qaResponse) throws Exception {
		new Thread(new Runnable() {

			@Override
			public void run() {
				qaResponseMapper.insert(qaResponse);
			}
		}).start();

	}

	@Override
	public List<QaResponse> selectQaResponseSearchInfo(QaResponse qaResponse, PageModel pageModel) throws Exception {
		/** 当前需要分页的总数据条数  */
		QaResponseExample example = new QaResponseExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return qaResponseMapper.selectByExample(example);
		} else {
			return new ArrayList<QaResponse>();
		}
	}

	@Override
	public int getCount(QaResponseExample example) throws Exception {
		return qaResponseMapper.countByExample(example);
	}

	@Override
	public QaResponse selectByPrimaryKey(String qaResponseId) throws Exception {
		return qaResponseMapper.selectByPrimaryKey(qaResponseId);
	}

}
