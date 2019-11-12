package com.zhkj.backstage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.base.BaseActivity;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.contract.LoginContract;
import com.zhkj.backstage.model.LoginModel;
import com.zhkj.backstage.presenter.LoginPresenter;
import com.zhkj.backstage.weight.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements View.OnClickListener, LoginContract.View {
    @BindView(R.id.et_username)
    ClearEditText mEtUsername;
    @BindView(R.id.et_password)
    ClearEditText mEtPassword;
    @BindView(R.id.ll_password)
    LinearLayout mLlPassword;
    @BindView(R.id.login)
    Button mLogin;
    private SPUtils spUtils;
    private String userName;
    private String passWord;
    private boolean isLogin;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        spUtils = SPUtils.getInstance("token");
        userName = spUtils.getString("userName");
        passWord = spUtils.getString("passWord");
        isLogin = spUtils.getBoolean("isLogin");
        mEtUsername.setText(userName);
        mEtPassword.setText(passWord);
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
        mImmersionBar.statusBarColor(R.color.white);
        mImmersionBar.fitsSystemWindows(false);
        mImmersionBar.keyboardEnable(true).navigationBarWithKitkatEnable(false).init();
    }

    @Override
    protected void setListener() {
        mLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                userName = mEtUsername.getText().toString();
                passWord = mEtPassword.getText().toString();
                if ("".equals(userName)) {
                    ToastUtils.showShort("请输入手机号！");
                    return;
                }
//                if (!RegexUtils.isMobileExact(userName)){
//                    ToastUtils.showShort("手机号格式不正确！");
//                    return;
//                }
                if ("".equals(passWord)) {
                    ToastUtils.showShort("请输入密码！");
                    return;
                }
                mPresenter.Login(userName, passWord);
//
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
    public void Login(BaseResult<Data<String>> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                Data<String> data=baseResult.getData();
                if (data.isItem1()){
                    spUtils.put("adminToken", data.getItem2());
                    spUtils.put("userName", userName);
                    spUtils.put("passWord", passWord);
                    spUtils.put("isLogin", true);
//                    mPresenter.AddAndUpdatePushAccount(XGPushConfig.getToken(this),"6",userName);
                    startActivity(new Intent(mActivity, MainActivity.class));
                    finish();
                }else{
                    ToastUtils.showShort(data.getItem2());
                }
                break;
        }
    }

    @Override
    public void GetUserInfo(BaseResult<String> baseResult) {

    }
}
