package com.zhkj.backstage.mvp.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.mvp.contract.OrderListContract;

public class OrderListPresenter extends OrderListContract.Presenter {
    @Override
    public void GetOrderInfoList(String OrderID, String UserID, String TypeID, String State, String ProvinceCode, String CityCode, String AreaCode, String CreateDate, String partsIs, String messageIs,String SendUserIs,String StartTime, String EndTime,String SendUser,String page, String limit) {
        mModel.GetOrderInfoList(OrderID, UserID, TypeID, State, ProvinceCode, CityCode, AreaCode, CreateDate, partsIs, messageIs,SendUserIs,StartTime,EndTime,SendUser,page,limit)
                .subscribe(new BaseObserver<WorkOrder>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<WorkOrder> value) {
                        mView.GetOrderInfoList(value);
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
}
