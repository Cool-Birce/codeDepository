package com.gec.service.impl;

import com.gec.dao.UserDao;
import com.gec.pojo.User;
import com.gec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Brice
 * @title: UserServiceImpl
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/911:38
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public User findUser(String name,String password) {
        User user = userDao.findUser(name);
            return user;
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }
}
