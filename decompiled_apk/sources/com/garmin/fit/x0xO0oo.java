package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class x0xO0oo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final long f15265I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final long f15266II0XooXoX = Fit.f11230x0xO.longValue();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final long f15267II0xO0 = 1;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final long f15268Oxx0IOOO = 1024;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final long f15269X0o0xo = 8;

    /* renamed from: XO, reason: collision with root package name */
    public static final long f15270XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final long f15271oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final long f15272oxoX = 4;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final Map<Long, String> f15273xxIXOIIO;

    static {
        HashMap hashMap = new HashMap();
        f15273xxIXOIIO = hashMap;
        hashMap.put(0L, "NONE");
        hashMap.put(1L, kotlinx.coroutines.debug.internal.oxoX.f29951II0xO0);
        hashMap.put(2L, "CYCLING");
        hashMap.put(4L, "SWIMMING");
        hashMap.put(8L, "WALKING");
        hashMap.put(32L, "ELLIPTICAL");
        hashMap.put(1024L, "SEDENTARY");
    }

    public static Long II0xO0(String str) {
        for (Map.Entry<Long, String> entry : f15273xxIXOIIO.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Long.valueOf(f15266II0XooXoX);
    }

    public static String oIX0oI(Long l) {
        Map<Long, String> map = f15273xxIXOIIO;
        if (map.containsKey(l)) {
            return map.get(l);
        }
        return "";
    }
}
