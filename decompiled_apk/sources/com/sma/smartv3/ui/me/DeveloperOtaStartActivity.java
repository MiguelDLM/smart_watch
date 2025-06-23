package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import com.bestmafen.androidbase.extension.PermissionStatus;
import com.bestmafen.baseble.connector.AbsBleConnector;
import com.bestmafen.baseble.scanner.BleDevice;
import com.bestmafen.baseble.scanner.ScanMode;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.ClipboardUtils;
import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.kuaishou.weapon.p0.g;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.BatchOtaConfig;
import com.sma.smartv3.model.BleFirmwareInfo;
import com.sma.smartv3.model.ExtraPackVersions;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.ui.device.BaseListFunctionActivity;
import com.sma.smartv3.util.UtilsKt;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nDeveloperOtaStartActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperOtaStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaStartActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,415:1\n19#2:416\n15#2:417\n19#2:418\n15#2:419\n19#2:420\n15#2:421\n19#2:422\n15#2:423\n27#2,2:517\n11#2,2:519\n11#2,2:521\n11#2,2:523\n69#3,3:424\n72#3,5:428\n69#3,3:433\n72#3,5:437\n69#3,3:442\n72#3,5:446\n87#3,7:451\n94#3,3:459\n70#3,7:462\n97#3:469\n87#3,7:470\n94#3,3:478\n70#3,7:481\n97#3:488\n87#3,7:489\n94#3,3:497\n70#3,7:500\n97#3:507\n69#3,3:508\n72#3,5:512\n1#4:427\n1#4:436\n1#4:445\n1#4:458\n1#4:477\n1#4:496\n1#4:511\n*S KotlinDebug\n*F\n+ 1 DeveloperOtaStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaStartActivity\n*L\n67#1:416\n67#1:417\n70#1:418\n70#1:419\n73#1:420\n73#1:421\n204#1:422\n204#1:423\n306#1:517,2\n404#1:519,2\n405#1:521,2\n406#1:523,2\n261#1:424,3\n261#1:428,5\n263#1:433,3\n263#1:437,5\n266#1:442,3\n266#1:446,5\n273#1:451,7\n273#1:459,3\n273#1:462,7\n273#1:469\n282#1:470,7\n282#1:478,3\n282#1:481,7\n282#1:488\n288#1:489,7\n288#1:497,3\n288#1:500,7\n288#1:507\n292#1:508,3\n292#1:512,5\n261#1:427\n263#1:436\n266#1:445\n273#1:458\n282#1:477\n288#1:496\n292#1:511\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperOtaStartActivity extends BaseListFunctionActivity<BleDevice> {

    @OXOo.OOXIXo
    private BleFirmwareInfo bleFirmwareInfo;

    @OXOo.OOXIXo
    private ExtraPackVersions extraPackageDatas;

    @OXOo.OOXIXo
    private FirmwareVersion firmwareVersion;
    private boolean isStartOTA;

    @OXOo.OOXIXo
    private final oIX0oI mBleHandleCallback;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mScanner$delegate;
    private int platform;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvVersionInfo$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$tvVersionInfo$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperOtaStartActivity.this.findViewById(R.id.tv_version_info);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO etOldBleName$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$etOldBleName$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) DeveloperOtaStartActivity.this.findViewById(R.id.et_old_ble_name);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btStartOta$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AppCompatButton>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$btStartOta$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AppCompatButton invoke() {
            return (AppCompatButton) DeveloperOtaStartActivity.this.findViewById(R.id.bt_start_ota);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btStopOta$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AppCompatButton>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$btStopOta$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AppCompatButton invoke() {
            return (AppCompatButton) DeveloperOtaStartActivity.this.findViewById(R.id.bt_stop_ota);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO etSignal$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$etSignal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) DeveloperOtaStartActivity.this.findViewById(R.id.et_signal);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvSearchNumber$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$tvSearchNumber$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperOtaStartActivity.this.findViewById(R.id.tv_search_number);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAlreadyOta$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$tvAlreadyOta$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperOtaStartActivity.this.findViewById(R.id.tv_already_ota);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO cbSmaUpdate$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$cbSmaUpdate$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) DeveloperOtaStartActivity.this.findViewById(R.id.cb_sma_update);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO cbSmaDowngrade$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$cbSmaDowngrade$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) DeveloperOtaStartActivity.this.findViewById(R.id.cb_sma_downgrade);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO cbShutdown$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$cbShutdown$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) DeveloperOtaStartActivity.this.findViewById(R.id.cb_shutdown);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO cbOtaFile$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$cbOtaFile$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) DeveloperOtaStartActivity.this.findViewById(R.id.cb_ota_file);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO etBufferSize$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$etBufferSize$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) DeveloperOtaStartActivity.this.findViewById(R.id.et_buffer_size);
        }
    });
    private int mStepsIndex = -1;

    @kotlin.jvm.internal.XX({"SMAP\nDeveloperOtaStartActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperOtaStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaStartActivity$mBleHandleCallback$1\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,415:1\n69#2,3:416\n72#2,5:420\n69#2,3:425\n72#2,5:429\n69#2,3:434\n72#2,5:438\n1#3:419\n1#3:428\n1#3:437\n*S KotlinDebug\n*F\n+ 1 DeveloperOtaStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaStartActivity$mBleHandleCallback$1\n*L\n143#1:416,3\n143#1:420,5\n146#1:425,3\n146#1:429,5\n149#1:434,3\n149#1:438,5\n143#1:419\n146#1:428\n149#1:437\n*E\n"})
    /* loaded from: classes11.dex */
    public static final class oIX0oI implements BleHandleCallback {
        public oIX0oI() {
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
            BleHandleCallback.DefaultImpls.onCommandSendTimeout(this, bleKey, bleKeyFlag);
        }

        @Override // com.szabh.smable3.component.BleHandleCallback
        public void onDeviceConnected(@OXOo.OOXIXo BluetoothDevice device) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
            DeveloperOtaStartActivity.this.getBtStopOta().setVisibility(0);
            int platform = DeveloperOtaStartActivity.this.getPlatform();
            if (platform != 1) {
                if (platform != 2) {
                    if (platform == 4) {
                        DeveloperOtaStartActivity developerOtaStartActivity = DeveloperOtaStartActivity.this;
                        developerOtaStartActivity.startActivity(new Intent(developerOtaStartActivity, (Class<?>) DeveloperUpgradeGQActivity.class));
                        return;
                    }
                    return;
                }
                DeveloperOtaStartActivity developerOtaStartActivity2 = DeveloperOtaStartActivity.this;
                developerOtaStartActivity2.startActivity(new Intent(developerOtaStartActivity2, (Class<?>) DeveloperUpgradeGActivity.class));
                return;
            }
            DeveloperOtaStartActivity developerOtaStartActivity3 = DeveloperOtaStartActivity.this;
            developerOtaStartActivity3.startActivity(new Intent(developerOtaStartActivity3, (Class<?>) DeveloperUpgradeNActivity.class));
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
            BleHandleCallback.DefaultImpls.onSessionStateChange(this, z);
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
            BleHandleCallback.DefaultImpls.onStreamProgress(this, z, i, i2, i3, bleKey);
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

    public DeveloperOtaStartActivity() {
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        this.platform = xo0.II0xO0().getInt(com.sma.smartv3.util.XoI0Ixx0.f24458oo0xXOI0I);
        SPUtils II0xO02 = xo0.II0xO0();
        Object bleFirmwareInfo = new BleFirmwareInfo(0, 0, null, null, null, 31, null);
        Object fromJson = new Gson().fromJson(II0xO02.getString(BleFirmwareInfo.class.getName()), (Class<Object>) BleFirmwareInfo.class);
        this.bleFirmwareInfo = (BleFirmwareInfo) (fromJson != null ? fromJson : bleFirmwareInfo);
        SPUtils II0xO03 = xo0.II0xO0();
        Object firmwareVersion = new FirmwareVersion(null, 0, null, null, null, 0, null, null, null, 511, null);
        Object fromJson2 = new Gson().fromJson(II0xO03.getString(FirmwareVersion.class.getName()), (Class<Object>) FirmwareVersion.class);
        this.firmwareVersion = (FirmwareVersion) (fromJson2 != null ? fromJson2 : firmwareVersion);
        SPUtils II0xO04 = xo0.II0xO0();
        Object extraPackVersions = new ExtraPackVersions(null, null, null, null, null, null, 63, null);
        Object fromJson3 = new Gson().fromJson(II0xO04.getString(ExtraPackVersions.class.getName()), (Class<Object>) ExtraPackVersions.class);
        this.extraPackageDatas = (ExtraPackVersions) (fromJson3 != null ? fromJson3 : extraPackVersions);
        this.mScanner$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<XOxIOxOx.II0xO0>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$mScanner$2

            @kotlin.jvm.internal.XX({"SMAP\nDeveloperOtaStartActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperOtaStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaStartActivity$mScanner$2$2\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,415:1\n19#2:416\n15#2:417\n1002#3,2:418\n*S KotlinDebug\n*F\n+ 1 DeveloperOtaStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaStartActivity$mScanner$2$2\n*L\n124#1:416\n124#1:417\n130#1:418,2\n*E\n"})
            /* loaded from: classes11.dex */
            public static final class II0xO0 implements XOxIOxOx.oxoX {

                /* renamed from: oIX0oI, reason: collision with root package name */
                public final /* synthetic */ DeveloperOtaStartActivity f23211oIX0oI;

                @kotlin.jvm.internal.XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 DeveloperOtaStartActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaStartActivity$mScanner$2$2\n*L\n1#1,328:1\n130#2:329\n*E\n"})
                /* loaded from: classes11.dex */
                public static final class oIX0oI<T> implements Comparator {
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return xX0ox.Oxx0IOOO.oOoXoXO(Integer.valueOf(-((BleDevice) t).getMRssi()), Integer.valueOf(-((BleDevice) t2).getMRssi()));
                    }
                }

                public II0xO0(DeveloperOtaStartActivity developerOtaStartActivity) {
                    this.f23211oIX0oI = developerOtaStartActivity;
                }

                public static final void X0o0xo(DeveloperOtaStartActivity this$0) {
                    EditText etOldBleName;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                    etOldBleName = this$0.getEtOldBleName();
                    kotlin.jvm.internal.IIX0o.oO(etOldBleName, "access$getEtOldBleName(...)");
                    this$0.startSearch(etOldBleName);
                }

                @Override // XOxIOxOx.oxoX
                public void I0Io() {
                }

                @Override // XOxIOxOx.oxoX
                public void II0xO0(@OXOo.OOXIXo BleDevice device) {
                    List mList;
                    List mList2;
                    List mList3;
                    TextView tvSearchNumber;
                    List mList4;
                    XIOOI.oIX0oI mListAdapter;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
                    mList = this.f23211oIX0oI.getMList();
                    if (mList.contains(device)) {
                        return;
                    }
                    SPUtils II0xO02 = com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0();
                    Object ooooo0oxi = new ooOOo0oXI(null, 1, null);
                    Object fromJson = new Gson().fromJson(II0xO02.getString(ooOOo0oXI.class.getName()), (Class<Object>) ooOOo0oXI.class);
                    if (fromJson != null) {
                        ooooo0oxi = fromJson;
                    }
                    if (!((ooOOo0oXI) ooooo0oxi).oxoX().contains(device.getMBluetoothDevice().getAddress())) {
                        mList2 = this.f23211oIX0oI.getMList();
                        mList2.add(device);
                        mList3 = this.f23211oIX0oI.getMList();
                        if (mList3.size() > 1) {
                            kotlin.collections.o00.OO0x0xX(mList3, new oIX0oI());
                        }
                        tvSearchNumber = this.f23211oIX0oI.getTvSearchNumber();
                        DeveloperOtaStartActivity developerOtaStartActivity = this.f23211oIX0oI;
                        mList4 = developerOtaStartActivity.getMList();
                        tvSearchNumber.setText(developerOtaStartActivity.getString(R.string.device_found, Integer.valueOf(mList4.size())));
                        mListAdapter = this.f23211oIX0oI.getMListAdapter();
                        mListAdapter.notifyDataSetChanged();
                    }
                }

                @Override // XOxIOxOx.oxoX
                public void oIX0oI(boolean z) {
                    AppCompatButton btStartOta;
                    AppCompatButton btStartOta2;
                    List mList;
                    EditText etOldBleName;
                    AppCompatButton btStartOta3;
                    if (z) {
                        btStartOta3 = this.f23211oIX0oI.getBtStartOta();
                        btStartOta3.setVisibility(8);
                        return;
                    }
                    if (com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24449oX, false)) {
                        btStartOta2 = this.f23211oIX0oI.getBtStartOta();
                        btStartOta2.setVisibility(8);
                        mList = this.f23211oIX0oI.getMList();
                        if (mList.isEmpty()) {
                            ToastUtils.showLong("没有搜到设备，正在重试...", new Object[0]);
                            Handler handler = new Handler();
                            final DeveloperOtaStartActivity developerOtaStartActivity = this.f23211oIX0oI;
                            handler.postDelayed(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0047: INVOKE 
                                  (r5v13 'handler' android.os.Handler)
                                  (wrap:java.lang.Runnable:0x0042: CONSTRUCTOR (r0v3 'developerOtaStartActivity' com.sma.smartv3.ui.me.DeveloperOtaStartActivity A[DONT_INLINE]) A[MD:(com.sma.smartv3.ui.me.DeveloperOtaStartActivity):void (m), WRAPPED] (LINE:67) call: com.sma.smartv3.ui.me.ooOx.<init>(com.sma.smartv3.ui.me.DeveloperOtaStartActivity):void type: CONSTRUCTOR)
                                  (wrap:long:SGET  A[WRAPPED] com.google.android.exoplayer2.ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS long)
                                 VIRTUAL call: android.os.Handler.postDelayed(java.lang.Runnable, long):boolean A[MD:(java.lang.Runnable, long):boolean (c)] (LINE:72) in method: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$mScanner$2.II0xO0.oIX0oI(boolean):void, file: classes11.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
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
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.me.ooOx, state: NOT_LOADED
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
                                	... 35 more
                                */
                            /*
                                this = this;
                                r0 = 8
                                if (r5 == 0) goto Le
                                com.sma.smartv3.ui.me.DeveloperOtaStartActivity r5 = r4.f23211oIX0oI
                                androidx.appcompat.widget.AppCompatButton r5 = com.sma.smartv3.ui.me.DeveloperOtaStartActivity.access$getBtStartOta(r5)
                                r5.setVisibility(r0)
                                goto L63
                            Le:
                                com.sma.smartv3.util.Xo0 r5 = com.sma.smartv3.util.Xo0.f24349oIX0oI
                                com.blankj.utilcode.util.SPUtils r5 = r5.II0xO0()
                                java.lang.String r1 = "DEVELOPER_AUTO_UPDATE"
                                r2 = 0
                                boolean r5 = r5.getBoolean(r1, r2)
                                if (r5 == 0) goto L5a
                                com.sma.smartv3.ui.me.DeveloperOtaStartActivity r5 = r4.f23211oIX0oI
                                androidx.appcompat.widget.AppCompatButton r5 = com.sma.smartv3.ui.me.DeveloperOtaStartActivity.access$getBtStartOta(r5)
                                r5.setVisibility(r0)
                                com.sma.smartv3.ui.me.DeveloperOtaStartActivity r5 = r4.f23211oIX0oI
                                java.util.List r5 = com.sma.smartv3.ui.me.DeveloperOtaStartActivity.access$getMList(r5)
                                boolean r5 = r5.isEmpty()
                                if (r5 == 0) goto L4b
                                java.lang.String r5 = "没有搜到设备，正在重试..."
                                java.lang.Object[] r0 = new java.lang.Object[r2]
                                com.blankj.utilcode.util.ToastUtils.showLong(r5, r0)
                                android.os.Handler r5 = new android.os.Handler
                                r5.<init>()
                                com.sma.smartv3.ui.me.DeveloperOtaStartActivity r0 = r4.f23211oIX0oI
                                com.sma.smartv3.ui.me.ooOx r1 = new com.sma.smartv3.ui.me.ooOx
                                r1.<init>(r0)
                                r2 = 2000(0x7d0, double:9.88E-321)
                                r5.postDelayed(r1, r2)
                                goto L63
                            L4b:
                                com.sma.smartv3.ui.me.DeveloperOtaStartActivity r5 = r4.f23211oIX0oI
                                android.widget.EditText r0 = com.sma.smartv3.ui.me.DeveloperOtaStartActivity.access$getEtOldBleName(r5)
                                java.lang.String r1 = "access$getEtOldBleName(...)"
                                kotlin.jvm.internal.IIX0o.oO(r0, r1)
                                r5.startOta(r0)
                                goto L63
                            L5a:
                                com.sma.smartv3.ui.me.DeveloperOtaStartActivity r5 = r4.f23211oIX0oI
                                androidx.appcompat.widget.AppCompatButton r5 = com.sma.smartv3.ui.me.DeveloperOtaStartActivity.access$getBtStartOta(r5)
                                r5.setVisibility(r2)
                            L63:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$mScanner$2.II0xO0.oIX0oI(boolean):void");
                        }
                    }

                    /* loaded from: classes11.dex */
                    public static final class oIX0oI implements XOxIOxOx.X0o0xo {

                        /* renamed from: oIX0oI, reason: collision with root package name */
                        public final /* synthetic */ DeveloperOtaStartActivity f23212oIX0oI;

                        public oIX0oI(DeveloperOtaStartActivity developerOtaStartActivity) {
                            this.f23212oIX0oI = developerOtaStartActivity;
                        }

                        @Override // XOxIOxOx.X0o0xo
                        public boolean oIX0oI(@OXOo.OOXIXo BleDevice device) {
                            boolean isOTA;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(device, "device");
                            com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                            String string = xo0.II0xO0().getString(com.sma.smartv3.util.XoI0Ixx0.f24429XoI0Ixx0, "");
                            kotlin.jvm.internal.IIX0o.oO(string, "getString(...)");
                            if (string.length() == 0) {
                                if (device.getMRssi() <= xo0.II0xO0().getInt(com.sma.smartv3.util.XoI0Ixx0.f24428Xo0, -60)) {
                                    return false;
                                }
                            } else {
                                if (device.getMRssi() <= xo0.II0xO0().getInt(com.sma.smartv3.util.XoI0Ixx0.f24428Xo0, -60)) {
                                    return false;
                                }
                                if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(ProductManager.f20544oIX0oI.x0xO0oo(device.getMName()), xo0.II0xO0().getString(com.sma.smartv3.util.XoI0Ixx0.f24429XoI0Ixx0, ""))) {
                                    isOTA = this.f23212oIX0oI.isOTA(device.getMName());
                                    if (!isOTA) {
                                        return false;
                                    }
                                }
                            }
                            return true;
                        }
                    }

                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oIX0oI
                    @OXOo.OOXIXo
                    public final XOxIOxOx.II0xO0 invoke() {
                        return XOxIOxOx.oO.II0xO0(XOxIOxOx.oO.f3971oIX0oI, null, ScanMode.LOW_LATENCY, 1, null).Oo(8).IXxxXO(new oIX0oI(DeveloperOtaStartActivity.this)).ooOOo0oXI(new II0xO0(DeveloperOtaStartActivity.this));
                    }
                });
                this.mBleHandleCallback = new oIX0oI();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final AppCompatButton getBtStartOta() {
                return (AppCompatButton) this.btStartOta$delegate.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final AppCompatButton getBtStopOta() {
                return (AppCompatButton) this.btStopOta$delegate.getValue();
            }

            private final CheckBox getCbOtaFile() {
                return (CheckBox) this.cbOtaFile$delegate.getValue();
            }

            private final CheckBox getCbShutdown() {
                return (CheckBox) this.cbShutdown$delegate.getValue();
            }

            private final CheckBox getCbSmaDowngrade() {
                return (CheckBox) this.cbSmaDowngrade$delegate.getValue();
            }

            private final CheckBox getCbSmaUpdate() {
                return (CheckBox) this.cbSmaUpdate$delegate.getValue();
            }

            private final EditText getEtBufferSize() {
                return (EditText) this.etBufferSize$delegate.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final EditText getEtOldBleName() {
                return (EditText) this.etOldBleName$delegate.getValue();
            }

            private final EditText getEtSignal() {
                return (EditText) this.etSignal$delegate.getValue();
            }

            private final XOxIOxOx.II0xO0 getMScanner() {
                return (XOxIOxOx.II0xO0) this.mScanner$delegate.getValue();
            }

            private final TextView getTvAlreadyOta() {
                return (TextView) this.tvAlreadyOta$delegate.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final TextView getTvSearchNumber() {
                return (TextView) this.tvSearchNumber$delegate.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final TextView getTvVersionInfo() {
                return (TextView) this.tvVersionInfo$delegate.getValue();
            }

            private final void initOtaConfig() {
                Serializable serializableExtra = getIntent().getSerializableExtra("otaConfig");
                if (serializableExtra != null) {
                    BatchOtaConfig batchOtaConfig = (BatchOtaConfig) serializableExtra;
                    OI0.oIX0oI.f1507oIX0oI.oIX0oI("initOtaConfig -> " + serializableExtra);
                    this.platform = batchOtaConfig.getPlatform();
                    this.bleFirmwareInfo = batchOtaConfig.getBleFirmwareInfo();
                    this.firmwareVersion = batchOtaConfig.getFirmwareVersion();
                    this.extraPackageDatas = batchOtaConfig.getExtraPackageDatas();
                    if (!TextUtils.isEmpty(batchOtaConfig.getBleName())) {
                        getEtOldBleName().setText(batchOtaConfig.getBleName());
                    }
                    com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                    xo0.II0xO0().put(Integer.class.getName(), new Gson().toJson(Integer.valueOf(this.platform)));
                    xo0.II0xO0().put(FirmwareVersion.class.getName(), new Gson().toJson(this.firmwareVersion));
                    xo0.II0xO0().put(ExtraPackVersions.class.getName(), new Gson().toJson(this.extraPackageDatas));
                    getCbOtaFile().setChecked(batchOtaConfig.isLocalOta());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void initView$lambda$0(DeveloperOtaStartActivity this$0, AdapterView adapterView, View view, int i, long j) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                this$0.getEtOldBleName().setText(ProductManager.f20544oIX0oI.x0xO0oo(this$0.getMList().get(i).getMName()));
                EditText etOldBleName = this$0.getEtOldBleName();
                kotlin.jvm.internal.IIX0o.oO(etOldBleName, "<get-etOldBleName>(...)");
                this$0.startSearch(etOldBleName);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final boolean isOTA(String str) {
                return kotlin.jvm.internal.IIX0o.Oxx0IOOO(str, "OTA_" + com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getString(com.sma.smartv3.util.XoI0Ixx0.f24429XoI0Ixx0, ""));
            }

            @RequiresApi(29)
            private final void permissionBackgroundLocationRemind() {
                if (getMPermissionBackgroundPopup() == null) {
                    com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
                    xoI0Ixx0.IoOoX(R.string.background_set_remind);
                    com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
                    xoI0Ixx0.x0o(R.string.settings, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$permissionBackgroundLocationRemind$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // Oox.oIX0oI
                        @OXOo.OOXIXo
                        public final Boolean invoke() {
                            Activity mContext;
                            mContext = DeveloperOtaStartActivity.this.getMContext();
                            mContext.requestPermissions(new String[]{g.g, "android.permission.ACCESS_BACKGROUND_LOCATION"}, 3);
                            return Boolean.TRUE;
                        }
                    });
                    setMPermissionBackgroundPopup(xoI0Ixx0);
                }
                com.sma.smartv3.pop.XoI0Ixx0 mPermissionBackgroundPopup = getMPermissionBackgroundPopup();
                if (mPermissionBackgroundPopup != null) {
                    View rootView = getRootView();
                    kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                    mPermissionBackgroundPopup.OxxIIOOXO(rootView);
                }
            }

            private final void requestEnableBluetooth() {
                oOXoIIIo.oIX0oI.IXxxXO(this, "android.bluetooth.adapter.action.REQUEST_ENABLE", 1, 0, 4, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void requestLocationPermission() {
                if (Build.VERSION.SDK_INT >= 29) {
                    permissionBackgroundLocationRemind();
                    return;
                }
                PermissionUtils permission = PermissionUtils.permission(PermissionConstants.LOCATION);
                kotlin.jvm.internal.IIX0o.oO(permission, "permission(...)");
                oOXoIIIo.X0o0xo.I0Io(permission, null, null, new Oox.oOoXoXO<PermissionStatus, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaStartActivity$requestLocationPermission$1

                    /* loaded from: classes11.dex */
                    public /* synthetic */ class oIX0oI {

                        /* renamed from: oIX0oI, reason: collision with root package name */
                        public static final /* synthetic */ int[] f23214oIX0oI;

                        static {
                            int[] iArr = new int[PermissionStatus.values().length];
                            try {
                                iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[PermissionStatus.DENIED.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            f23214oIX0oI = iArr;
                        }
                    }

                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(PermissionStatus permissionStatus) {
                        invoke2(permissionStatus);
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OXOo.OOXIXo PermissionStatus it) {
                        TextView tvVersionInfo;
                        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                        int i = oIX0oI.f23214oIX0oI[it.ordinal()];
                        if (i != 1) {
                            if (i == 2) {
                                DeveloperOtaStartActivity.this.requestLocationPermission();
                                return;
                            } else {
                                DeveloperOtaStartActivity.this.permissionRemind();
                                return;
                            }
                        }
                        DeveloperOtaStartActivity developerOtaStartActivity = DeveloperOtaStartActivity.this;
                        tvVersionInfo = developerOtaStartActivity.getTvVersionInfo();
                        kotlin.jvm.internal.IIX0o.oO(tvVersionInfo, "access$getTvVersionInfo(...)");
                        developerOtaStartActivity.startSearch(tvVersionInfo);
                    }
                }, 3, null);
            }

            public final void clearOtaHistory(@OXOo.OOXIXo View view) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
                com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().remove(ooOOo0oXI.class.getName());
                getTvAlreadyOta().setText("0");
                EditText etOldBleName = getEtOldBleName();
                kotlin.jvm.internal.IIX0o.oO(etOldBleName, "<get-etOldBleName>(...)");
                startSearch(etOldBleName);
            }

            @OXOo.OOXIXo
            public final BleFirmwareInfo getBleFirmwareInfo() {
                return this.bleFirmwareInfo;
            }

            @OXOo.OOXIXo
            public final ExtraPackVersions getExtraPackageDatas() {
                return this.extraPackageDatas;
            }

            @OXOo.OOXIXo
            public final FirmwareVersion getFirmwareVersion() {
                return this.firmwareVersion;
            }

            public final int getPlatform() {
                return this.platform;
            }

            @Override // com.bestmafen.androidbase.base.oIX0oI
            public void init(@OXOo.oOoXoXO Bundle bundle) {
                BleConnector.INSTANCE.addHandleCallback(this.mBleHandleCallback);
            }

            @Override // com.bestmafen.androidbase.list.II0xO0
            @OXOo.OOXIXo
            public List<BleDevice> initList() {
                return new ArrayList();
            }

            @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
            public void initView() {
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                int i;
                super.initView();
                this.mStepsIndex = -1;
                initOtaConfig();
                OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                oix0oi.oIX0oI("bleFirmwareInfo -> " + this.bleFirmwareInfo);
                oix0oi.oIX0oI("FirmwareVersion -> " + this.firmwareVersion);
                oix0oi.oIX0oI("ExtraPackVersion -> " + this.extraPackageDatas);
                int i2 = 8;
                getBtStartOta().setVisibility(8);
                getBtStopOta().setVisibility(8);
                boolean z = true;
                getCbShutdown().setChecked(true);
                FirmwareVersion uiPackVersion = this.extraPackageDatas.getUiPackVersion();
                FirmwareVersion languagePackVersion = this.extraPackageDatas.getLanguagePackVersion();
                FirmwareVersion brandPackVersion = this.extraPackageDatas.getBrandPackVersion();
                FirmwareVersion fontPackVersion = this.extraPackageDatas.getFontPackVersion();
                TextView tvVersionInfo = getTvVersionInfo();
                StringBuilder sb = new StringBuilder();
                sb.append(" BleName = ");
                sb.append(this.bleFirmwareInfo.getBleName());
                sb.append(" , firmwareFlag = ");
                sb.append(this.bleFirmwareInfo.getFlag());
                sb.append(" ,  remark = ");
                sb.append(this.bleFirmwareInfo.getRemark());
                sb.append("  , firmwareInfo = ");
                sb.append(this.firmwareVersion.getInfo());
                sb.append(" ,  firmwareVersion = ");
                sb.append(this.firmwareVersion.getVersion());
                sb.append("  , UiPackageInfo = ");
                String str8 = null;
                if (uiPackVersion != null) {
                    str = uiPackVersion.getInfo();
                } else {
                    str = null;
                }
                sb.append(str);
                sb.append("  , UiPackageVersion = ");
                if (uiPackVersion != null) {
                    str2 = uiPackVersion.getVersion();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(" , LanguagePackageInfo =  ");
                if (languagePackVersion != null) {
                    str3 = languagePackVersion.getInfo();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append("  , LanguagePackageVersion = ");
                if (languagePackVersion != null) {
                    str4 = languagePackVersion.getVersion();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                sb.append(" , BrandPackVersion =  ");
                if (brandPackVersion != null) {
                    str5 = brandPackVersion.getInfo();
                } else {
                    str5 = null;
                }
                sb.append(str5);
                sb.append("  , BrandPackageVersion = ");
                if (brandPackVersion != null) {
                    str6 = brandPackVersion.getVersion();
                } else {
                    str6 = null;
                }
                sb.append(str6);
                sb.append(" , FontPackVersion =  ");
                if (fontPackVersion != null) {
                    str7 = fontPackVersion.getInfo();
                } else {
                    str7 = null;
                }
                sb.append(str7);
                sb.append("  , FontPackageVersion = ");
                if (fontPackVersion != null) {
                    str8 = fontPackVersion.getVersion();
                }
                sb.append(str8);
                tvVersionInfo.setText(sb.toString());
                getTvVersionInfo().setMovementMethod(new ScrollingMovementMethod());
                getMListView().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sma.smartv3.ui.me.I0
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view, int i3, long j) {
                        DeveloperOtaStartActivity.initView$lambda$0(DeveloperOtaStartActivity.this, adapterView, view, i3, j);
                    }
                });
                CheckBox cbShutdown = getCbShutdown();
                if (brandPackVersion != null) {
                    z = false;
                }
                cbShutdown.setChecked(z);
                CheckBox cbSmaUpdate = getCbSmaUpdate();
                if (this.platform == 0) {
                    i = 0;
                } else {
                    i = 8;
                }
                cbSmaUpdate.setVisibility(i);
                CheckBox cbSmaDowngrade = getCbSmaDowngrade();
                if (this.platform == 0) {
                    i2 = 0;
                }
                cbSmaDowngrade.setVisibility(i2);
            }

            @Override // com.bestmafen.androidbase.list.II0xO0
            public int itemLayoutId() {
                return R.layout.item_device;
            }

            @Override // com.bestmafen.androidbase.base.oIX0oI
            public int layoutId() {
                return R.layout.activity_developer_test_ota_start;
            }

            @Override // com.bestmafen.androidbase.base.BaseActivity, android.app.Activity, android.view.Window.Callback
            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                EditText etOldBleName = getEtOldBleName();
                kotlin.jvm.internal.IIX0o.oO(etOldBleName, "<get-etOldBleName>(...)");
                startSearch(etOldBleName);
            }

            public final void onCopy(@OXOo.OOXIXo View view) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
                String json = new Gson().toJson(new BatchOtaConfig(this.platform, this.bleFirmwareInfo, this.firmwareVersion, this.extraPackageDatas, getEtOldBleName().getText().toString(), getCbOtaFile().isChecked()));
                kotlin.jvm.internal.IIX0o.oO(json, "toJson(...)");
                byte[] bytes = json.getBytes(kotlin.text.oxoX.f29581II0xO0);
                kotlin.jvm.internal.IIX0o.oO(bytes, "getBytes(...)");
                String base64Encode2String = EncodeUtils.base64Encode2String(bytes);
                ClipboardUtils.copyText(base64Encode2String);
                ToastUtils.showLong(R.string.copied);
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("onCopyConfig -> " + base64Encode2String);
            }

            @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
            public void onDestroy() {
                BleConnector bleConnector = BleConnector.INSTANCE;
                bleConnector.setOtaMode(false);
                bleConnector.removeHandleCallback(this.mBleHandleCallback);
                super.onDestroy();
                getMScanner().II0xO0();
            }

            @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
            public void onResume() {
                super.onResume();
                TextView tvAlreadyOta = getTvAlreadyOta();
                SPUtils II0xO02 = com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0();
                Object ooooo0oxi = new ooOOo0oXI(null, 1, null);
                Object fromJson = new Gson().fromJson(II0xO02.getString(ooOOo0oXI.class.getName()), (Class<Object>) ooOOo0oXI.class);
                if (fromJson != null) {
                    ooooo0oxi = fromJson;
                }
                tvAlreadyOta.setText(String.valueOf(((ooOOo0oXI) ooooo0oxi).oxoX().size()));
                if (this.isStartOTA) {
                    ToastUtils.showLong(R.string.auto_next_upgrade);
                    this.isStartOTA = false;
                    EditText etOldBleName = getEtOldBleName();
                    kotlin.jvm.internal.IIX0o.oO(etOldBleName, "<get-etOldBleName>(...)");
                    startSearch(etOldBleName);
                }
            }

            public final void setBleFirmwareInfo(@OXOo.OOXIXo BleFirmwareInfo bleFirmwareInfo) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(bleFirmwareInfo, "<set-?>");
                this.bleFirmwareInfo = bleFirmwareInfo;
            }

            public final void setExtraPackageDatas(@OXOo.OOXIXo ExtraPackVersions extraPackVersions) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(extraPackVersions, "<set-?>");
                this.extraPackageDatas = extraPackVersions;
            }

            public final void setFirmwareVersion(@OXOo.OOXIXo FirmwareVersion firmwareVersion) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(firmwareVersion, "<set-?>");
                this.firmwareVersion = firmwareVersion;
            }

            public final void setPlatform(int i) {
                this.platform = i;
            }

            public final void startOta(@OXOo.OOXIXo View view) {
                long j;
                String obj;
                kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
                if (getMList().isEmpty()) {
                    ToastUtils.showLong(R.string.no_device_not_upgrade);
                    return;
                }
                com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                xo0.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24449oX, true);
                xo0.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24382O0Xx, getCbShutdown().isChecked());
                xo0.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24354I0oOIX, getCbOtaFile().isChecked());
                SPUtils II0xO02 = xo0.II0xO0();
                Editable text = getEtBufferSize().getText();
                if (text != null && (obj = text.toString()) != null) {
                    j = Long.parseLong(obj);
                } else {
                    j = 1018;
                }
                II0xO02.put(com.sma.smartv3.util.XoI0Ixx0.f24493xoxXI, j);
                this.isStartOTA = true;
                xo0.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24456oo, getMList().get(0).getMBluetoothDevice().getAddress());
                int i = this.platform;
                if (i != 0) {
                    if (i != 1 && i != 2 && i != 4) {
                        if (i != 5) {
                            if (i != 6) {
                                if (i == 7) {
                                    getBtStopOta().setVisibility(0);
                                    startActivity(new Intent(this, (Class<?>) DeveloperUpgradeZActivity.class));
                                    return;
                                }
                                return;
                            }
                            getBtStopOta().setVisibility(0);
                            this.mStepsIndex++;
                            BleConnector.INSTANCE.setOtaMode(false);
                            int i2 = this.mStepsIndex;
                            Bundle bundle = new Bundle();
                            bundle.putString("mArg0", null);
                            bundle.putInt("mArg1", i2);
                            bundle.putParcelable("mArg2", null);
                            bundle.putSerializable("mArg3", null);
                            Intent intent = new Intent(this, (Class<?>) DeveloperUpgradeSActivity.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                            return;
                        }
                        BleConnector.INSTANCE.setOtaMode(false);
                        getBtStopOta().setVisibility(0);
                        OI0.oIX0oI.f1507oIX0oI.oIX0oI("start -> " + getMList().get(0).getMName() + ", " + xo0.II0xO0().getString(com.sma.smartv3.util.XoI0Ixx0.f24429XoI0Ixx0, "") + ", " + isOTA(getMList().get(0).getMName()));
                        boolean isOTA = isOTA(getMList().get(0).getMName());
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("mArg0", null);
                        bundle2.putInt("mArg1", isOTA ? 1 : 0);
                        bundle2.putParcelable("mArg2", null);
                        bundle2.putSerializable("mArg3", null);
                        Intent intent2 = new Intent(this, (Class<?>) DeveloperUpgradeJSmaActivity.class);
                        intent2.putExtras(bundle2);
                        startActivity(intent2);
                        return;
                    }
                    BleConnector bleConnector = BleConnector.INSTANCE;
                    bleConnector.setOtaMode(true);
                    ToastUtils.showLong(R.string.wait_device_connect_remind);
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(getMList().get(0).getMName(), "Goodix_Fast_DFU")) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("mArg0", "Goodix_Fast_DFU");
                        bundle3.putParcelable("mArg2", null);
                        bundle3.putSerializable("mArg3", null);
                        Intent intent3 = new Intent(this, (Class<?>) DeveloperUpgradeGQActivity.class);
                        intent3.putExtras(bundle3);
                        startActivity(intent3);
                        return;
                    }
                    AbsBleConnector.setBleDevice$default(bleConnector, getMList().get(0), 0, 2, null).connect(true);
                    return;
                }
                BleConnector.INSTANCE.setOtaMode(false);
                getBtStopOta().setVisibility(0);
                ProductManager productManager = ProductManager.f20544oIX0oI;
                if (!productManager.Oxx().contains(productManager.x0xO0oo(getMList().get(0).getMName())) && !getCbSmaUpdate().isChecked()) {
                    startActivity(new Intent(this, (Class<?>) DeveloperUpgradeRActivity.class));
                } else if (getCbSmaDowngrade().isChecked()) {
                    startActivity(new Intent(this, (Class<?>) DeveloperUpgradeRActivity.class));
                } else {
                    startActivity(new Intent(this, (Class<?>) DeveloperUpgradeRSmaActivity.class));
                }
            }

            public final void startSearch(@OXOo.OOXIXo View view) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
                if (!PermissionUtils.isGranted(g.g)) {
                    requestLocationPermission();
                    return;
                }
                if (!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
                    requestEnableBluetooth();
                    return;
                }
                if (!UtilsKt.oo()) {
                    locationServerRemind();
                    return;
                }
                ToastUtils.showLong(R.string.search_device_remind);
                if (getEtSignal().getText().toString().length() == 0) {
                    getEtSignal().setText("60");
                }
                com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                xo0.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24428Xo0, -Integer.parseInt(getEtSignal().getText().toString()));
                xo0.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24429XoI0Ixx0, getEtOldBleName().getText().toString());
                getMList().clear();
                getMListAdapter().notifyDataSetChanged();
                getTvSearchNumber().setText(getString(R.string.device_found, Integer.valueOf(getMList().size())));
                getMScanner().oOoXoXO(true);
            }

            public final void stopOta(@OXOo.OOXIXo View view) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
                ToastUtils.showLong(R.string.close_auto_upgrade_tip);
                com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(com.sma.smartv3.util.XoI0Ixx0.f24449oX, false);
                getBtStopOta().setVisibility(8);
            }

            @Override // com.bestmafen.androidbase.list.I0Io
            public void initItem(@OXOo.OOXIXo XIOOI.I0Io holder, @OXOo.OOXIXo BleDevice item, int i) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
                kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
                holder.o00(R.id.tv_name, item.getMName());
                holder.o00(R.id.tv_address, item.getMBluetoothDevice().getAddress());
                ((ImageView) holder.X0o0xo(R.id.iv_rssi)).setImageLevel(-item.getMRssi());
            }
        }
