package com.cruelbb.business.common.web;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据封装类
 *
 * @author wangbingyuan
 */
public class R extends HashMap<String, Object> {

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = -3741642844045730858L;

  public R() {
    put("code", 0);
  }

  /**
   * error
   *
   * @param code
   * @param msg
   * @return
   */
  public static R error(int code, String msg) {
    R r = new R();
    r.put("code", code);
    r.put("msg", msg);
    return r;
  }

  public static R error() {
    return error(500, "未知错误,请联系管理员");
  }

  public static R error(String msg) {
    return error(500, msg);
  }

  public static R ok() {
    R r = new R();
    return r;
  }

  public static R ok(String msg) {
    R r = new R();
    r.put("msg", msg);
    return r;
  }

  public static R ok(Map<String, Object> map) {
    R r = new R();
    r.putAll(map);
    return r;
  }

  public R put(String key, Object value) {
    super.put(key, value);
    return this;
  }
}
