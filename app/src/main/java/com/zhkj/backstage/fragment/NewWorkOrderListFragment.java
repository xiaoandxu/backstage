package com.zhkj.backstage.fragment;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.GetOderCountByCustomService2;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.mvp.contract.NewWorkOrderListContract;

import java.util.List;

import butterknife.BindView;

public class NewWorkOrderListFragment<NewWorkOrderListPresenter,NewWorkOrderListModel> extends BaseLazyFragment implements View.OnClickListener, NewWorkOrderListContract.View {
    private static final String ARG_PARAM1 = "param1";//
    private static final String ARG_PARAM2 = "param2";//
    @BindView(R.id.rv_order)
    RecyclerView mRvOrder;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private String mParam1;
    private String mParam2;
    private ClipboardManager myClipboard;
    private LaterorderAdapter adapter;
    private List<WorkOrder.DataBean> list;
    private ClipData myClip;
    private View sendView;
    private AlertDialog senddialog;
    private int page;


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
        myClipboard = (ClipboardManager) mActivity.getSystemService(Context.CLIPBOARD_SERVICE);
        adapter = new LaterorderAdapter(R.layout.item_new_order, list);
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
                                mPresenter.ChangeOrderStateTwenty(list.get(position).getOrderID());
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

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
    private void getData() {
        switch (name){
            case "最新工单":
                mPresenter.GetOrderInfoList(null, null, null, null, null, null, null, date, null, null,null,null,null,null, String.valueOf(page), "10");
                break;
            case "配件工单":
                mPresenter.GetOrderInfoList(null, null, null, null, null, null, null, null, "1", null, null,null,null,null,String.valueOf(page), "10");
                break;
            case "质保工单":
                mPresenter.GetOrderInfoList(null, null, "3", null, null, null, null, null, null, null,null, null,null,null,String.valueOf(page), "10");
                break;
            case "远程费工单":
                mPresenter.GetOrderInfoList(null, null, null, "9", null, null, null, null, null, null, null,null,null,null,String.valueOf(page), "10");
                break;
            case "留言工单":
                mPresenter.GetOrderInfoList(null, null, null, null, null, null, null, null, null, "1", null,null,null,null,String.valueOf(page), "10");
                break;
            case "投诉工单":
                mPresenter.GetOrderInfoList(null, null, null, null, null, null, null, null, null, null,null,null,null,null,String.valueOf(page), "10");
                break;
            case "完成工单":
                mPresenter.GetOrderInfoList(null, null, null, "7", null, null, null, null, null, null, null,null,null,null,String.valueOf(page), "10");
                break;
            case "已派未接单":
                mPresenter.GetOrderInfoList(null, null, null, "1", null, null, null, null, null, null,"1", null,null,null,String.valueOf(page), "10");
                break;
            case "已接单待服务":
                mPresenter.GetOrderInfoList(null,null,null,"2",null,null,null,null,null,null,null,null,null,null,String.valueOf(page), "10");
                break;
            case "昨日工单":
                mPresenter.GetOrderInfoList(null,null,null,null,null,null,null,null,null,null,null,getStringByFormat(getYesterdaysmorning()),getStringByFormat(getTimesmorning()),null,String.valueOf(page), "10");
                break;
            case "个人工单":
                mPresenter.GetOrderInfoList(null,null,null,null,null,null,null,null,null,null,null,null,null,phone,String.valueOf(page), "10");
                break;
            case "待完结工单":
                mPresenter.GetOrderInfoList(null,null,null,"5",null,null,null,null,null,null,null,null,null,null,String.valueOf(page), "10");
                break;
        }
    }

    @Override
    public void GetOderCountByCustomService(BaseResult<GetOderCountByCustomService> baseResult) {

    }

    @Override
    public void GetOderCountByCustomService2(BaseResult<List<GetOderCountByCustomService2>> baseResult) {

    }
}
