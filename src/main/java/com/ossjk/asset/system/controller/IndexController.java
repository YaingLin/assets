package com.ossjk.asset.system.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ossjk.asset.base.controller.BaseController;
import com.ossjk.asset.common.util.Constant;
import com.ossjk.asset.system.entity.User;
import com.ossjk.asset.system.service.IUserService;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

	@Autowired
	private IUserService iUserService;

	@RequestMapping("/")
	public String toIndex() {
		return "index";
	}

	@RequestMapping("/login")
	public String login(String name, String pwd, ModelMap map, HttpSession session) throws Exception {
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, pwd);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(usernamePasswordToken); // 完成登录
			User user = (User) subject.getPrincipal();
			session.setAttribute("user", user);
			return "redirect:/";
		} catch (Exception e) {
			return "login";// 返回登录页面
		}
	}

	@RequestMapping("/toLogout")
	public String toLogout() {
		return "logoutConfirm";
	}

	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(Constant.SESSION_USER_KEY);
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/toLogin";
	}
}
