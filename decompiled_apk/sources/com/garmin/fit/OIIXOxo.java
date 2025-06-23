package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class OIIXOxo extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12476II0XooXoX = 250;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12477OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12478oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f12479ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final oIXoXx0 f12480x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12481xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12482xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("memo_glob", 145);
        f12480x0XOIxOo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("part_index", 250, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT32));
        oixoxx0.xxIXOIIO(new X0xII0I("memo", 0, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BYTE));
        oixoxx0.xxIXOIIO(new X0xII0I("mesg_num", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESG_NUM));
        oixoxx0.xxIXOIIO(new X0xII0I("parent_index", 2, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("field_num", 3, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
        oixoxx0.xxIXOIIO(new X0xII0I("data", 4, 10, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8Z));
    }

    public OIIXOxo() {
        super(x0OxxIOxX.XO(145));
    }

    public void IxX00(Integer num) {
        X0xxXX0(2, 0, num, 65535);
    }

    public void O00(int i, Short sh) {
        X0xxXX0(4, i, sh, 65535);
    }

    public void O0xxXxI(int i, Byte b) {
        X0xxXX0(0, i, b, 65535);
    }

    public int OIx00oxx() {
        return oOoIIO0(0, 65535);
    }

    public Integer OO0() {
        return oX(1, 0, 65535);
    }

    public Short[] OX() {
        return xoO0xx0(4, 65535);
    }

    public int OooI() {
        return oOoIIO0(4, 65535);
    }

    public Short Oxx(int i) {
        return XI0oooXX(4, i, 65535);
    }

    public void XO0o(Long l) {
        X0xxXX0(250, 0, l, 65535);
    }

    public Byte[] XoIxOXIXo() {
        return oo0xXOI0I(0, 65535);
    }

    public Byte o0IXXIx(int i) {
        return XxX0x0xxx(0, i, 65535);
    }

    public Short oXIoO() {
        return XI0oooXX(3, 0, 65535);
    }

    public void oxOXxoXII(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public Integer xIXX() {
        return oX(2, 0, 65535);
    }

    public void xOOxIO(Short sh) {
        X0xxXX0(3, 0, sh, 65535);
    }

    public Long xxxI() {
        return x0xO(250, 0, 65535);
    }

    public OIIXOxo(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
