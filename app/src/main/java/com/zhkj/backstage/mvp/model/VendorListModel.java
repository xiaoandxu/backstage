package com.zhkj.backstage.mvp.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.AddrList;
import com.zhkj.backstage.bean.GetUserInfoListForPlatformResult;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.bean.worker;
import com.zhkj.backstage.mvp.contract.VendorListContract;
import com.zhkj.backstage.service.ApiRetrofit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class VendorListModel implements VendorListContract.Model {
    @Override
    public Observable<BaseResult<UserInfoList>> GetUserInfoList(String Type, String IfAuth,String StartDate, String EndDate,String page, String limit) {
        return ApiRetrofit.getDefault().GetUserInfoList(Type, IfAuth,StartDate,EndDate,page,limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
    @Override
    public Observable<BaseResult<UserInfoList>> GetUserInfoPartList(RequestBody json) {
        return ApiRetrofit.getDefault().GetUserInfoPartList(json)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<GetUserInfoListForPlatformResult> GetUserInfoListForPlatform(RequestBody json) {
        return ApiRetrofit.getDefault().GetUserInfoListForPlatform(json)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<AddrList>> GetProvinceMasterDistance() {
        return ApiRetrofit.getDefault().GetProvinceMasterDistance()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<worker>> GetProvinceMasterList(String page, String limit, String code) {
        return ApiRetrofit.getDefault().GetProvinceMasterList(page, limit, code)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
