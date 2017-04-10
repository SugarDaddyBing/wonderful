package com.cruelbb.core.shiro.token;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.cruelbb.business.user.model.UUser;
import com.cruelbb.business.user.service.UserService;

/**
 * shiro 认证 +授权
 *
 * @author wangbingyuan
 *
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		return null;
	}

	/**
	 * 认证信息，针对用户登录
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authtoken) throws AuthenticationException {
		ShiroToken token = (ShiroToken) authtoken;
		UUser user = userService.login(token.getUsername(), token.getPwd());
		if (null == user) {
			throw new AccountException("账号或密码不正确");
			/* 如果用户的status为禁用 */
		} else if (UUser._0.equals(user.getStatus())) {
			throw new DisabledAccountException("账号已经禁止登录");
		} else {


		}
		return new SimpleAuthenticationInfo(user, user.getPswd(), getName());
	}

}
