package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class oxOII extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15047II0XooXoX = 254;

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final int f15048IIX0o = 31;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f15049IIXOooo = 13;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f15050IXxxXO = 9;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f15051O0xOxO = 18;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15052OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f15053Oo = 8;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f15054OxI = 17;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f15055Oxx0xo = 10;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f15056OxxIIOOXO = 12;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f15057X0IIOO = 21;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f15058XI0IXoo = 22;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f15059XIxXXX0x0 = 23;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final int f15060XxX0x0xxx = 29;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f15061o00 = 16;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f15062oI0IIXIo = 11;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f15063oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15064oOoXoXO = 3;

    /* renamed from: oo, reason: collision with root package name */
    public static final oIXoXx0 f15065oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static final int f15066oo0xXOI0I = 49;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15067ooOOo0oXI = 4;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final int f15068ooXIXxIX = 32;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15069x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f15070x0xO0oo = 7;

    /* renamed from: xI, reason: collision with root package name */
    public static final int f15071xI = 47;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final int f15072xXxxox0I = 30;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15073xoIox = 1;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f15074xoXoI = 14;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15075xxIXOIIO = 0;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f15076xxX = 28;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("user_profile", 3);
        f15065oo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("friendly_name", 0, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
        oixoxx0.xxIXOIIO(new X0xII0I("gender", 1, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.GENDER));
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("age", 2, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "years", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("height", 3, 2, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type));
        Profile.Type type2 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("weight", 4, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "kg", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("language", 5, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.LANGUAGE));
        Profile.Type type3 = Profile.Type.DISPLAY_MEASURE;
        oixoxx0.xxIXOIIO(new X0xII0I("elev_setting", 6, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("weight_setting", 7, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("resting_heart_rate", 8, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("default_max_running_heart_rate", 9, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("default_max_biking_heart_rate", 10, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("default_max_heart_rate", 11, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("hr_setting", 12, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DISPLAY_HEART));
        oixoxx0.xxIXOIIO(new X0xII0I("speed_setting", 13, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("dist_setting", 14, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("power_setting", 16, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DISPLAY_POWER));
        oixoxx0.xxIXOIIO(new X0xII0I("activity_class", 17, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.ACTIVITY_CLASS));
        oixoxx0.xxIXOIIO(new X0xII0I("position_setting", 18, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DISPLAY_POSITION));
        oixoxx0.xxIXOIIO(new X0xII0I("temperature_setting", 21, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("local_id", 22, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.USER_LOCAL_ID));
        oixoxx0.xxIXOIIO(new X0xII0I("global_id", 23, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BYTE));
        Profile.Type type4 = Profile.Type.LOCALTIME_INTO_DAY;
        oixoxx0.xxIXOIIO(new X0xII0I("wake_time", 28, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("sleep_time", 29, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("height_setting", 30, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("user_running_step_length", 31, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("user_walking_step_length", 32, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("depth_setting", 47, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("dive_count", 49, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT32));
    }

    public oxOII() {
        super(x0OxxIOxX.XO(3));
    }

    public void IIOIX(String str) {
        X0xxXX0(0, 0, str, 65535);
    }

    public void IOOoXo0Ix(DisplayPower displayPower) {
        X0xxXX0(16, 0, Short.valueOf(displayPower.value), 65535);
    }

    public void Ix0(DisplayMeasure displayMeasure) {
        X0xxXX0(13, 0, Short.valueOf(displayMeasure.value), 65535);
    }

    public void IxIo(DisplayHeart displayHeart) {
        X0xxXX0(12, 0, Short.valueOf(displayHeart.value), 65535);
    }

    public DisplayMeasure IxX00() {
        Short XI0oooXX2 = XI0oooXX(30, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayMeasure.getByValue(XI0oooXX2);
    }

    public Gender O00() {
        Short XI0oooXX2 = XI0oooXX(1, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Gender.getByValue(XI0oooXX2);
    }

    public void O0OOX0IIx(DisplayMeasure displayMeasure) {
        X0xxXX0(7, 0, Short.valueOf(displayMeasure.value), 65535);
    }

    public Byte[] O0xxXxI() {
        return oo0xXOI0I(23, 65535);
    }

    public Long OIx00oxx() {
        return x0xO(49, 0, 65535);
    }

    public DisplayMeasure OO0() {
        Short XI0oooXX2 = XI0oooXX(47, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayMeasure.getByValue(XI0oooXX2);
    }

    public void OOIXx0x(Short sh) {
        X0xxXX0(10, 0, sh, 65535);
    }

    public Short OOOI() {
        return XI0oooXX(8, 0, 65535);
    }

    public Float OOxOI() {
        return XX(4, 0, 65535);
    }

    public Short OX() {
        return XI0oooXX(2, 0, 65535);
    }

    public void OXXoIoXI(ActivityClass activityClass) {
        X0xxXX0(17, 0, Short.valueOf(activityClass.value), 65535);
    }

    public DisplayMeasure OooI() {
        Short XI0oooXX2 = XI0oooXX(14, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayMeasure.getByValue(XI0oooXX2);
    }

    public DisplayMeasure OxO() {
        Short XI0oooXX2 = XI0oooXX(21, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayMeasure.getByValue(XI0oooXX2);
    }

    public DisplayPower OxXXx0X() {
        Short XI0oooXX2 = XI0oooXX(16, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayPower.getByValue(XI0oooXX2);
    }

    public void Oxo00O(Long l) {
        X0xxXX0(29, 0, l, 65535);
    }

    public ActivityClass Oxx() {
        Short XI0oooXX2 = XI0oooXX(17, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return ActivityClass.getByValue(XI0oooXX2);
    }

    public Long X00xOoXI() {
        return x0xO(28, 0, 65535);
    }

    public void X0IOOI(Short sh) {
        X0xxXX0(8, 0, sh, 65535);
    }

    public DisplayMeasure X0O0I0() {
        Short XI0oooXX2 = XI0oooXX(13, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayMeasure.getByValue(XI0oooXX2);
    }

    public void X0ooXIooI(int i, Byte b) {
        X0xxXX0(23, i, b, 65535);
    }

    public DisplayMeasure XO00XOO() {
        Short XI0oooXX2 = XI0oooXX(7, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayMeasure.getByValue(XI0oooXX2);
    }

    public DisplayHeart XO0o() {
        Short XI0oooXX2 = XI0oooXX(12, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayHeart.getByValue(XI0oooXX2);
    }

    public void XOxoX(Integer num) {
        X0xxXX0(22, 0, num, 65535);
    }

    public void Xo(Long l) {
        X0xxXX0(49, 0, l, 65535);
    }

    public Short XoIxOXIXo() {
        return XI0oooXX(9, 0, 65535);
    }

    public void XoOxI0ox(Gender gender) {
        X0xxXX0(1, 0, Short.valueOf(gender.value), 65535);
    }

    public void XooIO0oo0(Short sh) {
        X0xxXX0(2, 0, sh, 65535);
    }

    public void XxIo(Float f) {
        X0xxXX0(32, 0, f, 65535);
    }

    public Short o0IXXIx() {
        return XI0oooXX(11, 0, 65535);
    }

    public Float o0Xo() {
        return XX(32, 0, 65535);
    }

    public Long o0oxo0oI() {
        return x0xO(29, 0, 65535);
    }

    public void oX000x(Float f) {
        X0xxXX0(3, 0, f, 65535);
    }

    public Language oX0I0O() {
        Short XI0oooXX2 = XI0oooXX(5, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Language.getByValue(XI0oooXX2);
    }

    public int oX0ooo0I0() {
        return oOoIIO0(23, 65535);
    }

    public Short oXIoO() {
        return XI0oooXX(10, 0, 65535);
    }

    public void oXO0oOx0(DisplayMeasure displayMeasure) {
        X0xxXX0(6, 0, Short.valueOf(displayMeasure.value), 65535);
    }

    public void oXxx000(Short sh) {
        X0xxXX0(9, 0, sh, 65535);
    }

    public DisplayPosition oo00() {
        Short XI0oooXX2 = XI0oooXX(18, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayPosition.getByValue(XI0oooXX2);
    }

    public void oo0oIXo(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public void oxIO0IIo(Long l) {
        X0xxXX0(28, 0, l, 65535);
    }

    public Float oxOXxoXII() {
        return XX(3, 0, 65535);
    }

    public Integer x00IOx() {
        return oX(22, 0, 65535);
    }

    public void x0oxIIIX(Language language) {
        X0xxXX0(5, 0, Short.valueOf(language.value), 65535);
    }

    public void xIOXX(DisplayMeasure displayMeasure) {
        X0xxXX0(30, 0, Short.valueOf(displayMeasure.value), 65535);
    }

    public void xIXIOX(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public DisplayMeasure xIXX() {
        Short XI0oooXX2 = XI0oooXX(6, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayMeasure.getByValue(XI0oooXX2);
    }

    public void xIx(DisplayMeasure displayMeasure) {
        X0xxXX0(14, 0, Short.valueOf(displayMeasure.value), 65535);
    }

    public void xIx0XO(Short sh) {
        X0xxXX0(11, 0, sh, 65535);
    }

    public void xIxooxXX(Float f) {
        X0xxXX0(31, 0, f, 65535);
    }

    public void xOOxI(DisplayMeasure displayMeasure) {
        X0xxXX0(47, 0, Short.valueOf(displayMeasure.value), 65535);
    }

    public Byte xOOxIO(int i) {
        return XxX0x0xxx(23, i, 65535);
    }

    public Integer xX() {
        return oX(254, 0, 65535);
    }

    public void xo(DisplayPosition displayPosition) {
        X0xxXX0(18, 0, Short.valueOf(displayPosition.value), 65535);
    }

    public void xox(DisplayMeasure displayMeasure) {
        X0xxXX0(21, 0, Short.valueOf(displayMeasure.value), 65535);
    }

    public Float xxx00() {
        return XX(31, 0, 65535);
    }

    public String xxxI() {
        return XIXIX(0, 0, 65535);
    }

    public oxOII(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
