package com.baidu.mapapi;

/* loaded from: classes7.dex */
public class UIMsg {
    public static final String UI_TIP_AR_ENTERING = "正在进入实景模式...";
    public static final String UI_TIP_FAVORITE_OFF = "收藏的地点已关闭";
    public static final String UI_TIP_FAVORITE_ON = "收藏的地点已打开";
    public static final String UI_TIP_FRIEND_OFF = "好友图层已关闭";
    public static final String UI_TIP_FRIEND_ON = "好友图层已打开";
    public static final String UI_TIP_GEO_ERROR = "暂时无法获取该点信息";
    public static final String UI_TIP_GOALS_FAILURE = "未找到该终点";
    public static final String UI_TIP_GOALS_INVALID = "抱歉,未找到该终点";
    public static final String UI_TIP_HIDE_TO_FRIEND = "已向好友隐藏了您的位置";
    public static final String UI_TIP_INDOOR_NOT_IN_BUILDING = "您不在当前建筑内，无法定位";
    public static final String UI_TIP_INDOOR_NO_GPS = "暂时无法获取当前位置\n请检查网络设置后重试";
    public static final String UI_TIP_INPUT_GOALS = "输入终点";
    public static final String UI_TIP_INPUT_START = "输入起点";
    public static final String UI_TIP_INPUT_START_EQUALS_GOAL = "起点终点相同";
    public static final String UI_TIP_LOCATION = "正在获取您的位置";
    public static final String UI_TIP_LOCATION_CHANGE = "设置中我的位置已关闭，请打开";
    public static final String UI_TIP_LOCATION_ERROR = "暂时无法获取您的位置";
    public static final String UI_TIP_MAX_SCALE = "已放大到最大级别";
    public static final String UI_TIP_MIN_SCALE = "已缩小到最小级别";
    public static final String UI_TIP_NET_CORE_MEMORY_ALLOCATE_ERROR = "内核内存错误";
    public static final String UI_TIP_NET_CORE_TRANS_CODE_ERROR = "内核转化错误";
    public static final String UI_TIP_NET_NETWORK_CONNECT_ERROR = "网络未连接，请检查网络设置后重试";
    public static final String UI_TIP_NET_NETWORK_DATA_ERROR = "网络暂时无法连接";
    public static final String UI_TIP_NET_NETWORK_ERROR_404 = "网络错误404";
    public static final String UI_TIP_NET_NETWORK_GET_CITYID_ERROR = "网络暂时无法连接，请检查网络后重试";
    public static final String UI_TIP_NET_NETWORK_TIMEOUT_ERROR = "网络暂时无法连接，请稍后重试";
    public static final String UI_TIP_NET_RESULT_NOT_FOUND = "未搜索到结果";
    public static final String UI_TIP_NET_RP_NOT_SUPPORT_BUS = "不支持公交";
    public static final String UI_TIP_NET_RP_NOT_SUPPORT_BUS_2CITY = "抱歉,暂不支持跨城市公交查询";
    public static final String UI_TIP_NET_RP_ST_EN_TOO_NEAR = "起点终点太近，请选择步行方案";
    public static final String UI_TIP_NET_UNDEFINED_ERROR = "未定义错误";
    public static final String UI_TIP_NET_USER_CANCEL = "用户请求取消";
    public static final String UI_TIP_NEW_VERSION = "您目前的版本已是最新版本";
    public static final String UI_TIP_POI_SEARCH_ERROR = "未找到相关结果";
    public static final String UI_TIP_SATELLITE_NO = "抱歉,当前城市暂无卫星图数据";
    public static final String UI_TIP_SATELLITE_OFF = "卫星图层已关闭";
    public static final String UI_TIP_SATELLITE_ON = "卫星图层已打开";
    public static final String UI_TIP_SDCARD_NO_SPACE = "检测到当前您的SD卡空间不足，为保证软件的正常使用，建议您腾出空间后再进行下载。";
    public static final String UI_TIP_SEARCHING = "正在搜索您所需的信息...";
    public static final String UI_TIP_SHOW_TO_FRIEND = "已向好友显示了您的位置";
    public static final String UI_TIP_START_FAILURE = "未找到该起点";
    public static final String UI_TIP_START_INVALID = "抱歉,未找到该起点";
    public static final String UI_TIP_TRAFFIC_CHINA_NO = "请放大到城市查看路况";
    public static final String UI_TIP_TRAFFIC_NO = "抱歉,当前城市暂无实时路况数据";
    public static final String UI_TIP_TRAFFIC_OFF = "实时路况已关闭";
    public static final String UI_TIP_TRAFFIC_ON = "实时路况已打开";
    public static final String UI_TIP_YOUR_SEARCH_GOALS = "您要找的终点是:";
    public static final String UI_TIP_YOUR_SEARCH_GOALS_IN_CITY = "您要找的终点在如下城市:";
    public static final String UI_TIP_YOUR_SEARCH_START = "您要找的起点是:";
    public static final String UI_TIP_YOUR_SEARCH_START_IN_CITY = "您要找的起点在如下城市:";

