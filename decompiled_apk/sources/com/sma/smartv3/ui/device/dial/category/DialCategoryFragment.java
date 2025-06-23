package com.sma.smartv3.ui.device.dial.category;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.Oxx0xo;
import XO0.XO;
import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslAdapterStatusItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragmentKt;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.smartv3.biz.DeviceInfoChecker;
import com.sma.smartv3.biz.StatManager;
import com.sma.smartv3.ble.I0Io;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.dsl.AdapterStatusItem;
import com.sma.smartv3.initializer.AGPSInitializer;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.OnlineWatchFaceKt;
import com.sma.smartv3.model.SyncStatus;
import com.sma.smartv3.model.WatchFaceCategory;
import com.sma.smartv3.model.WatchFaceInfo;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.ui.device.dial.DialActivity;
import com.sma.smartv3.ui.device.dial.DialPickerPopup;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.oO;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.ProgressButton;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
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
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nDialCategoryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DialCategoryFragment.kt\ncom/sma/smartv3/ui/device/dial/category/DialCategoryFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,429:1\n90#2:430\n*S KotlinDebug\n*F\n+ 1 DialCategoryFragment.kt\ncom/sma/smartv3/ui/device/dial/category/DialCategoryFragment\n*L\n184#1:430\n*E\n"})
/* loaded from: classes12.dex */
public final class DialCategoryFragment extends BaseDSLRecyclerFragment {

    @oOoXoXO
    private DialPickerPopup dialPickerPopup;
    private String mBinFileName;

    @oOoXoXO
    private WatchFaceCategory[] mCategorys;
    private int mCurSyncCompleted;
    private int mCurSyncDevicePosition;
    private int mCurSyncDialId;
    private int mCurSyncPosition;
    private int mCurSyncTotal;

    @OOXIXo
    private final List<Integer> mDialIds = CollectionsKt__CollectionsKt.XOxIOxOx(0);

    @OOXIXo
    private SyncStatus mCurSyncStatus = SyncStatus.NO_SYNC;

    @OOXIXo
    private final II0xO0 mBleHandleCallback = new II0xO0();

