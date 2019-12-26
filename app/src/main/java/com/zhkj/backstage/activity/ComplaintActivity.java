package com.zhkj.backstage.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.LaterorderAdapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.contract.ComplaintContract;
import com.zhkj.backstage.model.ComplaintModel;
import com.zhkj.backstage.presenter.ComplaintPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComplaintActivity extends BaseActivity<ComplaintPresenter, ComplaintModel> implements View.OnClickListener, ComplaintContract.View {

    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.rv_complaint)
    RecyclerView mRvComplaint;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private String name;
    private int page = 1;
    private List<WorkOrder.DataBean> list = new ArrayList<>();
    private LaterorderAdapter adapter;
    private ClipboardManager myClipboard;
    private ClipData myClip;
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
        return R.layout.activity_complaint;
    }

    @Override
    protected void initData() {

        myClipboard = (ClipboardManager) mActivity.getSystemService(Context.CLIPBOARD_SERVICE);
        adapter = new LaterorderAdapter(R.layout.item_new_order, list);
        mRvComplaint.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvComplaint.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent=new Intent(mActivity, TopDetailsActivity.class);
                intent.putExtra("OrderId",list.get(position).getOrderID());
                startActivity(intent);
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {

            private Intent intent;

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.iv_copy:
                        String id = list.get(position).getOrderID();
                        myClip = ClipData.newPlainText("", id);
                        myClipboard.setPrimaryClip(myClip);
                        ToastUtils.showShort("复制成功");
                        break;
                    case R.id.iv_specify:
                        intent = new Intent(mActivity,DesignatedDispatchActivity.class);
                        intent.putExtra("orderId",list.get(position).getOrderID());
                        intent.putExtra("typeId","1");
                        startActivity(intent);
                        break;
                    case R.id.iv_transfer:
                        intent=new Intent(mActivity,DesignatedDispatchActivity.class);
                        intent.putExtra("orderId",list.get(position).getOrderID());
                        intent.putExtra("typeId","2");
                        startActivity(intent);
                        break;
                }
            }
        });


        //没满屏时禁止上拉
        mRefreshLayout.setEnableLoadMoreWhenContentNotFull(false);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                getData();
//                mPresenter.GetUserInfoList(type, "0", "", "", String.valueOf(page), "10");
                refreshLayout.finishRefresh(1000);
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
//                mPresenter.GetUserInfoList(type, "0", "", "", String.valueOf(page), "10");
                getData();
                refreshLayout.finishLoadMore(1000);
            }
        });
    }

    @Override
    protected void initView() {
        name = getIntent().getStringExtra("name");
        mTvTitle.setText(name);
        getData();
    }

    private void getData() {
        switch (name) {
            case "工厂待处理仲裁":
                mPresenter.GetOrderInfoComplaintList("", "", "F", String.valueOf(page), "10");
                break;
            case "师傅待处理仲裁":
                mPresenter.GetOrderInfoComplaintList("", "W", "", String.valueOf(page), "10");
                break;
        }
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
    public void GetOrderInfoComplaintList(BaseResult<WorkOrder> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                if(page==1){
                    list.clear();
                }
                if (baseResult.getData()!=null){
                    list.addAll(baseResult.getData().getData());
                    adapter.setNewData(list);
                }

                mRefreshLayout.finishRefresh();
                if (page != 1 && "0".equals(baseResult.getData().getCount())) {
                    mRefreshLayout.finishLoadMoreWithNoMoreData();
                } else {
                    mRefreshLayout.finishLoadMore();
                }
                hideProgress();
                break;
        }
    }
}