    /* loaded from: classes7.dex */
    public static class NetDetectedType {
        public static final int NETYPE_2G = 2;
        public static final int NETYPE_3G = 3;
        public static final int NETYPE_4G = 4;
        public static final int NETYPE_4G_UNKNOWN = 10;
        public static final int NETYPE_MOBILE_3G = 8;
        public static final int NETYPE_MOBILE_UNICOM_2G = 6;
        public static final int NETYPE_TELECOM_2G = 5;
        public static final int NETYPE_TELECOM_3G = 7;
        public static final int NETYPE_UNICOM_3G = 9;
        public static final int NETYPE_UNKNOWN = 0;
        public static final int NETYPE_WIFI = 1;
    }

    /* loaded from: classes7.dex */
    public class UIGPSStatus {
        public static final int GPS_DEVICE_DISABLED = 0;
        public static final int GPS_DEVICE_ENABLED = 1;
        public static final int GPS_SIGNAL_CONNECTED = 2;
        public static final int GPS_SIGNAL_NOT_CONNECTED = 3;
        public static final int GPS_SIGNAL_SATELLITE_NUM = 4;

        public UIGPSStatus() {
        }
    }

    /* loaded from: classes7.dex */
    public class UIHttpType {
        public static final int ADD_FLS = 10;
        public static final int APP_SEARCH_REQ = 0;
        public static final int HIDE_TO_FRI_REQ = 19;
        public static final int MAP_IMAGE_REQ = 1;
        public static final int NET_HTTP_FLS = 7;
        public static final int NET_HTTP_NONE = -1;
        public static final int SHOW_TO_FRI_REQ = 18;
        public static final int VERSION_UPDATE = 6;
        public static final int VERSION_UPDATE_NAV_MODULE = 17;
        public static final int VOICE_SEARCH_REQ = 11;

        public UIHttpType() {
        }
    }

    /* loaded from: classes7.dex */
    public class UIOffType {
        public static final int MSG_DATARUN_EXCEPTION = -1;
        public static final int MSG_OFFLINE_ADD = 9;
        public static final int MSG_OFFLINE_DELETE = 11;
        public static final int MSG_OFFLINE_DETECTED = 101;
        public static final int MSG_OFFLINE_DOWNLOADING = 8;
        public static final int MSG_OFFLINE_FIND = 6;
        public static final int MSG_OFFLINE_FIRSTLOC = 1;
        public static final int MSG_OFFLINE_MEMENOUGH = 5;
        public static final int MSG_OFFLINE_NETERROR = 10;
        public static final int MSG_OFFLINE_PROGRESS = 102;
        public static final int MSG_OFFLINE_SECONDLOC = 2;
        public static final int MSG_OFFLINE_UPDATE = 0;
        public static final int MSG_OFFLINE_VERUPDATE = 4;
        public static final int MSG_OFFLINE_WIFICONNECT = -2;
        public static final int MSG_TEMPORY_UPDATE = 7;

        public UIOffType() {
        }
    }

