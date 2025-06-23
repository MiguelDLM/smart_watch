package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class xI0Ooxx0x {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final long f15318I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final long f15319II0XooXoX = 128;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final long f15320II0xO0 = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final long f15321Oxx0IOOO = 64;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final long f15322X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final long f15323XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final long f15324oIX0oI = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final long f15325oxoX = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Map<Long, String> f15326xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final long f15327xxIXOIIO = Fit.f11236xOoOIoI.longValue();

    static {
        HashMap hashMap = new HashMap();
        f15326xoIox = hashMap;
        hashMap.put(1L, "FULL_SCREEN");
        hashMap.put(2L, "HALF_VERTICAL");
        hashMap.put(4L, "HALF_HORIZONTAL");
        hashMap.put(8L, "HALF_VERTICAL_RIGHT_SPLIT");
        hashMap.put(16L, "HALF_HORIZONTAL_BOTTOM_SPLIT");
        hashMap.put(32L, "FULL_QUARTER_SPLIT");
        hashMap.put(64L, "HALF_VERTICAL_LEFT_SPLIT");
        hashMap.put(128L, "HALF_HORIZONTAL_TOP_SPLIT");
    }

    public static Long II0xO0(String str) {
        for (Map.Entry<Long, String> entry : f15326xoIox.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Long.valueOf(f15327xxIXOIIO);
    }

    public static String oIX0oI(Long l) {
        Map<Long, String> map = f15326xoIox;
        if (map.containsKey(l)) {
            return map.get(l);
        }
        return "";
    }
}
