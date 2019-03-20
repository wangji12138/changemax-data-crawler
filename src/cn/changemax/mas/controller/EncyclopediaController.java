package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Encyclopedia;
import cn.changemax.mas.po.EncyclopediaKey;
import cn.changemax.mas.service.EncyclopediaService;
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
@RequestMapping("/encyclopedia")
public class EncyclopediaController {
	@Autowired
	private EncyclopediaService encyclopediaService;

	@ResponseBody
	@RequestMapping(value = "/idiomSearch", method = { RequestMethod.POST, RequestMethod.GET })
	public Encyclopedia idiomSearch(String key, String idiomName) {
		Encyclopedia idiom = null;
		try {
			idiom = encyclopediaService.selectIdiomEncyclopedia(key, idiomName);
		} catch (Exception e) {
			e.getMessage();
		}

		return idiom;
	}

	@RequestMapping(value = "/goIdiomIndex", method = { RequestMethod.GET })
	public String goIdiomIndex() {
		return "/admin/encyclopedia/goIdiomIndex";
	}

	@RequestMapping(value = "/listEncyclopedia", method = { RequestMethod.POST, RequestMethod.GET })
	public String listEncyclopedia(Integer pageSize, Integer pageIndex, Model model, Encyclopedia encyclopedia) {
		List<Encyclopedia> encyclopediaList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			encyclopediaList = encyclopediaService.selectEncyclopediaSearchInfo(encyclopedia, pageModel);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("encyclopediaList", encyclopediaList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/encyclopedia/encyclopedia-list";
	}

	@RequestMapping(value = "/showEncyclopedia", method = { RequestMethod.POST, RequestMethod.GET })
	public String showEncyclopedia(String name, String url, Model model) {
		Encyclopedia encyclopedia = null;
		if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(url)) {
			EncyclopediaKey key = new EncyclopediaKey(name, url);
			try {
				encyclopedia = encyclopediaService.selectEncyclopediaByKey(key);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}
		model.addAttribute("encyclopedia", encyclopedia);

		return "/admin/encyclopedia/encyclopedia-show";
	}

}
