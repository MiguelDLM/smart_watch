package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class Ox0XO extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12918II0XooXoX = 0;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final oIXoXx0 f12919IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f12920IXxxXO = 10;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12921OOXIXo = 3;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f12922Oo = 9;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f12923Oxx0xo = 11;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f12924OxxIIOOXO = 15;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f12925oI0IIXIo = 14;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f12926oO = 7;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12927oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f12928ooOOo0oXI = 5;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f12929x0XOIxOo = 6;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f12930x0xO0oo = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12931xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12932xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("sleep_assessment", IXXIXx00I.f11690IoXIXo);
        f12919IIXOooo = oixoxx0;
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("combined_awake_score", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("awake_time_score", 1, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("awakenings_count_score", 2, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("deep_sleep_score", 3, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sleep_duration_score", 4, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("light_sleep_score", 5, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("overall_sleep_score", 6, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sleep_quality_score", 7, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sleep_recovery_score", 8, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("rem_sleep_score", 9, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sleep_restlessness_score", 10, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("awakenings_count", 11, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("interruptions_score", 14, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("average_stress_during_sleep", 15, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
    }

    public Ox0XO() {
        super(x0OxxIOxX.XO(IXXIXx00I.f11690IoXIXo));
    }

    public void IxX00(Float f) {
        X0xxXX0(15, 0, f, 65535);
    }

    public Short O00() {
        return XI0oooXX(4, 0, 65535);
    }

    public Short O0xxXxI() {
        return XI0oooXX(8, 0, 65535);
    }

    public Short OIx00oxx() {
        return XI0oooXX(5, 0, 65535);
    }

    public Short OO0() {
        return XI0oooXX(3, 0, 65535);
    }

    public void OOOI(Short sh) {
        X0xxXX0(6, 0, sh, 65535);
    }

    public Short OX() {
        return XI0oooXX(1, 0, 65535);
    }

    public Short OooI() {
        return XI0oooXX(14, 0, 65535);
    }

    public void OxO(Short sh) {
        X0xxXX0(7, 0, sh, 65535);
    }

    public void OxXXx0X(Short sh) {
        X0xxXX0(5, 0, sh, 65535);
    }

    public Float Oxx() {
        return XX(15, 0, 65535);
    }

    public void X0O0I0(Short sh) {
        X0xxXX0(4, 0, sh, 65535);
    }

    public void XO0o(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    public Short XoIxOXIXo() {
        return XI0oooXX(0, 0, 65535);
    }

    public Short o0IXXIx() {
        return XI0oooXX(2, 0, 65535);
    }

    public void o0Xo(Short sh) {
        X0xxXX0(10, 0, sh, 65535);
    }

    public void o0oxo0oI(Short sh) {
        X0xxXX0(9, 0, sh, 65535);
    }

    public void oX0I0O(Short sh) {
        X0xxXX0(11, 0, sh, 65535);
    }

    public void oX0ooo0I0(Short sh) {
        X0xxXX0(3, 0, sh, 65535);
    }

    public Short oXIoO() {
        return XI0oooXX(11, 0, 65535);
    }

    public void oo00(Short sh) {
        X0xxXX0(14, 0, sh, 65535);
    }

    public Short oxOXxoXII() {
        return XI0oooXX(10, 0, 65535);
    }

    public void x00IOx(Short sh) {
        X0xxXX0(2, 0, sh, 65535);
    }

    public Short xIXX() {
        return XI0oooXX(6, 0, 65535);
    }

    public Short xOOxIO() {
        return XI0oooXX(7, 0, 65535);
    }

    public void xX(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public void xxx00(Short sh) {
        X0xxXX0(8, 0, sh, 65535);
    }

    public Short xxxI() {
        return XI0oooXX(9, 0, 65535);
    }

    public Ox0XO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
