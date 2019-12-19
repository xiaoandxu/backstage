package com.zhkj.backstage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.activity.PhotoViewActivity;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.contract.DetailContract;
import com.zhkj.backstage.model.DetailModel;
import com.zhkj.backstage.presenter.DetailPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//返件信息
public class ReturnFragment extends BaseLazyFragment<DetailPresenter, DetailModel> implements DetailContract.View , View.OnClickListener{
    private static final String ARG_PARAM1 = "param1";//
    private static final String ARG_PARAM2 = "param2";//
    @BindView(R.id.iv_bar_code)
    ImageView mIvBarCode;
    @BindView(R.id.ll_bar_code)
    LinearLayout mLlBarCode;
    @BindView(R.id.iv_machine)
    ImageView mIvMachine;
    @BindView(R.id.ll_machine)
    LinearLayout mLlMachine;
    @BindView(R.id.iv_fault_location)
    ImageView mIvFaultLocation;
    @BindView(R.id.ll_fault_location)
    LinearLayout mLlFaultLocation;
    @BindView(R.id.iv_new_and_old_accessories)
    ImageView mIvNewAndOldAccessories;
    @BindView(R.id.ll_new_and_old_accessories)
    LinearLayout mLlNewAndOldAccessories;
    @BindView(R.id.ll_return_information)
    LinearLayout mLlReturnInformation;

    private String mParam1;
    private String mParam2;
    private WorkOrder.DataBean data;
    private Intent intent;

    public static ReturnFragment newInstance(String param1, String param2) {
        ReturnFragment fragment = new ReturnFragment();
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
        return R.layout.fragment_return;
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
        mIvBarCode.setOnClickListener(this);
        mIvFaultLocation.setOnClickListener(this);
        mIvMachine.setOnClickListener(this);
        mIvNewAndOldAccessories.setOnClickListener(this);
    }


    @Override
    public void GetOrderInfo(BaseResult<WorkOrder.DataBean> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                data = baseResult.getData();
                List<String> list = new ArrayList<>();
                for (int i = 0; i < data.getReturnaccessoryImg().size(); i++) {
                    if ("img1".equals(data.getReturnaccessoryImg().get(i).getRelation())) {
                        Glide.with(mActivity).load("https://img.xigyu.com/Pics/OldAccessory/" + data.getReturnaccessoryImg().get(i).getUrl()).into(mIvBarCode);
                    }
                    if ("img2".equals(data.getReturnaccessoryImg().get(i).getRelation())) {
                        Glide.with(mActivity).load("https://img.xigyu.com/Pics/OldAccessory/" + data.getReturnaccessoryImg().get(i).getUrl()).into(mIvMachine);
                    }
                    if ("img3".equals(data.getReturnaccessoryImg().get(i).getRelation())) {
                        Glide.with(mActivity).load("https://img.xigyu.com/Pics/OldAccessory/" + data.getReturnaccessoryImg().get(i).getUrl()).into(mIvFaultLocation);
                    }
                    if ("img4".equals(data.getReturnaccessoryImg().get(i).getRelation())) {
                        Glide.with(mActivity).load("https://img.xigyu.com/Pics/OldAccessory/" + data.getReturnaccessoryImg().get(i).getUrl()).into(mIvNewAndOldAccessories);
                    }
                    list.add(data.getReturnaccessoryImg().get(i).getRelation());
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_bar_code:
                for (int i = 0; i < data.getReturnaccessoryImg().size(); i++) {
                    if ("img1".equals(data.getReturnaccessoryImg().get(i).getRelation())) {
                        intent = new Intent(mActivity, PhotoViewActivity.class);
                        intent.putExtra("PhotoUrl","https://img.xigyu.com/Pics/OldAccessory/" + data.getReturnaccessoryImg().get(i).getUrl());
                        startActivity(intent);
                    }
                }
                break;
            case R.id.iv_machine:
                for (int i = 0; i < data.getReturnaccessoryImg().size(); i++) {
                    if ("img2".equals(data.getReturnaccessoryImg().get(i).getRelation())) {
//                        scaleview("https://img.xigyu.com/Pics/OldAccessory/" + data.getReturnaccessoryImg().get(i).getUrl());
                        intent = new Intent(mActivity, PhotoViewActivity.class);
                        intent.putExtra("PhotoUrl","https://img.xigyu.com/Pics/OldAccessory/" + data.getReturnaccessoryImg().get(i).getUrl());
                        startActivity(intent);
                    }
                }
                break;
            case R.id.iv_fault_location:
                for (int i = 0; i < data.getReturnaccessoryImg().size(); i++) {
                    if ("img3".equals(data.getReturnaccessoryImg().get(i).getRelation())) {
//                        scaleview("https://img.xigyu.com/Pics/OldAccessory/" + data.getReturnaccessoryImg().get(i).getUrl());
                        intent = new Intent(mActivity, PhotoViewActivity.class);
                        intent.putExtra("PhotoUrl","https://img.xigyu.com/Pics/OldAccessory/" + data.getReturnaccessoryImg().get(i).getUrl());
                        startActivity(intent);
                    }
                }
                break;
            case R.id.iv_new_and_old_accessories:
                for (int i = 0; i < data.getReturnaccessoryImg().size(); i++) {
                    if ("img4".equals(data.getReturnaccessoryImg().get(i).getRelation())) {
//                        scaleview("https://img.xigyu.com/Pics/OldAccessory/" + data.getReturnaccessoryImg().get(i).getUrl());
                        intent = new Intent(mActivity, PhotoViewActivity.class);
                        intent.putExtra("PhotoUrl","https://img.xigyu.com/Pics/OldAccessory/" + data.getReturnaccessoryImg().get(i).getUrl());
                        startActivity(intent);
                    }
                }
                break;
        }
    }
}
