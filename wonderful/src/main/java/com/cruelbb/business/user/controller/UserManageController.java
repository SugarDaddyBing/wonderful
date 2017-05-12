package com.cruelbb.business.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cruelbb.business.common.web.PageIn;
import com.cruelbb.business.common.web.PageOut;
import com.cruelbb.business.common.web.R;
import com.cruelbb.business.user.po.Role;
import com.cruelbb.business.user.po.User;
import com.cruelbb.business.user.service.UserService;
import com.cruelbb.business.user.vo.UserRolePerm;
import com.cruelbb.business.user.vo.UserVo;
import com.cruelbb.core.shiro.token.manager.TokenManager;
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

  /**
   * 角色列表支持
   *
   * @return
   */
  @RequestMapping("/roleSelect")
  public R roleSelect() {
    List<Role> rlist = userService.getRoleList();
    return R.ok().put("rolelist", rlist);
  }

  /**
   * 用于用户管理的更新功能
   *
   * @param user
   * @return
   */
  @RequestMapping("/userUpdate")
  public R userUpdate(UserVo user) {

    if (userService.updateUser(user)) {
      return R.ok();
    } else {
      return R.error();
    }
  }

  /**
   * 当前登录用户信息
   *
   * @return
   */
  @RequestMapping("/getUser")
  public R getUser() {
    User user = TokenManager.getToken();
    return R.ok().put("user", user);
  }
}
