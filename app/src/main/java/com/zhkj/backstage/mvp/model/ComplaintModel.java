package com.zhkj.backstage.mvp.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.mvp.contract.ComplaintContract;
import com.zhkj.backstage.service.ApiRetrofit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ComplaintModel implements ComplaintContract.Model {
    @Override
    public Observable<BaseResult<WorkOrder>> GetOrderInfoComplaintList(String OrderID, String WorkerComplaint, String FactoryComplaint, String page, String limit) {
        return ApiRetrofit.getDefault().GetOrderInfoComplaintList(OrderID, WorkerComplaint, FactoryComplaint, page, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
