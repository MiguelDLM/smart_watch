package com.baidu.navisdk.comapi.mapcontrol;

/* loaded from: classes7.dex */
public class MapParams {

    /* loaded from: classes7.dex */
    public class Action {
        public Action() {
        }
    }

    /* loaded from: classes7.dex */
    public interface ClickBaseMapElements {
        public static final int CLICK_ELEMENT_DEFAULT = 0;
        public static final int CLICK_ELEMENT_LIMIT_LINE = 1;
        public static final int CLICK_ELEMENT_LIMIT_SURFACE = 2;
        public static final int CLICK_ELEMENT_LINE = 100;
        public static final int CLICK_ELEMENT_SURFACE = 200;
    }

    /* loaded from: classes7.dex */
    public interface ClickNaviMapElements {
        public static final int CLICK_ELEMENT_BUBBLE = 2;
        public static final int CLICK_ELEMENT_DRIP_OR_ICON = 1;
        public static final int CLICK_ELEMENT_ICON = 4;
        public static final int CLICK_ELEMENT_LINE = 3;
        public static final int CLICK_ELEMENT_SURFACE = 5;
    }

    /* loaded from: classes7.dex */
    public interface ClickSource {
        public static final int CLICK_CAR_LOGO = 5;
        public static final int CLICK_CONGESTED_ROAD = 1;
        public static final int CLICK_CONSTRUCTION_LABEL = 7;
        public static final int CLICK_DEST_NODE = 6;
        public static final int CLICK_JAM_LABEL = 2;
        public static final int CLICK_OTHER = 3;
        public static final int CLICK_TRUCK_UGC = 4;
    }

    /* loaded from: classes7.dex */
    public class Config {
        public Config() {
        }
    }

    /* loaded from: classes7.dex */
    public class Const {
        public static final int DEFAULT_LOCATED_SCALE_LEVEL = 14;
        public static final int DEFAULT_MAP_LOACTE_LATITUDE = 3945000;
        public static final int DEFAULT_MAP_LOACTE_LONGITUDE = 10856000;
        public static final int DEFAULT_NOT_LOCATED_SCALE_LEVEL = 3;
        public static final int DEFAULT_PICKPOINT_SCALE_LEVEL = 14;
        public static final int DEFAULT_POI_DETAIL_SCALE_LEVEL = 17;
        public static final String DISCOUNT = "discount";
        public static final String DISCOUNT_TITLE = "discount_title";
        public static final String D_DATA_TYPE = "d_data_type";
        public static final int MAPSTATUS_ANIMATION_TIME = 300;
        public static final int MAP_STATE_ENTER_NAV_PAGE_LEVEL = -2;
        public static final int MAP_STATE_INVALID_LEVEL = -1;
        public static final int MAX_MERCATOR_X = 20037508;
        public static final int MAX_MERCATOR_Y = 20037508;
        public static final int MAX_WAITING_LOCATION_TIMESPAN = 15000;
        public static final int MAX_ZOOM_LEVEL = 21;
        public static final int MIN_MERCATOR_X = -20037508;
        public static final int MIN_MERCATOR_Y = -20037508;
        public static final int MIN_ZOOM_LEVEL = 4;
        public static final int NAV_DEFAULT_AUTO_SCALE_LEVEL = 19;
        public static final int NAV_DEFAULT_SCALE_LEVEL_GUIDE = 18;
        public static final int NAV_MAX_SCALE_LEVEL_GUIDE = 19;
        public static final int NAV_MIN_SCALE_LEVEL_GUIDE = 15;
        public static final String SRC_NAME = "src_name";

        /* loaded from: classes7.dex */
        public class LayerMode {
            public static final int MAP_LAYER_MODE_BROWSE_MAP = 0;
            public static final int MAP_LAYER_MODE_CRUISE = 7;
            public static final int MAP_LAYER_MODE_INVALID = -1;
            public static final int MAP_LAYER_MODE_PICK_POINT = 4;
            public static final int MAP_LAYER_MODE_POIPKG = 2;
            public static final int MAP_LAYER_MODE_POI_DETAIL = 1;
            public static final int MAP_LAYER_MODE_RC_CALC_FAILED = 9;
            public static final int MAP_LAYER_MODE_ROUTE_DETAIL = 5;
            public static final int MAP_LAYER_MODE_ROUTE_DETAIL_FOR_NAVI = 6;
            public static final int MAP_LAYER_MODE_ROUTE_GUIDE = 3;
            public static final int MAP_LAYER_MODE_TRACK = 8;
            public static final int MAP_LAYER_MODE_UGC_ADD_SELECT_LINK = 12;
            public static final int MAP_LAYER_MODE_UGC_MAP_POP_UP = 10;
            public static final int MAP_LAYER_MODE_UGC_YAW_POP_UP = 11;

