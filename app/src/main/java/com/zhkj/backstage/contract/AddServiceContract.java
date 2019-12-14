package com.zhkj.backstage.contract;



import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.Address;
import com.zhkj.backstage.bean.Area;
import com.zhkj.backstage.bean.City;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.District;
import com.zhkj.backstage.bean.Province;

import java.util.List;

import io.reactivex.Observable;


public interface AddServiceContract {
    interface Model extends BaseModel {
        Observable<BaseResult<List<Province>>> GetProvince();
        Observable<BaseResult<Data<List<City>>>> GetCity(String parentcode);
        Observable<BaseResult<Data<List<Area>>>> GetArea(String parentcode);
        Observable<BaseResult<Data<List<District>>>> GetDistrict(String parentcode, int code);
        Observable<BaseResult<List<Address>>> GetServiceRangeByUserID(String UserID);
        Observable<BaseResult<Data<String>>> AddorUpdateServiceArea(String UserID, String ServiceAreaJsonStr);
    }

    interface View extends BaseView {
        void GetProvince(BaseResult<List<Province>> baseResult);
        void GetCity(BaseResult<Data<List<City>>> baseResult);
        void GetArea(BaseResult<Data<List<Area>>> baseResult);
        void GetDistrict(BaseResult<Data<List<District>>> baseResult, int code);
        void GetServiceRangeByUserID(BaseResult<List<Address>> baseResult);
        void AddorUpdateServiceArea(BaseResult<Data<String>> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void GetProvince();

        public abstract void GetCity(String parentcode);

        public abstract void GetArea(String parentcode);
        public abstract void GetDistrict(String parentcode,int code);

        public abstract void GetServiceRangeByUserID(String UserID);

        public abstract void AddorUpdateServiceArea(String UserID ,String ServiceAreaJsonStr);
    }


}
