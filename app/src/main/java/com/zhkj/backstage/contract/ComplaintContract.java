package com.zhkj.backstage.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.WorkOrder;

import io.reactivex.Observable;

public interface ComplaintContract {
    interface Model extends BaseModel{
        Observable<BaseResult<WorkOrder>> GetOrderInfoComplaintList(String OrderID, String WorkerComplaint, String FactoryComplaint, String page, String limit);
    }

    interface View extends BaseView{
        void GetOrderInfoComplaintList(BaseResult<WorkOrder> baseResult);
    }

    abstract class Presenter extends BasePresenter<View ,Model>{
        public abstract void GetOrderInfoComplaintList(String OrderID, String WorkerComplaint, String FactoryComplaint, String page, String limit);
    }
}
