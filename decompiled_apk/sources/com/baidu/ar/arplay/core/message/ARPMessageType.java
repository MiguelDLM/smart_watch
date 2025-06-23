package com.baidu.ar.arplay.core.message;

/* loaded from: classes7.dex */
public class ARPMessageType {
    public static final int LUA_REQUEST_ANSWER = 9003;
    public static final int LUA_REQUEST_STATUS = 9002;
    public static final int LUA_URL_REQUEST = 9001;
    public static final int MSG_ALL = 0;
    public static final int MSG_CASE_DESTROY_COMPLETED = 9;
    public static final int MSG_CASE_INIT_COMPLETED = 8;
    public static final int MSG_ENGINE_CREATE_COMPLETED = 6;
    public static final int MSG_ENGINE_DESTROY_COMPLETED = 7;
    public static final int MSG_GLOBAL_FILTER_CREATE_COMPLETED = 12;
    public static final int MSG_MODEL_APPEAR = 201;
    public static final int MSG_MODEL_DISAPPEAR = 202;
    public static final int MSG_NONE = -1;
    public static final int MSG_ON_RECEIVE_FILTER_NAME_LIST = 50;
    public static final int MSG_OPEN_OFFSCREEN_UPDATE = 7001;
    public static final int MSG_PLAY_MUSIC = 1001;
    public static final int MSG_PLAY_MUSIC_RES = 1002;
    public static final int MSG_START_CONFIG = 10;
    public static final int MSG_SWITCH_APP_TYPE = 401;
    public static final int MSG_TEMPLETE_INIT_COMPLETED = 13;
    public static final int MSG_TRACK_FOUND = 101;
    public static final int MSG_TRACK_FOUND_HANDLER_SET = 103;
    public static final int MSG_TRACK_LOST = 102;
    public static final int MSG_TRACK_LOST_HANDLER_SET = 104;
    public static final int MSG_TYPE_AUDIO = 5211;
    public static final int MSG_TYPE_DEVICE_ORIENTATION = 4001;
    public static final int MSG_TYPE_IMU_CLOSE = 303;
    public static final int MSG_TYPE_IMU_CLOSE_RES = 304;
    public static final int MSG_TYPE_IMU_MIRROR_DATA = 306;
    public static final int MSG_TYPE_IMU_OPEN = 301;
    public static final int MSG_TYPE_IMU_OPEN_RES = 302;
    public static final int MSG_TYPE_IMU_RESET_LOCATION = 305;
    public static final int MSG_TYPE_LUA_CALL_SDK_FUC = 3002;
    public static final int MSG_TYPE_LUA_SDK_BRIDGE = 1901;
    public static final int MSG_TYPE_MODEL_LOAD_PROGRESS = 6001;
    public static final int MSG_TYPE_MUSIC_FAILED = 1010;
    public static final int MSG_TYPE_MUSIC_FINISHED = 1009;
    public static final int MSG_TYPE_MUSIC_PLAY_INFO_UPDATE = 1011;
    public static final int MSG_TYPE_MUSIC_RESET = 1012;
    public static final int MSG_TYPE_MUSIC_RESET_RES = 1013;
    public static final int MSG_TYPE_OBR_TO_SDK = 8200;
    public static final int MSG_TYPE_OPEN_URL = 1301;
    public static final int MSG_TYPE_PAUSE_MUSIC = 1003;
    public static final int MSG_TYPE_PAUSE_MUSIC_RES = 1004;
    public static final int MSG_TYPE_PHONE_CALL = 1401;
    public static final int MSG_TYPE_RELEASE = -2;
    public static final int MSG_TYPE_RESUME_MUSIC = 1005;
    public static final int MSG_TYPE_RESUME_MUSIC_RES = 1006;
    public static final int MSG_TYPE_RES_REQUEST = 5001;
    public static final int MSG_TYPE_RES_RESPONE = 5003;
    public static final int MSG_TYPE_RES_RESPONE_PROGRESS = 5002;
    public static final int MSG_TYPE_SDK_CALL_LUA_FUC = 3001;
    public static final int MSG_TYPE_SDK_LUA_BRIDGE = 1902;
    public static final int MSG_TYPE_SDK_RUN_SCRIPT = 2001;
    public static final int MSG_TYPE_SDK_SET_MODEL_COLOR = 2002;
    public static final int MSG_TYPE_SDK_TO_OBR = 8100;
    public static final int MSG_TYPE_SHARE = 1601;
    public static final int MSG_TYPE_SLAM_GUESTURE_INTERACTION = 4100;
    public static final int MSG_TYPE_STATISTICS = 1801;
    public static final int MSG_TYPE_STOP_MUSIC = 1007;
    public static final int MSG_TYPE_STOP_MUSIC_RES = 1008;
    public static final int MSG_TYPE_VIBERATOR = 1501;
    public static final int MSG_TYPE_VIDEO = 5210;
    public static final int MSG_TYPE_VIDEO_PAUSE = 1023;
    public static final int MSG_TYPE_VIDEO_PAUSE_RES = 1024;
    public static final int MSG_TYPE_VIDEO_PLAY = 1021;
    public static final int MSG_TYPE_VIDEO_PLAY_FAILED = 1029;
    public static final int MSG_TYPE_VIDEO_PLAY_FINISH = 1030;
    public static final int MSG_TYPE_VIDEO_PLAY_INFO_UPDATE = 1031;
    public static final int MSG_TYPE_VIDEO_PLAY_RES = 1022;
    public static final int MSG_TYPE_VIDEO_RESUME = 1025;
    public static final int MSG_TYPE_VIDEO_RESUME_RES = 1026;
    public static final int MSG_TYPE_VIDEO_STOP = 1027;
    public static final int MSG_TYPE_VIDEO_STOP_RES = 1028;
    public static final int MSG_TYPE_WAIT_SLAM_DATA = 4101;
    public static final int MSG_USR_INTERACTION_CONFIG = 11;

    /* loaded from: classes7.dex */
    public static class ARPLuaSdkBridgeMessageType {
        public static final int MSG_TYPE_SDK_LUA_GAME_CONFIG = 1001;
        public static final int MSG_TYPE_WEBVIEW_OPERATION = 10800;
    }

    /* loaded from: classes7.dex */
    public static class ARPMessageParamKeys {
        public static final String MAP_NPC_KEY_NAME = "script";
        public static final String MODEL_COLOR_KEY = "model_color";
        public static final String MODEL_TYPE_KEY = "model_type";
    }
}
