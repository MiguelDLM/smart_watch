package com.baidu.navisdk.comapi.routeguide;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes7.dex */
public class RouteGuideParams {
    public static final String ACTION_QUITNAVI = "com.baidu.navi.quitnavi";
    public static final int AUTO_EXIT_TIMEOUT = 5000;
    public static final int AUTO_HIDE_UI_TIMEOUT = 5000;
    public static final int AUTO_HIDE_UI_TIMEOUT_WHEN_MENU_SHOW = 60000;
    public static final int AUTO_LOCCAR_TIMEOUT_2D_3D = 10000;
    public static final int COUNT_DOWN_TIME = 10;
    public static final double Car2D_LAND_Yoffset = 0.1d;
    public static final int Car2D_PORTRAIT_Yoffset = 64;
    public static final double Car3D_LAND_Yoffset = 0.25d;
    public static final double Car3D_PORTRAIT_Yoffset = 0.23d;
    public static final int EXIT_COUNT_DOWN_TIME = 5;
    public static final int HANDLE_MSG_ASSIST_INFO_HIDE_OK = 265486339;
    public static final int HighwayExitIconType_TURN_FRONT = 1;
    public static final int HighwayExitIconType_TURN_LEFT_FRONT = 8;
    public static final int HighwayExitIconType_TURN_RIGHT_FRONT = 2;
    public static final int HighwayModel_Exit_Distance_Shreshold = 3000;
    public static final int NAV_VOICE_SPEED = 5191;
    public static final int RETURN_CAR_COUNT_DOWN_TIME = 10000;
    public static final int SEARCH_SPACE_RADIUS_FOR_SERVICE = 60000;
    public static final int SEARCH_SPACE_RADIUS_WHEN_RG = 5000;
    public static final int SUB_NAVI_STATUS_BEGIN = 1;
    public static final int SUB_NAVI_STATUS_CLOSE_TO_DEST = 5;
    public static final int SUB_NAVI_STATUS_END = 6;
    public static final int SUB_NAVI_STATUS_EXACT_GUIDE = 11;
    public static final int SUB_NAVI_STATUS_FAKE_YAWING = 12;
    public static final int SUB_NAVI_STATUS_REROUTE_CARFREE = 4;
    public static final int SUB_NAVI_STATUS_REROUTE_COMPLETE = 3;
    public static final int SUB_NAVI_STATUS_YAWING = 2;
    public static final int TURN_KIND_TYPE_INDOOR_FLOOR = 70;
    public static final int VIEW_DISPLAY_TIMEOUT = 3000;
    private static int routeGuideMode = 1;
    public static final String[] gTurnTypeDesc = {"无效值", "直行", "右前方转弯", "右转", "右后方转弯", "掉头", "左后方转弯", "左转", "左前方转弯", "环岛", "环岛出口", "靠左", "靠右", "左侧走本线", "靠最左走本线", "右侧走本线", "靠最右走本线", "中间走本线", "左侧走IC", "右侧走IC", "靠最左", "靠最右", "靠中间", "起始地", "目的地", "途经点1", "途经点2", "途经点3", "途经点4", "进入渡口", "脱出渡口", "收费站", "左侧直行走IC", "右侧直行走IC", "二分歧左侧直行", "二分歧右侧直行", "三分歧左侧直行", "三分歧中央直行", "三分歧右侧直行", "三分歧左侧走IC", "三分歧中央走IC", "三分歧右侧走IC", "IC三分歧左侧直行", "IC三分歧中间直行", "IC三分歧右侧直行", "靠左直行", "靠右直行 ", "靠最左侧直行 ", "沿中间直行", "靠最右侧直行", "左转，驶入左侧道路", "左转，驶入右侧道路", "左转，驶入最左侧道路", "左转，驶入中间道路", "左转，驶入最右侧道路", "右转，驶入左侧道路", "右转，驶入右侧道路", "右转，驶入最左侧道路", "右转，驶入中间道路", "右转，驶入最右侧道路", "左侧二叉路口靠左行驶", "左侧二叉路口靠右行驶", "右侧二叉路口靠左行驶", "右侧二叉路口靠右行驶", "八方向掉头,随后靠左", "八方向掉头,随后靠右", "八方向掉头,随后靠最左", "八方向掉头,随后沿中间", "八方向掉头,随后靠最右 ", "环岛向前", "环岛向左", "环岛向左后", "环岛向左前", "环岛向右", "环岛向右后", "环岛向右前", "环岛向后 ", "向左后方行驶，进入左侧道路", "向左后方行驶，进入右侧道路", "向左后方行驶，进入中间道路", "向左后方行驶，进入最左侧道路", "向左后方行驶，进入最右侧道路", "向右后方行驶", "靠左直行", "靠右直行", "向左后方行驶，注意不是掉头", "向左前方行驶，进入中间道路", "向左前方行驶，进入最左侧道路", "向左前方行驶，进入最右侧道路", "向左前方行驶，注意不是左转", "向右后方行驶，进入左侧道路", "向右后方行驶，进入右侧道路", "向右后方行驶，进入中间道路", "向右后方行驶，进入最左侧道路", "向右后方行驶，进入最右侧道路", "向右后方行驶", "向右前方行驶，进入中间道路", "向右前方行驶，进入最左侧道路", "向右前方行驶，进入最右侧道路", "向右前方行驶，注意不是右转", "在第二个口靠右前方"};
    public static final String[] gVoiceTurnTypeDesc = {"无效", "请直行", "向右前方行驶", "右转", "向右后方转弯", "请掉头", "向左后方转弯", "左转", "向左前方行驶", "进入环岛", "驶出环岛", "靠左前方", "靠右前方", "靠左前方", "三岔路靠最左侧", "靠右前方", "三岔路靠最右侧", "三岔路沿中间", "靠左前方", "靠右前方", "三岔路靠最左侧", "三岔路靠最右侧", "三岔路沿中间", "起始地", "到达目的地", "到达途经点", "到达途经点", "到达途经点", "到达途经点", "到达渡口入口", "到达渡口出口", "进入收费站", "靠左前方", "靠右前方", "靠左前方", "靠右前方", "三岔路靠最左侧", "三岔路沿中间", "三岔路靠最右侧", "三岔路靠最左侧", "三岔路沿中间", "三岔路靠最右侧", "三岔路靠最左侧", "三岔路沿中间", "三岔路靠最右侧", "岔路靠左行驶", "岔路靠右行驶", "三岔路靠最左侧行驶", "三岔路沿中间行驶", "三岔路靠最右侧行驶", "左转，驶入左侧道路", "左转，驶入右侧道路", "左转，驶入最左侧道路", "左转，驶入中间道路", "左转，驶入最右侧道路", "右转，驶入左侧道路", "右转，驶入右侧道路", "右转，驶入最左侧道路", "右转，驶入中间道路", "右转，驶入最右侧道路", "左前方岔路靠左", "左前方岔路靠右", "右前方岔路靠左", "右前方岔路靠右", "掉头", "掉头", "掉头", "掉头", "掉头", "环岛向前", "环岛向左", "环岛向左后", "环岛向左前", "环岛向右", "环岛向右后", "环岛向右前", "环岛向后 ", "向左后方行驶，进入左侧道路", "向左后方行驶，进入右侧道路", "向左后方行驶，进入中间道路", "向左后方行驶，进入最左侧道路", "向左后方行驶，进入最右侧道路", "向右后方行驶", "靠左直行", "靠右直行", "向左后方行驶，注意不是掉头", "向左前方行驶，进入中间道路", "向左前方行驶，进入最左侧道路", "向左前方行驶，进入最右侧道路", "向左前方行驶，注意不是左转", "向右后方行驶，进入左侧道路", "向右后方行驶，进入右侧道路", "向右后方行驶，进入中间道路", "向右后方行驶，进入最左侧道路", "向右后方行驶，进入最右侧道路", "向右后方行驶", "向右前方行驶，进入中间道路", "向右前方行驶，进入最左侧道路", "向右前方行驶，进入最右侧道路", "向右前方行驶，注意不是右转", "在第二个口靠右前方"};
    public static final String[] gTurnIconName = {"turn_back.png", "turn_front.png", "turn_right_front.png", "turn_right.png", "turn_right_back.png", "turn_back.png", "turn_left_back.png", "turn_left.png", "turn_left_front.png", "turn_ring.png", "turn_ring_out.png", "turn_left_side.png", "turn_right_side.png", "turn_left_side_main.png", "turn_branch_left_straight.png", "turn_right_side_main.png", "turn_branch_right_straight.png", "turn_branch_center.png", "turn_left_side_ic.png", "turn_right_side_ic.png", "turn_branch_left.png", "turn_branch_right.png", "turn_branch_center.png", "turn_start.png", "turn_dest.png", "turn_via_1.png", "turn_via_2.png", "turn_via_3.png", "turn_via_4.png", "turn_inferry.png", "turn_outferry.png", "turn_tollgate.png", "turn_left_side_main.png", "turn_right_side_main.png", "turn_left_side_main.png", "turn_right_side_main.png", "turn_branch_left_straight.png", "turn_branch_center.png", "turn_branch_right_straight.png", "turn_branch_left.png", "turn_branch_center.png", "turn_branch_right.png", "turn_branch_left_straight.png", "turn_branch_center.png", "turn_branch_right_straight.png", "turn_left_side_main.png", "turn_right_side_main.png", "turn_branch_left_straight.png", "turn_branch_center.png", "turn_branch_right_straight.png", "turn_left_2branch_left.png", "turn_left_2branch_right.png", "turn_left_3branch_left.png", "turn_left_3branch_middle.png", "turn_left_3branch_right.png", "turn_right_2branch_left.png", "turn_right_2branch_right.png", "turn_right_3branch_left.png", "turn_right_3branch_middle.png", "turn_right_3branch_right.png", "turn_lf_2branch_left.png", "turn_lf_2branch_right.png", "turn_rf_2branch_left.png", "turn_rf_2branch_right.png", "turn_back_2branch_left.png", "turn_back_2branch_right.png", "turn_back_3branch_left.png", "turn_back_3branch_middle.png", "turn_back_3branch_right.png", "turn_ring_front.png", "turn_ring_left.png", "turn_ring_leftback.png", "turn_ring_leftfront.png", "turn_ring_right.png", "turn_ring_rightback.png", "turn_ring_rightfront.png", "turn_ring_back.png", "turn_lb_2branch_left.png", "turn_lb_2branch_right.png", "turn_lb_3branch_middle.png", "turn_lb_3branch_left.png", "turn_lb_3branch_right.png", "turn_back_right.png", "turn_left_straight.png", "turn_right_straight.png", "turn_lb_not_back.png", "turn_lf_3branch_middle.png", "turn_lf_3branch_left.png", "turn_lf_3branch_right.png", "turn_lf_not_left.png", "turn_rb_2branch_left.png", "turn_rb_2branch_right.png", "turn_rb_3branch_middle.png", "turn_rb_3branch_left.png", "turn_rb_3branch_right.png", "turn_rb_not_back.png", "turn_rf_3branch_middle.png", "turn_rf_3branch_left.png", "turn_rf_3branch_right.png", "turn_rf_not_right.png", "turn_near_right_front.png"};
    public static final String[] sManeuverKindEnum = {"turn_back.png", "turn_front.png", "turn_right_front.png", "turn_right.png", "turn_right_back.png", "turn_back.png", "turn_left_back.png", "turn_left.png", "turn_left_front.png", "turn_ring.png", "turn_ring_out.png", "turn_left_side.png", "turn_right_side.png", "turn_left_side_main.png", "turn_branch_left_straight.png", "turn_right_side_main.png", "turn_branch_right_straight.png", "turn_branch_center.png", "turn_left_side_ic.png", "turn_right_side_ic.png", "turn_branch_left.png", "turn_branch_right.png", "turn_branch_center.png", "turn_start.png", "turn_dest.png", "turn_via_1.png", "turn_via_2.png", "turn_via_3.png", "turn_via_4.png", "turn_inferry.png", "turn_outferry.png", "turn_tollgate.png", "turn_left_side_main.png", "turn_right_side_main.png", "turn_left_straight.png", "turn_right_straight.png", "turn_branch_left_straight.png", "turn_branch_center.png", "turn_branch_right_straight.png", "turn_branch_left.png", "turn_branch_center.png", "turn_branch_right.png", "turn_branch_left_straight.png", "turn_branch_center.png", "turn_branch_right_straight.png", "turn_left_straight.png", "turn_right_straight.png", "turn_branch_left_straight.png", "turn_branch_center.png", "turn_branch_right_straight.png", "turn_left_2branch_left.png", "turn_left_2branch_right.png", "turn_left_3branch_left.png", "turn_left_3branch_middle.png", "turn_left_3branch_right.png", "turn_right_2branch_left.png", "turn_right_2branch_right.png", "turn_right_3branch_left.png", "turn_right_3branch_middle.png", "turn_right_3branch_right.png", "turn_lf_2branch_left.png", "turn_lf_2branch_right.png", "turn_rf_2branch_left.png", "turn_rf_2branch_right.png", "turn_back_2branch_left.png", "turn_back_2branch_right.png", "turn_back_3branch_left.png", "turn_back_3branch_middle.png", "turn_back_3branch_right.png", "turn_front.png", "", "turn_lf_not_left.png", "turn_rf_not_right.png", "turn_lb_not_back.png", "turn_lf_3branch_left.png", "turn_lf_3branch_middle.png", "turn_lf_3branch_right.png", "turn_rf_3branch_left.png", "turn_rf_3branch_middle.png", "turn_rf_3branch_right.png", "turn_lb_2branch_left.png", "turn_lb_2branch_right.png", "turn_lb_3branch_left.png", "turn_lb_3branch_middle.png", "turn_lb_3branch_right.png", "turn_rb_2branch_left.png", "turn_rb_2branch_right.png", "turn_rb_3branch_left.png", "turn_rb_3branch_middle.png", "turn_rb_3branch_right.png", "turn_ring_front.png", "turn_ring_rightfront.png", "turn_ring_right.png", "turn_ring_rightback.png", "turn_ring_back.png", "turn_ring_leftback.png", "turn_ring_left.png", "turn_ring_leftfront.png", "", "", "turn_back_right.png", "turn_rb_not_back.png"};

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface BroadType {
        public static final int HIGH_FAST_EXIT = 1;
        public static final int NORMAL = 0;
    }

