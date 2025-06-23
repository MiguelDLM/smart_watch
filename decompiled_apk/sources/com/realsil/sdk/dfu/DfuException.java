package com.realsil.sdk.dfu;

/* loaded from: classes11.dex */
public class DfuException extends Exception {
    public static final int ERROR_AES_SECRET_KEY_INVALID = 4113;
    public static final int ERROR_BATTERY_LEVEL_LOW = 269;
    public static final int ERROR_BLUEDROID_MASK = 1024;
    public static final int ERROR_BUFFER_CHECK_REACH_MAX_RETRY_TIMES = 275;
    public static final int ERROR_CANNOT_FIND_DEVICE = 265;
    public static final int ERROR_CONNECTION_GATT_CONN_TERMINATE_PEER_USER = 2067;
    public static final int ERROR_CONNECTION_GATT_CONN_TIMEOUT = 2056;
    public static final int ERROR_CONNECTION_GATT_ERROR = 2181;
    public static final int ERROR_CONNECTION_MASK = 2048;
    public static final int ERROR_CONNECTION_TIMEOUT = 260;
    public static final int ERROR_CONNECT_DEVICE_FAILED = 256;
    public static final int ERROR_CONNECT_ERROR = 264;
    public static final int ERROR_DEVICE_ADDRESS_INVALID = 4112;
    public static final int ERROR_DFU_ABORTED = 4128;
    public static final int ERROR_DFU_ALREADY_BE_LATEST_VERSION = 287;
    public static final int ERROR_DFU_CONFIG_INVALID = 4114;
    public static final int ERROR_DFU_COPY_IMAGE_FAILED = 288;
    public static final int ERROR_DFU_ENABLE_BUFFER_CHECK_NO_RESPONSE = 284;
    public static final int ERROR_DFU_HAND_SHAKE_FAILED = 286;
    public static final int ERROR_DFU_PUB_KEYS_CONFLICT = 285;
    public static final int ERROR_DFU_ROLE_SWAP_FAILED = 283;
    public static final int ERROR_DFU_SPP_OTA_NOT_SUPPORTED = 281;
    public static final int ERROR_DFU_SPP_RWS_NOT_READY = 282;
    public static final int ERROR_ENTER_OTA_MODE_FAILED = 280;
    public static final int ERROR_FILE_IO_EXCEPTION = 257;
    public static final int ERROR_GATT_DISCOVER_SERVICE_FAILED = 258;
    public static final int ERROR_GATT_INVALID_PDU = 1028;
    public static final int ERROR_GATT_OUT_OF_RANGE = 2303;
    public static final int ERROR_LOCK_WAIT_INTERRUPTED = 259;
    public static final int ERROR_MASK = 256;
    public static final int ERROR_NA = 0;
    public static final int ERROR_NOTIFICATION_NO_RESPONSE = 767;
    public static final int ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS = 263;
    public static final int ERROR_NO_SERVICE_FOUND_OR_LOSS = 262;
    public static final int ERROR_OPCODE_RESPONSE_NOT_SUPPORTED = 766;
    public static final int ERROR_READ_APP_INFO_ERROR = 271;
    public static final int ERROR_READ_DEVICE_INFO_ERROR = 270;
    public static final int ERROR_READ_IMAGE_VERSION_FAILED = 273;
    public static final int ERROR_READ_PATCH_INFO_ERROR = 272;
    public static final int ERROR_READ_REMOTE_MAC_ADDR = 277;
    public static final int ERROR_REMOTE_CRC_ERROR = 517;
    public static final int ERROR_REMOTE_FLASH_ERASE_ERROR = 520;
    public static final int ERROR_REMOTE_MASK = 512;
    public static final int ERROR_REQUEST_MTU_NO_CALLBACK = 276;
    public static final int ERROR_SEND_COMMAND_FAIL = 279;
    public static final int ERROR_SEND_COMMAND_REACH_MAX_RETRY_TIMES = 268;
    public static final int ERROR_SEND_COMMAND_WITH_NO_CALLBACK = 261;
    public static final int ERROR_USER_NOT_ACTIVE_IMAGE_ERROR = 274;
    public static final int ERROR_WRITE_CHARAC_ERROR = 267;
    public static final int ERROR_WRITE_CHARAC_NOTIFY_ERROR = 266;
    public static final int ERROR_WRITE_NOT_PERMIT = 1027;
    private static final long serialVersionUID = -6901728550661937942L;
    private int errCode;
    public int errType;

    /* loaded from: classes11.dex */
    public static class Type {
        public static final int CONNECTION = 0;
        public static final int OTA = 65536;
    }

    public DfuException(String str, int i, int i2) {
        super(str);
        this.errType = i;
        this.errCode = i2;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public int getErrType() {
        return this.errType;
    }

    public int getErrorNumber() {
        return this.errCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return String.format("[0x%02X : 0x%04X] %s", Integer.valueOf(this.errType), Integer.valueOf(this.errCode), super.getMessage());
    }

    public DfuException(String str, int i) {
        this(str, 65536, i);
    }

    public DfuException(int i) {
        this(null, 65536, i);
    }
}
