package com.juzhi.entity;

/**
 * Created by xjwan on 5/11/14.
 */
public class InfoDetailed {
    private String id;
    private String name;
    private String time;
    private String author;
    private Number hot;
    private String info;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Number getHot() {
        return hot;
    }

    public void setHot(Number hot) {
        this.hot = hot;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
