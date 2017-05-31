package com.cruelbb.business.menu.service;

import java.util.List;

import com.cruelbb.business.menu.po.Menu;


public interface MenuService {

  List<Menu> getMenuList();
  List<Menu> getParentMenuList();
}
