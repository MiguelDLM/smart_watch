package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class OxO extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12933II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12934OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final oIXoXx0 f12935Oo;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f12936oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12937oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f12938ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f12939x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f12940x0xO0oo = 7;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12941xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12942xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("gps_metadata", 160);
        f12935Oo = oixoxx0;
        Profile.Type type = Profile.Type.DATE_TIME;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        Profile.Type type2 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp_ms", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type2));
        Profile.Type type3 = Profile.Type.SINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("position_lat", 1, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("position_long", 2, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type3));
        Profile.Type type4 = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_altitude", 3, 134, 5.0d, 500.0d, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_speed", 4, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("heading", 5, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "degrees", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("utc_timestamp", 6, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("velocity", 7, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, Profile.Type.SINT16));
    }

    public OxO() {
        super(x0OxxIOxX.XO(160));
    }

    public void IxX00(Integer num) {
        X0xxXX0(2, 0, num, 65535);
    }

    public void O00(Float f) {
        X0xxXX0(3, 0, f, 65535);
    }

    public void O0xxXxI(Float f) {
        X0xxXX0(5, 0, f, 65535);
    }

    public o0xxxXXxX OIx00oxx() {
        return oXX0IoI(x0xO(6, 0, 65535));
    }

    public Integer OO0() {
        return oX(2, 0, 65535);
    }

    public Float OX() {
        return XX(4, 0, 65535);
    }

    public Integer OooI() {
        return oX(0, 0, 65535);
    }

    public Float Oxx() {
        return XX(3, 0, 65535);
    }

    public void XO0o(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(1, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public int o0IXXIx() {
        return oOoIIO0(7, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oX0I0O(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(6, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Float oXIoO() {
        return XX(5, 0, 65535);
    }

    public void oxOXxoXII(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public void x00IOx(int i, Float f) {
        X0xxXX0(7, i, f, 65535);
    }

    public Float xIXX(int i) {
        return XX(7, i, 65535);
    }

    public void xOOxIO(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public Float[] xxxI() {
        return xo0x(7, 65535);
    }

    public OxO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
