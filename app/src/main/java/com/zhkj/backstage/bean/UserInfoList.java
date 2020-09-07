package com.zhkj.backstage.bean;

import java.io.Serializable;
import java.util.List;

public class UserInfoList implements Serializable {


    /**
     * code : 0
     * msg : success
     * count : 1
     * data : [{"Id":"18888888888","UserID":"18888888888","NickName":"ss","Avator":"285d6da44ac44a609402dc76384794b9.jpg","CreateDate":"2019-09-30T15:27:00","LastLoginDate":"2020-07-01T11:58:00","LoginCount":307,"RemainMoney":0,"TotalMoney":10000,"FrozenMoney":368,"Type":"6","TopRank":"3","YnAuth":null,"barCode":"0","IsUse":"Y","PassWord":"888888","PayPassWord":"888888","RoleID":14,"RoleName":"厂商用户","AccountID":3000,"DistrictCode":"","Con":2000000000,"Longitude":"121.555227","Dimension":"29.886757","ServiceTotalOrderNum":"1","ServiceComplaintNum":"4","UnfinishedAmount":0,"ServiceTotalMoney":0,"CompanyName":"西瓜鱼","OrderFee":0,"FeeTypes":"N","DoorFee":0,"AgainMoney":0,"PlatformFee":0,"IsOnLine":0,"StartDate":null,"EndDate":null,"ProvinceCode":"330000","CityCode":"","AreaCode":"","Address":"浙江省宁波市江北区望山路715号靠近宁波企协大厦","DepositMoney":0,"DepositFrozenMoney":0,"Skills":null,"IfAuth":"0","AuthMessage":"","ParentUserID":"","TrueName":"评教","IDCard":"330682199702163029","Sex":"女","Phone":"123456","emergencyContact":null,"teamNumber":0,"IsOrNoTruck":null,"page":0,"limit":0,"Version":0}]
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
         * Id : 18888888888
         * UserID : 18888888888
         * NickName : ss
         * Avator : 285d6da44ac44a609402dc76384794b9.jpg
         * CreateDate : 2019-09-30T15:27:00
         * LastLoginDate : 2020-07-01T11:58:00
         * LoginCount : 307
         * RemainMoney : 0.0
         * TotalMoney : 10000.0
         * FrozenMoney : 368.0
         * Type : 6
         * TopRank : 3
         * YnAuth : null
         * barCode : 0
         * IsUse : Y
         * PassWord : 888888
         * PayPassWord : 888888
         * RoleID : 14
         * RoleName : 厂商用户
         * AccountID : 3000
         * DistrictCode :
         * Con : 2000000000
         * Longitude : 121.555227
         * Dimension : 29.886757
         * ServiceTotalOrderNum : 1
         * ServiceComplaintNum : 4
         * UnfinishedAmount : 0.0
         * ServiceTotalMoney : 0.0
         * CompanyName : 西瓜鱼
         * OrderFee : 0.0
         * FeeTypes : N
         * DoorFee : 0.0
         * AgainMoney : 0.0
         * PlatformFee : 0.0
         * IsOnLine : 0
         * StartDate : null
         * EndDate : null
         * ProvinceCode : 330000
         * CityCode :
         * AreaCode :
         * Address : 浙江省宁波市江北区望山路715号靠近宁波企协大厦
         * DepositMoney : 0.0
         * DepositFrozenMoney : 0.0
         * Skills : null
         * IfAuth : 0
         * AuthMessage :
         * ParentUserID :
         * TrueName : 评教
         * IDCard : 330682199702163029
         * Sex : 女
         * Phone : 123456
         * emergencyContact : null
         * teamNumber : 0
         * IsOrNoTruck : null
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
        private Object YnAuth;
        private String barCode;
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
        private double ServiceTotalMoney;
        private String CompanyName;
        private double OrderFee;
        private String FeeTypes;
        private double DoorFee;
        private double AgainMoney;
        private double PlatformFee;
        private int IsOnLine;
        private Object StartDate;
        private Object EndDate;
        private String ProvinceCode;
        private String CityCode;
        private String AreaCode;
        private String ProvinceName;
        private String CityName;
        private String AreaName;
        private String DistrictName;
        private String Address;
        private double DepositMoney;
        private double DepositFrozenMoney;
        private Object Skills;
        private String IfAuth;
        private String AuthMessage;
        private String ParentUserID;
        private String TrueName;
        private String IDCard;
        private String Sex;
        private String Phone;
        private Object emergencyContact;
        private int teamNumber;
        private Object IsOrNoTruck;
        private int page;
        private int limit;
        private int Version;

        public String getProvinceName() {
            return ProvinceName;
        }

        public void setProvinceName(String provinceName) {
            ProvinceName = provinceName;
        }

        public String getCityName() {
            return CityName;
        }

        public void setCityName(String cityName) {
            CityName = cityName;
        }

        public String getAreaName() {
            return AreaName;
        }

        public void setAreaName(String areaName) {
            AreaName = areaName;
        }

        public String getDistrictName() {
            return DistrictName;
        }

        public void setDistrictName(String districtName) {
            DistrictName = districtName;
        }

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

        public Object getYnAuth() {
            return YnAuth;
        }

        public void setYnAuth(Object YnAuth) {
            this.YnAuth = YnAuth;
        }

        public String getBarCode() {
            return barCode;
        }

        public void setBarCode(String barCode) {
            this.barCode = barCode;
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

        public double getServiceTotalMoney() {
            return ServiceTotalMoney;
        }

        public void setServiceTotalMoney(double ServiceTotalMoney) {
            this.ServiceTotalMoney = ServiceTotalMoney;
        }

        public String getCompanyName() {
            return CompanyName;
        }

        public void setCompanyName(String CompanyName) {
            this.CompanyName = CompanyName;
        }

        public double getOrderFee() {
            return OrderFee;
        }

        public void setOrderFee(double OrderFee) {
            this.OrderFee = OrderFee;
        }

        public String getFeeTypes() {
            return FeeTypes;
        }

        public void setFeeTypes(String FeeTypes) {
            this.FeeTypes = FeeTypes;
        }

        public double getDoorFee() {
            return DoorFee;
        }

        public void setDoorFee(double DoorFee) {
            this.DoorFee = DoorFee;
        }

        public double getAgainMoney() {
            return AgainMoney;
        }

        public void setAgainMoney(double AgainMoney) {
            this.AgainMoney = AgainMoney;
        }

        public double getPlatformFee() {
            return PlatformFee;
        }

        public void setPlatformFee(double PlatformFee) {
            this.PlatformFee = PlatformFee;
        }

        public int getIsOnLine() {
            return IsOnLine;
        }

        public void setIsOnLine(int IsOnLine) {
            this.IsOnLine = IsOnLine;
        }

        public Object getStartDate() {
            return StartDate;
        }

        public void setStartDate(Object StartDate) {
            this.StartDate = StartDate;
        }

        public Object getEndDate() {
            return EndDate;
        }

        public void setEndDate(Object EndDate) {
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

        public Object getSkills() {
            return Skills;
        }

        public void setSkills(Object Skills) {
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

        public Object getEmergencyContact() {
            return emergencyContact;
        }

        public void setEmergencyContact(Object emergencyContact) {
            this.emergencyContact = emergencyContact;
        }

        public int getTeamNumber() {
            return teamNumber;
        }

        public void setTeamNumber(int teamNumber) {
            this.teamNumber = teamNumber;
        }

        public Object getIsOrNoTruck() {
            return IsOrNoTruck;
        }

        public void setIsOrNoTruck(Object IsOrNoTruck) {
            this.IsOrNoTruck = IsOrNoTruck;
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
