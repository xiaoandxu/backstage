package com.zhkj.backstage.mvp.model;


import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.CategoryData;
import com.zhkj.backstage.bean.Skill;
import com.zhkj.backstage.mvp.contract.AddSkillsContract;
import com.zhkj.backstage.service.ApiRetrofit;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class AddSkillsModel implements AddSkillsContract.Model {


    @Override
    public Observable<BaseResult<CategoryData>> GetFactoryCategory(String ParentID) {
        return  ApiRetrofit.getDefault().GetFactoryCategory(ParentID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<CategoryData>> GetChildFactoryCategory(String ParentID) {
        return  ApiRetrofit.getDefault().GetChildFactoryCategory(ParentID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<List<Skill>>> GetAccountSkill(String UserID) {
        return  ApiRetrofit.getDefault().GetAccountSkill(UserID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseResult<String>> UpdateAccountSkillData(String UserID,String NodeIds) {
        return  ApiRetrofit.getDefault().UpdateAccountSkillData(UserID,NodeIds)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

}
