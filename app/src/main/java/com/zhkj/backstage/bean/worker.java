package com.zhkj.backstage.bean;

import java.io.Serializable;
import java.util.List;

public class worker implements Serializable {


    /**
     * status : true
     * msg : success
     * data : {"Item1":[["13520479752","北京燕山玉新家用电器维修部","北京市房山区迎风街道迎风街40迎风四里"],["17896015185","维修","北京市海淀区采石北路14靠近三街坊东居委会社区康复站"],["13683112667","朗朗乾坤","北京市顺义区李桥镇德威(中共顺义区李桥镇委员会东)"],["15810921908","池师傅小店","北京市昌平区南口镇水厂路80号"],["15810527969","15810527969","北京市朝阳区金盏镇贝贝佳幼儿园(金盏乡人民政府拆迁腾退办公室东)"],["15158305471","15158305471","123456"],["13124748802","回龙观家电维修","北京市昌平区龙泽园街道行知路慧华苑"],["13520258876","13520258876","北京市昌平区二拨子路70号靠近二拨子村信访接待站"],["15201155978","京城社区家电清洗维修","北京市朝阳区劲松街道北京万嘉新兴体育俱乐部乐澜宝邸"],["13601203351","默认微信名称","北京市朝阳区双井街道荣小馆(北京大望路店)北京博瑞祥星汽车销售有限公司"]],"Item2":46}
     */

    private boolean status;
    private String msg;
    private DataBean data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * Item1 : [["13520479752","北京燕山玉新家用电器维修部","北京市房山区迎风街道迎风街40迎风四里"],["17896015185","维修","北京市海淀区采石北路14靠近三街坊东居委会社区康复站"],["13683112667","朗朗乾坤","北京市顺义区李桥镇德威(中共顺义区李桥镇委员会东)"],["15810921908","池师傅小店","北京市昌平区南口镇水厂路80号"],["15810527969","15810527969","北京市朝阳区金盏镇贝贝佳幼儿园(金盏乡人民政府拆迁腾退办公室东)"],["15158305471","15158305471","123456"],["13124748802","回龙观家电维修","北京市昌平区龙泽园街道行知路慧华苑"],["13520258876","13520258876","北京市昌平区二拨子路70号靠近二拨子村信访接待站"],["15201155978","京城社区家电清洗维修","北京市朝阳区劲松街道北京万嘉新兴体育俱乐部乐澜宝邸"],["13601203351","默认微信名称","北京市朝阳区双井街道荣小馆(北京大望路店)北京博瑞祥星汽车销售有限公司"]]
         * Item2 : 46
         */

        private int Item2;
        private List<List<String>> Item1;

        public int getItem2() {
            return Item2;
        }

        public void setItem2(int Item2) {
            this.Item2 = Item2;
        }

        public List<List<String>> getItem1() {
            return Item1;
        }

        public void setItem1(List<List<String>> Item1) {
            this.Item1 = Item1;
        }
    }
}
