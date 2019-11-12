package com.zhkj.backstage.presenter;


import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.contract.LoginContract;

import okhttp3.RequestBody;

public class LoginPresenter extends LoginContract.Presenter {
    @Override
    public void Login(String userName, String passWord) {
        mModel.Login(userName, passWord)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.Login(value);
                    }
                });
    }

    @Override
    public void GetUserInfo(RequestBody json) {
        mModel.GetUserInfo(json)
                .subscribe(new BaseObserver<String>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<String> value) {
                        mView.GetUserInfo(value);
                    }
                });
    }



}
