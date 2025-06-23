package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class x00X0xoXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f15149I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f15150II0XooXoX = 12;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f15151II0xO0 = 1;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f15152Oxx0IOOO = 10;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f15153X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f15154XO = 5;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f15155oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f15156oxoX = 3;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Map<Short, String> f15157xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final short f15158xxIXOIIO = Fit.f11224oxxXoxO.shortValue();

    static {
        HashMap hashMap = new HashMap();
        f15157xoIox = hashMap;
        hashMap.put((short) 0, "GPS");
        hashMap.put((short) 1, "GLONASS");
        hashMap.put((short) 2, "GPS_GLONASS");
        hashMap.put((short) 3, "ACCELEROMETER");
        hashMap.put((short) 4, "BAROMETER");
        hashMap.put((short) 5, "TEMPERATURE");
        hashMap.put((short) 10, "WHR");
        hashMap.put((short) 12, "SENSOR_HUB");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f15157xoIox.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f15158xxIXOIIO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f15157xoIox;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
