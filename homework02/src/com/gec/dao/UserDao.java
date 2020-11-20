package com.gec.dao;

import com.gec.bean.PageBean;
import com.gec.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brice
 * @title: UserDao
 * @projectName homework02
 * @description: TODO
 * @date 2020/10/2619:45
 */
public interface UserDao {
    boolean save(User user);
    User find(String name,String password);
    ArrayList<User> findAll();
    PageBean<User> page(int pageNow);
    boolean update(User user);
    boolean delete(int id);
}
