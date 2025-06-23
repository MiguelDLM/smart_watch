package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class xxX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f15708I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f15709II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f15710II0xO0 = 1;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f15711Oxx0IOOO = 6;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f15712X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f15713XO = 5;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f15714oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f15715oxoX = 3;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Map<Short, String> f15716xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final short f15717xxIXOIIO = Fit.f11224oxxXoxO.shortValue();

    static {
        HashMap hashMap = new HashMap();
        f15716xoIox = hashMap;
        hashMap.put((short) 0, "CONNECTED_GPS");
        hashMap.put((short) 1, "HEART_RATE");
        hashMap.put((short) 2, "BIKE_POWER");
        hashMap.put((short) 3, "BIKE_SPEED_CADENCE");
        hashMap.put((short) 4, "BIKE_SPEED");
        hashMap.put((short) 5, "BIKE_CADENCE");
        hashMap.put((short) 6, "FOOTPOD");
        hashMap.put((short) 7, "BIKE_TRAINER");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f15716xoIox.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f15717xxIXOIIO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f15716xoIox;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
