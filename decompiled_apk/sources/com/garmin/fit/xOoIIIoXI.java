package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xOoIIIoXI extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15432II0XooXoX = 253;

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final int f15433IIX0o = 31;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f15434IIXOooo = 14;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f15435IXxxXO = 9;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f15436O0xOxO = 24;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15437OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f15438Oo = 8;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f15439OxI = 19;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f15440Oxx0xo = 10;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f15441OxxIIOOXO = 12;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f15442X0IIOO = 25;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f15443XI0IXoo = 26;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f15444XIxXXX0x0 = 27;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final int f15445XxX0x0xxx = 29;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f15446o00 = 16;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f15447oI0IIXIo = 11;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f15448oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15449oOoXoXO = 3;

    /* renamed from: oo, reason: collision with root package name */
    public static final oIXoXx0 f15450oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static final int f15451oo0xXOI0I = 34;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15452ooOOo0oXI = 4;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final int f15453ooXIXxIX = 32;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15454x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f15455x0xO0oo = 7;

    /* renamed from: xI, reason: collision with root package name */
    public static final int f15456xI = 33;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final int f15457xXxxox0I = 30;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15458xoIox = 1;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f15459xoXoI = 15;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15460xxIXOIIO = 0;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f15461xxX = 28;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("monitoring", 55);
        f15450oo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("device_index", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DEVICE_INDEX));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("calories", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "kcal", false, type));
        Profile.Type type2 = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15470o00, 2, 134, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15473xoXoI, 3, 134, 2.0d, XIXIX.OOXIXo.f3760XO, xOxOoo.f15473xoXoI, false, type2));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("steps", 134, 1.0d, XIXIX.OOXIXo.f3760XO, "steps"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(0).II0xO0(5, 6L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(0).II0xO0(5, 1L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("strokes", 134, 2.0d, XIXIX.OOXIXo.f3760XO, "strokes"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(1).II0xO0(5, 2L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(1).II0xO0(5, 5L);
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15466X0IIOO, 4, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("activity_type", 5, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.ACTIVITY_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("activity_subtype", 6, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.ACTIVITY_SUBTYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("activity_level", 7, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.ACTIVITY_LEVEL));
        oixoxx0.xxIXOIIO(new X0xII0I("distance_16", 8, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "100 * m", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("cycles_16", 9, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "2 * cycles (steps)", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("active_time_16", 10, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("local_timestamp", 11, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.LOCAL_DATE_TIME));
        Profile.Type type3 = Profile.Type.SINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("temperature", 12, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "C", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("temperature_min", 14, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "C", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("temperature_max", 15, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "C", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("activity_time", 16, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "minutes", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15465OxI, 19, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "kcal", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("current_activity_type_intensity", 24, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BYTE));
        oixoxx0.f14429oxoX.get(18).f13537xoIox.add(new oXX0IoI(5, false, 5, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(18).f13537xoIox.add(new oXX0IoI(28, false, 3, 1.0d, XIXIX.OOXIXo.f3760XO));
        Profile.Type type4 = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp_min_8", 25, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "min", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp_16", 26, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("heart_rate", 27, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15467XI0IXoo, 28, 2, 10.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("duration_min", 29, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "min", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("duration", 30, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15469XxX0x0xxx, 31, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15472xXxxox0I, 32, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15462IIX0o, 33, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "minutes", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15471ooXIXxIX, 34, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "minutes", false, type));
    }

    public xOoIIIoXI() {
        super(x0OxxIOxX.XO(55));
    }

    public void IIOIX(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public void IOOoXo0Ix(Short sh) {
        X0xxXX0(27, 0, sh, 65535);
    }

    public void Ix0(Integer num) {
        X0xxXX0(33, 0, num, 65535);
    }

    public void IxIo(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public Short IxX00() {
        return XI0oooXX(0, 0, 65535);
    }

    public Byte O00() {
        return XxX0x0xxx(24, 0, 65535);
    }

    public void O0OOX0IIx(Integer num) {
        X0xxXX0(26, 0, num, 65535);
    }

    public Integer O0xxXxI() {
        return oX(9, 0, 65535);
    }

    public ActivityType OIx00oxx() {
        Short XI0oooXX2 = XI0oooXX(5, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return ActivityType.getByValue(XI0oooXX2);
    }

    public void OIxx0I0(Integer num) {
        X0xxXX0(34, 0, num, 65535);
    }

    public Integer OO0(int i) {
        return oX(16, i, 65535);
    }

    public void OOIXx0x(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public Integer OOOI() {
        return oX(33, 0, 65535);
    }

    public Integer OOxOI() {
        return oX(26, 0, 65535);
    }

    public Float OX() {
        return XX(4, 0, 65535);
    }

    public Integer OXXoIoXI() {
        return oX(34, 0, 65535);
    }

    public Integer[] OooI() {
        return xoxXI(16, 65535);
    }

    public Float OxO() {
        return XX(3, 0, 1);
    }

    public Long OxXXx0X() {
        return x0xO(11, 0, 65535);
    }

    public void Oxo00O(Long l) {
        X0xxXX0(11, 0, l, 65535);
    }

    public Integer Oxx() {
        return oX(19, 0, 65535);
    }

    public Float X00xOoXI() {
        return XX(14, 0, 65535);
    }

    public void X0IOOI(Float f) {
        X0xxXX0(28, 0, f, 65535);
    }

    public Long X0O0I0() {
        return x0xO(3, 0, 0);
    }

    public void X0ooXIooI(Float f) {
        X0xxXX0(3, 0, f, 65535);
    }

    public Short XO00XOO() {
        return XI0oooXX(25, 0, 65535);
    }

    public Float XO0o() {
        return XX(2, 0, 65535);
    }

    public void XOxoX(Integer num) {
        X0xxXX0(8, 0, num, 65535);
    }

    public void Xo(ActivityType activityType) {
        X0xxXX0(5, 0, Short.valueOf(activityType.value), 65535);
    }

    public ActivitySubtype XoIxOXIXo() {
        Short XI0oooXX2 = XI0oooXX(6, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return ActivitySubtype.getByValue(XI0oooXX2);
    }

    public void XoOxI0ox(Byte b) {
        X0xxXX0(24, 0, b, 65535);
    }

    public void XooIO0oo0(Integer num) {
        X0xxXX0(19, 0, num, 65535);
    }

    public void XxIo(Float f) {
        X0xxXX0(12, 0, f, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public ActivityLevel o0IXXIx() {
        Short XI0oooXX2 = XI0oooXX(7, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return ActivityLevel.getByValue(XI0oooXX2);
    }

    public Float o0Xo() {
        return XX(15, 0, 65535);
    }

    public int o0oxo0oI() {
        return oOoIIO0(16, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oX000x(Integer num) {
        X0xxXX0(9, 0, num, 65535);
    }

    public Integer oX0I0O() {
        return oX(8, 0, 65535);
    }

    public Short oX0ooo0I0() {
        return XI0oooXX(27, 0, 65535);
    }

    public Integer oXIoO() {
        return oX(10, 0, 65535);
    }

    public void oXO0oOx0(Float f) {
        X0xxXX0(31, 0, f, 65535);
    }

    public void oXxx000(ActivityLevel activityLevel) {
        X0xxXX0(7, 0, Short.valueOf(activityLevel.value), 65535);
    }

    public Float oo00() {
        return XX(28, 0, 65535);
    }

    public void oo0oIXo(Float f) {
        X0xxXX0(14, 0, f, 65535);
    }

    public void oxIO0IIo(Float f) {
        X0xxXX0(15, 0, f, 65535);
    }

    public Float oxOXxoXII() {
        return XX(32, 0, 65535);
    }

    public Long x00IOx() {
        return x0xO(30, 0, 65535);
    }

    public void x0oxIIIX(Float f) {
        X0xxXX0(2, 0, f, 65535);
    }

    public void xIOXX(Float f) {
        X0xxXX0(32, 0, f, 65535);
    }

    public void xIXIOX(Long l) {
        X0xxXX0(30, 0, l, 65535);
    }

    public Float xIXX() {
        return XX(31, 0, 65535);
    }

    public void xIx(int i, Integer num) {
        X0xxXX0(16, i, num, 65535);
    }

    public void xIx0XO(Integer num) {
        X0xxXX0(10, 0, num, 65535);
    }

    public void xIxooxXX(Float f) {
        X0xxXX0(3, 0, f, 1);
    }

    public void xOOxI(ActivitySubtype activitySubtype) {
        X0xxXX0(6, 0, Short.valueOf(activitySubtype.value), 65535);
    }

    public Float xOOxIO() {
        return XX(3, 0, 65535);
    }

    public Integer xX() {
        return oX(29, 0, 65535);
    }

    public void xo(Integer num) {
        X0xxXX0(29, 0, num, 65535);
    }

    public void xoX(Short sh) {
        X0xxXX0(25, 0, sh, 65535);
    }

    public void xox(Long l) {
        X0xxXX0(3, 0, l, 0);
    }

    public Float xxx00() {
        return XX(12, 0, 65535);
    }

    public Integer xxxI() {
        return oX(1, 0, 65535);
    }

    public xOoIIIoXI(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
