package com.zhkj.backstage.mvp.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.mvp.contract.VendorListContract;

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
}
