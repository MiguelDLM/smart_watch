package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class DeviceConfigInfo extends JsonFieldContainer {
    private int alarmWithTag;

    @oOoXoXO
    private CustomConfigInfo customConfig;
    private int defHeartRateMonitoringSwitch;

    @OOXIXo
    private String deviceImage;

    @OOXIXo
    private String deviceImage2;

    @OOXIXo
    private String devicePlatform;

    @OOXIXo
    private String devicePrototype;
    private int firmwareId;
    private int id;

    @oOoXoXO
    private MacConfig macConfig;
    private int projectId;
    private int requireReadAlarm;
    private int requireReadNoDisturb;
    private int scheduleMax;
    private int supWarnTipGuide;
    private int supWf;

    @OOXIXo
    private String supportBackLightTimeArrays;
    private int supportGirlCare;
    private int supportMusic;
    private int supportNFC;
    private int supportPeriodicHeartRateMonitoring;
    private int supportSyncContact;

    public /* synthetic */ DeviceConfigInfo(int i, int i2, int i3, String str, String str2, String str3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, String str4, int i12, int i13, int i14, int i15, CustomConfigInfo customConfigInfo, String str5, MacConfig macConfig, int i16, IIXOooo iIXOooo) {
        this((i16 & 1) != 0 ? 0 : i, (i16 & 2) != 0 ? 0 : i2, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? "" : str, (i16 & 16) != 0 ? "" : str2, (i16 & 32) != 0 ? "" : str3, (i16 & 64) != 0 ? 0 : i4, (i16 & 128) != 0 ? 0 : i5, (i16 & 256) != 0 ? 0 : i6, (i16 & 512) != 0 ? 0 : i7, (i16 & 1024) != 0 ? 0 : i8, (i16 & 2048) != 0 ? 0 : i9, (i16 & 4096) != 0 ? 0 : i10, (i16 & 8192) != 0 ? 0 : i11, (i16 & 16384) != 0 ? "" : str4, (32768 & i16) != 0 ? 0 : i12, (65536 & i16) != 0 ? 0 : i13, (131072 & i16) != 0 ? 0 : i14, (262144 & i16) != 0 ? 0 : i15, customConfigInfo, (i16 & 1048576) != 0 ? "" : str5, macConfig);
    }

    public final int component1() {
        return this.id;
    }

    public final int component10() {
        return this.scheduleMax;
    }

    public final int component11() {
        return this.requireReadNoDisturb;
    }

    public final int component12() {
        return this.supportPeriodicHeartRateMonitoring;
    }

    public final int component13() {
        return this.defHeartRateMonitoringSwitch;
    }

    public final int component14() {
        return this.supportGirlCare;
    }

    @OOXIXo
    public final String component15() {
        return this.supportBackLightTimeArrays;
    }

    public final int component16() {
        return this.supportMusic;
    }

    public final int component17() {
        return this.supportNFC;
    }

    public final int component18() {
        return this.supWf;
    }

    public final int component19() {
        return this.supWarnTipGuide;
    }

    public final int component2() {
        return this.projectId;
    }

    @oOoXoXO
    public final CustomConfigInfo component20() {
        return this.customConfig;
    }

    @OOXIXo
    public final String component21() {
        return this.deviceImage2;
    }

    @oOoXoXO
    public final MacConfig component22() {
        return this.macConfig;
    }

    public final int component3() {
        return this.firmwareId;
    }

    @OOXIXo
    public final String component4() {
        return this.devicePrototype;
    }

    @OOXIXo
    public final String component5() {
        return this.devicePlatform;
    }

    @OOXIXo
    public final String component6() {
        return this.deviceImage;
    }

    public final int component7() {
        return this.supportSyncContact;
    }

    public final int component8() {
        return this.requireReadAlarm;
    }

    public final int component9() {
        return this.alarmWithTag;
    }

    @OOXIXo
    public final DeviceConfigInfo copy(int i, int i2, int i3, @OOXIXo String devicePrototype, @OOXIXo String devicePlatform, @OOXIXo String deviceImage, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, @OOXIXo String supportBackLightTimeArrays, int i12, int i13, int i14, int i15, @oOoXoXO CustomConfigInfo customConfigInfo, @OOXIXo String deviceImage2, @oOoXoXO MacConfig macConfig) {
        IIX0o.x0xO0oo(devicePrototype, "devicePrototype");
        IIX0o.x0xO0oo(devicePlatform, "devicePlatform");
        IIX0o.x0xO0oo(deviceImage, "deviceImage");
        IIX0o.x0xO0oo(supportBackLightTimeArrays, "supportBackLightTimeArrays");
        IIX0o.x0xO0oo(deviceImage2, "deviceImage2");
        return new DeviceConfigInfo(i, i2, i3, devicePrototype, devicePlatform, deviceImage, i4, i5, i6, i7, i8, i9, i10, i11, supportBackLightTimeArrays, i12, i13, i14, i15, customConfigInfo, deviceImage2, macConfig);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceConfigInfo)) {
            return false;
        }
        DeviceConfigInfo deviceConfigInfo = (DeviceConfigInfo) obj;
        return this.id == deviceConfigInfo.id && this.projectId == deviceConfigInfo.projectId && this.firmwareId == deviceConfigInfo.firmwareId && IIX0o.Oxx0IOOO(this.devicePrototype, deviceConfigInfo.devicePrototype) && IIX0o.Oxx0IOOO(this.devicePlatform, deviceConfigInfo.devicePlatform) && IIX0o.Oxx0IOOO(this.deviceImage, deviceConfigInfo.deviceImage) && this.supportSyncContact == deviceConfigInfo.supportSyncContact && this.requireReadAlarm == deviceConfigInfo.requireReadAlarm && this.alarmWithTag == deviceConfigInfo.alarmWithTag && this.scheduleMax == deviceConfigInfo.scheduleMax && this.requireReadNoDisturb == deviceConfigInfo.requireReadNoDisturb && this.supportPeriodicHeartRateMonitoring == deviceConfigInfo.supportPeriodicHeartRateMonitoring && this.defHeartRateMonitoringSwitch == deviceConfigInfo.defHeartRateMonitoringSwitch && this.supportGirlCare == deviceConfigInfo.supportGirlCare && IIX0o.Oxx0IOOO(this.supportBackLightTimeArrays, deviceConfigInfo.supportBackLightTimeArrays) && this.supportMusic == deviceConfigInfo.supportMusic && this.supportNFC == deviceConfigInfo.supportNFC && this.supWf == deviceConfigInfo.supWf && this.supWarnTipGuide == deviceConfigInfo.supWarnTipGuide && IIX0o.Oxx0IOOO(this.customConfig, deviceConfigInfo.customConfig) && IIX0o.Oxx0IOOO(this.deviceImage2, deviceConfigInfo.deviceImage2) && IIX0o.Oxx0IOOO(this.macConfig, deviceConfigInfo.macConfig);
    }

    public final int getAlarmWithTag() {
        return this.alarmWithTag;
    }

    @oOoXoXO
    public final CustomConfigInfo getCustomConfig() {
        return this.customConfig;
    }

    public final int getDefHeartRateMonitoringSwitch() {
        return this.defHeartRateMonitoringSwitch;
    }

    @OOXIXo
    public final String getDeviceImage() {
        return this.deviceImage;
    }

    @OOXIXo
    public final String getDeviceImage2() {
        return this.deviceImage2;
    }

    @OOXIXo
    public final String getDevicePlatform() {
        return this.devicePlatform;
    }

    @OOXIXo
    public final String getDevicePrototype() {
        return this.devicePrototype;
    }

    public final int getFirmwareId() {
        return this.firmwareId;
    }

    public final int getId() {
        return this.id;
    }

    @oOoXoXO
    public final MacConfig getMacConfig() {
        return this.macConfig;
    }

    public final int getProjectId() {
        return this.projectId;
    }

    public final int getRequireReadAlarm() {
        return this.requireReadAlarm;
    }

    public final int getRequireReadNoDisturb() {
        return this.requireReadNoDisturb;
    }

    public final int getScheduleMax() {
        return this.scheduleMax;
    }

    public final int getSupWarnTipGuide() {
        return this.supWarnTipGuide;
    }

    public final int getSupWf() {
        return this.supWf;
    }

    @OOXIXo
    public final String getSupportBackLightTimeArrays() {
        return this.supportBackLightTimeArrays;
    }

    public final int getSupportGirlCare() {
        return this.supportGirlCare;
    }

    public final int getSupportMusic() {
        return this.supportMusic;
    }

    public final int getSupportNFC() {
        return this.supportNFC;
    }

    public final int getSupportPeriodicHeartRateMonitoring() {
        return this.supportPeriodicHeartRateMonitoring;
    }

    public final int getSupportSyncContact() {
        return this.supportSyncContact;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((((this.id * 31) + this.projectId) * 31) + this.firmwareId) * 31) + this.devicePrototype.hashCode()) * 31) + this.devicePlatform.hashCode()) * 31) + this.deviceImage.hashCode()) * 31) + this.supportSyncContact) * 31) + this.requireReadAlarm) * 31) + this.alarmWithTag) * 31) + this.scheduleMax) * 31) + this.requireReadNoDisturb) * 31) + this.supportPeriodicHeartRateMonitoring) * 31) + this.defHeartRateMonitoringSwitch) * 31) + this.supportGirlCare) * 31) + this.supportBackLightTimeArrays.hashCode()) * 31) + this.supportMusic) * 31) + this.supportNFC) * 31) + this.supWf) * 31) + this.supWarnTipGuide) * 31;
        CustomConfigInfo customConfigInfo = this.customConfig;
        int hashCode2 = (((hashCode + (customConfigInfo == null ? 0 : customConfigInfo.hashCode())) * 31) + this.deviceImage2.hashCode()) * 31;
        MacConfig macConfig = this.macConfig;
        return hashCode2 + (macConfig != null ? macConfig.hashCode() : 0);
    }

    public final void setAlarmWithTag(int i) {
        this.alarmWithTag = i;
    }

    public final void setCustomConfig(@oOoXoXO CustomConfigInfo customConfigInfo) {
        this.customConfig = customConfigInfo;
    }

    public final void setDefHeartRateMonitoringSwitch(int i) {
        this.defHeartRateMonitoringSwitch = i;
    }

    public final void setDeviceImage(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.deviceImage = str;
    }

    public final void setDeviceImage2(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.deviceImage2 = str;
    }

    public final void setDevicePlatform(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.devicePlatform = str;
    }

    public final void setDevicePrototype(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.devicePrototype = str;
    }

    public final void setFirmwareId(int i) {
        this.firmwareId = i;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setMacConfig(@oOoXoXO MacConfig macConfig) {
        this.macConfig = macConfig;
    }

    public final void setProjectId(int i) {
        this.projectId = i;
    }

    public final void setRequireReadAlarm(int i) {
        this.requireReadAlarm = i;
    }

    public final void setRequireReadNoDisturb(int i) {
        this.requireReadNoDisturb = i;
    }

    public final void setScheduleMax(int i) {
        this.scheduleMax = i;
    }

    public final void setSupWarnTipGuide(int i) {
        this.supWarnTipGuide = i;
    }

    public final void setSupWf(int i) {
        this.supWf = i;
    }

    public final void setSupportBackLightTimeArrays(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.supportBackLightTimeArrays = str;
    }

    public final void setSupportGirlCare(int i) {
        this.supportGirlCare = i;
    }

    public final void setSupportMusic(int i) {
        this.supportMusic = i;
    }

    public final void setSupportNFC(int i) {
        this.supportNFC = i;
    }

    public final void setSupportPeriodicHeartRateMonitoring(int i) {
        this.supportPeriodicHeartRateMonitoring = i;
    }

    public final void setSupportSyncContact(int i) {
        this.supportSyncContact = i;
    }

    @OOXIXo
    public String toString() {
        return "DeviceConfigInfo(id=" + this.id + ", projectId=" + this.projectId + ", firmwareId=" + this.firmwareId + ", devicePrototype=" + this.devicePrototype + ", devicePlatform=" + this.devicePlatform + ", deviceImage=" + this.deviceImage + ", supportSyncContact=" + this.supportSyncContact + ", requireReadAlarm=" + this.requireReadAlarm + ", alarmWithTag=" + this.alarmWithTag + ", scheduleMax=" + this.scheduleMax + ", requireReadNoDisturb=" + this.requireReadNoDisturb + ", supportPeriodicHeartRateMonitoring=" + this.supportPeriodicHeartRateMonitoring + ", defHeartRateMonitoringSwitch=" + this.defHeartRateMonitoringSwitch + ", supportGirlCare=" + this.supportGirlCare + ", supportBackLightTimeArrays=" + this.supportBackLightTimeArrays + ", supportMusic=" + this.supportMusic + ", supportNFC=" + this.supportNFC + ", supWf=" + this.supWf + ", supWarnTipGuide=" + this.supWarnTipGuide + ", customConfig=" + this.customConfig + ", deviceImage2=" + this.deviceImage2 + ", macConfig=" + this.macConfig + HexStringBuilder.COMMENT_END_CHAR;
    }

    public DeviceConfigInfo(int i, int i2, int i3, @OOXIXo String devicePrototype, @OOXIXo String devicePlatform, @OOXIXo String deviceImage, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, @OOXIXo String supportBackLightTimeArrays, int i12, int i13, int i14, int i15, @oOoXoXO CustomConfigInfo customConfigInfo, @OOXIXo String deviceImage2, @oOoXoXO MacConfig macConfig) {
        IIX0o.x0xO0oo(devicePrototype, "devicePrototype");
        IIX0o.x0xO0oo(devicePlatform, "devicePlatform");
        IIX0o.x0xO0oo(deviceImage, "deviceImage");
        IIX0o.x0xO0oo(supportBackLightTimeArrays, "supportBackLightTimeArrays");
        IIX0o.x0xO0oo(deviceImage2, "deviceImage2");
        this.id = i;
        this.projectId = i2;
        this.firmwareId = i3;
        this.devicePrototype = devicePrototype;
        this.devicePlatform = devicePlatform;
        this.deviceImage = deviceImage;
        this.supportSyncContact = i4;
        this.requireReadAlarm = i5;
        this.alarmWithTag = i6;
        this.scheduleMax = i7;
        this.requireReadNoDisturb = i8;
        this.supportPeriodicHeartRateMonitoring = i9;
        this.defHeartRateMonitoringSwitch = i10;
        this.supportGirlCare = i11;
        this.supportBackLightTimeArrays = supportBackLightTimeArrays;
        this.supportMusic = i12;
        this.supportNFC = i13;
        this.supWf = i14;
        this.supWarnTipGuide = i15;
        this.customConfig = customConfigInfo;
        this.deviceImage2 = deviceImage2;
        this.macConfig = macConfig;
    }
}
