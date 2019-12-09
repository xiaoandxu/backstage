package com.zhkj.backstage.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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
import com.zhkj.backstage.adapter.DesignatedDispatchAdapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.UserList;
import com.zhkj.backstage.contract.DesignatedDispatchContract;
import com.zhkj.backstage.model.DesignatedDispatchModel;
import com.zhkj.backstage.presenter.DesignatedDispatchPresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DesignatedDispatchActivity extends BaseActivity<DesignatedDispatchPresenter, DesignatedDispatchModel> implements View.OnClickListener, DesignatedDispatchContract.View {
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.rv_person)
    RecyclerView mRvPerson;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.tv_search)
    TextView mTvSearch;
    private int page = 1;
    private String orderId;
    private List<UserList.DataBean> list = new ArrayList<>();
    private DesignatedDispatchAdapter adapter;
    private View sendView;
    private AlertDialog senddialog;
    private SPUtils spUtils;
    private String userId;
    private String typeId;

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
        return R.layout.activity_designated_dispatch;
    }

    @Override
    protected void initData() {

        adapter = new DesignatedDispatchAdapter(R.layout.item_person, list);
        mRvPerson.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvPerson.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.ll_user:
                        sendView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_home, null);
                        Button btn_negtive = sendView.findViewById(R.id.negtive);
                        Button btn_positive = sendView.findViewById(R.id.positive);
                        TextView tv_title = sendView.findViewById(R.id.title);
                        TextView tv_message = sendView.findViewById(R.id.message);
                        tv_title.setText("提示");
                        tv_message.setText("确定派单给该师傅？");
                        btn_negtive.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                senddialog.dismiss();
                            }
                        });
                        btn_positive.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mPresenter.SendOrder(orderId,list.get(position).getUserID(),userId,typeId);
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

        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear();
                page = 1;
                mPresenter.GetMUserList("", "7", String.valueOf(page), "10");
                mRefreshLayout.finishRefresh(1000);
            }
        });
//        mRefreshLayout.setEnableLoadMore(false);

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresenter.GetMUserList("", "7", String.valueOf(page), "10");
                refreshLayout.finishLoadMore(1000);
            }
        });
    }

    @Override
    protected void initView() {

        orderId = getIntent().getStringExtra("orderId");
        typeId = getIntent().getStringExtra("typeId");
        if ("1".equals(typeId)){
            mTvTitle.setText("指定派单");
        }else if ("2".equals(typeId)){
            mTvTitle.setText("转派工单");
        }
        spUtils = SPUtils.getInstance("token");
        userId = spUtils.getString("userName");
        mPresenter.GetMUserList("", "7", String.valueOf(page), "10");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mTvSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_search:
                String name=mEtSearch.getText().toString();
                if (name.isEmpty()){
                    mPresenter.GetMUserList("", "7", String.valueOf(page), "10");
                }else {
                    list.clear();
                    mPresenter.GetMUserList(name, "7", "1", "10");
                }
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
    public void GetMUserList(BaseResult<UserList> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                if (baseResult.getData().getData() != null) {
                    list.addAll(baseResult.getData().getData());
                    adapter.setNewData(list);
                }
                break;
        }
    }

    @Override
    public void SendOrder(BaseResult<Data<String>> baseResult) {
        switch (baseResult.getStatusCode()){
            case 200:
                if (baseResult.getData().isItem1()){
                    ToastUtils.showShort("派单成功");
                    EventBus.getDefault().post("send");
                    finish();
                }else {
                    ToastUtils.showShort(baseResult.getData().getItem2());
                }

                break;
        }
    }
}
