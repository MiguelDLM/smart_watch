package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class x0Io0 extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15159II0XooXoX = 0;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final oIXoXx0 f15160xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15161xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("stress_level", 227);
        f15160xoIox = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("stress_level_value", 0, 131, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("stress_level_time", 1, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
    }

    public x0Io0() {
        super(x0OxxIOxX.XO(227));
    }

    public Short OX() {
        return XI0oooXX(0, 0, 65535);
    }

    public o0xxxXXxX Oxx() {
        return oXX0IoI(x0xO(1, 0, 65535));
    }

    public void o0IXXIx(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public void oXIoO(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(1, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public x0Io0(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
