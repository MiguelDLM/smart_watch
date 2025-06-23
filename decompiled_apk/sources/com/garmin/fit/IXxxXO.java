package com.garmin.fit;

import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class IXxxXO extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11922II0XooXoX = 253;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f11923IXxxXO = 9;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f11924OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f11925Oo = 8;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f11926Oxx0xo = 10;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final oIXoXx0 f11927oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f11928oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f11929oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f11930ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f11931x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f11932x0xO0oo = 7;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11933xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11934xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("aviation_attitude", 178);
        f11927oI0IIXIo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp_ms", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("system_time", 1, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, Profile.Type.UINT32));
        Profile.Type type2 = Profile.Type.SINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("pitch", 2, 131, 10430.38d, XIXIX.OOXIXo.f3760XO, "radians", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("roll", 3, 131, 10430.38d, XIXIX.OOXIXo.f3760XO, "radians", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("accel_lateral", 4, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "m/s^2", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("accel_normal", 5, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "m/s^2", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("turn_rate", 6, 131, 1024.0d, XIXIX.OOXIXo.f3760XO, "radians/second", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("stage", 7, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.ATTITUDE_STAGE));
        oixoxx0.xxIXOIIO(new X0xII0I("attitude_stage_complete", 8, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "%", false, Profile.Type.UINT8));
        oixoxx0.xxIXOIIO(new X0xII0I(ARPScriptEnvironment.KEY_DATA_PIP_TRACK, 9, 132, 10430.38d, XIXIX.OOXIXo.f3760XO, "radians", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("validity", 10, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.ATTITUDE_VALIDITY));
    }

    public IXxxXO() {
        super(x0OxxIOxX.XO(178));
    }

    public void IIOIX(int i, Float f) {
        X0xxXX0(6, i, f, 65535);
    }

    public int IxX00() {
        return oOoIIO0(6, 65535);
    }

    public int O00() {
        return oOoIIO0(3, 65535);
    }

    public int O0xxXxI() {
        return oOoIIO0(1, 65535);
    }

    public int OIx00oxx() {
        return oOoIIO0(5, 65535);
    }

    public Short[] OO0() {
        return xoO0xx0(8, 65535);
    }

    public void OOIXx0x(int i, Short sh) {
        X0xxXX0(8, i, sh, 65535);
    }

    public Long OOOI(int i) {
        return x0xO(1, i, 65535);
    }

    public Integer OOxOI(int i) {
        return oX(10, i, 65535);
    }

    public Float[] OX() {
        return xo0x(4, 65535);
    }

    public void OXXoIoXI(int i, Float f) {
        X0xxXX0(4, i, f, 65535);
    }

    public int OooI() {
        return oOoIIO0(4, 65535);
    }

    public Float OxO(int i) {
        return XX(9, i, 65535);
    }

    public AttitudeStage[] OxXXx0X() {
        Short[] xoO0xx02 = xoO0xx0(7, 65535);
        AttitudeStage[] attitudeStageArr = new AttitudeStage[xoO0xx02.length];
        for (int i = 0; i < xoO0xx02.length; i++) {
            attitudeStageArr[i] = AttitudeStage.getByValue(xoO0xx02[i]);
        }
        return attitudeStageArr;
    }

    public Float Oxx(int i) {
        return XX(4, i, 65535);
    }

    public Float[] X00xOoXI() {
        return xo0x(6, 65535);
    }

    public Integer X0O0I0() {
        return oX(0, 0, 65535);
    }

    public Integer[] XO00XOO() {
        return xoxXI(10, 65535);
    }

    public int XO0o() {
        return oOoIIO0(10, 65535);
    }

    public void Xo(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public Short XoIxOXIXo(int i) {
        return XI0oooXX(8, i, 65535);
    }

    public void XoOxI0ox(int i, Integer num) {
        X0xxXX0(10, i, num, 65535);
    }

    public void XooIO0oo0(int i, Float f) {
        X0xxXX0(5, i, f, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float[] o0IXXIx() {
        return xo0x(5, 65535);
    }

    public Float o0Xo(int i) {
        return XX(6, i, 65535);
    }

    public Long[] o0oxo0oI() {
        return XX0xXo(1, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Float oX0I0O(int i) {
        return XX(2, i, 65535);
    }

    public Float[] oX0ooo0I0() {
        return xo0x(3, 65535);
    }

    public Float oXIoO(int i) {
        return XX(5, i, 65535);
    }

    public void oXO0oOx0(int i, Float f) {
        X0xxXX0(9, i, f, 65535);
    }

    public void oXxx000(int i, Float f) {
        X0xxXX0(3, i, f, 65535);
    }

    public AttitudeStage oo00(int i) {
        Short XI0oooXX2 = XI0oooXX(7, i, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return AttitudeStage.getByValue(XI0oooXX2);
    }

    public int oxOXxoXII() {
        return oOoIIO0(9, 65535);
    }

    public Float[] x00IOx() {
        return xo0x(2, 65535);
    }

    public int xIXX() {
        return oOoIIO0(8, 65535);
    }

    public void xIx(int i, Long l) {
        X0xxXX0(1, i, l, 65535);
    }

    public void xIx0XO(int i, Float f) {
        X0xxXX0(2, i, f, 65535);
    }

    public void xOOxI(int i, AttitudeStage attitudeStage) {
        X0xxXX0(7, i, Short.valueOf(attitudeStage.value), 65535);
    }

    public int xOOxIO() {
        return oOoIIO0(7, 65535);
    }

    public Float xX(int i) {
        return XX(3, i, 65535);
    }

    public Float[] xxx00() {
        return xo0x(9, 65535);
    }

    public int xxxI() {
        return oOoIIO0(2, 65535);
    }

    public IXxxXO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