            public LayerMode() {
            }
        }

        /* loaded from: classes7.dex */
        public class LayerTag {
            public static final String COMPASS_LAYER_TAG = "compass";
            public static final String DEFAULT_LAYER_TAG = "default";
            public static final String ITEM_LAYER_TAG = "item";
            public static final String ITSROUTE_LAYER_TAG = "itsroute";
            public static final String LOCATION_LAYER_TAG = "location";
            public static final String POPUP_LAYER_TAG = "popup";
            public static final String SHARELOCATION_BUBBLE = "smshare";
            public static final String STREETPOPUP_LAYER_TAG = "streetpopup";

            public LayerTag() {
            }
        }

        /* loaded from: classes7.dex */
        public class LayerType {
            public static final int MAP_LAYER_TYPE_AVOIDLINE = 17;
            public static final int MAP_LAYER_TYPE_BASE_MAP = 0;
            public static final int MAP_LAYER_TYPE_BASE_POI = 12;
            public static final int MAP_LAYER_TYPE_BILLBOARDARC = 23;
            public static final int MAP_LAYER_TYPE_COMPASS = 9;
            public static final int MAP_LAYER_TYPE_ELEMENT_AROUND_ROUTE = 6017;
            public static final int MAP_LAYER_TYPE_ELEMENT_RC_PRED = 6020;
            public static final int MAP_LAYER_TYPE_END = 2;
            public static final int MAP_LAYER_TYPE_FAVPOI = 16;
            public static final int MAP_LAYER_TYPE_FAV_MARK = 7;
            public static final int MAP_LAYER_TYPE_FAV_POI = 6;
            public static final int MAP_LAYER_TYPE_GUIDELINE = 15;
            public static final int MAP_LAYER_TYPE_INVALID = -1;

            @Deprecated
            public static final int MAP_LAYER_TYPE_ITEM = 200;
            public static final int MAP_LAYER_TYPE_JUCVVIEW = 18;
            public static final int MAP_LAYER_TYPE_LANDMARK = 22;
            public static final int MAP_LAYER_TYPE_LOCATION = 14;
            public static final int MAP_LAYER_TYPE_MG_DATA = 6022;
            public static final int MAP_LAYER_TYPE_POI = 3;
            public static final int MAP_LAYER_TYPE_POI_BKG = 4;
            public static final int MAP_LAYER_TYPE_POPUP = 11;
            public static final int MAP_LAYER_TYPE_ROUTE = 10;
            public static final int MAP_LAYER_TYPE_ROUTECRUISER = 20;
            public static final int MAP_LAYER_TYPE_ROUTE_NODE = 8;
            public static final int MAP_LAYER_TYPE_ROUTE_SPEC = 13;
            public static final int MAP_LAYER_TYPE_ROUTE_UGC = 6016;
            public static final int MAP_LAYER_TYPE_SEARCH_CENTER = 5;
            public static final int MAP_LAYER_TYPE_START = 1;
            public static final int MAP_LAYER_TYPE_THROUGH_NODE = 1240;
            public static final int MAP_LAYER_TYPE_TRACK = 19;
            public static final int MAP_LAYER_TYPE_TRACKCAR = 21;
            public static final int MAP_LAYER_TYPE_TRUCK_UGC = 6021;
            public static final int NE_MAP_LAYER_TYPE_TRAFFIC_LIGHT = 37;
            public static final int NE_Map_Layer_Type_Label = 35;
            public static final int NE_Map_Layer_Type_MAP_UGC = 34;
            public static final int NE_Map_Layer_Type_RouteCamera = 24;
            public static final int NE_Map_Layer_Type_RouteIcon = 27;
            public static final int NE_Map_Layer_Type_RouteTrafficJam = 25;
            public static final int NE_Map_Layer_Type_RouteTrafficSign = 26;
            public static final int NE_Map_Layer_Type_UGC_Popup = 31;
            public static final int NE_Map_Layer_Type_UGC_ReRoute_Popup = 32;
            public static final int NE_Map_Layer_Type_UGC_SelectLink = 33;

            public LayerType() {
            }
        }

