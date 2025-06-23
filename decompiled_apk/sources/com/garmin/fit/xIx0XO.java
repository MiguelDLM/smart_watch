package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xIx0XO extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15362II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f15363OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15364xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15365xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("hr_zone", 8);
        f15363OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("high_bpm", 1, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, Profile.Type.UINT8));
        oixoxx0.xxIXOIIO(new X0xII0I("name", 2, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
    }

    public xIx0XO() {
        super(x0OxxIOxX.XO(8));
    }

    public Integer OX() {
        return oX(254, 0, 65535);
    }

    public Short Oxx() {
        return XI0oooXX(1, 0, 65535);
    }

    public void XoIxOXIXo(String str) {
        X0xxXX0(2, 0, str, 65535);
    }

    public void o0IXXIx(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void oXIoO(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    @Override // com.garmin.fit.oIXoXx0
    public String x0OIX00oO() {
        return XIXIX(2, 0, 65535);
    }

    public xIx0XO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
