package com.zhkj.backstage.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.GAccessory;
import com.zhkj.backstage.bean.WorkOrder;

import java.util.List;

public class AccessoryDetailAdapter extends BaseQuickAdapter<GAccessory, BaseViewHolder> {
    private String AccessoryState;
    public AccessoryDetailAdapter(int layoutResId, @Nullable List<GAccessory> data,String AccessoryState) {
        super(layoutResId, data);
        this.AccessoryState=AccessoryState;
    }

    @Override
    protected void convert(BaseViewHolder helper, GAccessory item) {
        String time=item.getCreateTime().replace("T"," ");
        helper.setText(R.id.tv_accessories_name,item.getFAccessoryName())
                .setText(R.id.tv_crate_time,time)
                .setText(R.id.tv_shipment_number,item.getExpressNo());
        Glide.with(mContext).load("https://img.xigyu.com/Pics/Accessory/"+item.getPhoto1()).into((ImageView) helper.getView(R.id.iv_host));
        Glide.with(mContext).load("https://img.xigyu.com/Pics/Accessory/"+item.getPhoto2()).into((ImageView) helper.getView(R.id.iv_accessories));
        if ("0".equals(AccessoryState)){
            helper.setText(R.id.tv_accessories_number,item.getQuantity()+"个");
        }else {
            helper.setText(R.id.tv_accessories_number,"¥"+item.getDiscountPrice()+"/"+item.getQuantity()+"个");
        }
        helper.addOnClickListener(R.id.iv_accessories);
        helper.addOnClickListener(R.id.iv_host);
        if ("Y".equals(item.getNeedPlatformAuth())){
            helper.setGone(R.id.ll_accessories,false);
        }

    }
}
