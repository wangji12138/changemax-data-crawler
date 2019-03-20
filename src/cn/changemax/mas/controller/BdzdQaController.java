package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.BdzdQa;
import cn.changemax.mas.service.BdzdQaService;
import cn.changemax.mas.utils.StringUtils;

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
@RequestMapping("/bdzdQa")
public class BdzdQaController {
	@Autowired
	private BdzdQaService bdzdQaService;

	@RequestMapping(value = "/listBdzdQa", method = { RequestMethod.POST, RequestMethod.GET })
	public String listBdzdQa(Integer pageSize, Integer pageIndex, Model model, BdzdQa bdzdQa) {
		List<BdzdQa> bdzdQaList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null && pageSize > 1 && pageSize < 30) {
			pageModel.setPageSize((pageSize > 30) ? 30 : pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			bdzdQaList = bdzdQaService.selectBdzdQaSearchInfo(bdzdQa, pageModel);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("bdzdQaList", bdzdQaList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/bdzdQa/bdzdQa-list";
	}

	@RequestMapping(value = "/detailedBdzdQa", method = { RequestMethod.POST, RequestMethod.GET })
	public String detailedBdzdQa(String url, Model model) {
		BdzdQa bdzdQa = null;
		if (StringUtils.isNotEmpty(url)) {
			try {
				bdzdQa = bdzdQaService.selectBdzdQaByKey(url);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		model.addAttribute("bdzdQa", bdzdQa);

		return "/admin/bdzdQa/detailed";
	}

}
