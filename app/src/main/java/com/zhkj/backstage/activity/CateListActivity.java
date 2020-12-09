package com.zhkj.backstage.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.CateListAdapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BankCard;
import com.zhkj.backstage.bean.CompanyInfo;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetIDCardImg;
import com.zhkj.backstage.bean.GetSecondCategoryListResult;
import com.zhkj.backstage.bean.UpdateFactroyUserResult;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.mvp.contract.PersonalInformationCotract;
import com.zhkj.backstage.mvp.model.PersonalInformationModel;
import com.zhkj.backstage.mvp.presenter.PersonalInformationPresenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CateListActivity extends BaseActivity<PersonalInformationPresenter, PersonalInformationModel> implements View.OnClickListener, PersonalInformationCotract.View {


    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_all_check)
    TextView mTvAllCheck;
    @BindView(R.id.rv_list)
    RecyclerView mRvList;
    @BindView(R.id.btn_ok)
    Button mBtnOk;
    List<GetSecondCategoryListResult.DataBeanX.DataBean> list=new ArrayList<>();
    private CateListAdapter adapter;
    private boolean allCheck=true;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_catelist;
    }

    @Override
    protected void initData() {

        adapter = new CateListAdapter(R.layout.item_cate_check, list);
        mRvList.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvList.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                boolean check=list.get(position).isCheck();
                list.get(position).setCheck(!check);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initView() {
        mPresenter.GetSecondCategoryList();
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mTvAllCheck.setOnClickListener(this);
        mBtnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                Intent intent=new Intent();
                intent.putExtra("list", (Serializable) list);
                setResult(100,intent);
                finish();
                break;
            case R.id.tv_all_check:
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setCheck(allCheck);
                    adapter.notifyDataSetChanged();
                }
                allCheck = !allCheck;
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    public void GetUserInfo(BaseResult<UserInfoList> baseResult) {

    }

    @Override
    public void GetmessageBytype(BaseResult<Data<CompanyInfo>> baseResult) {

    }

    @Override
    public void GetIDCardImg(BaseResult<List<GetIDCardImg>> baseResult) {

    }

    @Override
    public void GetAccountPayInfoList(BaseResult<List<BankCard>> baseResult) {

    }

    @Override
    public void ApproveAuth(BaseResult<Data<String>> baseResult) {

    }

    @Override
    public void UpdateFactroyUser(UpdateFactroyUserResult baseResult) {

    }

    @Override
    public void GetSecondCategoryList(GetSecondCategoryListResult baseResult) {
        if (baseResult.getStatusCode()==200){
            list=baseResult.getData().getData();
            adapter.setNewData(list);
        }
    }

}
