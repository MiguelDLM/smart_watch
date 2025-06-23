package com.garmin.fit;

import com.garmin.fit.Profile;
import com.sma.smartv3.network.BaiDu;

/* loaded from: classes9.dex */
public class IIXOxIxOo extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11435II0XooXoX = 254;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f11436IIXOooo = 26;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f11437IXxxXO = 22;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f11438O0xOxO = 110;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f11439OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f11440Oo = 21;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f11441OxI = 74;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f11442Oxx0xo = 23;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f11443OxxIIOOXO = 25;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final oIXoXx0 f11444X0IIOO;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f11445o00 = 28;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f11446oI0IIXIo = 24;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f11447oO = 13;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f11448oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f11449ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f11450x0XOIxOo = 9;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f11451x0xO0oo = 14;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11452xoIox = 1;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f11453xoXoI = 27;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11454xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("split", 312);
        f11444X0IIOO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("split_type", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPLIT_TYPE));
        Profile.Type type = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("total_elapsed_time", 1, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("total_timer_time", 2, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("total_distance", 3, 134, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_speed", 4, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type));
        Profile.Type type2 = Profile.Type.DATE_TIME;
        oixoxx0.xxIXOIIO(new X0xII0I(BaiDu.START_TIME, 9, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        Profile.Type type3 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("total_ascent", 13, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("total_descent", 14, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type3));
        Profile.Type type4 = Profile.Type.SINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("start_position_lat", 21, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("start_position_long", 22, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("end_position_lat", 23, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("end_position_long", 24, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("max_speed", 25, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_vert_speed", 26, 133, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("end_time", 27, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("total_calories", 28, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "kcal", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("start_elevation", 74, 134, 5.0d, 500.0d, "m", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("total_moving_time", 110, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
    }

    public IIXOxIxOo() {
        super(x0OxxIOxX.XO(312));
    }

    public Integer IxX00() {
        return oX(14, 0, 65535);
    }

    public Integer O00() {
        return oX(22, 0, 65535);
    }

    public Integer O0xxXxI() {
        return oX(13, 0, 65535);
    }

    public SplitType OIx00oxx() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SplitType.getByValue(XI0oooXX2);
    }

    public Float OO0() {
        return XX(25, 0, 65535);
    }

    public void OOIXx0x(Integer num) {
        X0xxXX0(14, 0, num, 65535);
    }

    public void OOOI(Integer num) {
        X0xxXX0(24, 0, num, 65535);
    }

    public void OOxOI(Integer num) {
        X0xxXX0(22, 0, num, 65535);
    }

    public Float OX() {
        return XX(26, 0, 65535);
    }

    public void OXXoIoXI(Integer num) {
        X0xxXX0(13, 0, num, 65535);
    }

    public Integer OooI() {
        return oX(254, 0, 65535);
    }

    public void OxO(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void OxXXx0X(Integer num) {
        X0xxXX0(23, 0, num, 65535);
    }

    public Float Oxx() {
        return XX(4, 0, 65535);
    }

    public void X00xOoXI(Integer num) {
        X0xxXX0(21, 0, num, 65535);
    }

    public void X0O0I0(Float f) {
        X0xxXX0(25, 0, f, 65535);
    }

    public void XO00XOO(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(9, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Float XO0o() {
        return XX(3, 0, 65535);
    }

    public o0xxxXXxX XoIxOXIXo() {
        return oXX0IoI(x0xO(27, 0, 65535));
    }

    public void XooIO0oo0(Long l) {
        X0xxXX0(28, 0, l, 65535);
    }

    public Integer o0IXXIx() {
        return oX(24, 0, 65535);
    }

    public void o0Xo(Float f) {
        X0xxXX0(74, 0, f, 65535);
    }

    public void o0oxo0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(27, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Float oX0I0O() {
        return XX(1, 0, 65535);
    }

    public void oX0ooo0I0(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public Integer oXIoO() {
        return oX(23, 0, 65535);
    }

    public void oXxx000(Float f) {
        X0xxXX0(1, 0, f, 65535);
    }

    public void oo00(Float f) {
        X0xxXX0(26, 0, f, 65535);
    }

    public Long oxOXxoXII() {
        return x0xO(28, 0, 65535);
    }

    public Float x00IOx() {
        return XX(110, 0, 65535);
    }

    public Float xIXX() {
        return XX(74, 0, 65535);
    }

    public void xIx(Float f) {
        X0xxXX0(2, 0, f, 65535);
    }

    public void xIx0XO(Float f) {
        X0xxXX0(3, 0, f, 65535);
    }

    public void xOOxI(Float f) {
        X0xxXX0(110, 0, f, 65535);
    }

    public o0xxxXXxX xOOxIO() {
        return oXX0IoI(x0xO(9, 0, 65535));
    }

    public Float xX() {
        return XX(2, 0, 65535);
    }

    public void xxx00(SplitType splitType) {
        X0xxXX0(0, 0, Short.valueOf(splitType.value), 65535);
    }

    public Integer xxxI() {
        return oX(21, 0, 65535);
    }

    public IIXOxIxOo(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
