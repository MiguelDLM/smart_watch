package com.garmin.fit;

import com.baidu.ar.constants.HttpConstants;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class II0XooXoX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11410II0XooXoX = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f11411OOXIXo = 3;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f11412oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final oIXoXx0 f11413ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11414xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11415xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("ant_channel_id", 82);
        f11413ooOOo0oXI = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("channel_number", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
        Profile.Type type = Profile.Type.UINT8Z;
        oixoxx0.xxIXOIIO(new X0xII0I(HttpConstants.DEVICE_TYPE, 1, 10, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("device_number", 2, 139, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16Z));
        oixoxx0.xxIXOIIO(new X0xII0I("transmission_type", 3, 10, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("device_index", 4, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DEVICE_INDEX));
    }

    public II0XooXoX() {
        super(x0OxxIOxX.XO(82));
    }

    public void OIx00oxx(Integer num) {
        X0xxXX0(2, 0, num, 65535);
    }

    public void OO0(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public Short OX() {
        return XI0oooXX(4, 0, 65535);
    }

    public void OooI(Short sh) {
        X0xxXX0(4, 0, sh, 65535);
    }

    public Short Oxx() {
        return XI0oooXX(0, 0, 65535);
    }

    public Short XoIxOXIXo() {
        return XI0oooXX(3, 0, 65535);
    }

    public Short o0IXXIx() {
        return XI0oooXX(1, 0, 65535);
    }

    public Integer oXIoO() {
        return oX(2, 0, 65535);
    }

    public void xIXX(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    public void xxxI(Short sh) {
        X0xxXX0(3, 0, sh, 65535);
    }

    public II0XooXoX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
