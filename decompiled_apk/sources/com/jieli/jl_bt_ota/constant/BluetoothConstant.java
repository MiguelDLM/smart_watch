package com.jieli.jl_bt_ota.constant;

import java.util.UUID;

/* loaded from: classes10.dex */
public class BluetoothConstant {
    public static final int BLE_MTU_MAX = 509;
    public static final int BLE_MTU_MIN = 20;
    public static final int DEFAULT_SCAN_TIMEOUT = 8000;
    public static final int DEFAULT_SEND_CMD_TIMEOUT = 3000;
    public static final String JL_AUTH = "jl_ota_auth";
    public static final int PAIR_OR_UNPAIR_TIMEOUT = 30000;
    public static final int PROTOCOL_TYPE_BLE = 0;
    public static final int PROTOCOL_TYPE_SPP = 1;
    public static final int RECEIVE_OTA_CMD_TIMEOUT = 20000;
    public static final int SCAN_TYPE_ALL = 2;
    public static final int SCAN_TYPE_BLE = 0;
    public static final int SCAN_TYPE_CLASSIC = 1;
    public static UUID UUID_SERVICE = UUID.fromString("0000ae00-0000-1000-8000-00805F9B34FB");
    public static UUID UUID_WRITE = UUID.fromString("0000ae01-0000-1000-8000-00805F9B34FB");
    public static UUID UUID_NOTIFICATION = UUID.fromString("0000ae02-0000-1000-8000-00805F9B34FB");
    public static final UUID UUID_HFP = UUID.fromString("0000111e-0000-1000-8000-00805F9B34FB");
    public static final UUID UUID_A2DP = UUID.fromString("0000110b-0000-1000-8000-00805F9B34FB");
    public static final UUID UUID_SPP = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    public static void setUuidNotification(UUID uuid) {
        UUID_NOTIFICATION = uuid;
    }

    public static void setUuidService(UUID uuid) {
        UUID_SERVICE = uuid;
    }

    public static void setUuidWrite(UUID uuid) {
        UUID_WRITE = uuid;
    }
}
