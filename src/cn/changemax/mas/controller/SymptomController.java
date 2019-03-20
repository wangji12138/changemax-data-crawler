package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Symptom;
import cn.changemax.mas.po.SymptomWithBLOBs;
import cn.changemax.mas.service.SymptomService;
import cn.changemax.mas.utils.StringUtils;

/**
 * <p>
 * Title: TSymptomController.java
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
@RequestMapping("/symptom")
public class SymptomController {
	@Autowired
	private SymptomService symptomService;

	@RequestMapping(value = "/listSymptom", method = { RequestMethod.POST, RequestMethod.GET })
	public String listSymptom(Integer pageSize, Integer pageIndex, Model model, Symptom symptom) {
		List<SymptomWithBLOBs> symptomWithBLOBsList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			symptomWithBLOBsList = symptomService.selectSymptomWithBLOBsSearchInfo(symptom, pageModel);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("symptomWithBLOBsList", symptomWithBLOBsList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/symptom/symptom-list";
	}

	@RequestMapping(value = "/detailedSymptom", method = { RequestMethod.POST, RequestMethod.GET })
	public String detailedSymptom(String symptomId, Model model) {
		Symptom symptom = null;
		if (StringUtils.isNotEmpty(symptomId)) {
			try {
				symptom = symptomService.selectByPrimaryKey(symptomId);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		model.addAttribute("symptom", symptom);

		return "/admin/symptom/detailed";
	}

	@RequestMapping(value = "/showSymptom", method = { RequestMethod.POST, RequestMethod.GET })
	public String showSymptom(String symptomId, Model model) {
		Symptom symptom = null;
		if (StringUtils.isNotEmpty(symptomId)) {
			try {
				symptom = symptomService.selectByPrimaryKey(symptomId);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}
		model.addAttribute("symptom", symptom);

		return "/admin/symptom/symptom-show";
	}

}
