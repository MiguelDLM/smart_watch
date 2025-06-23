package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes8.dex */
public class TTAdConstant {
    public static final int ADULT = 0;
    public static final int AD_EVENT_AUTH_DOUYIN = 1;
    public static final int AD_ID_IS_NULL_CODE = 401;
    public static final String AD_ID_IS_NULL_MSG = "ad_id is null";
    public static final long AD_MAX_EVENT_TIME = 600000;
    public static final int AD_TYPE_COMMON_VIDEO = 0;
    public static final int AD_TYPE_LIVE = 3;
    public static final int AD_TYPE_PLAYABLE = 2;
    public static final int AD_TYPE_PLAYABLE_VIDEO = 1;
    public static final int AD_TYPE_UNKNOWN = -1;
    public static final float ASPECT_CORNER_RADIUS_DEFAULT = 0.0f;
    public static final float ASPECT_CORNER_RADIUS_MAX_DEFAULT = 50.0f;
    public static final float ASPECT_MARGIN_DEFAULT = 0.07f;
    public static final float ASPECT_MARGIN_MAX_DEFAULT = 0.175f;
    public static final int CLICK_SEND_TYPE_DEFAULT = 0;
    public static final int CLICK_SEND_TYPE_SHOW = 1;
    public static final int DEEPLINK_FALLBACK_TYPE_ERROR_CODE = 403;
    public static final String DEEPLINK_FALLBACK_TYPE_ERROR_MSG = "deeplink fallback type error";
    public static final int DEEPLINK_FALL_BACK_CODE = 418;
    public static final String DEEPLINK_FALL_BACK_MSG = "deeplink fall back url is empty";
    public static final int DEEPLINK_UNAVAILABLE_CODE = 402;
    public static final String DEEPLINK_UNAVAILABLE_MSG = "deeplink url is empty";
    public static final int DEFAULT_ENDCARD_CLOSE_TIME = 0;
    public static final int DEFAULT_LIVE_FANS = -1;
    public static final int DEFAULT_LIVE_SHOW_TIME = 60;
    public static final int DEFAULT_LIVE_SHOW_TIME_MAX = 300;
    public static final int DEFAULT_LIVE_SHOW_TIME_MINIMUM = 1;
    public static final int DEFAULT_LIVE_WATCH = -1;
    public static final int DEFAULT_PLAYABLE_CLOSE_TIME = -1;
    public static final int DEFAULT_REWARD_VIDEO_WATCHING = 100;
    public static final int DOWNLOAD_APP_INFO_CODE = 406;
    public static final String DOWNLOAD_APP_INFO_MSG = "download type appInfo is empty";
    public static final int DOWNLOAD_URL_CODE = 407;
    public static final String DOWNLOAD_URL_MSG = "download type download url is empty";
    public static final int FALLBACK_TYPE_DOWNLOAD = 2;
    public static final int FALLBACK_TYPE_LANDING_PAGE = 1;
    public static final float FULL_INTERACTION_TYPE_DEFAULT = 100.0f;
    public static final int HORIZONTAL = 2;
    public static final int IMAGE_CODE = 411;
    public static final int IMAGE_LIST_CODE = 409;
    public static final String IMAGE_LIST_CODE_MSG = "image type image list is empty";
    public static final int IMAGE_LIST_SIZE_CODE = 410;
    public static final String IMAGE_LIST_SIZE_MSG = "image type image list size is 0";
    public static final int IMAGE_MODE_GROUP_IMG = 4;
    public static final int IMAGE_MODE_LARGE_IMG = 3;
    public static final int IMAGE_MODE_LIVE = 166;
    public static final int IMAGE_MODE_SMALL_IMG = 2;
    public static final int IMAGE_MODE_SPLASH = 131;
    public static final int IMAGE_MODE_UNKNOWN = -1;
    public static final int IMAGE_MODE_VERTICAL_IMG = 16;
    public static final int IMAGE_MODE_VIDEO = 5;
    public static final int IMAGE_MODE_VIDEO_VERTICAL = 15;
    public static final String IMAGE_MSG = "image type image is empty";
    public static final int IMAGE_URL_CODE = 412;
    public static final String IMAGE_URL_MSG = "image type image url is empty";
    public static final int INIT_FAILED_CREATE_INITIALIZER_FAILED = 4201;
    public static final int INIT_FAILED_CREATE_INVOKE_FAILED = 4202;
    public static final int INIT_FAILED_LOAD_PLUGIN_FAILED = 4200;
    public static final int INIT_LOAD_VMP_SO_FAIL_CODE = 4001;
    public static final int INIT_LOCAL_FAIL_CODE = 4000;
    public static final int INTERACTION_TYPE_BROWSER = 2;
    public static final int INTERACTION_TYPE_CODE = 408;
    public static final int INTERACTION_TYPE_DIAL = 5;
    public static final int INTERACTION_TYPE_DOWNLOAD = 4;
    public static final int INTERACTION_TYPE_LANDING_PAGE = 3;
    public static final String INTERACTION_TYPE_MSG = "download type download url is empty";
    public static final int INTERACTION_TYPE_UNKNOWN = -1;
    public static final int KEY_CLICK_AREA = 67108864;
    public static final String KEY_INIT_FOR_LIVE = "live_init";
    public static final int LANDING_PAGE_TYPE_CODE = 405;
    public static final String LANDING_PAGE_TYPE_MSG = "open the landing page but the target url is empty";
    public static final int LIVE_AD_CODE = 416;
    public static final String LIVE_AD_MSG = "live type live ad is empty";
    public static final int LIVE_FEED_URL_CODE = 417;
    public static final String LIVE_FEED_URL_MSG = "live type live feed url is empty";
    public static final int LIVE_PLUGIN_STOP_WORK = 64;
    public static final int LIVE_PLUGIN_UNINSTALL = 80;
    public static final int LIVE_PLUGIN_UPDATE = 32;
    public static final int LIVE_PLUGIN_WIFI_UPDATE = 16;
    public static final Long LIVE_REWARD_TIME = 5000L;
    public static final String MATE_IS_NULL_MSG = "mate is null";
    public static final int MATE_VALID = 200;
    public static final int MINOR = 2;
    public static final int NETWORK_STATE_2G = 2;
    public static final int NETWORK_STATE_3G = 3;
    public static final int NETWORK_STATE_4G = 5;
    public static final int NETWORK_STATE_5G = 6;
    public static final int NETWORK_STATE_MOBILE = 1;
    public static final int NETWORK_STATE_WIFI = 4;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int PLAYABLE_CLOSE_TIME_DEFAULT = 0;
    public static final int PLAYABLE_DEFAULT_DURATION_TIME = 0;
    public static final int PLAYABLE_DEFAULT_ENDCARD_CLOSE_TIME = 0;
    public static final int PLAYABLE_REWARD_TYPE = 0;
    public static final int PLAYABLE_REWARD_TYPE_NO = 1;
    public static final int PLUGIN_UPDATE = 2;
    public static final int PLUGIN_WIFI_UPDATE = 1;
    public static final int REQ_TYPE_LOAD = 3;
    public static final int REQ_TYPE_PRELOAD = 1;
    public static final int REQ_TYPE_SDK_PRELOAD = 2;
    public static final int REQ_TYPE_UNKNOWN = -1;
    public static final int REWARD_BROWSE_TYPE_LANDING = 1;
    public static final int REWARD_BROWSE_TYPE_MIX = 3;
    public static final int REWARD_BROWSE_TYPE_NO = 0;
    public static final int REWARD_END_CARD_TYPE_CLOUD_GAME = 2;
    public static final int REWARD_END_CARD_TYPE_DIRECT_LANDING = 3;
    public static final int REWARD_END_CARD_TYPE_NORMAL = 0;
    public static final int REWARD_END_CARD_TYPE_PIP = 4;
    public static final int REWARD_END_CARD_TYPE_PLAYABLE = 1;
    public static final int SDK_BIDDING_TYPE_CLIENT_BIDDING = 2;
    public static final int SDK_NOT_SUPPORT_LIVE_MATE_CODE = 404;
    public static final String SDK_NOT_SUPPORT_LIVE_MATE_MSG = "sdk does not support live mate";
    public static final int SHOW_POLL_TIME_MAX = 3000;
    public static final int SHOW_POLL_TIME_NOT_FOUND = Integer.MIN_VALUE;
    public static final int SHOW_POLL_TIME_OTHER_DEFAULT = 1000;
    public static final int SHOW_POLL_TIME_SPLASH_DEFAULT = 500;
    public static final int STYLE_SIZE_RADIO_16_9 = 1777;
    public static final int STYLE_SIZE_RADIO_1_1 = 1000;
    public static final int STYLE_SIZE_RADIO_2_3 = 666;
    public static final int STYLE_SIZE_RADIO_3_2 = 1500;
    public static final int STYLE_SIZE_RADIO_9_16 = 562;
    public static final float STYLE_SIZE_RADIO_FULL = 100.0f;
    public static final int TEENAGER = 1;
    public static final int TITLE_BAR_THEME_DARK = 1;
    public static final int TITLE_BAR_THEME_LIGHT = 0;
    public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
    public static final int VALUE_CLICK_AREA_LAUNCH_DOUYIN = 512;
    public static final int VALUE_CLICK_AREA_OTHER = 869;
    public static final int VALUE_CLICK_AREA_SAAS_AUTH = 357;
    public static final int VALUE_CLICK_AREA_SAAS_NORMAL = 1126;
    public static final int VERTICAL = 1;
    public static final int VIDEO_CLOSE_COMPLETE = 4;
    public static final int VIDEO_CLOSE_FEED_CLICK_CLOSE = 1;
    public static final int VIDEO_CLOSE_FULL_REWARD_CLICK_SKIP = 2;
    public static final int VIDEO_CLOSE_FULL_REWARD_STUCK = 3;
    public static final int VIDEO_CLOSE_PLAYER_ERROR = 5;
    public static final int VIDEO_CLOSE_TIME_OUT = 6;
    public static final int VIDEO_COVER_URL_CODE = 415;
    public static final String VIDEO_COVER_URL_MSG = "video type cover url is empty";
    public static final int VIDEO_INFO_CODE = 413;
    public static final String VIDEO_INFO_MSG = "video type video info is empty";
    public static final int VIDEO_URL_CODE = 414;
    public static final String VIDEO_URL_MSG = "video type video url is empty";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface AD_EVENT {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface AGE_GROUP {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface INIT_KEY {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface NATIVE_AD_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface NETWORK_STATE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface ORIENTATION_STATE {
    }

    /* loaded from: classes8.dex */
    public enum RitScenes {
        CUSTOMIZE_SCENES("customize_scenes"),
        HOME_OPEN_BONUS("home_open_bonus"),
        HOME_SVIP_BONUS("home_svip_bonus"),
        HOME_GET_PROPS("home_get_props"),
        HOME_TRY_PROPS("home_try_props"),
        HOME_GET_BONUS("home_get_bonus"),
        HOME_GIFT_BONUS("home_gift_bonus"),
        GAME_START_BONUS("game_start_bonus"),
        GAME_REDUCE_WAITING("geme_reduce_waiting"),
        GAME_MORE_KLLKRTUNITIES(TTAdConstant.b("game_more_kllkrtunities")),
        GAME_FINISH_REWARDS("game_finish_rewards"),
        GAME_GIFT_BONUS("game_gift_bonus");


        /* renamed from: a, reason: collision with root package name */
        final String f10650a;

        RitScenes(String str) {
            this.f10650a = str;
        }

        public String getScenesName() {
            return this.f10650a;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes8.dex */
    public @interface TITLE_BAR_THEME {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        if (!str.contains("kllk")) {
            return "";
        }
        return str.replace("kllk", "oppo");
    }
}
