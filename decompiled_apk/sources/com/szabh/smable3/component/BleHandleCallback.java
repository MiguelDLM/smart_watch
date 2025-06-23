package com.szabh.smable3.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.bluetooth.BluetoothDevice;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.entity.BleAICoachBeforePlan;
import com.szabh.smable3.entity.BleAICoachGeneratePlan;
import com.szabh.smable3.entity.BleActivity;
import com.szabh.smable3.entity.BleActivityDetail;
import com.szabh.smable3.entity.BleAlarm;
import com.szabh.smable3.entity.BleAlipayBindInfo;
import com.szabh.smable3.entity.BleAlipaySettings;
import com.szabh.smable3.entity.BleAppAudioBookList;
import com.szabh.smable3.entity.BleAppInfoList;
import com.szabh.smable3.entity.BleAppOp;
import com.szabh.smable3.entity.BleAppSportState;
import com.szabh.smable3.entity.BleAvgHeartRate;
import com.szabh.smable3.entity.BleBAC;
import com.szabh.smable3.entity.BleBWNaviInfo;
import com.szabh.smable3.entity.BleBacCalibration;
import com.szabh.smable3.entity.BleBatteryUsage;
import com.szabh.smable3.entity.BleBloodGlucose;
import com.szabh.smable3.entity.BleBloodOxyGenSettings;
import com.szabh.smable3.entity.BleBloodOxygen;
import com.szabh.smable3.entity.BleBloodPressure;
import com.szabh.smable3.entity.BleBloodPressureCalibration;
import com.szabh.smable3.entity.BleBodyStatus;
import com.szabh.smable3.entity.BleCPUserInfo;
import com.szabh.smable3.entity.BleCalibrationData;
import com.szabh.smable3.entity.BleCalorieIntake;
import com.szabh.smable3.entity.BleCheckInEveryDay;
import com.szabh.smable3.entity.BleCoachingIds;
import com.szabh.smable3.entity.BleDeviceFile;
import com.szabh.smable3.entity.BleDeviceInfo;
import com.szabh.smable3.entity.BleDeviceInfo2;
import com.szabh.smable3.entity.BleDeviceLanguages;
import com.szabh.smable3.entity.BleDeviceSportData;
import com.szabh.smable3.entity.BleDeviceUniqueDataSettings;
import com.szabh.smable3.entity.BleDoubleScreenSettings;
import com.szabh.smable3.entity.BleDrinkWaterSettings;
import com.szabh.smable3.entity.BleEarphoneAncSettings;
import com.szabh.smable3.entity.BleEarphoneInfo;
import com.szabh.smable3.entity.BleEarphoneKey;
import com.szabh.smable3.entity.BleEarphonePower;
import com.szabh.smable3.entity.BleEarphoneSoundEffectsSettings;
import com.szabh.smable3.entity.BleEarphoneState;
import com.szabh.smable3.entity.BleEcg;
import com.szabh.smable3.entity.BleEcgSettings;
import com.szabh.smable3.entity.BleFactoryTest;
import com.szabh.smable3.entity.BleFindEarphone;
import com.szabh.smable3.entity.BleFoodBalance;
import com.szabh.smable3.entity.BleGSensorMotion;
import com.szabh.smable3.entity.BleGSensorRaw;
import com.szabh.smable3.entity.BleGSensorSHSY;
import com.szabh.smable3.entity.BleGameControl;
import com.szabh.smable3.entity.BleGestureWake;
import com.szabh.smable3.entity.BleGestureWake2;
import com.szabh.smable3.entity.BleGirlCareMonthly;
import com.szabh.smable3.entity.BleGirlCareSettings;
import com.szabh.smable3.entity.BleGoMoreSettings;
import com.szabh.smable3.entity.BleHRRaw;
import com.szabh.smable3.entity.BleHanBaoSettings;
import com.szabh.smable3.entity.BleHanBaoVibration;
import com.szabh.smable3.entity.BleHeartRate;
import com.szabh.smable3.entity.BleHrMonitoringSettings;
import com.szabh.smable3.entity.BleHrv;
import com.szabh.smable3.entity.BleHrv2;
import com.szabh.smable3.entity.BleIPCStoresInfo;
import com.szabh.smable3.entity.BleIPCWifiInfo;
import com.szabh.smable3.entity.BleLactateThreshold;
import com.szabh.smable3.entity.BleLanguagePackVersion;
import com.szabh.smable3.entity.BleLocation;
import com.szabh.smable3.entity.BleLocationGga;
import com.szabh.smable3.entity.BleLocationGsv;
import com.szabh.smable3.entity.BleLogText;
import com.szabh.smable3.entity.BleLoveTap;
import com.szabh.smable3.entity.BleLoveTapUser;
import com.szabh.smable3.entity.BleMatchRecord;
import com.szabh.smable3.entity.BleMatchRecord2;
import com.szabh.smable3.entity.BleMeasurement;
import com.szabh.smable3.entity.BleMedicationAlarm;
import com.szabh.smable3.entity.BleMedicationReminder;
import com.szabh.smable3.entity.BleMindStatus;
import com.szabh.smable3.entity.BleNaviInfo;
import com.szabh.smable3.entity.BleNoDisturbSettings;
import com.szabh.smable3.entity.BleNotificationSettings2;
import com.szabh.smable3.entity.BlePackageStatus;
import com.szabh.smable3.entity.BlePhysicalPower;
import com.szabh.smable3.entity.BlePower2;
import com.szabh.smable3.entity.BlePpgSHSY;
import com.szabh.smable3.entity.BlePressure;
import com.szabh.smable3.entity.BlePressureTimingMeasurement;
import com.szabh.smable3.entity.BleQiblaSettings;
import com.szabh.smable3.entity.BleRealTimeMeasurement;
import com.szabh.smable3.entity.BleRealtimeLog;
import com.szabh.smable3.entity.BleReceiveFilePacket;
import com.szabh.smable3.entity.BleRecordPacket;
import com.szabh.smable3.entity.BleRelaxReminder;
import com.szabh.smable3.entity.BleRespiratoryRate;
import com.szabh.smable3.entity.BleRingVibrationSettings;
import com.szabh.smable3.entity.BleRri;
import com.szabh.smable3.entity.BleSDCardInfo;
import com.szabh.smable3.entity.BleSGTest;
import com.szabh.smable3.entity.BleSMSQuickReply;
import com.szabh.smable3.entity.BleSOSSettings;
import com.szabh.smable3.entity.BleSedentarinessSettings;
import com.szabh.smable3.entity.BleSettingWatchPassword;
import com.szabh.smable3.entity.BleSleep;
import com.szabh.smable3.entity.BleSleepQuality;
import com.szabh.smable3.entity.BleSosCallLog;
import com.szabh.smable3.entity.BleSosContact;
import com.szabh.smable3.entity.BleStandbyWatchFaceSet;
import com.szabh.smable3.entity.BleStock;
import com.szabh.smable3.entity.BleTemperature;
import com.szabh.smable3.entity.BleThirdPartyData;
import com.szabh.smable3.entity.BleTrainingStatus;
import com.szabh.smable3.entity.BleTuyaKey;
import com.szabh.smable3.entity.BleUserProfile;
import com.szabh.smable3.entity.BleVitality;
import com.szabh.smable3.entity.BleWatchFaceId;
import com.szabh.smable3.entity.BleWatchFaceIndex;
import com.szabh.smable3.entity.BleWorkout;
import com.szabh.smable3.entity.BleWorkout2;
import com.szabh.smable3.entity.BleWorkout3;
import com.szabh.smable3.entity.BleWorldClock;
import com.szabh.smable3.entity.MusicCommand;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes13.dex */
public interface BleHandleCallback {

