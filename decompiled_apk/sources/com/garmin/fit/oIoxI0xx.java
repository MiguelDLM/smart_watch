package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class oIoxI0xx extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14437II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14438OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final oIXoXx0 f14439oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14440xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14441xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("spo2_data", 269);
        f14439oOoXoXO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("reading_spo2", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("reading_confidence", 1, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("mode", 2, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPO2_MEASUREMENT_TYPE));
    }

    public oIoxI0xx() {
        super(x0OxxIOxX.XO(269));
    }

    public void OO0(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public Short OX() {
        return XI0oooXX(1, 0, 65535);
    }

    public Spo2MeasurementType Oxx() {
        Short XI0oooXX2 = XI0oooXX(2, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Spo2MeasurementType.getByValue(XI0oooXX2);
    }

    public void XoIxOXIXo(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public void o0IXXIx(Spo2MeasurementType spo2MeasurementType) {
        X0xxXX0(2, 0, Short.valueOf(spo2MeasurementType.value), 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Short oXIoO() {
        return XI0oooXX(0, 0, 65535);
    }

    public oIoxI0xx(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
