package com.hibernate.dao;

import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;

/**
 * @author : 张晋飞
 * date : 2019/4/9
 */
public class StudentDao {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Student student= new Student();
        student.setName("zhangsan");
        session.save(student);

        session.getTransaction().commit();
        session.close();
    }


}
