package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class IxIX0I extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12276II0XooXoX = 0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f12277IXxxXO = 11;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12278OOXIXo = 3;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f12279Oo = 10;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final oIXoXx0 f12280Oxx0xo;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f12281oO = 8;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12282oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f12283ooOOo0oXI = 5;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f12284x0XOIxOo = 6;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f12285x0xO0oo = 9;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12286xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12287xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("exd_data_concept_configuration", 202);
        f12280Oxx0xo = oixoxx0;
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("screen_index", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("concept_field", 1, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BYTE));
        oixoxx0.f14429oxoX.get(1).f13537xoIox.add(new oXX0IoI(2, false, 4, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(1).f13537xoIox.add(new oXX0IoI(3, false, 4, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("field_id", 2, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("concept_index", 3, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("data_page", 4, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("concept_key", 5, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("scaling", 6, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("data_units", 8, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EXD_DATA_UNITS));
        oixoxx0.xxIXOIIO(new X0xII0I("qualifier", 9, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EXD_QUALIFIERS));
        oixoxx0.xxIXOIIO(new X0xII0I("descriptor", 10, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EXD_DESCRIPTORS));
        oixoxx0.xxIXOIIO(new X0xII0I("is_signed", 11, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BOOL));
    }

    public IxIX0I() {
        super(x0OxxIOxX.XO(202));
    }

    public void IxX00(Short sh) {
        X0xxXX0(4, 0, sh, 65535);
    }

    public Short O00() {
        return XI0oooXX(0, 0, 65535);
    }

    public void O0xxXxI(Short sh) {
        X0xxXX0(3, 0, sh, 65535);
    }

    public Bool OIx00oxx() {
        Short XI0oooXX2 = XI0oooXX(11, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public ExdDescriptors OO0() {
        Short XI0oooXX2 = XI0oooXX(10, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return ExdDescriptors.getByValue(XI0oooXX2);
    }

    public Short OX() {
        return XI0oooXX(3, 0, 65535);
    }

    public Short OooI() {
        return XI0oooXX(2, 0, 65535);
    }

    public void OxXXx0X(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public Byte Oxx() {
        return XxX0x0xxx(1, 0, 65535);
    }

    public void XO0o(ExdDataUnits exdDataUnits) {
        X0xxXX0(8, 0, Short.valueOf(exdDataUnits.value), 65535);
    }

    public ExdDataUnits XoIxOXIXo() {
        Short XI0oooXX2 = XI0oooXX(8, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return ExdDataUnits.getByValue(XI0oooXX2);
    }

    public Short o0IXXIx() {
        return XI0oooXX(4, 0, 65535);
    }

    public void oX0I0O(ExdDescriptors exdDescriptors) {
        X0xxXX0(10, 0, Short.valueOf(exdDescriptors.value), 65535);
    }

    public void oX0ooo0I0(ExdQualifiers exdQualifiers) {
        X0xxXX0(9, 0, Short.valueOf(exdQualifiers.value), 65535);
    }

    public Short oXIoO() {
        return XI0oooXX(5, 0, 65535);
    }

    public void oo00(Short sh) {
        X0xxXX0(6, 0, sh, 65535);
    }

    public void oxOXxoXII(Short sh) {
        X0xxXX0(5, 0, sh, 65535);
    }

    public void x00IOx(Short sh) {
        X0xxXX0(2, 0, sh, 65535);
    }

    public ExdQualifiers xIXX() {
        Short XI0oooXX2 = XI0oooXX(9, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return ExdQualifiers.getByValue(XI0oooXX2);
    }

    public void xOOxIO(Byte b) {
        X0xxXX0(1, 0, b, 65535);
    }

    public void xX(Bool bool) {
        X0xxXX0(11, 0, Short.valueOf(bool.value), 65535);
    }

    public Short xxxI() {
        return XI0oooXX(6, 0, 65535);
    }

    public IxIX0I(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
