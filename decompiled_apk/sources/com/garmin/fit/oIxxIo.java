package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class oIxxIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f14446I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f14447II0XooXoX = 128;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f14448II0xO0 = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f14449Oxx0IOOO = 64;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f14450X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f14451XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f14452oIX0oI = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f14453oxoX = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Map<Short, String> f14454xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final short f14455xxIXOIIO = Fit.f11168OX00O0xII.shortValue();

    static {
        HashMap hashMap = new HashMap();
        f14454xoIox = hashMap;
        hashMap.put((short) 1, "TENNIS");
        hashMap.put((short) 2, "AMERICAN_FOOTBALL");
        hashMap.put((short) 4, "TRAINING");
        hashMap.put((short) 8, "WALKING");
        hashMap.put((short) 16, "CROSS_COUNTRY_SKIING");
        hashMap.put((short) 32, "ALPINE_SKIING");
        hashMap.put((short) 64, "SNOWBOARDING");
        hashMap.put((short) 128, "ROWING");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f14454xoIox.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f14455xxIXOIIO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f14454xoIox;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
