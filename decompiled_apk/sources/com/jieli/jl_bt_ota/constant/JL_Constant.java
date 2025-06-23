package com.jieli.jl_bt_ota.constant;

import com.jieli.jl_bt_ota.BuildConfig;

/* loaded from: classes10.dex */
public class JL_Constant {
    public static final int ADV_OP_CLOSE_NOTIFY = 0;
    public static final int ADV_OP_OPEN_NOTIFY = 1;
    public static final int ADV_REQUEST_OP_RECONNECT_DEVICE = 3;
    public static final int ADV_REQUEST_OP_SYNC_DEVICE_INFO = 4;
    public static final int ADV_REQUEST_OP_SYNC_TIME = 2;
    public static final int ADV_REQUEST_OP_UPDATE_AFTER_REBOOT = 1;
    public static final int ADV_REQUEST_OP_UPDATE_CONFIGURE = 0;
    public static final int DEFAULT_PROTOCOL_MTU = 530;
    public static final int DEVICE_CLOSE = 1;
    public static final int DEVICE_REBOOT = 0;
    public static final byte END_FLAG = -17;
    public static final int EXPAND_MODE_NONE = 0;
    public static final int EXPAND_MODE_RES_OTA = 1;
    public static final int FLAG_LOADER = 1;
    public static final int FLAG_MANDATORY_UPGRADE = 1;
    public static final int FLAG_NORMAL_UPGRADE = 0;
    public static final int FLAG_SDK = 0;
    public static final int MIN_TIMEOUT = 500;
    public static String OTA_IDENTIFY = "JLOTA";
    public static final int OTA_PROTOCOL_MTU = 530;
    public static final byte PLATFORM_ANDROID = 0;
    public static final byte PLATFORM_IOS = 1;
    public static final byte PLATFORM_WEB_APP = 2;
    public static final byte PREFIX_FLAG_FIRST = -2;
    public static final byte PREFIX_FLAG_SECOND = -36;
    public static final byte PREFIX_FLAG_THIRD = -70;
    public static final int SINGLE_BACKUP_OTA_WAY_BLE = 1;
    public static final int SINGLE_BACKUP_OTA_WAY_NONE = 0;
    public static final int SINGLE_BACKUP_OTA_WAY_SPP = 2;
    public static final int TYPE_CHECK_FILE = 0;
    public static final int TYPE_FIRMWARE_UPGRADE = 1;

    public static int getLibVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    public static String getLibVersionName() {
        return BuildConfig.VERSION_NAME;
    }
}
