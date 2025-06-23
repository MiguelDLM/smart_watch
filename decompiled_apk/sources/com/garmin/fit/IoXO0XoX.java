package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class IoXO0XoX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12131II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f12132OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12133xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12134xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("power_zone", 9);
        f12132OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("high_value", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("name", 2, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
    }

    public IoXO0XoX() {
        super(x0OxxIOxX.XO(9));
    }

    public Integer OX() {
        return oX(254, 0, 65535);
    }

    public Integer Oxx() {
        return oX(1, 0, 65535);
    }

    public void XoIxOXIXo(String str) {
        X0xxXX0(2, 0, str, 65535);
    }

    public void o0IXXIx(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void oXIoO(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    @Override // com.garmin.fit.oIXoXx0
    public String x0OIX00oO() {
        return XIXIX(2, 0, 65535);
    }

    public IoXO0XoX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
