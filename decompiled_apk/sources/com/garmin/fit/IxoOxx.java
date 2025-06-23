package com.garmin.fit;

import com.baidu.ar.constants.HttpConstants;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class IxoOxx extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12315II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12316OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12317oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f12318ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final oIXoXx0 f12319x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12320xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12321xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("training_file", 72);
        f12319x0XOIxOo = oixoxx0;
        Profile.Type type = Profile.Type.DATE_TIME;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("type", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.FILE));
        oixoxx0.xxIXOIIO(new X0xII0I(HttpConstants.HTTP_MANUFACTURER, 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MANUFACTURER));
        oixoxx0.xxIXOIIO(new X0xII0I("product", 2, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.f14429oxoX.get(3).f13530OOXIXo.add(new xxOoXO("favero_product", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(3).f13530OOXIXo.get(0).II0xO0(1, 263L);
        oixoxx0.f14429oxoX.get(3).f13530OOXIXo.add(new xxOoXO("garmin_product", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(3).f13530OOXIXo.get(1).II0xO0(1, 1L);
        oixoxx0.f14429oxoX.get(3).f13530OOXIXo.get(1).II0xO0(1, 15L);
        oixoxx0.f14429oxoX.get(3).f13530OOXIXo.get(1).II0xO0(1, 13L);
        oixoxx0.f14429oxoX.get(3).f13530OOXIXo.get(1).II0xO0(1, 89L);
        oixoxx0.xxIXOIIO(new X0xII0I("serial_number", 3, 140, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT32Z));
        oixoxx0.xxIXOIIO(new X0xII0I("time_created", 4, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
    }

    public IxoOxx() {
        super(x0OxxIOxX.XO(72));
    }

    public void O00(Integer num) {
        X0xxXX0(2, 0, num, 65535);
    }

    public void O0xxXxI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(4, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void OIx00oxx(Integer num) {
        X0xxXX0(2, 0, num, 0);
    }

    public o0xxxXXxX OO0() {
        return oXX0IoI(x0xO(4, 0, 65535));
    }

    public Integer OX() {
        return oX(2, 0, 1);
    }

    public File OooI() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return File.getByValue(XI0oooXX2);
    }

    public Integer Oxx() {
        return oX(2, 0, 0);
    }

    public Long XoIxOXIXo() {
        return x0xO(3, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Integer o0IXXIx() {
        return oX(2, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Integer oXIoO() {
        return oX(1, 0, 65535);
    }

    public void oxOXxoXII(File file) {
        X0xxXX0(0, 0, Short.valueOf(file.value), 65535);
    }

    public void xIXX(Integer num) {
        X0xxXX0(2, 0, num, 1);
    }

    public void xOOxIO(Long l) {
        X0xxXX0(3, 0, l, 65535);
    }

    public void xxxI(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public IxoOxx(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
