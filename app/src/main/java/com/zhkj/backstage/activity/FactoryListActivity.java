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
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.FacListAdapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.AddrList;
import com.zhkj.backstage.bean.GetUserInfoListForPlatformReq;
import com.zhkj.backstage.bean.GetUserInfoListForPlatformResult;
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

public class FactoryListActivity extends BaseActivity<VendorListPresenter, VendorListModel> implements View.OnClickListener, VendorListContract.View {
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
    private List<GetUserInfoListForPlatformResult.DataBeanX.DataBean> list = new ArrayList<>();
    private FacListAdapter adapter;
    private GetUserInfoListForPlatformReq getUserInfoListForPlatformReq;
    private int page=1;

    @Override
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
//        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
        mImmersionBar.statusBarView(mView);
        mImmersionBar.keyboardEnable(true);
        mImmersionBar.init();
    }

    @Override
    public void GetUserInfoListForPlatform(GetUserInfoListForPlatformResult baseResult) {
        if (baseResult.getStatusCode()==200){
            if (baseResult.getData().getCode()==0){
                if (page==1){
                    list.clear();
                }
                if(page!=1&&baseResult.getData().getData().size()==0){//第二页没有数据说明所有数据已全部加载
                    mRefreshLayout.finishLoadMoreWithNoMoreData();
                }
                list.addAll(baseResult.getData().getData());
                adapter.setNewData(list);
                hideProgress();
            }
        }else{
            hideProgress();
        }
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_vendor_list;
    }

    @Override
    protected void initData() {
        mTvTitle.setText("工厂管理");
        adapter = new FacListAdapter(R.layout.fac_item, list);
        mRvVerdor.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvVerdor.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mActivity, PersonalInformationActivity.class);
                intent.putExtra("userId", list.get(position).getUserID());
                startActivity(intent);
            }
        });

        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                getData();
                mRefreshLayout.resetNoMoreData();
                mRefreshLayout.finishRefresh(1000);
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getData();
                mRefreshLayout.finishLoadMore(1000);
            }
        });
    }

    @Override
    protected void initView() {
        showProgress();
        getData();
    }

    private void getData() {
        Gson gson=new Gson();
        getUserInfoListForPlatformReq = new GetUserInfoListForPlatformReq();
        getUserInfoListForPlatformReq.setType("6");
        getUserInfoListForPlatformReq.setPage(Integer.toString(page));
        getUserInfoListForPlatformReq.setLimit("20");
        String s = gson.toJson(getUserInfoListForPlatformReq);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), s);
        mPresenter.GetUserInfoListForPlatform(body);
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
    }

    @Override
    public void GetProvinceMasterDistance(BaseResult<AddrList> baseResult) {

    }

    @Override
    public void GetProvinceMasterList(BaseResult<worker> baseResult) {

    }
}
