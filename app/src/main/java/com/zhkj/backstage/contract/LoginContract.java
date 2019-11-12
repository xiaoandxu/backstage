package com.zhkj.backstage.contract;


import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Data;

import io.reactivex.Observable;
import okhttp3.RequestBody;


public interface LoginContract {
    interface Model extends BaseModel {
        Observable<BaseResult<Data<String>>> Login(String userName, String passWord);
        Observable<BaseResult<String>> GetUserInfo(RequestBody json);

    }

    interface View extends BaseView {
        void Login(BaseResult<Data<String>> baseResult);
        void GetUserInfo(BaseResult<String> baseResult);

    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void Login(String userName,String passWord);
        public abstract void GetUserInfo(RequestBody json);
    }
}
