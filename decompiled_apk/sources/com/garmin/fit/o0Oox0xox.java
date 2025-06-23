package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class o0Oox0xox {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f14261I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14262II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f14263II0xO0 = 1;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14264OOXIXo = 10;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f14265Oxx0IOOO = 6;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f14266X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f14267XO = 5;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f14268oIX0oI = 0;

    /* renamed from: oO, reason: collision with root package name */
    public static final Map<Integer, String> f14269oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14270oOoXoXO = 11;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14271ooOOo0oXI = 12;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f14272oxoX = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14273x0XOIxOo = Fit.f11195Xo0.intValue();

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14274xoIox = 9;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14275xxIXOIIO = 8;

    static {
        HashMap hashMap = new HashMap();
        f14269oO = hashMap;
        hashMap.put(0, "BURPEE");
        hashMap.put(1, "WEIGHTED_BURPEE");
        hashMap.put(2, "BURPEE_BOX_JUMP");
        hashMap.put(3, "WEIGHTED_BURPEE_BOX_JUMP");
        hashMap.put(4, "HIGH_PULL_BURPEE");
        hashMap.put(5, "MAN_MAKERS");
        hashMap.put(6, "ONE_ARM_BURPEE");
        hashMap.put(7, "SQUAT_THRUSTS");
        hashMap.put(8, "WEIGHTED_SQUAT_THRUSTS");
        hashMap.put(9, "SQUAT_PLANK_PUSH_UP");
        hashMap.put(10, "WEIGHTED_SQUAT_PLANK_PUSH_UP");
        hashMap.put(11, "STANDING_T_ROTATION_BALANCE");
        hashMap.put(12, "WEIGHTED_STANDING_T_ROTATION_BALANCE");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f14269oO.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f14273x0XOIxOo);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f14269oO;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
