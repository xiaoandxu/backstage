package com.zhkj.backstage.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.MyPagerAdapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.fragment.person.CertificationtionFragment;
import com.zhkj.backstage.fragment.person.PaymentFragment;
import com.zhkj.backstage.fragment.person.PersonalInformationFragment;
import com.zhkj.backstage.fragment.person.ServiceAreaFragment;
import com.zhkj.backstage.fragment.person.SkillFragment;
import com.zhkj.backstage.fragment.person.TransactionRecordFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonalInformationActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.inforbar)
    TabLayout mInforbar;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private String[] title = new String[]{"个人信息", "认证信息", "支付管理", "技能", "服务区域", "交易记录"};
    private List<Fragment> fragmentList = new ArrayList<>();
    private String userId;

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
        return R.layout.activity_personal_information;
    }

    @Override
    protected void initData() {
        userId = getIntent().getStringExtra("userId");
        fragmentList.add(PersonalInformationFragment.newInstance(userId,""));
        fragmentList.add(CertificationtionFragment.newInstance(userId,""));
        fragmentList.add(PaymentFragment.newInstance(userId,""));
        fragmentList.add(SkillFragment.newInstance(userId,""));
        fragmentList.add(ServiceAreaFragment.newInstance(userId,""));
        fragmentList.add(TransactionRecordFragment.newInstance(userId,""));
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), title, fragmentList);
        mViewpager.setAdapter(adapter);
        mInforbar.setTabMode(TabLayout.MODE_SCROLLABLE);
        mInforbar.setupWithViewPager(mViewpager);
        mViewpager.setCurrentItem(0);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("个人详情");


    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
