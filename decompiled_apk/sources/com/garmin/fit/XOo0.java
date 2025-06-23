package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class XOo0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final long f13910oIX0oI = Fit.f11230x0xO.longValue();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final Map<Long, String> f13909II0xO0 = new HashMap();

    public static Long II0xO0(String str) {
        for (Map.Entry<Long, String> entry : f13909II0xO0.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Long.valueOf(f13910oIX0oI);
    }

    public static String oIX0oI(Long l) {
        Map<Long, String> map = f13909II0xO0;
        if (map.containsKey(l)) {
            return map.get(l);
        }
        return "";
    }
}
