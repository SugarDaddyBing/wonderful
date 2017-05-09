package com.cruelbb.business.user.vo;

import com.cruelbb.business.user.po.User;



public class UserVo extends User {

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 1L;

  private String rolename;

  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }
}
