package com.cruelbb.business.menu.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruelbb.business.common.web.R;
import com.cruelbb.business.menu.po.Menu;
import com.cruelbb.business.menu.service.MenuService;
import com.cruelbb.business.menu.vo.MenuVo;

/**
 * 加载首页index的导航
 *
 * @author wangbingyuan
 */
@RestController
@RequestMapping("/menu/")
public class MeunController {

  @Autowired
  private MenuService menuService;

  @RequestMapping("list")
  public R list() {
    List<Menu> menulist = menuService.getMenuList();
    List<MenuVo> menuvolist = new LinkedList<MenuVo>();

    List<Menu> firstMenuList = new ArrayList<Menu>();
    List<Menu> secondMenuList = new ArrayList<Menu>();

    for (Menu menu : menulist) {
      if (menu.getParentid() == 0 && menu.getDisabled() == 0) {
        firstMenuList.add(menu);
      } else {
        secondMenuList.add(menu);
      }
    }

    for (int i = 0; i < firstMenuList.size(); i++) {
      MenuVo vo = new MenuVo();
      vo.setTitle(firstMenuList.get(i).getTitle());
      vo.setIcon(firstMenuList.get(i).getIcon());
      List<Menu> mlist = new ArrayList<Menu>();
      for (int j = 0; j < secondMenuList.size(); j++) {
        if (firstMenuList.get(i).getId() == secondMenuList.get(j).getParentid()) {
          mlist.add(secondMenuList.get(j));
        }
      }
      vo.setChildren(mlist);
      menuvolist.add(vo);
    }

    return R.ok().put("menulist", menuvolist);
  }
}
