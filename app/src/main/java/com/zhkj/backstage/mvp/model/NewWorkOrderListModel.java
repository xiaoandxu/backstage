package com.zhkj.backstage.mvp.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BackstageGetOrderNum;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetCustomService;
import com.zhkj.backstage.bean.GetOderCountByCustomService2;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.mvp.contract.NewWorkOrderListContract;
import com.zhkj.backstage.service.ApiRetrofit;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewWorkOrderListModel implements NewWorkOrderListContract.Model {
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
    public Observable<BaseResult<List<GetOderCountByCustomService2>>> GetOderCountByCustomService2(String type, String IsCall, String IsAll, String searchContent, String page, String limit) {
        return ApiRetrofit.getDefault().GetOderCountByCustomService2(type, IsCall, IsAll, searchContent, page, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<WorkOrder>> GetoderInfoPartListBak(String type, String page, String limit) {
        return ApiRetrofit.getDefault().GetoderInfoPartListBak(type, page, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<List<GetCustomService>>> GetCustomService() {
        return ApiRetrofit.getDefault().GetCustomService()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<String>>> SetChangeGiveWay(String orderID, String receivePersonID) {
        return ApiRetrofit.getDefault().SetChangeGiveWay(orderID, receivePersonID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
