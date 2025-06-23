package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class XIOOI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f13803I0Io = Fit.f11224oxxXoxO.shortValue();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f13804II0xO0 = 128;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f13805oIX0oI = 127;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Map<Short, String> f13806oxoX;

    static {
        HashMap hashMap = new HashMap();
        f13806oxoX = hashMap;
        hashMap.put(Short.valueOf(f13805oIX0oI), "MASK");
        hashMap.put((short) 128, "RIGHT");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f13806oxoX.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f13803I0Io);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f13806oxoX;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
