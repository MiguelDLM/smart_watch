package com.garmin.fit;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class Oxx extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f13288II0XooXoX = 0;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final oIXoXx0 f13289IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f13290IXxxXO = 10;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f13291OOXIXo = 3;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f13292Oo = 9;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f13293Oxx0xo = 13;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f13294OxxIIOOXO = 15;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f13295oI0IIXIo = 14;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f13296oO = 7;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f13297oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f13298ooOOo0oXI = 5;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f13299x0XOIxOo = 6;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f13300x0xO0oo = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f13301xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f13302xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("field_description", 206);
        f13289IIXOooo = oixoxx0;
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("developer_data_index", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("field_definition_number", 1, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("fit_base_type_id", 2, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.FIT_BASE_TYPE));
        Profile.Type type2 = Profile.Type.STRING;
        oixoxx0.xxIXOIIO(new X0xII0I("field_name", 3, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("array", 4, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("components", 5, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("scale", 6, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I(TypedValues.CycleType.S_WAVE_OFFSET, 7, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SINT8));
        oixoxx0.xxIXOIIO(new X0xII0I("units", 8, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("bits", 9, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("accumulate", 10, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("fit_base_unit_id", 13, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.FIT_BASE_UNIT));
        oixoxx0.xxIXOIIO(new X0xII0I("native_mesg_num", 14, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESG_NUM));
        oixoxx0.xxIXOIIO(new X0xII0I("native_field_num", 15, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
    }

    public Oxx() {
        super(x0OxxIOxX.XO(206));
    }

    public Byte IxX00() {
        return XxX0x0xxx(7, 0, 65535);
    }

    public Short O00() {
        return XI0oooXX(15, 0, 65535);
    }

    public int O0xxXxI() {
        return oOoIIO0(3, 65535);
    }

    public String[] OIx00oxx() {
        return xOoOIoI(3, 65535);
    }

    public Short OO0() {
        return XI0oooXX(1, 0, 65535);
    }

    public void OOOI(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public void OOxOI(Byte b) {
        X0xxXX0(7, 0, b, 65535);
    }

    public Short OX() {
        return XI0oooXX(4, 0, 65535);
    }

    public void OXXoIoXI(int i, String str) {
        X0xxXX0(8, i, str, 65535);
    }

    public String OooI(int i) {
        return XIXIX(3, i, 65535);
    }

    public void OxO(Short sh) {
        X0xxXX0(2, 0, sh, 65535);
    }

    public void OxXXx0X(String str) {
        X0xxXX0(5, 0, str, 65535);
    }

    public String Oxx() {
        return XIXIX(10, 0, 65535);
    }

    public void X00xOoXI(Integer num) {
        X0xxXX0(14, 0, num, 65535);
    }

    public void X0O0I0(int i, String str) {
        X0xxXX0(3, i, str, 65535);
    }

    public void XO00XOO(Short sh) {
        X0xxXX0(6, 0, sh, 65535);
    }

    public Short XO0o() {
        return XI0oooXX(6, 0, 65535);
    }

    public Short XoIxOXIXo() {
        return XI0oooXX(0, 0, 65535);
    }

    public String o0IXXIx() {
        return XIXIX(5, 0, 65535);
    }

    public void o0Xo(Short sh) {
        X0xxXX0(15, 0, sh, 65535);
    }

    public void o0oxo0oI(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    public String oX0I0O(int i) {
        return XIXIX(8, i, 65535);
    }

    public void oX0ooo0I0(Short sh) {
        X0xxXX0(4, 0, sh, 65535);
    }

    public String oXIoO() {
        return XIXIX(9, 0, 65535);
    }

    public void oo00(String str) {
        X0xxXX0(9, 0, str, 65535);
    }

    public int oxOXxoXII() {
        return oOoIIO0(8, 65535);
    }

    public String[] x00IOx() {
        return xOoOIoI(8, 65535);
    }

    public Short xIXX() {
        return XI0oooXX(2, 0, 65535);
    }

    public Integer xOOxIO() {
        return oX(14, 0, 65535);
    }

    public void xX(String str) {
        X0xxXX0(10, 0, str, 65535);
    }

    public void xxx00(Integer num) {
        X0xxXX0(13, 0, num, 65535);
    }

    public Integer xxxI() {
        return oX(13, 0, 65535);
    }

    public Oxx(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
