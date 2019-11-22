package com.zhkj.backstage.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.WorkOrder;

import io.reactivex.Observable;

public interface DetailContract {
    interface Model extends BaseModel{
        Observable<BaseResult<WorkOrder.DataBean>> GetOrderInfo(String OrderID);
    }

    interface View extends BaseView{
        void GetOrderInfo(BaseResult<WorkOrder.DataBean> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void GetOrderInfo(String OrderID);
    }
}
