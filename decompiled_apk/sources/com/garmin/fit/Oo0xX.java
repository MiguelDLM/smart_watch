package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class Oo0xX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f12815I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f12816II0XooXoX = 128;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f12817II0xO0 = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f12818Oxx0IOOO = 64;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f12819X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f12820XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f12821oIX0oI = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f12822oxoX = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Map<Short, String> f12823xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final short f12824xxIXOIIO = Fit.f11168OX00O0xII.shortValue();

    static {
        HashMap hashMap = new HashMap();
        f12823xoIox = hashMap;
        hashMap.put((short) 1, "DRIVING");
        hashMap.put((short) 2, "GOLF");
        hashMap.put((short) 4, "HANG_GLIDING");
        hashMap.put((short) 8, "HORSEBACK_RIDING");
        hashMap.put((short) 16, "HUNTING");
        hashMap.put((short) 32, "FISHING");
        hashMap.put((short) 64, "INLINE_SKATING");
        hashMap.put((short) 128, "ROCK_CLIMBING");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f12823xoIox.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f12824xxIXOIIO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f12823xoIox;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
