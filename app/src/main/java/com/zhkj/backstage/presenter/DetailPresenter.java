package com.zhkj.backstage.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.contract.DetailContract;

public class DetailPresenter extends DetailContract.Presenter {
    @Override
    public void GetOrderInfo(String OrderID) {
        mModel.GetOrderInfo(OrderID)
                .subscribe(new BaseObserver<WorkOrder.DataBean>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<WorkOrder.DataBean> value) {
                        mView.GetOrderInfo(value);
                    }
                });
    }

    @Override
    public void UpdatePhone(String OrderID, String Phone) {
        mModel.UpdatePhone(OrderID, Phone)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.UpdatePhone(value);
                    }
                });
    }

    @Override
    public void CloseOrder(String OrderID, String Type, String price, String UserID) {
        mModel.CloseOrder(OrderID, Type, price, UserID)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.CloseOrder(value);
                    }
                });
    }

    @Override
    public void modifyOrderMoney(String OrderID, String orderMoney, String UserID) {
        mModel.modifyOrderMoney(OrderID, orderMoney, UserID)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.modifyOrderMoney(value);
                    }
                });
    }


}
