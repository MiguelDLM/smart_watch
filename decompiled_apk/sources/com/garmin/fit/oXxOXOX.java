package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class oXxOXOX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14934II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14935OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14936oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14937ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final oIXoXx0 f14938x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14939xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14940xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("one_d_sensor_calibration", 210);
        f14938x0XOIxOo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("sensor_type", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SENSOR_TYPE));
        Profile.Type type = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("calibration_factor", 1, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.add(new xxOoXO("baro_cal_factor", 134, 1.0d, XIXIX.OOXIXo.f3760XO, "Pa"));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.get(0).II0xO0(0, 3L);
        oixoxx0.xxIXOIIO(new X0xII0I("calibration_divisor", 2, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "counts", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("level_shift", 3, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("offset_cal", 4, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SINT32));
    }

    public oXxOXOX() {
        super(x0OxxIOxX.XO(210));
    }

    public void O00(Integer num) {
        X0xxXX0(4, 0, num, 65535);
    }

    public void OIx00oxx(Long l) {
        X0xxXX0(2, 0, l, 65535);
    }

    public SensorType OO0() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SensorType.getByValue(XI0oooXX2);
    }

    public Long OX() {
        return x0xO(2, 0, 65535);
    }

    public void OooI(Long l) {
        X0xxXX0(1, 0, l, 0);
    }

    public Long Oxx() {
        return x0xO(1, 0, 0);
    }

    public Integer XoIxOXIXo() {
        return oX(4, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Long o0IXXIx() {
        return x0xO(3, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Long oXIoO() {
        return x0xO(1, 0, 65535);
    }

    public void xIXX(Long l) {
        X0xxXX0(1, 0, l, 65535);
    }

    public void xOOxIO(SensorType sensorType) {
        X0xxXX0(0, 0, Short.valueOf(sensorType.value), 65535);
    }

    public void xxxI(Long l) {
        X0xxXX0(3, 0, l, 65535);
    }

    public oXxOXOX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
