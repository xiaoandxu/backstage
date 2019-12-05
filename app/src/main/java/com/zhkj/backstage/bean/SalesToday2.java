package com.zhkj.backstage.bean;

import java.io.Serializable;

public class SalesToday2 implements Serializable {

    /**
     * factoryExamineCount : 0
     * MasterWorkerCount : 0
     * InServiceOreder : 35
     * LongRange : 6
     * TodayFactoryCount : 0
     * YesterdayFactoryCount : 1
     * TodayMasterWorkerCount : 1
     * YesterdayMasterWorkerCount : 6
     * ComplaintCount : 2
     * withdrawalCount : 64
     * factorycomplaint : 0
     */

    private int factoryExamineCount;
    private int MasterWorkerCount;
    private int InServiceOreder;
    private int LongRange;
    private int TodayFactoryCount;
    private int YesterdayFactoryCount;
    private int TodayMasterWorkerCount;
    private int YesterdayMasterWorkerCount;
    private int ComplaintCount;
    private int withdrawalCount;
    private int factorycomplaint;

    public int getFactoryExamineCount() {
        return factoryExamineCount;
    }

    public void setFactoryExamineCount(int factoryExamineCount) {
        this.factoryExamineCount = factoryExamineCount;
    }

    public int getMasterWorkerCount() {
        return MasterWorkerCount;
    }

    public void setMasterWorkerCount(int MasterWorkerCount) {
        this.MasterWorkerCount = MasterWorkerCount;
    }

    public int getInServiceOreder() {
        return InServiceOreder;
    }

    public void setInServiceOreder(int InServiceOreder) {
        this.InServiceOreder = InServiceOreder;
    }

    public int getLongRange() {
        return LongRange;
    }

    public void setLongRange(int LongRange) {
        this.LongRange = LongRange;
    }

    public int getTodayFactoryCount() {
        return TodayFactoryCount;
    }

    public void setTodayFactoryCount(int TodayFactoryCount) {
        this.TodayFactoryCount = TodayFactoryCount;
    }

    public int getYesterdayFactoryCount() {
        return YesterdayFactoryCount;
    }

    public void setYesterdayFactoryCount(int YesterdayFactoryCount) {
        this.YesterdayFactoryCount = YesterdayFactoryCount;
    }

    public int getTodayMasterWorkerCount() {
        return TodayMasterWorkerCount;
    }

    public void setTodayMasterWorkerCount(int TodayMasterWorkerCount) {
        this.TodayMasterWorkerCount = TodayMasterWorkerCount;
    }

    public int getYesterdayMasterWorkerCount() {
        return YesterdayMasterWorkerCount;
    }

    public void setYesterdayMasterWorkerCount(int YesterdayMasterWorkerCount) {
        this.YesterdayMasterWorkerCount = YesterdayMasterWorkerCount;
    }

    public int getComplaintCount() {
        return ComplaintCount;
    }

    public void setComplaintCount(int ComplaintCount) {
        this.ComplaintCount = ComplaintCount;
    }

    public int getWithdrawalCount() {
        return withdrawalCount;
    }

    public void setWithdrawalCount(int withdrawalCount) {
        this.withdrawalCount = withdrawalCount;
    }

    public int getFactorycomplaint() {
        return factorycomplaint;
    }

    public void setFactorycomplaint(int factorycomplaint) {
        this.factorycomplaint = factorycomplaint;
    }
}
