package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xIoXXXIXo extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15352II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15353OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final oIXoXx0 f15354Oo;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f15355oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15356oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15357ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15358x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f15359x0xO0oo = 7;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15360xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15361xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("magnetometer_data", 208);
        f15354Oo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp_ms", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sample_time_offset", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("mag_x", 2, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "counts", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("mag_y", 3, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "counts", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("mag_z", 4, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "counts", false, type));
        Profile.Type type2 = Profile.Type.FLOAT32;
        oixoxx0.xxIXOIIO(new X0xII0I("calibrated_mag_x", 5, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "G", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("calibrated_mag_y", 6, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "G", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("calibrated_mag_z", 7, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "G", false, type2));
    }

    public xIoXXXIXo() {
        super(x0OxxIOxX.XO(208));
    }

    public int IxX00() {
        return oOoIIO0(7, 65535);
    }

    public Integer O00(int i) {
        return oX(4, i, 65535);
    }

    public int O0xxXxI() {
        return oOoIIO0(5, 65535);
    }

    public Integer[] OIx00oxx() {
        return xoxXI(2, 65535);
    }

    public Float[] OO0() {
        return xo0x(7, 65535);
    }

    public void OOOI(int i, Float f) {
        X0xxXX0(5, i, f, 65535);
    }

    public void OOxOI(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public Float[] OX() {
        return xo0x(5, 65535);
    }

    public Integer OooI(int i) {
        return oX(2, i, 65535);
    }

    public void OxO(int i, Integer num) {
        X0xxXX0(2, i, num, 65535);
    }

    public Integer OxXXx0X() {
        return oX(0, 0, 65535);
    }

    public Float Oxx(int i) {
        return XX(5, i, 65535);
    }

    public void X00xOoXI(int i, Integer num) {
        X0xxXX0(1, i, num, 65535);
    }

    public void X0O0I0(int i, Float f) {
        X0xxXX0(7, i, f, 65535);
    }

    public int XO0o() {
        return oOoIIO0(2, 65535);
    }

    public Float XoIxOXIXo(int i) {
        return XX(7, i, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float[] o0IXXIx() {
        return xo0x(6, 65535);
    }

    public void o0Xo(int i, Integer num) {
        X0xxXX0(4, i, num, 65535);
    }

    public void o0oxo0oI(int i, Float f) {
        X0xxXX0(6, i, f, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public int oX0I0O() {
        return oOoIIO0(3, 65535);
    }

    public Integer oX0ooo0I0(int i) {
        return oX(1, i, 65535);
    }

    public Float oXIoO(int i) {
        return XX(6, i, 65535);
    }

    public Integer[] oo00() {
        return xoxXI(1, 65535);
    }

    public int oxOXxoXII() {
        return oOoIIO0(6, 65535);
    }

    public int x00IOx() {
        return oOoIIO0(4, 65535);
    }

    public Integer xIXX(int i) {
        return oX(3, i, 65535);
    }

    public Integer[] xOOxIO() {
        return xoxXI(4, 65535);
    }

    public int xX() {
        return oOoIIO0(1, 65535);
    }

    public void xxx00(int i, Integer num) {
        X0xxXX0(3, i, num, 65535);
    }

    public Integer[] xxxI() {
        return xoxXI(3, 65535);
    }

    public xIoXXXIXo(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
