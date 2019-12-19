package com.zhkj.backstage.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.GService;

import java.util.List;

public class ServiceAdapter extends BaseQuickAdapter<GService, BaseViewHolder> {
    public ServiceAdapter(int layoutResId, @Nullable List<GService> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GService item) {
        helper.setText(R.id.tv_service_name,item.getServiceName());
    }
}
