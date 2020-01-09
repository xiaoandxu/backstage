package com.zhkj.backstage.fragment;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.ServiceAdapter;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.contract.DetailContract;
import com.zhkj.backstage.model.DetailModel;
import com.zhkj.backstage.presenter.DetailPresenter;

import butterknife.BindView;

//服务信息
public class SysteminfoFragment extends BaseLazyFragment<DetailPresenter, DetailModel> implements DetailContract.View {
    private static final String ARG_PARAM1 = "param1";//
    private static final String ARG_PARAM2 = "param2";//
    @BindView(R.id.rv_service)
    RecyclerView mRvService;

    private String mParam1;
    private String mParam2;
    private WorkOrder.DataBean data;
    private ServiceAdapter serviceAdapter;

    public static SysteminfoFragment newInstance(String param1, String param2) {
        SysteminfoFragment fragment = new SysteminfoFragment();
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
//        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
//        mImmersionBar.statusBarView(mView);
        mImmersionBar.keyboardEnable(true);
        mImmersionBar.init();
    }


    @Override
    protected int setLayoutId() {
        return R.layout.fragment_system_info;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mPresenter.GetOrderInfo(mParam1);
    }

    @Override
    protected void setListener() {

    }


    @Override
    public void GetOrderInfo(BaseResult<WorkOrder.DataBean> baseResult) {
        switch (baseResult.getStatusCode()){
            case 200:
                data = baseResult.getData();
                serviceAdapter = new ServiceAdapter(R.layout.item_service, data.getOrderServiceDetail());
                mRvService.setLayoutManager(new LinearLayoutManager(mActivity));
                mRvService.setAdapter(serviceAdapter);
                break;
        }

    }

    @Override
    public void UpdatePhone(BaseResult<Data<String>> baseResult) {

    }

    @Override
    public void CloseOrder(BaseResult<Data<String>> baseResult) {

    }

    @Override
    public void modifyOrderMoney(BaseResult<Data<String>> baseResult) {

    }

    @Override
    public void ChangeOrderStateTwenty(BaseResult<Data<String>> baseResult) {

    }

    @Override
    public void NowEnSureOrder(BaseResult<Data<String>> baseResult) {

    }
}
