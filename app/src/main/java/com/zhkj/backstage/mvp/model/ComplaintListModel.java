package com.zhkj.backstage.mvp.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.ComplaintList;
import com.zhkj.backstage.mvp.contract.ComplaintListContract;
import com.zhkj.backstage.service.ApiRetrofit;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ComplaintListModel implements ComplaintListContract.Model {
    @Override
    public Observable<BaseResult<List<ComplaintList>>> GetComplaintListByOrderId(String OrderId) {
        return ApiRetrofit.getDefault().GetComplaintListByOrderId(OrderId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
