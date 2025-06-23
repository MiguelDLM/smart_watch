package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class IxX00 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f12296I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f12297II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f12298II0xO0 = 1;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final short f12299IXxxXO = Fit.f11224oxxXoxO.shortValue();

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final short f12300OOXIXo = 10;

    /* renamed from: Oo, reason: collision with root package name */
    public static final short f12301Oo = 144;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f12302Oxx0IOOO = 134;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final Map<Short, String> f12303Oxx0xo;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f12304X0o0xo = 132;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f12305XO = 133;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f12306oIX0oI = 0;

    /* renamed from: oO, reason: collision with root package name */
    public static final short f12307oO = 142;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final short f12308oOoXoXO = 139;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final short f12309ooOOo0oXI = 140;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f12310oxoX = 131;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final short f12311x0XOIxOo = 13;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final short f12312x0xO0oo = 143;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final short f12313xoIox = 137;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final short f12314xxIXOIIO = 136;

    static {
        HashMap hashMap = new HashMap();
        f12303Oxx0xo = hashMap;
        hashMap.put((short) 0, "ENUM");
        hashMap.put((short) 1, "SINT8");
        hashMap.put((short) 2, "UINT8");
        hashMap.put(Short.valueOf(f12310oxoX), "SINT16");
        hashMap.put(Short.valueOf(f12304X0o0xo), "UINT16");
        hashMap.put(Short.valueOf(f12305XO), "SINT32");
        hashMap.put(Short.valueOf(f12302Oxx0IOOO), "UINT32");
        hashMap.put((short) 7, "STRING");
        hashMap.put(Short.valueOf(f12314xxIXOIIO), "FLOAT32");
        hashMap.put(Short.valueOf(f12313xoIox), "FLOAT64");
        hashMap.put((short) 10, "UINT8Z");
        hashMap.put(Short.valueOf(f12308oOoXoXO), "UINT16Z");
        hashMap.put(Short.valueOf(f12309ooOOo0oXI), "UINT32Z");
        hashMap.put((short) 13, "BYTE");
        hashMap.put(Short.valueOf(f12307oO), "SINT64");
        hashMap.put(Short.valueOf(f12312x0xO0oo), "UINT64");
        hashMap.put(Short.valueOf(f12301Oo), "UINT64Z");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f12303Oxx0xo.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f12299IXxxXO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f12303Oxx0xo;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
