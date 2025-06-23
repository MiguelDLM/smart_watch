package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class ox0I {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f14987I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14988II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f14989II0xO0 = 1;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f14990IIXOooo = 21;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f14991IXxxXO = 17;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14992OOXIXo = 10;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f14993Oo = 16;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f14994Oxx0IOOO = 6;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f14995Oxx0xo = 18;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f14996OxxIIOOXO = 20;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f14997X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f14998XO = 5;

    /* renamed from: o00, reason: collision with root package name */
    public static final Map<Integer, String> f14999o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f15000oI0IIXIo = 19;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f15001oIX0oI = 0;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f15002oO = 14;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15003oOoXoXO = 11;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15004ooOOo0oXI = 12;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f15005oxoX = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15006x0XOIxOo = 13;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f15007x0xO0oo = 15;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15008xoIox = 9;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f15009xoXoI = Fit.f11195Xo0.intValue();

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15010xxIXOIIO = 8;

    static {
        HashMap hashMap = new HashMap();
        f14999o00 = hashMap;
        hashMap.put(0, "HANGING_KNEE_RAISE");
        hashMap.put(1, "HANGING_LEG_RAISE");
        hashMap.put(2, "WEIGHTED_HANGING_LEG_RAISE");
        hashMap.put(3, "HANGING_SINGLE_LEG_RAISE");
        hashMap.put(4, "WEIGHTED_HANGING_SINGLE_LEG_RAISE");
        hashMap.put(5, "KETTLEBELL_LEG_RAISES");
        hashMap.put(6, "LEG_LOWERING_DRILL");
        hashMap.put(7, "WEIGHTED_LEG_LOWERING_DRILL");
        hashMap.put(8, "LYING_STRAIGHT_LEG_RAISE");
        hashMap.put(9, "WEIGHTED_LYING_STRAIGHT_LEG_RAISE");
        hashMap.put(10, "MEDICINE_BALL_LEG_DROPS");
        hashMap.put(11, "QUADRUPED_LEG_RAISE");
        hashMap.put(12, "WEIGHTED_QUADRUPED_LEG_RAISE");
        hashMap.put(13, "REVERSE_LEG_RAISE");
        hashMap.put(14, "WEIGHTED_REVERSE_LEG_RAISE");
        hashMap.put(15, "REVERSE_LEG_RAISE_ON_SWISS_BALL");
        hashMap.put(16, "WEIGHTED_REVERSE_LEG_RAISE_ON_SWISS_BALL");
        hashMap.put(17, "SINGLE_LEG_LOWERING_DRILL");
        hashMap.put(18, "WEIGHTED_SINGLE_LEG_LOWERING_DRILL");
        hashMap.put(19, "WEIGHTED_HANGING_KNEE_RAISE");
        hashMap.put(20, "LATERAL_STEPOVER");
        hashMap.put(21, "WEIGHTED_LATERAL_STEPOVER");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f14999o00.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f15009xoXoI);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f14999o00;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
