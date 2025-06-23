package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class XooIO0oo0 extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14115II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14116OOXIXo = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14117oOoXoXO = 9;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14118ooOOo0oXI = 10;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final oIXoXx0 f14119x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14120xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14121xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("hr", 132);
        f14119x0XOIxOo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("fractional_timestamp", 0, 132, 32768.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.UINT16));
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("time256", 1, 2, 256.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.f14429oxoX.get(2).f13537xoIox.add(new oXX0IoI(0, false, 8, 256.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("filtered_bpm", 6, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("event_timestamp", 9, 134, 1024.0d, XIXIX.OOXIXo.f3760XO, "s", true, Profile.Type.UINT32));
        oixoxx0.xxIXOIIO(new X0xII0I("event_timestamp_12", 10, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BYTE));
        oixoxx0.f14429oxoX.get(5).f13537xoIox.add(new oXX0IoI(9, true, 12, 1024.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(5).f13537xoIox.add(new oXX0IoI(9, true, 12, 1024.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(5).f13537xoIox.add(new oXX0IoI(9, true, 12, 1024.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(5).f13537xoIox.add(new oXX0IoI(9, true, 12, 1024.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(5).f13537xoIox.add(new oXX0IoI(9, true, 12, 1024.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(5).f13537xoIox.add(new oXX0IoI(9, true, 12, 1024.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(5).f13537xoIox.add(new oXX0IoI(9, true, 12, 1024.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(5).f13537xoIox.add(new oXX0IoI(9, true, 12, 1024.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(5).f13537xoIox.add(new oXX0IoI(9, true, 12, 1024.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(5).f13537xoIox.add(new oXX0IoI(9, true, 12, 1024.0d, XIXIX.OOXIXo.f3760XO));
    }

    public XooIO0oo0() {
        super(x0OxxIOxX.XO(132));
    }

    public void IxX00(Float f) {
        X0xxXX0(0, 0, f, 65535);
    }

    public Float O00() {
        return XX(1, 0, 65535);
    }

    public void O0xxXxI(int i, Byte b) {
        X0xxXX0(10, i, b, 65535);
    }

    public int OIx00oxx() {
        return oOoIIO0(9, 65535);
    }

    public Short[] OO0() {
        return xoO0xx0(6, 65535);
    }

    public Float[] OX() {
        return xo0x(9, 65535);
    }

    public Float OooI() {
        return XX(0, 0, 65535);
    }

    public Float Oxx(int i) {
        return XX(9, i, 65535);
    }

    public void XO0o(Float f) {
        X0xxXX0(1, 0, f, 65535);
    }

    public Short XoIxOXIXo(int i) {
        return XI0oooXX(6, i, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Byte[] o0IXXIx() {
        return oo0xXOI0I(10, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Byte oXIoO(int i) {
        return XxX0x0xxx(10, i, 65535);
    }

    public void oxOXxoXII(int i, Short sh) {
        X0xxXX0(6, i, sh, 65535);
    }

    public int xIXX() {
        return oOoIIO0(10, 65535);
    }

    public void xOOxIO(int i, Float f) {
        X0xxXX0(9, i, f, 65535);
    }

    public int xxxI() {
        return oOoIIO0(6, 65535);
    }

    public XooIO0oo0(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
