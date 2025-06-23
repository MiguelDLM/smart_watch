package com.garmin.fit;

import androidx.core.app.NotificationCompat;
import com.garmin.fit.Profile;
import com.huawei.hms.ads.ContentClassification;
import com.sma.smartv3.network.BaiDu;
import com.tenmeter.smlibrary.utils.DateFormatUtils;

/* loaded from: classes9.dex */
public class OX00o0X extends oIXoXx0 implements XIxO {

    /* renamed from: I0, reason: collision with root package name */
    public static final int f12632I0 = 71;

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public static final int f12633I0X0x0oIo = 49;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public static final int f12634I0oOIX = 54;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public static final int f12635I0oOoX = 42;

    /* renamed from: I0xX0, reason: collision with root package name */
    public static final int f12636I0xX0 = 130;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12637II0XooXoX = 254;

    /* renamed from: IIX0, reason: collision with root package name */
    public static final int f12638IIX0 = 91;

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final int f12639IIX0o = 24;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f12640IIXOooo = 13;

    /* renamed from: IIxOXoOo0, reason: collision with root package name */
    public static final int f12641IIxOXoOo0 = 70;

    /* renamed from: IO, reason: collision with root package name */
    public static final int f12642IO = 33;

    /* renamed from: IO0XoXxO, reason: collision with root package name */
    public static final int f12643IO0XoXxO = 122;

    /* renamed from: IOoo, reason: collision with root package name */
    public static final int f12644IOoo = 126;

    /* renamed from: IXO, reason: collision with root package name */
    public static final int f12645IXO = 111;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f12646IXxxXO = 8;

    /* renamed from: Io, reason: collision with root package name */
    public static final int f12647Io = 38;

    /* renamed from: IoIOOxIIo, reason: collision with root package name */
    public static final int f12648IoIOOxIIo = 97;

    /* renamed from: IoOoX, reason: collision with root package name */
    public static final int f12649IoOoX = 29;

    /* renamed from: IoOoo, reason: collision with root package name */
    public static final int f12650IoOoo = 57;

    /* renamed from: IoXIXo, reason: collision with root package name */
    public static final int f12651IoXIXo = 115;

    /* renamed from: Ioxxx, reason: collision with root package name */
    public static final int f12652Ioxxx = 62;

    /* renamed from: Ix00oIoI, reason: collision with root package name */
    public static final int f12653Ix00oIoI = 113;

    /* renamed from: IxIX0I, reason: collision with root package name */
    public static final int f12654IxIX0I = 105;

    /* renamed from: IxX00, reason: collision with root package name */
    public static final int f12655IxX00 = 148;

    /* renamed from: O0, reason: collision with root package name */
    public static final int f12656O0 = 94;

    /* renamed from: O00, reason: collision with root package name */
    public static final int f12657O00 = 144;

    /* renamed from: O00XxXI, reason: collision with root package name */
    public static final int f12658O00XxXI = 66;

    /* renamed from: O0IxXx, reason: collision with root package name */
    public static final int f12659O0IxXx = 114;

    /* renamed from: O0X, reason: collision with root package name */
    public static final int f12660O0X = 90;

    /* renamed from: O0Xx, reason: collision with root package name */
    public static final int f12661O0Xx = 53;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f12662O0xOxO = 17;

    /* renamed from: O0xxXxI, reason: collision with root package name */
    public static final int f12663O0xxXxI = 146;

    /* renamed from: OI0, reason: collision with root package name */
    public static final int f12664OI0 = 37;

    /* renamed from: OIOoIIOIx, reason: collision with root package name */
    public static final int f12665OIOoIIOIx = 102;

    /* renamed from: OIx00oxx, reason: collision with root package name */
    public static final int f12666OIx00oxx = 141;

    /* renamed from: OO, reason: collision with root package name */
    public static final int f12667OO = 56;

    /* renamed from: OO0, reason: collision with root package name */
    public static final int f12668OO0 = 139;

    /* renamed from: OO0x0xX, reason: collision with root package name */
    public static final int f12669OO0x0xX = 60;

    /* renamed from: OOIXx0x, reason: collision with root package name */
    public static final int f12670OOIXx0x = 198;

    /* renamed from: OOOI, reason: collision with root package name */
    public static final int f12671OOOI = 180;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12672OOXIXo = 1;

    /* renamed from: OOXIxO0, reason: collision with root package name */
    public static final int f12673OOXIxO0 = 69;

    /* renamed from: OOxOI, reason: collision with root package name */
    public static final int f12674OOxOI = 193;

    /* renamed from: OX, reason: collision with root package name */
    public static final int f12675OX = 132;

    /* renamed from: OX00O0xII, reason: collision with root package name */
    public static final int f12676OX00O0xII = 84;

    /* renamed from: OXXoIoXI, reason: collision with root package name */
    public static final int f12677OXXoIoXI = 195;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f12678Oo = 7;

    /* renamed from: OoO, reason: collision with root package name */
    public static final int f12679OoO = 101;

    /* renamed from: OooI, reason: collision with root package name */
    public static final int f12680OooI = 140;

    /* renamed from: Ox0O, reason: collision with root package name */
    public static final int f12681Ox0O = 93;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f12682OxI = 16;

    /* renamed from: OxO, reason: collision with root package name */
    public static final int f12683OxO = 183;

    /* renamed from: OxXXx0X, reason: collision with root package name */
    public static final int f12684OxXXx0X = 170;

    /* renamed from: Oxx, reason: collision with root package name */
    public static final int f12685Oxx = 131;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f12686Oxx0xo = 9;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f12687OxxIIOOXO = 11;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public static final int f12688X00IoxXI = 32;

    /* renamed from: X00xOoXI, reason: collision with root package name */
    public static final int f12689X00xOoXI = 192;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f12690X0IIOO = 18;

    /* renamed from: X0O0I0, reason: collision with root package name */
    public static final int f12691X0O0I0 = 182;

    /* renamed from: X0xII0I, reason: collision with root package name */
    public static final int f12692X0xII0I = 120;

    /* renamed from: X0xxXX0, reason: collision with root package name */
    public static final int f12693X0xxXX0 = 121;

    /* renamed from: XI, reason: collision with root package name */
    public static final int f12694XI = 125;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f12695XI0IXoo = 19;

    /* renamed from: XI0oooXX, reason: collision with root package name */
    public static final int f12696XI0oooXX = 68;

    /* renamed from: XIXIX, reason: collision with root package name */
    public static final int f12697XIXIX = 87;

    /* renamed from: XIXIxO, reason: collision with root package name */
    public static final int f12698XIXIxO = 100;

    /* renamed from: XIo0oOXIx, reason: collision with root package name */
    public static final int f12699XIo0oOXIx = 61;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f12700XIxXXX0x0 = 20;

    /* renamed from: XO00XOO, reason: collision with root package name */
    public static final int f12701XO00XOO = 194;

    /* renamed from: XO0o, reason: collision with root package name */
    public static final int f12702XO0o = 149;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public static final int f12703XOxIOxOx = 36;

    /* renamed from: XOxxooXI, reason: collision with root package name */
    public static final int f12704XOxxooXI = 124;

    /* renamed from: XX, reason: collision with root package name */
    public static final int f12705XX = 41;

