package com.cruelbb.business.user.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.cruelbb.business.user.bo.UserRolePerm;
import com.cruelbb.business.user.dao.UserMapper;
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
    return DynamicSqlSessionTemplate.getMapper(UserMapper.class).findRolesByUsername(email);
  }

  @Override
  public Set<String> findPermissionsByUsername(String email) {
    return DynamicSqlSessionTemplate.getMapper(UserMapper.class).findPermissionsByUsername(email);
  }

  @Override
  public List<UserRolePerm> getURPByUsername(String email)  {
    return DynamicSqlSessionTemplate.getMapper(UserMapper.class).getURPByUsername(email);
  }

}
