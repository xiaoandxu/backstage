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
import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.VendorListAdapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.contract.VendorListContract;
import com.zhkj.backstage.model.VendorListModel;
import com.zhkj.backstage.presenter.VendorListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VendorListActivity extends BaseActivity<VendorListPresenter, VendorListModel> implements View.OnClickListener, VendorListContract.View {
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
    private String type;
    private int page=1;
    private List<UserInfoList.DataBean> list=new ArrayList<>();
    private VendorListAdapter adapter;

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
        //没满屏时禁止上拉
        mRefreshLayout.setEnableLoadMoreWhenContentNotFull(false);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                mPresenter.GetUserInfoList(type, "0",String.valueOf(page),"10");
                refreshLayout.finishRefresh(1000);
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresenter.GetUserInfoList(type, "0",String.valueOf(page),"10");
                refreshLayout.finishLoadMore(1000);
            }
        });
    }

    @Override
    protected void initView() {
        type = getIntent().getStringExtra("type");
        if ("6".equals(type)) {
            mTvTitle.setText("厂商入驻待审核");
        } else if ("7".equals(type)) {
            mTvTitle.setText("师傅入驻待审核");
        }
        showProgress();
        mPresenter.GetUserInfoList(type, "0",String.valueOf(page),"10");
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
        list.clear();
        list.addAll(baseResult.getData().getData());
        adapter = new VendorListAdapter(R.layout.item_vendor,baseResult.getData().getData());
        mRvVerdor.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvVerdor.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent=new Intent(mActivity,PersonalInformationActivity.class);
                intent.putExtra("userId",list.get(position).getUserID());
                startActivity(intent);
            }
        });
        hideProgress();
    }
}
