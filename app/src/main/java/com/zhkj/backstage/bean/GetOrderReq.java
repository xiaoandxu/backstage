package com.zhkj.backstage.bean;

public class GetOrderReq {
    public String Type="7";
    public String StartTime;
    public String EndTime;
    public String page;
    public String limit;

    public GetOrderReq(String startTime, String endTime, String page, String limit) {
        StartTime = startTime;
        EndTime = endTime;
        this.page = page;
        this.limit = limit;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}
