package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class XoOxI0ox extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14102II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14103OOXIXo = 2;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f14104oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14105oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14106ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14107x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final oIXoXx0 f14108x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14109xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14110xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("hrv_status_summary", IXXIXx00I.f11791xxOXOOoIX);
        f14108x0xO0oo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("weekly_average", 0, 132, 128.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("last_night_average", 1, 132, 128.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("last_night_5_min_high", 2, 132, 128.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("baseline_low_upper", 3, 132, 128.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("baseline_balanced_lower", 4, 132, 128.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("baseline_balanced_upper", 5, 132, 128.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("status", 6, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.HRV_STATUS));
    }

    public XoOxI0ox() {
        super(x0OxxIOxX.XO(IXXIXx00I.f11791xxOXOOoIX));
    }

    public void O00(Float f) {
        X0xxXX0(2, 0, f, 65535);
    }

    public void O0xxXxI(HrvStatus hrvStatus) {
        X0xxXX0(6, 0, Short.valueOf(hrvStatus.value), 65535);
    }

    public void OIx00oxx(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public HrvStatus OO0() {
        Short XI0oooXX2 = XI0oooXX(6, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return HrvStatus.getByValue(XI0oooXX2);
    }

    public Float OX() {
        return XX(5, 0, 65535);
    }

    public Float OooI() {
        return XX(0, 0, 65535);
    }

    public Float Oxx() {
        return XX(4, 0, 65535);
    }

    public Float XoIxOXIXo() {
        return XX(1, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float o0IXXIx() {
        return XX(2, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Float oXIoO() {
        return XX(3, 0, 65535);
    }

    public void oxOXxoXII(Float f) {
        X0xxXX0(0, 0, f, 65535);
    }

    public void xIXX(Float f) {
        X0xxXX0(5, 0, f, 65535);
    }

    public void xOOxIO(Float f) {
        X0xxXX0(1, 0, f, 65535);
    }

    public void xxxI(Float f) {
        X0xxXX0(3, 0, f, 65535);
    }

    public XoOxI0ox(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
