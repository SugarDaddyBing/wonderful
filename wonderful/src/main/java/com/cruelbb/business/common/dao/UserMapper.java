package com.cruelbb.business.common.dao;

import java.util.List;
import java.util.Map;

import com.cruelbb.business.user.po.Role;
import com.cruelbb.business.user.po.User;
import com.cruelbb.business.user.vo.UserRolePerm;
import com.cruelbb.business.user.vo.UserVo;
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

  /**
   * 更新user
   *
   * @param user
   * @return 受影响行数
   */
  int updateUser(UserVo user);
}
