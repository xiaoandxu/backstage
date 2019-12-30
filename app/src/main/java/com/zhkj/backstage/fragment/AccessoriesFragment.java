package com.zhkj.backstage.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.activity.PhotoViewActivity;
import com.zhkj.backstage.adapter.AccessoryDetailAdapter;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.contract.DetailContract;
import com.zhkj.backstage.model.DetailModel;
import com.zhkj.backstage.presenter.DetailPresenter;

import butterknife.BindView;

//配件信息
public class AccessoriesFragment extends BaseLazyFragment<DetailPresenter, DetailModel> implements DetailContract.View {
    private static final String ARG_PARAM1 = "param1";//
    private static final String ARG_PARAM2 = "param2";//
    @BindView(R.id.rv_accessories)
    RecyclerView mRvAccessories;
    private SimpleTarget<Bitmap> simpleTarget;
    private String mParam1;
    private String mParam2;
    private WorkOrder.DataBean data;
    private AccessoryDetailAdapter accessoryDetailAdapter;
    private Intent intent;

    public static AccessoriesFragment newInstance(String param1, String param2) {
        AccessoriesFragment fragment = new AccessoriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
//        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
//        mImmersionBar.statusBarView(mView);
        mImmersionBar.keyboardEnable(true);
        mImmersionBar.init();
    }


    @Override
    protected int setLayoutId() {
        return R.layout.fragment_accessories;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mPresenter.GetOrderInfo(mParam1);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void GetOrderInfo(BaseResult<WorkOrder.DataBean> baseResult) {
        switch (baseResult.getStatusCode()){
            case 200:
                data = baseResult.getData();
                accessoryDetailAdapter = new AccessoryDetailAdapter(R.layout.item_accessories, data.getOrderAccessroyDetail(), data.getAccessoryState());
                mRvAccessories.setLayoutManager(new LinearLayoutManager(mActivity));
                mRvAccessories.setAdapter(accessoryDetailAdapter);
                accessoryDetailAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                    @Override
                    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                        switch (view.getId()) {
                            case R.id.iv_host:
                                if (data.getOrderAccessroyDetail() == null) {
                                    return;
                                }
                                if (data.getOrderAccessroyDetail().size() == 0) {
                                    return;
                                }
                                intent = new Intent(mActivity, PhotoViewActivity.class);
                                intent.putExtra("PhotoUrl","https://img.xigyu.com/Pics/Accessory/" + data.getOrderAccessroyDetail().get(position).getPhoto1());
                                startActivity(intent);
                                break;
                            case R.id.iv_accessories:
                                if (data.getOrderAccessroyDetail() == null) {
                                    return;
                                }
                                if (data.getOrderAccessroyDetail().size() == 0) {
                                    return;
                                }
                                intent=new Intent(mActivity, PhotoViewActivity.class);
                                intent.putExtra("PhotoUrl","https://img.xigyu.com/Pics/Accessory/" + data.getOrderAccessroyDetail().get(position).getPhoto2());
                                startActivity(intent);
                                break;
                        }
                    }
                });

        break;
        }

    }

    @Override
    public void UpdatePhone(BaseResult<Data<String>> baseResult) {

    }

    @Override
    public void CloseOrder(BaseResult<Data<String>> baseResult) {

    }

    @Override
    public void modifyOrderMoney(BaseResult<Data<String>> baseResult) {

    }

    @Override
    public void ChangeOrderStateTwenty(BaseResult<Data<String>> baseResult) {

    }


}
