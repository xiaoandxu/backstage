package com.zhkj.backstage.mvp.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.UserList;

import io.reactivex.Observable;

public interface DesignatedDispatchContract {
    interface Model extends BaseModel{
        Observable<BaseResult<UserList>> GetMUserList(String UserID, String Type, String page, String limit);
        Observable<BaseResult<Data<String>>> SendOrder( String OrderID, String UserID, String LoginUser, String TypeID);
    }

    interface View extends BaseView{
        void GetMUserList(BaseResult<UserList> baseResult);
        void SendOrder(BaseResult<Data<String>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void GetMUserList(String UserID, String Type,String page, String limit);
        public abstract void SendOrder(String OrderID, String UserID, String LoginUser, String TypeID);
    }
}
