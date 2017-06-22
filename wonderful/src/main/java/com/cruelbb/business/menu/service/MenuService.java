package com.cruelbb.business.menu.service;

import java.util.List;

import com.cruelbb.business.menu.po.Menu;

public interface MenuService {

  // 全部未禁用的menu
  List<Menu> getMenuList();

  // 全部未禁用的父节点
  List<Menu> getParentMenuList();

  // 全部指定父节点下未禁用的子节点
  List<Menu> getChildByParentId(int id);

  // 软删
  boolean delMenuById(int id);

  // 新增
  boolean addMenu(Menu menu);
}
