package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class O0xOxO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f12412I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12413II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f12414II0xO0 = 1;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f12415IIXOooo = 21;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f12416IXxxXO = 17;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f12417O0xOxO = 25;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12418OOXIXo = 10;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f12419Oo = 16;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f12420OxI = 24;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f12421Oxx0IOOO = 6;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f12422Oxx0xo = 18;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f12423OxxIIOOXO = 20;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f12424X0IIOO = 26;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f12425X0o0xo = 4;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f12426XI0IXoo = Fit.f11195Xo0.intValue();

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final Map<Integer, String> f12427XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f12428XO = 5;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f12429o00 = 23;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f12430oI0IIXIo = 19;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f12431oIX0oI = 0;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f12432oO = 14;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12433oOoXoXO = 11;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f12434ooOOo0oXI = 12;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f12435oxoX = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f12436x0XOIxOo = 13;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f12437x0xO0oo = 15;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12438xoIox = 9;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f12439xoXoI = 22;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12440xxIXOIIO = 8;

    static {
        HashMap hashMap = new HashMap();
        f12427XIxXXX0x0 = hashMap;
        hashMap.put(0, "ALTERNATING_DUMBBELL_CHEST_PRESS_ON_SWISS_BALL");
        hashMap.put(1, "BARBELL_BENCH_PRESS");
        hashMap.put(2, "BARBELL_BOARD_BENCH_PRESS");
        hashMap.put(3, "BARBELL_FLOOR_PRESS");
        hashMap.put(4, "CLOSE_GRIP_BARBELL_BENCH_PRESS");
        hashMap.put(5, "DECLINE_DUMBBELL_BENCH_PRESS");
        hashMap.put(6, "DUMBBELL_BENCH_PRESS");
        hashMap.put(7, "DUMBBELL_FLOOR_PRESS");
        hashMap.put(8, "INCLINE_BARBELL_BENCH_PRESS");
        hashMap.put(9, "INCLINE_DUMBBELL_BENCH_PRESS");
        hashMap.put(10, "INCLINE_SMITH_MACHINE_BENCH_PRESS");
        hashMap.put(11, "ISOMETRIC_BARBELL_BENCH_PRESS");
        hashMap.put(12, "KETTLEBELL_CHEST_PRESS");
        hashMap.put(13, "NEUTRAL_GRIP_DUMBBELL_BENCH_PRESS");
        hashMap.put(14, "NEUTRAL_GRIP_DUMBBELL_INCLINE_BENCH_PRESS");
        hashMap.put(15, "ONE_ARM_FLOOR_PRESS");
        hashMap.put(16, "WEIGHTED_ONE_ARM_FLOOR_PRESS");
        hashMap.put(17, "PARTIAL_LOCKOUT");
        hashMap.put(18, "REVERSE_GRIP_BARBELL_BENCH_PRESS");
        hashMap.put(19, "REVERSE_GRIP_INCLINE_BENCH_PRESS");
        hashMap.put(20, "SINGLE_ARM_CABLE_CHEST_PRESS");
        hashMap.put(21, "SINGLE_ARM_DUMBBELL_BENCH_PRESS");
        hashMap.put(22, "SMITH_MACHINE_BENCH_PRESS");
        hashMap.put(23, "SWISS_BALL_DUMBBELL_CHEST_PRESS");
        hashMap.put(24, "TRIPLE_STOP_BARBELL_BENCH_PRESS");
        hashMap.put(25, "WIDE_GRIP_BARBELL_BENCH_PRESS");
        hashMap.put(26, "ALTERNATING_DUMBBELL_CHEST_PRESS");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f12427XIxXXX0x0.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f12426XI0IXoo);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f12427XIxXXX0x0;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
