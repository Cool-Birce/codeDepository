package com.gec.test;

import com.gec.pojo.User;
import com.gec.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Brice
 * @title: Test01
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/911:09
 */
public class Test01 {
    @Test
    public void fun1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        List<User> allUser = userService.findAllUser();
        allUser.forEach(u -> System.out.println(u));

    }
}
