package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class O0OOoIox {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Map<Long, String> f12346I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final long f12347II0xO0 = Fit.f11230x0xO.longValue();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final long f12348oIX0oI = 1000;

    static {
        HashMap hashMap = new HashMap();
        f12346I0Io = hashMap;
        hashMap.put(1000L, "WATTS_OFFSET");
    }

    public static Long II0xO0(String str) {
        for (Map.Entry<Long, String> entry : f12346I0Io.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Long.valueOf(f12347II0xO0);
    }

    public static String oIX0oI(Long l) {
        Map<Long, String> map = f12346I0Io;
        if (map.containsKey(l)) {
            return map.get(l);
        }
        return "";
    }
}
