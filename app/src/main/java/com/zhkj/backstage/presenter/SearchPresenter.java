package com.zhkj.backstage.presenter;


import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.contract.SearchContract;

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
}
