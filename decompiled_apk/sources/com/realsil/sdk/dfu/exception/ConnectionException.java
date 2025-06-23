package com.realsil.sdk.dfu.exception;

import com.realsil.sdk.dfu.DfuException;

/* loaded from: classes11.dex */
public class ConnectionException extends DfuException {
    public static final int OTA_GATT_CONNECTION_FAIL = 0;
    public static final int OTA_GATT_DISCOVERY_FAIL = 1;
    public static final int OTA_GET_CHARA_FAIL = 4;
    public static final int OTA_GET_SERVICE_FAIL = 2;
    public static final int OTA_OTA_SERVICE_LOSS = 3;
    public static final int OTA_READ_CHAR_ERROR = 5;
    public static final int OTA_SPP_CONNECTION_FAIL = 6;

    public ConnectionException(String str, int i) {
        super(str, i);
        this.errType = 0;
    }

    public ConnectionException(int i) {
        super(i);
        this.errType = 0;
    }
}
