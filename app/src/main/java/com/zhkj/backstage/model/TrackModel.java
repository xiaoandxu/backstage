package com.zhkj.backstage.model;


import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Track;
import com.zhkj.backstage.contract.TrackContract;
import com.zhkj.backstage.service.ApiRetrofit;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TrackModel implements TrackContract.Model {
    @Override
    public Observable<BaseResult<List<Track>>> GetOrderRecordByOrderID(String OrderId) {
        return ApiRetrofit.getDefault().GetOrderRecordByOrderID(OrderId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
