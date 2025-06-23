package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final long f13303I0Io = 16711680;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final long f13304II0xO0 = 251658240;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final long f13305X0o0xo = Fit.f11236xOoOIoI.longValue();

    /* renamed from: XO, reason: collision with root package name */
    public static final Map<Long, String> f13306XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final long f13307oIX0oI = -268435456;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final long f13308oxoX = 65535;

    static {
        HashMap hashMap = new HashMap();
        f13306XO = hashMap;
        hashMap.put(Long.valueOf(f13307oIX0oI), "ANT_EXTENDED_DEVICE_NUMBER_UPPER_NIBBLE");
        hashMap.put(Long.valueOf(f13304II0xO0), "ANT_TRANSMISSION_TYPE_LOWER_NIBBLE");
        hashMap.put(Long.valueOf(f13303I0Io), "ANT_DEVICE_TYPE");
        hashMap.put(65535L, "ANT_DEVICE_NUMBER");
    }

    public static Long II0xO0(String str) {
        for (Map.Entry<Long, String> entry : f13306XO.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Long.valueOf(f13305X0o0xo);
    }

    public static String oIX0oI(Long l) {
        Map<Long, String> map = f13306XO;
        if (map.containsKey(l)) {
            return map.get(l);
        }
        return "";
    }
}
