package com.zhkj.backstage.mvp.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WorkOrder;

import io.reactivex.Observable;
import okhttp3.RequestBody;

public interface LeaveMessageContract {
    interface Model extends BaseModel {
        Observable<BaseResult<Data<String>>> AddLeaveMessageForOrder(String UserID, String OrderId, String Content, String photo);
        //根据工单号获取工单详情
        Observable<BaseResult<WorkOrder.DataBean>> GetOrderInfo(String OrderID);
        Observable<BaseResult<Data<String>>> LeaveMessageImg(RequestBody json);
        Observable<BaseResult<Data>> LeaveMessageWhetherLook(String OrderID);
    }

    interface View extends BaseView {
        void AddLeaveMessageForOrder(BaseResult<Data<String>> baseResult);
        //根据工单号获取工单详情
        void GetOrderInfo(BaseResult<WorkOrder.DataBean> baseResult);
        void LeaveMessageImg(BaseResult<Data<String>> baseResult);
        void LeaveMessageWhetherLook(BaseResult<Data> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void AddLeaveMessageForOrder(String UserID, String OrderId, String Content,String photo);
        //根据工单号获取工单详情
        public abstract void GetOrderInfo(String OrderID);
        public abstract void LeaveMessageImg(RequestBody json);
        public abstract void LeaveMessageWhetherLook(String OrderID);
    }
}
