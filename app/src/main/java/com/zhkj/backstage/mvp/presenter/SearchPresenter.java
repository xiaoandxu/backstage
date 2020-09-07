package com.zhkj.backstage.mvp.presenter;


import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseObserver2;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetCustomService;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.bean.WorkOrderListBean;
import com.zhkj.backstage.mvp.contract.SearchContract;

import java.util.List;

public class SearchPresenter extends SearchContract.Presenter {
    @Override
    public void GetOrderInfoList(String Phone, String OrderID,String UserID ,String UserName,String limit, String page) {
        mModel.GetOrderInfoList(Phone, OrderID, UserID,UserName,limit, page)
                .subscribe(new BaseObserver<WorkOrder>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<WorkOrder> value) {
                        mView.GetOrderInfoList(value);
                    }
                });
    }

//    @Override
//    public void GetFStarOrder(String OrderID, String FStarOrder) {
//        mModel.GetFStarOrder(OrderID, FStarOrder)
//                .subscribe(new BaseObserver<Data<String>>() {
//                    @Override
//                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
//                        mView.GetFStarOrder(value);
//                    }
//                });
//    }

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

    @Override
    public void GetoderInfoPartListBak2(String type, String OrderID, String Phone, String SelectCustomerUserId,String page, String limit) {
        mModel.GetoderInfoPartListBak2(type, OrderID, Phone,SelectCustomerUserId, page, limit)
                .subscribe(new BaseObserver2<WorkOrderListBean>() {
                    @Override
                    protected void onHandleSuccess(WorkOrderListBean value) {
                        mView.GetoderInfoPartListBak2(value);
                    }
                });
    }
}
