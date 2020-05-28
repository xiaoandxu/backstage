package com.zhkj.backstage.bean;

import java.io.Serializable;

public class GetCustomService implements Serializable {

    /**
     * id : 378
     * name : Bing
     */

    private int id;
    private String name;

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
