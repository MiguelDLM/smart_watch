package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xXO0oXX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15528II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15529OOXIXo = 2;

    /* renamed from: oO, reason: collision with root package name */
    public static final oIXoXx0 f15530oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15531oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15532ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15533x0XOIxOo = 5;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15534xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15535xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("timestamp_correlation", 162);
        f15530oO = oixoxx0;
        Profile.Type type = Profile.Type.DATE_TIME;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        Profile.Type type2 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("fractional_timestamp", 0, 132, 32768.0d, XIXIX.OOXIXo.f3760XO, "s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("system_timestamp", 1, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("fractional_system_timestamp", 2, 132, 32768.0d, XIXIX.OOXIXo.f3760XO, "s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("local_timestamp", 3, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.LOCAL_DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp_ms", 4, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("system_timestamp_ms", 5, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type2));
    }

    public xXO0oXX() {
        super(x0OxxIOxX.XO(162));
    }

    public void O00(Integer num) {
        X0xxXX0(5, 0, num, 65535);
    }

    public void OIx00oxx(Float f) {
        X0xxXX0(0, 0, f, 65535);
    }

    public Integer OO0() {
        return oX(4, 0, 65535);
    }

    public Float OX() {
        return XX(0, 0, 65535);
    }

    public void OooI(Float f) {
        X0xxXX0(2, 0, f, 65535);
    }

    public Float Oxx() {
        return XX(2, 0, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(5, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public o0xxxXXxX o0IXXIx() {
        return oXX0IoI(x0xO(1, 0, 65535));
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Long oXIoO() {
        return x0xO(3, 0, 65535);
    }

    public void xIXX(Long l) {
        X0xxXX0(3, 0, l, 65535);
    }

    public void xOOxIO(Integer num) {
        X0xxXX0(4, 0, num, 65535);
    }

    public void xxxI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(1, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public xXO0oXX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
