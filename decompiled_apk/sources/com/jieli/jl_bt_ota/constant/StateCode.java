package com.jieli.jl_bt_ota.constant;

import java.util.Locale;

/* loaded from: classes10.dex */
public class StateCode {

    @Deprecated
    public static final int CONNECTION_CONNECTED = 4;
    public static final int CONNECTION_CONNECTING = 3;
    public static final int CONNECTION_DISCONNECT = 0;
    public static final int CONNECTION_FAILED = 2;
    public static final int CONNECTION_OK = 1;
    public static final int RESULT_CAN_UPDATE = 0;
    public static final int RESULT_DEVICE_IN_DOUBLE_CONNECTION = 7;
    public static final int RESULT_DEVICE_LOW_VOLTAGE_EQUIPMENT = 1;
    public static final int RESULT_FAIL = 1;
    public static final int RESULT_FIRMWARE_INFO_ERROR = 2;
    public static final int RESULT_FIRMWARE_VERSION_NO_CHANGE = 3;
    public static final int RESULT_HEADSET_NOT_IN_CHARGING_BIN = 5;
    public static final int RESULT_OK = 0;
    public static final int RESULT_OTA_IN_PROGRESS = 6;
    public static final int RESULT_TWS_NOT_CONNECT = 4;
    public static final int STATUS_ALL_DATA_CRC_ERROR = 6;
    public static final int STATUS_BUSY = 3;
    public static final int STATUS_CRC_ERROR = 5;
    public static final int STATUS_FAIL = 1;
    public static final int STATUS_NO_RESOURCE = 4;
    public static final int STATUS_PARAMETER_ERROR = 7;
    public static final int STATUS_RESPONSE_DATA_OVER_LIMIT = 8;
    public static final int STATUS_SUCCESS = 0;
    public static final int STATUS_UNKOWN_CMD = 2;
    public static final int UPGRADE_RESULT_CMD_TIMEOUT = 8;
    public static final int UPGRADE_RESULT_COMPLETE = 0;
    public static final int UPGRADE_RESULT_DATA_CHECK_ERROR = 1;
    public static final int UPGRADE_RESULT_DOWNLOAD_BOOT_LOADER_SUCCESS = 128;
    public static final int UPGRADE_RESULT_ENCRYPTED_KEY_NOT_MATCH = 3;
    public static final int UPGRADE_RESULT_ERROR_LENGTH = 6;
    public static final int UPGRADE_RESULT_FAIL = 2;
    public static final int UPGRADE_RESULT_FLASH_READ = 7;
    public static final int UPGRADE_RESULT_SAME_FILE = 9;
    public static final int UPGRADE_RESULT_UPGRADE_FILE_ERROR = 4;
    public static final int UPGRADE_RESULT_UPGRADE_TYPE_ERROR = 5;

    public static String printConnectionState(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return String.format(Locale.ENGLISH, "UNKNOWN STATE(%d)", Integer.valueOf(i));
                        }
                        return "CONNECTION_CONNECTED(4)";
                    }
                    return "CONNECTION_CONNECTING(3)";
                }
                return "CONNECTION_FAILED(2)";
            }
            return "CONNECTION_OK(1)";
        }
        return "CONNECTION_DISCONNECT(0)";
    }
}
