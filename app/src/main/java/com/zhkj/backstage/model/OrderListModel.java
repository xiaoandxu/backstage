package com.zhkj.backstage.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.contract.OrderListContract;
import com.zhkj.backstage.service.ApiRetrofit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class OrderListModel implements OrderListContract.Model {
    @Override
    public Observable<BaseResult<WorkOrder>> GetOrderInfoList(String OrderID, String UserID, String TypeID, String State, String ProvinceCode, String CityCode, String AreaCode, String CreateDate, String partsIs, String messageIs,String SendUserIs,String StartTime, String EndTime, String page, String limit) {
        return ApiRetrofit.getDefault().GetOrderInfoList(OrderID, UserID, TypeID, State, ProvinceCode, CityCode, AreaCode, CreateDate, partsIs, messageIs,SendUserIs,StartTime,EndTime,page,limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<String>>> ChangeOrderStateTwenty(String OrderId) {
        return ApiRetrofit.getDefault().ChangeOrderStateTwenty(OrderId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
