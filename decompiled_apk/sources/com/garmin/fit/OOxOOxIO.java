package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class OOxOOxIO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f12622I0Io = Fit.f11195Xo0.intValue();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f12623II0xO0 = 32768;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f12624oIX0oI = 16383;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Map<Integer, String> f12625oxoX;

    static {
        HashMap hashMap = new HashMap();
        f12625oxoX = hashMap;
        hashMap.put(Integer.valueOf(f12624oIX0oI), "MASK");
        hashMap.put(32768, "RIGHT");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f12625oxoX.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f12622I0Io);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f12625oxoX;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
