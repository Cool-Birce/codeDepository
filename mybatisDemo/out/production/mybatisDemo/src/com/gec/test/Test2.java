package com.gec.test;

import com.gec.mapper.UserMapper;
import com.gec.pojo.User;
import com.gec.util.SessionTool;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Brice
 * @title: Test2
 * @projectName mybatisDemo
 * @description: TODO
 * @date 2020/10/3110:13
 */
public class Test2 {

    @Test
    public void fun1() {
        SqlSession session = SessionTool.foundSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }

    }
    @Test
    public void fun2() {
        SqlSession session = SessionTool.foundSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.findById(1001);
            System.out.println(user);

    }
    @Test
    public void fun3() {
        SqlSession session = SessionTool.foundSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user1 = new User(0, "黄蓉", "123", "靓女");
        int i = mapper.addUser(user1);
        System.out.println(i);
            System.out.println(user1.getId());
    }
    @Test
    public void fun4() {
        SqlSession session = SessionTool.foundSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user1 = new User(0, "黄蓉", "123", "靓女");
        List<User> user = mapper.findByUser(user1);
        user.forEach(a -> System.out.println(a));
    }
    @Test
    public void fun5() {
        SqlSession session = SessionTool.foundSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<Object> list = new ArrayList<>();
        list.add("黄蓉");
        list.add("admin");
        List<User> user = mapper.findInName(list);
        user.forEach(a -> System.out.println(a));
        Map map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);
        map.forEach((k,v) -> System.out.println(k+","+v));
    }
}
