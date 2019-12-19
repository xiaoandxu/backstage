package com.zhkj.backstage.viewholder;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;

import com.chad.library.adapter.base.BaseViewHolder;

public class LayoutParamsViewHolder extends BaseViewHolder {
    public LayoutParamsViewHolder(View view) {
        super(view);
    }
    public BaseViewHolder setLayoutParams(@IdRes int viewId, ViewGroup.LayoutParams layoutParams) {
        View view = getView(viewId);
        view.setLayoutParams(layoutParams);
        return this;
    }
}
