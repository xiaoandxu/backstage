package com.zhkj.backstage.mvp.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetUserInfoPartListBak;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.mvp.contract.CustomerServiceContract;

import java.util.List;

import okhttp3.RequestBody;

public class CustomerServicePresenter extends CustomerServiceContract.Presenter {
    @Override
    public void GetUserInfo(String UserID, String limit) {
        mModel.GetUserInfo(UserID, limit)
                .subscribe(new BaseObserver<UserInfoList>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<UserInfoList> value) {
                        mView.GetUserInfo(value);
                    }
                });
    }

    @Override
    public void GetUserInfoPartListBak(RequestBody json) {
        mModel.GetUserInfoPartListBak(json)
                .subscribe(new BaseObserver<GetUserInfoPartListBak>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<GetUserInfoPartListBak> value) {
                        mView.GetUserInfoPartListBak(value);
                    }
                });
    }

    @Override
    public void SetEndOrderReceiving(String accountID) {
        mModel.SetEndOrderReceiving(accountID)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.SetEndOrderReceiving(value);
                    }
                });
    }

    @Override
    public void SetStartOrderReceiving(String accountID) {
        mModel.SetStartOrderReceiving(accountID)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.SetStartOrderReceiving(value);
                    }
                });
    }
}
