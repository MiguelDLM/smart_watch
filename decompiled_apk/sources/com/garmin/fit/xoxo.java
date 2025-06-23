package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class xoxo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f15600I0Io = 2;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f15601II0xO0 = 1;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f15602X0o0xo = Fit.f11195Xo0.intValue();

    /* renamed from: XO, reason: collision with root package name */
    public static final Map<Integer, String> f15603XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f15604oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f15605oxoX = 3;

    static {
        HashMap hashMap = new HashMap();
        f15603XO = hashMap;
        hashMap.put(0, "RUN");
        hashMap.put(1, "WALK");
        hashMap.put(2, "JOG");
        hashMap.put(3, "SPRINT");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f15603XO.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f15602X0o0xo);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f15603XO;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
