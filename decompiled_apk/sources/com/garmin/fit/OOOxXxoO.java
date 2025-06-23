package com.garmin.fit;

import com.sma.smartv3.ble.ProductManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class OOOxXxoO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final long f12554I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final long f12555II0XooXoX = 256;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final long f12556II0xO0 = 2;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final long f12557OOXIXo = 2048;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final long f12558Oxx0IOOO = 128;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final long f12559X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final long f12560XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final long f12561oIX0oI = 1;

    /* renamed from: oO, reason: collision with root package name */
    public static final long f12562oO = Fit.f11236xOoOIoI.longValue();

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final long f12563oOoXoXO = 4096;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final long f12564ooOOo0oXI = 8192;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final long f12565oxoX = 8;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final long f12566x0XOIxOo = 16384;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final Map<Long, String> f12567x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final long f12568xoIox = 1024;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final long f12569xxIXOIIO = 512;

    static {
        HashMap hashMap = new HashMap();
        f12567x0xO0oo = hashMap;
        hashMap.put(1L, "INTERVAL");
        hashMap.put(2L, "CUSTOM");
        hashMap.put(4L, "FITNESS_EQUIPMENT");
        hashMap.put(8L, "FIRSTBEAT");
        hashMap.put(16L, "NEW_LEAF");
        hashMap.put(32L, "TCX");
        hashMap.put(128L, "SPEED");
        hashMap.put(256L, "HEART_RATE");
        hashMap.put(512L, "DISTANCE");
        hashMap.put(1024L, "CADENCE");
        hashMap.put(2048L, ProductManager.oxIIOOX);
        hashMap.put(4096L, "GRADE");
        hashMap.put(8192L, "RESISTANCE");
        hashMap.put(16384L, "PROTECTED");
    }

    public static Long II0xO0(String str) {
        for (Map.Entry<Long, String> entry : f12567x0xO0oo.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Long.valueOf(f12562oO);
    }

    public static String oIX0oI(Long l) {
        Map<Long, String> map = f12567x0xO0oo;
        if (map.containsKey(l)) {
            return map.get(l);
        }
        return "";
    }
}
