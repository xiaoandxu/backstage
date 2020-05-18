package com.zhkj.backstage.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.LogisticsAdapter;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.Logistics;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.mvp.contract.ExpressInfoContract;
import com.zhkj.backstage.mvp.model.ExpressInfoModel;
import com.zhkj.backstage.mvp.presenter.ExpressInfoPresenter;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/*寄件物流*/
public class ShippingFragment extends BaseLazyFragment<ExpressInfoPresenter, ExpressInfoModel> implements ExpressInfoContract.View, View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";//
    private static final String ARG_PARAM2 = "param2";//
    @BindView(R.id.courier_company_tv)
    TextView mCourierCompanyTv;
    @BindView(R.id.tv_number)
    TextView mTvNumber;
    @BindView(R.id.shipping_rv)
    RecyclerView mShippingRv;
    @BindView(R.id.iv_copy)
    ImageView mIvCopy;
    @BindView(R.id.tv_no_logistics)
    TextView mTvNoLogistics;
    @BindView(R.id.sv_logistics)
    ScrollView mSvLogistics;

    private String mParam1;
    private String mParam2;
    private String orderId;
    private List<Logistics.ExpressDetailListBean.DataBean> list = new ArrayList<>();
    private WorkOrder.DataBean data;
    private LogisticsAdapter adapter;
    private ClipboardManager myClipboard;
    private ClipData myClip;
    private ZLoadingDialog dialog;

    public static ShippingFragment newInstance(String param1, String param2) {
        ShippingFragment fragment = new ShippingFragment();
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
        return R.layout.fragment_shipping;
    }

    @Override
    protected void initData() {
        //loading
        dialog = new ZLoadingDialog(mActivity);
//        showLoading();
        orderId = mParam1;
        mPresenter.GetOrderInfo(orderId);

        adapter = new LogisticsAdapter(R.layout.logistics_recycle_item, list);
        mShippingRv.setLayoutManager(new LinearLayoutManager(mActivity));
        mShippingRv.setAdapter(adapter);
//        adapter.setEmptyView(getEmptyLogistics());
        myClipboard = (ClipboardManager) mActivity.getSystemService(Context.CLIPBOARD_SERVICE);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        mIvCopy.setOnClickListener(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(String name) {

    }

    @Override
    public void GetExpressInfo(BaseResult<Data<Logistics>> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                if (baseResult.getData().getItem2().getExpressDetailList() != null) {
                    list.addAll(baseResult.getData().getItem2().getExpressDetailList().getData());
                    adapter.setNewData(list);
                    cancleLoading();
                }


                break;
        }
    }

    @Override
    public void GetOrderInfo(BaseResult<WorkOrder.DataBean> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                data = baseResult.getData();
                if (data.getOrderAccessroyDetail().size()>0){
                    if ("".equals(data.getOrderAccessroyDetail().get(0).getExpressNo())) {
                        mTvNoLogistics.setVisibility(View.VISIBLE);
                        mSvLogistics.setVisibility(View.GONE);
                        return;
                    } else {
                        mTvNoLogistics.setVisibility(View.GONE);
                        mSvLogistics.setVisibility(View.VISIBLE);
                        if (!"".equals(data.getOrderAccessroyDetail().get(0).getExpressNo())) {
                            mPresenter.GetExpressInfo(data.getOrderAccessroyDetail().get(0).getExpressNo());
                        }
                        mTvNumber.setText(data.getOrderAccessroyDetail().get(0).getExpressNo());
                    }
                }else {
                    return;
                }

                break;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_copy:
                String id = mTvNumber.getText().toString();
                myClip = ClipData.newPlainText("", id);
                myClipboard.setPrimaryClip(myClip);
                ToastUtils.showShort("复制成功");
                break;
        }
    }

    public void showLoading(){
        dialog.setLoadingBuilder(Z_TYPE.SINGLE_CIRCLE)//设置类型
                .setLoadingColor(Color.BLACK)//颜色
                .setHintText("请稍后...")
                .setHintTextSize(14) // 设置字体大小 dp
                .setHintTextColor(Color.BLACK)  // 设置字体颜色
                .setDurationTime(0.5) // 设置动画时间百分比 - 0.5倍
                .setCanceledOnTouchOutside(false)//点击外部无法取消
                .show();
    }

    public void cancleLoading(){
        dialog.dismiss();
    }
}
