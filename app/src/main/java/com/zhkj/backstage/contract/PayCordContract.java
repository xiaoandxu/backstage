package com.zhkj.backstage.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.PayByOrderID;

import java.util.List;

import io.reactivex.Observable;

public interface PayCordContract {
    interface Model extends BaseModel{
        Observable<BaseResult<List<PayByOrderID>>> GetOrderPayByOrderID(String OrderID);
    }

    interface View extends BaseView{
        void GetOrderPayByOrderID(BaseResult<List<PayByOrderID>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void GetOrderPayByOrderID(String OrderID);
    }
}
