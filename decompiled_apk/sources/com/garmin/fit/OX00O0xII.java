package com.garmin.fit;

import androidx.exifinterface.media.ExifInterface;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class OX00O0xII extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12626II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12627OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12628oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final oIXoXx0 f12629ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12630xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12631xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("device_aux_battery_info", IXXIXx00I.f11766x0);
        f12629ooOOo0oXI = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("device_index", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DEVICE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("battery_voltage", 1, 132, 256.0d, XIXIX.OOXIXo.f3760XO, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("battery_status", 2, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BATTERY_STATUS));
        oixoxx0.xxIXOIIO(new X0xII0I("battery_identifier", 3, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
    }

    public OX00O0xII() {
        super(x0OxxIOxX.XO(IXXIXx00I.f11766x0));
    }

    public void OIx00oxx(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public void OO0(Short sh) {
        X0xxXX0(2, 0, sh, 65535);
    }

    public Short OX() {
        return XI0oooXX(2, 0, 65535);
    }

    public void OooI(Float f) {
        X0xxXX0(1, 0, f, 65535);
    }

    public Short Oxx() {
        return XI0oooXX(3, 0, 65535);
    }

    public void XoIxOXIXo(Short sh) {
        X0xxXX0(3, 0, sh, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Short o0IXXIx() {
        return XI0oooXX(0, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Float oXIoO() {
        return XX(1, 0, 65535);
    }

    public OX00O0xII(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
