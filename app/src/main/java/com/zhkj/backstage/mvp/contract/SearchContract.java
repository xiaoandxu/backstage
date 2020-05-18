package com.zhkj.backstage.mvp.contract;


import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.WorkOrder;

import io.reactivex.Observable;

public interface SearchContract {
    interface Model extends BaseModel {
        Observable<BaseResult<WorkOrder>> GetOrderInfoList(String Phone, String OrderID, String UserID, String UserName, String limit, String page);
//        Observable<BaseResult<Data<String>>> GetFStarOrder(String OrderID, String FStarOrder);
    }

    interface View extends BaseView {
        void GetOrderInfoList(BaseResult<WorkOrder> baseResult);
//        void GetFStarOrder(BaseResult<Data<String>> baseResult);

    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void GetOrderInfoList(String Phone, String OrderID, String UserID,String UserName,String limit, String page);
//        public abstract void GetFStarOrder(String OrderID, String FStarOrder);

    }
}
