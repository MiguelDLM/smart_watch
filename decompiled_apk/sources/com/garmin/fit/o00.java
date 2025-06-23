package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class o00 extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14207II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f14208OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14209xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14210xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("beat_intervals", 290);
        f14208OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp_ms", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("time", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
    }

    public o00() {
        super(x0OxxIOxX.XO(290));
    }

    public void OO0(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public Integer OX(int i) {
        return oX(1, i, 65535);
    }

    public int Oxx() {
        return oOoIIO0(1, 65535);
    }

    public void XoIxOXIXo(int i, Integer num) {
        X0xxXX0(1, i, num, 65535);
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

    public Integer[] oXIoO() {
        return xoxXI(1, 65535);
    }

    public o00(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
