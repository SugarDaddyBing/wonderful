package com.cruelbb.business.menu.po;

public class Menu {

  private int id;

  private String title;

  private int parentid;

  private String icon;

  private String href;

  private int disabled;// 0:正常 1：禁用

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getParentid() {
    return parentid;
  }

  public void setParentid(int parentid) {
    this.parentid = parentid;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public int getDisabled() {
    return disabled;
  }

  public void setDisabled(int disabled) {
    this.disabled = disabled;
  }

}