    /* loaded from: classes7.dex */
    public static class WalkNaviMsg {
        public static final int MSG_APP_PB_DATA_OK = 2008;
        public static final int NL_UI_MESSAGE_TYPE_COMPASS_GUIDEINFO_UPDATE = 4106;
        public static final int NL_UI_MESSAGE_TYPE_GPS_STATE_CHANGE = 4103;
        public static final int NL_UI_MESSAGE_TYPE_INVALID = 4096;
        public static final int NL_UI_MESSAGE_TYPE_MSG_NAVI_BASE_MAPVIEW = 11097;
        public static final int NL_UI_MESSAGE_TYPE_NAVI_STATUS_CHANGE = 4098;
        public static final int NL_UI_MESSAGE_TYPE_ONROUTE = 4110;
        public static final int NL_UI_MESSAGE_TYPE_PANO_ID_RESULT = 4104;
        public static final int NL_UI_MESSAGE_TYPE_PANO_IMAGE_UPDATE = 4105;
        public static final int NL_UI_MESSAGE_TYPE_REMAIN_INFO_UPDATE = 4101;
        public static final int NL_UI_MESSAGE_TYPE_ROUTE_PLAN_RESULT = 4099;
        public static final int NL_UI_MESSAGE_TYPE_SIMPLE_MAP_UPDATE = 4100;
        public static final int NL_UI_MESSAGE_TYPE_SPEAK_MANEUVERKIND_UPDATE = 4111;
        public static final int NL_UI_MESSAGE_TYPE_SPEED_UPDATE = 4107;
        public static final int NL_UI_MESSAGE_TYPE_SYNC_OPERATION = 4102;
        public static final int NL_UI_MESSAGE_TYPE_VIA_POI_PANO_IMAGE_UPDATE = 4108;
        public static final int NL_UI_MESSAGE_TYPE_ZOOM_UPDATE = 4097;
        public static final int NL_UI_Message_Type_GPSMatchResult_Update = 4113;
        public static final int VM_USER_ID = 4096;
    }

    /* loaded from: classes7.dex */
    public class d_ResultType {
        public static final int ADDR_LIST = 23;
        public static final int AREA_SEARCH_LIST = 21;
        public static final int BUS_DETAIL = 18;
        public static final int BUS_REPORT = 19;
        public static final int BUS_ROUTE = 14;
        public static final int CAR_ROUTE = 20;
        public static final int CELLID_LOCATE_REQ = 503;
        public static final int CENTER_CITY = 4;
        public static final int CIRCUM_SEARCH_LIST = 12;
        public static final int CITY_LIST = 7;
        public static final int CITY_QUERY = 2;
        public static final int CITY_SUP_ITS = 511;
        public static final int ESPECIAL_QUERY = 26;
        public static final int FLS_REQ = 509;
        public static final int FOOT_ROUTE = 31;
        public static final int ITS_ROAD_SEARCH = 505;
        public static final int LOC_INFO_UPLOAD = 504;
        public static final int LONG_URL = 508;
        public static final int NEARBY_CENTER_LIST = 22;
        public static final int NEWVERSION_DOWNLOAD = 502;
        public static final int NEWVERSION_DOWNLOAD_NAV_MODULE = 515;
        public static final int OFFLINETASK_SEARCH = 507;
        public static final int POIRGC_DETAIL = 33;
        public static final int POI_BKG_DATA = 510;
        public static final int POI_DETAIL = 6;
        public static final int POI_LIST = 11;
        public static final int RECOMMANDLINK_SEARCH = 513;
        public static final int REVERSE_GEOCODING_SEARCH = 44;
        public static final int SHORT_URL = 500;
        public static final int SUGGESTION_SEARCH = 506;
        public static final int TYPE_ERROR = -1;
        public static final int VERSION_CHECK = 501;
        public static final int VERSION_CHECK_NAV_MODULE = 514;
        public static final int VOICE_REQ = 512;

        public d_ResultType() {
        }
    }

