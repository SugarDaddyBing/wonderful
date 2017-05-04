package com.cruelbb.business.user.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.cruelbb.business.user.bo.UserRolePerm;
import com.cruelbb.business.user.dao.UserMapper;
import com.cruelbb.business.user.po.Role;
import com.cruelbb.business.user.po.User;
import com.cruelbb.business.user.service.UserService;
import com.cruelbb.core.dataSource.orm.mybatis.DynamicSqlSessionTemplate;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public class UserServiceImpl implements UserService {

  @Autowired
  private DynamicSqlSessionTemplate DynamicSqlSessionTemplate;

  public User validateByusernameAndPwd(String email, String pswd) {
    return DynamicSqlSessionTemplate.getMapper(UserMapper.class).login(email, pswd);
  }

  @Override
  public Set<String> findRolesByUsername(String email) {
    String rolenameString = DynamicSqlSessionTemplate.getMapper(UserMapper.class).findRolesByUsername(email);
    Set<String> rolenameSet = new HashSet<String>();
    rolenameSet.add(rolenameString);
    return rolenameSet;
  }

  @Override
  public Set<String> findPermissionsByUsername(String email) {
    String permissionString = DynamicSqlSessionTemplate.getMapper(UserMapper.class).findPermissionsByUsername(email);
    Set<String> permSet = new HashSet<String>();
    List<String> permList = Arrays.asList(permissionString.split(","));
    permSet.addAll(permList);
    return permSet;
  }

  @Override
  public List<UserRolePerm> getURPByUsername(Map<String, Object> map, PageBounds pageBounds) {
    return DynamicSqlSessionTemplate.getMapper(UserMapper.class).getURPByUsername(map, pageBounds);
  }

  @Override
  public List<Role> getRoleList() {
    return DynamicSqlSessionTemplate.getMapper(UserMapper.class).getRoleList();
  }

}
