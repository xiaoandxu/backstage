package com.zhkj.backstage.mvp.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.PayByOrderID;
import com.zhkj.backstage.mvp.contract.PayCordContract;

import java.util.List;

public class PayCordPresenter extends PayCordContract.Presenter {
    @Override
    public void GetOrderPayByOrderID(String OrderID) {
        mModel.GetOrderPayByOrderID(OrderID)
                .subscribe(new BaseObserver<List<PayByOrderID>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<List<PayByOrderID>> value) {
                        mView.GetOrderPayByOrderID(value);
                    }
                });
    }
}