    /* loaded from: classes7.dex */
    public class f_FUN {
        public static final int FUN_ID_GBS = 13;
        public static final int FUN_ID_GBS_OPTION = 1301;
        public static final int FUN_ID_GBS_OPTION_CELL = 13010200;
        public static final int FUN_ID_GBS_OPTION_GPS = 13010100;
        public static final int FUN_ID_HIS = 14;
        public static final int FUN_ID_HIS_ACTION = 1402;
        public static final int FUN_ID_HIS_ACTION_ADD = 14020200;
        public static final int FUN_ID_HIS_ACTION_EDIT_RCD = 14020300;
        public static final int FUN_ID_HIS_ACTION_HOTKEY = 1403;
        public static final int FUN_ID_HIS_ACTION_HOTKEY_GET = 14030200;
        public static final int FUN_ID_HIS_ACTION_HOTKEY_SET = 14030100;
        public static final int FUN_ID_HIS_ACTION_REMOVEAT = 14020400;
        public static final int FUN_ID_HIS_ACTION_VIEW_RCD = 14020500;
        public static final int FUN_ID_HIS_ACTION_VIEW_RET = 14020100;
        public static final int FUN_ID_HIS_OPTION = 1401;
        public static final int FUN_ID_HIS_OPTION_POI = 14010100;
        public static final int FUN_ID_HIS_OPTION_ROT = 14010200;
        public static final int FUN_ID_ITS = 21;
        public static final int FUN_ID_ITS_ACTION_VIEW_EVENT_RCD = 21010100;
        public static final int FUN_ID_MAP = 10;
        public static final int FUN_ID_MAP_ACTION = 1001;
        public static final int FUN_ID_MAP_ACTION_CLICK_DOWN = 10010300;
        public static final int FUN_ID_MAP_ACTION_CLICK_MOVE = 10010400;
        public static final int FUN_ID_MAP_ACTION_CLICK_UP = 10010500;
        public static final int FUN_ID_MAP_ACTION_FOCUS_AT = 10010600;
        public static final int FUN_ID_MAP_ACTION_ZOOM_IN = 10010100;
        public static final int FUN_ID_MAP_ACTION_ZOOM_OUT = 10010200;
        public static final int FUN_ID_MAP_OPTION = 1002;
        public static final int FUN_ID_MAP_OPTION_FAVORITE = 10020300;
        public static final int FUN_ID_MAP_OPTION_FLS = 10020700;
        public static final int FUN_ID_MAP_OPTION_POI = 10020100;
        public static final int FUN_ID_MAP_OPTION_POI_SMS = 10020801;
        public static final int FUN_ID_MAP_OPTION_PREV_ITS = 10020500;
        public static final int FUN_ID_MAP_OPTION_REAL_ITS = 10020400;
        public static final int FUN_ID_MAP_OPTION_RGC = 10020800;
        public static final int FUN_ID_MAP_OPTION_RGC_SMS = 10020802;
        public static final int FUN_ID_MAP_OPTION_ROUTE = 10020200;
        public static final int FUN_ID_MAP_OPTION_SCALE = 10020600;
        public static final int FUN_ID_MAP_OPTION_STATION = 10020101;
        public static final int FUN_ID_MAP_STATE = 1003;
        public static final int FUN_ID_MAP_STATE_LOCATE = 10030200;
        public static final int FUN_ID_MAP_STATE_NORMAL = 10030100;
        public static final int FUN_ID_NET = 12;
        public static final int FUN_ID_NET_OPTION = 1201;
        public static final int FUN_ID_OFFLINE_ACTION_CURRENTCITY = 16010100;
        public static final int FUN_ID_OFFLINE_ACTION_DIRCITYSEARCH = 16010300;
        public static final int FUN_ID_OFFLINE_ACTION_HOTCITYGETALL = 16010200;
        public static final int FUN_ID_OFFLINE_ACTION_OFFLINEREQRESUME = 16011500;
        public static final int FUN_ID_OFFLINE_ACTION_OFFLINEREQSUSPEND = 16011400;
        public static final int FUN_ID_OFFLINE_ACTION_USRCITYADDRCD = 16010600;
        public static final int FUN_ID_OFFLINE_ACTION_USRCITYBATBEGIN = 16011600;
        public static final int FUN_ID_OFFLINE_ACTION_USRCITYBATSUSPEND = 16011700;
        public static final int FUN_ID_OFFLINE_ACTION_USRCITYBEGINLOAD = 16010800;
        public static final int FUN_ID_OFFLINE_ACTION_USRCITYGETALL = 16010400;
        public static final int FUN_ID_OFFLINE_ACTION_USRCITYREMOVE = 16011100;
        public static final int FUN_ID_OFFLINE_ACTION_USRCITYSUSPEND = 16011000;
        public static final int FUN_ID_OFFLINE_ACTION_USRCITYUPDATELOAD = 16010900;
        public static final int FUN_ID_SCH = 11;
        public static final int FUN_ID_SCH_NAV = 1102;
        public static final int FUN_ID_SCH_NAV_ACTION = 110202;
        public static final int FUN_ID_SCH_NAV_ACTION_ALERT = 11020210;
        public static final int FUN_ID_SCH_NAV_ACTION_ALERT_RECV_RET = 11020211;
        public static final int FUN_ID_SCH_NAV_ACTION_RECV_BUSREPORT = 11020212;
        public static final int FUN_ID_SCH_NAV_ACTION_RECV_RET = 11020204;
        public static final int FUN_ID_SCH_NAV_ACTION_RESET_POS = 11020213;
        public static final int FUN_ID_SCH_NAV_ACTION_SEARCH = 11020203;
        public static final int FUN_ID_SCH_NAV_ACTION_SEARCH_BACK = 11020207;
        public static final int FUN_ID_SCH_NAV_ACTION_SEARCH_CHANGE = 11020206;
        public static final int FUN_ID_SCH_NAV_ACTION_SEARCH_CITY = 11020209;
        public static final int FUN_ID_SCH_NAV_ACTION_SEARCH_POILIST = 11020208;
        public static final int FUN_ID_SCH_NAV_ACTION_SET_KEY = 11020201;
        public static final int FUN_ID_SCH_NAV_ACTION_SET_PAGE = 11020202;
        public static final int FUN_ID_SCH_NAV_ACTION_VIEW_RCD = 11020205;
        public static final int FUN_ID_SCH_NAV_OPTION = 110201;
        public static final int FUN_ID_SCH_NAV_OPTION_ALERT_PAUSE = 11020105;
        public static final int FUN_ID_SCH_NAV_OPTION_ALERT_SETTING = 11020107;
        public static final int FUN_ID_SCH_NAV_OPTION_ALERT_START = 11020104;
        public static final int FUN_ID_SCH_NAV_OPTION_ALERT_STOP = 11020106;
        public static final int FUN_ID_SCH_NAV_OPTION_BUS = 11020101;
        public static final int FUN_ID_SCH_NAV_OPTION_CAR = 11020102;
        public static final int FUN_ID_SCH_NAV_OPTION_FOOT = 11020103;
        public static final int FUN_ID_SCH_POI = 1101;
        public static final int FUN_ID_SCH_POI_ACTION = 110102;
        public static final int FUN_ID_SCH_POI_ACTION_RECV_RET = 11010204;
        public static final int FUN_ID_SCH_POI_ACTION_SEARCH = 11010203;
        public static final int FUN_ID_SCH_POI_ACTION_SET_KEY = 11010201;
        public static final int FUN_ID_SCH_POI_ACTION_SET_PAGE = 11010202;
        public static final int FUN_ID_SCH_POI_ACTION_VIEW_RCD = 11010205;
        public static final int FUN_ID_SCH_POI_OPTION = 110101;
        public static final int FUN_ID_SCH_POI_OPTION_AREA = 11010104;
        public static final int FUN_ID_SCH_POI_OPTION_BSLD = 11010105;
        public static final int FUN_ID_SCH_POI_OPTION_CIRCUM = 11010103;
        public static final int FUN_ID_SCH_POI_OPTION_FORCE = 11010102;
        public static final int FUN_ID_SCH_POI_OPTION_NEARBY_CENTER = 11010112;
        public static final int FUN_ID_SCH_POI_OPTION_OFFLINETASK = 11010108;
        public static final int FUN_ID_SCH_POI_OPTION_ONE = 11010101;
        public static final int FUN_ID_SCH_POI_OPTION_RECOMMANDLINK = 11010111;
        public static final int FUN_ID_SCH_POI_OPTION_RGC = 11010109;
        public static final int FUN_ID_SCH_POI_OPTION_RGC_SHORTURL = 11010110;
        public static final int FUN_ID_SCH_POI_OPTION_SUGGEST = 11010107;
        public static final int FUN_ID_SET_POI_INFOR = 17;
        public static final int FUN_ID_UTIL = 15;
        public static final int FUN_ID_UTIL_ACTION = 1501;
        public static final int FUN_ID_UTIL_ACTION_ALRIGHT = 15011200;
        public static final int FUN_ID_UTIL_ACTION_FLS_ADDPAOPAO = 15011214;
        public static final int FUN_ID_UTIL_ACTION_FLS_SHOWPAOPAO = 15011219;
        public static final int FUN_ID_UTIL_ACTION_GEMTOSCREEN = 15010200;
        public static final int FUN_ID_UTIL_ACTION_GETSCALEDATA = 15011218;
        public static final int FUN_ID_UTIL_ACTION_LATILONGI_TO_BAIDUGEO = 15010101;
        public static final int FUN_ID_UTIL_ACTION_LOC = 15011000;
        public static final int FUN_ID_UTIL_ACTION_MAP = 15011300;
        public static final int FUN_ID_UTIL_ACTION_MMS = 15010400;
        public static final int FUN_ID_UTIL_ACTION_REQUIRE = 15010801;
        public static final int FUN_ID_UTIL_ACTION_RESET = 15011100;
        public static final int FUN_ID_UTIL_ACTION_SCREENTOGEM = 15010100;
        public static final int FUN_ID_UTIL_ACTION_SHOWPAOPAO = 15011213;
        public static final int FUN_ID_UTIL_ACTION_SMS = 15010300;
        public static final int FUN_ID_UTIL_ACTION_SMSCALLBACK = 15010500;
        public static final int FUN_ID_UTIL_ACTION_SYSINFO = 15010900;
        public static final int FUN_ID_UTIL_ACTION_UPDATE = 15010802;
        public static final int FUN_ID_UTIL_ACTION_UPDATE_NAV_MODULE = 15010806;
        public static final int FUN_ID_UTIL_OPTION_ALRIGHT_GET = 15011202;
        public static final int FUN_ID_UTIL_OPTION_ALRIGHT_SET = 15011201;
        public static final int FUN_ID_UTIL_OPTION_FLS_ACTION = 15010800;
        public static final int FUN_ID_UTIL_OPTION_GETINSTALL = 15010904;
        public static final int FUN_ID_UTIL_OPTION_LOC_GET = 15011002;
        public static final int FUN_ID_UTIL_OPTION_LOC_SET = 15011001;
        public static final int FUN_ID_UTIL_OPTION_MAPANIMATION = 15011305;
        public static final int FUN_ID_UTIL_OPTION_MAPDATADOMSIZE_GET = 15011306;
        public static final int FUN_ID_UTIL_OPTION_MAPDATATMPSIZE_GET = 15011303;
        public static final int FUN_ID_UTIL_OPTION_MAPDATAVMPSIZE_GET = 15011304;
        public static final int FUN_ID_UTIL_OPTION_MAPTMPAUTOUPDATE_GET = 15011302;
        public static final int FUN_ID_UTIL_OPTION_MAPTMPAUTOUPDATE_SET = 15011301;
        public static final int FUN_ID_UTIL_OPTION_NOWIFI = 15010901;
        public static final int FUN_ID_UTIL_OPTION_OTHERSYS = 15010903;
        public static final int FUN_ID_UTIL_OPTION_POI = 15010600;
        public static final int FUN_ID_UTIL_OPTION_POI_RGC = 15010601;
        public static final int FUN_ID_UTIL_OPTION_ROT = 15010700;
        public static final int FUN_ID_UTIL_OPTION_SETINSTALL = 15010905;
        public static final int FUN_ID_UTIL_OPTION_SETWIFI = 15010902;
        public static final int FUN_ID_UTIL_OPTION_UPDATE_CHECK = 15010803;
        public static final int FUN_ID_UTIL_OPTION_UPDATE_CHECK_NAV_MODULE = 15010807;
        public static final int FUN_ID_UTIL_OPTION_UPDATE_DESC = 15010805;
        public static final int FUN_ID_UTIL_OPTION_UPDATE_DESC_NAV_MODULE = 15010809;
        public static final int FUN_ID_UTIL_OPTION_UPDATE_START = 15010804;
        public static final int FUN_ID_UTIL_OPTION_UPDATE_START_NAV_MODULE = 15010808;
        public static final int FUN_ID_VOICE = 20;
        public static final int FUN_ID_VOICE_SCH = 2001;
        public static final int FUN_ID_VOICE_SCH_ACTION = 200101;
        public static final int FUN_ID_VOICE_SCH_ACTION_RECV_RET = 20010102;
        public static final int FUN_ID_VOICE_SCH_ACTION_SEARCH = 20010101;
        public static final int FUN_ID_VOICE_SCH_OPTION = 200102;
        public static final int FUN_ID_VOICE_SCH_OPTION_GLOBAL_KEY = 20010202;
        public static final int FUN_ID_VOICE_SCH_OPTION_IDENTITY = 20010201;

