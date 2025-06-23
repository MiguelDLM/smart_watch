package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class oo0oIXo extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14953II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14954OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final oIXoXx0 f14955oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14956xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14957xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("hsa_heart_rate_data", 308);
        f14955oOoXoXO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("processing_interval", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.UINT16));
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("status", 1, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("heart_rate", 2, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type));
    }

    public oo0oIXo() {
        super(x0OxxIOxX.XO(308));
    }

    public void OIx00oxx(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    public void OO0(int i, Short sh) {
        X0xxXX0(2, i, sh, 65535);
    }

    public Short[] OX() {
        return xoO0xx0(2, 65535);
    }

    public void OooI(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public Short Oxx(int i) {
        return XI0oooXX(2, i, 65535);
    }

    public Short XoIxOXIXo() {
        return XI0oooXX(1, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Integer o0IXXIx() {
        return oX(0, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public int oXIoO() {
        return oOoIIO0(2, 65535);
    }

    public oo0oIXo(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
