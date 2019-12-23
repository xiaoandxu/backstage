package com.zhkj.backstage.bean;

import java.io.Serializable;
import java.util.List;

public class RemoteFeeAudit implements Serializable {

    /**
     * Info : 请求(或处理)成功
     * msg : 获取远程待审核大于50元的列表
     * StatusCode : 0
     * count : 5
     * data : [{"Id":2000002850,"OrderID":2000002850,"TypeID":1,"TypeName":"维修","SubTypeID":0,"Frozen":75,"SubTypeName":null,"CategoryID":287,"CategoryName":"冰洗类","SubCategoryID":250,"SubCategoryName":"冰箱","Memo":"测试","BrandID":230,"BrandName":"lol","SendAddress":null,"ProductType":"单门 容积X≤100","ProductTypeID":"251","Num":1,"ProvinceCode":"120000","CityCode":"120100","AreaCode":"120101","DistrictCode":"120101004","Address":"天津市天津市 和平区新兴街道。","Longitude":"117.186340","Dimension":"39.105538","UserID":"18888888888","ComID":null,"Guarantee":"Y","UserName":"路飞","Phone":"18767773654","CreateDate":"2019-11-11T17:31:59","AudDate":"2019-11-11T17:31:59","ReceiveOrderDate":null,"RepairCompleteDate":null,"AppraiseDate":null,"State":"9","FakerTime":0,"StateHtml":"远程费审核","Extra":"N","ExtraTime":"0","IsCall":null,"ExtraFee":0,"IsUse":"Y","SendUser":"18767773654","OrgSendUser":null,"LoginUser":"System","IsPay":"Y","OrderMoney":35,"terraceMoney":0,"InitMoney":0,"ExamineMoney":0,"AgainMoney":0,"RelationOrderID":0,"BeyondMoney":9999,"QuaMoney":0,"BeyondID":237,"BeyondState":"0","BeyondDistance":"9999","Accessory":null,"AccessorySequency":null,"AccessoryApplyState":null,"AccessoryAndServiceApplyState":null,"AccessoryState":"","AccessorySendState":null,"AccessoryMoney":0,"AccessorySearchState":"0","AccessoryApplyDate":null,"AccessoryMemo":null,"AccessoryServiceMoney":0,"Service":null,"ServiceMoney":0,"ServiceApplyState":null,"ServiceApplyDate":null,"AccessoryAndServiceApplyDate":null,"StarOrder":null,"FStarOrder":null,"PostPayType":"","PostMoney":0,"NewMoney":null,"AddressBack":"","IsReturn":"","ApplyNum":0,"QApplyNum":0,"MallID":0,"EndRemark":null,"Grade":0,"Grade1":0,"Grade2":0,"Grade3":0,"ReturnAccessory":null,"ReturnAccessoryMsg":null,"ApplyCancel":null,"OrgAppraise":null,"UpdateTime":"0001-01-01T00:00:00","LateTime":"0001-01 -01T00:00:00","IsExtraTime":null,"OrderPayStr":null,"ThirdPartyNo":null,"PartyNo":"","ExpressNo":null,"RecycleOrderHour":48,"IsRecevieGoods":"N","AppointmentMessage":null,"AppointmentState":null,"IsLate":null,"Distance":0,"DistanceTureOrFalse":false,"SendOrderState":null,"SendOrderMsg":null,"IsSendRepair":null,"OrderSource":null,"OrderImg":[],"ReturnaccessoryImg":[],"OrderAccessroyDetail":[],"OrderServiceDetail":[],"OrderBeyondImg":[{"Id":196,"OrderBeyondImgID":196,"Url":"53fc78f5f814451b95bd3c2f045ef522.jpg","OrderID":2000002850,"CreateTime":"2019-11-24T14:37:57","IsUse":"Y","page":1,"limit":999,"Version":0}],"OrderComplaintDetail":[],"OrderAppraiseDetail":[],"SendOrderList":[{"Id":3048,"SendID":3048,"CreateDate":"2019-11-11T17:31:59","UserID":"18767773654","OrderID":2000002850,"State":"0","UpdateDate":null,"ServiceDate":null,"ServiceDate2":null,"LoginUser":"system","IsUse":"Y","CategoryID":287,"CategoryName":"冰洗类","SubTypeID":0,"SubTypeName":null,"Memo":"测试","BrandID":230,"BrandName":"lol","ProductType":"单门 容积X≤100","ProvinceCode":"120000","CityCode":"120100","AreaCode":"120101","Address":"天津市天津市 和平区新兴街道。","Guarantee":"Y","UserName":"路飞","Phone":"18767773654","AppointmentState":null,"AppointmentMessage":null,"page":1,"limit":10,"Version":0}],"LeavemessageList":[],"LeavemessageimgList":[],"IsPressFactory":null,"WorkerComplaint":null,"FactoryComplaint":null,"IsLook":"1","FIsLook":"1","page":0,"limit":0,"StateList":[],"AccessorySearchStateList":null,"EndTime":null,"StartTime":null,"isOnLookMessage":0,"AppointmentRefuseState":null,"InvoiceName":null,"AccessoryRefuseState":null,"FactoryApplyState":null,"OrderApplyState":null,"AccessoryIsPay":null,"OrderSort":null,"partsIs":null,"messageIs":null,"SendUserIs":null,"uniqId":null,"IsSettlement":null,"SettlementMoney":0,"SettlementTime":"0001-01-01T00:00:00","OrderAccessoryStr":null,"ContinueIssuing":null,"Version":0},{"Id":2000002851,"OrderID":2000002851,"TypeID":1,"TypeName":"维修","SubTypeID":0,"Frozen":75,"SubTypeName":null,"CategoryID":287,"CategoryName":"冰洗类","SubCategoryID":250,"SubCategoryName":"冰箱","Memo":"测试","BrandID":230,"BrandName":"lol","SendAddress":null,"ProductType":"单门 容积X≤100","ProductTypeID":"251","Num":1,"ProvinceCode":"120000","CityCode":"120100","AreaCode":"120101","DistrictCode":"120101004","Address":"天津市天津市 和平区新兴街道。","Longitude":"117.186340","Dimension":"39.105538","UserID":"18888888888","ComID":null,"Guarantee":"Y","UserName":"路飞","Phone":"18767773654","CreateDate":"2019-11-11T17:32:02","AudDate":"2019-11-11T17:32:02","ReceiveOrderDate":null,"RepairCompleteDate":null,"AppraiseDate":null,"State":"9","FakerTime":0,"StateHtml":"远程费审核","Extra":"N","ExtraTime":"0","IsCall":null,"ExtraFee":0,"IsUse":"Y","SendUser":"18767773654","OrgSendUser":null,"LoginUser":"System","IsPay":"Y","OrderMoney":35,"terraceMoney":0,"InitMoney":0,"ExamineMoney":0,"AgainMoney":0,"RelationOrderID":0,"BeyondMoney":9999,"QuaMoney":0,"BeyondID":235,"BeyondState":"0","BeyondDistance":"9999","Accessory":null,"AccessorySequency":null,"AccessoryApplyState":null,"AccessoryAndServiceApplyState":null,"AccessoryState":"","AccessorySendState":null,"AccessoryMoney":0,"AccessorySearchState":"0","AccessoryApplyDate":null,"AccessoryMemo":null,"AccessoryServiceMoney":0,"Service":null,"ServiceMoney":0,"ServiceApplyState":null,"ServiceApplyDate":null,"AccessoryAndServiceApplyDate":null,"StarOrder":null,"FStarOrder":null,"PostPayType":"","PostMoney":0,"NewMoney":null,"AddressBack":"","IsReturn":"","ApplyNum":0,"QApplyNum":0,"MallID":0,"EndRemark":null,"Grade":0,"Grade1":0,"Grade2":0,"Grade3":0,"ReturnAccessory":null,"ReturnAccessoryMsg":null,"ApplyCancel":null,"OrgAppraise":null,"UpdateTime":"0001-01-01T00:00:00","LateTime":"0001-01-01T00:00:00","IsExtraTime":null,"OrderPayStr":null,"ThirdPartyNo":null,"PartyNo":"","ExpressNo":null,"RecycleOrderHour":48,"IsRecevieGoods":"N","AppointmentMessage":null,"AppointmentState":null,"IsLate":null,"Distance":0,"DistanceTureOrFalse":false,"SendOrderState":null,"SendOrderMsg":null,"IsSendRepair":null,"OrderSource":null,"OrderImg":[],"ReturnaccessoryImg":[],"OrderAccessroyDetail":[],"OrderServiceDetail":[],"OrderBeyondImg":[{"Id":194,"OrderBeyondImgID":194,"Url":"3104c021a6ca456cab47edb388735603.jpg","OrderID":2000002851,"CreateTime":"2019-11-22T12:21:36","IsUse":"Y","page":1,"limit":999,"Version":0}],"OrderComplaintDetail":[],"OrderAppraiseDetail":[],"SendOrderList":[{"Id":3049,"SendID":3049,"CreateDate":"2019-11-11T17:32:02","UserID":"18767773654","OrderID":2000002851,"State":"0","UpdateDate":null,"ServiceDate":null,"ServiceDate2":null,"LoginUser":"system","IsUse":"Y","CategoryID":287,"CategoryName":"冰洗类","SubTypeID":0,"SubTypeName":null,"Memo":"测试","BrandID":230,"BrandName":"lol","ProductType":"单门 容积X≤100","ProvinceCode":"120000","CityCode":"120100","AreaCode":"120101","Address":"天津市天津市 和平区新兴街道。","Guarantee":"Y","UserName":"路飞","Phone":"18767773654","AppointmentState":null,"AppointmentMessage":null,"page":1,"limit":10,"Version":0}],"LeavemessageList":[],"LeavemessageimgList":[],"IsPressFactory":null,"WorkerComplaint":null,"FactoryComplaint":null,"IsLook":"1","FIsLook":"1","page":0,"limit":0,"StateList":[],"AccessorySearchStateList":null,"EndTime":null,"StartTime":null,"isOnLookMessage":0,"AppointmentRefuseState":null,"InvoiceName":null,"AccessoryRefuseState":null,"FactoryApplyState":null,"OrderApplyState":null,"AccessoryIsPay":null,"OrderSort":null,"partsIs":null,"messageIs":null,"SendUserIs":null,"uniqId":null,"IsSettlement":null,"SettlementMoney":0,"SettlementTime":"0001-01-01T00:00:00","OrderAccessoryStr":null,"ContinueIssuing":null,"Version":0},{"Id":2000002852,"OrderID":2000002852,"TypeID":1,"TypeName":"维修","SubTypeID":0,"Frozen":75,"SubTypeName":null,"CategoryID":287,"CategoryName":"冰洗类","SubCategoryID":250,"SubCategoryName":"冰箱","Memo":"测试","BrandID":230,"BrandName":"lol","SendAddress":null,"ProductType":"单门 容积X≤100","ProductTypeID":"251","Num":1,"ProvinceCode":"120000","CityCode":"120100","AreaCode":"120101","DistrictCode":"120101004","Address":"天津市天津市 和平区新兴街道。","Longitude":"117.186340","Dimension":"39.105538","UserID":"18888888888","ComID":null,"Guarantee":"Y","UserName":"路飞","Phone":"18767773654","CreateDate":"2019-11-11T17:32:06","AudDate":"2019-11-11T17:32:06","ReceiveOrderDate":null,"RepairCompleteDate":null,"AppraiseDate":null,"State":"9","FakerTime":0,"StateHtml":"远程费审核","Extra":"N","ExtraTime":"0","IsCall":null,"ExtraFee":0,"IsUse":"Y","SendUser":"18767773654","OrgSendUser":null,"LoginUser":"System","IsPay":"Y","OrderMoney":35,"terraceMoney":0,"InitMoney":0,"ExamineMoney":0,"AgainMoney":0,"RelationOrderID":0,"BeyondMoney":9999,"QuaMoney":0,"BeyondID":234,"BeyondState":"0","BeyondDistance":null,"Accessory":null,"AccessorySequency":null,"AccessoryApplyState":null,"AccessoryAndServiceApplyState":null,"AccessoryState":"","AccessorySendState":null,"AccessoryMoney":0,"AccessorySearchState":"0","AccessoryApplyDate":null,"AccessoryMemo":null,"AccessoryServiceMoney":0,"Service":null,"ServiceMoney":0,"ServiceApplyState":null,"ServiceApplyDate":null,"AccessoryAndServiceApplyDate":null,"StarOrder":null,"FStarOrder":null,"PostPayType":"","PostMoney":0,"NewMoney":null,"AddressBack":"","IsReturn":"","ApplyNum":0,"QApplyNum":0,"MallID":0,"EndRemark":null,"Grade":0,"Grade1":0,"Grade2":0,"Grade3":0,"ReturnAccessory":null,"ReturnAccessoryMsg":null,"ApplyCancel":null,"OrgAppraise":null,"UpdateTime":"0001-01-01T00:00:00","LateTime":"0001-01-01T00:00:00","IsExtraTime":null,"OrderPayStr":null,"ThirdPartyNo":null,"PartyNo":"","ExpressNo":null,"RecycleOrderHour":48,"IsRecevieGoods":"N","AppointmentMessage":null,"AppointmentState":null,"IsLate":null,"Distance":0,"DistanceTureOrFalse":false,"SendOrderState":null,"SendOrderMsg":null,"IsSendRepair":null,"OrderSource":null,"OrderImg":[],"ReturnaccessoryImg":[],"OrderAccessroyDetail":[],"OrderServiceDetail":[],"OrderBeyondImg":[{"Id":193,"OrderBeyondImgID":193,"Url":"1f9471693c68431f92dfd9ae8fc7d82d.jpg","OrderID":2000002852,"CreateTime":"2019-11-22T11:36:26","IsUse":"Y","page":1,"limit":999,"Version":0}],"OrderComplaintDetail":[],"OrderAppraiseDetail":[],"SendOrderList":[{"Id":3050,"SendID":3050,"CreateDate":"2019-11-11T17:32:06","UserID":"18767773654","OrderID":2000002852,"State":"0","UpdateDate":null,"ServiceDate":null,"ServiceDate2":null,"LoginUser":"system","IsUse":"Y","CategoryID":287,"CategoryName":"冰洗类","SubTypeID":0,"SubTypeName":null,"Memo":"测试","BrandID":230,"BrandName":"lol","ProductType":"单门 容积X≤100","ProvinceCode":"120000","CityCode":"120100","AreaCode":"120101","Address":"天津市天津市 和平区新兴街道。","Guarantee":"Y","UserName":"路飞","Phone":"18767773654","AppointmentState":null,"AppointmentMessage":null,"page":1,"limit":10,"Version":0}],"LeavemessageList":[],"LeavemessageimgList":[],"IsPressFactory":null,"WorkerComplaint":null,"FactoryComplaint":null,"IsLook":"1","FIsLook":"1","page":0,"limit":0,"StateList":[],"AccessorySearchStateList":null,"EndTime":null,"StartTime":null,"isOnLookMessage":0,"AppointmentRefuseState":null,"InvoiceName":null,"AccessoryRefuseState":null,"FactoryApplyState":null,"OrderApplyState":null,"AccessoryIsPay":null,"OrderSort":null,"partsIs":null,"messageIs":null,"SendUserIs":null,"uniqId":null,"IsSettlement":null,"SettlementMoney":0,"SettlementTime":"0001-01-01T00:00:00","OrderAccessoryStr":null,"ContinueIssuing":null,"Version":0},{"Id":2000002857,"OrderID":2000002857,"TypeID":1,"TypeName":"维修","SubTypeID":0,"Frozen":75,"SubTypeName":null,"CategoryID":287,"CategoryName":"冰洗类","SubCategoryID":250,"SubCategoryName":"冰箱","Memo":"测试","BrandID":230,"BrandName":"lol","SendAddress":null,"ProductType":"单门 容积X≤100","ProductTypeID":"251","Num":1,"ProvinceCode":"120000","CityCode":"120100","AreaCode":"120101","DistrictCode":"120101004","Address":"天津市天津市 和平区新兴街道。","Longitude":"117.186340","Dimension":"39.105538","UserID":"18888888888","ComID":null,"Guarantee":"Y","UserName":"路飞","Phone":"18767773654","CreateDate":"2019-11-11T17:32:55","AudDate":"2019-11-11T17:32:55","ReceiveOrderDate":null,"RepairCompleteDate":null,"AppraiseDate":null,"State":"9","FakerTime":0,"StateHtml":"远程费审核","Extra":"N","ExtraTime":"0","IsCall":null,"ExtraFee":0,"IsUse":"Y","SendUser":"18767773654","OrgSendUser":null,"LoginUser":"System","IsPay":"Y","OrderMoney":35,"terraceMoney":0,"InitMoney":0,"ExamineMoney":0,"AgainMoney":0,"RelationOrderID":0,"BeyondMoney":52,"QuaMoney":0,"BeyondID":214,"BeyondState":"0","BeyondDistance":null,"Accessory":null,"AccessorySequency":null,"AccessoryApplyState":null,"AccessoryAndServiceApplyState":null,"AccessoryState":"","AccessorySendState":null,"AccessoryMoney":0,"AccessorySearchState":"0","AccessoryApplyDate":null,"AccessoryMemo":null,"AccessoryServiceMoney":0,"Service":null,"ServiceMoney":0,"ServiceApplyState":null,"ServiceApplyDate":null,"AccessoryAndServiceApplyDate":null,"StarOrder":null,"FStarOrder":null,"PostPayType":"","PostMoney":0,"NewMoney":null,"AddressBack":"","IsReturn":"","ApplyNum":0,"QApplyNum":0,"MallID":0,"EndRemark":null,"Grade":0,"Grade1":0,"Grade2":0,"Grade3":0,"ReturnAccessory":null,"ReturnAccessoryMsg":null,"ApplyCancel":null,"OrgAppraise":null,"UpdateTime":"0001-01-01T00:00:00","LateTime":"0001-01-01T00:00:00","IsExtraTime":null,"OrderPayStr":null,"ThirdPartyNo":null,"PartyNo":"","ExpressNo":null,"RecycleOrderHour":48,"IsRecevieGoods":"N","AppointmentMessage":null,"AppointmentState":null,"IsLate":null,"Distance":0,"DistanceTureOrFalse":false,"SendOrderState":null,"SendOrderMsg":null,"IsSendRepair":null,"OrderSource":null,"OrderImg":[],"ReturnaccessoryImg":[],"OrderAccessroyDetail":[],"OrderServiceDetail":[],"OrderBeyondImg":[{"Id":173,"OrderBeyondImgID":173,"Url":"6842a604f82e4552b4285c70700cc92d.jpg","OrderID":2000002857,"CreateTime":"2019-11-11T17:33:53","IsUse":"Y","page":1,"limit":999,"Version":0}],"OrderComplaintDetail":[],"OrderAppraiseDetail":[],"SendOrderList":[{"Id":3055,"SendID":3055,"CreateDate":"2019-11-11T17: 32:55","UserID":"18767773654","OrderID":2000002857,"State":"0","UpdateDate":null,"ServiceDate":null,"ServiceDate2":null,"LoginUser":"system","IsUse":"Y","CategoryID":287,"CategoryName":"冰洗类","SubTypeID":0,"SubTypeName":null,"Memo":"测试","BrandID":230,"BrandName":"lol","ProductType":"单门 容积X≤100","ProvinceCode":"120000","CityCode":"120100","AreaCode":"120101","Address":"天津市天津市 和平区新兴街道。","Guarantee":"Y","UserName":"路飞","Phone":"18767773654","AppointmentState":null,"AppointmentMessage":null,"page":1,"limit":10,"Version":0}],"LeavemessageList":[{"Id":196,"LeaveMessageId":196,"UserId":"18767773654","UserName":"我","Type":"1","OrderId":2000002857,"Content":"123","photo":null,"CreateDate":"2019-11-19T16:45:25","IsUse":"Y","factoryIslook":null,"workerIslook":"2","platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":342,"LeaveMessageId":342,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"16mm","photo":"bb857d1273ac4b679fcfb4ee15b85959.jpeg","CreateDate":"2019-12-09T15:23:55","IsUse":"Y","factoryIslook":null,"workerIslook":"2","platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":343,"LeaveMessageId":343,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"33331","photo":"bd0ddde833b5445d9708b5f196225809.jpeg","CreateDate":"2019-12-09T15:24:15","IsUse":"Y","factoryIslook":null,"workerIslook":"2","platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":344,"LeaveMessageId":344,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"呃呃呃","photo":null,"CreateDate":"2019-12-09T15:24:36","IsUse":"Y","factoryIslook":null,"workerIslook":"2","platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":345,"LeaveMessageId":345,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"，。。","photo":null,"CreateDate":"2019-12-09T15:25:01","IsUse":"Y","factoryIslook":null,"workerIslook":"2","platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":346,"LeaveMessageId":346,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"123456的","photo":null,"CreateDate":"2019-12-09T15:25:09","IsUse":"Y","factoryIslook":null,"workerIslook":"2","platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":347,"LeaveMessageId":347,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"，，，","photo":null,"CreateDate":"2019-12-09T15:32:34","IsUse":"Y","factoryIslook":null,"workerIslook":"2","platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":348,"LeaveMessageId":348,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"额迷路定嘚瑟哈额","photo":null,"CreateDate":"2019-12-09T15:32:43","IsUse":"Y","factoryIslook":null,"workerIslook":"2","platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":359,"LeaveMessageId":359,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"西瓜","photo":"33a5bb076ab74029a151696b4d1e5611.jpg","CreateDate":"2019-12-10T11:41:54","IsUse":"Y","factoryIslook":null,"workerIslook":null,"platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":360,"LeaveMessageId":360,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"西瓜汁","photo":"33a5bb076ab74029a151696b4d1e5611.jpg","CreateDate":"2019-12-10T11:42:51","IsUse":"Y","factoryIslook":null,"workerIslook":null,"platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":361,"LeaveMessageId":361,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"我在这里等你的消息是真的是1\u20e3️我的错。西瓜西瓜鱼皮儿我","photo":null,"CreateDate":"2019-12-10T11:56:14","IsUse":"Y","factoryIslook":null,"workerIslook":null,"platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":362,"LeaveMessageId":362,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"我在这里等你的消息是真的是1\u20e3️我的错。西瓜皮儿我⬇️","photo":null,"CreateDate":"2019-12-10T12:04:59","IsUse":"Y","factoryIslook":null,"workerIslook":null,"platformIs look":null,"page":1,"limit":999,"Version":0},{"Id":363,"LeaveMessageId":363,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"我在这里等你的消息是真的是1\u20e3️我的错。西瓜皮儿我⬇️","photo":null,"CreateDate":"2019-12-10T12:05:16","IsUse":"Y","factoryIslook":null,"workerIslook":null,"platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":365,"LeaveMessageId":365,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"我在这里等你的消息是真的是1\u20e3️我的错。西瓜皮儿我⬇️","photo":null,"CreateDate":"2019-12-10T12:18:14","IsUse":"Y","factoryIslook":null,"workerIslook":null,"platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":366,"LeaveMessageId":366,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"西瓜等富含丰富的营养丰富成分的产品有丰富了营养成分更容易吸收能力的一切西瓜","photo":"fdeec42a783b4aa0a8c7f9932c3bc6c4.jpg","CreateDate":"2019-12-10T12:29:44","IsUse":"Y","factoryIslook":null,"workerIslook":null,"platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":371,"LeaveMessageId":371,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002857,"Content":"西瓜汁水","photo":"31b618c4da944fd2837afb9004bdfb2c.jpg","CreateDate":"2019-12-10T14:52:53","IsUse":"Y","factoryIslook":null,"workerIslook":null,"platformIslook":null,"page":1,"limit":999,"Version":0}],"LeavemessageimgList":[],"IsPressFactory":"Y","WorkerComplaint":null,"FactoryComplaint":null,"IsLook":"2","FIsLook":"1","page":0,"limit":0,"StateList":[],"AccessorySearchStateList":null,"EndTime":null,"StartTime":null,"isOnLookMessage":0,"AppointmentRefuseState":null,"InvoiceName":null,"AccessoryRefuseState":null,"FactoryApplyState":null,"OrderApplyState":null,"AccessoryIsPay":null,"OrderSort":null,"partsIs":null,"messageIs":null,"SendUserIs":null,"uniqId":null,"IsSettlement":null,"SettlementMoney":0,"SettlementTime":"0001-01-01T00:00:00","OrderAccessoryStr":null,"ContinueIssuing":null,"Version":0},{"Id":2000002994,"OrderID":2000002994,"TypeID":1,"TypeName":"维修","SubTypeID":0,"Frozen":75,"SubTypeName":null,"CategoryID":287,"CategoryName":"冰洗类","SubCategoryID":281,"SubCategoryName":"洗衣机","Memo":"1","BrandID":308,"BrandName":"奥克斯","SendAddress":null,"ProductType":"全自动滚筒洗衣机","ProductTypeID":"282","Num":1,"ProvinceCode":"120000","CityCode":"120100","AreaCode":"120101","DistrictCode":"120101004","Address":"天津市天津市 和平区新兴街道，","Longitude":"117.186340","Dimension":"39.105538","UserID":"18888888888","ComID":null,"Guarantee":"Y","UserName":"逆境","Phone":"18767773654","CreateDate":"2019-11-15T09:25:24","AudDate":"2019-11-15T09:25:24","ReceiveOrderDate":"2019-11-21T10:15:53","RepairCompleteDate":null,"AppraiseDate":null,"State":"9","FakerTime":0,"StateHtml":"远程费审核","Extra":"N","ExtraTime":"0","IsCall":null,"ExtraFee":0,"IsUse":"Y","SendUser":"18767773654","OrgSendUser":null,"LoginUser":"System","IsPay":"Y","OrderMoney":35,"terraceMoney":0,"InitMoney":0,"ExamineMoney":0,"AgainMoney":0,"RelationOrderID":0,"BeyondMoney":9999,"QuaMoney":0,"BeyondID":233,"BeyondState":"0","BeyondDistance":null,"Accessory":null,"AccessorySequency":null,"AccessoryApplyState":null,"AccessoryAndServiceApplyState":null,"AccessoryState":"","AccessorySendState":null,"AccessoryMoney":0,"AccessorySearchState":"0","AccessoryApplyDate":null,"AccessoryMemo":null,"AccessoryServiceMoney":0,"Service":null,"ServiceMoney":0,"ServiceApplyState":null,"ServiceApplyDate":null,"AccessoryAndServiceApplyDate":null,"StarOrder":null,"FStarOrder":null,"PostPayType":"","PostMoney":0,"NewMoney":null,"AddressBack":"","IsReturn":"","ApplyNum":0,"QApplyNum":0,"MallID":0,"EndRemark":null,"Grade":0,"Grade1":0,"Grade2":0,"Grade3":0,"ReturnAccessory":null,"ReturnAccessoryMsg":null,"ApplyCancel":null,"OrgAppraise":null,"UpdateTime":"0001-01-01T00:00:00","LateTime":"0001-01-01T00:00:00","IsExtraTime":null,"OrderPayStr":null,"ThirdPartyNo":null,"PartyNo":"","ExpressNo":null,"RecycleOrderHour":48,"IsRecevieGoods":"N","AppointmentMessage":null,"AppointmentState":null,"IsLate":null,"Distance":0,"DistanceTureOrFalse":false,"SendOrderState":null,"SendOrderMsg":null,"IsSendRepair":null,"OrderSource":null,"OrderImg":[],"ReturnaccessoryImg":[],"OrderAccessroyDetail":[],"OrderServiceDetail":[],"OrderBeyondImg":[{"Id":192,"OrderBeyondImgID":192,"Url":"33b09b016dd64574b8dac5b8cfc5adca.jpg","OrderID":2000002994,"CreateTime":"2019-11-21T11:53:42","IsUse":"Y","page":1,"limit":999,"Version":0}],"OrderComplaintDetail":[{"Id":69,"ComplaintID":69,"Type":"W","OrderID":2000002994,"Content":"123","UserID":"18767773654","CreateTime":"2019-12-18T14:19:08","ComplaintUser":"18888888888","ComplaintType":"F","Photo":"94712052a0944212b7517425357fe500.jpg","IsUse":"Y","page":1,"limit":999,"Version":0},{"Id":72,"ComplaintID":72,"Type":"W","OrderID":2000002994,"Content":"123","UserID":"18767773654","CreateTime":"2019-12-18T14:46:36","ComplaintUser":"18888888888","ComplaintType":"F","Photo":null,"IsUse":"Y","page":1,"limit":999,"Version":0},{"Id":73,"ComplaintID":73,"Type":"W","OrderID":2000002994,"Content":"3","UserID":"18767773654","CreateTime":"2019-12-18T15:54:19","ComplaintUser":"18767773654","ComplaintType":"P","Photo":null,"IsUse":"Y","page":1,"limit":999,"Version":0}],"OrderAppraiseDetail":[],"SendOrderList":[{"Id":3173,"SendID":3173,"CreateDate":"2019-11-15T09:25:24","UserID":"18767773654","OrderID":2000002994,"State":"1","UpdateDate":"2019-11-21T10:15:53","ServiceDate":null,"ServiceDate2":null,"LoginUser":"system","IsUse":"Y","CategoryID":287,"CategoryName":"冰洗类","SubTypeID":0,"SubTypeName":null,"Memo":"1","BrandID":308,"BrandName":"奥克斯","ProductType":"全自动滚筒洗衣机","ProvinceCode":"120000","CityCode":"120100","AreaCode":"120101","Address":"天津市天津市 和平区新兴街道，","Guarantee":"Y","UserName":"逆境","Phone":"18767773654","AppointmentState":null,"AppointmentMessage":null,"page":1,"limit":10,"Version":0}],"LeavemessageList":[{"Id":372,"LeaveMessageId":372,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002994,"Content":"西瓜","photo":null,"CreateDate":"2019-12-10T15:05:21","IsUse":"Y","factoryIslook":null,"workerIslook":null,"platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":373,"LeaveMessageId":373,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002994,"Content":"我也不","photo":null,"CreateDate":"2019-12-10T15:05:29","IsUse":"Y","factoryIslook":null,"workerIslook":null,"platformIslook":null,"page":1,"limit":999,"Version":0},{"Id":374,"LeaveMessageId":374,"UserId":"18767773654","UserName":"林俊杰","Type":"1","OrderId":2000002994,"Content":"我要你","photo":"a69ef135a9b44bed977567229c53584e.jpg","CreateDate":"2019-12-10T15:05:45","IsUse":"Y","factoryIslook":null,"workerIslook":null,"platformIslook":null,"page":1,"limit":999,"Version":0}],"LeavemessageimgList":[],"IsPressFactory":null,"WorkerComplaint":"W","FactoryComplaint":null,"IsLook":"2","FIsLook":"1","page":0,"limit":0,"StateList":[],"AccessorySearchStateList":null,"EndTime":null,"StartTime":null,"isOnLookMessage":0,"AppointmentRefuseState":null,"InvoiceName":null,"AccessoryRefuseState":null,"FactoryApplyState":null,"OrderApplyState":null,"AccessoryIsPay":null,"OrderSort":null,"partsIs":null,"messageIs":null,"SendUserIs":null,"uniqId":null,"IsSettlement":null,"SettlementMoney":0,"SettlementTime":"0001-01-01T00:00:00","OrderAccessoryStr":null,"ContinueIssuing":null,"Version":0}]
     */

