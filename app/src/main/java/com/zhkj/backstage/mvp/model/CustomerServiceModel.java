package com.zhkj.backstage.mvp.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetUserInfoPartListBak;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.mvp.contract.CustomerServiceContract;
import com.zhkj.backstage.service.ApiRetrofit;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CustomerServiceModel implements CustomerServiceContract.Model {
    @Override
    public Observable<BaseResult<UserInfoList>> GetUserInfo(String UserID, String limit) {
        return ApiRetrofit.getDefault().GetUserInfo(UserID, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
    @Override
    public Observable<BaseResult<GetUserInfoPartListBak>> GetUserInfoPartListBak(String RoleId, String page, String limit) {
        return ApiRetrofit.getDefault().GetUserInfoPartListBak(RoleId, page, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<String>>> SetEndOrderReceiving(String accountID) {
        return ApiRetrofit.getDefault().SetEndOrderReceiving(accountID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<String>>> SetStartOrderReceiving(String accountID) {
        return ApiRetrofit.getDefault().SetStartOrderReceiving(accountID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
