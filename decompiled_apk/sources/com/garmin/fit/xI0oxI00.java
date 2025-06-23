package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xI0oxI00 extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15328II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15329OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15330oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final oIXoXx0 f15331ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15332xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15333xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("dive_gas", 259);
        f15331ooOOo0oXI = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("helium_content", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("oxygen_content", 1, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("status", 2, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DIVE_GAS_STATUS));
        oixoxx0.xxIXOIIO(new X0xII0I("mode", 3, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DIVE_GAS_MODE));
    }

    public xI0oxI00() {
        super(x0OxxIOxX.XO(259));
    }

    public void OIx00oxx(DiveGasMode diveGasMode) {
        X0xxXX0(3, 0, Short.valueOf(diveGasMode.value), 65535);
    }

    public void OO0(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public Integer OX() {
        return oX(254, 0, 65535);
    }

    public void OooI(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public Short Oxx() {
        return XI0oooXX(0, 0, 65535);
    }

    public DiveGasStatus XoIxOXIXo() {
        Short XI0oooXX2 = XI0oooXX(2, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DiveGasStatus.getByValue(XI0oooXX2);
    }

    public Short o0IXXIx() {
        return XI0oooXX(1, 0, 65535);
    }

    public DiveGasMode oXIoO() {
        Short XI0oooXX2 = XI0oooXX(3, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DiveGasMode.getByValue(XI0oooXX2);
    }

    public void xIXX(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    public void xxxI(DiveGasStatus diveGasStatus) {
        X0xxXX0(2, 0, Short.valueOf(diveGasStatus.value), 65535);
    }

    public xI0oxI00(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
