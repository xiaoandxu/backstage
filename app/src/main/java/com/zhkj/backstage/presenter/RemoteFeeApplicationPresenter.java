package com.zhkj.backstage.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.RemoteFeeAudit;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.contract.RemoteFeeApplicationContract;

public class RemoteFeeApplicationPresenter extends RemoteFeeApplicationContract.Presenter {
    @Override
    public void RemoteFeeAudit(String page, String limit) {
        mModel.RemoteFeeAudit(page, limit)
                .subscribe(new BaseObserver<Data<RemoteFeeAudit>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<RemoteFeeAudit>> value) {
                        mView.RemoteFeeAudit(value);
                    }
                });
    }

    @Override
    public void ApproveBeyondMoney(String OrderID, String BeyondState, String ComID, String BeyondMoney) {
        mModel.ApproveBeyondMoney(OrderID, BeyondState, ComID, BeyondMoney)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.ApproveBeyondMoney(value);
                    }
                });
    }
}
