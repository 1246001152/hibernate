package com.xm.test;

import com.xm.entity.Classes;
import com.xm.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitTest {
    private Session session=null;

    @Before
    public void setUp(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @After
    public void tearDown(){
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void testStudentAndClasses(){

        Classes classes =  new Classes();
        classes.setClassName("高一");
        session.save(classes);
        Student stu1 =  new Student();
        stu1.setName("zhangjinfei1");
        stu1.setClasses(classes);

        Student stu2 =  new Student();
        stu2.setName("zhangjinfei2");
        stu2.setClasses(classes);
        session.save(stu1);
        session.save(stu2);
    }
}
