package com.zhkj.backstage.adapter;


import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhkj.backstage.R;
import com.zhkj.backstage.bean.GetCustomService;

import java.util.List;

import io.reactivex.annotations.Nullable;

/*选择子账号的adapter*/
public class Redeploy_Adapter extends BaseQuickAdapter<GetCustomService, BaseViewHolder> {
private Context context;

    public Redeploy_Adapter(int layoutResId, @Nullable List<GetCustomService> data, Context context) {
        super(layoutResId, data);
        this.context=context;
    }



    @Override
    protected void convert(BaseViewHolder helper, GetCustomService item) {

        if (item.isSelect()==false){//未选中
          helper.setVisible(R.id.img_redeploy_unselect,true);
          helper.setVisible(R.id.img_redeploy_select,false);

        }else {//选中
            helper.setVisible(R.id.img_redeploy_unselect,false);
            helper.setVisible(R.id.img_redeploy_select,true);

        }
        helper.setText(R.id.tv_subaccount_name,item.getName()+"("+item.getTrueName()+")");


        //helper.addOnClickListener(R.id.img_redeploy_unselect);
        //helper.addOnClickListener(R.id.img_redeploy_select);
       helper.addOnClickListener(R.id.rl_item_redeploy);

    }
}
