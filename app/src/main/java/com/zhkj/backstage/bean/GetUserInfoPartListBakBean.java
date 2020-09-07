package com.zhkj.backstage.bean;

import java.io.Serializable;

public class GetUserInfoPartListBakBean implements Serializable {
    private String ProvinceCode;
    private String Type;
    private String limit;
    private String page;
    private String RoleId;

    public String getRoleId() {
        return RoleId;
    }

    public void setRoleId(String roleId) {
        RoleId = roleId;
    }

    public String getProvinceCode() {
        return ProvinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        ProvinceCode = provinceCode;
    }

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
