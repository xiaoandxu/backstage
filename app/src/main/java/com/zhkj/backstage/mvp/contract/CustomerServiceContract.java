package com.zhkj.backstage.mvp.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetUserInfoPartListBak;
import com.zhkj.backstage.bean.UserInfoList;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;

public interface CustomerServiceContract {
    interface Model extends BaseModel{
        Observable<BaseResult<UserInfoList>> GetUserInfo(String UserID, String limit);
        Observable<BaseResult<GetUserInfoPartListBak>> GetUserInfoPartListBak(RequestBody json);
        Observable<BaseResult<Data<String>>> SetEndOrderReceiving(String accountID);
        Observable<BaseResult<Data<String>>> SetStartOrderReceiving(String accountID);
    }

    interface View extends BaseView{
        void GetUserInfo(BaseResult<UserInfoList> baseResult);
        void GetUserInfoPartListBak(BaseResult<GetUserInfoPartListBak> baseResult);
        void SetEndOrderReceiving(BaseResult<Data<String>> baseResult);
        void SetStartOrderReceiving(BaseResult<Data<String>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void GetUserInfo(String UserID, String limit);
        public abstract void GetUserInfoPartListBak(RequestBody json);
        public abstract void SetEndOrderReceiving(String accountID);
        public abstract void SetStartOrderReceiving(String accountID);
    }
}
