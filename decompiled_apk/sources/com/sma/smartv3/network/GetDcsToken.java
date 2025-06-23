package com.sma.smartv3.network;

import OXOo.OOXIXo;

/* loaded from: classes12.dex */
public final class GetDcsToken {

    @OOXIXo
    public static final String APP_VERSION = "appVersion";

    @OOXIXo
    public static final String BLE_NAME = "bleName";

    @OOXIXo
    public static final String FIRMWARE_VERSION = "bleVersion";

    @OOXIXo
    public static final String FLAG = "flag";

    @OOXIXo
    public static final String MAC_ADDRESS = "macAddress";

    @OOXIXo
    public static final String PROJECT_ID = "projectId";

    @OOXIXo
    public static final GetDcsToken INSTANCE = new GetDcsToken();

    @OOXIXo
    private static final String URL = "/baiduApi/getDcsTokenV2";

    private GetDcsToken() {
    }

    @OOXIXo
    public final String getURL() {
        return URL;
    }
}
