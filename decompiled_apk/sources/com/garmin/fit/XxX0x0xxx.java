package com.garmin.fit;

import com.garmin.fit.Profile;
import com.sma.smartv3.ble.ProductManager;

/* loaded from: classes9.dex */
public class XxX0x0xxx extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14166II0XooXoX = 253;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f14167IXxxXO = 9;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14168OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f14169Oo = 8;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final oIXoXx0 f14170Oxx0xo;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f14171oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14172oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14173ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14174x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f14175x0xO0oo = 7;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14176xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14177xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0(ProductManager.xxI0XIO, 51);
        f14170Oxx0xo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("systolic_pressure", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "mmHg", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("diastolic_pressure", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "mmHg", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("mean_arterial_pressure", 2, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "mmHg", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("map_3_sample_mean", 3, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "mmHg", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("map_morning_values", 4, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "mmHg", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("map_evening_values", 5, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "mmHg", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("heart_rate", 6, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, Profile.Type.UINT8));
        oixoxx0.xxIXOIIO(new X0xII0I("heart_rate_type", 7, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.HR_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("status", 8, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BP_STATUS));
        oixoxx0.xxIXOIIO(new X0xII0I("user_profile_index", 9, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
    }

    public XxX0x0xxx() {
        super(x0OxxIOxX.XO(51));
    }

    public void IxX00(Integer num) {
        X0xxXX0(5, 0, num, 65535);
    }

    public void O00(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public void O0xxXxI(HrType hrType) {
        X0xxXX0(7, 0, Short.valueOf(hrType.value), 65535);
    }

    public BpStatus OIx00oxx() {
        Short XI0oooXX2 = XI0oooXX(8, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return BpStatus.getByValue(XI0oooXX2);
    }

    public Integer OO0() {
        return oX(4, 0, 65535);
    }

    public Short OX() {
        return XI0oooXX(6, 0, 65535);
    }

    public Integer OooI() {
        return oX(2, 0, 65535);
    }

    public Integer Oxx() {
        return oX(1, 0, 65535);
    }

    public void XO0o(Integer num) {
        X0xxXX0(4, 0, num, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(5, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Integer o0IXXIx() {
        return oX(3, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oX0I0O(Integer num) {
        X0xxXX0(2, 0, num, 65535);
    }

    public void oX0ooo0I0(Integer num) {
        X0xxXX0(9, 0, num, 65535);
    }

    public HrType oXIoO() {
        Short XI0oooXX2 = XI0oooXX(7, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return HrType.getByValue(XI0oooXX2);
    }

    public void oxOXxoXII(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public void x00IOx(BpStatus bpStatus) {
        X0xxXX0(8, 0, Short.valueOf(bpStatus.value), 65535);
    }

    public Integer xIXX() {
        return oX(0, 0, 65535);
    }

    public void xOOxIO(Short sh) {
        X0xxXX0(6, 0, sh, 65535);
    }

    public void xX(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public Integer xxxI() {
        return oX(9, 0, 65535);
    }

    public XxX0x0xxx(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
