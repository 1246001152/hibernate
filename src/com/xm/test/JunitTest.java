package com.xm.test;

import com.xm.entity.Teacher;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Arrays;
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
    @Test
    public void queryTest() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Teacher t1= session.get(Teacher.class ,1);
        Teacher t2= session.get(Teacher.class ,2);
        Teacher t3= session.get(Teacher.class ,1);

        System.out.println(t1==t2);
        System.out.println(t1==t3);


        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void querySQL() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // 注意查询的是类名
        String sql = "select * from t_teacher";
        Query query = session.createSQLQuery(sql);
        List<Object[]> list = query.list();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void queryCriteria() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // 注意查询的是类名
        String sql = "select * from t_teacher";
        Criteria criteria = session.createCriteria(Teacher.class);
        List<Teacher> list = criteria.list();
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
        session.getTransaction().commit();
        session.close();
    }
}
