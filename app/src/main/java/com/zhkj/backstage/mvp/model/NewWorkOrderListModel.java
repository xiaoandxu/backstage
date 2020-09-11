package com.zhkj.backstage.mvp.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BackstageGetOrderNum;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetCustomService;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.WorkOrderListBean;
import com.zhkj.backstage.mvp.contract.NewWorkOrderListContract;
import com.zhkj.backstage.service.ApiRetrofit;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class NewWorkOrderListModel implements NewWorkOrderListContract.Model {
    @Override
    public Observable<BaseResult<GetOderCountByCustomService>> GetOderCountByCustomService() {
        return ApiRetrofit.getDefault().GetOderCountByCustomService()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<BackstageGetOrderNum>> BackstageGetOrderNum() {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "{}");
        return ApiRetrofit.getDefault().BackstageGetOrderNum(body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<WorkOrderListBean> GetOderCountByCustomService2(String type, String IsCall, String IsAll, String searchContent, String page, String limit) {
        return ApiRetrofit.getDefault().GetOderCountByCustomService2(type, IsCall, IsAll, searchContent, page, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<WorkOrderListBean> GetoderInfoPartListBak(String type, String page, String limit) {
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

    @Override
    public Observable<WorkOrderListBean> GetoderInfoPartListBak(RequestBody json) {
        return ApiRetrofit.getDefault().GetoderInfoPartListBak(json)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
