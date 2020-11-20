package com.gec.service.impl;

import com.gec.dao.UserMapper;
import com.gec.pojo.User;
import com.gec.pojo.UserExample;
import com.gec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Brice
 * @title: UserServiceImpl
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/1018:41
 */
@Service
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User login(String name, String pwd) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(name).andPasswordEqualTo(pwd);
        List<User> users = userMapper.selectByExample(example);
        return users.size() > 0 ? users.get(0) : null;
    }
}
