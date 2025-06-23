package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class xIOI0xO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Map<Integer, String> f15334I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f15335II0xO0 = Fit.f11195Xo0.intValue();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f15336oIX0oI = 65534;

    static {
        HashMap hashMap = new HashMap();
        f15334I0Io = hashMap;
        hashMap.put(65534, "CALCULATING");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f15334I0Io.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f15335II0xO0);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f15334I0Io;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
