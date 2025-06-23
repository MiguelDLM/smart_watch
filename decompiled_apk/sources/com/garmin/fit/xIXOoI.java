package com.garmin.fit;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class xIXOoI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f15337I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f15338II0XooXoX = 128;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f15339II0xO0 = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f15340Oxx0IOOO = 64;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f15341X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f15342XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f15343oIX0oI = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f15344oxoX = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Map<Short, String> f15345xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final short f15346xxIXOIIO = Fit.f11168OX00O0xII.shortValue();

    static {
        HashMap hashMap = new HashMap();
        f15345xoIox = hashMap;
        hashMap.put((short) 1, "BULGARIAN");
        hashMap.put((short) 2, "ROMANIAN");
        hashMap.put((short) 4, "CHINESE");
        hashMap.put((short) 8, ViewHierarchyConstants.JAPANESE);
        hashMap.put((short) 16, "KOREAN");
        hashMap.put((short) 32, "TAIWANESE");
        hashMap.put((short) 64, "THAI");
        hashMap.put((short) 128, "HEBREW");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f15345xoIox.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f15346xxIXOIIO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f15345xoIox;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
