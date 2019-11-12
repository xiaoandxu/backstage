package com.zhkj.backstage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.blankj.utilcode.util.ActivityUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.fragment.HomeFragment;
import com.zhkj.backstage.weight.CustomViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener , ViewPager.OnPageChangeListener{

    @BindView(R.id.viewPager)
    CustomViewPager mViewPager;
    @BindView(R.id.img_home)
    ImageView mImgHome;
    @BindView(R.id.tv_home)
    TextView mTvHome;
    @BindView(R.id.ll_home)
    LinearLayout mLlHome;
    @BindView(R.id.img_cate)
    ImageView mImgCate;
    @BindView(R.id.tv_cate)
    TextView mTvCate;
    @BindView(R.id.ll_category)
    LinearLayout mLlCategory;
    @BindView(R.id.img_message_invisible)
    ImageView mImgMessageInvisible;
    @BindView(R.id.img_message)
    ImageView mImgMessage;
    @BindView(R.id.tv_message)
    TextView mTvMessage;
    @BindView(R.id.ll_message)
    LinearLayout mLlMessage;
    @BindView(R.id.img_cart)
    ImageView mImgCart;
    @BindView(R.id.tv_cart)
    TextView mTvCart;
    @BindView(R.id.ll_car)
    LinearLayout mLlCar;
    @BindView(R.id.img_my)
    ImageView mImgMy;
    @BindView(R.id.tv_my)
    TextView mTvMy;
    @BindView(R.id.ll_mine)
    LinearLayout mLlMine;
    @BindView(R.id.tab_menu)
    LinearLayout mTabMenu;
    private ArrayList<Fragment> mFragments;
    private long mExittime;
    @Override
    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
        mImmersionBar.statusBarColor(R.color.transparent);
        mImmersionBar.fitsSystemWindows(false);
        mImmersionBar.init();
    }


    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(HomeFragment.newInstance("", ""));
        mFragments.add(HomeFragment.newInstance("", ""));
        mFragments.add(HomeFragment.newInstance("", ""));
        mFragments.add(HomeFragment.newInstance("", ""));
        mFragments.add(HomeFragment.newInstance("", ""));
    }

    @Override
    protected void initView() {
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(mFragments.size());
        mViewPager.setScroll(false);
        mLlHome.setSelected(true);
    }

    @Override
    protected void setListener() {
        mLlHome.setOnClickListener(this);
        mLlMessage.setOnClickListener(this);
        mLlCategory.setOnClickListener(this);
        mLlCar.setOnClickListener(this);
        mLlMine.setOnClickListener(this);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.ll_home:
                mViewPager.setCurrentItem(0);
                tabSelected(mLlHome);
                break;
            case R.id.ll_message:
                mViewPager.setCurrentItem(2);
                tabSelected(mLlMessage);
                break;
            case R.id.ll_category:
                mViewPager.setCurrentItem(2);
                tabSelected(mLlCategory);
                break;

            case R.id.ll_car:
                mViewPager.setCurrentItem(3);
                tabSelected(mLlCar);
                break;
            case R.id.ll_mine:
                mViewPager.setCurrentItem(4);
                tabSelected(mLlMine);
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
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                tabSelected(mLlHome);
                break;
            case 2:
                tabSelected(mLlMessage);
                break;
            case 1:
                tabSelected(mLlCategory);
                break;
            case 3:
                tabSelected(mLlCar);
                break;
            case 4:
                tabSelected(mLlMine);
                break;
        }
    }

    private void tabSelected(LinearLayout linearLayout) {
        mLlHome.setSelected(false);
        mLlMessage.setSelected(false);
        mLlCategory.setSelected(false);
        mLlCar.setSelected(false);
        mLlMine.setSelected(false);
        linearLayout.setSelected(true);
    }


    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class MyAdapter extends FragmentPagerAdapter {
        MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        /*  两秒之内再按一下退出*/
        //判断用户是否点击了返回键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //与上次点击返回键作差
            if ((System.currentTimeMillis() - mExittime) > 2000) {
                //大于2秒认为是误操作
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                //并记录记录下本次点击返回键的时刻
                mExittime = System.currentTimeMillis();
            } else {
                //小于2秒 则用户希望退出
                System.exit(0);
            }
            return true;

        }

        return super.onKeyDown(keyCode, event);
    }
}
