package com.garmin.fit;

import androidx.core.app.NotificationCompat;
import com.garmin.fit.Profile;
import com.huawei.hms.ads.ContentClassification;
import com.sma.smartv3.network.BaiDu;
import com.tenmeter.smlibrary.utils.DateFormatUtils;

/* loaded from: classes9.dex */
public class oXoXxOo extends oIXoXx0 implements XIxO {

    /* renamed from: I0, reason: collision with root package name */
    public static final int f14809I0 = 84;

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public static final int f14810I0X0x0oIo = 53;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public static final int f14811I0oOIX = 58;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public static final int f14812I0oOoX = 46;

    /* renamed from: I0xX0, reason: collision with root package name */
    public static final int f14813I0xX0 = 153;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14814II0XooXoX = 254;

    /* renamed from: IIX0, reason: collision with root package name */
    public static final int f14815IIX0 = 95;

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final int f14816IIX0o = 23;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f14817IIXOooo = 12;

    /* renamed from: IIxOXoOo0, reason: collision with root package name */
    public static final int f14818IIxOXoOo0 = 83;

    /* renamed from: IO, reason: collision with root package name */
    public static final int f14819IO = 38;

    /* renamed from: IO0XoXxO, reason: collision with root package name */
    public static final int f14820IO0XoXxO = 124;

    /* renamed from: IOoo, reason: collision with root package name */
    public static final int f14821IOoo = 148;

    /* renamed from: IXO, reason: collision with root package name */
    public static final int f14822IXO = 113;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f14823IXxxXO = 8;

    /* renamed from: Io, reason: collision with root package name */
    public static final int f14824Io = 43;

    /* renamed from: IoIOOxIIo, reason: collision with root package name */
    public static final int f14825IoIOOxIIo = 103;

    /* renamed from: IoOoX, reason: collision with root package name */
    public static final int f14826IoOoX = 33;

    /* renamed from: IoOoo, reason: collision with root package name */
    public static final int f14827IoOoo = 61;

    /* renamed from: IoXIXo, reason: collision with root package name */
    public static final int f14828IoXIXo = 117;

    /* renamed from: Ioxxx, reason: collision with root package name */
    public static final int f14829Ioxxx = 75;

    /* renamed from: Ix00oIoI, reason: collision with root package name */
    public static final int f14830Ix00oIoI = 115;

    /* renamed from: IxIX0I, reason: collision with root package name */
    public static final int f14831IxIX0I = 111;

    /* renamed from: O0, reason: collision with root package name */
    public static final int f14832O0 = 100;

    /* renamed from: O00XxXI, reason: collision with root package name */
    public static final int f14833O00XxXI = 79;

    /* renamed from: O0IxXx, reason: collision with root package name */
    public static final int f14834O0IxXx = 116;

    /* renamed from: O0X, reason: collision with root package name */
    public static final int f14835O0X = 94;

    /* renamed from: O0Xx, reason: collision with root package name */
    public static final int f14836O0Xx = 57;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f14837O0xOxO = 16;

    /* renamed from: OI0, reason: collision with root package name */
    public static final int f14838OI0 = 42;

    /* renamed from: OIOoIIOIx, reason: collision with root package name */
    public static final int f14839OIOoIIOIx = 108;

    /* renamed from: OO, reason: collision with root package name */
    public static final int f14840OO = 60;

    /* renamed from: OO0, reason: collision with root package name */
    public static final int f14841OO0 = 160;

    /* renamed from: OO0x0xX, reason: collision with root package name */
    public static final int f14842OO0x0xX = 71;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14843OOXIXo = 1;

    /* renamed from: OOXIxO0, reason: collision with root package name */
    public static final int f14844OOXIxO0 = 82;

    /* renamed from: OX, reason: collision with root package name */
    public static final int f14845OX = 156;

    /* renamed from: OX00O0xII, reason: collision with root package name */
    public static final int f14846OX00O0xII = 87;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f14847Oo = 7;

    /* renamed from: OoO, reason: collision with root package name */
    public static final int f14848OoO = 107;

    /* renamed from: OooI, reason: collision with root package name */
    public static final oIXoXx0 f14849OooI;

    /* renamed from: Ox0O, reason: collision with root package name */
    public static final int f14850Ox0O = 99;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f14851OxI = 15;

    /* renamed from: Oxx, reason: collision with root package name */
    public static final int f14852Oxx = 154;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f14853Oxx0xo = 9;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f14854OxxIIOOXO = 11;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public static final int f14855X00IoxXI = 37;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f14856X0IIOO = 17;

    /* renamed from: X0xII0I, reason: collision with root package name */
    public static final int f14857X0xII0I = 122;

    /* renamed from: X0xxXX0, reason: collision with root package name */
    public static final int f14858X0xxXX0 = 123;

    /* renamed from: XI, reason: collision with root package name */
    public static final int f14859XI = 147;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f14860XI0IXoo = 18;

    /* renamed from: XI0oooXX, reason: collision with root package name */
    public static final int f14861XI0oooXX = 81;

    /* renamed from: XIXIX, reason: collision with root package name */
    public static final int f14862XIXIX = 91;

    /* renamed from: XIXIxO, reason: collision with root package name */
    public static final int f14863XIXIxO = 106;

    /* renamed from: XIo0oOXIx, reason: collision with root package name */
    public static final int f14864XIo0oOXIx = 74;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f14865XIxXXX0x0 = 19;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public static final int f14866XOxIOxOx = 41;

    /* renamed from: XOxxooXI, reason: collision with root package name */
    public static final int f14867XOxxooXI = 137;

    /* renamed from: XX, reason: collision with root package name */
    public static final int f14868XX = 45;

    /* renamed from: XX0, reason: collision with root package name */
    public static final int f14869XX0 = 52;

