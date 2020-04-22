package com.zhkj.backstage.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.SearchAdapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.contract.SearchContract;
import com.zhkj.backstage.model.SearchModel;
import com.zhkj.backstage.presenter.SearchPresenter;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

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
                            mPresenter.GetOrderInfoList(searchname, null, null, null,"999", "1");
                        } else {
                            mPresenter.GetOrderInfoList(null, searchname, null, null,"999", "1");
                        }
                    }else {
                        mPresenter.GetOrderInfoList(null, null, null, searchname,"999", "1");
                    }

                }

                break;

        }
    }



    @Override
    public void GetOrderInfoList(BaseResult<WorkOrder> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
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
