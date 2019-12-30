package com.zhkj.backstage.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WorkOrder;

import io.reactivex.Observable;

public interface DetailContract {
    interface Model extends BaseModel{
        Observable<BaseResult<WorkOrder.DataBean>> GetOrderInfo(String OrderID);
        Observable<BaseResult<Data<String>>> UpdatePhone(String OrderID,String Phone);
        Observable<BaseResult<Data<String>>> CloseOrder(String OrderID, String Type, String price, String UserID);
        Observable<BaseResult<Data<String>>> modifyOrderMoney(String OrderID, String orderMoney,String UserID);
        Observable<BaseResult<Data<String>>> ChangeOrderStateTwenty(String OrderId);

    }

    interface View extends BaseView{
        void GetOrderInfo(BaseResult<WorkOrder.DataBean> baseResult);
        void UpdatePhone(BaseResult<Data<String>> baseResult);
        void CloseOrder(BaseResult<Data<String>> baseResult);
        void modifyOrderMoney(BaseResult<Data<String>> baseResult);
        void ChangeOrderStateTwenty(BaseResult<Data<String>> baseResult);

    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void GetOrderInfo(String OrderID);
        public abstract void UpdatePhone(String OrderID,String Phone);
        public abstract void CloseOrder(String OrderID, String Type, String price, String UserID);
        public abstract void modifyOrderMoney(String OrderID, String orderMoney, String UserID);
        public abstract void ChangeOrderStateTwenty(String OrderId);

    }
}
