package com.cruelbb.business.user.dao;

import java.util.List;
import java.util.Set;

import com.cruelbb.business.user.bo.UserRolePerm;
import com.cruelbb.business.user.po.User;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface UserMapper {

  /**
   * 用于登录
   *
   * @param map
   * @return User
   */
  User login(String email, String pswd);

  /**
   * 通过用户名查找role
   *
   * @param email
   * @return Set<String>
   */
  Set<String> findRolesByUsername(String email);

  /**
   * 通过用户名查找permission
   *
   * @param email
   * @return Set<String>
   */
  Set<String> findPermissionsByUsername(String email);

  /**
   * 通过用户名查询用户详细信息
   *
   * @param email
   * @return List<UserRolePerm>
   */
  List<UserRolePerm> getURPByUsername(String email);
}
