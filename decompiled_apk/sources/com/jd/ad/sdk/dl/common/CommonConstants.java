package com.jd.ad.sdk.dl.common;

/* loaded from: classes10.dex */
public class CommonConstants {
    public static final String CHARSET_UTF8 = "UTF-8";
    public static final int COUNT_DOWN_COMMON = 5;
    public static final int COUNT_DOWN_MAX = 30;
    public static final int COUNT_DOWN_MIN = 1;
    public static final int INVALID_ACTIVITY_HASH_CODE = -1;
    public static final int SPEC_SET_ID_10005 = 10005;

    /* loaded from: classes10.dex */
    public enum AdTmp {
        TEMPLATE_UNKNOWN(0),
        TEMPLATE_TEXT_ABOVE_IMAGE(16),
        TEMPLATE_TEXT_ABOVE_IMAGE_WITH_CREATIVITY(32),
        TEMPLATE_TEXT_ABOVE_IMAGE_WITH_FLOAT(64),
        TEMPLATE_IMAGE_WITH_FLOAT(128),
        TEMPLATE_TEXT_RIGHT_IMAGE(256),
        TEMPLATE_TEXT_LEFT_IMAGE(512),
        TEMPLATE_HORIZONTAL_VIDEO(1024),
        TEMPLATE_VERTICAL_VIDEO(2048),
        TEMPLATE_GROUP_IMAGE(513),
        TEMPLATE_INTERSTITIAL_SINGLE_IMAGE_1(1),
        TEMPLATE_INTERSTITIAL_SINGLE_IMAGE_2(2),
        TEMPLATE_SPLASH_SINGLE_IMAGE_4(4),
        TEMPLATE_SPLASH_SINGLE_IMAGE_8(8),
        TEMPLATE_BANNER_SINGLE_IMAGE_4096(4096),
        TEMPLATE_BANNER_SINGLE_IMAGE_8192(8192),
        TEMPLATE_BANNER_SINGLE_IMAGE_16384(16384),
        TEMPLATE_BANNER_SINGLE_IMAGE_32768(32768);

        private int templateId;

        AdTmp(int i) {
            this.templateId = i;
        }

        public int getTemplateId() {
            return this.templateId;
        }
    }

    /* loaded from: classes10.dex */
    public enum AdTriggerSourceType {
        CLICK,
        SHAKE,
        SLIDE_UP,
        SHAKE_ACCELERATION_ANGLE,
        SHAKE_ALL,
        SHAKE_ACCELERATION_TIME,
        SHAKE_ANGLE,
        SHAKE_ANGLE_TIME
    }

    /* loaded from: classes10.dex */
    public interface AdType {
        public static final int BANNER = 5;
        public static final int FEED = 2;
        public static final int FEED_VIDEO = 3;
        public static final int INTERSTITIAL = 4;
        public static final int REWARDED_VIDEO = 6;
        public static final int SPLASH = 1;
        public static final int UNKNOWN = 0;
    }

    /* loaded from: classes10.dex */
    public interface CLICK_TYPE {
        public static final int ANDROID_EXCEPTION = 3;
        public static final int CLOSE_AD = -1;
        public static final int DATA_EXCEPTION = 2;
        public static final int DEFAULT = -2;
        public static final int OPEN_JD_APP = 1;
        public static final int OPEN_SDK_H5 = 0;
    }

    /* loaded from: classes10.dex */
    public enum ClickAreaType {
        FULL_SCREEN_CLICK(1),
        STATIC_AREA_CLICK(2);

        private int templateId;

        ClickAreaType(int i) {
            this.templateId = i;
        }

        public int getTemplateId() {
            return this.templateId;
        }
    }

    /* loaded from: classes10.dex */
    public enum ClickFrom {
        UNKNOWN,
        AD,
        SKIP,
        CLOSE,
        AUTO0,
        CUSTOM_CLOSE,
        VIDEO
    }

    /* loaded from: classes10.dex */
    public interface DisplaySceneType {
        public static final int BANNER = 1;
        public static final int FEED = 64;
        public static final int FRONT_REAR_PATCH = 32;
        public static final int INTERSTITIAL = 2;
        public static final int MODEL = 8;
        public static final int REWARDED_VIDEO = 16;
        public static final int SPLASH = 4;
        public static final int UNKNOWN = 0;
    }

    /* loaded from: classes10.dex */
    public enum ExposureType {
        EXPOSURE_INSTANCE(0),
        EXPOSURE_VALID(1),
        EXPOSURE_FORCE(2),
        EXPOSURE_ATTACHE_TO_WINDOW(3);

        private final int index;

        ExposureType(int i) {
            this.index = i;
        }

        public int getIndex() {
            return this.index;
        }
    }

    /* loaded from: classes10.dex */
    public interface MEDIA_STYLE {
        public static final String DEEP_LINK = "1";
        public static final String DEFAULT = "0";
        public static final String DOWNLOAD = "2";
    }

    /* loaded from: classes10.dex */
    public interface PLATFORM_TYPE {
        public static final int AN = 1;
        public static final int UNKNOWN = 0;
    }

    /* loaded from: classes10.dex */
    public interface RENDER_MODE {
        public static final int MODE_DYNAMIC = 3;
        public static final int MODE_EXPRESS = 1;
        public static final int MODE_NATIVE = 2;
        public static final int UNKNOWN = 0;
    }

    /* loaded from: classes10.dex */
    public interface RESPONSE_TYPE {
        public static final int AD_LOADED = 0;
        public static final int AD_RENDERED = 1;
        public static final int UNKNOWN = -1;
    }
}
