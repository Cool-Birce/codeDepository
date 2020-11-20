package com.gec.bean;

import com.gec.util.SessionUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Set;

/**
 * @author Brice
 * @title: Test
 * @projectName homework02
 * @description: TODO
 * @date 2020/10/2813:56
 */
public class Test1 {
    @Test
    public void fun1(){
        Session session = SessionUtil.findSession();
        User user = session.get(User.class, 1001);
        System.out.println(user);
        Set<Car> cars = user.getCars();
        for (Car car : cars) {
            System.out.println(car);
        }

    }
    @Test
    public void fun2(){
        Session session = SessionUtil.findSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, 1017);
        Car car =new Car();
        car.setCarName("路虎");
        car.setUser(user);
        Car car1 =new Car();
        car1.setCarName("悍马");
        car1.setUser(user);
        user.getCars().add(car);
        user.getCars().add(car1);
//        session.save(user);
        transaction.commit();

    }
    @Test
    public void fun3(){
        Session session = SessionUtil.findSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, 1002);
        Car car = session.get(Car.class, 3);
        car.setUser(user);
        transaction.commit();

    }


}
