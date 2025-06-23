package com.sma.smartv3.network;

import OXOo.OOXIXo;

/* loaded from: classes12.dex */
public final class UploadOtaRecord {

    @OOXIXo
    public static final String CURRENT_VERSION = "currentVersion";

    @OOXIXo
    public static final String FLAG_FAILED = "-1";

    @OOXIXo
    public static final String FLAG_SUCCESS = "0";

    @OOXIXo
    public static final UploadOtaRecord INSTANCE = new UploadOtaRecord();

    @OOXIXo
    public static final String OTA_TYPE = "otaType";

    @OOXIXo
    public static final String REMARK = "remark";

    @OOXIXo
    public static final String SUCCESS_FLAG = "successFlag";

    @OOXIXo
    public static final String TARGET_VERSION = "trargetVersion";

    @OOXIXo
    public static final String TYPE_FIRMWARE = "1";

    @OOXIXo
    public static final String TYPE_OTHER = "2";

    @OOXIXo
    public static final String URL = "/ble_device/addOtaRecord";

    private UploadOtaRecord() {
    }
}
