package com.zhkj.backstage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.AddrListAdapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.AddrList;
import com.zhkj.backstage.bean.GetUserInfoPartListBakBean;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.bean.worker;
import com.zhkj.backstage.mvp.contract.VendorListContract;
import com.zhkj.backstage.mvp.model.VendorListModel;
import com.zhkj.backstage.mvp.presenter.VendorListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class AddrListActivity extends BaseActivity<VendorListPresenter, VendorListModel> implements View.OnClickListener, VendorListContract.View {
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.rv_verdor)
    RecyclerView mRvVerdor;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private List<List<String>> list = new ArrayList<>();
    private AddrListAdapter adapter;
    private GetUserInfoPartListBakBean getUserInfoPartListBakBean;

    @Override
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
//        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
        mImmersionBar.statusBarView(mView);
        mImmersionBar.keyboardEnable(true);
        mImmersionBar.init();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_vendor_list;
    }

    @Override
    protected void initData() {
        adapter = new AddrListAdapter(R.layout.addrlist_item, list);
        mRvVerdor.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvVerdor.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mActivity, WorkerListActivity.class);
                intent.putExtra("provinceCode", list.get(position).get(0));
                intent.putExtra("provinceName", list.get(position).get(1));
                startActivity(intent);
            }
        });

        //没满屏时禁止上拉
        mRefreshLayout.setEnableLoadMoreWhenContentNotFull(false);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.GetProvinceMasterDistance();
                mRefreshLayout.finishRefresh(1000);
            }
        });

        mRefreshLayout.setEnableLoadMore(false);
    }

    @Override
    protected void initView() {
        mPresenter.GetProvinceMasterDistance();
        Gson gson=new Gson();
        getUserInfoPartListBakBean = new GetUserInfoPartListBakBean();
        getUserInfoPartListBakBean.setType("7");
        getUserInfoPartListBakBean.setPage(1+"");
        getUserInfoPartListBakBean.setLimit("1");
        String s = gson.toJson(getUserInfoPartListBakBean);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), s);
        mPresenter.GetUserInfoPartList(body);
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void GetUserInfoList(BaseResult<UserInfoList> baseResult) {

    }

    @Override
    public void GetUserInfoPartList(BaseResult<UserInfoList> baseResult) {
        mTvTitle.setText("所有师傅("+baseResult.getData().getCount()+")");
    }

    @Override
    public void GetProvinceMasterDistance(BaseResult<AddrList> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                list=baseResult.getData().getData();
                adapter.setNewData(list);
                break;
        }
    }

    @Override
    public void GetProvinceMasterList(BaseResult<worker> baseResult) {

    }
}
