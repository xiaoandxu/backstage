package com.zhkj.backstage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.VendorListAdapter;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.AddrList;
import com.zhkj.backstage.bean.GetUserInfoListForPlatformResult;
import com.zhkj.backstage.bean.GetUserInfoPartListBakBean;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.bean.worker;
import com.zhkj.backstage.mvp.contract.VendorListContract;
import com.zhkj.backstage.mvp.model.VendorListModel;
import com.zhkj.backstage.mvp.presenter.VendorListPresenter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class VendorListActivity extends BaseActivity<VendorListPresenter, VendorListModel> implements View.OnClickListener, VendorListContract.View {
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.rv_verdor)
    RecyclerView mRvVerdor;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private String type;
    private int page = 1;
    private List<UserInfoList.DataBean> list = new ArrayList<>();
    private VendorListAdapter adapter;
    private String day;
    private String data;
    private String provinceCode;
    private GetUserInfoPartListBakBean getUserInfoPartListBakBean;
    private String provinceName;

    @Override
    public void GetUserInfoListForPlatform(GetUserInfoListForPlatformResult baseResult) {

    }

    @Override
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
//        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
        mImmersionBar.statusBarView(mView);
        mImmersionBar.keyboardEnable(true);
        mImmersionBar.init();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_vendor_list;
    }

    @Override
    protected void initData() {
        adapter = new VendorListAdapter(R.layout.item_vendor, list);
        mRvVerdor.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvVerdor.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mActivity, PersonalInformationActivity.class);
                intent.putExtra("userId", list.get(position).getUserID());
                startActivity(intent);
            }
        });

        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                getData();
                mRefreshLayout.finishRefresh(1000);
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                getData();
                mRefreshLayout.finishLoadMore(1000);
            }
        });
    }

    @Override
    protected void initView() {
        type = getIntent().getStringExtra("type");
        day = getIntent().getStringExtra("day");
        provinceCode = getIntent().getStringExtra("provinceCode");
        provinceName = getIntent().getStringExtra("provinceName");
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        data = dateformat.format(date);

        if ("6".equals(type) && "no".equals(day)) {
            mTvTitle.setText("厂商入驻待审核");
        } else if ("7".equals(type) && "no".equals(day)) {
            mTvTitle.setText("师傅入驻待审核");
        } else if ("tp".equals(day)) {
            mTvTitle.setText("今日入驻厂商");
        } else if ("yp".equals(day)) {
            mTvTitle.setText("昨日入驻厂商");
        } else if ("tm".equals(day)) {
            mTvTitle.setText("今日入驻师傅");
        } else if ("ym".equals(day)) {
            mTvTitle.setText("昨日入驻师傅");
        }else{
            mTvTitle.setText("所有师傅");
        }
        showProgress();
        getData();

    }

    private void getData() {
        if ("6".equals(type) && "no".equals(day)) {
            mPresenter.GetUserInfoList(type, "0", "", "", String.valueOf(page), "10");
        } else if ("7".equals(type) && "no".equals(day)) {
            mPresenter.GetUserInfoList(type, "0", "", "", String.valueOf(page), "10");
        } else if ("tp".equals(day)) {
            mPresenter.GetUserInfoList(type, "",getStringByFormat(getTimesmorning()) , getStringByFormat(getTimesmorning()), String.valueOf(page), "10");
        } else if ("yp".equals(day)) {
            mPresenter.GetUserInfoList(type, "", getStringByFormat(getYesterdaysmorning()), getStringByFormat(getYesterdaysmorning()), String.valueOf(page), "10");
        } else if ("tm".equals(day)) {
            mPresenter.GetUserInfoList(type, "", getStringByFormat(getTimesmorning()), getStringByFormat(getTimesmorning()), String.valueOf(page), "10");
        } else if ("ym".equals(day)) {
            mPresenter.GetUserInfoList(type, "",  getStringByFormat(getYesterdaysmorning()), getStringByFormat(getYesterdaysmorning()), String.valueOf(page), "10");
        }else{
            Gson gson=new Gson();
            getUserInfoPartListBakBean = new GetUserInfoPartListBakBean();
            getUserInfoPartListBakBean.setType("7");
            getUserInfoPartListBakBean.setPage(page+"");
            getUserInfoPartListBakBean.setLimit("15");
            getUserInfoPartListBakBean.setProvinceCode(provinceCode);
            String s = gson.toJson(getUserInfoPartListBakBean);
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), s);
            mPresenter.GetUserInfoPartList(body);
        }
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void GetUserInfoList(BaseResult<UserInfoList> baseResult) {
        if (page==1){
            list.clear();
        }
        list.addAll(baseResult.getData().getData());
        if (type==null){
            mTvTitle.setText("所有师傅("+baseResult.getData().getCount()+")");
        }
        adapter.setNewData(list);
        hideProgress();
    }

    @Override
    public void GetUserInfoPartList(BaseResult<UserInfoList> baseResult) {
        if (page==1){
            list.clear();
        }
        list.addAll(baseResult.getData().getData());
        if (type==null){
            if(mTvTitle==null){
                return;
            }
            mTvTitle.setText(provinceName +"("+baseResult.getData().getCount()+")");
        }
        adapter.setNewData(list);
        hideProgress();
    }

    @Override
    public void GetProvinceMasterDistance(BaseResult<AddrList> baseResult) {

    }

    @Override
    public void GetProvinceMasterList(BaseResult<worker> baseResult) {

    }

    // 获得当天0点时间
    public static Date getTimesmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static String getStringByFormat(Date date) {
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = null;
        try {
            strDate = mSimpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDate;
    }

    // 获得昨日0点时间
    public static Date getYesterdaysmorning() {

        Calendar cal = Calendar.getInstance();
        cal.add(cal.DATE, -1);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);


//        Date date = new Date();//取时间
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(date);
//        calendar.add(calendar.DATE, -1);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
//        date = calendar.getTime();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        String dateString = formatter.format(date);
//
//        calendar.setTime(date);
//        calendar.set(Calendar.HOUR, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(String message) {
        if ("审核完成".equals(message)){
            list.clear();
            getData();
        }
    }
}