    /* loaded from: classes7.dex */
    public static class CompassLocNodeViewLand {
        public static int X;
        public static int Y;
    }

    /* loaded from: classes7.dex */
    public static class CompassLocRaster {
        public static int X;
        public static int Y;
    }

    /* loaded from: classes7.dex */
    public static class CompassLocRasterLand {
        public static int X;
        public static int Y;
    }

    /* loaded from: classes7.dex */
    public static class CompassLocSimpleLand {
        public static int X;
        public static int Y;
    }

    /* loaded from: classes7.dex */
    public static class CompassPosGuidance {
        public static int EnlargeLandX;
        public static int EnlargeLandY;
        public static int EnlargePortX;
        public static int EnlargePortY;
        public static int SimpleLandX;
        public static int SimpleLandY;
        public static int SimplePortX;
        public static int SimplePortY;
    }

    /* loaded from: classes7.dex */
    public class CruiseBundleKey {
        public static final String ROAD_CAMERA_KEY = "CloseCamera";
        public static final String SPEED_LIMIT_KEY = "CloseSpeedLimit";
        public static final String TRAFFIC_SIGN_KEY = "CloseTrafficSign";

        public CruiseBundleKey() {
        }
    }

    /* loaded from: classes7.dex */
    public interface EnlargeMapHideType {
        public static final int HIDE_ALL = 1;
        public static final int HIDE_ALL_CROSS = 65536;
        public static final int HIDE_FRONT = 262144;
        public static final int HIDE_RASTER = 4;
        public static final int HIDE_STRAIGHT = 131072;
        public static final int HIDE_VECTOR = 2;
        public static final int OPEN_ALL = 0;
    }

