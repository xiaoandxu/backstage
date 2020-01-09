package com.zhkj.backstage.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.Logistics;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.contract.ExpressInfoContract;

public class ExpressInfoPresenter extends ExpressInfoContract.Presenter {
    @Override
    public void GetExpressInfo(String ExpressNo) {
        mModel.GetExpressInfo(ExpressNo)
                .subscribe(new BaseObserver<Data<Logistics>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<Logistics>> value) {
                        mView.GetExpressInfo(value);
                    }
                });
    }

    @Override
    public void GetOrderInfo(String OrderID) {
        mModel.GetOrderInfo(OrderID).subscribe(new BaseObserver<WorkOrder.DataBean>() {
            @Override
            protected void onHandleSuccess(BaseResult<WorkOrder.DataBean> value) {
                mView.GetOrderInfo(value);
            }
        });
    }

}