        /* loaded from: classes7.dex */
        public class LocationMode {
            public static final int MAP_LOC_MODE_CLOSED = 3;
            public static final int MAP_LOC_MODE_DIR = 2;
            public static final int MAP_LOC_MODE_FIXED = 1;
            public static final int MAP_LOC_MODE_INVALID = 4;
            public static final int MAP_LOC_MODE_NEXT = -1;
            public static final int MAP_LOC_MODE_NORMAL = 0;

            public LocationMode() {
            }
        }

        /* loaded from: classes7.dex */
        public class MapStyleMode {
            public static final int MAP_STYLE_TYPE_DEFAULT = 1;
            public static final int MAP_STYLE_TYPE_MAP_DAY = 2;
            public static final int MAP_STYLE_TYPE_MAP_NIGHT = 3;
            public static final int MAP_STYLE_TYPE_NAV_DAY = 4;
            public static final int MAP_STYLE_TYPE_NAV_IPO_DAY = 8;
            public static final int MAP_STYLE_TYPE_NAV_IPO_LOCK_DAY = 10;
            public static final int MAP_STYLE_TYPE_NAV_IPO_LOCK_NIGHT = 11;
            public static final int MAP_STYLE_TYPE_NAV_IPO_NIGHT = 9;
            public static final int MAP_STYLE_TYPE_NAV_NIGHT = 5;
            public static final int MAP_STYLE_TYPE_NAV_SMALL_SCREEN_DAY = 12;
            public static final int MAP_STYLE_TYPE_NAV_SMALL_SCREEN_NIGHT = 13;
            public static final int MAP_STYLE_TYPE_VIEWALL_DAY = 6;
            public static final int MAP_STYLE_TYPE_VIEWALL_NIGHT = 7;

            public MapStyleMode() {
            }
        }

        /* loaded from: classes7.dex */
        public class NodeType {
            public static final int BACKGMARK = 17;
            public static final int BUSLINE = 11;
            public static final int BUSLINE_STOP = 23;
            public static final int BUSSTATION = 9;
            public static final int COMPASS = 19;
            public static final int END = 2;
            public static final int E_STREET_ARROW = 1235;
            public static final int E_STREET_INTER_POI = 1236;
            public static final int E_STREET_POI = 1234;
            public static final int FAVMARK = 7;
            public static final int FAVORITEPOI = 6;
            public static final int INDOORMAPPOI = 24;
            public static final int ITS_EVENT = 22;
            public static final int LOCATION = 18;
            public static final int NONE = 26;
            public static final int OPENAPI_DETAIL = 102;
            public static final int OPENAPI_MARK_POI = 103;
            public static final int POI = 3;
            public static final int POIADDR = 13;
            public static final int POIBKG = 4;
            public static final int POIRGC = 14;
            public static final int POIRGCSHARE = 15;
            public static final int POISHARE = 16;
            public static final int REGEO = 101;
            public static final int ROUTE_NODE = 8;
            public static final int ROUTE_TIP_NODE = 21;
            public static final int SEARCH_CENTER = 5;
            public static final int SHARELOCATION = 25;
            public static final int START = 1;
            public static final int STREETPOPUP = 20;
            public static final int TRAINLINE = 12;
            public static final int TRAINSTATION = 10;

            public NodeType() {
            }
        }

        /* loaded from: classes7.dex */
        public class UpdateType {
            public static final int ECOMPULSORY_UPDATE = 1;
            public static final int EUPDATE_MAPSTATUSCHANGE = 2;
            public static final int EUPDATE_MAPSTATUSCHANGELATER = 4;
            public static final int EUPDATE_NONE = 0;
            public static final int EUPDATE_TIMERESCAP = 8;

            public UpdateType() {
            }
        }

        public Const() {
        }
    }

    /* loaded from: classes7.dex */
    public class Key {
        public Key() {
        }
    }

    /* loaded from: classes7.dex */
    public interface LabelClickType {
        public static final int CONSTRUCTION_LABEL_CLICK = 4;
        public static final int DEST_NODE_CLICK = 3;
        public static final int JAM_LABEL_CLICK = 2;
        public static final int ROUTE_LABEL_CLICK = 1;
    }

    /* loaded from: classes7.dex */
    public class LightNaviScreenType {
        public static final int ADDRESS_TYPE = 1;
        public static final int LOCK_TYPE = 2;
        public static final int UGC_TYPE = 4;

        public LightNaviScreenType() {
        }
    }

    /* loaded from: classes7.dex */
    public class MapClassType {
        public static final int COMMUTE = 2;
        public static final int INDOOR_PARK = 3;
        public static final int NORMAL = 1;
        public static final int OUTDOOR_PARK = 4;
        public static final int UNKNOWN = 0;

