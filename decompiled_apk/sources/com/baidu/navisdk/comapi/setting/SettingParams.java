package com.baidu.navisdk.comapi.setting;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes7.dex */
public class SettingParams {

    /* loaded from: classes7.dex */
    public class Action {
        public static final int DAY_NIGHT_MODE_AUTO = 1;
        public static final int DAY_NIGHT_MODE_DAY = 2;
        public static final int DAY_NIGHT_MODE_NIGHT = 3;
        public static final int DEFAULT_GUIDE_MODE = 0;
        public static final int FLOAT = 1;
        public static final int HD_AUTO = 0;
        public static final int HD_FULL = 2;
        public static final int HD_HALF = 1;
        public static final int PIP = 0;
        public static final boolean ROUTE_STATE_MODE_HISTORY = false;
        public static final boolean ROUTE_STATE_MODE_REAL = true;
        public static final int ROUTE_VOMITSLOT_Dialog_MODE_HIDE = 5;
        public static final int ROUTE_VOMITSLOT_Dialog_MODE_SHOW = 4;
        public static final int SIMPLE_GUIDE_MODE = 1;
        public static final int TTS_PLAY_MODE_VOL_DOWN = 0;
        public static final int TTS_PLAY_MODE_VOL_STOP = 1;

        public Action() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface DayNightMode {
    }

    /* loaded from: classes7.dex */
    public static class DebugKey {
        public static final String BNRR_GPS_LOCATE_MODE_CUR = "rr_loc_mode_cur";
        public static final String BNRR_GPS_LOCATE_MODE_ENTER = "rr_loc_mode_enter";
    }

    /* loaded from: classes7.dex */
    public interface FirstGuideKey {
        public static final String LONG_TUNNEL_TIPS = "LONG_TUNNEL_TIPS";
        public static final String NAVI_XD_SCENE_AID_ADD_VIA = "NAVI_XD_SCENE_AID_CHANGE_PREFER";
        public static final String TRUCK_GUIDE = "TRUCK_GUIDE";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface HdNaviScreenMode {
    }

