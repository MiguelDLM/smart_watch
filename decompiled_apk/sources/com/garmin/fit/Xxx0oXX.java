package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class Xxx0oXX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f14183I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14184II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f14185II0xO0 = 1;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f14186IXxxXO = Fit.f11195Xo0.intValue();

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14187OOXIXo = 10;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f14188Oo = 16;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f14189Oxx0IOOO = 6;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final Map<Integer, String> f14190Oxx0xo;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f14191X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f14192XO = 5;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f14193oIX0oI = 0;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f14194oO = 14;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14195oOoXoXO = 11;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14196ooOOo0oXI = 12;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f14197oxoX = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14198x0XOIxOo = 13;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f14199x0xO0oo = 15;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14200xoIox = 9;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14201xxIXOIIO = 8;

    static {
        HashMap hashMap = new HashMap();
        f14190Oxx0xo = hashMap;
        hashMap.put(0, "BARBELL_JUMP_SHRUG");
        hashMap.put(1, "BARBELL_SHRUG");
        hashMap.put(2, "BARBELL_UPRIGHT_ROW");
        hashMap.put(3, "BEHIND_THE_BACK_SMITH_MACHINE_SHRUG");
        hashMap.put(4, "DUMBBELL_JUMP_SHRUG");
        hashMap.put(5, "DUMBBELL_SHRUG");
        hashMap.put(6, "DUMBBELL_UPRIGHT_ROW");
        hashMap.put(7, "INCLINE_DUMBBELL_SHRUG");
        hashMap.put(8, "OVERHEAD_BARBELL_SHRUG");
        hashMap.put(9, "OVERHEAD_DUMBBELL_SHRUG");
        hashMap.put(10, "SCAPTION_AND_SHRUG");
        hashMap.put(11, "SCAPULAR_RETRACTION");
        hashMap.put(12, "SERRATUS_CHAIR_SHRUG");
        hashMap.put(13, "WEIGHTED_SERRATUS_CHAIR_SHRUG");
        hashMap.put(14, "SERRATUS_SHRUG");
        hashMap.put(15, "WEIGHTED_SERRATUS_SHRUG");
        hashMap.put(16, "WIDE_GRIP_JUMP_SHRUG");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f14190Oxx0xo.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f14186IXxxXO);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f14190Oxx0xo;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
