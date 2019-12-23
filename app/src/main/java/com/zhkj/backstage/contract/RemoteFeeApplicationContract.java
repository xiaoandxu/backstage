package com.zhkj.backstage.contract;

import android.view.Display;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.RemoteFeeAudit;
import com.zhkj.backstage.bean.WorkOrder;

import io.reactivex.Observable;

public interface RemoteFeeApplicationContract {
    interface Model extends BaseModel{
        Observable<BaseResult<Data<RemoteFeeAudit>>> RemoteFeeAudit(String page, String limit);
        Observable<BaseResult<Data<String>>> ApproveBeyondMoney( String OrderID, String BeyondState, String ComID, String BeyondMoney);
    }

    interface View extends BaseView{
        void RemoteFeeAudit(BaseResult<Data<RemoteFeeAudit>> baseResult);
        void ApproveBeyondMoney(BaseResult<Data<String>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View, Model>{
        public abstract void RemoteFeeAudit(String page, String limit);
        public abstract void ApproveBeyondMoney( String OrderID, String BeyondState, String ComID, String BeyondMoney);
    }
}
