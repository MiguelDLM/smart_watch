package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xxX0X extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15718II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15719OOXIXo = 2;

    /* renamed from: oO, reason: collision with root package name */
    public static final oIXoXx0 f15720oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15721oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15722ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15723x0XOIxOo = 5;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15724xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15725xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("workout_session", 158);
        f15720oO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("sport", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("sub_sport", 1, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SUB_SPORT));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("num_valid_steps", 2, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("first_step_index", 3, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("pool_length", 4, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("pool_length_unit", 5, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DISPLAY_MEASURE));
    }

    public xxX0X() {
        super(x0OxxIOxX.XO(158));
    }

    public void O00(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public void O0xxXxI(Sport sport) {
        X0xxXX0(0, 0, Short.valueOf(sport.value), 65535);
    }

    public void OIx00oxx(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public Sport OO0() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Sport.getByValue(XI0oooXX2);
    }

    public Integer OX() {
        return oX(254, 0, 65535);
    }

    public SubSport OooI() {
        Short XI0oooXX2 = XI0oooXX(1, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SubSport.getByValue(XI0oooXX2);
    }

    public Integer Oxx() {
        return oX(3, 0, 65535);
    }

    public DisplayMeasure XoIxOXIXo() {
        Short XI0oooXX2 = XI0oooXX(5, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayMeasure.getByValue(XI0oooXX2);
    }

    public Float o0IXXIx() {
        return XX(4, 0, 65535);
    }

    public Integer oXIoO() {
        return oX(2, 0, 65535);
    }

    public void oxOXxoXII(SubSport subSport) {
        X0xxXX0(1, 0, Short.valueOf(subSport.value), 65535);
    }

    public void xIXX(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void xOOxIO(DisplayMeasure displayMeasure) {
        X0xxXX0(5, 0, Short.valueOf(displayMeasure.value), 65535);
    }

    public void xxxI(Integer num) {
        X0xxXX0(2, 0, num, 65535);
    }

    public xxX0X(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
