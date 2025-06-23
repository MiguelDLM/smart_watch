package com.garmin.fit;

import com.baidu.ar.constants.HttpConstants;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class OXxx0OO extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12803II0XooXoX = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12804OOXIXo = 3;

    /* renamed from: oO, reason: collision with root package name */
    public static final oIXoXx0 f12805oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12806oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f12807ooOOo0oXI = 5;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f12808x0XOIxOo = 6;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12809xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12810xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("schedule", 28);
        f12805oO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I(HttpConstants.HTTP_MANUFACTURER, 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MANUFACTURER));
        oixoxx0.xxIXOIIO(new X0xII0I("product", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.f14429oxoX.get(1).f13530OOXIXo.add(new xxOoXO("favero_product", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(1).f13530OOXIXo.get(0).II0xO0(0, 263L);
        oixoxx0.f14429oxoX.get(1).f13530OOXIXo.add(new xxOoXO("garmin_product", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(1).f13530OOXIXo.get(1).II0xO0(0, 1L);
        oixoxx0.f14429oxoX.get(1).f13530OOXIXo.get(1).II0xO0(0, 15L);
        oixoxx0.f14429oxoX.get(1).f13530OOXIXo.get(1).II0xO0(0, 13L);
        oixoxx0.f14429oxoX.get(1).f13530OOXIXo.get(1).II0xO0(0, 89L);
        oixoxx0.xxIXOIIO(new X0xII0I("serial_number", 2, 140, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT32Z));
        oixoxx0.xxIXOIIO(new X0xII0I("time_created", 3, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("completed", 4, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BOOL));
        oixoxx0.xxIXOIIO(new X0xII0I("type", 5, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SCHEDULE));
        oixoxx0.xxIXOIIO(new X0xII0I("scheduled_time", 6, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.LOCAL_DATE_TIME));
    }

    public OXxx0OO() {
        super(x0OxxIOxX.XO(28));
    }

    public void IxX00(Long l) {
        X0xxXX0(6, 0, l, 65535);
    }

    public void O00(Integer num) {
        X0xxXX0(1, 0, num, 0);
    }

    public void O0xxXxI(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public o0xxxXXxX OIx00oxx() {
        return oXX0IoI(x0xO(3, 0, 65535));
    }

    public Long OO0() {
        return x0xO(6, 0, 65535);
    }

    public Integer OX() {
        return oX(1, 0, 0);
    }

    public Long OooI() {
        return x0xO(2, 0, 65535);
    }

    public Bool Oxx() {
        Short XI0oooXX2 = XI0oooXX(4, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void XO0o(Long l) {
        X0xxXX0(2, 0, l, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(1, 0, 65535);
    }

    public Integer o0IXXIx() {
        return oX(0, 0, 65535);
    }

    public void oX0I0O(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(3, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Integer oXIoO() {
        return oX(1, 0, 1);
    }

    public void oxOXxoXII(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public void x00IOx(Schedule schedule) {
        X0xxXX0(5, 0, Short.valueOf(schedule.value), 65535);
    }

    public Schedule xIXX() {
        Short XI0oooXX2 = XI0oooXX(5, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Schedule.getByValue(XI0oooXX2);
    }

    public void xOOxIO(Integer num) {
        X0xxXX0(1, 0, num, 1);
    }

    public void xxxI(Bool bool) {
        X0xxXX0(4, 0, Short.valueOf(bool.value), 65535);
    }

    public OXxx0OO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
