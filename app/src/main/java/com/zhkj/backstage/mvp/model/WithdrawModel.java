package com.zhkj.backstage.mvp.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WithDrawList;
import com.zhkj.backstage.mvp.contract.WithdrawContract;
import com.zhkj.backstage.service.ApiRetrofit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WithdrawModel implements WithdrawContract.Model {
    @Override
    public Observable<BaseResult<WithDrawList>> GetWithDrawList(String State, String UserID, String page, String limit) {
        return ApiRetrofit.getDefault().GetWithDrawList(State, UserID, page, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<String>>> ConfirmWithDraw(String WithDrawID, String ApproveUser) {
        return ApiRetrofit.getDefault().ConfirmWithDraw(WithDrawID, ApproveUser)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
