package com.example.shirodemo.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author Woo_home
 * @create 2020/8/21 13:19
 */

// 自定义的 UserRealm
public class UserRealm extends AuthorizingRealm {

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=》授权 doGetAuthorizationInfo");
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=》认证 doGetAuthenticationInfo");

        // 用户名，密码~  数据中取
        String username = "root";
        String password = "123456";

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;

        if (!userToken.getUsername().equals(username)) {
            return null;// 抛出异常 UnknownAccountException
        }

        // 密码认证，用 shiro 做~
        return new SimpleAuthenticationInfo("", password, "");
    }
}
