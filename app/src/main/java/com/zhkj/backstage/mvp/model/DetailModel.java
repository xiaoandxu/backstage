package com.zhkj.backstage.mvp.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.mvp.contract.DetailContract;
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

    @Override
    public Observable<BaseResult<Data<String>>> UpdatePhone(String OrderID, String Phone) {
        return ApiRetrofit.getDefault().UpdatePhone(OrderID, Phone)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<String>>> CloseOrder(String OrderID, String Type, String price, String UserID,String value) {
        return ApiRetrofit.getDefault().CloseOrder(OrderID, Type, price, UserID,value)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<String>>> modifyOrderMoney(String OrderID, String orderMoney, String UserID) {
        return ApiRetrofit.getDefault().modifyOrderMoney(OrderID, orderMoney, UserID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<String>>> ChangeOrderStateTwenty(String OrderId) {
        return ApiRetrofit.getDefault().ChangeOrderStateTwenty(OrderId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<String>>> NowEnSureOrder(String OrderId,String UserID) {
        return ApiRetrofit.getDefault().NowEnSureOrder(OrderId,UserID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<String>>> endAgain(String OrderID, String FactoryPrice, String wokerPrice, String UserID) {
        return ApiRetrofit.getDefault().endAgain(OrderID, FactoryPrice, wokerPrice, UserID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
