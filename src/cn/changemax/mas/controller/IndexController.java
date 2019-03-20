package cn.changemax.mas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.changemax.mas.po.QaCategory;
import cn.changemax.mas.po.Question;
import cn.changemax.mas.po.User;
import cn.changemax.mas.service.QaCategoryService;
import cn.changemax.mas.service.QuestionService;
import cn.changemax.mas.service.UserService;

/**
 * <p>
 * Title: IndexController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年11月30日
 * @version 1.0
 */
@Controller
public class IndexController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserService userService;

	@Autowired
	private QaCategoryService qaCategoryService;

	@RequestMapping(value = "/initIndex")
	public String initIndex(Model model) {
		System.out.println("初始化Home中对象到application");

		/*
		 * 初始化fineQuestionList
		 */
		try {
			String userId = null;
			String adoptionAnswerId = null;
			Integer questionCategoryId = -1;
			Integer isFine = 1;
			Integer isTop = 0;
			Integer number = 5;
			List<Question> fineQuestionList = questionService.selectByGenerationDateDesc(userId, adoptionAnswerId,
					questionCategoryId, isFine, isTop, number);
			model.addAttribute("fineQuestionList", fineQuestionList);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		/*
		 * 初始化hotQuestionList
		 */
		try {
			String userId = null;
			String adoptionAnswerId = null;
			Integer questionCategoryId = -1;
			Integer isFine = 0;
			Integer isTop = 0;
			Integer number = 10;
			List<Question> hotViewsQuestionList = questionService.selectByViewsDesc(userId, adoptionAnswerId,
					questionCategoryId, isFine, isTop, number);
			model.addAttribute("hotViewsQuestionList", hotViewsQuestionList);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		/*
		 * 初始化monthTopUserList
		 */
		try {
			Integer number = 5;
			List<User> monthTopUserList = userService.selectMaxUserAnswerNumber(number);

			model.addAttribute("monthTopUserList", monthTopUserList);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		/*
		 * 初始化newQuestionList
		 */
		try {
			String userId = null;
			String adoptionAnswerId = "null";
			Integer questionCategoryId = -1;
			Integer isFine = 0;
			Integer isTop = 0;
			Integer number = 10;
			List<Question> newDateQuestionList = questionService.selectByGenerationDateDesc(userId, adoptionAnswerId,
					questionCategoryId, isFine, isTop, number);
			model.addAttribute("newDateQuestionList", newDateQuestionList);

		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		/*
		 * 初始化hotQaCategoryList
		 */
		try {
			Integer qaCategoryId = -1, number = 5;
			List<QaCategory> hotQaCategoryList = qaCategoryService.selectMaxQuestionNumberQaCategory(qaCategoryId,
					number);

			model.addAttribute("hotQaCategoryList", hotQaCategoryList);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		return "/index";

	}

}
