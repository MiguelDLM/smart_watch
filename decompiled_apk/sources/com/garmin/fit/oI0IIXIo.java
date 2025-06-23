package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class oI0IIXIo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Map<Short, String> f14395I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f14396II0xO0 = Fit.f11224oxxXoxO.shortValue();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f14397oIX0oI = 0;

    static {
        HashMap hashMap = new HashMap();
        f14395I0Io = hashMap;
        hashMap.put((short) 0, "INFINITE");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f14395I0Io.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f14396II0xO0);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f14395I0Io;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
