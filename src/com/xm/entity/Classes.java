package com.xm.entity;

import java.util.HashSet;
import java.util.Set;

public class Classes {
    private int cId;
    private String className;
    private Set<Student> studentSet= new HashSet<>();

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

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
