package com.cruelbb.business.menu.vo;

import java.util.List;

import com.cruelbb.business.menu.po.Menu;

public class MenuVo {

  private String title;

  private String icon;

  private List<Menu> children;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public List<Menu> getChildren() {
    return children;
  }

  public void setChildren(List<Menu> children) {
    this.children = children;
  }

}
