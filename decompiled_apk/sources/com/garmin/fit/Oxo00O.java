package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class Oxo00O extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f13285II0XooXoX = 253;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final oIXoXx0 f13286xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f13287xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("hsa_event", 315);
        f13286xoIox = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("event_id", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
    }

    public Oxo00O() {
        super(x0OxxIOxX.XO(315));
    }

    public void OX(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public Short Oxx() {
        return XI0oooXX(0, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Oxo00O(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
