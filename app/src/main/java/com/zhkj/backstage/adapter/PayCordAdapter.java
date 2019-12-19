package com.zhkj.backstage.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.PayByOrderID;

import java.util.List;

public class PayCordAdapter extends BaseQuickAdapter<PayByOrderID, BaseViewHolder> {
    public PayCordAdapter(int layoutResId, @Nullable List<PayByOrderID> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PayByOrderID item) {
        String time=item.getCreateTime().replace("T"," ");
        helper.setText(R.id.tv_pay_money,"支付金额："+item.getPayMoney())
                .setText(R.id.tv_time,time);
    }
}
