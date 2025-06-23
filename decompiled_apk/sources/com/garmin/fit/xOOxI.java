package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xOOxI extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15397II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15398OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15399oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final oIXoXx0 f15400ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15401xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15402xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("hrm_profile", 4);
        f15400ooOOo0oXI = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        Profile.Type type = Profile.Type.BOOL;
        oixoxx0.xxIXOIIO(new X0xII0I("enabled", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("hrm_ant_id", 1, 139, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16Z));
        oixoxx0.xxIXOIIO(new X0xII0I("log_hrv", 2, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("hrm_ant_id_trans_type", 3, 10, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8Z));
    }

    public xOOxI() {
        super(x0OxxIOxX.XO(4));
    }

    public void OIx00oxx(Short sh) {
        X0xxXX0(3, 0, sh, 65535);
    }

    public void OO0(Bool bool) {
        X0xxXX0(0, 0, Short.valueOf(bool.value), 65535);
    }

    public Integer OX() {
        return oX(1, 0, 65535);
    }

    public void OooI(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public Bool Oxx() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public Integer XoIxOXIXo() {
        return oX(254, 0, 65535);
    }

    public Bool o0IXXIx() {
        Short XI0oooXX2 = XI0oooXX(2, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public Short oXIoO() {
        return XI0oooXX(3, 0, 65535);
    }

    public void xIXX(Bool bool) {
        X0xxXX0(2, 0, Short.valueOf(bool.value), 65535);
    }

    public void xxxI(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public xOOxI(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
