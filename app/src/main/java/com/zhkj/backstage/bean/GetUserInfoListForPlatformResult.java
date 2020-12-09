package com.zhkj.backstage.bean;

import java.util.List;

public class GetUserInfoListForPlatformResult {

    /**
     * StatusCode : 200
     * Info : 请求(或处理)成功
     * Count : 0
     * Data : {"code":0,"msg":"success","count":87,"data":[{"UserID":"13486687955","CreateDate":"2020-04-30 09:30:12","LastLoginDate":"2020-10-22 13:48:45","TotalMoney":161682,"FrozenMoney":140103,"DepositMoney":500,"Balance":21579,"TotalRecharge":920000,"settlementMoney":757818,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"浙江日普电气有限公司","num":18213},{"UserID":"13567896427","CreateDate":"2019-10-29 11:12:31","LastLoginDate":"2020-10-22 12:12:27","TotalMoney":22174,"FrozenMoney":4002,"DepositMoney":500,"Balance":18172,"TotalRecharge":90000,"settlementMoney":67326,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波乐士实业有限公司","num":1061},{"UserID":"15867444926","CreateDate":"2020-04-20 14:31:49","LastLoginDate":"2020-10-22 14:20:42","TotalMoney":48572,"FrozenMoney":43900,"DepositMoney":500,"Balance":4672,"TotalRecharge":62000,"settlementMoney":12928,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波欧品电器有限公司","num":867},{"UserID":"17585375423","CreateDate":"2020-05-19 15:04:43","LastLoginDate":"2020-10-20 10:40:44","TotalMoney":65,"FrozenMoney":-105,"DepositMoney":500,"Balance":170,"TotalRecharge":69500,"settlementMoney":68915,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"慈溪市一邦电器有限公司","num":696},{"UserID":"18989325655","CreateDate":"2020-09-08 15:47:48","LastLoginDate":"2020-10-22 14:17:12","TotalMoney":19155,"FrozenMoney":18040,"DepositMoney":500,"Balance":1115,"TotalRecharge":46110,"settlementMoney":26455,"TopRank":"3","IfAuth":"1","TrueName":"慈溪市飞兰电器有限公司","CompanyName":"慈溪市飞兰电器有限公司","num":686},{"UserID":"17757442637","CreateDate":"2019-12-31 11:00:17","LastLoginDate":"2020-09-09 18:01:39","TotalMoney":-583,"FrozenMoney":0,"DepositMoney":500,"Balance":-583,"TotalRecharge":60000,"settlementMoney":60065,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波松菱电器制造有限公司","num":543},{"UserID":"15728053637","CreateDate":"2019-12-25 14:45:01","LastLoginDate":"2020-10-22 08:59:51","TotalMoney":708,"FrozenMoney":232,"DepositMoney":0,"Balance":476,"TotalRecharge":6000,"settlementMoney":5292,"TopRank":"3","IfAuth":"1","TrueName":"川崎","CompanyName":"宁波正日电器有限公司","num":530},{"UserID":"18257435332","CreateDate":"2020-04-21 14:18:17","LastLoginDate":"2020-10-22 15:34:38","TotalMoney":631,"FrozenMoney":852,"DepositMoney":500,"Balance":-221,"TotalRecharge":34240,"settlementMoney":33162,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波长城电器有限公司","num":509},{"UserID":"13736067754","CreateDate":"2020-05-22 15:20:28","LastLoginDate":"2020-10-16 13:18:32","TotalMoney":-242,"FrozenMoney":0,"DepositMoney":500,"Balance":-242,"TotalRecharge":28000,"settlementMoney":27722,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"永雪制冷","num":461},{"UserID":"17682354123","CreateDate":"2020-04-02 15:35:19","LastLoginDate":"2020-10-22 10:10:03","TotalMoney":10345,"FrozenMoney":10170,"DepositMoney":500,"Balance":175,"TotalRecharge":17500,"settlementMoney":6655,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"慈溪市小黄鸭电器有限公司","num":379},{"UserID":"13736046059","CreateDate":"2020-05-08 08:50:18","LastLoginDate":"2020-10-22 13:40:11","TotalMoney":9102,"FrozenMoney":7880,"DepositMoney":500,"Balance":1222,"TotalRecharge":18500,"settlementMoney":8898,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波多芬电器有限公司","num":306},{"UserID":"13957895271","CreateDate":"2020-05-28 11:50:08","LastLoginDate":"2020-10-22 08:35:20","TotalMoney":1058,"FrozenMoney":1065,"DepositMoney":500,"Balance":-7,"TotalRecharge":21500,"settlementMoney":19922,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波雪菲特空调器有限公司","num":269},{"UserID":"18067299188","CreateDate":"2020-04-08 17:00:23","LastLoginDate":"2020-10-22 07:30:12","TotalMoney":2536.5,"FrozenMoney":2015,"DepositMoney":500,"Balance":521.5,"TotalRecharge":23500,"settlementMoney":20463.5,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波海冉电器科技有限公司","num":267},{"UserID":"13777982260","CreateDate":"2020-05-06 08:46:38","LastLoginDate":"2020-07-29 13:31:28","TotalMoney":170,"FrozenMoney":60,"DepositMoney":0,"Balance":110,"TotalRecharge":10050,"settlementMoney":9665,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波惠康国际工业有限公司","num":216},{"UserID":"13586781660","CreateDate":"2020-04-25 09:30:51","LastLoginDate":"2020-10-22 09:47:48","TotalMoney":620,"FrozenMoney":81,"DepositMoney":0,"Balance":539,"TotalRecharge":5950,"settlementMoney":5330,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"杭州湾环保科技有限公司","num":129},{"UserID":"15867386362","CreateDate":"2019-10-21 09:16:07","LastLoginDate":"2020-10-22 10:38:52","TotalMoney":-174,"FrozenMoney":-4,"DepositMoney":500,"Balance":-170,"TotalRecharge":8500,"settlementMoney":9177,"TopRank":"3","IfAuth":"1","TrueName":"夏浪电器","CompanyName":"慈溪市夏浪有限公司","num":123},{"UserID":"15092223333","CreateDate":"2020-07-01 10:01:23","LastLoginDate":"2020-10-21 09:25:55","TotalMoney":506,"FrozenMoney":260,"DepositMoney":500,"Balance":246,"TotalRecharge":11300,"settlementMoney":10594,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"青岛熙锐晟工贸有限公司","num":106},{"UserID":"17326749105","CreateDate":"2020-04-08 14:25:10","LastLoginDate":"2020-10-22 08:11:27","TotalMoney":12788.4,"FrozenMoney":2235,"DepositMoney":500,"Balance":10553.4,"TotalRecharge":17500,"settlementMoney":4211.6,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"众创制冷有限公司","num":97},{"UserID":"18098550579","CreateDate":"2020-08-01 09:00:30","LastLoginDate":"2020-10-22 09:16:54","TotalMoney":656,"FrozenMoney":540,"DepositMoney":0,"Balance":116,"TotalRecharge":10000,"settlementMoney":9344,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宣城市艺雪制冷设备有限公司","num":89},{"UserID":"15105632319","CreateDate":"2020-08-06 10:18:43","LastLoginDate":"2020-10-22 08:29:07","TotalMoney":2372,"FrozenMoney":870,"DepositMoney":0,"Balance":1502,"TotalRecharge":11100,"settlementMoney":8728,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宣城市宣夏厨具设备厂","num":76}],"errcode":"","errorId":""}
     */

