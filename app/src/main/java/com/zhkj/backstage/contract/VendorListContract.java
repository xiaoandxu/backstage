package com.zhkj.backstage.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.UserInfoList;

import io.reactivex.Observable;

public interface VendorListContract  {
    interface Model extends BaseModel{
        Observable<BaseResult<UserInfoList>> GetUserInfoList(String Type, String IfAuth ,String page, String limit);
    }

    interface View extends BaseView{
        void GetUserInfoList(BaseResult<UserInfoList> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void GetUserInfoList(String Type, String IfAuth,String page, String limit);
    }
}
