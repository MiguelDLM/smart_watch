package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class xIXX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f15347I0Io = 8;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f15348II0xO0 = 4;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final Map<Short, String> f15349X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f15350oIX0oI = 2;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f15351oxoX = Fit.f11168OX00O0xII.shortValue();

    static {
        HashMap hashMap = new HashMap();
        f15349X0o0xo = hashMap;
        hashMap.put((short) 2, "READ");
        hashMap.put((short) 4, "WRITE");
        hashMap.put((short) 8, "ERASE");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f15349X0o0xo.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f15351oxoX);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f15349X0o0xo;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
