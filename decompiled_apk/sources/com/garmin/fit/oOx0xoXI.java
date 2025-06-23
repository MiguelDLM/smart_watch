package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class oOx0xoXI extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14652II0XooXoX = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f14653OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14654xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14655xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("video", 184);
        f14653OOXIXo = oixoxx0;
        Profile.Type type = Profile.Type.STRING;
        oixoxx0.xxIXOIIO(new X0xII0I("url", 0, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("hosting_provider", 1, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("duration", 2, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, Profile.Type.UINT32));
    }

    public oOx0xoXI() {
        super(x0OxxIOxX.XO(184));
    }

    public void OO0(String str) {
        X0xxXX0(0, 0, str, 65535);
    }

    public String OX() {
        return XIXIX(1, 0, 65535);
    }

    public Long Oxx() {
        return x0xO(2, 0, 65535);
    }

    public void XoIxOXIXo(String str) {
        X0xxXX0(1, 0, str, 65535);
    }

    public void o0IXXIx(Long l) {
        X0xxXX0(2, 0, l, 65535);
    }

    public String oXIoO() {
        return XIXIX(0, 0, 65535);
    }

    public oOx0xoXI(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
