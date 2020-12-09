package com.zhkj.backstage.fragment.person;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.activity.CateListActivity;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.BankCard;
import com.zhkj.backstage.bean.CompanyInfo;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.FactoryToll;
import com.zhkj.backstage.bean.GetIDCardImg;
import com.zhkj.backstage.bean.GetSecondCategoryListResult;
import com.zhkj.backstage.bean.UpdateFactroyUserResult;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.mvp.contract.PersonalInformationCotract;
import com.zhkj.backstage.mvp.model.PersonalInformationModel;
import com.zhkj.backstage.mvp.presenter.PersonalInformationPresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;

//个人信息
public class PersonalInformationFragment extends BaseLazyFragment<PersonalInformationPresenter, PersonalInformationModel> implements PersonalInformationCotract.View, View.OnClickListener {
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
    @BindView(R.id.et_initmoney)
    EditText mEtInitmoney;
    @BindView(R.id.et_againmoney)
    EditText mEtAgainmoney;
    @BindView(R.id.et_platformmoney)
    EditText mEtPlatformmoney;
    @BindView(R.id.switcher_work_order_barcode)
    Switch mSwitcherWorkOrderBarcode;
    @BindView(R.id.ll_company)
    LinearLayout mLlCompany;
    @BindView(R.id.ll_choose)
    LinearLayout mLlChoose;
    @BindView(R.id.tv_choose)
    TextView mTvChoose;
    @BindView(R.id.iv_allprice)
    ImageView mIvAllprice;
    @BindView(R.id.ll_allprice_s)
    LinearLayout mLlAllpriceS;
    @BindView(R.id.iv_gg)
    ImageView mIvGg;
    @BindView(R.id.ll_gg_s)
    LinearLayout mLlGgS;
    @BindView(R.id.et_allprice)
    EditText mEtAllprice;
    @BindView(R.id.ll_allprice)
    LinearLayout mLlAllprice;

    private String mParam1;
    private String mParam2;
    private String userId;
    private UserInfoList.DataBean detail;
    private CompanyInfo companyDean;
    private View view;
    private AlertDialog dialog;
    private List<GetSecondCategoryListResult.DataBeanX.DataBean> list;
    private String names = "";
    private String values = "";
    private String Type="2";

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

        mIvAllprice.setSelected(false);
        mIvGg.setSelected(true);
        mLlAllprice.setVisibility(View.GONE);
    }

    @Override
    protected void setListener() {
        mBtnRefuse.setOnClickListener(this);
        mBtnPass.setOnClickListener(this);
        mLlChoose.setOnClickListener(this);
        mLlAllpriceS.setOnClickListener(this);
        mLlGgS.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_allprice_s://单价格收费
                mIvAllprice.setSelected(true);
                mIvGg.setSelected(false);
                mLlAllprice.setVisibility(View.VISIBLE);
                Type ="1";
                break;
            case R.id.ll_gg_s://规格配置收费
                mIvAllprice.setSelected(false);
                mIvGg.setSelected(true);
                mLlAllprice.setVisibility(View.GONE);
                Type ="2";
                break;
            case R.id.btn_pass:
                if ("6".equals(detail.getType())) {
                    String DoorFee = mEtInitmoney.getText().toString();
                    String AgainMoney = mEtAgainmoney.getText().toString();
                    String PlatformFee = mEtPlatformmoney.getText().toString();
                    String Allprice = mEtAllprice.getText().toString();
                    if (DoorFee.isEmpty()) {
                        ToastUtils.showShort("请设置上门费");
                        return;
                    }
                    if (AgainMoney.isEmpty()) {
                        ToastUtils.showShort("请设置二次上门费");
                        return;
                    }
                    if (PlatformFee.isEmpty()) {
                        ToastUtils.showShort("请设置平台费");
                        return;
                    }
                    if ("1".equals(Type)){
                        if (Allprice.isEmpty()) {
                            ToastUtils.showShort("请设置单价格费用");
                            return;
                        }
                    }else{
                        Allprice="0";
                    }
                    if ("".equals(values)) {
                        ToastUtils.showShort("请绑定产品");
                        return;
                    }
                    FactoryToll fac=new FactoryToll(Type,Allprice);
                    detail.setFactoryToll(fac);
                    detail.setDoorFee(Double.parseDouble(DoorFee));
                    detail.setAgainMoney(Double.parseDouble(AgainMoney));
                    detail.setPlatformFee(Double.parseDouble(PlatformFee));
                    detail.setSelect(values);
                    Gson gson = new Gson();
                    String s = gson.toJson(detail);
                    RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), s);
                    mPresenter.UpdateFactroyUser(body);
                } else if ("7".equals(detail.getType())) {
                    mPresenter.ApproveAuth(userId, "1", "");
                }

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
                        String reason = message.getText().toString();
                        if (reason.isEmpty()) {
                            ToastUtils.showShort("请输入拒绝理由");
                            return;
                        } else {
                            mPresenter.ApproveAuth(userId, "-1", reason);
                        }
                        dialog.dismiss();
                    }
                });

                dialog = new AlertDialog.Builder(mActivity)
                        .setView(view)
                        .create();
                dialog.show();
                break;
            case R.id.ll_choose:
                startActivityForResult(new Intent(mActivity, CateListActivity.class), 100);
                break;
        }
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

                    mEtInitmoney.setText(detail.getDoorFee() + "");
                    mEtAgainmoney.setText(detail.getAgainMoney() + "");
                    mEtPlatformmoney.setText(detail.getPlatformFee() + "");
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
                        mLlCompany.setVisibility(View.VISIBLE);
                    } else if ("7".equals(detail.getType())) {
                        mTvType.setText("加盟维修");
                        mLlCompany.setVisibility(View.GONE);
                    }
                    mTvRoles.setText(detail.getRoleName());
                    mTvCreationTime.setText(detail.getCreateDate());
                    mTvLastLoginTime.setText(detail.getLastLoginDate());
                    if ("0".equals(detail.getIfAuth())) {
                        mLlVerified.setVisibility(View.VISIBLE);
                    } else {
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
        switch (baseResult.getStatusCode()) {
            case 200:
                if (baseResult.getData().isItem1()) {
                    ToastUtils.showShort("审核完成");
                    EventBus.getDefault().post("审核完成");
                    mActivity.finish();
                } else {
                    ToastUtils.showShort(baseResult.getData().getItem2());
                }
                break;
        }
    }

    @Override
    public void UpdateFactroyUser(UpdateFactroyUserResult baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                if (baseResult.getData().isItem1()) {
                    mPresenter.ApproveAuth(userId, "1", "");
                } else {
                    ToastUtils.showShort(baseResult.getData().getItem2());
                }
                break;
        }
    }

    @Override
    public void GetSecondCategoryList(GetSecondCategoryListResult baseResult) {

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 100) {
            if (data != null) {
                list = (List<GetSecondCategoryListResult.DataBeanX.DataBean>) data.getSerializableExtra("list");
                names = "";
                values = "";
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).isCheck()) {
                        names += list.get(i).getName() + ",";
                        values += list.get(i).getValue() + ",";
                    }
                }
                if (names.contains(",")) {
                    names = names.substring(0, names.lastIndexOf(","));
                }
                if (values.contains(",")) {
                    values = values.substring(0, values.lastIndexOf(","));
                }
                mTvChoose.setText(names);
            }
        }
    }
}
