package com.zhkj.backstage.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.BankCard;

import java.util.List;

public class PaymentAdapter extends BaseQuickAdapter<BankCard, BaseViewHolder> {
    public PaymentAdapter(int layoutResId, @Nullable List<BankCard> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BankCard item) {
        helper.setText(R.id.tv_bank_name,item.getPayInfoName())
                .setText(R.id.tv_bank_number,item.getPayNo());
    }
}
