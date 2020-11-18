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
 * @projectName demo03
 * @description: TODO
 * @date 2020/11/219:14
 */
public class SessionTool {
    private static SqlSessionFactory build=null;
    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            build = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession foundSession(boolean flag){
        return build.openSession(flag);
    }
}
