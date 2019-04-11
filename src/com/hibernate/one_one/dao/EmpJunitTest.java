package com.hibernate.one_one.dao;

import com.hibernate.one_one.entity.Employee;
import com.hibernate.one_one.entity.JoinPart;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author : 张晋飞
 * date : 2019/4/10
 */
public class EmpJunitTest {
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

        JoinPart joinPart =  new JoinPart();
        joinPart.setPname("党员");
        Employee employee = new Employee();
        employee.setName("小衫");
        employee.setJoinPart(joinPart);
        joinPart.setEmployee(employee);

        session.save(employee);
        session.save(joinPart);
    }

}
