package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xI0OXooO extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15310II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15311OOXIXo = 3;

    /* renamed from: oO, reason: collision with root package name */
    public static final oIXoXx0 f15312oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15313oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15314ooOOo0oXI = 5;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15315x0XOIxOo = 6;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15316xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15317xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("segment_point", 150);
        f15312oO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        Profile.Type type = Profile.Type.SINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("position_lat", 1, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("position_long", 2, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type));
        Profile.Type type2 = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15470o00, 3, 134, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("altitude", 4, 132, 5.0d, 500.0d, "m", false, Profile.Type.UINT16));
        oixoxx0.f14429oxoX.get(4).f13537xoIox.add(new oXX0IoI(6, false, 16, 5.0d, 500.0d));
        oixoxx0.xxIXOIIO(new X0xII0I("leader_time", 5, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_altitude", 6, 134, 5.0d, 500.0d, "m", false, type2));
    }

    public xI0OXooO() {
        super(x0OxxIOxX.XO(150));
    }

    public void IxX00(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public void O00(Float f) {
        X0xxXX0(3, 0, f, 65535);
    }

    public void O0xxXxI(int i, Float f) {
        X0xxXX0(5, i, f, 65535);
    }

    public Integer OIx00oxx() {
        return oX(1, 0, 65535);
    }

    public Integer OO0() {
        return oX(254, 0, 65535);
    }

    public Float OX() {
        return XX(3, 0, 65535);
    }

    public int OooI() {
        return oOoIIO0(5, 65535);
    }

    public Float Oxx() {
        return XX(4, 0, 65535);
    }

    public void XO0o(Integer num) {
        X0xxXX0(2, 0, num, 65535);
    }

    public Float[] XoIxOXIXo() {
        return xo0x(5, 65535);
    }

    public Float o0IXXIx(int i) {
        return XX(5, i, 65535);
    }

    public Float oXIoO() {
        return XX(6, 0, 65535);
    }

    public void oxOXxoXII(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public Integer xIXX() {
        return oX(2, 0, 65535);
    }

    public void xOOxIO(Float f) {
        X0xxXX0(6, 0, f, 65535);
    }

    public void xxxI(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public xI0OXooO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
