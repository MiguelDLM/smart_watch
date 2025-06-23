package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class I0oOoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f11292I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11293II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f11294II0xO0 = 1;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f11295IIXOooo = 21;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f11296IXxxXO = 17;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f11297OOXIXo = 10;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f11298Oo = 16;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f11299Oxx0IOOO = 6;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f11300Oxx0xo = 18;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f11301OxxIIOOXO = 20;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f11302X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f11303XO = 5;

    /* renamed from: o00, reason: collision with root package name */
    public static final Map<Integer, String> f11304o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f11305oI0IIXIo = 19;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f11306oIX0oI = 0;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f11307oO = 14;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f11308oOoXoXO = 11;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f11309ooOOo0oXI = 12;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f11310oxoX = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f11311x0XOIxOo = 13;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f11312x0xO0oo = 15;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11313xoIox = 9;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f11314xoXoI = Fit.f11195Xo0.intValue();

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11315xxIXOIIO = 8;

    static {
        HashMap hashMap = new HashMap();
        f11304o00 = hashMap;
        hashMap.put(0, "BOB_AND_WEAVE_CIRCLE");
        hashMap.put(1, "WEIGHTED_BOB_AND_WEAVE_CIRCLE");
        hashMap.put(2, "CARDIO_CORE_CRAWL");
        hashMap.put(3, "WEIGHTED_CARDIO_CORE_CRAWL");
        hashMap.put(4, "DOUBLE_UNDER");
        hashMap.put(5, "WEIGHTED_DOUBLE_UNDER");
        hashMap.put(6, "JUMP_ROPE");
        hashMap.put(7, "WEIGHTED_JUMP_ROPE");
        hashMap.put(8, "JUMP_ROPE_CROSSOVER");
        hashMap.put(9, "WEIGHTED_JUMP_ROPE_CROSSOVER");
        hashMap.put(10, "JUMP_ROPE_JOG");
        hashMap.put(11, "WEIGHTED_JUMP_ROPE_JOG");
        hashMap.put(12, "JUMPING_JACKS");
        hashMap.put(13, "WEIGHTED_JUMPING_JACKS");
        hashMap.put(14, "SKI_MOGULS");
        hashMap.put(15, "WEIGHTED_SKI_MOGULS");
        hashMap.put(16, "SPLIT_JACKS");
        hashMap.put(17, "WEIGHTED_SPLIT_JACKS");
        hashMap.put(18, "SQUAT_JACKS");
        hashMap.put(19, "WEIGHTED_SQUAT_JACKS");
        hashMap.put(20, "TRIPLE_UNDER");
        hashMap.put(21, "WEIGHTED_TRIPLE_UNDER");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f11304o00.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f11314xoXoI);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f11304o00;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
