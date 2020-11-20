package com.gec.dao;

import com.gec.pojo.User;

import java.util.List;

/**
 * @author Brice
 * @title: UserDao
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/911:18
 */
public interface UserDao {
    List<User> findAllUser();
    User findUser(String name);
    int addUser(User user);
}
