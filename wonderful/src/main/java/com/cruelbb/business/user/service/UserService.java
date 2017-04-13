package com.cruelbb.business.user.service;

import java.util.Set;

import com.cruelbb.business.user.po.User;

public interface UserService {

  /**
   * 登录
   *
   * @param email
   * @param pswd
   * @return UUser
   */
  User login(String email, String pswd);

  /**
   * 根据email得到rolename
   *
   * @param email
   * @return
   */
  Set<String> findRolesByEmail(String email);

  /**
   * 根据email得到权限
   *
   * @param email
   * @return
   */
  Set<String> findPermissionsByEmail(String email);
}
