package com.zhkj.backstage.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.MyPagerAdapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.fragment.AccessoriesFragment;
import com.zhkj.backstage.fragment.ComplaintFragment;
import com.zhkj.backstage.fragment.DetailsFragment;
import com.zhkj.backstage.fragment.MessageFragment;
import com.zhkj.backstage.fragment.OrderdetailsFragment;
import com.zhkj.backstage.fragment.PayCordFragment;
import com.zhkj.backstage.fragment.ReturnFragment;
import com.zhkj.backstage.fragment.ReturnLogisticsFragment;
import com.zhkj.backstage.fragment.ShippingFragment;
import com.zhkj.backstage.fragment.SysteminfoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopDetailsActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.inforbar)
    TabLayout mInforbar;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.view)
    View mView;
    private String[] title = new String[]{"订单详情", "支付记录", "订单记录", "配件信息", "服务信息", "返件信息", "投诉信息", "留言显示","寄件物流","返件物流"};
    private List<Fragment> fragmentList = new ArrayList<>();
    private String orderId;

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
        return R.layout.activity_top_details;
    }

    @Override
    protected void initData() {
        orderId = getIntent().getStringExtra("OrderId");
        fragmentList.add(DetailsFragment.newInstance(orderId,""));
        fragmentList.add(PayCordFragment.newInstance(orderId,""));
        fragmentList.add(OrderdetailsFragment.newInstance(orderId,""));
        fragmentList.add(AccessoriesFragment.newInstance(orderId,""));
        fragmentList.add(SysteminfoFragment.newInstance(orderId,""));
        fragmentList.add(ReturnFragment.newInstance(orderId,""));
        fragmentList.add(ComplaintFragment.newInstance(orderId,""));
        fragmentList.add(MessageFragment.newInstance(orderId,""));
        fragmentList.add(ShippingFragment.newInstance(orderId,""));
        fragmentList.add(ReturnLogisticsFragment.newInstance(orderId,""));
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), title, fragmentList);
        mViewpager.setAdapter(adapter);
        mInforbar.setTabMode(TabLayout.MODE_SCROLLABLE);
        mInforbar.setupWithViewPager(mViewpager);
        mViewpager.setCurrentItem(0);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("工单详情");

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
