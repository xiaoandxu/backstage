package com.zhkj.backstage.mvp.contract;


import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.Logistics;
import com.zhkj.backstage.bean.WorkOrder;

import io.reactivex.Observable;

public interface ExpressInfoContract {
    interface Model extends BaseModel {
        Observable<BaseResult<Data<Logistics>>> GetExpressInfo(String ExpressNo);
        Observable<BaseResult<WorkOrder.DataBean>> GetOrderInfo(String OrderID);
    }

    interface View extends BaseView {
        void GetExpressInfo(BaseResult<Data<Logistics>> baseResult);
        void GetOrderInfo(BaseResult<WorkOrder.DataBean> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void GetExpressInfo(String ExpressNo);
        public abstract void GetOrderInfo(String OrderID);
    }
}
