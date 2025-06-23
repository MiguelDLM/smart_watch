package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class OxXXx0OX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12943II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f12944OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12945xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12946xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("watchface_settings", 159);
        f12944OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("mode", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.WATCHFACE_MODE));
        oixoxx0.xxIXOIIO(new X0xII0I("layout", 1, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BYTE));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.add(new xxOoXO("digital_layout", 0, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.get(0).II0xO0(0, 0L);
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.add(new xxOoXO("analog_layout", 0, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.get(1).II0xO0(0, 1L);
    }

    public OxXXx0OX() {
        super(x0OxxIOxX.XO(159));
    }

    public void OIx00oxx(Byte b) {
        X0xxXX0(1, 0, b, 65535);
    }

    public void OO0(AnalogWatchfaceLayout analogWatchfaceLayout) {
        X0xxXX0(1, 0, Short.valueOf(analogWatchfaceLayout.value), 1);
    }

    public DigitalWatchfaceLayout OX() {
        Short XI0oooXX2 = XI0oooXX(1, 0, 0);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DigitalWatchfaceLayout.getByValue(XI0oooXX2);
    }

    public void OooI(DigitalWatchfaceLayout digitalWatchfaceLayout) {
        X0xxXX0(1, 0, Short.valueOf(digitalWatchfaceLayout.value), 0);
    }

    public AnalogWatchfaceLayout Oxx() {
        Short XI0oooXX2 = XI0oooXX(1, 0, 1);
        if (XI0oooXX2 == null) {
            return null;
        }
        return AnalogWatchfaceLayout.getByValue(XI0oooXX2);
    }

    public WatchfaceMode XoIxOXIXo() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return WatchfaceMode.getByValue(XI0oooXX2);
    }

    public Integer o0IXXIx() {
        return oX(254, 0, 65535);
    }

    public Byte oXIoO() {
        return XxX0x0xxx(1, 0, 65535);
    }

    public void xIXX(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void xxxI(WatchfaceMode watchfaceMode) {
        X0xxXX0(0, 0, Short.valueOf(watchfaceMode.value), 65535);
    }

    public OxXXx0OX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
