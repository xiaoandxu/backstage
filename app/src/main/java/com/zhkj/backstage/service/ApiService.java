package com.zhkj.backstage.service;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.bean.SalesToday;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    /**
     * 判断用户名是否可用
     */
    @FormUrlEncoded
    @POST("Account/ValidateUserName")
    Observable<BaseResult<String>> ValidateUserName(@Field("UserID") String userName);

    /**
     * app用户登录
     */
    @FormUrlEncoded
    @POST("Account/LoginOn")
    Observable<BaseResult<Data<String>>> LoginOn(@Field("userName") String userName, @Field("passWord") String passWord, @Field("roleType") String roleType);

    /**
     * app获取用户信息
     */
    @POST("Account/GetUserInfo")
    Observable<BaseResult<String>> GetUserInfo(@Body RequestBody json);

    /**
     * app获取用户信息
     */
    @FormUrlEncoded
    @POST("Account/GetUserInfo")
    Observable<BaseResult<String>> GetUserInfo(@Field("userName") String userName);

    /**
     * 首页信息
     */
    @POST("Order/SalesToday")
    Observable<BaseResult<Data<SalesToday>>> SalesToday();

    /*
    * 最新工单,配件工单等
    *
    * OrderID,
    * UserID,
    * TypeID,
    * State,//工单状态
    * ProvinceCode,
    * CityCode,
    * AreaCode,
    * CreateDate,//最新工单，传当前日期
    * partsIs,//是否有配件的工单，有就传1，否就传null或者其他的
    * messageIs//是否留言的工单，有就传1，否就传null或者其他的
    * */
    @FormUrlEncoded
    @POST("Order/GetOrderInfoList2")
    Observable<BaseResult<WorkOrder>> GetOrderInfoList(@Field("OrderID") String OrderID,
                                                       @Field("UserID") String UserID,
                                                       @Field("TypeID") String TypeID,
                                                       @Field("State") String State,
                                                       @Field("ProvinceCode") String ProvinceCode,
                                                       @Field("CityCode") String CityCode,
                                                       @Field("AreaCode") String AreaCode,
                                                       @Field("CreateDate") String CreateDate,
                                                       @Field("partsIs") String partsIs,
                                                       @Field("messageIs") String messageIs,
                                                       @Field("page") String page,
                                                       @Field("limit") String limit);

    /**
     * 获取工单详情
     * 通过OrderID获取工单详情
     * MessageType:1工厂2师傅端3平台
     */
    @FormUrlEncoded
    @POST("Order/GetOrderInfo")
    Observable<BaseResult<WorkOrder.DataBean>> GetOrderInfo(@Field("OrderID") String OrderID,
                                                            @Field("MessageType") String MessageType);
}
