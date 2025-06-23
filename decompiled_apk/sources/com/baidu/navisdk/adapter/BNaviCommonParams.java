package com.baidu.navisdk.adapter;

/* loaded from: classes7.dex */
public class BNaviCommonParams {

    /* loaded from: classes7.dex */
    public interface BNMainSideBridge {
        public static final int ALL_DISMISS = 0;
        public static final int MAIN_ROAD = 1;
        public static final int ON_BRIDGE = 4;
        public static final int ON_BRIDGE_MAIN_ROAD = 5;
        public static final int ON_BRIDGE_SIDE_ROAD = 6;
        public static final int SIDE_ROAD = 2;
        public static final int UNDER_BRIDGE = 8;
        public static final int UNDER_BRIDGE_SIDE_ROAD = 10;
    }

    /* loaded from: classes7.dex */
    public interface BNRouteInfoKey {
        public static final String INFO_PASS_CITY = "info_pass_city";
        public static final String INFO_ROAD_CONDITION = "info_road_condition";
        public static final String INFO_ROUTE_DETAIL = "info_route_detail";
        public static final String INFO_ROUTE_POINT = "info_route_point";
        public static final String INFO_TAB = "info_tab";
        public static final String TRAFFIC_LIMIT_INFO = "traffic_limit_info";
    }

    /* loaded from: classes7.dex */
    public interface ProGuideKey {
        public static final String ADD_MAP = "add_map";
        public static final String IS_REALNAVI = "is_realnavi";
        public static final String IS_SUPPORT_FULL_SCREEN = "is_support_full_screen";
    }

    /* loaded from: classes7.dex */
    public interface RoutePlanKey {
        public static final String ASSIGN_ROUTE = "assign_route";
        public static final String EXTRA_KEY_IS_FUTURE = "route_plan_is_future";
        public static final String EXTRA_KEY_MRSL = "route_plan_mrsl";
        public static final String EXTRA_KEY_SESSION_ID = "route_plan_session_id";
        public static final String EXTRA_KEY_TIME_STAMP = "route_plan_time_stamp";
        public static final String EXTRA_KEY_TRAJECTORY_RESTORE_ID = "trajectory_restore_id";
        public static final String EXTRA_KEY_TRAJECTORY_RESTORE_TYPE = "trajectory_restore_type";
        public static final String SUB_VEHICLE = "sub_vehicle";
        public static final String VEHICLE_TYPE = "calc_route_vehicle_type";
    }
}
