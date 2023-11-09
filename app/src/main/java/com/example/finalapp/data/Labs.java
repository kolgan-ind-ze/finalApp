package com.example.finalapp.data;

import java.io.Serializable;

public class Labs implements Serializable {
    private int id;
    private String name;
    private String link;
    private String check;

    public Labs(String name, String link, String check) {
        this.name = name;
        this.link = link;
        this.check = check;
    }

    public Labs(){

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
}
