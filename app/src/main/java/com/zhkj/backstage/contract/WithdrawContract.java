package com.zhkj.backstage.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WithDrawList;

import java.util.List;

import io.reactivex.Observable;

public interface WithdrawContract {
    interface Model extends BaseModel{
        Observable<BaseResult<WithDrawList>> GetWithDrawList(String State, String UserID, String page, String limit);
        Observable<BaseResult<Data<String>>> ConfirmWithDraw(String WithDrawID, String ApproveUser);
    }

    interface View extends BaseView{
        void GetWithDrawList(BaseResult<WithDrawList> baseResult);
        void ConfirmWithDraw(BaseResult<Data<String>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void GetWithDrawList(String State, String UserID, String page, String limit);
        public abstract void ConfirmWithDraw(String WithDrawID, String ApproveUser);
    }
}
