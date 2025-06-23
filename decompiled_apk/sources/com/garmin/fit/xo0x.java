package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xo0x extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15561II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f15562OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15563xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15564xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("chrono_shot_data", IXXIXx00I.f11682IO0XoXxO);
        f15562OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("shot_speed", 0, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, Profile.Type.UINT32));
        oixoxx0.xxIXOIIO(new X0xII0I("shot_num", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
    }

    public xo0x() {
        super(x0OxxIOxX.XO(IXXIXx00I.f11682IO0XoXxO));
    }

    public Float OX() {
        return XX(0, 0, 65535);
    }

    public Integer Oxx() {
        return oX(1, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public void o0IXXIx(Float f) {
        X0xxXX0(0, 0, f, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oXIoO(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public xo0x(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
