package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class O0Xx {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final long f12349I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final long f12350II0XooXoX = 128;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final long f12351II0xO0 = 2;

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final long f12352IIX0o = Fit.f11236xOoOIoI.longValue();

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final long f12353IIXOooo = 2097152;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final long f12354IXxxXO = 131072;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final long f12355O0xOxO = 33554432;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final long f12356OOXIXo = 1024;

    /* renamed from: Oo, reason: collision with root package name */
    public static final long f12357Oo = 65536;

    /* renamed from: OxI, reason: collision with root package name */
    public static final long f12358OxI = 16777216;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final long f12359Oxx0IOOO = 64;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final long f12360Oxx0xo = 262144;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final long f12361OxxIIOOXO = 1048576;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final long f12362X0IIOO = 67108864;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final long f12363X0o0xo = 16;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final long f12364XI0IXoo = 134217728;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final long f12365XIxXXX0x0 = 268435456;

    /* renamed from: XO, reason: collision with root package name */
    public static final long f12366XO = 32;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final long f12367XxX0x0xxx = 1073741824;

    /* renamed from: o00, reason: collision with root package name */
    public static final long f12368o00 = 8388608;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final long f12369oI0IIXIo = 524288;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final long f12370oIX0oI = 1;

    /* renamed from: oO, reason: collision with root package name */
    public static final long f12371oO = 16384;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final long f12372oOoXoXO = 2048;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final long f12373ooOOo0oXI = 4096;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final Map<Long, String> f12374ooXIXxIX;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final long f12375oxoX = 8;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final long f12376x0XOIxOo = 8192;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final long f12377x0xO0oo = 32768;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final long f12378xXxxox0I = -2147483648L;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final long f12379xoIox = 512;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final long f12380xoXoI = 4194304;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final long f12381xxIXOIIO = 256;

    /* renamed from: xxX, reason: collision with root package name */
    public static final long f12382xxX = 536870912;

    static {
        HashMap hashMap = new HashMap();
        f12374ooXIXxIX = hashMap;
        hashMap.put(1L, "BLUETOOTH");
        hashMap.put(2L, "BLUETOOTH_LE");
        hashMap.put(4L, "ANT");
        hashMap.put(8L, "ACTIVITY_UPLOAD");
        hashMap.put(16L, "COURSE_DOWNLOAD");
        hashMap.put(32L, "WORKOUT_DOWNLOAD");
        hashMap.put(64L, "LIVE_TRACK");
        hashMap.put(128L, "WEATHER_CONDITIONS");
        hashMap.put(256L, "WEATHER_ALERTS");
        hashMap.put(512L, "GPS_EPHEMERIS_DOWNLOAD");
        hashMap.put(1024L, "EXPLICIT_ARCHIVE");
        hashMap.put(2048L, "SETUP_INCOMPLETE");
        hashMap.put(4096L, "CONTINUE_SYNC_AFTER_SOFTWARE_UPDATE");
        hashMap.put(8192L, "CONNECT_IQ_APP_DOWNLOAD");
        hashMap.put(16384L, "GOLF_COURSE_DOWNLOAD");
        hashMap.put(32768L, "DEVICE_INITIATES_SYNC");
        hashMap.put(65536L, "CONNECT_IQ_WATCH_APP_DOWNLOAD");
        hashMap.put(131072L, "CONNECT_IQ_WIDGET_DOWNLOAD");
        hashMap.put(262144L, "CONNECT_IQ_WATCH_FACE_DOWNLOAD");
        hashMap.put(524288L, "CONNECT_IQ_DATA_FIELD_DOWNLOAD");
        hashMap.put(1048576L, "CONNECT_IQ_APP_MANAGMENT");
        hashMap.put(2097152L, "SWING_SENSOR");
        hashMap.put(4194304L, "SWING_SENSOR_REMOTE");
        hashMap.put(Long.valueOf(f12368o00), "INCIDENT_DETECTION");
        hashMap.put(Long.valueOf(f12358OxI), "AUDIO_PROMPTS");
        hashMap.put(Long.valueOf(f12355O0xOxO), "WIFI_VERIFICATION");
        hashMap.put(Long.valueOf(f12362X0IIOO), "TRUE_UP");
        hashMap.put(Long.valueOf(f12364XI0IXoo), "FIND_MY_WATCH");
        hashMap.put(268435456L, "REMOTE_MANUAL_SYNC");
        hashMap.put(Long.valueOf(f12382xxX), "LIVE_TRACK_AUTO_START");
        hashMap.put(1073741824L, "LIVE_TRACK_MESSAGING");
        hashMap.put(Long.valueOf(f12378xXxxox0I), "INSTANT_INPUT");
    }

    public static Long II0xO0(String str) {
        for (Map.Entry<Long, String> entry : f12374ooXIXxIX.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Long.valueOf(f12352IIX0o);
    }

    public static String oIX0oI(Long l) {
        Map<Long, String> map = f12374ooXIXxIX;
        if (map.containsKey(l)) {
            return map.get(l);
        }
        return "";
    }
}
