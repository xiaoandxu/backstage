package com.zhkj.backstage.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.contract.DetailContract;
import com.zhkj.backstage.service.ApiRetrofit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DetailModel implements DetailContract.Model {
    @Override
    public Observable<BaseResult<WorkOrder.DataBean>> GetOrderInfo(String OrderID) {
        return ApiRetrofit.getDefault().GetOrderInfo(OrderID,"3")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
