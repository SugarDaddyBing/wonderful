package com.cruelbb.business.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cruelbb.business.common.web.Page;
import com.cruelbb.business.common.web.R;
import com.cruelbb.business.user.bo.UserRolePerm;
import com.cruelbb.business.user.service.UserService;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@RestController
@RequestMapping("/user/manage")
public class UserManageController {

  @Autowired
  private UserService userService;

  // @ResponseBody
  @RequestMapping("/list")
  public R list(@RequestParam Map<String, Object> params) {

    String email = "774153195@qq.com";
    PageBounds pageBounds = new PageBounds(1, 1, Order.formString("createtime.desc"), true);
    List<UserRolePerm> urp = userService.getURPByUsername(email);
    Page page = new Page(urp, 1, 1, 1);
    return (R) R.ok().put("page", page);

  }
}