    private String Info;
    private String msg;
    private int StatusCode;
    private int count;
    private List<DataBean> data;

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * Id : 2000002850
         * OrderID : 2000002850
         * TypeID : 1
         * TypeName : 维修
         * SubTypeID : 0
         * Frozen : 75
         * SubTypeName : null
         * CategoryID : 287
         * CategoryName : 冰洗类
         * SubCategoryID : 250
         * SubCategoryName : 冰箱
         * Memo : 测试
         * BrandID : 230
         * BrandName : lol
         * SendAddress : null
         * ProductType : 单门 容积X≤100
         * ProductTypeID : 251
         * Num : 1
         * ProvinceCode : 120000
         * CityCode : 120100
         * AreaCode : 120101
         * DistrictCode : 120101004
         * Address : 天津市天津市 和平区新兴街道。
         * Longitude : 117.186340
         * Dimension : 39.105538
         * UserID : 18888888888
         * ComID : null
         * Guarantee : Y
         * UserName : 路飞
         * Phone : 18767773654
         * CreateDate : 2019-11-11T17:31:59
         * AudDate : 2019-11-11T17:31:59
         * ReceiveOrderDate : null
         * RepairCompleteDate : null
         * AppraiseDate : null
         * State : 9
         * FakerTime : 0
         * StateHtml : 远程费审核
         * Extra : N
         * ExtraTime : 0
         * IsCall : null
         * ExtraFee : 0
         * IsUse : Y
         * SendUser : 18767773654
         * OrgSendUser : null
         * LoginUser : System
         * IsPay : Y
         * OrderMoney : 35
         * terraceMoney : 0
         * InitMoney : 0
         * ExamineMoney : 0
         * AgainMoney : 0
         * RelationOrderID : 0
         * BeyondMoney : 9999
         * QuaMoney : 0
         * BeyondID : 237
         * BeyondState : 0
         * BeyondDistance : 9999
         * Accessory : null
         * AccessorySequency : null
         * AccessoryApplyState : null
         * AccessoryAndServiceApplyState : null
         * AccessoryState :
         * AccessorySendState : null
         * AccessoryMoney : 0
         * AccessorySearchState : 0
         * AccessoryApplyDate : null
         * AccessoryMemo : null
         * AccessoryServiceMoney : 0
         * Service : null
         * ServiceMoney : 0
         * ServiceApplyState : null
         * ServiceApplyDate : null
         * AccessoryAndServiceApplyDate : null
         * StarOrder : null
         * FStarOrder : null
         * PostPayType :
         * PostMoney : 0
         * NewMoney : null
         * AddressBack :
         * IsReturn :
         * ApplyNum : 0
         * QApplyNum : 0
         * MallID : 0
         * EndRemark : null
         * Grade : 0
         * Grade1 : 0
         * Grade2 : 0
         * Grade3 : 0
         * ReturnAccessory : null
         * ReturnAccessoryMsg : null
         * ApplyCancel : null
         * OrgAppraise : null
         * UpdateTime : 0001-01-01T00:00:00
         * LateTime : 0001-01 -01T00:00:00
         * IsExtraTime : null
         * OrderPayStr : null
         * ThirdPartyNo : null
         * PartyNo :
         * ExpressNo : null
         * RecycleOrderHour : 48
         * IsRecevieGoods : N
         * AppointmentMessage : null
         * AppointmentState : null
         * IsLate : null
         * Distance : 0
         * DistanceTureOrFalse : false
         * SendOrderState : null
         * SendOrderMsg : null
         * IsSendRepair : null
         * OrderSource : null
         * OrderImg : []
         * ReturnaccessoryImg : []
         * OrderAccessroyDetail : []
         * OrderServiceDetail : []
         * OrderBeyondImg : [{"Id":196,"OrderBeyondImgID":196,"Url":"53fc78f5f814451b95bd3c2f045ef522.jpg","OrderID":2000002850,"CreateTime":"2019-11-24T14:37:57","IsUse":"Y","page":1,"limit":999,"Version":0}]
         * OrderComplaintDetail : []
         * OrderAppraiseDetail : []
         * SendOrderList : [{"Id":3048,"SendID":3048,"CreateDate":"2019-11-11T17:31:59","UserID":"18767773654","OrderID":2000002850,"State":"0","UpdateDate":null,"ServiceDate":null,"ServiceDate2":null,"LoginUser":"system","IsUse":"Y","CategoryID":287,"CategoryName":"冰洗类","SubTypeID":0,"SubTypeName":null,"Memo":"测试","BrandID":230,"BrandName":"lol","ProductType":"单门 容积X≤100","ProvinceCode":"120000","CityCode":"120100","AreaCode":"120101","Address":"天津市天津市 和平区新兴街道。","Guarantee":"Y","UserName":"路飞","Phone":"18767773654","AppointmentState":null,"AppointmentMessage":null,"page":1,"limit":10,"Version":0}]
         * LeavemessageList : []
         * LeavemessageimgList : []
         * IsPressFactory : null
         * WorkerComplaint : null
         * FactoryComplaint : null
         * IsLook : 1
         * FIsLook : 1
         * page : 0
         * limit : 0
         * StateList : []
         * AccessorySearchStateList : null
         * EndTime : null
         * StartTime : null
         * isOnLookMessage : 0
         * AppointmentRefuseState : null
         * InvoiceName : null
         * AccessoryRefuseState : null
         * FactoryApplyState : null
         * OrderApplyState : null
         * AccessoryIsPay : null
         * OrderSort : null
         * partsIs : null
         * messageIs : null
         * SendUserIs : null
         * uniqId : null
         * IsSettlement : null
         * SettlementMoney : 0
         * SettlementTime : 0001-01-01T00:00:00
         * OrderAccessoryStr : null
         * ContinueIssuing : null
         * Version : 0
         */

