package com.garmin.fit;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class xXo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f15551I0Io = 4;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f15552II0XooXoX = 128;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f15553II0xO0 = 2;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f15554Oxx0IOOO = 64;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f15555X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f15556XO = 32;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f15557oIX0oI = 1;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f15558oxoX = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Map<Short, String> f15559xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final short f15560xxIXOIIO = Fit.f11168OX00O0xII.shortValue();

    static {
        HashMap hashMap = new HashMap();
        f15559xoIox = hashMap;
        hashMap.put((short) 1, ViewHierarchyConstants.ENGLISH);
        hashMap.put((short) 2, "FRENCH");
        hashMap.put((short) 4, "ITALIAN");
        hashMap.put((short) 8, ViewHierarchyConstants.GERMAN);
        hashMap.put((short) 16, ViewHierarchyConstants.SPANISH);
        hashMap.put((short) 32, "CROATIAN");
        hashMap.put((short) 64, "CZECH");
        hashMap.put((short) 128, "DANISH");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f15559xoIox.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f15560xxIXOIIO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f15559xoIox;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
