package com.zhkj.backstage.mvp.model;


import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.mvp.contract.SearchContract;
import com.zhkj.backstage.service.ApiRetrofit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchModel implements SearchContract.Model {
    @Override
    public Observable<BaseResult<WorkOrder>> GetOrderInfoList(String Phone, String OrderID, String UserID, String UserName, String limit, String page) {
        return ApiRetrofit.getDefault().GetOrderInfoList2(Phone, OrderID, UserID,UserName,limit, page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

//    @Override
//    public Observable<BaseResult<Data<String>>> GetFStarOrder(String OrderID, String FStarOrder) {
//        return ApiRetrofit.getDefault().GetFStarOrder(OrderID, FStarOrder)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io());
//    }
}
