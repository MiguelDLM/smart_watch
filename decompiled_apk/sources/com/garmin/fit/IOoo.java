package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class IOoo extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11651II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f11652OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f11653oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final oIXoXx0 f11654ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11655xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11656xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("field_capabilities", 39);
        f11654ooOOo0oXI = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("file", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.FILE));
        oixoxx0.xxIXOIIO(new X0xII0I("mesg_num", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESG_NUM));
        oixoxx0.xxIXOIIO(new X0xII0I("field_num", 2, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
        oixoxx0.xxIXOIIO(new X0xII0I("count", 3, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
    }

    public IOoo() {
        super(x0OxxIOxX.XO(39));
    }

    public void OIx00oxx(File file) {
        X0xxXX0(0, 0, Short.valueOf(file.value), 65535);
    }

    public void OO0(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public Short OX() {
        return XI0oooXX(2, 0, 65535);
    }

    public void OooI(Short sh) {
        X0xxXX0(2, 0, sh, 65535);
    }

    public Integer Oxx() {
        return oX(3, 0, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(254, 0, 65535);
    }

    public Integer o0IXXIx() {
        return oX(1, 0, 65535);
    }

    public File oXIoO() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return File.getByValue(XI0oooXX2);
    }

    public void xIXX(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public void xxxI(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public IOoo(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
