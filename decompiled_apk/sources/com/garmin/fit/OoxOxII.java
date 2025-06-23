package com.garmin.fit;

import com.garmin.fit.Profile;
import com.sma.smartv3.network.BaiDu;

/* loaded from: classes9.dex */
public class OoxOxII extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12872II0XooXoX = 254;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f12873IXxxXO = 11;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12874OOXIXo = 4;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f12875Oo = 10;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final oIXoXx0 f12876Oxx0xo;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f12877oO = 8;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12878oOoXoXO = 5;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f12879ooOOo0oXI = 6;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f12880x0XOIxOo = 7;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f12881x0xO0oo = 9;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12882xoIox = 3;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12883xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("set", 225);
        f12876Oxx0xo = oixoxx0;
        Profile.Type type = Profile.Type.DATE_TIME;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 254, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("duration", 0, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.UINT32));
        Profile.Type type2 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("repetitions", 3, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("weight", 4, 132, 16.0d, XIXIX.OOXIXo.f3760XO, "kg", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("set_type", 5, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SET_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I(BaiDu.START_TIME, 6, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("category", 7, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EXERCISE_CATEGORY));
        oixoxx0.xxIXOIIO(new X0xII0I("category_subtype", 8, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("weight_display_unit", 9, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.FIT_BASE_UNIT));
        Profile.Type type3 = Profile.Type.MESSAGE_INDEX;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 10, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("wkt_step_index", 11, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
    }

    public OoxOxII() {
        super(x0OxxIOxX.XO(225));
    }

    public void IxX00(int i, Integer num) {
        X0xxXX0(7, i, num, 65535);
    }

    public o0xxxXXxX O00() {
        return oXX0IoI(x0xO(6, 0, 65535));
    }

    public Integer O0xxXxI() {
        return oX(9, 0, 65535);
    }

    public int OIx00oxx() {
        return oOoIIO0(8, 65535);
    }

    public Integer OO0() {
        return oX(10, 0, 65535);
    }

    public void OOOI(Integer num) {
        X0xxXX0(9, 0, num, 65535);
    }

    public Integer[] OX() {
        return xoxXI(7, 65535);
    }

    public int OooI() {
        return oOoIIO0(7, 65535);
    }

    public void OxXXx0X(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public Integer Oxx(int i) {
        return oX(7, i, 65535);
    }

    public void XO0o(int i, Integer num) {
        X0xxXX0(8, i, num, 65535);
    }

    public Float XoIxOXIXo() {
        return XX(0, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(254, 0, 65535));
    }

    public Integer[] o0IXXIx() {
        return xoxXI(8, 65535);
    }

    public void o0oxo0oI(Integer num) {
        X0xxXX0(11, 0, num, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(254, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oX0I0O(Float f) {
        X0xxXX0(0, 0, f, 65535);
    }

    public void oX0ooo0I0(Short sh) {
        X0xxXX0(5, 0, sh, 65535);
    }

    public Integer oXIoO(int i) {
        return oX(8, i, 65535);
    }

    public void oo00(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(6, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Integer oxOXxoXII() {
        return oX(11, 0, 65535);
    }

    public void x00IOx(Integer num) {
        X0xxXX0(10, 0, num, 65535);
    }

    public Integer xIXX() {
        return oX(3, 0, 65535);
    }

    public Float xOOxIO() {
        return XX(4, 0, 65535);
    }

    public void xX(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public Short xxxI() {
        return XI0oooXX(5, 0, 65535);
    }

    public OoxOxII(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
