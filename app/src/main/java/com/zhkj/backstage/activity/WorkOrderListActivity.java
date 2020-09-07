package com.zhkj.backstage.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.NewWorkOrderAdapter;
import com.zhkj.backstage.adapter.Redeploy_Adapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BackstageGetOrderNum;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetCustomService;
import com.zhkj.backstage.bean.GetOderCountByCustomService;
import com.zhkj.backstage.bean.GetOrderReq;
import com.zhkj.backstage.bean.WorkOrderListBean;
import com.zhkj.backstage.mvp.contract.NewWorkOrderListContract;
import com.zhkj.backstage.mvp.model.NewWorkOrderListModel;
import com.zhkj.backstage.mvp.presenter.NewWorkOrderListPresenter;
import com.zhkj.backstage.weight.CustomDialog_Redeploy;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static android.widget.Toast.LENGTH_SHORT;

/*最新工单*/
public class WorkOrderListActivity extends BaseActivity<NewWorkOrderListPresenter, NewWorkOrderListModel> implements View.OnClickListener, NewWorkOrderListContract.View {


    @BindView(R.id.new_order)
    RecyclerView mNewOrder;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.tv_save)
    TextView mTvSave;
    @BindView(R.id.iv_search)
    ImageView mIvSearch;
    private List<WorkOrderListBean.DataBeanX.DataBean> list = new ArrayList<>();
    private List<GetCustomService> subuserlist = new ArrayList<>();
    private NewWorkOrderAdapter adapter;
    private int page = 1;
    private String date;
    private String name;
    private ClipboardManager myClipboard;
    private ClipData myClip;
    private String phone;
    private Gson gson;
    private GetOrderReq req;
    private String json;
    private RequestBody body;
    private WorkOrderListBean.DataBeanX.DataBean.ProductsBean orderProductModelsBean;
    private String copyStr;
    private String SubUserID;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_workorder_list;
    }

    @Override
    protected void initData() {
        mIvSearch.setVisibility(View.VISIBLE);
        mPresenter.GetCustomService();
        myClipboard = (ClipboardManager) mActivity.getSystemService(Context.CLIPBOARD_SERVICE);
        adapter = new NewWorkOrderAdapter(R.layout.item_new_work_order, list);
        mNewOrder.setLayoutManager(new LinearLayoutManager(mActivity));
        adapter.setEmptyView(getEmptyView());
        mNewOrder.setAdapter(adapter);
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
                    case R.id.ll_copy:
                    case R.id.iv_copy:
                        copy(position);
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
                    case R.id.tv_customer_service:
                        deploy(position);
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
                getData();
                refreshLayout.resetNoMoreData();
                refreshLayout.finishRefresh(1000);
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getData();
                refreshLayout.finishLoadMore(1000);
            }
        });
    }

    //指派客服
    private void deploy(int position) {
        CustomDialog_Redeploy customDialog_redeploy = new CustomDialog_Redeploy(mActivity);
        customDialog_redeploy.getWindow().setBackgroundDrawableResource(R.color.transparent);
        customDialog_redeploy.show();
        Window window = customDialog_redeploy.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        Display d = window.getWindowManager().getDefaultDisplay();
        wlp.height = (d.getHeight());
        wlp.width = (d.getWidth());
        wlp.gravity = Gravity.CENTER;
        window.setAttributes(wlp);


        RecyclerView recyclerView_custom_redeploy = customDialog_redeploy.findViewById(R.id.recyclerView_custom_redeploy);
        recyclerView_custom_redeploy.setLayoutManager(new LinearLayoutManager(mActivity));
        Redeploy_Adapter redeploy_adapter = new Redeploy_Adapter(R.layout.item_redeploy, subuserlist, mActivity);
        recyclerView_custom_redeploy.setAdapter(redeploy_adapter);



        /*选择子账号进行转派*/
        redeploy_adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                switch (view.getId()) {
                    case R.id.rl_item_redeploy:
                        // case R.id.img_redeploy_unselect:
                        // case R.id.img_redeploy_select:
                        if (((GetCustomService) adapter.getData().get(position)).isSelect() == false) {//当前选中选中

                            for (int i = 0; i < subuserlist.size(); i++) {
                                subuserlist.get(i).setSelect(false);
                            }
                            subuserlist.get(position).setSelect(true); //点击的为选中状态
                            SubUserID = subuserlist.get(position).getId() + "";
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
                    mPresenter.SetChangeGiveWay(list.get(position).getOrderID() + "", SubUserID);
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
    }

    //复制
    private void copy(int position) {
        String prod = "";
        for (int i = 0; i < list.get(position).getProducts().size(); i++) {
            orderProductModelsBean = list.get(position).getProducts().get(i);
            prod += orderProductModelsBean.getProductContent() + ",";
        }
        if (prod.contains(",")) {
            prod = prod.substring(0, prod.lastIndexOf(","));
        }
        copyStr = "下单厂家：" + list.get(position).getInvoiceName() + "\n"
                + "工单号：" + list.get(position).getOrderID() + "\n"
                + "下单时间：" + list.get(position).getCreateDate() + "\n"
                + "用户信息：" + list.get(position).getUserName() + " " + list.get(position).getPhone() + "\n"
                + "用户地址：" + list.get(position).getAddress() + "\n"
                + "产品信息：" + prod + "\n"
                + "售后类型：" + list.get(position).getGuarantee() + "\n"
                + "服务类型：" + list.get(position).getTypeName();
        myClip = ClipData.newPlainText("", copyStr
        );
        myClipboard.setPrimaryClip(myClip);
        ToastUtils.showShort("复制成功" + "\n" + copyStr);
    }

    @Override
    protected void initView() {
        name = getIntent().getStringExtra("name");
        phone = getIntent().getStringExtra("phone");
        mTvTitle.setText(name);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  // HH:mm:ss  HH:24小时制  hh:12小时制
        date = dateFormat.format(new Date());
        showProgress();
        getData();
    }

    private void getData() {
        gson = new Gson();
        switch (name) {
            case "最新工单":
                req = new GetOrderReq(date, "", Integer.toString(page), "10");
                json = gson.toJson(req);
                body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
                mPresenter.GetoderInfoPartListBak(body);
                break;
            case "昨日工单":
                req = new GetOrderReq(getStringByFormat(getYesterdaysmorning()), getStringByFormat(getTimesmorning()), Integer.toString(page), "10");
                json = gson.toJson(req);
                body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
                mPresenter.GetoderInfoPartListBak(body);
                break;
        }
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mIvSearch.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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
    public void GetOderCountByCustomService(BaseResult<GetOderCountByCustomService> baseResult) {

    }

    @Override
    public void BackstageGetOrderNum(BaseResult<BackstageGetOrderNum> baseResult) {

    }

    @Override
    public void GetOderCountByCustomService2(WorkOrderListBean baseResult) {

    }

    @Override
    public void GetoderInfoPartListBak(WorkOrderListBean baseResult) {
        hideProgress();
        switch (baseResult.getStatusCode()) {
            case 200:
                if (page != 1 && baseResult.getData().getData().size() == 0) {
                    mRefreshLayout.finishLoadMoreWithNoMoreData();
                }
                if (page == 1) {
                    list.clear();
                }
                list.addAll(baseResult.getData().getData());
                adapter.setNewData(list);
                break;
        }
    }

    @Override
    public void GetCustomService(BaseResult<List<GetCustomService>> baseResult) {
        subuserlist = baseResult.getData();
    }

    @Override
    public void SetChangeGiveWay(BaseResult<Data<String>> baseResult) {
        ToastUtils.showShort("转派成功");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(String message) {
        if ("send".equals(message)) {
            list.clear();
            getData();
        }
    }

    // 获得当天0点时间
    public static Date getTimesmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static String getStringByFormat(Date date) {
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = null;
        try {
            strDate = mSimpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDate;
    }

    // 获得昨日0点时间
    public static Date getYesterdaysmorning() {

        Calendar cal = Calendar.getInstance();
        cal.add(cal.DATE, -1);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
