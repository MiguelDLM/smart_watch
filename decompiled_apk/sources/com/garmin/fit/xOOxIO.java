package com.garmin.fit;

import androidx.core.provider.FontsContractCompat;
import com.baidu.ar.constants.HttpConstants;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xOOxIO extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15403II0XooXoX = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15404OOXIXo = 3;

    /* renamed from: oO, reason: collision with root package name */
    public static final oIXoXx0 f15405oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15406oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15407ooOOo0oXI = 5;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15408x0XOIxOo = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15409xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15410xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0(FontsContractCompat.Columns.FILE_ID, 0);
        f15405oO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("type", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.FILE));
        oixoxx0.xxIXOIIO(new X0xII0I(HttpConstants.HTTP_MANUFACTURER, 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MANUFACTURER));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("product", 2, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.add(new xxOoXO("favero_product", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.get(0).II0xO0(1, 263L);
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.add(new xxOoXO("garmin_product", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.get(1).II0xO0(1, 1L);
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.get(1).II0xO0(1, 15L);
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.get(1).II0xO0(1, 13L);
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.get(1).II0xO0(1, 89L);
        oixoxx0.xxIXOIIO(new X0xII0I("serial_number", 3, 140, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT32Z));
        oixoxx0.xxIXOIIO(new X0xII0I("time_created", 4, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("number", 5, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("product_name", 8, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
    }

    public xOOxIO() {
        super(x0OxxIOxX.XO(0));
    }

    public void IxX00(String str) {
        X0xxXX0(8, 0, str, 65535);
    }

    public void O00(Integer num) {
        X0xxXX0(2, 0, num, 1);
    }

    public void O0xxXxI(Integer num) {
        X0xxXX0(5, 0, num, 65535);
    }

    public o0xxxXXxX OIx00oxx() {
        return oXX0IoI(x0xO(4, 0, 65535));
    }

    public String OO0() {
        return XIXIX(8, 0, 65535);
    }

    public Integer OX() {
        return oX(2, 0, 1);
    }

    public Long OooI() {
        return x0xO(3, 0, 65535);
    }

    public Integer Oxx() {
        return oX(2, 0, 0);
    }

    public void XO0o(Long l) {
        X0xxXX0(3, 0, l, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(2, 0, 65535);
    }

    public Integer o0IXXIx() {
        return oX(5, 0, 65535);
    }

    public void oX0I0O(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(4, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Integer oXIoO() {
        return oX(1, 0, 65535);
    }

    public void oxOXxoXII(Integer num) {
        X0xxXX0(2, 0, num, 65535);
    }

    public void x00IOx(File file) {
        X0xxXX0(0, 0, Short.valueOf(file.value), 65535);
    }

    public File xIXX() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return File.getByValue(XI0oooXX2);
    }

    public void xOOxIO(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public void xxxI(Integer num) {
        X0xxXX0(2, 0, num, 0);
    }

    public xOOxIO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
