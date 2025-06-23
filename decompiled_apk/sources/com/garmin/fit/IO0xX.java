package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class IO0xX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11467II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f11468OOXIXo = 2;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f11469oO = 7;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f11470oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f11471ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f11472x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final oIXoXx0 f11473x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11474xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11475xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("sdm_profile", 5);
        f11473x0xO0oo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        Profile.Type type = Profile.Type.BOOL;
        oixoxx0.xxIXOIIO(new X0xII0I("enabled", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sdm_ant_id", 1, 139, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16Z));
        oixoxx0.xxIXOIIO(new X0xII0I("sdm_cal_factor", 2, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "%", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("odometer", 3, 134, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, Profile.Type.UINT32));
        oixoxx0.xxIXOIIO(new X0xII0I("speed_source", 4, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sdm_ant_id_trans_type", 5, 10, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8Z));
        oixoxx0.xxIXOIIO(new X0xII0I("odometer_rollover", 7, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
    }

    public IO0xX() {
        super(x0OxxIOxX.XO(5));
    }

    public void IxX00(Float f) {
        X0xxXX0(2, 0, f, 65535);
    }

    public void O00(Float f) {
        X0xxXX0(3, 0, f, 65535);
    }

    public void O0xxXxI(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public Bool OIx00oxx() {
        Short XI0oooXX2 = XI0oooXX(4, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public Short OO0() {
        return XI0oooXX(5, 0, 65535);
    }

    public Integer OX() {
        return oX(254, 0, 65535);
    }

    public Float OooI() {
        return XX(2, 0, 65535);
    }

    public Bool Oxx() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void XO0o(Bool bool) {
        X0xxXX0(4, 0, Short.valueOf(bool.value), 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(1, 0, 65535);
    }

    public Short o0IXXIx() {
        return XI0oooXX(7, 0, 65535);
    }

    public Float oXIoO() {
        return XX(3, 0, 65535);
    }

    public void oxOXxoXII(Short sh) {
        X0xxXX0(5, 0, sh, 65535);
    }

    public void xIXX(Bool bool) {
        X0xxXX0(0, 0, Short.valueOf(bool.value), 65535);
    }

    public void xOOxIO(Short sh) {
        X0xxXX0(7, 0, sh, 65535);
    }

    public void xxxI(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public IO0xX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
