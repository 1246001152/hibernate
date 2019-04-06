package com.xm.entity;

import java.util.HashSet;
import java.util.Set;

public class Node {

    private int id;
    private String name;

    private Node pNode;
    private Set<Node> set= new HashSet<>();

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

    public Node getpNode() {
        return pNode;
    }

    public void setpNode(Node pNode) {
        this.pNode = pNode;
    }

    public Set<Node> getSet() {
        return set;
    }

    public void setSet(Set<Node> set) {
        this.set = set;
    }
}
