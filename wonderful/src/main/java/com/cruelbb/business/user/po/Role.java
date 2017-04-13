package com.cruelbb.business.user.po;

/**
 * 角色表
 *
 * @author wangbingyuan
 */
public class Role {

  // 角色id
  private int id;

  // 角色名
  private String rolename;

  public int getRoleid() {
    return id;
  }

  public void setRoleid(int roleid) {
    this.id = roleid;
  }

  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }

}
