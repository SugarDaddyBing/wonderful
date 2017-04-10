package com.cruelbb.core.shiro.token.manager;

import org.apache.shiro.SecurityUtils;

import com.cruelbb.business.user.model.UUser;
import com.cruelbb.core.shiro.token.ShiroToken;

/**
 * shiro管理下的一个token工具类
 *
 * @author wangbingyuan
 *
 */
public class TokenManager {

	/**
	 * 获取当前的登录的用户的user对象
	 * @return
	 */
	public static UUser getToken() {
		UUser token = (UUser) SecurityUtils.getSubject().getPrincipal();
		return token;
	}

	public static UUser login(UUser user) {
		ShiroToken token = new ShiroToken(user.getEmail(), user.getPswd());
		//token.setRememberMe(rememberMe);
		SecurityUtils.getSubject().login(token);
		return getToken();
	}
}
