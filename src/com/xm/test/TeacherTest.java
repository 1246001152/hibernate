package com.xm.test;


import com.xm.entity.Classes;
import com.xm.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TeacherTest {

    public static void main(String[] args) throws Exception, HibernateException {

        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Classes classes =  new Classes();
        classes.setClassName("高一2");
        Student stu1 =  new Student();
        stu1.setName("zhangjinfei1");
        stu1.setClasses(classes);

        Student stu2 =  new Student();
        stu2.setName("zhangjinfei2");
        stu2.setClasses(classes);

        classes.getStudentSet().add(stu1);
        classes.getStudentSet().add(stu2);

        session.save(classes);
        session.getTransaction().commit();
        session.close();
    }
}
