package com.cruelbb.business.user.po;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;

/**
 * 用户表
 *
 * @author wangbingyuan
 */
public class User implements Serializable {

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = -3554603888209177826L;

  // 0:禁止登录
  public static final Long _0 = new Long(0);

  // 1:有效
  public static final Long _1 = new Long(1);

  private String id;

  /** 昵称 */
  private String nickname;

  /** 邮箱 | 登录帐号 */
  private String email;

  /** 密码 */
  private transient String password;

  /** 创建时间 */
  private Date createTime;

  /** 最后登录时间 */
  private Date lastLoginTime;

  /** 1:有效，0:禁止登录 */
  private Long status;

  /* 对应的角色id */
  private int roleid;

  public User() {
  }

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

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPswd() {
    return password;
  }

  public void setPswd(String pswd) {
    this.password = pswd;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public String toString() {
    return JSONObject.fromObject(this).toString();
  }

  public int getRoleid() {
    return roleid;
  }

  public void setRoleid(int roleid) {
    this.roleid = roleid;
  }

}
