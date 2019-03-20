package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.changemax.mas.po.QaCategory;
import cn.changemax.mas.service.QaCategoryService;

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
@RequestMapping("/qaCategoryCategory")
public class QaCategoryController {
	@Autowired
	private QaCategoryService qaCategoryService;

	@RequestMapping(value = "/list", method = { RequestMethod.POST, RequestMethod.GET })
	public List<QaCategory> list(Model model) {
		List<QaCategory> qaCategoryList = null;

		try {
			qaCategoryList = qaCategoryService.selectAllQaCategory();
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		return qaCategoryList;
	}

	@RequestMapping(value = "/add", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(Model model, String name, String introduction) {

		try {
			qaCategoryService.insertQaCategory(name, introduction);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		return "/admin/qaCategory/list";
	}

	@RequestMapping(value = "/deleteQaCategory", method = { RequestMethod.POST, RequestMethod.GET })
	public String deleteQaCategory(Model model, Integer id) {

		try {
			qaCategoryService.deleteQaCategory(id);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		return "/admin/qaCategory/list";
	}

	@RequestMapping(value = "/detail", method = { RequestMethod.POST, RequestMethod.GET })
	public String detail(Integer id, Model model) {
		QaCategory qaCategory = null;
		if (id != null) {
			try {
				qaCategory = qaCategoryService.selectById(id);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		model.addAttribute("qaCategory", qaCategory);

		return "/qaCategory/detail";
	}

	/*
	 * 初始化hotQaCategoryList
	 */
	@RequestMapping(value = "/listHotQaCategory", method = { RequestMethod.POST, RequestMethod.GET })
	public List<QaCategory> listHotQaCategory(Model model) {
		List<QaCategory> hotQaCategoryList = null;
		try {
			Integer qaCategoryId = -1, number = 5;
			hotQaCategoryList = qaCategoryService.selectMaxQuestionNumberQaCategory(qaCategoryId, number);

		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		return hotQaCategoryList;
	}

}
