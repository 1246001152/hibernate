package com.xm.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="t_teacher")
public class Classes {
    private int cId;
    private String className;
    private Set<Student> studentSet= new HashSet<>();

    @Id
    @GenericGenerator(name="_native" ,strategy = "native")
    @GeneratedValue(generator = "_native")
    @Column(name = "c_id")
    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Column(name = "class_name")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="C_ID")
    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "cId=" + cId +
                ", className='" + className + '\'' +
                ", studentSet=" + studentSet +
                '}';
    }
}
