package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class oOo extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14609II0XooXoX = 0;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f14610IIXOooo = 58;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f14611IXxxXO = 47;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f14612O0xOxO = 89;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14613OOXIXo = 4;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f14614Oo = 46;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f14615OxI = 86;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f14616Oxx0xo = 55;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f14617OxxIIOOXO = 57;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f14618X0IIOO = 90;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f14619XI0IXoo = 94;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f14620XIxXXX0x0 = 95;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final int f14621XxX0x0xxx = 174;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f14622o00 = 80;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f14623oI0IIXIo = 56;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f14624oO = 39;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14625oOoXoXO = 5;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14626ooOOo0oXI = 12;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14627x0XOIxOo = 36;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f14628x0xO0oo = 40;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final oIXoXx0 f14629xXxxox0I;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14630xoIox = 2;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f14631xoXoI = 59;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14632xxIXOIIO = 1;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f14633xxX = 134;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("device_settings", 2);
        f14629xXxxox0I = oixoxx0;
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("active_time_zone", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        Profile.Type type2 = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("utc_offset", 1, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("time_offset", 2, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("time_mode", 4, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.TIME_MODE));
        oixoxx0.xxIXOIIO(new X0xII0I("time_zone_offset", 5, 1, 4.0d, XIXIX.OOXIXo.f3760XO, "hr", false, Profile.Type.SINT8));
        oixoxx0.xxIXOIIO(new X0xII0I("backlight_mode", 12, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BACKLIGHT_MODE));
        Profile.Type type3 = Profile.Type.BOOL;
        oixoxx0.xxIXOIIO(new X0xII0I("activity_tracker_enabled", 36, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("clock_time", 39, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        Profile.Type type4 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("pages_enabled", 40, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("move_alert_enabled", 46, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("date_mode", 47, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_MODE));
        Profile.Type type5 = Profile.Type.DISPLAY_ORIENTATION;
        oixoxx0.xxIXOIIO(new X0xII0I("display_orientation", 55, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("mounting_side", 56, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SIDE));
        oixoxx0.xxIXOIIO(new X0xII0I("default_page", 57, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("autosync_min_steps", 58, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "steps", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("autosync_min_time", 59, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "minutes", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("lactate_threshold_autodetect_enabled", 80, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("ble_auto_upload_enabled", 86, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("auto_sync_frequency", 89, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.AUTO_SYNC_FREQUENCY));
        oixoxx0.xxIXOIIO(new X0xII0I("auto_activity_detect", 90, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.AUTO_ACTIVITY_DETECT));
        oixoxx0.xxIXOIIO(new X0xII0I("number_of_screens", 94, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("smart_notification_display_orientation", 95, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("tap_interface", 134, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SWITCH));
        oixoxx0.xxIXOIIO(new X0xII0I("tap_sensitivity", 174, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.TAP_SENSITIVITY));
    }

    public oOo() {
        super(x0OxxIOxX.XO(2));
    }

    public void IIOIX(BacklightMode backlightMode) {
        X0xxXX0(12, 0, Short.valueOf(backlightMode.value), 65535);
    }

    public void IOOoXo0Ix(int i, Integer num) {
        X0xxXX0(40, i, num, 65535);
    }

    public void Ix0(TapSensitivity tapSensitivity) {
        X0xxXX0(174, 0, Short.valueOf(tapSensitivity.value), 65535);
    }

    public void IxIo(DisplayOrientation displayOrientation) {
        X0xxXX0(55, 0, Short.valueOf(displayOrientation.value), 65535);
    }

    public Side IxX00() {
        Short XI0oooXX2 = XI0oooXX(56, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Side.getByValue(XI0oooXX2);
    }

    public Integer O00(int i) {
        return oX(57, i, 65535);
    }

    public DisplayOrientation O0xxXxI() {
        Short XI0oooXX2 = XI0oooXX(55, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayOrientation.getByValue(XI0oooXX2);
    }

    public Bool OIx00oxx() {
        Short XI0oooXX2 = XI0oooXX(86, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public Integer OO0() {
        return oX(59, 0, 65535);
    }

    public Long OOIXx0x() {
        return x0xO(1, 0, 65535);
    }

    public Integer OOOI(int i) {
        return oX(40, i, 65535);
    }

    public Long OOxOI(int i) {
        return x0xO(2, i, 65535);
    }

    public Bool OX() {
        Short XI0oooXX2 = XI0oooXX(36, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public Float OXXoIoXI(int i) {
        return XX(5, i, 65535);
    }

    public BacklightMode OooI() {
        Short XI0oooXX2 = XI0oooXX(12, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return BacklightMode.getByValue(XI0oooXX2);
    }

    public Switch OxO() {
        Short XI0oooXX2 = XI0oooXX(134, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Switch.getByValue(XI0oooXX2);
    }

    public Short OxXXx0X() {
        return XI0oooXX(94, 0, 65535);
    }

    public void Oxo00O(Switch r4) {
        X0xxXX0(134, 0, Short.valueOf(r4.value), 65535);
    }

    public Short Oxx() {
        return XI0oooXX(0, 0, 65535);
    }

    public TimeMode[] X00xOoXI() {
        Short[] xoO0xx02 = xoO0xx0(4, 65535);
        TimeMode[] timeModeArr = new TimeMode[xoO0xx02.length];
        for (int i = 0; i < xoO0xx02.length; i++) {
            timeModeArr[i] = TimeMode.getByValue(xoO0xx02[i]);
        }
        return timeModeArr;
    }

    public void X0IOOI(DisplayOrientation displayOrientation) {
        X0xxXX0(95, 0, Short.valueOf(displayOrientation.value), 65535);
    }

    public DisplayOrientation X0O0I0() {
        Short XI0oooXX2 = XI0oooXX(95, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayOrientation.getByValue(XI0oooXX2);
    }

    public void X0ooXIooI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(39, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Long[] XO00XOO() {
        return XX0xXo(2, 65535);
    }

    public Bool XO0o() {
        Short XI0oooXX2 = XI0oooXX(46, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void XOxoX(Side side) {
        X0xxXX0(56, 0, Short.valueOf(side.value), 65535);
    }

    public void Xo(Integer num) {
        X0xxXX0(58, 0, num, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(58, 0, 65535);
    }

    public void XoOxI0ox(Bool bool) {
        X0xxXX0(86, 0, Short.valueOf(bool.value), 65535);
    }

    public Float[] XooIO0oo0() {
        return xo0x(5, 65535);
    }

    public void XxIo(int i, Float f) {
        X0xxXX0(5, i, f, 65535);
    }

    public AutoSyncFrequency o0IXXIx() {
        Short XI0oooXX2 = XI0oooXX(89, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return AutoSyncFrequency.getByValue(XI0oooXX2);
    }

    public TimeMode o0Xo(int i) {
        Short XI0oooXX2 = XI0oooXX(4, i, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return TimeMode.getByValue(XI0oooXX2);
    }

    public Integer[] o0oxo0oI() {
        return xoxXI(40, 65535);
    }

    public void oX000x(DateMode dateMode) {
        X0xxXX0(47, 0, Short.valueOf(dateMode.value), 65535);
    }

    public int oX0I0O() {
        return oOoIIO0(57, 65535);
    }

    public int oX0ooo0I0() {
        return oOoIIO0(2, 65535);
    }

    public Long oXIoO() {
        return x0xO(90, 0, 65535);
    }

    public void oXO0oOx0(Integer num) {
        X0xxXX0(59, 0, num, 65535);
    }

    public void oXxx000(Bool bool) {
        X0xxXX0(36, 0, Short.valueOf(bool.value), 65535);
    }

    public int oo00() {
        return oOoIIO0(5, 65535);
    }

    public void oxIO0IIo(Long l) {
        X0xxXX0(1, 0, l, 65535);
    }

    public Bool oxOXxoXII() {
        Short XI0oooXX2 = XI0oooXX(80, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public int x00IOx() {
        return oOoIIO0(40, 65535);
    }

    public void x0oxIIIX(Bool bool) {
        X0xxXX0(80, 0, Short.valueOf(bool.value), 65535);
    }

    public void xIOXX(int i, Integer num) {
        X0xxXX0(57, i, num, 65535);
    }

    public void xIXIOX(Bool bool) {
        X0xxXX0(46, 0, Short.valueOf(bool.value), 65535);
    }

    public o0xxxXXxX xIXX() {
        return oXX0IoI(x0xO(39, 0, 65535));
    }

    public void xIx(AutoSyncFrequency autoSyncFrequency) {
        X0xxXX0(89, 0, Short.valueOf(autoSyncFrequency.value), 65535);
    }

    public void xIx0XO(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public void xIxooxXX(int i, Long l) {
        X0xxXX0(2, i, l, 65535);
    }

    public void xOOxI(Long l) {
        X0xxXX0(90, 0, l, 65535);
    }

    public Integer[] xOOxIO() {
        return xoxXI(57, 65535);
    }

    public int xX() {
        return oOoIIO0(4, 65535);
    }

    public void xo(Short sh) {
        X0xxXX0(94, 0, sh, 65535);
    }

    public void xox(int i, TimeMode timeMode) {
        X0xxXX0(4, i, Short.valueOf(timeMode.value), 65535);
    }

    public TapSensitivity xxx00() {
        Short XI0oooXX2 = XI0oooXX(174, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return TapSensitivity.getByValue(XI0oooXX2);
    }

    public DateMode xxxI() {
        Short XI0oooXX2 = XI0oooXX(47, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DateMode.getByValue(XI0oooXX2);
    }

    public oOo(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
