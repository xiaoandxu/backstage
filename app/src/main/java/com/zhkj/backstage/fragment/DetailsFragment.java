package com.zhkj.backstage.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.zhkj.backstage.R;
import com.zhkj.backstage.base.BaseLazyFragment;

//工单详情
public class DetailsFragment extends BaseLazyFragment {
    private static final String Param="param";
    private String mParam;
   public static DetailsFragment newInstant(String param){
       DetailsFragment orderdetails=new DetailsFragment();
       Bundle args=new Bundle();
       args.getString(Param,param);
       orderdetails.setArguments(args);
       return orderdetails;
   }

    @Override
    protected int setLayoutId() {
       return R.layout.fragment_details;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            mParam=getArguments().getString(Param);
        }
    }
}
