package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Disease;
import cn.changemax.mas.po.DiseaseWithBLOBs;
import cn.changemax.mas.service.DiseaseService;
import cn.changemax.mas.utils.StringUtils;

/**
 * <p>
 * Title: TDiseaseController.java
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
@RequestMapping("/disease")
public class DiseaseController {
	@Autowired
	private DiseaseService diseaseService;

	@RequestMapping(value = "/listDisease", method = { RequestMethod.POST, RequestMethod.GET })
	public String listDisease(Integer pageSize, Integer pageIndex, Model model, Disease disease) {
		List<DiseaseWithBLOBs> diseaseWithBLOBsList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			diseaseWithBLOBsList = diseaseService.selectDiseaseWithBLOBsSearchInfo(disease, pageModel);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("diseaseWithBLOBsList", diseaseWithBLOBsList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/disease/disease-list";
	}

	@RequestMapping(value = "/detailedDisease", method = { RequestMethod.POST, RequestMethod.GET })
	public String detailedDisease(String diseaseId, Model model) {
		Disease disease = null;
		if (StringUtils.isNotEmpty(diseaseId)) {
			try {
				disease = diseaseService.selectByPrimaryKey(diseaseId);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		model.addAttribute("disease", disease);

		return "/admin/disease/detailed";
	}

	@RequestMapping(value = "/showDisease", method = { RequestMethod.POST, RequestMethod.GET })
	public String showDisease(String diseaseId, Model model) {
		Disease disease = null;
		if (StringUtils.isNotEmpty(diseaseId)) {
			try {
				disease = diseaseService.selectByPrimaryKey(diseaseId);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}
		model.addAttribute("disease", disease);

		return "/admin/disease/disease-show";
	}

}
