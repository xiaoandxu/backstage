package com.zhkj.backstage.bean;

public class FactoryToll {
    private String Type;
    private String Price;

    public FactoryToll(String type, String price) {
        Type = type;
        Price = price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