    /* renamed from: XX0, reason: collision with root package name */
    public static final int f12706XX0 = 48;

    /* renamed from: XX0xXo, reason: collision with root package name */
    public static final int f12707XX0xXo = 64;

    /* renamed from: XXXI, reason: collision with root package name */
    public static final int f12708XXXI = 129;

    /* renamed from: XXoOx0, reason: collision with root package name */
    public static final int f12709XXoOx0 = 104;

    /* renamed from: Xo, reason: collision with root package name */
    public static final int f12710Xo = 210;

    /* renamed from: Xo0, reason: collision with root package name */
    public static final int f12711Xo0 = 51;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public static final int f12712XoI0Ixx0 = 52;

    /* renamed from: XoIxOXIXo, reason: collision with root package name */
    public static final int f12713XoIxOXIXo = 137;

    /* renamed from: XoX, reason: collision with root package name */
    public static final int f12714XoX = 44;

    /* renamed from: XooIO0oo0, reason: collision with root package name */
    public static final int f12715XooIO0oo0 = 197;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public static final int f12716Xx000oIo = 31;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final int f12717XxX0x0xxx = 22;

    /* renamed from: o0, reason: collision with root package name */
    public static final int f12718o0 = 39;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f12719o00 = 15;

    /* renamed from: o0IXXIx, reason: collision with root package name */
    public static final int f12720o0IXXIx = 134;

    /* renamed from: o0Xo, reason: collision with root package name */
    public static final int f12721o0Xo = 187;

    /* renamed from: o0oIxOo, reason: collision with root package name */
    public static final int f12722o0oIxOo = 99;

    /* renamed from: o0oxo0oI, reason: collision with root package name */
    public static final int f12723o0oxo0oI = 181;

    /* renamed from: o0xxxXXxX, reason: collision with root package name */
    public static final int f12724o0xxxXXxX = 65;

    /* renamed from: oI, reason: collision with root package name */
    public static final int f12725oI = 112;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f12726oI0IIXIo = 10;

    /* renamed from: oIIxXoo, reason: collision with root package name */
    public static final int f12727oIIxXoo = 127;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f12728oO = 5;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public static final int f12729oOXoIIIo = 30;

    /* renamed from: oOo, reason: collision with root package name */
    public static final int f12730oOo = 89;

    /* renamed from: oOoIIO0, reason: collision with root package name */
    public static final int f12731oOoIIO0 = 110;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12732oOoXoXO = 2;

    /* renamed from: oX, reason: collision with root package name */
    public static final int f12733oX = 50;

    /* renamed from: oX0I0O, reason: collision with root package name */
    public static final int f12734oX0I0O = 150;

    /* renamed from: oX0ooo0I0, reason: collision with root package name */
    public static final int f12735oX0ooo0I0 = 168;

    /* renamed from: oXIO0o0XI, reason: collision with root package name */
    public static final int f12736oXIO0o0XI = 88;

    /* renamed from: oXIoO, reason: collision with root package name */
    public static final int f12737oXIoO = 133;

    /* renamed from: oXO0oOx0, reason: collision with root package name */
    public static final oIXoXx0 f12738oXO0oOx0;

    /* renamed from: oXX0IoI, reason: collision with root package name */
    public static final int f12739oXX0IoI = 128;

    /* renamed from: oXxOI0oIx, reason: collision with root package name */
    public static final int f12740oXxOI0oIx = 123;

    /* renamed from: oXxx000, reason: collision with root package name */
    public static final int f12741oXxx000 = 200;

    /* renamed from: oo, reason: collision with root package name */
    public static final int f12742oo = 28;

    /* renamed from: oo00, reason: collision with root package name */
    public static final int f12743oo00 = 169;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static final int f12744oo0xXOI0I = 27;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f12745ooOOo0oXI = 3;

    /* renamed from: ooOx, reason: collision with root package name */
    public static final int f12746ooOx = 82;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final int f12747ooXIXxIX = 25;

    /* renamed from: ox, reason: collision with root package name */
    public static final int f12748ox = 67;

    /* renamed from: oxIIX0o, reason: collision with root package name */
    public static final int f12749oxIIX0o = 98;

    /* renamed from: oxOXxoXII, reason: collision with root package name */
    public static final int f12750oxOXxoXII = 147;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public static final int f12751oxXx0IX = 45;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public static final int f12752oxxXoxO = 43;

    /* renamed from: x0, reason: collision with root package name */
    public static final int f12753x0 = 119;

    /* renamed from: x00IOx, reason: collision with root package name */
    public static final int f12754x00IOx = 155;

    /* renamed from: x0OIX00oO, reason: collision with root package name */
    public static final int f12755x0OIX00oO = 103;

    /* renamed from: x0OxxIOxX, reason: collision with root package name */
    public static final int f12756x0OxxIOxX = 118;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f12757x0XOIxOo = 4;

    /* renamed from: x0o, reason: collision with root package name */
    public static final int f12758x0o = 35;

    /* renamed from: x0xO, reason: collision with root package name */
    public static final int f12759x0xO = 59;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f12760x0xO0oo = 6;

    /* renamed from: xI, reason: collision with root package name */
    public static final int f12761xI = 26;

    /* renamed from: xI0oxI00, reason: collision with root package name */
    public static final int f12762xI0oxI00 = 96;

    /* renamed from: xII, reason: collision with root package name */
    public static final int f12763xII = 34;

    /* renamed from: xIXX, reason: collision with root package name */
    public static final int f12764xIXX = 142;

    /* renamed from: xIx, reason: collision with root package name */
    public static final int f12765xIx = 209;

    /* renamed from: xIx0XO, reason: collision with root package name */
    public static final int f12766xIx0XO = 199;

    /* renamed from: xOOOX, reason: collision with root package name */
    public static final int f12767xOOOX = 86;

    /* renamed from: xOOxI, reason: collision with root package name */
    public static final int f12768xOOxI = 208;

    /* renamed from: xOOxIO, reason: collision with root package name */
    public static final int f12769xOOxIO = 145;

    /* renamed from: xOoOIoI, reason: collision with root package name */
    public static final int f12770xOoOIoI = 92;

    /* renamed from: xX, reason: collision with root package name */
    public static final int f12771xX = 156;

    /* renamed from: xX0IIXIx0, reason: collision with root package name */
    public static final int f12772xX0IIXIx0 = 85;

    /* renamed from: xXOx, reason: collision with root package name */
    public static final int f12773xXOx = 47;

    /* renamed from: xXoOI00O, reason: collision with root package name */
    public static final int f12774xXoOI00O = 117;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final int f12775xXxxox0I = 23;

    /* renamed from: xo0x, reason: collision with root package name */
    public static final int f12776xo0x = 46;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12777xoIox = 0;

    /* renamed from: xoIxX, reason: collision with root package name */
    public static final int f12778xoIxX = 58;

    /* renamed from: xoO0xx0, reason: collision with root package name */
    public static final int f12779xoO0xx0 = 83;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f12780xoXoI = 14;

    /* renamed from: xoxXI, reason: collision with root package name */
    public static final int f12781xoxXI = 55;

    /* renamed from: xx0X0, reason: collision with root package name */
    public static final int f12782xx0X0 = 95;

    /* renamed from: xxIO, reason: collision with root package name */
    public static final int f12783xxIO = 63;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12784xxIXOIIO = 253;

