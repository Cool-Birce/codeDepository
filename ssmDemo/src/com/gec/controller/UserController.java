package com.gec.controller;

import com.gec.pojo.Product;
import com.gec.pojo.User;
import com.gec.service.ProductService;
import com.gec.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Brice
 * @title: UserController
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/1018:43
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    private ModelAndView mav;

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user) {
        mav = new ModelAndView();
        User user1 = userService.login(user.getUsername(), user.getPassword());
        if (user != null) {
            return "1";
        } else {
            return "用户不存在或者密码错误";
        }

    }

    @RequestMapping("/loginView")
    public ModelAndView loginView() {
        return new ModelAndView("login");
    }
}
