package com.zhkj.backstage.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.contract.ComplaintContract;

public class ComplaintPresenter extends ComplaintContract.Presenter {
    @Override
    public void GetOrderInfoComplaintList(String OrderID, String WorkerComplaint, String FactoryComplaint, String page, String limit) {
        mModel.GetOrderInfoComplaintList(OrderID, WorkerComplaint, FactoryComplaint, page, limit)
                .subscribe(new BaseObserver<WorkOrder>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<WorkOrder> value) {
                        mView.GetOrderInfoComplaintList(value);
                    }
                });
    }
}
