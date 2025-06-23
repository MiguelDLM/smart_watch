package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class XI0oooXX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f13797II0XooXoX = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f13798OOXIXo = 3;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f13799oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final oIXoXx0 f13800ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f13801xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f13802xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("developer_data_id", 207);
        f13800ooOOo0oXI = oixoxx0;
        Profile.Type type = Profile.Type.BYTE;
        oixoxx0.xxIXOIIO(new X0xII0I("developer_id", 0, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("application_id", 1, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("manufacturer_id", 2, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MANUFACTURER));
        oixoxx0.xxIXOIIO(new X0xII0I("developer_data_index", 3, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
        oixoxx0.xxIXOIIO(new X0xII0I("application_version", 4, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT32));
    }

    public XI0oooXX() {
        super(x0OxxIOxX.XO(207));
    }

    public void O00(Long l) {
        X0xxXX0(4, 0, l, 65535);
    }

    public void O0xxXxI(int i, Byte b) {
        X0xxXX0(0, i, b, 65535);
    }

    public int OIx00oxx() {
        return oOoIIO0(1, 65535);
    }

    public Byte[] OO0() {
        return oo0xXOI0I(0, 65535);
    }

    public Byte[] OX() {
        return oo0xXOI0I(1, 65535);
    }

    public Integer OooI() {
        return oX(2, 0, 65535);
    }

    public Byte Oxx(int i) {
        return XxX0x0xxx(1, i, 65535);
    }

    public Byte XoIxOXIXo(int i) {
        return XxX0x0xxx(0, i, 65535);
    }

    public Short o0IXXIx() {
        return XI0oooXX(3, 0, 65535);
    }

    public Long oXIoO() {
        return x0xO(4, 0, 65535);
    }

    public void oxOXxoXII(Integer num) {
        X0xxXX0(2, 0, num, 65535);
    }

    public int xIXX() {
        return oOoIIO0(0, 65535);
    }

    public void xOOxIO(Short sh) {
        X0xxXX0(3, 0, sh, 65535);
    }

    public void xxxI(int i, Byte b) {
        X0xxXX0(1, i, b, 65535);
    }

    public XI0oooXX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
