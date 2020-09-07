package com.zhkj.backstage.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.NewWorkOrderAdapter;
import com.zhkj.backstage.adapter.Redeploy_Adapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetCustomService;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.bean.WorkOrderListBean;
import com.zhkj.backstage.mvp.contract.SearchContract;
import com.zhkj.backstage.mvp.model.SearchModel;
import com.zhkj.backstage.mvp.presenter.SearchPresenter;
import com.zhkj.backstage.weight.CustomDialog_Redeploy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.Toast.LENGTH_SHORT;

public class SearchActivity extends BaseActivity<SearchPresenter, SearchModel> implements View.OnClickListener, SearchContract.View {
    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.back)
    TextView mBack;
    @BindView(R.id.rv_search)
    RecyclerView mRvSearch;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_microphone)
    ImageView mIvMicrophone;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private String userId;
    private ClipboardManager myClipboard;
    private ClipData myClip;
    private List<GetCustomService> subuserlist = new ArrayList<>();
    private String SubUserID;
    private List<WorkOrderListBean.DataBeanX.DataBean> list=new ArrayList<>();
    private WorkOrderListBean.DataBeanX.DataBean.ProductsBean orderProductModelsBean;
    private String copyStr;
    private int page=1;
    private NewWorkOrderAdapter adapter;
    private String roleId;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
        mImmersionBar.statusBarView(mView);
        mImmersionBar.keyboardMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        mImmersionBar.init();
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        SPUtils spUtils = SPUtils.getInstance("token");
        userId = spUtils.getString("userName");
        roleId = getIntent().getStringExtra("roleId");
        mPresenter.GetCustomService();
        search();
        myClipboard = (ClipboardManager) mActivity.getSystemService(Context.CLIPBOARD_SERVICE);
        adapter = new NewWorkOrderAdapter(R.layout.item_new_work_order, list);
        mRvSearch.setLayoutManager(new LinearLayoutManager(mActivity));
        adapter.setEmptyView(getEmptyView());
        mRvSearch.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent=new Intent(mActivity, TopDetailsActivity.class);
                intent.putExtra("OrderId",list.get(position).getOrderID());
                startActivity(intent);
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {

            private Intent intent;

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.ll_copy:
                    case R.id.iv_copy:
                        copy(position);
                        break;
                    case R.id.iv_specify:
                        intent = new Intent(mActivity,DesignatedDispatchActivity.class);
                        intent.putExtra("orderId",list.get(position).getOrderID());
                        intent.putExtra("typeId","1");
                        startActivity(intent);
                        break;
                    case R.id.iv_transfer:
                        intent=new Intent(mActivity,DesignatedDispatchActivity.class);
                        intent.putExtra("orderId",list.get(position).getOrderID());
                        intent.putExtra("typeId","2");
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
                page=1;
                search();
                refreshLayout.resetNoMoreData();
                refreshLayout.finishRefresh(1000);
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                search();
                refreshLayout.finishLoadMore(1000);
            }
        });

    }

    @Override
    protected void setListener() {
        mBack.setOnClickListener(this);
        mIvMicrophone.setOnClickListener(this);

        mEtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    showProgress();
                    mEtSearch.setInputType(EditorInfo.TYPE_NULL);
                    page = 1;
                    hideSoftKeyBoard();
                    search();
                    return true;
                }
                return false;
            }
        });
        mEtSearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mEtSearch.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
                return false;
            }
        });
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
            case R.id.back:
                showProgress();
                mEtSearch.setInputType(EditorInfo.TYPE_NULL);
                page=1;
                hideSoftKeyBoard();
                search();
                break;

        }
    }

    private void search() {
        String searchname = mEtSearch.getText().toString();
        if (searchname == null || "".equals(searchname)) {
            mPresenter.GetoderInfoPartListBak2("7", searchname, null, userId, Integer.toString(page), "10");
        } else {
            Pattern pattern = Pattern.compile("[0-9]*");
            boolean number = pattern.matcher(searchname).matches();
            if (number) {
                StringBuilder stringBuilder = new StringBuilder(searchname);
                String name = stringBuilder.substring(0, 1);
                if ("1".equals(name)) {
                    mPresenter.GetoderInfoPartListBak2("7", null, searchname, userId, Integer.toString(page), "10");
                } else {
                    mPresenter.GetoderInfoPartListBak2("7", searchname, null, userId, Integer.toString(page), "10");
                }
            }
        }
    }


    @Override
    public void GetOrderInfoList(BaseResult<WorkOrder> baseResult) {

    }

    @Override
    public void GetCustomService(BaseResult<List<GetCustomService>> baseResult) {
        subuserlist=baseResult.getData();
    }

    @Override
    public void SetChangeGiveWay(BaseResult<Data<String>> baseResult) {
        ToastUtils.showShort("转派成功");
    }

    @Override
    public void GetoderInfoPartListBak2(WorkOrderListBean baseResult) {
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
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
