package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class x0OI extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15177II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15178OOXIXo = 2;

    /* renamed from: oO, reason: collision with root package name */
    public static final oIXoXx0 f15179oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15180oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15181ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15182x0XOIxOo = 5;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15183xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15184xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("three_d_sensor_calibration", 167);
        f15179oO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("sensor_type", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SENSOR_TYPE));
        Profile.Type type = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("calibration_factor", 1, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.add(new xxOoXO("accel_cal_factor", 134, 1.0d, XIXIX.OOXIXo.f3760XO, "g"));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.get(0).II0xO0(0, 0L);
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.add(new xxOoXO("gyro_cal_factor", 134, 1.0d, XIXIX.OOXIXo.f3760XO, "deg/s"));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.get(1).II0xO0(0, 1L);
        oixoxx0.xxIXOIIO(new X0xII0I("calibration_divisor", 2, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "counts", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("level_shift", 3, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        Profile.Type type2 = Profile.Type.SINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("offset_cal", 4, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("orientation_matrix", 5, 133, 65535.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
    }

    public x0OI() {
        super(x0OxxIOxX.XO(167));
    }

    public void IxX00(Long l) {
        X0xxXX0(1, 0, l, 65535);
    }

    public Float[] O00() {
        return xo0x(5, 65535);
    }

    public void O0xxXxI(Long l) {
        X0xxXX0(1, 0, l, 0);
    }

    public Integer OIx00oxx(int i) {
        return oX(4, i, 65535);
    }

    public int OO0() {
        return oOoIIO0(4, 65535);
    }

    public Long OX() {
        return x0xO(2, 0, 65535);
    }

    public int OooI() {
        return oOoIIO0(5, 65535);
    }

    public Long Oxx() {
        return x0xO(1, 0, 0);
    }

    public void XO0o(Long l) {
        X0xxXX0(1, 0, l, 1);
    }

    public Long XoIxOXIXo() {
        return x0xO(3, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Long o0IXXIx() {
        return x0xO(1, 0, 1);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oX0I0O(Long l) {
        X0xxXX0(3, 0, l, 65535);
    }

    public void oX0ooo0I0(SensorType sensorType) {
        X0xxXX0(0, 0, Short.valueOf(sensorType.value), 65535);
    }

    public Long oXIoO() {
        return x0xO(1, 0, 65535);
    }

    public void oxOXxoXII(Long l) {
        X0xxXX0(2, 0, l, 65535);
    }

    public void x00IOx(int i, Integer num) {
        X0xxXX0(4, i, num, 65535);
    }

    public Integer[] xIXX() {
        return xoxXI(4, 65535);
    }

    public SensorType xOOxIO() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SensorType.getByValue(XI0oooXX2);
    }

    public void xX(int i, Float f) {
        X0xxXX0(5, i, f, 65535);
    }

    public Float xxxI(int i) {
        return XX(5, i, 65535);
    }

    public x0OI(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
