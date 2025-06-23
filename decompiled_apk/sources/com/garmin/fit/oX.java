package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class oX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14670II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14671OOXIXo = 2;

    /* renamed from: oO, reason: collision with root package name */
    public static final oIXoXx0 f14672oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14673oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14674ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14675x0XOIxOo = 5;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14676xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14677xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("climb_pro", 317);
        f14672oO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.SINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("position_lat", 0, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("position_long", 1, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("climb_pro_event", 2, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.CLIMB_PRO_EVENT));
        oixoxx0.xxIXOIIO(new X0xII0I("climb_number", 3, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("climb_category", 4, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
        oixoxx0.xxIXOIIO(new X0xII0I("current_dist", 5, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, Profile.Type.FLOAT32));
    }

    public oX() {
        super(x0OxxIOxX.XO(317));
    }

    public void O00(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public void OIx00oxx(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public Integer OO0() {
        return oX(1, 0, 65535);
    }

    public Integer OX() {
        return oX(3, 0, 65535);
    }

    public void OooI(Short sh) {
        X0xxXX0(4, 0, sh, 65535);
    }

    public Short Oxx() {
        return XI0oooXX(4, 0, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(0, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float o0IXXIx() {
        return XX(5, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public ClimbProEvent oXIoO() {
        Short XI0oooXX2 = XI0oooXX(2, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return ClimbProEvent.getByValue(XI0oooXX2);
    }

    public void xIXX(ClimbProEvent climbProEvent) {
        X0xxXX0(2, 0, Short.valueOf(climbProEvent.value), 65535);
    }

    public void xOOxIO(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public void xxxI(Float f) {
        X0xxXX0(5, 0, f, 65535);
    }

    public oX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