    private int StatusCode;
    private String Info;
    private int Count;
    private DataBeanX Data;

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

    public DataBeanX getData() {
        return Data;
    }

    public void setData(DataBeanX Data) {
        this.Data = Data;
    }

    public static class DataBeanX {
        /**
         * code : 0
         * msg : success
         * count : 87
         * data : [{"UserID":"13486687955","CreateDate":"2020-04-30 09:30:12","LastLoginDate":"2020-10-22 13:48:45","TotalMoney":161682,"FrozenMoney":140103,"DepositMoney":500,"Balance":21579,"TotalRecharge":920000,"settlementMoney":757818,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"浙江日普电气有限公司","num":18213},{"UserID":"13567896427","CreateDate":"2019-10-29 11:12:31","LastLoginDate":"2020-10-22 12:12:27","TotalMoney":22174,"FrozenMoney":4002,"DepositMoney":500,"Balance":18172,"TotalRecharge":90000,"settlementMoney":67326,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波乐士实业有限公司","num":1061},{"UserID":"15867444926","CreateDate":"2020-04-20 14:31:49","LastLoginDate":"2020-10-22 14:20:42","TotalMoney":48572,"FrozenMoney":43900,"DepositMoney":500,"Balance":4672,"TotalRecharge":62000,"settlementMoney":12928,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波欧品电器有限公司","num":867},{"UserID":"17585375423","CreateDate":"2020-05-19 15:04:43","LastLoginDate":"2020-10-20 10:40:44","TotalMoney":65,"FrozenMoney":-105,"DepositMoney":500,"Balance":170,"TotalRecharge":69500,"settlementMoney":68915,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"慈溪市一邦电器有限公司","num":696},{"UserID":"18989325655","CreateDate":"2020-09-08 15:47:48","LastLoginDate":"2020-10-22 14:17:12","TotalMoney":19155,"FrozenMoney":18040,"DepositMoney":500,"Balance":1115,"TotalRecharge":46110,"settlementMoney":26455,"TopRank":"3","IfAuth":"1","TrueName":"慈溪市飞兰电器有限公司","CompanyName":"慈溪市飞兰电器有限公司","num":686},{"UserID":"17757442637","CreateDate":"2019-12-31 11:00:17","LastLoginDate":"2020-09-09 18:01:39","TotalMoney":-583,"FrozenMoney":0,"DepositMoney":500,"Balance":-583,"TotalRecharge":60000,"settlementMoney":60065,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波松菱电器制造有限公司","num":543},{"UserID":"15728053637","CreateDate":"2019-12-25 14:45:01","LastLoginDate":"2020-10-22 08:59:51","TotalMoney":708,"FrozenMoney":232,"DepositMoney":0,"Balance":476,"TotalRecharge":6000,"settlementMoney":5292,"TopRank":"3","IfAuth":"1","TrueName":"川崎","CompanyName":"宁波正日电器有限公司","num":530},{"UserID":"18257435332","CreateDate":"2020-04-21 14:18:17","LastLoginDate":"2020-10-22 15:34:38","TotalMoney":631,"FrozenMoney":852,"DepositMoney":500,"Balance":-221,"TotalRecharge":34240,"settlementMoney":33162,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波长城电器有限公司","num":509},{"UserID":"13736067754","CreateDate":"2020-05-22 15:20:28","LastLoginDate":"2020-10-16 13:18:32","TotalMoney":-242,"FrozenMoney":0,"DepositMoney":500,"Balance":-242,"TotalRecharge":28000,"settlementMoney":27722,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"永雪制冷","num":461},{"UserID":"17682354123","CreateDate":"2020-04-02 15:35:19","LastLoginDate":"2020-10-22 10:10:03","TotalMoney":10345,"FrozenMoney":10170,"DepositMoney":500,"Balance":175,"TotalRecharge":17500,"settlementMoney":6655,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"慈溪市小黄鸭电器有限公司","num":379},{"UserID":"13736046059","CreateDate":"2020-05-08 08:50:18","LastLoginDate":"2020-10-22 13:40:11","TotalMoney":9102,"FrozenMoney":7880,"DepositMoney":500,"Balance":1222,"TotalRecharge":18500,"settlementMoney":8898,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波多芬电器有限公司","num":306},{"UserID":"13957895271","CreateDate":"2020-05-28 11:50:08","LastLoginDate":"2020-10-22 08:35:20","TotalMoney":1058,"FrozenMoney":1065,"DepositMoney":500,"Balance":-7,"TotalRecharge":21500,"settlementMoney":19922,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波雪菲特空调器有限公司","num":269},{"UserID":"18067299188","CreateDate":"2020-04-08 17:00:23","LastLoginDate":"2020-10-22 07:30:12","TotalMoney":2536.5,"FrozenMoney":2015,"DepositMoney":500,"Balance":521.5,"TotalRecharge":23500,"settlementMoney":20463.5,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波海冉电器科技有限公司","num":267},{"UserID":"13777982260","CreateDate":"2020-05-06 08:46:38","LastLoginDate":"2020-07-29 13:31:28","TotalMoney":170,"FrozenMoney":60,"DepositMoney":0,"Balance":110,"TotalRecharge":10050,"settlementMoney":9665,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宁波惠康国际工业有限公司","num":216},{"UserID":"13586781660","CreateDate":"2020-04-25 09:30:51","LastLoginDate":"2020-10-22 09:47:48","TotalMoney":620,"FrozenMoney":81,"DepositMoney":0,"Balance":539,"TotalRecharge":5950,"settlementMoney":5330,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"杭州湾环保科技有限公司","num":129},{"UserID":"15867386362","CreateDate":"2019-10-21 09:16:07","LastLoginDate":"2020-10-22 10:38:52","TotalMoney":-174,"FrozenMoney":-4,"DepositMoney":500,"Balance":-170,"TotalRecharge":8500,"settlementMoney":9177,"TopRank":"3","IfAuth":"1","TrueName":"夏浪电器","CompanyName":"慈溪市夏浪有限公司","num":123},{"UserID":"15092223333","CreateDate":"2020-07-01 10:01:23","LastLoginDate":"2020-10-21 09:25:55","TotalMoney":506,"FrozenMoney":260,"DepositMoney":500,"Balance":246,"TotalRecharge":11300,"settlementMoney":10594,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"青岛熙锐晟工贸有限公司","num":106},{"UserID":"17326749105","CreateDate":"2020-04-08 14:25:10","LastLoginDate":"2020-10-22 08:11:27","TotalMoney":12788.4,"FrozenMoney":2235,"DepositMoney":500,"Balance":10553.4,"TotalRecharge":17500,"settlementMoney":4211.6,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"众创制冷有限公司","num":97},{"UserID":"18098550579","CreateDate":"2020-08-01 09:00:30","LastLoginDate":"2020-10-22 09:16:54","TotalMoney":656,"FrozenMoney":540,"DepositMoney":0,"Balance":116,"TotalRecharge":10000,"settlementMoney":9344,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宣城市艺雪制冷设备有限公司","num":89},{"UserID":"15105632319","CreateDate":"2020-08-06 10:18:43","LastLoginDate":"2020-10-22 08:29:07","TotalMoney":2372,"FrozenMoney":870,"DepositMoney":0,"Balance":1502,"TotalRecharge":11100,"settlementMoney":8728,"TopRank":"3","IfAuth":"1","TrueName":"","CompanyName":"宣城市宣夏厨具设备厂","num":76}]
         * errcode :
         * errorId :
         */

