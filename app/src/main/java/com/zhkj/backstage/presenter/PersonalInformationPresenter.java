package com.zhkj.backstage.presenter;

import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BankCard;
import com.zhkj.backstage.bean.CompanyInfo;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetIDCardImg;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.contract.PersonalInformationCotract;

import java.util.List;

public class PersonalInformationPresenter extends PersonalInformationCotract.Presenter {
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
    public void GetmessageBytype(String UserId) {
        mModel.GetmessageBytype(UserId)
                .subscribe(new BaseObserver<Data<CompanyInfo>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<CompanyInfo>> value) {
                        mView.GetmessageBytype(value);
                    }
                });
    }

    @Override
    public void GetIDCardImg(String UserId) {
        mModel.GetIDCardImg(UserId)
                .subscribe(new BaseObserver<List<GetIDCardImg>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<List<GetIDCardImg>> value) {
                        mView.GetIDCardImg(value);
                    }
                });
    }

    @Override
    public void GetAccountPayInfoList(String UserId) {
        mModel.GetAccountPayInfoList(UserId)
                .subscribe(new BaseObserver<List<BankCard>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<List<BankCard>> value) {
                        mView.GetAccountPayInfoList(value);
                    }
                });
    }

    @Override
    public void ApproveAuth(String UserID, String State, String AuthMessage) {
        mModel.ApproveAuth(UserID, State, AuthMessage)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.ApproveAuth(value);
                    }
                });
    }
}
