package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xOI0 extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15374II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15375OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15376oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final oIXoXx0 f15377ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15378xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15379xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("skin_temp_overnight", IXXIXx00I.f11719XI);
        f15377ooOOo0oXI = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("local_timestamp", 0, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.LOCAL_DATE_TIME));
        Profile.Type type = Profile.Type.FLOAT32;
        oixoxx0.xxIXOIIO(new X0xII0I("average_deviation", 1, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("average_7_day_deviation", 2, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("nightly_value", 4, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
    }

    public xOI0() {
        super(x0OxxIOxX.XO(IXXIXx00I.f11719XI));
    }

    public void OIx00oxx(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public void OO0(Float f) {
        X0xxXX0(1, 0, f, 65535);
    }

    public Float OX() {
        return XX(1, 0, 65535);
    }

    public void OooI(Long l) {
        X0xxXX0(0, 0, l, 65535);
    }

    public Float Oxx() {
        return XX(2, 0, 65535);
    }

    public void XoIxOXIXo(Float f) {
        X0xxXX0(2, 0, f, 65535);
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

    public Long oXIoO() {
        return x0xO(0, 0, 65535);
    }

    public xOI0(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
