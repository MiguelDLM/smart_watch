package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class xxXXXxIxo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f15726I0Io = 4095;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f15727II0xO0 = 28672;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final Map<Integer, String> f15728X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f15729oIX0oI = 32768;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f15730oxoX = Fit.f11195Xo0.intValue();

    static {
        HashMap hashMap = new HashMap();
        f15728X0o0xo = hashMap;
        hashMap.put(32768, "SELECTED");
        hashMap.put(Integer.valueOf(f15727II0xO0), "RESERVED");
        hashMap.put(Integer.valueOf(f15726I0Io), "MASK");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f15728X0o0xo.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f15730oxoX);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f15728X0o0xo;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
