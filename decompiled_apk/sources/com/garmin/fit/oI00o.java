package com.garmin.fit;

import com.alimm.tanx.core.constant.TanxAdType;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.garmin.fit.Profile;
import com.tenmeter.smlibrary.utils.DateFormatUtils;

/* loaded from: classes9.dex */
public class oI00o extends oIXoXx0 {

    /* renamed from: I0, reason: collision with root package name */
    public static final int f14310I0 = 115;

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public static final int f14311I0X0x0oIo = 70;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public static final int f14312I0oOIX = 81;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public static final int f14313I0oOoX = 57;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14314II0XooXoX = 253;

    /* renamed from: IIX0, reason: collision with root package name */
    public static final int f14315IIX0 = 127;

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final int f14316IIX0o = 40;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f14317IIXOooo = 13;

    /* renamed from: IIxOXoOo0, reason: collision with root package name */
    public static final int f14318IIxOXoOo0 = 114;

    /* renamed from: IO, reason: collision with root package name */
    public static final int f14319IO = 49;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f14320IXxxXO = 9;

    /* renamed from: Io, reason: collision with root package name */
    public static final int f14321Io = 54;

    /* renamed from: IoOoX, reason: collision with root package name */
    public static final int f14322IoOoX = 45;

    /* renamed from: IoOoo, reason: collision with root package name */
    public static final int f14323IoOoo = 84;

    /* renamed from: Ioxxx, reason: collision with root package name */
    public static final int f14324Ioxxx = 93;

    /* renamed from: O0, reason: collision with root package name */
    public static final oIXoXx0 f14325O0;

    /* renamed from: O00XxXI, reason: collision with root package name */
    public static final int f14326O00XxXI = 97;

    /* renamed from: O0X, reason: collision with root package name */
    public static final int f14327O0X = 126;

    /* renamed from: O0Xx, reason: collision with root package name */
    public static final int f14328O0Xx = 78;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f14329O0xOxO = 28;

    /* renamed from: OI0, reason: collision with root package name */
    public static final int f14330OI0 = 53;

    /* renamed from: OO, reason: collision with root package name */
    public static final int f14331OO = 83;

    /* renamed from: OO0x0xX, reason: collision with root package name */
    public static final int f14332OO0x0xX = 91;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14333OOXIXo = 2;

    /* renamed from: OOXIxO0, reason: collision with root package name */
    public static final int f14334OOXIxO0 = 108;

    /* renamed from: OX00O0xII, reason: collision with root package name */
    public static final int f14335OX00O0xII = 118;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f14336Oo = 8;

    /* renamed from: Ox0O, reason: collision with root package name */
    public static final int f14337Ox0O = 139;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f14338OxI = 19;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f14339Oxx0xo = 10;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f14340OxxIIOOXO = 12;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public static final int f14341X00IoxXI = 48;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f14342X0IIOO = 29;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f14343XI0IXoo = 30;

    /* renamed from: XI0oooXX, reason: collision with root package name */
    public static final int f14344XI0oooXX = 99;

    /* renamed from: XIXIX, reason: collision with root package name */
    public static final int f14345XIXIX = 123;

    /* renamed from: XIo0oOXIx, reason: collision with root package name */
    public static final int f14346XIo0oOXIx = 92;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f14347XIxXXX0x0 = 31;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public static final int f14348XOxIOxOx = 52;

    /* renamed from: XX, reason: collision with root package name */
    public static final int f14349XX = 56;

    /* renamed from: XX0, reason: collision with root package name */
    public static final int f14350XX0 = 69;

    /* renamed from: XX0xXo, reason: collision with root package name */
    public static final int f14351XX0xXo = 95;

    /* renamed from: Xo0, reason: collision with root package name */
    public static final int f14352Xo0 = 72;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public static final int f14353XoI0Ixx0 = 73;

    /* renamed from: XoX, reason: collision with root package name */
    public static final int f14354XoX = 59;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public static final int f14355Xx000oIo = 47;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final int f14356XxX0x0xxx = 33;

    /* renamed from: o0, reason: collision with root package name */
    public static final int f14357o0 = 55;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f14358o00 = 18;

