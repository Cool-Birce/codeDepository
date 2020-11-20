package com.gec.mapper;

import com.gec.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Brice
 * @title: UserMapper
 * @projectName mybatisDemo
 * @description: TODO
 * @date 2020/10/3110:14
 */
public interface UserMapper {

    List<User> findAll();
    User findById(@Param("id")int id);
    int addUser(User user);
    List<User> findByUser(User user);
    List<User> findInName(List<Object> list);

}
