package com.zhkj.backstage.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.GetUserInfoPartListBak;

import java.util.List;

public class CustomerServiceAdapter extends BaseQuickAdapter<GetUserInfoPartListBak.DataBean, BaseViewHolder> {
    public CustomerServiceAdapter(int layoutResId, @Nullable List<GetUserInfoPartListBak.DataBean> data) {
        super(layoutResId, data);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void convert(BaseViewHolder helper, GetUserInfoPartListBak.DataBean item) {
        helper.addOnClickListener(R.id.tv_open);
        TextView tv_certification=helper.getView(R.id.tv_certification);
        if (item.getCreateDate()==null){

        }else {
            String time=item.getCreateDate().replace("T"," ");
            helper.setText(R.id.tv_create_time,"创建时间："+time);
        }

        helper.setText(R.id.tv_user,item.getTrueName());

//        if ("客服".equals(item.getRoleID())){
//            helper.setVisible(R.id.tv_open,true);
//        }else {
//            helper.setGone(R.id.tv_open,false);
//        }

        if ("6".equals(item.getType())){
            helper.setText(R.id.tv_type,"厂商");
            helper.setBackgroundRes(R.id.tv_type,R.drawable.red_shape);
        }else if ("7".equals(item.getType())){
            helper.setText(R.id.tv_type,"师傅");
            helper.setBackgroundRes(R.id.tv_type,R.drawable.blue_shape);
        }else if ("5".equals(item.getType())){
            helper.setText(R.id.tv_type,"平台");
            helper.setBackgroundRes(R.id.tv_type,R.drawable.blue_shape);
        }

        if (item.getIsOrderReceiving()==-1){
            helper.setText(R.id.tv_open,"开启接单");
            helper.setTextColor(R.id.tv_open, Color.BLUE);
        }else {
            helper.setText(R.id.tv_open,"停止接单");
            helper.setTextColor(R.id.tv_open, Color.RED);
        }

        if ("1".equals(item.getIfAuth())){
            tv_certification.setText("已实名");
            tv_certification.setVisibility(View.VISIBLE);
        }else {
            tv_certification.setText("暂未实名");
            tv_certification.setVisibility(View.GONE);
        }
    }
}
