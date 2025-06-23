package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class xxoXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f15731I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f15732II0XooXoX = 128;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f15733II0xO0 = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f15734Oxx0IOOO = 64;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f15735X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f15736XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f15737oIX0oI = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f15738oxoX = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Map<Short, String> f15739xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final short f15740xxIXOIIO = Fit.f11168OX00O0xII.shortValue();

    static {
        HashMap hashMap = new HashMap();
        f15739xoIox = hashMap;
        hashMap.put((short) 1, "SAILING");
        hashMap.put((short) 2, "ICE_SKATING");
        hashMap.put((short) 4, "SKY_DIVING");
        hashMap.put((short) 8, "SNOWSHOEING");
        hashMap.put((short) 16, "SNOWMOBILING");
        hashMap.put((short) 32, "STAND_UP_PADDLEBOARDING");
        hashMap.put((short) 64, "SURFING");
        hashMap.put((short) 128, "WAKEBOARDING");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f15739xoIox.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f15740xxIXOIIO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f15739xoIox;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
