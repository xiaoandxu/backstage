package com.zhkj.backstage.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dmcbig.mediapicker.PickerActivity;
import com.dmcbig.mediapicker.PickerConfig;
import com.dmcbig.mediapicker.PreviewActivity;
import com.dmcbig.mediapicker.entity.Media;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.zhkj.backstage.R;
import com.zhkj.backstage.activity.PhotoViewActivity;
import com.zhkj.backstage.adapter.LeaveMessageAdapter;
import com.zhkj.backstage.adapter.PicAdapter;
import com.zhkj.backstage.base.BaseLazyFragment;
import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.PicResult;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.mvp.contract.LeaveMessageContract;
import com.zhkj.backstage.mvp.model.LeaveMessageModel;
import com.zhkj.backstage.mvp.presenter.LeaveMessagePresenter;
import com.zhkj.backstage.service.Config;
import com.zhkj.backstage.util.MyUtils;
import com.zhkj.backstage.util.imageutil.ImageCompress;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

//留言信息
public class MessageFragment extends BaseLazyFragment<LeaveMessagePresenter, LeaveMessageModel> implements View.OnClickListener, LeaveMessageContract.View {
    private static final String ARG_PARAM1 = "param1";//
    private static final String ARG_PARAM2 = "param2";//
    @BindView(R.id.message_rv)
    RecyclerView mMessageRv;
    @BindView(R.id.et_message)
    EditText mEtMessage;
    @BindView(R.id.rv_icons)
    RecyclerView mRvIcons;
    @BindView(R.id.btn_submit)
    Button mBtnSubmit;


    private String mParam1;
    private String mParam2;
    private String orderId;
    private String userID;
    private LeaveMessageAdapter leaveMessageAdapter;
    private List<WorkOrder.LeavemessageListBean> list = new ArrayList<>();
    private WorkOrder.DataBean data;
    private ArrayList<String> permissions;
    private int size;
    private View popupWindow_view;
    private String FilePath;
    private PopupWindow mPopupWindow;
    private Uri uri;
    private HashMap<Integer, File> img = new HashMap<>();

    private ArrayList<String> piclist = new ArrayList<>();
    private ArrayList<String> selectpiclist = new ArrayList<>();
    private ArrayList<String> successpiclist = new ArrayList<>();
    private ArrayList<Media> select = new ArrayList<>();

    private Bitmap bitmap;
    private PicAdapter picAdapter;
    private int k;
    private String message;

    public static MessageFragment newInstance(String param1, String param2) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {

        }
        super.setUserVisibleHint(isVisibleToUser);

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
        return R.layout.fragment_message;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        orderId = mParam1;
        SPUtils spUtils = SPUtils.getInstance("token");
        //获取用户id
        userID = spUtils.getString("userName");

