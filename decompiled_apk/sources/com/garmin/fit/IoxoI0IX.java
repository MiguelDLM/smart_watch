package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class IoxoI0IX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12219II0XooXoX = 1;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12220OOXIXo = 5;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12221oOoXoXO = 7;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final oIXoXx0 f12222ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12223xoIox = 3;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12224xxIXOIIO = 2;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("zones_target", 7);
        f12222ooOOo0oXI = oixoxx0;
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("max_heart_rate", 1, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("threshold_heart_rate", 2, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("functional_threshold_power", 3, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("hr_calc_type", 5, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.HR_ZONE_CALC));
        oixoxx0.xxIXOIIO(new X0xII0I("pwr_calc_type", 7, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.PWR_ZONE_CALC));
    }

    public IoxoI0IX() {
        super(x0OxxIOxX.XO(7));
    }

    public void OIx00oxx(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    public void OO0(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public HrZoneCalc OX() {
        Short XI0oooXX2 = XI0oooXX(5, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return HrZoneCalc.getByValue(XI0oooXX2);
    }

    public void OooI(HrZoneCalc hrZoneCalc) {
        X0xxXX0(5, 0, Short.valueOf(hrZoneCalc.value), 65535);
    }

    public Integer Oxx() {
        return oX(3, 0, 65535);
    }

    public Short XoIxOXIXo() {
        return XI0oooXX(2, 0, 65535);
    }

    public PwrZoneCalc o0IXXIx() {
        Short XI0oooXX2 = XI0oooXX(7, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return PwrZoneCalc.getByValue(XI0oooXX2);
    }

    public Short oXIoO() {
        return XI0oooXX(1, 0, 65535);
    }

    public void xIXX(PwrZoneCalc pwrZoneCalc) {
        X0xxXX0(7, 0, Short.valueOf(pwrZoneCalc.value), 65535);
    }

    public void xxxI(Short sh) {
        X0xxXX0(2, 0, sh, 65535);
    }

    public IoxoI0IX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
