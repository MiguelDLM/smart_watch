package com.garmin.fit;

import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class IIX0 extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11416II0XooXoX = 254;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f11417IXxxXO = 9;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f11418OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f11419Oo = 8;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f11420Oxx0xo = 10;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final oIXoXx0 f11421OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f11422oI0IIXIo = 11;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f11423oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f11424oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f11425ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f11426x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f11427x0xO0oo = 7;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11428xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11429xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("dive_alarm", 262);
        f11421OxxIIOOXO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        Profile.Type type = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("depth", 0, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m", false, type));
        Profile.Type type2 = Profile.Type.SINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("time", 1, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type2));
        Profile.Type type3 = Profile.Type.BOOL;
        oixoxx0.xxIXOIIO(new X0xII0I("enabled", 2, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("alarm_type", 3, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DIVE_ALARM_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("sound", 4, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.TONE));
        oixoxx0.xxIXOIIO(new X0xII0I("dive_types", 5, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SUB_SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("id", 6, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("popup_enabled", 7, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("trigger_on_descent", 8, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("trigger_on_ascent", 9, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("repeating", 10, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I(RouteGuideParams.RGKey.AssistInfo.Speed, 11, 133, 1000.0d, XIXIX.OOXIXo.f3760XO, "mps", false, type2));
    }

    public IIX0() {
        super(x0OxxIOxX.XO(262));
    }

    public Bool IxX00() {
        Short XI0oooXX2 = XI0oooXX(8, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public Tone O00() {
        Short XI0oooXX2 = XI0oooXX(4, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Tone.getByValue(XI0oooXX2);
    }

    public Integer O0xxXxI() {
        return oX(1, 0, 65535);
    }

    public int OIx00oxx() {
        return oOoIIO0(5, 65535);
    }

    public Long OO0() {
        return x0xO(6, 0, 65535);
    }

    public void OOOI(Bool bool) {
        X0xxXX0(10, 0, Short.valueOf(bool.value), 65535);
    }

    public Float OX() {
        return XX(0, 0, 65535);
    }

    public Integer OooI() {
        return oX(254, 0, 65535);
    }

    public void OxO(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public void OxXXx0X(Bool bool) {
        X0xxXX0(7, 0, Short.valueOf(bool.value), 65535);
    }

    public DiveAlarmType Oxx() {
        Short XI0oooXX2 = XI0oooXX(3, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DiveAlarmType.getByValue(XI0oooXX2);
    }

    public void X0O0I0(Float f) {
        X0xxXX0(11, 0, f, 65535);
    }

    public void XO0o(DiveAlarmType diveAlarmType) {
        X0xxXX0(3, 0, Short.valueOf(diveAlarmType.value), 65535);
    }

    public Bool XoIxOXIXo() {
        Short XI0oooXX2 = XI0oooXX(2, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public SubSport[] o0IXXIx() {
        Short[] xoO0xx02 = xoO0xx0(5, 65535);
        SubSport[] subSportArr = new SubSport[xoO0xx02.length];
        for (int i = 0; i < xoO0xx02.length; i++) {
            subSportArr[i] = SubSport.getByValue(xoO0xx02[i]);
        }
        return subSportArr;
    }

    public void o0Xo(Bool bool) {
        X0xxXX0(8, 0, Short.valueOf(bool.value), 65535);
    }

    public void o0oxo0oI(Tone tone) {
        X0xxXX0(4, 0, Short.valueOf(tone.value), 65535);
    }

    public void oX0I0O(Float f) {
        X0xxXX0(0, 0, f, 65535);
    }

    public void oX0ooo0I0(Long l) {
        X0xxXX0(6, 0, l, 65535);
    }

    public SubSport oXIoO(int i) {
        Short XI0oooXX2 = XI0oooXX(5, i, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SubSport.getByValue(XI0oooXX2);
    }

    public void oo00(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public Bool oxOXxoXII() {
        Short XI0oooXX2 = XI0oooXX(9, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void x00IOx(int i, SubSport subSport) {
        X0xxXX0(5, i, Short.valueOf(subSport.value), 65535);
    }

    public Bool xIXX() {
        Short XI0oooXX2 = XI0oooXX(7, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public Float xOOxIO() {
        return XX(11, 0, 65535);
    }

    public void xX(Bool bool) {
        X0xxXX0(2, 0, Short.valueOf(bool.value), 65535);
    }

    public void xxx00(Bool bool) {
        X0xxXX0(9, 0, Short.valueOf(bool.value), 65535);
    }

    public Bool xxxI() {
        Short XI0oooXX2 = XI0oooXX(10, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public IIX0(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
