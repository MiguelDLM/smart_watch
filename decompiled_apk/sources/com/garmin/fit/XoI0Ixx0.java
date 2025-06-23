package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class XoI0Ixx0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f14090I0Io = 2;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f14091II0xO0 = 1;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f14092X0o0xo = Fit.f11195Xo0.intValue();

    /* renamed from: XO, reason: collision with root package name */
    public static final Map<Integer, String> f14093XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f14094oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f14095oxoX = 3;

    static {
        HashMap hashMap = new HashMap();
        f14093XO = hashMap;
        hashMap.put(0, "WILDCARD_PAIRING_TIMEOUT");
        hashMap.put(1, "PAIRING_TIMEOUT");
        hashMap.put(2, "CONNECTION_LOST");
        hashMap.put(3, "CONNECTION_TIMEOUT");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f14093XO.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f14092X0o0xo);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f14093XO;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
