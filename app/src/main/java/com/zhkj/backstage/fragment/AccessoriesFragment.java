package com.zhkj.backstage.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.zhkj.backstage.R;
import com.zhkj.backstage.base.BaseLazyFragment;

//配件信息
public class AccessoriesFragment extends BaseLazyFragment {
    private static final String Param="param";
    private String mParam;
   public static AccessoriesFragment newInstant(String param){
       AccessoriesFragment orderdetails=new AccessoriesFragment();
       Bundle args=new Bundle();
       args.getString(Param,param);
       orderdetails.setArguments(args);
       return orderdetails;
   }

    @Override
    protected int setLayoutId() {
       return R.layout.fragment_accessories;
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
