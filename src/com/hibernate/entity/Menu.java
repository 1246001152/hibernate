package com.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : 张晋飞
 * date : 2019/4/11
 */
@Entity
@Table(name="menu")
public class Menu {

    private Integer id;
    private String name;

    private Set<Role01> role01Set = new HashSet<>();

    @ManyToMany(mappedBy = "set")
    public Set<Role01> getRole01Set() {
        return role01Set;
    }

    public void setRole01Set(Set<Role01> role01Set) {
        this.role01Set = role01Set;
    }

    @Id
    @GeneratedValue(generator ="_native")
    @GenericGenerator(name = "_native",strategy = "native")
    @Column(name="m_id")
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
