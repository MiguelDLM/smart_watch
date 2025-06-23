package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class oIX0oI extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14416II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14417OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14418oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14419ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final oIXoXx0 f14420x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14421xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14422xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("aad_accel_features", 289);
        f14420x0XOIxOo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("time", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("energy_total", 1, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT32));
        oixoxx0.xxIXOIIO(new X0xII0I("zero_cross_cnt", 2, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("instance", 3, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
        oixoxx0.xxIXOIIO(new X0xII0I("time_above_threshold", 4, 132, 25.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
    }

    public oIX0oI() {
        super(x0OxxIOxX.XO(289));
    }

    public void OIx00oxx(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public void OO0(Long l) {
        X0xxXX0(1, 0, l, 65535);
    }

    public Short OX() {
        return XI0oooXX(3, 0, 65535);
    }

    public void OooI(Short sh) {
        X0xxXX0(3, 0, sh, 65535);
    }

    public Long Oxx() {
        return x0xO(1, 0, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(2, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float o0IXXIx() {
        return XX(4, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Integer oXIoO() {
        return oX(0, 0, 65535);
    }

    public void xIXX(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public void xxxI(Integer num) {
        X0xxXX0(2, 0, num, 65535);
    }

    public oIX0oI(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
