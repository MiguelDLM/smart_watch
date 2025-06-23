package com.sma.smartv3.ui.device.watchface.fragment;

import Oox.Oxx0xo;
import android.annotation.SuppressLint;
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
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.StatManager;
import com.sma.smartv3.biz.WatchFaceManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.dsl.AdapterStatusItem;
import com.sma.smartv3.initializer.AGPSInitializer;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.OnlineWatchFaceV2;
import com.sma.smartv3.model.SyncStatus;
import com.sma.smartv3.model.WatchFaceCategoryV2;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nOnlineWatchFaceFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnlineWatchFaceFragment.kt\ncom/sma/smartv3/ui/device/watchface/fragment/OnlineWatchFaceFragment\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,510:1\n3792#2:511\n4307#2,2:512\n*S KotlinDebug\n*F\n+ 1 OnlineWatchFaceFragment.kt\ncom/sma/smartv3/ui/device/watchface/fragment/OnlineWatchFaceFragment\n*L\n300#1:511\n300#1:512,2\n*E\n"})
/* loaded from: classes12.dex */
public final class OnlineWatchFaceFragment extends BaseDSLRecyclerFragment {

    @OXOo.oOoXoXO
    private DialPickerPopup dialPickerPopup;
    private String mBinFileName;
    private int mCurSyncCompleted;
    private int mCurSyncDevicePosition;
    private int mCurSyncDialId;
    private int mCurSyncPosition;
    private int mCurSyncTotal;

    @OXOo.oOoXoXO
    private List<OnlineWatchFaceV2> mWatchFaceList;

    @OXOo.OOXIXo
    private final String TAG = "OnlineWatchFaceFragment";

    @OXOo.OOXIXo
    private final List<Integer> mDialIds = CollectionsKt__CollectionsKt.XOxIOxOx(0);

    @OXOo.OOXIXo
    private SyncStatus mCurSyncStatus = SyncStatus.NO_SYNC;

