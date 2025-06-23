package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class x0xO extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15260II0XooXoX = 4;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15261OOXIXo = 7;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final oIXoXx0 f15262oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15263xoIox = 6;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15264xxIXOIIO = 5;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("course", 31);
        f15262oOoXoXO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("sport", 4, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("name", 5, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
        oixoxx0.xxIXOIIO(new X0xII0I("capabilities", 6, 140, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.COURSE_CAPABILITIES));
        oixoxx0.xxIXOIIO(new X0xII0I("sub_sport", 7, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SUB_SPORT));
    }

    public x0xO() {
        super(x0OxxIOxX.XO(31));
    }

    public void OO0(Sport sport) {
        X0xxXX0(4, 0, Short.valueOf(sport.value), 65535);
    }

    public Sport OX() {
        Short XI0oooXX2 = XI0oooXX(4, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Sport.getByValue(XI0oooXX2);
    }

    public void OooI(SubSport subSport) {
        X0xxXX0(7, 0, Short.valueOf(subSport.value), 65535);
    }

    public Long Oxx() {
        return x0xO(6, 0, 65535);
    }

    public void XoIxOXIXo(String str) {
        X0xxXX0(5, 0, str, 65535);
    }

    public void o0IXXIx(Long l) {
        X0xxXX0(6, 0, l, 65535);
    }

    public SubSport oXIoO() {
        Short XI0oooXX2 = XI0oooXX(7, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SubSport.getByValue(XI0oooXX2);
    }

    @Override // com.garmin.fit.oIXoXx0
    public String x0OIX00oO() {
        return XIXIX(5, 0, 65535);
    }

    public x0xO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
