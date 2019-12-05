package com.zhkj.backstage.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.SalesToday;
import com.zhkj.backstage.bean.SalesToday2;
import com.zhkj.backstage.bean.SalesToday3;
import com.zhkj.backstage.contract.HomeContract;
import com.zhkj.backstage.service.ApiRetrofit;
import com.zhkj.backstage.service.ApiService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomeModel implements HomeContract.Model {
    @Override
    public Observable<BaseResult<Data<SalesToday>>> SalesToday() {
        return ApiRetrofit.getDefault().SalesToday()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<SalesToday2>>> SalesToday2() {
        return ApiRetrofit.getDefault().SalesToday2()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<SalesToday3>>> SalesToday3() {
        return ApiRetrofit.getDefault().SalesToday3()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
