package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class OIoxIx {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f12483I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final Map<Short, String> f12484II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f12485II0xO0 = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f12486Oxx0IOOO = Fit.f11168OX00O0xII.shortValue();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f12487X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f12488XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f12489oIX0oI = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f12490oxoX = 8;

    static {
        HashMap hashMap = new HashMap();
        f12484II0XooXoX = hashMap;
        hashMap.put((short) 1, "BRAZILIAN_PORTUGUESE");
        hashMap.put((short) 2, "INDONESIAN");
        hashMap.put((short) 4, "MALAYSIAN");
        hashMap.put((short) 8, "VIETNAMESE");
        hashMap.put((short) 16, "BURMESE");
        hashMap.put((short) 32, "MONGOLIAN");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f12484II0XooXoX.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f12486Oxx0IOOO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f12484II0XooXoX;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
