package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class IOOoXo0Ix extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11614II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f11615OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11616xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11617xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("hsa_configuration_data", IXXIXx00I.f11755oXxOI0oIx);
        f11615OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("data", 0, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BYTE));
        oixoxx0.xxIXOIIO(new X0xII0I("data_size", 1, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
    }

    public IOOoXo0Ix() {
        super(x0OxxIOxX.XO(IXXIXx00I.f11755oXxOI0oIx));
    }

    public void OO0(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    public Byte[] OX() {
        return oo0xXOI0I(0, 65535);
    }

    public Byte Oxx(int i) {
        return XxX0x0xxx(0, i, 65535);
    }

    public void XoIxOXIXo(int i, Byte b) {
        X0xxXX0(0, i, b, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public int o0IXXIx() {
        return oOoIIO0(0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Short oXIoO() {
        return XI0oooXX(1, 0, 65535);
    }

    public IOOoXo0Ix(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