        showProgress();
        mPresenter.GetOrderInfo(orderId);
        leaveMessageAdapter = new LeaveMessageAdapter(R.layout.item_leave_message, list);
        mMessageRv.setLayoutManager(new LinearLayoutManager(mActivity));
        mMessageRv.setAdapter(leaveMessageAdapter);
//        leaveMessageAdapter.setEmptyView(getEmptyMessage());
        leaveMessageAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.iv_image:
                        Intent intent = new Intent(mActivity, PhotoViewActivity.class);
                        intent.putExtra("PhotoUrl", Config.Leave_Message_URL + ((WorkOrder.LeavemessageListBean) adapter.getData().get(position)).getPhoto());
                        startActivity(intent);
                        break;
                }
            }
        });
        piclist.clear();
        piclist.add("add");
        picAdapter = new PicAdapter(R.layout.item_picture, piclist);
        mRvIcons.setLayoutManager(new GridLayoutManager(mActivity,5));
        mRvIcons.setAdapter(picAdapter);
        picAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.img:
                        if ("add".equals(adapter.getItem(position))){
                            if(requestPermissions()){
                                goImage();
                            }else{
                                requestPermissions(permissions.toArray(new String[permissions.size()]), 10001);
                            }
                        }else{
                            goPreviewActivity();
                        }
                }
            }
        });
    }

    private void loadAdpater(ArrayList<String> paths) {
        piclist.clear();
        piclist.addAll(paths);
        selectpiclist.clear();
//        selectpiclist.addAll(paths);
        for (int i = 0; i < paths.size(); i++) {
            selectpiclist.add(ImageCompress.compressImage(paths.get(i),Environment.getExternalStorageDirectory().getAbsolutePath() + "/xgy/" + System.currentTimeMillis() + ".jpg",80));
        }
        if (piclist.size() != 5) {
            piclist.add("add");
        }
        System.out.println(selectpiclist);
        picAdapter.setNewData(piclist);
    }
    void goImage(){
        Intent intent =new Intent(mActivity, PickerActivity.class);
        intent.putExtra(PickerConfig.SELECT_MODE,PickerConfig.PICKER_IMAGE);//default image and video (Optional)
        long maxSize=188743680L;//long long long
        intent.putExtra(PickerConfig.MAX_SELECT_SIZE,maxSize); //default 180MB (Optional)
        intent.putExtra(PickerConfig.MAX_SELECT_COUNT,5-piclist.size()+1);  //default 40 (Optional)
//        intent.putExtra(PickerConfig.DEFAULT_SELECTED_LIST,select); // (Optional)
        startActivityForResult(intent,200);
    }
    void goPreviewActivity(){
        Intent intent =new Intent(mActivity, PreviewActivity.class);
        intent.putExtra(PickerConfig.PRE_RAW_LIST,select);//default image and video (Optional)
        intent.putExtra(PickerConfig.MAX_SELECT_COUNT,select.size());//default image and video (Optional)
        startActivityForResult(intent,300);
    }

    @Override
    protected void setListener() {
        mBtnSubmit.setOnClickListener(this);
        mEtMessage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (v.getId()) {
                    case R.id.et_message:
                        // 解决scrollView中嵌套EditText导致不能上下滑动的问题
                        if (canVerticalScroll(mEtMessage))
                            v.getParent().requestDisallowInterceptTouchEvent(true);
                        switch (event.getAction() & MotionEvent.ACTION_MASK) {
                            case MotionEvent.ACTION_UP:
                                v.getParent().requestDisallowInterceptTouchEvent(false);
                                break;
                        }
                }
                return false;
            }
        });
    }

    /**
     * EditText竖直方向是否可以滚动
     *
     * @param editText 需要判断的EditText
     * @return true：可以滚动  false：不可以滚动
     */
    public static boolean canVerticalScroll(EditText editText) {
        //滚动的距离
        int scrollY = editText.getScrollY();
        //控件内容的总高度
        int scrollRange = editText.getLayout().getHeight();
        //控件实际显示的高度
        int scrollExtent = editText.getHeight() - editText.getCompoundPaddingTop() - editText.getCompoundPaddingBottom();
        //控件内容总高度与实际显示高度的差值
        int scrollDifference = scrollRange - scrollExtent;

        if (scrollDifference == 0) {
            return false;
        }

        return (scrollY > 0) || (scrollY < scrollDifference - 1);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(String name) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                uploadImg(selectpiclist);

                break;
        }
    }

    @Override
    public void AddLeaveMessageForOrder(BaseResult<Data<String>> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                hideProgress();
                ToastUtils.showShort(baseResult.getData().getItem2());
                mEtMessage.setText("");
                select.clear();
                piclist.clear();
                selectpiclist.clear();
                loadAdpater(piclist);
                mPresenter.GetOrderInfo(orderId);
                break;
        }
    }

    @Override
    public void GetOrderInfo(BaseResult<WorkOrder.DataBean> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                mPresenter.LeaveMessageWhetherLook(orderId);
                data = baseResult.getData();
                if (data.getLeavemessageList().size() == 0) {
                } else {
                    list=data.getLeavemessageList();
                    Collections.reverse(list);
                    leaveMessageAdapter.setNewData(list);
                }
                hideProgress();
                break;
        }
    }

    @Override
    public void LeaveMessageImg(BaseResult<Data<String>> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                if (baseResult.getData().isItem1()) {
                    String message = mEtMessage.getText().toString();
                    if (message == null || "".equals(message)) {
                        ToastUtils.showShort("请输入留言内容");
                    } else {
                        mPresenter.AddLeaveMessageForOrder(userID, orderId, message,baseResult.getData().getItem2());
                    }

                }
                break;
            default:
                ToastUtils.showShort("图片上传失败");
                break;
        }
    }

    @Override
    public void LeaveMessageWhetherLook(BaseResult<Data> baseResult) {
        switch (baseResult.getStatusCode()) {
            case 200:
                EventBus.getDefault().post("read");
                break;
        }
    }

    //请求权限
    private boolean requestPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            permissions = new ArrayList<>();
            if (mActivity.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
            if (mActivity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
//            if (mActivity.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                permissions.add(Manifest.permission.CAMERA);
//            }
            if (permissions.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }


    //申请相关权限:返回监听
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        size = 0;
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                size++;
            }
        }
        switch (requestCode) {
            case 10001:
                if (size == grantResults.length) {//允许
                    goImage();
                } else {//拒绝
                    MyUtils.showToast(mActivity, "相关权限未开启");
                }
                break;
            default:
                break;

        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        File file = null;
        if(requestCode==200&&resultCode==PickerConfig.RESULT_CODE){
            select.addAll((ArrayList)data.getParcelableArrayListExtra(PickerConfig.EXTRA_RESULT));
            ArrayList<String> list=new ArrayList<>();
            Log.i("select","select.size"+select.size());
            for(Media media:select){
                list.add(media.path);
                Log.i("media",media.path);
                Log.e("media","s:"+media.size);
            }
            loadAdpater(list);
        }
        if(requestCode==300){
            select=data.getParcelableArrayListExtra(PickerConfig.EXTRA_RESULT);
            ArrayList<String> list=new ArrayList<>();
            Log.i("select","select.size"+select.size());
            for(Media media:select){
                list.add(media.path);
                Log.i("media",media.path);
                Log.e("media","s:"+media.size);
            }
            loadAdpater(list);
        }
    }

    public void uploadImg(List<String> selectimg) {
        message = mEtMessage.getText().toString();
        if (message == null || "".equals(message)) {
            ToastUtils.showShort("请输入留言内容");
            return;
        }
        showProgress();
        if (selectimg.size()==0){
            mPresenter.AddLeaveMessageForOrder(userID,orderId,message,"");
        }else{
            successpiclist.clear();
            for (int i = 0; i < selectimg.size(); i++) {
                File file=new File(selectimg.get(i));
                MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
                builder.addFormDataPart("img", file.getName(), RequestBody.create(MediaType.parse("img/png"), file));
                MultipartBody requestBody = builder.build();
                //接口
                String path = Config.URL+"Upload/LeaveMessageImg";
                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .connectTimeout(5, TimeUnit.MINUTES)
                        .readTimeout(5, TimeUnit.MINUTES)
                        .build();
                final Request request = new Request.Builder()
                        .url(path)
                        .post(requestBody)
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        hideProgress();
                        ToastUtils.showShort("留言失败，请稍后重试");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String str = response.body().string();
                        System.out.println(str);
                        Gson gson=new Gson();
                        PicResult result=gson.fromJson(str.replaceAll(" ",""), PicResult.class);
                        if (result.getData().isItem1()){
                            successpiclist.add(result.getData().getItem2());
                            if(successpiclist.size()==selectpiclist.size()){
                                String photo="";
                                for (int i = 0; i < successpiclist.size(); i++) {
                                    photo+=successpiclist.get(i)+",";
                                }
                                photo=photo.substring(0,photo.lastIndexOf(","));
                                mPresenter.AddLeaveMessageForOrder(userID,orderId,message,photo);
                            }
                        }else{
                            hideProgress();
                            ToastUtils.showShort("留言失败，请稍后重试");
                        }
                    }
                });
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(Bitmap name) {
        bitmap = name;
        ToastUtils.showShort(bitmap+"");
    }
}
