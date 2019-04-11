package com.hibernate.dao;

import com.hibernate.entity.Classes;
import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author : 张晋飞
 * date : 2019/4/9
 */
public class StudnetJunit {

    Session session=null;
    @Before
    public void before(){
        session= HibernateUtil.getSession();
        session.beginTransaction();
    }

    @After
    public void after(){
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void addClassAndStudent(){
        Classes classes =  new Classes();
        classes.setName("java班");
        session.save(classes);

        Student s1 = new Student();
        s1.setName("小花");
        s1.setClasses(classes);
        session.save(s1);
    }
      @Test
    public void addStudent(){

        Classes classes =  new Classes();
        classes.setName("java2班");

        Student s1 = new Student();
        s1.setName("小花");
        s1.setClasses(classes);
        session.save(s1);
    }
    @Test
    public void queryStudent(){
        Student s = session.get(Student.class, 2);
        System.out.println(s);
    }

}
