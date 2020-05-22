package com.zhkj.backstage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SPUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhkj.backstage.R;
import com.zhkj.backstage.activity.CustomerServiceActivity;
import com.zhkj.backstage.activity.NewWorkOrderListActivity;
import com.zhkj.backstage.activity.SearchActivity;
import com.zhkj.backstage.activity.VendorListActivity;
import com.zhkj.backstage.activity.WithdrawActivity;
import com.zhkj.backstage.activity.WorkOrderListActivity;
import com.zhkj.backstage.adapter.SecondaryListAdapter;
import com.zhkj.backstage.adapter.TreeAdapter;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BackstageGetOrderNum;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetModuleByRoleId;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.LeftTitle;
import com.zhkj.backstage.bean.ParentEntity;
import com.zhkj.backstage.bean.SalesToday2;
import com.zhkj.backstage.bean.SalesToday3;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.mvp.contract.HomeNewContract;
import com.zhkj.backstage.mvp.model.HomeNewModel;
import com.zhkj.backstage.mvp.presenter.HomeNewPresenter;
import com.zhkj.backstage.weight.CustomFilterDrawerPopupView;
import com.zhkj.backstage.weight.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

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
    @BindView(R.id.ll_customer_service)
    LinearLayout mLlCustomerService;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.ll_yesterday_order)
    LinearLayout mLlYesterdayOrder;
    @BindView(R.id.ll_today_master)
    LinearLayout mLlTodayMaster;
    @BindView(R.id.ll_yes_master)
    LinearLayout mLlYesMaster;
    @BindView(R.id.ll_yes_factory)
    LinearLayout mLlYesFactory;
    @BindView(R.id.ll_today_factory)
    LinearLayout mLlTodayFactory;
    private String mParam1;
    private String mParam2;
    private Intent intent;
    private String userID;
    private BasePopupView xPopup;
    private CustomFilterDrawerPopupView customFilterDrawerPopupView;
    private List<SecondaryListAdapter.DataTree<LeftTitle, String>> datas = new ArrayList<>();
    private List<LeftTitle> leftTitleList = new ArrayList<>();
    private String[] title = {"权限管理", "工单管理", "工厂配置", "财务管理", "系统设置", "文章管理", "西瓜币管理", "小程序管理", "商城商品管理"};
    //    private String[] title2={"权限管理","工单管理","工厂配置","财务管理","系统设置","文章管理","西瓜币管理","小程序管理","商城商品管理"};
    private TreeAdapter adapter;
    private ArrayList list;
    private String roleId;

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
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
//                showProgress();
//                mPresenter.SalesToday();
                mPresenter.SalesToday2();
                mPresenter.GetUserInfo(userID, "1");
