package com.szabh.smable3.component;

import OXOo.OOXIXo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HTTP;

/* loaded from: classes13.dex */
public final class IPCWifiState {
    public static final int CLOSE = 0;
    public static final int CLOSE_SUCCESSFULLY = 2;

    @OOXIXo
    public static final IPCWifiState INSTANCE = new IPCWifiState();
    public static final int IPC_ABNORMAL_STATE = 16;
    public static final int IPC_AI_PHOTO_FAILED = 34;
    public static final int IPC_EXPORT_DONE = 5;
    public static final int IPC_EXPORT_FAILED = 35;
    public static final int IPC_LOW_POWER_NOT_ALLOW = 23;
    public static final int IPC_NOT_ALLOW_RECORD = 18;
    public static final int IPC_NOT_ALLOW_TAKE_PHOTO = 17;
    public static final int IPC_NOT_ALLOW_VISION_RECOGNITION = 19;
    public static final int IPC_OTA_DONE = 4;
    public static final int IPC_OTA_FAILED = 36;
    public static final int IPC_PREVIEW_FAILED = 37;
    public static final int IPC_RECORD_FAILED = 33;
    public static final int IPC_TAKE_PHOTO_FAILED = 32;
    public static final int OPEN = 1;
    public static final int OPEN_SUCCESSFULLY = 3;
    public static final int OPEN_WIFI_P2P = 6;
    public static final int OPEN_WIFI_STA = 7;

    private IPCWifiState() {
    }

    @OOXIXo
    public final String getState(int i) {
        switch (i) {
            case 0:
                return HTTP.CONN_CLOSE;
            case 1:
                return "Open";
            case 2:
                return "Close Successfully";
            case 3:
                return "Open Successfully";
            case 4:
                return "IPC OTA Done";
            case 5:
                return "IPC export done";
            case 6:
                return "IPC wifi p2p";
            case 7:
                return "IPC wifi sta";
            default:
                return "IPC wifi state: 0x" + Integer.toHexString(i);
        }
    }
}
