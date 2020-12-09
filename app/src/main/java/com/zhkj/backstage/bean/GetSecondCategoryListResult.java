package com.zhkj.backstage.bean;

import java.io.Serializable;
import java.util.List;

public class GetSecondCategoryListResult {

    /**
     * StatusCode : 200
     * Info : 请求(或处理)成功
     * Count : 0
     * Data : {"code":0,"msg":"success","count":0,"data":[{"value":250,"name":"冰箱"},{"value":262,"name":"冷柜"},{"value":266,"name":"酒柜"},{"value":268,"name":"除湿机"},{"value":270,"name":"家用制冰机"},{"value":275,"name":"酿酒机压缩机"},{"value":276,"name":"热饮柜"},{"value":281,"name":"洗衣机"},{"value":317,"name":"空调"},{"value":318,"name":"空气能热水器（分体式）"},{"value":319,"name":"空气能一体式"},{"value":320,"name":"液晶彩色电视机"},{"value":321,"name":"点歌机"},{"value":322,"name":"油烟机"},{"value":323,"name":"消毒柜"},{"value":324,"name":"灶具"},{"value":325,"name":"集成灶  "},{"value":326,"name":"气电灶  "},{"value":327,"name":"洗碗机"},{"value":328,"name":"嵌入式电蒸/烤箱  "},{"value":329,"name":"旧项净水器(不可下单)  "},{"value":330,"name":"厨卫套装二件  "},{"value":331,"name":"厨卫套装三件  "},{"value":332,"name":"厨卫套装四件  "},{"value":333,"name":"集成水槽  "},{"value":334,"name":"商用电磁灶类  "},{"value":335,"name":"泵系列"},{"value":336,"name":"华帝橱柜吊码更换  "},{"value":337,"name":"食材净化器  "},{"value":338,"name":"铭铭电器尺寸测量"},{"value":339,"name":"燃气热水器  "},{"value":340,"name":"储水式电热水器  "},{"value":341,"name":"即热式热水器  "},{"value":342,"name":"取暖壁挂炉  "},{"value":343,"name":"电热开水器"},{"value":344,"name":"回水器"},{"value":345,"name":"发廊专用水能热水器"},{"value":346,"name":"移动式电热水器"},{"value":347,"name":"吸尘器"},{"value":348,"name":"扫地机"},{"value":349,"name":"微波炉"},{"value":350,"name":"小电烤箱"},{"value":351,"name":"煎烤炉"},{"value":352,"name":"电饼铛"},{"value":353,"name":"干果机"},{"value":354,"name":"养生壶"},{"value":355,"name":"电蒸笼"},{"value":356,"name":"电热锅"},{"value":357,"name":"电煮锅"},{"value":358,"name":"多士炉"},{"value":359,"name":"取暖器"},{"value":360,"name":"空调扇"},{"value":361,"name":"豆浆机"},{"value":362,"name":"破壁机"},{"value":363,"name":"料理机"},{"value":364,"name":"榨汁机"},{"value":365,"name":"挂烫机"},{"value":366,"name":"电饭烫"},{"value":367,"name":"电压力锅"},{"value":368,"name":"电磁炉"},{"value":369,"name":"电陶炉"},{"value":370,"name":"电风扇"},{"value":371,"name":"榨油机"},{"value":372,"name":"面包机"},{"value":373,"name":" 电热茶水"},{"value":374,"name":"面条机"},{"value":375,"name":"打蛋机"},{"value":376,"name":"厨师机"},{"value":377,"name":"和面机"},{"value":378,"name":"电炖汤药锅"},{"value":379,"name":"奶瓶消毒器"},{"value":380,"name":" 咖啡机"},{"value":381,"name":"冰茶机"},{"value":382,"name":"磨豆器"},{"value":383,"name":"智能炒菜机"},{"value":384,"name":"加湿器"},{"value":385,"name":"车载保温箱"},{"value":386,"name":"电子加热类"},{"value":387,"name":"蒸汽熨（挂）烫机"},{"value":388,"name":"家用小型冰激凌机"},{"value":389,"name":"太阳能光电互补采暖器  "},{"value":390,"name":"北美电器冰茶机"},{"value":391,"name":"磨豆器 "},{"value":392,"name":"咖啡机"},{"value":393,"name":"电子秤 "},{"value":394,"name":"按摩保健类"},{"value":395,"name":"制氧机"},{"value":396,"name":"半导体制冷类酒柜 "},{"value":397,"name":"冰箱 "},{"value":398,"name":"酸奶机 "},{"value":399,"name":"LED灯具"},{"value":400,"name":"全自动按摩椅 "},{"value":401,"name":"床 "},{"value":402,"name":"跑步机 "},{"value":403,"name":"足浴器"},{"value":404,"name":"足疗机"},{"value":405,"name":"脚踏车 "},{"value":406,"name":"按摩棒"},{"value":407,"name":"按摩垫"},{"value":408,"name":"按摩披肩"},{"value":409,"name":"吊扇"},{"value":410,"name":"水晶灯"},{"value":411,"name":"空气风幕机"},{"value":412,"name":"烘干除菌鞋柜"},{"value":413,"name":"智能快递柜 "},{"value":414,"name":"管道排风换气扇 "},{"value":415,"name":"健身 "},{"value":416,"name":"器材类"},{"value":417,"name":"挂式干衣机"},{"value":418,"name":"LED灯柜"},{"value":419,"name":"智能门锁（指纹+密码） "},{"value":420,"name":"无人机"},{"value":421,"name":"遮阳蓬"},{"value":422,"name":" 洗车机"},{"value":423,"name":"卫浴家具 "},{"value":424,"name":"智能卫浴 "},{"value":425,"name":"五金龙头类 "},{"value":426,"name":"卫浴配饰"},{"value":427,"name":"洗漱沐浴 "},{"value":428,"name":"欧派炉灶具"},{"value":429,"name":"欧派吸油烟机 "},{"value":430,"name":"欧派家用消毒柜"},{"value":431,"name":"欧派家用微波炉 "},{"value":432,"name":"欧派家用"},{"value":433,"name":"电蒸箱 "},{"value":434,"name":"欧派家用电烤箱 "},{"value":435,"name":"欧派家用洗碗机"},{"value":436,"name":"欧派家用电冰箱"},{"value":437,"name":"欧派家用纯水机"},{"value":438,"name":"欧派家用管线机"},{"value":439,"name":"欧派超滤净水器  "},{"value":440,"name":"欧派厨卫配件类 "},{"value":441,"name":"欧派小电器类"},{"value":442,"name":"欧派全屋前置过滤器 "},{"value":443,"name":"欧派垃圾处理器 "},{"value":444,"name":"智能马桶盖 "},{"value":445,"name":"马桶类"},{"value":446,"name":"浴霸 "},{"value":447,"name":"花洒浴屏类 "},{"value":448,"name":"卫浴套装2件 "},{"value":449,"name":"卫浴套装3件 "},{"value":450,"name":"卫浴套装4件"},{"value":451,"name":"浴柜类"},{"value":452,"name":"集成吊顶多功能风暖式浴霸"},{"value":453,"name":"卫浴套装6件"},{"value":454,"name":"卫浴套装9件 "},{"value":455,"name":"马桶盖 "},{"value":456,"name":"智能加热毛巾架 "},{"value":465,"name":"吸顶灯类 "},{"value":466,"name":"欧式水晶灯类 "},{"value":467,"name":"吊灯类"},{"value":468,"name":"鱼线灯类 "},{"value":469,"name":"其他灯饰类"},{"value":470,"name":"制冰机"},{"value":471,"name":"冰淇淋机 "},{"value":472,"name":"保鲜工作台 "},{"value":473,"name":"商用卧式冰箱"},{"value":474,"name":"硬质冰淇淋机 "},{"value":475,"name":"炒冰机 "},{"value":476,"name":"商用立式冰柜"},{"value":477,"name":"冷餐展示柜"},{"value":478,"name":"蛋糕柜蔬菜保鲜柜"},{"value":479,"name":"卧式展示柜"},{"value":480,"name":"熟食展示柜 "},{"value":481,"name":"药品冷藏柜 "},{"value":482,"name":"点菜柜"},{"value":483,"name":"硬冰展示柜"},{"value":484,"name":"保温展示柜"},{"value":485,"name":"商用热饮柜 "},{"value":486,"name":"商用热水电器"},{"value":487,"name":"商用开水桶 "},{"value":488,"name":"压缩机式酸奶机"},{"value":489,"name":"商用烤箱"},{"value":490,"name":"和面机 "},{"value":491,"name":"商用油水分离油炸锅"},{"value":492,"name":"商用电磁炉 "},{"value":493,"name":"商用电饭锅 "},{"value":494,"name":"商用烙饼机 "},{"value":495,"name":"蒸包炉肠粉机 "},{"value":496,"name":"关东煮 "},{"value":497,"name":"蒸饭柜 "},{"value":498,"name":"章鱼丸机"},{"value":499,"name":"鱼丸炉 "},{"value":500,"name":"商用 电磁煲仔炉 "},{"value":501,"name":"商用豆浆机"},{"value":502,"name":"商用打蛋搅拌机 "},{"value":503,"name":"商用绞肉机"},{"value":504,"name":"商用消毒柜 "},{"value":505,"name":"商用洗碗机 "},{"value":506,"name":"商用空气净化器 "},{"value":507,"name":"商用抽湿器 "},{"value":508,"name":"商用空调扇 "},{"value":509,"name":"商用风扇 "},{"value":510,"name":"商用咖啡机 "},{"value":511,"name":"冷（热）饮机系列 "},{"value":512,"name":"雪融机系列 "},{"value":513,"name":"制冰机系列"},{"value":514,"name":"展示柜系列 "},{"value":515,"name":"冰淇淋机系列"},{"value":516,"name":"厨房冰箱 "},{"value":517,"name":"三星洗衣机 "},{"value":518,"name":"三星电冰箱 "},{"value":519,"name":"三星电视机 "},{"value":520,"name":"三星空调 "},{"value":521,"name":"垃圾处理器 "},{"value":522,"name":"晾衣架"},{"value":523,"name":"智能主机 "},{"value":524,"name":"智能开关插座 "},{"value":525,"name":"智能窗饰控制 "},{"value":526,"name":"智能推窗器 "},{"value":527,"name":"智能影音 "},{"value":528,"name":"智能安防 "},{"value":529,"name":"智能厨卫 "},{"value":530,"name":"智能环境检测 "},{"value":531,"name":"智能监控 "},{"value":532,"name":"风扇吊灯类 "},{"value":533,"name":"吸顶水晶灯类 "},{"value":534,"name":"鱼线吊灯类 "},{"value":535,"name":"组合吸顶灯类"},{"value":536,"name":"平板花灯类"},{"value":537,"name":"枝型吊灯类 "},{"value":538,"name":"筒易吸顶灯类 "},{"value":539,"name":"黄水晶灯具类 "},{"value":541,"name":"智能锁"},{"value":767,"name":"电烤箱"},{"value":768,"name":"蒸蛋器"},{"value":769,"name":"烤鱼器"},{"value":770,"name":"纯蒸炉"},{"value":775,"name":"嵌入式大烤箱"},{"value":776,"name":"嵌入式微波炉"},{"value":777,"name":"燃气灶"},{"value":778,"name":"吸油烟机"},{"value":787,"name":"燃气热火器"},{"value":792,"name":"其他"},{"value":1039,"name":"窗帘"},{"value":1040,"name":"窗帘"},{"value":1041,"name":"窗帘"},{"value":1043,"name":"滚筒干衣机"},{"value":1119,"name":"水槽"},{"value":1160,"name":"垃圾处理器"},{"value":1177,"name":"烘干机"},{"value":1181,"name":"门"},{"value":1277,"name":"智能晾衣架"},{"value":1303,"name":"净水器"},{"value":1330,"name":"打印机"},{"value":1331,"name":"扫描仪"},{"value":1332,"name":"传真机"},{"value":1333,"name":"碎纸机"},{"value":1334,"name":"考勤机"},{"value":1335,"name":"投影仪"},{"value":1362,"name":"电热水龙头"},{"value":1741,"name":"电热水器"},{"value":1742,"name":"电热水器"},{"value":1744,"name":"集成热水器"}],"errcode":null,"errorId":null,"IsActionExceted":false}
     */

