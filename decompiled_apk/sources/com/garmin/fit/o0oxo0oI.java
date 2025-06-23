package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class o0oxo0oI extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14286II0XooXoX = 254;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f14287IXxxXO = 9;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14288OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f14289Oo = 8;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f14290Oxx0xo = 10;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final oIXoXx0 f14291OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f14292oI0IIXIo = 11;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f14293oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14294oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14295ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14296x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f14297x0xO0oo = 7;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14298xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14299xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("goal", 15);
        f14291OxxIIOOXO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("sport", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("sub_sport", 1, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SUB_SPORT));
        Profile.Type type = Profile.Type.DATE_TIME;
        oixoxx0.xxIXOIIO(new X0xII0I("start_date", 2, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("end_date", 3, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("type", 4, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.GOAL));
        Profile.Type type2 = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("value", 5, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        Profile.Type type3 = Profile.Type.BOOL;
        oixoxx0.xxIXOIIO(new X0xII0I("repeat", 6, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("target_value", 7, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("recurrence", 8, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.GOAL_RECURRENCE));
        oixoxx0.xxIXOIIO(new X0xII0I("recurrence_value", 9, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("enabled", 10, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("source", 11, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.GOAL_SOURCE));
    }

    public o0oxo0oI() {
        super(x0OxxIOxX.XO(15));
    }

    public void IxX00(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(3, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Long O00() {
        return x0xO(7, 0, 65535);
    }

    public Long O0xxXxI() {
        return x0xO(5, 0, 65535);
    }

    public Sport OIx00oxx() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Sport.getByValue(XI0oooXX2);
    }

    public Bool OO0() {
        Short XI0oooXX2 = XI0oooXX(6, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void OOOI(SubSport subSport) {
        X0xxXX0(1, 0, Short.valueOf(subSport.value), 65535);
    }

    public o0xxxXXxX OX() {
        return oXX0IoI(x0xO(3, 0, 65535));
    }

    public GoalSource OooI() {
        Short XI0oooXX2 = XI0oooXX(11, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return GoalSource.getByValue(XI0oooXX2);
    }

    public void OxO(Long l) {
        X0xxXX0(5, 0, l, 65535);
    }

    public void OxXXx0X(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(2, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Bool Oxx() {
        Short XI0oooXX2 = XI0oooXX(10, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void X0O0I0(Goal goal) {
        X0xxXX0(4, 0, Short.valueOf(goal.value), 65535);
    }

    public void XO0o(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(9, 0, 65535);
    }

    public GoalRecurrence o0IXXIx() {
        Short XI0oooXX2 = XI0oooXX(8, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return GoalRecurrence.getByValue(XI0oooXX2);
    }

    public void o0oxo0oI(Long l) {
        X0xxXX0(7, 0, l, 65535);
    }

    public void oX0I0O(GoalRecurrence goalRecurrence) {
        X0xxXX0(8, 0, Short.valueOf(goalRecurrence.value), 65535);
    }

    public void oX0ooo0I0(GoalSource goalSource) {
        X0xxXX0(11, 0, Short.valueOf(goalSource.value), 65535);
    }

    public Integer oXIoO() {
        return oX(254, 0, 65535);
    }

    public void oo00(Sport sport) {
        X0xxXX0(0, 0, Short.valueOf(sport.value), 65535);
    }

    public void oxOXxoXII(Bool bool) {
        X0xxXX0(10, 0, Short.valueOf(bool.value), 65535);
    }

    public void x00IOx(Integer num) {
        X0xxXX0(9, 0, num, 65535);
    }

    public o0xxxXXxX xIXX() {
        return oXX0IoI(x0xO(2, 0, 65535));
    }

    public Goal xOOxIO() {
        Short XI0oooXX2 = XI0oooXX(4, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Goal.getByValue(XI0oooXX2);
    }

    public void xX(Bool bool) {
        X0xxXX0(6, 0, Short.valueOf(bool.value), 65535);
    }

    public SubSport xxxI() {
        Short XI0oooXX2 = XI0oooXX(1, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SubSport.getByValue(XI0oooXX2);
    }

    public o0oxo0oI(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
