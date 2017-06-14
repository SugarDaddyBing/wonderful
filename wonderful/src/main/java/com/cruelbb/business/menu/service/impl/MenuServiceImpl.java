package com.cruelbb.business.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cruelbb.business.common.dao.MenuMapper;
import com.cruelbb.business.menu.po.Menu;
import com.cruelbb.business.menu.service.MenuService;
import com.cruelbb.core.dataSource.orm.mybatis.DynamicSqlSessionTemplate;

public class MenuServiceImpl implements MenuService {

  @Autowired
  private DynamicSqlSessionTemplate dynamicSqlSessionTemplate;

  @Override
  public List<Menu> getMenuList() {
    return dynamicSqlSessionTemplate.getMapper(MenuMapper.class).getMenuList();
  }

  @Override
  public List<Menu> getParentMenuList() {
    return dynamicSqlSessionTemplate.getMapper(MenuMapper.class).getParentMenuList();
  }

  @Override
  public List<Menu> getChildByParentId(int id) {

    return dynamicSqlSessionTemplate.getMapper(MenuMapper.class).getChildByParentId(id);
  }

  @Override
  public boolean delMenuById(int id) {

    return dynamicSqlSessionTemplate.getMapper(MenuMapper.class).delMenuById(id) > 0;
  }

}
