package com.zhkj.backstage.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.contract.DetailContract;
import com.zhkj.backstage.model.DetailModel;
import com.zhkj.backstage.presenter.DetailPresenter;
import com.zhkj.backstage.weight.CommonDialog_Home;

import butterknife.BindView;

//工单详情
public class DetailsFragment extends BaseLazyFragment<DetailPresenter, DetailModel> implements DetailContract.View ,View.OnClickListener{
    private static final String ARG_PARAM1 = "param1";//
    private static final String ARG_PARAM2 = "param2";//
    @BindView(R.id.tv_customer_name)
    TextView mTvCustomerName;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.tv_service_type)
    TextView mTvServiceType;
    @BindView(R.id.tv_brand)
    TextView mTvBrand;
    @BindView(R.id.tv_model)
    TextView mTvModel;
    @BindView(R.id.tv_description)
    TextView mTvDescription;
    @BindView(R.id.tv_fault_description)
    TextView mTvFaultDescription;
    @BindView(R.id.tv_receiver)
    TextView mTvReceiver;
    @BindView(R.id.tv_send_user)
    TextView mTvSendUser;
    @BindView(R.id.tv_recorder)
    TextView mTvRecorder;
    @BindView(R.id.tv_expedited)
    TextView mTvExpedited;
    @BindView(R.id.tv_expedited_time)
    TextView mTvExpeditedTime;
    @BindView(R.id.tv_expedited_free)
    TextView mTvExpeditedFree;
    @BindView(R.id.tv_remote_fee)
    TextView mTvRemoteFee;
    @BindView(R.id.tv_exceeding_kilometers)
    TextView mTvExceedingKilometers;
    @BindView(R.id.tv_approval_status)
    TextView mTvApprovalStatus;
    @BindView(R.id.tv_amount_of_accessories)
    TextView mTvAmountOfAccessories;
    @BindView(R.id.tv_accessory_status)
    TextView mTvAccessoryStatus;
    @BindView(R.id.tv_accessory_review)
    TextView mTvAccessoryReview;
    @BindView(R.id.tv_shipment_number)
    TextView mTvShipmentNumber;
    @BindView(R.id.tv_return_information)
    TextView mTvReturnInformation;
    @BindView(R.id.tv_arrival)
    TextView mTvArrival;
    @BindView(R.id.tv_arrival_number)
    TextView mTvArrivalNumber;
    @BindView(R.id.tv_platform_amount)
    TextView mTvPlatformAmount;
    @BindView(R.id.tv_order_amount)
    TextView mTvOrderAmount;
    @BindView(R.id.tv_creation_time)
    TextView mTvCreationTime;
    @BindView(R.id.tv_order_time)
    TextView mTvOrderTime;
    @BindView(R.id.tv_end_time)
    TextView mTvEndTime;
    @BindView(R.id.tv_evaluation_time)
    TextView mTvEvaluationTime;
    @BindView(R.id.btn_close)
    Button mBtnClose;
    @BindView(R.id.btn_abolish)
    Button mBtnAbolish;
    @BindView(R.id.btn_modify)
    Button mBtnModify;
    @BindView(R.id.btn_finish)
    Button mBtnFinish;
    @BindView(R.id.btn_change_phone)
    Button mBtnChangePhone;

    private String orderId;
    private String mParam1;
    private String mParam2;
    private WorkOrder.DataBean detail;
    private View sendView;
    private AlertDialog senddialog;
    private Button btn_negtive;
    private Button btn_positive;
    private TextView tv_title;
    private EditText tv_message;
    private SPUtils spUtils;
    private String userId;

    public static DetailsFragment newInstance(String param1, String param2) {
        DetailsFragment fragment = new DetailsFragment();
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
        return R.layout.fragment_details;
    }

    @Override
    protected void initData() {
        spUtils = SPUtils.getInstance("token");
        userId = spUtils.getString("userName");
    }

    @Override
    protected void initView() {
        orderId = mParam1;
        mPresenter.GetOrderInfo(orderId);
    }

    @Override
    protected void setListener() {
        mBtnChangePhone.setOnClickListener(this);
        mBtnClose.setOnClickListener(this);
        mBtnAbolish.setOnClickListener(this);
        mBtnModify.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_change_phone:
                sendView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_refuse, null);
                btn_negtive = sendView.findViewById(R.id.negtive);
                btn_positive = sendView.findViewById(R.id.positive);
                tv_title = sendView.findViewById(R.id.title);
                tv_message = sendView.findViewById(R.id.message);
                tv_title.setText("提示");
                tv_message.setHint("输入修改的手机号");


                btn_negtive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        senddialog.dismiss();
                    }
                });
                btn_positive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String phone= tv_message.getText().toString();
                        if (phone.isEmpty()){
                            ToastUtils.showShort("请输入手机号");
                            return;
                        }else {
                            senddialog.dismiss();
                            mPresenter.UpdatePhone(orderId,phone);
                        }

                    }
                });

                senddialog = new AlertDialog.Builder(mActivity)
                        .setView(sendView)
                        .create();
                senddialog.show();
                break;
            case R.id.btn_close:
                sendView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_refuse, null);
                btn_negtive = sendView.findViewById(R.id.negtive);
                btn_positive = sendView.findViewById(R.id.positive);
                tv_title = sendView.findViewById(R.id.title);
                tv_message = sendView.findViewById(R.id.message);
                tv_title.setText("提示");
                tv_message.setHint("输入结算金额");
                btn_negtive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        senddialog.dismiss();
                    }
                });
                btn_positive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String phone= tv_message.getText().toString();
                        if (phone.isEmpty()){
                            ToastUtils.showShort("请输入结算金额");
                            return;
                        }else {
                            senddialog.dismiss();
                            mPresenter.CloseOrder(orderId,"1",phone,userId);
                        }

                    }
                });

                senddialog = new AlertDialog.Builder(mActivity)
                        .setView(sendView)
                        .create();
                senddialog.show();
                break;
            case R.id.btn_abolish:
                CommonDialog_Home reject = new CommonDialog_Home(mActivity);
                reject.setMessage("是否废除工单")

                        //.setImageResId(R.mipmap.ic_launcher)
                        .setTitle("提示")
                        .setSingle(false).setOnClickBottomListener(new CommonDialog_Home.OnClickBottomListener() {
                    @Override
                    public void onPositiveClick() {
                        reject.dismiss();
                        mPresenter.CloseOrder(orderId,"2","",userId);
                    }

                    @Override
                    public void onNegtiveClick() {//取消
                        reject.dismiss();
                        // Toast.makeText(MainActivity.this,"ssss",Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.btn_modify:
                sendView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_refuse, null);
                btn_negtive = sendView.findViewById(R.id.negtive);
                btn_positive = sendView.findViewById(R.id.positive);
                tv_title = sendView.findViewById(R.id.title);
                tv_message = sendView.findViewById(R.id.message);
                tv_title.setText("提示");
                tv_message.setHint("输入修改金额");
                btn_negtive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        senddialog.dismiss();
                    }
                });
                btn_positive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String phone= tv_message.getText().toString();
                        if (phone.isEmpty()){
                            ToastUtils.showShort("请输入修改金额");
                            return;
                        }else {
                            senddialog.dismiss();
                            mPresenter.modifyOrderMoney(orderId,phone,userId);
                        }

                    }
                });

                senddialog = new AlertDialog.Builder(mActivity)
                        .setView(sendView)
                        .create();
                senddialog.show();
                break;

        }
    }


    @Override
    public void GetOrderInfo(BaseResult<WorkOrder.DataBean> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                if (baseResult != null) {
                    detail = baseResult.getData();
                    mTvCustomerName.setText(detail.getUserName() + "     " + detail.getPhone());
                    mTvAddress.setText(detail.getAddress());
                    mTvServiceType.setText("服务类型：" + detail.getTypeName() + "/" + detail.getGuarantee());
                    mTvBrand.setText("品      牌：" + detail.getBrandName());
                    mTvModel.setText("型      号：" + detail.getProductType());
                    if ("1".equals(detail.getTypeID())) {
                        mTvDescription.setText("故障描述");
                    } else if ("2".equals(detail.getTypeID())) {
                        mTvDescription.setText("安装备注");
                    } else {
                        mTvDescription.setText("故障描述");
                    }

                    mTvFaultDescription.setText(detail.getMemo());
                    if (detail.getSendUser() == null) {
                        mTvReceiver.setText("未找到师傅");
                    } else {
                        mTvReceiver.setText(detail.getSendUser());
                    }

                    mTvSendUser.setText(detail.getUserID());
                    if (detail.getLoginUser() == null) {
                        mTvRecorder.setText("暂未派单");
                    } else {
                        mTvRecorder.setText(detail.getLoginUser());
                    }

                    if ("N".equals(detail.getExtra())) {
                        mTvExpedited.setText("否");

                    } else {
                        mTvExpedited.setText("是");
                    }
                    mTvExpeditedTime.setText(detail.getExtraTime());
                    mTvExpeditedFree.setText(detail.getExtraFee());
                    mTvRemoteFee.setText(detail.getBeyondMoney());
                    mTvExceedingKilometers.setText(detail.getBeyondDistance());
                    if (detail.getBeyondState() == null) {
                        mTvApprovalStatus.setText("未申请远程费");
                    } else if ("0".equals(detail.getBeyondState())) {
                        mTvApprovalStatus.setText("待审核");
                    } else if ("1".equals(detail.getBeyondState())) {
                        mTvApprovalStatus.setText("审核通过");
                    } else if ("-1".equals(detail.getBeyondState())) {
                        mTvApprovalStatus.setText("审核拒绝");
                    } else if ("2".equals(detail.getBeyondState())) {
                        mTvApprovalStatus.setText("修改价格");
                    }
//
                    mTvAmountOfAccessories.setText(detail.getAccessoryMoney());
                    if (detail.getAccessoryState() == null) {
                        mTvAccessoryStatus.setText("未申请配件");
                    } else if ("0".equals(detail.getAccessoryState())) {
                        mTvAccessoryStatus.setText("厂家寄件");
                    } else if ("1".equals(detail.getAccessoryState())) {
                        mTvAccessoryStatus.setText("师傅自购件申请");
                    }

                    if (detail.getAccessoryApplyState() == null) {
                        mTvAccessoryReview.setText("未申请配件");
                    } else if ("0".equals(detail.getAccessoryApplyState())) {
                        mTvAccessoryReview.setText("待审核");
                    } else if ("1".equals(detail.getAccessoryApplyState())) {
                        mTvAccessoryReview.setText("审核通过");
                    } else if ("-1".equals(detail.getAccessoryApplyState())) {
                        mTvAccessoryReview.setText("审核拒绝");
                    }
                    if ("1".equals(detail.getTypeID())) {
                        if (detail.getExpressNo() == null) {
                            mTvShipmentNumber.setText("暂未发货");
                        } else {
                            mTvShipmentNumber.setText(detail.getExpressNo());
                        }
                        mTvArrivalNumber.setText("无");
                        mTvArrival.setText("");
                    } else if ("2".equals(detail.getTypeID())) {
                        mTvShipmentNumber.setText("无");
                        if ("Y".equals(detail.getIsRecevieGoods())) {
                            mTvArrivalNumber.setText("已收到货");
                            mTvArrival.setText("是");
                        } else if ("N".equals(detail.getIsRecevieGoods())) {
                            mTvArrivalNumber.setText(detail.getExpressNo());
                            mTvArrival.setText("否");
                        }
                    } else {
                        if (detail.getExpressNo() == null) {
                            mTvShipmentNumber.setText("暂未发货");
                        } else {
                            mTvShipmentNumber.setText(detail.getExpressNo());
                        }
                        mTvArrivalNumber.setText("无");
                    }


                    if (detail.getReturnAccessoryMsg() == null) {
                        mTvReturnInformation.setText("暂未返件");
                    } else {
                        mTvReturnInformation.setText(detail.getReturnAccessoryMsg());
                    }
//
                    mTvPlatformAmount.setText(detail.getTerraceMoney());
                    mTvOrderAmount.setText(detail.getOrderMoney());
                    mTvCreationTime.setText(detail.getCreateDate());
                    mTvOrderTime.setText(detail.getAudDate());
                    mTvEndTime.setText(detail.getRepairCompleteDate());

                    if ("服务完成".equals(detail.getState())) {
                        mBtnFinish.setVisibility(View.VISIBLE);
                    } else {
                        mBtnFinish.setVisibility(View.GONE);
                    }
                }
                break;
        }
    }

    @Override
    public void UpdatePhone(BaseResult<Data<String>> baseResult) {
        switch (baseResult.getStatusCode()){
            case 200:
                if (baseResult.getData().isItem1()){
                    ToastUtils.showShort("修改成功");
                    mPresenter.GetOrderInfo(orderId);
                }else {
                    ToastUtils.showShort(baseResult.getData().getItem2());
                }
                break;
        }
    }

    @Override
    public void CloseOrder(BaseResult<Data<String>> baseResult) {
        switch (baseResult.getStatusCode()){
            case 200:
                if (baseResult.getData().isItem1()){
                    ToastUtils.showShort("操作成功");
                    mPresenter.GetOrderInfo(orderId);
                }else {
                    ToastUtils.showShort(baseResult.getData().getItem2());
                }
                break;
        }
    }

    @Override
    public void modifyOrderMoney(BaseResult<Data<String>> baseResult) {
        switch (baseResult.getStatusCode()){
            case 200:
                if (baseResult.getData().isItem1()){
                    ToastUtils.showShort("操作成功");
                    mPresenter.GetOrderInfo(orderId);
                }else {
                    ToastUtils.showShort(baseResult.getData().getItem2());
                }
                break;
        }
    }


}
