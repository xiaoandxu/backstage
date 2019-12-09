package com.zhkj.backstage.fragment.person;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BankCard;
import com.zhkj.backstage.bean.CompanyInfo;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.GetIDCardImg;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.contract.PersonalInformationCotract;
import com.zhkj.backstage.model.PersonalInformationModel;
import com.zhkj.backstage.presenter.PersonalInformationPresenter;

import java.util.List;

import butterknife.BindView;

//个人信息
public class PersonalInformationFragment extends BaseLazyFragment<PersonalInformationPresenter, PersonalInformationModel> implements PersonalInformationCotract.View,View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";//
    private static final String ARG_PARAM2 = "param2";//
    @BindView(R.id.tv_username)
    TextView mTvUsername;
    @BindView(R.id.tv_nickname)
    TextView mTvNickname;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.tv_true_name)
    TextView mTvTrueName;
    @BindView(R.id.tv_card)
    TextView mTvCard;
    @BindView(R.id.tv_parent)
    TextView mTvParent;
    @BindView(R.id.tv_company_name)
    TextView mTvCompanyName;
    @BindView(R.id.tv_business_license)
    TextView mTvBusinessLicense;
    @BindView(R.id.tv_consumer_hotline)
    TextView mTvConsumerHotline;
    @BindView(R.id.tv_manage_names)
    TextView mTvManageNames;
    @BindView(R.id.tv_manage_phone)
    TextView mTvManagePhone;
    @BindView(R.id.tv_financial_call)
    TextView mTvFinancialCall;
    @BindView(R.id.tv_total_amount)
    TextView mTvTotalAmount;
    @BindView(R.id.tv_frozen_funds)
    TextView mTvFrozenFunds;
    @BindView(R.id.tv_available_funds)
    TextView mTvAvailableFunds;
    @BindView(R.id.tv_sincerity_gold)
    TextView mTvSincerityGold;
    @BindView(R.id.tv_frozen_sincerity_gold)
    TextView mTvFrozenSincerityGold;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.tv_roles)
    TextView mTvRoles;
    @BindView(R.id.tv_last_login_time)
    TextView mTvLastLoginTime;
    @BindView(R.id.tv_creation_time)
    TextView mTvCreationTime;
    @BindView(R.id.btn_refuse)
    Button mBtnRefuse;
    @BindView(R.id.btn_pass)
    Button mBtnPass;
    @BindView(R.id.tv_certification)
    TextView mTvCertification;
    @BindView(R.id.ll_verified)
    LinearLayout mLlVerified;

    private String mParam1;
    private String mParam2;
    private String userId;
    private UserInfoList.DataBean detail;
    private CompanyInfo companyDean;
    private View view;
    private AlertDialog dialog;

    public static PersonalInformationFragment newInstance(String param1, String param2) {
        PersonalInformationFragment fragment = new PersonalInformationFragment();
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
        return R.layout.fragment_personal_information;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        userId = mParam1;
        mPresenter.GetUserInfo(userId, "1");
    }

    @Override
    protected void setListener() {
        mBtnRefuse.setOnClickListener(this);
        mBtnPass.setOnClickListener(this);
    }

    @Override
    public void GetUserInfo(BaseResult<UserInfoList> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                if (baseResult.getData().getData() != null) {
                    detail = baseResult.getData().getData().get(0);
                    mTvUsername.setText(detail.getUserID());
                    if ("1".equals(detail.getIfAuth())) {
                        mTvCertification.setText("认证成功");
                    } else {
                        mTvCertification.setText("未认证");
                    }

                    mTvNickname.setText(detail.getNickName());
                    mTvPhone.setText(detail.getPhone());
                    mTvTrueName.setText(detail.getTrueName());
                    mTvCard.setText(detail.getIDCard());
                    mTvParent.setText(detail.getParentUserID());
                    if ("6".equals(detail.getType())) {
                        mPresenter.GetmessageBytype(userId);
                    }
                    mTvTotalAmount.setText(detail.getTotalMoney() + "");
                    mTvFrozenFunds.setText(detail.getFrozenMoney() + "");
                    mTvAvailableFunds.setText(detail.getRemainMoney() + "");
                    mTvSincerityGold.setText(detail.getDepositMoney() + "");
                    mTvFrozenSincerityGold.setText(detail.getDepositFrozenMoney() + "");
                    mTvAddress.setText(detail.getAddress());
                    if ("6".equals(detail.getType())) {
                        mTvType.setText("加盟公司");
                    } else if ("7".equals(detail.getType())) {
                        mTvType.setText("加盟维修");
                    }
                    mTvRoles.setText(detail.getRoleName());
                    mTvCreationTime.setText(detail.getCreateDate());
                    mTvLastLoginTime.setText(detail.getLastLoginDate());
                    if ("0".equals(detail.getIfAuth())){
                        mLlVerified.setVisibility(View.VISIBLE);
                    }else {
                        mLlVerified.setVisibility(View.GONE);
                    }
                }
                break;
        }
    }

    @Override
    public void GetmessageBytype(BaseResult<Data<CompanyInfo>> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                if (baseResult.getData().isItem1()) {
                    companyDean = baseResult.getData().getItem2();
                    mTvCompanyName.setText(companyDean.getCompanyName());
                    mTvBusinessLicense.setText(companyDean.getCompanyNum());
                    mTvConsumerHotline.setText(companyDean.getServicePhone());
                    mTvManageNames.setText(companyDean.getManagyName());
                    mTvManagePhone.setText(companyDean.getManagyPhone());
                    mTvFinancialCall.setText(companyDean.getFinancePhone());
                }
                break;
        }
    }

    @Override
    public void GetIDCardImg(BaseResult<List<GetIDCardImg>> baseResult) {

    }

    @Override
    public void GetAccountPayInfoList(BaseResult<List<BankCard>> baseResult) {

    }

    @Override
    public void ApproveAuth(BaseResult<Data<String>> baseResult) {
        switch (baseResult.getStatusCode()){
            case 200:
                ToastUtils.showShort("审核完成");
                mPresenter.GetUserInfo(userId,"1");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pass:
                mPresenter.ApproveAuth(userId,"1","");
                break;
            case R.id.btn_refuse:
                view = LayoutInflater.from(mActivity).inflate(R.layout.dialog_refuse, null);
                Button btn_negtive = view.findViewById(R.id.negtive);
                Button btn_positive = view.findViewById(R.id.positive);
                TextView tv_title = view.findViewById(R.id.title);
                EditText message = view.findViewById(R.id.message);
                tv_title.setText("提示");
                btn_negtive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btn_positive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String reason=message.getText().toString();
                        if (reason.isEmpty()){
                            ToastUtils.showShort("请输入拒绝理由");
                            return;
                        }else {
                            mPresenter.ApproveAuth(userId,"-1",reason);
                        }
                        dialog.dismiss();
                    }
                });

                dialog = new AlertDialog.Builder(mActivity)
                        .setView(view)
                        .create();
                dialog.show();
                break;
        }
    }
}
