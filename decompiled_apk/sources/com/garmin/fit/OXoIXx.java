package com.garmin.fit;

import androidx.core.app.NotificationCompat;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class OXoIXx extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12794II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12795OOXIXo = 6;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f12796oO = 15;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12797oOoXoXO = 8;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f12798ooOOo0oXI = 11;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f12799x0XOIxOo = 14;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final oIXoXx0 f12800x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12801xoIox = 5;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12802xxIXOIIO = 4;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0(NotificationCompat.CATEGORY_WORKOUT, 26);
        f12800x0xO0oo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("sport", 4, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("capabilities", 5, 140, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.WORKOUT_CAPABILITIES));
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("num_valid_steps", 6, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("wkt_name", 8, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
        oixoxx0.xxIXOIIO(new X0xII0I("sub_sport", 11, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SUB_SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("pool_length", 14, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("pool_length_unit", 15, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DISPLAY_MEASURE));
    }

    public OXoIXx() {
        super(x0OxxIOxX.XO(26));
    }

    public void IxX00(SubSport subSport) {
        X0xxXX0(11, 0, Short.valueOf(subSport.value), 65535);
    }

    public void O00(Integer num) {
        X0xxXX0(6, 0, num, 65535);
    }

    public void O0xxXxI(DisplayMeasure displayMeasure) {
        X0xxXX0(15, 0, Short.valueOf(displayMeasure.value), 65535);
    }

    public String OIx00oxx() {
        return XIXIX(8, 0, 65535);
    }

    public Sport OO0() {
        Short XI0oooXX2 = XI0oooXX(4, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Sport.getByValue(XI0oooXX2);
    }

    public Integer OX() {
        return oX(254, 0, 65535);
    }

    public SubSport OooI() {
        Short XI0oooXX2 = XI0oooXX(11, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SubSport.getByValue(XI0oooXX2);
    }

    public Long Oxx() {
        return x0xO(5, 0, 65535);
    }

    public void XO0o(String str) {
        X0xxXX0(8, 0, str, 65535);
    }

    public DisplayMeasure XoIxOXIXo() {
        Short XI0oooXX2 = XI0oooXX(15, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayMeasure.getByValue(XI0oooXX2);
    }

    public Float o0IXXIx() {
        return XX(14, 0, 65535);
    }

    public Integer oXIoO() {
        return oX(6, 0, 65535);
    }

    public void oxOXxoXII(Sport sport) {
        X0xxXX0(4, 0, Short.valueOf(sport.value), 65535);
    }

    public void xIXX(Long l) {
        X0xxXX0(5, 0, l, 65535);
    }

    public void xOOxIO(Float f) {
        X0xxXX0(14, 0, f, 65535);
    }

    public void xxxI(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public OXoIXx(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
