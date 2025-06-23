package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class O0o000XOX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12406II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12407OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12408oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final oIXoXx0 f12409ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12410xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12411xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("tank_summary", 323);
        f12409ooOOo0oXI = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("sensor", 0, 140, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.ANT_CHANNEL_ID));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("start_pressure", 1, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "bar", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("end_pressure", 2, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "bar", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("volume_used", 3, 134, 100.0d, XIXIX.OOXIXo.f3760XO, "L", false, Profile.Type.UINT32));
    }

    public O0o000XOX() {
        super(x0OxxIOxX.XO(323));
    }

    public void OIx00oxx(Float f) {
        X0xxXX0(3, 0, f, 65535);
    }

    public void OO0(Long l) {
        X0xxXX0(0, 0, l, 65535);
    }

    public Long OX() {
        return x0xO(0, 0, 65535);
    }

    public void OooI(Float f) {
        X0xxXX0(1, 0, f, 65535);
    }

    public Float Oxx() {
        return XX(2, 0, 65535);
    }

    public void XoIxOXIXo(Float f) {
        X0xxXX0(2, 0, f, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float o0IXXIx() {
        return XX(3, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Float oXIoO() {
        return XX(1, 0, 65535);
    }

    public O0o000XOX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