    /* renamed from: xxOXOOoIX, reason: collision with root package name */
    public static final int f12785xxOXOOoIX = 116;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f12786xxX = 21;

    /* renamed from: xxx00, reason: collision with root package name */
    public static final int f12787xxx00 = 186;

    /* renamed from: xxxI, reason: collision with root package name */
    public static final int f12788xxxI = 143;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("session", 18);
        f12738oXO0oOx0 = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        Profile.Type type = Profile.Type.DATE_TIME;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I(NotificationCompat.CATEGORY_EVENT, 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EVENT));
        oixoxx0.xxIXOIIO(new X0xII0I("event_type", 1, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EVENT_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I(BaiDu.START_TIME, 2, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        Profile.Type type2 = Profile.Type.SINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("start_position_lat", 3, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("start_position_long", 4, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("sport", 5, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("sub_sport", 6, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SUB_SPORT));
        Profile.Type type3 = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("total_elapsed_time", 7, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("total_timer_time", 8, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("total_distance", 9, 134, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("total_cycles", 10, 134, 1.0d, XIXIX.OOXIXo.f3760XO, xOxOoo.f15473xoXoI, false, type3));
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.add(new xxOoXO("total_strides", 134, 1.0d, XIXIX.OOXIXo.f3760XO, "strides"));
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.get(0).II0xO0(5, 1L);
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.get(0).II0xO0(5, 11L);
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.add(new xxOoXO("total_strokes", 134, 1.0d, XIXIX.OOXIXo.f3760XO, "strokes"));
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.get(1).II0xO0(5, 2L);
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.get(1).II0xO0(5, 5L);
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.get(1).II0xO0(5, 15L);
        oixoxx0.f14429oxoX.get(12).f13530OOXIXo.get(1).II0xO0(5, 37L);
        Profile.Type type4 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("total_calories", 11, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "kcal", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("total_fat_calories", 13, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "kcal", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_speed", 14, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type4));
        oixoxx0.f14429oxoX.get(15).f13537xoIox.add(new oXX0IoI(124, false, 16, 1000.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("max_speed", 15, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type4));
        oixoxx0.f14429oxoX.get(16).f13537xoIox.add(new oXX0IoI(125, false, 16, 1000.0d, XIXIX.OOXIXo.f3760XO));
        Profile.Type type5 = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("avg_heart_rate", 16, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("max_heart_rate", 17, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_cadence", 18, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type5));
        oixoxx0.f14429oxoX.get(19).f13530OOXIXo.add(new xxOoXO("avg_running_cadence", 2, 1.0d, XIXIX.OOXIXo.f3760XO, "strides/min"));
        oixoxx0.f14429oxoX.get(19).f13530OOXIXo.get(0).II0xO0(5, 1L);
        oixoxx0.xxIXOIIO(new X0xII0I("max_cadence", 19, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type5));
        oixoxx0.f14429oxoX.get(20).f13530OOXIXo.add(new xxOoXO("max_running_cadence", 2, 1.0d, XIXIX.OOXIXo.f3760XO, "strides/min"));
        oixoxx0.f14429oxoX.get(20).f13530OOXIXo.get(0).II0xO0(5, 1L);
        oixoxx0.xxIXOIIO(new X0xII0I("avg_power", 20, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("max_power", 21, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("total_ascent", 22, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("total_descent", 23, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("total_training_effect", 24, 2, 10.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("first_lap_index", 25, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("num_laps", 26, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("event_group", 27, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("trigger", 28, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SESSION_TRIGGER));
        oixoxx0.xxIXOIIO(new X0xII0I("nec_lat", 29, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("nec_long", 30, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("swc_lat", 31, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("swc_long", 32, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("num_lengths", 33, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "lengths", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("normalized_power", 34, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("training_stress_score", 35, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "tss", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("intensity_factor", 36, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "if", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("left_right_balance", 37, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.LEFT_RIGHT_BALANCE_100));
        oixoxx0.xxIXOIIO(new X0xII0I("end_position_lat", 38, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("end_position_long", 39, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_stroke_count", 41, 134, 10.0d, XIXIX.OOXIXo.f3760XO, "strokes/lap", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_stroke_distance", 42, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("swim_stroke", 43, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "swim_stroke", false, Profile.Type.SWIM_STROKE));
        oixoxx0.xxIXOIIO(new X0xII0I("pool_length", 44, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("threshold_power", 45, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("pool_length_unit", 46, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DISPLAY_MEASURE));
        oixoxx0.xxIXOIIO(new X0xII0I("num_active_lengths", 47, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "lengths", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("total_work", 48, 134, 1.0d, XIXIX.OOXIXo.f3760XO, ContentClassification.AD_CONTENT_CLASSIFICATION_J, false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_altitude", 49, 132, 5.0d, 500.0d, "m", false, type4));
        oixoxx0.f14429oxoX.get(49).f13537xoIox.add(new oXX0IoI(126, false, 16, 5.0d, 500.0d));
        oixoxx0.xxIXOIIO(new X0xII0I("max_altitude", 50, 132, 5.0d, 500.0d, "m", false, type4));
        oixoxx0.f14429oxoX.get(50).f13537xoIox.add(new oXX0IoI(128, false, 16, 5.0d, 500.0d));
        oixoxx0.xxIXOIIO(new X0xII0I("gps_accuracy", 51, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type5));
        Profile.Type type6 = Profile.Type.SINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("avg_grade", 52, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_pos_grade", 53, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_neg_grade", 54, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("max_pos_grade", 55, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("max_neg_grade", 56, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type6));
        Profile.Type type7 = Profile.Type.SINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("avg_temperature", 57, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "C", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("max_temperature", 58, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "C", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("total_moving_time", 59, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_pos_vertical_speed", 60, 131, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_neg_vertical_speed", 61, 131, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("max_pos_vertical_speed", 62, 131, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("max_neg_vertical_speed", 63, 131, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("min_heart_rate", 64, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_hr_zone", 65, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_speed_zone", 66, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_cadence_zone", 67, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("time_in_power_zone", 68, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_lap_time", 69, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("best_lap_index", 70, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("min_altitude", 71, 132, 5.0d, 500.0d, "m", false, type4));
        oixoxx0.f14429oxoX.get(71).f13537xoIox.add(new oXX0IoI(127, false, 16, 5.0d, 500.0d));
        oixoxx0.xxIXOIIO(new X0xII0I("player_score", 82, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("opponent_score", 83, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        Profile.Type type8 = Profile.Type.STRING;
        oixoxx0.xxIXOIIO(new X0xII0I("opponent_name", 84, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("stroke_count", 85, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "counts", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("zone_count", 86, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "counts", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("max_ball_speed", 87, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_ball_speed", 88, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_vertical_oscillation", 89, 132, 10.0d, XIXIX.OOXIXo.f3760XO, DateFormatUtils.MIN, false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_stance_time_percent", 90, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_stance_time", 91, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_fractional_cadence", 92, 2, 128.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("max_fractional_cadence", 93, 2, 128.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("total_fractional_cycles", 94, 2, 128.0d, XIXIX.OOXIXo.f3760XO, xOxOoo.f15473xoXoI, false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_total_hemoglobin_conc", 95, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "g/dL", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("min_total_hemoglobin_conc", 96, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "g/dL", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("max_total_hemoglobin_conc", 97, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "g/dL", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_saturated_hemoglobin_percent", 98, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "%", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("min_saturated_hemoglobin_percent", 99, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "%", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("max_saturated_hemoglobin_percent", 100, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "%", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_torque_effectiveness", 101, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_torque_effectiveness", 102, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_pedal_smoothness", 103, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_pedal_smoothness", 104, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_combined_pedal_smoothness", 105, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("sport_profile_name", 110, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type8));
        oixoxx0.xxIXOIIO(new X0xII0I("sport_index", 111, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("time_standing", 112, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("stand_count", 113, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_pco", 114, 1, 1.0d, XIXIX.OOXIXo.f3760XO, DateFormatUtils.MIN, false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_pco", 115, 1, 1.0d, XIXIX.OOXIXo.f3760XO, DateFormatUtils.MIN, false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_power_phase", 116, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_left_power_phase_peak", 117, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_power_phase", 118, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_right_power_phase_peak", 119, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_power_position", 120, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("max_power_position", 121, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_cadence_position", 122, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("max_cadence_position", 123, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_avg_speed", 124, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_max_speed", 125, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_avg_altitude", 126, 134, 5.0d, 500.0d, "m", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_min_altitude", 127, 134, 5.0d, 500.0d, "m", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_max_altitude", 128, 134, 5.0d, 500.0d, "m", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_lev_motor_power", 129, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("max_lev_motor_power", 130, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("lev_battery_consumption", 131, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_vertical_ratio", 132, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_stance_time_balance", 133, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_step_length", 134, 132, 10.0d, XIXIX.OOXIXo.f3760XO, DateFormatUtils.MIN, false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("total_anaerobic_training_effect", 137, 2, 10.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_vam", 139, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_depth", 140, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("max_depth", 141, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("surface_interval", 142, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("start_cns", 143, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("end_cns", 144, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("start_n2", 145, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("end_n2", 146, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_respiration_rate", 147, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.f14429oxoX.get(130).f13537xoIox.add(new oXX0IoI(169, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("max_respiration_rate", 148, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.f14429oxoX.get(131).f13537xoIox.add(new oXX0IoI(170, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("min_respiration_rate", 149, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.f14429oxoX.get(132).f13537xoIox.add(new oXX0IoI(180, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("min_temperature", 150, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "C", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("o2_toxicity", 155, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "OTUs", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("dive_number", 156, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("training_load_peak", 168, 133, 65536.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_avg_respiration_rate", 169, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "Breaths/min", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_max_respiration_rate", 170, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "Breaths/min", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_min_respiration_rate", 180, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        Profile.Type type9 = Profile.Type.FLOAT32;
        oixoxx0.xxIXOIIO(new X0xII0I("total_grit", 181, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "kGrit", false, type9));
        oixoxx0.xxIXOIIO(new X0xII0I("total_flow", 182, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "Flow", false, type9));
        oixoxx0.xxIXOIIO(new X0xII0I("jump_count", 183, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_grit", 186, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "kGrit", false, type9));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_flow", 187, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "Flow", false, type9));
        oixoxx0.xxIXOIIO(new X0xII0I("workout_feel", 192, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("workout_rpe", 193, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_spo2", 194, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_stress", 195, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("sdrr_hrv", 197, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "mS", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("rmssd_hrv", 198, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "mS", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("total_fractional_ascent", 199, 2, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("total_fractional_descent", 200, 2, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_core_temperature", 208, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "C", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("min_core_temperature", 209, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "C", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("max_core_temperature", 210, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "C", false, type4));
    }

    public OX00o0X() {
        super(x0OxxIOxX.XO(18));
    }

    public void I000X(Float f) {
        X0xxXX0(55, 0, f, 65535);
    }

    public Integer I00O() {
        return oX(183, 0, 65535);
    }

    public void I00oX(Float f) {
        X0xxXX0(35, 0, f, 65535);
    }

    public void I0IIXxxo(Byte b) {
        X0xxXX0(58, 0, b, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public Short I0Io() {
        return XI0oooXX(27, 0, 65535);
    }

    public Integer I0O00OI(int i) {
        return oX(86, i, 65535);
    }

    public int I0OO() {
        return oOoIIO0(97, 65535);
    }

    public void I0XIOxO(int i, Float f) {
        X0xxXX0(119, i, f, 65535);
    }

    public void I0o(Float f) {
        X0xxXX0(7, 0, f, 65535);
    }

    public void II0(Float f) {
        X0xxXX0(53, 0, f, 65535);
    }

    public SwimStroke II0OOXOx() {
        Short XI0oooXX2 = XI0oooXX(43, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SwimStroke.getByValue(XI0oooXX2);
    }

    @Override // com.garmin.fit.XIxO
    public Event II0xO0() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Event.getByValue(XI0oooXX2);
    }

    public void IIIo0Xo(Float f) {
        X0xxXX0(44, 0, f, 65535);
    }

    public int IIIxO() {
        return oOoIIO0(122, 65535);
    }

    public Float IIOIX() {
        return XX(14, 0, 65535);
    }

    public void IIXOxIxOo(Float f) {
        X0xxXX0(49, 0, f, 65535);
    }

    public void IIXxoXXox(int i, Integer num) {
        X0xxXX0(86, i, num, 65535);
    }

    public String IIoX0OoI() {
        return XIXIX(110, 0, 65535);
    }

    public Integer IO0xX() {
        return oX(32, 0, 65535);
    }

    public String IOI() {
        return XIXIX(84, 0, 65535);
    }

    public Short IOOXOOOOo() {
        return XI0oooXX(197, 0, 65535);
    }

    public Float IOOoXo0Ix(int i) {
        return XX(95, i, 65535);
    }

    public int IOXOxOII() {
        return oOoIIO0(65, 65535);
    }

    public Integer IOo0() {
        return oX(45, 0, 65535);
    }

    public void IOoXX(Float f) {
        X0xxXX0(8, 0, f, 65535);
    }

    public Float IOooo0o() {
        return XX(137, 0, 65535);
    }

    public void IX0OOX(Integer num) {
        X0xxXX0(83, 0, num, 65535);
    }

    public Float IXI() {
        return XX(168, 0, 65535);
    }

    public Float IXIIo() {
        return XX(24, 0, 65535);
    }

    public Float[] IXIxx0() {
        return xo0x(96, 65535);
    }

    public void IXOO0X0(Float f) {
        X0xxXX0(137, 0, f, 65535);
    }

    public Integer IXX(int i) {
        return oX(121, i, 65535);
    }

    public Integer IXXIXx00I() {
        return oX(29, 0, 65535);
    }

    public void IXXxo(Byte b) {
        X0xxXX0(150, 0, b, 65535);
    }

    public void IXo(Float f) {
        X0xxXX0(88, 0, f, 65535);
    }

    public Integer IXoIo() {
        return oX(25, 0, 65535);
    }

    public void IXoxO(Long l) {
        X0xxXX0(10, 0, l, 65535);
    }

    public Short IXxOIOO() {
        return XI0oooXX(149, 0, 65535);
    }

    public void Io0OXxX(SwimStroke swimStroke) {
        X0xxXX0(43, 0, Short.valueOf(swimStroke.value), 65535);
    }

    public void IoO(Float f) {
        X0xxXX0(59, 0, f, 65535);
    }

    public Short IoX() {
        return XI0oooXX(19, 0, 0);
    }

    public void IoXIo(Short sh) {
        X0xxXX0(64, 0, sh, 65535);
    }

    public Integer IoXO0XoX() {
        return oX(82, 0, 65535);
    }

    public void IoXOxx0o(Short sh) {
        X0xxXX0(192, 0, sh, 65535);
    }

    public void IoooXox0(Integer num) {
        X0xxXX0(82, 0, num, 65535);
    }

    public Short IoxOx() {
        return XI0oooXX(111, 0, 65535);
    }

    public Float IoxX() {
        return XX(8, 0, 65535);
    }

    public void IoxoI0IX(Integer num) {
        X0xxXX0(21, 0, num, 65535);
    }

    public void Ix(Float f) {
        X0xxXX0(200, 0, f, 65535);
    }

    public Float Ix0() {
        return XX(89, 0, 65535);
    }

    public void Ix00(int i, Float f) {
        X0xxXX0(100, i, f, 65535);
    }

    public Short Ix0x() {
        return XI0oooXX(17, 0, 65535);
    }

    public Short IxI(int i) {
        return XI0oooXX(123, i, 65535);
    }

    public Float IxIo() {
        return XX(134, 0, 65535);
    }

    public int IxO0Oxo() {
        return oOoIIO0(96, 65535);
    }

    public void IxOIO(Short sh) {
        X0xxXX0(16, 0, sh, 65535);
    }

    public Integer[] IxOXOxO() {
        return xoxXI(86, 65535);
    }

    public Byte IxX00() {
        return XxX0x0xxx(114, 0, 65535);
    }

    public void IxoOxx(Float f) {
        X0xxXX0(42, 0, f, 65535);
    }

    public void IxoXXoXo(Integer num) {
        X0xxXX0(155, 0, num, 65535);
    }

    public Float O00() {
        return XX(52, 0, 65535);
    }

    public Float O0IoXXOx() {
        return XX(181, 0, 65535);
    }

    public Float[] O0O0Io00X() {
        return xo0x(97, 65535);
    }

    public Integer O0OOX0IIx() {
        return oX(38, 0, 65535);
    }

    public void O0OOoIox(Short sh) {
        X0xxXX0(17, 0, sh, 65535);
    }

    public void O0OoXI(Float f) {
        X0xxXX0(140, 0, f, 65535);
    }

    public Float O0o0() {
        return XX(62, 0, 65535);
    }

    public void O0o000XOX(Float f) {
        X0xxXX0(104, 0, f, 65535);
    }

    public void O0oXOX0XX(Long l) {
        X0xxXX0(10, 0, l, 1);
    }

    public Float O0x() {
        return XX(170, 0, 65535);
    }

    public void O0x0XXxI(Float f) {
        X0xxXX0(128, 0, f, 65535);
    }

    public Float O0xO0(int i) {
        return XX(96, i, 65535);
    }

    public Short O0xxXxI() {
        return XI0oooXX(16, 0, 65535);
    }

    public void OI(Sport sport) {
        X0xxXX0(5, 0, Short.valueOf(sport.value), 65535);
    }

    public int OI0IXox() {
        return oOoIIO0(119, 65535);
    }

    public Integer OIII0O() {
        return oX(13, 0, 65535);
    }

    public Integer OIIXOxo() {
        return oX(254, 0, 65535);
    }

    public void OIOxOX(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void OIXO(Integer num) {
        X0xxXX0(31, 0, num, 65535);
    }

    public Float OIoxIx() {
        return XX(210, 0, 65535);
    }

    public Float OIx00oxx() {
        return XX(140, 0, 65535);
    }

    public Integer OIx0xoOo() {
        return oX(3, 0, 65535);
    }

    public Integer OIxI0O() {
        return oX(21, 0, 65535);
    }

    public Float[] OIxOIX0II() {
        return xo0x(68, 65535);
    }

    public Float OIxOX() {
        return XX(127, 0, 65535);
    }

    public Float OIxx0I0() {
        return XX(126, 0, 65535);
    }

    public Float OO0() {
        return XX(105, 0, 65535);
    }

    public void OOI(int i, Integer num) {
        X0xxXX0(85, i, num, 65535);
    }

    public Float[] OOIXx0x() {
        return xo0x(118, 65535);
    }

    public Float OOOI() {
        return XX(54, 0, 65535);
    }

    public Integer OOOox() {
        return oX(83, 0, 65535);
    }

    public void OOOxXxoO(int i, Short sh) {
        X0xxXX0(123, i, sh, 65535);
    }

    public void OOX0x(Float f) {
        X0xxXX0(131, 0, f, 65535);
    }

    public void OOo(Integer num) {
        X0xxXX0(37, 0, num, 65535);
    }

    public Long OOoOoO0o() {
        return x0xO(10, 0, 1);
    }

    public Short OOxOI() {
        return XI0oooXX(147, 0, 65535);
    }

    public Integer OOxOOxIO() {
        return oX(130, 0, 65535);
    }

    public void OOxOXI0(int i, Float f) {
        X0xxXX0(67, i, f, 65535);
    }

    public Float OX() {
        return XX(88, 0, 65535);
    }

    public Integer OX00o0X() {
        return oX(22, 0, 65535);
    }

    public void OXI(Integer num) {
        X0xxXX0(26, 0, num, 65535);
    }

    public Short OXIOoo0X0() {
        return XI0oooXX(51, 0, 65535);
    }

    public Short OXOo() {
        return XI0oooXX(192, 0, 65535);
    }

    public Float OXXoIoXI() {
        return XX(104, 0, 65535);
    }

    public void OXXxXoO(Short sh) {
        X0xxXX0(149, 0, sh, 65535);
    }

    public void OXoIOx(int i, Float f) {
        X0xxXX0(96, i, f, 65535);
    }

    public void OXoIXx(Float f) {
        X0xxXX0(141, 0, f, 65535);
    }

    public Float OXooXo() {
        return XX(93, 0, 65535);
    }

    public Integer[] OXxx0OO() {
        return xoxXI(85, 65535);
    }

    public SessionTrigger Oo0IXI0() {
        Short XI0oooXX2 = XI0oooXX(28, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SessionTrigger.getByValue(XI0oooXX2);
    }

    public void Oo0xX(int i, Float f) {
        X0xxXX0(116, i, f, 65535);
    }

    public Integer OoI0OO() {
        return oX(155, 0, 65535);
    }

    public Float OoIXo() {
        return XX(15, 0, 65535);
    }

    public void OoIoI0(Integer num) {
        X0xxXX0(11, 0, num, 65535);
    }

    public Float OoOoXO0() {
        return XX(59, 0, 65535);
    }

    public void OoOoxX0xo(int i, Float f) {
        X0xxXX0(95, i, f, 65535);
    }

    public Float OooI() {
        return XX(208, 0, 65535);
    }

    public Float OooO0XOx() {
        return XX(124, 0, 65535);
    }

    public void OoooxII(Long l) {
        X0xxXX0(10, 0, l, 0);
    }

    public int Oox() {
        return oOoIIO0(118, 65535);
    }

    public Long OoxOxII() {
        return x0xO(10, 0, 65535);
    }

    public void OoxxX(Byte b) {
        X0xxXX0(114, 0, b, 65535);
    }

    public void Ox(Float f) {
        X0xxXX0(105, 0, f, 65535);
    }

    public void Ox0(int i, Float f) {
        X0xxXX0(99, i, f, 65535);
    }

    public Float[] Ox00XOXoo() {
        return xo0x(67, 65535);
    }

    public Long Ox0XO() {
        return x0xO(10, 0, 0);
    }

    public void OxI0(Float f) {
        X0xxXX0(56, 0, f, 65535);
    }

    public void OxIXxXXI0(Integer num) {
        X0xxXX0(32, 0, num, 65535);
    }

    public Short OxIxx0() {
        return XI0oooXX(198, 0, 65535);
    }

    public Float OxO() {
        return XX(60, 0, 65535);
    }

    public void OxXIoIX(Float f) {
        X0xxXX0(181, 0, f, 65535);
    }

    public void OxXXx0OX(Float f) {
        X0xxXX0(180, 0, f, 65535);
    }

    public Integer OxXXx0X() {
        return oX(129, 0, 65535);
    }

    public Float Oxo00O() {
        return XX(139, 0, 65535);
    }

    public Float Oxx() {
        return XX(49, 0, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void Oxx0IOOO(Short sh) {
        X0xxXX0(27, 0, sh, 65535);
    }

    public void OxxIXIX(Float f) {
        X0xxXX0(169, 0, f, 65535);
    }

    public Float Oxxo() {
        return XX(9, 0, 65535);
    }

    public int X0() {
        return oOoIIO0(100, 65535);
    }

    public int X00IxOx() {
        return oOoIIO0(98, 65535);
    }

    public Integer[] X00xOoXI() {
        return xoxXI(120, 65535);
    }

    public Float[] X0IOOI() {
        return xo0x(95, 65535);
    }

    public void X0Ix00XxO(int i, Integer num) {
        X0xxXX0(121, i, num, 65535);
    }

    public Float X0O0I0() {
        return XX(53, 0, 65535);
    }

    public void X0OXI(Integer num) {
        X0xxXX0(25, 0, num, 65535);
    }

    public Long X0OXX() {
        return x0xO(142, 0, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public EventType X0o0xo() {
        Short XI0oooXX2 = XI0oooXX(1, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return EventType.getByValue(XI0oooXX2);
    }

    public void X0oX(Short sh) {
        X0xxXX0(194, 0, sh, 65535);
    }

    public Float X0ooXIooI() {
        return XX(91, 0, 65535);
    }

    public int X0x() {
        return oOoIIO0(117, 65535);
    }

    public void X0xO(Integer num) {
        X0xxXX0(45, 0, num, 65535);
    }

    public Byte X0xOO() {
        return XxX0x0xxx(58, 0, 65535);
    }

    public void X0xXOX(SessionTrigger sessionTrigger) {
        X0xxXX0(28, 0, Short.valueOf(sessionTrigger.value), 65535);
    }

    public void XI0(Long l) {
        X0xxXX0(48, 0, l, 65535);
    }

    public Float XIOOI() {
        return XX(56, 0, 65535);
    }

    public void XIOoI(int i, Float f) {
        X0xxXX0(65, i, f, 65535);
    }

    public void XIo(Float f) {
        X0xxXX0(90, 0, f, 65535);
    }

    public void XIoox00ox(int i, Float f) {
        X0xxXX0(97, i, f, 65535);
    }

    public Integer XIxO() {
        return oX(34, 0, 65535);
    }

    public void XIxoOo0oI(Short sh) {
        X0xxXX0(144, 0, sh, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void XO(EventType eventType) {
        X0xxXX0(1, 0, Short.valueOf(eventType.value), 65535);
    }

    public Short XO0() {
        return XI0oooXX(193, 0, 65535);
    }

    public Byte XO00XOO() {
        return XxX0x0xxx(115, 0, 65535);
    }

    public int XO0OX() {
        return oOoIIO0(120, 65535);
    }

    public Float XO0o() {
        return XX(103, 0, 65535);
    }

    public void XOO(Float f) {
        X0xxXX0(9, 0, f, 65535);
    }

    public void XOOI0(Float f) {
        X0xxXX0(71, 0, f, 65535);
    }

    public Float XOOO0O(int i) {
        return XX(65, i, 65535);
    }

    public void XOX0XxOxI(Integer num) {
        X0xxXX0(23, 0, num, 65535);
    }

    public Short XOo0() {
        return XI0oooXX(148, 0, 65535);
    }

    public void XOoxOOO(Long l) {
        X0xxXX0(156, 0, l, 65535);
    }

    public Float XOx() {
        return XX(35, 0, 65535);
    }

    public void XOx0xX(Integer num) {
        X0xxXX0(39, 0, num, 65535);
    }

    public Float XOxoX() {
        return XX(41, 0, 65535);
    }

    public void XX00xxo(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public int XXIoX0() {
        return oOoIIO0(86, 65535);
    }

    public Integer XXO0() {
        return oX(4, 0, 65535);
    }

    public void XXOOoxx0x(String str) {
        X0xxXX0(110, 0, str, 65535);
    }

    public void XXOo(Float f) {
        X0xxXX0(112, 0, f, 65535);
    }

    public Float XXoO0oX() {
        return XX(199, 0, 65535);
    }

    public Float XXooOOI() {
        return XX(7, 0, 65535);
    }

    public Sport XXx0OXXXo() {
        Short XI0oooXX2 = XI0oooXX(5, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Sport.getByValue(XI0oooXX2);
    }

    public Float Xo(int i) {
        return XX(98, i, 65535);
    }

    public void XoI0OoX(Integer num) {
        X0xxXX0(30, 0, num, 65535);
    }

    public void XoIoOXOIx(Integer num) {
        X0xxXX0(129, 0, num, 65535);
    }

    public Short[] XoIxOXIXo() {
        return xoO0xx0(122, 65535);
    }

    public void XoIxo(Short sh) {
        X0xxXX0(198, 0, sh, 65535);
    }

    public void XoO(Float f) {
        X0xxXX0(168, 0, f, 65535);
    }

    public void XoOOOXox(Integer num) {
        X0xxXX0(20, 0, num, 65535);
    }

    public int XoOOx0IX() {
        return oOoIIO0(85, 65535);
    }

    public void XoOOxOo0o(SubSport subSport) {
        X0xxXX0(6, 0, Short.valueOf(subSport.value), 65535);
    }

    public Short XoOxI0ox() {
        return XI0oooXX(194, 0, 65535);
    }

    public Float XooIO0oo0(int i) {
        return XX(118, i, 65535);
    }

    public void Xooo0Xx(Float f) {
        X0xxXX0(63, 0, f, 65535);
    }

    public void Xox0o(Integer num) {
        X0xxXX0(70, 0, num, 65535);
    }

    public SubSport Xx() {
        Short XI0oooXX2 = XI0oooXX(6, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SubSport.getByValue(XI0oooXX2);
    }

    public Integer Xx0() {
        return oX(31, 0, 65535);
    }

    public void Xx0OXIoI(Integer num) {
        X0xxXX0(29, 0, num, 65535);
    }

    public void Xx0oX(Byte b) {
        X0xxXX0(115, 0, b, 65535);
    }

    public Short XxI() {
        return XI0oooXX(64, 0, 65535);
    }

    public void XxI0(Float f) {
        X0xxXX0(139, 0, f, 65535);
    }

    public Float XxIIOXIXx(int i) {
        return XX(97, i, 65535);
    }

    public void XxIO0(Float f) {
        X0xxXX0(210, 0, f, 65535);
    }

    public Float XxIOX(int i) {
        return XX(67, i, 65535);
    }

    public Long XxIo() {
        return x0xO(156, 0, 65535);
    }

    public void XxOOoxOO(Float f) {
        X0xxXX0(91, 0, f, 65535);
    }

    public Float XxXX() {
        return XX(128, 0, 65535);
    }

    public void XxoOI00IX(Integer num) {
        X0xxXX0(146, 0, num, 65535);
    }

    public Float Xxx0oXX() {
        return XX(182, 0, 65535);
    }

    public void XxxIX(Float f) {
        X0xxXX0(24, 0, f, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Short o00xOoIO() {
        return XI0oooXX(19, 0, 65535);
    }

    public void o0I(Float f) {
        X0xxXX0(182, 0, f, 65535);
    }

    public void o0I0O0oXX(Float f) {
        X0xxXX0(127, 0, f, 65535);
    }

    public Short o0IXXIx(int i) {
        return XI0oooXX(122, i, 65535);
    }

    public void o0Ixx(Integer num) {
        X0xxXX0(34, 0, num, 65535);
    }

    public Float o0OO0() {
        return XX(50, 0, 65535);
    }

    public Float o0Oo() {
        return XX(125, 0, 65535);
    }

    public void o0OoX(Short sh) {
        X0xxXX0(111, 0, sh, 65535);
    }

    public void o0Oox0xox(Float f) {
        X0xxXX0(134, 0, f, 65535);
    }

    public Integer o0Xo(int i) {
        return oX(120, i, 65535);
    }

    public void o0Xo0XII(Byte b) {
        X0xxXX0(57, 0, b, 65535);
    }

    public void o0XxxOIx(Short sh) {
        X0xxXX0(193, 0, sh, 65535);
    }

    public Float o0oIxXOx(int i) {
        return XX(66, i, 65535);
    }

    public Float o0oxo0oI() {
        return XX(61, 0, 65535);
    }

    public void o0x0XOXx(Integer num) {
        X0xxXX0(145, 0, num, 65535);
    }

    public Float o0xIIX0(int i) {
        return XX(68, i, 65535);
    }

    public int o0xIoII() {
        return oOoIIO0(66, 65535);
    }

    public int o0xOIoxo() {
        return oOoIIO0(121, 65535);
    }

    public Float oI0(int i) {
        return XX(100, i, 65535);
    }

    public Short oI00o() {
        return XI0oooXX(143, 0, 65535);
    }

    public Float oI0X0() {
        return XX(71, 0, 65535);
    }

    public void oII(Float f) {
        X0xxXX0(14, 0, f, 65535);
    }

    public Float oIX0o() {
        return XX(200, 0, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Float oIXoXx0() {
        return XX(209, 0, 65535);
    }

    public void oIoIXxIO(Float f) {
        X0xxXX0(61, 0, f, 65535);
    }

    public void oIoIxo(Short sh) {
        X0xxXX0(51, 0, sh, 65535);
    }

    public void oIoxI0xx(Float f) {
        X0xxXX0(187, 0, f, 65535);
    }

    public void oIxOXo(Float f) {
        X0xxXX0(92, 0, f, 65535);
    }

    public void oIxXX0Xo(Float f) {
        X0xxXX0(126, 0, f, 65535);
    }

    public void oIxXXOI(int i, Float f) {
        X0xxXX0(98, i, f, 65535);
    }

    public void oIxxIo(Float f) {
        X0xxXX0(186, 0, f, 65535);
    }

    public void oO0(Float f) {
        X0xxXX0(208, 0, f, 65535);
    }

    public Integer oO0IXx() {
        return oX(37, 0, 65535);
    }

    public Float[] oO0OX0() {
        return xo0x(65, 65535);
    }

    public Integer oOIXoIXXI() {
        return oX(113, 0, 65535);
    }

    public Integer oOIx() {
        return oX(33, 0, 65535);
    }

    public void oOo0o(Short sh) {
        X0xxXX0(195, 0, sh, 65535);
    }

    public void oOx0xoXI(Float f) {
        X0xxXX0(124, 0, f, 65535);
    }

    public void oOxoXxoX(Integer num) {
        X0xxXX0(38, 0, num, 65535);
    }

    public void oOxxXI(Float f) {
        X0xxXX0(101, 0, f, 65535);
    }

    public Float oX000x() {
        return XX(133, 0, 65535);
    }

    public Float oX0I0O(int i) {
        return XX(116, i, 65535);
    }

    public void oX0O(Float f) {
        X0xxXX0(103, 0, f, 65535);
    }

    public void oX0Ox(Float f) {
        X0xxXX0(94, 0, f, 65535);
    }

    public Float[] oX0ooo0I0() {
        return xo0x(117, 65535);
    }

    public void oXIo0X0x(Integer num) {
        X0xxXX0(13, 0, num, 65535);
    }

    public int oXIoIo() {
        return oOoIIO0(95, 65535);
    }

    public Short oXIoO() {
        return XI0oooXX(18, 0, 65535);
    }

    public Float[] oXO0oOx0() {
        return xo0x(98, 65535);
    }

    public Float oXoXxOo() {
        return XX(141, 0, 65535);
    }

    public int oXxOXOX() {
        return oOoIIO0(68, 65535);
    }

    public Float[] oXxx000() {
        return xo0x(119, 65535);
    }

    public Float oo00() {
        return XX(101, 0, 65535);
    }

    public void oo00Io(Float f) {
        X0xxXX0(41, 0, f, 65535);
    }

    public Integer oo0oIXo() {
        return oX(146, 0, 65535);
    }

    public Float ooO0oXxI() {
        return XX(131, 0, 65535);
    }

    public void oooO0oo(Float f) {
        X0xxXX0(125, 0, f, 65535);
    }

    public void oox(Float f) {
        X0xxXX0(62, 0, f, 65535);
    }

    public Float oox000IX() {
        return XX(63, 0, 65535);
    }

    public Integer ox0() {
        return oX(11, 0, 65535);
    }

    public Float ox0I() {
        return XX(55, 0, 65535);
    }

    public Short oxIO0IIo() {
        return XI0oooXX(144, 0, 65535);
    }

    public Long oxO() {
        return x0xO(48, 0, 65535);
    }

    public void oxOII(Float f) {
        X0xxXX0(89, 0, f, 65535);
    }

    public Integer oxOIoIx() {
        return oX(145, 0, 65535);
    }

    public Float oxOXxoXII() {
        return XX(69, 0, 65535);
    }

    public void oxXIOXO(int i, Float f) {
        X0xxXX0(118, i, f, 65535);
    }

    public void oxoIOxO(Short sh) {
        X0xxXX0(143, 0, sh, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void oxoX(Event event) {
        X0xxXX0(0, 0, Short.valueOf(event.value), 65535);
    }

    public Float[] x00IOx() {
        return xo0x(116, 65535);
    }

    public Integer[] x00X0xoXO() {
        return xoxXI(121, 65535);
    }

    public void x0I0(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(2, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void x0Io0(Float f) {
        X0xxXX0(60, 0, f, 65535);
    }

    public void x0Ix0O(Float f) {
        X0xxXX0(87, 0, f, 65535);
    }

    public void x0OI(Short sh) {
        X0xxXX0(18, 0, sh, 0);
    }

    public Float x0OOI() {
        return XX(180, 0, 65535);
    }

    public void x0ooOIxO(Integer num) {
        X0xxXX0(113, 0, num, 65535);
    }

    public Float x0oox0() {
        return XX(36, 0, 65535);
    }

    public Short x0oxIIIX() {
        return XI0oooXX(195, 0, 65535);
    }

    public void x0x(Integer num) {
        X0xxXX0(47, 0, num, 65535);
    }

    public o0xxxXXxX x0xOIoO() {
        return oXX0IoI(x0xO(2, 0, 65535));
    }

    public Float xI0OXooO() {
        return XX(112, 0, 65535);
    }

    public void xI0Ooxx0x(Short sh) {
        X0xxXX0(147, 0, sh, 65535);
    }

    public void xIIoO(Float f) {
        X0xxXX0(102, 0, f, 65535);
    }

    public void xIOI0xO(Float f) {
        X0xxXX0(50, 0, f, 65535);
    }

    public void xIOOIO(Float f) {
        X0xxXX0(15, 0, f, 65535);
    }

    public Float xIOXX() {
        return XX(90, 0, 65535);
    }

    public Float xIXIOX() {
        return XX(42, 0, 65535);
    }

    public Short[] xIXOoI() {
        return xoO0xx0(123, 65535);
    }

    public Float xIXX() {
        return XX(187, 0, 65535);
    }

    public void xIXXIo(Short sh) {
        X0xxXX0(148, 0, sh, 65535);
    }

    public DisplayMeasure xIXoO0Xx() {
        Short XI0oooXX2 = XI0oooXX(46, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DisplayMeasure.getByValue(XI0oooXX2);
    }

    public void xIo0xoOOx(Short sh) {
        X0xxXX0(19, 0, sh, 0);
    }

    public Float[] xIoXXXIXo() {
        return xo0x(100, 65535);
    }

    public Short xIx() {
        return XI0oooXX(18, 0, 0);
    }

    public Float xIx0XO(int i) {
        return XX(119, i, 65535);
    }

    public Integer xIxooxXX() {
        return oX(70, 0, 65535);
    }

    public void xO0x00ox(Float f) {
        X0xxXX0(199, 0, f, 65535);
    }

    public Float xOI0() {
        return XX(94, 0, 65535);
    }

    public void xOIO(Float f) {
        X0xxXX0(52, 0, f, 65535);
    }

    public void xOIx00(Float f) {
        X0xxXX0(54, 0, f, 65535);
    }

    public Float xOOxI() {
        return XX(102, 0, 65535);
    }

    public Float xOOxIO() {
        return XX(186, 0, 65535);
    }

    public void xOOxX(Integer num) {
        X0xxXX0(183, 0, num, 65535);
    }

    public void xOXoxI(Float f) {
        X0xxXX0(170, 0, f, 65535);
    }

    public void xOo(Integer num) {
        X0xxXX0(22, 0, num, 65535);
    }

    public Integer xOoIIIoXI() {
        return oX(26, 0, 65535);
    }

    public Float[] xOx() {
        return xo0x(66, 65535);
    }

    public int xOxOoo() {
        return oOoIIO0(123, 65535);
    }

    public int xOxxXO() {
        return oOoIIO0(99, 65535);
    }

    public Float xX(int i) {
        return XX(117, i, 65535);
    }

    public Float xX0ox(int i) {
        return XX(99, i, 65535);
    }

    public Integer xXIX0Xo() {
        return oX(23, 0, 65535);
    }

    public void xXIxxo0x(int i, Float f) {
        X0xxXX0(66, i, f, 65535);
    }

    public void xXO0oXX(Float f) {
        X0xxXX0(133, 0, f, 65535);
    }

    public void xXOO(Integer num) {
        X0xxXX0(33, 0, num, 65535);
    }

    public void xXXXox(Integer num) {
        X0xxXX0(4, 0, num, 65535);
    }

    public void xXXxoI(int i, Short sh) {
        X0xxXX0(122, i, sh, 65535);
    }

    public Float xXo() {
        return XX(87, 0, 65535);
    }

    public void xXx0x0(Short sh) {
        X0xxXX0(19, 0, sh, 65535);
    }

    public void xXxIoIXX0(int i, Float f) {
        X0xxXX0(68, i, f, 65535);
    }

    public Byte xo() {
        return XxX0x0xxx(57, 0, 65535);
    }

    public void xoIIIOI(Float f) {
        X0xxXX0(36, 0, f, 65535);
    }

    public Float[] xoIXOxX() {
        return xo0x(99, 65535);
    }

    public void xoO0(DisplayMeasure displayMeasure) {
        X0xxXX0(46, 0, Short.valueOf(displayMeasure.value), 65535);
    }

    public void xoOI00O0X(Float f) {
        X0xxXX0(209, 0, f, 65535);
    }

    public void xoOx(String str) {
        X0xxXX0(84, 0, str, 65535);
    }

    public Integer xoX() {
        return oX(39, 0, 65535);
    }

    public void xooXo(Float f) {
        X0xxXX0(93, 0, f, 65535);
    }

    public Byte xooxxX() {
        return XxX0x0xxx(150, 0, 65535);
    }

    public Float xox() {
        return XX(132, 0, 65535);
    }

    public Integer xoxo(int i) {
        return oX(85, i, 65535);
    }

    public Float xx() {
        return XX(44, 0, 65535);
    }

    public Float xx0() {
        return XX(169, 0, 65535);
    }

    public int xx00oOoI() {
        return oOoIIO0(67, 65535);
    }

    public void xx0O(Short sh) {
        X0xxXX0(18, 0, sh, 65535);
    }

    public Integer xx0o0O() {
        return oX(30, 0, 65535);
    }

    public void xxIOxXI(Long l) {
        X0xxXX0(142, 0, l, 65535);
    }

    public void xxOoXO(int i, Integer num) {
        X0xxXX0(120, i, num, 65535);
    }

    public void xxX0X(Integer num) {
        X0xxXX0(130, 0, num, 65535);
    }

    public int xxXXXxIxo() {
        return oOoIIO0(116, 65535);
    }

    public void xxXooOI(Float f) {
        X0xxXX0(132, 0, f, 65535);
    }

    public void xxoXO(int i, Float f) {
        X0xxXX0(117, i, f, 65535);
    }

    public void xxx(Float f) {
        X0xxXX0(69, 0, f, 65535);
    }

    public Integer xxx00() {
        return oX(20, 0, 65535);
    }

    public Float xxxI() {
        return XX(92, 0, 65535);
    }

    public Integer xxxoo0XI() {
        return oX(47, 0, 65535);
    }

    public void xxxxxo(Short sh) {
        X0xxXX0(197, 0, sh, 65535);
    }

    public OX00o0X(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
