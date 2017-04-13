package com.cruelbb.business.user.dao;

import java.util.Set;

import com.cruelbb.business.user.po.User;

public interface UserMapper {

  /**
   * 用于登录
   *
   * @param map
   * @return User
   */
  User login(String email, String pswd);

  /**
   *
   * @param email
   * @return
   */
  Set<String> findRolesByEmail(String email);

  /**
   *
   * @param email
   * @return
   */
  Set<String> findPermissionsByEmail(String email);
}
