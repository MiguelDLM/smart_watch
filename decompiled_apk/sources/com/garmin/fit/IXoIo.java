package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class IXoIo extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11793II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f11794OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11795xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11796xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("hsa_stress_data", 306);
        f11794OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("processing_interval", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("stress_level", 1, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.SINT8));
    }

    public IXoIo() {
        super(x0OxxIOxX.XO(306));
    }

    public void OO0(int i, Byte b) {
        X0xxXX0(1, i, b, 65535);
    }

    public Integer OX() {
        return oX(0, 0, 65535);
    }

    public int Oxx() {
        return oOoIIO0(1, 65535);
    }

    public void XoIxOXIXo(Integer num) {
        X0xxXX0(0, 0, num, 65535);
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

    public IXoIo(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
