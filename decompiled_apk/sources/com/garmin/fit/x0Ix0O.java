package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class x0Ix0O extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15162II0XooXoX = 253;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final oIXoXx0 f15163IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f15164IXxxXO = 10;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15165OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f15166Oo = 9;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f15167Oxx0xo = 11;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f15168OxxIIOOXO = 13;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f15169oI0IIXIo = 12;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f15170oO = 7;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15171oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15172ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15173x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f15174x0xO0oo = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15175xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15176xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("weight_scale", 30);
        f15163IIXOooo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("weight", 0, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "kg", false, Profile.Type.WEIGHT));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("percent_fat", 1, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("percent_hydration", 2, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("visceral_fat_mass", 3, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "kg", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("bone_mass", 4, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "kg", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("muscle_mass", 5, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "kg", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("basal_met", 7, 132, 4.0d, XIXIX.OOXIXo.f3760XO, "kcal/day", false, type));
        Profile.Type type2 = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("physique_rating", 8, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("active_met", 9, 132, 4.0d, XIXIX.OOXIXo.f3760XO, "kcal/day", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("metabolic_age", 10, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "years", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("visceral_fat_rating", 11, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("user_profile_index", 12, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("bmi", 13, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "kg/m^2", false, type));
    }

    public x0Ix0O() {
        super(x0OxxIOxX.XO(30));
    }

    public void IxX00(Float f) {
        X0xxXX0(7, 0, f, 65535);
    }

    public Float O00() {
        return XX(3, 0, 65535);
    }

    public Float O0xxXxI() {
        return XX(0, 0, 65535);
    }

    public Float OIx00oxx() {
        return XX(2, 0, 65535);
    }

    public Float OO0() {
        return XX(5, 0, 65535);
    }

    public void OOOI(Integer num) {
        X0xxXX0(12, 0, num, 65535);
    }

    public Float OX() {
        return XX(7, 0, 65535);
    }

    public Float OooI() {
        return XX(1, 0, 65535);
    }

    public void OxO(Float f) {
        X0xxXX0(0, 0, f, 65535);
    }

    public void OxXXx0X(Short sh) {
        X0xxXX0(8, 0, sh, 65535);
    }

    public Float Oxx() {
        return XX(9, 0, 65535);
    }

    public void X0O0I0(Short sh) {
        X0xxXX0(11, 0, sh, 65535);
    }

    public void XO0o(Float f) {
        X0xxXX0(13, 0, f, 65535);
    }

    public Short XoIxOXIXo() {
        return XI0oooXX(10, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float o0IXXIx() {
        return XX(4, 0, 65535);
    }

    public void o0oxo0oI(Float f) {
        X0xxXX0(3, 0, f, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oX0I0O(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public void oX0ooo0I0(Float f) {
        X0xxXX0(1, 0, f, 65535);
    }

    public Float oXIoO() {
        return XX(13, 0, 65535);
    }

    public void oo00(Float f) {
        X0xxXX0(2, 0, f, 65535);
    }

    public void oxOXxoXII(Float f) {
        X0xxXX0(9, 0, f, 65535);
    }

    public void x00IOx(Short sh) {
        X0xxXX0(10, 0, sh, 65535);
    }

    public Short xIXX() {
        return XI0oooXX(8, 0, 65535);
    }

    public Short xOOxIO() {
        return XI0oooXX(11, 0, 65535);
    }

    public void xX(Float f) {
        X0xxXX0(5, 0, f, 65535);
    }

    public Integer xxxI() {
        return oX(12, 0, 65535);
    }

    public x0Ix0O(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
