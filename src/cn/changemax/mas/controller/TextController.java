package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hankcs.hanlp.seg.common.Term;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Text;
import cn.changemax.mas.service.TextService;
import cn.changemax.mas.utils.StringUtils;

/**
 * <p>
 * Title: TTextController.java
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
@RequestMapping("/text")
public class TextController {
	@Autowired
	private TextService textService;

	@RequestMapping(value = "/listText", method = { RequestMethod.POST, RequestMethod.GET })
	public String listText(Integer pageSize, Integer pageIndex, Model model, Text text) {
		List<Text> textList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			textList = textService.selectTextSearchInfo(text, pageModel);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("textList", textList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/text/text-list";
	}

	@RequestMapping(value = "/detailedText", method = { RequestMethod.POST, RequestMethod.GET })
	public String detailedText(Integer id, Model model) {
		Text text = null;
		if (id != null) {
			try {
				text = textService.selectByPrimaryKey(id);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		model.addAttribute("text", text);

		return "/admin/text/detailed";
	}

	@ResponseBody
	@RequestMapping(value = "/segmentText", method = { RequestMethod.POST })
	public List<Term> segmentText(String preanalysisText) {
		List<Term> termList = null;
		if (StringUtils.isNotEmpty(preanalysisText)) {
			try {
				termList = textService.segmentText(preanalysisText);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		return termList;
	}

	/**
	 * 
	 * <p>
	 * Title: convertToSimplifiedChinese
	 * </p>
	 * <p>
	 * Description: 繁转简
	 * </p>
	 * 
	 * @param traditionalChineseString
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/convertToSimplifiedChinese", method = { RequestMethod.POST })
	public String convertToSimplifiedChinese(String traditionalChineseString) throws Exception {
		String simplifiedChineseString = null;
		if (StringUtils.isNotEmpty(traditionalChineseString)) {
			try {
				simplifiedChineseString = textService.convertToSimplifiedChinese(traditionalChineseString);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		return simplifiedChineseString;
	}

	/**
	 * 
	 * <p>
	 * Title: convertToTraditionalChinese
	 * </p>
	 * <p>
	 * Description: 简转繁
	 * </p>
	 * 
	 * @param simplifiedChineseString
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/convertToTraditionalChinese", method = { RequestMethod.POST })
	public String convertToTraditionalChinese(String simplifiedChineseString) throws Exception {
		String traditionalChineseString = null;
		if (StringUtils.isNotEmpty(simplifiedChineseString)) {
			try {
				traditionalChineseString = textService.convertToTraditionalChinese(simplifiedChineseString);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		return traditionalChineseString;
	}
}
