package com.zhkj.backstage.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.PayByOrderID;
import com.zhkj.backstage.contract.PayCordContract;
import com.zhkj.backstage.service.ApiRetrofit;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PayCordModel implements PayCordContract.Model {
    @Override
    public Observable<BaseResult<List<PayByOrderID>>> GetOrderPayByOrderID(String OrderID) {
        return ApiRetrofit.getDefault().GetOrderPayByOrderID(OrderID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
