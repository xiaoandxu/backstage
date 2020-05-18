package com.zhkj.backstage.mvp.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.SalesToday2;
import com.zhkj.backstage.mvp.contract.HomeNewContract;
import com.zhkj.backstage.service.ApiRetrofit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomeNewModel implements HomeNewContract.Model {
    @Override
    public Observable<BaseResult<GetOderCountByCustomService>> GetOderCountByCustomService() {
        return ApiRetrofit.getDefault().GetOderCountByCustomService()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<SalesToday2>>> SalesToday2() {
        return ApiRetrofit.getDefault().SalesToday2()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
