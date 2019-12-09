package com.zhkj.backstage.bean;

import java.io.Serializable;
import java.util.List;

public class UserInfoList implements Serializable {

    /**
     * code : 0
     * msg : success
     * count : 1
     * data : [{"Id":"15757964771","UserID":"15757964771","NickName":"宁波正海科技有限公司呵呵呵","Avator":"439c5e380a384efd9b24eabaf69430cb.jpg","CreateDate":"2019-10-17T16:07:27","LastLoginDate":"2019-12-03T11:12:38","LoginCount":513,"RemainMoney":0,"TotalMoney":10000,"FrozenMoney":300,"Type":"6","TopRank":"3","IsUse":"Y","PassWord":"888888","PayPassWord":"888888","RoleID":14,"RoleName":"普通用户","AccountID":336,"DistrictCode":null,"Con":600,"Longitude":null,"Dimension":null,"ServiceTotalOrderNum":"0","ServiceComplaintNum":"3","UnfinishedAmount":24924,"StartDate":null,"EndDate":null,"ProvinceCode":null,"CityCode":null,"AreaCode":null,"Address":null,"DepositMoney":500,"DepositFrozenMoney":0,"Skills":null,"IfAuth":"0","AuthMessage":"","ParentUserID":null,"TrueName":null,"IDCard":null,"Sex":null,"Phone":"15757964771","page":0,"limit":0,"Version":0}]
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
         * Id : 15757964771
         * UserID : 15757964771
         * NickName : 宁波正海科技有限公司呵呵呵
         * Avator : 439c5e380a384efd9b24eabaf69430cb.jpg
         * CreateDate : 2019-10-17T16:07:27
         * LastLoginDate : 2019-12-03T11:12:38
         * LoginCount : 513
         * RemainMoney : 0.0
         * TotalMoney : 10000.0
         * FrozenMoney : 300.0
         * Type : 6
         * TopRank : 3
         * IsUse : Y
         * PassWord : 888888
         * PayPassWord : 888888
         * RoleID : 14
         * RoleName : 普通用户
         * AccountID : 336
         * DistrictCode : null
         * Con : 600
         * Longitude : null
         * Dimension : null
         * ServiceTotalOrderNum : 0
         * ServiceComplaintNum : 3
         * UnfinishedAmount : 24924.0
         * StartDate : null
         * EndDate : null
         * ProvinceCode : null
         * CityCode : null
         * AreaCode : null
         * Address : null
         * DepositMoney : 500.0
         * DepositFrozenMoney : 0.0
         * Skills : null
         * IfAuth : 0
         * AuthMessage :
         * ParentUserID : null
         * TrueName : null
         * IDCard : null
         * Sex : null
         * Phone : 15757964771
         * page : 0
         * limit : 0
         * Version : 0
         */

        private String Id;
        private String UserID;
        private String NickName;
        private String Avator;
        private String CreateDate;
        private String LastLoginDate;
        private int LoginCount;
        private double RemainMoney;
        private double TotalMoney;
        private double FrozenMoney;
        private String Type;
        private String TopRank;
        private String IsUse;
        private String PassWord;
        private String PayPassWord;
        private int RoleID;
        private String RoleName;
        private int AccountID;
        private String DistrictCode;
        private int Con;
        private String Longitude;
        private String Dimension;
        private String ServiceTotalOrderNum;
        private String ServiceComplaintNum;
        private double UnfinishedAmount;
        private String StartDate;
        private String EndDate;
        private String ProvinceCode;
        private String CityCode;
        private String AreaCode;
        private String Address;
        private double DepositMoney;
        private double DepositFrozenMoney;
        private String Skills;
        private String IfAuth;
        private String AuthMessage;
        private String ParentUserID;
        private String TrueName;
        private String IDCard;
        private String Sex;
        private String Phone;
        private int page;
        private int limit;
        private int Version;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getUserID() {
            return UserID;
        }

        public void setUserID(String UserID) {
            this.UserID = UserID;
        }

        public String getNickName() {
            return NickName;
        }

        public void setNickName(String NickName) {
            this.NickName = NickName;
        }

        public String getAvator() {
            return Avator;
        }

        public void setAvator(String Avator) {
            this.Avator = Avator;
        }

