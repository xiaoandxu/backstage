package com.zhkj.backstage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.LaterorderAdapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.bean.Latestorder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LatestorderActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.new_order)
    RecyclerView mNewOrder;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private List<Latestorder> list = new ArrayList<>();
    private LaterorderAdapter adapter;

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
        return R.layout.activity_latestorder;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 10; i++) {
            list.add(new Latestorder());
        }

        adapter = new LaterorderAdapter(R.layout.item_new_order, list);
        mNewOrder.setLayoutManager(new LinearLayoutManager(mActivity));
        mNewOrder.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mActivity, TopDetailsActivity.class));
            }
        });
    }

    @Override
    protected void initView() {
        mTvTitle.setText("最新工单");
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
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
