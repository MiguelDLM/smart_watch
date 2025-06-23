package com.garmin.fit;

import androidx.core.app.NotificationCompat;
import com.baidu.ar.constants.HttpConstants;
import com.garmin.fit.Profile;
import com.huawei.hms.ads.ContentClassification;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.sma.smartv3.network.BaiDu;
import com.tenmeter.smlibrary.utils.DateFormatUtils;

/* loaded from: classes9.dex */
public class oO0OX0 extends oIXoXx0 implements XIxO {

    /* renamed from: I0, reason: collision with root package name */
    public static final int f14513I0 = 69;

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public static final int f14514I0X0x0oIo = 47;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public static final int f14515I0oOIX = 52;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public static final int f14516I0oOoX = 40;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14517II0XooXoX = 254;

    /* renamed from: IIX0, reason: collision with root package name */
    public static final int f14518IIX0 = 79;

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final int f14519IIX0o = 23;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f14520IIXOooo = 12;

    /* renamed from: IIxOXoOo0, reason: collision with root package name */
    public static final int f14521IIxOXoOo0 = 68;

    /* renamed from: IO, reason: collision with root package name */
    public static final int f14522IO = 32;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f14523IXxxXO = 8;

    /* renamed from: Io, reason: collision with root package name */
    public static final int f14524Io = 37;

    /* renamed from: IoIOOxIIo, reason: collision with root package name */
    public static final int f14525IoIOOxIIo = 85;

    /* renamed from: IoOoX, reason: collision with root package name */
    public static final int f14526IoOoX = 28;

    /* renamed from: IoOoo, reason: collision with root package name */
    public static final int f14527IoOoo = 55;

    /* renamed from: Ioxxx, reason: collision with root package name */
    public static final int f14528Ioxxx = 60;

    /* renamed from: IxIX0I, reason: collision with root package name */
    public static final oIXoXx0 f14529IxIX0I;

    /* renamed from: O0, reason: collision with root package name */
    public static final int f14530O0 = 82;

    /* renamed from: O00XxXI, reason: collision with root package name */
    public static final int f14531O00XxXI = 64;

    /* renamed from: O0X, reason: collision with root package name */
    public static final int f14532O0X = 78;

    /* renamed from: O0Xx, reason: collision with root package name */
    public static final int f14533O0Xx = 51;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f14534O0xOxO = 16;

    /* renamed from: OI0, reason: collision with root package name */
    public static final int f14535OI0 = 36;

    /* renamed from: OIOoIIOIx, reason: collision with root package name */
    public static final int f14536OIOoIIOIx = 91;

    /* renamed from: OO, reason: collision with root package name */
    public static final int f14537OO = 54;

    /* renamed from: OO0x0xX, reason: collision with root package name */
    public static final int f14538OO0x0xX = 58;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14539OOXIXo = 1;

    /* renamed from: OOXIxO0, reason: collision with root package name */
    public static final int f14540OOXIxO0 = 67;

    /* renamed from: OX00O0xII, reason: collision with root package name */
    public static final int f14541OX00O0xII = 72;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f14542Oo = 7;

    /* renamed from: OoO, reason: collision with root package name */
    public static final int f14543OoO = 90;

    /* renamed from: Ox0O, reason: collision with root package name */
    public static final int f14544Ox0O = 81;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f14545OxI = 15;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f14546Oxx0xo = 9;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f14547OxxIIOOXO = 11;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public static final int f14548X00IoxXI = 31;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f14549X0IIOO = 17;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f14550XI0IXoo = 18;

    /* renamed from: XI0oooXX, reason: collision with root package name */
    public static final int f14551XI0oooXX = 66;

    /* renamed from: XIXIX, reason: collision with root package name */
    public static final int f14552XIXIX = 75;

    /* renamed from: XIXIxO, reason: collision with root package name */
    public static final int f14553XIXIxO = 89;

    /* renamed from: XIo0oOXIx, reason: collision with root package name */
    public static final int f14554XIo0oOXIx = 59;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f14555XIxXXX0x0 = 19;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public static final int f14556XOxIOxOx = 35;

    /* renamed from: XX, reason: collision with root package name */
    public static final int f14557XX = 39;

    /* renamed from: XX0, reason: collision with root package name */
    public static final int f14558XX0 = 46;

