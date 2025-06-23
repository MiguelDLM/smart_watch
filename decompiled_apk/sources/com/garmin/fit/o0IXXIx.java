package com.garmin.fit;

import com.garmin.fit.Profile;
import com.huawei.openalliance.ad.constant.bn;

/* loaded from: classes9.dex */
public class o0IXXIx extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14254II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14255OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14256oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14257ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final oIXoXx0 f14258x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14259xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14260xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("file_capabilities", 37);
        f14258x0XOIxOo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("type", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.FILE));
        oixoxx0.xxIXOIIO(new X0xII0I(bn.f.y, 1, 10, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.FILE_FLAGS));
        oixoxx0.xxIXOIIO(new X0xII0I("directory", 2, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
        oixoxx0.xxIXOIIO(new X0xII0I("max_count", 3, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("max_size", 4, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "bytes", false, Profile.Type.UINT32));
    }

    public o0IXXIx() {
        super(x0OxxIOxX.XO(37));
    }

    public void O00(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void OIx00oxx(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    public File OO0() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return File.getByValue(XI0oooXX2);
    }

    public Short OX() {
        return XI0oooXX(1, 0, 65535);
    }

    public void OooI(String str) {
        X0xxXX0(2, 0, str, 65535);
    }

    public String Oxx() {
        return XIXIX(2, 0, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(254, 0, 65535);
    }

    public Long o0IXXIx() {
        return x0xO(4, 0, 65535);
    }

    public Integer oXIoO() {
        return oX(3, 0, 65535);
    }

    public void xIXX(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public void xOOxIO(File file) {
        X0xxXX0(0, 0, Short.valueOf(file.value), 65535);
    }

    public void xxxI(Long l) {
        X0xxXX0(4, 0, l, 65535);
    }

    public o0IXXIx(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
