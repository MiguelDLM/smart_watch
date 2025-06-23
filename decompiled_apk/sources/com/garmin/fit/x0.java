package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class x0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f15144I0Io = Fit.f11195Xo0.intValue();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f15145II0xO0 = 12;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f15146oIX0oI = 10;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Map<Integer, String> f15147oxoX;

    static {
        HashMap hashMap = new HashMap();
        f15147oxoX = hashMap;
        hashMap.put(10, "ASSIOMA_UNO");
        hashMap.put(12, "ASSIOMA_DUO");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f15147oxoX.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f15144I0Io);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f15147oxoX;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
