package com.hibernate.dao;

import com.hibernate.entity.User;
import com.hibernate.framework.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 张晋飞
 * date : 2019/4/12
 */
public class UserDao {

    /**
     * 查询分页
     * 参数： 页码  每页条数
     */
    public List<User> queryPageUser(int pageIndex,int pageCount){
        List<User> list  =  new ArrayList<>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from User");
            // mysql 分页需要  索引和每页条数
            //索引
            query.setFirstResult((pageIndex-1)*pageCount);
            //每页条数
            query.setMaxResults(pageCount);

            list = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return list;
    }
    // 分页  总页数
    public int pages(int pageCount){
        int pages = 1;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createQuery("select count(1) from User");
        // 总条数
        Number number = (Number)query.uniqueResult();
        session.getTransaction().commit();
        session.close();

        pages = (number.intValue()+pageCount-1)/pageCount;
        return pages;
    }


    /*public static void main(String[] args) {

        List<User> users = new UserDao().queryPageUser(2, 5);
        for (User user:users) {
            System.out.println(user);
        }

        System.out.println(new UserDao().pages(3));
    }
*/
}