        public f_FUN() {
        }
    }

    /* loaded from: classes7.dex */
    public class k_event {
        public static final int MV_MAP_ADDLOGOBJ = 4108;
        public static final int MV_MAP_CACHEMANAGE = 12289;
        public static final int MV_MAP_CALDISTANCE = 4106;
        public static final int MV_MAP_CHANGETO2D = 4112;
        public static final int MV_MAP_CLEANRESAULT = 4101;
        public static final int MV_MAP_CLEARLOCINFO = 65294;
        public static final int MV_MAP_CLEARSATECACHE = 4115;
        public static final int MV_MAP_GETMAPMODE = 4113;
        public static final int MV_MAP_GETSAVEFLAX = 4110;
        public static final int MV_MAP_ITS = 4098;
        public static final int MV_MAP_LOCATION = 4100;
        public static final int MV_MAP_MOVETOGEO = 4102;
        public static final int MV_MAP_MOVETOGEOBOUND = 4104;
        public static final int MV_MAP_MOVETOSCREEN = 4103;
        public static final int MV_MAP_RESETOPENGLRES = 4111;
        public static final int MV_MAP_SATELLITE = 4114;
        public static final int MV_MAP_SAVEMAP = 4105;
        public static final int MV_MAP_SENDPVLOGOBJ = 4117;
        public static final int MV_MAP_SETMAPMODE = 4109;
        public static final int MV_MAP_SETRENDER = 4116;
        public static final int MV_MAP_SHOWONMAP = 4099;
        public static final int MV_MAP_STOPUPDATEFLS = 65295;
        public static final int MV_MAP_ZOOMIN = 4096;
        public static final int MV_MAP_ZOOMOUT = 4097;
        public static final int MV_MAP_ZOOMTO = 4118;
        public static final int MV_SCREENSIZE_CHANGE = 32;
        public static final int V_A = 65;
        public static final int V_D = 68;
        public static final int V_DOWN = 19;
        public static final int V_LEFT = 16;
        public static final int V_RIGHT = 18;
        public static final int V_S = 83;
        public static final int V_UP = 17;
        public static final int V_W = 87;
        public static final int V_WM_CANCELREQ = 35;
        public static final int V_WM_DBCLICK = 8195;
        public static final int V_WM_GETLASTCLRSATETIME = 8194;
        public static final int V_WM_GLCHANGE = 40;
        public static final int V_WM_GLRENDER = 39;
        public static final int V_WM_KEYDOWN = 1;
        public static final int V_WM_KEYUP = 2;
        public static final int V_WM_LBUTTONDOWN = 4;
        public static final int V_WM_LBUTTONUP = 5;
        public static final int V_WM_LONGPRESS = 48;
        public static final int V_WM_MOUSEMOVE = 3;
        public static final int V_WM_ONFING = 34;
        public static final int V_WM_ROTATE = 8193;
        public static final int V_WM_ROTATEMOVE = 81;
        public static final int V_WM_STATUS_CHANGE = 41;
        public static final int V_WM_STREET_JUMP = 49;
        public static final int V_WM_TRACKBALLMOVE = 38;
        public static final int V_WM_VDATAENGINE = 65289;

