package com.cruelbb.core.shiro.token.manager;

import org.apache.shiro.SecurityUtils;

import com.cruelbb.business.user.po.User;
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
   *
   * @return
   */
  public static User getToken() {
    User token = (User) SecurityUtils.getSubject().getPrincipal();
    return token;
  }

  /**
   * 用于登录
   *
   * @param user
   * @return User
   */
  public static User login(User user) {
    ShiroToken token = new ShiroToken(user.getEmail(), user.getPswd());
    // token.setRememberMe(rememberMe);
    SecurityUtils.getSubject().login(token);
    return getToken();
  }
}
