package com.zhkj.backstage.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.UserList;
import com.zhkj.backstage.contract.DesignatedDispatchContract;
import com.zhkj.backstage.service.ApiRetrofit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DesignatedDispatchModel implements DesignatedDispatchContract.Model {
    @Override
    public Observable<BaseResult<UserList>> GetMUserList(String UserID, String Type,String page, String limit) {
        return ApiRetrofit.getDefault().GetMUserList(UserID, Type,page,limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<String>>> SendOrder(String OrderID, String UserID, String LoginUser, String TypeID) {
        return ApiRetrofit.getDefault().SendOrder(OrderID, UserID, LoginUser, TypeID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