    /* renamed from: o0xxxXXxX, reason: collision with root package name */
    public static final int f14359o0xxxXXxX = 96;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f14360oI0IIXIo = 11;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f14361oO = 6;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public static final int f14362oOXoIIIo = 46;

    /* renamed from: oOo, reason: collision with root package name */
    public static final int f14363oOo = 125;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14364oOoXoXO = 3;

    /* renamed from: oX, reason: collision with root package name */
    public static final int f14365oX = 71;

    /* renamed from: oXIO0o0XI, reason: collision with root package name */
    public static final int f14366oXIO0o0XI = 124;

    /* renamed from: oo, reason: collision with root package name */
    public static final int f14367oo = 44;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public static final int f14368oo0xXOI0I = 43;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14369ooOOo0oXI = 4;

    /* renamed from: ooOx, reason: collision with root package name */
    public static final int f14370ooOx = 116;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public static final int f14371ooXIXxIX = 41;

    /* renamed from: ox, reason: collision with root package name */
    public static final int f14372ox = 98;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public static final int f14373oxXx0IX = 62;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public static final int f14374oxxXoxO = 58;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14375x0XOIxOo = 5;

    /* renamed from: x0o, reason: collision with root package name */
    public static final int f14376x0o = 51;

    /* renamed from: x0xO, reason: collision with root package name */
    public static final int f14377x0xO = 87;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f14378x0xO0oo = 7;

    /* renamed from: xI, reason: collision with root package name */
    public static final int f14379xI = 42;

    /* renamed from: xII, reason: collision with root package name */
    public static final int f14380xII = 50;

    /* renamed from: xOOOX, reason: collision with root package name */
    public static final int f14381xOOOX = 120;

    /* renamed from: xOoOIoI, reason: collision with root package name */
    public static final int f14382xOoOIoI = 129;

    /* renamed from: xX0IIXIx0, reason: collision with root package name */
    public static final int f14383xX0IIXIx0 = 119;

    /* renamed from: xXOx, reason: collision with root package name */
    public static final int f14384xXOx = 68;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final int f14385xXxxox0I = 39;

    /* renamed from: xo0x, reason: collision with root package name */
    public static final int f14386xo0x = 67;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14387xoIox = 1;

    /* renamed from: xoIxX, reason: collision with root package name */
    public static final int f14388xoIxX = 85;

    /* renamed from: xoO0xx0, reason: collision with root package name */
    public static final int f14389xoO0xx0 = 117;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f14390xoXoI = 17;

    /* renamed from: xoxXI, reason: collision with root package name */
    public static final int f14391xoxXI = 82;