        private int Id;
        private String OrderID;
        private int TypeID;
        private String TypeName;
        private int SubTypeID;
        private int Frozen;
        private Object SubTypeName;
        private int CategoryID;
        private String CategoryName;
        private int SubCategoryID;
        private String SubCategoryName;
        private String Memo;
        private int BrandID;
        private String BrandName;
        private Object SendAddress;
        private String ProductType;
        private String ProductTypeID;
        private int Num;
        private String ProvinceCode;
        private String CityCode;
        private String AreaCode;
        private String DistrictCode;
        private String Address;
        private String Longitude;
        private String Dimension;
        private String UserID;
        private Object ComID;
        private String Guarantee;
        private String UserName;
        private String Phone;
        private String CreateDate;
        private String AudDate;
        private Object ReceiveOrderDate;
        private Object RepairCompleteDate;
        private Object AppraiseDate;
        private String State;
        private int FakerTime;
        private String StateHtml;
        private String Extra;
        private String ExtraTime;
        private Object IsCall;
        private int ExtraFee;
        private String IsUse;
        private String SendUser;
        private Object OrgSendUser;
        private String LoginUser;
        private String IsPay;
        private int OrderMoney;
        private int terraceMoney;
        private int InitMoney;
        private int ExamineMoney;
        private int AgainMoney;
        private int RelationOrderID;
        private int BeyondMoney;
        private int QuaMoney;
        private int BeyondID;
        private String BeyondState;
        private String BeyondDistance;
        private Object Accessory;
        private Object AccessorySequency;
        private Object AccessoryApplyState;
        private Object AccessoryAndServiceApplyState;
        private String AccessoryState;
        private Object AccessorySendState;
        private int AccessoryMoney;
        private String AccessorySearchState;
        private Object AccessoryApplyDate;
        private Object AccessoryMemo;
        private int AccessoryServiceMoney;
        private Object Service;
        private int ServiceMoney;
        private Object ServiceApplyState;
        private Object ServiceApplyDate;
        private Object AccessoryAndServiceApplyDate;
        private Object StarOrder;
        private Object FStarOrder;
        private String PostPayType;
        private int PostMoney;
        private Object NewMoney;
        private String AddressBack;
        private String IsReturn;
        private int ApplyNum;
        private int QApplyNum;
        private int MallID;
        private Object EndRemark;
        private int Grade;
        private int Grade1;
        private int Grade2;
        private int Grade3;
        private Object ReturnAccessory;
        private Object ReturnAccessoryMsg;
        private Object ApplyCancel;
        private Object OrgAppraise;
        private String UpdateTime;
        private String LateTime;
        private Object IsExtraTime;
        private Object OrderPayStr;
        private Object ThirdPartyNo;
        private String PartyNo;
        private Object ExpressNo;
        private int RecycleOrderHour;
        private String IsRecevieGoods;
        private Object AppointmentMessage;
        private Object AppointmentState;
        private Object IsLate;
        private int Distance;
        private boolean DistanceTureOrFalse;
        private Object SendOrderState;
        private Object SendOrderMsg;
        private Object IsSendRepair;
        private Object OrderSource;
        private Object IsPressFactory;
        private Object WorkerComplaint;
        private Object FactoryComplaint;
        private String IsLook;
        private String FIsLook;
        private int page;
        private int limit;
        private Object AccessorySearchStateList;
        private Object EndTime;
        private Object StartTime;
        private int isOnLookMessage;
        private Object AppointmentRefuseState;
        private Object InvoiceName;
        private Object AccessoryRefuseState;
        private Object FactoryApplyState;
        private Object OrderApplyState;
        private Object AccessoryIsPay;
        private Object OrderSort;
        private Object partsIs;
        private Object messageIs;
        private Object SendUserIs;
        private Object uniqId;
        private Object IsSettlement;
        private int SettlementMoney;
        private String SettlementTime;
        private Object OrderAccessoryStr;
        private Object ContinueIssuing;
        private int Version;
        private List<?> OrderImg;
        private List<?> ReturnaccessoryImg;
        private List<?> OrderAccessroyDetail;
        private List<?> OrderServiceDetail;
        private List<OrderBeyondImgBean> OrderBeyondImg;
        private List<?> OrderComplaintDetail;
        private List<?> OrderAppraiseDetail;
        private List<SendOrderListBean> SendOrderList;
        private List<?> LeavemessageList;
        private List<?> LeavemessageimgList;
        private List<?> StateList;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getOrderID() {
            return OrderID;
        }

