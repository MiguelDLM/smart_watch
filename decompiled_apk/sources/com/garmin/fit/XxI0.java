package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class XxI0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f14144I0Io = 16;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final Map<Integer, String> f14145II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f14146II0xO0 = 15;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f14147Oxx0IOOO = Fit.f11195Xo0.intValue();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f14148X0o0xo = 256;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f14149XO = 65534;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f14150oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f14151oxoX = 255;

    static {
        HashMap hashMap = new HashMap();
        f14145II0XooXoX = hashMap;
        hashMap.put(0, "LOCAL_MIN");
        hashMap.put(15, "LOCAL_MAX");
        hashMap.put(16, "STATIONARY_MIN");
        hashMap.put(255, "STATIONARY_MAX");
        hashMap.put(256, "PORTABLE_MIN");
        hashMap.put(65534, "PORTABLE_MAX");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f14145II0XooXoX.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f14147Oxx0IOOO);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f14145II0XooXoX;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
