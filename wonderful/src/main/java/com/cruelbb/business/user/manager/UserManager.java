package com.cruelbb.business.user.manager;

import com.cruelbb.business.user.po.User;
import com.cruelbb.common.utils.MathUtil;

public class UserManager {

	/**
	 * 返回MD5加密后的密码(string)
	 *
	 * @param email
	 * @param pwd
	 * @return
	 */
	public static String md5Pswd(String email, String pwd) {
		pwd = String.format("%s#%s", email, pwd);
		pwd = MathUtil.getMD5(pwd);
		return pwd;
	}

	/**
	 * 返回MD5加密后的user类
	 *
	 * @param user
	 * @return
	 */
	public static User md5Pswd(User user) {
		user.setPswd(md5Pswd(user.getEmail(), user.getPswd()));
		return user;
	}
}
