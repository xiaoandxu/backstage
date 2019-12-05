package com.zhkj.backstage.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.UserList;
import com.zhkj.backstage.contract.DesignatedDispatchContract;

public class DesignatedDispatchPresenter extends DesignatedDispatchContract.Presenter {
    @Override
    public void GetMUserList(String UserID, String Type,String page, String limit) {
        mModel.GetMUserList(UserID, Type,page,limit)
                .subscribe(new BaseObserver<UserList>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<UserList> value) {
                        mView.GetMUserList(value);
                    }
                });
    }

    @Override
    public void SendOrder(String OrderID, String UserID, String LoginUser, String TypeID) {
        mModel.SendOrder(OrderID, UserID, LoginUser, TypeID)
                .subscribe(new BaseObserver<String>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<String> value) {
                        mView.SendOrder(value);
                    }
                });
    }
}
