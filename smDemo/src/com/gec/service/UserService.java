package com.gec.service;

import com.gec.pojo.User;

import java.util.List;

/**
 * @author Brice
 * @title: UserService
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/911:20
 */
public interface UserService {
    List<User> findAllUser();
    User findUser(String name,String password);
    int addUser(User user);
}
