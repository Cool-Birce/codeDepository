package com.gec.dao;

import com.gec.bean.User;
import com.gec.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * @author Brice
 * @title: Test1
 * @projectName Test
 * @description: TODO
 * @date 2020/10/2615:38
 */
public class Test1 {
    @Test
    public void test(){
        Configuration conf = new Configuration();
        Configuration configure = conf.configure();
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, 1002);
        System.out.println(user);

    }
    @Test
    public void save(){
        Session session = SessionUtil.findSession();
        Transaction transaction = session.beginTransaction();
        try {
            Integer result  = (Integer) session.save(new User("小明", "123", "433.jpg"));
            System.out.println(result);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SessionUtil.close();
        }
    }
}
