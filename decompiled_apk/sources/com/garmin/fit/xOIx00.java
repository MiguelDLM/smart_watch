package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xOIx00 extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15390II0XooXoX = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f15391OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15392xoIox = 3;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15393xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("sport", 12);
        f15391OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("sport", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("sub_sport", 1, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SUB_SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("name", 3, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
    }

    public xOIx00() {
        super(x0OxxIOxX.XO(12));
    }

    public SubSport OX() {
        Short XI0oooXX2 = XI0oooXX(1, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SubSport.getByValue(XI0oooXX2);
    }

    public Sport Oxx() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Sport.getByValue(XI0oooXX2);
    }

    public void XoIxOXIXo(SubSport subSport) {
        X0xxXX0(1, 0, Short.valueOf(subSport.value), 65535);
    }

    public void o0IXXIx(Sport sport) {
        X0xxXX0(0, 0, Short.valueOf(sport.value), 65535);
    }

    public void oXIoO(String str) {
        X0xxXX0(3, 0, str, 65535);
    }

    @Override // com.garmin.fit.oIXoXx0
    public String x0OIX00oO() {
        return XIXIX(3, 0, 65535);
    }

    public xOIx00(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
