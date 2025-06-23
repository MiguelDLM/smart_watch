package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class X00IxOx extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f13503II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f13504OOXIXo = 3;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f13505oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f13506ooOOo0oXI = 5;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final oIXoXx0 f13507x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f13508xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f13509xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("monitoring_info", 103);
        f13507x0XOIxOo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("local_timestamp", 0, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.LOCAL_DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("activity_type", 1, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.ACTIVITY_TYPE));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("cycles_to_distance", 3, 132, 5000.0d, XIXIX.OOXIXo.f3760XO, "m/cycle", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("cycles_to_calories", 4, 132, 5000.0d, XIXIX.OOXIXo.f3760XO, "kcal/cycle", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("resting_metabolic_rate", 5, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "kcal / day", false, type));
    }

    public X00IxOx() {
        super(x0OxxIOxX.XO(103));
    }

    public void IxX00(Long l) {
        X0xxXX0(0, 0, l, 65535);
    }

    public Integer O00() {
        return oX(5, 0, 65535);
    }

    public void O0xxXxI(int i, Float f) {
        X0xxXX0(4, i, f, 65535);
    }

    public int OIx00oxx() {
        return oOoIIO0(1, 65535);
    }

    public Float[] OO0() {
        return xo0x(3, 65535);
    }

    public ActivityType[] OX() {
        Short[] xoO0xx02 = xoO0xx0(1, 65535);
        ActivityType[] activityTypeArr = new ActivityType[xoO0xx02.length];
        for (int i = 0; i < xoO0xx02.length; i++) {
            activityTypeArr[i] = ActivityType.getByValue(xoO0xx02[i]);
        }
        return activityTypeArr;
    }

    public Long OooI() {
        return x0xO(0, 0, 65535);
    }

    public ActivityType Oxx(int i) {
        Short XI0oooXX2 = XI0oooXX(1, i, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return ActivityType.getByValue(XI0oooXX2);
    }

    public void XO0o(Integer num) {
        X0xxXX0(5, 0, num, 65535);
    }

    public Float XoIxOXIXo(int i) {
        return XX(3, i, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float[] o0IXXIx() {
        return xo0x(4, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Float oXIoO(int i) {
        return XX(4, i, 65535);
    }

    public void oxOXxoXII(int i, Float f) {
        X0xxXX0(3, i, f, 65535);
    }

    public int xIXX() {
        return oOoIIO0(4, 65535);
    }

    public void xOOxIO(int i, ActivityType activityType) {
        X0xxXX0(1, i, Short.valueOf(activityType.value), 65535);
    }

    public int xxxI() {
        return oOoIIO0(3, 65535);
    }

    public X00IxOx(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
