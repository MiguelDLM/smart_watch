package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class xOIO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f15380I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f15381II0XooXoX = 128;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f15382II0xO0 = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f15383Oxx0IOOO = 64;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f15384X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f15385XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f15386oIX0oI = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f15387oxoX = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Map<Short, String> f15388xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final short f15389xxIXOIIO = Fit.f11168OX00O0xII.shortValue();

    static {
        HashMap hashMap = new HashMap();
        f15388xoIox = hashMap;
        hashMap.put((short) 1, "GENERIC");
        hashMap.put((short) 2, kotlinx.coroutines.debug.internal.oxoX.f29951II0xO0);
        hashMap.put((short) 4, "CYCLING");
        hashMap.put((short) 8, "TRANSITION");
        hashMap.put((short) 16, "FITNESS_EQUIPMENT");
        hashMap.put((short) 32, "SWIMMING");
        hashMap.put((short) 64, "BASKETBALL");
        hashMap.put((short) 128, "SOCCER");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f15388xoIox.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f15389xxIXOIIO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f15388xoIox;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
