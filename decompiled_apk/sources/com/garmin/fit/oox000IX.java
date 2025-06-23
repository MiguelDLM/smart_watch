package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class oox000IX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f14973I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14974II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f14975II0xO0 = 1;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14976OOXIXo = 10;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f14977Oxx0IOOO = 6;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f14978X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f14979XO = 5;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f14980oIX0oI = 0;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14981oOoXoXO = 11;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14982ooOOo0oXI = Fit.f11195Xo0.intValue();

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f14983oxoX = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final Map<Integer, String> f14984x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14985xoIox = 9;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14986xxIXOIIO = 8;

    static {
        HashMap hashMap = new HashMap();
        f14984x0XOIxOo = hashMap;
        hashMap.put(0, "LEG_CURL");
        hashMap.put(1, "WEIGHTED_LEG_CURL");
        hashMap.put(2, "GOOD_MORNING");
        hashMap.put(3, "SEATED_BARBELL_GOOD_MORNING");
        hashMap.put(4, "SINGLE_LEG_BARBELL_GOOD_MORNING");
        hashMap.put(5, "SINGLE_LEG_SLIDING_LEG_CURL");
        hashMap.put(6, "SLIDING_LEG_CURL");
        hashMap.put(7, "SPLIT_BARBELL_GOOD_MORNING");
        hashMap.put(8, "SPLIT_STANCE_EXTENSION");
        hashMap.put(9, "STAGGERED_STANCE_GOOD_MORNING");
        hashMap.put(10, "SWISS_BALL_HIP_RAISE_AND_LEG_CURL");
        hashMap.put(11, "ZERCHER_GOOD_MORNING");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f14984x0XOIxOo.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f14982ooOOo0oXI);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f14984x0XOIxOo;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
