package com.cruelbb.business.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 一个专门做路由跳转的controller
 *
 * @author wangbingyuan
 */
@Controller
public class MapController {


  @RequestMapping(value = "v3")
  public String v3() {
    return "user/v3";
  }

}
