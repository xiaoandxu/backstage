package com.zhkj.backstage.mvp.presenter;

import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BackstageGetOrderNum;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetModuleByRoleId;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.SalesToday2;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.mvp.contract.HomeNewContract;

public class HomeNewPresenter extends HomeNewContract.Presenter {
    @Override
    public void GetOderCountByCustomService() {
        mModel.GetOderCountByCustomService()
                .subscribe(new BaseObserver<GetOderCountByCustomService>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<GetOderCountByCustomService> value) {
                        mView.GetOderCountByCustomService(value);
                    }
                });
    }

    @Override
    public void BackstageGetOrderNum() {
        mModel.BackstageGetOrderNum()
                .subscribe(new BaseObserver<BackstageGetOrderNum>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<BackstageGetOrderNum> value) {
                        mView.BackstageGetOrderNum(value);
                    }
                });
    }

    @Override
    public void SalesToday2() {
        mModel.SalesToday2()
                .subscribe(new BaseObserver<Data<SalesToday2>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<SalesToday2>> value) {
                        mView.SalesToday2(value);
                    }
                });
    }

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
    public void GetModuleByRoleId(String RoleId) {
        mModel.GetModuleByRoleId(RoleId)
                .subscribe(new BaseObserver<GetModuleByRoleId>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<GetModuleByRoleId> value) {
                        mView.GetModuleByRoleId(value);
                    }
                });
    }
}
