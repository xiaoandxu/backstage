package com.zhkj.backstage.fragment;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhkj.backstage.R;
import com.zhkj.backstage.activity.DesignatedDispatchActivity;
import com.zhkj.backstage.activity.TopDetailsActivity;
import com.zhkj.backstage.adapter.LaterorderAdapter;
import com.zhkj.backstage.adapter.NewWorkOrderAdapter;
import com.zhkj.backstage.adapter.NewWorkOrderAdapter2;
import com.zhkj.backstage.adapter.Redeploy_Adapter;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BackstageGetOrderNum;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetCustomService;
import com.zhkj.backstage.bean.GetCustomService2;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.GetOderCountByCustomService2;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.mvp.contract.NewWorkOrderListContract;
import com.zhkj.backstage.mvp.model.NewWorkOrderListModel;
import com.zhkj.backstage.mvp.presenter.NewWorkOrderListPresenter;
import com.zhkj.backstage.weight.CustomDialog_Redeploy;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.widget.Toast.LENGTH_SHORT;

public class NewWorkOrderListFragment extends BaseLazyFragment<NewWorkOrderListPresenter, NewWorkOrderListModel> implements View.OnClickListener, NewWorkOrderListContract.View {
    private static final String ARG_PARAM1 = "param1";//
    private static final String ARG_PARAM2 = "param2";//
    @BindView(R.id.rv_order)
    RecyclerView mRvOrder;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private String mParam1;
    private String mParam2;
    private ClipboardManager myClipboard;
    private NewWorkOrderAdapter adapter;
    private List<GetOderCountByCustomService2> list=new ArrayList<>();
    private List<WorkOrder.DataBean> list2=new ArrayList<>();
    private ClipData myClip;
    private View sendView;
    private AlertDialog senddialog;
    private int page=1;
    private NewWorkOrderAdapter2 newWorkOrderAdapter2;
    private CustomDialog_Redeploy customDialog_redeploy;
    private RecyclerView recyclerView_custom_redeploy;
    private Redeploy_Adapter redeploy_adapter;
    private List<GetCustomService2> subuserlist=new ArrayList<>();
    private String SubUserID;

    public static NewWorkOrderListFragment newInstance(String param1, String param2) {
        NewWorkOrderListFragment fragment = new NewWorkOrderListFragment();
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
        mImmersionBar.keyboardEnable(true);
        mImmersionBar.init();
    }


    @Override
    protected int setLayoutId() {
        return R.layout.fragment_new_work_order_list;
    }

    @Override
    protected void initData() {
        getData();
        myClipboard = (ClipboardManager) mActivity.getSystemService(Context.CLIPBOARD_SERVICE);
        if ("22".equals(mParam2)||"1".equals(mParam2)||"2".equals(mParam2)){
            newWorkOrderAdapter2 = new NewWorkOrderAdapter2(R.layout.item_new_work_order,list2);
            mRvOrder.setLayoutManager(new LinearLayoutManager(mActivity));
            mRvOrder.setAdapter(newWorkOrderAdapter2);
            newWorkOrderAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    Intent intent = new Intent(mActivity, TopDetailsActivity.class);
                    intent.putExtra("OrderId", list2.get(position).getOrderID());
                    startActivity(intent);
                }
            });
            newWorkOrderAdapter2.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {

                private Intent intent;

                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    switch (view.getId()) {
                        case R.id.iv_copy:
                            String id = list2.get(position).getOrderID();
                            myClip = ClipData.newPlainText("", id);
                            myClipboard.setPrimaryClip(myClip);
                            ToastUtils.showShort("复制成功");
                            break;
                        case R.id.iv_specify:
                            intent = new Intent(mActivity, DesignatedDispatchActivity.class);
                            intent.putExtra("orderId", list2.get(position).getOrderID());
                            intent.putExtra("typeId", "1");
                            startActivity(intent);
                            break;
                        case R.id.iv_transfer:
                            intent = new Intent(mActivity, DesignatedDispatchActivity.class);
                            intent.putExtra("orderId", list2.get(position).getOrderID());
                            intent.putExtra("typeId", "2");
                            startActivity(intent);
                            break;
                        case R.id.tv_change_state:
                            sendView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_home, null);
                            Button btn_negtive = sendView.findViewById(R.id.negtive);
                            Button btn_positive = sendView.findViewById(R.id.positive);
                            TextView tv_title = sendView.findViewById(R.id.title);
                            TextView tv_message = sendView.findViewById(R.id.message);
                            tv_title.setText("提示");
                            tv_message.setText("是否改变工单状态？");

                            btn_negtive.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    senddialog.dismiss();
                                }
                            });
                            btn_positive.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    senddialog.dismiss();
