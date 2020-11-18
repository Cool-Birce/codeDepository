package com.gec.authentication;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Brice
 * @title: CustomRealm
 * @projectName mainDemo
 * @description: TODO
 * @date 2020/11/1916:52
 */
public class CustomRealm extends AuthorizingRealm {
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //提供身份信息获取主身份信息
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        System.out.println("primaryPrincipal = " + primaryPrincipal);
        //根据主身份信息去数据库查询,角色,权限
        List<String> list = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        list.add("user:create");
        list.add("user:update");
        list2.add("user=role1");
        list2.add("user=role2");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.addStringPermissions(list);
        info.addRoles(list2);

        return info;
    }
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Object username = token.getPrincipal();
        System.out.println("username = " + username);
        String password1 = new String((char[])token.getCredentials());
        System.out.println("password1 = " + password1);
        //模拟数据库
        //String password="111";
        String password="2d77405ebe1ac72b54945c2386eab1e1";
        //盐
        String salt="abcd";
        //SimpleAuthenticationInfo ias = new SimpleAuthenticationInfo(username, password, "ias");
        //shiro为MD5算法提供专门的方法
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes(salt), "info");
        return info;
    }
}
