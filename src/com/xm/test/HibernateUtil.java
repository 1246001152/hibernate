package com.xm.test;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory SESSION_FACTORY = null;

    static {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SESSION_FACTORY = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public  static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }
}
