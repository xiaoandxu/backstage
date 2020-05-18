package com.zhkj.backstage.mvp.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.SalesToday2;

import io.reactivex.Observable;

public interface HomeNewContract {
    interface Model extends BaseModel{
        Observable<BaseResult<GetOderCountByCustomService>> GetOderCountByCustomService();
        Observable<BaseResult<Data<SalesToday2>>> SalesToday2();
    }

    interface View extends BaseView{
        void GetOderCountByCustomService(BaseResult<GetOderCountByCustomService> baseResult);
        void SalesToday2(BaseResult<Data<SalesToday2>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void GetOderCountByCustomService();
        public abstract void SalesToday2();
    }
}
