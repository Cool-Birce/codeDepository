package com.gec.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import sun.security.provider.MD5;

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
        UsernamePasswordToken token = new UsernamePasswordToken("lisi", "111");
//        6.认证
        try {
            subject.login(token);
            //是否通过认证
            System.out.println("subject.isAuthenticated() = " + subject.isAuthenticated());
//            subject.logout();
//            System.out.println("subject.isAuthenticated() = " + subject.isAuthenticated());
            boolean hasRole = subject.hasRole("role1");
            System.out.println("hasRole = " + hasRole);
            // 基于资源的授权，调用isPermitted方法会调用CustomRealm从数据库查询正确权限数据
            // isPermitted传入权限标识符，判断user:create:1是否在CustomRealm查询到权限数据之内
            boolean isPermitted = subject.isPermitted("user:create");
            System.out.println("单个权限判断" + isPermitted);

            boolean isPermittedAll = subject.isPermittedAll("user:create:1",
                    "user:update:1");
            System.out.println("多个权限判断" + isPermittedAll);

            // 使用check方法进行授权，如果授权不通过会抛出异常
            //subject.checkPermission("items:add:1");

        } catch (AuthenticationException e) {
            e.printStackTrace();
            if (e instanceof UnknownAccountException) {
                System.out.println("登陆失败!用户名不存在!");
            }
            else if (e instanceof IncorrectCredentialsException) {
                System.out.println("登陆失败!密码错误!");
            }

        }

    }
    @Test
    public void md5(){
        String salt="abcd";
        Md5Hash md5Hash= new Md5Hash("111", salt, 1);
        System.out.println("md5Hash.toString() = " + md5Hash.toString());
    }
}
