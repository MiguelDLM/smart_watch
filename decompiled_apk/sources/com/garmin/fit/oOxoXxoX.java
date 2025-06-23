package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class oOxoXxoX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14656II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f14657OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14658xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14659xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("video_description", 186);
        f14657OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("message_count", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("text", 1, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
    }

    public oOxoXxoX() {
        super(x0OxxIOxX.XO(186));
    }

    public void OO0(String str) {
        X0xxXX0(1, 0, str, 65535);
    }

    public Integer OX() {
        return oX(254, 0, 65535);
    }

    public Integer Oxx() {
        return oX(0, 0, 65535);
    }

    public void XoIxOXIXo(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void o0IXXIx(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public String oXIoO() {
        return XIXIX(1, 0, 65535);
    }

    public oOxoXxoX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
