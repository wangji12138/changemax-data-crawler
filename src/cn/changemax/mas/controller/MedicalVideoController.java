package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.MedicalVideo;
import cn.changemax.mas.service.MedicalVideoService;
import cn.changemax.mas.utils.StringUtils;

/**
 * <p>
 * Title: TMedicalVideoController.java
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
@RequestMapping("/medicalVideo")
public class MedicalVideoController {
	@Autowired
	private MedicalVideoService medicalVideoService;

	@RequestMapping(value = "/listMedicalVideo", method = { RequestMethod.POST, RequestMethod.GET })
	public String listMedicalVideo(Integer pageSize, Integer pageIndex, Model model, MedicalVideo medicalVideo) {
		List<MedicalVideo> medicalVideoList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			medicalVideoList = medicalVideoService.selectMedicalVideoSearchInfo(medicalVideo, pageModel);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("medicalVideoList", medicalVideoList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/medicalVideo/medicalVideo-list";
	}

	@RequestMapping(value = "/detailedMedicalVideo", method = { RequestMethod.POST, RequestMethod.GET })
	public String detailedMedicalVideo(Integer videoId, Model model) {
		MedicalVideo medicalVideo = null;
		if (videoId != null) {
			try {
				medicalVideo = medicalVideoService.selectByPrimaryKey(videoId);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		model.addAttribute("medicalVideo", medicalVideo);

		return "/admin/medicalVideo/detailed";
	}

	@RequestMapping(value = "/showMedicalVideo", method = { RequestMethod.POST, RequestMethod.GET })
	public String showMedicalVideo(String videoId, Model model) {
		MedicalVideo medicalVideo = null;
		if (StringUtils.isNotEmpty(videoId)) {
			try {
				medicalVideo = medicalVideoService.selectByPrimaryKey(Integer.parseInt(videoId));
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}
		model.addAttribute("medicalVideo", medicalVideo);

		return "/admin/medicalVideo/medicalVideo-show";
	}

}
