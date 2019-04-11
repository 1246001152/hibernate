package com.hibernate.dao;

import com.hibernate.entity.Menu;
import com.hibernate.entity.Role;
import com.hibernate.entity.Role01;
import com.hibernate.entity.User;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author : 张晋飞
 * date : 2019/4/9
 */
public class JunitTest {

    Session session=null;
    @Before
    public void before(){
        session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    @After
    public void after(){
        session.getTransaction().commit();
        session.close();
    }

    //添加用户和角色
    @Test
    public void addUserAndRole(){
        User user1 = new User("aaa111","aaa111");
        User user2 = new User("bbb222","bbb222");
        User user3 = new User("ccc333","ccc333");
        Role role1 = new Role();
        role1.setName("新闻管理员");
        Role role2 = new Role();
        role2.setName("文档管理员");
        user1.getRole().add(role1);
        user1.getRole().add(role2);

        user2.getRole().add(role1);
        user2.getRole().add(role2);

        user3.getRole().add(role1);

        session.save(user1);
        session.save(user2);
        session.save(user3);
    }

    //删除用户的角色
    @Test
    public void deleteUserRole(){
        User user = session.get(User.class, 1);
        Role role = session.get(Role.class, 1);
        user.getRole().add(role);
    }
    @Test
    public void addRoleAndMenu(){

        Menu menu1 = new Menu();
        menu1.setName("管理员url");
        Menu menu2 = new Menu();
        menu2.setName("安保url");

        Role01 role01 =  new Role01();
        role01.setName("管理员");
        role01.getSet().add(menu1);
        role01.getSet().add(menu2);

        Role01 role02 =  new Role01();
        role02.setName("保安");
        role02.getSet().add(menu2);

        session.save(role01);
        session.save(role02);

    }

}
