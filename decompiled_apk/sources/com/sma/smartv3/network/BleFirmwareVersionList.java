package com.sma.smartv3.network;

import OXOo.OOXIXo;

/* loaded from: classes12.dex */
public final class BleFirmwareVersionList {

    @OOXIXo
    public static final String FIRMWARE_ID = "firmwareId";

    @OOXIXo
    public static final BleFirmwareVersionList INSTANCE = new BleFirmwareVersionList();

    @OOXIXo
    public static final String URL = "/ble_firmware_version/list";

    private BleFirmwareVersionList() {
    }
}
