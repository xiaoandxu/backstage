package com.zhkj.backstage.mvp.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.GetOderCountByCustomService2;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.mvp.contract.NewWorkOrderListContract;

import java.util.List;

public class NewWorkOrderListPresenter extends NewWorkOrderListContract.Presenter {
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
    public void GetOderCountByCustomService2(String type, String IsCall, String IsAll, String searchContent, String page, String limit) {
        mModel.GetOderCountByCustomService2(type, IsCall, IsAll, searchContent, page, limit)
                .subscribe(new BaseObserver<List<GetOderCountByCustomService2>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<List<GetOderCountByCustomService2>> value) {
                        mView.GetOderCountByCustomService2(value);
                    }
                });
    }
}
