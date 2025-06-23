package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xOxxXO extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15512II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15513OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final oIXoXx0 f15514Oo;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f15515oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15516oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15517ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15518x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f15519x0xO0oo = 7;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15520xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15521xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("obdii_data", 174);
        f15514Oo = oixoxx0;
        Profile.Type type = Profile.Type.DATE_TIME;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        Profile.Type type2 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp_ms", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("time_offset", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type2));
        Profile.Type type3 = Profile.Type.BYTE;
        oixoxx0.xxIXOIIO(new X0xII0I("pid", 2, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("raw_data", 3, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("pid_data_size", 4, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
        oixoxx0.xxIXOIIO(new X0xII0I("system_time", 5, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT32));
        oixoxx0.xxIXOIIO(new X0xII0I("start_timestamp", 6, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("start_timestamp_ms", 7, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type2));
    }

    public xOxxXO() {
        super(x0OxxIOxX.XO(174));
    }

    public Integer[] IxX00() {
        return xoxXI(1, 65535);
    }

    public Integer O00() {
        return oX(7, 0, 65535);
    }

    public Long[] O0xxXxI() {
        return XX0xXo(5, 65535);
    }

    public Byte OIx00oxx(int i) {
        return XxX0x0xxx(3, i, 65535);
    }

    public Short OO0(int i) {
        return XI0oooXX(4, i, 65535);
    }

    public void OOOI(int i, Integer num) {
        X0xxXX0(1, i, num, 65535);
    }

    public int OX() {
        return oOoIIO0(3, 65535);
    }

    public Short[] OooI() {
        return xoO0xx0(4, 65535);
    }

    public void OxXXx0X(int i, Long l) {
        X0xxXX0(5, i, l, 65535);
    }

    public int Oxx() {
        return oOoIIO0(4, 65535);
    }

    public Integer XO0o() {
        return oX(0, 0, 65535);
    }

    public Byte XoIxOXIXo() {
        return XxX0x0xxx(2, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public int o0IXXIx() {
        return oOoIIO0(1, 65535);
    }

    public void o0oxo0oI(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oX0I0O(Byte b) {
        X0xxXX0(2, 0, b, 65535);
    }

    public void oX0ooo0I0(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(6, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public int oXIoO() {
        return oOoIIO0(5, 65535);
    }

    public void oo00(Integer num) {
        X0xxXX0(7, 0, num, 65535);
    }

    public Integer oxOXxoXII(int i) {
        return oX(1, i, 65535);
    }

    public void x00IOx(int i, Short sh) {
        X0xxXX0(4, i, sh, 65535);
    }

    public Byte[] xIXX() {
        return oo0xXOI0I(3, 65535);
    }

    public Long xOOxIO(int i) {
        return x0xO(5, i, 65535);
    }

    public void xX(int i, Byte b) {
        X0xxXX0(3, i, b, 65535);
    }

    public o0xxxXXxX xxxI() {
        return oXX0IoI(x0xO(6, 0, 65535));
    }

    public xOxxXO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
