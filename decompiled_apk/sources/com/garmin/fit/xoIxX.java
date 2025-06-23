package com.garmin.fit;

import com.sma.smartv3.ble.ProductManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class xoIxX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final long f15572I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final long f15573II0XooXoX = 128;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final long f15574II0xO0 = 2;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final long f15575OOXIXo = 1024;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final long f15576Oxx0IOOO = 64;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final long f15577X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final long f15578XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final long f15579oIX0oI = 1;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final long f15580oOoXoXO = 4096;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final long f15581ooOOo0oXI = Fit.f11236xOoOIoI.longValue();

    /* renamed from: oxoX, reason: collision with root package name */
    public static final long f15582oxoX = 8;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final Map<Long, String> f15583x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final long f15584xoIox = 512;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final long f15585xxIXOIIO = 256;

    static {
        HashMap hashMap = new HashMap();
        f15583x0XOIxOo = hashMap;
        hashMap.put(1L, "PROCESSED");
        hashMap.put(2L, "VALID");
        hashMap.put(4L, "TIME");
        hashMap.put(8L, "DISTANCE");
        hashMap.put(16L, "POSITION");
        hashMap.put(32L, "HEART_RATE");
        hashMap.put(64L, ProductManager.oxIIOOX);
        hashMap.put(128L, "CADENCE");
        hashMap.put(256L, "TRAINING");
        hashMap.put(512L, "NAVIGATION");
        hashMap.put(1024L, "BIKEWAY");
        hashMap.put(4096L, "AVIATION");
    }

    public static Long II0xO0(String str) {
        for (Map.Entry<Long, String> entry : f15583x0XOIxOo.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Long.valueOf(f15581ooOOo0oXI);
    }

    public static String oIX0oI(Long l) {
        Map<Long, String> map = f15583x0XOIxOo;
        if (map.containsKey(l)) {
            return map.get(l);
        }
        return "";
    }
}