    /* loaded from: classes7.dex */
    public interface EnlargeMapStatisitcs {
        public static final int DY_VECTOR = 5;
        public static final int MODE_2D = 2;
        public static final int PANORAMA = 3;
        public static final int REAL_3D = 4;
        public static final int UN_KNOW = 0;
        public static final int VECTOR = 1;
    }

    /* loaded from: classes7.dex */
    public interface EnlargeMapType {
        public static final int ARROW = 2;
        public static final int PATTERN = 1;
    }

    /* loaded from: classes7.dex */
    public interface ExitKey {
        public static final String ID = "id";
        public static final String NAME = "name";
    }

    /* loaded from: classes7.dex */
    public class FirstGuideMatchMode {
        public static final int IN_MATCH_STATE = 2;
        public static final int IN_VEHICLE_FREE = 1;
        public static final int OUT = 3;

        public FirstGuideMatchMode() {
        }
    }

    /* loaded from: classes7.dex */
    public class FullViewRouteType {
        public static final int fullViewRasterMapGuideLand = 4;
        public static final int fullViewRasterMapGuidePort = 2;
        public static final int fullViewSimpleGuideLand = 3;
        public static final int fullViewSimpleGuidePort = 1;

        public FullViewRouteType() {
        }
    }

    /* loaded from: classes7.dex */
    public class GuideStatus {
        public static final int NE_Guide_Status_CommuteGuide = 8;
        public static final int NE_Guide_Status_Cruise = 4;
        public static final int NE_Guide_Status_DemoGuide = 3;
        public static final int NE_Guide_Status_FuzzyGuide = 7;
        public static final int NE_Guide_Status_GenericGuide = 6;
        public static final int NE_Guide_Status_IndoorParkGuide = 9;
        public static final int NE_Guide_Status_Invalid = 0;
        public static final int NE_Guide_Status_LightNavi = 5;
        public static final int NE_Guide_Status_RealGuide = 2;
        public static final int NE_Guide_Status_Track = 1;

