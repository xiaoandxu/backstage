package com.zhkj.backstage.mvp.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.BankCard;
import com.zhkj.backstage.bean.CompanyInfo;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetIDCardImg;
import com.zhkj.backstage.bean.UserInfoList;

import java.util.List;

import io.reactivex.Observable;

public interface PersonalInformationCotract {
    interface Model extends BaseModel{
        Observable<BaseResult<UserInfoList>> GetUserInfo(String UserID, String limit);
        Observable<BaseResult<Data<CompanyInfo>>> GetmessageBytype(String UserId);
        Observable<BaseResult<List<GetIDCardImg>>> GetIDCardImg(String UserId);
        Observable<BaseResult<List<BankCard>>> GetAccountPayInfoList(String UserId);
        Observable<BaseResult<Data<String>>> ApproveAuth(String UserID, String State, String AuthMessage);
    }

    interface View extends BaseView{
        void GetUserInfo(BaseResult<UserInfoList> baseResult);
        void GetmessageBytype(BaseResult<Data<CompanyInfo>> baseResult);
        void GetIDCardImg(BaseResult<List<GetIDCardImg>> baseResult);
        void GetAccountPayInfoList(BaseResult<List<BankCard>> baseResult);
        void ApproveAuth(BaseResult<Data<String>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void GetUserInfo(String UserID, String limit);
        public abstract void GetmessageBytype(String UserId);
        public abstract void GetIDCardImg(String UserId);
        public abstract void GetAccountPayInfoList(String UserId);
        public abstract void ApproveAuth(String UserID, String State, String AuthMessage);
    }
}
