package com.zhkj.backstage.mvp.presenter;


import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Address;
import com.zhkj.backstage.bean.Area;
import com.zhkj.backstage.bean.City;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.District;
import com.zhkj.backstage.bean.Province;
import com.zhkj.backstage.mvp.contract.AddServiceContract;

import java.util.List;

public class AddServicePresenter extends AddServiceContract.Presenter {


    @Override
    public void GetProvince() {
        mModel.GetProvince()
                .subscribe(new BaseObserver<List<Province>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<List<Province>> value) {
                        mView.GetProvince(value);
                    }
                });
    }

    @Override
    public void GetCity(String parentcode) {
        mModel.GetCity(parentcode)
                .subscribe(new BaseObserver<Data<List<City>>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<List<City>>> value) {
                        mView.GetCity(value);
                    }
                });
    }

    @Override
    public void GetArea(String parentcode) {
        mModel.GetArea(parentcode)
                .subscribe(new BaseObserver<Data<List<Area>>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<List<Area>>> value) {
                        mView.GetArea(value);
                    }
                });
    }

    @Override
    public void GetDistrict(String parentcode, final int code) {
        mModel.GetDistrict(parentcode,code)
                .subscribe(new BaseObserver<Data<List<District>>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<List<District>>> value) {
                        mView.GetDistrict(value,code);
                    }
                });
    }

    @Override
    public void GetServiceRangeByUserID(String UserID) {
        mModel.GetServiceRangeByUserID(UserID)
                .subscribe(new BaseObserver<List<Address>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<List<Address>> value) {
                        mView.GetServiceRangeByUserID(value);
                    }
                });
    }

    @Override
    public void AddorUpdateServiceArea(String UserID,String ServiceAreaJsonStr) {
        mModel.AddorUpdateServiceArea(UserID,ServiceAreaJsonStr)
                .subscribe(new BaseObserver<Data<String>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<Data<String>> value) {
                        mView.AddorUpdateServiceArea(value);
                    }
                });
    }
}