//                                mPresenter.ChangeOrderStateTwenty(list.get(position).getOrderID());
                                }
                            });

                            senddialog = new AlertDialog.Builder(mActivity)
                                    .setView(sendView)
                                    .create();
                            senddialog.show();
                            break;
                        case R.id.tv_customer_service:
                            customDialog_redeploy = new CustomDialog_Redeploy(mActivity);
                            customDialog_redeploy.getWindow().setBackgroundDrawableResource(R.color.transparent);
                            customDialog_redeploy.show();
                            Window window = customDialog_redeploy.getWindow();
                            WindowManager.LayoutParams wlp = window.getAttributes();
                            Display d = window.getWindowManager().getDefaultDisplay();
                            wlp.height = (d.getHeight());
                            wlp.width = (d.getWidth());
                            wlp.gravity = Gravity.CENTER;
                            window.setAttributes(wlp);


                            recyclerView_custom_redeploy = customDialog_redeploy.findViewById(R.id.recyclerView_custom_redeploy);
                            recyclerView_custom_redeploy.setLayoutManager(new LinearLayoutManager(mActivity));
                            redeploy_adapter = new Redeploy_Adapter(R.layout.item_redeploy, subuserlist, mActivity);
                            recyclerView_custom_redeploy.setAdapter(redeploy_adapter);



                            /*选择子账号进行转派*/
                            redeploy_adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                                    switch (view.getId()) {
                                        case R.id.rl_item_redeploy:
                                            // case R.id.img_redeploy_unselect:
                                            // case R.id.img_redeploy_select:
                                            if (((GetCustomService2) adapter.getData().get(position)).isSelect() == false) {//当前选中选中

                                                for (int i = 0; i < subuserlist.size(); i++) {
                                                    subuserlist.get(i).setSelect(false);
                                                }
                                                subuserlist.get(position).setSelect(true); //点击的为选中状态
                                                SubUserID = subuserlist.get(position).getId()+"";
//                                                Log.d("====>", SubUserID);
                                                redeploy_adapter.notifyDataSetChanged();

                                            } else { //点击的为已选中

                                                for (int i = 0; i < subuserlist.size(); i++) {
                                                    subuserlist.get(i).setSelect(false);
                                                }
                                                SubUserID = null;
                                                redeploy_adapter.notifyDataSetChanged();
                                            }


                                            break;
                                        default:
                                            break;
                                    }
                                }
                            });

                            customDialog_redeploy.setYesOnclickListener("转派订单", new CustomDialog_Redeploy.onYesOnclickListener() {
                                @Override
                                public void onYesClick() {
                                    if (SubUserID == null) {
                                        Toast.makeText(mActivity, "您还没选择客服账号进行转派", LENGTH_SHORT).show();
                                        //  customDialog_redeploy.dismiss(); //没选择人进行选派
                                    } else {
                                        //转派成功状态恢复原状

                                        for (int i = 0; i < subuserlist.size(); i++) {
                                            subuserlist.get(i).setSelect(false);
                                        }
                                        //转派成功 刷新当前页面
//                            redeployposition = position;
//                                        mPresenter.ChangeSendOrder(orderId, SubUserID);
                                        mPresenter.SetChangeGiveWay(list2.get(position).getOrderID(),SubUserID);
                                        customDialog_redeploy.dismiss();
                                        // mRefreshLayout.autoRefresh(0,0,1);
                                        SubUserID = null;
                                    }

                                }
                            });

                            customDialog_redeploy.setNoOnclickListener("取消转派", new CustomDialog_Redeploy.onNoOnclickListener() {
                                @Override
                                public void onNoOnclick() {
                                    //点击了取消所谓状态恢复原状
                                    SubUserID = null;
                                    for (int i = 0; i < subuserlist.size(); i++) {
                                        subuserlist.get(i).setSelect(false);
                                    }
                                    customDialog_redeploy.dismiss();
                                }
                            });
                            break;
                    }
                }
            });
        }else {
            adapter = new NewWorkOrderAdapter(R.layout.item_new_work_order, list);
            mRvOrder.setLayoutManager(new LinearLayoutManager(mActivity));
            mRvOrder.setAdapter(adapter);
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    Intent intent = new Intent(mActivity, TopDetailsActivity.class);
                    intent.putExtra("OrderId", list.get(position).getOrderID());
                    startActivity(intent);
                }
            });
            adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {

                private Intent intent;

                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    switch (view.getId()) {
                        case R.id.iv_copy:
                            String id = list.get(position).getOrderID();
                            myClip = ClipData.newPlainText("", id);
                            myClipboard.setPrimaryClip(myClip);
                            ToastUtils.showShort("复制成功");
                            break;
                        case R.id.iv_specify:
                            intent = new Intent(mActivity, DesignatedDispatchActivity.class);
                            intent.putExtra("orderId", list.get(position).getOrderID());
                            intent.putExtra("typeId", "1");
                            startActivity(intent);
                            break;
                        case R.id.iv_transfer:
                            intent = new Intent(mActivity, DesignatedDispatchActivity.class);
                            intent.putExtra("orderId", list.get(position).getOrderID());
                            intent.putExtra("typeId", "2");
                            startActivity(intent);
                            break;
                        case R.id.tv_change_state:
                            sendView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_home, null);
                            Button btn_negtive = sendView.findViewById(R.id.negtive);
                            Button btn_positive = sendView.findViewById(R.id.positive);
                            TextView tv_title = sendView.findViewById(R.id.title);
                            TextView tv_message = sendView.findViewById(R.id.message);
                            tv_title.setText("提示");
                            tv_message.setText("是否改变工单状态？");

                            btn_negtive.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    senddialog.dismiss();
                                }
                            });
                            btn_positive.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    senddialog.dismiss();
