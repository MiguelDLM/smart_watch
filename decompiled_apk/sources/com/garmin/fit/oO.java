package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class oO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f14456I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14457II0XooXoX = 128;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f14458II0xO0 = 2;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14459OOXIXo = 1024;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f14460Oxx0IOOO = 64;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f14461X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f14462XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f14463oIX0oI = 1;

    /* renamed from: oO, reason: collision with root package name */
    public static final Map<Integer, String> f14464oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14465oOoXoXO = 2048;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14466ooOOo0oXI = 4096;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f14467oxoX = 8;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14468x0XOIxOo = Fit.f11195Xo0.intValue();

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14469xoIox = 512;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14470xxIXOIIO = 256;

    static {
        HashMap hashMap = new HashMap();
        f14464oO = hashMap;
        hashMap.put(1, "TRACK_ANGLE_HEADING_VALID");
        hashMap.put(2, "PITCH_VALID");
        hashMap.put(4, "ROLL_VALID");
        hashMap.put(8, "LATERAL_BODY_ACCEL_VALID");
        hashMap.put(16, "NORMAL_BODY_ACCEL_VALID");
        hashMap.put(32, "TURN_RATE_VALID");
        hashMap.put(64, "HW_FAIL");
        hashMap.put(128, "MAG_INVALID");
        hashMap.put(256, "NO_GPS");
        hashMap.put(512, "GPS_INVALID");
        hashMap.put(1024, "SOLUTION_COASTING");
        hashMap.put(2048, "TRUE_TRACK_ANGLE");
        hashMap.put(4096, "MAGNETIC_HEADING");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f14464oO.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f14468x0XOIxOo);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f14464oO;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
