package com.zhkj.backstage.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.TrackAdapter;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
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
    private View sendView;
    private AlertDialog senddialog;

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
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                sendView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_refuse, null);
                Button btn_negtive = sendView.findViewById(R.id.negtive);
                Button btn_positive = sendView.findViewById(R.id.positive);
                TextView tv_title = sendView.findViewById(R.id.title);
                EditText tv_message = sendView.findViewById(R.id.message);
                tv_title.setText("提示");
                tv_message.setHint("输入修改的内容");


                btn_negtive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        senddialog.dismiss();
                    }
                });
                btn_positive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String phone=tv_message.getText().toString();
                        if (phone.isEmpty()){
                            ToastUtils.showShort("请输入修改内容");
                            return;
                        }else {
                            senddialog.dismiss();
                            mPresenter.UpdateOrderrecord(list.get(position).getRecordID(),phone);
                        }

                    }
                });

                senddialog = new AlertDialog.Builder(mActivity)
                        .setView(sendView)
                        .create();
                senddialog.show();
            }
        });
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

    @Override
    public void UpdateOrderrecord(BaseResult<Data<String>> baseResult) {
        switch (baseResult.getStatusCode()){
            case 200:
                if (baseResult.getData().isItem1()){
                    ToastUtils.showShort("修改成功");
                    mPresenter.GetOrderRecordByOrderID(mParam1);
                }else {
                    ToastUtils.showShort(baseResult.getData().getItem2());
                }
                break;
        }
    }
}
