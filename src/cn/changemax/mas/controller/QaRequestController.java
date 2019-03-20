package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.QaRequest;
import cn.changemax.mas.po.QaResponse;
import cn.changemax.mas.service.QaRequestService;

/**
 * <p>
 * Title: requestJsonController.java
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
@Controller
@RequestMapping("/qaRequest")
public class QaRequestController {

	@Autowired
	private QaRequestService qaRequestService;

	@RequestMapping(value = "/listQaRequest", method = { RequestMethod.POST, RequestMethod.GET })
	public String listQaRequest(Integer pageSize, Integer pageIndex, Model model, QaRequest qaRequest) {
		List<QaRequest> qaRequestList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			qaRequestList = qaRequestService.selectQaRequestSearchInfo(qaRequest, pageModel);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("qaRequestList", qaRequestList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/qaRequest/qaRequest-list";
	}

	/**
	 * 
	 * <p>
	 * Title: qaRequestTestPage
	 * </p>
	 * <p>
	 * Description:对话式简单请求响应
	 * </p>
	 * 
	 * @param qaRequest
	 * @return
	 */
	@RequestMapping(value = "/getQaResponseByQaRequest", method = RequestMethod.POST)
	public @ResponseBody QaResponse getQaResponseByQaRequest(@RequestBody(required = false) QaRequest qaRequest) {
		// 获取校验错误信息
		long start = System.currentTimeMillis();
		QaResponse qaResponse = null;
		try {
			qaResponse = qaRequestService.getQaResponseByQaRequest(qaRequest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.err.println(qaResponse.getQaResponseTextList().get(0).getTextContent());

		long end = System.currentTimeMillis();
		Double cha = new Double(end - start);

		System.err.println("耗时(秒)：" + (cha /= 1000));
		return qaResponse;
	}

}
