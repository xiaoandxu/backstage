package com.zhkj.backstage.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.SalesToday;
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
}
