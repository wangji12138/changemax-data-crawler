package cn.changemax.mas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Admin;
import cn.changemax.mas.service.AdminService;
import cn.changemax.mas.utils.StringUtils;

/**
 * <p>
 * Title: AdminController.java
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
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		Object admin = request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/error/404";
		} else {
			return "/admin/index";
		}
	}

	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request) {
		Object admin = request.getSession().getAttribute("admin");
		if (admin == null) {
			return "/error/404";
		} else {
			return "/admin/welcome";
		}
	}

	@RequestMapping("/doLogout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("admin");
		return "/index";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		return "/admin/login";
	}

	@RequestMapping(value = "/doLogin", method = { RequestMethod.POST })
	public String doLogin(HttpServletRequest request, Model model, @RequestParam String adminUsername,
			@RequestParam String adminPassword) throws Exception {

		if (StringUtils.isNotEmpty(adminUsername) && StringUtils.isNotEmpty(adminPassword)) {
			Admin admin = adminService.selectAdminByUsernameAndPassword(adminUsername, adminPassword);
			if (admin != null) {
				request.getSession().setAttribute("admin", admin);
				System.out.println("密码正确！");
				// 重定向
				return "redirect:/admin/index";
			}

		}
		System.out.println("密码错误！");
		String errorMessage = "账户或者密码错误！";

		model.addAttribute("adminUsername", adminUsername);
		model.addAttribute("errorMessage", errorMessage);

		// 请求转发·
		return "/admin/login";
	}

	@RequestMapping(value = "/listAdmin", method = { RequestMethod.POST, RequestMethod.GET })
	public String listAdmin(HttpServletRequest request, Integer pageSize, Integer pageIndex, Model model, Admin admin) {

		Admin sessionAdmin = (Admin) request.getSession().getAttribute("admin");

		if (sessionAdmin != null && sessionAdmin.getSeniorAdmin().equals("1")) {

			List<Admin> adminList = null;
			// 创建分页对象
			PageModel pageModel = new PageModel();
			if (pageSize != null && pageSize > 1 && pageSize < 30) {
				pageModel.setPageSize((pageSize > 30) ? 30 : pageSize);
			}
			if (pageIndex != null) {
				pageModel.setPageIndex(pageIndex);
			}

			try {
				adminList = adminService.selectAdminSearchInfo(admin, pageModel);
			} catch (Exception e) {
				String errorMessage = e.getMessage();
				System.err.println(errorMessage);
				e.printStackTrace();
			}
			model.addAttribute("adminList", adminList);
			model.addAttribute("pageModel", pageModel);

			return "/admin/admin/admin-list";

		} else {
			return "forward:/assets/error/404.html";
		}

	}

}