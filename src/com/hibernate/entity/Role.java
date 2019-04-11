package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : 张晋飞
 * date : 2019/4/11
 */
public class Role {

    private Integer id;
    private String name;


    private Set<User> set= new HashSet<>();

    public Set<User> getSet() {
        return set;
    }

    public void setSet(Set<User> set) {
        this.set = set;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
