package com.zhkj.backstage.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.WithDrawList;

import java.util.List;

public class WithdrawAdapter extends BaseQuickAdapter<WithDrawList.DataBean, BaseViewHolder> {

    private String time2;

    public WithdrawAdapter(int layoutResId, @Nullable List<WithDrawList.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WithDrawList.DataBean item) {
        if ("0".equals(item.getState())){
            helper.setText(R.id.tv_state,"待提现");
        }else if ("1".equals(item.getState())){
            helper.setText(R.id.tv_state,"提现成功");
        }
        String time1=item.getCreateTime().replace("T"," ");
        if (item.getApproveTime()==null){
            time2="";
        }else {
            time2 = item.getApproveTime().replace("T"," ");
        }


        helper.setText(R.id.tv_use,"用户名:"+item.getUserID())
                .setText(R.id.tv_money,"提现金额:"+item.getPayMoney())
                .setText(R.id.tv_account_holder,"开户人:"+item.getPayName())
                .setText(R.id.tv_bank_name,"提现银行:"+item.getPayInfo())
                .setText(R.id.tv_bank_number,item.getPayNo())
                .setText(R.id.tv_crate_time,"创建时间："+time1)
                .setText(R.id.tv_review_time,"审核时间："+ time2)
                .setText(R.id.tv_reviewer,"审核人："+item.getApproveUser());
        helper.addOnClickListener(R.id.tv_withdraw)
                .addOnClickListener(R.id.iv_copy);
    }
}
