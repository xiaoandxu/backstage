package com.zhkj.backstage.presenter;


import com.zhkj.backstage.base.BaseObserver;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.CategoryData;
import com.zhkj.backstage.bean.Skill;
import com.zhkj.backstage.contract.AddSkillsContract;

import java.util.List;

public class AddSkillsPresenter extends AddSkillsContract.Presenter {


    @Override
    public void GetFactoryCategory(String ParentID) {
        mModel.GetFactoryCategory(ParentID)
                .subscribe(new BaseObserver<CategoryData>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<CategoryData> value) {
                        mView.GetFactoryCategory(value);
                    }
                });
    }

    @Override
    public void GetChildFactoryCategory(String ParentID) {
        mModel.GetChildFactoryCategory(ParentID)
                .subscribe(new BaseObserver<CategoryData>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<CategoryData> value) {
                        mView.GetChildFactoryCategory(value);
                    }
                });
    }

    @Override
    public void GetAccountSkill(String UserID) {
        mModel.GetAccountSkill(UserID)
                .subscribe(new BaseObserver<List<Skill>>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<List<Skill>> value) {
                        mView.GetAccountSkill(value);
                    }
                });
    }

    @Override
    public void UpdateAccountSkillData(String UserID, String NodeIds) {
        mModel.UpdateAccountSkillData(UserID,NodeIds)
                .subscribe(new BaseObserver<String>() {
                    @Override
                    protected void onHandleSuccess(BaseResult<String> value) {
                        mView.UpdateAccountSkillData(value);
                    }
                });
    }
}
