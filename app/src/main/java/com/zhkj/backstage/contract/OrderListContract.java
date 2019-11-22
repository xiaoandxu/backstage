package com.zhkj.backstage.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
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
                                                           String page,
                                                           String limit);
    }

    interface View extends BaseView{
        void GetOrderInfoList(BaseResult<WorkOrder> baseResult);
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
                                              String page,
                                              String limit);
    }
}
