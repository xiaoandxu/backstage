package com.zhkj.backstage.bean;

import java.io.Serializable;
import java.util.List;

public class WithDrawList implements Serializable {

    /**
     * code : 0
     * msg : success
     * count : 3
     * data : [{"Id":334,"WithDrawID":334,"UserID":"13475077703","PayMoney":33.95,"PayInfo":"山东省农村信用社联合社","PayName":"李树勇","PayNo":"6223201301044352","State":"0","CreateTime":"2019-12-23T23:56:14","ApproveTime":null,"ApproveUser":null,"IsUse":"Y","DrawType":null,"page":1,"limit":999,"Version":0},{"Id":333,"WithDrawID":333,"UserID":"13562805678","PayMoney":221.16,"PayInfo":"农业银行","PayName":"王爱花","PayNo":"6228480276390882260","State":"0","CreateTime":"2019-12-23T22:14:06","ApproveTime":null,"ApproveUser":null,"IsUse":"Y","DrawType":null,"page":1,"limit":999,"Version":0},{"Id":332,"WithDrawID":332,"UserID":"17896015185","PayMoney":58.2,"PayInfo":"农业银行","PayName":"郭军","PayNo":"6228480018051153577","State":"0","CreateTime":"2019-12-23T17:54:42","ApproveTime":null,"ApproveUser":null,"IsUse":"Y","DrawType":null,"page":1,"limit":999,"Version":0}]
     */

    private String code;
    private String msg;
    private String count;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * Id : 334
         * WithDrawID : 334
         * UserID : 13475077703
         * PayMoney : 33.95
         * PayInfo : 山东省农村信用社联合社
         * PayName : 李树勇
         * PayNo : 6223201301044352
         * State : 0
         * CreateTime : 2019-12-23T23:56:14
         * ApproveTime : null
         * ApproveUser : null
         * IsUse : Y
         * DrawType : null
         * page : 1
         * limit : 999
         * Version : 0
         */

        private int Id;
        private int WithDrawID;
        private String UserID;
        private double PayMoney;
        private String PayInfo;
        private String PayName;
        private String PayNo;
        private String State;
        private String CreateTime;
        private String ApproveTime;
        private String ApproveUser;
        private String IsUse;
        private String DrawType;
        private int page;
        private int limit;
        private int Version;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getWithDrawID() {
            return WithDrawID;
        }

        public void setWithDrawID(int WithDrawID) {
            this.WithDrawID = WithDrawID;
        }

        public String getUserID() {
            return UserID;
        }

        public void setUserID(String UserID) {
            this.UserID = UserID;
        }

        public double getPayMoney() {
            return PayMoney;
        }

        public void setPayMoney(double PayMoney) {
            this.PayMoney = PayMoney;
        }

        public String getPayInfo() {
            return PayInfo;
        }

        public void setPayInfo(String PayInfo) {
            this.PayInfo = PayInfo;
        }

        public String getPayName() {
            return PayName;
        }

        public void setPayName(String PayName) {
            this.PayName = PayName;
        }

        public String getPayNo() {
            return PayNo;
        }

        public void setPayNo(String PayNo) {
            this.PayNo = PayNo;
        }

        public String getState() {
            return State;
        }

        public void setState(String State) {
            this.State = State;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getApproveTime() {
            return ApproveTime;
        }

        public void setApproveTime(String ApproveTime) {
            this.ApproveTime = ApproveTime;
        }

        public String getApproveUser() {
            return ApproveUser;
        }

        public void setApproveUser(String ApproveUser) {
            this.ApproveUser = ApproveUser;
        }

        public String getIsUse() {
            return IsUse;
        }

        public void setIsUse(String IsUse) {
            this.IsUse = IsUse;
        }

        public String getDrawType() {
            return DrawType;
        }

        public void setDrawType(String DrawType) {
            this.DrawType = DrawType;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getVersion() {
            return Version;
        }

        public void setVersion(int Version) {
            this.Version = Version;
        }
    }
}
