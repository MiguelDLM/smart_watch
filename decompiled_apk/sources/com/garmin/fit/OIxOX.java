package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class OIxOX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12508II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f12509OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12510xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12511xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("hsa_step_data", 304);
        f12509OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("processing_interval", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("steps", 1, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "steps", false, Profile.Type.UINT32));
    }

    public OIxOX() {
        super(x0OxxIOxX.XO(304));
    }

    public void OO0(int i, Long l) {
        X0xxXX0(1, i, l, 65535);
    }

    public Integer OX() {
        return oX(0, 0, 65535);
    }

    public int Oxx() {
        return oOoIIO0(1, 65535);
    }

    public void XoIxOXIXo(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Long[] o0IXXIx() {
        return XX0xXo(1, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Long oXIoO(int i) {
        return x0xO(1, i, 65535);
    }

    public OIxOX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
