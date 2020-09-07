package com.zhkj.backstage.mvp.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.BackstageGetOrderNum;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetCustomService;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.WorkOrderListBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.RequestBody;

public interface NewWorkOrderListContract {
    interface Model extends BaseModel {
        Observable<BaseResult<GetOderCountByCustomService>> GetOderCountByCustomService();
        Observable<BaseResult<BackstageGetOrderNum>> BackstageGetOrderNum();
        Observable<WorkOrderListBean> GetOderCountByCustomService2(String type,
                                                                                                String IsCall,
                                                                                                String IsAll,
                                                                                                String searchContent,
                                                                                                String page,
                                                                                                String limit);
        Observable<WorkOrderListBean> GetoderInfoPartListBak(String type, String page, String limit);
        Observable<WorkOrderListBean> GetoderInfoPartListBak(RequestBody json);
        Observable<BaseResult<List<GetCustomService>>> GetCustomService();
        Observable<BaseResult<Data<String>>> SetChangeGiveWay(String orderID, String receivePersonID);


    }

    interface View extends BaseView {
        void GetOderCountByCustomService(BaseResult<GetOderCountByCustomService> baseResult);
        void BackstageGetOrderNum(BaseResult<BackstageGetOrderNum> baseResult);
        void GetOderCountByCustomService2(WorkOrderListBean baseResult);
        void GetoderInfoPartListBak(WorkOrderListBean baseResult);
        void GetCustomService(BaseResult<List<GetCustomService>> baseResult);
        void SetChangeGiveWay(BaseResult<Data<String>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void GetOderCountByCustomService();
        public abstract void BackstageGetOrderNum();
        public abstract void GetOderCountByCustomService2(String type,
                                                          String IsCall,
                                                          String IsAll,
                                                          String searchContent,
                                                          String page,
                                                          String limit);
        public abstract void GetoderInfoPartListBak(String type, String page, String limit);
        public abstract void GetoderInfoPartListBak(RequestBody json);
        public abstract void GetCustomService();
        public abstract void SetChangeGiveWay(String orderID, String receivePersonID);
    }
}