    /* renamed from: XX0xXo, reason: collision with root package name */
    public static final int f14559XX0xXo = 62;

    /* renamed from: XXoOx0, reason: collision with root package name */
    public static final int f14560XXoOx0 = 93;

    /* renamed from: Xo0, reason: collision with root package name */
    public static final int f14561Xo0 = 49;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public static final int f14562XoI0Ixx0 = 50;

    /* renamed from: XoX, reason: collision with root package name */
    public static final int f14563XoX = 42;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public static final int f14564Xx000oIo = 30;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final int f14565XxX0x0xxx = 21;

    /* renamed from: o0, reason: collision with root package name */
    public static final int f14566o0 = 38;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f14567o00 = 14;

    /* renamed from: o0oIxOo, reason: collision with root package name */
    public static final int f14568o0oIxOo = 87;

    /* renamed from: o0xxxXXxX, reason: collision with root package name */
    public static final int f14569o0xxxXXxX = 63;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f14570oI0IIXIo = 10;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f14571oO = 5;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public static final int f14572oOXoIIIo = 29;

    /* renamed from: oOo, reason: collision with root package name */
    public static final int f14573oOo = 77;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14574oOoXoXO = 2;

    /* renamed from: oX, reason: collision with root package name */
    public static final int f14575oX = 48;

    /* renamed from: oXIO0o0XI, reason: collision with root package name */
    public static final int f14576oXIO0o0XI = 76;

    /* renamed from: oo, reason: collision with root package name */
    public static final int f14577oo = 27;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static final int f14578oo0xXOI0I = 26;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14579ooOOo0oXI = 3;

    /* renamed from: ooOx, reason: collision with root package name */
    public static final int f14580ooOx = 70;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final int f14581ooXIXxIX = 24;

    /* renamed from: ox, reason: collision with root package name */
    public static final int f14582ox = 65;

    /* renamed from: oxIIX0o, reason: collision with root package name */
    public static final int f14583oxIIX0o = 86;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public static final int f14584oxXx0IX = 43;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public static final int f14585oxxXoxO = 41;

    /* renamed from: x0OIX00oO, reason: collision with root package name */
    public static final int f14586x0OIX00oO = 92;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14587x0XOIxOo = 4;

    /* renamed from: x0o, reason: collision with root package name */
    public static final int f14588x0o = 34;

    /* renamed from: x0xO, reason: collision with root package name */
    public static final int f14589x0xO = 57;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f14590x0xO0oo = 6;

    /* renamed from: xI, reason: collision with root package name */
    public static final int f14591xI = 25;

    /* renamed from: xI0oxI00, reason: collision with root package name */
    public static final int f14592xI0oxI00 = 84;

    /* renamed from: xII, reason: collision with root package name */
    public static final int f14593xII = 33;

    /* renamed from: xOOOX, reason: collision with root package name */
    public static final int f14594xOOOX = 74;

    /* renamed from: xOoOIoI, reason: collision with root package name */
    public static final int f14595xOoOIoI = 80;

    /* renamed from: xX0IIXIx0, reason: collision with root package name */
    public static final int f14596xX0IIXIx0 = 73;

    /* renamed from: xXOx, reason: collision with root package name */
    public static final int f14597xXOx = 45;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final int f14598xXxxox0I = 22;

    /* renamed from: xo0x, reason: collision with root package name */
    public static final int f14599xo0x = 44;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14600xoIox = 0;

    /* renamed from: xoIxX, reason: collision with root package name */
    public static final int f14601xoIxX = 56;

    /* renamed from: xoO0xx0, reason: collision with root package name */
    public static final int f14602xoO0xx0 = 71;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f14603xoXoI = 13;

    /* renamed from: xoxXI, reason: collision with root package name */
    public static final int f14604xoxXI = 53;

    /* renamed from: xx0X0, reason: collision with root package name */
    public static final int f14605xx0X0 = 83;

