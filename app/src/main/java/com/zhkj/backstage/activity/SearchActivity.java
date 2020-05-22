package com.zhkj.backstage.activity;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.NewWorkOrderAdapter2;
import com.zhkj.backstage.adapter.Redeploy_Adapter;
import com.zhkj.backstage.adapter.SearchAdapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetCustomService;
import com.zhkj.backstage.bean.GetCustomService2;
import com.zhkj.backstage.bean.WorkOrder;
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
    private String userId;
    private SearchAdapter searchAdapter;
    private ClipboardManager myClipboard;
    private ClipData myClip;
    private String roleId;
    private NewWorkOrderAdapter2 newWorkOrderAdapter2;
    private AlertDialog senddialog;
    private List<GetCustomService2> subuserlist=new ArrayList<>();
    private String SubUserID;

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
        myClipboard = (ClipboardManager) mActivity.getSystemService(Context.CLIPBOARD_SERVICE);


    }

    @Override
    protected void setListener() {
        mBack.setOnClickListener(this);
        mIvMicrophone.setOnClickListener(this);

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
                String searchname = mEtSearch.getText().toString();
                if (searchname == null || "".equals(searchname)) {
                    ToastUtils.showShort("请输入用户手机号或者工单号");
                } else {

                    Pattern pattern = Pattern.compile("[0-9]*");
                    boolean number=pattern.matcher(searchname).matches();
                    if (number){
                        StringBuilder stringBuilder = new StringBuilder(searchname);
                        String name = stringBuilder.substring(0, 1);
                        if ("1".equals(name)) {
                            mPresenter.GetoderInfoPartListBak2("5",null,searchname,userId,"1","999");
//                            mPresenter.GetOrderInfoList(searchname, null, null, null,"999", "1");
                        } else {
                            mPresenter.GetoderInfoPartListBak2("5",searchname,null,userId,"1","999");
//                            mPresenter.GetOrderInfoList(null, searchname, null, null,"999", "1");
                        }
                    }else {

                        mPresenter.GetOrderInfoList(null, null, null, searchname,"999", "1");
                    }

                }

//                break;

        }
    }



    @Override
    public void GetOrderInfoList(BaseResult<WorkOrder> baseResult) {

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

    @Override
    public void GetoderInfoPartListBak2(BaseResult<WorkOrder> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                if ("22".equals(roleId)||"1".equals(roleId)||"2".equals(roleId)){
                    mPresenter.GetCustomService();
                    newWorkOrderAdapter2 = new NewWorkOrderAdapter2(R.layout.item_new_work_order, baseResult.getData().getData());
                    mRvSearch.setLayoutManager(new LinearLayoutManager(mActivity));
                    mRvSearch.setAdapter(newWorkOrderAdapter2);
                    newWorkOrderAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            Intent intent = new Intent(mActivity, TopDetailsActivity.class);
                            intent.putExtra("OrderId",  baseResult.getData().getData().get(position).getOrderID());
                            startActivity(intent);
                        }
                    });
                    newWorkOrderAdapter2.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {

                        private Intent intent;

                        @Override
                        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                            switch (view.getId()) {
                                case R.id.iv_copy:
                                    String id =  baseResult.getData().getData().get(position).getOrderID();
                                    myClip = ClipData.newPlainText("", id);
                                    myClipboard.setPrimaryClip(myClip);
                                    ToastUtils.showShort("复制成功");
                                    break;
                                case R.id.iv_specify:
                                    intent = new Intent(mActivity, DesignatedDispatchActivity.class);
                                    intent.putExtra("orderId",  baseResult.getData().getData().get(position).getOrderID());
                                    intent.putExtra("typeId", "1");
                                    startActivity(intent);
                                    break;
                                case R.id.iv_transfer:
                                    intent = new Intent(mActivity, DesignatedDispatchActivity.class);
                                    intent.putExtra("orderId",  baseResult.getData().getData().get(position).getOrderID());
                                    intent.putExtra("typeId", "2");
                                    startActivity(intent);
                                    break;
                                case R.id.tv_change_state:
                                    View sendView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_home, null);
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
                                                mPresenter.SetChangeGiveWay(baseResult.getData().getData().get(position).getOrderID(),SubUserID);
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
                    searchAdapter = new SearchAdapter(R.layout.item_new_order, baseResult.getData().getData());
                    mRvSearch.setLayoutManager(new LinearLayoutManager(mActivity));
                    mRvSearch.setAdapter(searchAdapter);
                    searchAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                        @Override
                        public void onItemChildClick(BaseQuickAdapter adapter, View view, final int position) {
                            switch (view.getId()) {
                                case R.id.iv_copy:
                                    String id = baseResult.getData().getData().get(position).getOrderID();
                                    myClip = ClipData.newPlainText("", id);
                                    myClipboard.setPrimaryClip(myClip);
                                    ToastUtils.showShort("复制成功");
                                    break;
                            }
                        }
                    });
                    searchAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                            Intent intent1 = new Intent(mActivity, TopDetailsActivity.class);
                            intent1.putExtra("OrderId", baseResult.getData().getData().get(i).getOrderID());
                            startActivity(intent1);
                        }
                    });
                }
                break;
        }
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
