package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xOOxX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15411II0XooXoX = 253;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f15412IIXOooo = 13;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f15413IXxxXO = 9;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15414OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f15415Oo = 8;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f15416Oxx0xo = 10;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f15417OxxIIOOXO = 12;

    /* renamed from: o00, reason: collision with root package name */
    public static final oIXoXx0 f15418o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f15419oI0IIXIo = 11;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f15420oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15421oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15422ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15423x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f15424x0xO0oo = 7;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15425xoIox = 1;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f15426xoXoI = 14;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15427xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("weather_conditions", 128);
        f15418o00 = oixoxx0;
        Profile.Type type = Profile.Type.DATE_TIME;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("weather_report", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.WEATHER_REPORT));
        Profile.Type type2 = Profile.Type.SINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("temperature", 1, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "C", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("condition", 2, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.WEATHER_STATUS));
        Profile.Type type3 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("wind_direction", 3, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "degrees", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("wind_speed", 4, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type3));
        Profile.Type type4 = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("precipitation_probability", 5, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("temperature_feels_like", 6, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "C", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("relative_humidity", 7, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("location", 8, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
        oixoxx0.xxIXOIIO(new X0xII0I("observed_at_time", 9, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        Profile.Type type5 = Profile.Type.SINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("observed_location_lat", 10, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("observed_location_long", 11, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("day_of_week", 12, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DAY_OF_WEEK));
        oixoxx0.xxIXOIIO(new X0xII0I("high_temperature", 13, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "C", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("low_temperature", 14, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "C", false, type2));
    }

    public xOOxX() {
        super(x0OxxIOxX.XO(128));
    }

    public Float IxX00() {
        return XX(4, 0, 65535);
    }

    public Byte O00() {
        return XxX0x0xxx(1, 0, 65535);
    }

    public WeatherReport O0xxXxI() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return WeatherReport.getByValue(XI0oooXX2);
    }

    public Integer OIx00oxx() {
        return oX(11, 0, 65535);
    }

    public o0xxxXXxX OO0() {
        return oXX0IoI(x0xO(9, 0, 65535));
    }

    public void OOOI(Integer num) {
        X0xxXX0(11, 0, num, 65535);
    }

    public void OOxOI(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public DayOfWeek OX() {
        Short XI0oooXX2 = XI0oooXX(12, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DayOfWeek.getByValue(XI0oooXX2);
    }

    public Integer OooI() {
        return oX(10, 0, 65535);
    }

    public void OxO(Byte b) {
        X0xxXX0(1, 0, b, 65535);
    }

    public void OxXXx0X(Integer num) {
        X0xxXX0(10, 0, num, 65535);
    }

    public WeatherStatus Oxx() {
        Short XI0oooXX2 = XI0oooXX(2, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return WeatherStatus.getByValue(XI0oooXX2);
    }

    public void X00xOoXI(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public void X0O0I0(Short sh) {
        X0xxXX0(7, 0, sh, 65535);
    }

    public void XO0o(WeatherStatus weatherStatus) {
        X0xxXX0(2, 0, Short.valueOf(weatherStatus.value), 65535);
    }

    public Byte XoIxOXIXo() {
        return XxX0x0xxx(14, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public String o0IXXIx() {
        return XIXIX(8, 0, 65535);
    }

    public void o0Xo(WeatherReport weatherReport) {
        X0xxXX0(0, 0, Short.valueOf(weatherReport.value), 65535);
    }

    public void o0oxo0oI(Short sh) {
        X0xxXX0(5, 0, sh, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oX0I0O(DayOfWeek dayOfWeek) {
        X0xxXX0(12, 0, Short.valueOf(dayOfWeek.value), 65535);
    }

    public void oX0ooo0I0(Byte b) {
        X0xxXX0(14, 0, b, 65535);
    }

    public Byte oXIoO() {
        return XxX0x0xxx(13, 0, 65535);
    }

    public void oo00(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(9, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Integer oxOXxoXII() {
        return oX(3, 0, 65535);
    }

    public void x00IOx(Byte b) {
        X0xxXX0(13, 0, b, 65535);
    }

    public Short xIXX() {
        return XI0oooXX(5, 0, 65535);
    }

    public Byte xOOxIO() {
        return XxX0x0xxx(6, 0, 65535);
    }

    public void xX(String str) {
        X0xxXX0(8, 0, str, 65535);
    }

    public void xxx00(Byte b) {
        X0xxXX0(6, 0, b, 65535);
    }

    public Short xxxI() {
        return XI0oooXX(7, 0, 65535);
    }

    public xOOxX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
