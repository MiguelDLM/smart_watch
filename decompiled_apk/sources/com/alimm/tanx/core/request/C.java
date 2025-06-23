package com.alimm.tanx.core.request;

import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.BaseBean;
import com.alimm.tanx.core.utils.MD5Utils;

/* loaded from: classes.dex */
public class C extends BaseBean {
    private static final String AD = "/japi";
    private static volatile String BASE_CONFIG = "https://sdk-config.tanx.com";
    private static final String BASE_DEBUG_CONFIG_URL = "https://pre-sdk-config.alibaba-inc.com";
    private static final String BASE_DEBUG_CONFIG_URL_HTTP = "http://pre-sdk-config.alibaba-inc.com";
    private static final String BASE_DEBUG_QUERY_HISTORY_REWARD_URL = "https://videoproxy.tanx.com";
    private static final String BASE_DEBUG_QUERY_HISTORY_REWARD_URL_HTTP = "http://videoproxy.tanx.com";
    private static final String BASE_DEBUG_URL = "https://videoproxy.tanx.com";
    private static final String BASE_DEBUG_URL_HTTP = "http://videoproxy.tanx.com";
    private static volatile String BASE_ORANGE_URL = "https://et.tanx.com";
    private static final String BASE_RELEASE_CONFIG_URL = "https://sdk-config.tanx.com";
    private static final String BASE_RELEASE_CONFIG_URL_HTTP = "http://sdk-config.tanx.com";
    private static final String BASE_RELEASE_QUERY_HISTORY_REWARD_URL = " https://task.tanx.com";
    private static final String BASE_RELEASE_QUERY_HISTORY_REWARD_URL_HTTP = " http://task.tanx.com";
    private static final String BASE_RELEASE_URL = "https://opehs.tanx.com";
    private static final String BASE_RELEASE_URL_HTTP = "http://opehs.tanx.com";
    private static final String BASE_RELEASE_UT_URL = "https://et.tanx.com";
    private static final String BASE_RELEASE_UT_URL_HTTP = "http://et.tanx.com";
    private static volatile String BASE_REWARD = " https://task.tanx.com";
    private static volatile String BASE_URL = "https://opehs.tanx.com";
    private static volatile String BASE_UT_URL = "https://et.tanx.com";
    private static final String CONFIG = "/requestConfigV2";
    private static final String REWARD = "/task_reward";
    private static final String REWARD_DEBUG_TEMP = "/tanx_task";
    private static final String UT = "/tsbpm";

    public static String getAdUrl() {
        return BASE_URL + AD + "?id=" + MD5Utils.getMD5String(TanxCoreSdk.getConfig().getAppKey());
    }

    public static String getConfigUrl() {
        return BASE_CONFIG + CONFIG;
    }

    public static String getOrangeUrl() {
        return BASE_ORANGE_URL + "/tsc?os=android";
    }

    public static String getRewardUrl() {
        return BASE_REWARD + REWARD + "?id=" + MD5Utils.getMD5String(TanxCoreSdk.getConfig().getAppKey());
    }

    public static String getUtUrl() {
        return BASE_UT_URL + UT + "?id=" + MD5Utils.getMD5String(TanxCoreSdk.getConfig().getAppKey());
    }

    public static void setDebug() {
        BASE_URL = "https://videoproxy.tanx.com";
        BASE_UT_URL = "https://videoproxy.tanx.com";
        BASE_ORANGE_URL = "https://videoproxy.tanx.com";
        BASE_REWARD = "https://videoproxy.tanx.com/tanx_task";
        BASE_CONFIG = BASE_DEBUG_CONFIG_URL;
    }

    public static void setDebugHttp() {
        BASE_URL = "http://videoproxy.tanx.com";
        BASE_UT_URL = "http://videoproxy.tanx.com";
        BASE_ORANGE_URL = "http://videoproxy.tanx.com";
        BASE_REWARD = "http://videoproxy.tanx.com/tanx_task";
        BASE_CONFIG = BASE_DEBUG_CONFIG_URL_HTTP;
    }

    public static void setRelease() {
        BASE_URL = BASE_RELEASE_URL;
        BASE_UT_URL = BASE_RELEASE_UT_URL;
        BASE_ORANGE_URL = BASE_RELEASE_UT_URL;
        BASE_REWARD = BASE_RELEASE_QUERY_HISTORY_REWARD_URL;
        BASE_CONFIG = BASE_RELEASE_CONFIG_URL;
    }

    public static void setReleaseHttp() {
        Boolean bool;
        try {
            bool = Boolean.valueOf(TanxCoreSdk.getConfig().isDebugMode());
        } catch (Exception unused) {
            bool = null;
        }
        if (bool == null || bool.booleanValue()) {
            BASE_URL = BASE_RELEASE_URL_HTTP;
            BASE_UT_URL = BASE_RELEASE_UT_URL_HTTP;
            BASE_ORANGE_URL = BASE_RELEASE_UT_URL_HTTP;
            BASE_REWARD = BASE_RELEASE_QUERY_HISTORY_REWARD_URL_HTTP;
            BASE_CONFIG = BASE_RELEASE_CONFIG_URL_HTTP;
        }
    }
}
