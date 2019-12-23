package com.zhkj.backstage.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.RemoteFeeAudit;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.contract.RemoteFeeApplicationContract;
import com.zhkj.backstage.service.ApiRetrofit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RemoteFeeApplicationModel implements RemoteFeeApplicationContract.Model {
    @Override
    public Observable<BaseResult<Data<RemoteFeeAudit>>> RemoteFeeAudit(String page, String limit) {
        return ApiRetrofit.getDefault().RemoteFeeAudit(page, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<String>>> ApproveBeyondMoney(String OrderID, String BeyondState, String ComID, String BeyondMoney) {
        return ApiRetrofit.getDefault().ApproveBeyondMoney(OrderID, BeyondState, ComID, BeyondMoney)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
