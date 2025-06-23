package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class IxI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f12266I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f12267II0XooXoX = 128;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f12268II0xO0 = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f12269Oxx0IOOO = 64;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f12270X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f12271XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f12272oIX0oI = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f12273oxoX = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Map<Short, String> f12274xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final short f12275xxIXOIIO = Fit.f11168OX00O0xII.shortValue();

    static {
        HashMap hashMap = new HashMap();
        f12274xoIox = hashMap;
        hashMap.put((short) 1, "SLOVENIAN");
        hashMap.put((short) 2, "SWEDISH");
        hashMap.put((short) 4, "RUSSIAN");
        hashMap.put((short) 8, "TURKISH");
        hashMap.put((short) 16, "LATVIAN");
        hashMap.put((short) 32, "UKRAINIAN");
        hashMap.put((short) 64, "ARABIC");
        hashMap.put((short) 128, "FARSI");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f12274xoIox.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f12275xxIXOIIO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f12274xoIox;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
