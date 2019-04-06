package com.xm.test;

import com.xm.entity.Classes;
import com.xm.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

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

    @Test
    public void getStudentByClasses(){

        Classes classes = session.get(Classes.class, 1);
        Set<Student> studentSet = classes.getStudentSet();
        for (Student student:studentSet) {
            System.out.println(student);
        }
    }


    @Test
    public void testDeleteCalsses(){
        // 级联删除  改变 cascade = delete  实现级联删除
        Classes classes = session.get(Classes.class, 1);

        session.delete(classes);
    }


    @Test
    public void testClassStaut(){

        Classes c1 =  new Classes(); // 临时对象
        c1.setClassName("一班");
        Classes c2 =  new Classes();
        c1.setClassName("二班");

        session.save(c1); // 持久化对象
        session.save(c2);

        session.delete(c2); // 删除对象 从数据库删除的

        // 提交事物之后的状态是 游离状态
    }
}
