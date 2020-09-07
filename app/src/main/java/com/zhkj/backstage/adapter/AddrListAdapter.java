package com.zhkj.backstage.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;

import java.util.List;

public class AddrListAdapter extends BaseQuickAdapter<List<String>, BaseViewHolder> {
    public AddrListAdapter(int layoutResId, List<List<String>> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, List<String> item) {
        helper.setText(R.id.tv_category,item.get(1)+"("+item.get(2)+")");
    }
}
