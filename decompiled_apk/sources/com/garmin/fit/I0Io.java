package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class I0Io extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11257II0XooXoX = 253;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f11258IXxxXO = 9;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f11259OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f11260Oo = 8;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f11261Oxx0xo = 10;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final oIXoXx0 f11262oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f11263oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f11264oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f11265ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f11266x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f11267x0xO0oo = 7;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11268xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11269xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("accelerometer_data", 165);
        f11262oI0IIXIo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp_ms", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sample_time_offset", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("accel_x", 2, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "counts", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("accel_y", 3, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "counts", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("accel_z", 4, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "counts", false, type));
        Profile.Type type2 = Profile.Type.FLOAT32;
        oixoxx0.xxIXOIIO(new X0xII0I("calibrated_accel_x", 5, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "g", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("calibrated_accel_y", 6, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "g", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("calibrated_accel_z", 7, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "g", false, type2));
        Profile.Type type3 = Profile.Type.SINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("compressed_calibrated_accel_x", 8, 131, 1.0d, XIXIX.OOXIXo.f3760XO, "mG", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("compressed_calibrated_accel_y", 9, 131, 1.0d, XIXIX.OOXIXo.f3760XO, "mG", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("compressed_calibrated_accel_z", 10, 131, 1.0d, XIXIX.OOXIXo.f3760XO, "mG", false, type3));
    }

    public I0Io() {
        super(x0OxxIOxX.XO(165));
    }

    public void IIOIX(int i, Integer num) {
        X0xxXX0(1, i, num, 65535);
    }

    public Short IxX00(int i) {
        return XI0oooXX(9, i, 65535);
    }

    public Float O00(int i) {
        return XX(7, i, 65535);
    }

    public Short O0xxXxI(int i) {
        return XI0oooXX(8, i, 65535);
    }

    public Float[] OIx00oxx() {
        return xo0x(5, 65535);
    }

    public Integer[] OO0() {
        return xoxXI(4, 65535);
    }

    public void OOIXx0x(int i, Integer num) {
        X0xxXX0(4, i, num, 65535);
    }

    public int OOOI() {
        return oOoIIO0(6, 65535);
    }

    public Integer[] OOxOI() {
        return xoxXI(1, 65535);
    }

    public Integer[] OX() {
        return xoxXI(2, 65535);
    }

    public void OXXoIoXI(int i, Integer num) {
        X0xxXX0(2, i, num, 65535);
    }

    public Float OooI(int i) {
        return XX(5, i, 65535);
    }

    public int OxO() {
        return oOoIIO0(9, 65535);
    }

    public int OxXXx0X() {
        return oOoIIO0(5, 65535);
    }

    public Integer Oxx(int i) {
        return oX(2, i, 65535);
    }

    public Integer X00xOoXI(int i) {
        return oX(1, i, 65535);
    }

    public int X0O0I0() {
        return oOoIIO0(8, 65535);
    }

    public Integer XO00XOO() {
        return oX(0, 0, 65535);
    }

    public Short[] XO0o() {
        return xoO0xx0(9, 65535);
    }

    public void Xo(int i, Short sh) {
        X0xxXX0(9, i, sh, 65535);
    }

    public Integer XoIxOXIXo(int i) {
        return oX(4, i, 65535);
    }

    public void XoOxI0ox(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public void XooIO0oo0(int i, Integer num) {
        X0xxXX0(3, i, num, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Integer[] o0IXXIx() {
        return xoxXI(3, 65535);
    }

    public int o0Xo() {
        return oOoIIO0(1, 65535);
    }

    public int o0oxo0oI() {
        return oOoIIO0(7, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Short oX0I0O(int i) {
        return XI0oooXX(10, i, 65535);
    }

    public int oX0ooo0I0() {
        return oOoIIO0(3, 65535);
    }

    public Integer oXIoO(int i) {
        return oX(3, i, 65535);
    }

    public void oXO0oOx0(int i, Short sh) {
        X0xxXX0(10, i, sh, 65535);
    }

    public void oXxx000(int i, Float f) {
        X0xxXX0(6, i, f, 65535);
    }

    public int oo00() {
        return oOoIIO0(4, 65535);
    }

    public Short[] oxOXxoXII() {
        return xoO0xx0(8, 65535);
    }

    public Short[] x00IOx() {
        return xoO0xx0(10, 65535);
    }

    public Float xIXX(int i) {
        return XX(6, i, 65535);
    }

    public void xIx(int i, Short sh) {
        X0xxXX0(8, i, sh, 65535);
    }

    public void xIx0XO(int i, Float f) {
        X0xxXX0(5, i, f, 65535);
    }

    public void xOOxI(int i, Float f) {
        X0xxXX0(7, i, f, 65535);
    }

    public Float[] xOOxIO() {
        return xo0x(7, 65535);
    }

    public int xX() {
        return oOoIIO0(2, 65535);
    }

    public int xxx00() {
        return oOoIIO0(10, 65535);
    }

    public Float[] xxxI() {
        return xo0x(6, 65535);
    }

    public I0Io(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
