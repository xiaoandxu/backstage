package com.zhkj.backstage.adapter;


import android.content.Context;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.GetCustomService;
import com.zhkj.backstage.bean.GetCustomService2;

import java.util.List;

import io.reactivex.annotations.Nullable;

/*选择子账号的adapter*/
public class Redeploy_Adapter extends BaseQuickAdapter<GetCustomService2, BaseViewHolder> {
private Context context;

    public Redeploy_Adapter(int layoutResId, @Nullable List<GetCustomService2> data, Context context) {
        super(layoutResId, data);
        this.context=context;
    }



    @Override
    protected void convert(BaseViewHolder helper, GetCustomService2 item) {

        if (item.isSelect()==false){//未选中
          helper.setVisible(R.id.img_redeploy_unselect,true);
          helper.setVisible(R.id.img_redeploy_select,false);

        }else {//选中
            helper.setVisible(R.id.img_redeploy_unselect,false);
            helper.setVisible(R.id.img_redeploy_select,true);

        }
        helper.setText(R.id.tv_subaccount_name,item.getName());


        //helper.addOnClickListener(R.id.img_redeploy_unselect);
        //helper.addOnClickListener(R.id.img_redeploy_select);
       helper.addOnClickListener(R.id.rl_item_redeploy);

    }
}
