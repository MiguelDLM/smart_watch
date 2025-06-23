package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class OIx0xoOo extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12497II0XooXoX = 253;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final oIXoXx0 f12498xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12499xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("respiration_rate", 297);
        f12498xoIox = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("respiration_rate", 0, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "breaths/min", false, Profile.Type.SINT16));
    }

    public OIx0xoOo() {
        super(x0OxxIOxX.XO(297));
    }

    public void OX(Float f) {
        X0xxXX0(0, 0, f, 65535);
    }

    public Float Oxx() {
        return XX(0, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public OIx0xoOo(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
