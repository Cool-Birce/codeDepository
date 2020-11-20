package com.gec.dao.Impl;

import com.gec.bean.PageBean;
import com.gec.bean.User;
import com.gec.dao.UserDao;
import com.gec.util.SessionUtil;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brice
 * @title: UserDaoImpl
 * @projectName homework02
 * @description: TODO
 * @date 2020/10/2619:48
 */
public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(User user) {
        Session session = SessionUtil.findSession();
        Transaction transaction = session.beginTransaction();
        try {
            Integer result = (Integer) session.save(user);
            System.out.println(result);
            transaction.commit();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SessionUtil.close();
        }
        return false;
    }

    @Override
    public User find(String name, String password) {
        Session session = SessionUtil.findSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.and(Restrictions.eq("userName", name), Restrictions.eq("userPassword", password)));
        ArrayList<User> list = (ArrayList<User>) criteria.list();

        //        String sql = "from User where userName=? and userPassword=?";
//        Query sqlQuery = session.createQuery(sql);
//        sqlQuery.setParameter(0, name);
//        sqlQuery.setParameter(1, password);
//        List<User> list = sqlQuery.list();
        return list.get(0);
    }

    @Override
    public ArrayList<User> findAll() {
        Session session = SessionUtil.findSession();
        Criteria criteria = session.createCriteria(User.class);
        ArrayList<User> list = (ArrayList<User>) criteria.list();
//        String hql="from User";
//        Query sqlQuery = session.createQuery(hql);
//        //分页
//        sqlQuery.setFirstResult(0);
//        sqlQuery.setMaxResults(3);
//        ArrayList<User> list = (ArrayList<User>) sqlQuery.list();
        return list;

    }

    @Override
    public PageBean<User> page(int pageNow) {
        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setPageNow(pageNow);
        pageBean.setPageSize(3);
        Session session = SessionUtil.findSession();
        //统计条数
        Criteria criteria = session.createCriteria(User.class);
        criteria.setProjection(Projections.count("id"));
        Long count = (Long) criteria.uniqueResult();
        int i = Integer.parseInt(count.toString());
        //总条数
        pageBean.setRowCount(i);
        //查询分页用户信息
        Criteria criteria1 = session.createCriteria(User.class);
        criteria1.setFirstResult((pageNow-1)*pageBean.getPageSize());
        criteria1.setMaxResults(pageBean.getPageSize());
        List<User> list = criteria1.list();
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public boolean update(User user) {
        Session session = SessionUtil.findSession();
        //查询
        User user1 = session.get(User.class, user.getId());
        user1 = user;
        if (user1 != null) {
            //修改
            session.update(user1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        Session session = SessionUtil.findSession();
        //查询
        User user1 = session.get(User.class, id);
        if (user1 != null) {
            //删除
            session.delete(user1);
            return true;
        } else {
            return false;
        }
    }
}
