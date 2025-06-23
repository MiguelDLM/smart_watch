package com.bluetrum.fota.manager;

/* loaded from: classes8.dex */
public enum OtaError {
    REPORT_FROM_DEVICE(2000, "有点问题，错误代码"),
    REFUSED_BY_DEVICE(2001, "设备拒绝了升级"),
    TIMEOUT_RECEIVE_RESPONSE(2002, "等待设备回复超时"),
    DATA_READER_ERROR(3000, "DataReader错误");

    private final String description;
    private byte deviceErrorCode;
    private final int errorCode;

    OtaError(int i, String str) {
        this.errorCode = i;
        this.description = str;
    }

    public String getDescription() {
        return this.description;
    }

    public byte getDeviceErrorCode() {
        return this.deviceErrorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setDeviceErrorCode(byte b) {
        this.deviceErrorCode = b;
    }
}
