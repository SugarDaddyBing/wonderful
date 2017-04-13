package com.cruelbb.core.shiro.token;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
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
    String username = TokenManager.getToken().getEmail();

    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    Set<String> rolename = userService.findRolesByEmail(username);
    Set<String> permissionname = userService.findPermissionsByEmail(username);
    info.setRoles(rolename);
    info.setStringPermissions(permissionname);
    return info;
  }

  /**
   * 认证信息，针对用户登录
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authtoken) throws AuthenticationException {
    ShiroToken token = (ShiroToken) authtoken;
    User user = userService.login(token.getUsername(), token.getPwd());
    if (null == user) {
      throw new AccountException("账号或密码不正确");
      /* 如果用户的status为禁用 */
    } else if (User._0.equals(user.getStatus())) {
      throw new DisabledAccountException("账号已经禁止登录");
    } else {

    }
    return new SimpleAuthenticationInfo(user, user.getPswd(), getName());
  }

}
