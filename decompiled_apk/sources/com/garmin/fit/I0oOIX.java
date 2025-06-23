package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class I0oOIX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11278II0XooXoX = 0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f11279IXxxXO = 10;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f11280OOXIXo = 3;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f11281Oo = 9;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f11282Oxx0xo = 11;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final oIXoXx0 f11283OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f11284oI0IIXIo = 12;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f11285oO = 7;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f11286oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f11287ooOOo0oXI = 5;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f11288x0XOIxOo = 6;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f11289x0xO0oo = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11290xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11291xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("connectivity", 127);
        f11283OxxIIOOXO = oixoxx0;
        Profile.Type type = Profile.Type.BOOL;
        oixoxx0.xxIXOIIO(new X0xII0I("bluetooth_enabled", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("bluetooth_le_enabled", 1, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("ant_enabled", 2, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("name", 3, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
        oixoxx0.xxIXOIIO(new X0xII0I("live_tracking_enabled", 4, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("weather_conditions_enabled", 5, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("weather_alerts_enabled", 6, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("auto_activity_upload_enabled", 7, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("course_download_enabled", 8, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("workout_download_enabled", 9, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("gps_ephemeris_download_enabled", 10, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("incident_detection_enabled", 11, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("grouptrack_enabled", 12, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
    }

    public I0oOIX() {
        super(x0OxxIOxX.XO(127));
    }

    public void IxX00(Bool bool) {
        X0xxXX0(0, 0, Short.valueOf(bool.value), 65535);
    }

    public Bool O00() {
        Short XI0oooXX2 = XI0oooXX(5, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void O0xxXxI(Bool bool) {
        X0xxXX0(2, 0, Short.valueOf(bool.value), 65535);
    }

    public Bool OIx00oxx() {
        Short XI0oooXX2 = XI0oooXX(11, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public Bool OO0() {
        Short XI0oooXX2 = XI0oooXX(10, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void OOOI(Bool bool) {
        X0xxXX0(6, 0, Short.valueOf(bool.value), 65535);
    }

    public Bool OX() {
        Short XI0oooXX2 = XI0oooXX(7, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public Bool OooI() {
        Short XI0oooXX2 = XI0oooXX(12, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void OxXXx0X(String str) {
        X0xxXX0(3, 0, str, 65535);
    }

    public Bool Oxx() {
        Short XI0oooXX2 = XI0oooXX(2, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void X0O0I0(Bool bool) {
        X0xxXX0(9, 0, Short.valueOf(bool.value), 65535);
    }

    public void XO0o(Bool bool) {
        X0xxXX0(1, 0, Short.valueOf(bool.value), 65535);
    }

    public Bool XoIxOXIXo() {
        Short XI0oooXX2 = XI0oooXX(8, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public Bool o0IXXIx() {
        Short XI0oooXX2 = XI0oooXX(1, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void o0oxo0oI(Bool bool) {
        X0xxXX0(5, 0, Short.valueOf(bool.value), 65535);
    }

    public void oX0I0O(Bool bool) {
        X0xxXX0(8, 0, Short.valueOf(bool.value), 65535);
    }

    public void oX0ooo0I0(Bool bool) {
        X0xxXX0(11, 0, Short.valueOf(bool.value), 65535);
    }

    public Bool oXIoO() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void oo00(Bool bool) {
        X0xxXX0(4, 0, Short.valueOf(bool.value), 65535);
    }

    public void oxOXxoXII(Bool bool) {
        X0xxXX0(7, 0, Short.valueOf(bool.value), 65535);
    }

    public void x00IOx(Bool bool) {
        X0xxXX0(10, 0, Short.valueOf(bool.value), 65535);
    }

    @Override // com.garmin.fit.oIXoXx0
    public String x0OIX00oO() {
        return XIXIX(3, 0, 65535);
    }

    public Bool xIXX() {
        Short XI0oooXX2 = XI0oooXX(4, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public Bool xOOxIO() {
        Short XI0oooXX2 = XI0oooXX(9, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void xX(Bool bool) {
        X0xxXX0(12, 0, Short.valueOf(bool.value), 65535);
    }

    public Bool xxxI() {
        Short XI0oooXX2 = XI0oooXX(6, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public I0oOIX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
