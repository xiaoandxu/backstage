package com.zhkj.backstage.bean;

import java.io.Serializable;

public class SalesToday3 implements Serializable {

    /**
     * newOrder : 4
     * completeCount : 379
     * AbolishCount : 60
     * QualityAssurance : 12
     * serviceCount : 6
     * ComplaintCount2 : 2
     * LeavemessageServiceCount : 148
     * OrderAccessroyDetailCount : 290
     */

    private int newOrder;
    private int completeCount;
    private int AbolishCount;
    private int QualityAssurance;
    private int serviceCount;
    private int ComplaintCount2;
    private int LeavemessageServiceCount;
    private int OrderAccessroyDetailCount;
    private int YesterdayOrder;
    private int TobePaid;

    public int getTobePaid() {
        return TobePaid;
    }

    public void setTobePaid(int tobePaid) {
        TobePaid = tobePaid;
    }

    public int getYesterdayOrder() {
        return YesterdayOrder;
    }

    public void setYesterdayOrder(int yesterdayOrder) {
        YesterdayOrder = yesterdayOrder;
    }


    public int getNewOrder() {
        return newOrder;
    }

    public void setNewOrder(int newOrder) {
        this.newOrder = newOrder;
    }

    public int getCompleteCount() {
        return completeCount;
    }

    public void setCompleteCount(int completeCount) {
        this.completeCount = completeCount;
    }

    public int getAbolishCount() {
        return AbolishCount;
    }

    public void setAbolishCount(int AbolishCount) {
        this.AbolishCount = AbolishCount;
    }

    public int getQualityAssurance() {
        return QualityAssurance;
    }

    public void setQualityAssurance(int QualityAssurance) {
        this.QualityAssurance = QualityAssurance;
    }

    public int getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(int serviceCount) {
        this.serviceCount = serviceCount;
    }

    public int getComplaintCount2() {
        return ComplaintCount2;
    }

    public void setComplaintCount2(int ComplaintCount2) {
        this.ComplaintCount2 = ComplaintCount2;
    }

    public int getLeavemessageServiceCount() {
        return LeavemessageServiceCount;
    }

    public void setLeavemessageServiceCount(int LeavemessageServiceCount) {
        this.LeavemessageServiceCount = LeavemessageServiceCount;
    }

    public int getOrderAccessroyDetailCount() {
        return OrderAccessroyDetailCount;
    }

    public void setOrderAccessroyDetailCount(int OrderAccessroyDetailCount) {
        this.OrderAccessroyDetailCount = OrderAccessroyDetailCount;
    }
}
