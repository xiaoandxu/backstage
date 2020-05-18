package com.zhkj.backstage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhkj.backstage.R;
import com.zhkj.backstage.activity.ComplaintActivity;
import com.zhkj.backstage.activity.RemoteFeeApplicationActivity;
import com.zhkj.backstage.activity.SearchActivity;
import com.zhkj.backstage.activity.VendorListActivity;
import com.zhkj.backstage.activity.WithdrawActivity;
import com.zhkj.backstage.activity.WorkOrderListActivity;
import com.zhkj.backstage.adapter.SecondaryListAdapter;
import com.zhkj.backstage.adapter.TreeAdapter;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.LeftTitle;
import com.zhkj.backstage.bean.ParentEntity;
import com.zhkj.backstage.bean.SalesToday;
import com.zhkj.backstage.bean.SalesToday2;
import com.zhkj.backstage.bean.SalesToday3;
import com.zhkj.backstage.mvp.contract.HomeContract;
import com.zhkj.backstage.mvp.model.HomeModel;
import com.zhkj.backstage.mvp.presenter.HomePresenter;
import com.zhkj.backstage.weight.CustomFilterDrawerPopupView;
import com.zhkj.backstage.weight.DividerItemDecoration;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

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
    TextView mSosou;
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
    @BindView(R.id.ll_vendor_settled)
    LinearLayout mLlVendorSettled;
    @BindView(R.id.ll_master_settled)
    LinearLayout mLlMasterSettled;
    @BindView(R.id.tv_sale)
    TextView mTvSale;
    @BindView(R.id.tv_total_person)
    TextView mTvTotalPerson;
    @BindView(R.id.tv_total_order)
    TextView mTvTotalOrder;
    @BindView(R.id.ll_order_received_service)
    LinearLayout mLlOrderReceivedService;
    @BindView(R.id.ll_remote_fee_application)
    LinearLayout mLlRemoteFeeApplication;
    @BindView(R.id.ll_today_plant)
    LinearLayout mLlTodayPlant;
    @BindView(R.id.ll_yesterday_plant)
    LinearLayout mLlYesterdayPlant;
    @BindView(R.id.ll_today_master)
    LinearLayout mLlTodayMaster;
    @BindView(R.id.ll_yesterday_master)
    LinearLayout mLlYesterdayMaster;
    @BindView(R.id.tv_withdraw_factory)
    TextView mTvWithdrawFactory;
    @BindView(R.id.ll_factory_complaint)
    LinearLayout mLlFactoryComplaint;
    @BindView(R.id.ll_master_complaint)
    LinearLayout mLlMasterComplaint;
    @BindView(R.id.ll_withdraw)
    LinearLayout mLlWithdraw;
    @BindView(R.id.tv_yesterday_ticket)
    TextView mTvYesterdayTicket;
    @BindView(R.id.ll_yesterday_ticket)
    LinearLayout mLlYesterdayTicket;
    @BindView(R.id.tv_finish)
    TextView mTvFinish;
    @BindView(R.id.ll_finish)
    LinearLayout mLlFinish;
    @BindView(R.id.tv_first)
    TextView mTvFirst;

    private String mParam1;
    private String mParam2;
    private Intent intent1;
    private BasePopupView xPopup;
    private CustomFilterDrawerPopupView customFilterDrawerPopupView;
    private List<SecondaryListAdapter.DataTree<LeftTitle, String>> datas = new ArrayList<>();
    private List<LeftTitle> leftTitleList=new ArrayList<>();
    private String[] title={"权限管理","工单管理","工厂配置","财务管理","系统设置","文章管理","西瓜币管理","小程序管理","商城商品管理"};
