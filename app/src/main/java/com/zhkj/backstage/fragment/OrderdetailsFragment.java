package com.zhkj.backstage.fragment;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.TrackAdapter;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Track;
import com.zhkj.backstage.contract.TrackContract;
import com.zhkj.backstage.model.TrackModel;
import com.zhkj.backstage.presenter.TrackPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//订单记录
public class OrderdetailsFragment extends BaseLazyFragment<TrackPresenter, TrackModel> implements TrackContract.View {
    private static final String ARG_PARAM1 = "param1";//
    private static final String ARG_PARAM2 = "param2";//
    @BindView(R.id.track_rv)
    RecyclerView mTrackRv;

    private String mParam1;
    private String mParam2;
    private TrackAdapter adapter;
    private List<Track> list=new ArrayList<>();
    public static OrderdetailsFragment newInstance(String param1, String param2) {
        OrderdetailsFragment fragment = new OrderdetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    protected int setLayoutId() {
        return R.layout.fragment_order_detail;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mPresenter.GetOrderRecordByOrderID(mParam1);

//        Divideritemdecoration divideritemdecoration=new Divideritemdecoration(mActivity);
//        mTrackRv.addItemDecoration(divideritemdecoration);

        adapter = new TrackAdapter(R.layout.item_track, list);
        mTrackRv.setLayoutManager(new LinearLayoutManager(mActivity));
        mTrackRv.setAdapter(adapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void GetOrderRecordByOrderID(BaseResult<List<Track>> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                list=baseResult.getData();
                adapter.setNewData(list);
                break;
            case 401:
                break;
        }
    }
}
