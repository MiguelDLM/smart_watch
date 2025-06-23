package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class OxxIIOOXO extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f13309II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f13310OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final oIXoXx0 f13311oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f13312xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f13313xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("barometer_data", 209);
        f13311oOoXoXO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp_ms", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sample_time_offset", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("baro_pres", 2, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "Pa", false, Profile.Type.UINT32));
    }

    public OxxIIOOXO() {
        super(x0OxxIOxX.XO(209));
    }

    public void OIx00oxx(int i, Long l) {
        X0xxXX0(2, i, l, 65535);
    }

    public Integer[] OO0() {
        return xoxXI(1, 65535);
    }

    public Long[] OX() {
        return XX0xXo(2, 65535);
    }

    public Integer OooI() {
        return oX(0, 0, 65535);
    }

    public Long Oxx(int i) {
        return x0xO(2, i, 65535);
    }

    public Integer XoIxOXIXo(int i) {
        return oX(1, i, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public int o0IXXIx() {
        return oOoIIO0(1, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public int oXIoO() {
        return oOoIIO0(2, 65535);
    }

    public void xIXX(int i, Integer num) {
        X0xxXX0(1, i, num, 65535);
    }

    public void xxxI(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public OxxIIOOXO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
