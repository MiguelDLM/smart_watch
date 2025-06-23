package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class oOxxXI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f14660I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f14661II0XooXoX = 128;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f14662II0xO0 = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f14663Oxx0IOOO = 64;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f14664X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f14665XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f14666oIX0oI = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f14667oxoX = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Map<Short, String> f14668xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final short f14669xxIXOIIO = Fit.f11168OX00O0xII.shortValue();

    static {
        HashMap hashMap = new HashMap();
        f14668xoIox = hashMap;
        hashMap.put((short) 1, "WATER_SKIING");
        hashMap.put((short) 2, "KAYAKING");
        hashMap.put((short) 4, "RAFTING");
        hashMap.put((short) 8, "WINDSURFING");
        hashMap.put((short) 16, "KITESURFING");
        hashMap.put((short) 32, "TACTICAL");
        hashMap.put((short) 64, "JUMPMASTER");
        hashMap.put((short) 128, "BOXING");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f14668xoIox.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f14669xxIXOIIO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f14668xoIox;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