//                                mPresenter.ChangeOrderStateTwenty(list.get(position).getOrderID());
                                }
                            });

                            senddialog = new AlertDialog.Builder(mActivity)
                                    .setView(sendView)
                                    .create();
                            senddialog.show();
                            break;
                    }
                }
            });
        }


        //没满屏时禁止上拉
        mRefreshLayout.setEnableLoadMoreWhenContentNotFull(false);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
//                list.clear();
//                showProgress();
                getData();
                refreshLayout.finishRefresh(1000);
//                mPresenter.GetOrderInfoList(null, null, null, null, null, null, null, date, null, null, String.valueOf(page), "10");
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getData();
//                mPresenter.GetOrderInfoList(null, null, null, null, null, null, null, date, null, null, String.valueOf(page), "10");
                refreshLayout.finishLoadMore(1000);
            }
        });
    }

    private void getData() {
        switch (mParam1.substring(0,3)){
            case "未指派":
                if ("22".equals(mParam2)||"1".equals(mParam2)||"2".equals(mParam2)){
                    mPresenter.GetoderInfoPartListBak("0",page+"","10");
                }else {
                    mPresenter.GetOderCountByCustomService2("0",null,null,null,page+"","10");
                }

                break;
            case "未预约":
                if ("22".equals(mParam2)||"1".equals(mParam2)||"2".equals(mParam2)){
                    mPresenter.GetoderInfoPartListBak("1",page+"","10");
                }else {
                    mPresenter.GetOderCountByCustomService2("1", null, null, null, page + "", "10");
                }
                break;
            case "服务中":
                if ("22".equals(mParam2)||"1".equals(mParam2)||"2".equals(mParam2)){
                    mPresenter.GetoderInfoPartListBak("2",page+"","10");
                }else {
                    mPresenter.GetOderCountByCustomService2("2", null, null, null, page + "", "10");
                }
                break;
            case "未支付":
                if ("22".equals(mParam2)||"1".equals(mParam2)||"2".equals(mParam2)){
                    mPresenter.GetoderInfoPartListBak("3",page+"","10");
                }else {
                    mPresenter.GetOderCountByCustomService2("3", null, null, null, page + "", "10");
                }
                break;
            case "已完成":
                if ("22".equals(mParam2)||"1".equals(mParam2)||"2".equals(mParam2)){
                    mPresenter.GetoderInfoPartListBak("4",page+"","10");
                }else {
                    mPresenter.GetOderCountByCustomService2("4", null, null, null, page + "", "10");
                }
                break;
            case "所有工":
                if ("22".equals(mParam2)||"1".equals(mParam2)||"2".equals(mParam2)){
                    mPresenter.GetoderInfoPartListBak("5",page+"","10");
                }else {
                    mPresenter.GetOderCountByCustomService2("5", null, null, null, page + "", "10");
                }
                break;
        }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void GetOderCountByCustomService(BaseResult<GetOderCountByCustomService> baseResult) {

    }

    @Override
    public void BackstageGetOrderNum(BaseResult<BackstageGetOrderNum> baseResult) {

    }

    @Override
    public void GetOderCountByCustomService2(BaseResult<List<GetOderCountByCustomService2>> baseResult) {
        list.addAll(baseResult.getData());
        adapter.setNewData(list);
    }

    @Override
    public void GetoderInfoPartListBak(BaseResult<WorkOrder> baseResult) {
        list2.addAll(baseResult.getData().getData());
        newWorkOrderAdapter2.setNewData(list2);
        mPresenter.GetCustomService();
    }

    @Override
    public void GetCustomService(BaseResult<List<GetCustomService>> baseResult) {
        for (int i = 0; i < baseResult.getData().size(); i++) {
            subuserlist.add(new GetCustomService2(baseResult.getData().get(i).getId(),baseResult.getData().get(i).getName(),false));
        }


    }

    @Override
    public void SetChangeGiveWay(BaseResult<Data<String>> baseResult) {
        ToastUtils.showShort("转派成功");
    }
}
