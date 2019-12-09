package com.zhkj.backstage.fragment.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.activity.PhotoViewActivity;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BankCard;
import com.zhkj.backstage.bean.CompanyInfo;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetIDCardImg;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.contract.PersonalInformationCotract;
import com.zhkj.backstage.model.PersonalInformationModel;
import com.zhkj.backstage.presenter.PersonalInformationPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//认证信息
public class CertificationtionFragment extends BaseLazyFragment<PersonalInformationPresenter, PersonalInformationModel> implements PersonalInformationCotract.View , View.OnClickListener{
    private static final String ARG_PARAM1 = "param1";//
    private static final String ARG_PARAM2 = "param2";//
    @BindView(R.id.iv_one)
    ImageView mIvOne;
    @BindView(R.id.iv_two)
    ImageView mIvTwo;
    @BindView(R.id.iv_three)
    ImageView mIvThree;

    private String mParam1;
    private String mParam2;
    private String userId;
    private List<GetIDCardImg> list=new ArrayList<>();
    private Intent intent;

    public static CertificationtionFragment newInstance(String param1, String param2) {
        CertificationtionFragment fragment = new CertificationtionFragment();
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
        return R.layout.fragment_certificationtion;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        userId = mParam1;
        mPresenter.GetUserInfo(userId, "1");
        mPresenter.GetIDCardImg(userId);
    }

    @Override
    protected void setListener() {
        mIvOne.setOnClickListener(this);
        mIvTwo.setOnClickListener(this);
        mIvThree.setOnClickListener(this);
    }

    @Override
    public void GetUserInfo(BaseResult<UserInfoList> baseResult) {

    }

    @Override
    public void GetmessageBytype(BaseResult<Data<CompanyInfo>> baseResult) {

    }

    @Override
    public void GetIDCardImg(BaseResult<List<GetIDCardImg>> baseResult) {
        switch (baseResult.getStatusCode()){
            case 200:
                list = baseResult.getData();
                if (baseResult.getData().size()==1){
                    Glide.with(mActivity).
                            load("https://img.xigyu.com/Pics/IDCard/" + baseResult.getData().get(0).getImageUrl())
                            .into(mIvOne);
                } else if (baseResult.getData().size()==2) {
                    Glide.with(mActivity).
                            load("https://img.xigyu.com/Pics/IDCard/" + baseResult.getData().get(0).getImageUrl())
                            .into(mIvOne);
                    Glide.with(mActivity).
                            load("https://img.xigyu.com/Pics/IDCard/" + baseResult.getData().get(1).getImageUrl())
                            .into(mIvTwo);
                }else if (baseResult.getData().size()==3){
                    Glide.with(mActivity).
                            load("https://img.xigyu.com/Pics/IDCard/" + baseResult.getData().get(0).getImageUrl())
                            .into(mIvOne);
                    Glide.with(mActivity).
                            load("https://img.xigyu.com/Pics/IDCard/" + baseResult.getData().get(1).getImageUrl())
                            .into(mIvTwo);
                    Glide.with(mActivity).
                            load("https://img.xigyu.com/Pics/IDCard/" + baseResult.getData().get(2).getImageUrl())
                            .into(mIvThree);
                }else {
                    return;
                }
                break;
        }
    }

    @Override
    public void GetAccountPayInfoList(BaseResult<List<BankCard>> baseResult) {

    }

    @Override
    public void ApproveAuth(BaseResult<Data<String>> baseResult) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_one:
                intent = new Intent(mActivity, PhotoViewActivity.class);
                intent.putExtra("PhotoUrl",list.get(0).getImageUrl());
                startActivity(intent);
                break;
            case R.id.iv_two:
                intent = new Intent(mActivity, PhotoViewActivity.class);
                intent.putExtra("PhotoUrl",list.get(1).getImageUrl());
                startActivity(intent);
                break;
            case R.id.iv_three:
                intent = new Intent(mActivity, PhotoViewActivity.class);
                intent.putExtra("PhotoUrl",list.get(2).getImageUrl());
                startActivity(intent);
                break;
        }
    }
}
