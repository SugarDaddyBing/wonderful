package com.cruelbb.core.shiro.token;

import java.io.Serializable;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * shirotoken
 *
 * @author wangbingyuan
 *
 */
public class ShiroToken extends UsernamePasswordToken implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8983232950870563040L;
	/**
	 * 登录密码 【字符串类型】 父类是char[]
	 */
	private String pwd;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public ShiroToken(String username, String pwd) {
		super(username, pwd);
		this.pwd = pwd;
	}
}
