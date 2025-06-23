package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class Ix00oIoI extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12225II0XooXoX = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12226OOXIXo = 3;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final oIXoXx0 f12227oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12228xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12229xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("exd_screen_configuration", 200);
        f12227oOoXoXO = oixoxx0;
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("screen_index", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("field_count", 1, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("layout", 2, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EXD_LAYOUT));
        oixoxx0.xxIXOIIO(new X0xII0I("screen_enabled", 3, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BOOL));
    }

    public Ix00oIoI() {
        super(x0OxxIOxX.XO(200));
    }

    public void OIx00oxx(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public void OO0(ExdLayout exdLayout) {
        X0xxXX0(2, 0, Short.valueOf(exdLayout.value), 65535);
    }

    public ExdLayout OX() {
        Short XI0oooXX2 = XI0oooXX(2, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return ExdLayout.getByValue(XI0oooXX2);
    }

    public void OooI(Bool bool) {
        X0xxXX0(3, 0, Short.valueOf(bool.value), 65535);
    }

    public Short Oxx() {
        return XI0oooXX(1, 0, 65535);
    }

    public void XoIxOXIXo(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    public Short o0IXXIx() {
        return XI0oooXX(0, 0, 65535);
    }

    public Bool oXIoO() {
        Short XI0oooXX2 = XI0oooXX(3, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public Ix00oIoI(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
