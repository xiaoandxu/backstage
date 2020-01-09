package com.zhkj.backstage.adapter;


import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhkj.backstage.R;
import com.zhkj.backstage.util.GlideUtil;
import com.zhkj.backstage.viewholder.LayoutParamsViewHolder;

import java.util.List;

import io.reactivex.annotations.Nullable;

public class PicAdapter extends BaseQuickAdapter<String, LayoutParamsViewHolder> {
    public PicAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(LayoutParamsViewHolder helper, String item) {

        GlideUtil.loadImageViewLoding(mContext, item, (ImageView) helper.getView(R.id.img), R.drawable.add_picture,R.drawable.add_picture);
        helper.addOnClickListener(R.id.img);

    }
}
