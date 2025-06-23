package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class IO extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11463II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f11464OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11465xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11466xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("cadence_zone", 131);
        f11464OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("high_value", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, Profile.Type.UINT8));
        oixoxx0.xxIXOIIO(new X0xII0I("name", 1, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
    }

    public IO() {
        super(x0OxxIOxX.XO(131));
    }

    public Integer OX() {
        return oX(254, 0, 65535);
    }

    public Short Oxx() {
        return XI0oooXX(0, 0, 65535);
    }

    public void XoIxOXIXo(String str) {
        X0xxXX0(1, 0, str, 65535);
    }

    public void o0IXXIx(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void oXIoO(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    @Override // com.garmin.fit.oIXoXx0
    public String x0OIX00oO() {
        return XIXIX(1, 0, 65535);
    }

    public IO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
