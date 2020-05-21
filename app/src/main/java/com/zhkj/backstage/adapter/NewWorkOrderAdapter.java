package com.zhkj.backstage.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.GetOderCountByCustomService2;

import java.util.List;

public class NewWorkOrderAdapter extends BaseQuickAdapter<GetOderCountByCustomService2, BaseViewHolder> {
    public NewWorkOrderAdapter(int layoutResId, @Nullable List<GetOderCountByCustomService2> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GetOderCountByCustomService2 item) {

        if ("Y".equals(item.getExtra()) && !"0".equals(item.getExtraTime())) {
            helper.setText(R.id.tv_service, item.getTypeName() + "/" + item.getGuarantee() + "/加急");
        } else {
            helper.setText(R.id.tv_service, item.getTypeName() + "/" + item.getGuarantee());
        }
        helper.addOnClickListener(R.id.iv_specify)
                .addOnClickListener(R.id.iv_transfer)
                .addOnClickListener(R.id.tv_change_state);

//        if (item.getSendUser()==null){
//            helper.setVisible(R.id.iv_transfer,false);
////            helper.setVisible(R.id.tv_change_state,false);
//            helper.setVisible(R.id.iv_specify,true);
//        }else {
//            helper.setVisible(R.id.iv_transfer,true);
////            helper.setVisible(R.id.tv_change_state,true);
//            helper.setVisible(R.id.iv_specify,false);
//        }

        helper.setText(R.id.tv_order_num,"工单号："+item.getOrderID())
                .setText(R.id.tv_name, item.getBrandName() + " " + item.getSubCategoryName()+" "+item.getProductType())
//                .setText(R.id.tv_warranty,item.getTypeName()+"/"+item.getGuarantee())
                .setText(R.id.tv_state,item.getState())
                .setText(R.id.tv_billing_account,"发单账号："+item.getInvoiceName())
                .setText(R.id.tv_crate_time,"创建时间："+item.getCreateDate())
                .setText(R.id.tv_address,"地址:"+item.getAddress())
                .setText(R.id.tv_operation,"操作客服:"+item.getTrueName())
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