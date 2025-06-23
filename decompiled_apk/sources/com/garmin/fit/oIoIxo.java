package com.garmin.fit;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class oIoIxo extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14430II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14431OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14432oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14433ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final oIXoXx0 f14434x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14435xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14436xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("weather_alert", 129);
        f14434x0XOIxOo = oixoxx0;
        Profile.Type type = Profile.Type.DATE_TIME;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("report_id", 0, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
        oixoxx0.xxIXOIIO(new X0xII0I("issue_time", 1, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("expire_time", 2, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I(SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, 3, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.WEATHER_SEVERITY));
        oixoxx0.xxIXOIIO(new X0xII0I("type", 4, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.WEATHER_SEVERE_TYPE));
    }

    public oIoIxo() {
        super(x0OxxIOxX.XO(129));
    }

    public void OIx00oxx(String str) {
        X0xxXX0(0, 0, str, 65535);
    }

    public void OO0(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(2, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public o0xxxXXxX OX() {
        return oXX0IoI(x0xO(1, 0, 65535));
    }

    public void OooI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(1, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public o0xxxXXxX Oxx() {
        return oXX0IoI(x0xO(2, 0, 65535));
    }

    public WeatherSevereType XoIxOXIXo() {
        Short XI0oooXX2 = XI0oooXX(4, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return WeatherSevereType.getByValue(XI0oooXX2);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public WeatherSeverity o0IXXIx() {
        Short XI0oooXX2 = XI0oooXX(3, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return WeatherSeverity.getByValue(XI0oooXX2);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public String oXIoO() {
        return XIXIX(0, 0, 65535);
    }

    public void xIXX(WeatherSeverity weatherSeverity) {
        X0xxXX0(3, 0, Short.valueOf(weatherSeverity.value), 65535);
    }

    public void xxxI(WeatherSevereType weatherSevereType) {
        X0xxXX0(4, 0, Short.valueOf(weatherSevereType.value), 65535);
    }

    public oIoIxo(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
