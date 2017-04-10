package com.cruelbb.business.user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapController {

	/**
	 * 登录跳转
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("user/login");
	}

	/**
	 * 注册跳转
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("user/register");
	}

	/**
	 * 主页跳转
	 */
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		Cookie c = cookies[0];
		ModelAndView mv = new ModelAndView("user/home");
		mv.addObject("user", c.getValue());
		return mv;
	}
}