//                mPresenter.SalesToday3();
                mRefreshLayout.finishRefresh(1000);
            }
        });
        mRefreshLayout.setEnableLoadMore(false);
    }

    @Override
    protected void initView() {
        SPUtils spUtils = SPUtils.getInstance("token");
        userID = spUtils.getString("userName");
        mPresenter.SalesToday2();
        mPresenter.GetUserInfo(userID, "1");
//        mPresenter.GetOderCountByCustomService();

        customFilterDrawerPopupView = new CustomFilterDrawerPopupView(mActivity);
        RecyclerView recyclerView = (RecyclerView) customFilterDrawerPopupView.findViewById(R.id.recyclerView);
//        RecyclerView rv = (RecyclerView)customFilterDrawerPopupView.findViewById(R.id.recyclerView);
//        rv.setLayoutManager(new LinearLayoutManager(mActivity));
//        rv.setHasFixedSize(true);
//        rv.addItemDecoration(new RvDividerItemDecoration(mActivity, LinearLayoutManager.VERTICAL));
//
//
//        RecyclerAdapter adapter = new RecyclerAdapter(mActivity);
//
//        adapter.setData(datas);
//        rv.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        recyclerView.addItemDecoration(new DividerItemDecoration(mActivity,
                DividerItemDecoration.VERTICAL_LIST));//间距设置，完全copy了别人的代码。。
        recyclerView.setItemAnimator(new SlideInUpAnimator());//这是一个开源的动画效果，非常棒的哦
        list = new ArrayList();
        adapter = new TreeAdapter(mActivity, list, R.layout.layout_treerecycler_item,
                new int[]{R.id.parent_name, R.id.child_name, R.id.iv_logo, R.id.iv_right});
        //这里的点击事件很重要
        adapter.setOnItemClickLitener(new TreeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (list.get(position) instanceof ParentEntity) {//判断是否为父
                    ParentEntity parent = (ParentEntity) list.get(position);
                    if ((position + 1) == list.size()) {//判断是否为最后一个元素
                        adapter.addAllChild(parent.getChildren(), position + 1);
                    } else {
                        if (list.get(position + 1) instanceof ParentEntity) {//如果是父则表示为折叠状态需要添加儿子
                            ((ParentEntity) list.get(position)).setSelect(true);
                            adapter.addAllChild(parent.getChildren(), position + 1);
                            adapter.notifyDataSetChanged();
                        } else if (list.get(position + 1) instanceof ParentEntity.ChildEntity) {//如果是儿子则表示为展开状态需要删除儿子
                            ((ParentEntity) list.get(position)).setSelect(false);
                            adapter.deleteAllChild(position + 1, parent.getChildren().size());
                            adapter.notifyDataSetChanged();
                        }
                    }
                } else {//是儿子你想干啥就干啥吧
                    ParentEntity.ChildEntity child = (ParentEntity.ChildEntity) list.get(position);
//                    Toast.makeText(getApplicationContext(), child.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        recyclerView.setAdapter(adapter);
        for (int i = 0; i < title.length; i++) {
            ParentEntity parent = new ParentEntity();
            parent.setId(i);
            parent.setName(title[i]);
            parent.setSelect(false);
            List<ParentEntity.ChildEntity> children = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                ParentEntity.ChildEntity child = new ParentEntity.ChildEntity();
                child.setId(j);
                child.setName("我是父" + i + "的儿子" + j);
                children.add(child);
            }
            parent.setChildren(children);
            list.add(parent);
        }
        xPopup = new XPopup.Builder(mActivity)
                .popupPosition(PopupPosition.Left)//右边
                .hasStatusBarShadow(true) //启用状态栏阴影
                .asCustom(customFilterDrawerPopupView);
    }

    {

        List<String> group = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            leftTitleList.add(new LeftTitle(title[i]));
        }
        for (int i = 0; i < leftTitleList.size(); i++) {

            datas.add(new SecondaryListAdapter.DataTree<LeftTitle, String>(leftTitleList.get(i), new
                    ArrayList<String>() {{
                        add("sub 0");
                        add("sub 1");
                        add("sub 2");
                    }}));

        }
    }

    @Override
    protected void setListener() {
        mSosou.setOnClickListener(this);
        mLlAllWorkOrders.setOnClickListener(this);
        mLlNewOrder.setOnClickListener(this);
        mLlNoAppointment.setOnClickListener(this);
        mLlServingWorkOrders.setOnClickListener(this);
        mLlUnconfirmed.setOnClickListener(this);
        mLlFinished.setOnClickListener(this);
        mTvFirst.setOnClickListener(this);
        mLlCustomerService.setOnClickListener(this);
        mLlMaster.setOnClickListener(this);
        mLlFactory.setOnClickListener(this);
        mLlComplaint.setOnClickListener(this);
        mLlWithdraw.setOnClickListener(this);
        mLlYesterdayOrder.setOnClickListener(this);
        mLlYesMaster.setOnClickListener(this);
        mLlTodayMaster.setOnClickListener(this);
        mLlYesFactory.setOnClickListener(this);
        mLlTodayFactory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sosou:
                intent = new Intent(mActivity, SearchActivity.class);
                intent.putExtra("roleId", roleId);
                startActivity(intent);
                break;
            case R.id.ll_all_work_orders:
                intent = new Intent(mActivity, NewWorkOrderListActivity.class);
                intent.putExtra("type", "所有工单");
                intent.putExtra("roleId", roleId);
                startActivity(intent);
                break;
            case R.id.ll_new_order:
                intent = new Intent(mActivity, NewWorkOrderListActivity.class);
                intent.putExtra("type", "未指派");
                intent.putExtra("roleId", roleId);
                startActivity(intent);
                break;
            case R.id.ll_no_appointment:
                intent = new Intent(mActivity, NewWorkOrderListActivity.class);
                intent.putExtra("type", "未预约");
                intent.putExtra("roleId", roleId);
                startActivity(intent);
                break;
            case R.id.ll_serving_work_orders:
                intent = new Intent(mActivity, NewWorkOrderListActivity.class);
                intent.putExtra("type", "服务中");
                intent.putExtra("roleId", roleId);
                startActivity(intent);
                break;
            case R.id.ll_unconfirmed:
                intent = new Intent(mActivity, NewWorkOrderListActivity.class);
                intent.putExtra("type", "未支付");
                intent.putExtra("roleId", roleId);
                startActivity(intent);
                break;
            case R.id.ll_finished:
                intent = new Intent(mActivity, NewWorkOrderListActivity.class);
                intent.putExtra("type", "已完成");
                intent.putExtra("roleId", roleId);
                startActivity(intent);
                break;
            case R.id.tv_first:
                xPopup.show();
                break;
            case R.id.ll_customer_service:
                startActivity(new Intent(mActivity, CustomerServiceActivity.class));
                break;
            case R.id.ll_master:
                intent = new Intent(mActivity, VendorListActivity.class);
                intent.putExtra("type", "7");
                intent.putExtra("day", "no");
                startActivity(intent);
                break;
            case R.id.ll_factory:
                intent = new Intent(mActivity, VendorListActivity.class);
                intent.putExtra("type", "6");
                intent.putExtra("day", "no");
                startActivity(intent);
                break;
            case R.id.ll_complaint:
                intent = new Intent(mActivity, WorkOrderListActivity.class);
                intent.putExtra("name", "最新工单");
                startActivity(intent);
                break;
            case R.id.ll_yesterday_order:
                intent = new Intent(mActivity, WorkOrderListActivity.class);
                intent.putExtra("name", "昨日工单");
                startActivity(intent);
                break;
            case R.id.ll_withdraw:
                intent = new Intent(mActivity, WithdrawActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_yes_master:
                intent = new Intent(mActivity, VendorListActivity.class);
                intent.putExtra("type", "7");
                intent.putExtra("day", "ym");
                startActivity(intent);
                break;
            case R.id.ll_today_master:
                intent = new Intent(mActivity, VendorListActivity.class);
                intent.putExtra("type", "7");
                intent.putExtra("day", "tm");
                startActivity(intent);
                break;
            case R.id.ll_yes_factory:
                intent = new Intent(mActivity, VendorListActivity.class);
                intent.putExtra("type", "6");
                intent.putExtra("day", "yp");
                startActivity(intent);
                break;
            case R.id.ll_today_factory:
                intent = new Intent(mActivity, VendorListActivity.class);
                intent.putExtra("type", "6");
                intent.putExtra("day", "tp");
                startActivity(intent);
                break;
        }
    }

    @Override
    public void GetOderCountByCustomService(BaseResult<GetOderCountByCustomService> baseResult) {
        mTvAllWorkOrders.setText(baseResult.getData().getData().get(5) + "");
        mTvNewOrder.setText(baseResult.getData().getData().get(0) + "");
        mTvNoAppointment.setText(baseResult.getData().getData().get(1) + "");
        mTvServingWorkOrders.setText(baseResult.getData().getData().get(2) + "");
        mTvUnconfirmed.setText(baseResult.getData().getData().get(3) + "");
        mTvFinished.setText(baseResult.getData().getData().get(4) + "");
    }

    @Override
    public void BackstageGetOrderNum(BaseResult<BackstageGetOrderNum> baseResult) {
        mTvAllWorkOrders.setText(baseResult.getData().getAllOrder() + "");
        mTvNewOrder.setText(baseResult.getData().getUnanswered() + "");
        mTvNoAppointment.setText(baseResult.getData().getNoappointment() + "");
        mTvServingWorkOrders.setText(baseResult.getData().getInservice() + "");
        mTvUnconfirmed.setText(baseResult.getData().getOutstanding() + "");
        mTvFinished.setText(baseResult.getData().getComplete() + "");
    }

    @Override
    public void SalesToday2(BaseResult<Data<SalesToday2>> baseResult) {
        mTvMaster.setText(baseResult.getData().getItem2().getMasterWorkerCount() + "");
        mTvMasterToday.setText(baseResult.getData().getItem2().getTodayMasterWorkerCount() + "");
        mTvMasterYesterday.setText(baseResult.getData().getItem2().getYesterdayMasterWorkerCount() + "");
        mTvFactory.setText(baseResult.getData().getItem2().getFactoryExamineCount() + "");
        mTvFactoryToday.setText(baseResult.getData().getItem2().getTodayFactoryCount() + "");
        mTvFactoryYesterday.setText(baseResult.getData().getItem2().getYesterdayFactoryCount() + "");

        mTvWithdraw.setText(baseResult.getData().getItem2().getWithdrawalCount() + "");
        mPresenter.SalesToday3();
    }

    @Override
    public void SalesToday3(BaseResult<Data<SalesToday3>> baseResult) {
        mTvComplaint.setText(baseResult.getData().getItem2().getNewOrder() + "");
        mTvComplaintToday.setText(baseResult.getData().getItem2().getNewOrder() + "");
        mTvComplaintYesterday.setText(baseResult.getData().getItem2().getYesterdayOrder() + "");
    }

    @Override
    public void GetUserInfo(BaseResult<UserInfoList> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                roleId = baseResult.getData().getData().get(0).getRoleID() + "";
                if (baseResult.getData().getData().get(0).getRoleID() == 22 || baseResult.getData().getData().get(0).getRoleID() == 1 || baseResult.getData().getData().get(0).getRoleID() == 2) {
                    mPresenter.BackstageGetOrderNum();
                } else {
                    mPresenter.GetOderCountByCustomService();
                }
//                mPresenter.GetModuleByRoleId(baseResult.getData().getData().get(0).getRoleID()+"");
                break;
        }
    }

    @Override
    public void GetModuleByRoleId(BaseResult<GetModuleByRoleId> baseResult) {

    }
}
