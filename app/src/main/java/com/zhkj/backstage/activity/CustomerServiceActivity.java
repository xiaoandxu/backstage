package com.zhkj.backstage.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.CustomerServiceAdapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetUserInfoPartListBak;
import com.zhkj.backstage.bean.GetUserInfoPartListBakBean;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.mvp.contract.CustomerServiceContract;
import com.zhkj.backstage.mvp.model.CustomerServiceModel;
import com.zhkj.backstage.mvp.presenter.CustomerServicePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class CustomerServiceActivity extends BaseActivity<CustomerServicePresenter, CustomerServiceModel> implements View.OnClickListener , CustomerServiceContract.View {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_save)
    TextView mTvSave;
    @BindView(R.id.rv_customer_service)
    RecyclerView mRvCustomerService;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private String userID;
    private UserInfoList.DataBean infolist;
    private int page=1;
    private int pos;
    private List<GetUserInfoPartListBak.DataBean> list=new ArrayList<>();
    private CustomerServiceAdapter adapter;
    private Gson gson=new Gson();
    private GetUserInfoPartListBakBean getUserInfoPartListBakBean;

    /**
     * 初始化沉浸式
     */
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
        mImmersionBar.statusBarColor(R.color.white);
//        mImmersionBar.statusBarView(view);
        mImmersionBar.fitsSystemWindows(false);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_customer_service;
    }

    @Override
    protected void initData() {
        adapter = new CustomerServiceAdapter(R.layout.item_customer_service,list);
        mRvCustomerService.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvCustomerService.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.tv_open:
                        pos=position;
                        if (list.get(position).getIsOrderReceiving()==-1){
                            mPresenter.SetStartOrderReceiving(list.get(position).getAccountID()+"");
                        }else {
                            mPresenter.SetEndOrderReceiving(list.get(position).getAccountID()+"");
                        }
                        break;
                }
            }
        });
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear();
                    page=1;
//                mPresenter.GetUserInfoPartListBak("5",page+"","10");
                getUserInfoPartListBakBean = new GetUserInfoPartListBakBean();
                getUserInfoPartListBakBean.setType("5");
                getUserInfoPartListBakBean.setPage(page+"");
                getUserInfoPartListBakBean.setLimit("10");
                String s = gson.toJson(getUserInfoPartListBakBean);
                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), s);
                mPresenter.GetUserInfoPartListBak(body);
                mRefreshLayout.finishRefresh(1000);
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page=page+1;
//                mPresenter.GetUserInfoPartListBak("5",page+"","10");
                getUserInfoPartListBakBean = new GetUserInfoPartListBakBean();
                getUserInfoPartListBakBean.setType("5");
                getUserInfoPartListBakBean.setPage(page+"");
                getUserInfoPartListBakBean.setLimit("10");
                String s = gson.toJson(getUserInfoPartListBakBean);
                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), s);
                mPresenter.GetUserInfoPartListBak(body);
                refreshLayout.finishLoadMore(1000);
            }
        });
    }

    @Override
    protected void initView() {
        SPUtils spUtils = SPUtils.getInstance("token");
        userID = spUtils.getString("userName");
        mTvTitle.setText("客服管理");
        getUserInfoPartListBakBean = new GetUserInfoPartListBakBean();
        getUserInfoPartListBakBean.setType("5");
        getUserInfoPartListBakBean.setPage(page+"");
        getUserInfoPartListBakBean.setLimit("10");
        String s = gson.toJson(getUserInfoPartListBakBean);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), s);
        mPresenter.GetUserInfoPartListBak(body);
//        mPresenter.GetUserInfo(userID,"1");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    public void GetUserInfo(BaseResult<UserInfoList> baseResult) {
        switch (baseResult.getStatusCode()){
            case 200:
                infolist = baseResult.getData().getData().get(0);

                break;
        }
    }

    @Override
    public void GetUserInfoPartListBak(BaseResult<GetUserInfoPartListBak> baseResult) {
        switch (baseResult.getStatusCode()){
            case 200:
                list.addAll(baseResult.getData().getData());
                adapter.setNewData(list);
                break;
        }
    }

    @Override
    public void SetEndOrderReceiving(BaseResult<Data<String>> baseResult) {
        list.get(pos).setIsOrderReceiving(-1);
        adapter.notifyDataSetChanged();
        ToastUtils.showShort("停止成功");
    }

    @Override
    public void SetStartOrderReceiving(BaseResult<Data<String>> baseResult) {
        list.get(pos).setIsOrderReceiving(0);
        adapter.notifyDataSetChanged();
        ToastUtils.showShort("开启成功");
    }
}
