package com.zhkj.backstage.adapter;

import android.graphics.Color;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.WorkOrder;

import java.util.List;

public class LaterorderAdapter extends BaseQuickAdapter<WorkOrder.DataBean, BaseViewHolder> {
    public LaterorderAdapter(int layoutResId, @Nullable List<WorkOrder.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WorkOrder.DataBean item) {
        if ("Y".equals(item.getExtra()) && !"0".equals(item.getExtraTime())) {
            helper.setText(R.id.tv_service, item.getTypeName() + "/" + item.getGuarantee() + "/加急");
        } else {
            helper.setText(R.id.tv_service, item.getTypeName() + "/" + item.getGuarantee());
        }

        helper.setText(R.id.tv_order_num,"工单号："+item.getOrderID())
                .setText(R.id.tv_name, item.getBrandName() + " " + item.getSubCategoryName()+" "+item.getProductType())
//                .setText(R.id.tv_warranty,item.getTypeName()+"/"+item.getGuarantee())
                .setText(R.id.tv_state,item.getState())
                .setText(R.id.tv_billing_account,"发单账号："+item.getUserID())
                .setText(R.id.tv_address,"地址:"+item.getAddress())
                .addOnClickListener(R.id.iv_copy);

        if ("维修".equals(item.getTypeName())){
            helper.setText(R.id.tv_malfunction,"故障:"+item.getMemo());
//            helper.setBackgroundColor(R.id.tv_warranty, Color.parseColor("#F25037"));
        }else if ("安装".equals(item.getTypeName())){
            helper.setText(R.id.tv_malfunction,"安装备注:"+item.getMemo());
//            helper.setBackgroundColor(R.id.tv_warranty, Color.parseColor("#ff3359"));
        }else {
            helper.setText(R.id.tv_malfunction,item.getMemo());
//            helper.setBackgroundColor(R.id.tv_warranty, Color.parseColor("#F25037"));
        }
    }
}
