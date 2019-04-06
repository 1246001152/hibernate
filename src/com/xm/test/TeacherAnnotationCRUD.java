package com.xm.test;


import com.xm.entity.Teacher;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class TeacherAnnotationCRUD {
    private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

    /**
     * 添加
     */
    public void add() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Teacher t=  new Teacher();
        t.settName("张晋飞");
        t.setSex("男");
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * 删除
     */
    public void delete() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Teacher teacher = session.get(Teacher.class, 1);
        if(teacher!=null){
            session.delete(teacher);
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

        Teacher teacher = new Teacher();
        teacher.settId(2);
        session.delete(teacher);

        session.getTransaction().commit();
        session.close();
    }

    /**
     * 修改
     */
    public void update() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Teacher teacher = session.get(Teacher.class, 1);

        teacher.settName("zhangjinfei");
        session.save(teacher);

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
        String hql="from Teacher";
        Query query = session.createQuery(hql);
        List<Teacher> list = query.list();
        for (Teacher Teacher :list) {
            System.out.println(Teacher);
        }
        session.getTransaction().commit();
        session.close();
    }

    public static void main(String[] args) throws Exception, HibernateException {

        TeacherAnnotationCRUD tac = new TeacherAnnotationCRUD();
//        tac.add();
//        tac.delete();
        tac.del();
//        tac.update();
//        tac.query();

    }


}
