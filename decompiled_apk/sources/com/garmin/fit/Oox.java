package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class Oox extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12868II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f12869OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12870xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12871xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("monitoring_hr_data", 211);
        f12869OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("resting_heart_rate", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("current_day_resting_heart_rate", 1, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type));
    }

    public Oox() {
        super(x0OxxIOxX.XO(211));
    }

    public Short OX() {
        return XI0oooXX(0, 0, 65535);
    }

    public Short Oxx() {
        return XI0oooXX(1, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public void o0IXXIx(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oXIoO(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    public Oox(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