        public GuideStatus() {
        }
    }

    /* loaded from: classes7.dex */
    public class MenuType {
        public static final int INSIDE = 1;
        public static final int INVALID = -1;
        public static final int JUMP_OUT = 0;

        public MenuType() {
        }
    }

    /* loaded from: classes7.dex */
    public class NE_SyncCallOpera_Type {
        public static final int NE_SyncCallOpera_Type_CalcRoute = 1;
        public static final int NE_SyncCallOpera_Type_Invalid = 0;
        public static final int NE_SyncCallOpera_Type_RemoveRoute = 2;
        public static final int NE_SyncCallOpera_Type_SelectRoute = 3;
        public static final int NE_SyncCallOpera_Type_StartRouteCruise = 6;
        public static final int NE_SyncCallOpera_Type_StartRouteGuide = 4;
        public static final int NE_SyncCallOpera_Type_StopRouteCruise = 7;
        public static final int NE_SyncCallOpera_Type_StopRouteGuide = 5;

        public NE_SyncCallOpera_Type() {
        }
    }

    /* loaded from: classes7.dex */
    public class NavState {
        public static final String NAV_STATE_NAVING = "NAV_STATE_NAVING";
        public static final String NAV_STATE_OPERATE = "NAV_STATE_OPERATE";

        public NavState() {
        }
    }