        public void setOrderID(String OrderID) {
            this.OrderID = OrderID;
        }

        public int getTypeID() {
            return TypeID;
        }

        public void setTypeID(int TypeID) {
            this.TypeID = TypeID;
        }

        public String getTypeName() {
            return TypeName;
        }

        public void setTypeName(String TypeName) {
            this.TypeName = TypeName;
        }

        public int getSubTypeID() {
            return SubTypeID;
        }

        public void setSubTypeID(int SubTypeID) {
            this.SubTypeID = SubTypeID;
        }

        public int getFrozen() {
            return Frozen;
        }

        public void setFrozen(int Frozen) {
            this.Frozen = Frozen;
        }

        public Object getSubTypeName() {
            return SubTypeName;
        }

        public void setSubTypeName(Object SubTypeName) {
            this.SubTypeName = SubTypeName;
        }

        public int getCategoryID() {
            return CategoryID;
        }

        public void setCategoryID(int CategoryID) {
            this.CategoryID = CategoryID;
        }

        public String getCategoryName() {
            return CategoryName;
        }

        public void setCategoryName(String CategoryName) {
            this.CategoryName = CategoryName;
        }

        public int getSubCategoryID() {
            return SubCategoryID;
        }

        public void setSubCategoryID(int SubCategoryID) {
            this.SubCategoryID = SubCategoryID;
        }

