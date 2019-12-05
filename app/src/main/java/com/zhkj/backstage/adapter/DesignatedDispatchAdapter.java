package com.zhkj.backstage.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.UserList;

import java.util.List;

public class DesignatedDispatchAdapter extends BaseQuickAdapter<UserList.DataBean, BaseViewHolder> {
    public DesignatedDispatchAdapter(int layoutResId, @Nullable List<UserList.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserList.DataBean item) {
        helper.setText(R.id.tv_user,item.getUserID())
                .setText(R.id.tv_name,item.getTrueName())
                .setText(R.id.tv_address,"地址："+item.getAddress());
        helper.addOnClickListener(R.id.ll_user);
    }
}
