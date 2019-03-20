package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.ChangeMax;
import cn.changemax.mas.service.ChangeMaxService;
import cn.changemax.mas.utils.StringUtils;

/**
 * <p>
 * Title: TChangeMaxController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年11月29日
 * @version 1.0
 */
@Controller
//为了对url进行分类管理，可以在这里定义根路径，最终访问url是根路径+子路径
@RequestMapping("/changeMax")
public class ChangeMaxController {
	@Autowired
	private ChangeMaxService changeMaxService;

	@RequestMapping(value = "/listChangeMax", method = { RequestMethod.POST, RequestMethod.GET })
	public String listChangeMax(Integer pageSize, Integer pageIndex, Model model, ChangeMax changeMax) {
		List<ChangeMax> changeMaxList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			changeMaxList = changeMaxService.selectChangeMaxSearchInfo(changeMax, pageModel);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("changeMaxList", changeMaxList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/changeMax/changeMax-list";
	}

	@RequestMapping(value = "/detailedChangeMax", method = { RequestMethod.POST, RequestMethod.GET })
	public String detailedChangeMax(String changeMaxId, Model model) {
		ChangeMax changeMax = null;
		if (StringUtils.isNotEmpty(changeMaxId)) {
			try {
				changeMax = changeMaxService.selectByPrimaryKey(Integer.parseInt(changeMaxId));
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		model.addAttribute("changeMax", changeMax);

		return "/admin/changeMax/detailed";
	}

}
