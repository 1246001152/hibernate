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
@Table(name="role_01")
public class Role01 {

    private Integer id;
    private String name;
    private Set<Menu> set = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_menu",
            joinColumns ={@JoinColumn(name="r_id")},
            inverseJoinColumns = {@JoinColumn(name="m_id")}
            )
    public Set<Menu> getSet() {
        return set;
    }

    public void setSet(Set<Menu> set) {
        this.set = set;
    }

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native",strategy = "native")
    @Column(name="r_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
