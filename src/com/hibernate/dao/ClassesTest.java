package com.hibernate.dao;

import com.hibernate.entity.Classes;
import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * @author : 张晋飞
 * date : 2019/4/10
 */
public class ClassesTest {

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
    public  void addClassAndStudent(){

        Classes classes =  new Classes();
        classes.setName("UI02");

        Student s1= new Student();
        s1.setName("小红1");
        s1.setClasses(classes);
        Student s2= new Student();
        s2.setName("小绿1");
        s2.setClasses(classes);

        classes.getStudentSet().add(s1);
        classes.getStudentSet().add(s2);

        session.save(classes);
        session.save(s1);
        session.save(s2);
    }

    @Test
    public  void queryStudentByClass(){

        Classes classes = session.get(Classes.class, 1);
        Set<Student> studentSet = classes.getStudentSet();
        for (Student s:studentSet) {
            System.out.println(s);
        }
    }

    //非关联修改：修改班级信息，并修改部门下全部员工的属性。
    @Test
    public  void update(){

        Classes classes = session.get(Classes.class, 1);
        classes.setName("java01");
        Set<Student> studentSet = classes.getStudentSet();
        for (Student s:studentSet) {
           s.setName("小小");
        }
    }
    // 设定员工不属于任何部门
    @Test
    public  void delete(){
        Student student = session.get(Student.class, 1);
        student.setClasses(null);
        session.save(student);
    }

    // 给学生添加班级
    @Test
    public  void addClassToStudnet(){
        Student student = session.get(Student.class, 1);
        Classes classes =session.get(Classes.class, 1);
        student.setClasses(classes);
        classes.getStudentSet().add(student);
    }

    // 给学生添加班级
    @Test
    public  void deleteClasses(){
        Classes classes =session.get(Classes.class, 1);
        session.delete(classes);
    }

}
