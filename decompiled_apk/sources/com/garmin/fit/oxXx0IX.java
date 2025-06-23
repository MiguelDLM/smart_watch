package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class oxXx0IX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f15078I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15079II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f15080II0xO0 = 1;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f15081IIXOooo = 21;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f15082IXxxXO = 17;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15083OOXIXo = 10;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f15084Oo = 16;

    /* renamed from: OxI, reason: collision with root package name */
    public static final Map<Integer, String> f15085OxI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f15086Oxx0IOOO = 6;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f15087Oxx0xo = 18;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f15088OxxIIOOXO = 20;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f15089X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f15090XO = 5;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f15091o00 = Fit.f11195Xo0.intValue();

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f15092oI0IIXIo = 19;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f15093oIX0oI = 0;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f15094oO = 14;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15095oOoXoXO = 11;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15096ooOOo0oXI = 12;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f15097oxoX = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15098x0XOIxOo = 13;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f15099x0xO0oo = 15;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15100xoIox = 9;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f15101xoXoI = 22;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15102xxIXOIIO = 8;

    static {
        HashMap hashMap = new HashMap();
        f15085OxI = hashMap;
        hashMap.put(0, "CABLE_PULL_THROUGH");
        hashMap.put(1, "CABLE_ROTATIONAL_LIFT");
        hashMap.put(2, "CABLE_WOODCHOP");
        hashMap.put(3, "CROSS_CHOP_TO_KNEE");
        hashMap.put(4, "WEIGHTED_CROSS_CHOP_TO_KNEE");
        hashMap.put(5, "DUMBBELL_CHOP");
        hashMap.put(6, "HALF_KNEELING_ROTATION");
        hashMap.put(7, "WEIGHTED_HALF_KNEELING_ROTATION");
        hashMap.put(8, "HALF_KNEELING_ROTATIONAL_CHOP");
        hashMap.put(9, "HALF_KNEELING_ROTATIONAL_REVERSE_CHOP");
        hashMap.put(10, "HALF_KNEELING_STABILITY_CHOP");
        hashMap.put(11, "HALF_KNEELING_STABILITY_REVERSE_CHOP");
        hashMap.put(12, "KNEELING_ROTATIONAL_CHOP");
        hashMap.put(13, "KNEELING_ROTATIONAL_REVERSE_CHOP");
        hashMap.put(14, "KNEELING_STABILITY_CHOP");
        hashMap.put(15, "KNEELING_WOODCHOPPER");
        hashMap.put(16, "MEDICINE_BALL_WOOD_CHOPS");
        hashMap.put(17, "POWER_SQUAT_CHOPS");
        hashMap.put(18, "WEIGHTED_POWER_SQUAT_CHOPS");
        hashMap.put(19, "STANDING_ROTATIONAL_CHOP");
        hashMap.put(20, "STANDING_SPLIT_ROTATIONAL_CHOP");
        hashMap.put(21, "STANDING_SPLIT_ROTATIONAL_REVERSE_CHOP");
        hashMap.put(22, "STANDING_STABILITY_REVERSE_CHOP");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f15085OxI.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f15091o00);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f15085OxI;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
