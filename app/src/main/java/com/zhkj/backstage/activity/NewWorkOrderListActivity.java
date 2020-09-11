package com.zhkj.backstage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.zhkj.backstage.R;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BackstageGetOrderNum;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetCustomService;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.WorkOrderListBean;
import com.zhkj.backstage.fragment.NewWorkOrderListFragment;
import com.zhkj.backstage.mvp.contract.NewWorkOrderListContract;
import com.zhkj.backstage.mvp.model.NewWorkOrderListModel;
import com.zhkj.backstage.mvp.presenter.NewWorkOrderListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewWorkOrderListActivity extends BaseActivity<NewWorkOrderListPresenter, NewWorkOrderListModel> implements View.OnClickListener, NewWorkOrderListContract.View {
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_save)
    TextView mTvSave;
    @BindView(R.id.tab_receiving_layout)
    SlidingTabLayout mTabReceivingLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.iv_search)
    ImageView mIvSearch;
    private String[] mTitles;
    private List<Fragment> mWorkOrderFragmentList = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private String type;
    private String roleId;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_new_work_order_list;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText("工单列表");
        type = getIntent().getStringExtra("type");
        roleId = getIntent().getStringExtra("roleId");
        mTitles = new String[]{
                "所有工单(0)", "未指派(0)", "未预约(0)", "服务中(0)"
                , "未支付(0)", "已完成(0)", "取消工单(0)","未接工单(0)","被催工单(0)","待审核(0)"
        };
        for (int i = 0; i < mTitles.length; i++) {
            mWorkOrderFragmentList.add(NewWorkOrderListFragment.newInstance(mTitles[i], roleId));

        }

        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(mWorkOrderFragmentList.size());
        mTabReceivingLayout.setViewPager(mViewPager);
        switch (type) {
            case "未指派":
                mViewPager.setCurrentItem(1);
                break;
            case "未预约":
                mViewPager.setCurrentItem(2);
                break;
            case "服务中":
                mViewPager.setCurrentItem(3);
                break;
            case "未支付":
                mViewPager.setCurrentItem(4);
                break;
            case "已完成":
                mViewPager.setCurrentItem(5);
                break;
            case "所有工单":
                mViewPager.setCurrentItem(0);
                break;
            case "取消工单":
                mViewPager.setCurrentItem(6);
                break;
            case "未接工单":
                mViewPager.setCurrentItem(7);
                break;
            case "被催工单":
                mViewPager.setCurrentItem(8);
                break;
            case "待审核":
                mViewPager.setCurrentItem(9);
                break;
        }

        if ("22".equals(roleId) || "1".equals(roleId) || "2".equals(roleId)) {
            mPresenter.BackstageGetOrderNum();
        } else {
            mPresenter.GetOderCountByCustomService();
        }

    }

    @Override
    protected void setListener() {
        mIvSearch.setVisibility(View.VISIBLE);
        mIvBack.setOnClickListener(this);
        mIvSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_search:
                startActivity(new Intent(mActivity,SearchActivity.class));
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
    public void GetOderCountByCustomService(BaseResult<GetOderCountByCustomService> baseResult) {
        List<Integer> data = baseResult.getData().getData();
        mTitles = new String[]{
                "所有工单(" + data.get(7) + ")", "未指派(" + data.get(0) + ")", "未预约(" + data.get(2) + ")", "服务中(" + data.get(3) + ")"
                , "未支付(" + data.get(4) + ")", "已完成(" + data.get(5) + ")", "取消工单(" + data.get(6) + ")", "未接工单(" + data.get(1) + ")", "被催工单(" + data.get(1) + ")"
        };
        mTabReceivingLayout.notifyDataSetChanged();
    }

    @Override
    public void BackstageGetOrderNum(BaseResult<BackstageGetOrderNum> baseResult) {
        BackstageGetOrderNum data = baseResult.getData();
        mTitles = new String[]{
                "所有工单(" + data.getAllOrder() + ")", "未指派(" + data.getUnanswered() + ")", "未预约(" + data.getNoappointment() + ")", "服务中(" + data.getInservice() + ")"
                , "未支付(" + data.getOutstanding() + ")", "已完成(" + data.getComplete() + ")", "取消工单(" + data.getCancel() + ")", "未接工单(" + data.getNotAccepted() + ")"
                , "被催工单(" + data.getReminders() + ")", "待审核(" + data.getExamine() + ")"
        };
        mTabReceivingLayout.notifyDataSetChanged();
    }

    @Override
    public void GetOderCountByCustomService2(WorkOrderListBean baseResult) {

    }

    @Override
    public void GetoderInfoPartListBak(WorkOrderListBean baseResult) {

    }

    @Override
    public void GetCustomService(BaseResult<List<GetCustomService>> baseResult) {

    }

    @Override
    public void SetChangeGiveWay(BaseResult<Data<String>> baseResult) {

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mWorkOrderFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mWorkOrderFragmentList.get(position);
        }
    }
}