        public String getSubCategoryName() {
            return SubCategoryName;
        }

        public void setSubCategoryName(String SubCategoryName) {
            this.SubCategoryName = SubCategoryName;
        }

        public String getMemo() {
            return Memo;
        }

        public void setMemo(String Memo) {
            this.Memo = Memo;
        }

        public int getBrandID() {
            return BrandID;
        }

        public void setBrandID(int BrandID) {
            this.BrandID = BrandID;
        }

        public String getBrandName() {
            return BrandName;
        }

        public void setBrandName(String BrandName) {
            this.BrandName = BrandName;
        }

        public Object getSendAddress() {
            return SendAddress;
        }

        public void setSendAddress(Object SendAddress) {
            this.SendAddress = SendAddress;
        }

        public String getProductType() {
            return ProductType;
        }

        public void setProductType(String ProductType) {
            this.ProductType = ProductType;
        }

        public String getProductTypeID() {
            return ProductTypeID;
        }

        public void setProductTypeID(String ProductTypeID) {
            this.ProductTypeID = ProductTypeID;
        }

        public int getNum() {
            return Num;
        }

        public void setNum(int Num) {
            this.Num = Num;
        }

        public String getProvinceCode() {
            return ProvinceCode;
        }

        public void setProvinceCode(String ProvinceCode) {
            this.ProvinceCode = ProvinceCode;
        }

        public String getCityCode() {
            return CityCode;
        }

        public void setCityCode(String CityCode) {
            this.CityCode = CityCode;
        }

        public String getAreaCode() {
            return AreaCode;
        }

        public void setAreaCode(String AreaCode) {
            this.AreaCode = AreaCode;
        }

        public String getDistrictCode() {
            return DistrictCode;
        }

