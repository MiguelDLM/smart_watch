package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class xOOOX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Map<Short, String> f15394I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f15395II0xO0 = Fit.f11224oxxXoxO.shortValue();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f15396oIX0oI = 0;

    static {
        HashMap hashMap = new HashMap();
        f15394I0Io = hashMap;
        hashMap.put((short) 0, "CREATOR");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f15394I0Io.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f15395II0xO0);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f15394I0Io;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
