package com.jieli.jl_rcsp.constant;

import com.jieli.jl_fatfs.BuildConfig;

/* loaded from: classes.dex */
public class WatchConstant extends RcspConstant {
    public static final String DEFAULT_DIAL_BACKGROUND_NAME = "/null";
    public static final int DEVICE_PHONE_STATUS_CALLING = 1;
    public static final int DEVICE_PHONE_STATUS_NORMAL = 0;
    public static final boolean ENABLE_ERASURE_DATA_CMD = false;
    public static boolean ENABLE_WRITE_DATA_CHECK = false;
    public static final int FAT_END_OFFSET = 16384;
    public static final String FAT_FS_ROOT = "/";
    public static final int FAT_HEAD_OFFSET = 8192;
    public static final String RES_DIR_NAME = "res.ori";

    public static int getLibVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    public static String getLibVersionName() {
        return BuildConfig.VERSION_NAME;
    }
}
