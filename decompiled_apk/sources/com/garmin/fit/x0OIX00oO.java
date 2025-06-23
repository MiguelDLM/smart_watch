package com.garmin.fit;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class x0OIX00oO extends oIXoXx0 implements XIxO {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15185II0XooXoX = 253;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f15186IIXOooo = 15;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f15187IXxxXO = 11;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f15188O0xOxO = 24;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15189OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f15190Oo = 10;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f15191OxI = 23;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f15192Oxx0xo = 12;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f15193OxxIIOOXO = 14;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final oIXoXx0 f15194X0IIOO;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f15195o00 = 22;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f15196oI0IIXIo = 13;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f15197oO = 8;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15198oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f15199ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f15200x0XOIxOo = 7;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f15201x0xO0oo = 9;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15202xoIox = 1;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f15203xoXoI = 21;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15204xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0(NotificationCompat.CATEGORY_EVENT, 21);
        f15194X0IIOO = oixoxx0;
        Profile.Type type = Profile.Type.DATE_TIME;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I(NotificationCompat.CATEGORY_EVENT, 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EVENT));
        oixoxx0.xxIXOIIO(new X0xII0I("event_type", 1, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EVENT_TYPE));
        Profile.Type type2 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("data16", 2, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.f14429oxoX.get(3).f13537xoIox.add(new oXX0IoI(3, false, 16, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("data", 3, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT32));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("timer_trigger", 0, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(0).II0xO0(0, 0L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("course_point_index", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(1).II0xO0(0, 10L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("battery_level", 132, 1000.0d, XIXIX.OOXIXo.f3760XO, ExifInterface.GPS_MEASUREMENT_INTERRUPTED));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(2).II0xO0(0, 11L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("virtual_partner_speed", 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(3).II0xO0(0, 12L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("hr_high_alert", 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(4).II0xO0(0, 13L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("hr_low_alert", 2, 1.0d, XIXIX.OOXIXo.f3760XO, "bpm"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(5).II0xO0(0, 14L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("speed_high_alert", 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(6).II0xO0(0, 15L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("speed_low_alert", 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(7).II0xO0(0, 16L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("cad_high_alert", 132, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(8).II0xO0(0, 17L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("cad_low_alert", 132, 1.0d, XIXIX.OOXIXo.f3760XO, "rpm"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(9).II0xO0(0, 18L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("power_high_alert", 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(10).II0xO0(0, 19L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("power_low_alert", 132, 1.0d, XIXIX.OOXIXo.f3760XO, "watts"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(11).II0xO0(0, 20L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("time_duration_alert", 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(12).II0xO0(0, 23L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("distance_duration_alert", 134, 100.0d, XIXIX.OOXIXo.f3760XO, "m"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(13).II0xO0(0, 24L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("calorie_duration_alert", 134, 1.0d, XIXIX.OOXIXo.f3760XO, "calories"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(14).II0xO0(0, 25L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("fitness_equipment_state", 0, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(15).II0xO0(0, 27L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("sport_point", 134, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(16).II0xO0(0, 33L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(16).oIX0oI(new oXX0IoI(7, false, 16, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(16).oIX0oI(new oXX0IoI(8, false, 16, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("gear_change_data", 134, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(17).II0xO0(0, 42L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(17).II0xO0(0, 43L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(17).oIX0oI(new oXX0IoI(11, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(17).oIX0oI(new oXX0IoI(12, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(17).oIX0oI(new oXX0IoI(9, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(17).oIX0oI(new oXX0IoI(10, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("rider_position", 0, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(18).II0xO0(0, 44L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("comm_timeout", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(19).II0xO0(0, 47L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("dive_alert", 0, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(20).II0xO0(0, 56L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("auto_activity_detect_duration", 132, 1.0d, XIXIX.OOXIXo.f3760XO, "min"));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(21).II0xO0(0, 54L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("radar_threat_alert", 134, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(22).II0xO0(0, 75L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(22).oIX0oI(new oXX0IoI(21, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(22).oIX0oI(new oXX0IoI(22, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(22).oIX0oI(new oXX0IoI(23, false, 8, 10.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(22).oIX0oI(new oXX0IoI(24, false, 8, 10.0d, XIXIX.OOXIXo.f3760XO));
        Profile.Type type3 = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("event_group", 4, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("score", 7, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("opponent_score", 8, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        Profile.Type type4 = Profile.Type.UINT8Z;
        oixoxx0.xxIXOIIO(new X0xII0I("front_gear_num", 9, 10, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("front_gear", 10, 10, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("rear_gear_num", 11, 10, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("rear_gear", 12, 10, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("device_index", 13, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DEVICE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("activity_type", 14, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.ACTIVITY_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("start_timestamp", 15, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.f14429oxoX.get(14).f13530OOXIXo.add(new xxOoXO("auto_activity_detect_start_timestamp", 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s"));
        oixoxx0.f14429oxoX.get(14).f13530OOXIXo.get(0).II0xO0(0, 54L);
        oixoxx0.xxIXOIIO(new X0xII0I("radar_threat_level_max", 21, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.RADAR_THREAT_LEVEL_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("radar_threat_count", 22, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("radar_threat_avg_approach_speed", 23, 2, 10.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("radar_threat_max_approach_speed", 24, 2, 10.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type3));
    }

    public x0OIX00oO() {
        super(x0OxxIOxX.XO(21));
    }

    public void I00O(Float f) {
        X0xxXX0(3, 0, f, 7);
    }

    @Override // com.garmin.fit.XIxO
    public Short I0Io() {
        return XI0oooXX(4, 0, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public Event II0xO0() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Event.getByValue(XI0oooXX2);
    }

    public void IIOIX(Integer num) {
        X0xxXX0(3, 0, num, 21);
    }

    public void IOOoXo0Ix(Short sh) {
        X0xxXX0(13, 0, sh, 65535);
    }

    public void IXoIo(RiderPositionType riderPositionType) {
        X0xxXX0(3, 0, Short.valueOf(riderPositionType.value), 18);
    }

    public void Ix0(FitnessEquipmentState fitnessEquipmentState) {
        X0xxXX0(3, 0, Short.valueOf(fitnessEquipmentState.value), 15);
    }

    public void IxIo(Long l) {
        X0xxXX0(3, 0, l, 14);
    }

    public FitnessEquipmentState IxX00() {
        Short XI0oooXX2 = XI0oooXX(3, 0, 15);
        if (XI0oooXX2 == null) {
            return null;
        }
        return FitnessEquipmentState.getByValue(XI0oooXX2);
    }

    public Integer O00() {
        return oX(2, 0, 65535);
    }

    public void O0OOX0IIx(Integer num) {
        X0xxXX0(8, 0, num, 65535);
    }

    public void O0x(RadarThreatLevelType radarThreatLevelType) {
        X0xxXX0(21, 0, Short.valueOf(radarThreatLevelType.value), 65535);
    }

    public Float O0xxXxI() {
        return XX(3, 0, 13);
    }

    public Integer OIx00oxx() {
        return oX(3, 0, 19);
    }

    public void OIxOX(Short sh) {
        X0xxXX0(12, 0, sh, 65535);
    }

    public void OIxx0I0(Integer num) {
        X0xxXX0(3, 0, num, 11);
    }

    public Integer OO0() {
        return oX(3, 0, 9);
    }

    public Float OOIXx0x() {
        return XX(3, 0, 7);
    }

    public Integer OOOI() {
        return oX(3, 0, 11);
    }

    public Short OOxOI() {
        return XI0oooXX(11, 0, 65535);
    }

    public Integer OX() {
        return oX(3, 0, 21);
    }

    public void OXIOoo0X0(Integer num) {
        X0xxXX0(7, 0, num, 65535);
    }

    public Integer OXXoIoXI() {
        return oX(7, 0, 65535);
    }

    public Long OooI() {
        return x0xO(3, 0, 14);
    }

    public void OooO0XOx(Float f) {
        X0xxXX0(23, 0, f, 65535);
    }

    public Short OxO() {
        return XI0oooXX(22, 0, 65535);
    }

    public Integer OxXXx0X() {
        return oX(3, 0, 10);
    }

    public void Oxo00O(DiveAlert diveAlert) {
        X0xxXX0(3, 0, Short.valueOf(diveAlert.value), 20);
    }

    public ActivityType Oxx() {
        Short XI0oooXX2 = XI0oooXX(14, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return ActivityType.getByValue(XI0oooXX2);
    }

    @Override // com.garmin.fit.XIxO
    public void Oxx0IOOO(Short sh) {
        X0xxXX0(4, 0, sh, 65535);
    }

    public Short X00xOoXI() {
        return XI0oooXX(12, 0, 65535);
    }

    public void X0IOOI(Float f) {
        X0xxXX0(3, 0, f, 13);
    }

    public Float X0O0I0() {
        return XX(23, 0, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public EventType X0o0xo() {
        Short XI0oooXX2 = XI0oooXX(1, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return EventType.getByValue(XI0oooXX2);
    }

    public void X0ooXIooI(Float f) {
        X0xxXX0(3, 0, f, 2);
    }

    @Override // com.garmin.fit.XIxO
    public void XO(EventType eventType) {
        X0xxXX0(1, 0, Short.valueOf(eventType.value), 65535);
    }

    public RiderPositionType XO00XOO() {
        Short XI0oooXX2 = XI0oooXX(3, 0, 18);
        if (XI0oooXX2 == null) {
            return null;
        }
        return RiderPositionType.getByValue(XI0oooXX2);
    }

    public Short XO0o() {
        return XI0oooXX(10, 0, 65535);
    }

    public void XOxoX(Integer num) {
        X0xxXX0(3, 0, num, 1);
    }

    public Float Xo() {
        return XX(3, 0, 3);
    }

    public Integer XoIxOXIXo() {
        return oX(3, 0, 8);
    }

    public void XoOxI0ox(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(15, 0, o0xxxxxxx.x0xO0oo(), 0);
    }

    public Float XooIO0oo0() {
        return XX(3, 0, 6);
    }

    public void XxIo(Long l) {
        X0xxXX0(3, 0, l, 17);
    }

    public void XxXX(Short sh) {
        X0xxXX0(22, 0, sh, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public void o00xOoIO(Float f) {
        X0xxXX0(3, 0, f, 3);
    }

    public Float o0IXXIx() {
        return XX(3, 0, 2);
    }

    public void o0OO0(Float f) {
        X0xxXX0(3, 0, f, 12);
    }

    public void o0Oo(Float f) {
        X0xxXX0(24, 0, f, 65535);
    }

    public Float o0Xo() {
        return XX(24, 0, 65535);
    }

    public Long o0oxo0oI() {
        return x0xO(3, 0, 22);
    }

    @Override // com.garmin.fit.XIxO
    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oO0IXx(Long l) {
        X0xxXX0(3, 0, l, 16);
    }

    public void oX000x(Integer num) {
        X0xxXX0(3, 0, num, 8);
    }

    public Short oX0I0O() {
        return XI0oooXX(9, 0, 65535);
    }

    public Short oX0ooo0I0() {
        return XI0oooXX(3, 0, 5);
    }

    public o0xxxXXxX oXIoO() {
        return oXX0IoI(x0xO(15, 0, 0));
    }

    public void oXO0oOx0(ActivityType activityType) {
        X0xxXX0(14, 0, Short.valueOf(activityType.value), 65535);
    }

    public o0xxxXXxX oXxx000() {
        return oXX0IoI(x0xO(15, 0, 65535));
    }

    public Integer oo00() {
        return oX(8, 0, 65535);
    }

    public void oo0oIXo(Short sh) {
        X0xxXX0(3, 0, sh, 5);
    }

    public void ooO0oXxI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(15, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oxIO0IIo(Short sh) {
        X0xxXX0(3, 0, sh, 4);
    }

    public DiveAlert oxOXxoXII() {
        Short XI0oooXX2 = XI0oooXX(3, 0, 20);
        if (XI0oooXX2 == null) {
            return null;
        }
        return DiveAlert.getByValue(XI0oooXX2);
    }

    @Override // com.garmin.fit.XIxO
    public void oxoX(Event event) {
        X0xxXX0(0, 0, Short.valueOf(event.value), 65535);
    }

    public Long x00IOx() {
        return x0xO(3, 0, 17);
    }

    public void x0OOI(Short sh) {
        X0xxXX0(11, 0, sh, 65535);
    }

    public void x0oox0(Float f) {
        X0xxXX0(3, 0, f, 6);
    }

    public void x0oxIIIX(Integer num) {
        X0xxXX0(3, 0, num, 19);
    }

    public void xIOXX(Integer num) {
        X0xxXX0(3, 0, num, 9);
    }

    public void xIXIOX(Long l) {
        X0xxXX0(3, 0, l, 65535);
    }

    public Integer xIXX() {
        return oX(3, 0, 1);
    }

    public TimerTrigger xIx() {
        Short XI0oooXX2 = XI0oooXX(3, 0, 0);
        if (XI0oooXX2 == null) {
            return null;
        }
        return TimerTrigger.getByValue(XI0oooXX2);
    }

    public Long xIx0XO() {
        return x0xO(3, 0, 16);
    }

    public void xIxooxXX(Short sh) {
        X0xxXX0(9, 0, sh, 65535);
    }

    public Float xOOxI() {
        return XX(3, 0, 12);
    }

    public Short xOOxIO() {
        return XI0oooXX(13, 0, 65535);
    }

    public Short xX() {
        return XI0oooXX(3, 0, 4);
    }

    public void xXo(TimerTrigger timerTrigger) {
        X0xxXX0(3, 0, Short.valueOf(timerTrigger.value), 0);
    }

    public void xo(Integer num) {
        X0xxXX0(2, 0, num, 65535);
    }

    public void xoX(Integer num) {
        X0xxXX0(3, 0, num, 10);
    }

    public void xox(Short sh) {
        X0xxXX0(10, 0, sh, 65535);
    }

    public void xx0(Long l) {
        X0xxXX0(3, 0, l, 22);
    }

    public RadarThreatLevelType xxx00() {
        Short XI0oooXX2 = XI0oooXX(21, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return RadarThreatLevelType.getByValue(XI0oooXX2);
    }

    public Long xxxI() {
        return x0xO(3, 0, 65535);
    }

    public x0OIX00oO(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