    @XX({"SMAP\nDialCategoryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DialCategoryFragment.kt\ncom/sma/smartv3/ui/device/dial/category/DialCategoryFragment$mBleHandleCallback$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,429:1\n1855#2,2:430\n*S KotlinDebug\n*F\n+ 1 DialCategoryFragment.kt\ncom/sma/smartv3/ui/device/dial/category/DialCategoryFragment$mBleHandleCallback$1\n*L\n162#1:430,2\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class II0xO0 implements BleHandleCallback {
        public II0xO0() {
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
            IIX0o.x0xO0oo(bleKey, "bleKey");
            IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
            if (bleKey == BleKey.WATCH_FACE) {
                DialCategoryFragment.this.mCurSyncStatus = SyncStatus.FAILED;
                ToastUtils.showLong(oO.f24511oIX0oI.oIX0oI(0), new Object[0]);
                DialCategoryFragment.this.getDslAdapter().notifyDataSetChanged();
            }
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
        public void onReadAICoachGenerateBeforeInfo(@OOXIXo BleAICoachBeforePlan bleAICoachBeforePlan) {
            BleHandleCallback.DefaultImpls.onReadAICoachGenerateBeforeInfo(this, bleAICoachBeforePlan);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAICoachPlan(@OOXIXo BleAICoachGeneratePlan bleAICoachGeneratePlan) {
            BleHandleCallback.DefaultImpls.onReadAICoachPlan(this, bleAICoachGeneratePlan);
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
        public void onReadWatchFaceId(@OOXIXo BleWatchFaceId watchFaceId) {
            IIX0o.x0xO0oo(watchFaceId, "watchFaceId");
            DialCategoryFragment.this.mDialIds.clear();
            List<Integer> mIdList = watchFaceId.getMIdList();
            DialCategoryFragment dialCategoryFragment = DialCategoryFragment.this;
            Iterator<T> it = mIdList.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                if (intValue <= 0) {
                    dialCategoryFragment.mDialIds.add(0);
                } else {
                    dialCategoryFragment.mDialIds.add(Integer.valueOf(intValue));
                }
            }
            LogUtils.d("mDialIds -> " + DialCategoryFragment.this.mDialIds);
            DialCategoryFragment.this.getDslAdapter().notifyDataSetChanged();
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
            LogUtils.d("prog error onSessionStateChange " + z);
            if (DialCategoryFragment.this.mCurSyncDialId != 0 && DialCategoryFragment.this.mCurSyncStatus == SyncStatus.SYNCING) {
                DialCategoryFragment.this.mCurSyncStatus = SyncStatus.FAILED;
            }
            DialCategoryFragment.this.getDslAdapter().notifyDataSetChanged();
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
            IIX0o.x0xO0oo(bleKey, "bleKey");
            if (bleKey != BleKey.WATCH_FACE) {
                return;
            }
            if (z) {
                DialCategoryFragment.this.mCurSyncStatus = SyncStatus.SYNCING;
                BleInitializer bleInitializer = BleInitializer.f20700XO;
                bleInitializer.IXO(true);
                if (i2 == i3) {
                    DialCategoryFragment.this.mCurSyncStatus = SyncStatus.SYNCED;
                    x0xO0oo.II0xO0(x0xO0oo.f24584O00XxXI, null, 2, null);
                    DialCategoryFragment.this.mDialIds.set(DialCategoryFragment.this.mCurSyncDevicePosition, Integer.valueOf(DialCategoryFragment.this.mCurSyncDialId));
                    if (!ProductManager.f20544oIX0oI.OOoOoO0o()) {
                        Xo0.f24349oIX0oI.II0xO0().put("syncId", DialCategoryFragment.this.mCurSyncDialId);
                    }
                    DialCategoryFragment.this.getDslAdapter().notifyDataSetChanged();
                    bleInitializer.IXO(false);
                }
            } else {
                DialCategoryFragment.this.mCurSyncStatus = SyncStatus.FAILED;
                ToastUtils.showLong(oO.f24511oIX0oI.I0Io(i), new Object[0]);
                BleInitializer.f20700XO.IXO(false);
                DialCategoryFragment.this.mDialIds.set(DialCategoryFragment.this.mCurSyncDevicePosition, 0);
                if (!ProductManager.f20544oIX0oI.OOoOoO0o()) {
                    Xo0.f24349oIX0oI.II0xO0().put("syncId", 0);
                }
            }
            DialCategoryFragment.this.mCurSyncTotal = i2;
            DialCategoryFragment.this.mCurSyncCompleted = i3;
            DialCategoryFragment.this.getDslAdapter().notifyItemChanged(DialCategoryFragment.this.mCurSyncPosition, Integer.valueOf(DialCategoryFragment.this.mCurSyncDialId));
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
            if (DialCategoryFragment.this.isResumed()) {
                BleConnector bleConnector = BleConnector.INSTANCE;
                BleKey bleKey = BleKey.WATCH_FACE;
                X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                String str = DialCategoryFragment.this.mBinFileName;
                if (str == null) {
                    IIX0o.XOxIOxOx("mBinFileName");
                    str = null;
                }
                bleConnector.sendStream(bleKey, IXxxXO.X0o0xo(oix0oi, str), DialCategoryFragment.this.mCurSyncDevicePosition);
                ProductManager.f20544oIX0oI.xOIO();
            }
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

    /* loaded from: classes12.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f22328oIX0oI;

        static {
            int[] iArr = new int[SyncStatus.values().length];
            try {
                iArr[SyncStatus.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SyncStatus.NO_SYNC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SyncStatus.SYNCING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SyncStatus.SYNCED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f22328oIX0oI = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doItem(WatchFaceCategory[] watchFaceCategoryArr) {
        for (final WatchFaceCategory watchFaceCategory : watchFaceCategoryArr) {
            DslAdapterExKt.oO(getDslAdapter(), R.layout.layout_online_watchface_category_head, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$doItem$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                    dslItem.setItemIsGroupHead(true);
                    dslItem.setItemIsHover(false);
                    dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(WatchFaceCategory.this.getDir()));
                    final DialCategoryFragment dialCategoryFragment = this;
                    final WatchFaceCategory watchFaceCategory2 = WatchFaceCategory.this;
                    dslItem.setItemBindOverride(new Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$doItem$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        @Override // Oox.Oxx0xo
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                            invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(@OOXIXo DslViewHolder itemHolder, int i, @OOXIXo DslAdapterItem dslAdapterItem, @OOXIXo List<? extends Object> list) {
                            Activity mActivity;
                            IIX0o.x0xO0oo(itemHolder, "itemHolder");
                            IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                            IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                            TextView tv = itemHolder.tv(R.id.tv_name);
                            if (tv == null) {
                                return;
                            }
                            DialCategoryFragment dialCategoryFragment2 = DialCategoryFragment.this;
                            mActivity = dialCategoryFragment2.getMActivity();
                            tv.setText(dialCategoryFragment2.getString(OnlineWatchFaceKt.getWatchFaceCategoryName(mActivity, watchFaceCategory2.getType())));
                        }
                    });
                    dslItem.setItemTag(WatchFaceCategory.this.getDir());
                    final DialCategoryFragment dialCategoryFragment2 = this;
                    final WatchFaceCategory watchFaceCategory3 = WatchFaceCategory.this;
                    dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$doItem$1.2
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
                            if (DialCategoryFragment.this.isSync()) {
                                ToastUtils.showLong(R.string.syncing_remind);
                                return;
                            }
                            Xo0.f24349oIX0oI.I0Io().put(XoI0Ixx0.f24488xo0x + '_' + WatchFaceInfo[].class.getName(), new Gson().toJson(watchFaceCategory3.getList()));
                            DialCategoryFragment dialCategoryFragment3 = DialCategoryFragment.this;
                            int type = watchFaceCategory3.getType();
                            Bundle bundle = new Bundle();
                            bundle.putString("mArg0", null);
                            bundle.putInt("mArg1", type);
                            bundle.putParcelable("mArg2", null);
                            bundle.putSerializable("mArg3", null);
                            Intent intent = new Intent(dialCategoryFragment3.getActivity(), (Class<?>) DialActivity.class);
                            intent.putExtras(bundle);
                            dialCategoryFragment3.startActivity(intent);
                        }
                    });
                }
            });
            for (final WatchFaceInfo watchFaceInfo : CollectionsKt___CollectionsKt.O0o000XOX(ArraysKt___ArraysKt.XOXXox0(watchFaceCategory.getList()), 6)) {
                DslAdapterExKt.oO(getDslAdapter(), R.layout.item_dial_f3, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$doItem$2

                    /* renamed from: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$doItem$2$1, reason: invalid class name */
                    /* loaded from: classes12.dex */
                    public static final class AnonymousClass1 extends Lambda implements Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI> {
                        final /* synthetic */ WatchFaceCategory $category;
                        final /* synthetic */ WatchFaceInfo $item;
                        final /* synthetic */ DialCategoryFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(WatchFaceInfo watchFaceInfo, DialCategoryFragment dialCategoryFragment, WatchFaceCategory watchFaceCategory) {
                            super(4);
                            this.$item = watchFaceInfo;
                            this.this$0 = dialCategoryFragment;
                            this.$category = watchFaceCategory;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void invoke$lambda$0(final DialCategoryFragment this$0, final int i, final WatchFaceCategory category, final int i2, final ProgressButton progressButton, final WatchFaceInfo item, View view) {
                            IIX0o.x0xO0oo(this$0, "this$0");
                            IIX0o.x0xO0oo(category, "$category");
                            IIX0o.x0xO0oo(progressButton, "$progressButton");
                            IIX0o.x0xO0oo(item, "$item");
                            if (this$0.isSync()) {
                                ToastUtils.showLong(R.string.syncing_remind);
                            } else if (this$0.mDialIds.contains(Integer.valueOf(i))) {
                                ToastUtils.showLong(R.string.dial_sync_done);
                            } else {
                                I0Io.II0xO0(false, 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0045: INVOKE 
                                      false
                                      (wrap:Oox.oOoXoXO<com.szabh.smable3.component.BleConnector, kotlin.oXIO0o0XI>:0x003f: CONSTRUCTOR 
                                      (r7v0 'this$0' com.sma.smartv3.ui.device.dial.category.DialCategoryFragment A[DONT_INLINE])
                                      (r9v0 'category' com.sma.smartv3.model.WatchFaceCategory A[DONT_INLINE])
                                      (r8v0 'i' int A[DONT_INLINE])
                                      (r10v0 'i2' int A[DONT_INLINE])
                                      (r11v0 'progressButton' com.sma.smartv3.view.ProgressButton A[DONT_INLINE])
                                      (r12v0 'item' com.sma.smartv3.model.WatchFaceInfo A[DONT_INLINE])
                                     A[MD:(com.sma.smartv3.ui.device.dial.category.DialCategoryFragment, com.sma.smartv3.model.WatchFaceCategory, int, int, com.sma.smartv3.view.ProgressButton, com.sma.smartv3.model.WatchFaceInfo):void (m), WRAPPED] (LINE:64) call: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$doItem$2$1$1$1.<init>(com.sma.smartv3.ui.device.dial.category.DialCategoryFragment, com.sma.smartv3.model.WatchFaceCategory, int, int, com.sma.smartv3.view.ProgressButton, com.sma.smartv3.model.WatchFaceInfo):void type: CONSTRUCTOR)
                                      (1 int)
                                      (null java.lang.Object)
                                     STATIC call: com.sma.smartv3.ble.I0Io.II0xO0(boolean, Oox.oOoXoXO, int, java.lang.Object):boolean A[MD:(boolean, Oox.oOoXoXO, int, java.lang.Object):boolean (m)] (LINE:70) in method: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$doItem$2.1.invoke$lambda$0(com.sma.smartv3.ui.device.dial.category.DialCategoryFragment, int, com.sma.smartv3.model.WatchFaceCategory, int, com.sma.smartv3.view.ProgressButton, com.sma.smartv3.model.WatchFaceInfo, android.view.View):void, file: classes12.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$doItem$2$1$1$1, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 23 more
                                    */
                                /*
                                    java.lang.String r13 = "this$0"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r13)
                                    java.lang.String r13 = "$category"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r9, r13)
                                    java.lang.String r13 = "$progressButton"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r11, r13)
                                    java.lang.String r13 = "$item"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r12, r13)
                                    boolean r13 = r7.isSync()
                                    if (r13 == 0) goto L21
                                    r7 = 2132021755(0x7f1411fb, float:1.968191E38)
                                    com.blankj.utilcode.util.ToastUtils.showLong(r7)
                                    return
                                L21:
                                    java.util.List r13 = com.sma.smartv3.ui.device.dial.category.DialCategoryFragment.access$getMDialIds$p(r7)
                                    java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
                                    boolean r13 = r13.contains(r0)
                                    if (r13 == 0) goto L36
                                    r7 = 2132018296(0x7f140478, float:1.9674895E38)
                                    com.blankj.utilcode.util.ToastUtils.showLong(r7)
                                    return
                                L36:
                                    com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$doItem$2$1$1$1 r13 = new com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$doItem$2$1$1$1
                                    r0 = r13
                                    r1 = r7
                                    r2 = r9
                                    r3 = r8
                                    r4 = r10
                                    r5 = r11
                                    r6 = r12
                                    r0.<init>(r1, r2, r3, r4, r5, r6)
                                    r7 = 1
                                    r8 = 0
                                    r9 = 0
                                    com.sma.smartv3.ble.I0Io.II0xO0(r9, r13, r7, r8)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$doItem$2.AnonymousClass1.invoke$lambda$0(com.sma.smartv3.ui.device.dial.category.DialCategoryFragment, int, com.sma.smartv3.model.WatchFaceCategory, int, com.sma.smartv3.view.ProgressButton, com.sma.smartv3.model.WatchFaceInfo, android.view.View):void");
                            }

                            @Override // Oox.Oxx0xo
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(@OOXIXo DslViewHolder itemHolder, final int i, @OOXIXo DslAdapterItem adapterItem, @OOXIXo List<? extends Object> payloads) {
                                IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                IIX0o.x0xO0oo(adapterItem, "adapterItem");
                                IIX0o.x0xO0oo(payloads, "payloads");
                                final int id = this.$item.getId();
                                View v = itemHolder.v(R.id.pb);
                                IIX0o.ooOOo0oXI(v);
                                final ProgressButton progressButton = (ProgressButton) v;
                                if (!payloads.isEmpty()) {
                                    DialCategoryFragment dialCategoryFragment = this.this$0;
                                    dialCategoryFragment.syncStatusChange(progressButton, dialCategoryFragment.mCurSyncStatus);
                                    return;
                                }
                                ProgressButton.X0o0xo(progressButton, R.string.sync, false, 2, null);
                                if (this.this$0.mCurSyncDialId != id) {
                                    if (this.this$0.mDialIds.contains(Integer.valueOf(id))) {
                                        progressButton.I0Io(R.string.synced, true);
                                    }
                                } else {
                                    DialCategoryFragment dialCategoryFragment2 = this.this$0;
                                    dialCategoryFragment2.syncStatusChange(progressButton, dialCategoryFragment2.mCurSyncStatus);
                                }
                                final DialCategoryFragment dialCategoryFragment3 = this.this$0;
                                final WatchFaceCategory watchFaceCategory = this.$category;
                                final WatchFaceInfo watchFaceInfo = this.$item;
                                progressButton.setOnClickListener(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0073: INVOKE 
                                      (r10v5 'progressButton' com.sma.smartv3.view.ProgressButton)
                                      (wrap:android.view.View$OnClickListener:0x0070: CONSTRUCTOR 
                                      (r1v1 'dialCategoryFragment3' com.sma.smartv3.ui.device.dial.category.DialCategoryFragment A[DONT_INLINE])
                                      (r2v0 'id' int A[DONT_INLINE])
                                      (r3v1 'watchFaceCategory' com.sma.smartv3.model.WatchFaceCategory A[DONT_INLINE])
                                      (r9v0 'i' int A[DONT_INLINE])
                                      (r10v5 'progressButton' com.sma.smartv3.view.ProgressButton A[DONT_INLINE])
                                      (r6v0 'watchFaceInfo' com.sma.smartv3.model.WatchFaceInfo A[DONT_INLINE])
                                     A[MD:(com.sma.smartv3.ui.device.dial.category.DialCategoryFragment, int, com.sma.smartv3.model.WatchFaceCategory, int, com.sma.smartv3.view.ProgressButton, com.sma.smartv3.model.WatchFaceInfo):void (m), WRAPPED] call: com.sma.smartv3.ui.device.dial.category.oIX0oI.<init>(com.sma.smartv3.ui.device.dial.category.DialCategoryFragment, int, com.sma.smartv3.model.WatchFaceCategory, int, com.sma.smartv3.view.ProgressButton, com.sma.smartv3.model.WatchFaceInfo):void type: CONSTRUCTOR)
                                     VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$doItem$2.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.dial.category.oIX0oI, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 19 more
                                    */
                                /*
                                    this = this;
                                    java.lang.String r0 = "itemHolder"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r0)
                                    java.lang.String r0 = "adapterItem"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r10, r0)
                                    java.lang.String r10 = "payloads"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r11, r10)
                                    com.sma.smartv3.model.WatchFaceInfo r10 = r7.$item
                                    int r2 = r10.getId()
                                    r10 = 2131366812(0x7f0a139c, float:1.8353528E38)
                                    android.view.View r10 = r8.v(r10)
                                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(r10)
                                    com.sma.smartv3.view.ProgressButton r10 = (com.sma.smartv3.view.ProgressButton) r10
                                    java.util.Collection r11 = (java.util.Collection) r11
                                    boolean r11 = r11.isEmpty()
                                    if (r11 != 0) goto L33
                                    com.sma.smartv3.ui.device.dial.category.DialCategoryFragment r8 = r7.this$0
                                    com.sma.smartv3.model.SyncStatus r9 = com.sma.smartv3.ui.device.dial.category.DialCategoryFragment.access$getMCurSyncStatus$p(r8)
                                    com.sma.smartv3.ui.device.dial.category.DialCategoryFragment.access$syncStatusChange(r8, r10, r9)
                                    return
                                L33:
                                    r11 = 2
                                    r0 = 0
                                    r1 = 2132021746(0x7f1411f2, float:1.9681892E38)
                                    r3 = 0
                                    com.sma.smartv3.view.ProgressButton.X0o0xo(r10, r1, r3, r11, r0)
                                    com.sma.smartv3.ui.device.dial.category.DialCategoryFragment r11 = r7.this$0
                                    int r11 = com.sma.smartv3.ui.device.dial.category.DialCategoryFragment.access$getMCurSyncDialId$p(r11)
                                    if (r11 != r2) goto L4e
                                    com.sma.smartv3.ui.device.dial.category.DialCategoryFragment r11 = r7.this$0
                                    com.sma.smartv3.model.SyncStatus r0 = com.sma.smartv3.ui.device.dial.category.DialCategoryFragment.access$getMCurSyncStatus$p(r11)
                                    com.sma.smartv3.ui.device.dial.category.DialCategoryFragment.access$syncStatusChange(r11, r10, r0)
                                    goto L65
                                L4e:
                                    com.sma.smartv3.ui.device.dial.category.DialCategoryFragment r11 = r7.this$0
                                    java.util.List r11 = com.sma.smartv3.ui.device.dial.category.DialCategoryFragment.access$getMDialIds$p(r11)
                                    java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
                                    boolean r11 = r11.contains(r0)
                                    if (r11 == 0) goto L65
                                    r11 = 2132021752(0x7f1411f8, float:1.9681904E38)
                                    r0 = 1
                                    r10.I0Io(r11, r0)
                                L65:
                                    com.sma.smartv3.ui.device.dial.category.DialCategoryFragment r1 = r7.this$0
                                    com.sma.smartv3.model.WatchFaceCategory r3 = r7.$category
                                    com.sma.smartv3.model.WatchFaceInfo r6 = r7.$item
                                    com.sma.smartv3.ui.device.dial.category.oIX0oI r11 = new com.sma.smartv3.ui.device.dial.category.oIX0oI
                                    r0 = r11
                                    r4 = r9
                                    r5 = r10
                                    r0.<init>(r1, r2, r3, r4, r5, r6)
                                    r10.setOnClickListener(r11)
                                    r9 = 2131364945(0x7f0a0c51, float:1.8349741E38)
                                    android.view.View r8 = r8.v(r9)
                                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(r8)
                                    com.sma.smartv3.view.SquareImageView r8 = (com.sma.smartv3.view.SquareImageView) r8
                                    com.sma.smartv3.ui.device.dial.category.DialCategoryFragment r9 = r7.this$0
                                    android.content.Context r9 = r9.requireContext()
                                    com.bumptech.glide.RequestManager r9 = com.bumptech.glide.Glide.with(r9)
                                    com.sma.smartv3.model.WatchFaceInfo r10 = r7.$item
                                    java.lang.String r10 = r10.getPreviewPath()
                                    com.bumptech.glide.RequestBuilder r9 = r9.load(r10)
                                    r9.into(r8)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$doItem$2.AnonymousClass1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                            dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(WatchFaceCategory.this.getDir()));
                            dslItem.setItemBindOverride(new AnonymousClass1(watchFaceInfo, this, WatchFaceCategory.this));
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void sendDial() {
            if (AGPSInitializer.f20674XO.ooOOo0oXI()) {
                return;
            }
            this.mCurSyncStatus = SyncStatus.SYNCING;
            ProductManager productManager = ProductManager.f20544oIX0oI;
            if (productManager.OOoOoO0o()) {
                BleConnector.sendInt32$default(BleConnector.INSTANCE, BleKey.WATCHFACE_ID, BleKeyFlag.UPDATE, this.mCurSyncDialId, null, false, false, 56, null);
                return;
            }
            BleConnector bleConnector = BleConnector.INSTANCE;
            BleKey bleKey = BleKey.WATCH_FACE;
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            String str = this.mBinFileName;
            if (str == null) {
                IIX0o.XOxIOxOx("mBinFileName");
                str = null;
            }
            bleConnector.sendStream(bleKey, IXxxXO.X0o0xo(oix0oi, str), this.mCurSyncDevicePosition);
            productManager.xOIO();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void syncDial(int i, int i2, int i3, final ProgressButton progressButton, final WatchFaceInfo watchFaceInfo, final int i4) {
            LogUtils.d("syncDial -> position:" + i2 + ", mCurSyncPosition:" + i3 + ", mCurSyncDialId:" + i);
            this.mCurSyncDialId = i;
            this.mCurSyncPosition = i2;
            this.mCurSyncStatus = SyncStatus.DOWNLOAD;
            this.mCurSyncDevicePosition = i3;
            StringBuilder sb = new StringBuilder();
            BleCache bleCache = BleCache.INSTANCE;
            sb.append(bleCache.getMPrototype());
            sb.append('_');
            sb.append(bleCache.getMBleName());
            sb.append('_');
            sb.append(watchFaceInfo.getId());
            sb.append(".bin");
            this.mBinFileName = sb.toString();
            X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
            File XI0IXoo2 = IXxxXO.XI0IXoo(oix0oi);
            String str = this.mBinFileName;
            String str2 = null;
            if (str == null) {
                IIX0o.XOxIOxOx("mBinFileName");
                str = null;
            }
            final File file = new File(XI0IXoo2, str);
            final File file2 = new File(IXxxXO.XI0IXoo(oix0oi), bleCache.getMPrototype() + '_' + bleCache.getMBleName() + '_' + watchFaceInfo.getId());
            if (!FileUtils.isFileExists(file2)) {
                FileUtils.createOrExistsFile(file2);
                FileIOUtils.writeFileFromString(file2, watchFaceInfo.getPreviewPath(), false);
            }
            if (file.exists()) {
                OI0.oIX0oI oix0oi2 = OI0.oIX0oI.f1507oIX0oI;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("syncDial -> dial try get from dialFile file = ");
                String str3 = this.mBinFileName;
                if (str3 == null) {
                    IIX0o.XOxIOxOx("mBinFileName");
                    str3 = null;
                }
                sb2.append(str3);
                sb2.append(" size:");
                sb2.append(FileUtils.getSize(file));
                oix0oi2.oIX0oI(sb2.toString());
                ProgressButton.X0o0xo(progressButton, R.string.syncing, false, 2, null);
                sendDial();
                return;
            }
            ProgressButton.X0o0xo(progressButton, R.string.downloading, false, 2, null);
            NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
            String binPath = watchFaceInfo.getBinPath();
            String absolutePath = IXxxXO.XI0IXoo(oix0oi).getAbsolutePath();
            IIX0o.oO(absolutePath, "getAbsolutePath(...)");
            String str4 = this.mBinFileName;
            if (str4 == null) {
                IIX0o.XOxIOxOx("mBinFileName");
            } else {
                str2 = str4;
            }
            netWorkUtils.download(binPath, absolutePath, str2, new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$syncDial$1
                @Override // xxxI.II0xO0
                public void handleError(@OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    FileUtils.delete(file);
                    FileUtils.delete(file2);
                    this.mCurSyncStatus = SyncStatus.FAILED;
                    ProgressButton.X0o0xo(progressButton, R.string.sync_failed, false, 2, null);
                    ToastUtils.showLong(oO.f24511oIX0oI.oIX0oI(1), new Object[0]);
                }

                @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                public void handleProgress(int i5) {
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@oOoXoXO String str5) {
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("syncDial -> dial try get from net");
                    StatManager.f20200oIX0oI.I0Io(WatchFaceInfo.this.getBinPath(), FileUtils.getLength(file), i4, WatchFaceInfo.this.getId());
                    ProgressButton.X0o0xo(progressButton, R.string.syncing, false, 2, null);
                    this.sendDial();
                }
            });
        }

        public static /* synthetic */ void syncDial$default(DialCategoryFragment dialCategoryFragment, int i, int i2, int i3, ProgressButton progressButton, WatchFaceInfo watchFaceInfo, int i4, int i5, Object obj) {
            int i6;
            if ((i5 & 32) != 0) {
                i6 = 0;
            } else {
                i6 = i4;
            }
            dialCategoryFragment.syncDial(i, i2, i3, progressButton, watchFaceInfo, i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void syncStatusChange(ProgressButton progressButton, SyncStatus syncStatus) {
            int i = oIX0oI.f22328oIX0oI[syncStatus.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            progressButton.I0Io(R.string.synced, true);
                            return;
                        }
                        return;
                    }
                    progressButton.setProgressDecimalPlaces(this.mCurSyncCompleted / this.mCurSyncTotal);
                    return;
                }
                ProgressButton.X0o0xo(progressButton, R.string.sync, false, 2, null);
                return;
            }
            ProgressButton.X0o0xo(progressButton, R.string.sync_failed, false, 2, null);
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
        @OOXIXo
        public DslAdapterStatusItem adapterStatusItem() {
            setAdapterStatus(new AdapterStatusItem());
            return getAdapterStatus();
        }

        @Override // com.bestmafen.androidbase.base.oIX0oI
        public void init(@oOoXoXO Bundle bundle) {
            BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
            SPUtils I0Io2 = Xo0.f24349oIX0oI.I0Io();
            WatchFaceCategory[] watchFaceCategoryArr = (WatchFaceCategory[]) new Gson().fromJson(I0Io2.getString(XoI0Ixx0.f24465oxXx0IX + '_' + WatchFaceCategory[].class.getName()), WatchFaceCategory[].class);
            this.mCategorys = watchFaceCategoryArr;
            if (watchFaceCategoryArr != null && watchFaceCategoryArr.length == 0) {
                DeviceInfoChecker.f19983oIX0oI.oI0IIXIo();
            }
        }

        @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
        public boolean initEvent() {
            return true;
        }

        public final boolean isSync() {
            SyncStatus syncStatus = this.mCurSyncStatus;
            if (syncStatus != SyncStatus.SYNCING && syncStatus != SyncStatus.DOWNLOAD) {
                return false;
            }
            return true;
        }

        @Override // com.bestmafen.androidbase.base.oIX0oI
        public int layoutId() {
            return R.layout.fragment_online_watchface;
        }

        @XO(tag = AGPSInitializer.f20668IXxxXO)
        public final void onAGPSSyncState(boolean z) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI("onAGPSSyncState -> " + z + ", " + isSync());
            if (!z && isSync()) {
                sendDial();
            }
        }

        @Override // com.bestmafen.androidbase.base.BaseFragment, androidx.fragment.app.Fragment
        public void onDestroy() {
            BleConnector.INSTANCE.removeHandleCallback(this.mBleHandleCallback);
            super.onDestroy();
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
        public void onInitBaseLayoutAfter() {
            super.onInitBaseLayoutAfter();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getMActivity(), 3);
            getRecyclerView().setLayoutManager(gridLayoutManager);
            gridLayoutManager.setSpanSizeLookup(BaseDSLRecyclerFragmentKt.II0xO0(gridLayoutManager, getDslAdapter()));
            renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$onInitBaseLayoutAfter$2
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                    invoke2(dslAdapter);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo DslAdapter renderAdapter) {
                    IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                    DslViewHolder dslViewHolder = DialCategoryFragment.this.getDslViewHolder();
                    final DialCategoryFragment dialCategoryFragment = DialCategoryFragment.this;
                    dslViewHolder.post(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment$onInitBaseLayoutAfter$2.1
                        {
                            super(0);
                        }

                        @Override // Oox.oIX0oI
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                            invoke2();
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            final DialCategoryFragment dialCategoryFragment2 = DialCategoryFragment.this;
                            dialCategoryFragment2.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.dial.category.DialCategoryFragment.onInitBaseLayoutAfter.2.1.1
                                {
                                    super(1);
                                }

                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                    invoke2(dslAdapter);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OOXIXo DslAdapter renderAdapter2) {
                                    WatchFaceCategory[] watchFaceCategoryArr;
                                    IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                    watchFaceCategoryArr = DialCategoryFragment.this.mCategorys;
                                    if (watchFaceCategoryArr != null) {
                                        DialCategoryFragment.this.doItem(watchFaceCategoryArr);
                                    }
                                }
                            });
                        }
                    });
                }
            });
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            if (ProductManager.f20544oIX0oI.OOoOoO0o()) {
                BleConnector.sendData$default(BleConnector.INSTANCE, BleKey.WATCHFACE_ID, BleKeyFlag.READ, null, false, false, 28, null);
                return;
            }
            this.mDialIds.set(0, Integer.valueOf(Xo0.f24349oIX0oI.II0xO0().getInt("syncId", 0)));
            LogUtils.d("mDialIds -> " + this.mDialIds);
            getDslAdapter().notifyDataSetChanged();
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
        public int recyclerViewId() {
            return R.id.recycler_view;
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
        public int refreshLayoutId() {
            return 0;
        }
    }
