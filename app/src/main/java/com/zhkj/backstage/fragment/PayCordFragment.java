package com.zhkj.backstage.fragment;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.PayCordAdapter;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.PayByOrderID;
import com.zhkj.backstage.contract.PayCordContract;
import com.zhkj.backstage.model.PayCordModel;
import com.zhkj.backstage.presenter.PayCordPresenter;

import java.util.List;

import butterknife.BindView;

//支付记录
public class PayCordFragment extends BaseLazyFragment<PayCordPresenter, PayCordModel> implements PayCordContract.View {
    private static final String ARG_PARAM1 = "param1";//
    private static final String ARG_PARAM2 = "param2";//
    @BindView(R.id.rv_paycord)
    RecyclerView mRvPaycord;

    private String mParam1;
    private String mParam2;
    private PayCordAdapter adapter;

    public static PayCordFragment newInstance(String param1, String param2) {
        PayCordFragment fragment = new PayCordFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
//        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
//        mImmersionBar.statusBarView(mView);
        mImmersionBar.keyboardEnable(true);
        mImmersionBar.init();
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
    protected int setLayoutId() {
        return R.layout.fragment_pay_cord;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mPresenter.GetOrderPayByOrderID(mParam1);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void GetOrderPayByOrderID(BaseResult<List<PayByOrderID>> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                adapter = new PayCordAdapter(R.layout.item_pay_cord, baseResult.getData());
                mRvPaycord.setLayoutManager(new LinearLayoutManager(mActivity));
                mRvPaycord.setAdapter(adapter);
                break;
        }
    }
}
