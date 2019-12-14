package com.zhkj.backstage.contract;


import com.zhkj.backstage.base.BaseModel;
import com.zhkj.backstage.base.BasePresenter;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.base.BaseView;
import com.zhkj.backstage.bean.CategoryData;
import com.zhkj.backstage.bean.Skill;

import java.util.List;

import io.reactivex.Observable;


public interface AddSkillsContract {
    interface Model extends BaseModel {
        Observable<BaseResult<CategoryData>> GetFactoryCategory(String ParentID);
         Observable<BaseResult<CategoryData>> GetChildFactoryCategory(String ParentID);
        //获取该账号下的技能
        Observable<BaseResult<List<Skill>>> GetAccountSkill(String UserID);
        Observable<BaseResult<String>> UpdateAccountSkillData(String UserID, String NodeIds);

    }

    interface View extends BaseView {
        void GetFactoryCategory(BaseResult<CategoryData> baseResult);
        void GetChildFactoryCategory(BaseResult<CategoryData> baseResult);
        //获取该账号下的技能
        void GetAccountSkill(BaseResult<List<Skill>> baseResult);
        void UpdateAccountSkillData(BaseResult<String> baseResult);
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void GetFactoryCategory(String ParentID);
        public abstract void GetChildFactoryCategory(String ParentID);
        //获取该账号下的技能
        public abstract void GetAccountSkill(String UserID);
        public abstract void UpdateAccountSkillData(String UserID,String NodeIds);
    }
}
