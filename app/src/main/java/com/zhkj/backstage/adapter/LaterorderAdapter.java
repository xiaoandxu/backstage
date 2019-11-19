package com.zhkj.backstage.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.bean.Latestorder;

import java.util.List;

public class LaterorderAdapter extends BaseQuickAdapter<Latestorder, BaseViewHolder> {
    public LaterorderAdapter(int layoutResId, @Nullable List<Latestorder> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Latestorder item) {

    }
}
