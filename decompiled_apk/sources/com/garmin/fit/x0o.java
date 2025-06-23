package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class x0o {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f15233I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15234II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f15235II0xO0 = 1;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f15236IIXOooo = Fit.f11195Xo0.intValue();

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f15237IXxxXO = 17;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15238OOXIXo = 10;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f15239Oo = 16;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f15240Oxx0IOOO = 6;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f15241Oxx0xo = 18;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f15242OxxIIOOXO = 20;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f15243X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f15244XO = 5;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f15245oI0IIXIo = 19;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f15246oIX0oI = 0;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f15247oO = 14;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15248oOoXoXO = 11;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15249ooOOo0oXI = 12;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f15250oxoX = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15251x0XOIxOo = 13;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f15252x0xO0oo = 15;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15253xoIox = 9;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final Map<Integer, String> f15254xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15255xxIXOIIO = 8;

    static {
        HashMap hashMap = new HashMap();
        f15254xoXoI = hashMap;
        hashMap.put(0, "_3_WAY_CALF_RAISE");
        hashMap.put(1, "_3_WAY_WEIGHTED_CALF_RAISE");
        hashMap.put(2, "_3_WAY_SINGLE_LEG_CALF_RAISE");
        hashMap.put(3, "_3_WAY_WEIGHTED_SINGLE_LEG_CALF_RAISE");
        hashMap.put(4, "DONKEY_CALF_RAISE");
        hashMap.put(5, "WEIGHTED_DONKEY_CALF_RAISE");
        hashMap.put(6, "SEATED_CALF_RAISE");
        hashMap.put(7, "WEIGHTED_SEATED_CALF_RAISE");
        hashMap.put(8, "SEATED_DUMBBELL_TOE_RAISE");
        hashMap.put(9, "SINGLE_LEG_BENT_KNEE_CALF_RAISE");
        hashMap.put(10, "WEIGHTED_SINGLE_LEG_BENT_KNEE_CALF_RAISE");
        hashMap.put(11, "SINGLE_LEG_DECLINE_PUSH_UP");
        hashMap.put(12, "SINGLE_LEG_DONKEY_CALF_RAISE");
        hashMap.put(13, "WEIGHTED_SINGLE_LEG_DONKEY_CALF_RAISE");
        hashMap.put(14, "SINGLE_LEG_HIP_RAISE_WITH_KNEE_HOLD");
        hashMap.put(15, "SINGLE_LEG_STANDING_CALF_RAISE");
        hashMap.put(16, "SINGLE_LEG_STANDING_DUMBBELL_CALF_RAISE");
        hashMap.put(17, "STANDING_BARBELL_CALF_RAISE");
        hashMap.put(18, "STANDING_CALF_RAISE");
        hashMap.put(19, "WEIGHTED_STANDING_CALF_RAISE");
        hashMap.put(20, "STANDING_DUMBBELL_CALF_RAISE");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f15254xoXoI.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f15236IIXOooo);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f15254xoXoI;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