    /* loaded from: classes7.dex */
    public interface Key {
        public static final String ADDITION_PAGE_VISITED = "addition_page_visited";
        public static final String ADDRESS_LAST_UPLOAD_TIME = "ADDRESS_LAST_UPLOAD_TIME";
        public static final String ANALOG_QUIT_BUTTON = "analog_quit_button";
        public static final String ANALOG_SPEED_BUTTON = "analog_speed_button";
        public static final String ANALOG_SWITCH_BUTTON = "analog_switch_button";
        public static final String AR_NAV_ORIENTATION = "nav_ar_orientation";
        public static final String AR_NAV_STATE = "nav_ar_state";
        public static final String ASR_FIRST_USE = "ASR_FIRST_USE";
        public static final String BLUE_TOOTH_BLANK_VOICE_ENABLED = "bluetooth_blank_voice_enabled";
        public static final String BN_FIRST_GUIDE = "BN_FIRST_GUIDE";
        public static final String BN_SCENIC_BROADCAST_OPEN = "bn_s_b_open";
        public static final String BROADCAST_CONTENT_START_UP_TIME = "broadcast_content_start_up_time";
        public static final String CAR_PLATE_NUM = "car_plate_num";
        public static final String CAR_PLATE_NUM_NEW = "nav_cpn";
        public static final String CAR_POWER_TYPE = "car_power_type";
        public static final String CAR_TOP_TAB_BUBBLE = "car_top_tab_bubble";
        public static final String CHALLENGE_MODE_DEBUG = "challenge_mode_debug";
        public static final String CHALLENGE_MODE_RECORD_GUIDE_CONTENT_MD5 = "challenge_mode_record_guide_content_md5";
        public static final String CHALLENGE_MODE_RECORD_INFO = "challenge_mode_info";
        public static final String CHALLENGE_MODE_RECORD_UPLOAD_SUCCESS_COUNT = "challenge_mode_record_upload_success_count";
        public static final String CHALLENGE_MODE_TRUCK_BOTTOM_RED_POINT_EVER_SHOWN = "truck_bottom_challenge_mode_red_point";
        public static final String CHARGE_PREFER = "charge_prefer";
        public static final String CLOSE_ASR_WAKEUP_POWER_SAVE = "close_asr_wakeUp_power_save";
        public static final String COLLADA_SWITCH = "COLLADA_SWITCH";
        public static final String COMMUTE_DEBUG = "commute_debug";
        public static final String COMMUTE_FUN = "commute_fun";
        public static final String COMMUTE_FUN_PREFER = "commute_fun_prefer";
        public static final String COMMUTE_GUIDE_AUTO_ENTER_SOUND_TIP_DIALOD = "ever_show_commute_auto_enter_dialog";
        public static final String COMMUTE_GUIDE_BOTTOM_TAB_BUBBLE = "commute_guide_bottom_tab_bubble";
        public static final String COMMUTE_GUIDE_BUBBLE_DISPLAY_HISTORY = "commute_guide_bubble_display_history";
        public static final String COMMUTE_GUIDE_CAN_SHOW_LOCATION_BTN_BUBBLE = "commute_guide_can_show_location_btn_bubble";
        public static final String COMMUTE_GUIDE_CAN_SHOW_SETTING_BTN_BUBBLE = "commute_guide_can_show_setting_btn_bubble";
        public static final String COMMUTE_GUIDE_CONCERN_ROAD_DIALOD = "ever_show_commute_concern_road_dialog";
        public static final String COMMUTE_GUIDE_EVER_SHOW_CONCERN_ROAD_TIP_PANEL = "ever_show_concern_road_tip_panel";
        public static final String COMMUTE_GUIDE_SETTING_AUTO_ENTER_NAVI = "commute_auto_enter_navi";
        public static final String COMMUTE_GUIDE_SETTING_BTN_BUBBLE = "commute_guide_bottom_tab_bubble";
        public static final String COMMUTE_GUIDE_SETTING_SCALE = "commute_guide_scale_setting";
        public static final String COMMUTE_GUIDE_SETTING_SOUND = "commute_guide_setting_sound";
        public static final String COMMUTE_GUIDE_SETTING_SOUND_COMBINE = "commute_guide_setting_sound_unit";
        public static final String COMMUTE_GUIDE_SETTING_SOUND_ELE_EYE = "commute_guide_setting_sound_ele_eye";
        public static final String COMMUTE_GUIDE_SETTING_SOUND_TURN = "commute_guide_setting_sound_turn";
        public static final String COMMUTE_GUIDE_VISUAL_MODE = "commute_guide_visual_mode";
        public static final String COMMUTE_LICENCE_AGREE_STATE = "commute_licence_agree_state";
        public static final String COMMUTE_ROUTE_TAB_CONCERN_GUIDE = "commute_route_tab_concern_road_guide";
        public static final String COMMUTE_SOUND_SETTING_OUTER = "commute_dsound_setting_outer";
        public static final String CRUISE_SAFE_GUARD_SHOW = "cruise_safe_guard_show";
        public static final String CUR_GLOBAL_VOICE_TASK_ID = "cur_global_voice_task_id";
        public static final String CUR_PUTONGHUA_PERSONALISE_VOICE_TASK_ID = "cur_putonghua_personalise_voice_task_id";
        public static final String DAY_NIGHT_GUIDE_HAS_SHOW = "day_night_guide_has_show";
        public static final String DEBUG_MODE_CALC_ROAD_VERSION = "debug_mode_calc_road_version";
        public static final String DEBUG_MODE_ROUTE_GUIDE_VERSION = "debug_mode_routeguide_version";
        public static final String DIY_SWITCH_GUIDE_SHOW_TIMES_IN_NAVI = "diy_switch_guide_show_times";
        public static final String DYNA_UI_PRELOAD = "dyna_ui_preload";
        public static final String ENTER_NAVI_BY_ROOKIE_MODE = "enter_navi_by_rookie_mode";
        public static final String EVER_DO_FUTURE_TRIP_SCROLL_GUIDE = "future_trip_scroll_guide";
        public static final String EVER_SHOW_LIGHT_COMMUTE_GUIDE_PANEL = "light_page_commute_guide_panel";
        public static final String EVER_SHOW_RG_MOSS_RED_POINT = "rg_ever_show_moss_guide_red_point";
        public static final String EVER_SHOW_RR_MOSS_RED_POINT = "rr_ever_show_moss_guide_red_point";
        public static final String FELLOW_DEBUG_CITY_NAME = "FELLOW_DEBUG_CITY_NAME";
        public static final String FELLOW_IS_BUTTON_CLICK = "FELLOW_IS_BUTTON_CLICK";
        public static final String FELLOW_PREFER_TIPS_TTS_COUNT = "fellow_prefer_tips_tts_count";
        public static final String FELLOW_PREFER_TIPS_TTS_KEY = "fellow_prefer_tips_tts_key";
        public static final String FELLOW_SUPPORT = "fellow_support";
        public static final String FELLOW_SWITCH = "fellow_switch";
        public static final String FELLOW_TIPS_SHOW = "FELLOW_TIPS_SHOW";
        public static final String FIRST_GUIDE_PANEL_MODE_GUIDE_SHOW = "first_guide_power_save_mode";
        public static final String FIRST_INSTALL_USER = "first_install_user";
        public static final String FIRST_ITS_ON = "FIRST_ITS_ON";
        public static final String FIRST_ROUTE_PLAN = "first_rout_plan";
        public static final String FIRST_VOICE_NOTIFY_GUIDE = "FIRST_VOICE_NOTIFY_GUIDE";
        public static final String FUTURE_TRIP_ITEM_GUIDE = "future_trip_histogram_item_guide";
        public static final String FUTURE_TRIP_PLAN_FOR_DEBUG = "future_trip_plan_for_debug";
        public static final String GPS_CLOSE_VDR_FUNCTION_NORMAL = "gps_close_vdr_function_normal";
        public static final String HAS_TURN_ON_ROOKIE_MODE = "has_turn_on_rookie_mode";
        public static final String HAS_UPLOAD_ADDRESS = "asr_has_upload_address";
        public static final String HD_CLOSE_CONFIRM_PANEL_SHOWED = "is_show_hd_close_confirm_panel";
        public static final String HD_NAVI_DEFAULT_MODE = "hd_navi_default_mode";
        public static final String HD_NAVI_ENABLE = "hd_navi_enable";
        public static final String HD_NAVI_SCREEN_MODE = "hd_navi_screen_mode";
        public static final String HIGHWAY_SIMPLE_BOARD = "highway_simple_board";
        public static final String HOLIDAY_RED_GIFT = "HOLIDAY_RED_GIFT";
        public static final String HUD_MIRRO_SHOW = "IS_SHOW_HUD_MIRRO";
        public static final String HUD_SDK_SWITCH = "hudsdk_switch";
        public static final String IPO_GUIDE_SHOW_TIME = "IPO_GUIDE_SHOW_TIME";
        public static final String IPO_NAVI_LOCK_GUIDE = "ipo_navi_lock_guide";
        public static final String IS_CLICKED_SETTING_PAGE_NAVI_SETTING_ITEM = "is_clicked_setting_page_navi_setting_item";
        public static final String IS_CLICKED_TOOLBOX_SETTING_ITEM = "is_clicked_toolbox_setting_item";
        public static final String IS_ENTERED_NAVI_VOICE_SETTING_PAGE = "rr_is_entered_voice_setting_page";
        public static final String IS_ENTERED_OUT_NAV_SETTING_PAGE = "rr_is_entered_out_nav_setting_page";
        public static final String IS_FIRST_SETUP_BROADCAST_MODE = "is_first_setup_broadcast_mode";
        public static final String IS_IPO_GUIDE_FIRST_SHOW = "IS_IPO_GUIDE_FIRST_SHOW";
        public static final String IS_LIGHT_POWER_MODE_FIRST_ENABLE = "IS_LIGHT_POWER_MODE_FIRST_ENABLE";
        public static final String JAM_ROAD_GUIDE_IS_SHOWN = "jam_road_guide_is_shown";
        public static final String KEY_CHECK_NEW_DATA = "CHECK_NEW_DATA";
        public static final String LAST_CLOSE_CAR_HOME_DIALOG_VERSION = "last_close_car_home_dialog_version";
        public static final String LAST_CLOSE_CAR_HOME_TIP_VERSION = "last_close_car_home_tip_version";
        public static final String LAST_SHOW_3D_CARLOGO_BUBBLE_TEXT = "last_show_3d_carlogo_bubble_text";
        public static final String LAST_SHOW_3D_CARLOGO_BUBBLE_TIME = "last_show_3d_carlogo_bubble_time";
        public static final String LEAK_CANARY_FUNCTION_STATUS = "leak_canary_function_status";
        public static final String LIGHT_EVER_SHOW_MOSS_GUIDE = "light_ever_show_moss_guide";
        public static final String LIGHT_NAVI_QUIET = "light_navi_quiet";
        public static final String LIGHT_NAVI_SAVE_POWER = "light_navi_save_power";
        public static final String LIGHT_NAV_CAR_ICON_OFFSET = "light_nav_car_icon_offset";
        public static final String LIGHT_NAV_ROUTE_VIEW_SIZE = "light_nav_route_view_size";
        public static final String LIGHT_RED_POINT = "light_red_point";
        public static final String LIGHT_USER_GUIDE = "light_user_guide";
        public static final String LOCATION_SUPPORT_BD = "loc_support_bd";
        public static final String MAPS_INIT_TIME = "maps_startup_time";
        public static final String NAVING_SETTING_VISITED = "naving_setting_visited";
        public static final String NAVING_START_BY_FULLVIEW = "naving_start_by_fullview";
        public static final String NAVI_ALWAYS_BRIGHT = "NAVI_ALWAYS_BRIGHT";
        public static final String NAVI_ANTI_CHEAT = "NAVI_ANTI_CHEAT";
        public static final String NAVI_ASR_SHOW = "NAVI_ASR_SHOW";
        public static final String NAVI_ASR_WAKUP_ON_OFF = "NAVI_ASR_ON_OFF";
        public static final String NAVI_AUTO_CHECK_NEW_DATA = "NAVI_AUTO_CHECK_NEW_DATA";
        public static final String NAVI_AUTO_ENTER_LIGHT_NAVI = "NAVI_AUTO_ENTER_LIGHT_NAVI";
        public static final String NAVI_AUTO_LEVEL = "NAVI_AUTO_LEVEL";
        public static final String NAVI_AUTO_UPDATE_NEW_DATA = "NAVI_AUTO_UPDATE_NEW_DATA";
        public static final String NAVI_BLUETOOTH_CHANNEL_MODE = "nav_b_c_t";
        public static final String NAVI_BLUE_TOOTH_NAME = "NAVI_BLUE_TOOTH_NAME";
        public static final String NAVI_BLUE_TOOTH_PHONE_CHANNEL = "NAVI_BLUE_TOOTH_PHONE_CHANNEL";
        public static final String NAVI_BT_GUIDE_SHOWED = "navi_bt_guide_showed_2";
        public static final String NAVI_CHARGE_AREA_TIP_DISPLAY_COUNT = "charge_area_tip_display_count";
        public static final String NAVI_CHARGE_AREA_TIP_DISPLAY_TIME = "charge_area_tip_display_time";
        public static final String NAVI_DEFAULT_LAUNCH_MODE = "NAVI_DEFAULT_LAUNCH_MODE";
        public static final String NAVI_DEFAULT_MODE_DAY_AND_NIGHT_FROM_CLOUD = "NAVI_DEFAULT_MODE_DAY_AND_NIGHT_FROM_CLOUD";
        public static final String NAVI_DEFAULT_ROUTE_SORT = "NAVI_DEFAULT_SORT_VALUE";
        public static final String NAVI_DEST_PARK_SWITCH_CLICKED = "nav_dest_park_switch_clicked";
        public static final String NAVI_DIY_CUSTOM_MODE_VALUE = "NAVI_DIY_CUSTOM_MODE_VALUE";
        public static final String NAVI_DIY_VOICE_AUTO_CHANGE_AID_CANCEL = "NAVI_DIY_VOICE_AUTO_CHANGE_AID_CANCEL";
        public static final String NAVI_DIY_VOICE_AUTO_CHANGE_IN_MUSIC = "NAVI_DIY_VOICE_AUTO_CHANGE_IN_MUSIC";
        public static final String NAVI_DIY_VOICE_MODE = "NAVI_DIY_VOICE_MODE";
        public static final String NAVI_DIY_VOICE_MODE_OPEN = "NAVI_DIY_VOICE_MODE_OPEN";
        public static final String NAVI_DIY_VOICE_MODE_SWITCH_GUIDE = "NAVI_DIY_VOICE_MODE_SWITCH_GUIDE";
        public static final String NAVI_DIY_VOICE_MUSIC_AID_COUNT = "NAVI_DIY_VOICE_MUSIC_AID_COUNT";
        public static final String NAVI_EVER_ENTERED_FUTURE_TRIP = "show_bnrr_arrive_time_bubble";
        public static final String NAVI_FELLOW_DEBUG = "NAVI_FELLOW_DEBUG";
        public static final String NAVI_FIRST_BLUE_TOOTH_CHANNEL_GUIDE = "NAVI_FIRST_BLUE_TOOTH_CHANNEL_GUIDE";
        public static final String NAVI_FIRST_CAR_LOGO_GUIDE = "NAVI_FIRST_CAR_LOGO_GUIDE";
        public static final String NAVI_FIRST_GUIDE_MODE_GUIDE = "NAVI_FIRST_GUIDE_MODE_GUIDE";
        public static final String NAVI_FIRST_MENU_GUIDE = "NAVI_FIRST_MENU_GUIDE";
        public static final String NAVI_FIRST_MORE_MENU_GUIDE = "NAVI_FIRST_MORE_MENU_GUIDE";
        public static final String NAVI_FIRST_VOICE_GUIDE = "NAVI_FIRST_VOICE_GUIDE";
        public static final String NAVI_FLOAT_SWITCH = "NAVI_FLOAT_SWITCH";
        public static final String NAVI_FUTURE_TRIP_ETA_URL = "future_trip_eta_url";
        public static final String NAVI_GPS_DEBUG = "NAVI_GPS_DEBUG";
        public static final String NAVI_GPS_HOT_STAST = "NAVI_GPS_HOT_STAST";
        public static final String NAVI_GUIDE_END = "NAVI_GUIDE_END";
        public static final String NAVI_GUIDE_VIEW_MODE = "NAVI_GUIDE_VIEW_MODE";
        public static final String NAVI_INIT_CLOUD_CFG = "NAVI_INIT_CLOUD_CFG";
        public static final String NAVI_INIT_CLOUD_CFG_URL = "NAVI_INIT_CLOUD_CFG_URL";
        public static final String NAVI_IPO_ROADCOND_ON_OFF = "NAVI_IPO_ROADCOND_ON_OFF";
        public static final String NAVI_LAST_IS_SHOW_NO_HIGH_WAY_BUBBLE = "last_is_show_no_high_way_bubble";
        public static final String NAVI_LAST_QUIET_MODE = "NAVI_LAST_QUIET_MODE";
        public static final String NAVI_LAST_VOICE_MODE = "NAVI_LAST_VOICE_MODE";
        public static final String NAVI_LOCATION_SHARE_FUNC_ONLINE = "NAVI_LOCATION_SHARE_FUNC_ONLINE";
        public static final String NAVI_LOCATION_SHARE_FUNC_OPEN = "NAVI_LOCATION_SHARE_FUNC_OPEN";
        public static final String NAVI_LOCATION_SHARE_FUNC_USING = "NAVI_LOCATION_SHARE_FUNC_USING";
        public static final String NAVI_LOW_PERF_VOICE_PATH = "navi_low_perf_voice_path";
        public static final String NAVI_MAP_MODE = "navi_map_mode";
        public static final String NAVI_MODE_DAY_AND_NIGHT = "NAVI_MODE_DAY_AND_NIGHT";
        public static final String NAVI_MONKEY = "NAVI_MONKEY";
        public static final String NAVI_ORIENTATIOJN_CHANGED_DIALOG_SHOW_COUNT = "navi_orientation_changed_dialog_show_count";
        public static final String NAVI_ORIENTATION_LANDSCAPE_BY_USER = "orientation_landscape_by_user";
        public static final String NAVI_ORITATION_BTN_NEW_TAG = "NAVI_ORITATION_BTN_NEW_TAG";
        public static final String NAVI_PARK_SEARCH = "NAVI_PARK_SEARCH";
        public static final String NAVI_PIP_SWITCH = "NAVI_PIP_SWITCH";
        public static final String NAVI_PLAY_BACKGROUND_SPEAK = "NAVI_PLAY_BACKGROUND_SPEAK";
        public static final String NAVI_PLAY_VOICE_WHEN_CALLING = "navi_p_v_w_c";
        public static final String NAVI_PLUGIN_MD5 = "navi_plugin_md5";
        public static final String NAVI_POWER_SAVE_MODE = "NAVI_POWER_SAVE_MODE";
        public static final String NAVI_PRO_SETTING_GROUP_RANK = "navi_pro_setting_group_rank";
        public static final String NAVI_PRO_SHORTCUT_FUN = "navi_pro_shortcut_fun";
        public static final String NAVI_PUSH_SERVICE = "NAVI_PUSH_SERVICE";
        public static final String NAVI_REAL_HISTORY_ITS = "NAVI_REAL_HISTORY_ITS";
        public static final String NAVI_REMEMBER_LAUNCH_MODE = "NAVI_REMEMBER_LAUNCH_MODE";
        public static final String NAVI_REMEMBER_PREFER_BUBBLE = "route_prefer_remember_prefer_bubble";
        public static final String NAVI_ROADCOND_ON_OFF = "NAVI_ROADCOND_ON_OFF";
        public static final String NAVI_ROOT_SCREEN = "ROOT_SCREEN_OPEN";
        public static final String NAVI_ROUTEPLAN_RESULT_PREF = "NAVI_ROUTEPLAN_RESULT_PREF";
        public static final String NAVI_ROUTE_PREFER_GUID_IS_CLICK = "NAVI_ROUTE_PREFER_GUID_IS_CLICK";
        public static final String NAVI_ROUTE_PREFER_REMEMBER_IS_OPEN = "navi_remember_route_prefer_is_open";
        public static final String NAVI_ROUTE_SORT_CAR_RESULT_CARD_GUIDE = "NAVI_ROUTE_SORT_CAR_RESULT_CARD_GUIDE_10300";
        public static final String NAVI_ROUTE_SORT_DRIVING_HABIT = "NAVI_SORT_DRIVING_HABIT_VALUE";
        public static final String NAVI_ROUTE_SORT_SETTING_PAGE_GUIDE = "NAVI_ROUTE_SORT_SETTING_PAGE_GUIDE";
        public static final String NAVI_ROUTE_SORT__IS_SHOW_DRIVING_HABIT = "NAVI_IS_SHOW_DRIVING_HABIT";
        public static final String NAVI_RP_NET_MODE = "NAVI_RP_NET_MODE";
        public static final String NAVI_RP_NET_MODE_MOTOR = "NAVI_RP_NET_MODE_MOTOR";
        public static final String NAVI_RP_NET_MODE_OFFLINE_USE_CAR = "NAVI_RP_NET_MODE_OFFLINE_USE_CAR";
        public static final String NAVI_RP_NET_MODE_SET = "NAVI_RP_NET_MODE_SET";
        public static final String NAVI_RP_NET_MODE_TRUCK = "NAVI_RP_NET_MODE_TRUCK";
        public static final String NAVI_SAFEGUARD_TIPS_SHOWED = "navi_safe_t_showed";
        public static final String NAVI_SAFE_YELLOW_BAR_DISPLAY_COUNT = "navi_safe_yellow_bar_display_count";
        public static final String NAVI_SAVE_PARKING_SWITCH = "NAVI_SAVE_PARKING_SWITCH";
        public static final String NAVI_SEARCH_NET_MODE = "NAVI_SEARCH_NET_MODE";
        public static final String NAVI_SEARCH_RESULT_SORT_PREF = "NAVI_SEARCH_RESULT_SORT_PREF";
        public static final String NAVI_SENSOR_CHECK_DEBUG = "navi_sensor_check_debug";
        public static final String NAVI_SERVICE_AREA_TIP_DISPLAY_COUNT = "service_area_tip_display_count";
        public static final String NAVI_SHOWLOCATION_ONOFF = "NAVI_LOCATION_SHOULD_SHOW";
        public static final String NAVI_SHOW_BNRR_FUTURE_TRIP_ARRIVE_BUBBLE_TIME_STAMP = "show_bnrr_arrive_time_bubble_time_stamp";
        public static final String NAVI_SHOW_CAR_LOGO_TO_END = "SHOW_CAR_LOGO_TO_END";
        public static final String NAVI_SHOW_DISCLAIMER = "NAVI_SHOW_DISCLAIMER";
        public static final String NAVI_SHOW_FUTURE_TRIP_ARRIVE_BUBBLE = "show_future_trip_arrive_time_bubble";
        public static final String NAVI_SHOW_FUTURE_TRIP_DEPART_BUBBLE = "show_future_trip_depart_time_bubble";
        public static final String NAVI_SHOW_JAVA_LOG = "NAVI_SHOW_JAVALOG";
        public static final String NAVI_SHOW_LOCATION_SHARE_BTN_NEW_TAG = "NAVI_SHOW_LOCATION_SHARE_BTN_NEW_TAG";
        public static final String NAVI_SHOW_MAP_SWITCH = "NAVI_SHOW_MAP_SWITCH";
        public static final String NAVI_SHOW_MORE_BTN_NEW_TAG = "NAVI_SHOW_MORE_BTN_NEW_TAG";
        public static final String NAVI_SHOW_NATIVE_LOG = "NAVI_SHOW_NATIVE_LOG";
        public static final String NAVI_SHOW_NEW_MAP_SWITCH = "NAVI_SHOW_NEW_MAP_SWITCH";
        public static final String NAVI_SHOW_ONLINE_USE = "NAVI_SHOW_ONLINE_USE";
        public static final String NAVI_SHOW_PHONE_STATE_DECLARE = "NAVI_SHOW_PHONE_STATE_DECLARE";
        public static final String NAVI_TEST_ENVIRONMENT = "navi_test_environment";
        public static final String NAVI_TEST_ENVIRONMENT_URL = "navi_test_environment_url";
        public static final String NAVI_TRACK_RECORD_ONOFF = "NAVI_TRACK_RECORD";
        public static final String NAVI_TTS_ENGINE_VERSION = "navi_tts_engine_version";
        public static final String NAVI_TTS_PLAY_MODE = "NAVI_TTS_PLAY_MODE";
        public static final String NAVI_TTS_SPEED = "NAVI_TTS_SPEED";
        public static final String NAVI_TTS_VOCODER = "NAVI_TTS_VOCODER";
        public static final String NAVI_TTS_VOL = "NAVI_TTS_VOL";
        public static final String NAVI_UPDATE_APK_NOT_ALERT = "NAVI_UPDATE_APK_NOT_ALERT";
        public static final String NAVI_UPDATE_APK_VERSION = "NAVI_UPDATE_APK_VERSION";
        public static final String NAVI_USE_HTTPS_OFFLINE_URL = "NAVI_USE_HTTPS_OFFLINE_URL";
        public static final String NAVI_USE_LANELINE_DEBUG = "navi_laneline_DEBUG";
        public static final String NAVI_USE_TEXTUREVIEW_DEBUG = "navi_use_textureview_DEBUG";
        public static final String NAVI_VDR_LOW_OPERABLE_NOTIFICATION_SHOW_DATE = "navi_vdr_low_notif_SHOW_DATE";
        public static final String NAVI_VIA_POINT_COUNT = "navi_via_point_count";
        public static final String NAVI_VIA_PREFER_ROUTE_PLAN = "navi_via_prefer_route_plan";
        public static final String NAVI_VOICE_BTN_NEW_TAG = "NAVI_VOICE_BTN_NEW_TAG";
        public static final String NAVI_VOICE_BTN_TIPS_PLAYED = "nav_voice_btn_tips_played";
        public static final String NAVI_VOICE_BTN_TIPS_SHOWED = "nav_voice_btn_tips_showed";
        public static final String NAVI_VOICE_JINSHA_AUTO_DOWNLOAD = "NAVI_VOICE_JINSHA_AUTO_DOWNLOAD";
        public static final String NAVI_VOICE_MAIDOU_GUIDE = "NAVI_VOICE_MAIDOU_Guide";
        public static final String NAVI_VOICE_MODE = "NAVI_VOICE_MODE";
        public static final String NAVI_VOICE_NEW_VOICE_TASKIDS = "NAVI_VOICE_NEW_VOICE_TASKIDS";
        public static final String NAVI_VOICE_RECOMMEN_HAS_CLICKED = "NAVI_VOICE_RECOMMEN_HAS_CLICKED";
        public static final String NAVI_VOICE_RECOMMEN_SHOW_COUNT = "NAVI_VOICE_RECOMMEN_SHOW_COUNT";
        public static final String NAVI_VOICE_TTS_DATA_PATH = "NAVI_VOICE_TTS_DATA_PATH";
        public static final String NAVI_WEATHER_BTN_TIPS_HAS_SHOW = "nav_weather_btn_tips_has_show";
        public static final String NAVI_XD_AWAKEND = "nav_xd_awakened";
        public static final String NAVI_XD_SCENE_AID_CHANGE_PREFER = "NAVI_XD_SCENE_AID_CHANGE_PREFER";
        public static final String NAVI_XD_SCENE_AID_DAYNIGHT = "NAVI_XD_SCENE_AID_DAYNIGHT";
        public static final String NAVI_XD_SCENE_AID_REFRESH_ROUTE = "NAVI_XD_SCENE_AID_REFRESH_ROUTE";
        public static final String NAVI_XD_SCENE_AID_SWITCH_ROUTE = "NAVI_XD_SCENE_AID_SWITCH_ROUTE";
        public static final String NAVI_XD_SCENE_AID_UGC_UPLOAD = "NAVI_XD_SCENE_AID_UGC_UPLOAD";
        public static final String NAVI_XD_SCENE_AID_VOICE_MODE = "NAVI_XD_SCENE_AID_VOICE_MODE";
        public static final String NAV_AR_MOCK = "nav_ar_mock";
        public static final String NAV_AR_RECORD = "nav_ar_record";
        public static final String NAV_AUTO_QUIT_ARRIVE = "auto_quit_arrive";
        public static final String NAV_AVOIDANCE_NOTIFICATION = "nav_avoidance_notification";
        public static final String NAV_AVOIDANCE_REMINDER = "nav_avoidance_reminder";
        public static final String NAV_CAR_BRAND = "nav_car_brand";
        public static final String NAV_CAR_BRAND_ID = "nav_car_brand_id";
        public static final String NAV_CAR_BRAND_MODEL = "nav_car_brand_model";
        public static final String NAV_CAR_BRAND_NAME = "nav_car_brand_name";
        public static final String NAV_CAR_ETC_CLASS = "nav_car_etc_class";
        public static final String NAV_CAR_ETC_COLOR = "nav_car_etc_color";
        public static final String NAV_CAR_ICON = "nav_car_icon";
        public static final String NAV_CAR_IS_ETC = "nav_car_is_etc";
        public static final String NAV_CAR_IS_NEW_ENERGY = "nav_car_is_new_energy";
        public static final String NAV_CAR_IS_PICKUP = "nav_car_is_pickup";
        public static final String NAV_CAR_NEW_ENERGY_CHARGE_PREFER = "nav_car_new_energy_charge_prefer";
        public static final String NAV_CAR_NEW_ENERGY_EXT = "nav_car_new_energy_ext";
        public static final String NAV_CAR_NEW_ENERGY_REMAIN_MILEAGE = "nav_car_new_energy_remain_mileage";
        public static final String NAV_CAR_PASSPORT_IDS = "nav_car_passport_ids";
        public static final String NAV_DISPATCH_TAG = "nav_dispatch_tag";
        public static final String NAV_END_YELLOW_BANNER_CLICK = "NAV_END_YELLOW_BANNER_CLICK";
        public static final String NAV_END_YELLOW_BANNER_SHOW = "NAV_END_YELLOW_BANNER_SHOW";
        public static final String NAV_ENERGY_DEFAULT_PLATE = "nav_energy_default_plate";
        public static final String NAV_ENERGY_DEFAULT_PLATE_NEW = "nav_energy_dp";
        public static final String NAV_ENG_BRAND_ID = "nav_eng_brand_id";
        public static final String NAV_ENG_ETC_CLASS = "nav_eng_etc_class";
        public static final String NAV_ENG_ETC_COLOR = "nav_eng_etc_color";
        public static final String NAV_ENG_ICON = "nav_eng_icon";
        public static final String NAV_ENG_IS_ETC = "nav_eng_is_etc";
        public static final String NAV_ENG_PASSPORT_IDS = "nav_eng_passport_ids";
        public static final String NAV_HIGHWAY_ENABLE = "nav_highway_enable";
        public static final String NAV_LANE_LINE_ENABLE = "nav_lane_line_enable";
        public static final String NAV_MAIN_AUXILIARY_OR_BRIDGE = "nav_main_auxiliary_or_bridge";
        public static final String NAV_MEASUREMENT_ENABLE = "nav_measurement_enable";
        public static final String NAV_MODE_PREFER = "nav_mode_prefer";
        public static final String NAV_NEVER_CLOSE_GPS = "nav_never_close_gps";
        public static final String NAV_OPEN_MULTI_ROUTE = "nav_open_multi_route";
        public static final String NAV_OPEN_NODE_CLICK = "nav_open_node_click";
        public static final String NAV_REFRESH_BUTTON = "nav_refresh_button";
        public static final String NAV_REMIND_DIALOG = "nav_remind_dialog";
        public static final String NAV_ROAD_CONDITION_BUTTON = "road_condition_button";
        public static final String NAV_ROAD_NAME_ENABLE = "nav_road_name_enable";
        public static final String NAV_SETTING_BOTTOM_BAR = "nav_setting_bottom_bar";
        public static final String NAV_SETTING_BUTTON = "nav_setting_button";
        public static final String NAV_UGC_BUTTON_ENABLE = "nav_ugc_button_enable";
        public static final String NAV_VOICE_BUTTON = "nav_voice_button";
        public static final String NAV_ZOOM_BUTTON = "nav_zoom_button";
        public static final String NEW_ENG_REMAIN_DISTANCE = "new_eng_remain_distance";
        public static final String NE_CAR_BRANDING_SHOW = "ne_car_branding_show";
        public static final String NE_CAR_GUIDE_DIALOG_LATEST_CLOSE_VERSION = "ne_car_guide_dialog_latest_close_version";
        public static final String NORMAL_HD_NAVI_ENABLE = "normal_hd_navi_enable";
        public static final String NORMAL_HD_NAVI_VERIFY_PANEL = "normal_hd_navi_verfiy_panel";
        public static final String Navi_ElecCamera_Speak = "Navi_ElecCamera_Speak";
        public static final String Navi_RoadCondition_Speak = "Navi_RoadCondition_Speak";
        public static final String Navi_SaftyDrive_Speak = "Navi_SaftyDrive_Speak";
        public static final String Navi_SpeedCamera_Speak = "Navi_SpeedCamera_Speak";
        public static final String Navi_StraightDirect_Speak = "Navi_StraightDirect_Speak";
        public static final String OFFLINEDATA_DOWNLOAD_ITEM_SET = "offlinedata_download_item_set";
        public static final String OPEN_HD_NAVI_BUBBLE_SHOWED = "is_show_open_hd_navi_b";
        public static final String OWNER_CAR_PLATE = "owner_car_plate";
        public static final String POI_SORT_RULE_TYPE = "POI_SORT_RULE_TYPE";
        public static final String PREF_NAVI_FIRST_USE = "PREF_NAVI_FIRST_USE";
        public static final String PROFESSIONAL_NAV_CAR_ICON_OFFSET = "profession_nav_car_icon_offset";
        public static final String PROFESSIONAL_NAV_CAR_ICON_OFFSET_USER_SET = "profession_nav_car_icon_offset_user_set";
        public static final String PROFESSIONAL_NAV_ROUTE_VIEW_SIZE = "professional_nav_route_view_size";
        public static final String QUIT_FOR_EXCEPTION_IN_NAVIMODE = "quit_for_exception_in_navimode";
        public static final String RC_IS_ALLOW_CLICK = "rc_is_allow_click";
        public static final String RC_IS_SHOW_AVOID = "rc_is_show_avoid";
        public static final String RECOMMEND_3D_CARLOGO_ID = "recommend_3d_carlogo_id";
        public static final String RG_FLOAT_CLOSE_MSG = "rg_float_close_msg";
        public static final String RG_FLOAT_MODE = "rg_float_mode";
        public static final String RG_FLOAT_OPEN_GUIDE_SHOW = "rg_float_show_open_guide";
        public static final String RG_IS_SHOW_CAR_DIRE_COMPASS = "rg_is_show_car_dire_compass";
        public static final String RG_IS_SHOW_CURRENT_ROAD = "rg_is_show_current_road";
        public static final String RG_IS_SHOW_HIGH_PANEL = "rg_is_show_high_panel";
        public static final String RG_IS_SHOW_LANE_LINE = "rg_is_show_lane_line";
        public static final String RG_IS_SHOW_SPEED_CLOCK = "rg_is_show_speed_clock";
        public static final String RG_IS_SHOW_XIAODU = "rg_is_show_xiaodu";
        public static final String RG_SCREEN_ORIENTATION = "rg_screen_orientation";
        public static final String RG_SETTING_BUBBLE_SHOW_TIMES = "rg_setting_bubble_show_times";
        public static final String RG_ZOOM_IN_BTN_SHOW = "rg_is_show_zoom_in_btn";
        public static final String ROOKIE_EVENT_OP_START_TIME = "rookie_event_op_start_time";
        public static final String ROOKIE_MODE_SHOW = "rookie_mode_show";
        public static final String ROUTE_DETAIL_GUIDE_SHOW_TIME = "route_detail_guide_show_time";
        public static final String ROUTE_FUTURE_TRIP_INFO = "car_route_future_trip_info";
        public static final String ROUTE_RESULT_APPROACH_GUIDE = "rr_approach_guide";
        public static final String ROUTE_RESULT_CAN_SHOW_COMMUTE_BTN_BUBBLE_AFTER_LIGHT = "route_result_commute_btn_bubble_after_light";
        public static final String ROUTE_RESULT_CAR_FORCE_TO_NEW_ENG = "rr_car_force_to_new_eng";
        public static final String ROUTE_RESULT_EDIT_TEMP_HEIGHT_BUBBLE = "rr_is_show_edit_temp_bubble";
        public static final String ROUTE_RESULT_FAVORITE_GUIDE = "rr_favorite_guide";
        public static final String ROUTE_RESULT_FUTURE_TRIP_GUIDE = "rr_future_trip_new_guide";
        public static final String ROUTE_RESULT_INTELLI_DRIVE_GUIDE = "rr_intelli_drive_guide";
        public static final String ROUTE_RESULT_IS_CLICKED_BROADCAST_CONTENT_RP_IN_NAVI = "rr_is_show_broadcast_content_rp_in_navi";
        public static final String ROUTE_RESULT_IS_DRAG_FAVORITE_ROUTE_BUTTON = "rr_is_drag_favorite_route_button";
        public static final String ROUTE_RESULT_IS_ENTERED_BROADCAST_CONTENT_PAGE = "rr_is_show_broadcast_content_setting_page";
        public static final String ROUTE_RESULT_IS_SHOW_AVOID_JAM_BUBBLE = "rr_is_show_avoid_jam_bubble";
        public static final String ROUTE_RESULT_IS_SHOW_BROADCAST_CONTENT_BUBBLE_IN_RR = "rr_is_show_broadcast_content_bubble";
        public static final String ROUTE_RESULT_IS_SHOW_CANCEL_FAVORITE_BUBBLE = "rr_is_show_cancel_favorite_bubble";
        public static final String ROUTE_RESULT_IS_SHOW_FAVORITE_BUBBLE = "rr_is_show_favorite_bubble";
        public static final String ROUTE_RESULT_IS_SHOW_FUTURE_TRIP_BUBBLE = "rr_is_show_future_trip_bubble";
        public static final String ROUTE_RESULT_IS_SHOW_LESS_CHARGE_BUBBLE = "rr_is_show_less_charge_bubble";
        public static final String ROUTE_RESULT_IS_SHOW_LIGHT_NAVI_BUBBLE = "rr_is_show_light_navi_bubble";
        public static final String ROUTE_RESULT_IS_SHOW_NEARBY_SEARCH_CHARGE_BUBBLE = "rr_is_show_nearby_search_charge_bubble";
        public static final String ROUTE_RESULT_IS_SHOW_TO_ONLINE_BUBBLE = "rr_is_show_to_online_bubble";
        public static final String ROUTE_RESULT_IS_SHOW_WEATHER_GUIDE_BUBBLE = "rr_is_show_weather_guide_bubble";
        public static final String ROUTE_RESULT_PICKUP_LIMIT_GUIDE = "rr_pickup_limit_guide";
        public static final String ROUTE_RESULT_RC_PREDICTION_BUBBLE_SHOW_TIMES = "rr_rc_prediction_bubble_show_times";
        public static final String ROUTE_RESULT_RC_PREDICTION_GUIDE = "rr_rc_prediction_guide";
        public static final String ROUTE_RESULT_REFRESH_GUIDE = "rr_guide";
        public static final String ROUTE_RESULT_SHOW_FUTURE_TRIP_BUBBLE_FOREIGN_LAND_TIME_MS = "rr_show_future_trip_bubble_foreign_land_time";
        public static final String ROUTE_RESULT_SHOW_FUTURE_TRIP_BUBBLE_LONG_DISTANCE_TIME_MS = "rr_show_future_trip_bubble_long_distance_time";
        public static final String ROUTE_RESULT_SHOW_FUTURE_TRIP_BUBBLE_START_NOT_MY_LOC_TIME_MS = "rr_show_future_trip_bubble_start_not_my_loc_time";
        public static final String ROUTE_RESULT_SHOW_FUTURE_TRIP_BUBBLE_TRAFFIC_OR_VIEWPOINT_TIME_MS = "rr_show_future_trip_bubble_traffic_or_viewpoint_time";
        public static final String ROUTE_RESULT_SHOW_NO_HIGH_WAY_BUBBLE_TIMES = "rr_show_no_high_way_bubble_times";
        public static final String ROUTE_RESULT_TOOLBOX_CHARGING_MOVE_TO_BACK = "car_route_toolbox_charging_move_to_back";
        public static final String ROUTE_RESULT_TOOLBOX_ITEM_ARRAY = "car_route_toolbox_item_array";
        public static final String ROUTE_RESULT_TRUCK_GUIDE = "rr_truck_guide";
        public static final String ROUTE_RESULT_WEATHER_AND_DOWNLOAD_GUIDE = "rr_weather_and_download_guide";
        public static final String ROUTE_USE_CAROWNER_PLATE = "car_route_use_carowner_plate";
        public static final String RP_IS_FORCE_SWITCH_CLOSE = "rp_isforce_switch_close";
        public static final String RP_YAWING_USE_DATA = "rp_yawing_use_data";
        public static final String RR_FUTURE_TRIP_RED_POINT_SHOW = "rr_future_red_point_show";
        public static final String RR_NEARBY_SEARCH_CHARGE_RED_POINT_SHOW = "rr_nearby_search_charge_red_point_show";
        public static final String SEARCH_DISTRICT_ID = "search_district_id";
        public static final String SEARCH_DISTRICT_NAME = "search_district_name";
        public static final String SHOW_3D_CARLOGO_BUBBLE_TIMES = "show_3d_carlogo_bubble_times";
        public static final String SIMPLE_GUIDE_MODE = "SIMPLE_GUIDE_MODE";
        public static final String SP_ACCOUNT_ONLINE = "sp_account_online";
        public static final String SP_ROUTEPLAN_SHOW_AVOID_TRAFFICJAM_DIALOG = "routeplan_show_avoid_trafficjam_dialog";
        public static final String SP_ROUTEPLAN_SHOW_FISRT_CALC = "routeplan_show_first_calc";
        public static final String SP_ROUTEPLAN_SHOW_ONLINE_DIALOG = "routeplan_show_online_dialog";
        public static final String SP_SHOW_NAVING_REAL_ENLARGEMENT = "sp_show_naving_real_enlargement";
        public static final String SP_SHOW_NAVING_VECTOR_EXPAND = "sp_show_naving_vector_expand";
        public static final String SP_Show_Naving_Total_Road_Condition_Bar = "SP_Show_Naving_Total_Road_Condition_Bar";
        public static final String SP_TRACK_LOCATE_GUIDE = "track_locate_guide";
        public static final String SP_USING_MODE = "SP_USING_MODE";
        public static final String SYNC_EDOG_TRAJECTORY_TO_MAP = "sync_edog_trajectory_to_map";
        public static final String TRUCK_CHALLENGE_MODE_H5_USE_DEBUG_URL = "truck_challenge_mode_h5_use_debug_url";
        public static final String TRUCK_PRO_PLATE_GUIDE = "truck_pro_plate_guide";
        public static final String TRUCK_PRO_USE_GUIDE = "truck_pro_use_guide";
        public static final String TTS_APP_ID = "tts_app_id";
        public static final String TTS_COPY_TIME = "tts_copy_time";
        public static final String USER_GUIDE_STATE = "navi_user_guide_state";
        public static final String USE_OLD_SETTING = "nav_sdk_use_old_setting";
        public static final String VDR_FUNCTION_STATUS = "vdr_function_status";
        public static final String VDR_MOCK_FOR_DEBUG = "vdr_mock";
        public static final String VEHICLE_INFO = "vehicle_info";
        public static final String VOICE_PERSONALIZE_VOICE_GUIDE = "voice_personalize_voice_guide";
        public static final String XD_INSTRUCTION_PRE_SUFFIX = "xd_instruction_";
        public static final String XMLY_DOWNLOADED_PAGE_INDEX = "xmly_download_page_index";
        public static final String XMLY_FIRST_DATA_ID = "xmly_first_data_id";
        public static final String XMLY_OPEN_STATE = "xmly_open_state";
        public static final String XMLY_SWITCH_TIPS = "xmly_switch_tips";
        public static final String XMLY_WIFI_DOWNLOAD_STATE = "xmly_wifi_download_state";
        public static final String YELLOW_BANNE_ICBC_COMMERCIALIZE_TIME = "yellow_banner_ICBC_commercialize_time";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface LightCommutePreferMode {
        public static final int AUTO = 0;
        public static final int LIGHT = 2;
        public static final int MOSS = 1;
    }

    /* loaded from: classes7.dex */
    public interface MapMode {
        public static final int CAR_3D = 1;
        public static final int CAR_3D_AUTO = 3;
        public static final int NORTH_2D = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface MapModeType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface NavPreferMode {
        public static final int ROOKIE = 1;
        public static final int STANDARD = 0;
    }

    /* loaded from: classes7.dex */
    public static class PowerSaveMode {
        public static final int AUTO_MODE = 0;
        public static final int DISABLE_MODE = 2;
        public static final int ENABLE_MODE = 1;
    }

    /* loaded from: classes7.dex */
    public @interface ScreenOrientation {
        public static final int AUTO = 0;
        public static final int LAND = 2;
        public static final int PORTRAIT = 1;
        public static final int UNSPECIFIED = -1;
    }

    /* loaded from: classes7.dex */
    public static class UsingMode {
        public static final int CAR_MODE = 2;
        public static final int MAP_MODE = 1;
        public static final int UNKNOWN_MODE = 1;
    }
}
