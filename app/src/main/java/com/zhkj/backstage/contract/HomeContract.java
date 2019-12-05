package com.zhkj.backstage.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.SalesToday;
import com.zhkj.backstage.bean.SalesToday2;
import com.zhkj.backstage.bean.SalesToday3;

import io.reactivex.Observable;

public interface HomeContract {
    interface Model extends BaseModel{
        Observable<BaseResult<Data<SalesToday>>> SalesToday();
        Observable<BaseResult<Data<SalesToday2>>> SalesToday2();
        Observable<BaseResult<Data<SalesToday3>>> SalesToday3();
    }

    interface View extends BaseView{
        void SalesToday(BaseResult<Data<SalesToday>> baseResult);
        void SalesToday2(BaseResult<Data<SalesToday2>> baseResult);
        void SalesToday3(BaseResult<Data<SalesToday3>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void SalesToday();
        public abstract void SalesToday2();
        public abstract void SalesToday3();
    }
}