        public void setDistrictCode(String DistrictCode) {
            this.DistrictCode = DistrictCode;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getLongitude() {
            return Longitude;
        }

        public void setLongitude(String Longitude) {
            this.Longitude = Longitude;
        }

        public String getDimension() {
            return Dimension;
        }

        public void setDimension(String Dimension) {
            this.Dimension = Dimension;
        }

        public String getUserID() {
            return UserID;
        }

        public void setUserID(String UserID) {
            this.UserID = UserID;
        }

        public Object getComID() {
            return ComID;
        }

        public void setComID(Object ComID) {
            this.ComID = ComID;
        }

        public String getGuarantee() {
            if ("Y".equals(Guarantee)){
                return "保内";
            }else{
                return "保外";
            }
        }

        public void setGuarantee(String Guarantee) {
            this.Guarantee = Guarantee;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String Phone) {
            this.Phone = Phone;
        }

        public String getCreateDate() {
            return CreateDate.replace("T"," ");
        }

        public void setCreateDate(String CreateDate) {
            this.CreateDate = CreateDate;
        }

        public String getAudDate() {
            return AudDate;
        }

        public void setAudDate(String AudDate) {
            this.AudDate = AudDate;
        }

        public Object getReceiveOrderDate() {
            return ReceiveOrderDate;
        }

        public void setReceiveOrderDate(Object ReceiveOrderDate) {
            this.ReceiveOrderDate = ReceiveOrderDate;
        }

        public Object getRepairCompleteDate() {
            return RepairCompleteDate;
        }

        public void setRepairCompleteDate(Object RepairCompleteDate) {
            this.RepairCompleteDate = RepairCompleteDate;
        }

        public Object getAppraiseDate() {
            return AppraiseDate;
        }

        public void setAppraiseDate(Object AppraiseDate) {
            this.AppraiseDate = AppraiseDate;
        }

        public String getState() {
            String status="";
            switch (State){
                case "-4":
                    status="关闭工单";
                    break;
                case "-2":
                    status="申请废除工单";
                    break;
                case "-1":
                    status="退单处理";
                    break;
                case "0":
                    status="待审核";
                    break;
                case "1":
                    status="待接单";
                    break;
                case "2":
                    status="已接单待联系客户";
                    break;
                case "3":
                    status="已联系客户待服务";
                    break;
                case "4":
                    status="服务中";
                    break;
                case "5":
                    status="服务完成";
                    break;
                case "6":
                    status="待评价";
                    break;
                case "7":
                    status="已完成";
                    break;
                case "9":
                    status="远程费审核";
                    break;
            }
            return status;
        }

        public void setState(String State) {
            this.State = State;
        }

        public int getFakerTime() {
            return FakerTime;
        }

        public void setFakerTime(int FakerTime) {
            this.FakerTime = FakerTime;
        }

        public String getStateHtml() {
            return StateHtml;
        }

        public void setStateHtml(String StateHtml) {
            this.StateHtml = StateHtml;
        }

        public String getExtra() {
            return Extra;
        }

        public void setExtra(String Extra) {
            this.Extra = Extra;
        }

        public String getExtraTime() {
            return ExtraTime;
        }

        public void setExtraTime(String ExtraTime) {
            this.ExtraTime = ExtraTime;
        }

        public Object getIsCall() {
            return IsCall;
        }

        public void setIsCall(Object IsCall) {
            this.IsCall = IsCall;
        }

        public int getExtraFee() {
            return ExtraFee;
        }

        public void setExtraFee(int ExtraFee) {
            this.ExtraFee = ExtraFee;
        }

        public String getIsUse() {
            return IsUse;
        }

        public void setIsUse(String IsUse) {
            this.IsUse = IsUse;
        }

        public String getSendUser() {
            return SendUser;
        }

        public void setSendUser(String SendUser) {
            this.SendUser = SendUser;
        }

        public Object getOrgSendUser() {
            return OrgSendUser;
        }

        public void setOrgSendUser(Object OrgSendUser) {
            this.OrgSendUser = OrgSendUser;
        }

        public String getLoginUser() {
            return LoginUser;
        }

        public void setLoginUser(String LoginUser) {
            this.LoginUser = LoginUser;
        }

        public String getIsPay() {
            return IsPay;
        }

        public void setIsPay(String IsPay) {
            this.IsPay = IsPay;
        }

        public int getOrderMoney() {
            return OrderMoney;
        }

        public void setOrderMoney(int OrderMoney) {
            this.OrderMoney = OrderMoney;
        }

        public int getTerraceMoney() {
            return terraceMoney;
        }

        public void setTerraceMoney(int terraceMoney) {
            this.terraceMoney = terraceMoney;
        }

        public int getInitMoney() {
            return InitMoney;
        }

        public void setInitMoney(int InitMoney) {
            this.InitMoney = InitMoney;
        }

        public int getExamineMoney() {
            return ExamineMoney;
        }

        public void setExamineMoney(int ExamineMoney) {
            this.ExamineMoney = ExamineMoney;
        }

        public int getAgainMoney() {
            return AgainMoney;
        }

        public void setAgainMoney(int AgainMoney) {
            this.AgainMoney = AgainMoney;
        }

        public int getRelationOrderID() {
            return RelationOrderID;
        }

        public void setRelationOrderID(int RelationOrderID) {
            this.RelationOrderID = RelationOrderID;
        }

        public int getBeyondMoney() {
            return BeyondMoney;
        }

        public void setBeyondMoney(int BeyondMoney) {
            this.BeyondMoney = BeyondMoney;
        }

        public int getQuaMoney() {
            return QuaMoney;
        }

        public void setQuaMoney(int QuaMoney) {
            this.QuaMoney = QuaMoney;
        }

        public int getBeyondID() {
            return BeyondID;
        }

        public void setBeyondID(int BeyondID) {
            this.BeyondID = BeyondID;
        }

        public String getBeyondState() {
            return BeyondState;
        }

        public void setBeyondState(String BeyondState) {
            this.BeyondState = BeyondState;
        }

        public String getBeyondDistance() {
            return BeyondDistance;
        }

        public void setBeyondDistance(String BeyondDistance) {
            this.BeyondDistance = BeyondDistance;
        }

        public Object getAccessory() {
            return Accessory;
        }

        public void setAccessory(Object Accessory) {
            this.Accessory = Accessory;
        }

        public Object getAccessorySequency() {
            return AccessorySequency;
        }

        public void setAccessorySequency(Object AccessorySequency) {
            this.AccessorySequency = AccessorySequency;
        }

        public Object getAccessoryApplyState() {
            return AccessoryApplyState;
        }

        public void setAccessoryApplyState(Object AccessoryApplyState) {
            this.AccessoryApplyState = AccessoryApplyState;
        }

        public Object getAccessoryAndServiceApplyState() {
            return AccessoryAndServiceApplyState;
        }

        public void setAccessoryAndServiceApplyState(Object AccessoryAndServiceApplyState) {
            this.AccessoryAndServiceApplyState = AccessoryAndServiceApplyState;
        }

        public String getAccessoryState() {
            return AccessoryState;
        }

        public void setAccessoryState(String AccessoryState) {
            this.AccessoryState = AccessoryState;
        }

        public Object getAccessorySendState() {
            return AccessorySendState;
        }

        public void setAccessorySendState(Object AccessorySendState) {
            this.AccessorySendState = AccessorySendState;
        }

        public int getAccessoryMoney() {
            return AccessoryMoney;
        }

        public void setAccessoryMoney(int AccessoryMoney) {
            this.AccessoryMoney = AccessoryMoney;
        }

        public String getAccessorySearchState() {
            return AccessorySearchState;
        }

        public void setAccessorySearchState(String AccessorySearchState) {
            this.AccessorySearchState = AccessorySearchState;
        }

        public Object getAccessoryApplyDate() {
            return AccessoryApplyDate;
        }

        public void setAccessoryApplyDate(Object AccessoryApplyDate) {
            this.AccessoryApplyDate = AccessoryApplyDate;
        }

        public Object getAccessoryMemo() {
            return AccessoryMemo;
        }

        public void setAccessoryMemo(Object AccessoryMemo) {
            this.AccessoryMemo = AccessoryMemo;
        }

        public int getAccessoryServiceMoney() {
            return AccessoryServiceMoney;
        }

        public void setAccessoryServiceMoney(int AccessoryServiceMoney) {
            this.AccessoryServiceMoney = AccessoryServiceMoney;
        }

        public Object getService() {
            return Service;
        }

        public void setService(Object Service) {
            this.Service = Service;
        }

        public int getServiceMoney() {
            return ServiceMoney;
        }

        public void setServiceMoney(int ServiceMoney) {
            this.ServiceMoney = ServiceMoney;
        }

        public Object getServiceApplyState() {
            return ServiceApplyState;
        }

        public void setServiceApplyState(Object ServiceApplyState) {
            this.ServiceApplyState = ServiceApplyState;
        }

        public Object getServiceApplyDate() {
            return ServiceApplyDate;
        }

        public void setServiceApplyDate(Object ServiceApplyDate) {
            this.ServiceApplyDate = ServiceApplyDate;
        }

        public Object getAccessoryAndServiceApplyDate() {
            return AccessoryAndServiceApplyDate;
        }

        public void setAccessoryAndServiceApplyDate(Object AccessoryAndServiceApplyDate) {
            this.AccessoryAndServiceApplyDate = AccessoryAndServiceApplyDate;
        }

        public Object getStarOrder() {
            return StarOrder;
        }

        public void setStarOrder(Object StarOrder) {
            this.StarOrder = StarOrder;
        }

        public Object getFStarOrder() {
            return FStarOrder;
        }

        public void setFStarOrder(Object FStarOrder) {
            this.FStarOrder = FStarOrder;
        }

        public String getPostPayType() {
            return PostPayType;
        }

        public void setPostPayType(String PostPayType) {
            this.PostPayType = PostPayType;
        }

        public int getPostMoney() {
            return PostMoney;
        }

        public void setPostMoney(int PostMoney) {
            this.PostMoney = PostMoney;
        }

        public Object getNewMoney() {
            return NewMoney;
        }

        public void setNewMoney(Object NewMoney) {
            this.NewMoney = NewMoney;
        }

        public String getAddressBack() {
            return AddressBack;
        }

        public void setAddressBack(String AddressBack) {
            this.AddressBack = AddressBack;
        }

        public String getIsReturn() {
            return IsReturn;
        }

        public void setIsReturn(String IsReturn) {
            this.IsReturn = IsReturn;
        }

        public int getApplyNum() {
            return ApplyNum;
        }

        public void setApplyNum(int ApplyNum) {
            this.ApplyNum = ApplyNum;
        }

        public int getQApplyNum() {
            return QApplyNum;
        }

        public void setQApplyNum(int QApplyNum) {
            this.QApplyNum = QApplyNum;
        }

        public int getMallID() {
            return MallID;
        }

        public void setMallID(int MallID) {
            this.MallID = MallID;
        }

        public Object getEndRemark() {
            return EndRemark;
        }

        public void setEndRemark(Object EndRemark) {
            this.EndRemark = EndRemark;
        }

        public int getGrade() {
            return Grade;
        }

        public void setGrade(int Grade) {
            this.Grade = Grade;
        }

        public int getGrade1() {
            return Grade1;
        }

        public void setGrade1(int Grade1) {
            this.Grade1 = Grade1;
        }

        public int getGrade2() {
            return Grade2;
        }

        public void setGrade2(int Grade2) {
            this.Grade2 = Grade2;
        }

        public int getGrade3() {
            return Grade3;
        }

        public void setGrade3(int Grade3) {
            this.Grade3 = Grade3;
        }

        public Object getReturnAccessory() {
            return ReturnAccessory;
        }

        public void setReturnAccessory(Object ReturnAccessory) {
            this.ReturnAccessory = ReturnAccessory;
        }

        public Object getReturnAccessoryMsg() {
            return ReturnAccessoryMsg;
        }

        public void setReturnAccessoryMsg(Object ReturnAccessoryMsg) {
            this.ReturnAccessoryMsg = ReturnAccessoryMsg;
        }

        public Object getApplyCancel() {
            return ApplyCancel;
        }

        public void setApplyCancel(Object ApplyCancel) {
            this.ApplyCancel = ApplyCancel;
        }

        public Object getOrgAppraise() {
            return OrgAppraise;
        }

        public void setOrgAppraise(Object OrgAppraise) {
            this.OrgAppraise = OrgAppraise;
        }

        public String getUpdateTime() {
            return UpdateTime;
        }

        public void setUpdateTime(String UpdateTime) {
            this.UpdateTime = UpdateTime;
        }

        public String getLateTime() {
            return LateTime;
        }

        public void setLateTime(String LateTime) {
            this.LateTime = LateTime;
        }

        public Object getIsExtraTime() {
            return IsExtraTime;
        }

        public void setIsExtraTime(Object IsExtraTime) {
            this.IsExtraTime = IsExtraTime;
        }

        public Object getOrderPayStr() {
            return OrderPayStr;
        }

        public void setOrderPayStr(Object OrderPayStr) {
            this.OrderPayStr = OrderPayStr;
        }

        public Object getThirdPartyNo() {
            return ThirdPartyNo;
        }

        public void setThirdPartyNo(Object ThirdPartyNo) {
            this.ThirdPartyNo = ThirdPartyNo;
        }

        public String getPartyNo() {
            return PartyNo;
        }

        public void setPartyNo(String PartyNo) {
            this.PartyNo = PartyNo;
        }

        public Object getExpressNo() {
            return ExpressNo;
        }

        public void setExpressNo(Object ExpressNo) {
            this.ExpressNo = ExpressNo;
        }

        public int getRecycleOrderHour() {
            return RecycleOrderHour;
        }

        public void setRecycleOrderHour(int RecycleOrderHour) {
            this.RecycleOrderHour = RecycleOrderHour;
        }

        public String getIsRecevieGoods() {
            return IsRecevieGoods;
        }

        public void setIsRecevieGoods(String IsRecevieGoods) {
            this.IsRecevieGoods = IsRecevieGoods;
        }

        public Object getAppointmentMessage() {
            return AppointmentMessage;
        }

        public void setAppointmentMessage(Object AppointmentMessage) {
            this.AppointmentMessage = AppointmentMessage;
        }

        public Object getAppointmentState() {
            return AppointmentState;
        }

        public void setAppointmentState(Object AppointmentState) {
            this.AppointmentState = AppointmentState;
        }

        public Object getIsLate() {
            return IsLate;
        }

        public void setIsLate(Object IsLate) {
            this.IsLate = IsLate;
        }

        public int getDistance() {
            return Distance;
        }

        public void setDistance(int Distance) {
            this.Distance = Distance;
        }

        public boolean isDistanceTureOrFalse() {
            return DistanceTureOrFalse;
        }

        public void setDistanceTureOrFalse(boolean DistanceTureOrFalse) {
            this.DistanceTureOrFalse = DistanceTureOrFalse;
        }

        public Object getSendOrderState() {
            return SendOrderState;
        }

        public void setSendOrderState(Object SendOrderState) {
            this.SendOrderState = SendOrderState;
        }

        public Object getSendOrderMsg() {
            return SendOrderMsg;
        }

        public void setSendOrderMsg(Object SendOrderMsg) {
            this.SendOrderMsg = SendOrderMsg;
        }

        public Object getIsSendRepair() {
            return IsSendRepair;
        }

        public void setIsSendRepair(Object IsSendRepair) {
            this.IsSendRepair = IsSendRepair;
        }

        public Object getOrderSource() {
            return OrderSource;
        }

        public void setOrderSource(Object OrderSource) {
            this.OrderSource = OrderSource;
        }

        public Object getIsPressFactory() {
            return IsPressFactory;
        }

        public void setIsPressFactory(Object IsPressFactory) {
            this.IsPressFactory = IsPressFactory;
        }

        public Object getWorkerComplaint() {
            return WorkerComplaint;
        }

        public void setWorkerComplaint(Object WorkerComplaint) {
            this.WorkerComplaint = WorkerComplaint;
        }

        public Object getFactoryComplaint() {
            return FactoryComplaint;
        }

        public void setFactoryComplaint(Object FactoryComplaint) {
            this.FactoryComplaint = FactoryComplaint;
        }

        public String getIsLook() {
            return IsLook;
        }

        public void setIsLook(String IsLook) {
            this.IsLook = IsLook;
        }

        public String getFIsLook() {
            return FIsLook;
        }

        public void setFIsLook(String FIsLook) {
            this.FIsLook = FIsLook;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public Object getAccessorySearchStateList() {
            return AccessorySearchStateList;
        }

        public void setAccessorySearchStateList(Object AccessorySearchStateList) {
            this.AccessorySearchStateList = AccessorySearchStateList;
        }

        public Object getEndTime() {
            return EndTime;
        }

        public void setEndTime(Object EndTime) {
            this.EndTime = EndTime;
        }

        public Object getStartTime() {
            return StartTime;
        }

        public void setStartTime(Object StartTime) {
            this.StartTime = StartTime;
        }

        public int getIsOnLookMessage() {
            return isOnLookMessage;
        }

        public void setIsOnLookMessage(int isOnLookMessage) {
            this.isOnLookMessage = isOnLookMessage;
        }

        public Object getAppointmentRefuseState() {
            return AppointmentRefuseState;
        }

        public void setAppointmentRefuseState(Object AppointmentRefuseState) {
            this.AppointmentRefuseState = AppointmentRefuseState;
        }

        public Object getInvoiceName() {
            return InvoiceName;
        }

        public void setInvoiceName(Object InvoiceName) {
            this.InvoiceName = InvoiceName;
        }

        public Object getAccessoryRefuseState() {
            return AccessoryRefuseState;
        }

        public void setAccessoryRefuseState(Object AccessoryRefuseState) {
            this.AccessoryRefuseState = AccessoryRefuseState;
        }

        public Object getFactoryApplyState() {
            return FactoryApplyState;
        }

        public void setFactoryApplyState(Object FactoryApplyState) {
            this.FactoryApplyState = FactoryApplyState;
        }

        public Object getOrderApplyState() {
            return OrderApplyState;
        }

        public void setOrderApplyState(Object OrderApplyState) {
            this.OrderApplyState = OrderApplyState;
        }

        public Object getAccessoryIsPay() {
            return AccessoryIsPay;
        }

        public void setAccessoryIsPay(Object AccessoryIsPay) {
            this.AccessoryIsPay = AccessoryIsPay;
        }

        public Object getOrderSort() {
            return OrderSort;
        }

        public void setOrderSort(Object OrderSort) {
            this.OrderSort = OrderSort;
        }

        public Object getPartsIs() {
            return partsIs;
        }

        public void setPartsIs(Object partsIs) {
            this.partsIs = partsIs;
        }

        public Object getMessageIs() {
            return messageIs;
        }

        public void setMessageIs(Object messageIs) {
            this.messageIs = messageIs;
        }

        public Object getSendUserIs() {
            return SendUserIs;
        }

        public void setSendUserIs(Object SendUserIs) {
            this.SendUserIs = SendUserIs;
        }

        public Object getUniqId() {
            return uniqId;
        }

        public void setUniqId(Object uniqId) {
            this.uniqId = uniqId;
        }

        public Object getIsSettlement() {
            return IsSettlement;
        }

        public void setIsSettlement(Object IsSettlement) {
            this.IsSettlement = IsSettlement;
        }

        public int getSettlementMoney() {
            return SettlementMoney;
        }

        public void setSettlementMoney(int SettlementMoney) {
            this.SettlementMoney = SettlementMoney;
        }

        public String getSettlementTime() {
            return SettlementTime;
        }

        public void setSettlementTime(String SettlementTime) {
            this.SettlementTime = SettlementTime;
        }

        public Object getOrderAccessoryStr() {
            return OrderAccessoryStr;
        }

        public void setOrderAccessoryStr(Object OrderAccessoryStr) {
            this.OrderAccessoryStr = OrderAccessoryStr;
        }

        public Object getContinueIssuing() {
            return ContinueIssuing;
        }

        public void setContinueIssuing(Object ContinueIssuing) {
            this.ContinueIssuing = ContinueIssuing;
        }

        public int getVersion() {
            return Version;
        }

        public void setVersion(int Version) {
            this.Version = Version;
        }

        public List<?> getOrderImg() {
            return OrderImg;
        }

        public void setOrderImg(List<?> OrderImg) {
            this.OrderImg = OrderImg;
        }

        public List<?> getReturnaccessoryImg() {
            return ReturnaccessoryImg;
        }

        public void setReturnaccessoryImg(List<?> ReturnaccessoryImg) {
            this.ReturnaccessoryImg = ReturnaccessoryImg;
        }

        public List<?> getOrderAccessroyDetail() {
            return OrderAccessroyDetail;
        }

        public void setOrderAccessroyDetail(List<?> OrderAccessroyDetail) {
            this.OrderAccessroyDetail = OrderAccessroyDetail;
        }

        public List<?> getOrderServiceDetail() {
            return OrderServiceDetail;
        }

        public void setOrderServiceDetail(List<?> OrderServiceDetail) {
            this.OrderServiceDetail = OrderServiceDetail;
        }

        public List<OrderBeyondImgBean> getOrderBeyondImg() {
            return OrderBeyondImg;
        }

        public void setOrderBeyondImg(List<OrderBeyondImgBean> OrderBeyondImg) {
            this.OrderBeyondImg = OrderBeyondImg;
        }

        public List<?> getOrderComplaintDetail() {
            return OrderComplaintDetail;
        }

        public void setOrderComplaintDetail(List<?> OrderComplaintDetail) {
            this.OrderComplaintDetail = OrderComplaintDetail;
        }

        public List<?> getOrderAppraiseDetail() {
            return OrderAppraiseDetail;
        }

        public void setOrderAppraiseDetail(List<?> OrderAppraiseDetail) {
            this.OrderAppraiseDetail = OrderAppraiseDetail;
        }

        public List<SendOrderListBean> getSendOrderList() {
            return SendOrderList;
        }

        public void setSendOrderList(List<SendOrderListBean> SendOrderList) {
            this.SendOrderList = SendOrderList;
        }

        public List<?> getLeavemessageList() {
            return LeavemessageList;
        }

        public void setLeavemessageList(List<?> LeavemessageList) {
            this.LeavemessageList = LeavemessageList;
        }

        public List<?> getLeavemessageimgList() {
            return LeavemessageimgList;
        }

        public void setLeavemessageimgList(List<?> LeavemessageimgList) {
            this.LeavemessageimgList = LeavemessageimgList;
        }

        public List<?> getStateList() {
            return StateList;
        }

        public void setStateList(List<?> StateList) {
            this.StateList = StateList;
        }

        public static class OrderBeyondImgBean {
            /**
             * Id : 196
             * OrderBeyondImgID : 196
             * Url : 53fc78f5f814451b95bd3c2f045ef522.jpg
             * OrderID : 2000002850
             * CreateTime : 2019-11-24T14:37:57
             * IsUse : Y
             * page : 1
             * limit : 999
             * Version : 0
             */

            private int Id;
            private int OrderBeyondImgID;
            private String Url;
            private int OrderID;
            private String CreateTime;
            private String IsUse;
            private int page;
            private int limit;
            private int Version;

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public int getOrderBeyondImgID() {
                return OrderBeyondImgID;
            }

            public void setOrderBeyondImgID(int OrderBeyondImgID) {
                this.OrderBeyondImgID = OrderBeyondImgID;
            }

            public String getUrl() {
                return Url;
            }

            public void setUrl(String Url) {
                this.Url = Url;
            }

            public int getOrderID() {
                return OrderID;
            }

            public void setOrderID(int OrderID) {
                this.OrderID = OrderID;
            }

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String CreateTime) {
                this.CreateTime = CreateTime;
            }

            public String getIsUse() {
                return IsUse;
            }

            public void setIsUse(String IsUse) {
                this.IsUse = IsUse;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public int getLimit() {
                return limit;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public int getVersion() {
                return Version;
            }

            public void setVersion(int Version) {
                this.Version = Version;
            }
        }

        public static class SendOrderListBean {
            /**
             * Id : 3048
             * SendID : 3048
             * CreateDate : 2019-11-11T17:31:59
             * UserID : 18767773654
             * OrderID : 2000002850
             * State : 0
             * UpdateDate : null
             * ServiceDate : null
             * ServiceDate2 : null
             * LoginUser : system
             * IsUse : Y
             * CategoryID : 287
             * CategoryName : 冰洗类
             * SubTypeID : 0
             * SubTypeName : null
             * Memo : 测试
             * BrandID : 230
             * BrandName : lol
             * ProductType : 单门 容积X≤100
             * ProvinceCode : 120000
             * CityCode : 120100
             * AreaCode : 120101
             * Address : 天津市天津市 和平区新兴街道。
             * Guarantee : Y
             * UserName : 路飞
             * Phone : 18767773654
             * AppointmentState : null
             * AppointmentMessage : null
             * page : 1
             * limit : 10
             * Version : 0
             */

            private int Id;
            private int SendID;
            private String CreateDate;
            private String UserID;
            private int OrderID;
            private String State;
            private Object UpdateDate;
            private Object ServiceDate;
            private Object ServiceDate2;
            private String LoginUser;
            private String IsUse;
            private int CategoryID;
            private String CategoryName;
            private int SubTypeID;
            private Object SubTypeName;
            private String Memo;
            private int BrandID;
            private String BrandName;
            private String ProductType;
            private String ProvinceCode;
            private String CityCode;
            private String AreaCode;
            private String Address;
            private String Guarantee;
            private String UserName;
            private String Phone;
            private Object AppointmentState;
            private Object AppointmentMessage;
            private int page;
            private int limit;
            private int Version;

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
            }

            public int getSendID() {
                return SendID;
            }

            public void setSendID(int SendID) {
                this.SendID = SendID;
            }

            public String getCreateDate() {
                return CreateDate;
            }

            public void setCreateDate(String CreateDate) {
                this.CreateDate = CreateDate;
            }

            public String getUserID() {
                return UserID;
            }

            public void setUserID(String UserID) {
                this.UserID = UserID;
            }

            public int getOrderID() {
                return OrderID;
            }

            public void setOrderID(int OrderID) {
                this.OrderID = OrderID;
            }

            public String getState() {
                return State;
            }

            public void setState(String State) {
                this.State = State;
            }

            public Object getUpdateDate() {
                return UpdateDate;
            }

            public void setUpdateDate(Object UpdateDate) {
                this.UpdateDate = UpdateDate;
            }

            public Object getServiceDate() {
                return ServiceDate;
            }

            public void setServiceDate(Object ServiceDate) {
                this.ServiceDate = ServiceDate;
            }

            public Object getServiceDate2() {
                return ServiceDate2;
            }

            public void setServiceDate2(Object ServiceDate2) {
                this.ServiceDate2 = ServiceDate2;
            }

            public String getLoginUser() {
                return LoginUser;
            }

            public void setLoginUser(String LoginUser) {
                this.LoginUser = LoginUser;
            }

            public String getIsUse() {
                return IsUse;
            }

            public void setIsUse(String IsUse) {
                this.IsUse = IsUse;
            }

            public int getCategoryID() {
                return CategoryID;
            }

            public void setCategoryID(int CategoryID) {
                this.CategoryID = CategoryID;
            }

            public String getCategoryName() {
                return CategoryName;
            }

            public void setCategoryName(String CategoryName) {
                this.CategoryName = CategoryName;
            }

            public int getSubTypeID() {
                return SubTypeID;
            }

            public void setSubTypeID(int SubTypeID) {
                this.SubTypeID = SubTypeID;
            }

            public Object getSubTypeName() {
                return SubTypeName;
            }

            public void setSubTypeName(Object SubTypeName) {
                this.SubTypeName = SubTypeName;
            }

            public String getMemo() {
                return Memo;
            }

            public void setMemo(String Memo) {
                this.Memo = Memo;
            }

            public int getBrandID() {
                return BrandID;
            }

            public void setBrandID(int BrandID) {
                this.BrandID = BrandID;
            }

            public String getBrandName() {
                return BrandName;
            }

            public void setBrandName(String BrandName) {
                this.BrandName = BrandName;
            }

            public String getProductType() {
                return ProductType;
            }

            public void setProductType(String ProductType) {
                this.ProductType = ProductType;
            }

            public String getProvinceCode() {
                return ProvinceCode;
            }

            public void setProvinceCode(String ProvinceCode) {
                this.ProvinceCode = ProvinceCode;
            }

            public String getCityCode() {
                return CityCode;
            }

            public void setCityCode(String CityCode) {
                this.CityCode = CityCode;
            }

            public String getAreaCode() {
                return AreaCode;
            }

            public void setAreaCode(String AreaCode) {
                this.AreaCode = AreaCode;
            }

            public String getAddress() {
                return Address;
            }

            public void setAddress(String Address) {
                this.Address = Address;
            }

            public String getGuarantee() {
                return Guarantee;
            }

            public void setGuarantee(String Guarantee) {
                this.Guarantee = Guarantee;
            }

            public String getUserName() {
                return UserName;
            }

            public void setUserName(String UserName) {
                this.UserName = UserName;
            }

            public String getPhone() {
                return Phone;
            }

            public void setPhone(String Phone) {
                this.Phone = Phone;
            }

            public Object getAppointmentState() {
                return AppointmentState;
            }

            public void setAppointmentState(Object AppointmentState) {
                this.AppointmentState = AppointmentState;
            }

            public Object getAppointmentMessage() {
                return AppointmentMessage;
            }

            public void setAppointmentMessage(Object AppointmentMessage) {
                this.AppointmentMessage = AppointmentMessage;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public int getLimit() {
                return limit;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public int getVersion() {
                return Version;
            }

            public void setVersion(int Version) {
                this.Version = Version;
            }
        }
    }
}
