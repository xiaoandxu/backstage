package com.zhkj.backstage.mvp.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BackstageGetOrderNum;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetCustomService;
import com.zhkj.backstage.bean.GetOderCountByCustomService2;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.mvp.contract.NewWorkOrderListContract;

import java.util.List;

public class NewWorkOrderListPresenter extends NewWorkOrderListContract.Presenter {
    @Override
    public void GetOderCountByCustomService() {
        mModel.GetOderCountByCustomService()
                .subscribe(new BaseObserver<GetOderCountByCustomService>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<GetOderCountByCustomService> value) {
                        mView.GetOderCountByCustomService(value);
                    }
                });
    }

    @Override
    public void BackstageGetOrderNum() {
        mModel.BackstageGetOrderNum()
                .subscribe(new BaseObserver<BackstageGetOrderNum>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<BackstageGetOrderNum> value) {
                        mView.BackstageGetOrderNum(value);
                    }
                });
    }

    @Override
    public void GetOderCountByCustomService2(String type, String IsCall, String IsAll, String searchContent, String page, String limit) {
        mModel.GetOderCountByCustomService2(type, IsCall, IsAll, searchContent, page, limit)
                .subscribe(new BaseObserver<List<GetOderCountByCustomService2>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<List<GetOderCountByCustomService2>> value) {
                        mView.GetOderCountByCustomService2(value);
                    }
                });
    }

    @Override
    public void GetoderInfoPartListBak(String type, String page, String limit) {
        mModel.GetoderInfoPartListBak(type, page, limit)
                .subscribe(new BaseObserver<WorkOrder>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<WorkOrder> value) {
                        mView.GetoderInfoPartListBak(value);
                    }
                });
    }

    @Override
    public void GetCustomService() {
        mModel.GetCustomService()
                .subscribe(new BaseObserver<List<GetCustomService>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<List<GetCustomService>> value) {
                        mView.GetCustomService(value);
                    }
                });
    }

    @Override
    public void SetChangeGiveWay(String orderID, String receivePersonID) {
        mModel.SetChangeGiveWay(orderID, receivePersonID)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.SetChangeGiveWay(value);
                    }
                });
    }
}
