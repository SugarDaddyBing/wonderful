package com.cruelbb.business.user.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cruelbb.business.user.po.UUser;
import com.cruelbb.core.shiro.token.manager.TokenManager;

/**
 * 用户登录相关 ，无需做登录限制
 *
 * @author wangbingyuan
 *
 */
@Controller
public class UserLoginController {

	/**
	 * 登陆提交
	 *
	 * @param entity
	 * @param remeberMe
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "submitLogin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitLogin(UUser entity, HttpServletRequest request) {

		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		try {
			entity = TokenManager.login(entity);
			resultMap.put("status", 200);
			resultMap.put("message", "登陆成功");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "账号或密码错误");
		}
		return resultMap;
	}
}
