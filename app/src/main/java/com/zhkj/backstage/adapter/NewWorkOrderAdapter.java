package com.zhkj.backstage.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.WorkOrderListBean;

import java.util.List;

public class NewWorkOrderAdapter extends BaseQuickAdapter<WorkOrderListBean.DataBeanX.DataBean, BaseViewHolder> {

    private WorkOrderListBean.DataBeanX.DataBean.ProductsBean productsBean;

    public NewWorkOrderAdapter(int layoutResId, @Nullable List<WorkOrderListBean.DataBeanX.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WorkOrderListBean.DataBeanX.DataBean item) {

        if ("Y".equals(item.getExtra()) && !"0".equals(item.getExtraTime())) {
            helper.setText(R.id.tv_service, item.getTypeName() + "/" + item.getGuarantee() + "/加急");
        } else {
            helper.setText(R.id.tv_service, item.getTypeName() + "/" + item.getGuarantee());
        }
        helper.addOnClickListener(R.id.iv_specify)
                .addOnClickListener(R.id.iv_transfer)
                .addOnClickListener(R.id.tv_change_state)
                .addOnClickListener(R.id.tv_customer_service);

        helper.setGone(R.id.tv_transfer,false)
                .setGone(R.id.tv_change_person,false)
                .setGone(R.id.tv_mark,false)
                .setGone(R.id.tv_change_time,false)
                .setVisible(R.id.tv_customer_service,true);

        String prod="";
        for (int i = 0; i < item.getProducts().size(); i++) {

            productsBean = item.getProducts().get(i);
            prod+= productsBean.getProductContent()+",";
        }
        if (prod.contains(",")){
            prod = prod.substring(0, prod.lastIndexOf(","));
        }

        helper.setText(R.id.tv_order_num,"工单号："+item.getOrderNumber())
                .setText(R.id.tv_name, prod)
                .setText(R.id.tv_state,item.getState())
                .setText(R.id.tv_billing_account,"发单账号："+item.getInvoiceName())
                .setText(R.id.tv_crate_time,"创建时间："+item.getCreateDate())
                .setText(R.id.tv_address,"地址:"+item.getAddress())
                .setText(R.id.tv_operation,"操作客服:"+item.getTrueName())
                .addOnClickListener(R.id.ll_copy)
                .addOnClickListener(R.id.iv_copy);

    }
}
