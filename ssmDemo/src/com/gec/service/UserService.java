package com.gec.service;

import com.gec.pojo.User;

import java.util.List;

/**
 * @author Brice
 * @title: UserService
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/1018:39
 */
public interface UserService {
    //查询所有用户
    List<User> findAll();
    //通过id查询用户
    User findById(Integer id);
    //登录
    User login(String name,String pwd);
}
