package com.zhkj.backstage.mvp.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.BackstageGetOrderNum;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetModuleByRoleId;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.SalesToday2;
import com.zhkj.backstage.bean.SalesToday3;
import com.zhkj.backstage.bean.UserInfoList;

import io.reactivex.Observable;

public interface HomeNewContract {
    interface Model extends BaseModel{
        Observable<BaseResult<GetOderCountByCustomService>> GetOderCountByCustomService();
        Observable<BaseResult<BackstageGetOrderNum>> BackstageGetOrderNum();
        Observable<BaseResult<Data<SalesToday2>>> SalesToday2();
        Observable<BaseResult<Data<SalesToday3>>> SalesToday3();
        Observable<BaseResult<UserInfoList>> GetUserInfo(String UserID, String limit);
        Observable<BaseResult<GetModuleByRoleId>> GetModuleByRoleId(String RoleId);

    }

    interface View extends BaseView{
        void GetOderCountByCustomService(BaseResult<GetOderCountByCustomService> baseResult);
        void BackstageGetOrderNum(BaseResult<BackstageGetOrderNum> baseResult);
        void SalesToday2(BaseResult<Data<SalesToday2>> baseResult);
        void SalesToday3(BaseResult<Data<SalesToday3>> baseResult);
        void GetUserInfo(BaseResult<UserInfoList> baseResult);
        void GetModuleByRoleId(BaseResult<GetModuleByRoleId> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void GetOderCountByCustomService();
        public abstract void BackstageGetOrderNum();
        public abstract void SalesToday2();
        public abstract void SalesToday3();
        public abstract void GetUserInfo(String UserID, String limit);
        public abstract void GetModuleByRoleId(String RoleId);
    }
}
