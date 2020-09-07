package com.zhkj.backstage.bean;

import java.io.Serializable;

public class OneKeyResult implements Serializable {


    /**
     * StatusCode : 200
     * Info : 请求(或处理)成功
     * Count : 0
     * Data : {"result":true,"msg":"7"}
     */

    private int StatusCode;
    private String Info;
    private int Count;
    private DataBean Data;

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

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * result : true
         * msg : 7
         */

        private boolean result;
        private String msg;

        public boolean isResult() {
            return result;
        }

        public void setResult(boolean result) {
            this.result = result;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
