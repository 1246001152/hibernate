package com.xm.test;

import com.xm.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class JunitTest {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Test
    public void add() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Teacher t = new Teacher();
        t.settName("张晋飞");
        t.setSex("男");
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void delete() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Teacher teacher = session.get(Teacher.class, 1);
        if (teacher != null) {
            session.delete(teacher);
        }

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void update() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Teacher teacher = session.get(Teacher.class, 1);

        teacher.settName("zhangjinfei");
        session.save(teacher);

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void query() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // 注意查询的是类名
        String hql = "from Teacher";
        Query query = session.createQuery(hql);
        List<Teacher> list = query.list();
        for (Teacher Teacher : list) {
            System.out.println(Teacher);
        }
        session.getTransaction().commit();
        session.close();
    }

}
