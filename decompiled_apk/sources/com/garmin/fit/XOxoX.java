package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class XOxoX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f13917II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f13918OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f13919oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final oIXoXx0 f13920ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f13921xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f13922xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("hsa_body_battery_data", 314);
        f13920ooOOo0oXI = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("processing_interval", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("level", 1, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, Profile.Type.SINT8));
        Profile.Type type = Profile.Type.SINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("charged", 2, 131, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("uncharged", 3, 131, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
    }

    public XOxoX() {
        super(x0OxxIOxX.XO(314));
    }

    public void O00(int i, Short sh) {
        X0xxXX0(2, i, sh, 65535);
    }

    public void O0xxXxI(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public Integer OIx00oxx() {
        return oX(0, 0, 65535);
    }

    public int OO0() {
        return oOoIIO0(1, 65535);
    }

    public Short[] OX() {
        return xoO0xx0(2, 65535);
    }

    public int OooI() {
        return oOoIIO0(3, 65535);
    }

    public Short Oxx(int i) {
        return XI0oooXX(2, i, 65535);
    }

    public int XoIxOXIXo() {
        return oOoIIO0(2, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Byte[] o0IXXIx() {
        return oo0xXOI0I(1, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Byte oXIoO(int i) {
        return XxX0x0xxx(1, i, 65535);
    }

    public void oxOXxoXII(int i, Short sh) {
        X0xxXX0(3, i, sh, 65535);
    }

    public Short xIXX(int i) {
        return XI0oooXX(3, i, 65535);
    }

    public void xOOxIO(int i, Byte b) {
        X0xxXX0(1, i, b, 65535);
    }

    public Short[] xxxI() {
        return xoO0xx0(3, 65535);
    }

    public XOxoX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
