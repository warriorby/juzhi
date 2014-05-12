package com.juzhi.entity;

/**
 * Created by xjwan on 5/10/14.
 */
public class Hello {
    private int id;
    private String name;

    public Hello(){}

    public Hello(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
