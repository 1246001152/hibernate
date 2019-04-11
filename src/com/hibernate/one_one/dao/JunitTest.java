package com.hibernate.one_one.dao;

import com.hibernate.one_one.entity.HusBand;
import com.hibernate.one_one.entity.Wife;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author : 张晋飞
 * date : 2019/4/10
 */
public class JunitTest {

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
    public void addHusBand(){

        Wife wife = new Wife();
        wife.setName("赵敏");

        HusBand husBand  = new HusBand();
        husBand.setName("张无忌");

        husBand.setWife(wife);
        wife.setHusBand(husBand);

        session.save(husBand);
    }


}
