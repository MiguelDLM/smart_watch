package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class XIo0oOXIx extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f13851II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f13852OOXIXo = 3;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f13853oO = 8;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f13854oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f13855ooOOo0oXI = 5;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f13856x0XOIxOo = 6;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final oIXoXx0 f13857x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f13858xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f13859xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("course_point", 32);
        f13857x0xO0oo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 1, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.SINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("position_lat", 2, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("position_long", 3, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15470o00, 4, 134, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, Profile.Type.UINT32));
        oixoxx0.xxIXOIIO(new X0xII0I("type", 5, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.COURSE_POINT));
        oixoxx0.xxIXOIIO(new X0xII0I("name", 6, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
        oixoxx0.xxIXOIIO(new X0xII0I("favorite", 8, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BOOL));
    }

    public XIo0oOXIx() {
        super(x0OxxIOxX.XO(32));
    }

    public void O00(Integer num) {
        X0xxXX0(2, 0, num, 65535);
    }

    public void O0xxXxI(CoursePoint coursePoint) {
        X0xxXX0(5, 0, Short.valueOf(coursePoint.value), 65535);
    }

    public void OIx00oxx(Bool bool) {
        X0xxXX0(8, 0, Short.valueOf(bool.value), 65535);
    }

    public CoursePoint OO0() {
        Short XI0oooXX2 = XI0oooXX(5, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return CoursePoint.getByValue(XI0oooXX2);
    }

    public Bool OX() {
        Short XI0oooXX2 = XI0oooXX(8, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void OooI(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public Float Oxx() {
        return XX(4, 0, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(3, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(1, 0, 65535));
    }

    public Integer o0IXXIx() {
        return oX(2, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(1, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Integer oXIoO() {
        return oX(254, 0, 65535);
    }

    @Override // com.garmin.fit.oIXoXx0
    public String x0OIX00oO() {
        return XIXIX(6, 0, 65535);
    }

    public void xIXX(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void xOOxIO(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public void xxxI(String str) {
        X0xxXX0(6, 0, str, 65535);
    }

    public XIo0oOXIx(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
