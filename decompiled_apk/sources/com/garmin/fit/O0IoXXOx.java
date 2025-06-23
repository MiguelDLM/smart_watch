package com.garmin.fit;

import com.baidu.ar.constants.HttpConstants;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class O0IoXXOx extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12343II0XooXoX = 0;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final oIXoXx0 f12344xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12345xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("slave_device", 106);
        f12344xoIox = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I(HttpConstants.HTTP_MANUFACTURER, 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MANUFACTURER));
        oixoxx0.xxIXOIIO(new X0xII0I("product", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.f14429oxoX.get(1).f13530OOXIXo.add(new xxOoXO("favero_product", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(1).f13530OOXIXo.get(0).II0xO0(0, 263L);
        oixoxx0.f14429oxoX.get(1).f13530OOXIXo.add(new xxOoXO("garmin_product", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(1).f13530OOXIXo.get(1).II0xO0(0, 1L);
        oixoxx0.f14429oxoX.get(1).f13530OOXIXo.get(1).II0xO0(0, 15L);
        oixoxx0.f14429oxoX.get(1).f13530OOXIXo.get(1).II0xO0(0, 13L);
        oixoxx0.f14429oxoX.get(1).f13530OOXIXo.get(1).II0xO0(0, 89L);
    }

    public O0IoXXOx() {
        super(x0OxxIOxX.XO(106));
    }

    public void OIx00oxx(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public void OO0(Integer num) {
        X0xxXX0(1, 0, num, 1);
    }

    public Integer OX() {
        return oX(1, 0, 1);
    }

    public void OooI(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public Integer Oxx() {
        return oX(1, 0, 0);
    }

    public void XoIxOXIXo(Integer num) {
        X0xxXX0(1, 0, num, 0);
    }

    public Integer o0IXXIx() {
        return oX(1, 0, 65535);
    }

    public Integer oXIoO() {
        return oX(0, 0, 65535);
    }

    public O0IoXXOx(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