        private int code;
        private String msg;
        private int count;
        private String errcode;
        private String errorId;
        private List<DataBean> data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getErrcode() {
            return errcode;
        }

        public void setErrcode(String errcode) {
            this.errcode = errcode;
        }

        public String getErrorId() {
            return errorId;
        }

        public void setErrorId(String errorId) {
            this.errorId = errorId;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * UserID : 13486687955
             * CreateDate : 2020-04-30 09:30:12
             * LastLoginDate : 2020-10-22 13:48:45
             * TotalMoney : 161682.0
             * FrozenMoney : 140103.0
             * DepositMoney : 500.0
             * Balance : 21579.0
             * TotalRecharge : 920000.0
             * settlementMoney : 757818.0
             * TopRank : 3
             * IfAuth : 1
             * TrueName :
             * CompanyName : 浙江日普电气有限公司
             * num : 18213
             */

            private String UserID;
            private String CreateDate;
            private String LastLoginDate;
            private double TotalMoney;
            private double FrozenMoney;
            private double DepositMoney;
            private double Balance;
            private double TotalRecharge;
            private double settlementMoney;
            private String TopRank;
            private String IfAuth;
            private String TrueName;
            private String CompanyName;
            private int num;

            public String getUserID() {
                return UserID;
            }

            public void setUserID(String UserID) {
                this.UserID = UserID;
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

            public double getDepositMoney() {
                return DepositMoney;
            }

            public void setDepositMoney(double DepositMoney) {
                this.DepositMoney = DepositMoney;
            }

            public double getBalance() {
                return Balance;
            }

            public void setBalance(double Balance) {
                this.Balance = Balance;
            }

            public double getTotalRecharge() {
                return TotalRecharge;
            }

            public void setTotalRecharge(double TotalRecharge) {
                this.TotalRecharge = TotalRecharge;
            }

            public double getSettlementMoney() {
                return settlementMoney;
            }

            public void setSettlementMoney(double settlementMoney) {
                this.settlementMoney = settlementMoney;
            }

            public String getTopRank() {
                return TopRank;
            }

            public void setTopRank(String TopRank) {
                this.TopRank = TopRank;
            }

            public String getIfAuth() {
                return IfAuth;
            }

            public void setIfAuth(String IfAuth) {
                this.IfAuth = IfAuth;
            }

            public String getTrueName() {
                return TrueName;
            }

            public void setTrueName(String TrueName) {
                this.TrueName = TrueName;
            }

            public String getCompanyName() {
                return CompanyName;
            }

            public void setCompanyName(String CompanyName) {
                this.CompanyName = CompanyName;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }
    }
}
