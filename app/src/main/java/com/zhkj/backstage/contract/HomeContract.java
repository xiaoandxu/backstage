package com.zhkj.backstage.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.SalesToday;

import io.reactivex.Observable;

public interface HomeContract {
    interface Model extends BaseModel{
        Observable<BaseResult<Data<SalesToday>>> SalesToday();
    }

    interface View extends BaseView{
        void SalesToday(BaseResult<Data<SalesToday>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void SalesToday();
    }
}
