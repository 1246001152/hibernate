package com.hibernate.framework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author : 张晋飞
 * date : 2019/4/12
 */
public class HibernateUtil {

    private  static SessionFactory SESSIONFACTORY=null;
    private static Session session=null;


    public static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration().configure();
        if(SESSIONFACTORY==null){
            SESSIONFACTORY = configuration.buildSessionFactory();
        }
        return SESSIONFACTORY;
    }

    public static Session getSession(){
            session=getSessionFactory().openSession();
        return session;
    }


}
