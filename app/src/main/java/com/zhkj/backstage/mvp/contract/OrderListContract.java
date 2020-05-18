package com.zhkj.backstage.mvp.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WorkOrder;

import io.reactivex.Observable;

public interface OrderListContract {
    interface Model extends BaseModel{
        Observable<BaseResult<WorkOrder>> GetOrderInfoList(String OrderID,
                                                           String UserID,
                                                           String TypeID,
                                                           String State,
                                                           String ProvinceCode,
                                                           String CityCode,
                                                           String AreaCode,
                                                           String CreateDate,
                                                           String partsIs,
                                                           String messageIs,
                                                           String SendUserIs,
                                                           String StartTime,
                                                           String EndTime,
                                                           String SendUser,
                                                           String page,
                                                           String limit);
        Observable<BaseResult<Data<String>>> ChangeOrderStateTwenty(String OrderId);
    }

    interface View extends BaseView{
        void GetOrderInfoList(BaseResult<WorkOrder> baseResult);
        void ChangeOrderStateTwenty(BaseResult<Data<String>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void GetOrderInfoList(String OrderID,
                                              String UserID,
                                              String TypeID,
                                              String State,
                                              String ProvinceCode,
                                              String CityCode,
                                              String AreaCode,
                                              String CreateDate,
                                              String partsIs,
                                              String messageIs,
                                              String SendUserIs,
                                              String StartTime,
                                              String EndTime,
                                              String SendUser,
                                              String page,
                                              String limit);
        public abstract void ChangeOrderStateTwenty(String OrderId);
    }
}