    /* renamed from: XX0xXo, reason: collision with root package name */
    public static final int f14870XX0xXo = 77;

    /* renamed from: XXXI, reason: collision with root package name */
    public static final int f14871XXXI = 151;

    /* renamed from: XXoOx0, reason: collision with root package name */
    public static final int f14872XXoOx0 = 110;

    /* renamed from: Xo0, reason: collision with root package name */
    public static final int f14873Xo0 = 55;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public static final int f14874XoI0Ixx0 = 56;

    /* renamed from: XoIxOXIXo, reason: collision with root package name */
    public static final int f14875XoIxOXIXo = 159;

    /* renamed from: XoX, reason: collision with root package name */
    public static final int f14876XoX = 48;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public static final int f14877Xx000oIo = 35;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final int f14878XxX0x0xxx = 21;

    /* renamed from: o0, reason: collision with root package name */
    public static final int f14879o0 = 44;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f14880o00 = 14;

    /* renamed from: o0IXXIx, reason: collision with root package name */
    public static final int f14881o0IXXIx = 158;

    /* renamed from: o0oIxOo, reason: collision with root package name */
    public static final int f14882o0oIxOo = 105;

    /* renamed from: o0xxxXXxX, reason: collision with root package name */
    public static final int f14883o0xxxXXxX = 78;

    /* renamed from: oI, reason: collision with root package name */
    public static final int f14884oI = 114;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f14885oI0IIXIo = 10;

    /* renamed from: oIIxXoo, reason: collision with root package name */
    public static final int f14886oIIxXoo = 149;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f14887oO = 5;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public static final int f14888oOXoIIIo = 34;

    /* renamed from: oOo, reason: collision with root package name */
    public static final int f14889oOo = 93;

    /* renamed from: oOoIIO0, reason: collision with root package name */
    public static final int f14890oOoIIO0 = 112;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14891oOoXoXO = 2;

    /* renamed from: oX, reason: collision with root package name */
    public static final int f14892oX = 54;

    /* renamed from: oXIO0o0XI, reason: collision with root package name */
    public static final int f14893oXIO0o0XI = 92;

    /* renamed from: oXIoO, reason: collision with root package name */
    public static final int f14894oXIoO = 157;

    /* renamed from: oXX0IoI, reason: collision with root package name */
    public static final int f14895oXX0IoI = 150;

    /* renamed from: oXxOI0oIx, reason: collision with root package name */
    public static final int f14896oXxOI0oIx = 136;

    /* renamed from: oo, reason: collision with root package name */
    public static final int f14897oo = 32;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static final int f14898oo0xXOI0I = 26;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14899ooOOo0oXI = 3;

    /* renamed from: ooOx, reason: collision with root package name */
    public static final int f14900ooOx = 85;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final int f14901ooXIXxIX = 24;

    /* renamed from: ox, reason: collision with root package name */
    public static final int f14902ox = 80;

    /* renamed from: oxIIX0o, reason: collision with root package name */
    public static final int f14903oxIIX0o = 104;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public static final int f14904oxXx0IX = 49;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public static final int f14905oxxXoxO = 47;

    /* renamed from: x0, reason: collision with root package name */
    public static final int f14906x0 = 121;

    /* renamed from: x0OIX00oO, reason: collision with root package name */
    public static final int f14907x0OIX00oO = 109;

    /* renamed from: x0OxxIOxX, reason: collision with root package name */
    public static final int f14908x0OxxIOxX = 120;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14909x0XOIxOo = 4;

    /* renamed from: x0o, reason: collision with root package name */
    public static final int f14910x0o = 40;

    /* renamed from: x0xO, reason: collision with root package name */
    public static final int f14911x0xO = 63;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f14912x0xO0oo = 6;

    /* renamed from: xI, reason: collision with root package name */
    public static final int f14913xI = 25;

    /* renamed from: xI0oxI00, reason: collision with root package name */
    public static final int f14914xI0oxI00 = 102;

    /* renamed from: xII, reason: collision with root package name */
    public static final int f14915xII = 39;

    /* renamed from: xOOOX, reason: collision with root package name */
    public static final int f14916xOOOX = 89;

    /* renamed from: xOoOIoI, reason: collision with root package name */
    public static final int f14917xOoOIoI = 98;

    /* renamed from: xX0IIXIx0, reason: collision with root package name */
    public static final int f14918xX0IIXIx0 = 88;

    /* renamed from: xXOx, reason: collision with root package name */
    public static final int f14919xXOx = 51;

    /* renamed from: xXoOI00O, reason: collision with root package name */
    public static final int f14920xXoOI00O = 119;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final int f14921xXxxox0I = 22;

    /* renamed from: xo0x, reason: collision with root package name */
    public static final int f14922xo0x = 50;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14923xoIox = 0;

    /* renamed from: xoIxX, reason: collision with root package name */
    public static final int f14924xoIxX = 62;

    /* renamed from: xoO0xx0, reason: collision with root package name */
    public static final int f14925xoO0xx0 = 86;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f14926xoXoI = 13;

    /* renamed from: xoxXI, reason: collision with root package name */
    public static final int f14927xoxXI = 59;

    /* renamed from: xx0X0, reason: collision with root package name */
    public static final int f14928xx0X0 = 101;

    /* renamed from: xxIO, reason: collision with root package name */
    public static final int f14929xxIO = 76;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14930xxIXOIIO = 253;

