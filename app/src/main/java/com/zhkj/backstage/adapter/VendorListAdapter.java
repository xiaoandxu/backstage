package com.zhkj.backstage.adapter;

import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.UserInfoList;

import java.util.List;

public class VendorListAdapter extends BaseQuickAdapter<UserInfoList.DataBean, BaseViewHolder> {
    public VendorListAdapter(int layoutResId, @Nullable List<UserInfoList.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserInfoList.DataBean item) {
        TextView tv_certification=helper.getView(R.id.tv_certification);
//        String time=item.getCreateDate().replace("T"," ");
        helper.setText(R.id.tv_user,item.getNickName())
                .setText(R.id.tv_addr,"地址："+(item.getAddress()==null?item.getProvinceName()+item.getCityName()+item.getAreaName()+item.getDistrictName():item.getAddress()));
        if ("6".equals(item.getType())){
            helper.setText(R.id.tv_type,"厂商");
            helper.setBackgroundRes(R.id.tv_type,R.drawable.red_shape);
        }else if ("7".equals(item.getType())){
            helper.setText(R.id.tv_type,"师傅");
            helper.setBackgroundRes(R.id.tv_type,R.drawable.blue_shape);
        }

//        if ("1".equals(item.getIfAuth())){
//            tv_certification.setText("已实名");
//            tv_certification.setVisibility(View.VISIBLE);
//        }else {
//            tv_certification.setText("暂未实名");
//            tv_certification.setVisibility(View.GONE);
//        }

    }
}
