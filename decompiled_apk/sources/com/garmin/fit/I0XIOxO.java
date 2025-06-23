package com.garmin.fit;

import com.garmin.fit.Profile;
import com.sma.smartv3.ble.ProductManager;

/* loaded from: classes9.dex */
public class I0XIOxO extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11274II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f11275OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11276xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11277xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("tank_update", 319);
        f11275OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("sensor", 0, 140, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.ANT_CHANNEL_ID));
        oixoxx0.xxIXOIIO(new X0xII0I(ProductManager.oXoxo0x, 1, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "bar", false, Profile.Type.UINT16));
    }

    public I0XIOxO() {
        super(x0OxxIOxX.XO(319));
    }

    public Long OX() {
        return x0xO(0, 0, 65535);
    }

    public Float Oxx() {
        return XX(1, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public void o0IXXIx(Long l) {
        X0xxXX0(0, 0, l, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oXIoO(Float f) {
        X0xxXX0(1, 0, f, 65535);
    }

    public I0XIOxO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
