package com.cruelbb.business.common.dao;

import java.util.List;

import com.cruelbb.business.menu.po.Menu;

public interface MenuMapper {

  List<Menu> getMenuList();

  List<Menu> getParentMenuList();
}
