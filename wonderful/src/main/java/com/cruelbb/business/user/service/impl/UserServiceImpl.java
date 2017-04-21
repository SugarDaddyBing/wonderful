package com.cruelbb.business.user.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.cruelbb.business.user.dao.UserMapper;
import com.cruelbb.business.user.po.User;
import com.cruelbb.business.user.service.UserService;
import com.cruelbb.core.dataSource.orm.mybatis.DynamicSqlSessionTemplate;

public class UserServiceImpl implements UserService {

  @Autowired
  private DynamicSqlSessionTemplate DynamicSqlSessionTemplate;

  public User validateByusernameAndPwd(String email, String pswd) {
    return DynamicSqlSessionTemplate.getMapper(UserMapper.class).login(email, pswd);
  }

  @Override
  public Set<String> findRolesByUsername(String email) {
    return DynamicSqlSessionTemplate.getMapper(UserMapper.class).findRolesByEmail(email);
  }

  @Override
  public Set<String> findPermissionsByUsername(String email) {
    return DynamicSqlSessionTemplate.getMapper(UserMapper.class).findPermissionsByEmail(email);
  }

}
