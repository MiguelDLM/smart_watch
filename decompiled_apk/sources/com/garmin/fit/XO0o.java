package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class XO0o {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f13904I0Io = 2;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f13905II0xO0 = 1;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final Map<Integer, String> f13906X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f13907oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f13908oxoX = Fit.f11195Xo0.intValue();

    static {
        HashMap hashMap = new HashMap();
        f13906X0o0xo = hashMap;
        hashMap.put(0, oOoIIO0.oIX0oI.f32055oI0IIXIo);
        hashMap.put(1, "KILOGRAM");
        hashMap.put(2, "POUND");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f13906X0o0xo.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f13908oxoX);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f13906X0o0xo;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
