package com.garmin.fit;

/* loaded from: classes9.dex */
public enum DiveAlert {
    NDL_REACHED(0),
    GAS_SWITCH_PROMPTED(1),
    NEAR_SURFACE(2),
    APPROACHING_NDL(3),
    PO2_WARN(4),
    PO2_CRIT_HIGH(5),
    PO2_CRIT_LOW(6),
    TIME_ALERT(7),
    DEPTH_ALERT(8),
    DECO_CEILING_BROKEN(9),
    DECO_COMPLETE(10),
    SAFETY_STOP_BROKEN(11),
    SAFETY_STOP_COMPLETE(12),
    CNS_WARNING(13),
    CNS_CRITICAL(14),
    OTU_WARNING(15),
    OTU_CRITICAL(16),
    ASCENT_CRITICAL(17),
    ALERT_DISMISSED_BY_KEY(18),
    ALERT_DISMISSED_BY_TIMEOUT(19),
    BATTERY_LOW(20),
    BATTERY_CRITICAL(21),
    SAFETY_STOP_STARTED(22),
    APPROACHING_FIRST_DECO_STOP(23),
    SETPOINT_SWITCH_AUTO_LOW(24),
    SETPOINT_SWITCH_AUTO_HIGH(25),
    SETPOINT_SWITCH_MANUAL_LOW(26),
    SETPOINT_SWITCH_MANUAL_HIGH(27),
    AUTO_SETPOINT_SWITCH_IGNORED(28),
    SWITCHED_TO_OPEN_CIRCUIT(29),
    SWITCHED_TO_CLOSED_CIRCUIT(30),
    TANK_BATTERY_LOW(32),
    PO2_CCR_DIL_LOW(33),
    DECO_STOP_CLEARED(34),
    APNEA_NEUTRAL_BUOYANCY(35),
    APNEA_TARGET_DEPTH(36),
    APNEA_SURFACE(37),
    APNEA_HIGH_SPEED(38),
    APNEA_LOW_SPEED(39),
    INVALID(255);

    protected short value;

    DiveAlert(short s) {
        this.value = s;
    }

    public static DiveAlert getByValue(Short sh) {
        for (DiveAlert diveAlert : values()) {
            if (sh.shortValue() == diveAlert.value) {
                return diveAlert;
            }
        }
        return INVALID;
    }

    public static String getStringFromValue(DiveAlert diveAlert) {
        return diveAlert.name();
    }

    public short getValue() {
        return this.value;
    }
}
