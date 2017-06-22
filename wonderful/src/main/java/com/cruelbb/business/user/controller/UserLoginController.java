package com.cruelbb.business.user.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cruelbb.business.common.annotation.MyA;
import com.cruelbb.business.user.po.User;
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
  @MyA("登录成功")
  @RequestMapping(value = "submitLogin", method = RequestMethod.POST)
  @ResponseBody
  public Map<String, Object> submitLogin(User entity, HttpServletRequest request) {

    Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
    try {
      entity = TokenManager.login(entity);
      resultMap.put("status", 200);
      resultMap.put("message", "登陆成功");
    } catch (UnknownAccountException e) {
      resultMap.put("status", 500);
      resultMap.put("message", "账号或密码错误");
    } catch (LockedAccountException e) {
      resultMap.put("status", 403);
      resultMap.put("message", "账号被限制登录");
    } catch (Exception e) {

    }
    return resultMap;
  }

  @RequestMapping("/logout")
  @ResponseBody
  public void logout() {
    Subject subject = SecurityUtils.getSubject();
    if (subject.isAuthenticated()) {
      subject.logout();
    }
  }
}
