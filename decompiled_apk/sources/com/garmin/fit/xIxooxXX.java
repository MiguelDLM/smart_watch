package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xIxooxXX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15366II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15367OOXIXo = 2;

    /* renamed from: oO, reason: collision with root package name */
    public static final oIXoXx0 f15368oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15369oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15370ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15371x0XOIxOo = 5;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15372xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15373xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("hsa_gyroscope_data", IXXIXx00I.f11717X0xII0I);
        f15368oO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp_ms", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sampling_interval", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "1/32768 s", false, type));
        Profile.Type type2 = Profile.Type.SINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("gyro_x", 2, 131, 28.57143d, XIXIX.OOXIXo.f3760XO, "deg/s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("gyro_y", 3, 131, 28.57143d, XIXIX.OOXIXo.f3760XO, "deg/s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("gyro_z", 4, 131, 28.57143d, XIXIX.OOXIXo.f3760XO, "deg/s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp_32k", 5, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "1/32768 s", false, Profile.Type.UINT32));
    }

    public xIxooxXX() {
        super(x0OxxIOxX.XO(IXXIXx00I.f11717X0xII0I));
    }

    public void IxX00(int i, Float f) {
        X0xxXX0(4, i, f, 65535);
    }

    public Long O00() {
        return x0xO(5, 0, 65535);
    }

    public void O0xxXxI(int i, Float f) {
        X0xxXX0(2, i, f, 65535);
    }

    public int OIx00oxx() {
        return oOoIIO0(3, 65535);
    }

    public Float[] OO0() {
        return xo0x(4, 65535);
    }

    public Float[] OX() {
        return xo0x(2, 65535);
    }

    public int OooI() {
        return oOoIIO0(2, 65535);
    }

    public Float Oxx(int i) {
        return XX(2, i, 65535);
    }

    public void XO0o(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public Float XoIxOXIXo(int i) {
        return XX(4, i, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float[] o0IXXIx() {
        return xo0x(3, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oX0I0O(Long l) {
        X0xxXX0(5, 0, l, 65535);
    }

    public Float oXIoO(int i) {
        return XX(3, i, 65535);
    }

    public void oxOXxoXII(int i, Float f) {
        X0xxXX0(3, i, f, 65535);
    }

    public void x00IOx(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public int xIXX() {
        return oOoIIO0(4, 65535);
    }

    public Integer xOOxIO() {
        return oX(0, 0, 65535);
    }

    public Integer xxxI() {
        return oX(1, 0, 65535);
    }

    public xIxooxXX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
