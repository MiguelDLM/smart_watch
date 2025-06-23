package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class O00XxXI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f12322I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12323II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f12324II0xO0 = 1;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f12325IXxxXO = 17;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12326OOXIXo = 10;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f12327Oo = 16;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f12328Oxx0IOOO = 6;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f12329Oxx0xo = 18;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final Map<Integer, String> f12330OxxIIOOXO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f12331X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f12332XO = 5;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f12333oI0IIXIo = Fit.f11195Xo0.intValue();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f12334oIX0oI = 0;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f12335oO = 14;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12336oOoXoXO = 11;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f12337ooOOo0oXI = 12;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f12338oxoX = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f12339x0XOIxOo = 13;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f12340x0xO0oo = 15;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12341xoIox = 9;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12342xxIXOIIO = 8;

    static {
        HashMap hashMap = new HashMap();
        f12330OxxIIOOXO = hashMap;
        hashMap.put(0, "BARBELL_DEADLIFT");
        hashMap.put(1, "BARBELL_STRAIGHT_LEG_DEADLIFT");
        hashMap.put(2, "DUMBBELL_DEADLIFT");
        hashMap.put(3, "DUMBBELL_SINGLE_LEG_DEADLIFT_TO_ROW");
        hashMap.put(4, "DUMBBELL_STRAIGHT_LEG_DEADLIFT");
        hashMap.put(5, "KETTLEBELL_FLOOR_TO_SHELF");
        hashMap.put(6, "ONE_ARM_ONE_LEG_DEADLIFT");
        hashMap.put(7, "RACK_PULL");
        hashMap.put(8, "ROTATIONAL_DUMBBELL_STRAIGHT_LEG_DEADLIFT");
        hashMap.put(9, "SINGLE_ARM_DEADLIFT");
        hashMap.put(10, "SINGLE_LEG_BARBELL_DEADLIFT");
        hashMap.put(11, "SINGLE_LEG_BARBELL_STRAIGHT_LEG_DEADLIFT");
        hashMap.put(12, "SINGLE_LEG_DEADLIFT_WITH_BARBELL");
        hashMap.put(13, "SINGLE_LEG_RDL_CIRCUIT");
        hashMap.put(14, "SINGLE_LEG_ROMANIAN_DEADLIFT_WITH_DUMBBELL");
        hashMap.put(15, "SUMO_DEADLIFT");
        hashMap.put(16, "SUMO_DEADLIFT_HIGH_PULL");
        hashMap.put(17, "TRAP_BAR_DEADLIFT");
        hashMap.put(18, "WIDE_GRIP_BARBELL_DEADLIFT");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f12330OxxIIOOXO.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f12333oI0IIXIo);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f12330OxxIIOOXO;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
