package com.zhkj.backstage.service;

import com.zhkj.backstage.base.BaseResult;
import com.zhkj.backstage.bean.Address;
import com.zhkj.backstage.bean.Area;
import com.zhkj.backstage.bean.BankCard;
import com.zhkj.backstage.bean.CategoryData;
import com.zhkj.backstage.bean.City;
import com.zhkj.backstage.bean.CompanyInfo;
import com.zhkj.backstage.bean.Data;
import com.zhkj.backstage.bean.District;
import com.zhkj.backstage.bean.GetIDCardImg;
import com.zhkj.backstage.bean.Province;
import com.zhkj.backstage.bean.SalesToday2;
import com.zhkj.backstage.bean.SalesToday3;
import com.zhkj.backstage.bean.Skill;
import com.zhkj.backstage.bean.UserInfoList;
import com.zhkj.backstage.bean.UserList;
import com.zhkj.backstage.bean.WorkOrder;
import com.zhkj.backstage.bean.SalesToday;

import java.util.List;

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

    /**
     * 首页信息
     */
    @POST("Order/SalesToday2")
    Observable<BaseResult<Data<SalesToday2>>> SalesToday2();

    /**
     * 首页信息
     */
    @POST("Order/SalesToday3")
    Observable<BaseResult<Data<SalesToday3>>> SalesToday3();
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


    /*获取用户列表*/
    @FormUrlEncoded
    @POST("Account/GetMUserList")
    Observable<BaseResult<UserList>> GetMUserList(@Field("UserID") String UserID,
                                                  @Field("Type") String Type,
                                                  @Field("page") String page,
                                                  @Field("limit") String limit);

    /*
    * 指定派单
    * TypeId:操作：1指定派单2改派工单
    * */
    @FormUrlEncoded
    @POST("Order/SendOrder")
    Observable<BaseResult<Data<String>>> SendOrder(@Field("OrderID") String OrderID,
                                                  @Field("UserID") String UserID,
                                                  @Field("LoginUser") String LoginUser,
                                                  @Field("TypeID") String TypeID);


    /*获取待审核列表
    *
    * */
    @FormUrlEncoded
    @POST("Account/GetUserInfoList")
    Observable<BaseResult<UserInfoList>> GetUserInfoList(@Field("Type") String Type,
                                                         @Field("IfAuth") String IfAuth,
                                                         @Field("page") String page,
                                                         @Field("limit") String limit);

    /*获取用户信息*/
    @FormUrlEncoded
    @POST("Account/GetUserInfoList")
    Observable<BaseResult<UserInfoList>> GetUserInfo(@Field("UserID") String UserID,
                                                     @Field("limit") String limit);

    /**
     * 获取公司信息
     */
    @FormUrlEncoded
    @POST("account/GetmessageBytype")
    Observable<BaseResult<Data<CompanyInfo>>> GetmessageBytype(@Field("UserID") String UserID);

    /**
     * 获取用户实名照片
     */
    @FormUrlEncoded
    @POST("Account/GetIDCardImg")
    Observable<BaseResult<List<GetIDCardImg>>> GetIDCardImg(@Field("UserID") String UserID);

    /*获取银行卡*/
    @FormUrlEncoded
    @POST("Account/GetAccountPayInfoList")
    Observable<BaseResult<List<BankCard>>> GetAccountPayInfoList(@Field("UserID") String UserID);

    /*审核实名认证*/
    @FormUrlEncoded
    @POST("Account/ApproveAuth")
    Observable<BaseResult<Data<String>>> ApproveAuth(@Field("UserID") String UserID,
                                                     @Field("State") String State,
                                                     @Field("AuthMessage") String AuthMessage);

    /**
     * 获取分类
     */
    @FormUrlEncoded
    @POST("FactoryConfig/GetFactoryCategory")
    Observable<BaseResult<CategoryData>> GetFactoryCategory(@Field("ParentID") String ParentID);

    /**
     * 获取子分类
     */
    @FormUrlEncoded
    @POST("FactoryConfig/GetFactoryCategory")
    Observable<BaseResult<CategoryData>> GetChildFactoryCategory(@Field("ParentID") String ParentID);

    /*获取账户的技能*/
    @FormUrlEncoded
    @POST("Account/GetAccountSkill")
    Observable<BaseResult<List<Skill>>> GetAccountSkill(@Field("UserID") String UserID);

    /**
     * 添加技能
     *
     * @param UserID
     * @return
     */
    @FormUrlEncoded
    @POST("Account/UpdateAccountSkillData")
    Observable<BaseResult<String>> UpdateAccountSkillData(@Field("UserID") String UserID, @Field("NodeIds") String NodeIds);

    /**
     * 获取省
     */
    @POST("Config/GetProvince")
    Observable<BaseResult<List<Province>>> GetProvince();

    /**
     * 获取市
     */
    @FormUrlEncoded
    @POST("Config/GetCity")
    Observable<BaseResult<Data<List<City>>>> GetCity(@Field("parentcode") String parentcode);

    /**
     * 获取区
     */
    @FormUrlEncoded
    @POST("Config/GetArea")
    Observable<BaseResult<Data<List<Area>>>> GetArea(@Field("parentcode") String parentcode);

    /**
     * 获取区
     */
    @FormUrlEncoded
    @POST("Config/GetDistrict")
    Observable<BaseResult<Data<List<District>>>> GetDistrict(@Field("parentcode") String parentcode);

    /*获取服务区域*/
    @FormUrlEncoded
    @POST("Account/GetServiceRangeByUserID")
    Observable<BaseResult<List<Address>>> GetServiceRangeByUserID(@Field("UserID") String UserID);

    /*更新服务区域*/
    @FormUrlEncoded
    @POST("Account/AddorUpdateServiceArea")
    Observable<BaseResult<Data<String>>> AddorUpdateServiceArea(@Field("UserID") String UserID,
                                                                @Field("ServiceAreaJsonStr") String ServiceAreaJsonStr);

}
