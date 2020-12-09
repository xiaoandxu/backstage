package com.zhkj.backstage.mvp.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BankCard;
import com.zhkj.backstage.bean.CompanyInfo;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetIDCardImg;
import com.zhkj.backstage.bean.GetSecondCategoryListResult;
import com.zhkj.backstage.bean.UpdateFactroyUserResult;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.mvp.contract.PersonalInformationCotract;
import com.zhkj.backstage.service.ApiRetrofit;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

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

    @Override
    public Observable<UpdateFactroyUserResult> UpdateFactroyUser(RequestBody json) {
        return ApiRetrofit.getDefault().UpdateFactroyUser(json)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<GetSecondCategoryListResult> GetSecondCategoryList() {
        return ApiRetrofit.getDefault().GetSecondCategoryList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
