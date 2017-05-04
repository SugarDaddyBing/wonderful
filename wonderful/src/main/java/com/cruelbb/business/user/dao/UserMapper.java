package com.cruelbb.business.user.dao;

import java.util.List;
import java.util.Map;

import com.cruelbb.business.user.bo.UserRolePerm;
import com.cruelbb.business.user.po.Role;
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
   * @return role名
   */
  String findRolesByUsername(String email);

  /**
   * 通过用户名查找permission
   *
   * @param email
   * @return permissionname权限名
   */
  String findPermissionsByUsername(String email);

  /**
   * 通过用户名查询用户详细信息
   *
   * @param params
   *        pageBounds
   * @return List<UserRolePerm>
   */
  List<UserRolePerm> getURPByUsername(Map<String, Object> params, PageBounds pageBounds);

  /**
   * 得到所有的角色
   *
   * @return List<Role>
   */
  List<Role> getRoleList();
}
