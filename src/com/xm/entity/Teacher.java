package com.xm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="t_teacher")
public class Teacher {

    private Integer tId;
    private String tName;
    private String sex;
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name="_native" ,strategy = "native")
    @Column(name="t_id")
    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }
    @Column(name = "t_name" ,length = 50)
    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    @Column
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
