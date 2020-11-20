package com.gec.service.impl;

import com.gec.bean.PageBean;
import com.gec.bean.User;
import com.gec.dao.Impl.UserDaoImpl;
import com.gec.dao.UserDao;
import com.gec.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brice
 * @title: UserServiceImpl
 * @projectName homework02
 * @description: TODO
 * @date 2020/10/2619:50
 */
public class UserServiceImpl implements UserService {
    private UserDao ud = new UserDaoImpl();
    @Override
    public boolean save(User user) {
        return ud.save(user);
    }

    @Override
    public User find(String name, String password) {
        return ud.find(name, password);
    }

    @Override
    public ArrayList<User> findAll() {
        return ud.findAll();
    }

    @Override
    public PageBean<User>page(int pageNow) {
        return ud.page(pageNow);
    }

    @Override
    public boolean update(User user) {
        return ud.update(user);
    }

    @Override
    public boolean delete(int id) {
        return ud.delete(id);
    }
}
