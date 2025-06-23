package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xXXxoI extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15536II0XooXoX = 254;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final oIXoXx0 f15537IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f15538IXxxXO = 11;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15539OOXIXo = 4;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f15540Oo = 10;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f15541Oxx0xo = 12;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f15542OxxIIOOXO = 77;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f15543oI0IIXIo = 13;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f15544oO = 8;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15545oOoXoXO = 5;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15546ooOOo0oXI = 6;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15547x0XOIxOo = 7;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f15548x0xO0oo = 9;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15549xoIox = 3;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15550xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("split_summary", 313);
        f15537IIXOooo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("split_type", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPLIT_TYPE));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("num_splits", 3, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        Profile.Type type2 = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("total_timer_time", 4, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("total_distance", 5, 134, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_speed", 6, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("max_speed", 7, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("total_ascent", 8, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("total_descent", 9, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type));
        Profile.Type type3 = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("avg_heart_rate", 10, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("max_heart_rate", 11, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_vert_speed", 12, 133, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, Profile.Type.SINT32));
        oixoxx0.xxIXOIIO(new X0xII0I("total_calories", 13, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "kcal", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("total_moving_time", 77, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type2));
    }

    public xXXxoI() {
        super(x0OxxIOxX.XO(313));
    }

    public void IxX00(Short sh) {
        X0xxXX0(10, 0, sh, 65535);
    }

    public Integer O00() {
        return oX(9, 0, 65535);
    }

    public Float O0xxXxI() {
        return XX(77, 0, 65535);
    }

    public SplitType OIx00oxx() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SplitType.getByValue(XI0oooXX2);
    }

    public Integer OO0() {
        return oX(254, 0, 65535);
    }

    public void OOOI(Integer num) {
        X0xxXX0(8, 0, num, 65535);
    }

    public Float OX() {
        return XX(6, 0, 65535);
    }

    public Integer OooI() {
        return oX(3, 0, 65535);
    }

    public void OxO(Float f) {
        X0xxXX0(5, 0, f, 65535);
    }

    public void OxXXx0X(SplitType splitType) {
        X0xxXX0(0, 0, Short.valueOf(splitType.value), 65535);
    }

    public Short Oxx() {
        return XI0oooXX(10, 0, 65535);
    }

    public void X0O0I0(Integer num) {
        X0xxXX0(9, 0, num, 65535);
    }

    public void XO0o(Float f) {
        X0xxXX0(6, 0, f, 65535);
    }

    public Float XoIxOXIXo() {
        return XX(7, 0, 65535);
    }

    public Short o0IXXIx() {
        return XI0oooXX(11, 0, 65535);
    }

    public void o0Xo(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public void o0oxo0oI(Long l) {
        X0xxXX0(13, 0, l, 65535);
    }

    public void oX0I0O(Float f) {
        X0xxXX0(12, 0, f, 65535);
    }

    public void oX0ooo0I0(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public Float oXIoO() {
        return XX(12, 0, 65535);
    }

    public void oo00(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public Float oxOXxoXII() {
        return XX(4, 0, 65535);
    }

    public void x00IOx(Short sh) {
        X0xxXX0(11, 0, sh, 65535);
    }

    public Integer xIXX() {
        return oX(8, 0, 65535);
    }

    public Float xOOxIO() {
        return XX(5, 0, 65535);
    }

    public void xX(Float f) {
        X0xxXX0(7, 0, f, 65535);
    }

    public void xxx00(Float f) {
        X0xxXX0(77, 0, f, 65535);
    }

    public Long xxxI() {
        return x0xO(13, 0, 65535);
    }

    public xXXxoI(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
