package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class XxIIOXIXx extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14152II0XooXoX = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14153OOXIXo = 6;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f14154oO = 13;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14155oOoXoXO = 8;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14156ooOOo0oXI = 9;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14157x0XOIxOo = 12;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final oIXoXx0 f14158x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14159xoIox = 5;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14160xxIXOIIO = 2;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("max_met_data", 229);
        f14158x0xO0oo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("update_time", 0, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("vo2_max", 2, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "mL/kg/min", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("sport", 5, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("sub_sport", 6, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SUB_SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("max_met_category", 8, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MAX_MET_CATEGORY));
        oixoxx0.xxIXOIIO(new X0xII0I("calibrated_data", 9, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BOOL));
        oixoxx0.xxIXOIIO(new X0xII0I("hr_source", 12, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MAX_MET_HEART_RATE_SOURCE));
        oixoxx0.xxIXOIIO(new X0xII0I("speed_source", 13, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MAX_MET_SPEED_SOURCE));
    }

    public XxIIOXIXx() {
        super(x0OxxIOxX.XO(229));
    }

    public void IxX00(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(0, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void O00(MaxMetCategory maxMetCategory) {
        X0xxXX0(8, 0, Short.valueOf(maxMetCategory.value), 65535);
    }

    public void O0xxXxI(Sport sport) {
        X0xxXX0(5, 0, Short.valueOf(sport.value), 65535);
    }

    public Float OIx00oxx() {
        return XX(2, 0, 65535);
    }

    public SubSport OO0() {
        Short XI0oooXX2 = XI0oooXX(6, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SubSport.getByValue(XI0oooXX2);
    }

    public MaxMetHeartRateSource OX() {
        Short XI0oooXX2 = XI0oooXX(12, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return MaxMetHeartRateSource.getByValue(XI0oooXX2);
    }

    public o0xxxXXxX OooI() {
        return oXX0IoI(x0xO(0, 0, 65535));
    }

    public Bool Oxx() {
        Short XI0oooXX2 = XI0oooXX(9, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void XO0o(Float f) {
        X0xxXX0(2, 0, f, 65535);
    }

    public Sport XoIxOXIXo() {
        Short XI0oooXX2 = XI0oooXX(5, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Sport.getByValue(XI0oooXX2);
    }

    public MaxMetSpeedSource o0IXXIx() {
        Short XI0oooXX2 = XI0oooXX(13, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return MaxMetSpeedSource.getByValue(XI0oooXX2);
    }

    public MaxMetCategory oXIoO() {
        Short XI0oooXX2 = XI0oooXX(8, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return MaxMetCategory.getByValue(XI0oooXX2);
    }

    public void oxOXxoXII(SubSport subSport) {
        X0xxXX0(6, 0, Short.valueOf(subSport.value), 65535);
    }

    public void xIXX(Bool bool) {
        X0xxXX0(9, 0, Short.valueOf(bool.value), 65535);
    }

    public void xOOxIO(MaxMetSpeedSource maxMetSpeedSource) {
        X0xxXX0(13, 0, Short.valueOf(maxMetSpeedSource.value), 65535);
    }

    public void xxxI(MaxMetHeartRateSource maxMetHeartRateSource) {
        X0xxXX0(12, 0, Short.valueOf(maxMetHeartRateSource.value), 65535);
    }

    public XxIIOXIXx(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
