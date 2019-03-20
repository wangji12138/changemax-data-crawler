
package cn.changemax.mas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.QaCategory;
import cn.changemax.mas.po.Question;
import cn.changemax.mas.po.User;
import cn.changemax.mas.service.AnswerService;
import cn.changemax.mas.service.QaCategoryService;
import cn.changemax.mas.service.QuestionService;
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
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private QaCategoryService qaCategoryService;

	@RequestMapping(value = "/add", method = { RequestMethod.POST, RequestMethod.GET })
	public String add(HttpServletRequest request, Model model) {

		try {
			List<QaCategory> qaCategoryList = qaCategoryService.selectAllQaCategory();

			model.addAttribute("qaCategoryList", qaCategoryList);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		return "/question/add";
	}

	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request, Model model, Integer questionCategoryId, String questionTitle,
			String questionDetail, Integer questionReward, Integer isAnonymous) {
		String userId = "";

		User sessionUser = (User) request.getSession().getAttribute("user");
		if (sessionUser != null && StringUtils.isNotEmpty(sessionUser.getUserId())) {
			userId = sessionUser.getUserId();
		} else {
			// 未登录，无法进行发帖操作，返回登录窗口
			return "redirect:/user/login";
		}

		try {
			Question question = questionService.insertQuestion(userId, questionCategoryId, questionTitle,
					questionDetail, questionReward, isAnonymous);

			model.addAttribute("question", question);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		return "/question/detail";
	}

	/*
	 * 初始化fineQuestionList
	 */
	@RequestMapping(value = "/listFine", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Question> listFine(Model model) {
		List<Question> fineQuestionList = null;
		try {
			String userId = null;
			String adoptionAnswerId = null;
			Integer questionCategoryId = -1;
			Integer isFine = 1;
			Integer isTop = 0;
			Integer number = 5;
			fineQuestionList = questionService.selectByGenerationDateDesc(userId, adoptionAnswerId, questionCategoryId,
					isFine, isTop, number);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		return fineQuestionList;
	}

	/*
	 * 初始化hotViewsQuestionList
	 */
	@RequestMapping(value = "/listHotViews", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Question> listHotViews(Model model) {
		List<Question> hotViewsQuestionList = null;
		try {
			String userId = null;
			String adoptionAnswerId = null;
			Integer questionCategoryId = -1;
			Integer isFine = 0;
			Integer isTop = 0;
			Integer number = 10;
			hotViewsQuestionList = questionService.selectByViewsDesc(userId, adoptionAnswerId, questionCategoryId,
					isFine, isTop, number);

		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		return hotViewsQuestionList;
	}

	/*
	 * 获取最新待解答问题
	 */
	@RequestMapping(value = "/listNewDatePending", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Question> listNewDatePending(Model model) {
		List<Question> newDateQuestionList = null;
		try {
			String userId = null;
			String adoptionAnswerId = "null";
			Integer questionCategoryId = -1;
			Integer isFine = 0;
			Integer isTop = 0;
			Integer number = 10;
			newDateQuestionList = questionService.selectByGenerationDateDesc(userId, adoptionAnswerId,
					questionCategoryId, isFine, isTop, number);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		return newDateQuestionList;
	}

	/*
	 * 获取最新问题
	 */
	@RequestMapping(value = "/listNewDate", method = { RequestMethod.POST, RequestMethod.GET })
	public List<Question> listNewDate(Model model) {
		List<Question> newQuestionList = null;
		try {
			String userId = null;
			String adoptionAnswerId = null;
			Integer questionCategoryId = -1;
			Integer isFine = 0;
			Integer isTop = 0;
			Integer number = 10;
			newQuestionList = questionService.selectByGenerationDateDesc(userId, adoptionAnswerId, questionCategoryId,
					isFine, isTop, number);

			model.addAttribute("newQuestionList", newQuestionList);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		return newQuestionList;
	}
	
	/*
	 * 获取最新问题
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Model model) {
		List<Question> newQuestionList = null;
		try {
			String userId = null;
			String adoptionAnswerId = null;
			Integer questionCategoryId = -1;
			Integer isFine = 0;
			Integer isTop = 0;
			Integer number = 10;
			newQuestionList = questionService.selectByGenerationDateDesc(userId, adoptionAnswerId, questionCategoryId,
					isFine, isTop, number);

			model.addAttribute("questionList", newQuestionList);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		return "/question/index";
	}

	/*
	 * 查看Question
	 */
	@RequestMapping(value = "/detail", method = { RequestMethod.POST, RequestMethod.GET })
	public String detail(HttpServletRequest request, Model model, String questionId) {

		if (StringUtils.isNotEmpty(questionId)) {

			try {
				Question question = questionService.selectByQuestionId(questionId);

				String userId1 = null;
				String adoptionAnswerId1 = null;
				Integer questionCategoryId1 = -1;
				Integer isFine1 = 0;
				Integer isTop1 = 0;
				Integer number1 = 10;
				List<Question> hotViewsQuestionList = questionService.selectByViewsDesc(userId1, adoptionAnswerId1,
						questionCategoryId1, isFine1, isTop1, number1);

				String userId2 = null;
				String adoptionAnswerId2 = null;
				Integer questionCategoryId2 = -1;
				Integer isFine2 = 0;
				Integer isTop2 = 0;
				Integer number2 = 10;
				List<Question> hotAnswerQuestionList = questionService.selectByAnswerNumberDesc(userId2,
						adoptionAnswerId2, questionCategoryId2, isFine2, isTop2, number2);

				model.addAttribute("question", question);
				model.addAttribute("hotViewsQuestionList", hotViewsQuestionList);
				model.addAttribute("hotAnswerQuestionList", hotAnswerQuestionList);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		return "/question/detail";
	}

	/**
	 * 
	 * <p>
	 * Title: detailedQuestion
	 * </p>
	 * <p>
	 * Description:按searchQuestion模糊查询Question
	 * </p>
	 * 
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/likeSearchQuestion", method = { RequestMethod.POST, RequestMethod.GET })
	public String likeSearchQuestion(Model model, String searchQuestion) {

		try {
			List<Question> questionList = questionService.selectByLikeSearchQuestion(searchQuestion);
			model.addAttribute("questionList", questionList);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		return "/question/index";
	}

	@RequestMapping(value = "/adminList", method = { RequestMethod.POST, RequestMethod.GET })
	public String adminList(Integer pageSize, Integer pageIndex, Model model, Question question, String startTime,
			String endTime) {
		List<Question> questionList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			questionList = questionService.selectQuestionSearchInfo(question, pageModel, startTime, endTime);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("questionList", questionList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/question-details";
	}

}
