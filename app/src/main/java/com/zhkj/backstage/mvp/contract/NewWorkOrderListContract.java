package com.zhkj.backstage.mvp.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.GetOderCountByCustomService2;
import com.zhkj.backstage.bean.GetOderCountByCustomService;

import java.util.List;

import io.reactivex.Observable;

public interface NewWorkOrderListContract {
    interface Model extends BaseModel {
        Observable<BaseResult<GetOderCountByCustomService>> GetOderCountByCustomService();
        Observable<BaseResult<List<GetOderCountByCustomService2>>> GetOderCountByCustomService2(String type,
                                                                                                String IsCall,
                                                                                                String IsAll,
                                                                                                String searchContent,
                                                                                                String page,
                                                                                                String limit);
    }

    interface View extends BaseView {
        void GetOderCountByCustomService(BaseResult<GetOderCountByCustomService> baseResult);
        void GetOderCountByCustomService2(BaseResult<List<GetOderCountByCustomService2>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void GetOderCountByCustomService();
        public abstract void GetOderCountByCustomService2(String type,
                                                          String IsCall,
                                                          String IsAll,
                                                          String searchContent,
                                                          String page,
                                                          String limit);
    }
}
