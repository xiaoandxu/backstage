package com.zhkj.backstage.mvp.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WithDrawList;
import com.zhkj.backstage.mvp.contract.WithdrawContract;

public class WithdrawPresenter extends WithdrawContract.Presenter {
    @Override
    public void GetWithDrawList(String State, String UserID, String page, String limit) {
        mModel.GetWithDrawList(State, UserID, page, limit)
                .subscribe(new BaseObserver<WithDrawList>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<WithDrawList> value) {
                        mView.GetWithDrawList(value);
                    }
                });
    }

    @Override
    public void ConfirmWithDraw(String WithDrawID, String ApproveUser) {
        mModel.ConfirmWithDraw(WithDrawID, ApproveUser)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.ConfirmWithDraw(value);
                    }
                });
    }
}
