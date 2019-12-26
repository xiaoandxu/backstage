package com.zhkj.backstage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.activity.PhotoViewActivity;
import com.zhkj.backstage.adapter.ComplaintDetailAdapter;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.ComplaintList;
import com.zhkj.backstage.contract.ComplaintListContract;
import com.zhkj.backstage.model.ComplaintListModel;
import com.zhkj.backstage.presenter.ComplaintListPresenter;
import com.zhkj.backstage.service.Config;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//投诉信息
public class ComplaintFragment extends BaseLazyFragment<ComplaintListPresenter, ComplaintListModel> implements ComplaintListContract.View {
    private static final String ARG_PARAM1 = "param1";//
    private static final String ARG_PARAM2 = "param2";//
    @BindView(R.id.rv_complaint)
    RecyclerView mRvComplaint;
    private List<ComplaintList> lists = new ArrayList<>();
    private String mParam1;
    private String mParam2;
    private ComplaintDetailAdapter adapter;

    public static ComplaintFragment newInstance(String param1, String param2) {
        ComplaintFragment fragment = new ComplaintFragment();
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
        return R.layout.fragment_complaint;
    }

    @Override
    protected void initData() {
        adapter = new ComplaintDetailAdapter(R.layout.item_complaint_detail, lists);
        mRvComplaint.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvComplaint.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.iv_image:
                        Intent intent = new Intent(mActivity, PhotoViewActivity.class);
                        intent.putExtra("PhotoUrl", Config.ComPlaint_URL + lists.get(position).getPhoto());
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    protected void initView() {
        mPresenter.GetComplaintListByOrderId(mParam1);
    }

    @Override
    protected void setListener() {

    }


    @Override
    public void GetComplaintListByOrderId(BaseResult<List<ComplaintList>> baseResult) {
        switch (baseResult.getStatusCode()){
            case 200:
                if (baseResult.getData()!=null){
                    lists.addAll(baseResult.getData());
                    adapter.setNewData(lists);
                }
                break;
        }
    }
}
