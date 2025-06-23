package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class oxxXoxO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f15103I0Io = 2;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f15104II0xO0 = 1;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final Map<Integer, String> f15105Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f15106X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f15107XO = Fit.f11195Xo0.intValue();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f15108oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f15109oxoX = 3;

    static {
        HashMap hashMap = new HashMap();
        f15105Oxx0IOOO = hashMap;
        hashMap.put(0, "BAR_HOLDS");
        hashMap.put(1, "FARMERS_WALK");
        hashMap.put(2, "FARMERS_WALK_ON_TOES");
        hashMap.put(3, "HEX_DUMBBELL_HOLD");
        hashMap.put(4, "OVERHEAD_CARRY");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f15105Oxx0IOOO.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f15107XO);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f15105Oxx0IOOO;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
