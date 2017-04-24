package com.cruelbb.business.sys.controller;

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
  @RequestMapping("/user/{url}")
  public String indexMap(@PathVariable("url") String url) {
    return "user/" + url;
  }
}
