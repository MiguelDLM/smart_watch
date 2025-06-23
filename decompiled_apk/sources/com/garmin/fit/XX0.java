package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class XX0 extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f13925II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f13926OOXIXo = 2;

    /* renamed from: oO, reason: collision with root package name */
    public static final oIXoXx0 f13927oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f13928oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f13929ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f13930x0XOIxOo = 5;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f13931xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f13932xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("chrono_shot_session", IXXIXx00I.f11718X0xxXX0);
        f13927oO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("min_speed", 0, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("max_speed", 1, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_speed", 2, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("shot_count", 3, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("projectile_type", 4, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.PROJECTILE_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("grain_weight", 5, 134, 10.0d, XIXIX.OOXIXo.f3760XO, "gr", false, type));
    }

    public XX0() {
        super(x0OxxIOxX.XO(IXXIXx00I.f11718X0xxXX0));
    }

    public void O00(ProjectileType projectileType) {
        X0xxXX0(4, 0, Short.valueOf(projectileType.value), 65535);
    }

    public void OIx00oxx(Float f) {
        X0xxXX0(5, 0, f, 65535);
    }

    public Integer OO0() {
        return oX(3, 0, 65535);
    }

    public Float OX() {
        return XX(5, 0, 65535);
    }

    public void OooI(Float f) {
        X0xxXX0(2, 0, f, 65535);
    }

    public Float Oxx() {
        return XX(2, 0, 65535);
    }

    public ProjectileType XoIxOXIXo() {
        Short XI0oooXX2 = XI0oooXX(4, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return ProjectileType.getByValue(XI0oooXX2);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float o0IXXIx() {
        return XX(0, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Float oXIoO() {
        return XX(1, 0, 65535);
    }

    public void xIXX(Float f) {
        X0xxXX0(1, 0, f, 65535);
    }

    public void xOOxIO(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public void xxxI(Float f) {
        X0xxXX0(0, 0, f, 65535);
    }

    public XX0(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
