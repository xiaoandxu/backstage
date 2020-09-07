package com.zhkj.backstage.bean;

import java.io.Serializable;

public class GetCustomService implements Serializable {

    /**
     * id : 378
     * name : Bing
     */

    private int id;
    private String name;
    private String trueName;
    private boolean select;

    public GetCustomService(int id, String name, String trueName, boolean select) {
        this.id = id;
        this.name = name;
        this.trueName = trueName;
        this.select = select;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
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
