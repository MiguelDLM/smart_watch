package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class oo00 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f14941I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14942II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f14943II0xO0 = 1;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14944OOXIXo = Fit.f11195Xo0.intValue();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f14945Oxx0IOOO = 6;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f14946X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f14947XO = 5;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f14948oIX0oI = 0;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final Map<Integer, String> f14949oOoXoXO;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f14950oxoX = 3;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14951xoIox = 9;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14952xxIXOIIO = 8;

    static {
        HashMap hashMap = new HashMap();
        f14949oOoXoXO = hashMap;
        hashMap.put(0, "CABLE_CROSSOVER");
        hashMap.put(1, "DECLINE_DUMBBELL_FLYE");
        hashMap.put(2, "DUMBBELL_FLYE");
        hashMap.put(3, "INCLINE_DUMBBELL_FLYE");
        hashMap.put(4, "KETTLEBELL_FLYE");
        hashMap.put(5, "KNEELING_REAR_FLYE");
        hashMap.put(6, "SINGLE_ARM_STANDING_CABLE_REVERSE_FLYE");
        hashMap.put(7, "SWISS_BALL_DUMBBELL_FLYE");
        hashMap.put(8, "ARM_ROTATIONS");
        hashMap.put(9, "HUG_A_TREE");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f14949oOoXoXO.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f14944OOXIXo);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f14949oOoXoXO;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
