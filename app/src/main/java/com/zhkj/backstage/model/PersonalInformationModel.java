package com.zhkj.backstage.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BankCard;
import com.zhkj.backstage.bean.CompanyInfo;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetIDCardImg;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.contract.PersonalInformationCotract;
import com.zhkj.backstage.service.ApiRetrofit;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PersonalInformationModel implements PersonalInformationCotract.Model {
    @Override
    public Observable<BaseResult<UserInfoList>> GetUserInfo(String UserID, String limit) {
        return ApiRetrofit.getDefault().GetUserInfo(UserID, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<CompanyInfo>>> GetmessageBytype(String UserId) {
        return ApiRetrofit.getDefault().GetmessageBytype(UserId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<List<GetIDCardImg>>> GetIDCardImg(String UserId) {
        return ApiRetrofit.getDefault().GetIDCardImg(UserId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<List<BankCard>>> GetAccountPayInfoList(String UserId) {
        return ApiRetrofit.getDefault().GetAccountPayInfoList(UserId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<String>>> ApproveAuth(String UserID, String State, String AuthMessage) {
        return ApiRetrofit.getDefault().ApproveAuth(UserID, State, AuthMessage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