    /* renamed from: xxIO, reason: collision with root package name */
    public static final int f14392xxIO = 94;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14393xxIXOIIO = 0;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f14394xxX = 32;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("record", 20);
        f14325O0 = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.SINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("position_lat", 0, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("position_long", 1, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type));
        Profile.Type type2 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("altitude", 2, 132, 5.0d, 500.0d, "m", false, type2));
        oixoxx0.f14429oxoX.get(3).f13537xoIox.add(new oXX0IoI(78, false, 16, 5.0d, 500.0d));
        Profile.Type type3 = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("heart_rate", 3, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("cadence", 4, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type3));
        Profile.Type type4 = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15470o00, 5, 134, 100.0d, XIXIX.OOXIXo.f3760XO, "m", true, type4));
        oixoxx0.xxIXOIIO(new X0xII0I(RouteGuideParams.RGKey.AssistInfo.Speed, 6, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type2));
        oixoxx0.f14429oxoX.get(7).f13537xoIox.add(new oXX0IoI(73, false, 16, 1000.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("power", 7, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("compressed_speed_distance", 8, 13, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BYTE));
        oixoxx0.f14429oxoX.get(9).f13537xoIox.add(new oXX0IoI(6, false, 12, 100.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(9).f13537xoIox.add(new oXX0IoI(5, true, 12, 16.0d, XIXIX.OOXIXo.f3760XO));
        Profile.Type type5 = Profile.Type.SINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("grade", 9, 131, 100.0d, XIXIX.OOXIXo.f3760XO, "%", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("resistance", 10, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("time_from_course", 11, 133, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("cycle_length", 12, 2, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type3));
        Profile.Type type6 = Profile.Type.SINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("temperature", 13, 1, 1.0d, XIXIX.OOXIXo.f3760XO, "C", false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("speed_1s", 17, 2, 16.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15473xoXoI, 18, 2, 1.0d, XIXIX.OOXIXo.f3760XO, xOxOoo.f15473xoXoI, false, type3));
        oixoxx0.f14429oxoX.get(16).f13537xoIox.add(new oXX0IoI(19, true, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("total_cycles", 19, 134, 1.0d, XIXIX.OOXIXo.f3760XO, xOxOoo.f15473xoXoI, true, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("compressed_accumulated_power", 28, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type2));
        oixoxx0.f14429oxoX.get(18).f13537xoIox.add(new oXX0IoI(29, true, 16, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("accumulated_power", 29, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", true, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("left_right_balance", 30, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.LEFT_RIGHT_BALANCE));
        oixoxx0.xxIXOIIO(new X0xII0I("gps_accuracy", 31, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("vertical_speed", 32, 131, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type5));
        oixoxx0.xxIXOIIO(new X0xII0I("calories", 33, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "kcal", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("vertical_oscillation", 39, 132, 10.0d, XIXIX.OOXIXo.f3760XO, DateFormatUtils.MIN, false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("stance_time_percent", 40, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("stance_time", 41, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("activity_type", 42, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.ACTIVITY_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("left_torque_effectiveness", 43, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("right_torque_effectiveness", 44, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("left_pedal_smoothness", 45, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("right_pedal_smoothness", 46, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("combined_pedal_smoothness", 47, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("time128", 48, 2, 128.0d, XIXIX.OOXIXo.f3760XO, "s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("stroke_type", 49, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STROKE_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("zone", 50, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("ball_speed", 51, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("cadence256", 52, 132, 256.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("fractional_cadence", 53, 2, 128.0d, XIXIX.OOXIXo.f3760XO, "rpm", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("total_hemoglobin_conc", 54, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "g/dL", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("total_hemoglobin_conc_min", 55, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "g/dL", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("total_hemoglobin_conc_max", 56, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "g/dL", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("saturated_hemoglobin_percent", 57, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "%", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("saturated_hemoglobin_percent_min", 58, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "%", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("saturated_hemoglobin_percent_max", 59, 132, 10.0d, XIXIX.OOXIXo.f3760XO, "%", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("device_index", 62, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DEVICE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("left_pco", 67, 1, 1.0d, XIXIX.OOXIXo.f3760XO, DateFormatUtils.MIN, false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("right_pco", 68, 1, 1.0d, XIXIX.OOXIXo.f3760XO, DateFormatUtils.MIN, false, type6));
        oixoxx0.xxIXOIIO(new X0xII0I("left_power_phase", 69, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("left_power_phase_peak", 70, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("right_power_phase", 71, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("right_power_phase_peak", 72, 2, 0.7111111d, XIXIX.OOXIXo.f3760XO, "degrees", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_speed", 73, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_altitude", 78, 134, 5.0d, 500.0d, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("battery_soc", 81, 2, 2.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("motor_power", 82, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("vertical_ratio", 83, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("stance_time_balance", 84, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("step_length", 85, 132, 10.0d, XIXIX.OOXIXo.f3760XO, DateFormatUtils.MIN, false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("cycle_length16", 87, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "m", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("absolute_pressure", 91, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "Pa", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("depth", 92, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("next_stop_depth", 93, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("next_stop_time", 94, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("time_to_surface", 95, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("ndl_time", 96, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("cns_load", 97, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("n2_load", 98, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("respiration_rate", 99, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type3));
        oixoxx0.f14429oxoX.get(68).f13537xoIox.add(new oXX0IoI(108, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_respiration_rate", 108, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "Breaths/min", false, type2));
        Profile.Type type7 = Profile.Type.FLOAT32;
        oixoxx0.xxIXOIIO(new X0xII0I("grit", 114, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I(TanxAdType.FEED_STRING, 115, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type7));
        oixoxx0.xxIXOIIO(new X0xII0I("current_stress", 116, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("ebike_travel_range", 117, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "km", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("ebike_battery_level", 118, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("ebike_assist_mode", 119, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "depends on sensor", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("ebike_assist_level_percent", 120, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("air_time_remaining", 123, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("pressure_sac", 124, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "bar/min", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("volume_sac", 125, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "L/min", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("rmv", 126, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "L/min", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("ascent_rate", 127, 133, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("po2", 129, 2, 100.0d, XIXIX.OOXIXo.f3760XO, "percent", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("core_temperature", 139, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "C", false, type2));
    }

    public oI00o() {
        super(x0OxxIOxX.XO(20));
    }

    public Float I00O() {
        return XX(59, 0, 65535);
    }

    public void I0OO(Short sh) {
        X0xxXX0(31, 0, sh, 65535);
    }

    public void II0OOXOx(int i, Float f) {
        X0xxXX0(17, i, f, 65535);
    }

    public void IIIxO(Short sh) {
        X0xxXX0(18, 0, sh, 65535);
    }

    public Float[] IIOIX() {
        return xo0x(69, 65535);
    }

    public void IIoX0OoI(Float f) {
        X0xxXX0(124, 0, f, 65535);
    }

    public void IO0xX(Float f) {
        X0xxXX0(6, 0, f, 65535);
    }

    public void IOI(Integer num) {
        X0xxXX0(82, 0, num, 65535);
    }

    public void IOOXOOOOo(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public int IOOoXo0Ix() {
        return oOoIIO0(8, 65535);
    }

    public void IOXOxOII(Float f) {
        X0xxXX0(45, 0, f, 65535);
    }

    public void IOo0(Float f) {
        X0xxXX0(41, 0, f, 65535);
    }

    public void IOooo0o(Float f) {
        X0xxXX0(54, 0, f, 65535);
    }

    public void IXIxx0(int i, Byte b) {
        X0xxXX0(8, i, b, 65535);
    }

    public Float IXX() {
        return XX(39, 0, 65535);
    }

    public void IXXIXx00I(Float f) {
        X0xxXX0(139, 0, f, 65535);
    }

    public Float IXoIo() {
        return XX(44, 0, 65535);
    }

    public void IXxOIOO(Float f) {
        X0xxXX0(52, 0, f, 65535);
    }

    public Float IoX() {
        return XX(125, 0, 65535);
    }

    public void IoXO0XoX(Long l) {
        X0xxXX0(96, 0, l, 65535);
    }

    public void IoxOx(Integer num) {
        X0xxXX0(7, 0, num, 65535);
    }

    public int Ix0() {
        return oOoIIO0(71, 65535);
    }

    public Float Ix0x() {
        return XX(48, 0, 65535);
    }

    public Float IxI() {
        return XX(84, 0, 65535);
    }

    public Integer IxIo() {
        return oX(82, 0, 65535);
    }

    public void IxO0Oxo(Float f) {
        X0xxXX0(114, 0, f, 65535);
    }

    public Byte IxX00(int i) {
        return XxX0x0xxx(8, i, 65535);
    }

    public Integer O00() {
        return oX(33, 0, 65535);
    }

    public void O0O0Io00X(Float f) {
        X0xxXX0(2, 0, f, 65535);
    }

    public Integer O0OOX0IIx() {
        return oX(7, 0, 65535);
    }

    public Float O0o0() {
        return XX(56, 0, 65535);
    }

    public Float O0x(int i) {
        return XX(71, i, 65535);
    }

    public void O0xO0(Integer num) {
        X0xxXX0(28, 0, num, 65535);
    }

    public Float O0xxXxI() {
        return XX(47, 0, 65535);
    }

    public void OI0IXox(Short sh) {
        X0xxXX0(119, 0, sh, 65535);
    }

    public void OIII0O(Short sh) {
        X0xxXX0(50, 0, sh, 65535);
    }

    public void OIIXOxo(Float f) {
        X0xxXX0(127, 0, f, 65535);
    }

    public Float OIoxIx() {
        return XX(85, 0, 65535);
    }

    public Float OIx00oxx() {
        return XX(81, 0, 65535);
    }

    public void OIx0xoOo(Float f) {
        X0xxXX0(46, 0, f, 65535);
    }

    public Float OIxI0O() {
        return XX(55, 0, 65535);
    }

    public void OIxOIX0II(Float f) {
        X0xxXX0(48, 0, f, 65535);
    }

    public Float OIxOX(int i) {
        return XX(72, i, 65535);
    }

    public Short OIxx0I0() {
        return XI0oooXX(10, 0, 65535);
    }

    public Float OO0() {
        return XX(127, 0, 65535);
    }

    public Short OOIXx0x() {
        return XI0oooXX(31, 0, 65535);
    }

    public Short OOOI() {
        return XI0oooXX(62, 0, 65535);
    }

    public void OOOox(Integer num) {
        X0xxXX0(98, 0, num, 65535);
    }

    public Float OOxOI() {
        return XX(108, 0, 65535);
    }

    public Float OOxOOxIO() {
        return XX(11, 0, 65535);
    }

    public Long OX() {
        return x0xO(29, 0, 65535);
    }

    public void OX00o0X(Float f) {
        X0xxXX0(56, 0, f, 65535);
    }

    public Float OXIOoo0X0() {
        return XX(126, 0, 65535);
    }

    public Float OXXoIoXI() {
        return XX(115, 0, 65535);
    }

    public Byte OXooXo() {
        return XxX0x0xxx(13, 0, 65535);
    }

    public void OXxx0OO(Float f) {
        X0xxXX0(126, 0, f, 65535);
    }

    public void OoI0OO(Float f) {
        X0xxXX0(43, 0, f, 65535);
    }

    public void OoIXo(Long l) {
        X0xxXX0(29, 0, l, 65535);
    }

    public Float OooI() {
        return XX(51, 0, 65535);
    }

    public Byte OooO0XOx() {
        return XxX0x0xxx(68, 0, 65535);
    }

    public void Oox(Short sh) {
        X0xxXX0(120, 0, sh, 65535);
    }

    public void OoxOxII(Float f) {
        X0xxXX0(39, 0, f, 65535);
    }

    public void Ox00XOXoo(Float f) {
        X0xxXX0(40, 0, f, 65535);
    }

    public void OxIxx0(Float f) {
        X0xxXX0(129, 0, f, 65535);
    }

    public Short OxO() {
        return XI0oooXX(119, 0, 65535);
    }

    public Float OxXXx0X() {
        return XX(92, 0, 65535);
    }

    public int Oxo00O() {
        return oOoIIO0(70, 65535);
    }

    public Long Oxx() {
        return x0xO(91, 0, 65535);
    }

    public void Oxxo(Float f) {
        X0xxXX0(32, 0, f, 65535);
    }

    public void X0(Float f) {
        X0xxXX0(53, 0, f, 65535);
    }

    public void X00IxOx(Short sh) {
        X0xxXX0(118, 0, sh, 65535);
    }

    public Float X00xOoXI() {
        return XX(78, 0, 65535);
    }

    public int X0IOOI() {
        return oOoIIO0(69, 65535);
    }

    public Short X0O0I0() {
        return XI0oooXX(120, 0, 65535);
    }

    public void X0OXX(Float f) {
        X0xxXX0(59, 0, f, 65535);
    }

    public Float[] X0ooXIooI() {
        return xo0x(70, 65535);
    }

    public void X0x(Short sh) {
        X0xxXX0(62, 0, sh, 65535);
    }

    public void X0xOO(ActivityType activityType) {
        X0xxXX0(42, 0, Short.valueOf(activityType.value), 65535);
    }

    public Long XIOOI() {
        return x0xO(95, 0, 65535);
    }

    public void XIxO(Float f) {
        X0xxXX0(12, 0, f, 65535);
    }

    public Float XO00XOO() {
        return XX(73, 0, 65535);
    }

    public void XO0OX(Float f) {
        X0xxXX0(5, 0, f, 65535);
    }

    public Byte[] XO0o() {
        return oo0xXOI0I(8, 65535);
    }

    public void XOOO0O(Float f) {
        X0xxXX0(85, 0, f, 65535);
    }

    public Float XOo0() {
        return XX(32, 0, 65535);
    }

    public Long XOxoX() {
        return x0xO(96, 0, 65535);
    }

    public void XXIoX0(Short sh) {
        X0xxXX0(30, 0, sh, 65535);
    }

    public void XXO0(int i, Float f) {
        X0xxXX0(71, i, f, 65535);
    }

    public void XXooOOI(Float f) {
        X0xxXX0(125, 0, f, 65535);
    }

    public void XXx0OXXXo(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public Float Xo() {
        return XX(45, 0, 65535);
    }

    public Float XoIxOXIXo() {
        return XX(2, 0, 65535);
    }

    public void XoOOx0IX(Short sh) {
        X0xxXX0(3, 0, sh, 65535);
    }

    public Float XoOxI0ox(int i) {
        return XX(70, i, 65535);
    }

    public Float XooIO0oo0() {
        return XX(53, 0, 65535);
    }

    public void Xx(Float f) {
        X0xxXX0(57, 0, f, 65535);
    }

    public void Xx0(Float f) {
        X0xxXX0(58, 0, f, 65535);
    }

    public void XxI(Short sh) {
        X0xxXX0(4, 0, sh, 65535);
    }

    public void XxIIOXIXx(Long l) {
        X0xxXX0(123, 0, l, 65535);
    }

    public void XxIOX(Float f) {
        X0xxXX0(84, 0, f, 65535);
    }

    public Float XxIo() {
        return XX(129, 0, 65535);
    }

    public Float XxXX() {
        return XX(46, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float o00xOoIO() {
        return XX(41, 0, 65535);
    }

    public Long o0IXXIx() {
        return x0xO(123, 0, 65535);
    }

    public Float o0OO0(int i) {
        return XX(17, i, 65535);
    }

    public Float[] o0Oo() {
        return xo0x(71, 65535);
    }

    public Integer o0Xo() {
        return oX(117, 0, 65535);
    }

    public void o0oIxXOx(Float f) {
        X0xxXX0(11, 0, f, 65535);
    }

    public Float o0oxo0oI() {
        return XX(5, 0, 65535);
    }

    public void o0xIIX0(Byte b) {
        X0xxXX0(13, 0, b, 65535);
    }

    public void o0xIoII(int i, Float f) {
        X0xxXX0(70, i, f, 65535);
    }

    public void o0xOIoxo(Float f) {
        X0xxXX0(115, 0, f, 65535);
    }

    public Short oI0() {
        return XI0oooXX(50, 0, 65535);
    }

    public void oI00o(Short sh) {
        X0xxXX0(99, 0, sh, 65535);
    }

    public void oI0X0(Float f) {
        X0xxXX0(51, 0, f, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oIXoXx0(Float f) {
        X0xxXX0(81, 0, f, 65535);
    }

    public Float oO0IXx() {
        return XX(58, 0, 65535);
    }

    public void oO0OX0(StrokeType strokeType) {
        X0xxXX0(49, 0, Short.valueOf(strokeType.value), 65535);
    }

    public void oOIXoIXXI(Short sh) {
        X0xxXX0(10, 0, sh, 65535);
    }

    public void oOIx(Float f) {
        X0xxXX0(108, 0, f, 65535);
    }

    public Short oX000x() {
        return XI0oooXX(30, 0, 65535);
    }

    public Float oX0I0O() {
        return XX(139, 0, 65535);
    }

    public Float oX0ooo0I0() {
        return XX(87, 0, 65535);
    }

    public void oXIoIo(Integer num) {
        X0xxXX0(117, 0, num, 65535);
    }

    public ActivityType oXIoO() {
        Short XI0oooXX2 = XI0oooXX(42, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return ActivityType.getByValue(XI0oooXX2);
    }

    public Float oXO0oOx0(int i) {
        return XX(69, i, 65535);
    }

    public StrokeType oXoXxOo() {
        Short XI0oooXX2 = XI0oooXX(49, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return StrokeType.getByValue(XI0oooXX2);
    }

    public void oXxOXOX(int i, Float f) {
        X0xxXX0(69, i, f, 65535);
    }

    public Float oXxx000() {
        return XX(114, 0, 65535);
    }

    public Short oo00() {
        return XI0oooXX(18, 0, 65535);
    }

    public Integer oo0oIXo() {
        return oX(1, 0, 65535);
    }

    public Float ooO0oXxI() {
        return XX(6, 0, 65535);
    }

    public Long oox000IX() {
        return x0xO(19, 0, 65535);
    }

    public void ox0(Float f) {
        X0xxXX0(55, 0, f, 65535);
    }

    public Float ox0I() {
        return XX(54, 0, 65535);
    }

    public Integer oxIO0IIo() {
        return oX(0, 0, 65535);
    }

    public void oxOIoIx(Byte b) {
        X0xxXX0(68, 0, b, 65535);
    }

    public Integer oxOXxoXII() {
        return oX(28, 0, 65535);
    }

    public Float x00IOx() {
        return XX(116, 0, 65535);
    }

    public Float x00X0xoXO() {
        return XX(83, 0, 65535);
    }

    public Float[] x0OOI() {
        return xo0x(72, 65535);
    }

    public Float x0oox0() {
        return XX(57, 0, 65535);
    }

    public Integer x0oxIIIX() {
        return oX(98, 0, 65535);
    }

    public void x0xOIoO(int i, Float f) {
        X0xxXX0(72, i, f, 65535);
    }

    public void xI0OXooO(Long l) {
        X0xxXX0(19, 0, l, 65535);
    }

    public Float xIOXX() {
        return XX(43, 0, 65535);
    }

    public Float xIXIOX() {
        return XX(93, 0, 65535);
    }

    public Float xIXOoI() {
        return XX(40, 0, 65535);
    }

    public Short xIXX() {
        return XI0oooXX(4, 0, 65535);
    }

    public void xIXoO0Xx(Long l) {
        X0xxXX0(94, 0, l, 65535);
    }

    public void xIoXXXIXo(Long l) {
        X0xxXX0(91, 0, l, 65535);
    }

    public Byte xIx() {
        return XxX0x0xxx(67, 0, 65535);
    }

    public Float xIx0XO() {
        return XX(9, 0, 65535);
    }

    public int xIxooxXX() {
        return oOoIIO0(17, 65535);
    }

    public Short xOOxI() {
        return XI0oooXX(3, 0, 65535);
    }

    public Short xOOxIO() {
        return XI0oooXX(97, 0, 65535);
    }

    public void xOoIIIoXI(Float f) {
        X0xxXX0(78, 0, f, 65535);
    }

    public void xOx(Long l) {
        X0xxXX0(95, 0, l, 65535);
    }

    public void xOxOoo(Float f) {
        X0xxXX0(73, 0, f, 65535);
    }

    public void xOxxXO(Float f) {
        X0xxXX0(9, 0, f, 65535);
    }

    public Float xX() {
        return XX(12, 0, 65535);
    }

    public void xX0ox(Integer num) {
        X0xxXX0(33, 0, num, 65535);
    }

    public void xXIX0Xo(Float f) {
        X0xxXX0(83, 0, f, 65535);
    }

    public Float[] xXo() {
        return xo0x(17, 65535);
    }

    public Long xo() {
        return x0xO(94, 0, 65535);
    }

    public void xoIXOxX(Short sh) {
        X0xxXX0(97, 0, sh, 65535);
    }

    public Float xoX() {
        return XX(124, 0, 65535);
    }

    public void xooxxX(Float f) {
        X0xxXX0(47, 0, f, 65535);
    }

    public int xox() {
        return oOoIIO0(72, 65535);
    }

    public void xoxo(Float f) {
        X0xxXX0(44, 0, f, 65535);
    }

    public void xx(Float f) {
        X0xxXX0(93, 0, f, 65535);
    }

    public Short xx0() {
        return XI0oooXX(99, 0, 65535);
    }

    public void xx00oOoI(Byte b) {
        X0xxXX0(67, 0, b, 65535);
    }

    public void xx0o0O(Float f) {
        X0xxXX0(116, 0, f, 65535);
    }

    public void xxXXXxIxo(Float f) {
        X0xxXX0(92, 0, f, 65535);
    }

    public Short xxx00() {
        return XI0oooXX(118, 0, 65535);
    }

    public Float xxxI() {
        return XX(52, 0, 65535);
    }

    public void xxxoo0XI(Float f) {
        X0xxXX0(87, 0, f, 65535);
    }

    public oI00o(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
