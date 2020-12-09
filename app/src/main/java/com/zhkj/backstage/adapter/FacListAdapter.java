package com.zhkj.backstage.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.GetUserInfoListForPlatformResult;

import java.util.List;

public class FacListAdapter extends BaseQuickAdapter<GetUserInfoListForPlatformResult.DataBeanX.DataBean, BaseViewHolder> {
    public FacListAdapter(int layoutResId, List<GetUserInfoListForPlatformResult.DataBeanX.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GetUserInfoListForPlatformResult.DataBeanX.DataBean item) {
        helper.setText(R.id.tv_name,item.getCompanyName());
        helper.setText(R.id.tv_banlance,"可用余额￥"+item.getBalance());
    }
}
