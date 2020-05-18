package com.zhkj.backstage.mvp.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.ComplaintList;
import com.zhkj.backstage.mvp.contract.ComplaintListContract;

import java.util.List;

public class ComplaintListPresenter extends ComplaintListContract.Presenter {
    @Override
    public void GetComplaintListByOrderId(String OrderId) {
        mModel.GetComplaintListByOrderId(OrderId)
                .subscribe(new BaseObserver<List<ComplaintList>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<List<ComplaintList>> value) {
                        mView.GetComplaintListByOrderId(value);
                    }
                });
    }
}
