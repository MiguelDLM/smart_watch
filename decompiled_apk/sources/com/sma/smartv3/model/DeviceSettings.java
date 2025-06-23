package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.entity.BleAlarm;
import com.szabh.smable3.entity.BleCoaching;
import com.szabh.smable3.entity.BleDrinkWaterSettings;
import com.szabh.smable3.entity.BleGameSettings;
import com.szabh.smable3.entity.BleGestureWake;
import com.szabh.smable3.entity.BleGirlCareSettings;
import com.szabh.smable3.entity.BleHrMonitoringSettings;
import com.szabh.smable3.entity.BleNoDisturbSettings;
import com.szabh.smable3.entity.BleSchedule;
import com.szabh.smable3.entity.BleSedentarinessSettings;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class DeviceSettings extends JsonField {

    @oOoXoXO
    private List<BleAlarm> alarms;

    @oOoXoXO
    private Integer backLight;

    @oOoXoXO
    private List<BleCoaching> coachings;

    @oOoXoXO
    private BleDrinkWaterSettings drinkWaterSettings;

    @oOoXoXO
    private final BleGameSettings gameSettings;

    @oOoXoXO
    private BleGestureWake gestureWake;

    @oOoXoXO
    private BleGirlCareSettings girlCare;

    @oOoXoXO
    private BleHrMonitoringSettings hrMonitoringSettings;

    @oOoXoXO
    private BleNoDisturbSettings noDisturbSettings;

    @oOoXoXO
    private List<BleSchedule> schedules;

    @oOoXoXO
    private BleSedentarinessSettings sedentarinessSettings;

    @oOoXoXO
    private Integer stepGoal;

    @oOoXoXO
    private Integer vibration;

    public DeviceSettings(@oOoXoXO Integer num, @oOoXoXO Integer num2, @oOoXoXO BleSedentarinessSettings bleSedentarinessSettings, @oOoXoXO BleNoDisturbSettings bleNoDisturbSettings, @oOoXoXO Integer num3, @oOoXoXO List<BleAlarm> list, @oOoXoXO BleHrMonitoringSettings bleHrMonitoringSettings, @oOoXoXO BleGestureWake bleGestureWake, @oOoXoXO BleGirlCareSettings bleGirlCareSettings, @oOoXoXO List<BleSchedule> list2, @oOoXoXO List<BleCoaching> list3, @oOoXoXO BleDrinkWaterSettings bleDrinkWaterSettings, @oOoXoXO BleGameSettings bleGameSettings) {
        this.stepGoal = num;
        this.backLight = num2;
        this.sedentarinessSettings = bleSedentarinessSettings;
        this.noDisturbSettings = bleNoDisturbSettings;
        this.vibration = num3;
        this.alarms = list;
        this.hrMonitoringSettings = bleHrMonitoringSettings;
        this.gestureWake = bleGestureWake;
        this.girlCare = bleGirlCareSettings;
        this.schedules = list2;
        this.coachings = list3;
        this.drinkWaterSettings = bleDrinkWaterSettings;
        this.gameSettings = bleGameSettings;
    }

    @oOoXoXO
    public final Integer component1() {
        return this.stepGoal;
    }

    @oOoXoXO
    public final List<BleSchedule> component10() {
        return this.schedules;
    }

    @oOoXoXO
    public final List<BleCoaching> component11() {
        return this.coachings;
    }

    @oOoXoXO
    public final BleDrinkWaterSettings component12() {
        return this.drinkWaterSettings;
    }

    @oOoXoXO
    public final BleGameSettings component13() {
        return this.gameSettings;
    }

    @oOoXoXO
    public final Integer component2() {
        return this.backLight;
    }

    @oOoXoXO
    public final BleSedentarinessSettings component3() {
        return this.sedentarinessSettings;
    }

    @oOoXoXO
    public final BleNoDisturbSettings component4() {
        return this.noDisturbSettings;
    }

    @oOoXoXO
    public final Integer component5() {
        return this.vibration;
    }

    @oOoXoXO
    public final List<BleAlarm> component6() {
        return this.alarms;
    }

    @oOoXoXO
    public final BleHrMonitoringSettings component7() {
        return this.hrMonitoringSettings;
    }

    @oOoXoXO
    public final BleGestureWake component8() {
        return this.gestureWake;
    }

    @oOoXoXO
    public final BleGirlCareSettings component9() {
        return this.girlCare;
    }

    @OOXIXo
    public final DeviceSettings copy(@oOoXoXO Integer num, @oOoXoXO Integer num2, @oOoXoXO BleSedentarinessSettings bleSedentarinessSettings, @oOoXoXO BleNoDisturbSettings bleNoDisturbSettings, @oOoXoXO Integer num3, @oOoXoXO List<BleAlarm> list, @oOoXoXO BleHrMonitoringSettings bleHrMonitoringSettings, @oOoXoXO BleGestureWake bleGestureWake, @oOoXoXO BleGirlCareSettings bleGirlCareSettings, @oOoXoXO List<BleSchedule> list2, @oOoXoXO List<BleCoaching> list3, @oOoXoXO BleDrinkWaterSettings bleDrinkWaterSettings, @oOoXoXO BleGameSettings bleGameSettings) {
        return new DeviceSettings(num, num2, bleSedentarinessSettings, bleNoDisturbSettings, num3, list, bleHrMonitoringSettings, bleGestureWake, bleGirlCareSettings, list2, list3, bleDrinkWaterSettings, bleGameSettings);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceSettings)) {
            return false;
        }
        DeviceSettings deviceSettings = (DeviceSettings) obj;
        return IIX0o.Oxx0IOOO(this.stepGoal, deviceSettings.stepGoal) && IIX0o.Oxx0IOOO(this.backLight, deviceSettings.backLight) && IIX0o.Oxx0IOOO(this.sedentarinessSettings, deviceSettings.sedentarinessSettings) && IIX0o.Oxx0IOOO(this.noDisturbSettings, deviceSettings.noDisturbSettings) && IIX0o.Oxx0IOOO(this.vibration, deviceSettings.vibration) && IIX0o.Oxx0IOOO(this.alarms, deviceSettings.alarms) && IIX0o.Oxx0IOOO(this.hrMonitoringSettings, deviceSettings.hrMonitoringSettings) && IIX0o.Oxx0IOOO(this.gestureWake, deviceSettings.gestureWake) && IIX0o.Oxx0IOOO(this.girlCare, deviceSettings.girlCare) && IIX0o.Oxx0IOOO(this.schedules, deviceSettings.schedules) && IIX0o.Oxx0IOOO(this.coachings, deviceSettings.coachings) && IIX0o.Oxx0IOOO(this.drinkWaterSettings, deviceSettings.drinkWaterSettings) && IIX0o.Oxx0IOOO(this.gameSettings, deviceSettings.gameSettings);
    }

    @oOoXoXO
    public final List<BleAlarm> getAlarms() {
        return this.alarms;
    }

    @oOoXoXO
    public final Integer getBackLight() {
        return this.backLight;
    }

    @oOoXoXO
    public final List<BleCoaching> getCoachings() {
        return this.coachings;
    }

    @oOoXoXO
    public final BleDrinkWaterSettings getDrinkWaterSettings() {
        return this.drinkWaterSettings;
    }

    @oOoXoXO
    public final BleGameSettings getGameSettings() {
        return this.gameSettings;
    }

    @oOoXoXO
    public final BleGestureWake getGestureWake() {
        return this.gestureWake;
    }

    @oOoXoXO
    public final BleGirlCareSettings getGirlCare() {
        return this.girlCare;
    }

    @oOoXoXO
    public final BleHrMonitoringSettings getHrMonitoringSettings() {
        return this.hrMonitoringSettings;
    }

    @oOoXoXO
    public final BleNoDisturbSettings getNoDisturbSettings() {
        return this.noDisturbSettings;
    }

    @oOoXoXO
    public final List<BleSchedule> getSchedules() {
        return this.schedules;
    }

    @oOoXoXO
    public final BleSedentarinessSettings getSedentarinessSettings() {
        return this.sedentarinessSettings;
    }

    @oOoXoXO
    public final Integer getStepGoal() {
        return this.stepGoal;
    }

    @oOoXoXO
    public final Integer getVibration() {
        return this.vibration;
    }

    public int hashCode() {
        Integer num = this.stepGoal;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.backLight;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        BleSedentarinessSettings bleSedentarinessSettings = this.sedentarinessSettings;
        int hashCode3 = (hashCode2 + (bleSedentarinessSettings == null ? 0 : bleSedentarinessSettings.hashCode())) * 31;
        BleNoDisturbSettings bleNoDisturbSettings = this.noDisturbSettings;
        int hashCode4 = (hashCode3 + (bleNoDisturbSettings == null ? 0 : bleNoDisturbSettings.hashCode())) * 31;
        Integer num3 = this.vibration;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        List<BleAlarm> list = this.alarms;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        BleHrMonitoringSettings bleHrMonitoringSettings = this.hrMonitoringSettings;
        int hashCode7 = (hashCode6 + (bleHrMonitoringSettings == null ? 0 : bleHrMonitoringSettings.hashCode())) * 31;
        BleGestureWake bleGestureWake = this.gestureWake;
        int hashCode8 = (hashCode7 + (bleGestureWake == null ? 0 : bleGestureWake.hashCode())) * 31;
        BleGirlCareSettings bleGirlCareSettings = this.girlCare;
        int hashCode9 = (hashCode8 + (bleGirlCareSettings == null ? 0 : bleGirlCareSettings.hashCode())) * 31;
        List<BleSchedule> list2 = this.schedules;
        int hashCode10 = (hashCode9 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<BleCoaching> list3 = this.coachings;
        int hashCode11 = (hashCode10 + (list3 == null ? 0 : list3.hashCode())) * 31;
        BleDrinkWaterSettings bleDrinkWaterSettings = this.drinkWaterSettings;
        int hashCode12 = (hashCode11 + (bleDrinkWaterSettings == null ? 0 : bleDrinkWaterSettings.hashCode())) * 31;
        BleGameSettings bleGameSettings = this.gameSettings;
        return hashCode12 + (bleGameSettings != null ? bleGameSettings.hashCode() : 0);
    }

    public final void setAlarms(@oOoXoXO List<BleAlarm> list) {
        this.alarms = list;
    }

    public final void setBackLight(@oOoXoXO Integer num) {
        this.backLight = num;
    }

    public final void setCoachings(@oOoXoXO List<BleCoaching> list) {
        this.coachings = list;
    }

    public final void setDrinkWaterSettings(@oOoXoXO BleDrinkWaterSettings bleDrinkWaterSettings) {
        this.drinkWaterSettings = bleDrinkWaterSettings;
    }

    public final void setGestureWake(@oOoXoXO BleGestureWake bleGestureWake) {
        this.gestureWake = bleGestureWake;
    }

    public final void setGirlCare(@oOoXoXO BleGirlCareSettings bleGirlCareSettings) {
        this.girlCare = bleGirlCareSettings;
    }

    public final void setHrMonitoringSettings(@oOoXoXO BleHrMonitoringSettings bleHrMonitoringSettings) {
        this.hrMonitoringSettings = bleHrMonitoringSettings;
    }

    public final void setNoDisturbSettings(@oOoXoXO BleNoDisturbSettings bleNoDisturbSettings) {
        this.noDisturbSettings = bleNoDisturbSettings;
    }

    public final void setSchedules(@oOoXoXO List<BleSchedule> list) {
        this.schedules = list;
    }

    public final void setSedentarinessSettings(@oOoXoXO BleSedentarinessSettings bleSedentarinessSettings) {
        this.sedentarinessSettings = bleSedentarinessSettings;
    }

    public final void setStepGoal(@oOoXoXO Integer num) {
        this.stepGoal = num;
    }

    public final void setVibration(@oOoXoXO Integer num) {
        this.vibration = num;
    }

    @OOXIXo
    public String toString() {
        return "DeviceSettings(stepGoal=" + this.stepGoal + ", backLight=" + this.backLight + ", sedentarinessSettings=" + this.sedentarinessSettings + ", noDisturbSettings=" + this.noDisturbSettings + ", vibration=" + this.vibration + ", alarms=" + this.alarms + ", hrMonitoringSettings=" + this.hrMonitoringSettings + ", gestureWake=" + this.gestureWake + ", girlCare=" + this.girlCare + ", schedules=" + this.schedules + ", coachings=" + this.coachings + ", drinkWaterSettings=" + this.drinkWaterSettings + ", gameSettings=" + this.gameSettings + HexStringBuilder.COMMENT_END_CHAR;
    }
}
