package com.zhkj.backstage.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.fragment.HomeNewFragment;
import com.zhkj.backstage.weight.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

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
        mFragments.add(HomeNewFragment.newInstance("", ""));
//        mFragments.add(HomeFragment.newInstance("", ""));
//        mFragments.add(HomeFragment.newInstance("", ""));
//        mFragments.add(HomeFragment.newInstance("", ""));
//        mFragments.add(HomeFragment.newInstance("", ""));
    }


    @Override
    protected void initView() {

//        Intent grayIntent = new Intent(getApplicationContext(), GrayService.class);
////        startService(grayIntent);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            //android8.0以上通过startForegroundService启动service
//            startForegroundService(grayIntent);
//        } else {
//            startService(grayIntent);
//        }

        // 适配android M，检查权限
//        List<String> permissions = new ArrayList<>();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && isNeedRequestPermissions(permissions)) {
//            requestPermissions(permissions.toArray(new String[permissions.size()]), 0);
//        }

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

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//
//        /*  两秒之内再按一下退出*/
//        //判断用户是否点击了返回键
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            //与上次点击返回键作差
//            if ((System.currentTimeMillis() - mExittime) > 2000) {
//                //大于2秒认为是误操作
//                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
//                //并记录记录下本次点击返回键的时刻
//                mExittime = System.currentTimeMillis();
//            } else {
//                //小于2秒 则用户希望退出
//                System.exit(0);
//            }
//            return true;
//
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }

    private boolean isNeedRequestPermissions(List<String> permissions) {
        // 定位精确位置
        addPermission(permissions, Manifest.permission.ACCESS_FINE_LOCATION);
        // 存储权限
        addPermission(permissions, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            // 前台服务权限
            addPermission(permissions, Manifest.permission.FOREGROUND_SERVICE);
        }

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            // 后台定位权限
            addPermission(permissions, Manifest.permission.ACCESS_COARSE_LOCATION);
//        }

        return permissions.size() > 0;
    }

    private void addPermission(List<String> permissionsList, String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
        }
    }

}
