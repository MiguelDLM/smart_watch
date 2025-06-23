package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class IOXOxOII {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f11618I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11619II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f11620II0xO0 = 1;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f11621IIXOooo = Fit.f11195Xo0.intValue();

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f11622IXxxXO = 17;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f11623OOXIXo = 10;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f11624Oo = 16;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f11625Oxx0IOOO = 6;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f11626Oxx0xo = 18;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f11627OxxIIOOXO = 20;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f11628X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f11629XO = 5;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f11630oI0IIXIo = 19;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f11631oIX0oI = 0;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f11632oO = 14;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f11633oOoXoXO = 11;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f11634ooOOo0oXI = 12;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f11635oxoX = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f11636x0XOIxOo = 13;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f11637x0xO0oo = 15;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11638xoIox = 9;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final Map<Integer, String> f11639xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11640xxIXOIIO = 8;

    static {
        HashMap hashMap = new HashMap();
        f11639xoXoI = hashMap;
        hashMap.put(0, "BARBELL_HANG_POWER_CLEAN");
        hashMap.put(1, "BARBELL_HANG_SQUAT_CLEAN");
        hashMap.put(2, "BARBELL_POWER_CLEAN");
        hashMap.put(3, "BARBELL_POWER_SNATCH");
        hashMap.put(4, "BARBELL_SQUAT_CLEAN");
        hashMap.put(5, "CLEAN_AND_JERK");
        hashMap.put(6, "BARBELL_HANG_POWER_SNATCH");
        hashMap.put(7, "BARBELL_HANG_PULL");
        hashMap.put(8, "BARBELL_HIGH_PULL");
        hashMap.put(9, "BARBELL_SNATCH");
        hashMap.put(10, "BARBELL_SPLIT_JERK");
        hashMap.put(11, "CLEAN");
        hashMap.put(12, "DUMBBELL_CLEAN");
        hashMap.put(13, "DUMBBELL_HANG_PULL");
        hashMap.put(14, "ONE_HAND_DUMBBELL_SPLIT_SNATCH");
        hashMap.put(15, "PUSH_JERK");
        hashMap.put(16, "SINGLE_ARM_DUMBBELL_SNATCH");
        hashMap.put(17, "SINGLE_ARM_HANG_SNATCH");
        hashMap.put(18, "SINGLE_ARM_KETTLEBELL_SNATCH");
        hashMap.put(19, "SPLIT_JERK");
        hashMap.put(20, "SQUAT_CLEAN_AND_JERK");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f11639xoXoI.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f11621IIXOooo);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f11639xoXoI;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
