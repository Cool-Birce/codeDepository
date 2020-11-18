package com.gec;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @author Brice
 * @title: Test1
 * @projectName mainDemo
 * @description: TODO
 * @date 2020/11/1914:06
 */
public class Test1 {

    public static void main(String[] args) {
        //1.创建SecurityManger工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
//        2.获取SecurityManger对象
        SecurityManager manager = factory.getInstance();
//      3.将SecurityManger配置到环境中
        SecurityUtils.setSecurityManager(manager);
//        4.获取subject主体对象
        Subject subject = SecurityUtils.getSubject();
//        5模拟登陆
        UsernamePasswordToken token = new UsernamePasswordToken("lisi", "222");
//        6.认证
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            if (e instanceof UnknownAccountException) {
                System.out.println("登陆失败!用户名不存在!");
            }
            else if (e instanceof IncorrectCredentialsException) {
                System.out.println("登陆失败!密码错误!");
            }
            //是否通过认证
            System.out.println("subject.isAuthenticated() = " + subject.isAuthenticated());
            subject.logout();
            System.out.println("subject.isAuthenticated() = " + subject.isAuthenticated());
        }
    }
}
