package com.sma.smartv3.network;

import OXOo.OOXIXo;

/* loaded from: classes12.dex */
public final class BleFirmwareList {

    @OOXIXo
    public static final String FILTER = "filter";

    @OOXIXo
    public static final BleFirmwareList INSTANCE = new BleFirmwareList();

    @OOXIXo
    public static final String LIMIT = "limit";

    @OOXIXo
    public static final String PAGE = "page";

    @OOXIXo
    public static final String URL = "/ble_firmware/list_no_verify";

    private BleFirmwareList() {
    }
}
