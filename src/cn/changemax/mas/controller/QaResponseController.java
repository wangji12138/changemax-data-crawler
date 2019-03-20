package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.QaResponse;
import cn.changemax.mas.service.QaResponseService;

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
@RequestMapping("/qaResponse")
public class QaResponseController {

	@Autowired
	private QaResponseService qaResponseService;

	@RequestMapping(value = "/listQaResponse", method = { RequestMethod.POST, RequestMethod.GET })
	public String listQaResponse(Integer pageSize, Integer pageIndex, Model model, QaResponse qaResponse) {
		List<QaResponse> qaResponseList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			qaResponseList = qaResponseService.selectQaResponseSearchInfo(qaResponse, pageModel);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("qaResponseList", qaResponseList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/qaResponse/qaResponse-list";
	}

}
