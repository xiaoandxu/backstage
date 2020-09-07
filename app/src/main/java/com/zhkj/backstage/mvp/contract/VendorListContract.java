package com.zhkj.backstage.mvp.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.AddrList;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.bean.worker;

import io.reactivex.Observable;
import okhttp3.RequestBody;

public interface VendorListContract  {
    interface Model extends BaseModel{
        Observable<BaseResult<UserInfoList>> GetUserInfoList(String Type, String IfAuth ,String StartDate, String EndDate,String page, String limit);
        Observable<BaseResult<UserInfoList>> GetUserInfoPartList(RequestBody json);
        Observable<BaseResult<AddrList>> GetProvinceMasterDistance();
        Observable<BaseResult<worker>> GetProvinceMasterList(String page,String limit,String code);
    }

    interface View extends BaseView{
        void GetUserInfoList(BaseResult<UserInfoList> baseResult);
        void GetUserInfoPartList(BaseResult<UserInfoList> baseResult);
        void GetProvinceMasterDistance(BaseResult<AddrList> baseResult);
        void GetProvinceMasterList(BaseResult<worker> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void GetUserInfoList(String Type, String IfAuth,String StartDate, String EndDate,String page, String limit);
        public abstract void GetUserInfoPartList(RequestBody json);
        public abstract void GetProvinceMasterDistance();
        public abstract void GetProvinceMasterList(String page,String limit,String code);
    }
}
