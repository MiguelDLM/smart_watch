package com.garmin.fit;

import com.garmin.fit.Profile;
import com.sma.smartv3.ble.ProductManager;

/* loaded from: classes9.dex */
public class oXO0oOx0 extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14802II0XooXoX = 0;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final oIXoXx0 f14803xxIXOIIO;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0(ProductManager.oIIX, 78);
        f14803xxIXOIIO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("time", 0, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.UINT16));
    }

    public oXO0oOx0() {
        super(x0OxxIOxX.XO(78));
    }

    public Float OX(int i) {
        return XX(0, i, 65535);
    }

    public int Oxx() {
        return oOoIIO0(0, 65535);
    }

    public void o0IXXIx(int i, Float f) {
        X0xxXX0(0, i, f, 65535);
    }

    public Float[] oXIoO() {
        return xo0x(0, 65535);
    }

    public oXO0oOx0(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
