package com.sma.smartv3.ui.me;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import com.bestmafen.androidbase.list.BaseListActivity;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.WatchFaceInfo;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.ui.me.DeveloperWatchFaceStressTestActivity;
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
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@kotlin.jvm.internal.XX({"SMAP\nDeveloperWatchFaceStressTestActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperWatchFaceStressTestActivity.kt\ncom/sma/smartv3/ui/me/DeveloperWatchFaceStressTestActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,288:1\n50#2,3:289\n53#2:295\n55#2,2:297\n1549#3:292\n1620#3,2:293\n1622#3:296\n254#4:299\n256#4,2:300\n256#4,2:302\n256#4,2:304\n256#4,2:306\n*S KotlinDebug\n*F\n+ 1 DeveloperWatchFaceStressTestActivity.kt\ncom/sma/smartv3/ui/me/DeveloperWatchFaceStressTestActivity\n*L\n136#1:289,3\n136#1:295\n136#1:297,2\n136#1:292\n136#1:293,2\n136#1:296\n146#1:299\n275#1:300,2\n276#1:302,2\n278#1:304,2\n279#1:306,2\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperWatchFaceStressTestActivity extends BaseListActivity<WatchFaceInfo> {
    private List<WatchFaceInfo> dataList;
    private boolean isSkipFailed;
    private int mCurTestFailedTime;
    private int mCurTestSuccessTime;
    private int mCurTestTime;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xOOOX mProgressPop;

    @OXOo.OOXIXo
    private final String TAG = "WatchFaceStressTest";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btStart$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AppCompatButton>() { // from class: com.sma.smartv3.ui.me.DeveloperWatchFaceStressTestActivity$btStart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AppCompatButton invoke() {
            return (AppCompatButton) DeveloperWatchFaceStressTestActivity.this.findViewById(R.id.bt_start);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btStop$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AppCompatButton>() { // from class: com.sma.smartv3.ui.me.DeveloperWatchFaceStressTestActivity$btStop$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AppCompatButton invoke() {
            return (AppCompatButton) DeveloperWatchFaceStressTestActivity.this.findViewById(R.id.bt_stop);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvStatus$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperWatchFaceStressTestActivity$tvStatus$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperWatchFaceStressTestActivity.this.findViewById(R.id.tv_status);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO cbSkipCheckBox$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.me.DeveloperWatchFaceStressTestActivity$cbSkipCheckBox$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) DeveloperWatchFaceStressTestActivity.this.findViewById(R.id.cb_skip_failed);
        }
    });

    @OXOo.OOXIXo
    private final oIX0oI mBleHandleCallback = new oIX0oI();

    @kotlin.jvm.internal.XX({"SMAP\nDeveloperWatchFaceStressTestActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperWatchFaceStressTestActivity.kt\ncom/sma/smartv3/ui/me/DeveloperWatchFaceStressTestActivity$mBleHandleCallback$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,288:1\n254#2:289\n254#2:290\n254#2:291\n*S KotlinDebug\n*F\n+ 1 DeveloperWatchFaceStressTestActivity.kt\ncom/sma/smartv3/ui/me/DeveloperWatchFaceStressTestActivity$mBleHandleCallback$1\n*L\n81#1:289\n106#1:290\n119#1:291\n*E\n"})
    /* loaded from: classes11.dex */
    public static final class oIX0oI implements BleHandleCallback {
        public oIX0oI() {
        }

        public static final void I0Io(DeveloperWatchFaceStressTestActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            AppCompatButton btStop = this$0.getBtStop();
            kotlin.jvm.internal.IIX0o.oO(btStop, "access$getBtStop(...)");
            if (btStop.getVisibility() == 0) {
                BleConnector.sendData$default(BleConnector.INSTANCE, BleKey.PACKAGE_STATUS, BleKeyFlag.READ, null, false, false, 28, null);
            }
        }

        public static final void oxoX(DeveloperWatchFaceStressTestActivity this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            AppCompatButton btStop = this$0.getBtStop();
            kotlin.jvm.internal.IIX0o.oO(btStop, "access$getBtStop(...)");
            if (btStop.getVisibility() == 0) {
                this$0.mCurTestTime--;
                this$0.startTest();
            }
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
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKey, "bleKey");
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
            if (bleKey == BleKey.WATCH_FACE) {
                DeveloperWatchFaceStressTestActivity.this.testFailed("BleKey.WATCH_FACE send timeout");
            } else if (bleKey == BleKey.PACKAGE_STATUS) {
                DeveloperWatchFaceStressTestActivity.this.testFailed("BleKey.PACKAGE_STATUS send timeout");
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
        public void onReadPackageStatus(@OXOo.OOXIXo BlePackageStatus packageStatus) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(packageStatus, "packageStatus");
            AppCompatButton btStop = DeveloperWatchFaceStressTestActivity.this.getBtStop();
            kotlin.jvm.internal.IIX0o.oO(btStop, "access$getBtStop(...)");
            if (btStop.getVisibility() == 0) {
                if (packageStatus.getMUIPackageStatus() == 1) {
                    DeveloperWatchFaceStressTestActivity.this.testFailed("ui error");
                } else {
                    if (packageStatus.getMFontPackageStatus() == 1) {
                        DeveloperWatchFaceStressTestActivity.this.testFailed("font error");
                        return;
                    }
                    DeveloperWatchFaceStressTestActivity.this.mCurTestSuccessTime++;
                    DeveloperWatchFaceStressTestActivity.this.startNextTest();
                }
            }
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
            if (!z && DeveloperWatchFaceStressTestActivity.this.mProgressPop != null) {
                DeveloperWatchFaceStressTestActivity.this.testFailed("Disconnected");
            }
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
            kotlin.jvm.internal.IIX0o.x0xO0oo(bleKey, "bleKey");
            if (z) {
                com.sma.smartv3.pop.xOOOX xooox = DeveloperWatchFaceStressTestActivity.this.mProgressPop;
                if (xooox != null) {
                    xooox.XIxXXX0x0((int) ((i3 / i2) * 100));
                }
                if (i2 == i3) {
                    com.sma.smartv3.pop.xOOOX xooox2 = DeveloperWatchFaceStressTestActivity.this.mProgressPop;
                    if (xooox2 != null) {
                        xooox2.dismiss();
                    }
                    DeveloperWatchFaceStressTestActivity.this.mProgressPop = null;
                    Handler handler = new Handler();
                    final DeveloperWatchFaceStressTestActivity developerWatchFaceStressTestActivity = DeveloperWatchFaceStressTestActivity.this;
                    handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.Oxo00O
                        @Override // java.lang.Runnable
                        public final void run() {
                            DeveloperWatchFaceStressTestActivity.oIX0oI.I0Io(DeveloperWatchFaceStressTestActivity.this);
                        }
                    }, 3000L);
                    return;
                }
                return;
            }
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_SIFLI) && i == 2) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(DeveloperWatchFaceStressTestActivity.this.TAG + " testFailed -> If the capacity is insufficient, empty the watchface first!");
                BleConnector.sendData$default(BleConnector.INSTANCE, BleKey.WATCH_FACE, BleKeyFlag.DELETE, null, false, false, 28, null);
                Handler handler2 = new Handler();
                final DeveloperWatchFaceStressTestActivity developerWatchFaceStressTestActivity2 = DeveloperWatchFaceStressTestActivity.this;
                handler2.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.Ix0
                    @Override // java.lang.Runnable
                    public final void run() {
                        DeveloperWatchFaceStressTestActivity.oIX0oI.oxoX(DeveloperWatchFaceStressTestActivity.this);
                    }
                }, 1000L);
                return;
            }
            DeveloperWatchFaceStressTestActivity.this.testFailed("errorCode:" + i);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeBtn(boolean z) {
        if (z) {
            AppCompatButton btStart = getBtStart();
            kotlin.jvm.internal.IIX0o.oO(btStart, "<get-btStart>(...)");
            btStart.setVisibility(8);
            AppCompatButton btStop = getBtStop();
            kotlin.jvm.internal.IIX0o.oO(btStop, "<get-btStop>(...)");
            btStop.setVisibility(0);
            return;
        }
        AppCompatButton btStart2 = getBtStart();
        kotlin.jvm.internal.IIX0o.oO(btStart2, "<get-btStart>(...)");
        btStart2.setVisibility(0);
        AppCompatButton btStop2 = getBtStop();
        kotlin.jvm.internal.IIX0o.oO(btStop2, "<get-btStop>(...)");
        btStop2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeStatus() {
        getTvStatus().setText("当前测试" + this.mCurTestTime + "次，成功" + this.mCurTestSuccessTime + "次，失败" + this.mCurTestFailedTime + (char) 27425);
    }

    private final AppCompatButton getBtStart() {
        return (AppCompatButton) this.btStart$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatButton getBtStop() {
        return (AppCompatButton) this.btStop$delegate.getValue();
    }

    private final CheckBox getCbSkipCheckBox() {
        return (CheckBox) this.cbSkipCheckBox$delegate.getValue();
    }

    private final TextView getTvStatus() {
        return (TextView) this.tvStatus$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startNextTest() {
        int i = this.mCurTestTime;
        List<WatchFaceInfo> list = this.dataList;
        if (list == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("dataList");
            list = null;
        }
        if (i >= list.size()) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> Test done!");
            changeBtn(false);
            ToastUtils.showLong("压测结束", new Object[0]);
            changeStatus();
            getTvStatus().append("\n压测结束");
            return;
        }
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> startNextTest");
        startTest();
        changeBtn(true);
        changeStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startTest() {
        this.mCurTestTime++;
        this.isSkipFailed = getCbSkipCheckBox().isChecked();
        List<WatchFaceInfo> list = this.dataList;
        if (list == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("dataList");
            list = null;
        }
        WatchFaceInfo watchFaceInfo = list.get(this.mCurTestTime - 1);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " startTest -> isSkipFailed:" + this.isSkipFailed + ", mCurTestTime:" + this.mCurTestTime + ", " + watchFaceInfo);
        syncWatchFace(watchFaceInfo);
    }

    private final void syncWatchFace(WatchFaceInfo watchFaceInfo) {
        com.sma.smartv3.pop.xOOOX xooox;
        List<WatchFaceInfo> list = null;
        if (this.mProgressPop == null) {
            com.sma.smartv3.pop.xOOOX xooox2 = new com.sma.smartv3.pop.xOOOX(this, 0, 2, null);
            xooox2.XIxXXX0x0(0);
            this.mProgressPop = xooox2;
        }
        com.sma.smartv3.pop.xOOOX xooox3 = this.mProgressPop;
        if (xooox3 != null && !xooox3.isShowing() && (xooox = this.mProgressPop) != null) {
            xooox.IIXOooo();
        }
        com.sma.smartv3.pop.xOOOX xooox4 = this.mProgressPop;
        if (xooox4 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mCurTestTime);
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            List<WatchFaceInfo> list2 = this.dataList;
            if (list2 == null) {
                kotlin.jvm.internal.IIX0o.XOxIOxOx("dataList");
            } else {
                list = list2;
            }
            sb.append(list.size());
            sb.append(" - ");
            sb.append(watchFaceInfo.getId());
            xooox4.XxX0x0xxx(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        BleCache bleCache = BleCache.INSTANCE;
        sb2.append(bleCache.getMPrototype());
        sb2.append('_');
        sb2.append(bleCache.getMBleName());
        sb2.append('_');
        sb2.append(watchFaceInfo.getId());
        sb2.append(".bin");
        final String sb3 = sb2.toString();
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        final File file = new File(com.sma.smartv3.initializer.IXxxXO.XI0IXoo(oix0oi), sb3);
        if (file.exists()) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " syncWatchFace -> WatchFace try get from WatchFaceFile file = " + sb3 + " size:" + FileUtils.getSize(file));
            BleConnector.sendStream$default(BleConnector.INSTANCE, BleKey.WATCH_FACE, com.sma.smartv3.initializer.IXxxXO.X0o0xo(oix0oi, sb3), 0, 4, (Object) null);
            return;
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        String binPath = watchFaceInfo.getBinPath();
        String absolutePath = com.sma.smartv3.initializer.IXxxXO.XI0IXoo(oix0oi).getAbsolutePath();
        kotlin.jvm.internal.IIX0o.oO(absolutePath, "getAbsolutePath(...)");
        netWorkUtils.download(binPath, absolutePath, sb3, new HttpProgressCallback<String>() { // from class: com.sma.smartv3.ui.me.DeveloperWatchFaceStressTestActivity$syncWatchFace$2
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                FileUtils.delete(file);
                ToastUtils.showLong(com.sma.smartv3.util.oO.f24511oIX0oI.oIX0oI(1), new Object[0]);
                DeveloperWatchFaceStressTestActivity.this.testFailed("There was a download error：" + error);
            }

            @Override // com.sma.androidnetworklib.method.HttpProgressCallback
            public void handleProgress(int i) {
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(DeveloperWatchFaceStressTestActivity.this.TAG + " syncWatchFace -> WatchFace try get from net");
                BleConnector.sendStream$default(BleConnector.INSTANCE, BleKey.WATCH_FACE, com.sma.smartv3.initializer.IXxxXO.X0o0xo(X00IoxXI.oIX0oI.f3233oIX0oI, sb3), 0, 4, (Object) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void testFailed(String str) {
        com.sma.smartv3.pop.xOOOX xooox = this.mProgressPop;
        if (xooox != null) {
            xooox.dismiss();
        }
        this.mProgressPop = null;
        this.mCurTestFailedTime++;
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.TAG + " testFailed -> reason: " + str);
        ToastUtils.showLong(str, new Object[0]);
        changeStatus();
        if (this.isSkipFailed) {
            oix0oi.oIX0oI(this.TAG + " -> The stress test failed, Skip to the next stress test!");
            new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.me.X0IOOI
                @Override // java.lang.Runnable
                public final void run() {
                    DeveloperWatchFaceStressTestActivity.testFailed$lambda$2(DeveloperWatchFaceStressTestActivity.this);
                }
            }, 3000L);
            return;
        }
        oix0oi.oIX0oI(this.TAG + " -> Interrupt the stress test!");
        changeBtn(false);
        getTvStatus().append("\n压测失败，中断压测");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void testFailed$lambda$2(DeveloperWatchFaceStressTestActivity this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startNextTest();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        List ooXIXxIX2;
        BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
        try {
            JsonArray asJsonArray = JsonParser.parseString(com.sma.smartv3.util.Xo0.f24349oIX0oI.oxoX().getString(com.sma.smartv3.util.XoI0Ixx0.f24488xo0x)).getAsJsonArray();
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), WatchFaceInfo.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        this.dataList = ooXIXxIX2;
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    @OXOo.OOXIXo
    public List<WatchFaceInfo> initList() {
        List<WatchFaceInfo> list = this.dataList;
        if (list == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("dataList");
            list = null;
        }
        return CollectionsKt___CollectionsKt.o0Xo0XII(list);
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        changeBtn(false);
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return android.R.layout.simple_list_item_1;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_developer_watchface_stress_test;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AppCompatButton btStop = getBtStop();
        kotlin.jvm.internal.IIX0o.oO(btStop, "<get-btStop>(...)");
        if (btStop.getVisibility() == 0) {
            ToastUtils.showLong("压测中...", new Object[0]);
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BleConnector bleConnector = BleConnector.INSTANCE;
        bleConnector.removeHandleCallback(this.mBleHandleCallback);
        bleConnector.launch();
    }

    public final void onStartTest(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.DeveloperWatchFaceStressTestActivity$onStartTest$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                DeveloperWatchFaceStressTestActivity.this.mCurTestTime = 0;
                DeveloperWatchFaceStressTestActivity.this.mCurTestSuccessTime = 0;
                DeveloperWatchFaceStressTestActivity.this.mCurTestFailedTime = 0;
                DeveloperWatchFaceStressTestActivity.this.changeBtn(true);
                DeveloperWatchFaceStressTestActivity.this.startTest();
                DeveloperWatchFaceStressTestActivity.this.changeStatus();
            }
        }, 1, null);
    }

    public final void onStopTest(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> Stop test!");
        changeBtn(false);
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo WatchFaceInfo item, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        holder.o00(android.R.id.text1, String.valueOf(item.getId()));
        holder.OxI(android.R.id.text1, getResources().getColor(R.color.line_color));
    }
}
