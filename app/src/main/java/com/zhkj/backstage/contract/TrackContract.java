package com.zhkj.backstage.contract;

import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Track;

import java.util.List;

import io.reactivex.Observable;

public interface TrackContract {
    interface Model extends BaseModel {
        Observable<BaseResult<List<Track>>> GetOrderRecordByOrderID(String OrderId);
    }

    interface View extends BaseView {
        void GetOrderRecordByOrderID(BaseResult<List<Track>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void GetOrderRecordByOrderID(String OrderId);
    }
}
