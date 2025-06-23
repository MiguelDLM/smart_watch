package com.sma.smartv3.ui.sport.coach;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.Oxx0xo;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.otherdevice.jl.view.CommonDecoration;
import com.sma.smartv3.pop.XoI0Ixx0;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import com.sma.smartv3.ui.sport.coach.item.PlanContentItem;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.component.BleHandleCallback;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import org.apache.log4j.helpers.x0XOIxOo;

@XX({"SMAP\nAiCoachFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiCoachFragment.kt\ncom/sma/smartv3/ui/sport/coach/AiCoachFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,472:1\n90#2:473\n90#2:474\n1855#3,2:475\n*S KotlinDebug\n*F\n+ 1 AiCoachFragment.kt\ncom/sma/smartv3/ui/sport/coach/AiCoachFragment\n*L\n135#1:473\n169#1:474\n454#1:475,2\n*E\n"})
/* loaded from: classes12.dex */
public final class AiCoachFragment extends BaseDSLRecyclerFragment {
    private int curPosition;
    private boolean isReachedTarget;
    private int mCurrentItem;

    @oOoXoXO
    private XoI0Ixx0 mDeleteWindow;

    @oOoXoXO
    private XoI0Ixx0 mExtensionWindow;

    @oOoXoXO
    private AICoachManage.VitalityData mVitalityData;

    @OOXIXo
    private final String TAG = "AiCoachFragment";

    @OOXIXo
    private final String ITEM_GROUPS_TAG = "cocah_groups";

    @OOXIXo
    private String curTimeDay = "";
    private int curDataPosition = -1;

    @OOXIXo
    private final List<CommonAdapter<AICoachManage.PlanGroupTitle>> mListAdapter = new ArrayList();

