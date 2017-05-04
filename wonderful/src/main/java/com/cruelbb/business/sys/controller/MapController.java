package com.cruelbb.business.sys.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 一个专门做路由跳转的controller
 *
 * @author wangbingyuan
 */
@Controller
public class MapController {

  /**
   * index页面map
   *
   * @param url
   * @return view
   */
  @RequiresRoles(value = {"管理员", "V3"}, logical = Logical.OR)
  @RequestMapping("/user/{url}")
  public String indexMap(@PathVariable("url") String url) {
    return "user/" + url + ".html";
  }
}
