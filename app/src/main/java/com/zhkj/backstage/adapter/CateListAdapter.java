package com.zhkj.backstage.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.GetSecondCategoryListResult;

import java.util.List;

public class CateListAdapter extends BaseQuickAdapter<GetSecondCategoryListResult.DataBeanX.DataBean, BaseViewHolder> {
    public CateListAdapter(int layoutResId, List<GetSecondCategoryListResult.DataBeanX.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GetSecondCategoryListResult.DataBeanX.DataBean item) {
        helper.setText(R.id.tv_name,item.getName());
        helper.getView(R.id.iv_choose).setSelected(item.isCheck());
    }
}
