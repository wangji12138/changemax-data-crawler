package cn.changemax.mas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.User;
import cn.changemax.mas.service.UserService;
import cn.changemax.mas.utils.StringUtils;

/**
 * <p>
 * Title: TUserController.java
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
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/home", method = { RequestMethod.POST, RequestMethod.GET })
	public String home(HttpServletRequest request, String userId, Model model) {
		if (StringUtils.isNotEmpty(userId)) {
			try {
				User user = userService.selectDetailByUserId(userId);
				model.addAttribute("user", user);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		} else {
			String errorMessage = "账户为空！";
			model.addAttribute("errorMessage", errorMessage);
			return "/error";
		}

		return "/user/home";

	}
	
	@RequestMapping(value = "/reg", method = { RequestMethod.POST, RequestMethod.GET })
	public String reg(Model model) { 
		return "/user/reg";
	}

	@RequestMapping(value = "/doReg", method = { RequestMethod.POST, RequestMethod.GET })
	public String doReg(User newUser, Model model) {
		if (newUser == null) {
			String errorMessage = "注册失败！";
			model.addAttribute("errorMessage", errorMessage);
		} else {

			try {
				User user = userService.insertUser(newUser);
				if (user != null) {
					String correctMessage = "注册成功，3秒后跳转登录！";
					String correctUrl = "/views/user/login.jsp";
					model.addAttribute("correctMessage", correctMessage);
					model.addAttribute("correctUrl", correctUrl);

					return "/correct";
				} else {
					String errorMessage = "注册失败！您的信息有误！请核对！";
					model.addAttribute("errorMessage", errorMessage);
				}
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}
		return "/user/reg";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public String login(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");

		if (user != null) {
			String errorMessage = "已经登录【\" + user.getUsername() + \"】账户，再次登录将替换账户。";
			model.addAttribute("errorMessage", errorMessage);
		}
		return "/user/login";
	}

	@RequestMapping(value = "/doLogin", method = { RequestMethod.POST, RequestMethod.GET })
	public String doLogin(HttpServletRequest request, String username, String password, Model model) {
		User user = null;
		if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
			try {
				user = userService.selectByUsernameAndPassword(username, password);
				if (user != null) {
					String correctMessage = "登录成功，3秒后跳转至您的首页！";
					String correctUrl = "javascript:history.back(-1)";
					model.addAttribute("correctMessage", correctMessage);
					model.addAttribute("correctUrl", correctUrl);
					request.getSession().setAttribute("user", user);

					return "/correct";
				}

				String errorMessage = "登录失败！请核对您的账号密码信息！";
				model.addAttribute("errorMessage", errorMessage);

			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
		}

		model.addAttribute("user", user);

		return "/user/login";
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.POST, RequestMethod.GET })
	public String logoutUser(HttpServletRequest request, Model model) {
		request.getSession().removeAttribute("user");
		String correctMessage = "注销成功，3秒后跳转至您的首页！";
		String correctUrl = "/views/index.jsp";
		model.addAttribute("correctMessage", correctMessage);
		model.addAttribute("correctUrl", correctUrl);

		return "/correct";
	}

	/*
	 * 初始化listMaxUserAnswerNumber
	 */
	@RequestMapping(value = "/listMaxUserAnswerNumber", method = { RequestMethod.POST, RequestMethod.GET })
	public List<User> listMaxUserAnswerNumber(Model model) {
		List<User> maxUserAnswerNumberList = null;
		try {
			Integer number = 5;
			maxUserAnswerNumberList = userService.selectMaxUserAnswerNumber(number);

		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		return maxUserAnswerNumberList;
	}

	/*
	 * 初始化listMaxUserAnswerNumber
	 */
	@RequestMapping(value = "/listMaxUserQuestionNumber", method = { RequestMethod.POST, RequestMethod.GET })
	public List<User> listMaxUserQuestionNumber(Model model) {
		List<User> maxUserQuestionNumberList = null;
		try {
			Integer number = 5;
			maxUserQuestionNumberList = userService.selectMaxUserQuestionNumber(number);

		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}

		return maxUserQuestionNumberList;
	}

	@RequestMapping(value = "/list", method = { RequestMethod.POST, RequestMethod.GET })
	public String list(Integer pageSize, Integer pageIndex, Model model, User user) {
		List<User> userList = null;
		// 创建分页对象
		PageModel pageModel = new PageModel();
		if (pageSize != null) {
			pageModel.setPageSize(pageSize);
		}
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}

		try {
			userList = userService.selectUserSearchInfo(user, pageModel);
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.err.println(errorMessage);
			e.printStackTrace();
		}
		model.addAttribute("userList", userList);
		model.addAttribute("pageModel", pageModel);

		return "/admin/user/user-list";
	}
}
