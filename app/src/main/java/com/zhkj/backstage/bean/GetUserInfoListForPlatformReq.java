package com.zhkj.backstage.bean;

public class GetUserInfoListForPlatformReq {
    private String Type;
    private String limit;
    private String page;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