    /* loaded from: classes7.dex */
    public static class NaviMode {
        public static final int NE_Navi_Mode_Commute = 3;
        public static final int NE_Navi_Mode_Invalid = 0;
        public static final int NE_Navi_Mode_Normal = 1;
        public static final int NE_Navi_Mode_Slight = 2;
        public static final int NE_Navi_Mode_Speedy = 4;
    }

    /* loaded from: classes7.dex */
    public class NaviSight {
        public static final int NAVI_Commute_Navi = 6;
        public static final int NAVI_Indoorpark_Navi = 7;
        public static final int NAVI_SIGHT_DEMO = 2;
        public static final int NAVI_SIGHT_FUZZY = 5;
        public static final int NAVI_SIGHT_GENERIC = 4;
        public static final int NAVI_SIGHT_INVALID = 0;
        public static final int NAVI_SIGHT_LIGHT = 3;
        public static final int NAVI_SIGHT_REAL = 1;

        public NaviSight() {
        }
    }

    /* loaded from: classes7.dex */
    public static class PageStatus {
        public static final int CAR_RESULT_PAGE = 1;
        public static final int INVALIDATE_PAGE = -1;
        public static final int LIGHT_NAVI_PAGE = 3;
        public static final int NAVI_PAGE = 2;
        public static final int NON_NAI_PAGE = 10;
    }

    /* loaded from: classes7.dex */
    public static class PageType {
        public static final int Car = 1;
        public static final int INVALID = 0;
        public static final int MOTOR = 2;
        public static final int NEW_ENERGY = 4;
        public static final int TRUCK = 3;
    }

