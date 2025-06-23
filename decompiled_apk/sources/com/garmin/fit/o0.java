package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class o0 extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14202II0XooXoX = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14203OOXIXo = 23;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final oIXoXx0 f14204oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14205xoIox = 21;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14206xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("capabilities", 1);
        f14204oOoXoXO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("languages", 0, 10, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8Z));
        oixoxx0.xxIXOIIO(new X0xII0I("sports", 1, 10, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPORT_BITS_0));
        oixoxx0.xxIXOIIO(new X0xII0I("workouts_supported", 21, 140, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.WORKOUT_CAPABILITIES));
        oixoxx0.xxIXOIIO(new X0xII0I("connectivity_supported", 23, 140, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.CONNECTIVITY_CAPABILITIES));
    }

    public o0() {
        super(x0OxxIOxX.XO(1));
    }

    public void O00(int i, Short sh) {
        X0xxXX0(1, i, sh, 65535);
    }

    public Long OIx00oxx() {
        return x0xO(21, 0, 65535);
    }

    public Short OO0(int i) {
        return XI0oooXX(1, i, 65535);
    }

    public Short OX(int i) {
        return XI0oooXX(0, i, 65535);
    }

    public Short[] OooI() {
        return xoO0xx0(1, 65535);
    }

    public Long Oxx() {
        return x0xO(23, 0, 65535);
    }

    public int XoIxOXIXo() {
        return oOoIIO0(1, 65535);
    }

    public int o0IXXIx() {
        return oOoIIO0(0, 65535);
    }

    public Short[] oXIoO() {
        return xoO0xx0(0, 65535);
    }

    public void xIXX(Long l) {
        X0xxXX0(23, 0, l, 65535);
    }

    public void xOOxIO(Long l) {
        X0xxXX0(21, 0, l, 65535);
    }

    public void xxxI(int i, Short sh) {
        X0xxXX0(0, i, sh, 65535);
    }

    public o0(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