        public k_event() {
        }
    }

    /* loaded from: classes7.dex */
    public class l_ErrorNo {
        public static final int CORE_MEMORY_ALLOCATE_ERROR = 101;
        public static final int CORE_TRANS_CODE_ERROR = 102;
        public static final int NETWORK_CONNECT_ERROR = 2;
        public static final int NETWORK_DATA_ERROR = 3;
        public static final int NETWORK_ERROR_404 = 404;
        public static final int NETWORK_INITIALING = 6;
        public static final int NETWORK_INITIAL_OK = 7;
        public static final int NETWORK_SETTING_ERROR = 5;
        public static final int NETWORK_TIMEOUT_ERROR = 8;
        public static final int REQUEST_OK = 0;
        public static final int RESULT_NOT_FOUND = 11;
        public static final int RP_NOT_SUPPORT_BUS = 12;
        public static final int RP_NOT_SUPPORT_BUS_2CITY = 13;
        public static final int RP_ST_EN_TOO_NEAR = 14;
        public static final int USER_CANCEL = 1;

        public l_ErrorNo() {
        }
    }

    /* loaded from: classes7.dex */
    public class m_AppUI {
        public static final int CELLDATA_UPLOAD_REQ = 507;
        public static final int MSG_APP_DATA_OK = 2000;
        public static final int MSG_APP_GPS = 5000;
        public static final int MSG_APP_SAVESCREEN = 4000;
        public static final int MSG_APP_VERSION = 2004;
        public static final int MSG_APP_VERSION_COMMEND = 2006;
        public static final int MSG_APP_VERSION_COMMEND_NAV_MODULE = 2009;
        public static final int MSG_APP_VERSION_FORCE = 2005;
        public static final int MSG_APP_VERSION_FORCE_NAV_MODULE = 2008;
        public static final int MSG_APP_VERSION_NAV_MODULE = 2007;
        public static final int MSG_ARMODE_ENTER = -4093;
        public static final int MSG_ARMODE_RESULT = -4090;
        public static final int MSG_ARMODE_UIENTER = -4092;
        public static final int MSG_ARTOAST_TIMER = -4091;
        public static final int MSG_AUTOHIDE_TIMER = -4095;
        public static final int MSG_BKG_DATA_OK = 511;
        public static final int MSG_CHINA_SUP_ITS = 516;
        public static final int MSG_CITY_SUP_DOM = 517;
        public static final int MSG_CITY_SUP_ITS = 515;
        public static final int MSG_CLICK_FLS_POPUP = 514;
        public static final int MSG_CLICK_ITEM = 9001;
        public static final int MSG_CLICK_POPUP = 512;
        public static final int MSG_CLOUD_SEARCH_RETURN_RESULT = 131072;
        public static final int MSG_COMPASS_DISPLAY = 518;
        public static final int MSG_COMPASS_REQ = 509;
        public static final int MSG_FAV_BUS_OLD = 8019;
        public static final int MSG_GET_GL_OK = 1020;
        public static final int MSG_LOCICON_TIMER = 510;
        public static final int MSG_MAPMODE_UPDATE = 513;
        public static final int MSG_MAP_HOTKEYS = 8014;
        public static final int MSG_MAP_HOTKEYSOPEN = 8017;
        public static final int MSG_MAP_OFFLINE = 8013;
        public static final int MSG_MAP_PAOPAO = 8012;
        public static final int MSG_MAP_ROUTEALERT_GPSSTATE = 65297;
        public static final int MSG_PLACEFIELD_RELOAD = 520;
        public static final int MSG_RADAR_SEARCH_RETURN_RESULT = 30000;
        public static final int MSG_SCALE_UPDATE = 505;
        public static final int MSG_SENSOR = -4096;
        public static final int MSG_SET_SENSOR_STATUS = 519;
        public static final int MSG_SUG_TEXTCHAGNE = 8018;
        public static final int V_WM_ADDLISTUPDATE = -255;
        public static final int V_WM_BMBAR = 65301;
        public static final int V_WM_DESTROY = 6;
        public static final int V_WM_FLSPUDATE = 65287;
        public static final int V_WM_GETBKGDATA = 65296;
        public static final int V_WM_GETCITYITS = 65291;
        public static final int V_WM_GETPOIUID = 65290;
        public static final int V_WM_HOTKEY = 65288;
        public static final int V_WM_INIT_ERROR = 34;
        public static final int V_WM_INIT_OK = 33;
        public static final int V_WM_LISTLISTUPDATE = -254;
        public static final int V_WM_PAINT = 9;
        public static final int V_WM_PERMCHECK = 2010;
        public static final int V_WM_SCALEFINISHED = 37;
        public static final int V_WM_VDATAENGINE = 65289;
        public static final int V_WM_WIFISTATECHANGE = 65025;

        public m_AppUI() {
        }
    }
}
