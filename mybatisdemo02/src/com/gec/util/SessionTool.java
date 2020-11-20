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
 * @projectName mybatisdemo02
 * @description: TODO
 * @date 2020/10/309:23
 */
public class SessionTool {
    private static SqlSessionFactory build = null;
    static {
        //1.导入配置文件
        String config = "mybatis-config.xml";
        //2.用Resources获取文件
        try {
            InputStream is = Resources.getResourceAsStream(config);
            //创建SqlSessionFactory对象
            build = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //创建Session并且判断是否自动提交,默认手动提交
    public static SqlSession foundSession(boolean flag){
        return build.openSession(flag);
    }


}
