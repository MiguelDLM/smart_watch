package com.goodix.ble.libble.v2.impl.data;

/* loaded from: classes9.dex */
public class BlePairingVariant {
    public static final int CONSENT = 3;
    public static final int DISPLAY_PASSKEY = 4;
    public static final int DISPLAY_PIN = 5;
    public static final int OOB_CONSENT = 6;
    public static final int PASSKEY = 1;
    public static final int PASSKEY_CONFIRMATION = 2;
    public static final int PIN = 0;

    public static String toString(int i) {
        switch (i) {
            case 0:
                return "PIN";
            case 1:
                return "PASSKEY";
            case 2:
                return "PASSKEY_CONFIRMATION";
            case 3:
                return "CONSENT";
            case 4:
                return "DISPLAY_PASSKEY";
            case 5:
                return "DISPLAY_PIN";
            case 6:
                return "OOB_CONSENT";
            default:
                return "UNKNOWN";
        }
    }
}
