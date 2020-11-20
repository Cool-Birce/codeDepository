package com.gec.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
    private static SessionFactory sessionFactory;
    private static Session session=null;

    static {
        Configuration configuration = new Configuration();
        Configuration configure = configuration.configure();
        sessionFactory = configure.buildSessionFactory();
    }
    public static Session findSession(){
        session = sessionFactory.openSession();
        return session;
    }
    public static void close(){
        if(session!=null){
            session.close();
        }
        if(sessionFactory!=null){
            sessionFactory.close();
        }

    }
}
