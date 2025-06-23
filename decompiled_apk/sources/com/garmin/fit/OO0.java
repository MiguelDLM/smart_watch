package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class OO0 extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12516II0XooXoX = 0;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final oIXoXx0 f12517xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12518xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("file_creator", 49);
        f12517xoIox = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("software_version", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("hardware_version", 1, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
    }

    public OO0() {
        super(x0OxxIOxX.XO(49));
    }

    public Integer OX() {
        return oX(0, 0, 65535);
    }

    public Short Oxx() {
        return XI0oooXX(1, 0, 65535);
    }

    public void o0IXXIx(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public void oXIoO(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    public OO0(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