    private int StatusCode;
    private String Info;
    private int Count;
    private DataBeanX Data;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public DataBeanX getData() {
        return Data;
    }

    public void setData(DataBeanX Data) {
        this.Data = Data;
    }

    public static class DataBeanX {
        /**
         * code : 0
         * msg : success
         * count : 0
         * data : [{"value":250,"name":"冰箱"},{"value":262,"name":"冷柜"},{"value":266,"name":"酒柜"},{"value":268,"name":"除湿机"},{"value":270,"name":"家用制冰机"},{"value":275,"name":"酿酒机压缩机"},{"value":276,"name":"热饮柜"},{"value":281,"name":"洗衣机"},{"value":317,"name":"空调"},{"value":318,"name":"空气能热水器（分体式）"},{"value":319,"name":"空气能一体式"},{"value":320,"name":"液晶彩色电视机"},{"value":321,"name":"点歌机"},{"value":322,"name":"油烟机"},{"value":323,"name":"消毒柜"},{"value":324,"name":"灶具"},{"value":325,"name":"集成灶  "},{"value":326,"name":"气电灶  "},{"value":327,"name":"洗碗机"},{"value":328,"name":"嵌入式电蒸/烤箱  "},{"value":329,"name":"旧项净水器(不可下单)  "},{"value":330,"name":"厨卫套装二件  "},{"value":331,"name":"厨卫套装三件  "},{"value":332,"name":"厨卫套装四件  "},{"value":333,"name":"集成水槽  "},{"value":334,"name":"商用电磁灶类  "},{"value":335,"name":"泵系列"},{"value":336,"name":"华帝橱柜吊码更换  "},{"value":337,"name":"食材净化器  "},{"value":338,"name":"铭铭电器尺寸测量"},{"value":339,"name":"燃气热水器  "},{"value":340,"name":"储水式电热水器  "},{"value":341,"name":"即热式热水器  "},{"value":342,"name":"取暖壁挂炉  "},{"value":343,"name":"电热开水器"},{"value":344,"name":"回水器"},{"value":345,"name":"发廊专用水能热水器"},{"value":346,"name":"移动式电热水器"},{"value":347,"name":"吸尘器"},{"value":348,"name":"扫地机"},{"value":349,"name":"微波炉"},{"value":350,"name":"小电烤箱"},{"value":351,"name":"煎烤炉"},{"value":352,"name":"电饼铛"},{"value":353,"name":"干果机"},{"value":354,"name":"养生壶"},{"value":355,"name":"电蒸笼"},{"value":356,"name":"电热锅"},{"value":357,"name":"电煮锅"},{"value":358,"name":"多士炉"},{"value":359,"name":"取暖器"},{"value":360,"name":"空调扇"},{"value":361,"name":"豆浆机"},{"value":362,"name":"破壁机"},{"value":363,"name":"料理机"},{"value":364,"name":"榨汁机"},{"value":365,"name":"挂烫机"},{"value":366,"name":"电饭烫"},{"value":367,"name":"电压力锅"},{"value":368,"name":"电磁炉"},{"value":369,"name":"电陶炉"},{"value":370,"name":"电风扇"},{"value":371,"name":"榨油机"},{"value":372,"name":"面包机"},{"value":373,"name":" 电热茶水"},{"value":374,"name":"面条机"},{"value":375,"name":"打蛋机"},{"value":376,"name":"厨师机"},{"value":377,"name":"和面机"},{"value":378,"name":"电炖汤药锅"},{"value":379,"name":"奶瓶消毒器"},{"value":380,"name":" 咖啡机"},{"value":381,"name":"冰茶机"},{"value":382,"name":"磨豆器"},{"value":383,"name":"智能炒菜机"},{"value":384,"name":"加湿器"},{"value":385,"name":"车载保温箱"},{"value":386,"name":"电子加热类"},{"value":387,"name":"蒸汽熨（挂）烫机"},{"value":388,"name":"家用小型冰激凌机"},{"value":389,"name":"太阳能光电互补采暖器  "},{"value":390,"name":"北美电器冰茶机"},{"value":391,"name":"磨豆器 "},{"value":392,"name":"咖啡机"},{"value":393,"name":"电子秤 "},{"value":394,"name":"按摩保健类"},{"value":395,"name":"制氧机"},{"value":396,"name":"半导体制冷类酒柜 "},{"value":397,"name":"冰箱 "},{"value":398,"name":"酸奶机 "},{"value":399,"name":"LED灯具"},{"value":400,"name":"全自动按摩椅 "},{"value":401,"name":"床 "},{"value":402,"name":"跑步机 "},{"value":403,"name":"足浴器"},{"value":404,"name":"足疗机"},{"value":405,"name":"脚踏车 "},{"value":406,"name":"按摩棒"},{"value":407,"name":"按摩垫"},{"value":408,"name":"按摩披肩"},{"value":409,"name":"吊扇"},{"value":410,"name":"水晶灯"},{"value":411,"name":"空气风幕机"},{"value":412,"name":"烘干除菌鞋柜"},{"value":413,"name":"智能快递柜 "},{"value":414,"name":"管道排风换气扇 "},{"value":415,"name":"健身 "},{"value":416,"name":"器材类"},{"value":417,"name":"挂式干衣机"},{"value":418,"name":"LED灯柜"},{"value":419,"name":"智能门锁（指纹+密码） "},{"value":420,"name":"无人机"},{"value":421,"name":"遮阳蓬"},{"value":422,"name":" 洗车机"},{"value":423,"name":"卫浴家具 "},{"value":424,"name":"智能卫浴 "},{"value":425,"name":"五金龙头类 "},{"value":426,"name":"卫浴配饰"},{"value":427,"name":"洗漱沐浴 "},{"value":428,"name":"欧派炉灶具"},{"value":429,"name":"欧派吸油烟机 "},{"value":430,"name":"欧派家用消毒柜"},{"value":431,"name":"欧派家用微波炉 "},{"value":432,"name":"欧派家用"},{"value":433,"name":"电蒸箱 "},{"value":434,"name":"欧派家用电烤箱 "},{"value":435,"name":"欧派家用洗碗机"},{"value":436,"name":"欧派家用电冰箱"},{"value":437,"name":"欧派家用纯水机"},{"value":438,"name":"欧派家用管线机"},{"value":439,"name":"欧派超滤净水器  "},{"value":440,"name":"欧派厨卫配件类 "},{"value":441,"name":"欧派小电器类"},{"value":442,"name":"欧派全屋前置过滤器 "},{"value":443,"name":"欧派垃圾处理器 "},{"value":444,"name":"智能马桶盖 "},{"value":445,"name":"马桶类"},{"value":446,"name":"浴霸 "},{"value":447,"name":"花洒浴屏类 "},{"value":448,"name":"卫浴套装2件 "},{"value":449,"name":"卫浴套装3件 "},{"value":450,"name":"卫浴套装4件"},{"value":451,"name":"浴柜类"},{"value":452,"name":"集成吊顶多功能风暖式浴霸"},{"value":453,"name":"卫浴套装6件"},{"value":454,"name":"卫浴套装9件 "},{"value":455,"name":"马桶盖 "},{"value":456,"name":"智能加热毛巾架 "},{"value":465,"name":"吸顶灯类 "},{"value":466,"name":"欧式水晶灯类 "},{"value":467,"name":"吊灯类"},{"value":468,"name":"鱼线灯类 "},{"value":469,"name":"其他灯饰类"},{"value":470,"name":"制冰机"},{"value":471,"name":"冰淇淋机 "},{"value":472,"name":"保鲜工作台 "},{"value":473,"name":"商用卧式冰箱"},{"value":474,"name":"硬质冰淇淋机 "},{"value":475,"name":"炒冰机 "},{"value":476,"name":"商用立式冰柜"},{"value":477,"name":"冷餐展示柜"},{"value":478,"name":"蛋糕柜蔬菜保鲜柜"},{"value":479,"name":"卧式展示柜"},{"value":480,"name":"熟食展示柜 "},{"value":481,"name":"药品冷藏柜 "},{"value":482,"name":"点菜柜"},{"value":483,"name":"硬冰展示柜"},{"value":484,"name":"保温展示柜"},{"value":485,"name":"商用热饮柜 "},{"value":486,"name":"商用热水电器"},{"value":487,"name":"商用开水桶 "},{"value":488,"name":"压缩机式酸奶机"},{"value":489,"name":"商用烤箱"},{"value":490,"name":"和面机 "},{"value":491,"name":"商用油水分离油炸锅"},{"value":492,"name":"商用电磁炉 "},{"value":493,"name":"商用电饭锅 "},{"value":494,"name":"商用烙饼机 "},{"value":495,"name":"蒸包炉肠粉机 "},{"value":496,"name":"关东煮 "},{"value":497,"name":"蒸饭柜 "},{"value":498,"name":"章鱼丸机"},{"value":499,"name":"鱼丸炉 "},{"value":500,"name":"商用 电磁煲仔炉 "},{"value":501,"name":"商用豆浆机"},{"value":502,"name":"商用打蛋搅拌机 "},{"value":503,"name":"商用绞肉机"},{"value":504,"name":"商用消毒柜 "},{"value":505,"name":"商用洗碗机 "},{"value":506,"name":"商用空气净化器 "},{"value":507,"name":"商用抽湿器 "},{"value":508,"name":"商用空调扇 "},{"value":509,"name":"商用风扇 "},{"value":510,"name":"商用咖啡机 "},{"value":511,"name":"冷（热）饮机系列 "},{"value":512,"name":"雪融机系列 "},{"value":513,"name":"制冰机系列"},{"value":514,"name":"展示柜系列 "},{"value":515,"name":"冰淇淋机系列"},{"value":516,"name":"厨房冰箱 "},{"value":517,"name":"三星洗衣机 "},{"value":518,"name":"三星电冰箱 "},{"value":519,"name":"三星电视机 "},{"value":520,"name":"三星空调 "},{"value":521,"name":"垃圾处理器 "},{"value":522,"name":"晾衣架"},{"value":523,"name":"智能主机 "},{"value":524,"name":"智能开关插座 "},{"value":525,"name":"智能窗饰控制 "},{"value":526,"name":"智能推窗器 "},{"value":527,"name":"智能影音 "},{"value":528,"name":"智能安防 "},{"value":529,"name":"智能厨卫 "},{"value":530,"name":"智能环境检测 "},{"value":531,"name":"智能监控 "},{"value":532,"name":"风扇吊灯类 "},{"value":533,"name":"吸顶水晶灯类 "},{"value":534,"name":"鱼线吊灯类 "},{"value":535,"name":"组合吸顶灯类"},{"value":536,"name":"平板花灯类"},{"value":537,"name":"枝型吊灯类 "},{"value":538,"name":"筒易吸顶灯类 "},{"value":539,"name":"黄水晶灯具类 "},{"value":541,"name":"智能锁"},{"value":767,"name":"电烤箱"},{"value":768,"name":"蒸蛋器"},{"value":769,"name":"烤鱼器"},{"value":770,"name":"纯蒸炉"},{"value":775,"name":"嵌入式大烤箱"},{"value":776,"name":"嵌入式微波炉"},{"value":777,"name":"燃气灶"},{"value":778,"name":"吸油烟机"},{"value":787,"name":"燃气热火器"},{"value":792,"name":"其他"},{"value":1039,"name":"窗帘"},{"value":1040,"name":"窗帘"},{"value":1041,"name":"窗帘"},{"value":1043,"name":"滚筒干衣机"},{"value":1119,"name":"水槽"},{"value":1160,"name":"垃圾处理器"},{"value":1177,"name":"烘干机"},{"value":1181,"name":"门"},{"value":1277,"name":"智能晾衣架"},{"value":1303,"name":"净水器"},{"value":1330,"name":"打印机"},{"value":1331,"name":"扫描仪"},{"value":1332,"name":"传真机"},{"value":1333,"name":"碎纸机"},{"value":1334,"name":"考勤机"},{"value":1335,"name":"投影仪"},{"value":1362,"name":"电热水龙头"},{"value":1741,"name":"电热水器"},{"value":1742,"name":"电热水器"},{"value":1744,"name":"集成热水器"}]
         * errcode : null
         * errorId : null
         * IsActionExceted : false
         */

        private int code;
        private String msg;
        private int count;
        private Object errcode;
        private Object errorId;
        private boolean IsActionExceted;
        private List<DataBean> data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Object getErrcode() {
            return errcode;
        }

        public void setErrcode(Object errcode) {
            this.errcode = errcode;
        }

        public Object getErrorId() {
            return errorId;
        }

        public void setErrorId(Object errorId) {
            this.errorId = errorId;
        }

        public boolean isIsActionExceted() {
            return IsActionExceted;
        }

        public void setIsActionExceted(boolean IsActionExceted) {
            this.IsActionExceted = IsActionExceted;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements Serializable {
            /**
             * value : 250
             * name : 冰箱
             */

            private int value;
            private String name;
            private boolean check=false;

            public boolean isCheck() {
                return check;
            }

            public void setCheck(boolean check) {
                this.check = check;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