    /* loaded from: classes7.dex */
    public class PreViewRoadCondition {
        public static final int ARC_ROAD_BAR = 3;
        public static final int MapMini = 0;
        public static final int NoAll = 2;
        public static final int RoadBar = 1;

        public PreViewRoadCondition() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface PreViewRoadConditionType {
    }

    /* loaded from: classes7.dex */
    public static class RCRoadInfo_Change_Type {
        public static final int NE_RCRoadInfo_Change_Type_InValid = 0;
        public static final int NE_RCRoadInfo_Change_Type_ToNoSide = 2;
        public static final int NE_RCRoadInfo_Change_Type_ToNoSide_ToNoViaduct = 10;
        public static final int NE_RCRoadInfo_Change_Type_ToNoSide_ToViaduct = 6;
        public static final int NE_RCRoadInfo_Change_Type_ToNoViaduct = 8;
        public static final int NE_RCRoadInfo_Change_Type_ToSide = 1;
        public static final int NE_RCRoadInfo_Change_Type_ToSide_ToNoViaduct = 9;
        public static final int NE_RCRoadInfo_Change_Type_ToSide_ToViaduct = 5;
        public static final int NE_RCRoadInfo_Change_Type_ToViaduct = 4;
    }

    /* loaded from: classes7.dex */
    public class RGKey {

        /* loaded from: classes7.dex */
        public class AssistInfo {
            public static final String AssistType = "assisttype";
            public static final String Speed = "speed";
            public static final String UpdateType = "updatetype";

            public AssistInfo() {
            }
        }

        /* loaded from: classes7.dex */
        public class CurRoadName {
            public static final String CurRoadName = "road_name";

            public CurRoadName() {
            }
        }

        /* loaded from: classes7.dex */
        public class DirectionInfo {
            public static final String ADD_DIST = "direction_add_dist";
            public static final String CODE = "direction_code";
            public static final String NAME = "direction_name";
            public static final String REMAIN_DIST = "direction_remain_dist";
            public static final String START_DIST = "direction_start_dist";

            public DirectionInfo() {
            }
        }

        /* loaded from: classes7.dex */
        public class ExitFastway {
            public static final String ADD_DIST = "fastway_exit_add_dist";
            public static final String REMAIN_DIST = "fastway_exit_remain_dist";
            public static final String ROAD_ID = "fastway_exit_road_id";
            public static final String ROAD_NAME = "fastway_exit_roadname";
            public static final String TOTAL_DIST = "fastway_exit_total_dist";

            public ExitFastway() {
            }
        }

        /* loaded from: classes7.dex */
        public class ExpandMap {
            public static final String AddDistance = "add_dist";
            public static final String ArrowName = "arrow_name";
            public static final String BgName = "bg_name";
            public static final String CarPosX = "car_pos_x";
            public static final String CarPosY = "car_pos_y";
            public static final String CarRotate = "car_rotate";
            public static final String ForbidAnimation = "forbid_animation";
            public static final String GetImage = "get_image";
            public static final String GridmapKind = "gridmap_kind";
            public static final String IconName = "icon_name";
            public static final String ImageBytes = "image_bytes";
            public static final String ImageHeight = "image_height";
            public static final String ImageWidth = "image_width";
            public static final String LastCarPosX = "last_car_pos_x";
            public static final String LastCarPosY = "last_car_pos_y";
            public static final String LastCarRotate = "last_car_rotate";
            public static final String REMAIN_DIST_HIDE = "remain_dist_hide";
            public static final String REPLACE_ARROW_MAP = "replace_arrow_map";
            public static final String REPLACE_ARROW_MAP_RES_ID = "replaceArrowMapResId";
            public static final String REPLACE_TEXT = "replace_text";
            public static final String RasterType = "raster_type";
            public static final String RemainDist = "rem_dist";
            public static final String ResId = "resid";
            public static final String RoadName = "road_name";
            public static final String StreetImageSource = "image_source";
            public static final String StreetImageType = "image_type";
            public static final String StreetUid = "street_uid";
            public static final String TagContent = "tag_content";
            public static final String TotalDist = "total_dist";
            public static final String UpdateProgress = "updateprogress";

            public ExpandMap() {
            }
        }

