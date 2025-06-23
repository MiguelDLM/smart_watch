package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class XoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f14111I0Io = Fit.f11224oxxXoxO.shortValue();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f14112II0xO0 = 1;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f14113oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Map<Short, String> f14114oxoX;

    static {
        HashMap hashMap = new HashMap();
        f14114oxoX = hashMap;
        hashMap.put((short) 0, "CLEAR");
        hashMap.put((short) 1, "OK");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f14114oxoX.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f14111I0Io);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f14114oxoX;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
