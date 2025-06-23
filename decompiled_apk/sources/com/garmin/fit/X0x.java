package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class X0x extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f13523II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f13524OOXIXo = 3;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final oIXoXx0 f13525oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f13526xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f13527xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("met_zone", 10);
        f13525oOoXoXO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("high_bpm", 1, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("calories", 2, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "kcal / min", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("fat_calories", 3, 2, 10.0d, XIXIX.OOXIXo.f3760XO, "kcal / min", false, type));
    }

    public X0x() {
        super(x0OxxIOxX.XO(10));
    }

    public void OIx00oxx(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void OO0(Float f) {
        X0xxXX0(3, 0, f, 65535);
    }

    public Float OX() {
        return XX(3, 0, 65535);
    }

    public void OooI(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    public Float Oxx() {
        return XX(2, 0, 65535);
    }

    public void XoIxOXIXo(Float f) {
        X0xxXX0(2, 0, f, 65535);
    }

    public Integer o0IXXIx() {
        return oX(254, 0, 65535);
    }

    public Short oXIoO() {
        return XI0oooXX(1, 0, 65535);
    }

    public X0x(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
