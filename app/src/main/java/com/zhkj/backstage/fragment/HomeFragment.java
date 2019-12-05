package com.zhkj.backstage.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.ToastUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhkj.backstage.R;
import com.zhkj.backstage.activity.WorkOrderListActivity;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.SalesToday;
import com.zhkj.backstage.bean.SalesToday2;
import com.zhkj.backstage.bean.SalesToday3;
import com.zhkj.backstage.contract.HomeContract;
import com.zhkj.backstage.model.HomeModel;
import com.zhkj.backstage.presenter.HomePresenter;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import butterknife.BindView;

public class HomeFragment extends BaseLazyFragment<HomePresenter, HomeModel> implements View.OnClickListener, HomeContract.View {
    private static final String TAG = "HomeFragment";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.tv_vendor_settled)
    TextView mTvVendorSettled;
    @BindView(R.id.tv_master_settled)
    TextView mTvMasterSettled;
    @BindView(R.id.tv_pending_service)
    TextView mTvPendingService;
    @BindView(R.id.tv_pending_review)
    TextView mTvPendingReview;
    @BindView(R.id.tv_today_plant)
    TextView mTvTodayPlant;
    @BindView(R.id.tv_yesterday_plant)
    TextView mTvYesterdayPlant;
    @BindView(R.id.tv_today_master)
    TextView mTvTodayMaster;
    @BindView(R.id.tv_yesterday_master)
    TextView mTvYesterdayMaster;
    @BindView(R.id.tv_withdraw)
    TextView mTvWithdraw;
    @BindView(R.id.tv_arbitration)
    TextView mTvArbitration;
    @BindView(R.id.tv_latest_work_order)
    TextView mTvLatestWorkOrder;
    @BindView(R.id.tv_accessories)
    TextView mTvAccessories;
    @BindView(R.id.tv_warranty)
    TextView mTvWarranty;
    @BindView(R.id.tv_remote_fee)
    TextView mTvRemoteFee;
    @BindView(R.id.tv_leave_message)
    TextView mTvLeaveMessage;
    @BindView(R.id.tv_complaint)
    TextView mTvComplaint;
    @BindView(R.id.tv_carry_out)
    TextView mTvCarryOut;
    @BindView(R.id.tv_abolition)
    TextView mTvAbolition;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.sosou)
    EditText mSosou;
    @BindView(R.id.ll_lastest)
    LinearLayout mLlLastest;
    @BindView(R.id.ll_accessories)
    LinearLayout mLlAccessories;
    @BindView(R.id.ll_warranty)
    LinearLayout mLlWarranty;
    @BindView(R.id.ll_remote_fee)
    LinearLayout mLlRemoteFee;
    @BindView(R.id.ll_leave_message)
    LinearLayout mLlLeaveMessage;
    @BindView(R.id.ll_complaint)
    LinearLayout mLlComplaint;
    @BindView(R.id.ll_carry_out)
    LinearLayout mLlCarryOut;
    @BindView(R.id.ll_abolition)
    LinearLayout mLlAbolition;

    private String mParam1;
    private String mParam2;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        if (isVisibleToUser){
////            ToastUtils.showShort("ddffdfd");
////            showProgress();
////            mPresenter.SalesToday();
////            mPresenter.SalesToday2();
////            mPresenter.SalesToday3();
//            initView();
//        }
//        super.setUserVisibleHint(isVisibleToUser);
//
//    }

    @Override
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
        mImmersionBar.statusBarColor(R.color.white);
        mImmersionBar.fitsSystemWindows(true);
        mImmersionBar.keyboardEnable(true).navigationBarWithKitkatEnable(false).init();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        mRefreshLayout.setEnableLoadMore(false);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                showProgress();
                mPresenter.SalesToday();
                mPresenter.SalesToday2();
                mPresenter.SalesToday3();
                mRefreshLayout.finishRefresh(1000);
            }
        });
    }

    @Override
    protected void initView() {
        //loading
        showProgress();
        mPresenter.SalesToday();
        mPresenter.SalesToday2();
        mPresenter.SalesToday3();


    }

    @Override
    protected void setListener() {
        mLlLastest.setOnClickListener(this);
        mLlAccessories.setOnClickListener(this);
        mLlCarryOut.setOnClickListener(this);
        mLlAbolition.setOnClickListener(this);
        mLlComplaint.setOnClickListener(this);
        mLlLeaveMessage.setOnClickListener(this);
        mLlRemoteFee.setOnClickListener(this);
        mLlWarranty.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mActivity, WorkOrderListActivity.class);
        switch (v.getId()) {
            case R.id.ll_lastest:
                intent.putExtra("name", "最新工单");
                break;
            case R.id.ll_accessories:
                intent.putExtra("name", "配件工单");
                break;
            case R.id.ll_warranty:
                intent.putExtra("name", "质保工单");
                break;
            case R.id.ll_remote_fee:
                intent.putExtra("name", "远程费工单");
                break;
            case R.id.ll_leave_message:
                intent.putExtra("name", "留言工单");
                break;
            case R.id.ll_complaint:
                intent.putExtra("name", "投诉工单");
                break;
            case R.id.ll_carry_out:
                intent.putExtra("name", "完成工单");
                break;
            case R.id.ll_abolition:
                intent.putExtra("name", "废除工单");
                break;
        }

        startActivity(intent);
    }


    @Override
    public void SalesToday(BaseResult<Data<SalesToday>> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                break;
        }
    }

    @Override
    public void SalesToday2(BaseResult<Data<SalesToday2>> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                mTvVendorSettled.setText(baseResult.getData().getItem2().getFactoryExamineCount() + "");
                mTvMasterSettled.setText(baseResult.getData().getItem2().getMasterWorkerCount() + "");
                mTvPendingService.setText(baseResult.getData().getItem2().getInServiceOreder() + "");
                mTvPendingReview.setText(baseResult.getData().getItem2().getLongRange() + "");
                mTvTodayPlant.setText(baseResult.getData().getItem2().getTodayFactoryCount() + "");
                mTvYesterdayPlant.setText(baseResult.getData().getItem2().getYesterdayFactoryCount() + "");
                mTvTodayMaster.setText(baseResult.getData().getItem2().getTodayMasterWorkerCount() + "");
                mTvYesterdayMaster.setText(baseResult.getData().getItem2().getYesterdayMasterWorkerCount() + "");
                mTvWithdraw.setText(baseResult.getData().getItem2().getWithdrawalCount() + "");
                mTvArbitration.setText(baseResult.getData().getItem2().getComplaintCount() + "");

                break;
        }
    }

    @Override
    public void SalesToday3(BaseResult<Data<SalesToday3>> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                mTvLatestWorkOrder.setText(baseResult.getData().getItem2().getNewOrder() + "");
                mTvAccessories.setText(baseResult.getData().getItem2().getOrderAccessroyDetailCount() + "");
                mTvWarranty.setText(baseResult.getData().getItem2().getQualityAssurance() + "");
                mTvRemoteFee.setText(baseResult.getData().getItem2().getServiceCount() + "");
                mTvLeaveMessage.setText(baseResult.getData().getItem2().getLeavemessageServiceCount() + "");
                mTvComplaint.setText(baseResult.getData().getItem2().getComplaintCount2() + "");
                mTvCarryOut.setText(baseResult.getData().getItem2().getCompleteCount() + "");
                mTvAbolition.setText(baseResult.getData().getItem2().getAbolishCount() + "");
                hideProgress();
                break;
        }
    }

}