        public MapClassType() {
        }
    }

    /* loaded from: classes7.dex */
    public class MapClickEventType {
        public static final int NE_Map_ClickEventType_Invalid = 0;
        public static final int NE_Map_ClickEventType_OverSpeed = 4;
        public static final int NE_Map_ClickEventType_UrgentAcc = 1;
        public static final int NE_Map_ClickEventType_UrgentDec = 2;
        public static final int NE_Map_ClickEventType_UrgentTurn = 3;

        public MapClickEventType() {
        }
    }

    /* loaded from: classes7.dex */
    public class MapCommandType {
        public static final int NE_MAP_COMMAND_TYPE_INVALID = 0;
        public static final int NE_MAP_COMMAND_TYPE_NAVIEND = 1;
        public static final int NE_Map_Command_Type_EndCruise = 3;
        public static final int NE_Map_Command_Type_EndWaySearch = 6;
        public static final int NE_Map_Command_Type_RecoveryNavi = 4;
        public static final int NE_Map_Command_Type_StartCruise = 2;
        public static final int NE_Map_Command_Type_StartWaySearch = 5;

        public MapCommandType() {
        }
    }

    /* loaded from: classes7.dex */
    public class MapElementType {
        public static final int COMPASS = 11;
        public static final int JAM_LINK = 7;
        public static final int PANO_UGC = 10;
        public static final int ROUTE = 1;
        public static final int ROUTECAR = 4;
        public static final int ROUTENAME = 2;
        public static final int ROUTENODE = 3;
        public static final int ROUTENODELIGATURE = 5;
        public static final int ROUTE_DESC_LABEL = 6;
        public static final int TRUCK_UGC = 9;
        public static final int UGC = 8;
        public static final int UNKNOWN = 0;

        public MapElementType() {
        }
    }

    /* loaded from: classes7.dex */
    public class MapStrategyType {
        public static final int AUTO_LEVEL = 8;
        public static final int CARPLAY = 3;
        public static final int DYNAMIC_EFFECTS = 7;
        public static final int PART_ROUTE_ZOOM = 9;
        public static final int POI_SCENE = 4;
        public static final int QUIT_MOSS_PART_ZOOM = 10;
        public static final int SHOW_FAST_ROUTE = 2;
        public static final int SPEED = 5;
        public static final int UNKNOWN = 0;
        public static final int USE2DLOOK = 1;
        public static final int USE_DYNAMIC_LOOK = 6;

        public MapStrategyType() {
        }
    }

    /* loaded from: classes7.dex */
    public interface NLMDIYImageType {
        public static final int CarLogo = 0;
        public static final int EndPoint = 2;
        public static final int HD3DCar = 5;
        public static final int HDAccident = 10;
        public static final int HDCamera = 9;
        public static final int HDConstruction = 11;
        public static final int HDGuideArrow = 6;
        public static final int HDTrafficControl = 12;
        public static final int HDWarningSign = 13;
        public static final int StartPoint = 1;
        public static final int TriDCarLogo = 4;
        public static final int WayPoint = 3;
    }

    /* loaded from: classes7.dex */
    public class NaviMapMode {
        public static final int CRUISE = 3;
        public static final int FINISH = 4;
        public static final int NORMAL = 1;
        public static final int ROUTE = 5;
        public static final int SLIGHT = 2;
        public static final int TOTAL = 6;
        public static final int UNDEFINE = 0;

        public NaviMapMode() {
        }
    }

    /* loaded from: classes7.dex */
    public interface PanoramaKeys {
        public static final String DESC = "desc";
        public static final String EVENT_TYPE = "vt";
        public static final String PANO_URL = "panourl";
        public static final String ROAD_NAME = "roadname";
        public static final String X = "x";
        public static final String Y = "y";
    }

    /* loaded from: classes7.dex */
    public interface PoiSearchKey {
        public static final String KEY_BKG_CLICK_TYPE = "pkgty";
        public static final String KEY_BKG_ROUTE_VIA_FAST_LABEL = "pkgfast";
        public static final String KEY_ROUTE_AROUND_ELEMENT_DIS = "dis";
        public static final String KEY_ROUTE_AROUND_ELEMENT_GEO = "geo";
        public static final String KEY_ROUTE_AROUND_ELEMENT_STYLE_ID = "style_id";
    }

    /* loaded from: classes7.dex */
    public interface RouteClickType {
        public static final int CONGESTED_ROAD = 2;
        public static final int ROUTE_CLICK = 1;
    }
}
