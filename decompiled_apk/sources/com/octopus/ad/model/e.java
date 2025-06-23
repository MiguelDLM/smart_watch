package com.octopus.ad.model;

/* loaded from: classes11.dex */
public final class e {

    /* loaded from: classes11.dex */
    public enum a {
        ADP_UNKNOWN(0),
        ADP_IVIDEO(1),
        ADP_LOADING(2),
        ADP_TABLE(3),
        ADP_BANNER(4),
        ADP_CUSTOMER(5),
        ADP_NATIVE(6);

        private final int h;

        a(int i2) {
            this.h = i2;
        }

        public static a a(int i2) {
            switch (i2) {
                case 0:
                    return ADP_UNKNOWN;
                case 1:
                    return ADP_IVIDEO;
                case 2:
                    return ADP_LOADING;
                case 3:
                    return ADP_TABLE;
                case 4:
                    return ADP_BANNER;
                case 5:
                    return ADP_CUSTOMER;
                case 6:
                    return ADP_NATIVE;
                default:
                    return null;
            }
        }
    }

    /* loaded from: classes11.dex */
    public enum b {
        DEVICE_UNKNOWN(0),
        DEVICE_PHONE(1),
        DEVICE_FLAT(2),
        DEVICE_WEAR(3),
        DEVICE_PC(4),
        DEVICE_OTHER(5);

        private final int g;

        b(int i) {
            this.g = i;
        }
    }

    /* loaded from: classes11.dex */
    public enum c {
        ISP_UNKNOWN(0),
        ISP_CN_MOBILE(1),
        ISP_CN_UNICOM(2),
        ISP_CN_TEL(3),
        ISP_OTHER(4);

        private final int f;

        c(int i) {
            this.f = i;
        }

        public final int a() {
            return this.f;
        }
    }

    /* loaded from: classes11.dex */
    public enum d {
        NET_UNKNOWN(0),
        NET_3G(1),
        NET_4G(2),
        NET_5G(3),
        NET_WIFI(4),
        NET_OTHER(5),
        NET_2G(6);

        private final int h;

        d(int i2) {
            this.h = i2;
        }

        public final int a() {
            return this.h;
        }
    }

    /* renamed from: com.octopus.ad.model.e$e, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public enum EnumC0897e {
        PLATFORM_UNKNOWN(0),
        PLATFORM_IOS(1),
        PLATFORM_ANDROID(2),
        PLATFORM_OTHER(3);

        private final int e;

        EnumC0897e(int i) {
            this.e = i;
        }
    }

    /* loaded from: classes11.dex */
    public enum f {
        RENDER_UNKNOWN(0),
        RENDER_VIDEO(1),
        RENDER_PIC(2),
        RENDER_H5(3),
        RENDER_JSON(4),
        RENDER_VAST_VIDEO(5);

        private final int g;

        f(int i) {
            this.g = i;
        }

        public static f a(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return null;
                                }
                                return RENDER_VAST_VIDEO;
                            }
                            return RENDER_JSON;
                        }
                        return RENDER_H5;
                    }
                    return RENDER_PIC;
                }
                return RENDER_VIDEO;
            }
            return RENDER_UNKNOWN;
        }
    }

    /* loaded from: classes11.dex */
    public enum g {
        REQ_UNKNOWN(0),
        REQ_AD(1),
        REQ_WIFI_PRELOAD(2);

        private final int d;

        g(int i) {
            this.d = i;
        }
    }

    /* loaded from: classes11.dex */
    public enum h {
        SCREEN_DIRECTION_UNKOWN(0),
        PORTRAIT(1),
        LANDSCAPE(2);

        private final int d;

        h(int i) {
            this.d = i;
        }

        public static h a(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return LANDSCAPE;
                }
                return PORTRAIT;
            }
            return SCREEN_DIRECTION_UNKOWN;
        }
    }

    /* loaded from: classes11.dex */
    public enum i {
        SRC_UNKNOWN(0),
        SRC_APP(1),
        SRC_WAP(2),
        SRC_PC(3),
        SRC_TEST(4);

        private final int f;

        i(int i) {
            this.f = i;
        }
    }
}
