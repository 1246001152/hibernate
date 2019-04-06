package com.xm.test;


import com.xm.entity.Teacher;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TeacherTest {

    public static void main(String[] args) throws Exception, HibernateException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Teacher t=  new Teacher();
        t.settName("zhangsan");
        t.setSex("男");

        session.save(t);
        session.getTransaction().commit();
        session.close();
    }
}
