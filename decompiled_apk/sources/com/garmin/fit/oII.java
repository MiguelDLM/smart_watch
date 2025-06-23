package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class oII extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14398II0XooXoX = 253;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f14399IIXOooo = 13;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f14400IXxxXO = 9;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14401OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f14402Oo = 8;

    /* renamed from: OxI, reason: collision with root package name */
    public static final oIXoXx0 f14403OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f14404Oxx0xo = 10;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f14405OxxIIOOXO = 12;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f14406o00 = 15;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f14407oI0IIXIo = 11;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f14408oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14409oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14410ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14411x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f14412x0xO0oo = 7;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14413xoIox = 1;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f14414xoXoI = 14;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14415xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("time_in_zone", 216);
        f14403OxI = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("reference_mesg", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESG_NUM));
        oixoxx0.xxIXOIIO(new X0xII0I("reference_index", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        Profile.Type type = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_hr_zone", 2, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_speed_zone", 3, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_cadence_zone", 4, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_power_zone", 5, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        Profile.Type type2 = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("hr_zone_high_boundary", 6, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type2));
        Profile.Type type3 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("speed_zone_high_boundary", 7, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("cadence_zone_high_bondary", 8, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("power_zone_high_boundary", 9, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("hr_calc_type", 10, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.HR_ZONE_CALC));
        oixoxx0.xxIXOIIO(new X0xII0I("max_heart_rate", 11, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("resting_heart_rate", 12, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("threshold_heart_rate", 13, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("pwr_calc_type", 14, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.PWR_ZONE_CALC));
        oixoxx0.xxIXOIIO(new X0xII0I("functional_threshold_power", 15, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
    }

    public oII() {
        super(x0OxxIOxX.XO(216));
    }

    public void IIOIX(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public void IxIo(int i, Float f) {
        X0xxXX0(2, i, f, 65535);
    }

    public int IxX00() {
        return oOoIIO0(3, 65535);
    }

    public int O00() {
        return oOoIIO0(7, 65535);
    }

    public int O0xxXxI() {
        return oOoIIO0(2, 65535);
    }

    public int OIx00oxx() {
        return oOoIIO0(8, 65535);
    }

    public Short[] OO0() {
        return xoO0xx0(6, 65535);
    }

    public void OOIXx0x(Integer num) {
        X0xxXX0(15, 0, num, 65535);
    }

    public Float[] OOOI() {
        return xo0x(7, 65535);
    }

    public Float[] OOxOI() {
        return xo0x(5, 65535);
    }

    public Short[] OX() {
        return xoO0xx0(8, 65535);
    }

    public Float[] OXXoIoXI() {
        return xo0x(3, 65535);
    }

    public Short OooI() {
        return XI0oooXX(11, 0, 65535);
    }

    public Float[] OxO() {
        return xo0x(4, 65535);
    }

    public Float OxXXx0X(int i) {
        return XX(7, i, 65535);
    }

    public Short Oxx(int i) {
        return XI0oooXX(8, i, 65535);
    }

    public Float X00xOoXI(int i) {
        return XX(5, i, 65535);
    }

    public Float X0O0I0(int i) {
        return XX(4, i, 65535);
    }

    public void X0ooXIooI(int i, Float f) {
        X0xxXX0(7, i, f, 65535);
    }

    public Float XO00XOO(int i) {
        return XX(3, i, 65535);
    }

    public Integer XO0o(int i) {
        return oX(9, i, 65535);
    }

    public void XOxoX(int i, Float f) {
        X0xxXX0(3, i, f, 65535);
    }

    public void Xo(PwrZoneCalc pwrZoneCalc) {
        X0xxXX0(14, 0, Short.valueOf(pwrZoneCalc.value), 65535);
    }

    public Short XoIxOXIXo(int i) {
        return XI0oooXX(6, i, 65535);
    }

    public void XoOxI0ox(Short sh) {
        X0xxXX0(12, 0, sh, 65535);
    }

    public void XooIO0oo0(int i, Short sh) {
        X0xxXX0(8, i, sh, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public HrZoneCalc o0IXXIx() {
        Short XI0oooXX2 = XI0oooXX(10, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return HrZoneCalc.getByValue(XI0oooXX2);
    }

    public Float[] o0Xo() {
        return xo0x(2, 65535);
    }

    public Short o0oxo0oI() {
        return XI0oooXX(13, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oX000x(Short sh) {
        X0xxXX0(13, 0, sh, 65535);
    }

    public Integer[] oX0I0O() {
        return xoxXI(9, 65535);
    }

    public Integer oX0ooo0I0() {
        return oX(0, 0, 65535);
    }

    public Integer oXIoO() {
        return oX(15, 0, 65535);
    }

    public void oXO0oOx0(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public void oXxx000(int i, Short sh) {
        X0xxXX0(6, i, sh, 65535);
    }

    public Short oo00() {
        return XI0oooXX(12, 0, 65535);
    }

    public int oxOXxoXII() {
        return oOoIIO0(5, 65535);
    }

    public PwrZoneCalc x00IOx() {
        Short XI0oooXX2 = XI0oooXX(14, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return PwrZoneCalc.getByValue(XI0oooXX2);
    }

    public void x0oxIIIX(int i, Float f) {
        X0xxXX0(5, i, f, 65535);
    }

    public void xIOXX(int i, Float f) {
        X0xxXX0(4, i, f, 65535);
    }

    public int xIXX() {
        return oOoIIO0(6, 65535);
    }

    public void xIx(int i, Integer num) {
        X0xxXX0(9, i, num, 65535);
    }

    public void xIx0XO(HrZoneCalc hrZoneCalc) {
        X0xxXX0(10, 0, Short.valueOf(hrZoneCalc.value), 65535);
    }

    public void xOOxI(Short sh) {
        X0xxXX0(11, 0, sh, 65535);
    }

    public int xOOxIO() {
        return oOoIIO0(4, 65535);
    }

    public Integer xX() {
        return oX(1, 0, 65535);
    }

    public Float xxx00(int i) {
        return XX(2, i, 65535);
    }

    public int xxxI() {
        return oOoIIO0(9, 65535);
    }

    public oII(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
