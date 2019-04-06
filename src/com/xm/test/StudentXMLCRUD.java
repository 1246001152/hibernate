package com.xm.test;


import com.xm.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StudentXMLCRUD {
    private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

    /**
     * 添加
     */
    public void add() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student s=  new Student();
        s.setName("zhangsan");
        s.setAge(20);
        session.save(s);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * 删除
     */
    public void delete() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = session.get(Student.class, 1);
        if(student!=null){
            session.delete(student);
        }

        session.getTransaction().commit();
        session.close();
    }
    /**
     * 删除第二方式
     */
    public void del() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = new Student();
        student.setId(2);
        session.delete(student);

        session.getTransaction().commit();
        session.close();
    }

    /**
     * 修改
     */
    public void update() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student stu = session.get(Student.class, 1);

        stu.setName("zhangsan1");
        stu.setAge(22);
        session.save(stu);

        session.getTransaction().commit();
        session.close();
    }

    /**
     * 查询
     */
    public void query() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // 注意查询的是类名
        String hql="from Student";
        Query query = session.createQuery(hql);
        List<Student> list = query.list();
        for (Student student :list) {
            System.out.println(student);
        }
        session.getTransaction().commit();
        session.close();
    }

    public static void main(String[] args) throws Exception, HibernateException {

        StudentXMLCRUD sxc = new StudentXMLCRUD();
//        sxc.add();
//        sxc.delete();
//        sxc.del();
//        sxc.update();
        sxc.query();

    }


}
