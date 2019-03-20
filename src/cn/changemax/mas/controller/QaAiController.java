package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.QaAi;
import cn.changemax.mas.po.QaAiKey;
import cn.changemax.mas.service.QaAiService;
import cn.changemax.mas.utils.StringUtils;

/**
 * <p>
 * Title: TQaAiController.java
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
@RequestMapping("/qaAi")
public class QaAiController {
	@Autowired
	private QaAiService qaAiService;

	@RequestMapping(value = "/listQaAi", method = { RequestMethod.POST, RequestMethod.GET })
	public String listQaAi(Integer pageSize, Integer pageIndex, Model model, QaAi qaAi) {
		List<QaAi> qaAiList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			qaAiList = qaAiService.selectQaAiSearchInfo(qaAi, pageModel);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("qaAiList", qaAiList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/qaAi/qaAi-list";
	}

	@RequestMapping(value = "/detailedQaAi", method = { RequestMethod.POST, RequestMethod.GET })
	public String detailedQaAi(String userText, String text, Model model) {
		QaAi qaAi = null;
		if (StringUtils.isNotEmpty(userText) && StringUtils.isNotEmpty(text)) {
			QaAiKey key = new QaAiKey(userText, text);
			try {
				qaAi = qaAiService.selectByPrimaryKey(key);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		model.addAttribute("qaAi", qaAi);

		return "/admin/qaAi/detailed";
	}

}
