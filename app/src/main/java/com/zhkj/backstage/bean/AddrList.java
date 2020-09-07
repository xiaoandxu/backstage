package com.zhkj.backstage.bean;

import java.io.Serializable;
import java.util.List;

public class AddrList implements Serializable {

    /**
     * status : true
     * msg : 成功
     * data : [["其他",791],["其他",2],["北京市",49],["天津市",46],["河北省",762],["山西省",181],["内蒙古自治区",35],["辽宁省",53],["吉林省",39],["黑龙江省",58],["上海市",91],["江苏省",607],["浙江省",694],["安徽省",373],["福建省",401],["江西省",513],["山东省",624],["河南省",847],["湖北省",245],["湖南省",551],["广东省",773],["广西壮族自治区",486],["海南省",32],["重庆市",233],["四川省",609],["贵州省",455],["云南省",353],["西藏自治区",5],["陕西省",315],["甘肃省",73],["青海省",29],["宁夏回族自治区",39],["新疆维吾尔自治区",23]]
     */

    private boolean status;
    private String msg;
    private List<List<String>> data;

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

    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }
}
