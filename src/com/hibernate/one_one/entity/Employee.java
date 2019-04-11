package com.hibernate.one_one.entity;

/**
 * @author : 张晋飞
 * date : 2019/4/10
 */
public class Employee {

    private int id;
    private String name;

    private JoinPart joinPart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JoinPart getJoinPart() {
        return joinPart;
    }

    public void setJoinPart(JoinPart joinPart) {
        this.joinPart = joinPart;
    }
}
