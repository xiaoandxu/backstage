package com.zhkj.backstage.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.SalesToday;
import com.zhkj.backstage.bean.SalesToday2;
import com.zhkj.backstage.bean.SalesToday3;
import com.zhkj.backstage.contract.HomeContract;

public class HomePresenter extends HomeContract.Presenter {
    @Override
    public void SalesToday() {
        mModel.SalesToday()
                .subscribe(new BaseObserver<Data<SalesToday>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<SalesToday>> value) {
                        mView.SalesToday(value);
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
    public void SalesToday3() {
        mModel.SalesToday3()
                .subscribe(new BaseObserver<Data<SalesToday3>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<SalesToday3>> value) {
                        mView.SalesToday3(value);
                    }
                });
    }
}
