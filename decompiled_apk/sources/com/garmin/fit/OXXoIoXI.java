package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class OXXoIoXI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f12789I0Io = 2;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f12790II0xO0 = 1;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final Map<Integer, String> f12791X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f12792oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f12793oxoX = Fit.f11195Xo0.intValue();

    static {
        HashMap hashMap = new HashMap();
        f12791X0o0xo = hashMap;
        hashMap.put(0, "SINGLE_ARM_KETTLEBELL_SWING");
        hashMap.put(1, "SINGLE_ARM_DUMBBELL_SWING");
        hashMap.put(2, "STEP_OUT_SWING");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f12791X0o0xo.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f12793oxoX);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f12791X0o0xo;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
