package com.zhkj.backstage.model;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Address;
import com.zhkj.backstage.bean.Area;
import com.zhkj.backstage.bean.City;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.District;
import com.zhkj.backstage.bean.Province;
import com.zhkj.backstage.contract.AddServiceContract;
import com.zhkj.backstage.service.ApiRetrofit;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class AddServiceModel implements AddServiceContract.Model {


    @Override
    public Observable<BaseResult<List<Province>>> GetProvince() {
        return  ApiRetrofit.getDefault().GetProvince()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<List<City>>>> GetCity(String parentcode) {
        return  ApiRetrofit.getDefault().GetCity(parentcode)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<List<Area>>>> GetArea(String parentcode) {
        return  ApiRetrofit.getDefault().GetArea(parentcode)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<List<District>>>> GetDistrict(String parentcode, int code) {
        return  ApiRetrofit.getDefault().GetDistrict(parentcode)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<List<Address>>> GetServiceRangeByUserID(String UserID) {
        return  ApiRetrofit.getDefault().GetServiceRangeByUserID(UserID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<Data<String>>> AddorUpdateServiceArea(String UserID ,String ServiceAreaJsonStr) {
        return  ApiRetrofit.getDefault().AddorUpdateServiceArea(UserID,ServiceAreaJsonStr)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
