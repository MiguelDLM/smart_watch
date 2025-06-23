package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class IoxX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12216II0XooXoX = 253;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final oIXoXx0 f12217xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12218xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("sleep_level", 275);
        f12217xoIox = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("sleep_level", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SLEEP_LEVEL));
    }

    public IoxX() {
        super(x0OxxIOxX.XO(275));
    }

    public void OX(SleepLevel sleepLevel) {
        X0xxXX0(0, 0, Short.valueOf(sleepLevel.value), 65535);
    }

    public SleepLevel Oxx() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SleepLevel.getByValue(XI0oooXX2);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public IoxX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
