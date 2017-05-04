package com.cruelbb.business.user.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cruelbb.business.common.web.PageIn;
import com.cruelbb.business.common.web.PageOut;
import com.cruelbb.business.common.web.R;
import com.cruelbb.business.user.bo.UserRolePerm;
import com.cruelbb.business.user.po.Role;
import com.cruelbb.business.user.service.UserService;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

//这个restcontroller=responsebody+controller
@RestController
@RequestMapping("/user/manage")
public class UserManageController {

  @Autowired
  private UserService userService;

  /**
   * 用户信息显示（分页，查询）
   *
   * @param params
   * @return
   */
  @RequestMapping("/list")
  public R list(@RequestParam Map<String, Object> params) {

    PageIn pageIn = new PageIn(params);
    String orderby = pageIn.getOrderby();
    PageBounds pageBounds = new PageBounds(pageIn.getPage(), pageIn.getLimit(), Order.formString(orderby), true);

    PageList<UserRolePerm> urp = (PageList<UserRolePerm>) userService.getURPByUsername(params, pageBounds);
    PageOut page = new PageOut(urp, urp.getPaginator().getTotalCount(), pageIn.getLimit(), pageIn.getPage());

    return R.ok().put("page", page);

  }

  @RequestMapping("/roleSelect")
  public R roleSelect() {
    List<Role> rlist = userService.getRoleList();
    return R.ok().put("rolelist", rlist);
  }
}
