package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class o00xOoIO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f14211I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f14212II0XooXoX = 128;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f14213II0xO0 = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f14214Oxx0IOOO = 64;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f14215X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f14216XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f14217oIX0oI = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f14218oxoX = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Map<Short, String> f14219xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final short f14220xxIXOIIO = Fit.f11168OX00O0xII.shortValue();

    static {
        HashMap hashMap = new HashMap();
        f14219xoIox = hashMap;
        hashMap.put((short) 1, "DUTCH");
        hashMap.put((short) 2, "FINNISH");
        hashMap.put((short) 4, "GREEK");
        hashMap.put((short) 8, "HUNGARIAN");
        hashMap.put((short) 16, "NORWEGIAN");
        hashMap.put((short) 32, "POLISH");
        hashMap.put((short) 64, "PORTUGUESE");
        hashMap.put((short) 128, "SLOVAKIAN");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f14219xoIox.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f14220xxIXOIIO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f14219xoIox;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
