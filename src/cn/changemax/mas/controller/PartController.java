package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Part;
import cn.changemax.mas.service.PartService;

/**
 * <p>
 * Title: TPartController.java
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
@RequestMapping("/part")
public class PartController {
	@Autowired
	private PartService partService;

	@RequestMapping(value = "/listPart", method = { RequestMethod.POST, RequestMethod.GET })
	public String listPart(Integer pageSize, Integer pageIndex, Model model, Part part) {
		List<Part> partList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			partList = partService.selectPartSearchInfo(part, pageModel);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("partList", partList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/part/part-list";
	}

	@RequestMapping(value = "/showPart", method = { RequestMethod.POST, RequestMethod.GET })
	public String showPart(Integer partId, Model model) {
		Part part = null;
		if (partId != null) {
			try {
				part = partService.selectPartById(partId);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		model.addAttribute("part", part);

		return "/admin/part/part-show";
	}

}
