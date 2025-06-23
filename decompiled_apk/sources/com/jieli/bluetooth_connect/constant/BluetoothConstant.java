package com.jieli.bluetooth_connect.constant;

import com.jieli.bluetooth_connect.BuildConfig;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes10.dex */
public class BluetoothConstant {
    public static final int ALL_FILTER = 1;
    public static final int BLE_MTU_MAX = 509;
    public static final int BLE_MTU_MIN = 20;
    public static final int CONNECT_BLE_OR_SPP_TIMEOUT = 30000;
    public static final int CONNECT_STATE_CONNECTED = 2;
    public static final int CONNECT_STATE_CONNECTING = 1;
    public static final int CONNECT_STATE_DISCONNECT = 0;
    public static final int CONNECT_TIMEOUT = 40000;
    public static final int DEFAULT_SCAN_TIMEOUT = 8000;
    public static final int DEFAULT_SEND_CMD_TIMEOUT = 2000;
    public static final int FAST_BOND_LIMIT_TIME = 5000;
    public static final int FLAG_FILTER = 2;
    public static final int HASH_FILTER = 3;
    public static final int HISTORY_OP_ADD = 0;
    public static final int HISTORY_OP_DELETE = 1;
    public static final int HISTORY_OP_MODIFY = 2;
    public static final boolean IS_CHANGE_ACTIVITY_DEVICE = false;
    public static final int JL_VID = 1494;
    public static final String KEY_BLE_NOTIFICATION_CHARACTERISTIC_UUID = "ble_notification_characteristic_uuid";
    public static final String KEY_BLE_SERVICE_UUID = "ble_service_uuid";
    public static final String KEY_BLE_WRITE_CHARACTERISTIC_UUID = "ble_write_characteristic_uuid";
    public static final int NONE_FILTER = 0;
    public static final String OTA_FILTER_FLAG = "JLOTA";
    public static final int PAIR_OR_UNPAIR_TIMEOUT = 30000;
    public static final int PROTOCOL_TYPE_BLE = 0;
    public static final int PROTOCOL_TYPE_SPP = 1;
    public static final int RETRY_TIMES = 5;
    public static final int SCAN_TYPE_ALL = 2;
    public static final int SCAN_TYPE_BLE = 0;
    public static final int SCAN_TYPE_CLASSIC = 1;
    public static final int SCAN_TYPE_FLAG_CONTENT = 0;
    public static final int SCAN_TYPE_FLAG_EDR_MESSAGE = 4;
    public static final int SCAN_TYPE_FLAG_PAIRED = 1;
    public static final int SCAN_TYPE_FLAG_PHONE_VIRTUAL_ADDRESS = 2;
    public static final int SCAN_TYPE_FLAG_PID = 3;
    public static final int SEND_DATA_MAX_TIMEOUT = 6000;
    public static final int TWS_HEADSET_STATUS_CONNECTED = 2;
    public static final int TWS_HEADSET_STATUS_CONNECTING = 3;
    public static final int TWS_HEADSET_STATUS_DISCONNECTED = 1;
    public static final int TWS_HEADSET_STATUS_DISMISS = 0;
    public static byte[] AUTH_VID = {5, -42};
    public static final UUID UUID_SERVICE = UUID.fromString("0000ae00-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_WRITE = UUID.fromString("0000ae01-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_NOTIFICATION = UUID.fromString("0000ae02-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_CLIENT_CHARACTERISTIC_CONFIG = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_HFP = UUID.fromString("0000111e-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_A2DP = UUID.fromString("0000110b-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_SPP = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

    public static int getLibVersionCode() {
        return 10312;
    }

    public static String getLibVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    public static String printBtConnection(int connection) {
        if (connection != 0) {
            if (connection != 1) {
                if (connection != 2) {
                    return "Unknown Connection State : " + connection;
                }
                return "CONNECT_STATE_CONNECTED(2)";
            }
            return "CONNECT_STATE_CONNECTING(1)";
        }
        return "CONNECT_STATE_DISCONNECT(0)";
    }

    public static void setAuthVid(byte[] authVid) {
        if (authVid != null && authVid.length == 2 && !Arrays.equals(AUTH_VID, authVid)) {
            AUTH_VID = authVid;
        }
    }
}