        /* loaded from: classes7.dex */
        public class HUDInfo {
            public static final String CurrentRoad = "hud_currentroad";
            public static final String Direction = "hud_head_angle";
            public static final String EixtRemainDistance = "hud_exitremaindistance";
            public static final String ExitDirection = "hud_highway_exitdirection";
            public static final String ExitDirectionName = "hud_highway_directionname";
            public static final String ExitICode = "hud_highway_exiticcode";
            public static final String ExitNextRoad = "hud_exitnextroad";
            public static final String GPSLost = "hud_gps_lost";
            public static final String HighAlong = "hud_along";
            public static final String NextRoad = "hud_nextroad";
            public static final String RemainDist = "hud_remaindist";
            public static final String ResId = "hud_resid";
            public static final String Speed = "hud_speed";
            public static final String StartDist = "hud_startdist";
            public static final String Straight = "hud_straight";
            public static final String TotalDist = "hud_totaldist";
            public static final String TotalTime = "hud_totaltime";
            public static final String UpdateType = "hud_updatetype";

            public HUDInfo() {
            }
        }

        /* loaded from: classes7.dex */
        public class HighWayInfo {
            public static final String CurRoadName = "highway_cur_road_name";
            public static final String ExitDirection = "highway_exit_direction";
            public static final String ExitDirectionName = "highway_exit_directionname";
            public static final String ExitIC = "highway_exit_ic";
            public static final String ExitICCode = "highway_exit_iccode";
            public static final String ExitNextRoadName = "highway_exit_nextroadname";
            public static final String ExitRemainDist = "highway_exit_remain_dist";
            public static final String ExitTotalDist = "highway_exit_total_dist";
            public static final String HIGHWAY_EXIT_GP_ADD_DIST = "highway_exit_gp_add_dist";
            public static final String HideInfo = "highway_hide_info";
            public static final String NextExitDirectionName = "highway_nextexit_direction_name";
            public static final String NextExitIC = "highway_nextexit_ic";
            public static final String NextExitICCode = "highway_nextexit_iccode";
            public static final String NextExitRemainDist = "highway_nextexit_remain_dist";
            public static final String NextExitTotalDist = "highway_nextexit_total_dist";
            public static final String NextGateName = "highway_gate_name";
            public static final String NextGateRemainDist = "highway_gate_remain_dist";
            public static final String NextGateTotalDist = "highway_gate_total_dist";
            public static final String NextServiceName = "highway_nextservice_name";
            public static final String NextServiceRemainDist = "highway_nextservice_remain_dist";
            public static final String NextServiceTotalDist = "highway_nextservice_total_dist";
            public static final String ServiceName = "highway_service_name";
            public static final String ServiceRemainDist = "highway_service_remain_dist";
            public static final String ServiceTotalDist = "highway_service_total_dist";

            public HighWayInfo() {
            }
        }

        /* loaded from: classes7.dex */
        public class SimpleGuideInfo {
            public static final String BroadType = "broad_type";
            public static final String CurRoadName = "cur_road_name";
            public static final String DistCur2NextGP = "DistCur2NextGP";
            public static final String GP_LENGTH = "nGPLength";
            public static final String HighwayExCur2NextGP = "HighwayExCur2NextGP";
            public static final String IconName = "icon_name";
            public static final String IndoorParkFloor = "parking_floor";
            public static final String LaneAddType = "laneAddType";
            public static final String LaneAddTypeArray = "laneAddTypeArray";
            public static final String LaneCount = "laneCount";
            public static final String LaneSignArray = "laneSignArray";
            public static final String MainAuxiliary = "mainauxiliary";
            public static final String MatchMode = "match_mode";
            public static final String NextNextRoadName = "next_next_road_name";
            public static final String NextRoad = "road_name";
            public static final String NextTurnKind = "NextTurnKind";
            public static final String PlanarName = "planar_name";
            public static final String REMAIN_DIST_HIDE = "remain_dist_hide";
            public static final String RemainDist = "remain_dist";
            public static final String RemainTime = "remain_time";
            public static final String ResId = "resid";
            public static final String RingFlag = "ringFlag";
            public static final String RoadID = "roadID";
            public static final String RoadPosX = "roadPosX";
            public static final String RoadPoxY = "roadPoxY";
            public static final String StartDist = "start_dist";
            public static final String Straight = "straight";
            public static final String TTSText = "ttstext";
            public static final String TotalDist = "totaldist";
            public static final String TotalTime = "totaltime";
            public static final String TurnKind = "TurnKind";
            public static final String UpdateType = "updatetype";
            public static final String isRightRudder = "isRightRudder";