//    private String[] title2={"权限管理","工单管理","工厂配置","财务管理","系统设置","文章管理","西瓜币管理","小程序管理","商城商品管理"};
    private TreeAdapter adapter;
    private ArrayList list;

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
//        mRefreshLayout.setRefreshHeader(new ClassicsHeader(mActivity));//设置Header
//        mRefreshLayout.setEnableHeaderTranslationContent(true);//是否下拉Header的时候向下平移列表或者内容
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
//                showProgress();
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

        customFilterDrawerPopupView=new CustomFilterDrawerPopupView(mActivity);
        RecyclerView recyclerView = (RecyclerView)customFilterDrawerPopupView.findViewById(R.id.recyclerView);
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
                new int[]{R.id.parent_name, R.id.child_name,R.id.iv_logo,R.id.iv_right});
        //这里的点击事件很重要
        adapter.setOnItemClickLitener(new TreeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (list.get(position) instanceof ParentEntity){//判断是否为父
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
                }else {//是儿子你想干啥就干啥吧
                    ParentEntity.ChildEntity child = (ParentEntity.ChildEntity) list.get(position);
//                    Toast.makeText(getApplicationContext(), child.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        recyclerView.setAdapter(adapter);
        for (int i = 0; i < title.length; i++){
            ParentEntity parent = new ParentEntity();
            parent.setId(i);
            parent.setName(title[i]);
            parent.setSelect(false);
            List<ParentEntity.ChildEntity> children = new ArrayList<>();
            for (int j = 0; j < 4; j++){
                ParentEntity.ChildEntity child = new ParentEntity.ChildEntity();
                child.setId(j);
                child.setName("我是父"+i+"的儿子" + j);
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
                    ArrayList<String>(){{add("sub 0"); add("sub 1"); add("sub 2");}}));

        }

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
        mLlVendorSettled.setOnClickListener(this);
        mLlMasterSettled.setOnClickListener(this);
        mLlOrderReceivedService.setOnClickListener(this);
        mLlRemoteFeeApplication.setOnClickListener(this);
        mLlTodayMaster.setOnClickListener(this);
        mLlTodayPlant.setOnClickListener(this);
        mLlYesterdayMaster.setOnClickListener(this);
        mLlYesterdayPlant.setOnClickListener(this);
        mLlWithdraw.setOnClickListener(this);
        mLlFactoryComplaint.setOnClickListener(this);
        mLlMasterComplaint.setOnClickListener(this);
        mLlYesterdayTicket.setOnClickListener(this);
        mLlFinish.setOnClickListener(this);
        mSosou.setOnClickListener(this);
        mTvFirst.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mActivity, WorkOrderListActivity.class);
        switch (v.getId()) {
            case R.id.ll_lastest:
                intent.putExtra("name", "最新工单");
                startActivity(intent);
                break;
            case R.id.ll_accessories:
                intent.putExtra("name", "配件工单");
                startActivity(intent);
                break;
            case R.id.ll_warranty:
                intent.putExtra("name", "质保工单");
                startActivity(intent);
                break;
            case R.id.ll_remote_fee:
                intent.putExtra("name", "远程费工单");
                startActivity(intent);
                break;
            case R.id.ll_leave_message:
                intent.putExtra("name", "留言工单");
                startActivity(intent);
                break;
            case R.id.ll_complaint:
                intent.putExtra("name", "投诉工单");
                startActivity(intent);
                break;
            case R.id.ll_carry_out:
                intent.putExtra("name", "完成工单");
                startActivity(intent);
                break;
            case R.id.ll_abolition:
                intent.putExtra("name", "已派未接单");
                startActivity(intent);
                break;
            case R.id.ll_yesterday_ticket:
                intent.putExtra("name", "昨日工单");
                startActivity(intent);
                break;
            case R.id.ll_finish:
                intent.putExtra("name", "待完结工单");
                startActivity(intent);
                break;
            case R.id.ll_factory_complaint:
                intent1 = new Intent(mActivity, ComplaintActivity.class);
                intent1.putExtra("name", "工厂待处理仲裁");
                startActivity(intent1);
                break;
            case R.id.ll_master_complaint:
                intent1 = new Intent(mActivity, ComplaintActivity.class);
                intent1.putExtra("name", "师傅待处理仲裁");
                startActivity(intent1);
                break;
            case R.id.ll_vendor_settled:
                intent1 = new Intent(mActivity, VendorListActivity.class);
                intent1.putExtra("type", "6");
                intent1.putExtra("day", "no");
                startActivity(intent1);
                break;
            case R.id.ll_master_settled:
                intent1 = new Intent(mActivity, VendorListActivity.class);
                intent1.putExtra("type", "7");
                intent1.putExtra("day", "no");
                startActivity(intent1);
                break;
            case R.id.ll_today_plant:
                intent1 = new Intent(mActivity, VendorListActivity.class);
                intent1.putExtra("type", "6");
                intent1.putExtra("day", "tp");
                startActivity(intent1);
                break;
            case R.id.ll_yesterday_plant:
                intent1 = new Intent(mActivity, VendorListActivity.class);
                intent1.putExtra("type", "6");
                intent1.putExtra("day", "yp");
                startActivity(intent1);
                break;
            case R.id.ll_today_master:
                intent1 = new Intent(mActivity, VendorListActivity.class);
                intent1.putExtra("type", "7");
                intent1.putExtra("day", "tm");
                startActivity(intent1);
                break;
            case R.id.ll_yesterday_master:
                intent1 = new Intent(mActivity, VendorListActivity.class);
                intent1.putExtra("type", "7");
                intent1.putExtra("day", "ym");
                startActivity(intent1);
                break;
            case R.id.ll_order_received_service:
                intent.putExtra("name", "已接单待服务");
                startActivity(intent);
                break;
            case R.id.ll_remote_fee_application:
                intent1 = new Intent(mActivity, RemoteFeeApplicationActivity.class);
                startActivity(intent1);
                break;
            case R.id.ll_withdraw:
                intent1 = new Intent(mActivity, WithdrawActivity.class);
                startActivity(intent1);
                break;
            case R.id.sosou:
                startActivity(new Intent(mActivity, SearchActivity.class));
                break;
            case R.id.tv_first:
                xPopup.show();
                break;
        }


    }


    @Override
    public void SalesToday(BaseResult<Data<SalesToday>> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                mTvSale.setText(baseResult.getData().getItem2().getMoney() + "");
                mTvTotalPerson.setText(baseResult.getData().getItem2().getCount() + "");
                mTvTotalOrder.setText(baseResult.getData().getItem2().getOrderCount() + "");
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
                mTvWithdrawFactory.setText(baseResult.getData().getItem2().getFactorycomplaint() + "");

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
                mTvYesterdayTicket.setText(baseResult.getData().getItem2().getYesterdayOrder() + "");
                mTvFinish.setText(baseResult.getData().getItem2().getTobePaid() + "");
                hideProgress();
                break;
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(String message) {
        if ("two".equals(message)) {
            mPresenter.SalesToday2();
        }
    }
}
