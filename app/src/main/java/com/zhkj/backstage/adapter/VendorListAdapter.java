package com.zhkj.backstage.adapter;

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
        String time=item.getCreateDate().replace("T"," ");
        helper.setText(R.id.tv_user,item.getUserID())
                .setText(R.id.tv_create_time,"创建时间："+time);
        if ("6".equals(item.getType())){
            helper.setText(R.id.tv_type,"厂商");
            helper.setBackgroundRes(R.id.tv_type,R.drawable.red_shape);
        }else if ("7".equals(item.getType())){
            helper.setText(R.id.tv_type,"师傅");
            helper.setBackgroundRes(R.id.tv_type,R.drawable.blue_shape);
        }
    }
}
