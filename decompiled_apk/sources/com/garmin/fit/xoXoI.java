package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class xoXoI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f15586I0Io = 3;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f15587II0XooXoX = Fit.f11224oxxXoxO.shortValue();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f15588II0xO0 = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f15589Oxx0IOOO = 7;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f15590X0o0xo = 5;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f15591XO = 6;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f15592oIX0oI = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f15593oxoX = 4;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final Map<Short, String> f15594xxIXOIIO;

    static {
        HashMap hashMap = new HashMap();
        f15594xxIXOIIO = hashMap;
        hashMap.put((short) 1, "NEW");
        hashMap.put((short) 2, "GOOD");
        hashMap.put((short) 3, "OK");
        hashMap.put((short) 4, "LOW");
        hashMap.put((short) 5, "CRITICAL");
        hashMap.put((short) 6, "CHARGING");
        hashMap.put((short) 7, "UNKNOWN");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f15594xxIXOIIO.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f15587II0XooXoX);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f15594xxIXOIIO;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
