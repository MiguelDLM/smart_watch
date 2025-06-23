package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class Oxxo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f13314I0Io = Fit.f11224oxxXoxO.shortValue();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f13315II0xO0 = 1;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f13316oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Map<Short, String> f13317oxoX;

    static {
        HashMap hashMap = new HashMap();
        f13317oxoX = hashMap;
        hashMap.put((short) 0, "REST");
        hashMap.put((short) 1, "ACTIVE");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f13317oxoX.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f13314I0Io);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f13317oxoX;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
