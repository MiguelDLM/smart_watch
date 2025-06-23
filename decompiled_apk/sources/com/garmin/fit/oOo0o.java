package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class oOo0o extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14634II0XooXoX = 254;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final oIXoXx0 f14635IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14636OOXIXo = 1;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f14637Oo = 9;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f14638oO = 5;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14639oOoXoXO = 2;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14640ooOOo0oXI = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14641x0XOIxOo = 4;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f14642x0xO0oo = 6;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14643xoIox = 0;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14644xxIXOIIO = 253;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("totals", 33);
        f14635IXxxXO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("timer_time", 0, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15470o00, 1, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("calories", 2, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "kcal", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sport", 3, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("elapsed_time", 4, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sessions", 5, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15466X0IIOO, 6, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sport_index", 9, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
    }

    public oOo0o() {
        super(x0OxxIOxX.XO(33));
    }

    public void IxX00(Integer num) {
        X0xxXX0(5, 0, num, 65535);
    }

    public void O00(Long l) {
        X0xxXX0(2, 0, l, 65535);
    }

    public void O0xxXxI(Long l) {
        X0xxXX0(4, 0, l, 65535);
    }

    public Short OIx00oxx() {
        return XI0oooXX(9, 0, 65535);
    }

    public Integer OO0() {
        return oX(5, 0, 65535);
    }

    public Long OX() {
        return x0xO(2, 0, 65535);
    }

    public Sport OooI() {
        Short XI0oooXX2 = XI0oooXX(3, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Sport.getByValue(XI0oooXX2);
    }

    public Long Oxx() {
        return x0xO(6, 0, 65535);
    }

    public void XO0o(Sport sport) {
        X0xxXX0(3, 0, Short.valueOf(sport.value), 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(254, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Long o0IXXIx() {
        return x0xO(4, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oX0I0O(Short sh) {
        X0xxXX0(9, 0, sh, 65535);
    }

    public Long oXIoO() {
        return x0xO(1, 0, 65535);
    }

    public void oxOXxoXII(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void x00IOx(Long l) {
        X0xxXX0(0, 0, l, 65535);
    }

    public Long xIXX() {
        return x0xO(0, 0, 65535);
    }

    public void xOOxIO(Long l) {
        X0xxXX0(1, 0, l, 65535);
    }

    public void xxxI(Long l) {
        X0xxXX0(6, 0, l, 65535);
    }

    public oOo0o(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
