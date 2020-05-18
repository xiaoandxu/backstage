package com.zhkj.backstage.bean;

import java.io.Serializable;
import java.util.List;

public class GetOderCountByCustomService implements Serializable {

    /**
     * result : true
     * Data : [0,0,0,0,0,0,225]
     */

    private boolean result;
    private List<Integer> Data;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<Integer> getData() {
        return Data;
    }

    public void setData(List<Integer> Data) {
        this.Data = Data;
    }
}
