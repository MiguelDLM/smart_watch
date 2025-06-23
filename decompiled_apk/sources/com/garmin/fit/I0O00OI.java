package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class I0O00OI extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11270II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f11271OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11272xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11273xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("speed_zone", 53);
        f11271OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("high_value", 0, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("name", 1, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
    }

    public I0O00OI() {
        super(x0OxxIOxX.XO(53));
    }

    public Integer OX() {
        return oX(254, 0, 65535);
    }

    public Float Oxx() {
        return XX(0, 0, 65535);
    }

    public void XoIxOXIXo(String str) {
        X0xxXX0(1, 0, str, 65535);
    }

    public void o0IXXIx(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void oXIoO(Float f) {
        X0xxXX0(0, 0, f, 65535);
    }

    @Override // com.garmin.fit.oIXoXx0
    public String x0OIX00oO() {
        return XIXIX(1, 0, 65535);
    }

    public I0O00OI(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
