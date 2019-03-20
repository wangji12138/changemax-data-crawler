package cn.changemax.mas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.Question;
import cn.changemax.mas.po.User;
import cn.changemax.mas.service.AnswerService;
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
@RequestMapping("/qa")
public class AnswerController {
	@Autowired
	private AnswerService answerService;

	@RequestMapping(value = "/listQa", method = { RequestMethod.POST, RequestMethod.GET })
	public String listQa(Integer pageSize, Integer pageIndex, Model model, Answer answer, String startTime,
			String endTime) {
		List<Answer> answerList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			answerList = answerService.selectQuestionInfo(answer, pageModel, startTime, endTime);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("answerList", answerList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/answer/list";
	}

	@RequestMapping(value = "/detail", method = { RequestMethod.POST, RequestMethod.GET })
	public String detail(String answerId, Model model) {
		Answer answer = null;
		if (StringUtils.isNotEmpty(answerId)) {
			try {
				answer = answerService.selectAnswerById(answerId);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		model.addAttribute("answer", answer);

		return "/admin/answer/detailed";
	}

	/**
	 * 
	 * <p>
	 * Title: searchAllQa
	 * </p>
	 * <p>
	 * Description: 层主回帖操作
	 * </p>
	 * 
	 * @param request
	 * @param model
	 * @param searchQuestion
	 * @return
	 */
	@RequestMapping(value = "/answer", method = RequestMethod.POST)
	public String answer(HttpServletRequest request, Model model, String questionId, String originalQuestion,
			String answerDetail) {
		String userId = "";

		User sessionUser = (User) request.getSession().getAttribute("user");
		if (sessionUser != null && StringUtils.isNotEmpty(sessionUser.getUserId())) {
			userId = sessionUser.getUserId();
		} else {
			// 未登录，无法进行回帖操作，返回登录窗口
			return "redirect:/user/login";
		}

		if (StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(questionId)
				&& StringUtils.isNotEmpty(originalQuestion) && StringUtils.isNotEmpty(answerDetail)) {
			try {
				Question question = answerService.insertAnswer(userId, questionId, originalQuestion, answerDetail);
				model.addAttribute("question", question);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		} else {
			// 错误页面
		}

		return "/question/detail";
	}

}
