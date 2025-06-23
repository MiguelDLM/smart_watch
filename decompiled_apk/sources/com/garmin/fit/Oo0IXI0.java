package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class Oo0IXI0 extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12811II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f12812OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12813xoIox = 5;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12814xxIXOIIO = 3;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("software", 35);
        f12812OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("version", 3, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("part_number", 5, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
    }

    public Oo0IXI0() {
        super(x0OxxIOxX.XO(35));
    }

    public void OO0(Float f) {
        X0xxXX0(3, 0, f, 65535);
    }

    public String OX() {
        return XIXIX(5, 0, 65535);
    }

    public Integer Oxx() {
        return oX(254, 0, 65535);
    }

    public void XoIxOXIXo(String str) {
        X0xxXX0(5, 0, str, 65535);
    }

    public void o0IXXIx(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public Float oXIoO() {
        return XX(3, 0, 65535);
    }

    public Oo0IXI0(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