    /* renamed from: xxIO, reason: collision with root package name */
    public static final int f14606xxIO = 61;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14607xxIXOIIO = 253;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f14608xxX = 20;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("segment_lap", 142);
        f14529IxIX0I = oixoxx0;
        Profile.Type type = Profile.Type.MESSAGE_INDEX;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        Profile.Type type2 = Profile.Type.DATE_TIME;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I(NotificationCompat.CATEGORY_EVENT, 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EVENT));
        oixoxx0.xxIXOIIO(new X0xII0I("event_type", 1, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EVENT_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I(BaiDu.START_TIME, 2, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        Profile.Type type3 = Profile.Type.SINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("start_position_lat", 3, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("start_position_long", 4, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("end_position_lat", 5, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("end_position_long", 6, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type3));
        Profile.Type type4 = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("total_elapsed_time", 7, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("total_timer_time", 8, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("total_distance", 9, 134, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("total_cycles", 10, 134, 1.0d, XIXIX.OOXIXo.f3760XO, xOxOoo.f15473xoXoI, false, type4));
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.add(new xxOoXO("total_strokes", 134, 1.0d, XIXIX.OOXIXo.f3760XO, "strokes"));
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.get(0).II0xO0(23, 2L);
        Profile.Type type5 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("total_calories", 11, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "kcal", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("total_fat_calories", 12, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "kcal", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_speed", 13, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("max_speed", 14, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type5));
        Profile.Type type6 = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("avg_heart_rate", 15, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("max_heart_rate", 16, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_cadence", 17, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("max_cadence", 18, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_power", 19, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("max_power", 20, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("total_ascent", 21, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("total_descent", 22, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("sport", 23, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("event_group", 24, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("nec_lat", 25, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("nec_long", 26, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("swc_lat", 27, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("swc_long", 28, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type3));
        Profile.Type type7 = Profile.Type.STRING;
        oixoxx0.xxIXOIIO(new X0xII0I("name", 29, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("normalized_power", 30, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("left_right_balance", 31, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.LEFT_RIGHT_BALANCE_100));
        oixoxx0.xxIXOIIO(new X0xII0I("sub_sport", 32, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SUB_SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("total_work", 33, 134, 1.0d, XIXIX.OOXIXo.f3760XO, ContentClassification.AD_CONTENT_CLASSIFICATION_J, false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_altitude", 34, 132, 5.0d, 500.0d, "m", false, type5));
        oixoxx0.f14429oxoX.get(36).f13537xoIox.add(new oXX0IoI(91, false, 16, 5.0d, 500.0d));
        oixoxx0.xxIXOIIO(new X0xII0I("max_altitude", 35, 132, 5.0d, 500.0d, "m", false, type5));
        oixoxx0.f14429oxoX.get(37).f13537xoIox.add(new oXX0IoI(92, false, 16, 5.0d, 500.0d));
        oixoxx0.xxIXOIIO(new X0xII0I("gps_accuracy", 36, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type6));
        Profile.Type type8 = Profile.Type.SINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("avg_grade", 37, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_pos_grade", 38, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_neg_grade", 39, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("max_pos_grade", 40, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("max_neg_grade", 41, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type8));
        Profile.Type type9 = Profile.Type.SINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("avg_temperature", 42, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "C", false, type9));
        oixoxx0.xxIXOIIO(new X0xII0I("max_temperature", 43, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "C", false, type9));
        oixoxx0.xxIXOIIO(new X0xII0I("total_moving_time", 44, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_pos_vertical_speed", 45, 131, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_neg_vertical_speed", 46, 131, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("max_pos_vertical_speed", 47, 131, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("max_neg_vertical_speed", 48, 131, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_hr_zone", 49, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_speed_zone", 50, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_cadence_zone", 51, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_power_zone", 52, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("repetition_num", 53, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("min_altitude", 54, 132, 5.0d, 500.0d, "m", false, type5));
        oixoxx0.f14429oxoX.get(56).f13537xoIox.add(new oXX0IoI(93, false, 16, 5.0d, 500.0d));
        oixoxx0.xxIXOIIO(new X0xII0I("min_heart_rate", 55, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15466X0IIOO, 56, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("wkt_step_index", 57, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sport_event", 58, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPORT_EVENT));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_torque_effectiveness", 59, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_torque_effectiveness", 60, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_pedal_smoothness", 61, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_pedal_smoothness", 62, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_combined_pedal_smoothness", 63, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("status", 64, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SEGMENT_LAP_STATUS));
        oixoxx0.xxIXOIIO(new X0xII0I(Constant.MAP_KEY_UUID, 65, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_fractional_cadence", 66, 2, 128.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("max_fractional_cadence", 67, 2, 128.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("total_fractional_cycles", 68, 2, 128.0d, XIXIX.OOXIXo.f3760XO, xOxOoo.f15473xoXoI, false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("front_gear_shift_count", 69, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("rear_gear_shift_count", 70, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("time_standing", 71, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("stand_count", 72, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_pco", 73, 1, 1.0d, XIXIX.OOXIXo.f3760XO, DateFormatUtils.MIN, false, type9));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_pco", 74, 1, 1.0d, XIXIX.OOXIXo.f3760XO, DateFormatUtils.MIN, false, type9));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_power_phase", 75, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_power_phase_peak", 76, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_power_phase", 77, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_power_phase_peak", 78, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_power_position", 79, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("max_power_position", 80, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_cadence_position", 81, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("max_cadence_position", 82, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I(HttpConstants.HTTP_MANUFACTURER, 83, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MANUFACTURER));
        Profile.Type type10 = Profile.Type.FLOAT32;
        oixoxx0.xxIXOIIO(new X0xII0I("total_grit", 84, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "kGrit", false, type10));
        oixoxx0.xxIXOIIO(new X0xII0I("total_flow", 85, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "Flow", false, type10));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_grit", 86, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "kGrit", false, type10));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_flow", 87, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "Flow", false, type10));
        oixoxx0.xxIXOIIO(new X0xII0I("total_fractional_ascent", 89, 2, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("total_fractional_descent", 90, 2, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_avg_altitude", 91, 134, 5.0d, 500.0d, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_max_altitude", 92, 134, 5.0d, 500.0d, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_min_altitude", 93, 134, 5.0d, 500.0d, "m", false, type4));
    }

    public oO0OX0() {
        super(x0OxxIOxX.XO(142));
    }

    public int I00O() {
        return oOoIIO0(51, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public Short I0Io() {
        return XI0oooXX(24, 0, 65535);
    }

    public void I0O00OI(Float f) {
        X0xxXX0(7, 0, f, 65535);
    }

    public void I0OO(int i, Float f) {
        X0xxXX0(75, i, f, 65535);
    }

    public void II0OOXOx(Float f) {
        X0xxXX0(40, 0, f, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public Event II0xO0() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Event.getByValue(XI0oooXX2);
    }

    public Integer IIIxO() {
        return oX(57, 0, 65535);
    }

    public Short IIOIX() {
        return XI0oooXX(36, 0, 65535);
    }

    public void IIXOxIxOo(Float f) {
        X0xxXX0(85, 0, f, 65535);
    }

    public void IIoX0OoI(Float f) {
        X0xxXX0(92, 0, f, 65535);
    }

    public void IO0xX(Float f) {
        X0xxXX0(48, 0, f, 65535);
    }

    public void IOI(Float f) {
        X0xxXX0(62, 0, f, 65535);
    }

    public void IOOXOOOOo(Integer num) {
        X0xxXX0(5, 0, num, 65535);
    }

    public Float IOOoXo0Ix() {
        return XX(48, 0, 65535);
    }

    public void IOXOxOII(Float f) {
        X0xxXX0(38, 0, f, 65535);
    }

    public void IOo0(Float f) {
        X0xxXX0(47, 0, f, 65535);
    }

    public void IOooo0o(Integer num) {
        X0xxXX0(26, 0, num, 65535);
    }

    public void IXI(Integer num) {
        X0xxXX0(21, 0, num, 65535);
    }

    public void IXIIo(int i, Float f) {
        X0xxXX0(50, i, f, 65535);
    }

    public Float IXIxx0() {
        return XX(44, 0, 65535);
    }

    public Float IXX(int i) {
        return XX(49, i, 65535);
    }

    public Long IXXIXx00I() {
        return x0xO(10, 0, 0);
    }

    public void IXo(Float f) {
        X0xxXX0(89, 0, f, 65535);
    }

    public int IXoIo() {
        return oOoIIO0(78, 65535);
    }

    public Float IXxOIOO() {
        return XX(85, 0, 65535);
    }

    public Float[] IoX() {
        return xo0x(52, 65535);
    }

    public void IoXO0XoX(int i, Float f) {
        X0xxXX0(78, i, f, 65535);
    }

    public void IoxOx(Float f) {
        X0xxXX0(91, 0, f, 65535);
    }

    public void IoxX(int i, Float f) {
        X0xxXX0(52, i, f, 65535);
    }

    public Integer Ix0() {
        return oX(20, 0, 65535);
    }

    public o0xxxXXxX Ix0x() {
        return oXX0IoI(x0xO(2, 0, 65535));
    }

    public Sport IxI() {
        Short XI0oooXX2 = XI0oooXX(23, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Sport.getByValue(XI0oooXX2);
    }

    public Short IxIo(int i) {
        return XI0oooXX(82, i, 65535);
    }

    public void IxO0Oxo(Float f) {
        X0xxXX0(59, 0, f, 65535);
    }

    public void IxOXOxO(Integer num) {
        X0xxXX0(12, 0, num, 65535);
    }

    public Float[] IxX00() {
        return xo0x(75, 65535);
    }

    public Short O00() {
        return XI0oooXX(15, 0, 65535);
    }

    public void O0IoXXOx(Integer num) {
        X0xxXX0(27, 0, num, 65535);
    }

    public Long O0O0Io00X() {
        return x0xO(10, 0, 65535);
    }

    public Float O0OOX0IIx() {
        return XX(54, 0, 65535);
    }

    public void O0OoXI(Long l) {
        X0xxXX0(10, 0, l, 0);
    }

    public Float O0o0(int i) {
        return XX(51, i, 65535);
    }

    public int O0x() {
        return oOoIIO0(75, 65535);
    }

    public Float O0xO0() {
        return XX(84, 0, 65535);
    }

    public Float O0xxXxI() {
        return XX(61, 0, 65535);
    }

    public void OI0IXox(Float f) {
        X0xxXX0(63, 0, f, 65535);
    }

    public void OIII0O(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public Integer OIIXOxo() {
        return oX(22, 0, 65535);
    }

    public Integer OIoxIx() {
        return oX(72, 0, 65535);
    }

    public Float OIx00oxx() {
        return XX(66, 0, 65535);
    }

    public void OIx0xoOo(Integer num) {
        X0xxXX0(31, 0, num, 65535);
    }

    public Float[] OIxI0O() {
        return xo0x(51, 65535);
    }

    public void OIxOIX0II(Float f) {
        X0xxXX0(54, 0, f, 65535);
    }

    public int OIxOX() {
        return oOoIIO0(79, 65535);
    }

    public Integer OIxx0I0() {
        return oX(25, 0, 65535);
    }

    public Float OO0() {
        return XX(63, 0, 65535);
    }

    public Byte OOIXx0x() {
        return XxX0x0xxx(42, 0, 65535);
    }

    public Integer OOOI() {
        return oX(19, 0, 65535);
    }

    public void OOOox(int i, Float f) {
        X0xxXX0(77, i, f, 65535);
    }

    public void OOoOoO0o(int i, Float f) {
        X0xxXX0(49, i, f, 65535);
    }

    public Float OOxOI(int i) {
        return XX(78, i, 65535);
    }

    public SegmentLapStatus OOxOOxIO() {
        Short XI0oooXX2 = XI0oooXX(64, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SegmentLapStatus.getByValue(XI0oooXX2);
    }

    public Float OX() {
        return XX(34, 0, 65535);
    }

    public void OX00o0X(Integer num) {
        X0xxXX0(30, 0, num, 65535);
    }

    public int OXIOoo0X0() {
        return oOoIIO0(82, 65535);
    }

    public void OXOo(Integer num) {
        X0xxXX0(22, 0, num, 65535);
    }

    public Float OXXoIoXI() {
        return XX(60, 0, 65535);
    }

    public Integer OXooXo() {
        return oX(4, 0, 65535);
    }

    public void OXxx0OO(int i, Short sh) {
        X0xxXX0(82, i, sh, 65535);
    }

    public void Oo0IXI0(Long l) {
        X0xxXX0(10, 0, l, 65535);
    }

    public void OoI0OO(Byte b) {
        X0xxXX0(74, 0, b, 65535);
    }

    public Float OoIXo() {
        return XX(71, 0, 65535);
    }

    public void OoOoXO0(Integer num) {
        X0xxXX0(28, 0, num, 65535);
    }

    public Float OooI() {
        return XX(87, 0, 65535);
    }

    public Integer OooO0XOx() {
        return oX(30, 0, 65535);
    }

    public void Oox(int i, Short sh) {
        X0xxXX0(81, i, sh, 65535);
    }

    public void OoxOxII(Integer num) {
        X0xxXX0(53, 0, num, 65535);
    }

    public void Ox(Float f) {
        X0xxXX0(84, 0, f, 65535);
    }

    public void Ox00XOXoo(int i, Integer num) {
        X0xxXX0(80, i, num, 65535);
    }

    public void Ox0XO(int i, Float f) {
        X0xxXX0(51, i, f, 65535);
    }

    public void OxIxx0(Byte b) {
        X0xxXX0(42, 0, b, 65535);
    }

    public Byte OxO() {
        return XxX0x0xxx(74, 0, 65535);
    }

    public Float OxXXx0X() {
        return XX(45, 0, 65535);
    }

    public Float Oxo00O() {
        return XX(47, 0, 65535);
    }

    public Float Oxx() {
        return XX(56, 0, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void Oxx0IOOO(Short sh) {
        X0xxXX0(24, 0, sh, 65535);
    }

    public void Oxxo(SportEvent sportEvent) {
        X0xxXX0(58, 0, Short.valueOf(sportEvent.value), 65535);
    }

    public void X0(Float f) {
        X0xxXX0(61, 0, f, 65535);
    }

    public void X00IxOx(Float f) {
        X0xxXX0(87, 0, f, 65535);
    }

    public Float[] X00xOoXI() {
        return xo0x(77, 65535);
    }

    public Float X0IOOI() {
        return XX(40, 0, 65535);
    }

    public Integer[] X0O0I0() {
        return xoxXI(79, 65535);
    }

    public void X0OXX(Short sh) {
        X0xxXX0(16, 0, sh, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public EventType X0o0xo() {
        Short XI0oooXX2 = XI0oooXX(1, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return EventType.getByValue(XI0oooXX2);
    }

    public Integer X0ooXIooI() {
        return oX(83, 0, 65535);
    }

    public void X0x(Float f) {
        X0xxXX0(34, 0, f, 65535);
    }

    public Integer X0xOO() {
        return oX(21, 0, 65535);
    }

    public SubSport XIOOI() {
        Short XI0oooXX2 = XI0oooXX(32, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SubSport.getByValue(XI0oooXX2);
    }

    public Long XIxO() {
        return x0xO(33, 0, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void XO(EventType eventType) {
        X0xxXX0(1, 0, Short.valueOf(eventType.value), 65535);
    }

    public void XO0(Float f) {
        X0xxXX0(9, 0, f, 65535);
    }

    public Float[] XO00XOO() {
        return xo0x(78, 65535);
    }

    public void XO0OX(Short sh) {
        X0xxXX0(17, 0, sh, 65535);
    }

    public Float XO0o(int i) {
        return XX(76, i, 65535);
    }

    public void XOOO0O(Float f) {
        X0xxXX0(14, 0, f, 65535);
    }

    public Float XOo0(int i) {
        return XX(52, i, 65535);
    }

    public void XOx(Integer num) {
        X0xxXX0(11, 0, num, 65535);
    }

    public Float XOxoX() {
        return XX(67, 0, 65535);
    }

    public void XXIoX0(int i, Integer num) {
        X0xxXX0(79, i, num, 65535);
    }

    public void XXO0(Integer num) {
        X0xxXX0(83, 0, num, 65535);
    }

    public void XXoO0oX(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(2, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void XXooOOI(Integer num) {
        X0xxXX0(72, 0, num, 65535);
    }

    public void XXx0OXXXo(Integer num) {
        X0xxXX0(6, 0, num, 65535);
    }

    public Float Xo() {
        return XX(93, 0, 65535);
    }

    public Short[] XoIxOXIXo() {
        return xoO0xx0(81, 65535);
    }

    public void XoOOx0IX(Float f) {
        X0xxXX0(39, 0, f, 65535);
    }

    public Integer XoOxI0ox() {
        return oX(31, 0, 65535);
    }

    public Float XooIO0oo0() {
        return XX(13, 0, 65535);
    }

    public void Xx(Float f) {
        X0xxXX0(67, 0, f, 65535);
    }

    public void Xx0(Float f) {
        X0xxXX0(41, 0, f, 65535);
    }

    public Integer XxI() {
        return oX(12, 0, 65535);
    }

    public Integer XxIIOXIXx() {
        return oX(11, 0, 65535);
    }

    public void XxIOX(Integer num) {
        X0xxXX0(20, 0, num, 65535);
    }

    public Float XxIo() {
        return XX(14, 0, 65535);
    }

    public int XxXX() {
        return oOoIIO0(81, 65535);
    }

    public void Xxx0oXX(Integer num) {
        X0xxXX0(4, 0, num, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Integer o00xOoIO() {
        return oX(53, 0, 65535);
    }

    public Short o0IXXIx(int i) {
        return XI0oooXX(81, i, 65535);
    }

    public int o0OO0() {
        return oOoIIO0(50, 65535);
    }

    public int o0Oo() {
        return oOoIIO0(76, 65535);
    }

    public Float o0Xo(int i) {
        return XX(77, i, 65535);
    }

    public void o0oIxXOx(Short sh) {
        X0xxXX0(55, 0, sh, 65535);
    }

    public Integer o0oxo0oI(int i) {
        return oX(79, i, 65535);
    }

    public void o0xIIX0(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void o0xIoII(Integer num) {
        X0xxXX0(19, 0, num, 65535);
    }

    public void o0xOIoxo(Byte b) {
        X0xxXX0(73, 0, b, 65535);
    }

    public Float oI0(int i) {
        return XX(50, i, 65535);
    }

    public void oI00o(Integer num) {
        X0xxXX0(69, 0, num, 65535);
    }

    public Float oI0X0() {
        return XX(9, 0, 65535);
    }

    public void oIX0o(SubSport subSport) {
        X0xxXX0(32, 0, Short.valueOf(subSport.value), 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Float oIXoXx0() {
        return XX(7, 0, 65535);
    }

    public void oIoxI0xx(Float f) {
        X0xxXX0(8, 0, f, 65535);
    }

    public void oIxOXo(Long l) {
        X0xxXX0(33, 0, l, 65535);
    }

    public void oIxxIo(Integer num) {
        X0xxXX0(57, 0, num, 65535);
    }

    public void oO0(Float f) {
        X0xxXX0(44, 0, f, 65535);
    }

    public int oO0IXx() {
        return oOoIIO0(49, 65535);
    }

    public void oO0OX0(Byte b) {
        X0xxXX0(43, 0, b, 65535);
    }

    public void oOIXoIXXI(Float f) {
        X0xxXX0(93, 0, f, 65535);
    }

    public void oOIx(Float f) {
        X0xxXX0(86, 0, f, 65535);
    }

    public Float oX000x() {
        return XX(35, 0, 65535);
    }

    public Float[] oX0I0O() {
        return xo0x(76, 65535);
    }

    public Float oX0ooo0I0() {
        return XX(46, 0, 65535);
    }

    public void oXIoIo(Float f) {
        X0xxXX0(66, 0, f, 65535);
    }

    public Short oXIoO() {
        return XI0oooXX(17, 0, 65535);
    }

    public Integer oXO0oOx0() {
        return oX(69, 0, 65535);
    }

    public Integer oXoXxOo() {
        return oX(3, 0, 65535);
    }

    public void oXxOXOX(Float f) {
        X0xxXX0(45, 0, f, 65535);
    }

    public Integer oXxx000() {
        return oX(6, 0, 65535);
    }

    public Float oo00() {
        return XX(38, 0, 65535);
    }

    public Integer oo0oIXo() {
        return oX(254, 0, 65535);
    }

    public int ooO0oXxI() {
        return oOoIIO0(52, 65535);
    }

    public Integer oox000IX() {
        return oX(27, 0, 65535);
    }

    public void ox0(Integer num) {
        X0xxXX0(70, 0, num, 65535);
    }

    public Integer ox0I() {
        return oX(28, 0, 65535);
    }

    public Byte oxIO0IIo() {
        return XxX0x0xxx(43, 0, 65535);
    }

    public void oxO(Float f) {
        X0xxXX0(71, 0, f, 65535);
    }

    public void oxOIoIx(Short sh) {
        X0xxXX0(36, 0, sh, 65535);
    }

    public Float oxOXxoXII(int i) {
        return XX(75, i, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void oxoX(Event event) {
        X0xxXX0(0, 0, Short.valueOf(event.value), 65535);
    }

    public Float x00IOx() {
        return XX(59, 0, 65535);
    }

    public Float[] x00X0xoXO() {
        return xo0x(49, 65535);
    }

    @Override // com.garmin.fit.oIXoXx0
    public String x0OIX00oO() {
        return XIXIX(29, 0, 65535);
    }

    public int x0OOI() {
        return oOoIIO0(77, 65535);
    }

    public int x0oox0() {
        return oOoIIO0(80, 65535);
    }

    public Short[] x0oxIIIX() {
        return xoO0xx0(82, 65535);
    }

    public void x0xOIoO(Float f) {
        X0xxXX0(35, 0, f, 65535);
    }

    public void xI0OXooO(Integer num) {
        X0xxXX0(25, 0, num, 65535);
    }

    public Short xIOXX() {
        return XI0oooXX(18, 0, 65535);
    }

    public Short xIXIOX() {
        return XI0oooXX(16, 0, 65535);
    }

    public SportEvent xIXOoI() {
        Short XI0oooXX2 = XI0oooXX(58, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SportEvent.getByValue(XI0oooXX2);
    }

    public Float xIXX() {
        return XX(37, 0, 65535);
    }

    public void xIXoO0Xx(Float f) {
        X0xxXX0(13, 0, f, 65535);
    }

    public Float[] xIoXXXIXo() {
        return xo0x(50, 65535);
    }

    public Float xIx() {
        return XX(92, 0, 65535);
    }

    public Integer xIx0XO() {
        return oX(5, 0, 65535);
    }

    public Integer[] xIxooxXX() {
        return xoxXI(80, 65535);
    }

    public void xOI0(SegmentLapStatus segmentLapStatus) {
        X0xxXX0(64, 0, Short.valueOf(segmentLapStatus.value), 65535);
    }

    public void xOIO(String str) {
        X0xxXX0(65, 0, str, 65535);
    }

    public Float xOOxI() {
        return XX(91, 0, 65535);
    }

    public Byte xOOxIO() {
        return XxX0x0xxx(73, 0, 65535);
    }

    public void xOoIIIoXI(Float f) {
        X0xxXX0(37, 0, f, 65535);
    }

    public void xOx(String str) {
        X0xxXX0(29, 0, str, 65535);
    }

    public void xOxOoo(Short sh) {
        X0xxXX0(15, 0, sh, 65535);
    }

    public void xOxxXO(int i, Float f) {
        X0xxXX0(76, i, f, 65535);
    }

    public Float xX() {
        return XX(39, 0, 65535);
    }

    public Float xX0ox() {
        return XX(89, 0, 65535);
    }

    public void xXIX0Xo(Sport sport) {
        X0xxXX0(23, 0, Short.valueOf(sport.value), 65535);
    }

    public void xXXxoI(Float f) {
        X0xxXX0(90, 0, f, 65535);
    }

    public Integer xXo() {
        return oX(70, 0, 65535);
    }

    public Float xo() {
        return XX(41, 0, 65535);
    }

    public Float xoIXOxX() {
        return XX(68, 0, 65535);
    }

    public Short xoX() {
        return XI0oooXX(55, 0, 65535);
    }

    public Float xooxxX() {
        return XX(90, 0, 65535);
    }

    public Integer xox(int i) {
        return oX(80, i, 65535);
    }

    public void xoxo(Short sh) {
        X0xxXX0(18, 0, sh, 65535);
    }

    public void xx(Float f) {
        X0xxXX0(60, 0, f, 65535);
    }

    public Integer xx0() {
        return oX(26, 0, 65535);
    }

    public void xx00oOoI(Float f) {
        X0xxXX0(46, 0, f, 65535);
    }

    public void xx0O(Float f) {
        X0xxXX0(68, 0, f, 65535);
    }

    public Float xx0o0O() {
        return XX(8, 0, 65535);
    }

    public void xxXXXxIxo(Float f) {
        X0xxXX0(56, 0, f, 65535);
    }

    public Float xxx00() {
        return XX(62, 0, 65535);
    }

    public Float xxxI() {
        return XX(86, 0, 65535);
    }

    public String xxxoo0XI() {
        return XIXIX(65, 0, 65535);
    }

    public oO0OX0(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
