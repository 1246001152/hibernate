package com.xm.test;


import com.xm.entity.Classes;
import com.xm.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentTest {

    public static void main(String[] args) throws Exception, HibernateException {

        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Classes classes =  new Classes();
        classes.setClassName("高一");
//      级联保存需要在hbm.xml 中配置 cascade ，cascade 默认none, 强制级联保存用sava-update
//        session.save(classes);
        Student stu1 =  new Student();
        stu1.setName("zhangjinfei1");
        stu1.setClasses(classes);

        Student stu2 =  new Student();
        stu2.setName("zhangjinfei2");
        stu2.setClasses(classes);
        session.save(stu1);
        session.save(stu2);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
