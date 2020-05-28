package com.zhkj.backstage.bean;

import java.io.Serializable;

public class BackstageGetOrderNum implements Serializable {

    /**
     * AllOrder : 2352
     * Complete : 1366
     * Inservice : 158
     * Outstanding : 35
     * Unanswered : 62
     * Noappointment : 53
     */

    private int AllOrder;
    private int Complete;
    private int Inservice;
    private int Outstanding;
    private int Unanswered;
    private int Noappointment;

    public int getAllOrder() {
        return AllOrder;
    }

    public void setAllOrder(int AllOrder) {
        this.AllOrder = AllOrder;
    }

    public int getComplete() {
        return Complete;
    }

    public void setComplete(int Complete) {
        this.Complete = Complete;
    }

    public int getInservice() {
        return Inservice;
    }

    public void setInservice(int Inservice) {
        this.Inservice = Inservice;
    }

    public int getOutstanding() {
        return Outstanding;
    }

    public void setOutstanding(int Outstanding) {
        this.Outstanding = Outstanding;
    }

    public int getUnanswered() {
        return Unanswered;
    }

    public void setUnanswered(int Unanswered) {
        this.Unanswered = Unanswered;
    }

    public int getNoappointment() {
        return Noappointment;
    }

    public void setNoappointment(int Noappointment) {
        this.Noappointment = Noappointment;
    }
}