            public SimpleGuideInfo() {
            }
        }

        public RGKey() {
        }
    }

    /* loaded from: classes7.dex */
    public class RGLocationMode {
        public static final int NE_Commute_Navi_Mode_GPS = 7;
        public static final int NE_Light_Navi_Mode_GPS = 6;
        public static final int NE_Locate_Mode_ExtGPS = 5;
        public static final int NE_Locate_Mode_GPS = 1;
        public static final int NE_Locate_Mode_Invalid = 0;
        public static final int NE_Locate_Mode_ManualDemoGPS = 4;
        public static final int NE_Locate_Mode_NEMADemoGPS = 3;
        public static final int NE_Locate_Mode_RouteDemoGPS = 2;

        public RGLocationMode() {
        }
    }

    /* loaded from: classes7.dex */
    public class RGViewMode {
        public static final int ROUTE_FULLVIEW = 2;
        public static final int ROUTE_GUIDE = 1;

        public RGViewMode() {
        }
    }

    /* loaded from: classes7.dex */
    public static class RasterType {
        public static final String COMMON_WINDOW = "common_window";

        @Deprecated
        public static final String DEST_STREET = "dest_street";

        @Deprecated
        public static final String DIRECT_BOARD = "raster_direct_board";
        public static final String GRID = "raster_grid";
        public static final String STREET = "raster_street";

        @Deprecated
        public static final String VECTOR = "raster_vector";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface RoadGrade {
        public static final int COMMON = 100;
        public static final int FAST = 1;
        public static final int HIGHWAY = 0;
        public static final int INVALID = -1;
    }

    /* loaded from: classes7.dex */
    public class RotateMode {
        public static final int EN_Rotate_Mode_Car = 1;
        public static final int EN_Rotate_Mode_Map = 0;

        public RotateMode() {
        }
    }

    /* loaded from: classes7.dex */
    public interface RouteDemoSpeed {
        public static final int SPEED_FAST = 0;
        public static final int SPEED_LOW = 2;
        public static final int SPEED_MIDDLE = 1;
    }

    /* loaded from: classes7.dex */
    public static class SubNaviMode {
        public static final int NE_Sub_Navi_Mode_Car = 1;
        public static final int NE_Sub_Navi_Mode_Default = 0;
    }

    /* loaded from: classes7.dex */
    public class VoiceDiyMode {
        public static final int CUSTOM = 6;
        public static final int DEFAULT = -1;
        public static final int DETAIL = 7;
        public static final int SIMPLE = 1;
        public static final int STANDARD = 0;

        public VoiceDiyMode() {
        }
    }

    /* loaded from: classes7.dex */
    public class VoiceMode {
        public static final int JustPlayWarning = 3;
        public static final int PLAY = 0;

        @Deprecated
        public static final int PLAY_BK = 1;
        public static final int Quiet = 2;

        public VoiceMode() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface VoiceModeType {
    }

    /* loaded from: classes7.dex */
    public class VoicePersonalityMode {
        public static final int Custom = 2;
        public static final int FullDose = 3;
        public static final int MIX = 4;
        public static final int MaiDou = 1;
        public static final int Normal = 0;
        public static final int YueChinese = 5;

        public VoicePersonalityMode() {
        }
    }

    /* loaded from: classes7.dex */
    public interface XDMsgType {
        public static final int INVALID = 0;
        public static final int JAM_REASION_FOR_UGC = 3;
        public static final int TRAFFIC_RIGHT_TRUN = 1;
        public static final int VARIABLE_LANE = 2;
    }

    public static synchronized int getRouteGuideMode() {
        int i;
        synchronized (RouteGuideParams.class) {
            i = routeGuideMode;
        }
        return i;
    }

    public static synchronized void setRouteGuideMode(int i) {
        synchronized (RouteGuideParams.class) {
            routeGuideMode = i;
        }
    }
}
