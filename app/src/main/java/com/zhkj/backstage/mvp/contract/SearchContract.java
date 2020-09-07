package com.zhkj.backstage.mvp.contract;


import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetCustomService;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.bean.WorkOrderListBean;

import java.util.List;

import io.reactivex.Observable;

public interface SearchContract {
    interface Model extends BaseModel {
        Observable<BaseResult<WorkOrder>> GetOrderInfoList(String Phone, String OrderID, String UserID, String UserName, String limit, String page);

        //        Observable<BaseResult<Data<String>>> GetFStarOrder(String OrderID, String FStarOrder);
        Observable<BaseResult<List<GetCustomService>>> GetCustomService();

        Observable<BaseResult<Data<String>>> SetChangeGiveWay(String orderID, String receivePersonID);
        Observable<WorkOrderListBean> GetoderInfoPartListBak2(String type, String OrderID, String Phone, String SelectCustomerUserId, String page, String limit);
    }

    interface View extends BaseView {
        void GetOrderInfoList(BaseResult<WorkOrder> baseResult);

        //        void GetFStarOrder(BaseResult<Data<String>> baseResult);
        void GetCustomService(BaseResult<List<GetCustomService>> baseResult);

        void SetChangeGiveWay(BaseResult<Data<String>> baseResult);
        void GetoderInfoPartListBak2(WorkOrderListBean baseResult);

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void GetOrderInfoList(String Phone, String OrderID, String UserID, String UserName, String limit, String page);

        //        public abstract void GetFStarOrder(String OrderID, String FStarOrder);
        public abstract void GetCustomService();

        public abstract void SetChangeGiveWay(String orderID, String receivePersonID);
        public abstract void GetoderInfoPartListBak2(String type, String OrderID, String Phone,String SelectCustomerUserId, String page, String limit);

    }
}
