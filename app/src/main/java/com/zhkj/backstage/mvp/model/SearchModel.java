package com.zhkj.backstage.mvp.model;


import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetCustomService;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.bean.WorkOrderListBean;
import com.zhkj.backstage.mvp.contract.SearchContract;
import com.zhkj.backstage.service.ApiRetrofit;

import java.util.List;

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
    public Observable<WorkOrderListBean> GetoderInfoPartListBak2(String type, String OrderID, String Phone, String SelectCustomerUserId , String page, String limit) {
        return ApiRetrofit.getDefault().GetoderInfoPartListBak2(type, OrderID, Phone,SelectCustomerUserId, page, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
