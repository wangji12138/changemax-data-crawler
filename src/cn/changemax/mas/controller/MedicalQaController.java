package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.MedicalQa;
import cn.changemax.mas.service.MedicalQaService;
import cn.changemax.mas.utils.StringUtils;

/**
 * <p>
 * Title: TMedicalQaController.java
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
@RequestMapping("/medicalQa")
public class MedicalQaController {
	@Autowired
	private MedicalQaService medicalQaService;

	@RequestMapping(value = "/listMedicalQa", method = { RequestMethod.POST, RequestMethod.GET })
	public String listMedicalQa(Integer pageSize, Integer pageIndex, Model model, MedicalQa medicalQa) {
		List<MedicalQa> medicalQaList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			medicalQaList = medicalQaService.selectMedicalQaSearchInfo(medicalQa, pageModel);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("medicalQaList", medicalQaList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/medicalQa/medicalQa-list";
	}

	@RequestMapping(value = "/detailedMedicalQa", method = { RequestMethod.POST, RequestMethod.GET })
	public String detailedMedicalQa(Integer qaId, Model model) {
		MedicalQa medicalQa = null;
		if (qaId != null) {
			try {
				medicalQa = medicalQaService.selectByPrimaryKey(qaId);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		model.addAttribute("medicalQa", medicalQa);

		return "/admin/medicalQa/detailed";
	}

	@RequestMapping(value = "/showMedicalQa", method = { RequestMethod.POST, RequestMethod.GET })
	public String showMedicalQa(String qaId, Model model) {
		MedicalQa medicalQa = null;
		if (StringUtils.isNotEmpty(qaId)) {
			try {
				medicalQa = medicalQaService.selectByPrimaryKey(Integer.parseInt(qaId));
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}
		model.addAttribute("medicalQa", medicalQa);

		return "/admin/medicalQa/medicalQa-show";
	}

}
