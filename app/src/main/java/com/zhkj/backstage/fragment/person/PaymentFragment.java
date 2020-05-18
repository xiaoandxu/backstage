package com.zhkj.backstage.fragment.person;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.adapter.PaymentAdapter;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BankCard;
import com.zhkj.backstage.bean.CompanyInfo;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetIDCardImg;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.mvp.contract.PersonalInformationCotract;
import com.zhkj.backstage.mvp.model.PersonalInformationModel;
import com.zhkj.backstage.mvp.presenter.PersonalInformationPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

//支付管理
public class PaymentFragment extends BaseLazyFragment<PersonalInformationPresenter, PersonalInformationModel> implements PersonalInformationCotract.View {
    private static final String ARG_PARAM1 = "param1";//
    private static final String ARG_PARAM2 = "param2";//
    @BindView(R.id.rv_payment)
    RecyclerView mRvPayment;

    private String mParam1;
    private String mParam2;
    private String userId;
    private List<BankCard> list=new ArrayList<>();
    private PaymentAdapter adapter;

    public static PaymentFragment newInstance(String param1, String param2) {
        PaymentFragment fragment = new PaymentFragment();
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
        return R.layout.fragment_payment;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        userId = mParam1;
        mPresenter.GetAccountPayInfoList(userId);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void GetUserInfo(BaseResult<UserInfoList> baseResult) {

    }

    @Override
    public void GetmessageBytype(BaseResult<Data<CompanyInfo>> baseResult) {

    }

    @Override
    public void GetIDCardImg(BaseResult<List<GetIDCardImg>> baseResult) {

    }

    @Override
    public void GetAccountPayInfoList(BaseResult<List<BankCard>> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                if (baseResult.getData() == null) {
                    return;
                } else {
                    for (int i = 0; i < baseResult.getData().size(); i++) {
                        if ("Y".equals(baseResult.getData().get(i).getIsUse())){
                            list.add(baseResult.getData().get(i));
                        }
                    }

                    adapter = new PaymentAdapter(R.layout.item_payment,list);
                    mRvPayment.setLayoutManager(new LinearLayoutManager(mActivity));
                    mRvPayment.setAdapter(adapter);
                }
                break;
        }
    }

    @Override
    public void ApproveAuth(BaseResult<Data<String>> baseResult) {

    }
}
