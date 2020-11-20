package com.gec.controller;

import com.gec.pojo.User;
import com.gec.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @author Brice
 * @title: HomeController
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/916:03
 */
public class HomeController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] names = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(names));
        UserService us = context.getBean("userService", UserService.class);

        ModelAndView mav = new ModelAndView("index");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        User user = us.findUser(name, pwd);
        if(user!=null){
            if(user.getPassword().equals(pwd)){
                mav.addObject("user",user);
            }else{
                mav.addObject("msg","密码错误");
            }
        }else{
            mav.addObject("msg","用户不存在");

        }
        return mav;
    }
}
