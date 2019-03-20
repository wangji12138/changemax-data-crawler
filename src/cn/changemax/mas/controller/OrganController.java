package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Organ;
import cn.changemax.mas.service.OrganService;

/**
 * <p>
 * Title: TOrganController.java
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
@RequestMapping("/organ")
public class OrganController {
	@Autowired
	private OrganService organService;

	@RequestMapping(value = "/listOrgan", method = { RequestMethod.POST, RequestMethod.GET })
	public String listOrgan(Integer pageSize, Integer pageIndex, Model model, Organ organ) {
		List<Organ> organList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			organList = organService.selectOrganSearchInfo(organ, pageModel);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		model.addAttribute("organList", organList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/organ/organ-list";
	}

	@RequestMapping(value = "/detailedOrgan", method = { RequestMethod.POST, RequestMethod.GET })
	public String detailedOrgan(Integer organId, Model model) {
		Organ organ = null;
		if (organId != null) {
			try {
				organ = organService.selectByPrimaryKey(organId);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		model.addAttribute("organ", organ);

		return "/admin/organ/detailed";
	}

}