    @OXOo.OOXIXo
    private final X0IIOO emptyView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$emptyView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = OnlineWatchFaceFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.empty_view);
        }
    });
    private boolean isNoShowTitle = true;

    @OXOo.OOXIXo
    private final II0xO0 mBleHandleCallback = new II0xO0();

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements BleHandleCallback {
        public II0xO0() {
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAICoachGeneratePlanUpdate(int i) {
            BleHandleCallback.DefaultImpls.onAICoachGeneratePlanUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAlarmAdd(@OXOo.OOXIXo BleAlarm bleAlarm) {
            BleHandleCallback.DefaultImpls.onAlarmAdd(this, bleAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAlarmDelete(int i) {
            BleHandleCallback.DefaultImpls.onAlarmDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAlarmUpdate(@OXOo.OOXIXo BleAlarm bleAlarm) {
            BleHandleCallback.DefaultImpls.onAlarmUpdate(this, bleAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAppOpUpdate(@OXOo.OOXIXo BleAppOp bleAppOp) {
            BleHandleCallback.DefaultImpls.onAppOpUpdate(this, bleAppOp);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onAppSportDataResponse(boolean z) {
            BleHandleCallback.DefaultImpls.onAppSportDataResponse(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onBWNaviInfoUpdate(@OXOo.OOXIXo BleBWNaviInfo bleBWNaviInfo) {
            BleHandleCallback.DefaultImpls.onBWNaviInfoUpdate(this, bleBWNaviInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onBacklightUpdate(int i) {
            BleHandleCallback.DefaultImpls.onBacklightUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onBleThirdPartyDataUpdate(@OXOo.OOXIXo BleThirdPartyData bleThirdPartyData) {
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
        public void onCheckInEveryDayUpdate(@OXOo.OOXIXo BleCheckInEveryDay bleCheckInEveryDay) {
            BleHandleCallback.DefaultImpls.onCheckInEveryDayUpdate(this, bleCheckInEveryDay);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onClassicBluetoothStateChange(int i) {
            BleHandleCallback.DefaultImpls.onClassicBluetoothStateChange(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCommandReply(@OXOo.OOXIXo BleKey bleKey, @OXOo.OOXIXo BleKeyFlag bleKeyFlag, boolean z) {
            BleHandleCallback.DefaultImpls.onCommandReply(this, bleKey, bleKeyFlag, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onCommandSendTimeout(@OXOo.OOXIXo BleKey bleKey, @OXOo.OOXIXo BleKeyFlag bleKeyFlag) {
            IIX0o.x0xO0oo(bleKey, "bleKey");
            IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
            if (bleKey == BleKey.WATCH_FACE) {
                OnlineWatchFaceFragment.this.mCurSyncStatus = SyncStatus.FAILED;
                ToastUtils.showLong(oO.f24511oIX0oI.oIX0oI(0), new Object[0]);
                OnlineWatchFaceFragment.this.getDslAdapter().notifyDataSetChanged();
            }
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceConnected(@OXOo.OOXIXo BluetoothDevice bluetoothDevice) {
            BleHandleCallback.DefaultImpls.onDeviceConnected(this, bluetoothDevice);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceConnecting(boolean z) {
            BleHandleCallback.DefaultImpls.onDeviceConnecting(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceFileUpdate(@OXOo.OOXIXo BleDeviceFile bleDeviceFile) {
            BleHandleCallback.DefaultImpls.onDeviceFileUpdate(this, bleDeviceFile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceRequestAGpsFile(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onDeviceRequestAGpsFile(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceSMSQuickReply(@OXOo.OOXIXo BleSMSQuickReply bleSMSQuickReply) {
            BleHandleCallback.DefaultImpls.onDeviceSMSQuickReply(this, bleSMSQuickReply);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceSportDataUpdate(@OXOo.OOXIXo BleDeviceSportData bleDeviceSportData) {
            BleHandleCallback.DefaultImpls.onDeviceSportDataUpdate(this, bleDeviceSportData);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDistanceGoalUpdate(int i) {
            BleHandleCallback.DefaultImpls.onDistanceGoalUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDoubleScreenSettingsUpdate(@OXOo.OOXIXo BleDoubleScreenSettings bleDoubleScreenSettings) {
            BleHandleCallback.DefaultImpls.onDoubleScreenSettingsUpdate(this, bleDoubleScreenSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneAncSettingsUpdate(@OXOo.OOXIXo BleEarphoneAncSettings bleEarphoneAncSettings) {
            BleHandleCallback.DefaultImpls.onEarphoneAncSettingsUpdate(this, bleEarphoneAncSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneCallUpdate(int i) {
            BleHandleCallback.DefaultImpls.onEarphoneCallUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneKeyUpdate(@OXOo.OOXIXo BleEarphoneKey bleEarphoneKey) {
            BleHandleCallback.DefaultImpls.onEarphoneKeyUpdate(this, bleEarphoneKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneSoundEffectsSettingsUpdate(@OXOo.OOXIXo BleEarphoneSoundEffectsSettings bleEarphoneSoundEffectsSettings) {
            BleHandleCallback.DefaultImpls.onEarphoneSoundEffectsSettingsUpdate(this, bleEarphoneSoundEffectsSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onEarphoneStateUpdate(@OXOo.OOXIXo BleEarphoneState bleEarphoneState) {
            BleHandleCallback.DefaultImpls.onEarphoneStateUpdate(this, bleEarphoneState);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFactoryTestUpdate(@OXOo.OOXIXo BleFactoryTest bleFactoryTest) {
            BleHandleCallback.DefaultImpls.onFactoryTestUpdate(this, bleFactoryTest);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFallSetUpdate(int i) {
            BleHandleCallback.DefaultImpls.onFallSetUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onFindEarphoneUpdate(@OXOo.OOXIXo BleFindEarphone bleFindEarphone) {
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
        public void onGameControlUpdate(@OXOo.OOXIXo BleGameControl bleGameControl) {
            BleHandleCallback.DefaultImpls.onGameControlUpdate(this, bleGameControl);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onGestureWake2Update(@OXOo.OOXIXo BleGestureWake2 bleGestureWake2) {
            BleHandleCallback.DefaultImpls.onGestureWake2Update(this, bleGestureWake2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onGestureWakeUpdate(@OXOo.OOXIXo BleGestureWake bleGestureWake) {
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
        public void onIPCStoresInfoUpdate(@OXOo.OOXIXo BleIPCStoresInfo bleIPCStoresInfo) {
            BleHandleCallback.DefaultImpls.onIPCStoresInfoUpdate(this, bleIPCStoresInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIPCWifiInfoUpdate(@OXOo.OOXIXo BleIPCWifiInfo bleIPCWifiInfo) {
            BleHandleCallback.DefaultImpls.onIPCWifiInfoUpdate(this, bleIPCWifiInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIPCWifiStateUpdate(int i) {
            BleHandleCallback.DefaultImpls.onIPCWifiStateUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onIdentityCreate(boolean z, @OXOo.oOoXoXO BleDeviceInfo bleDeviceInfo) {
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
        public void onLoveTapUpdate(@OXOo.OOXIXo BleLoveTap bleLoveTap) {
            BleHandleCallback.DefaultImpls.onLoveTapUpdate(this, bleLoveTap);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onLoveTapUserDelete(int i) {
            BleHandleCallback.DefaultImpls.onLoveTapUserDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onLoveTapUserUpdate(@OXOo.OOXIXo BleLoveTapUser bleLoveTapUser) {
            BleHandleCallback.DefaultImpls.onLoveTapUserUpdate(this, bleLoveTapUser);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMeasurementUpdate(@OXOo.OOXIXo BleMeasurement bleMeasurement) {
            BleHandleCallback.DefaultImpls.onMeasurementUpdate(this, bleMeasurement);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationAlarmAdd(@OXOo.OOXIXo BleMedicationAlarm bleMedicationAlarm) {
            BleHandleCallback.DefaultImpls.onMedicationAlarmAdd(this, bleMedicationAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationAlarmDelete(int i) {
            BleHandleCallback.DefaultImpls.onMedicationAlarmDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationAlarmUpdate(@OXOo.OOXIXo BleMedicationAlarm bleMedicationAlarm) {
            BleHandleCallback.DefaultImpls.onMedicationAlarmUpdate(this, bleMedicationAlarm);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationReminderDelete(int i) {
            BleHandleCallback.DefaultImpls.onMedicationReminderDelete(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onMedicationReminderUpdate(@OXOo.OOXIXo BleMedicationReminder bleMedicationReminder) {
            BleHandleCallback.DefaultImpls.onMedicationReminderUpdate(this, bleMedicationReminder);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNaviInfoUpdate(@OXOo.OOXIXo BleNaviInfo bleNaviInfo) {
            BleHandleCallback.DefaultImpls.onNaviInfoUpdate(this, bleNaviInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNoDisturbUpdate(@OXOo.OOXIXo BleNoDisturbSettings bleNoDisturbSettings) {
            BleHandleCallback.DefaultImpls.onNoDisturbUpdate(this, bleNoDisturbSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNotificationLightScreenSetUpdate(int i) {
            BleHandleCallback.DefaultImpls.onNotificationLightScreenSetUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onNotificationSettings2Update(@OXOo.OOXIXo BleNotificationSettings2 bleNotificationSettings2) {
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
        public void onReadAICoachGenerateBeforeInfo(@OXOo.OOXIXo BleAICoachBeforePlan bleAICoachBeforePlan) {
            BleHandleCallback.DefaultImpls.onReadAICoachGenerateBeforeInfo(this, bleAICoachBeforePlan);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAICoachPlan(@OXOo.OOXIXo BleAICoachGeneratePlan bleAICoachGeneratePlan) {
            BleHandleCallback.DefaultImpls.onReadAICoachPlan(this, bleAICoachGeneratePlan);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadActivity(@OXOo.OOXIXo List<BleActivity> list) {
            BleHandleCallback.DefaultImpls.onReadActivity(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadActivityDetail(@OXOo.OOXIXo BleActivityDetail bleActivityDetail) {
            BleHandleCallback.DefaultImpls.onReadActivityDetail(this, bleActivityDetail);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAlarm(@OXOo.OOXIXo List<BleAlarm> list) {
            BleHandleCallback.DefaultImpls.onReadAlarm(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAlipayBindInfo(@OXOo.OOXIXo List<BleAlipayBindInfo> list) {
            BleHandleCallback.DefaultImpls.onReadAlipayBindInfo(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAlipaySettings(@OXOo.OOXIXo BleAlipaySettings bleAlipaySettings) {
            BleHandleCallback.DefaultImpls.onReadAlipaySettings(this, bleAlipaySettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAppApiVersion(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadAppApiVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAppInfoList(@OXOo.OOXIXo BleAppInfoList bleAppInfoList) {
            BleHandleCallback.DefaultImpls.onReadAppInfoList(this, bleAppInfoList);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadAvgHeartRate(@OXOo.OOXIXo List<BleAvgHeartRate> list) {
            BleHandleCallback.DefaultImpls.onReadAvgHeartRate(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBAC(@OXOo.OOXIXo List<BleBAC> list) {
            BleHandleCallback.DefaultImpls.onReadBAC(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBacCalibration(@OXOo.OOXIXo BleBacCalibration bleBacCalibration, @OXOo.OOXIXo BleKeyFlag bleKeyFlag) {
            BleHandleCallback.DefaultImpls.onReadBacCalibration(this, bleBacCalibration, bleKeyFlag);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBacklight(int i) {
            BleHandleCallback.DefaultImpls.onReadBacklight(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBatteryUsage(@OXOo.OOXIXo BleBatteryUsage bleBatteryUsage) {
            BleHandleCallback.DefaultImpls.onReadBatteryUsage(this, bleBatteryUsage);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleAddress(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadBleAddress(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleHrv(@OXOo.OOXIXo List<BleHrv> list) {
            BleHandleCallback.DefaultImpls.onReadBleHrv(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleHrv2(@OXOo.OOXIXo List<BleHrv2> list) {
            BleHandleCallback.DefaultImpls.onReadBleHrv2(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBleLogText(@OXOo.OOXIXo List<BleLogText> list) {
            BleHandleCallback.DefaultImpls.onReadBleLogText(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodGlucose(@OXOo.OOXIXo List<BleBloodGlucose> list) {
            BleHandleCallback.DefaultImpls.onReadBloodGlucose(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodOxyGenSettings(@OXOo.OOXIXo BleBloodOxyGenSettings bleBloodOxyGenSettings) {
            BleHandleCallback.DefaultImpls.onReadBloodOxyGenSettings(this, bleBloodOxyGenSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodOxygen(@OXOo.OOXIXo List<BleBloodOxygen> list) {
            BleHandleCallback.DefaultImpls.onReadBloodOxygen(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodPressure(@OXOo.OOXIXo List<BleBloodPressure> list) {
            BleHandleCallback.DefaultImpls.onReadBloodPressure(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBloodPressureCalibration(@OXOo.OOXIXo BleBloodPressureCalibration bleBloodPressureCalibration) {
            BleHandleCallback.DefaultImpls.onReadBloodPressureCalibration(this, bleBloodPressureCalibration);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadBodyStatus(@OXOo.OOXIXo List<BleBodyStatus> list) {
            BleHandleCallback.DefaultImpls.onReadBodyStatus(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCPUserInfo(@OXOo.OOXIXo BleCPUserInfo bleCPUserInfo) {
            BleHandleCallback.DefaultImpls.onReadCPUserInfo(this, bleCPUserInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCalibrationData(@OXOo.OOXIXo BleCalibrationData bleCalibrationData) {
            BleHandleCallback.DefaultImpls.onReadCalibrationData(this, bleCalibrationData);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCalorieIntake(@OXOo.OOXIXo List<BleCalorieIntake> list) {
            BleHandleCallback.DefaultImpls.onReadCalorieIntake(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCaloriesGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadCaloriesGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCheckInEveryDay(@OXOo.OOXIXo BleCheckInEveryDay bleCheckInEveryDay) {
            BleHandleCallback.DefaultImpls.onReadCheckInEveryDay(this, bleCheckInEveryDay);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadClassicBluetoothState(int i) {
            BleHandleCallback.DefaultImpls.onReadClassicBluetoothState(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadCoachingIds(@OXOo.OOXIXo BleCoachingIds bleCoachingIds) {
            BleHandleCallback.DefaultImpls.onReadCoachingIds(this, bleCoachingIds);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDailyPower(@OXOo.OOXIXo List<BlePhysicalPower> list) {
            BleHandleCallback.DefaultImpls.onReadDailyPower(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDateFormat(int i) {
            BleHandleCallback.DefaultImpls.onReadDateFormat(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceFile(@OXOo.OOXIXo BleDeviceFile bleDeviceFile) {
            BleHandleCallback.DefaultImpls.onReadDeviceFile(this, bleDeviceFile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceInfo(@OXOo.OOXIXo BleDeviceInfo bleDeviceInfo) {
            BleHandleCallback.DefaultImpls.onReadDeviceInfo(this, bleDeviceInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceInfo2(@OXOo.OOXIXo BleDeviceInfo2 bleDeviceInfo2) {
            BleHandleCallback.DefaultImpls.onReadDeviceInfo2(this, bleDeviceInfo2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceLanguages(@OXOo.OOXIXo BleDeviceLanguages bleDeviceLanguages) {
            BleHandleCallback.DefaultImpls.onReadDeviceLanguages(this, bleDeviceLanguages);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDeviceUniqueDataSettings(@OXOo.OOXIXo BleDeviceUniqueDataSettings bleDeviceUniqueDataSettings) {
            BleHandleCallback.DefaultImpls.onReadDeviceUniqueDataSettings(this, bleDeviceUniqueDataSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDistanceGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadDistanceGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDoubleScreenSettings(@OXOo.OOXIXo BleDoubleScreenSettings bleDoubleScreenSettings) {
            BleHandleCallback.DefaultImpls.onReadDoubleScreenSettings(this, bleDoubleScreenSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadDrinkWater(@OXOo.OOXIXo BleDrinkWaterSettings bleDrinkWaterSettings) {
            BleHandleCallback.DefaultImpls.onReadDrinkWater(this, bleDrinkWaterSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneAncSettings(@OXOo.OOXIXo BleEarphoneAncSettings bleEarphoneAncSettings) {
            BleHandleCallback.DefaultImpls.onReadEarphoneAncSettings(this, bleEarphoneAncSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneCall(int i) {
            BleHandleCallback.DefaultImpls.onReadEarphoneCall(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneInfo(@OXOo.OOXIXo BleEarphoneInfo bleEarphoneInfo) {
            BleHandleCallback.DefaultImpls.onReadEarphoneInfo(this, bleEarphoneInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneKey(@OXOo.OOXIXo BleEarphoneKey bleEarphoneKey) {
            BleHandleCallback.DefaultImpls.onReadEarphoneKey(this, bleEarphoneKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphonePower(@OXOo.OOXIXo BleEarphonePower bleEarphonePower) {
            BleHandleCallback.DefaultImpls.onReadEarphonePower(this, bleEarphonePower);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneSoundEffectsSettings(@OXOo.OOXIXo BleEarphoneSoundEffectsSettings bleEarphoneSoundEffectsSettings) {
            BleHandleCallback.DefaultImpls.onReadEarphoneSoundEffectsSettings(this, bleEarphoneSoundEffectsSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEarphoneState(@OXOo.OOXIXo BleEarphoneState bleEarphoneState) {
            BleHandleCallback.DefaultImpls.onReadEarphoneState(this, bleEarphoneState);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEcg(@OXOo.OOXIXo List<BleEcg> list) {
            BleHandleCallback.DefaultImpls.onReadEcg(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadEcgSettings(@OXOo.OOXIXo BleEcgSettings bleEcgSettings) {
            BleHandleCallback.DefaultImpls.onReadEcgSettings(this, bleEcgSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFallSet(int i) {
            BleHandleCallback.DefaultImpls.onReadFallSet(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFilePath(@OXOo.OOXIXo BleAppAudioBookList bleAppAudioBookList) {
            BleHandleCallback.DefaultImpls.onReadFilePath(this, bleAppAudioBookList);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFirmwareVersion(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadFirmwareVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadFoodBalance(@OXOo.OOXIXo List<BleFoodBalance> list) {
            BleHandleCallback.DefaultImpls.onReadFoodBalance(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGestureWake(@OXOo.OOXIXo BleGestureWake bleGestureWake) {
            BleHandleCallback.DefaultImpls.onReadGestureWake(this, bleGestureWake);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGestureWake2(@OXOo.OOXIXo BleGestureWake2 bleGestureWake2) {
            BleHandleCallback.DefaultImpls.onReadGestureWake2(this, bleGestureWake2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGirlCareMonthly(@OXOo.OOXIXo BleGirlCareMonthly bleGirlCareMonthly) {
            BleHandleCallback.DefaultImpls.onReadGirlCareMonthly(this, bleGirlCareMonthly);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGirlCareSettings(@OXOo.OOXIXo BleGirlCareSettings bleGirlCareSettings) {
            BleHandleCallback.DefaultImpls.onReadGirlCareSettings(this, bleGirlCareSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGoMoreSettings(@OXOo.OOXIXo BleGoMoreSettings bleGoMoreSettings) {
            BleHandleCallback.DefaultImpls.onReadGoMoreSettings(this, bleGoMoreSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadGpsFirmwareVersion(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadGpsFirmwareVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHanBaoSettings(@OXOo.OOXIXo BleHanBaoSettings bleHanBaoSettings) {
            BleHandleCallback.DefaultImpls.onReadHanBaoSettings(this, bleHanBaoSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHanBaoVibration(@OXOo.OOXIXo List<BleHanBaoVibration> list) {
            BleHandleCallback.DefaultImpls.onReadHanBaoVibration(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHeartRate(@OXOo.OOXIXo List<BleHeartRate> list) {
            BleHandleCallback.DefaultImpls.onReadHeartRate(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHourSystem(int i) {
            BleHandleCallback.DefaultImpls.onReadHourSystem(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadHrMonitoringSettings(@OXOo.OOXIXo BleHrMonitoringSettings bleHrMonitoringSettings) {
            BleHandleCallback.DefaultImpls.onReadHrMonitoringSettings(this, bleHrMonitoringSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadIPCStoresInfo(@OXOo.OOXIXo BleIPCStoresInfo bleIPCStoresInfo) {
            BleHandleCallback.DefaultImpls.onReadIPCStoresInfo(this, bleIPCStoresInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadIPCVersion(@OXOo.OOXIXo String str) {
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
        public void onReadLactateThreshold(@OXOo.OOXIXo List<BleLactateThreshold> list) {
            BleHandleCallback.DefaultImpls.onReadLactateThreshold(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLanguage(int i) {
            BleHandleCallback.DefaultImpls.onReadLanguage(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLanguagePackVersion(@OXOo.OOXIXo BleLanguagePackVersion bleLanguagePackVersion) {
            BleHandleCallback.DefaultImpls.onReadLanguagePackVersion(this, bleLanguagePackVersion);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLocation(@OXOo.OOXIXo List<BleLocation> list) {
            BleHandleCallback.DefaultImpls.onReadLocation(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadLoveTapUser(@OXOo.OOXIXo List<BleLoveTapUser> list) {
            BleHandleCallback.DefaultImpls.onReadLoveTapUser(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMatchRecord(@OXOo.OOXIXo List<BleMatchRecord> list) {
            BleHandleCallback.DefaultImpls.onReadMatchRecord(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMatchRecord2(@OXOo.OOXIXo List<BleMatchRecord2> list) {
            BleHandleCallback.DefaultImpls.onReadMatchRecord2(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMedicationAlarm(@OXOo.OOXIXo List<BleMedicationAlarm> list) {
            BleHandleCallback.DefaultImpls.onReadMedicationAlarm(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMedicationReminder(@OXOo.OOXIXo List<BleMedicationReminder> list) {
            BleHandleCallback.DefaultImpls.onReadMedicationReminder(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMindStatus(@OXOo.OOXIXo List<BleMindStatus> list) {
            BleHandleCallback.DefaultImpls.onReadMindStatus(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadMtkOtaMeta() {
            BleHandleCallback.DefaultImpls.onReadMtkOtaMeta(this);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNetworkFirmwareVersion(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadNetworkFirmwareVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNoDisturb(@OXOo.OOXIXo BleNoDisturbSettings bleNoDisturbSettings) {
            BleHandleCallback.DefaultImpls.onReadNoDisturb(this, bleNoDisturbSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNotificationLightScreenSet(int i) {
            BleHandleCallback.DefaultImpls.onReadNotificationLightScreenSet(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadNotificationSettings2(@OXOo.OOXIXo BleNotificationSettings2 bleNotificationSettings2) {
            BleHandleCallback.DefaultImpls.onReadNotificationSettings2(this, bleNotificationSettings2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPackageStatus(@OXOo.OOXIXo BlePackageStatus blePackageStatus) {
            BleHandleCallback.DefaultImpls.onReadPackageStatus(this, blePackageStatus);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPower(int i) {
            BleHandleCallback.DefaultImpls.onReadPower(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPower2(@OXOo.OOXIXo BlePower2 blePower2) {
            BleHandleCallback.DefaultImpls.onReadPower2(this, blePower2);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPressure(@OXOo.OOXIXo List<BlePressure> list) {
            BleHandleCallback.DefaultImpls.onReadPressure(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadPressureTimingMeasurement(@OXOo.OOXIXo BlePressureTimingMeasurement blePressureTimingMeasurement) {
            BleHandleCallback.DefaultImpls.onReadPressureTimingMeasurement(this, blePressureTimingMeasurement);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadQiblaSettings(@OXOo.OOXIXo BleQiblaSettings bleQiblaSettings) {
            BleHandleCallback.DefaultImpls.onReadQiblaSettings(this, bleQiblaSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRelaxReminder(@OXOo.OOXIXo BleRelaxReminder bleRelaxReminder) {
            BleHandleCallback.DefaultImpls.onReadRelaxReminder(this, bleRelaxReminder);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRespiratoryRate(@OXOo.OOXIXo List<BleRespiratoryRate> list) {
            BleHandleCallback.DefaultImpls.onReadRespiratoryRate(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRingVibrationSet(@OXOo.OOXIXo BleRingVibrationSettings bleRingVibrationSettings) {
            BleHandleCallback.DefaultImpls.onReadRingVibrationSet(this, bleRingVibrationSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadRri(@OXOo.OOXIXo List<BleRri> list) {
            BleHandleCallback.DefaultImpls.onReadRri(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSDCardInfo(@OXOo.OOXIXo BleSDCardInfo bleSDCardInfo) {
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
        public void onReadSOSSettings(@OXOo.OOXIXo BleSOSSettings bleSOSSettings) {
            BleHandleCallback.DefaultImpls.onReadSOSSettings(this, bleSOSSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadScreenBrightnessSet(int i) {
            BleHandleCallback.DefaultImpls.onReadScreenBrightnessSet(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSedentariness(@OXOo.OOXIXo BleSedentarinessSettings bleSedentarinessSettings) {
            BleHandleCallback.DefaultImpls.onReadSedentariness(this, bleSedentarinessSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleep(@OXOo.OOXIXo List<BleSleep> list) {
            BleHandleCallback.DefaultImpls.onReadSleep(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadSleepGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepQuality(@OXOo.OOXIXo BleSleepQuality bleSleepQuality) {
            BleHandleCallback.DefaultImpls.onReadSleepQuality(this, bleSleepQuality);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepQualityScore(int i) {
            BleHandleCallback.DefaultImpls.onReadSleepQualityScore(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSleepRaw(@OXOo.OOXIXo byte[] bArr) {
            BleHandleCallback.DefaultImpls.onReadSleepRaw(this, bArr);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSosCallLog(@OXOo.OOXIXo List<BleSosCallLog> list) {
            BleHandleCallback.DefaultImpls.onReadSosCallLog(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSosContact(@OXOo.OOXIXo BleSosContact bleSosContact) {
            BleHandleCallback.DefaultImpls.onReadSosContact(this, bleSosContact);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadSportDurationGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadSportDurationGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadStandbyWatchFaceSet(@OXOo.OOXIXo BleStandbyWatchFaceSet bleStandbyWatchFaceSet) {
            BleHandleCallback.DefaultImpls.onReadStandbyWatchFaceSet(this, bleStandbyWatchFaceSet);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadStepGoal(int i) {
            BleHandleCallback.DefaultImpls.onReadStepGoal(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadStock(@OXOo.OOXIXo List<BleStock> list) {
            BleHandleCallback.DefaultImpls.onReadStock(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTemperature(@OXOo.OOXIXo List<BleTemperature> list) {
            BleHandleCallback.DefaultImpls.onReadTemperature(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTemperatureUnit(int i) {
            BleHandleCallback.DefaultImpls.onReadTemperatureUnit(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTrainingStatus(@OXOo.OOXIXo List<BleTrainingStatus> list) {
            BleHandleCallback.DefaultImpls.onReadTrainingStatus(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadTuyaKey(@OXOo.OOXIXo BleTuyaKey bleTuyaKey) {
            BleHandleCallback.DefaultImpls.onReadTuyaKey(this, bleTuyaKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadUiPackVersion(@OXOo.OOXIXo String str) {
            BleHandleCallback.DefaultImpls.onReadUiPackVersion(this, str);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadUnit(int i) {
            BleHandleCallback.DefaultImpls.onReadUnit(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadUserProfile(@OXOo.OOXIXo BleUserProfile bleUserProfile) {
            BleHandleCallback.DefaultImpls.onReadUserProfile(this, bleUserProfile);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadVitalityValue(@OXOo.OOXIXo List<BleVitality> list) {
            BleHandleCallback.DefaultImpls.onReadVitalityValue(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchFaceId(@OXOo.OOXIXo BleWatchFaceId bleWatchFaceId) {
            BleHandleCallback.DefaultImpls.onReadWatchFaceId(this, bleWatchFaceId);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchFaceIndex(@OXOo.OOXIXo BleWatchFaceIndex bleWatchFaceIndex) {
            BleHandleCallback.DefaultImpls.onReadWatchFaceIndex(this, bleWatchFaceIndex);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchFaceSwitch(int i) {
            BleHandleCallback.DefaultImpls.onReadWatchFaceSwitch(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWatchPassword(@OXOo.OOXIXo BleSettingWatchPassword bleSettingWatchPassword) {
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
        public void onReadWorkout(@OXOo.OOXIXo List<BleWorkout> list) {
            BleHandleCallback.DefaultImpls.onReadWorkout(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWorkout2(@OXOo.OOXIXo List<BleWorkout2> list) {
            BleHandleCallback.DefaultImpls.onReadWorkout2(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWorkout3(@OXOo.OOXIXo List<BleWorkout3> list) {
            BleHandleCallback.DefaultImpls.onReadWorkout3(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReadWorldClock(@OXOo.OOXIXo List<BleWorldClock> list) {
            BleHandleCallback.DefaultImpls.onReadWorldClock(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onRealTimeMeasurement(@OXOo.OOXIXo BleRealTimeMeasurement bleRealTimeMeasurement) {
            BleHandleCallback.DefaultImpls.onRealTimeMeasurement(this, bleRealTimeMeasurement);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveFilePacket(@OXOo.OOXIXo BleReceiveFilePacket bleReceiveFilePacket) {
            BleHandleCallback.DefaultImpls.onReceiveFilePacket(this, bleReceiveFilePacket);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveGSensorMotion(@OXOo.OOXIXo List<BleGSensorMotion> list) {
            BleHandleCallback.DefaultImpls.onReceiveGSensorMotion(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveGSensorRaw(@OXOo.OOXIXo List<BleGSensorRaw> list) {
            BleHandleCallback.DefaultImpls.onReceiveGSensorRaw(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveGSensorSHSY(@OXOo.OOXIXo List<BleGSensorSHSY> list) {
            BleHandleCallback.DefaultImpls.onReceiveGSensorSHSY(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveHRRaw(@OXOo.OOXIXo List<BleHRRaw> list) {
            BleHandleCallback.DefaultImpls.onReceiveHRRaw(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveLocationGga(@OXOo.OOXIXo BleLocationGga bleLocationGga) {
            BleHandleCallback.DefaultImpls.onReceiveLocationGga(this, bleLocationGga);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveLocationGsv(@OXOo.OOXIXo List<BleLocationGsv> list) {
            BleHandleCallback.DefaultImpls.onReceiveLocationGsv(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveMusicCommand(@OXOo.OOXIXo MusicCommand musicCommand) {
            BleHandleCallback.DefaultImpls.onReceiveMusicCommand(this, musicCommand);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceivePpgSHSY(@OXOo.OOXIXo List<BlePpgSHSY> list) {
            BleHandleCallback.DefaultImpls.onReceivePpgSHSY(this, list);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveRealtimeLog(@OXOo.OOXIXo BleRealtimeLog bleRealtimeLog) {
            BleHandleCallback.DefaultImpls.onReceiveRealtimeLog(this, bleRealtimeLog);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onReceiveRecordPacket(@OXOo.OOXIXo BleRecordPacket bleRecordPacket) {
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
        public void onRingVibrationSetUpdate(@OXOo.OOXIXo BleRingVibrationSettings bleRingVibrationSettings) {
            BleHandleCallback.DefaultImpls.onRingVibrationSetUpdate(this, bleRingVibrationSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSDCardInfoUpdate(@OXOo.OOXIXo BleSDCardInfo bleSDCardInfo) {
            BleHandleCallback.DefaultImpls.onSDCardInfoUpdate(this, bleSDCardInfo);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSGTestUpdate(@OXOo.OOXIXo BleSGTest bleSGTest) {
            BleHandleCallback.DefaultImpls.onSGTestUpdate(this, bleSGTest);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSOSSettingsUpdate(@OXOo.OOXIXo BleSOSSettings bleSOSSettings) {
            BleHandleCallback.DefaultImpls.onSOSSettingsUpdate(this, bleSOSSettings);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onScreenBrightnessSetUpdate(int i) {
            BleHandleCallback.DefaultImpls.onScreenBrightnessSetUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSessionStateChange(boolean z) {
            if (OnlineWatchFaceFragment.this.mCurSyncDialId != 0 && OnlineWatchFaceFragment.this.mCurSyncStatus == SyncStatus.SYNCING) {
                OnlineWatchFaceFragment.this.mCurSyncStatus = SyncStatus.FAILED;
            }
            OnlineWatchFaceFragment.this.getDslAdapter().notifyDataSetChanged();
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSosContactUpdate(@OXOo.OOXIXo BleSosContact bleSosContact) {
            BleHandleCallback.DefaultImpls.onSosContactUpdate(this, bleSosContact);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSportEndNotifyUpdate(int i) {
            BleHandleCallback.DefaultImpls.onSportEndNotifyUpdate(this, i);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onStandbyWatchFaceSetUpdate(@OXOo.OOXIXo BleStandbyWatchFaceSet bleStandbyWatchFaceSet) {
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
        public void onStreamProgress(boolean z, int i, int i2, int i3, @OXOo.OOXIXo BleKey bleKey) {
            IIX0o.x0xO0oo(bleKey, "bleKey");
            if (bleKey != BleKey.WATCH_FACE) {
                return;
            }
            if (z) {
                OnlineWatchFaceFragment.this.mCurSyncStatus = SyncStatus.SYNCING;
                BleInitializer bleInitializer = BleInitializer.f20700XO;
                bleInitializer.IXO(true);
                if (i2 == i3) {
                    OnlineWatchFaceFragment.this.mCurSyncStatus = SyncStatus.SYNCED;
                    OnlineWatchFaceFragment.this.mDialIds.set(OnlineWatchFaceFragment.this.mCurSyncDevicePosition, Integer.valueOf(OnlineWatchFaceFragment.this.mCurSyncDialId));
                    if (!ProductManager.f20544oIX0oI.OOoOoO0o()) {
                        Xo0.f24349oIX0oI.II0xO0().put("syncId", OnlineWatchFaceFragment.this.mCurSyncDialId);
                    }
                    x0xO0oo.II0xO0(x0xO0oo.f24584O00XxXI, null, 2, null);
                    OnlineWatchFaceFragment.this.getDslAdapter().notifyDataSetChanged();
                    bleInitializer.IXO(false);
                }
            } else {
                OnlineWatchFaceFragment.this.mCurSyncStatus = SyncStatus.FAILED;
                ToastUtils.showLong(oO.f24511oIX0oI.I0Io(i), new Object[0]);
                BleInitializer.f20700XO.IXO(false);
                OnlineWatchFaceFragment.this.mDialIds.set(OnlineWatchFaceFragment.this.mCurSyncDevicePosition, 0);
                if (!ProductManager.f20544oIX0oI.OOoOoO0o()) {
                    Xo0.f24349oIX0oI.II0xO0().put("syncId", 0);
                }
            }
            OnlineWatchFaceFragment.this.mCurSyncTotal = i2;
            OnlineWatchFaceFragment.this.mCurSyncCompleted = i3;
            OnlineWatchFaceFragment.this.getDslAdapter().notifyItemChanged(OnlineWatchFaceFragment.this.mCurSyncPosition, Integer.valueOf(OnlineWatchFaceFragment.this.mCurSyncDialId));
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onSyncData(int i, @OXOo.OOXIXo BleKey bleKey) {
            BleHandleCallback.DefaultImpls.onSyncData(this, i, bleKey);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onTimeUpdate() {
            BleHandleCallback.DefaultImpls.onTimeUpdate(this);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateAppSportState(@OXOo.OOXIXo BleAppSportState bleAppSportState) {
            BleHandleCallback.DefaultImpls.onUpdateAppSportState(this, bleAppSportState);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateBAC(@OXOo.OOXIXo BleBAC bleBAC) {
            BleHandleCallback.DefaultImpls.onUpdateBAC(this, bleBAC);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateBloodPressure(@OXOo.OOXIXo BleBloodPressure bleBloodPressure) {
            BleHandleCallback.DefaultImpls.onUpdateBloodPressure(this, bleBloodPressure);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateHeartRate(@OXOo.OOXIXo BleHeartRate bleHeartRate) {
            BleHandleCallback.DefaultImpls.onUpdateHeartRate(this, bleHeartRate);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateTemperature(@OXOo.OOXIXo BleTemperature bleTemperature) {
            BleHandleCallback.DefaultImpls.onUpdateTemperature(this, bleTemperature);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUpdateWatchFaceSwitch(boolean z) {
            BleHandleCallback.DefaultImpls.onUpdateWatchFaceSwitch(this, z);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onUserProfileUpdate(@OXOo.OOXIXo BleUserProfile bleUserProfile) {
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
        public void onWatchFaceIndexUpdate(@OXOo.OOXIXo BleWatchFaceIndex bleWatchFaceIndex) {
            BleHandleCallback.DefaultImpls.onWatchFaceIndexUpdate(this, bleWatchFaceIndex);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onWatchPasswordUpdate(@OXOo.OOXIXo BleSettingWatchPassword bleSettingWatchPassword) {
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
        public static final /* synthetic */ int[] f22802oIX0oI;

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
            f22802oIX0oI = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public final void findData(List<OnlineWatchFaceV2> list) {
        Boolean bool;
        boolean z;
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " listSize = " + list.size());
        for (final OnlineWatchFaceV2 onlineWatchFaceV2 : list) {
            if (!this.isNoShowTitle) {
                WatchFaceCategoryV2[] watchFaceList = onlineWatchFaceV2.getWatchFaceList();
                if (watchFaceList != null) {
                    if (watchFaceList.length == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bool = Boolean.valueOf(!z);
                } else {
                    bool = null;
                }
                IIX0o.ooOOo0oXI(bool);
                if (bool.booleanValue()) {
                    DslAdapterExKt.oO(getDslAdapter(), R.layout.layout_online_watchface_category_head, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$findData$1
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
                        public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                            IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                            dslItem.setItemIsGroupHead(true);
                            dslItem.setItemIsHover(false);
                            dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(OnlineWatchFaceV2.this.getTypeName()));
                            final OnlineWatchFaceV2 onlineWatchFaceV22 = OnlineWatchFaceV2.this;
                            dslItem.setItemBindOverride(new Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$findData$1.1
                                {
                                    super(4);
                                }

                                @Override // Oox.Oxx0xo
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list2) {
                                    invoke(dslViewHolder, num.intValue(), dslAdapterItem, list2);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list2) {
                                    IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                    IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                    IIX0o.x0xO0oo(list2, "<anonymous parameter 3>");
                                    TextView tv = itemHolder.tv(R.id.tv_name);
                                    if (tv == null) {
                                        return;
                                    }
                                    tv.setText(OnlineWatchFaceV2.this.getTypeName());
                                }
                            });
                            dslItem.setItemTag(OnlineWatchFaceV2.this.getTypeName());
                            final OnlineWatchFaceFragment onlineWatchFaceFragment = this;
                            final OnlineWatchFaceV2 onlineWatchFaceV23 = OnlineWatchFaceV2.this;
                            dslItem.setItemClick(new Oox.oOoXoXO<View, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$findData$1.2
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
                                public final void invoke2(@OXOo.OOXIXo View it) {
                                    String str;
                                    String str2;
                                    IIX0o.x0xO0oo(it, "it");
                                    if (OnlineWatchFaceFragment.this.isSync()) {
                                        ToastUtils.showLong(R.string.syncing_remind);
                                        return;
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    str = OnlineWatchFaceFragment.this.TAG;
                                    sb.append(str);
                                    sb.append(" move");
                                    LogUtils.d(sb.toString());
                                    ArrayList arrayList = new ArrayList();
                                    WatchFaceCategoryV2[] watchFaceList2 = onlineWatchFaceV23.getWatchFaceList();
                                    ArrayList arrayList2 = new ArrayList(watchFaceList2.length);
                                    for (WatchFaceCategoryV2 watchFaceCategoryV2 : watchFaceList2) {
                                        if (!IIX0o.Oxx0IOOO(watchFaceCategoryV2.getMemberAttr(), "1")) {
                                            arrayList.add(new WatchFaceInfo(watchFaceCategoryV2.getId(), watchFaceCategoryV2.getPreviewUrl(), watchFaceCategoryV2.getBinUrl()));
                                        }
                                        arrayList2.add(oXIO0o0XI.f29392oIX0oI);
                                    }
                                    StringBuilder sb2 = new StringBuilder();
                                    str2 = OnlineWatchFaceFragment.this.TAG;
                                    sb2.append(str2);
                                    sb2.append(" move   mList = ");
                                    sb2.append(arrayList.size());
                                    LogUtils.d(sb2.toString());
                                    Xo0.f24349oIX0oI.I0Io().put(XoI0Ixx0.f24488xo0x + '_' + WatchFaceInfo[].class.getName(), new Gson().toJson(CollectionsKt___CollectionsKt.OOoOoO0o(arrayList).toArray(new WatchFaceInfo[0])));
                                    int parseInt = Integer.parseInt(onlineWatchFaceV23.getTypeId());
                                    String typeName = onlineWatchFaceV23.getTypeName();
                                    OnlineWatchFaceFragment onlineWatchFaceFragment2 = OnlineWatchFaceFragment.this;
                                    Bundle bundle = new Bundle();
                                    bundle.putString("mArg0", typeName);
                                    bundle.putInt("mArg1", parseInt);
                                    bundle.putParcelable("mArg2", null);
                                    bundle.putSerializable("mArg3", null);
                                    Intent intent = new Intent(onlineWatchFaceFragment2.getActivity(), (Class<?>) DialActivity.class);
                                    intent.putExtras(bundle);
                                    onlineWatchFaceFragment2.startActivity(intent);
                                }
                            });
                        }
                    });
                }
            }
            if (onlineWatchFaceV2.getWatchFaceList() != null) {
                WatchFaceCategoryV2[] watchFaceList2 = onlineWatchFaceV2.getWatchFaceList();
                List<WatchFaceCategoryV2> arrayList = new ArrayList();
                for (WatchFaceCategoryV2 watchFaceCategoryV2 : watchFaceList2) {
                    if (!IIX0o.Oxx0IOOO(watchFaceCategoryV2.getMemberAttr(), "1")) {
                        arrayList.add(watchFaceCategoryV2);
                    }
                }
                if (!this.isNoShowTitle) {
                    arrayList = CollectionsKt___CollectionsKt.O0o000XOX(arrayList, 6);
                } else if (Integer.parseInt(onlineWatchFaceV2.getTypeId()) == 1) {
                    arrayList = CollectionsKt__CollectionsKt.ooXIXxIX();
                }
                for (final WatchFaceCategoryV2 watchFaceCategoryV22 : arrayList) {
                    DslAdapterExKt.oO(getDslAdapter(), R.layout.item_dial_f3, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$findData$2

                        /* renamed from: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$findData$2$1, reason: invalid class name */
                        /* loaded from: classes12.dex */
                        public static final class AnonymousClass1 extends Lambda implements Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI> {
                            final /* synthetic */ OnlineWatchFaceV2 $category;
                            final /* synthetic */ WatchFaceCategoryV2 $item;
                            final /* synthetic */ OnlineWatchFaceFragment this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(WatchFaceCategoryV2 watchFaceCategoryV2, OnlineWatchFaceFragment onlineWatchFaceFragment, OnlineWatchFaceV2 onlineWatchFaceV2) {
                                super(4);
                                this.$item = watchFaceCategoryV2;
                                this.this$0 = onlineWatchFaceFragment;
                                this.$category = onlineWatchFaceV2;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final void invoke$lambda$0(final OnlineWatchFaceFragment this$0, final int i, final OnlineWatchFaceV2 category, final int i2, final ProgressButton progressButton, final WatchFaceCategoryV2 item, View view) {
                                IIX0o.x0xO0oo(this$0, "this$0");
                                IIX0o.x0xO0oo(category, "$category");
                                IIX0o.x0xO0oo(progressButton, "$progressButton");
                                IIX0o.x0xO0oo(item, "$item");
                                if (this$0.isSync()) {
                                    ToastUtils.showLong(R.string.syncing_remind);
                                } else if (this$0.mDialIds.contains(Integer.valueOf(i))) {
                                    ToastUtils.showLong(R.string.dial_sync_done);
                                } else {
                                    com.sma.smartv3.ble.I0Io.II0xO0(false, 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0045: INVOKE 
                                          false
                                          (wrap:Oox.oOoXoXO<com.szabh.smable3.component.BleConnector, kotlin.oXIO0o0XI>:0x003f: CONSTRUCTOR 
                                          (r7v0 'this$0' com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment A[DONT_INLINE])
                                          (r9v0 'category' com.sma.smartv3.model.OnlineWatchFaceV2 A[DONT_INLINE])
                                          (r8v0 'i' int A[DONT_INLINE])
                                          (r10v0 'i2' int A[DONT_INLINE])
                                          (r11v0 'progressButton' com.sma.smartv3.view.ProgressButton A[DONT_INLINE])
                                          (r12v0 'item' com.sma.smartv3.model.WatchFaceCategoryV2 A[DONT_INLINE])
                                         A[MD:(com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment, com.sma.smartv3.model.OnlineWatchFaceV2, int, int, com.sma.smartv3.view.ProgressButton, com.sma.smartv3.model.WatchFaceCategoryV2):void (m), WRAPPED] (LINE:64) call: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$findData$2$1$1$1.<init>(com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment, com.sma.smartv3.model.OnlineWatchFaceV2, int, int, com.sma.smartv3.view.ProgressButton, com.sma.smartv3.model.WatchFaceCategoryV2):void type: CONSTRUCTOR)
                                          (1 int)
                                          (null java.lang.Object)
                                         STATIC call: com.sma.smartv3.ble.I0Io.II0xO0(boolean, Oox.oOoXoXO, int, java.lang.Object):boolean A[MD:(boolean, Oox.oOoXoXO, int, java.lang.Object):boolean (m)] (LINE:70) in method: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$findData$2.1.invoke$lambda$0(com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment, int, com.sma.smartv3.model.OnlineWatchFaceV2, int, com.sma.smartv3.view.ProgressButton, com.sma.smartv3.model.WatchFaceCategoryV2, android.view.View):void, file: classes12.dex
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
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$findData$2$1$1$1, state: NOT_LOADED
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
                                        java.util.List r13 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$getMDialIds$p(r7)
                                        java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
                                        boolean r13 = r13.contains(r0)
                                        if (r13 == 0) goto L36
                                        r7 = 2132018296(0x7f140478, float:1.9674895E38)
                                        com.blankj.utilcode.util.ToastUtils.showLong(r7)
                                        return
                                    L36:
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$findData$2$1$1$1 r13 = new com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$findData$2$1$1$1
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
                                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$findData$2.AnonymousClass1.invoke$lambda$0(com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment, int, com.sma.smartv3.model.OnlineWatchFaceV2, int, com.sma.smartv3.view.ProgressButton, com.sma.smartv3.model.WatchFaceCategoryV2, android.view.View):void");
                                }

                                @Override // Oox.Oxx0xo
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                    invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, final int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> payloads) {
                                    IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                    IIX0o.x0xO0oo(adapterItem, "adapterItem");
                                    IIX0o.x0xO0oo(payloads, "payloads");
                                    final int id = this.$item.getId();
                                    View v = itemHolder.v(R.id.item_dial_new_ll);
                                    if (v != null) {
                                        v.setVisibility((this.$item.getNewFlag() && ProjectManager.f19822oIX0oI.IxIX0I()) ? 0 : 8);
                                    }
                                    View v2 = itemHolder.v(R.id.pb);
                                    IIX0o.ooOOo0oXI(v2);
                                    final ProgressButton progressButton = (ProgressButton) v2;
                                    if (this.this$0.mCurSyncDialId == id && !payloads.isEmpty()) {
                                        OnlineWatchFaceFragment onlineWatchFaceFragment = this.this$0;
                                        onlineWatchFaceFragment.syncStatusChange(progressButton, onlineWatchFaceFragment.mCurSyncStatus);
                                        return;
                                    }
                                    ProgressButton.X0o0xo(progressButton, R.string.sync, false, 2, null);
                                    if (this.this$0.mCurSyncDialId != id) {
                                        if (this.this$0.mDialIds.contains(Integer.valueOf(id))) {
                                            progressButton.I0Io(R.string.synced, true);
                                        }
                                    } else {
                                        OnlineWatchFaceFragment onlineWatchFaceFragment2 = this.this$0;
                                        onlineWatchFaceFragment2.syncStatusChange(progressButton, onlineWatchFaceFragment2.mCurSyncStatus);
                                    }
                                    final OnlineWatchFaceFragment onlineWatchFaceFragment3 = this.this$0;
                                    final OnlineWatchFaceV2 onlineWatchFaceV2 = this.$category;
                                    final WatchFaceCategoryV2 watchFaceCategoryV2 = this.$item;
                                    progressButton.setOnClickListener(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009c: INVOKE 
                                          (r10v7 'progressButton' com.sma.smartv3.view.ProgressButton)
                                          (wrap:android.view.View$OnClickListener:0x0099: CONSTRUCTOR 
                                          (r1v3 'onlineWatchFaceFragment3' com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment A[DONT_INLINE])
                                          (r2v0 'id' int A[DONT_INLINE])
                                          (r3v1 'onlineWatchFaceV2' com.sma.smartv3.model.OnlineWatchFaceV2 A[DONT_INLINE])
                                          (r9v0 'i' int A[DONT_INLINE])
                                          (r10v7 'progressButton' com.sma.smartv3.view.ProgressButton A[DONT_INLINE])
                                          (r6v0 'watchFaceCategoryV2' com.sma.smartv3.model.WatchFaceCategoryV2 A[DONT_INLINE])
                                         A[MD:(com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment, int, com.sma.smartv3.model.OnlineWatchFaceV2, int, com.sma.smartv3.view.ProgressButton, com.sma.smartv3.model.WatchFaceCategoryV2):void (m), WRAPPED] call: com.sma.smartv3.ui.device.watchface.fragment.Oxx0IOOO.<init>(com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment, int, com.sma.smartv3.model.OnlineWatchFaceV2, int, com.sma.smartv3.view.ProgressButton, com.sma.smartv3.model.WatchFaceCategoryV2):void type: CONSTRUCTOR)
                                         VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$findData$2.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
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
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.watchface.fragment.Oxx0IOOO, state: NOT_LOADED
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
                                        com.sma.smartv3.model.WatchFaceCategoryV2 r10 = r7.$item
                                        int r2 = r10.getId()
                                        r10 = 2131364827(0x7f0a0bdb, float:1.8349502E38)
                                        android.view.View r10 = r8.v(r10)
                                        r0 = 0
                                        if (r10 != 0) goto L20
                                        goto L37
                                    L20:
                                        com.sma.smartv3.model.WatchFaceCategoryV2 r1 = r7.$item
                                        boolean r1 = r1.getNewFlag()
                                        if (r1 == 0) goto L32
                                        com.sma.smartv3.app.ProjectManager r1 = com.sma.smartv3.app.ProjectManager.f19822oIX0oI
                                        boolean r1 = r1.IxIX0I()
                                        if (r1 == 0) goto L32
                                        r1 = 0
                                        goto L34
                                    L32:
                                        r1 = 8
                                    L34:
                                        r10.setVisibility(r1)
                                    L37:
                                        r10 = 2131366812(0x7f0a139c, float:1.8353528E38)
                                        android.view.View r10 = r8.v(r10)
                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r10)
                                        com.sma.smartv3.view.ProgressButton r10 = (com.sma.smartv3.view.ProgressButton) r10
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r1 = r7.this$0
                                        int r1 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$getMCurSyncDialId$p(r1)
                                        if (r1 != r2) goto L5d
                                        java.util.Collection r11 = (java.util.Collection) r11
                                        boolean r11 = r11.isEmpty()
                                        if (r11 != 0) goto L5d
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r8 = r7.this$0
                                        com.sma.smartv3.model.SyncStatus r9 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$getMCurSyncStatus$p(r8)
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$syncStatusChange(r8, r10, r9)
                                        return
                                    L5d:
                                        r11 = 2
                                        r1 = 0
                                        r3 = 2132021746(0x7f1411f2, float:1.9681892E38)
                                        com.sma.smartv3.view.ProgressButton.X0o0xo(r10, r3, r0, r11, r1)
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r11 = r7.this$0
                                        int r11 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$getMCurSyncDialId$p(r11)
                                        if (r11 != r2) goto L77
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r11 = r7.this$0
                                        com.sma.smartv3.model.SyncStatus r0 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$getMCurSyncStatus$p(r11)
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$syncStatusChange(r11, r10, r0)
                                        goto L8e
                                    L77:
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r11 = r7.this$0
                                        java.util.List r11 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$getMDialIds$p(r11)
                                        java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
                                        boolean r11 = r11.contains(r0)
                                        if (r11 == 0) goto L8e
                                        r11 = 2132021752(0x7f1411f8, float:1.9681904E38)
                                        r0 = 1
                                        r10.I0Io(r11, r0)
                                    L8e:
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r1 = r7.this$0
                                        com.sma.smartv3.model.OnlineWatchFaceV2 r3 = r7.$category
                                        com.sma.smartv3.model.WatchFaceCategoryV2 r6 = r7.$item
                                        com.sma.smartv3.ui.device.watchface.fragment.Oxx0IOOO r11 = new com.sma.smartv3.ui.device.watchface.fragment.Oxx0IOOO
                                        r0 = r11
                                        r4 = r9
                                        r5 = r10
                                        r0.<init>(r1, r2, r3, r4, r5, r6)
                                        r10.setOnClickListener(r11)
                                        r9 = 2131364945(0x7f0a0c51, float:1.8349741E38)
                                        android.view.View r8 = r8.v(r9)
                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r8)
                                        com.sma.smartv3.view.SquareImageView r8 = (com.sma.smartv3.view.SquareImageView) r8
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r9 = r7.this$0
                                        android.content.Context r9 = r9.requireContext()
                                        com.bumptech.glide.RequestManager r9 = com.bumptech.glide.Glide.with(r9)
                                        com.sma.smartv3.model.WatchFaceCategoryV2 r10 = r7.$item
                                        java.lang.String r10 = r10.getPreviewUrl()
                                        com.bumptech.glide.RequestBuilder r9 = r9.load(r10)
                                        r9.into(r8)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$findData$2.AnonymousClass1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
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
                            public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(OnlineWatchFaceV2.this.getTypeName()));
                                dslItem.setItemBindOverride(new AnonymousClass1(watchFaceCategoryV22, this, OnlineWatchFaceV2.this));
                            }
                        });
                    }
                } else {
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TextView getEmptyView() {
            return (TextView) this.emptyView$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void initData() {
            renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$initData$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                    invoke2(dslAdapter);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter) {
                    IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                    DslViewHolder dslViewHolder = OnlineWatchFaceFragment.this.getDslViewHolder();
                    final OnlineWatchFaceFragment onlineWatchFaceFragment = OnlineWatchFaceFragment.this;
                    dslViewHolder.postDelay(300L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$initData$1.1
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
                            final OnlineWatchFaceFragment onlineWatchFaceFragment2 = OnlineWatchFaceFragment.this;
                            onlineWatchFaceFragment2.renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.initData.1.1.1
                                {
                                    super(1);
                                }

                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                    invoke2(dslAdapter);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* JADX WARN: Code restructure failed: missing block: B:3:0x0015, code lost:
                                
                                    r7 = r1.mWatchFaceList;
                                 */
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct add '--show-bad-code' argument
                                */
                                public final void invoke2(@OXOo.OOXIXo com.angcyo.dsladapter.DslAdapter r7) {
                                    /*
                                        r6 = this;
                                        java.lang.String r0 = "$this$renderAdapter"
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
                                        r0 = 2
                                        r1 = 0
                                        r2 = 0
                                        com.angcyo.dsladapter.DslAdapter.setAdapterStatus$default(r7, r1, r2, r0, r2)
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.this
                                        java.util.List r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$getMWatchFaceList$p(r7)
                                        r0 = 8
                                        if (r7 == 0) goto Lbb
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.this
                                        java.util.List r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$getMWatchFaceList$p(r7)
                                        if (r7 == 0) goto L25
                                        int r7 = r7.size()
                                        if (r7 != 0) goto L25
                                        goto Lbb
                                    L25:
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.this
                                        java.util.List r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$getMWatchFaceList$p(r7)
                                        r3 = 1
                                        if (r7 == 0) goto L68
                                        java.lang.Iterable r7 = (java.lang.Iterable) r7
                                        java.util.ArrayList r4 = new java.util.ArrayList
                                        r5 = 10
                                        int r5 = kotlin.collections.OxxIIOOXO.xo0x(r7, r5)
                                        r4.<init>(r5)
                                        java.util.Iterator r7 = r7.iterator()
                                    L3f:
                                        boolean r5 = r7.hasNext()
                                        if (r5 == 0) goto L68
                                        java.lang.Object r5 = r7.next()
                                        com.sma.smartv3.model.OnlineWatchFaceV2 r5 = (com.sma.smartv3.model.OnlineWatchFaceV2) r5
                                        com.sma.smartv3.model.WatchFaceCategoryV2[] r5 = r5.getWatchFaceList()
                                        if (r5 == 0) goto L57
                                        int r5 = r5.length
                                        java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                                        goto L58
                                    L57:
                                        r5 = r2
                                    L58:
                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r5)
                                        int r5 = r5.intValue()
                                        if (r5 <= 0) goto L62
                                        r3 = 0
                                    L62:
                                        kotlin.oXIO0o0XI r5 = kotlin.oXIO0o0XI.f29392oIX0oI
                                        r4.add(r5)
                                        goto L3f
                                    L68:
                                        if (r3 == 0) goto L7d
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.this
                                        androidx.recyclerview.widget.RecyclerView r7 = r7.getRecyclerView()
                                        r7.setVisibility(r0)
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.this
                                        android.widget.TextView r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$getEmptyView(r7)
                                        r7.setVisibility(r1)
                                        goto L9b
                                    L7d:
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.this
                                        androidx.recyclerview.widget.RecyclerView r7 = r7.getRecyclerView()
                                        r7.setVisibility(r1)
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.this
                                        android.widget.TextView r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$getEmptyView(r7)
                                        r7.setVisibility(r0)
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.this
                                        java.util.List r0 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$getMWatchFaceList$p(r7)
                                        kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$findData(r7, r0)
                                    L9b:
                                        OI0.oIX0oI r7 = OI0.oIX0oI.f1507oIX0oI
                                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                        r0.<init>()
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r1 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.this
                                        java.lang.String r1 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$getTAG$p(r1)
                                        r0.append(r1)
                                        java.lang.String r1 = " isEmptyData = "
                                        r0.append(r1)
                                        r0.append(r3)
                                        java.lang.String r0 = r0.toString()
                                        r7.oIX0oI(r0)
                                        goto Lcd
                                    Lbb:
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.this
                                        androidx.recyclerview.widget.RecyclerView r7 = r7.getRecyclerView()
                                        r7.setVisibility(r0)
                                        com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.this
                                        android.widget.TextView r7 = com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment.access$getEmptyView(r7)
                                        r7.setVisibility(r1)
                                    Lcd:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$initData$1.AnonymousClass1.C09611.invoke2(com.angcyo.dsladapter.DslAdapter):void");
                                }
                            });
                        }
                    });
                }
            });
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
        public final void syncDial(int i, int i2, int i3, final ProgressButton progressButton, final WatchFaceCategoryV2 watchFaceCategoryV2, final int i4) {
            WatchFaceManager.f20245oIX0oI.oIX0oI(String.valueOf(i));
            LogUtils.d("syncDial -> position:" + i2 + ", mCurSyncPosition:" + i3 + ", mCurSyncDialId:" + i);
            OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append("syncDial -> category = ");
            sb.append(i4);
            oix0oi.oIX0oI(sb.toString());
            this.mCurSyncDialId = i;
            this.mCurSyncPosition = i2;
            this.mCurSyncStatus = SyncStatus.DOWNLOAD;
            this.mCurSyncDevicePosition = i3;
            StringBuilder sb2 = new StringBuilder();
            BleCache bleCache = BleCache.INSTANCE;
            sb2.append(bleCache.getMPrototype());
            sb2.append('_');
            sb2.append(bleCache.getMBleName());
            sb2.append('_');
            sb2.append(watchFaceCategoryV2.getId());
            sb2.append(".bin");
            this.mBinFileName = sb2.toString();
            X00IoxXI.oIX0oI oix0oi2 = X00IoxXI.oIX0oI.f3233oIX0oI;
            File XI0IXoo2 = IXxxXO.XI0IXoo(oix0oi2);
            String str = this.mBinFileName;
            String str2 = null;
            if (str == null) {
                IIX0o.XOxIOxOx("mBinFileName");
                str = null;
            }
            final File file = new File(XI0IXoo2, str);
            final File file2 = new File(IXxxXO.XI0IXoo(oix0oi2), bleCache.getMPrototype() + '_' + bleCache.getMBleName() + '_' + watchFaceCategoryV2.getId());
            if (file.exists()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("syncDial -> dial try get from dialFile file = ");
                String str3 = this.mBinFileName;
                if (str3 == null) {
                    IIX0o.XOxIOxOx("mBinFileName");
                    str3 = null;
                }
                sb3.append(str3);
                sb3.append(" size:");
                sb3.append(FileUtils.getSize(file));
                oix0oi.oIX0oI(sb3.toString());
                ProgressButton.X0o0xo(progressButton, R.string.syncing, false, 2, null);
                sendDial();
                return;
            }
            ProgressButton.X0o0xo(progressButton, R.string.downloading, false, 2, null);
            NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
            String binUrl = watchFaceCategoryV2.getBinUrl();
            String absolutePath = IXxxXO.XI0IXoo(oix0oi2).getAbsolutePath();
            IIX0o.oO(absolutePath, "getAbsolutePath(...)");
            String str4 = this.mBinFileName;
            if (str4 == null) {
                IIX0o.XOxIOxOx("mBinFileName");
            } else {
                str2 = str4;
            }
            netWorkUtils.download(binUrl, absolutePath, str2, new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$syncDial$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
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
                public void handleResponse(@OXOo.oOoXoXO String str5) {
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("syncDial -> dial try get from net");
                    StatManager.f20200oIX0oI.I0Io(WatchFaceCategoryV2.this.getBinUrl(), FileUtils.getLength(file), i4, WatchFaceCategoryV2.this.getId());
                    if (!FileUtils.isFileExists(file2)) {
                        FileUtils.createOrExistsFile(file2);
                        FileIOUtils.writeFileFromString(file2, WatchFaceCategoryV2.this.getPreviewUrl(), false);
                    }
                    ProgressButton.X0o0xo(progressButton, R.string.syncing, false, 2, null);
                    this.sendDial();
                }
            });
        }

        public static /* synthetic */ void syncDial$default(OnlineWatchFaceFragment onlineWatchFaceFragment, int i, int i2, int i3, ProgressButton progressButton, WatchFaceCategoryV2 watchFaceCategoryV2, int i4, int i5, Object obj) {
            int i6;
            if ((i5 & 32) != 0) {
                i6 = 0;
            } else {
                i6 = i4;
            }
            onlineWatchFaceFragment.syncDial(i, i2, i3, progressButton, watchFaceCategoryV2, i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void syncStatusChange(ProgressButton progressButton, SyncStatus syncStatus) {
            int i = oIX0oI.f22802oIX0oI[syncStatus.ordinal()];
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
        @OXOo.OOXIXo
        public DslAdapterStatusItem adapterStatusItem() {
            setAdapterStatus(new AdapterStatusItem());
            return getAdapterStatus();
        }

        @Override // com.bestmafen.androidbase.base.oIX0oI
        public void init(@OXOo.oOoXoXO Bundle bundle) {
            BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
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
            return R.layout.fragment_online_watchface_2;
        }

        @XO0.XO(tag = AGPSInitializer.f20668IXxxXO)
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
            renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$onInitBaseLayoutAfter$2
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                    invoke2(dslAdapter);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter) {
                    IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                    DslAdapter.setAdapterStatus$default(renderAdapter, 2, null, 2, null);
                }
            });
            IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI);
            this.isNoShowTitle = false;
            if (ProductManager.f20544oIX0oI.OXXoIoXI()) {
                this.isNoShowTitle = false;
            }
            WatchFaceManager.f20245oIX0oI.II0xO0(!this.isNoShowTitle, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.watchface.fragment.OnlineWatchFaceFragment$onInitBaseLayoutAfter$3
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return oXIO0o0XI.f29392oIX0oI;
                }

                public final void invoke(boolean z) {
                    Collection ooXIXxIX2;
                    if (z) {
                        OnlineWatchFaceFragment onlineWatchFaceFragment = OnlineWatchFaceFragment.this;
                        try {
                            JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24362IIxOXoOo0)).getAsJsonArray();
                            IIX0o.ooOOo0oXI(asJsonArray);
                            ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
                            Iterator<JsonElement> it = asJsonArray.iterator();
                            while (it.hasNext()) {
                                ooXIXxIX2.add(new Gson().fromJson(it.next(), OnlineWatchFaceV2.class));
                            }
                        } catch (Exception unused) {
                            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                        }
                        onlineWatchFaceFragment.mWatchFaceList = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
                    }
                    OnlineWatchFaceFragment.this.initData();
                }
            });
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            this.mDialIds.set(0, Integer.valueOf(Xo0.f24349oIX0oI.II0xO0().getInt("syncId", 0)));
            LogUtils.d(this.TAG + "  mDialIds -> " + this.mDialIds);
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
