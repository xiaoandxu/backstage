package com.zhkj.backstage.mvp.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BackstageGetOrderNum;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetModuleByRoleId;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.SalesToday2;
import com.zhkj.backstage.bean.SalesToday3;
import com.zhkj.backstage.bean.UserInfoList;
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
    public Observable<BaseResult<BackstageGetOrderNum>> BackstageGetOrderNum() {
        return ApiRetrofit.getDefault().BackstageGetOrderNum()
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

    @Override
    public Observable<BaseResult<UserInfoList>> GetUserInfo(String UserID, String limit) {
        return ApiRetrofit.getDefault().GetUserInfo(UserID, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<GetModuleByRoleId>> GetModuleByRoleId(String RoleId) {
        return ApiRetrofit.getDefault().GetModuleByRoleId(RoleId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
