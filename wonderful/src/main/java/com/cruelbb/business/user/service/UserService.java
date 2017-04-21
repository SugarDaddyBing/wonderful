package com.cruelbb.business.user.service;

import java.util.Set;

import com.cruelbb.business.user.po.User;

/**
 * 用户相关service
 *
 * @author wangbingyuan
 */
public interface UserService {

  /**
   * 通过username，pwd获得user信息
   *
   * @param username
   * @param pswd
   * @return UUser
   */
  User validateByusernameAndPwd(String username, String pswd);

  /**
   * 根据email得到rolename
   *
   * @param email
   *        email
   * @return set集合
   */
  Set<String> findRolesByUsername(String email);

  /**
   * 根据email得到权限
   *
   * @param email
   * @return set集合
   */
  Set<String> findPermissionsByUsername(String email);
}
