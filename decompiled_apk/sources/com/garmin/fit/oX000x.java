package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class oX000x extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14678II0XooXoX = 253;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final oIXoXx0 f14679xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14680xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("hrv_value", IXXIXx00I.f11780xXoOI00O);
        f14679xoIox = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("value", 0, 132, 128.0d, XIXIX.OOXIXo.f3760XO, "ms", false, Profile.Type.UINT16));
    }

    public oX000x() {
        super(x0OxxIOxX.XO(IXXIXx00I.f11780xXoOI00O));
    }

    public void OX(Float f) {
        X0xxXX0(0, 0, f, 65535);
    }

    public Float Oxx() {
        return XX(0, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public oX000x(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
