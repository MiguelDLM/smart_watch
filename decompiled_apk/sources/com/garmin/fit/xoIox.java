package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xoIox extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15565II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15566OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15567oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15568ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final oIXoXx0 f15569x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15570xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15571xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("ant_rx", 80);
        f15569x0XOIxOo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("fractional_timestamp", 0, 132, 32768.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.UINT16));
        Profile.Type type = Profile.Type.BYTE;
        oixoxx0.xxIXOIIO(new X0xII0I("mesg_id", 1, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("mesg_data", 2, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.f14429oxoX.get(3).f13537xoIox.add(new oXX0IoI(3, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(3).f13537xoIox.add(new oXX0IoI(4, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(3).f13537xoIox.add(new oXX0IoI(4, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(3).f13537xoIox.add(new oXX0IoI(4, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(3).f13537xoIox.add(new oXX0IoI(4, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(3).f13537xoIox.add(new oXX0IoI(4, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(3).f13537xoIox.add(new oXX0IoI(4, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(3).f13537xoIox.add(new oXX0IoI(4, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(3).f13537xoIox.add(new oXX0IoI(4, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("channel_number", 3, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
        oixoxx0.xxIXOIIO(new X0xII0I("data", 4, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
    }

    public xoIox() {
        super(x0OxxIOxX.XO(80));
    }

    public void O00(int i, Byte b) {
        X0xxXX0(4, i, b, 65535);
    }

    public void O0xxXxI(int i, Byte b) {
        X0xxXX0(2, i, b, 65535);
    }

    public int OIx00oxx() {
        return oOoIIO0(4, 65535);
    }

    public Byte[] OO0() {
        return oo0xXOI0I(2, 65535);
    }

    public Byte OX(int i) {
        return XxX0x0xxx(4, i, 65535);
    }

    public Byte OooI() {
        return XxX0x0xxx(1, 0, 65535);
    }

    public Short Oxx() {
        return XI0oooXX(3, 0, 65535);
    }

    public Byte XoIxOXIXo(int i) {
        return XxX0x0xxx(2, i, 65535);
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

    public Byte[] oXIoO() {
        return oo0xXOI0I(4, 65535);
    }

    public void oxOXxoXII(Byte b) {
        X0xxXX0(1, 0, b, 65535);
    }

    public int xIXX() {
        return oOoIIO0(2, 65535);
    }

    public void xOOxIO(Float f) {
        X0xxXX0(0, 0, f, 65535);
    }

    public void xxxI(Short sh) {
        X0xxXX0(3, 0, sh, 65535);
    }

    public xoIox(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
