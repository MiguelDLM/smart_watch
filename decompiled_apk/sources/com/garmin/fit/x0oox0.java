package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class x0oox0 extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15256II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f15257OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15258xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15259xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("hsa_wrist_temperature_data", 409);
        f15257OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("processing_interval", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("value", 1, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "degC", false, type));
    }

    public x0oox0() {
        super(x0OxxIOxX.XO(409));
    }

    public void OO0(int i, Float f) {
        X0xxXX0(1, i, f, 65535);
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

    public Float[] o0IXXIx() {
        return xo0x(1, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Float oXIoO(int i) {
        return XX(1, i, 65535);
    }

    public x0oox0(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
