package com.gec.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Brice
 * @title: SessionTool
 * @projectName homework02
 * @description: TODO
 * @date 2020/10/2916:19
 */
public class SessionTool {
    private static SqlSessionFactory sessionFactory = null;
    static{
        String config = "mybatis-config.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);
            sessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession foundSession(boolean flag){
        return sessionFactory.openSession(flag);
    }
}
