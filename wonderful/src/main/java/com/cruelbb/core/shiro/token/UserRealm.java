package com.cruelbb.core.shiro.token;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.cruelbb.business.user.po.User;
import com.cruelbb.business.user.service.UserService;
import com.cruelbb.core.shiro.token.manager.TokenManager;

/**
 * shiro 认证 +授权
 *
 * @author wangbingyuan
 *
 */
public class UserRealm extends AuthorizingRealm {

  @Autowired
  private UserService userService;

  /**
   * 用于权限的认证
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    //String username = TokenManager.getToken().getEmail();
    User user = (User)principals.getPrimaryPrincipal();
    String username = user.getEmail();
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    Set<String> rolename = userService.findRolesByUsername(username);
    info.setRoles(rolename);
    Set<String> permissionname = userService.findPermissionsByUsername(username);
    info.setStringPermissions(permissionname);
    return info;
  }

  /**
   * 认证信息，针对用户登录
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authtoken) throws AuthenticationException {
    ShiroToken token = (ShiroToken) authtoken;
    User user = userService.validateByusernameAndPwd(token.getUsername(), token.getPwd());
    // 账号不存在
    if (null == user) {
      throw new UnknownAccountException("账号或密码不正确");
      /* 如果用户的status为禁用 */
    }
    if (User.BAN == user.getStatus()) {
      throw new LockedAccountException("账号已经禁止登录");
    }
    return new SimpleAuthenticationInfo(user, user.getPswd(), getName());
  }

}
