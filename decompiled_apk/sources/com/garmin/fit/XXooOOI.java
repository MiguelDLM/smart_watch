package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class XXooOOI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f14023I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14024II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f14025II0xO0 = 1;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f14026IIXOooo = 21;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f14027IXxxXO = 17;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final Map<Integer, String> f14028O0xOxO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14029OOXIXo = 10;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f14030Oo = 16;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f14031OxI = Fit.f11195Xo0.intValue();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f14032Oxx0IOOO = 6;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f14033Oxx0xo = 18;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f14034OxxIIOOXO = 20;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f14035X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f14036XO = 5;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f14037o00 = 23;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f14038oI0IIXIo = 19;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f14039oIX0oI = 0;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f14040oO = 14;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14041oOoXoXO = 11;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14042ooOOo0oXI = 12;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f14043oxoX = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14044x0XOIxOo = 13;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f14045x0xO0oo = 15;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14046xoIox = 9;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f14047xoXoI = 22;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14048xxIXOIIO = 8;

    static {
        HashMap hashMap = new HashMap();
        f14028O0xOxO = hashMap;
        hashMap.put(0, "ALTERNATING_DUMBBELL_SHOULDER_PRESS");
        hashMap.put(1, "ARNOLD_PRESS");
        hashMap.put(2, "BARBELL_FRONT_SQUAT_TO_PUSH_PRESS");
        hashMap.put(3, "BARBELL_PUSH_PRESS");
        hashMap.put(4, "BARBELL_SHOULDER_PRESS");
        hashMap.put(5, "DEAD_CURL_PRESS");
        hashMap.put(6, "DUMBBELL_ALTERNATING_SHOULDER_PRESS_AND_TWIST");
        hashMap.put(7, "DUMBBELL_HAMMER_CURL_TO_LUNGE_TO_PRESS");
        hashMap.put(8, "DUMBBELL_PUSH_PRESS");
        hashMap.put(9, "FLOOR_INVERTED_SHOULDER_PRESS");
        hashMap.put(10, "WEIGHTED_FLOOR_INVERTED_SHOULDER_PRESS");
        hashMap.put(11, "INVERTED_SHOULDER_PRESS");
        hashMap.put(12, "WEIGHTED_INVERTED_SHOULDER_PRESS");
        hashMap.put(13, "ONE_ARM_PUSH_PRESS");
        hashMap.put(14, "OVERHEAD_BARBELL_PRESS");
        hashMap.put(15, "OVERHEAD_DUMBBELL_PRESS");
        hashMap.put(16, "SEATED_BARBELL_SHOULDER_PRESS");
        hashMap.put(17, "SEATED_DUMBBELL_SHOULDER_PRESS");
        hashMap.put(18, "SINGLE_ARM_DUMBBELL_SHOULDER_PRESS");
        hashMap.put(19, "SINGLE_ARM_STEP_UP_AND_PRESS");
        hashMap.put(20, "SMITH_MACHINE_OVERHEAD_PRESS");
        hashMap.put(21, "SPLIT_STANCE_HAMMER_CURL_TO_PRESS");
        hashMap.put(22, "SWISS_BALL_DUMBBELL_SHOULDER_PRESS");
        hashMap.put(23, "WEIGHT_PLATE_FRONT_RAISE");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f14028O0xOxO.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f14031OxI);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f14028O0xOxO;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
