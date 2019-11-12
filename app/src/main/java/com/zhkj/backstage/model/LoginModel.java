package com.zhkj.backstage.model;


import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.contract.LoginContract;
import com.zhkj.backstage.service.ApiRetrofit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;


public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<BaseResult<Data<String>>> Login(String userName, String passWord) {
        return ApiRetrofit.getDefault().LoginOn(userName,passWord,"5")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<String>> GetUserInfo(RequestBody json) {
        return ApiRetrofit.getDefault().GetUserInfo(json)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }



}
