package com.zhkj.backstage.mvp.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseObserver2;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.AddrList;
import com.zhkj.backstage.bean.GetUserInfoListForPlatformResult;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.bean.worker;
import com.zhkj.backstage.mvp.contract.VendorListContract;

import okhttp3.RequestBody;

public class VendorListPresenter extends VendorListContract.Presenter {
    @Override
    public void GetUserInfoList(String Type, String IfAuth,String StartDate, String EndDate,String page, String limit) {
        mModel.GetUserInfoList(Type, IfAuth,StartDate,EndDate,page,limit)
                .subscribe(new BaseObserver<UserInfoList>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<UserInfoList> value) {
                        mView.GetUserInfoList(value);
                    }
                });
    }
    @Override
    public void GetUserInfoPartList(RequestBody json) {
        mModel.GetUserInfoPartList(json)
                .subscribe(new BaseObserver<UserInfoList>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<UserInfoList> value) {
                        mView.GetUserInfoPartList(value);
                    }
                });
    }

    @Override
    public void GetUserInfoListForPlatform(RequestBody json) {
        mModel.GetUserInfoListForPlatform(json)
                .subscribe(new BaseObserver2<GetUserInfoListForPlatformResult>() {
                    @Override
                    protected void onHandleSuccess(GetUserInfoListForPlatformResult value) {
                        mView.GetUserInfoListForPlatform(value);
                    }
                });
    }

    @Override
    public void GetProvinceMasterDistance() {
        mModel.GetProvinceMasterDistance()
                .subscribe(new BaseObserver<AddrList>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<AddrList> value) {
                        mView.GetProvinceMasterDistance(value);
                    }
                });
    }

    @Override
    public void GetProvinceMasterList(String page, String limit, String code) {
        mModel.GetProvinceMasterList(page, limit, code)
                .subscribe(new BaseObserver<worker>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<worker> value) {
                        mView.GetProvinceMasterList(value);
                    }
                });
    }
}
