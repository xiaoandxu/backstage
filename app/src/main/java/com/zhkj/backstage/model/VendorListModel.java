package com.zhkj.backstage.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.contract.VendorListContract;
import com.zhkj.backstage.service.ApiRetrofit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class VendorListModel implements VendorListContract.Model {
    @Override
    public Observable<BaseResult<UserInfoList>> GetUserInfoList(String Type, String IfAuth,String page, String limit) {
        return ApiRetrofit.getDefault().GetUserInfoList(Type, IfAuth,page,limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
