package com.zhkj.backstage.activity;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.zhkj.backstage.adapter.RemoteFeeApplicationAdapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.RemoteFeeAudit;
import com.zhkj.backstage.mvp.contract.RemoteFeeApplicationContract;
import com.zhkj.backstage.mvp.model.RemoteFeeApplicationModel;
import com.zhkj.backstage.mvp.presenter.RemoteFeeApplicationPresenter;
import com.zhkj.backstage.weight.CommonDialog_Home;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RemoteFeeApplicationActivity extends BaseActivity<RemoteFeeApplicationPresenter, RemoteFeeApplicationModel> implements View.OnClickListener, RemoteFeeApplicationContract.View {
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.rv_remote_fee_application)
    RecyclerView mRvRemoteFeeApplication;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private int page=1;
    private RemoteFeeApplicationAdapter adapter;
    private List<RemoteFeeAudit.DataBean> list=new ArrayList<>();
    private ClipboardManager myClipboard;
    private ClipData myClip;
    private SPUtils spUtils;
    private String userName;
    private AlertDialog beyondDialog;
    private Data<String> result;

    @Override
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
//        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
        mImmersionBar.statusBarView(mView);
        mImmersionBar.keyboardEnable(true);
        mImmersionBar.init();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_remote_fee_application;
    }

    @Override
    protected void initData() {
        myClipboard = (ClipboardManager) mActivity.getSystemService(Context.CLIPBOARD_SERVICE);
        adapter = new RemoteFeeApplicationAdapter(R.layout.item_remote_fee_application,list);
        mRvRemoteFeeApplication.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvRemoteFeeApplication.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent=new Intent(mActivity, TopDetailsActivity.class);
                intent.putExtra("OrderId",list.get(position).getOrderID()+"");
                startActivity(intent);
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {

            private Intent intent;

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.iv_copy:
                        String id = list.get(position).getOrderID()+"";
                        myClip = ClipData.newPlainText("", id);
                        myClipboard.setPrimaryClip(myClip);
                        ToastUtils.showShort("复制成功");
                        break;
                    case R.id.tv_pass:
                        CommonDialog_Home pass = new CommonDialog_Home(mActivity);
                        pass.setMessage("是否同意申请的服务")

                                //.setImageResId(R.mipmap.ic_launcher)
                                .setTitle("提示")
                                .setSingle(false).setOnClickBottomListener(new CommonDialog_Home.OnClickBottomListener() {
                            @Override
                            public void onPositiveClick() {
                                pass.dismiss();
                                mPresenter.ApproveBeyondMoney(list.get(position).getOrderID(),"1",userName,"");
//                        mPresenter.ApproveOrderService(OrderID, "1");
                            }

                            @Override
                            public void onNegtiveClick() {//取消
                                pass.dismiss();
                                // Toast.makeText(MainActivity.this,"ssss",Toast.LENGTH_SHORT).show();
                            }
                        }).show();

                        break;
                    case R.id.tv_refuse:
                        CommonDialog_Home reject = new CommonDialog_Home(mActivity);
                        reject.setMessage("是否拒绝申请的远程费")

                                //.setImageResId(R.mipmap.ic_launcher)
                                .setTitle("提示")
                                .setSingle(false).setOnClickBottomListener(new CommonDialog_Home.OnClickBottomListener() {
                                @Override
                            public void onPositiveClick() {
                                reject.dismiss();
                                mPresenter.ApproveBeyondMoney(list.get(position).getOrderID(),"-1",userName,"");
                            }

                            @Override
                            public void onNegtiveClick() {//取消
                                reject.dismiss();
                                // Toast.makeText(MainActivity.this,"ssss",Toast.LENGTH_SHORT).show();
                            }
                        }).show();

                        break;
                    case R.id.tv_change_money:
                        View BeyondView = LayoutInflater.from(mActivity).inflate(R.layout.customdialog_newmoney, null);
                        TextView message = BeyondView.findViewById(R.id.message);
                        TextView title = BeyondView.findViewById(R.id.title);
                        EditText et_new_money = BeyondView.findViewById(R.id.et_new_money);
                        Button negtive = BeyondView.findViewById(R.id.negtive);
                        Button positive = BeyondView.findViewById(R.id.positive);
                        title.setText("提示");
                        message.setText("若您对师傅申请的远程费价格不满意，请您修改您满意的远程费价格");


                        negtive.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                beyondDialog.dismiss();
                            }
                        });

                        positive.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String money = et_new_money.getText().toString();
                                if (money.isEmpty()) {
                                    ToastUtils.showShort("请输入修改的金额");
                                } else {
                                    mPresenter.ApproveBeyondMoney(list.get(position).getOrderID(), "2",userName, money);
                                    beyondDialog.dismiss();
                                }
                            }
                        });

                        beyondDialog = new AlertDialog.Builder(mActivity).setView(BeyondView).create();
                        beyondDialog.show();
                        Window window = beyondDialog.getWindow();
                        WindowManager.LayoutParams lp = window.getAttributes();
                        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                        window.setAttributes(lp);
                        break;
                }
            }
        });
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
//                list.clear();
//                showProgress();
                mPresenter.RemoteFeeAudit(String.valueOf(page),"10");
                refreshLayout.finishRefresh(1000);
//                mPresenter.GetOrderInfoList(null, null, null, null, null, null, null, date, null, null, String.valueOf(page), "10");
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresenter.RemoteFeeAudit(String.valueOf(page),"10");
//                mPresenter.GetOrderInfoList(null, null, null, null, null, null, null, date, null, null, String.valueOf(page), "10");
                refreshLayout.finishLoadMore(1000);
            }
        });
    }

    @Override
    protected void initView() {
        mTvTitle.setText("远程费申请待审核");
        spUtils = SPUtils.getInstance("token");
        userName = spUtils.getString("userName");
        showProgress();
        mPresenter.RemoteFeeAudit(String.valueOf(page),"10");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
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
    public void RemoteFeeAudit(BaseResult<Data<RemoteFeeAudit>> baseResult) {
        switch (baseResult.getStatusCode()){
            case 200:
                if(page==1){
                    list.clear();
                }
                if (baseResult.getData().getItem2().getData()!=null){
                    list.addAll(baseResult.getData().getItem2().getData());
                    adapter.setNewData(list);
                }

                hideProgress();
                break;
        }
    }

    @Override
    public void ApproveBeyondMoney(BaseResult<Data<String>> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                result = baseResult.getData();
                if (result.isItem1()) {
                    ToastUtils.showShort("审核成功！");
                    EventBus.getDefault().post("two");
                    showProgress();
                    list.clear();
                    mPresenter.RemoteFeeAudit(String.valueOf(page),"10");
                } else {
                    ToastUtils.showShort("审核失败！" + result.getItem2());
                }
                break;
            default:
                break;
        }
    }
}