    /* renamed from: xxOXOOoIX, reason: collision with root package name */
    public static final int f14931xxOXOOoIX = 118;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f14932xxX = 20;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("lap", 19);
        f14849OooI = oixoxx0;
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
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.add(new xxOoXO("total_strides", 134, 1.0d, XIXIX.OOXIXo.f3760XO, "strides"));
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.get(0).II0xO0(25, 1L);
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.get(0).II0xO0(25, 11L);
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.add(new xxOoXO("total_strokes", 134, 1.0d, XIXIX.OOXIXo.f3760XO, "strokes"));
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.get(1).II0xO0(25, 2L);
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.get(1).II0xO0(25, 5L);
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.get(1).II0xO0(25, 15L);
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.get(1).II0xO0(25, 37L);
        Profile.Type type5 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("total_calories", 11, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "kcal", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("total_fat_calories", 12, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "kcal", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_speed", 13, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type5));
        oixoxx0.f14429oxoX.get(15).f13537xoIox.add(new oXX0IoI(110, false, 16, 1000.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("max_speed", 14, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type5));
        oixoxx0.f14429oxoX.get(16).f13537xoIox.add(new oXX0IoI(111, false, 16, 1000.0d, XIXIX.OOXIXo.f3760XO));
        Profile.Type type6 = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("avg_heart_rate", 15, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("max_heart_rate", 16, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_cadence", 17, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type6));
        oixoxx0.f14429oxoX.get(19).f13530OOXIXo.add(new xxOoXO("avg_running_cadence", 2, 1.0d, XIXIX.OOXIXo.f3760XO, "strides/min"));
        oixoxx0.f14429oxoX.get(19).f13530OOXIXo.get(0).II0xO0(25, 1L);
        oixoxx0.xxIXOIIO(new X0xII0I("max_cadence", 18, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type6));
        oixoxx0.f14429oxoX.get(20).f13530OOXIXo.add(new xxOoXO("max_running_cadence", 2, 1.0d, XIXIX.OOXIXo.f3760XO, "strides/min"));
        oixoxx0.f14429oxoX.get(20).f13530OOXIXo.get(0).II0xO0(25, 1L);
        oixoxx0.xxIXOIIO(new X0xII0I("avg_power", 19, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("max_power", 20, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("total_ascent", 21, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("total_descent", 22, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15467XI0IXoo, 23, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.INTENSITY));
        oixoxx0.xxIXOIIO(new X0xII0I("lap_trigger", 24, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.LAP_TRIGGER));
        oixoxx0.xxIXOIIO(new X0xII0I("sport", 25, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("event_group", 26, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("num_lengths", 32, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "lengths", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("normalized_power", 33, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("left_right_balance", 34, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.LEFT_RIGHT_BALANCE_100));
        oixoxx0.xxIXOIIO(new X0xII0I("first_length_index", 35, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_stroke_distance", 37, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("swim_stroke", 38, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SWIM_STROKE));
        oixoxx0.xxIXOIIO(new X0xII0I("sub_sport", 39, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SUB_SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("num_active_lengths", 40, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "lengths", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("total_work", 41, 134, 1.0d, XIXIX.OOXIXo.f3760XO, ContentClassification.AD_CONTENT_CLASSIFICATION_J, false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_altitude", 42, 132, 5.0d, 500.0d, "m", false, type5));
        oixoxx0.f14429oxoX.get(38).f13537xoIox.add(new oXX0IoI(112, false, 16, 5.0d, 500.0d));
        oixoxx0.xxIXOIIO(new X0xII0I("max_altitude", 43, 132, 5.0d, 500.0d, "m", false, type5));
        oixoxx0.f14429oxoX.get(39).f13537xoIox.add(new oXX0IoI(114, false, 16, 5.0d, 500.0d));
        oixoxx0.xxIXOIIO(new X0xII0I("gps_accuracy", 44, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type6));
        Profile.Type type7 = Profile.Type.SINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("avg_grade", 45, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_pos_grade", 46, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_neg_grade", 47, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("max_pos_grade", 48, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("max_neg_grade", 49, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type7));
        Profile.Type type8 = Profile.Type.SINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("avg_temperature", 50, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "C", false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("max_temperature", 51, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "C", false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("total_moving_time", 52, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_pos_vertical_speed", 53, 131, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_neg_vertical_speed", 54, 131, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("max_pos_vertical_speed", 55, 131, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("max_neg_vertical_speed", 56, 131, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_hr_zone", 57, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_speed_zone", 58, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_cadence_zone", 59, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_power_zone", 60, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("repetition_num", 61, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("min_altitude", 62, 132, 5.0d, 500.0d, "m", false, type5));
        oixoxx0.f14429oxoX.get(58).f13537xoIox.add(new oXX0IoI(113, false, 16, 5.0d, 500.0d));
        oixoxx0.xxIXOIIO(new X0xII0I("min_heart_rate", 63, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("wkt_step_index", 71, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("opponent_score", 74, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("stroke_count", 75, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "counts", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("zone_count", 76, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "counts", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_vertical_oscillation", 77, 132, 10.0d, XIXIX.OOXIXo.f3760XO, DateFormatUtils.MIN, false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_stance_time_percent", 78, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_stance_time", 79, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_fractional_cadence", 80, 2, 128.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("max_fractional_cadence", 81, 2, 128.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("total_fractional_cycles", 82, 2, 128.0d, XIXIX.OOXIXo.f3760XO, xOxOoo.f15473xoXoI, false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("player_score", 83, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_total_hemoglobin_conc", 84, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "g/dL", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("min_total_hemoglobin_conc", 85, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "g/dL", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("max_total_hemoglobin_conc", 86, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "g/dL", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_saturated_hemoglobin_percent", 87, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "%", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("min_saturated_hemoglobin_percent", 88, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "%", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("max_saturated_hemoglobin_percent", 89, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "%", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_torque_effectiveness", 91, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_torque_effectiveness", 92, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_pedal_smoothness", 93, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_pedal_smoothness", 94, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_combined_pedal_smoothness", 95, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("time_standing", 98, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("stand_count", 99, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_pco", 100, 1, 1.0d, XIXIX.OOXIXo.f3760XO, DateFormatUtils.MIN, false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_pco", 101, 1, 1.0d, XIXIX.OOXIXo.f3760XO, DateFormatUtils.MIN, false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_power_phase", 102, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_power_phase_peak", 103, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_power_phase", 104, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_power_phase_peak", 105, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_power_position", 106, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("max_power_position", 107, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_cadence_position", 108, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("max_cadence_position", 109, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_avg_speed", 110, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_max_speed", 111, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_avg_altitude", 112, 134, 5.0d, 500.0d, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_min_altitude", 113, 134, 5.0d, 500.0d, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_max_altitude", 114, 134, 5.0d, 500.0d, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_lev_motor_power", 115, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("max_lev_motor_power", 116, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("lev_battery_consumption", 117, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_vertical_ratio", 118, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_stance_time_balance", 119, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_step_length", 120, 132, 10.0d, XIXIX.OOXIXo.f3760XO, DateFormatUtils.MIN, false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_vam", 121, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_depth", 122, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("max_depth", 123, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("min_temperature", 124, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "C", false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_avg_respiration_rate", 136, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "Breaths/min", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_max_respiration_rate", 137, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "Breaths/min", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_respiration_rate", 147, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type6));
        oixoxx0.f14429oxoX.get(111).f13537xoIox.add(new oXX0IoI(136, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("max_respiration_rate", 148, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type6));
        oixoxx0.f14429oxoX.get(112).f13537xoIox.add(new oXX0IoI(137, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        Profile.Type type9 = Profile.Type.FLOAT32;
        oixoxx0.xxIXOIIO(new X0xII0I("total_grit", 149, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "kGrit", false, type9));
        oixoxx0.xxIXOIIO(new X0xII0I("total_flow", 150, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "Flow", false, type9));
        oixoxx0.xxIXOIIO(new X0xII0I("jump_count", 151, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_grit", 153, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "kGrit", false, type9));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_flow", 154, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "Flow", false, type9));
        oixoxx0.xxIXOIIO(new X0xII0I("total_fractional_ascent", 156, 2, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("total_fractional_descent", 157, 2, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_core_temperature", 158, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "C", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("min_core_temperature", 159, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "C", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("max_core_temperature", 160, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "C", false, type5));
    }

    public oXoXxOo() {
        super(x0OxxIOxX.XO(19));
    }

    public void I000X(Float f) {
        X0xxXX0(150, 0, f, 65535);
    }

    public Float I00O() {
        return XX(81, 0, 65535);
    }

    public void I0IIXxxo(Float f) {
        X0xxXX0(8, 0, f, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public Short I0Io() {
        return XI0oooXX(26, 0, 65535);
    }

    public void I0O00OI(Float f) {
        X0xxXX0(13, 0, f, 65535);
    }

    public Integer I0OO() {
        return oX(3, 0, 65535);
    }

    public void I0XIOxO(Float f) {
        X0xxXX0(123, 0, f, 65535);
    }

    public void II0(Integer num) {
        X0xxXX0(151, 0, num, 65535);
    }

    public Long II0OOXOx() {
        return x0xO(41, 0, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public Event II0xO0() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Event.getByValue(XI0oooXX2);
    }

    public int IIIxO() {
        return oOoIIO0(88, 65535);
    }

    public Float IIOIX() {
        return XX(119, 0, 65535);
    }

    public void IIXOxIxOo(Float f) {
        X0xxXX0(119, 0, f, 65535);
    }

    public Integer IIoX0OoI() {
        return oX(22, 0, 65535);
    }

    public Float IO0xX() {
        return XX(8, 0, 65535);
    }

    public Float[] IOI() {
        return xo0x(57, 65535);
    }

    public Integer IOOXOOOOo() {
        return oX(21, 0, 65535);
    }

    public Integer IOOoXo0Ix() {
        return oX(5, 0, 65535);
    }

    public SubSport IOXOxOII() {
        Short XI0oooXX2 = XI0oooXX(39, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SubSport.getByValue(XI0oooXX2);
    }

    public Integer IOo0() {
        return oX(71, 0, 65535);
    }

    public void IOooo0o(Float f) {
        X0xxXX0(80, 0, f, 65535);
    }

    public void IXI(int i, Float f) {
        X0xxXX0(104, i, f, 65535);
    }

    public void IXIIo(Byte b) {
        X0xxXX0(101, 0, b, 65535);
    }

    public Integer IXIxx0() {
        return oX(32, 0, 65535);
    }

    public Integer IXX() {
        return oX(254, 0, 65535);
    }

    public int IXXIXx00I() {
        return oOoIIO0(109, 65535);
    }

    public void IXo(Float f) {
        X0xxXX0(78, 0, f, 65535);
    }

    public Short[] IXoIo() {
        return xoO0xx0(109, 65535);
    }

    public int IXxOIOO() {
        return oOoIIO0(106, 65535);
    }

    public Short IoX() {
        return XI0oooXX(63, 0, 65535);
    }

    public Float[] IoXO0XoX() {
        return xo0x(60, 65535);
    }

    public Long IoxOx() {
        return x0xO(10, 0, 65535);
    }

    public void IoxX(Short sh) {
        X0xxXX0(147, 0, sh, 65535);
    }

    public void IoxoI0IX(Float f) {
        X0xxXX0(82, 0, f, 65535);
    }

    public Float Ix0() {
        return XX(136, 0, 65535);
    }

    public void Ix00(Long l) {
        X0xxXX0(10, 0, l, 0);
    }

    public Short Ix0x() {
        return XI0oooXX(18, 0, 0);
    }

    public Float IxI() {
        return XX(55, 0, 65535);
    }

    public Float IxIo(int i) {
        return XX(84, i, 65535);
    }

    public o0xxxXXxX IxO0Oxo() {
        return oXX0IoI(x0xO(2, 0, 65535));
    }

    public void IxOIO(Float f) {
        X0xxXX0(112, 0, f, 65535);
    }

    public void IxOXOxO(Float f) {
        X0xxXX0(79, 0, f, 65535);
    }

    public Float IxX00(int i) {
        return XX(102, i, 65535);
    }

    public void IxoOxx(int i, Float f) {
        X0xxXX0(89, i, f, 65535);
    }

    public Float O00() {
        return XX(153, 0, 65535);
    }

    public void O0IoXXOx(Float f) {
        X0xxXX0(46, 0, f, 65535);
    }

    public Integer O0O0Io00X() {
        return oX(33, 0, 65535);
    }

    public Integer O0OOX0IIx() {
        return oX(35, 0, 65535);
    }

    public void O0OOoIox(Integer num) {
        X0xxXX0(22, 0, num, 65535);
    }

    public void O0OoXI(Float f) {
        X0xxXX0(121, 0, f, 65535);
    }

    public Float O0o0(int i) {
        return XX(86, i, 65535);
    }

    public void O0o000XOX(int i, Short sh) {
        X0xxXX0(109, i, sh, 65535);
    }

    public Float O0x() {
        return XX(117, 0, 65535);
    }

    public void O0x0XXxI(Integer num) {
        X0xxXX0(83, 0, num, 65535);
    }

    public int O0xO0() {
        return oOoIIO0(84, 65535);
    }

    public Byte O0xxXxI() {
        return XxX0x0xxx(100, 0, 65535);
    }

    public int OI0IXox() {
        return oOoIIO0(60, 65535);
    }

    public void OIII0O(int i, Float f) {
        X0xxXX0(103, i, f, 65535);
    }

    public Integer OIIXOxo() {
        return oX(40, 0, 65535);
    }

    public void OIOxOX(Integer num) {
        X0xxXX0(71, 0, num, 65535);
    }

    public Integer OIoxIx(int i) {
        return oX(107, i, 65535);
    }

    public Float OIx00oxx() {
        return XX(154, 0, 65535);
    }

    public Float OIx0xoOo() {
        return XX(150, 0, 65535);
    }

    public Float[] OIxI0O() {
        return xo0x(86, 65535);
    }

    public void OIxOIX0II(Float f) {
        X0xxXX0(95, 0, f, 65535);
    }

    public Short OIxOX() {
        return XI0oooXX(18, 0, 65535);
    }

    public Intensity OIxx0I0() {
        Short XI0oooXX2 = XI0oooXX(23, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Intensity.getByValue(XI0oooXX2);
    }

    public Float OO0() {
        return XX(158, 0, 65535);
    }

    public Float[] OOIXx0x() {
        return xo0x(105, 65535);
    }

    public Float OOOI() {
        return XX(46, 0, 65535);
    }

    public Float OOOox(int i) {
        return XX(60, i, 65535);
    }

    public void OOOxXxoO(Float f) {
        X0xxXX0(98, 0, f, 65535);
    }

    public void OOX0x(int i, Float f) {
        X0xxXX0(59, i, f, 65535);
    }

    public void OOo(SwimStroke swimStroke) {
        X0xxXX0(38, 0, Short.valueOf(swimStroke.value), 65535);
    }

    public void OOoOoO0o(int i, Integer num) {
        X0xxXX0(106, i, num, 65535);
    }

    public Float OOxOI() {
        return XX(94, 0, 65535);
    }

    public Float OOxOOxIO(int i) {
        return XX(89, i, 65535);
    }

    public Short OX() {
        return XI0oooXX(17, 0, 65535);
    }

    public void OX00o0X(Float f) {
        X0xxXX0(45, 0, f, 65535);
    }

    public Float OXIOoo0X0() {
        return XX(160, 0, 65535);
    }

    public void OXOo(Short sh) {
        X0xxXX0(17, 0, sh, 0);
    }

    public Float[] OXXoIoXI() {
        return xo0x(104, 65535);
    }

    public void OXoIXx(Integer num) {
        X0xxXX0(11, 0, num, 65535);
    }

    public Short OXooXo() {
        return XI0oooXX(148, 0, 65535);
    }

    public Float OXxx0OO() {
        return XX(149, 0, 65535);
    }

    public void Oo0IXI0(Float f) {
        X0xxXX0(92, 0, f, 65535);
    }

    public void Oo0xX(Float f) {
        X0xxXX0(137, 0, f, 65535);
    }

    public Float OoI0OO(int i) {
        return XX(57, i, 65535);
    }

    public Byte OoIXo() {
        return XxX0x0xxx(124, 0, 65535);
    }

    public void OoOoXO0(Float f) {
        X0xxXX0(53, 0, f, 65535);
    }

    public void OoOoxX0xo(Byte b) {
        X0xxXX0(51, 0, b, 65535);
    }

    public Float OooI() {
        return XX(122, 0, 65535);
    }

    public LapTrigger OooO0XOx() {
        Short XI0oooXX2 = XI0oooXX(24, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return LapTrigger.getByValue(XI0oooXX2);
    }

    public int Oox() {
        return oOoIIO0(57, 65535);
    }

    public void OoxOxII(Short sh) {
        X0xxXX0(15, 0, sh, 65535);
    }

    public void OoxxX(Float f) {
        X0xxXX0(110, 0, f, 65535);
    }

    public void Ox(Byte b) {
        X0xxXX0(50, 0, b, 65535);
    }

    public Integer[] Ox00XOXoo() {
        return xoxXI(76, 65535);
    }

    public void Ox0XO(Integer num) {
        X0xxXX0(19, 0, num, 65535);
    }

    public void OxI0(Float f) {
        X0xxXX0(7, 0, f, 65535);
    }

    public Float OxIxx0() {
        return XX(98, 0, 65535);
    }

    public Integer OxO(int i) {
        return oX(106, i, 65535);
    }

    public void OxXXx0OX(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public Float OxXXx0X() {
        return XX(54, 0, 65535);
    }

    public Float Oxo00O() {
        return XX(112, 0, 65535);
    }

    public Float Oxx() {
        return XX(42, 0, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void Oxx0IOOO(Short sh) {
        X0xxXX0(26, 0, sh, 65535);
    }

    public void OxxIXIX(Integer num) {
        X0xxXX0(32, 0, num, 65535);
    }

    public void Oxxo(Float f) {
        X0xxXX0(93, 0, f, 65535);
    }

    public Integer X0() {
        return oX(99, 0, 65535);
    }

    public int X00IxOx() {
        return oOoIIO0(58, 65535);
    }

    public Byte X00xOoXI() {
        return XxX0x0xxx(101, 0, 65535);
    }

    public Integer X0IOOI() {
        return oX(6, 0, 65535);
    }

    public void X0Ix00XxO(Float f) {
        X0xxXX0(157, 0, f, 65535);
    }

    public Integer X0O0I0() {
        return oX(19, 0, 65535);
    }

    public void X0OXI(Integer num) {
        X0xxXX0(4, 0, num, 65535);
    }

    public Long X0OXX() {
        return x0xO(10, 0, 0);
    }

    @Override // com.garmin.fit.XIxO
    public EventType X0o0xo() {
        Short XI0oooXX2 = XI0oooXX(1, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return EventType.getByValue(XI0oooXX2);
    }

    public void X0oX(Float f) {
        X0xxXX0(56, 0, f, 65535);
    }

    public Float X0ooXIooI() {
        return XX(120, 0, 65535);
    }

    public int X0x() {
        return oOoIIO0(75, 65535);
    }

    public Float X0xOO(int i) {
        return XX(85, i, 65535);
    }

    public Float[] XIOOI() {
        return xo0x(89, 65535);
    }

    public void XIo(Integer num) {
        X0xxXX0(20, 0, num, 65535);
    }

    public void XIoox00ox(Long l) {
        X0xxXX0(41, 0, l, 65535);
    }

    public int XIxO() {
        return oOoIIO0(89, 65535);
    }

    public void XIxoOo0oI(int i, Float f) {
        X0xxXX0(88, i, f, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void XO(EventType eventType) {
        X0xxXX0(1, 0, Short.valueOf(eventType.value), 65535);
    }

    public void XO0(int i, Float f) {
        X0xxXX0(87, i, f, 65535);
    }

    public Float XO00XOO(int i) {
        return XX(104, i, 65535);
    }

    public int XO0OX() {
        return oOoIIO0(59, 65535);
    }

    public Float[] XO0o() {
        return xo0x(102, 65535);
    }

    public void XOOI0(int i, Integer num) {
        X0xxXX0(76, i, num, 65535);
    }

    public void XOOO0O(Float f) {
        X0xxXX0(42, 0, f, 65535);
    }

    public Float XOo0() {
        return XX(159, 0, 65535);
    }

    public void XOoxOOO(Short sh) {
        X0xxXX0(63, 0, sh, 65535);
    }

    public void XOx(int i, Float f) {
        X0xxXX0(105, i, f, 65535);
    }

    public void XOx0xX(Integer num) {
        X0xxXX0(33, 0, num, 65535);
    }

    public Float XOxoX() {
        return XX(121, 0, 65535);
    }

    public Float[] XXIoX0() {
        return xo0x(59, 65535);
    }

    public Float XXO0() {
        return XX(156, 0, 65535);
    }

    public void XXoO0oX(Integer num) {
        X0xxXX0(115, 0, num, 65535);
    }

    public void XXooOOI(int i, Float f) {
        X0xxXX0(102, i, f, 65535);
    }

    public Integer XXx0OXXXo() {
        return oX(11, 0, 65535);
    }

    public Float Xo() {
        return XX(13, 0, 65535);
    }

    public void XoIoOXOIx(Integer num) {
        X0xxXX0(35, 0, num, 65535);
    }

    public Float XoIxOXIXo() {
        return XX(95, 0, 65535);
    }

    public void XoOOOXox(Integer num) {
        X0xxXX0(34, 0, num, 65535);
    }

    public Integer XoOOx0IX(int i) {
        return oX(75, i, 65535);
    }

    public Float XoOxI0ox() {
        return XX(78, 0, 65535);
    }

    public Float XooIO0oo0(int i) {
        return XX(105, i, 65535);
    }

    public void Xooo0Xx(Integer num) {
        X0xxXX0(12, 0, num, 65535);
    }

    public void Xox0o(Float f) {
        X0xxXX0(159, 0, f, 65535);
    }

    public Float Xx() {
        return XX(52, 0, 65535);
    }

    public Long Xx0() {
        return x0xO(10, 0, 1);
    }

    public void Xx0oX(Short sh) {
        X0xxXX0(18, 0, sh, 65535);
    }

    public int XxI() {
        return oOoIIO0(103, 65535);
    }

    public void XxI0(int i, Float f) {
        X0xxXX0(86, i, f, 65535);
    }

    public Float[] XxIIOXIXx() {
        return xo0x(85, 65535);
    }

    public void XxIO0(Integer num) {
        X0xxXX0(21, 0, num, 65535);
    }

    public Integer XxIOX(int i) {
        return oX(76, i, 65535);
    }

    public Float XxIo() {
        return XX(137, 0, 65535);
    }

    public void XxOOoxOO(Float f) {
        X0xxXX0(48, 0, f, 65535);
    }

    public Integer XxXX() {
        return oX(34, 0, 65535);
    }

    public void XxoOI00IX(Byte b) {
        X0xxXX0(124, 0, b, 65535);
    }

    public void Xxx0oXX(Float f) {
        X0xxXX0(91, 0, f, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float o00xOoIO() {
        return XX(48, 0, 65535);
    }

    public void o0I0O0oXX(Integer num) {
        X0xxXX0(99, 0, num, 65535);
    }

    public Short[] o0IXXIx() {
        return xoO0xx0(108, 65535);
    }

    public Float o0OO0() {
        return XX(49, 0, 65535);
    }

    public Float o0Oo() {
        return XX(43, 0, 65535);
    }

    public void o0Oox0xox(int i, Integer num) {
        X0xxXX0(107, i, num, 65535);
    }

    public Short o0Xo() {
        return XI0oooXX(147, 0, 65535);
    }

    public void o0Xo0XII(Float f) {
        X0xxXX0(14, 0, f, 65535);
    }

    public void o0oIxXOx(Float f) {
        X0xxXX0(158, 0, f, 65535);
    }

    public Float o0oxo0oI() {
        return XX(53, 0, 65535);
    }

    public void o0xIIX0(int i, Short sh) {
        X0xxXX0(108, i, sh, 65535);
    }

    public Float o0xIoII(int i) {
        return XX(59, i, 65535);
    }

    public Sport o0xOIoxo() {
        Short XI0oooXX2 = XI0oooXX(25, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Sport.getByValue(XI0oooXX2);
    }

    public Float oI0(int i) {
        return XX(88, i, 65535);
    }

    public Float oI00o() {
        return XX(7, 0, 65535);
    }

    public int oI0X0() {
        return oOoIIO0(108, 65535);
    }

    public void oII(Float f) {
        X0xxXX0(49, 0, f, 65535);
    }

    public void oIX0o(Float f) {
        X0xxXX0(54, 0, f, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public int oIXoXx0() {
        return oOoIIO0(102, 65535);
    }

    public void oIoIXxIO(Intensity intensity) {
        X0xxXX0(23, 0, Short.valueOf(intensity.value), 65535);
    }

    public void oIoIxo(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(2, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oIoxI0xx(Float f) {
        X0xxXX0(77, 0, f, 65535);
    }

    public void oIxOXo(Float f) {
        X0xxXX0(118, 0, f, 65535);
    }

    public void oIxXX0Xo(Integer num) {
        X0xxXX0(40, 0, num, 65535);
    }

    public void oIxXXOI(Integer num) {
        X0xxXX0(116, 0, num, 65535);
    }

    public void oIxxIo(Integer num) {
        X0xxXX0(6, 0, num, 65535);
    }

    public void oO0(int i, Float f) {
        X0xxXX0(84, i, f, 65535);
    }

    public Short oO0IXx() {
        return XI0oooXX(16, 0, 65535);
    }

    public void oO0OX0(Short sh) {
        X0xxXX0(17, 0, sh, 65535);
    }

    public Float oOIXoIXXI() {
        return XX(9, 0, 65535);
    }

    public Integer oOIx() {
        return oX(83, 0, 65535);
    }

    public void oOo0o(Short sh) {
        X0xxXX0(148, 0, sh, 65535);
    }

    public void oOx0xoXI(Integer num) {
        X0xxXX0(74, 0, num, 65535);
    }

    public void oOxoXxoX(int i, Float f) {
        X0xxXX0(85, i, f, 65535);
    }

    public void oOxxXI(Float f) {
        X0xxXX0(113, 0, f, 65535);
    }

    public Float oX000x() {
        return XX(37, 0, 65535);
    }

    public Float oX0I0O(int i) {
        return XX(103, i, 65535);
    }

    public void oX0O(Float f) {
        X0xxXX0(114, 0, f, 65535);
    }

    public Integer oX0ooo0I0() {
        return oX(115, 0, 65535);
    }

    public int oXIoIo() {
        return oOoIIO0(76, 65535);
    }

    public Short oXIoO(int i) {
        return XI0oooXX(108, i, 65535);
    }

    public Float oXO0oOx0() {
        return XX(79, 0, 65535);
    }

    public Integer[] oXoXxOo() {
        return xoxXI(107, 65535);
    }

    public SwimStroke oXxOXOX() {
        Short XI0oooXX2 = XI0oooXX(38, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SwimStroke.getByValue(XI0oooXX2);
    }

    public Short oXxx000() {
        return XI0oooXX(17, 0, 0);
    }

    public Float oo00() {
        return XX(47, 0, 65535);
    }

    public void oo00Io(Short sh) {
        X0xxXX0(18, 0, sh, 0);
    }

    public Float oo0oIXo() {
        return XX(113, 0, 65535);
    }

    public Integer ooO0oXxI() {
        return oX(116, 0, 65535);
    }

    public void oooO0oo(Sport sport) {
        X0xxXX0(25, 0, Short.valueOf(sport.value), 65535);
    }

    public void oox(Float f) {
        X0xxXX0(156, 0, f, 65535);
    }

    public Float oox000IX() {
        return XX(14, 0, 65535);
    }

    public void ox0(Float f) {
        X0xxXX0(153, 0, f, 65535);
    }

    public Byte ox0I() {
        return XxX0x0xxx(51, 0, 65535);
    }

    public Float oxIO0IIo() {
        return XX(111, 0, 65535);
    }

    public void oxO(Float f) {
        X0xxXX0(94, 0, f, 65535);
    }

    public void oxOII(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public Integer oxOIoIx() {
        return oX(12, 0, 65535);
    }

    public Float oxOXxoXII() {
        return XX(93, 0, 65535);
    }

    public void oxXIOXO(Float f) {
        X0xxXX0(160, 0, f, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void oxoX(Event event) {
        X0xxXX0(0, 0, Short.valueOf(event.value), 65535);
    }

    public Float[] x00IOx() {
        return xo0x(103, 65535);
    }

    public Float x00X0xoXO() {
        return XX(62, 0, 65535);
    }

    public void x0Io0(LapTrigger lapTrigger) {
        X0xxXX0(24, 0, Short.valueOf(lapTrigger.value), 65535);
    }

    public void x0Ix0O(int i, Float f) {
        X0xxXX0(60, i, f, 65535);
    }

    public void x0OI(Short sh) {
        X0xxXX0(16, 0, sh, 65535);
    }

    public Short x0OOI(int i) {
        return XI0oooXX(109, i, 65535);
    }

    public Float x0oox0() {
        return XX(123, 0, 65535);
    }

    public Float[] x0oxIIIX() {
        return xo0x(84, 65535);
    }

    public Float x0xOIoO() {
        return XX(82, 0, 65535);
    }

    public void xI0OXooO(Float f) {
        X0xxXX0(154, 0, f, 65535);
    }

    public void xI0Ooxx0x(Float f) {
        X0xxXX0(43, 0, f, 65535);
    }

    public void xIIoO(Float f) {
        X0xxXX0(81, 0, f, 65535);
    }

    public void xIOI0xO(int i, Float f) {
        X0xxXX0(57, i, f, 65535);
    }

    public void xIOOIO(Long l) {
        X0xxXX0(10, 0, l, 1);
    }

    public Byte xIOXX() {
        return XxX0x0xxx(50, 0, 65535);
    }

    public Float xIXIOX() {
        return XX(77, 0, 65535);
    }

    public Integer xIXOoI() {
        return oX(20, 0, 65535);
    }

    public Float xIXX() {
        return XX(80, 0, 65535);
    }

    public void xIXXIo(Float f) {
        X0xxXX0(149, 0, f, 65535);
    }

    public Float[] xIXoO0Xx() {
        return xo0x(58, 65535);
    }

    public void xIo0xoOOx(Float f) {
        X0xxXX0(52, 0, f, 65535);
    }

    public Float[] xIoXXXIXo() {
        return xo0x(88, 65535);
    }

    public Float[] xIx() {
        return xo0x(87, 65535);
    }

    public Float xIx0XO() {
        return XX(92, 0, 65535);
    }

    public Float xIxooxXX() {
        return XX(114, 0, 65535);
    }

    public void xOI0(Float f) {
        X0xxXX0(47, 0, f, 65535);
    }

    public void xOIO(Integer num) {
        X0xxXX0(5, 0, num, 65535);
    }

    public void xOIx00(Short sh) {
        X0xxXX0(44, 0, sh, 65535);
    }

    public Float xOOxI(int i) {
        return XX(87, i, 65535);
    }

    public Short xOOxIO() {
        return XI0oooXX(15, 0, 65535);
    }

    public void xOOxX(SubSport subSport) {
        X0xxXX0(39, 0, Short.valueOf(subSport.value), 65535);
    }

    public void xOXoxI(Integer num) {
        X0xxXX0(61, 0, num, 65535);
    }

    public Integer xOoIIIoXI() {
        return oX(74, 0, 65535);
    }

    public void xOx(Float f) {
        X0xxXX0(122, 0, f, 65535);
    }

    public Integer xOxOoo() {
        return oX(61, 0, 65535);
    }

    public Integer xOxxXO() {
        return oX(4, 0, 65535);
    }

    public Float xX() {
        return XX(91, 0, 65535);
    }

    public int xX0ox() {
        return oOoIIO0(104, 65535);
    }

    public void xXIX0Xo(Byte b) {
        X0xxXX0(100, 0, b, 65535);
    }

    public void xXO0oXX(Float f) {
        X0xxXX0(55, 0, f, 65535);
    }

    public void xXXxoI(Float f) {
        X0xxXX0(37, 0, f, 65535);
    }

    public Float xXo() {
        return XX(56, 0, 65535);
    }

    public void xXx0x0(int i, Float f) {
        X0xxXX0(58, i, f, 65535);
    }

    public Float xo() {
        return XX(118, 0, 65535);
    }

    public void xoIIIOI(int i, Integer num) {
        X0xxXX0(75, i, num, 65535);
    }

    public int xoIXOxX() {
        return oOoIIO0(105, 65535);
    }

    public Short xoX() {
        return XI0oooXX(44, 0, 65535);
    }

    public void xooXo(Long l) {
        X0xxXX0(10, 0, l, 65535);
    }

    public int xooxxX() {
        return oOoIIO0(87, 65535);
    }

    public Float xox() {
        return XX(110, 0, 65535);
    }

    public Float xoxo() {
        return XX(157, 0, 65535);
    }

    public Float xx(int i) {
        return XX(58, i, 65535);
    }

    public Integer xx0() {
        return oX(151, 0, 65535);
    }

    public Integer[] xx00oOoI() {
        return xoxXI(75, 65535);
    }

    public void xx0O(Float f) {
        X0xxXX0(120, 0, f, 65535);
    }

    public int xx0o0O() {
        return oOoIIO0(107, 65535);
    }

    public void xxOoXO(Float f) {
        X0xxXX0(117, 0, f, 65535);
    }

    public void xxX0X(Float f) {
        X0xxXX0(9, 0, f, 65535);
    }

    public int xxXXXxIxo() {
        return oOoIIO0(85, 65535);
    }

    public void xxXooOI(Float f) {
        X0xxXX0(62, 0, f, 65535);
    }

    public void xxoXO(Float f) {
        X0xxXX0(111, 0, f, 65535);
    }

    public void xxx(Float f) {
        X0xxXX0(136, 0, f, 65535);
    }

    public Integer[] xxx00() {
        return xoxXI(106, 65535);
    }

    public Float xxxI() {
        return XX(45, 0, 65535);
    }

    public int xxxoo0XI() {
        return oOoIIO0(86, 65535);
    }

    public oXoXxOo(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
