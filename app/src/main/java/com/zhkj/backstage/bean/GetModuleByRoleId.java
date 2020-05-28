package com.zhkj.backstage.bean;

import java.io.Serializable;

public class GetModuleByRoleId implements Serializable {

    /**
     * StatusCode : 200
     * Info : 请求(或处理)成功
     * Count : 0
     * Data : [{"Id":3,"ModuleID":3,"ModuleName":"用户管理","ModuleUrl":"/pb/user","ParentID":2,"Sort":1,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":69,"ModuleID":69,"ModuleName":"师傅管理","ModuleUrl":"/pb/workerUser","ParentID":2,"Sort":2,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":70,"ModuleID":70,"ModuleName":"工厂管理","ModuleUrl":"/pb/factoryUser","ParentID":2,"Sort":3,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":7,"ModuleID":7,"ModuleName":"所有工单","ModuleUrl":"/order/order","ParentID":6,"Sort":1,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":73,"ModuleID":73,"ModuleName":"我的工单","ModuleUrl":"/order/customerService","ParentID":6,"Sort":10,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":75,"ModuleID":75,"ModuleName":"用户审核管理","ModuleUrl":"/pb/auth","ParentID":6,"Sort":11,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":59,"ModuleID":59,"ModuleName":"新增地址","ModuleUrl":"/config/editaddress","ParentID":18,"Sort":1,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":24,"ModuleID":24,"ModuleName":"品牌管理","ModuleUrl":"/factory/brand","ParentID":23,"Sort":1,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":36,"ModuleID":36,"ModuleName":"分类管理","ModuleUrl":"/factory/category","ParentID":23,"Sort":2,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":25,"ModuleID":25,"ModuleName":"型号管理","ModuleUrl":"/factory/producttype","ParentID":23,"Sort":3,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":27,"ModuleID":27,"ModuleName":"配件管理","ModuleUrl":"/factory/accessory","ParentID":23,"Sort":4,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":28,"ModuleID":28,"ModuleName":"服务管理","ModuleUrl":"/factory/factoryservice","ParentID":23,"Sort":5,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":60,"ModuleID":60,"ModuleName":"发单优惠","ModuleUrl":"/pb/Discount","ParentID":23,"Sort":6,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":66,"ModuleID":66,"ModuleName":"分类超级管理","ModuleUrl":"/factory/SuperClassification","ParentID":23,"Sort":7,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":40,"ModuleID":40,"ModuleName":"配件审核","ModuleUrl":"/factory/accessoryapply","ParentID":23,"Sort":8,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":31,"ModuleID":31,"ModuleName":"栏目管理","ModuleUrl":"/cms/categorycontent","ParentID":30,"Sort":1,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":32,"ModuleID":32,"ModuleName":"个人消息管理","ModuleUrl":"/cms/accountmessage","ParentID":30,"Sort":2,"RoleID":19,"Icon":null,"IsUse":"Y","Version":0},{"Id":2,"ModuleID":2,"ModuleName":"权限管理","ModuleUrl":null,"ParentID":999,"Sort":2,"RoleID":0,"Icon":"layui-icon-user","IsUse":"Y","Version":0},{"Id":6,"ModuleID":6,"ModuleName":"工单管理","ModuleUrl":null,"ParentID":999,"Sort":3,"RoleID":0,"Icon":"layui-icon-template","IsUse":"Y","Version":0},{"Id":23,"ModuleID":23,"ModuleName":"厂商配置","ModuleUrl":null,"ParentID":999,"Sort":4,"RoleID":0,"Icon":"layui-icon-senior","IsUse":"Y","Version":0},{"Id":30,"ModuleID":30,"ModuleName":"文章管理","ModuleUrl":null,"ParentID":999,"Sort":8,"RoleID":0,"Icon":"layui-icon-component","IsUse":"Y","Version":0},{"Id":18,"ModuleID":18,"ModuleName":"系统设置","ModuleUrl":null,"ParentID":999,"Sort":10,"RoleID":0,"Icon":"layui-icon-set","IsUse":"Y","Version":0}]
     */

    private int StatusCode;
    private String Info;
    private int Count;
    private String Data;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }
}
