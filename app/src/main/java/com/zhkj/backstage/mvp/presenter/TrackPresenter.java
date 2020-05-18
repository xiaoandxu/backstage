package com.zhkj.backstage.mvp.presenter;


import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.Track;
import com.zhkj.backstage.mvp.contract.TrackContract;

import java.util.List;

public class TrackPresenter extends TrackContract.Presenter {
    @Override
    public void GetOrderRecordByOrderID(String OrderId) {
        mModel.GetOrderRecordByOrderID(OrderId)
                .subscribe(new BaseObserver<List<Track>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<List<Track>> value) {
                        mView.GetOrderRecordByOrderID(value);
                    }
                });
    }

    @Override
    public void UpdateOrderrecord(String RecordID, String StateName) {
        mModel.UpdateOrderrecord(RecordID, StateName)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.UpdateOrderrecord(value);
                    }
                });
    }
}