    /* loaded from: classes13.dex */
    public static final class DefaultImpls {
        public static void onAICoachGeneratePlanUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onAlarmAdd(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleAlarm alarm) {
            IIX0o.x0xO0oo(alarm, "alarm");
        }

        public static void onAlarmDelete(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onAlarmUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleAlarm alarm) {
            IIX0o.x0xO0oo(alarm, "alarm");
        }

        public static void onAppOpUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleAppOp appOp) {
            IIX0o.x0xO0oo(appOp, "appOp");
        }

        public static void onAppSportDataResponse(@OOXIXo BleHandleCallback bleHandleCallback, boolean z) {
        }

        public static void onBWNaviInfoUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleBWNaviInfo naviInfo) {
            IIX0o.x0xO0oo(naviInfo, "naviInfo");
        }

        public static void onBacklightUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onBleThirdPartyDataUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleThirdPartyData thirdPartyData) {
            IIX0o.x0xO0oo(thirdPartyData, "thirdPartyData");
        }

        public static void onCaloriesGoalUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onCameraResponse(@OOXIXo BleHandleCallback bleHandleCallback, boolean z, int i) {
        }

        public static void onCameraStateChange(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onCheckInEveryDayUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleCheckInEveryDay everyDay) {
            IIX0o.x0xO0oo(everyDay, "everyDay");
        }

        public static void onClassicBluetoothStateChange(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onCommandReply(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag, boolean z) {
            IIX0o.x0xO0oo(bleKey, "bleKey");
            IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
        }

        public static void onCommandSendTimeout(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag) {
            IIX0o.x0xO0oo(bleKey, "bleKey");
            IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
        }

        public static void onDeviceConnected(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BluetoothDevice device) {
            IIX0o.x0xO0oo(device, "device");
        }

        public static void onDeviceConnecting(@OOXIXo BleHandleCallback bleHandleCallback, boolean z) {
        }

        public static void onDeviceFileUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleDeviceFile deviceFile) {
            IIX0o.x0xO0oo(deviceFile, "deviceFile");
        }

        public static void onDeviceRequestAGpsFile(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo String url) {
            IIX0o.x0xO0oo(url, "url");
        }

        public static void onDeviceSMSQuickReply(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleSMSQuickReply smsQuickReply) {
            IIX0o.x0xO0oo(smsQuickReply, "smsQuickReply");
        }

        public static void onDeviceSportDataUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleDeviceSportData deviceSportData) {
            IIX0o.x0xO0oo(deviceSportData, "deviceSportData");
        }

        public static void onDistanceGoalUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onDoubleScreenSettingsUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleDoubleScreenSettings doubleScreenSettings) {
            IIX0o.x0xO0oo(doubleScreenSettings, "doubleScreenSettings");
        }

        public static void onEarphoneAncSettingsUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleEarphoneAncSettings earphoneAncSettings) {
            IIX0o.x0xO0oo(earphoneAncSettings, "earphoneAncSettings");
        }

        public static void onEarphoneCallUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onEarphoneKeyUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleEarphoneKey earphoneKey) {
            IIX0o.x0xO0oo(earphoneKey, "earphoneKey");
        }

        public static void onEarphoneSoundEffectsSettingsUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleEarphoneSoundEffectsSettings earphoneSoundEffectsSettings) {
            IIX0o.x0xO0oo(earphoneSoundEffectsSettings, "earphoneSoundEffectsSettings");
        }

        public static void onEarphoneStateUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleEarphoneState earphoneState) {
            IIX0o.x0xO0oo(earphoneState, "earphoneState");
        }

        public static void onFactoryTestUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleFactoryTest factoryTest) {
            IIX0o.x0xO0oo(factoryTest, "factoryTest");
        }

        public static void onFallSetUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onFindEarphoneUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleFindEarphone findEarphone) {
            IIX0o.x0xO0oo(findEarphone, "findEarphone");
        }

        public static void onFindPhone(@OOXIXo BleHandleCallback bleHandleCallback, boolean z) {
        }

        public static void onFindWatchUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onFollowSystemLanguage(@OOXIXo BleHandleCallback bleHandleCallback, boolean z) {
        }

        public static void onGameControlUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleGameControl gameControl) {
            IIX0o.x0xO0oo(gameControl, "gameControl");
        }

        public static void onGestureWake2Update(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleGestureWake2 gestureWake2) {
            IIX0o.x0xO0oo(gestureWake2, "gestureWake2");
        }

        public static void onGestureWakeUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleGestureWake gestureWake) {
            IIX0o.x0xO0oo(gestureWake, "gestureWake");
        }

        public static void onHIDState(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onHIDValueChange(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onHanBaoVibrationStateChange(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onHourSystemUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onIPCStoresInfoUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleIPCStoresInfo info) {
            IIX0o.x0xO0oo(info, "info");
        }

        public static void onIPCWifiInfoUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleIPCWifiInfo info) {
            IIX0o.x0xO0oo(info, "info");
        }

        public static void onIPCWifiStateUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onIdentityCreate(@OOXIXo BleHandleCallback bleHandleCallback, boolean z, @oOoXoXO BleDeviceInfo bleDeviceInfo) {
        }

        public static /* synthetic */ void onIdentityCreate$default(BleHandleCallback bleHandleCallback, boolean z, BleDeviceInfo bleDeviceInfo, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    bleDeviceInfo = null;
                }
                bleHandleCallback.onIdentityCreate(z, bleDeviceInfo);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onIdentityCreate");
        }

        public static void onIdentityDelete(@OOXIXo BleHandleCallback bleHandleCallback, boolean z) {
        }

        public static void onIdentityDeleteByDevice(@OOXIXo BleHandleCallback bleHandleCallback, boolean z) {
        }

        public static void onIncomingCallRingUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onIncomingCallStatus(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onLoveTapUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleLoveTap loveTap) {
            IIX0o.x0xO0oo(loveTap, "loveTap");
        }

        public static void onLoveTapUserDelete(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onLoveTapUserUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleLoveTapUser loveTapUser) {
            IIX0o.x0xO0oo(loveTapUser, "loveTapUser");
        }

        public static void onMeasurementUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleMeasurement measurement) {
            IIX0o.x0xO0oo(measurement, "measurement");
        }

        public static void onMedicationAlarmAdd(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleMedicationAlarm medicationAlarm) {
            IIX0o.x0xO0oo(medicationAlarm, "medicationAlarm");
        }

        public static void onMedicationAlarmDelete(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onMedicationAlarmUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleMedicationAlarm medicationAlarm) {
            IIX0o.x0xO0oo(medicationAlarm, "medicationAlarm");
        }

        public static void onMedicationReminderDelete(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onMedicationReminderUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleMedicationReminder medicationReminder) {
            IIX0o.x0xO0oo(medicationReminder, "medicationReminder");
        }

        public static void onNaviInfoUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleNaviInfo naviInfo) {
            IIX0o.x0xO0oo(naviInfo, "naviInfo");
        }

        public static void onNoDisturbUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleNoDisturbSettings noDisturbSettings) {
            IIX0o.x0xO0oo(noDisturbSettings, "noDisturbSettings");
        }

        public static void onNotificationLightScreenSetUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onNotificationSettings2Update(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleNotificationSettings2 notificationSettings2) {
            IIX0o.x0xO0oo(notificationSettings2, "notificationSettings2");
        }

        public static void onOTA(@OOXIXo BleHandleCallback bleHandleCallback, boolean z) {
        }

        public static void onPowerSaveModeState(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onPowerSaveModeStateChange(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onQiblaSettingsUpdate(@OOXIXo BleHandleCallback bleHandleCallback) {
        }

        public static void onReadAICoachGenerateBeforeInfo(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleAICoachBeforePlan info) {
            IIX0o.x0xO0oo(info, "info");
        }

        public static void onReadAICoachPlan(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleAICoachGeneratePlan plan) {
            IIX0o.x0xO0oo(plan, "plan");
        }

        public static void onReadActivity(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleActivity> activities) {
            IIX0o.x0xO0oo(activities, "activities");
        }

        public static void onReadActivityDetail(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleActivityDetail activityDetail) {
            IIX0o.x0xO0oo(activityDetail, "activityDetail");
        }

        public static void onReadAlarm(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleAlarm> alarms) {
            IIX0o.x0xO0oo(alarms, "alarms");
        }

        public static void onReadAlipayBindInfo(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleAlipayBindInfo> alipayBindInfos) {
            IIX0o.x0xO0oo(alipayBindInfos, "alipayBindInfos");
        }

        public static void onReadAlipaySettings(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleAlipaySettings alipaySettings) {
            IIX0o.x0xO0oo(alipaySettings, "alipaySettings");
        }

        public static void onReadAppApiVersion(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo String version) {
            IIX0o.x0xO0oo(version, "version");
        }

        public static void onReadAppInfoList(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleAppInfoList appInfoList) {
            IIX0o.x0xO0oo(appInfoList, "appInfoList");
        }

        public static void onReadAvgHeartRate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleAvgHeartRate> heartRates) {
            IIX0o.x0xO0oo(heartRates, "heartRates");
        }

        public static void onReadBAC(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleBAC> bacs) {
            IIX0o.x0xO0oo(bacs, "bacs");
        }

        public static void onReadBacCalibration(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleBacCalibration bac, @OOXIXo BleKeyFlag bleKeyFlag) {
            IIX0o.x0xO0oo(bac, "bac");
            IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
        }

        public static void onReadBacklight(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadBatteryUsage(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleBatteryUsage batteryUsage) {
            IIX0o.x0xO0oo(batteryUsage, "batteryUsage");
        }

        public static void onReadBleAddress(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo String address) {
            IIX0o.x0xO0oo(address, "address");
        }

        public static void onReadBleHrv(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleHrv> hrv) {
            IIX0o.x0xO0oo(hrv, "hrv");
        }

        public static void onReadBleHrv2(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleHrv2> hrv) {
            IIX0o.x0xO0oo(hrv, "hrv");
        }

        public static void onReadBleLogText(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleLogText> logs) {
            IIX0o.x0xO0oo(logs, "logs");
        }

        public static void onReadBloodGlucose(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleBloodGlucose> bloodGlucoses) {
            IIX0o.x0xO0oo(bloodGlucoses, "bloodGlucoses");
        }

        public static void onReadBloodOxyGenSettings(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleBloodOxyGenSettings bloodOxyGenSettings) {
            IIX0o.x0xO0oo(bloodOxyGenSettings, "bloodOxyGenSettings");
        }

        public static void onReadBloodOxygen(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleBloodOxygen> bloodOxygen) {
            IIX0o.x0xO0oo(bloodOxygen, "bloodOxygen");
        }

        public static void onReadBloodPressure(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleBloodPressure> bloodPressures) {
            IIX0o.x0xO0oo(bloodPressures, "bloodPressures");
        }

        public static void onReadBloodPressureCalibration(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleBloodPressureCalibration bloodPressureCalibration) {
            IIX0o.x0xO0oo(bloodPressureCalibration, "bloodPressureCalibration");
        }

        public static void onReadBodyStatus(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleBodyStatus> bodyData) {
            IIX0o.x0xO0oo(bodyData, "bodyData");
        }

        public static void onReadCPUserInfo(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleCPUserInfo info) {
            IIX0o.x0xO0oo(info, "info");
        }

        public static void onReadCalibrationData(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleCalibrationData calibrationData) {
            IIX0o.x0xO0oo(calibrationData, "calibrationData");
        }

        public static void onReadCalorieIntake(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleCalorieIntake> calorieIntakes) {
            IIX0o.x0xO0oo(calorieIntakes, "calorieIntakes");
        }

        public static void onReadCaloriesGoal(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadCheckInEveryDay(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleCheckInEveryDay everyDay) {
            IIX0o.x0xO0oo(everyDay, "everyDay");
        }

        public static void onReadClassicBluetoothState(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadCoachingIds(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleCoachingIds bleCoachingIds) {
            IIX0o.x0xO0oo(bleCoachingIds, "bleCoachingIds");
        }

        public static void onReadDailyPower(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BlePhysicalPower> powers) {
            IIX0o.x0xO0oo(powers, "powers");
        }

        public static void onReadDateFormat(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadDeviceFile(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleDeviceFile deviceFile) {
            IIX0o.x0xO0oo(deviceFile, "deviceFile");
        }

        public static void onReadDeviceInfo(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleDeviceInfo deviceInfo) {
            IIX0o.x0xO0oo(deviceInfo, "deviceInfo");
        }

        public static void onReadDeviceInfo2(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleDeviceInfo2 deviceInfo) {
            IIX0o.x0xO0oo(deviceInfo, "deviceInfo");
        }

        public static void onReadDeviceLanguages(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleDeviceLanguages deviceLanguages) {
            IIX0o.x0xO0oo(deviceLanguages, "deviceLanguages");
        }

        public static void onReadDeviceUniqueDataSettings(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleDeviceUniqueDataSettings deviceUniqueDataSettings) {
            IIX0o.x0xO0oo(deviceUniqueDataSettings, "deviceUniqueDataSettings");
        }

        public static void onReadDistanceGoal(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadDoubleScreenSettings(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleDoubleScreenSettings doubleScreenSettings) {
            IIX0o.x0xO0oo(doubleScreenSettings, "doubleScreenSettings");
        }

        public static void onReadDrinkWater(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleDrinkWaterSettings drinkWaterSettings) {
            IIX0o.x0xO0oo(drinkWaterSettings, "drinkWaterSettings");
        }

        public static void onReadEarphoneAncSettings(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleEarphoneAncSettings earphoneAncSettings) {
            IIX0o.x0xO0oo(earphoneAncSettings, "earphoneAncSettings");
        }

        public static void onReadEarphoneCall(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadEarphoneInfo(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleEarphoneInfo earphoneInfo) {
            IIX0o.x0xO0oo(earphoneInfo, "earphoneInfo");
        }

        public static void onReadEarphoneKey(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleEarphoneKey earphoneKey) {
            IIX0o.x0xO0oo(earphoneKey, "earphoneKey");
        }

        public static void onReadEarphonePower(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleEarphonePower earphonePower) {
            IIX0o.x0xO0oo(earphonePower, "earphonePower");
        }

        public static void onReadEarphoneSoundEffectsSettings(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleEarphoneSoundEffectsSettings earphoneSoundEffectsSettings) {
            IIX0o.x0xO0oo(earphoneSoundEffectsSettings, "earphoneSoundEffectsSettings");
        }

        public static void onReadEarphoneState(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleEarphoneState earphoneState) {
            IIX0o.x0xO0oo(earphoneState, "earphoneState");
        }

        public static void onReadEcg(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleEcg> ecgs) {
            IIX0o.x0xO0oo(ecgs, "ecgs");
        }

        public static void onReadEcgSettings(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleEcgSettings ecgSettings) {
            IIX0o.x0xO0oo(ecgSettings, "ecgSettings");
        }

        public static void onReadFallSet(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadFilePath(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleAppAudioBookList filePath) {
            IIX0o.x0xO0oo(filePath, "filePath");
        }

        public static void onReadFirmwareVersion(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo String version) {
            IIX0o.x0xO0oo(version, "version");
        }

        public static void onReadFoodBalance(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleFoodBalance> foodBalances) {
            IIX0o.x0xO0oo(foodBalances, "foodBalances");
        }

        public static void onReadGestureWake(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleGestureWake gestureWake) {
            IIX0o.x0xO0oo(gestureWake, "gestureWake");
        }

        public static void onReadGestureWake2(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleGestureWake2 gestureWake2) {
            IIX0o.x0xO0oo(gestureWake2, "gestureWake2");
        }

        public static void onReadGirlCareMonthly(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleGirlCareMonthly girlCareMonthly) {
            IIX0o.x0xO0oo(girlCareMonthly, "girlCareMonthly");
        }

        public static void onReadGirlCareSettings(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleGirlCareSettings girlCareSettings) {
            IIX0o.x0xO0oo(girlCareSettings, "girlCareSettings");
        }

        public static void onReadGoMoreSettings(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleGoMoreSettings goMoreSettings) {
            IIX0o.x0xO0oo(goMoreSettings, "goMoreSettings");
        }

        public static void onReadGpsFirmwareVersion(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo String version) {
            IIX0o.x0xO0oo(version, "version");
        }

        public static void onReadHanBaoSettings(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleHanBaoSettings hanBaoSettings) {
            IIX0o.x0xO0oo(hanBaoSettings, "hanBaoSettings");
        }

        public static void onReadHanBaoVibration(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleHanBaoVibration> hanBaoVibrations) {
            IIX0o.x0xO0oo(hanBaoVibrations, "hanBaoVibrations");
        }

        public static void onReadHeartRate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleHeartRate> heartRates) {
            IIX0o.x0xO0oo(heartRates, "heartRates");
        }

        public static void onReadHourSystem(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadHrMonitoringSettings(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleHrMonitoringSettings hrMonitoringSettings) {
            IIX0o.x0xO0oo(hrMonitoringSettings, "hrMonitoringSettings");
        }

        public static void onReadIPCStoresInfo(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleIPCStoresInfo info) {
            IIX0o.x0xO0oo(info, "info");
        }

        public static void onReadIPCVersion(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo String version) {
            IIX0o.x0xO0oo(version, "version");
        }

        public static void onReadIPCWifiState(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadIncomingCallRing(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadLactateThreshold(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleLactateThreshold> lactateThreshold) {
            IIX0o.x0xO0oo(lactateThreshold, "lactateThreshold");
        }

        public static void onReadLanguage(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadLanguagePackVersion(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleLanguagePackVersion version) {
            IIX0o.x0xO0oo(version, "version");
        }

        public static void onReadLocation(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleLocation> locations) {
            IIX0o.x0xO0oo(locations, "locations");
        }

        public static void onReadLoveTapUser(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleLoveTapUser> loveTapUsers) {
            IIX0o.x0xO0oo(loveTapUsers, "loveTapUsers");
        }

        public static void onReadMatchRecord(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleMatchRecord> matchRecords) {
            IIX0o.x0xO0oo(matchRecords, "matchRecords");
        }

        public static void onReadMatchRecord2(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleMatchRecord2> matchRecords) {
            IIX0o.x0xO0oo(matchRecords, "matchRecords");
        }

        public static void onReadMedicationAlarm(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleMedicationAlarm> medicationAlarm) {
            IIX0o.x0xO0oo(medicationAlarm, "medicationAlarm");
        }

        public static void onReadMedicationReminder(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleMedicationReminder> medicationReminders) {
            IIX0o.x0xO0oo(medicationReminders, "medicationReminders");
        }

        public static void onReadMindStatus(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleMindStatus> feelingData) {
            IIX0o.x0xO0oo(feelingData, "feelingData");
        }

        public static void onReadMtkOtaMeta(@OOXIXo BleHandleCallback bleHandleCallback) {
        }

        public static void onReadNetworkFirmwareVersion(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo String version) {
            IIX0o.x0xO0oo(version, "version");
        }

        public static void onReadNoDisturb(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleNoDisturbSettings noDisturbSettings) {
            IIX0o.x0xO0oo(noDisturbSettings, "noDisturbSettings");
        }

        public static void onReadNotificationLightScreenSet(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadNotificationSettings2(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleNotificationSettings2 notificationSettings2) {
            IIX0o.x0xO0oo(notificationSettings2, "notificationSettings2");
        }

        public static void onReadPackageStatus(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BlePackageStatus packageStatus) {
            IIX0o.x0xO0oo(packageStatus, "packageStatus");
        }

        public static void onReadPower(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadPower2(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BlePower2 power) {
            IIX0o.x0xO0oo(power, "power");
        }

        public static void onReadPressure(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BlePressure> pressures) {
            IIX0o.x0xO0oo(pressures, "pressures");
        }

        public static void onReadPressureTimingMeasurement(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BlePressureTimingMeasurement pressureTimingMeasurement) {
            IIX0o.x0xO0oo(pressureTimingMeasurement, "pressureTimingMeasurement");
        }

        public static void onReadQiblaSettings(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleQiblaSettings qiblaSettings) {
            IIX0o.x0xO0oo(qiblaSettings, "qiblaSettings");
        }

        public static void onReadRelaxReminder(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleRelaxReminder reminder) {
            IIX0o.x0xO0oo(reminder, "reminder");
        }

        public static void onReadRespiratoryRate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleRespiratoryRate> rate) {
            IIX0o.x0xO0oo(rate, "rate");
        }

        public static void onReadRingVibrationSet(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleRingVibrationSettings ringVibrationSettings) {
            IIX0o.x0xO0oo(ringVibrationSettings, "ringVibrationSettings");
        }

        public static void onReadRri(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleRri> rris) {
            IIX0o.x0xO0oo(rris, "rris");
        }

        public static void onReadSDCardInfo(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleSDCardInfo sdCardInfo) {
            IIX0o.x0xO0oo(sdCardInfo, "sdCardInfo");
        }

        public static void onReadSGKeywordAwake(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadSGSleepSet(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadSOSSettings(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleSOSSettings sosSettings) {
            IIX0o.x0xO0oo(sosSettings, "sosSettings");
        }

        public static void onReadScreenBrightnessSet(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadSedentariness(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleSedentarinessSettings sedentarinessSettings) {
            IIX0o.x0xO0oo(sedentarinessSettings, "sedentarinessSettings");
        }

        public static void onReadSleep(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleSleep> sleeps) {
            IIX0o.x0xO0oo(sleeps, "sleeps");
        }

        public static void onReadSleepGoal(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadSleepQuality(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleSleepQuality sleepQuality) {
            IIX0o.x0xO0oo(sleepQuality, "sleepQuality");
        }

        public static void onReadSleepQualityScore(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadSleepRaw(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo byte[] sleepRawData) {
            IIX0o.x0xO0oo(sleepRawData, "sleepRawData");
        }

        public static void onReadSosCallLog(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleSosCallLog> callLogs) {
            IIX0o.x0xO0oo(callLogs, "callLogs");
        }

        public static void onReadSosContact(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleSosContact sosContact) {
            IIX0o.x0xO0oo(sosContact, "sosContact");
        }

        public static void onReadSportDurationGoal(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadStandbyWatchFaceSet(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleStandbyWatchFaceSet standbyWatchFaceSet) {
            IIX0o.x0xO0oo(standbyWatchFaceSet, "standbyWatchFaceSet");
        }

        public static void onReadStepGoal(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadStock(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleStock> stocks) {
            IIX0o.x0xO0oo(stocks, "stocks");
        }

        public static void onReadTemperature(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleTemperature> temperatures) {
            IIX0o.x0xO0oo(temperatures, "temperatures");
        }

        public static void onReadTemperatureUnit(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadTrainingStatus(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleTrainingStatus> status) {
            IIX0o.x0xO0oo(status, "status");
        }

        public static void onReadTuyaKey(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleTuyaKey tuyaKey) {
            IIX0o.x0xO0oo(tuyaKey, "tuyaKey");
        }

        public static void onReadUiPackVersion(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo String version) {
            IIX0o.x0xO0oo(version, "version");
        }

        public static void onReadUnit(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadUserProfile(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleUserProfile userProfile) {
            IIX0o.x0xO0oo(userProfile, "userProfile");
        }

        public static void onReadVitalityValue(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleVitality> vitalityValue) {
            IIX0o.x0xO0oo(vitalityValue, "vitalityValue");
        }

        public static void onReadWatchFaceId(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleWatchFaceId watchFaceId) {
            IIX0o.x0xO0oo(watchFaceId, "watchFaceId");
        }

        public static void onReadWatchFaceIndex(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleWatchFaceIndex watchfaceIndex) {
            IIX0o.x0xO0oo(watchfaceIndex, "watchfaceIndex");
        }

        public static void onReadWatchFaceSwitch(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadWatchPassword(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleSettingWatchPassword watchPassword) {
            IIX0o.x0xO0oo(watchPassword, "watchPassword");
        }

        public static void onReadWearWayState(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onReadWeatherRealTime(@OOXIXo BleHandleCallback bleHandleCallback, boolean z) {
        }

        public static void onReadWorkout(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleWorkout> workouts) {
            IIX0o.x0xO0oo(workouts, "workouts");
        }

        public static void onReadWorkout2(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleWorkout2> workouts) {
            IIX0o.x0xO0oo(workouts, "workouts");
        }

        public static void onReadWorkout3(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleWorkout3> workouts) {
            IIX0o.x0xO0oo(workouts, "workouts");
        }

        public static void onReadWorldClock(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleWorldClock> clocks) {
            IIX0o.x0xO0oo(clocks, "clocks");
        }

        public static void onRealTimeMeasurement(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleRealTimeMeasurement realTimeMeasurement) {
            IIX0o.x0xO0oo(realTimeMeasurement, "realTimeMeasurement");
        }

        public static void onReceiveFilePacket(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleReceiveFilePacket filePacket) {
            IIX0o.x0xO0oo(filePacket, "filePacket");
        }

        public static void onReceiveGSensorMotion(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleGSensorMotion> gSensorMotions) {
            IIX0o.x0xO0oo(gSensorMotions, "gSensorMotions");
        }

        public static void onReceiveGSensorRaw(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleGSensorRaw> gSensorRaws) {
            IIX0o.x0xO0oo(gSensorRaws, "gSensorRaws");
        }

        public static void onReceiveGSensorSHSY(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleGSensorSHSY> gSensorSHSYs) {
            IIX0o.x0xO0oo(gSensorSHSYs, "gSensorSHSYs");
        }

        public static void onReceiveHRRaw(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleHRRaw> hrRaw) {
            IIX0o.x0xO0oo(hrRaw, "hrRaw");
        }

        public static void onReceiveLocationGga(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleLocationGga locationGga) {
            IIX0o.x0xO0oo(locationGga, "locationGga");
        }

        public static void onReceiveLocationGsv(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BleLocationGsv> locationGsv) {
            IIX0o.x0xO0oo(locationGsv, "locationGsv");
        }

        public static void onReceiveMusicCommand(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo MusicCommand musicCommand) {
            IIX0o.x0xO0oo(musicCommand, "musicCommand");
        }

        public static void onReceivePpgSHSY(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo List<BlePpgSHSY> ppgSHSYs) {
            IIX0o.x0xO0oo(ppgSHSYs, "ppgSHSYs");
        }

        public static void onReceiveRealtimeLog(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleRealtimeLog realtimeLog) {
            IIX0o.x0xO0oo(realtimeLog, "realtimeLog");
        }

        public static void onReceiveRecordPacket(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleRecordPacket recordPacket) {
            IIX0o.x0xO0oo(recordPacket, "recordPacket");
        }

        public static void onRequestAgpsPrerequisite(@OOXIXo BleHandleCallback bleHandleCallback) {
        }

        public static void onRequestLocation(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onRingVibrationSetUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleRingVibrationSettings ringVibrationSettings) {
            IIX0o.x0xO0oo(ringVibrationSettings, "ringVibrationSettings");
        }

        public static void onSDCardInfoUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleSDCardInfo sdCardInfo) {
            IIX0o.x0xO0oo(sdCardInfo, "sdCardInfo");
        }

        public static void onSGTestUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleSGTest test) {
            IIX0o.x0xO0oo(test, "test");
        }

        public static void onSOSSettingsUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleSOSSettings sosSettings) {
            IIX0o.x0xO0oo(sosSettings, "sosSettings");
        }

        public static void onScreenBrightnessSetUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onSessionStateChange(@OOXIXo BleHandleCallback bleHandleCallback, boolean z) {
        }

        public static void onSosContactUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleSosContact sosContact) {
            IIX0o.x0xO0oo(sosContact, "sosContact");
        }

        public static void onSportEndNotifyUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onStandbyWatchFaceSetUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleStandbyWatchFaceSet standbyWatchFaceSet) {
            IIX0o.x0xO0oo(standbyWatchFaceSet, "standbyWatchFaceSet");
        }

        public static void onStepGoalUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onStockDelete(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onStreamProgress(@OOXIXo BleHandleCallback bleHandleCallback, boolean z, int i, int i2, int i3, @OOXIXo BleKey bleKey) {
            IIX0o.x0xO0oo(bleKey, "bleKey");
        }

        public static /* synthetic */ void onStreamProgress$default(BleHandleCallback bleHandleCallback, boolean z, int i, int i2, int i3, BleKey bleKey, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 16) != 0) {
                    bleKey = BleKey.NONE;
                }
                bleHandleCallback.onStreamProgress(z, i, i2, i3, bleKey);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onStreamProgress");
        }

        public static void onSyncData(@OOXIXo BleHandleCallback bleHandleCallback, int i, @OOXIXo BleKey bleKey) {
            IIX0o.x0xO0oo(bleKey, "bleKey");
        }

        public static void onTimeUpdate(@OOXIXo BleHandleCallback bleHandleCallback) {
        }

        public static void onUpdateAppSportState(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleAppSportState appSportState) {
            IIX0o.x0xO0oo(appSportState, "appSportState");
        }

        public static void onUpdateBAC(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleBAC bac) {
            IIX0o.x0xO0oo(bac, "bac");
        }

        public static void onUpdateBloodPressure(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleBloodPressure bloodPressure) {
            IIX0o.x0xO0oo(bloodPressure, "bloodPressure");
        }

        public static void onUpdateHeartRate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleHeartRate heartRate) {
            IIX0o.x0xO0oo(heartRate, "heartRate");
        }

        public static void onUpdateTemperature(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleTemperature temperature) {
            IIX0o.x0xO0oo(temperature, "temperature");
        }

        public static void onUpdateWatchFaceSwitch(@OOXIXo BleHandleCallback bleHandleCallback, boolean z) {
        }

        public static void onUserProfileUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleUserProfile profile) {
            IIX0o.x0xO0oo(profile, "profile");
        }

        public static void onVibrationUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onWatchFaceIdUpdate(@OOXIXo BleHandleCallback bleHandleCallback, boolean z) {
        }

        public static void onWatchFaceIndexCreate(@OOXIXo BleHandleCallback bleHandleCallback, boolean z) {
        }

        public static void onWatchFaceIndexUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleWatchFaceIndex watchfaceIndex) {
            IIX0o.x0xO0oo(watchfaceIndex, "watchfaceIndex");
        }

        public static void onWatchPasswordUpdate(@OOXIXo BleHandleCallback bleHandleCallback, @OOXIXo BleSettingWatchPassword watchPassword) {
            IIX0o.x0xO0oo(watchPassword, "watchPassword");
        }

        public static void onWearWayUpdate(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onWorldClockDelete(@OOXIXo BleHandleCallback bleHandleCallback, int i) {
        }

        public static void onXModem(@OOXIXo BleHandleCallback bleHandleCallback, byte b) {
        }

        public static void onReadStock(@OOXIXo BleHandleCallback bleHandleCallback, boolean z) {
        }
    }

    void onAICoachGeneratePlanUpdate(int i);

    void onAlarmAdd(@OOXIXo BleAlarm bleAlarm);

    void onAlarmDelete(int i);

    void onAlarmUpdate(@OOXIXo BleAlarm bleAlarm);

    void onAppOpUpdate(@OOXIXo BleAppOp bleAppOp);

    void onAppSportDataResponse(boolean z);

    void onBWNaviInfoUpdate(@OOXIXo BleBWNaviInfo bleBWNaviInfo);

    void onBacklightUpdate(int i);

    void onBleThirdPartyDataUpdate(@OOXIXo BleThirdPartyData bleThirdPartyData);

    void onCaloriesGoalUpdate(int i);

    void onCameraResponse(boolean z, int i);

    void onCameraStateChange(int i);

    void onCheckInEveryDayUpdate(@OOXIXo BleCheckInEveryDay bleCheckInEveryDay);

    void onClassicBluetoothStateChange(int i);

    void onCommandReply(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag, boolean z);

    void onCommandSendTimeout(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag);

    void onDeviceConnected(@OOXIXo BluetoothDevice bluetoothDevice);

    void onDeviceConnecting(boolean z);

    void onDeviceFileUpdate(@OOXIXo BleDeviceFile bleDeviceFile);

    void onDeviceRequestAGpsFile(@OOXIXo String str);

    void onDeviceSMSQuickReply(@OOXIXo BleSMSQuickReply bleSMSQuickReply);

    void onDeviceSportDataUpdate(@OOXIXo BleDeviceSportData bleDeviceSportData);

    void onDistanceGoalUpdate(int i);

    void onDoubleScreenSettingsUpdate(@OOXIXo BleDoubleScreenSettings bleDoubleScreenSettings);

    void onEarphoneAncSettingsUpdate(@OOXIXo BleEarphoneAncSettings bleEarphoneAncSettings);

    void onEarphoneCallUpdate(int i);

    void onEarphoneKeyUpdate(@OOXIXo BleEarphoneKey bleEarphoneKey);

    void onEarphoneSoundEffectsSettingsUpdate(@OOXIXo BleEarphoneSoundEffectsSettings bleEarphoneSoundEffectsSettings);

    void onEarphoneStateUpdate(@OOXIXo BleEarphoneState bleEarphoneState);

    void onFactoryTestUpdate(@OOXIXo BleFactoryTest bleFactoryTest);

    void onFallSetUpdate(int i);

    void onFindEarphoneUpdate(@OOXIXo BleFindEarphone bleFindEarphone);

    void onFindPhone(boolean z);

    void onFindWatchUpdate(int i);

    void onFollowSystemLanguage(boolean z);

    void onGameControlUpdate(@OOXIXo BleGameControl bleGameControl);

    void onGestureWake2Update(@OOXIXo BleGestureWake2 bleGestureWake2);

    void onGestureWakeUpdate(@OOXIXo BleGestureWake bleGestureWake);

    void onHIDState(int i);

    void onHIDValueChange(int i);

    void onHanBaoVibrationStateChange(int i);

    void onHourSystemUpdate(int i);

    void onIPCStoresInfoUpdate(@OOXIXo BleIPCStoresInfo bleIPCStoresInfo);

    void onIPCWifiInfoUpdate(@OOXIXo BleIPCWifiInfo bleIPCWifiInfo);

    void onIPCWifiStateUpdate(int i);

    void onIdentityCreate(boolean z, @oOoXoXO BleDeviceInfo bleDeviceInfo);

    void onIdentityDelete(boolean z);

    void onIdentityDeleteByDevice(boolean z);

    void onIncomingCallRingUpdate(int i);

    void onIncomingCallStatus(int i);

    void onLoveTapUpdate(@OOXIXo BleLoveTap bleLoveTap);

    void onLoveTapUserDelete(int i);

    void onLoveTapUserUpdate(@OOXIXo BleLoveTapUser bleLoveTapUser);

    void onMeasurementUpdate(@OOXIXo BleMeasurement bleMeasurement);

    void onMedicationAlarmAdd(@OOXIXo BleMedicationAlarm bleMedicationAlarm);

    void onMedicationAlarmDelete(int i);

    void onMedicationAlarmUpdate(@OOXIXo BleMedicationAlarm bleMedicationAlarm);

    void onMedicationReminderDelete(int i);

    void onMedicationReminderUpdate(@OOXIXo BleMedicationReminder bleMedicationReminder);

    void onNaviInfoUpdate(@OOXIXo BleNaviInfo bleNaviInfo);

    void onNoDisturbUpdate(@OOXIXo BleNoDisturbSettings bleNoDisturbSettings);

    void onNotificationLightScreenSetUpdate(int i);

    void onNotificationSettings2Update(@OOXIXo BleNotificationSettings2 bleNotificationSettings2);

    void onOTA(boolean z);

    void onPowerSaveModeState(int i);

    void onPowerSaveModeStateChange(int i);

    void onQiblaSettingsUpdate();

    void onReadAICoachGenerateBeforeInfo(@OOXIXo BleAICoachBeforePlan bleAICoachBeforePlan);

    void onReadAICoachPlan(@OOXIXo BleAICoachGeneratePlan bleAICoachGeneratePlan);

    void onReadActivity(@OOXIXo List<BleActivity> list);

    void onReadActivityDetail(@OOXIXo BleActivityDetail bleActivityDetail);

    void onReadAlarm(@OOXIXo List<BleAlarm> list);

    void onReadAlipayBindInfo(@OOXIXo List<BleAlipayBindInfo> list);

    void onReadAlipaySettings(@OOXIXo BleAlipaySettings bleAlipaySettings);

    void onReadAppApiVersion(@OOXIXo String str);

    void onReadAppInfoList(@OOXIXo BleAppInfoList bleAppInfoList);

    void onReadAvgHeartRate(@OOXIXo List<BleAvgHeartRate> list);

    void onReadBAC(@OOXIXo List<BleBAC> list);

    void onReadBacCalibration(@OOXIXo BleBacCalibration bleBacCalibration, @OOXIXo BleKeyFlag bleKeyFlag);

    void onReadBacklight(int i);

    void onReadBatteryUsage(@OOXIXo BleBatteryUsage bleBatteryUsage);

    void onReadBleAddress(@OOXIXo String str);

    void onReadBleHrv(@OOXIXo List<BleHrv> list);

    void onReadBleHrv2(@OOXIXo List<BleHrv2> list);

    void onReadBleLogText(@OOXIXo List<BleLogText> list);

    void onReadBloodGlucose(@OOXIXo List<BleBloodGlucose> list);

    void onReadBloodOxyGenSettings(@OOXIXo BleBloodOxyGenSettings bleBloodOxyGenSettings);

    void onReadBloodOxygen(@OOXIXo List<BleBloodOxygen> list);

    void onReadBloodPressure(@OOXIXo List<BleBloodPressure> list);

    void onReadBloodPressureCalibration(@OOXIXo BleBloodPressureCalibration bleBloodPressureCalibration);

    void onReadBodyStatus(@OOXIXo List<BleBodyStatus> list);

    void onReadCPUserInfo(@OOXIXo BleCPUserInfo bleCPUserInfo);

    void onReadCalibrationData(@OOXIXo BleCalibrationData bleCalibrationData);

    void onReadCalorieIntake(@OOXIXo List<BleCalorieIntake> list);

    void onReadCaloriesGoal(int i);

    void onReadCheckInEveryDay(@OOXIXo BleCheckInEveryDay bleCheckInEveryDay);

    void onReadClassicBluetoothState(int i);

    void onReadCoachingIds(@OOXIXo BleCoachingIds bleCoachingIds);

    void onReadDailyPower(@OOXIXo List<BlePhysicalPower> list);

    void onReadDateFormat(int i);

    void onReadDeviceFile(@OOXIXo BleDeviceFile bleDeviceFile);

    void onReadDeviceInfo(@OOXIXo BleDeviceInfo bleDeviceInfo);

    void onReadDeviceInfo2(@OOXIXo BleDeviceInfo2 bleDeviceInfo2);

    void onReadDeviceLanguages(@OOXIXo BleDeviceLanguages bleDeviceLanguages);

    void onReadDeviceUniqueDataSettings(@OOXIXo BleDeviceUniqueDataSettings bleDeviceUniqueDataSettings);

    void onReadDistanceGoal(int i);

    void onReadDoubleScreenSettings(@OOXIXo BleDoubleScreenSettings bleDoubleScreenSettings);

    void onReadDrinkWater(@OOXIXo BleDrinkWaterSettings bleDrinkWaterSettings);

    void onReadEarphoneAncSettings(@OOXIXo BleEarphoneAncSettings bleEarphoneAncSettings);

    void onReadEarphoneCall(int i);

    void onReadEarphoneInfo(@OOXIXo BleEarphoneInfo bleEarphoneInfo);

    void onReadEarphoneKey(@OOXIXo BleEarphoneKey bleEarphoneKey);

    void onReadEarphonePower(@OOXIXo BleEarphonePower bleEarphonePower);

    void onReadEarphoneSoundEffectsSettings(@OOXIXo BleEarphoneSoundEffectsSettings bleEarphoneSoundEffectsSettings);

    void onReadEarphoneState(@OOXIXo BleEarphoneState bleEarphoneState);

    void onReadEcg(@OOXIXo List<BleEcg> list);

    void onReadEcgSettings(@OOXIXo BleEcgSettings bleEcgSettings);

    void onReadFallSet(int i);

    void onReadFilePath(@OOXIXo BleAppAudioBookList bleAppAudioBookList);

    void onReadFirmwareVersion(@OOXIXo String str);

    void onReadFoodBalance(@OOXIXo List<BleFoodBalance> list);

    void onReadGestureWake(@OOXIXo BleGestureWake bleGestureWake);

    void onReadGestureWake2(@OOXIXo BleGestureWake2 bleGestureWake2);

    void onReadGirlCareMonthly(@OOXIXo BleGirlCareMonthly bleGirlCareMonthly);

    void onReadGirlCareSettings(@OOXIXo BleGirlCareSettings bleGirlCareSettings);

    void onReadGoMoreSettings(@OOXIXo BleGoMoreSettings bleGoMoreSettings);

    void onReadGpsFirmwareVersion(@OOXIXo String str);

    void onReadHanBaoSettings(@OOXIXo BleHanBaoSettings bleHanBaoSettings);

    void onReadHanBaoVibration(@OOXIXo List<BleHanBaoVibration> list);

    void onReadHeartRate(@OOXIXo List<BleHeartRate> list);

    void onReadHourSystem(int i);

    void onReadHrMonitoringSettings(@OOXIXo BleHrMonitoringSettings bleHrMonitoringSettings);

    void onReadIPCStoresInfo(@OOXIXo BleIPCStoresInfo bleIPCStoresInfo);

    void onReadIPCVersion(@OOXIXo String str);

    void onReadIPCWifiState(int i);

    void onReadIncomingCallRing(int i);

    void onReadLactateThreshold(@OOXIXo List<BleLactateThreshold> list);

    void onReadLanguage(int i);

    void onReadLanguagePackVersion(@OOXIXo BleLanguagePackVersion bleLanguagePackVersion);

    void onReadLocation(@OOXIXo List<BleLocation> list);

    void onReadLoveTapUser(@OOXIXo List<BleLoveTapUser> list);

    void onReadMatchRecord(@OOXIXo List<BleMatchRecord> list);

    void onReadMatchRecord2(@OOXIXo List<BleMatchRecord2> list);

    void onReadMedicationAlarm(@OOXIXo List<BleMedicationAlarm> list);

    void onReadMedicationReminder(@OOXIXo List<BleMedicationReminder> list);

    void onReadMindStatus(@OOXIXo List<BleMindStatus> list);

    void onReadMtkOtaMeta();

    void onReadNetworkFirmwareVersion(@OOXIXo String str);

    void onReadNoDisturb(@OOXIXo BleNoDisturbSettings bleNoDisturbSettings);

    void onReadNotificationLightScreenSet(int i);

    void onReadNotificationSettings2(@OOXIXo BleNotificationSettings2 bleNotificationSettings2);

    void onReadPackageStatus(@OOXIXo BlePackageStatus blePackageStatus);

    void onReadPower(int i);

    void onReadPower2(@OOXIXo BlePower2 blePower2);

    void onReadPressure(@OOXIXo List<BlePressure> list);

    void onReadPressureTimingMeasurement(@OOXIXo BlePressureTimingMeasurement blePressureTimingMeasurement);

    void onReadQiblaSettings(@OOXIXo BleQiblaSettings bleQiblaSettings);

    void onReadRelaxReminder(@OOXIXo BleRelaxReminder bleRelaxReminder);

    void onReadRespiratoryRate(@OOXIXo List<BleRespiratoryRate> list);

    void onReadRingVibrationSet(@OOXIXo BleRingVibrationSettings bleRingVibrationSettings);

    void onReadRri(@OOXIXo List<BleRri> list);

    void onReadSDCardInfo(@OOXIXo BleSDCardInfo bleSDCardInfo);

    void onReadSGKeywordAwake(int i);

    void onReadSGSleepSet(int i);

    void onReadSOSSettings(@OOXIXo BleSOSSettings bleSOSSettings);

    void onReadScreenBrightnessSet(int i);

    void onReadSedentariness(@OOXIXo BleSedentarinessSettings bleSedentarinessSettings);

    void onReadSleep(@OOXIXo List<BleSleep> list);

    void onReadSleepGoal(int i);

    void onReadSleepQuality(@OOXIXo BleSleepQuality bleSleepQuality);

    void onReadSleepQualityScore(int i);

    void onReadSleepRaw(@OOXIXo byte[] bArr);

    void onReadSosCallLog(@OOXIXo List<BleSosCallLog> list);

    void onReadSosContact(@OOXIXo BleSosContact bleSosContact);

    void onReadSportDurationGoal(int i);

    void onReadStandbyWatchFaceSet(@OOXIXo BleStandbyWatchFaceSet bleStandbyWatchFaceSet);

    void onReadStepGoal(int i);

    void onReadStock(@OOXIXo List<BleStock> list);

    void onReadStock(boolean z);

    void onReadTemperature(@OOXIXo List<BleTemperature> list);

    void onReadTemperatureUnit(int i);

    void onReadTrainingStatus(@OOXIXo List<BleTrainingStatus> list);

    void onReadTuyaKey(@OOXIXo BleTuyaKey bleTuyaKey);

    void onReadUiPackVersion(@OOXIXo String str);

    void onReadUnit(int i);

    void onReadUserProfile(@OOXIXo BleUserProfile bleUserProfile);

    void onReadVitalityValue(@OOXIXo List<BleVitality> list);

    void onReadWatchFaceId(@OOXIXo BleWatchFaceId bleWatchFaceId);

    void onReadWatchFaceIndex(@OOXIXo BleWatchFaceIndex bleWatchFaceIndex);

    void onReadWatchFaceSwitch(int i);

    void onReadWatchPassword(@OOXIXo BleSettingWatchPassword bleSettingWatchPassword);

    void onReadWearWayState(int i);

    void onReadWeatherRealTime(boolean z);

    void onReadWorkout(@OOXIXo List<BleWorkout> list);

    void onReadWorkout2(@OOXIXo List<BleWorkout2> list);

    void onReadWorkout3(@OOXIXo List<BleWorkout3> list);

    void onReadWorldClock(@OOXIXo List<BleWorldClock> list);

    void onRealTimeMeasurement(@OOXIXo BleRealTimeMeasurement bleRealTimeMeasurement);

    void onReceiveFilePacket(@OOXIXo BleReceiveFilePacket bleReceiveFilePacket);

    void onReceiveGSensorMotion(@OOXIXo List<BleGSensorMotion> list);

    void onReceiveGSensorRaw(@OOXIXo List<BleGSensorRaw> list);

    void onReceiveGSensorSHSY(@OOXIXo List<BleGSensorSHSY> list);

    void onReceiveHRRaw(@OOXIXo List<BleHRRaw> list);

    void onReceiveLocationGga(@OOXIXo BleLocationGga bleLocationGga);

    void onReceiveLocationGsv(@OOXIXo List<BleLocationGsv> list);

    void onReceiveMusicCommand(@OOXIXo MusicCommand musicCommand);

    void onReceivePpgSHSY(@OOXIXo List<BlePpgSHSY> list);

    void onReceiveRealtimeLog(@OOXIXo BleRealtimeLog bleRealtimeLog);

    void onReceiveRecordPacket(@OOXIXo BleRecordPacket bleRecordPacket);

    void onRequestAgpsPrerequisite();

    void onRequestLocation(int i);

    void onRingVibrationSetUpdate(@OOXIXo BleRingVibrationSettings bleRingVibrationSettings);

    void onSDCardInfoUpdate(@OOXIXo BleSDCardInfo bleSDCardInfo);

    void onSGTestUpdate(@OOXIXo BleSGTest bleSGTest);

    void onSOSSettingsUpdate(@OOXIXo BleSOSSettings bleSOSSettings);

    void onScreenBrightnessSetUpdate(int i);

    void onSessionStateChange(boolean z);

    void onSosContactUpdate(@OOXIXo BleSosContact bleSosContact);

    void onSportEndNotifyUpdate(int i);

    void onStandbyWatchFaceSetUpdate(@OOXIXo BleStandbyWatchFaceSet bleStandbyWatchFaceSet);

    void onStepGoalUpdate(int i);

    void onStockDelete(int i);

    void onStreamProgress(boolean z, int i, int i2, int i3, @OOXIXo BleKey bleKey);

    void onSyncData(int i, @OOXIXo BleKey bleKey);

    void onTimeUpdate();

    void onUpdateAppSportState(@OOXIXo BleAppSportState bleAppSportState);

    void onUpdateBAC(@OOXIXo BleBAC bleBAC);

    void onUpdateBloodPressure(@OOXIXo BleBloodPressure bleBloodPressure);

    void onUpdateHeartRate(@OOXIXo BleHeartRate bleHeartRate);

    void onUpdateTemperature(@OOXIXo BleTemperature bleTemperature);

    void onUpdateWatchFaceSwitch(boolean z);

    void onUserProfileUpdate(@OOXIXo BleUserProfile bleUserProfile);

    void onVibrationUpdate(int i);

    void onWatchFaceIdUpdate(boolean z);

    void onWatchFaceIndexCreate(boolean z);

    void onWatchFaceIndexUpdate(@OOXIXo BleWatchFaceIndex bleWatchFaceIndex);

    void onWatchPasswordUpdate(@OOXIXo BleSettingWatchPassword bleSettingWatchPassword);

    void onWearWayUpdate(int i);

    void onWorldClockDelete(int i);

    void onXModem(byte b);
}
