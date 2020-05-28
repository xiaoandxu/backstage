package com.zhkj.backstage.bean;

import java.io.Serializable;

public class GetCustomService2 implements Serializable {

    /**
     * id : 378
     * name : Bing
     */

    private int id;
    private String name;
    private boolean select;

    public GetCustomService2(int id, String name, boolean select) {
        this.id = id;
        this.name = name;
        this.select = select;
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

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
