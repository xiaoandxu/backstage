package com.zhkj.backstage.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;

import java.util.List;

public class WorkerListAdapter extends BaseQuickAdapter<List<String>, BaseViewHolder> {
    public WorkerListAdapter(int layoutResId, @Nullable List<List<String>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, List<String> item) {
        helper.setText(R.id.tv_user,item.get(1))
                .setText(R.id.tv_addr,"地址："+item.get(2));
        helper.setText(R.id.tv_type,"师傅");
        helper.setBackgroundRes(R.id.tv_type,R.drawable.blue_shape);
    }
}
