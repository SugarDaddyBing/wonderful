package com.cruelbb.business.user.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户权限展示
 *
 * @author wangbingyuan
 */
public class UserRolePerm implements Serializable {

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 1L;

  /** 用户id */
  private String id;

  /** 昵称 */
  private String nickname;

  /** 邮箱 | 登录帐号 */
  private String email;

  /** 创建时间 */
  private Date createTime;

  /** 最后登录时间 */
  private Date lastLoginTime;

  /** 1:有效，0:禁止登录 */
  private int status;

  /** 对应的角色id */
  private int roleid;

  /** 角色名 */
  private String rolename;

  /** 权限名 */
  private String permissionname;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getCreateTime() {
    return createTime;
  }

  // @JsonFormat(pattern = "yyyy-MM-dd HH：mm：ss", timezone = "GMT + 8")
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  // @JsonFormat(pattern = "yyyy-MM-dd HH：mm：ss", timezone = "GMT + 8")
  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getRoleid() {
    return roleid;
  }

  public void setRoleid(int roleid) {
    this.roleid = roleid;
  }

  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }

  public String getPermissionname() {
    return permissionname;
  }

  public void setPermissionname(String permissionname) {
    this.permissionname = permissionname;
  }

}