    @OOXIXo
    private final oIX0oI mBleHandleCallback = new oIX0oI();
    private boolean isAddItemDecoration = true;

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements BleHandleCallback {
        public oIX0oI() {
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAICoachGeneratePlanUpdate(int i) {
            BleHandleCallback.DefaultImpls.onAICoachGeneratePlanUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAlarmAdd(@OOXIXo BleAlarm bleAlarm) {
            BleHandleCallback.DefaultImpls.onAlarmAdd(this, bleAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAlarmDelete(int i) {
            BleHandleCallback.DefaultImpls.onAlarmDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAlarmUpdate(@OOXIXo BleAlarm bleAlarm) {
            BleHandleCallback.DefaultImpls.onAlarmUpdate(this, bleAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAppOpUpdate(@OOXIXo BleAppOp bleAppOp) {
            BleHandleCallback.DefaultImpls.onAppOpUpdate(this, bleAppOp);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAppSportDataResponse(boolean z) {
            BleHandleCallback.DefaultImpls.onAppSportDataResponse(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onBWNaviInfoUpdate(@OOXIXo BleBWNaviInfo bleBWNaviInfo) {
            BleHandleCallback.DefaultImpls.onBWNaviInfoUpdate(this, bleBWNaviInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onBacklightUpdate(int i) {
            BleHandleCallback.DefaultImpls.onBacklightUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onBleThirdPartyDataUpdate(@OOXIXo BleThirdPartyData bleThirdPartyData) {
            BleHandleCallback.DefaultImpls.onBleThirdPartyDataUpdate(this, bleThirdPartyData);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCaloriesGoalUpdate(int i) {
            BleHandleCallback.DefaultImpls.onCaloriesGoalUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCameraResponse(boolean z, int i) {
            BleHandleCallback.DefaultImpls.onCameraResponse(this, z, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCameraStateChange(int i) {
            BleHandleCallback.DefaultImpls.onCameraStateChange(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCheckInEveryDayUpdate(@OOXIXo BleCheckInEveryDay bleCheckInEveryDay) {
            BleHandleCallback.DefaultImpls.onCheckInEveryDayUpdate(this, bleCheckInEveryDay);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onClassicBluetoothStateChange(int i) {
            BleHandleCallback.DefaultImpls.onClassicBluetoothStateChange(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCommandReply(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag, boolean z) {
            BleHandleCallback.DefaultImpls.onCommandReply(this, bleKey, bleKeyFlag, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCommandSendTimeout(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag) {
            BleHandleCallback.DefaultImpls.onCommandSendTimeout(this, bleKey, bleKeyFlag);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceConnected(@OOXIXo BluetoothDevice bluetoothDevice) {
            BleHandleCallback.DefaultImpls.onDeviceConnected(this, bluetoothDevice);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceConnecting(boolean z) {
            BleHandleCallback.DefaultImpls.onDeviceConnecting(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceFileUpdate(@OOXIXo BleDeviceFile bleDeviceFile) {
            BleHandleCallback.DefaultImpls.onDeviceFileUpdate(this, bleDeviceFile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceRequestAGpsFile(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onDeviceRequestAGpsFile(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceSMSQuickReply(@OOXIXo BleSMSQuickReply bleSMSQuickReply) {
            BleHandleCallback.DefaultImpls.onDeviceSMSQuickReply(this, bleSMSQuickReply);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceSportDataUpdate(@OOXIXo BleDeviceSportData bleDeviceSportData) {
            BleHandleCallback.DefaultImpls.onDeviceSportDataUpdate(this, bleDeviceSportData);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDistanceGoalUpdate(int i) {
            BleHandleCallback.DefaultImpls.onDistanceGoalUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDoubleScreenSettingsUpdate(@OOXIXo BleDoubleScreenSettings bleDoubleScreenSettings) {
            BleHandleCallback.DefaultImpls.onDoubleScreenSettingsUpdate(this, bleDoubleScreenSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneAncSettingsUpdate(@OOXIXo BleEarphoneAncSettings bleEarphoneAncSettings) {
            BleHandleCallback.DefaultImpls.onEarphoneAncSettingsUpdate(this, bleEarphoneAncSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneCallUpdate(int i) {
            BleHandleCallback.DefaultImpls.onEarphoneCallUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneKeyUpdate(@OOXIXo BleEarphoneKey bleEarphoneKey) {
            BleHandleCallback.DefaultImpls.onEarphoneKeyUpdate(this, bleEarphoneKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneSoundEffectsSettingsUpdate(@OOXIXo BleEarphoneSoundEffectsSettings bleEarphoneSoundEffectsSettings) {
            BleHandleCallback.DefaultImpls.onEarphoneSoundEffectsSettingsUpdate(this, bleEarphoneSoundEffectsSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneStateUpdate(@OOXIXo BleEarphoneState bleEarphoneState) {
            BleHandleCallback.DefaultImpls.onEarphoneStateUpdate(this, bleEarphoneState);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFactoryTestUpdate(@OOXIXo BleFactoryTest bleFactoryTest) {
            BleHandleCallback.DefaultImpls.onFactoryTestUpdate(this, bleFactoryTest);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFallSetUpdate(int i) {
            BleHandleCallback.DefaultImpls.onFallSetUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFindEarphoneUpdate(@OOXIXo BleFindEarphone bleFindEarphone) {
            BleHandleCallback.DefaultImpls.onFindEarphoneUpdate(this, bleFindEarphone);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFindPhone(boolean z) {
            BleHandleCallback.DefaultImpls.onFindPhone(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFindWatchUpdate(int i) {
            BleHandleCallback.DefaultImpls.onFindWatchUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFollowSystemLanguage(boolean z) {
            BleHandleCallback.DefaultImpls.onFollowSystemLanguage(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onGameControlUpdate(@OOXIXo BleGameControl bleGameControl) {
            BleHandleCallback.DefaultImpls.onGameControlUpdate(this, bleGameControl);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onGestureWake2Update(@OOXIXo BleGestureWake2 bleGestureWake2) {
            BleHandleCallback.DefaultImpls.onGestureWake2Update(this, bleGestureWake2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onGestureWakeUpdate(@OOXIXo BleGestureWake bleGestureWake) {
            BleHandleCallback.DefaultImpls.onGestureWakeUpdate(this, bleGestureWake);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onHIDState(int i) {
            BleHandleCallback.DefaultImpls.onHIDState(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onHIDValueChange(int i) {
            BleHandleCallback.DefaultImpls.onHIDValueChange(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onHanBaoVibrationStateChange(int i) {
            BleHandleCallback.DefaultImpls.onHanBaoVibrationStateChange(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onHourSystemUpdate(int i) {
            BleHandleCallback.DefaultImpls.onHourSystemUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIPCStoresInfoUpdate(@OOXIXo BleIPCStoresInfo bleIPCStoresInfo) {
            BleHandleCallback.DefaultImpls.onIPCStoresInfoUpdate(this, bleIPCStoresInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIPCWifiInfoUpdate(@OOXIXo BleIPCWifiInfo bleIPCWifiInfo) {
            BleHandleCallback.DefaultImpls.onIPCWifiInfoUpdate(this, bleIPCWifiInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIPCWifiStateUpdate(int i) {
            BleHandleCallback.DefaultImpls.onIPCWifiStateUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIdentityCreate(boolean z, @oOoXoXO BleDeviceInfo bleDeviceInfo) {
            BleHandleCallback.DefaultImpls.onIdentityCreate(this, z, bleDeviceInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIdentityDelete(boolean z) {
            BleHandleCallback.DefaultImpls.onIdentityDelete(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIdentityDeleteByDevice(boolean z) {
            BleHandleCallback.DefaultImpls.onIdentityDeleteByDevice(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIncomingCallRingUpdate(int i) {
            BleHandleCallback.DefaultImpls.onIncomingCallRingUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIncomingCallStatus(int i) {
            BleHandleCallback.DefaultImpls.onIncomingCallStatus(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onLoveTapUpdate(@OOXIXo BleLoveTap bleLoveTap) {
            BleHandleCallback.DefaultImpls.onLoveTapUpdate(this, bleLoveTap);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onLoveTapUserDelete(int i) {
            BleHandleCallback.DefaultImpls.onLoveTapUserDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onLoveTapUserUpdate(@OOXIXo BleLoveTapUser bleLoveTapUser) {
            BleHandleCallback.DefaultImpls.onLoveTapUserUpdate(this, bleLoveTapUser);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMeasurementUpdate(@OOXIXo BleMeasurement bleMeasurement) {
            BleHandleCallback.DefaultImpls.onMeasurementUpdate(this, bleMeasurement);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationAlarmAdd(@OOXIXo BleMedicationAlarm bleMedicationAlarm) {
            BleHandleCallback.DefaultImpls.onMedicationAlarmAdd(this, bleMedicationAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationAlarmDelete(int i) {
            BleHandleCallback.DefaultImpls.onMedicationAlarmDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationAlarmUpdate(@OOXIXo BleMedicationAlarm bleMedicationAlarm) {
            BleHandleCallback.DefaultImpls.onMedicationAlarmUpdate(this, bleMedicationAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationReminderDelete(int i) {
            BleHandleCallback.DefaultImpls.onMedicationReminderDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationReminderUpdate(@OOXIXo BleMedicationReminder bleMedicationReminder) {
            BleHandleCallback.DefaultImpls.onMedicationReminderUpdate(this, bleMedicationReminder);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNaviInfoUpdate(@OOXIXo BleNaviInfo bleNaviInfo) {
            BleHandleCallback.DefaultImpls.onNaviInfoUpdate(this, bleNaviInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNoDisturbUpdate(@OOXIXo BleNoDisturbSettings bleNoDisturbSettings) {
            BleHandleCallback.DefaultImpls.onNoDisturbUpdate(this, bleNoDisturbSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNotificationLightScreenSetUpdate(int i) {
            BleHandleCallback.DefaultImpls.onNotificationLightScreenSetUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNotificationSettings2Update(@OOXIXo BleNotificationSettings2 bleNotificationSettings2) {
            BleHandleCallback.DefaultImpls.onNotificationSettings2Update(this, bleNotificationSettings2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onOTA(boolean z) {
            BleHandleCallback.DefaultImpls.onOTA(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onPowerSaveModeState(int i) {
            BleHandleCallback.DefaultImpls.onPowerSaveModeState(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onPowerSaveModeStateChange(int i) {
            BleHandleCallback.DefaultImpls.onPowerSaveModeStateChange(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onQiblaSettingsUpdate() {
            BleHandleCallback.DefaultImpls.onQiblaSettingsUpdate(this);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAICoachGenerateBeforeInfo(@OOXIXo BleAICoachBeforePlan info) {
            IIX0o.x0xO0oo(info, "info");
            BleHandleCallback.DefaultImpls.onReadAICoachGenerateBeforeInfo(this, info);
            AICoachManage.oIX0oI oix0oi = AICoachManage.f23905XO;
            oix0oi.oIX0oI().o00(info);
            oix0oi.oIX0oI().ooOOo0oXI(1);
            LogUtils.i("onReadAICoachGenerateBeforeInfo " + info);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAICoachPlan(@OOXIXo BleAICoachGeneratePlan plan) {
            IIX0o.x0xO0oo(plan, "plan");
            BleHandleCallback.DefaultImpls.onReadAICoachPlan(this, plan);
            AICoachManage.f23905XO.oIX0oI().xoXoI(plan);
            AiCoachFragment.this.onPlanCreateChanged("");
            LogUtils.i("onReadAICoachPlan " + plan);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadActivity(@OOXIXo List<BleActivity> list) {
            BleHandleCallback.DefaultImpls.onReadActivity(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadActivityDetail(@OOXIXo BleActivityDetail bleActivityDetail) {
            BleHandleCallback.DefaultImpls.onReadActivityDetail(this, bleActivityDetail);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAlarm(@OOXIXo List<BleAlarm> list) {
            BleHandleCallback.DefaultImpls.onReadAlarm(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAlipayBindInfo(@OOXIXo List<BleAlipayBindInfo> list) {
            BleHandleCallback.DefaultImpls.onReadAlipayBindInfo(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAlipaySettings(@OOXIXo BleAlipaySettings bleAlipaySettings) {
            BleHandleCallback.DefaultImpls.onReadAlipaySettings(this, bleAlipaySettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAppApiVersion(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadAppApiVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAppInfoList(@OOXIXo BleAppInfoList bleAppInfoList) {
            BleHandleCallback.DefaultImpls.onReadAppInfoList(this, bleAppInfoList);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAvgHeartRate(@OOXIXo List<BleAvgHeartRate> list) {
            BleHandleCallback.DefaultImpls.onReadAvgHeartRate(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBAC(@OOXIXo List<BleBAC> list) {
            BleHandleCallback.DefaultImpls.onReadBAC(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBacCalibration(@OOXIXo BleBacCalibration bleBacCalibration, @OOXIXo BleKeyFlag bleKeyFlag) {
            BleHandleCallback.DefaultImpls.onReadBacCalibration(this, bleBacCalibration, bleKeyFlag);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBacklight(int i) {
            BleHandleCallback.DefaultImpls.onReadBacklight(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBatteryUsage(@OOXIXo BleBatteryUsage bleBatteryUsage) {
            BleHandleCallback.DefaultImpls.onReadBatteryUsage(this, bleBatteryUsage);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleAddress(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadBleAddress(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleHrv(@OOXIXo List<BleHrv> list) {
            BleHandleCallback.DefaultImpls.onReadBleHrv(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleHrv2(@OOXIXo List<BleHrv2> list) {
            BleHandleCallback.DefaultImpls.onReadBleHrv2(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleLogText(@OOXIXo List<BleLogText> list) {
            BleHandleCallback.DefaultImpls.onReadBleLogText(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodGlucose(@OOXIXo List<BleBloodGlucose> list) {
            BleHandleCallback.DefaultImpls.onReadBloodGlucose(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodOxyGenSettings(@OOXIXo BleBloodOxyGenSettings bleBloodOxyGenSettings) {
            BleHandleCallback.DefaultImpls.onReadBloodOxyGenSettings(this, bleBloodOxyGenSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodOxygen(@OOXIXo List<BleBloodOxygen> list) {
            BleHandleCallback.DefaultImpls.onReadBloodOxygen(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodPressure(@OOXIXo List<BleBloodPressure> list) {
            BleHandleCallback.DefaultImpls.onReadBloodPressure(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodPressureCalibration(@OOXIXo BleBloodPressureCalibration bleBloodPressureCalibration) {
            BleHandleCallback.DefaultImpls.onReadBloodPressureCalibration(this, bleBloodPressureCalibration);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBodyStatus(@OOXIXo List<BleBodyStatus> list) {
            BleHandleCallback.DefaultImpls.onReadBodyStatus(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCPUserInfo(@OOXIXo BleCPUserInfo bleCPUserInfo) {
            BleHandleCallback.DefaultImpls.onReadCPUserInfo(this, bleCPUserInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCalibrationData(@OOXIXo BleCalibrationData bleCalibrationData) {
            BleHandleCallback.DefaultImpls.onReadCalibrationData(this, bleCalibrationData);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCalorieIntake(@OOXIXo List<BleCalorieIntake> list) {
            BleHandleCallback.DefaultImpls.onReadCalorieIntake(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCaloriesGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadCaloriesGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCheckInEveryDay(@OOXIXo BleCheckInEveryDay bleCheckInEveryDay) {
            BleHandleCallback.DefaultImpls.onReadCheckInEveryDay(this, bleCheckInEveryDay);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadClassicBluetoothState(int i) {
            BleHandleCallback.DefaultImpls.onReadClassicBluetoothState(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCoachingIds(@OOXIXo BleCoachingIds bleCoachingIds) {
            BleHandleCallback.DefaultImpls.onReadCoachingIds(this, bleCoachingIds);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDailyPower(@OOXIXo List<BlePhysicalPower> list) {
            BleHandleCallback.DefaultImpls.onReadDailyPower(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDateFormat(int i) {
            BleHandleCallback.DefaultImpls.onReadDateFormat(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceFile(@OOXIXo BleDeviceFile bleDeviceFile) {
            BleHandleCallback.DefaultImpls.onReadDeviceFile(this, bleDeviceFile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceInfo(@OOXIXo BleDeviceInfo bleDeviceInfo) {
            BleHandleCallback.DefaultImpls.onReadDeviceInfo(this, bleDeviceInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceInfo2(@OOXIXo BleDeviceInfo2 bleDeviceInfo2) {
            BleHandleCallback.DefaultImpls.onReadDeviceInfo2(this, bleDeviceInfo2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceLanguages(@OOXIXo BleDeviceLanguages bleDeviceLanguages) {
            BleHandleCallback.DefaultImpls.onReadDeviceLanguages(this, bleDeviceLanguages);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceUniqueDataSettings(@OOXIXo BleDeviceUniqueDataSettings bleDeviceUniqueDataSettings) {
            BleHandleCallback.DefaultImpls.onReadDeviceUniqueDataSettings(this, bleDeviceUniqueDataSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDistanceGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadDistanceGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDoubleScreenSettings(@OOXIXo BleDoubleScreenSettings bleDoubleScreenSettings) {
            BleHandleCallback.DefaultImpls.onReadDoubleScreenSettings(this, bleDoubleScreenSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDrinkWater(@OOXIXo BleDrinkWaterSettings bleDrinkWaterSettings) {
            BleHandleCallback.DefaultImpls.onReadDrinkWater(this, bleDrinkWaterSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneAncSettings(@OOXIXo BleEarphoneAncSettings bleEarphoneAncSettings) {
            BleHandleCallback.DefaultImpls.onReadEarphoneAncSettings(this, bleEarphoneAncSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneCall(int i) {
            BleHandleCallback.DefaultImpls.onReadEarphoneCall(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneInfo(@OOXIXo BleEarphoneInfo bleEarphoneInfo) {
            BleHandleCallback.DefaultImpls.onReadEarphoneInfo(this, bleEarphoneInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneKey(@OOXIXo BleEarphoneKey bleEarphoneKey) {
            BleHandleCallback.DefaultImpls.onReadEarphoneKey(this, bleEarphoneKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphonePower(@OOXIXo BleEarphonePower bleEarphonePower) {
            BleHandleCallback.DefaultImpls.onReadEarphonePower(this, bleEarphonePower);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneSoundEffectsSettings(@OOXIXo BleEarphoneSoundEffectsSettings bleEarphoneSoundEffectsSettings) {
            BleHandleCallback.DefaultImpls.onReadEarphoneSoundEffectsSettings(this, bleEarphoneSoundEffectsSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneState(@OOXIXo BleEarphoneState bleEarphoneState) {
            BleHandleCallback.DefaultImpls.onReadEarphoneState(this, bleEarphoneState);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEcg(@OOXIXo List<BleEcg> list) {
            BleHandleCallback.DefaultImpls.onReadEcg(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEcgSettings(@OOXIXo BleEcgSettings bleEcgSettings) {
            BleHandleCallback.DefaultImpls.onReadEcgSettings(this, bleEcgSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFallSet(int i) {
            BleHandleCallback.DefaultImpls.onReadFallSet(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFilePath(@OOXIXo BleAppAudioBookList bleAppAudioBookList) {
            BleHandleCallback.DefaultImpls.onReadFilePath(this, bleAppAudioBookList);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFirmwareVersion(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadFirmwareVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFoodBalance(@OOXIXo List<BleFoodBalance> list) {
            BleHandleCallback.DefaultImpls.onReadFoodBalance(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGestureWake(@OOXIXo BleGestureWake bleGestureWake) {
            BleHandleCallback.DefaultImpls.onReadGestureWake(this, bleGestureWake);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGestureWake2(@OOXIXo BleGestureWake2 bleGestureWake2) {
            BleHandleCallback.DefaultImpls.onReadGestureWake2(this, bleGestureWake2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGirlCareMonthly(@OOXIXo BleGirlCareMonthly bleGirlCareMonthly) {
            BleHandleCallback.DefaultImpls.onReadGirlCareMonthly(this, bleGirlCareMonthly);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGirlCareSettings(@OOXIXo BleGirlCareSettings bleGirlCareSettings) {
            BleHandleCallback.DefaultImpls.onReadGirlCareSettings(this, bleGirlCareSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGoMoreSettings(@OOXIXo BleGoMoreSettings bleGoMoreSettings) {
            BleHandleCallback.DefaultImpls.onReadGoMoreSettings(this, bleGoMoreSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGpsFirmwareVersion(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadGpsFirmwareVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHanBaoSettings(@OOXIXo BleHanBaoSettings bleHanBaoSettings) {
            BleHandleCallback.DefaultImpls.onReadHanBaoSettings(this, bleHanBaoSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHanBaoVibration(@OOXIXo List<BleHanBaoVibration> list) {
            BleHandleCallback.DefaultImpls.onReadHanBaoVibration(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHeartRate(@OOXIXo List<BleHeartRate> list) {
            BleHandleCallback.DefaultImpls.onReadHeartRate(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHourSystem(int i) {
            BleHandleCallback.DefaultImpls.onReadHourSystem(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHrMonitoringSettings(@OOXIXo BleHrMonitoringSettings bleHrMonitoringSettings) {
            BleHandleCallback.DefaultImpls.onReadHrMonitoringSettings(this, bleHrMonitoringSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadIPCStoresInfo(@OOXIXo BleIPCStoresInfo bleIPCStoresInfo) {
            BleHandleCallback.DefaultImpls.onReadIPCStoresInfo(this, bleIPCStoresInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadIPCVersion(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadIPCVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadIPCWifiState(int i) {
            BleHandleCallback.DefaultImpls.onReadIPCWifiState(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadIncomingCallRing(int i) {
            BleHandleCallback.DefaultImpls.onReadIncomingCallRing(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLactateThreshold(@OOXIXo List<BleLactateThreshold> list) {
            BleHandleCallback.DefaultImpls.onReadLactateThreshold(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLanguage(int i) {
            BleHandleCallback.DefaultImpls.onReadLanguage(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLanguagePackVersion(@OOXIXo BleLanguagePackVersion bleLanguagePackVersion) {
            BleHandleCallback.DefaultImpls.onReadLanguagePackVersion(this, bleLanguagePackVersion);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLocation(@OOXIXo List<BleLocation> list) {
            BleHandleCallback.DefaultImpls.onReadLocation(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLoveTapUser(@OOXIXo List<BleLoveTapUser> list) {
            BleHandleCallback.DefaultImpls.onReadLoveTapUser(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMatchRecord(@OOXIXo List<BleMatchRecord> list) {
            BleHandleCallback.DefaultImpls.onReadMatchRecord(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMatchRecord2(@OOXIXo List<BleMatchRecord2> list) {
            BleHandleCallback.DefaultImpls.onReadMatchRecord2(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMedicationAlarm(@OOXIXo List<BleMedicationAlarm> list) {
            BleHandleCallback.DefaultImpls.onReadMedicationAlarm(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMedicationReminder(@OOXIXo List<BleMedicationReminder> list) {
            BleHandleCallback.DefaultImpls.onReadMedicationReminder(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMindStatus(@OOXIXo List<BleMindStatus> list) {
            BleHandleCallback.DefaultImpls.onReadMindStatus(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMtkOtaMeta() {
            BleHandleCallback.DefaultImpls.onReadMtkOtaMeta(this);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNetworkFirmwareVersion(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadNetworkFirmwareVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNoDisturb(@OOXIXo BleNoDisturbSettings bleNoDisturbSettings) {
            BleHandleCallback.DefaultImpls.onReadNoDisturb(this, bleNoDisturbSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNotificationLightScreenSet(int i) {
            BleHandleCallback.DefaultImpls.onReadNotificationLightScreenSet(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNotificationSettings2(@OOXIXo BleNotificationSettings2 bleNotificationSettings2) {
            BleHandleCallback.DefaultImpls.onReadNotificationSettings2(this, bleNotificationSettings2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPackageStatus(@OOXIXo BlePackageStatus blePackageStatus) {
            BleHandleCallback.DefaultImpls.onReadPackageStatus(this, blePackageStatus);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPower(int i) {
            BleHandleCallback.DefaultImpls.onReadPower(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPower2(@OOXIXo BlePower2 blePower2) {
            BleHandleCallback.DefaultImpls.onReadPower2(this, blePower2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPressure(@OOXIXo List<BlePressure> list) {
            BleHandleCallback.DefaultImpls.onReadPressure(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPressureTimingMeasurement(@OOXIXo BlePressureTimingMeasurement blePressureTimingMeasurement) {
            BleHandleCallback.DefaultImpls.onReadPressureTimingMeasurement(this, blePressureTimingMeasurement);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadQiblaSettings(@OOXIXo BleQiblaSettings bleQiblaSettings) {
            BleHandleCallback.DefaultImpls.onReadQiblaSettings(this, bleQiblaSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRelaxReminder(@OOXIXo BleRelaxReminder bleRelaxReminder) {
            BleHandleCallback.DefaultImpls.onReadRelaxReminder(this, bleRelaxReminder);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRespiratoryRate(@OOXIXo List<BleRespiratoryRate> list) {
            BleHandleCallback.DefaultImpls.onReadRespiratoryRate(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRingVibrationSet(@OOXIXo BleRingVibrationSettings bleRingVibrationSettings) {
            BleHandleCallback.DefaultImpls.onReadRingVibrationSet(this, bleRingVibrationSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRri(@OOXIXo List<BleRri> list) {
            BleHandleCallback.DefaultImpls.onReadRri(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSDCardInfo(@OOXIXo BleSDCardInfo bleSDCardInfo) {
            BleHandleCallback.DefaultImpls.onReadSDCardInfo(this, bleSDCardInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSGKeywordAwake(int i) {
            BleHandleCallback.DefaultImpls.onReadSGKeywordAwake(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSGSleepSet(int i) {
            BleHandleCallback.DefaultImpls.onReadSGSleepSet(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSOSSettings(@OOXIXo BleSOSSettings bleSOSSettings) {
            BleHandleCallback.DefaultImpls.onReadSOSSettings(this, bleSOSSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadScreenBrightnessSet(int i) {
            BleHandleCallback.DefaultImpls.onReadScreenBrightnessSet(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSedentariness(@OOXIXo BleSedentarinessSettings bleSedentarinessSettings) {
            BleHandleCallback.DefaultImpls.onReadSedentariness(this, bleSedentarinessSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleep(@OOXIXo List<BleSleep> list) {
            BleHandleCallback.DefaultImpls.onReadSleep(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadSleepGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepQuality(@OOXIXo BleSleepQuality bleSleepQuality) {
            BleHandleCallback.DefaultImpls.onReadSleepQuality(this, bleSleepQuality);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepQualityScore(int i) {
            BleHandleCallback.DefaultImpls.onReadSleepQualityScore(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepRaw(@OOXIXo byte[] bArr) {
            BleHandleCallback.DefaultImpls.onReadSleepRaw(this, bArr);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSosCallLog(@OOXIXo List<BleSosCallLog> list) {
            BleHandleCallback.DefaultImpls.onReadSosCallLog(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSosContact(@OOXIXo BleSosContact bleSosContact) {
            BleHandleCallback.DefaultImpls.onReadSosContact(this, bleSosContact);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSportDurationGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadSportDurationGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadStandbyWatchFaceSet(@OOXIXo BleStandbyWatchFaceSet bleStandbyWatchFaceSet) {
            BleHandleCallback.DefaultImpls.onReadStandbyWatchFaceSet(this, bleStandbyWatchFaceSet);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadStepGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadStepGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadStock(@OOXIXo List<BleStock> list) {
            BleHandleCallback.DefaultImpls.onReadStock(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTemperature(@OOXIXo List<BleTemperature> list) {
            BleHandleCallback.DefaultImpls.onReadTemperature(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTemperatureUnit(int i) {
            BleHandleCallback.DefaultImpls.onReadTemperatureUnit(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTrainingStatus(@OOXIXo List<BleTrainingStatus> list) {
            BleHandleCallback.DefaultImpls.onReadTrainingStatus(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTuyaKey(@OOXIXo BleTuyaKey bleTuyaKey) {
            BleHandleCallback.DefaultImpls.onReadTuyaKey(this, bleTuyaKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadUiPackVersion(@OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadUiPackVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadUnit(int i) {
            BleHandleCallback.DefaultImpls.onReadUnit(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadUserProfile(@OOXIXo BleUserProfile bleUserProfile) {
            BleHandleCallback.DefaultImpls.onReadUserProfile(this, bleUserProfile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadVitalityValue(@OOXIXo List<BleVitality> list) {
            BleHandleCallback.DefaultImpls.onReadVitalityValue(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchFaceId(@OOXIXo BleWatchFaceId bleWatchFaceId) {
            BleHandleCallback.DefaultImpls.onReadWatchFaceId(this, bleWatchFaceId);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchFaceIndex(@OOXIXo BleWatchFaceIndex bleWatchFaceIndex) {
            BleHandleCallback.DefaultImpls.onReadWatchFaceIndex(this, bleWatchFaceIndex);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchFaceSwitch(int i) {
            BleHandleCallback.DefaultImpls.onReadWatchFaceSwitch(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchPassword(@OOXIXo BleSettingWatchPassword bleSettingWatchPassword) {
            BleHandleCallback.DefaultImpls.onReadWatchPassword(this, bleSettingWatchPassword);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWearWayState(int i) {
            BleHandleCallback.DefaultImpls.onReadWearWayState(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWeatherRealTime(boolean z) {
            BleHandleCallback.DefaultImpls.onReadWeatherRealTime(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWorkout(@OOXIXo List<BleWorkout> list) {
            BleHandleCallback.DefaultImpls.onReadWorkout(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWorkout2(@OOXIXo List<BleWorkout2> list) {
            BleHandleCallback.DefaultImpls.onReadWorkout2(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWorkout3(@OOXIXo List<BleWorkout3> list) {
            BleHandleCallback.DefaultImpls.onReadWorkout3(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWorldClock(@OOXIXo List<BleWorldClock> list) {
            BleHandleCallback.DefaultImpls.onReadWorldClock(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onRealTimeMeasurement(@OOXIXo BleRealTimeMeasurement bleRealTimeMeasurement) {
            BleHandleCallback.DefaultImpls.onRealTimeMeasurement(this, bleRealTimeMeasurement);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveFilePacket(@OOXIXo BleReceiveFilePacket bleReceiveFilePacket) {
            BleHandleCallback.DefaultImpls.onReceiveFilePacket(this, bleReceiveFilePacket);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveGSensorMotion(@OOXIXo List<BleGSensorMotion> list) {
            BleHandleCallback.DefaultImpls.onReceiveGSensorMotion(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveGSensorRaw(@OOXIXo List<BleGSensorRaw> list) {
            BleHandleCallback.DefaultImpls.onReceiveGSensorRaw(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveGSensorSHSY(@OOXIXo List<BleGSensorSHSY> list) {
            BleHandleCallback.DefaultImpls.onReceiveGSensorSHSY(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveHRRaw(@OOXIXo List<BleHRRaw> list) {
            BleHandleCallback.DefaultImpls.onReceiveHRRaw(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveLocationGga(@OOXIXo BleLocationGga bleLocationGga) {
            BleHandleCallback.DefaultImpls.onReceiveLocationGga(this, bleLocationGga);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveLocationGsv(@OOXIXo List<BleLocationGsv> list) {
            BleHandleCallback.DefaultImpls.onReceiveLocationGsv(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveMusicCommand(@OOXIXo MusicCommand musicCommand) {
            BleHandleCallback.DefaultImpls.onReceiveMusicCommand(this, musicCommand);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceivePpgSHSY(@OOXIXo List<BlePpgSHSY> list) {
            BleHandleCallback.DefaultImpls.onReceivePpgSHSY(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveRealtimeLog(@OOXIXo BleRealtimeLog bleRealtimeLog) {
            BleHandleCallback.DefaultImpls.onReceiveRealtimeLog(this, bleRealtimeLog);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveRecordPacket(@OOXIXo BleRecordPacket bleRecordPacket) {
            BleHandleCallback.DefaultImpls.onReceiveRecordPacket(this, bleRecordPacket);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onRequestAgpsPrerequisite() {
            BleHandleCallback.DefaultImpls.onRequestAgpsPrerequisite(this);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onRequestLocation(int i) {
            BleHandleCallback.DefaultImpls.onRequestLocation(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onRingVibrationSetUpdate(@OOXIXo BleRingVibrationSettings bleRingVibrationSettings) {
            BleHandleCallback.DefaultImpls.onRingVibrationSetUpdate(this, bleRingVibrationSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSDCardInfoUpdate(@OOXIXo BleSDCardInfo bleSDCardInfo) {
            BleHandleCallback.DefaultImpls.onSDCardInfoUpdate(this, bleSDCardInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSGTestUpdate(@OOXIXo BleSGTest bleSGTest) {
            BleHandleCallback.DefaultImpls.onSGTestUpdate(this, bleSGTest);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSOSSettingsUpdate(@OOXIXo BleSOSSettings bleSOSSettings) {
            BleHandleCallback.DefaultImpls.onSOSSettingsUpdate(this, bleSOSSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onScreenBrightnessSetUpdate(int i) {
            BleHandleCallback.DefaultImpls.onScreenBrightnessSetUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSessionStateChange(boolean z) {
            BleHandleCallback.DefaultImpls.onSessionStateChange(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSosContactUpdate(@OOXIXo BleSosContact bleSosContact) {
            BleHandleCallback.DefaultImpls.onSosContactUpdate(this, bleSosContact);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSportEndNotifyUpdate(int i) {
            BleHandleCallback.DefaultImpls.onSportEndNotifyUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onStandbyWatchFaceSetUpdate(@OOXIXo BleStandbyWatchFaceSet bleStandbyWatchFaceSet) {
            BleHandleCallback.DefaultImpls.onStandbyWatchFaceSetUpdate(this, bleStandbyWatchFaceSet);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onStepGoalUpdate(int i) {
            BleHandleCallback.DefaultImpls.onStepGoalUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onStockDelete(int i) {
            BleHandleCallback.DefaultImpls.onStockDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onStreamProgress(boolean z, int i, int i2, int i3, @OOXIXo BleKey bleKey) {
            BleHandleCallback.DefaultImpls.onStreamProgress(this, z, i, i2, i3, bleKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSyncData(int i, @OOXIXo BleKey bleKey) {
            BleHandleCallback.DefaultImpls.onSyncData(this, i, bleKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onTimeUpdate() {
            BleHandleCallback.DefaultImpls.onTimeUpdate(this);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateAppSportState(@OOXIXo BleAppSportState bleAppSportState) {
            BleHandleCallback.DefaultImpls.onUpdateAppSportState(this, bleAppSportState);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateBAC(@OOXIXo BleBAC bleBAC) {
            BleHandleCallback.DefaultImpls.onUpdateBAC(this, bleBAC);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateBloodPressure(@OOXIXo BleBloodPressure bleBloodPressure) {
            BleHandleCallback.DefaultImpls.onUpdateBloodPressure(this, bleBloodPressure);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateHeartRate(@OOXIXo BleHeartRate bleHeartRate) {
            BleHandleCallback.DefaultImpls.onUpdateHeartRate(this, bleHeartRate);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateTemperature(@OOXIXo BleTemperature bleTemperature) {
            BleHandleCallback.DefaultImpls.onUpdateTemperature(this, bleTemperature);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateWatchFaceSwitch(boolean z) {
            BleHandleCallback.DefaultImpls.onUpdateWatchFaceSwitch(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUserProfileUpdate(@OOXIXo BleUserProfile bleUserProfile) {
            BleHandleCallback.DefaultImpls.onUserProfileUpdate(this, bleUserProfile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onVibrationUpdate(int i) {
            BleHandleCallback.DefaultImpls.onVibrationUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWatchFaceIdUpdate(boolean z) {
            BleHandleCallback.DefaultImpls.onWatchFaceIdUpdate(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWatchFaceIndexCreate(boolean z) {
            BleHandleCallback.DefaultImpls.onWatchFaceIndexCreate(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWatchFaceIndexUpdate(@OOXIXo BleWatchFaceIndex bleWatchFaceIndex) {
            BleHandleCallback.DefaultImpls.onWatchFaceIndexUpdate(this, bleWatchFaceIndex);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWatchPasswordUpdate(@OOXIXo BleSettingWatchPassword bleSettingWatchPassword) {
            BleHandleCallback.DefaultImpls.onWatchPasswordUpdate(this, bleSettingWatchPassword);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWearWayUpdate(int i) {
            BleHandleCallback.DefaultImpls.onWearWayUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWorldClockDelete(int i) {
            BleHandleCallback.DefaultImpls.onWorldClockDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onXModem(byte b) {
            BleHandleCallback.DefaultImpls.onXModem(this, b);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadStock(boolean z) {
            BleHandleCallback.DefaultImpls.onReadStock(this, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addGroupHead() {
        DslAdapterExKt.oO(getDslAdapter(), R.layout.ai_plan_item_group_head, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.AiCoachFragment$addGroupHead$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                invoke2(dslAdapterItem);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo DslAdapterItem dslItem) {
                String str;
                IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                dslItem.setItemIsGroupHead(true);
                str = AiCoachFragment.this.ITEM_GROUPS_TAG;
                dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(str));
                dslItem.setItemIsHover(false);
                final AiCoachFragment aiCoachFragment = AiCoachFragment.this;
                dslItem.setItemBindOverride(new Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.AiCoachFragment$addGroupHead$1.1
                    {
                        super(4);
                    }

                    @Override // Oox.Oxx0xo
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                        invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    public final void invoke(@OOXIXo DslViewHolder itemHolder, int i, @OOXIXo DslAdapterItem adapterItem, @OOXIXo List<? extends Object> list) {
                        IIX0o.x0xO0oo(itemHolder, "itemHolder");
                        IIX0o.x0xO0oo(adapterItem, "adapterItem");
                        IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                        View v = itemHolder.v(R.id.plan_week_tv);
                        IIX0o.ooOOo0oXI(v);
                        final TextView textView = (TextView) v;
                        View v2 = itemHolder.v(R.id.view_pager);
                        IIX0o.ooOOo0oXI(v2);
                        final ViewPager2 viewPager2 = (ViewPager2) v2;
                        List<AICoachManage.PlanGroupTitle> Oo2 = AICoachManage.f23905XO.oIX0oI().Oo();
                        final List OxXXx0X2 = Oo2 != null ? CollectionsKt___CollectionsKt.OxXXx0X(Oo2, 7) : null;
                        viewPager2.setOffscreenPageLimit(-1);
                        StringBuilder sb = new StringBuilder();
                        sb.append(AiCoachFragment.this.getString(R.string.week));
                        sb.append(" (");
                        sb.append(viewPager2.getCurrentItem() + 1);
                        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                        IIX0o.ooOOo0oXI(OxXXx0X2);
                        sb.append(OxXXx0X2.size());
                        sb.append(HexStringBuilder.COMMENT_END_CHAR);
                        textView.setText(sb.toString());
                        Context context = AiCoachFragment.this.getContext();
                        final AiCoachFragment aiCoachFragment2 = AiCoachFragment.this;
                        viewPager2.setAdapter(new CommonAdapter<List<? extends AICoachManage.PlanGroupTitle>>(OxXXx0X2, context) { // from class: com.sma.smartv3.ui.sport.coach.AiCoachFragment.addGroupHead.1.1.1
                            @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
                            public /* bridge */ /* synthetic */ void convert(ViewHolder viewHolder, List<? extends AICoachManage.PlanGroupTitle> list2, int i2) {
                                convert2(viewHolder, (List<AICoachManage.PlanGroupTitle>) list2, i2);
                            }

                            /* renamed from: convert, reason: avoid collision after fix types in other method */
                            public void convert2(@OOXIXo ViewHolder itemHolder2, @OOXIXo List<AICoachManage.PlanGroupTitle> time, int i2) {
                                IIX0o.x0xO0oo(itemHolder2, "itemHolder");
                                IIX0o.x0xO0oo(time, "time");
                                aiCoachFragment2.addRecyclerView(itemHolder2, time, viewPager2);
                            }
                        });
                        viewPager2.setCurrentItem(AiCoachFragment.this.getMCurrentItem());
                        final AiCoachFragment aiCoachFragment3 = AiCoachFragment.this;
                        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.sma.smartv3.ui.sport.coach.AiCoachFragment.addGroupHead.1.1.2
                            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                            public void onPageScrollStateChanged(int i2) {
                            }

                            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                            public void onPageScrolled(int i2, float f, int i3) {
                            }

                            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                            public void onPageSelected(int i2) {
                                textView.setText(aiCoachFragment3.getString(R.string.week) + " (" + (viewPager2.getCurrentItem() + 1) + IOUtils.DIR_SEPARATOR_UNIX + OxXXx0X2.size() + HexStringBuilder.COMMENT_END_CHAR);
                            }
                        });
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addRecyclerView(ViewHolder viewHolder, List<AICoachManage.PlanGroupTitle> list, ViewPager2 viewPager2) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = list;
        View view = viewHolder.getView(R.id.ai_plan_item_group_head_recycle);
        IIX0o.ooOOo0oXI(view);
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new CommonDecoration(getMActivity(), 0, getMActivity().getResources().getColor(R.color.transparent), 32));
        }
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 7));
        AiCoachFragment$addRecyclerView$adapter$1 aiCoachFragment$addRecyclerView$adapter$1 = new AiCoachFragment$addRecyclerView$adapter$1(objectRef, this, getContext());
        recyclerView.setAdapter(aiCoachFragment$addRecyclerView$adapter$1);
        this.mListAdapter.add(aiCoachFragment$addRecyclerView$adapter$1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefresh$lambda$0(AiCoachFragment this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        AICoachManage.f23905XO.oIX0oI().ooOOo0oXI(0);
        this$0.getRefreshLayout().setRefreshing(false);
    }

    private final void setCurSelected() {
        AICoachManage.PlanGroupTitle planGroupTitle;
        Object obj;
        List<AICoachManage.PlanGroupTitle> Oo2 = AICoachManage.f23905XO.oIX0oI().Oo();
        AICoachManage.PlanGroupTitle planGroupTitle2 = null;
        if (Oo2 != null) {
            Iterator<T> it = Oo2.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    AICoachManage.PlanGroupTitle planGroupTitle3 = (AICoachManage.PlanGroupTitle) obj;
                    if (planGroupTitle3.getMLessonIndex() != -1 && !planGroupTitle3.isCompleted() && AICoachManage.f23905XO.oIX0oI().oI0IIXIo().getDailySchedule().get(planGroupTitle3.getMLessonIndex() % 7).intValue() == 1) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            planGroupTitle = (AICoachManage.PlanGroupTitle) obj;
        } else {
            planGroupTitle = null;
        }
        if (planGroupTitle != null) {
            AICoachManage.oIX0oI oix0oi = AICoachManage.f23905XO;
            List<AICoachManage.PlanGroupTitle> Oo3 = oix0oi.oIX0oI().Oo();
            IIX0o.ooOOo0oXI(Oo3);
            int indexOf = Oo3.indexOf(planGroupTitle);
            if (indexOf <= 7) {
                this.curPosition = indexOf % 7;
                this.curTimeDay = planGroupTitle.getTimeDay();
                this.curDataPosition = planGroupTitle.getMLessonIndex();
                this.mCurrentItem = indexOf / 7;
                return;
            }
            List<AICoachManage.PlanGroupTitle> Oo4 = oix0oi.oIX0oI().Oo();
            if (Oo4 != null) {
                planGroupTitle2 = (AICoachManage.PlanGroupTitle) CollectionsKt___CollectionsKt.O0OOX0IIx(Oo4);
            }
            if (planGroupTitle2 != null) {
                this.curTimeDay = planGroupTitle2.getTimeDay();
                this.mCurrentItem = 0;
                this.curPosition = 0;
                this.curDataPosition = -1;
            }
        }
    }

    private final void showData() {
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.AiCoachFragment$showData$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo final DslAdapter renderAdapter) {
                IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                renderAdapter.clearAllItems();
                DslAdapter.setAdapterStatus$default(renderAdapter, 2, null, 2, null);
                DslViewHolder dslViewHolder = AiCoachFragment.this.getDslViewHolder();
                final AiCoachFragment aiCoachFragment = AiCoachFragment.this;
                dslViewHolder.postDelay(100L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.AiCoachFragment$showData$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                        invoke2();
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:
                    
                        if (r0.getPlanTarget() == 0.0f) goto L13;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void invoke2() {
                        /*
                            r10 = this;
                            com.sma.smartv3.ui.sport.coach.AiCoachFragment r0 = com.sma.smartv3.ui.sport.coach.AiCoachFragment.this
                            com.sma.smartv3.ui.sport.coach.AICoachManage$VitalityData r0 = com.sma.smartv3.ui.sport.coach.AiCoachFragment.access$getMVitalityData$p(r0)
                            r1 = 2
                            r2 = 0
                            if (r0 == 0) goto L57
                            com.sma.smartv3.ui.sport.coach.AiCoachFragment r0 = com.sma.smartv3.ui.sport.coach.AiCoachFragment.this
                            com.sma.smartv3.ui.sport.coach.AICoachManage$VitalityData r0 = com.sma.smartv3.ui.sport.coach.AiCoachFragment.access$getMVitalityData$p(r0)
                            if (r0 == 0) goto L25
                            com.sma.smartv3.ui.sport.coach.AiCoachFragment r0 = com.sma.smartv3.ui.sport.coach.AiCoachFragment.this
                            com.sma.smartv3.ui.sport.coach.AICoachManage$VitalityData r0 = com.sma.smartv3.ui.sport.coach.AiCoachFragment.access$getMVitalityData$p(r0)
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
                            float r0 = r0.getPlanTarget()
                            r3 = 0
                            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                            if (r0 != 0) goto L25
                            goto L57
                        L25:
                            com.angcyo.dsladapter.DslAdapter r0 = r2
                            com.sma.smartv3.ui.sport.coach.item.PlanDetailItem r3 = new com.sma.smartv3.ui.sport.coach.item.PlanDetailItem
                            r3.<init>()
                            com.angcyo.dsladapter.DslAdapterExKt.IXxxXO(r0, r3, r2, r1, r2)
                            com.sma.smartv3.ui.sport.coach.AICoachManage$oIX0oI r0 = com.sma.smartv3.ui.sport.coach.AICoachManage.f23905XO
                            com.sma.smartv3.ui.sport.coach.AICoachManage r0 = r0.oIX0oI()
                            com.sma.smartv3.ui.sport.coach.AICoachManage$VitalityData r0 = r0.oI0IIXIo()
                            int r0 = r0.getMProgress()
                            r3 = 100
                            if (r0 != r3) goto L4c
                            com.angcyo.dsladapter.DslAdapter r0 = r2
                            com.sma.smartv3.ui.sport.coach.item.CompletePlanItem r3 = new com.sma.smartv3.ui.sport.coach.item.CompletePlanItem
                            r3.<init>()
                            com.angcyo.dsladapter.DslAdapterExKt.IXxxXO(r0, r3, r2, r1, r2)
                            goto Lab
                        L4c:
                            com.sma.smartv3.ui.sport.coach.AiCoachFragment r0 = com.sma.smartv3.ui.sport.coach.AiCoachFragment.this
                            com.sma.smartv3.ui.sport.coach.AiCoachFragment.access$addGroupHead(r0)
                            com.sma.smartv3.ui.sport.coach.AiCoachFragment r0 = com.sma.smartv3.ui.sport.coach.AiCoachFragment.this
                            com.sma.smartv3.ui.sport.coach.AiCoachFragment.access$showPlanFunction(r0)
                            goto Lab
                        L57:
                            com.sma.smartv3.network.Api r0 = com.sma.smartv3.network.Api.INSTANCE
                            java.lang.String r0 = r0.getBASE_URL()
                            java.lang.String r3 = "https://dev.iot-solution.net/kotlinweb"
                            boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r3)
                            if (r0 == 0) goto L70
                            com.angcyo.dsladapter.DslAdapter r0 = r2
                            com.sma.smartv3.ui.sport.coach.item.LackPlanItem r3 = new com.sma.smartv3.ui.sport.coach.item.LackPlanItem
                            r3.<init>()
                            com.angcyo.dsladapter.DslAdapterExKt.IXxxXO(r0, r3, r2, r1, r2)
                            goto Lab
                        L70:
                            com.sma.smartv3.ui.sport.coach.AICoachManage$oIX0oI r0 = com.sma.smartv3.ui.sport.coach.AICoachManage.f23905XO
                            com.sma.smartv3.ui.sport.coach.AICoachManage r3 = r0.oIX0oI()
                            com.sma.smartv3.ui.sport.coach.AICoachManage$VitalityData r3 = r3.oI0IIXIo()
                            com.szabh.smable3.entity.BleAICoachBeforePlan r3 = r3.getMBeforePlanInfo()
                            if (r3 == 0) goto La1
                            com.sma.smartv3.ui.sport.coach.AICoachManage r0 = r0.oIX0oI()
                            com.sma.smartv3.ui.sport.coach.AICoachManage$VitalityData r0 = r0.oI0IIXIo()
                            com.szabh.smable3.entity.BleAICoachBeforePlan r0 = r0.getMBeforePlanInfo()
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
                            int r0 = r0.getMDayMET()
                            r3 = 3
                            if (r0 < r3) goto La1
                            com.angcyo.dsladapter.DslAdapter r0 = r2
                            com.sma.smartv3.ui.sport.coach.item.LackPlanItem r3 = new com.sma.smartv3.ui.sport.coach.item.LackPlanItem
                            r3.<init>()
                            com.angcyo.dsladapter.DslAdapterExKt.IXxxXO(r0, r3, r2, r1, r2)
                            goto Lab
                        La1:
                            com.angcyo.dsladapter.DslAdapter r0 = r2
                            com.sma.smartv3.ui.sport.coach.item.PlanConstrainedItem r3 = new com.sma.smartv3.ui.sport.coach.item.PlanConstrainedItem
                            r3.<init>()
                            com.angcyo.dsladapter.DslAdapterExKt.IXxxXO(r0, r3, r2, r1, r2)
                        Lab:
                            com.angcyo.dsladapter.DslAdapter r4 = r2
                            com.sma.smartv3.ui.sport.coach.AiCoachFragment$showData$1$1$1 r7 = new Oox.oOoXoXO<com.angcyo.dsladapter.DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.AiCoachFragment.showData.1.1.1
                                static {
                                    /*
                                        com.sma.smartv3.ui.sport.coach.AiCoachFragment$showData$1$1$1 r0 = new com.sma.smartv3.ui.sport.coach.AiCoachFragment$showData$1$1$1
                                        r0.<init>()
                                        
                                        // error: 0x0005: SPUT (r0 I:com.sma.smartv3.ui.sport.coach.AiCoachFragment$showData$1$1$1) com.sma.smartv3.ui.sport.coach.AiCoachFragment.showData.1.1.1.INSTANCE com.sma.smartv3.ui.sport.coach.AiCoachFragment$showData$1$1$1
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.sport.coach.AiCoachFragment$showData$1.AnonymousClass1.C10041.<clinit>():void");
                                }

                                {
                                    /*
                                        r1 = this;
                                        r0 = 1
                                        r1.<init>(r0)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.sport.coach.AiCoachFragment$showData$1.AnonymousClass1.C10041.<init>():void");
                                }

                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(com.angcyo.dsladapter.DslAdapter r1) {
                                    /*
                                        r0 = this;
                                        com.angcyo.dsladapter.DslAdapter r1 = (com.angcyo.dsladapter.DslAdapter) r1
                                        r0.invoke2(r1)
                                        kotlin.oXIO0o0XI r1 = kotlin.oXIO0o0XI.f29392oIX0oI
                                        return r1
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.sport.coach.AiCoachFragment$showData$1.AnonymousClass1.C10041.invoke(java.lang.Object):java.lang.Object");
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OXOo.OOXIXo com.angcyo.dsladapter.DslAdapter r4) {
                                    /*
                                        r3 = this;
                                        java.lang.String r0 = "$this$render"
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
                                        r0 = 0
                                        r1 = 2
                                        r2 = 0
                                        com.angcyo.dsladapter.DslAdapter.setAdapterStatus$default(r4, r2, r0, r1, r0)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.sport.coach.AiCoachFragment$showData$1.AnonymousClass1.C10041.invoke2(com.angcyo.dsladapter.DslAdapter):void");
                                }
                            }
                            r8 = 3
                            r9 = 0
                            r5 = 0
                            r6 = 0
                            com.angcyo.dsladapter.DslAdapter.render$default(r4, r5, r6, r7, r8, r9)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.sport.coach.AiCoachFragment$showData$1.AnonymousClass1.invoke2():void");
                    }
                });
            }
        });
    }

    private final void showDeletePopup() {
        int i;
        FragmentActivity requireActivity = requireActivity();
        IIX0o.oO(requireActivity, "requireActivity(...)");
        XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(requireActivity, 0, 2, null);
        xoI0Ixx0.IoOoX(R.string.plan_delete_tip_title);
        StringBuilder sb = new StringBuilder();
        AICoachManage.VitalityData vitalityData = this.mVitalityData;
        if (vitalityData != null) {
            i = vitalityData.getMProgress();
        } else {
            i = 0;
        }
        sb.append(i);
        sb.append(x0XOIxOo.f33309xxIXOIIO);
        xoI0Ixx0.oo(getString(R.string.plan_delete_tip, sb.toString()));
        xoI0Ixx0.x0xO0oo(false);
        xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.cancel), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.sport.coach.AiCoachFragment$showDeletePopup$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        });
        xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.sport.coach.AiCoachFragment$showDeletePopup$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final Boolean invoke() {
                AICoachManage.f23905XO.oIX0oI().II0XooXoX();
                return Boolean.TRUE;
            }
        });
        this.mDeleteWindow = xoI0Ixx0;
        xoI0Ixx0.IIXOooo();
    }

    private final void showExtensionPopup() {
        FragmentActivity requireActivity = requireActivity();
        IIX0o.oO(requireActivity, "requireActivity(...)");
        final XoI0Ixx0 xoI0Ixx0 = new XoI0Ixx0(requireActivity, 0, 2, null);
        xoI0Ixx0.IoOoX(R.string.plan_expired_tip_title);
        xoI0Ixx0.xI(Integer.valueOf(R.string.plan_expired_tip));
        xoI0Ixx0.x0xO0oo(false);
        xoI0Ixx0.X00IoxXI(Integer.valueOf(R.string.terminate_plan), new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.sport.coach.AiCoachFragment$showExtensionPopup$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final Boolean invoke() {
                x0xO0oo.II0xO0(x0xO0oo.f24617XXoOx0, null, 2, null);
                return Boolean.TRUE;
            }
        });
        xoI0Ixx0.x0o(R.string.plan_expired_sure, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.sport.coach.AiCoachFragment$showExtensionPopup$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OOXIXo
            public final Boolean invoke() {
                AiCoachFragment.this.startActivity(new Intent(xoI0Ixx0.Oxx0IOOO(), (Class<?>) CreatePlanActivity.class));
                return Boolean.TRUE;
            }
        });
        this.mExtensionWindow = xoI0Ixx0;
        xoI0Ixx0.IIXOooo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPlanFunction() {
        AICoachManage.VitalityLesson vitalityLesson;
        List<AICoachManage.VitalityDayLesson> dayLesson;
        if (this.curDataPosition != -1 && !this.isReachedTarget) {
            List<AICoachManage.VitalityLesson> mVitalityDayLesson = AICoachManage.f23905XO.oIX0oI().oI0IIXIo().getMVitalityDayLesson();
            if (mVitalityDayLesson != null && (vitalityLesson = mVitalityDayLesson.get(this.curDataPosition % 7)) != null && (dayLesson = vitalityLesson.getDayLesson()) != null) {
                for (final AICoachManage.VitalityDayLesson vitalityDayLesson : dayLesson) {
                    DslAdapterExKt.x0xO0oo(getDslAdapter(), new PlanContentItem(vitalityDayLesson, false, 2, null), new Oox.oOoXoXO<PlanContentItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.AiCoachFragment$showPlanFunction$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PlanContentItem planContentItem) {
                            invoke2(planContentItem);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OOXIXo PlanContentItem dslItem) {
                            String str;
                            IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                            str = AiCoachFragment.this.ITEM_GROUPS_TAG;
                            dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(str));
                            final AiCoachFragment aiCoachFragment = AiCoachFragment.this;
                            final AICoachManage.VitalityDayLesson vitalityDayLesson2 = vitalityDayLesson;
                            dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.AiCoachFragment$showPlanFunction$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view) {
                                    invoke2(view);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OOXIXo View it) {
                                    IIX0o.x0xO0oo(it, "it");
                                    AiCoachFragment aiCoachFragment2 = AiCoachFragment.this;
                                    AICoachManage.VitalityDayLesson vitalityDayLesson3 = vitalityDayLesson2;
                                    Bundle bundle = new Bundle();
                                    bundle.putString("mArg0", null);
                                    bundle.putParcelable("mArg2", null);
                                    bundle.putSerializable("mArg3", vitalityDayLesson3);
                                    Intent intent = new Intent(aiCoachFragment2.getActivity(), (Class<?>) CoachPlanDetailActivity.class);
                                    intent.putExtras(bundle);
                                    aiCoachFragment2.startActivity(intent);
                                }
                            });
                        }
                    });
                }
                return;
            }
            return;
        }
        DslAdapterExKt.x0xO0oo(getDslAdapter(), new PlanContentItem(new AICoachManage.VitalityDayLesson(0, null, null, 0, 0, 0.0f, null, 127, null), this.isReachedTarget), new Oox.oOoXoXO<PlanContentItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.coach.AiCoachFragment$showPlanFunction$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(PlanContentItem planContentItem) {
                invoke2(planContentItem);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo PlanContentItem dslItem) {
                String str;
                IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                str = AiCoachFragment.this.ITEM_GROUPS_TAG;
                dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(str));
            }
        });
    }

    public final int getMCurrentItem() {
        return this.mCurrentItem;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
        BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        AICoachManage.VitalityData vitalityData = (AICoachManage.VitalityData) new Gson().fromJson(XO2.getString(com.sma.smartv3.util.XoI0Ixx0.f24387OIx00oxx + '_' + AICoachManage.VitalityData.class.getName()), AICoachManage.VitalityData.class);
        this.mVitalityData = vitalityData;
        if (vitalityData != null) {
            AICoachManage.oIX0oI oix0oi = AICoachManage.f23905XO;
            AICoachManage oIX0oI2 = oix0oi.oIX0oI();
            AICoachManage.VitalityData vitalityData2 = this.mVitalityData;
            IIX0o.ooOOo0oXI(vitalityData2);
            oIX0oI2.XxX0x0xxx(vitalityData2);
            oix0oi.oIX0oI().IXxxXO();
            setCurSelected();
            AICoachManage oIX0oI3 = oix0oi.oIX0oI();
            AICoachManage.VitalityData vitalityData3 = this.mVitalityData;
            IIX0o.ooOOo0oXI(vitalityData3);
            if (AICoachManage.xoIox(oIX0oI3, vitalityData3.getStartTime(), 0, 2, null)) {
                showExtensionPopup();
            }
        }
        AICoachManage.f23905XO.oIX0oI().ooOOo0oXI(0);
    }

    public final boolean isReachedTarget() {
        return this.isReachedTarget;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.ai_coach_fragment_rv;
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BleConnector.INSTANCE.removeHandleCallback(this.mBleHandleCallback);
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getActivity()));
        if (this.isAddItemDecoration) {
            this.isAddItemDecoration = false;
            getRecyclerView().addItemDecoration(new CommonDecoration(getActivity(), 1, getResources().getColor(R.color.transparent), 16));
        }
        showData();
    }

    @XO0.XO(tag = x0xO0oo.f24647x0OIX00oO)
    public final void onPlanCreateChanged(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        AICoachManage.VitalityData vitalityData = (AICoachManage.VitalityData) new Gson().fromJson(XO2.getString(com.sma.smartv3.util.XoI0Ixx0.f24387OIx00oxx + '_' + AICoachManage.VitalityData.class.getName()), AICoachManage.VitalityData.class);
        this.mVitalityData = vitalityData;
        if (vitalityData != null) {
            AICoachManage.oIX0oI oix0oi = AICoachManage.f23905XO;
            AICoachManage oIX0oI2 = oix0oi.oIX0oI();
            AICoachManage.VitalityData vitalityData2 = this.mVitalityData;
            IIX0o.ooOOo0oXI(vitalityData2);
            oIX0oI2.XxX0x0xxx(vitalityData2);
            oix0oi.oIX0oI().IXxxXO();
            setCurSelected();
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " AICoachManage data = " + this.mVitalityData);
        showData();
    }

    @XO0.XO(tag = x0xO0oo.f24617XXoOx0)
    public final void onPlanDelete(@OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        XoI0Ixx0 xoI0Ixx0 = this.mDeleteWindow;
        if (xoI0Ixx0 != null) {
            xoI0Ixx0.dismiss();
        }
        showDeletePopup();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public void onRefresh() {
        super.onRefresh();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.sport.coach.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                AiCoachFragment.onRefresh$lambda$0(AiCoachFragment.this);
            }
        }, 1000L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getDslAdapter().notifyDataSetChanged();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int refreshLayoutId() {
        return R.id.srf;
    }

    public final void setMCurrentItem(int i) {
        this.mCurrentItem = i;
    }

    public final void setReachedTarget(boolean z) {
        this.isReachedTarget = z;
    }
}
