package com.hibernate.one_one.entity;

/**
 * @author : 张晋飞
 * date : 2019/4/10
 */
public class JoinPart {

    private int id;
    private String  pname;

    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
