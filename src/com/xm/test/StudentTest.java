package com.xm.test;


import com.xm.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StudentTest {

    public static void main(String[] args) throws Exception, HibernateException {
//      Hibernate 4.0 创建sessionFactory
//      Configuration configuration = new Configuration();
//      configuration.configure();
//      SessionFactory sessionFactory = configuration.buildSessionFactory();

//      Hibernate 5.0 创建sessionFactory
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student s=  new Student();
        s.setName("zhangsan");
        s.setAge(20);
        session.save(s);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
