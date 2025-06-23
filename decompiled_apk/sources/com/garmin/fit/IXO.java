package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class IXO extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11657II0XooXoX = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f11658OOXIXo = 3;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f11659oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f11660ooOOo0oXI = 5;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final oIXoXx0 f11661x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11662xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11663xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("exd_data_field_configuration", 201);
        f11661x0XOIxOo = oixoxx0;
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("screen_index", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("concept_field", 1, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BYTE));
        oixoxx0.f14429oxoX.get(1).f13537xoIox.add(new oXX0IoI(2, false, 4, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(1).f13537xoIox.add(new oXX0IoI(3, false, 4, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("field_id", 2, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("concept_count", 3, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("display_type", 4, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EXD_DISPLAY_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("title", 5, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
    }

    public IXO() {
        super(x0OxxIOxX.XO(201));
    }

    public void O00(ExdDisplayType exdDisplayType) {
        X0xxXX0(4, 0, Short.valueOf(exdDisplayType.value), 65535);
    }

    public void O0xxXxI(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public String[] OIx00oxx() {
        return xOoOIoI(5, 65535);
    }

    public Short OO0() {
        return XI0oooXX(0, 0, 65535);
    }

    public Byte OX() {
        return XxX0x0xxx(1, 0, 65535);
    }

    public String OooI(int i) {
        return XIXIX(5, i, 65535);
    }

    public Short Oxx() {
        return XI0oooXX(3, 0, 65535);
    }

    public int XoIxOXIXo() {
        return oOoIIO0(5, 65535);
    }

    public Short o0IXXIx() {
        return XI0oooXX(2, 0, 65535);
    }

    public ExdDisplayType oXIoO() {
        Short XI0oooXX2 = XI0oooXX(4, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return ExdDisplayType.getByValue(XI0oooXX2);
    }

    public void oxOXxoXII(int i, String str) {
        X0xxXX0(5, i, str, 65535);
    }

    public void xIXX(Short sh) {
        X0xxXX0(3, 0, sh, 65535);
    }

    public void xOOxIO(Short sh) {
        X0xxXX0(2, 0, sh, 65535);
    }

    public void xxxI(Byte b) {
        X0xxXX0(1, 0, b, 65535);
    }

    public IXO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
