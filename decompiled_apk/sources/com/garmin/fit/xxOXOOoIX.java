package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xxOXOOoIX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15693II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15694OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final oIXoXx0 f15695oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15696xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15697xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("exercise_title", 264);
        f15695oOoXoXO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("exercise_category", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EXERCISE_CATEGORY));
        oixoxx0.xxIXOIIO(new X0xII0I("exercise_name", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("wkt_step_name", 2, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
    }

    public xxOXOOoIX() {
        super(x0OxxIOxX.XO(264));
    }

    public void OIx00oxx(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public String[] OO0() {
        return xOoOIoI(2, 65535);
    }

    public Integer OX() {
        return oX(1, 0, 65535);
    }

    public void OooI(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public Integer Oxx() {
        return oX(0, 0, 65535);
    }

    public String XoIxOXIXo(int i) {
        return XIXIX(2, i, 65535);
    }

    public int o0IXXIx() {
        return oOoIIO0(2, 65535);
    }

    public Integer oXIoO() {
        return oX(254, 0, 65535);
    }

    public void xIXX(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void xxxI(int i, String str) {
        X0xxXX0(2, i, str, 65535);
    }

    public xxOXOOoIX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