        public String getCreateDate() {
            return CreateDate;
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        public String getLastLoginDate() {
            return LastLoginDate;
        }

        public void setLastLoginDate(String LastLoginDate) {
            this.LastLoginDate = LastLoginDate;
        }

        public int getLoginCount() {
            return LoginCount;
        }

        public void setLoginCount(int LoginCount) {
            this.LoginCount = LoginCount;
        }

        public double getRemainMoney() {
            return RemainMoney;
        }

        public void setRemainMoney(double RemainMoney) {
            this.RemainMoney = RemainMoney;
        }

        public double getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(double TotalMoney) {
            this.TotalMoney = TotalMoney;
        }

        public double getFrozenMoney() {
            return FrozenMoney;
        }

        public void setFrozenMoney(double FrozenMoney) {
            this.FrozenMoney = FrozenMoney;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getTopRank() {
            return TopRank;
        }

        public void setTopRank(String TopRank) {
            this.TopRank = TopRank;
        }

        public String getIsUse() {
            return IsUse;
        }

        public void setIsUse(String IsUse) {
            this.IsUse = IsUse;
        }

        public String getPassWord() {
            return PassWord;
        }

        public void setPassWord(String PassWord) {
            this.PassWord = PassWord;
        }

        public String getPayPassWord() {
            return PayPassWord;
        }

        public void setPayPassWord(String PayPassWord) {
            this.PayPassWord = PayPassWord;
        }

        public int getRoleID() {
            return RoleID;
        }

        public void setRoleID(int RoleID) {
            this.RoleID = RoleID;
        }

        public String getRoleName() {
            return RoleName;
        }

        public void setRoleName(String RoleName) {
            this.RoleName = RoleName;
        }

        public int getAccountID() {
            return AccountID;
        }

        public void setAccountID(int AccountID) {
            this.AccountID = AccountID;
        }

        public String getDistrictCode() {
            return DistrictCode;
        }

        public void setDistrictCode(String DistrictCode) {
            this.DistrictCode = DistrictCode;
        }

        public int getCon() {
            return Con;
        }

        public void setCon(int Con) {
            this.Con = Con;
        }

        public String getLongitude() {
            return Longitude;
        }

        public void setLongitude(String Longitude) {
            this.Longitude = Longitude;
        }

        public String getDimension() {
            return Dimension;
        }

        public void setDimension(String Dimension) {
            this.Dimension = Dimension;
        }

        public String getServiceTotalOrderNum() {
            return ServiceTotalOrderNum;
        }

        public void setServiceTotalOrderNum(String ServiceTotalOrderNum) {
            this.ServiceTotalOrderNum = ServiceTotalOrderNum;
        }

        public String getServiceComplaintNum() {
            return ServiceComplaintNum;
        }

        public void setServiceComplaintNum(String ServiceComplaintNum) {
            this.ServiceComplaintNum = ServiceComplaintNum;
        }

        public double getUnfinishedAmount() {
            return UnfinishedAmount;
        }

        public void setUnfinishedAmount(double UnfinishedAmount) {
            this.UnfinishedAmount = UnfinishedAmount;
        }

        public String getStartDate() {
            return StartDate;
        }

        public void setStartDate(String StartDate) {
            this.StartDate = StartDate;
        }

        public String getEndDate() {
            return EndDate;
        }

        public void setEndDate(String EndDate) {
            this.EndDate = EndDate;
        }

        public String getProvinceCode() {
            return ProvinceCode;
        }

        public void setProvinceCode(String ProvinceCode) {
            this.ProvinceCode = ProvinceCode;
        }

        public String getCityCode() {
            return CityCode;
        }

        public void setCityCode(String CityCode) {
            this.CityCode = CityCode;
        }

        public String getAreaCode() {
            return AreaCode;
        }

        public void setAreaCode(String AreaCode) {
            this.AreaCode = AreaCode;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public double getDepositMoney() {
            return DepositMoney;
        }

        public void setDepositMoney(double DepositMoney) {
            this.DepositMoney = DepositMoney;
        }

        public double getDepositFrozenMoney() {
            return DepositFrozenMoney;
        }

        public void setDepositFrozenMoney(double DepositFrozenMoney) {
            this.DepositFrozenMoney = DepositFrozenMoney;
        }

        public String getSkills() {
            return Skills;
        }

        public void setSkills(String Skills) {
            this.Skills = Skills;
        }

        public String getIfAuth() {
            return IfAuth;
        }

        public void setIfAuth(String IfAuth) {
            this.IfAuth = IfAuth;
        }

        public String getAuthMessage() {
            return AuthMessage;
        }

        public void setAuthMessage(String AuthMessage) {
            this.AuthMessage = AuthMessage;
        }

        public String getParentUserID() {
            return ParentUserID;
        }

        public void setParentUserID(String ParentUserID) {
            this.ParentUserID = ParentUserID;
        }

        public String getTrueName() {
            return TrueName;
        }

        public void setTrueName(String TrueName) {
            this.TrueName = TrueName;
        }

        public String getIDCard() {
            return IDCard;
        }

        public void setIDCard(String IDCard) {
            this.IDCard = IDCard;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String Phone) {
            this.Phone = Phone;
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
