package com.zhkj.backstage.mvp.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.mvp.contract.DetailContract;

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
    public void CloseOrder(String OrderID, String Type, String price, String UserID,String value) {
        mModel.CloseOrder(OrderID, Type, price, UserID,value)
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

    @Override
    public void ChangeOrderStateTwenty(String OrderId) {
        mModel.ChangeOrderStateTwenty(OrderId)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.ChangeOrderStateTwenty(value);
                    }
                });
    }

    @Override
    public void NowEnSureOrder(String OrderId,String UserID) {
        mModel.NowEnSureOrder(OrderId,UserID)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.NowEnSureOrder(value);
                    }
                });
    }

    @Override
    public void endAgain(String OrderID, String FactoryPrice, String wokerPrice, String UserID) {
        mModel.endAgain(OrderID, FactoryPrice, wokerPrice, UserID)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.endAgain(value);
                    }
                });
    }
}
