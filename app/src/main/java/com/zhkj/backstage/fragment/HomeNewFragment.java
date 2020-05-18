package com.zhkj.backstage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.activity.NewWorkOrderListActivity;
import com.zhkj.backstage.activity.SearchActivity;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.SalesToday2;
import com.zhkj.backstage.mvp.contract.HomeNewContract;
import com.zhkj.backstage.mvp.model.HomeNewModel;
import com.zhkj.backstage.mvp.presenter.HomeNewPresenter;

import butterknife.BindView;

public class HomeNewFragment extends BaseLazyFragment<HomeNewPresenter, HomeNewModel> implements View.OnClickListener, HomeNewContract.View {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.tv_first)
    TextView mTvFirst;
    @BindView(R.id.sosou)
    TextView mSosou;
    @BindView(R.id.tv_master)
    TextView mTvMaster;
    @BindView(R.id.tv_master_today)
    TextView mTvMasterToday;
    @BindView(R.id.tv_master_yesterday)
    TextView mTvMasterYesterday;
    @BindView(R.id.ll_master)
    LinearLayout mLlMaster;
    @BindView(R.id.tv_factory)
    TextView mTvFactory;
    @BindView(R.id.tv_factory_today)
    TextView mTvFactoryToday;
    @BindView(R.id.tv_factory_yesterday)
    TextView mTvFactoryYesterday;
    @BindView(R.id.ll_factory)
    LinearLayout mLlFactory;
    @BindView(R.id.tv_complaint)
    TextView mTvComplaint;
    @BindView(R.id.tv_complaint_today)
    TextView mTvComplaintToday;
    @BindView(R.id.tv_complaint_yesterday)
    TextView mTvComplaintYesterday;
    @BindView(R.id.ll_complaint)
    LinearLayout mLlComplaint;
    @BindView(R.id.tv_withdraw)
    TextView mTvWithdraw;
    @BindView(R.id.tv_withdraw_today)
    TextView mTvWithdrawToday;
    @BindView(R.id.tv_withdraw_yesterday)
    TextView mTvWithdrawYesterday;
    @BindView(R.id.ll_withdraw)
    LinearLayout mLlWithdraw;
    @BindView(R.id.tv_all_work_orders)
    TextView mTvAllWorkOrders;
    @BindView(R.id.ll_all_work_orders)
    LinearLayout mLlAllWorkOrders;
    @BindView(R.id.tv_new_order)
    TextView mTvNewOrder;
    @BindView(R.id.ll_new_order)
    LinearLayout mLlNewOrder;
    @BindView(R.id.tv_no_appointment)
    TextView mTvNoAppointment;
    @BindView(R.id.ll_no_appointment)
    LinearLayout mLlNoAppointment;
    @BindView(R.id.tv_serving_work_orders)
    TextView mTvServingWorkOrders;
    @BindView(R.id.ll_serving_work_orders)
    LinearLayout mLlServingWorkOrders;
    @BindView(R.id.tv_unconfirmed)
    TextView mTvUnconfirmed;
    @BindView(R.id.ll_unconfirmed)
    LinearLayout mLlUnconfirmed;
    @BindView(R.id.tv_finished)
    TextView mTvFinished;
    @BindView(R.id.ll_finished)
    LinearLayout mLlFinished;
    private String mParam1;
    private String mParam2;

    public static HomeNewFragment newInstance(String param1, String param2) {
        HomeNewFragment fragment = new HomeNewFragment();
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
        return R.layout.fragment_home_new;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mPresenter.SalesToday2();
        mPresenter.GetOderCountByCustomService();
    }

    @Override
    protected void setListener() {
        mSosou.setOnClickListener(this);
        mLlAllWorkOrders.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sosou:
                startActivity(new Intent(mActivity, SearchActivity.class));
                break;
            case R.id.ll_all_work_orders:
                startActivity(new Intent(mActivity, NewWorkOrderListActivity.class));
                break;
        }
    }

    @Override
    public void GetOderCountByCustomService(BaseResult<GetOderCountByCustomService> baseResult) {
        mTvAllWorkOrders.setText(baseResult.getData().getData().get(5)+"");
        mTvNewOrder.setText(baseResult.getData().getData().get(0)+"");
        mTvNoAppointment.setText(baseResult.getData().getData().get(1)+"");
        mTvServingWorkOrders.setText(baseResult.getData().getData().get(2)+"");
        mTvUnconfirmed.setText(baseResult.getData().getData().get(3)+"");
        mTvFinished.setText(baseResult.getData().getData().get(4)+"");
    }

    @Override
    public void SalesToday2(BaseResult<Data<SalesToday2>> baseResult) {
        mTvMaster.setText(baseResult.getData().getItem2().getMasterWorkerCount()+"");
        mTvMasterToday.setText(baseResult.getData().getItem2().getTodayMasterWorkerCount()+"");
        mTvMasterYesterday.setText(baseResult.getData().getItem2().getYesterdayMasterWorkerCount()+"");
        mTvFactory.setText(baseResult.getData().getItem2().getFactoryExamineCount()+"");
        mTvFactoryToday.setText(baseResult.getData().getItem2().getTodayFactoryCount()+"");
        mTvFactoryYesterday.setText(baseResult.getData().getItem2().getYesterdayFactoryCount()+"");
        mTvComplaint.setText(baseResult.getData().getItem2().getComplaintCount()+"");
        mTvWithdraw.setText(baseResult.getData().getItem2().getWithdrawalCount()+"");
    }
}
