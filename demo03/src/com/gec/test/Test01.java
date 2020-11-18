package com.gec.test;

import com.gec.mapper.CustomerOrderMapper;
import com.gec.mapper.OrderMapper;
import com.gec.mapper.UserMapper;
import com.gec.pojo.CustomerOrder;
import com.gec.pojo.Order;
import com.gec.pojo.User;
import com.gec.util.SessionTool;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Brice
 * @title: Test01
 * @projectName mybatisDemo
 * @description: TODO
 * @date 2020/11/217:16
 */
public class Test01 {

    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        InputStream configFile = Resources.getResourceAsStream("generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("完成");
    }
    //一对一
    @Test
    public void fun1(){
        SqlSession session = SessionTool.foundSession(true);
        CustomerOrderMapper mapper = session.getMapper(CustomerOrderMapper.class);
        List<CustomerOrder> customerOrders = mapper.findAll();
        for (CustomerOrder customerOrder : customerOrders) {
            System.out.println(customerOrder);
        }
    }
    //一对一
    @Test
    public void fun11(){
        SqlSession session = SessionTool.foundSession(true);
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        List<Order> orders = mapper.findOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }
    //多对一&一对多
    @Test
    public void fun2(){
        SqlSession session = SessionTool.foundSession(true);
        CustomerOrderMapper mapper = session.getMapper(CustomerOrderMapper.class);
        List<CustomerOrder> customerOrders = mapper.oneBymore(1);
        for (CustomerOrder customerOrder : customerOrders) {
            System.out.println(customerOrder);
        }
    }
    @Test
    public void fun22(){
        SqlSession session = SessionTool.foundSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.findUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
