package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class XxXX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14178II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14179OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final oIXoXx0 f14180oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14181xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14182xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("hsa_spo2_data", 305);
        f14180oOoXoXO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("processing_interval", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.UINT16));
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("reading_spo2", 1, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("confidence", 2, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
    }

    public XxXX() {
        super(x0OxxIOxX.XO(305));
    }

    public void OIx00oxx(int i, Short sh) {
        X0xxXX0(2, i, sh, 65535);
    }

    public Short OO0(int i) {
        return XI0oooXX(1, i, 65535);
    }

    public Short[] OX() {
        return xoO0xx0(2, 65535);
    }

    public Short[] OooI() {
        return xoO0xx0(1, 65535);
    }

    public Short Oxx(int i) {
        return XI0oooXX(2, i, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(0, 0, 65535);
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

    public void xIXX(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public void xxxI(int i, Short sh) {
        X0xxXX0(1, i, sh, 65535);
    }

    public XxXX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
