package com.zhkj.backstage.bean;

import java.io.Serializable;
import java.util.List;

public class LeftTitle implements Serializable {
    private String name;

    public LeftTitle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
