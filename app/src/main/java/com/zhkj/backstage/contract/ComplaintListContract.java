package com.zhkj.backstage.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.ComplaintList;

import java.util.List;

import io.reactivex.Observable;

public interface ComplaintListContract {
    interface Model extends BaseModel{
        Observable<BaseResult<List<ComplaintList>>> GetComplaintListByOrderId(String OrderId);
    }

    interface View extends BaseView{
        void GetComplaintListByOrderId(BaseResult<List<ComplaintList>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void GetComplaintListByOrderId(String OrderId);
    }
}
