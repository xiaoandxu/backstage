package com.zhkj.backstage.bean;

import java.io.Serializable;

public class SalesToday implements Serializable {

    /**
     * money : 35.0
     * Count : 1
     * orderCount : 858
     */

    private double money;
    private int Count;
    private int orderCount;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }
}
