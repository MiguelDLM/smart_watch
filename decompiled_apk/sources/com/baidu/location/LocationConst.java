package com.baidu.location;

/* loaded from: classes7.dex */
public class LocationConst {
    public static final String KEY_LOC_RES_LOC_INFO = "loc_info";

    /* loaded from: classes7.dex */
    public static class HDYawConst {
        public static final String KEY_HD_YAW_INDOOR_PARK_INFO = "indoor_park_info";
        public static final String KEY_HD_YAW_LINK_ID = "link_id";
        public static final String KEY_HD_YAW_STATE = "state";
        public static final String KEY_HD_YAW_TIMESTAMP = "timestamp";
        public static final String KEY_HD_YAW_VDR_YAW_ATTEMPT_INFO = "vdr_yaw_attempt_info";
    }

    /* loaded from: classes7.dex */
    public static class NaviConst {
        public static final String HD_LOC_RESULT_RADIUS = "hd_loc_result_radius";
        public static final String KEY_HD_LOC_COORDINATE = "hd_loc_coordinate";
        public static final String KEY_HD_LOC_COORDINATE_GCJ03 = "gcj03";
        public static final String KEY_HD_LOC_COORDINATE_WGS84 = "wgs84";
        public static final String KEY_HD_LOC_DELAY_STATUS = "hd_loc_delay_status";
        public static final String KEY_HD_LOC_IS_USED_IN_HD_NAVI_YAW = "is_used_in_hd_navi_yaw";
        public static final String KEY_HD_LOC_PROVIDER = "hd_loc_provider";
        public static final String KEY_HD_LOC_RESULT = "hd_loc_result";
        public static final String KEY_HD_LOC_RESULT_LAT = "hd_loc_result_lat";
        public static final String KEY_HD_LOC_RESULT_LON = "hd_loc_result_lon";
        public static final String KEY_NAVI_GPS_BIAS_LIST = "gps_bias_list";
        public static final String KEY_NAVI_GPS_STATUS = "gps_status";
        public static final String KEY_NAVI_IS_VIADUCT = "is_viaduct";
        public static final String KEY_NAVI_LANE_INFO = "hd_navi_info";
        public static final String KEY_NAVI_LANE_INFO_IS_HP = "hd_navi_is_hp";
        public static final String KEY_NAVI_LANE_INFO_LANE_RES = "hd_navi_lane_result";
        public static final String KEY_NAVI_LOC_INFO = "navi_loc_info";
    }

    /* loaded from: classes7.dex */
    public static class NaviVdrConst {
        public static final String KEY_VDR_DIRECTION = "vdr_direction";
        public static final String KEY_VDR_LAT = "vdr_lat";
        public static final String KEY_VDR_LOCATION = "vdr_location";
        public static final String KEY_VDR_LON = "vdr_lon";
        public static final String KEY_VDR_RADIUS = "vdr_radius";
        public static final String KEY_VDR_SOURCE = "vdr_source";
        public static final String KEY_VDR_SPEED = "vdr_speed";
        public static final String KEY_VDR_TIME = "vdr_time";
    }

    /* loaded from: classes7.dex */
    public static class PermissionType {
        public static final String KEY_PERMISSION_TYPE = "permission_type";
        public static final int REQUEST_BLUETOOTH_PERMISSION = 1;

        /* loaded from: classes7.dex */
        public static class PermissionStatus {
            public static final int STATUS_AGREE = 2;
            public static final int STATUS_REJECT = 1;
        }
    }

    /* loaded from: classes7.dex */
    public static class PoiDataConst {
        public static final String KEY_INDOOR_AREA = "indoor_area";
        public static final String KEY_INDOOR_LOC_NAME = "indoor_loc_name";
        public static final String KEY_INDOOR_LOC_TYPE = "indoor_loc_type";
        public static final String KEY_INDOOR_PARKING_LOT_NUM = "indoor_parking_lot_num";
        public static final String KEY_INDOOR_PARKING_LOT_UID = "indoor_parking_lot_uid";
        public static final String KEY_INDOOR_PARK_UID = "indoor_park_uid";
        public static final String KEY_INDOOR_USER_STATUS = "indoor_user_status";
    }

    /* loaded from: classes7.dex */
    public static class SceneType {
        public static final int SCENE_TYPE_RECOGNITION_SUBWAY = 1;
        public static final int SCENE_TYPE_RECOGNITION_TRAFFIC_TYPE = 2;
        public static final int SCENE_TYPE_RECOGNITION_VEHICLE = 3;
    }

    /* loaded from: classes7.dex */
    public static class SubWayErrorCode {
        public static final int SUBWAY_ERROR_LOC_ENGINE_INTERNAL = -5;
        public static final int SUBWAY_ERROR_LOC_ENGINE_MISS_DATA = -4;
        public static final int SUBWAY_ERROR_LOC_KNOWN = -6;
        public static final int SUBWAY_ERROR_NONSUPPORT_PRESSURE = -2;
        public static final int SUBWAY_ERROR_SWITCH_CLOSE = -1;
        public static final int SUBWAY_LOC_SDK_ERROR = -3;
    }

    /* loaded from: classes7.dex */
    public static class TrafficStatus {
        public static final int TRAFFIC_ERROR_LOC_ENGINE_INTERNAL = -6;
        public static final int TRAFFIC_ERROR_LOC_ENGINE_MISS_DATA = -5;
        public static final int TRAFFIC_ERROR_LOC_KNOWN = -7;
        public static final int TRAFFIC_ERROR_LOC_SDK = -4;
        public static final int TRAFFIC_ERROR_MODEL_LOAD_FAILED = -8;
        public static final int TRAFFIC_ERROR_NONSUPPORT_BLUETOOTH = -2;
        public static final int TRAFFIC_ERROR_NON_OPEN_BLUETOOTH = -3;
        public static final int TRAFFIC_ERROR_PREDICT_GPS_NO_DATA = 112;
        public static final int TRAFFIC_ERROR_PREDICT_MODEL_CUL_FAILED = 113;
        public static final int TRAFFIC_ERROR_SWITCH_CLOSE = -1;
        public static final int TRAFFIC_ERROR_USER_PERMISSION_REJECT = -9;
        public static final int TRAFFIC_SCAN_BLUETOOTH_FINISH = 101;
        public static final int TRAFFIC_SCAN_BLUETOOTH_NO_DATA = 102;
        public static final int TRAFFIC_STATUS_BUS = 2;
        public static final int TRAFFIC_STATUS_DRIVE = 0;
        public static final int TRAFFIC_STATUS_SUBWAY = 3;
        public static final int TRAFFIC_STATUS_WALK = 1;
    }
}
