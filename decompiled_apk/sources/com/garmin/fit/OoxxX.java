package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class OoxxX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f12884I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f12885II0XooXoX = 128;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f12886II0xO0 = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f12887Oxx0IOOO = 64;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f12888X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f12889XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f12890oIX0oI = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f12891oxoX = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Map<Short, String> f12892xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final short f12893xxIXOIIO = Fit.f11168OX00O0xII.shortValue();

    static {
        HashMap hashMap = new HashMap();
        f12892xoIox = hashMap;
        hashMap.put((short) 1, "MOUNTAINEERING");
        hashMap.put((short) 2, "HIKING");
        hashMap.put((short) 4, "MULTISPORT");
        hashMap.put((short) 8, "PADDLING");
        hashMap.put((short) 16, "FLYING");
        hashMap.put((short) 32, "E_BIKING");
        hashMap.put((short) 64, "MOTORCYCLING");
        hashMap.put((short) 128, "BOATING");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f12892xoIox.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f12893xxIXOIIO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f12892xoIox;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
