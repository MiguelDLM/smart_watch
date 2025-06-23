package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class XIXIxO extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f13827II0XooXoX = 253;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f13828IIXOooo = 13;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f13829IXxxXO = 9;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f13830O0xOxO = 17;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f13831OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f13832Oo = 8;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f13833OxI = 16;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f13834Oxx0xo = 10;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f13835OxxIIOOXO = 12;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f13836X0IIOO = 22;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f13837XI0IXoo = 23;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f13838XIxXXX0x0 = 24;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final oIXoXx0 f13839XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f13840o00 = 15;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f13841oI0IIXIo = 11;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f13842oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f13843oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f13844ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f13845x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f13846x0xO0oo = 7;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f13847xoIox = 1;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f13848xoXoI = 14;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f13849xxIXOIIO = 0;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f13850xxX = 25;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("dive_summary", 268);
        f13839XxX0x0xxx = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("reference_mesg", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESG_NUM));
        oixoxx0.xxIXOIIO(new X0xII0I("reference_index", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        Profile.Type type = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("avg_depth", 2, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("max_depth", 3, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("surface_interval", 4, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        Profile.Type type2 = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("start_cns", 5, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("end_cns", 6, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type2));
        Profile.Type type3 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("start_n2", 7, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("end_n2", 8, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("o2_toxicity", 9, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "OTUs", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("dive_number", 10, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("bottom_time", 11, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_pressure_sac", 12, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "bar/min", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_volume_sac", 13, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "L/min", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_rmv", 14, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "L/min", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("descent_time", 15, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("ascent_time", 16, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_ascent_rate", 17, 133, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, Profile.Type.SINT32));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_descent_rate", 22, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("max_ascent_rate", 23, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("max_descent_rate", 24, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("hang_time", 25, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
    }

    public XIXIxO() {
        super(x0OxxIOxX.XO(268));
    }

    public void IIOIX(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public Float IxX00() {
        return XX(3, 0, 65535);
    }

    public Short O00() {
        return XI0oooXX(6, 0, 65535);
    }

    public Float O0xxXxI() {
        return XX(25, 0, 65535);
    }

    public Float OIx00oxx() {
        return XX(11, 0, 65535);
    }

    public Float OO0() {
        return XX(14, 0, 65535);
    }

    public void OOIXx0x(Integer num) {
        X0xxXX0(8, 0, num, 65535);
    }

    public void OOOI(Float f) {
        X0xxXX0(16, 0, f, 65535);
    }

    public void OOxOI(Float f) {
        X0xxXX0(11, 0, f, 65535);
    }

    public Float OX() {
        return XX(17, 0, 65535);
    }

    public void OXXoIoXI(Long l) {
        X0xxXX0(10, 0, l, 65535);
    }

    public Float OooI() {
        return XX(13, 0, 65535);
    }

    public void OxO(Float f) {
        X0xxXX0(22, 0, f, 65535);
    }

    public Long OxXXx0X() {
        return x0xO(4, 0, 65535);
    }

    public Float Oxx() {
        return XX(16, 0, 65535);
    }

    public void X00xOoXI(Float f) {
        X0xxXX0(13, 0, f, 65535);
    }

    public void X0O0I0(Float f) {
        X0xxXX0(2, 0, f, 65535);
    }

    public void X0ooXIooI(Integer num) {
        X0xxXX0(7, 0, num, 65535);
    }

    public void XO00XOO(Float f) {
        X0xxXX0(15, 0, f, 65535);
    }

    public Float XO0o() {
        return XX(24, 0, 65535);
    }

    public void Xo(Integer num) {
        X0xxXX0(9, 0, num, 65535);
    }

    public Float XoIxOXIXo() {
        return XX(12, 0, 65535);
    }

    public void XoOxI0ox(Short sh) {
        X0xxXX0(5, 0, sh, 65535);
    }

    public void XooIO0oo0(Short sh) {
        X0xxXX0(6, 0, sh, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float o0IXXIx() {
        return XX(22, 0, 65535);
    }

    public void o0Xo(Float f) {
        X0xxXX0(14, 0, f, 65535);
    }

    public void o0oxo0oI(Float f) {
        X0xxXX0(17, 0, f, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oX000x(Long l) {
        X0xxXX0(4, 0, l, 65535);
    }

    public Integer oX0I0O() {
        return oX(9, 0, 65535);
    }

    public Short oX0ooo0I0() {
        return XI0oooXX(5, 0, 65535);
    }

    public Float oXIoO() {
        return XX(2, 0, 65535);
    }

    public void oXO0oOx0(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public void oXxx000(Float f) {
        X0xxXX0(23, 0, f, 65535);
    }

    public Integer oo00() {
        return oX(7, 0, 65535);
    }

    public Float oxOXxoXII() {
        return XX(23, 0, 65535);
    }

    public Integer x00IOx() {
        return oX(1, 0, 65535);
    }

    public Float xIXX() {
        return XX(15, 0, 65535);
    }

    public void xIx(Float f) {
        X0xxXX0(24, 0, f, 65535);
    }

    public void xIx0XO(Float f) {
        X0xxXX0(25, 0, f, 65535);
    }

    public void xOOxI(Float f) {
        X0xxXX0(3, 0, f, 65535);
    }

    public Integer xOOxIO() {
        return oX(8, 0, 65535);
    }

    public Integer xX() {
        return oX(0, 0, 65535);
    }

    public void xxx00(Float f) {
        X0xxXX0(12, 0, f, 65535);
    }

    public Long xxxI() {
        return x0xO(10, 0, 65535);
    }

    public XIXIxO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
